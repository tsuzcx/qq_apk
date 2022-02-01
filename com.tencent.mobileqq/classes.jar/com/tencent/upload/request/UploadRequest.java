package com.tencent.upload.request;

import com.qq.taf.jce.JceStruct;
import com.tencent.upload.network.session.IUploadSession.RequestListener;
import com.tencent.upload.utils.JceEncoder;
import com.tencent.upload.utils.PDUtil;
import com.tencent.upload.utils.UploadLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class UploadRequest
  implements IActionRequest
{
  private static final AtomicInteger REQUEST_SEQUENCE = new AtomicInteger(0);
  private static final String TAG = "UploadRequest";
  private IUploadSession.RequestListener mListener;
  protected final int mRequestId = REQUEST_SEQUENCE.incrementAndGet();
  private Object mTag;
  private int mTaskId;
  
  public UploadRequest() {}
  
  public UploadRequest(int paramInt)
  {
    this();
    this.mTaskId = paramInt;
  }
  
  protected abstract JceStruct createJceRequest();
  
  public byte[] encode()
  {
    for (;;)
    {
      try
      {
        localObject = createJceRequest();
        if (localObject == null)
        {
          UploadLog.e("UploadRequest", "createJceRequest return null");
          return null;
        }
      }
      catch (Throwable localThrowable)
      {
        byte[] arrayOfByte;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("encode exception. reqId=");
        ((StringBuilder)localObject).append(getRequestId());
        UploadLog.e("UploadRequest", ((StringBuilder)localObject).toString(), localThrowable);
        return null;
      }
      catch (IOException localIOException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("encode exception. reqId=");
        ((StringBuilder)localObject).append(getRequestId());
        UploadLog.e("UploadRequest", ((StringBuilder)localObject).toString(), localIOException);
        throw localIOException;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("encode exception. reqId=");
        ((StringBuilder)localObject).append(getRequestId());
        UploadLog.e("UploadRequest", ((StringBuilder)localObject).toString(), localFileNotFoundException);
        return null;
      }
      try
      {
        arrayOfByte = JceEncoder.encode((JceStruct)localObject);
        arrayOfByte = PDUtil.encode(getCmdId(), this.mRequestId, arrayOfByte);
        return arrayOfByte;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        continue;
      }
      UploadLog.e("UploadRequest", "encode request OOM. gc, then retry");
      System.gc();
      arrayOfByte = JceEncoder.encode((JceStruct)localObject);
      arrayOfByte = PDUtil.encode(getCmdId(), this.mRequestId, arrayOfByte);
    }
  }
  
  public int getCmdId()
  {
    return 1;
  }
  
  public IUploadSession.RequestListener getListener()
  {
    return this.mListener;
  }
  
  public int getRequestId()
  {
    return this.mRequestId;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public int getTaskId()
  {
    return this.mTaskId;
  }
  
  public boolean needTimeout()
  {
    return true;
  }
  
  public void setListener(IUploadSession.RequestListener paramRequestListener)
  {
    this.mListener = paramRequestListener;
  }
  
  public void setTag(Object paramObject)
  {
    this.mTag = paramObject;
  }
  
  public void setTaskId(int paramInt)
  {
    this.mTaskId = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskId=");
    localStringBuilder.append(getTaskId());
    localStringBuilder.append(" reqId=");
    localStringBuilder.append(getRequestId());
    localStringBuilder.append(" cmd=");
    localStringBuilder.append(getCmdId());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.request.UploadRequest
 * JD-Core Version:    0.7.0.1
 */