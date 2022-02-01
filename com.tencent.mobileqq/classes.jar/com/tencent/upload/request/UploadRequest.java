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
    try
    {
      Object localObject = createJceRequest();
      if (localObject == null)
      {
        UploadLog.e("UploadRequest", "createJceRequest return null");
        return null;
      }
      try
      {
        byte[] arrayOfByte = JceEncoder.encode((JceStruct)localObject);
        arrayOfByte = PDUtil.encode(getCmdId(), this.mRequestId, arrayOfByte);
        return arrayOfByte;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        UploadLog.e("UploadRequest", "encode request OOM. gc, then retry");
        System.gc();
        localObject = JceEncoder.encode((JceStruct)localObject);
        localObject = PDUtil.encode(getCmdId(), this.mRequestId, (byte[])localObject);
        return localObject;
      }
      return null;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      UploadLog.e("UploadRequest", "encode exception. reqId=" + getRequestId(), localFileNotFoundException);
      return null;
    }
    catch (IOException localIOException)
    {
      UploadLog.e("UploadRequest", "encode exception. reqId=" + getRequestId(), localIOException);
      throw localIOException;
    }
    catch (Throwable localThrowable)
    {
      UploadLog.e("UploadRequest", "encode exception. reqId=" + getRequestId(), localThrowable);
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
    localStringBuilder.append("taskId=").append(getTaskId()).append(" reqId=").append(getRequestId()).append(" cmd=").append(getCmdId());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.request.UploadRequest
 * JD-Core Version:    0.7.0.1
 */