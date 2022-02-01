package com.tencent.mobileqq.transfile;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public class NetReq
{
  public static final int PRIOTY_HIGH = 0;
  public static final int PRIOTY_LOW = 2;
  public static final int PRIOTY_NORMAL = 1;
  public boolean bAcceptNegativeContentLength = true;
  public INetEngine.IBreakDownFix mBreakDownFix;
  public int mBusiProtoType;
  public INetEngine.INetEngineListener mCallback;
  public boolean mCanPrintUrl = true;
  public int mContinuErrorLimit = 8;
  public int mContinueConnReusedErrorLimit = 5;
  public long mDelayTime;
  public long mEndDownOffset;
  public long mExcuteTimeLimit = 480000L;
  public INetEngine.NetFailedListener mFailedListener;
  public int mFileType;
  public boolean mIsNetChgAsError;
  public boolean mIsRenameInEngine = true;
  public String mKey;
  public String mMsgId;
  public String mOutPath;
  public OutputStream mOutStream;
  public int mPrioty = 1;
  public Object mPrivate;
  public HashMap<String, String> mReqProperties = new HashMap();
  public NetResp mResp;
  public byte[] mSendData;
  public List<ServerAddr> mServerList;
  public long mStartDownOffset;
  public String mTempPath;
  public boolean mUseByteArrayPool;
  public boolean mUseRaf;
  private Object mUserData;
  
  public Object getUserData()
  {
    try
    {
      Object localObject1 = this.mUserData;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public boolean isWriteToFile()
  {
    return this.mOutPath != null;
  }
  
  public boolean isWriteToStream()
  {
    return this.mOutStream != null;
  }
  
  public boolean saveRecvDataInTransLayer()
  {
    return (this.mOutPath != null) || (this.mOutStream != null);
  }
  
  public void setUserData(Object paramObject)
  {
    try
    {
      this.mUserData = paramObject;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetReq
 * JD-Core Version:    0.7.0.1
 */