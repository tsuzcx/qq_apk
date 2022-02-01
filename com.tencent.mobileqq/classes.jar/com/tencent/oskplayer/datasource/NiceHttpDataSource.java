package com.tencent.oskplayer.datasource;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.UuidPlayIdMap;
import com.tencent.oskplayer.proxy.VideoRequest;
import com.tencent.oskplayer.util.Fixer;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.Predicate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NiceHttpDataSource
  extends DefaultHttpDataSource
{
  private static boolean configLoaded = false;
  private static int sMaxRetryCount = 3;
  private HttpRetryLogic httpRetryLogic;
  private VideoRequest mVideoRequest;
  private int readRetryCount = 0;
  private String uuid;
  
  public NiceHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener paramTransferListener, HttpRetryLogic paramHttpRetryLogic, Fixer<Map<String, List<String>>> paramFixer, VideoRequest paramVideoRequest)
  {
    super(paramString, paramPredicate, paramTransferListener, 30000, 12000, true, paramFixer);
    this.httpRetryLogic = paramHttpRetryLogic;
    this.mVideoRequest = paramVideoRequest;
    this.TAG = "NiceHttpDataSource";
    if (!configLoaded)
    {
      sMaxRetryCount = PlayerConfig.g().getDataSourceMaxRetryCount();
      configLoaded = true;
    }
    paramString = PlayerConfig.g().getGlobalExtraHeader();
    if (paramString != null)
    {
      paramString = paramString.getSnapshot().entrySet().iterator();
      while (paramString.hasNext())
      {
        paramPredicate = (Map.Entry)paramString.next();
        setRequestProperty((String)paramPredicate.getKey(), (String)paramPredicate.getValue());
      }
    }
    paramString = paramVideoRequest.getExtraHeader();
    if (paramString != null)
    {
      paramString = paramString.getSnapshot().entrySet().iterator();
      while (paramString.hasNext())
      {
        paramPredicate = (Map.Entry)paramString.next();
        setRequestProperty((String)paramPredicate.getKey(), (String)paramPredicate.getValue());
      }
    }
  }
  
  private int readRetry(byte[] paramArrayOfByte, int paramInt1, int paramInt2, HttpDataSource.HttpDataSourceException paramHttpDataSourceException)
  {
    Object localObject;
    long l1;
    long l2;
    if (!UuidPlayIdMap.isUuidDeleted(getDataSpec().uuid))
    {
      localObject = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("read source error occurred ");
      localStringBuilder.append(paramHttpDataSourceException.toString());
      PlayerUtils.log(4, (String)localObject, localStringBuilder.toString());
      this.readRetryCount += 1;
      l1 = getDataSpec().position + bytesRead();
      int i = this.readRetryCount * 2000;
      localObject = getLogTag();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("retrying after ");
      localStringBuilder.append(i);
      localStringBuilder.append(" seconds, read start at offset ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" retry ");
      localStringBuilder.append(this.readRetryCount);
      localStringBuilder.append("/");
      localStringBuilder.append(sMaxRetryCount);
      PlayerUtils.log(4, (String)localObject, localStringBuilder.toString());
      l2 = i;
    }
    try
    {
      Thread.sleep(l2);
      localObject = new DataSpec(Uri.parse(getUri()), 0L, l1, -1L, null, 0, this.uuid, getDataSpec().priority);
      if ((!Thread.currentThread().isInterrupted()) && (this.readRetryCount < sMaxRetryCount))
      {
        if (!this.mVideoRequest.shouldCancel())
        {
          open((DataSpec)localObject);
          return read(paramArrayOfByte, paramInt1, paramInt2);
        }
        paramArrayOfByte = getLogTag();
        paramHttpDataSourceException = new StringBuilder();
        paramHttpDataSourceException.append("abort retry videoRequest is cancelling ");
        paramHttpDataSourceException.append(this.mVideoRequest);
        PlayerUtils.log(4, paramArrayOfByte, paramHttpDataSourceException.toString());
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("readRetry interrupted ");
        paramArrayOfByte.append(this.mVideoRequest);
        throw new HttpDataSource.InterruptReadException(paramArrayOfByte.toString(), getDataSpec());
      }
      throw paramHttpDataSourceException;
    }
    catch (InterruptedException paramArrayOfByte)
    {
      label359:
      break label359;
    }
    PlayerUtils.log(5, getLogTag(), "readRetry interrupted");
    throw paramHttpDataSourceException;
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("readRetry interrupted UuidDeleted");
    paramArrayOfByte.append(this.mVideoRequest);
    throw new HttpDataSource.InterruptReadException(paramArrayOfByte.toString(), getDataSpec());
  }
  
  private long retryOpen(DataSpec paramDataSpec, String paramString, HttpDataSource.HttpDataSourceException paramHttpDataSourceException)
  {
    boolean bool = paramHttpDataSourceException instanceof HttpDataSource.InvalidResponseCodeException;
    int j = 0;
    int i;
    Map localMap;
    if (bool)
    {
      localObject1 = (HttpDataSource.InvalidResponseCodeException)paramHttpDataSourceException;
      i = ((HttpDataSource.InvalidResponseCodeException)localObject1).responseCode;
      localMap = ((HttpDataSource.InvalidResponseCodeException)localObject1).headerFields;
    }
    else
    {
      localMap = null;
      i = 0;
    }
    Object localObject2 = paramDataSpec.uri.toString();
    Object localObject1 = getLogTag();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("retryOpen url=");
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append(" with responseCode=");
    ((StringBuilder)localObject4).append(i);
    PlayerUtils.log(4, (String)localObject1, ((StringBuilder)localObject4).toString());
    for (;;)
    {
      if ((Thread.currentThread().isInterrupted()) || (j >= sMaxRetryCount)) {
        break label651;
      }
      localObject1 = this.httpRetryLogic;
      if (localObject1 == null) {
        break label640;
      }
      localObject4 = ((HttpRetryLogic)localObject1).getRetryUrl((String)localObject2, j, i, localMap);
      localObject1 = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retryCount=");
      localStringBuilder.append(j);
      localStringBuilder.append(" retryUrl=");
      localStringBuilder.append((String)localObject4);
      PlayerUtils.log(4, (String)localObject1, localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = localObject4;
        if (((String)localObject4).equals(localObject2))
        {
          PlayerUtils.log(5, getLogTag(), "retryUrl is same as origin url");
          localObject1 = localObject4;
        }
      }
      if (UuidPlayIdMap.isUuidDeleted(paramDataSpec.uuid)) {
        break label599;
      }
      j += 1;
      int k = j * 2000;
      localObject2 = getLogTag();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("retry open retrying after ");
      ((StringBuilder)localObject4).append(k);
      ((StringBuilder)localObject4).append(" seconds  retry ");
      ((StringBuilder)localObject4).append(j);
      ((StringBuilder)localObject4).append("/");
      ((StringBuilder)localObject4).append(sMaxRetryCount);
      PlayerUtils.log(4, (String)localObject2, ((StringBuilder)localObject4).toString());
      long l = k;
      try
      {
        Thread.sleep(l);
        localObject2 = new DataSpec(Uri.parse((String)localObject1), paramDataSpec.absoluteStreamPosition, paramDataSpec.position, paramDataSpec.length, paramDataSpec.key, paramDataSpec.flags, paramDataSpec.uuid, paramDataSpec.priority);
        try
        {
          l = super.open((DataSpec)localObject2, paramString);
          return l;
        }
        catch (HttpDataSource.HttpDataSourceException localHttpDataSourceException)
        {
          localObject4 = this.mVideoRequest;
          if ((localObject4 != null) && (((VideoRequest)localObject4).shouldCancel()))
          {
            paramDataSpec = getLogTag();
            paramString = new StringBuilder();
            paramString.append("abort retryOpen videoRequest is cancelling ");
            paramString.append(this.mVideoRequest);
            paramString.append(",reason=");
            paramString.append(PlayerUtils.getPrintableStackTrace(localHttpDataSourceException));
            PlayerUtils.log(4, paramDataSpec, paramString.toString());
            paramDataSpec = new StringBuilder();
            paramDataSpec.append("retry open interrupted ");
            paramDataSpec.append(this.mVideoRequest);
            throw new HttpDataSource.InterruptConnectServerException(paramDataSpec.toString(), getDataSpec());
          }
          Object localObject3 = localObject1;
        }
      }
      catch (InterruptedException paramDataSpec)
      {
        label552:
        break label552;
      }
    }
    Thread.currentThread().interrupt();
    paramDataSpec = new StringBuilder();
    paramDataSpec.append("retry open  interrupted ");
    paramDataSpec.append(this.mVideoRequest);
    throw new HttpDataSource.InterruptConnectServerException(paramDataSpec.toString(), getDataSpec());
    label599:
    paramDataSpec = new StringBuilder();
    paramDataSpec.append("retry open interrupted UuidDeleted");
    paramDataSpec.append(this.mVideoRequest);
    throw new HttpDataSource.InterruptConnectServerException(paramDataSpec.toString(), getDataSpec());
    label640:
    PlayerUtils.log(4, getLogTag(), "httpRetryLogic is null");
    for (;;)
    {
      label651:
      throw paramHttpDataSourceException;
    }
  }
  
  public long open(DataSpec paramDataSpec)
  {
    this.uuid = paramDataSpec.uuid;
    try
    {
      long l = super.open(paramDataSpec);
      return l;
    }
    catch (HttpDataSource.HttpDataSourceException localHttpDataSourceException)
    {
      return retryOpen(paramDataSpec, null, localHttpDataSourceException);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
      return i;
    }
    catch (HttpDataSource.HttpDataSourceException localHttpDataSourceException)
    {
      return readRetry(paramArrayOfByte, paramInt1, paramInt2, localHttpDataSourceException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.NiceHttpDataSource
 * JD-Core Version:    0.7.0.1
 */