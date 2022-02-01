package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.UpCallBack;
import com.wx.voice.vad.WXVadSeg;
import java.io.OutputStream;

public class TransferRequest
{
  public boolean bEnableEnc = false;
  public int chatType;
  public Object extraObject;
  public boolean isJubaoMsgType = false;
  public boolean isQzonePic = false;
  public boolean isShareImageByServer;
  public int mBusiType;
  public boolean mCanSendMsg;
  public int mCommandId;
  public int mDbRecVersion = 5;
  public String mDisplayOutFilePath;
  public DownCallBack mDownCallBack;
  public int mDownMode;
  public byte[] mExtentionInfo;
  public Object mExtraObj;
  public long mFastForwardFileSize;
  public int mFastForwardHeight;
  public int mFastForwardWidth;
  public int mFileType;
  public long mGroupFileID;
  public String mGroupFileKeyStr;
  public boolean mIsFastForward = false;
  public boolean mIsOnlyGetUrl = false;
  public boolean mIsPresend;
  public boolean mIsPttPreSend;
  public boolean mIsSecSnapChatPic;
  public boolean mIsSelfSend = false;
  public boolean mIsUp;
  private String mKey = null;
  public String mLocalPath;
  public String mMd5;
  public long mMsgTime;
  public boolean mNeedReport = true;
  public OutputStream mOut;
  public String mOutFilePath;
  public String mPeerUin;
  public int mPicSendSource;
  public int mPrioty = 1;
  public boolean mPttCompressFinish = false;
  public int mPttUploadPanel;
  public MessageRecord mRec = null;
  public int mRequestDisplayLength;
  public int mRequestLength;
  public int mRequestOffset;
  public TransferResult mResult;
  public String mRichTag = "";
  public long mSecMsgId;
  public String mSecondId;
  public String mSelfUin;
  public String mServerPath;
  public long mSubMsgId;
  public boolean mSupportRangeBreakDown = false;
  public String mThumbMd5;
  public String mThumbPath;
  public int mUinType;
  public long mUniseq;
  public UpCallBack mUpCallBack;
  public int multiMsgType;
  public boolean myPresendInvalid = false;
  public boolean needSendMsg = true;
  public int pcmForVadNum;
  public String pcmForVadPath;
  public int pcmForVadPos;
  public PhotoSendParams photoSendParams;
  public String resIdStr;
  public byte[] toSendData;
  public int upMsgBusiType;
  public boolean useOutputstream = true;
  public WXVadSeg vadSeg;
  
  public String getKey()
  {
    String str = this.mKey;
    Object localObject = str;
    if (str == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mPeerUin);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mFileType);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mUniseq);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.mSubMsgId);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public String getKeyForTransfer()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mPeerUin);
    localStringBuilder.append(this.mUniseq);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("TransferRequest\n");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mUniseq=");
    localStringBuilder2.append(this.mUniseq);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mMd5=");
    localStringBuilder2.append(this.mMd5);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mIsIp=");
    localStringBuilder2.append(this.mIsUp);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mUinType=");
    localStringBuilder2.append(this.mUinType);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mFileType=");
    localStringBuilder2.append(this.mFileType);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mSelfUin=");
    localStringBuilder2.append(this.mSelfUin);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mPeerUin=");
    localStringBuilder2.append(this.mPeerUin);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mSecondId=");
    localStringBuilder2.append(this.mSecondId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mServerPath=");
    localStringBuilder2.append(this.mServerPath);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mLocalPath=");
    localStringBuilder2.append(this.mLocalPath);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mBusiType=");
    localStringBuilder2.append(this.mBusiType);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mGroupFileID=");
    localStringBuilder2.append(this.mGroupFileID);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mExtraObj={");
    localStringBuilder2.append(this.mExtraObj);
    localStringBuilder2.append("}");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mPrioty=");
    localStringBuilder2.append(this.mPrioty);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mLogicCallBack=");
    localStringBuilder2.append(this.mUpCallBack);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",bEnableEnc=");
    localStringBuilder2.append(this.bEnableEnc);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",isQzonePic=");
    localStringBuilder2.append(this.isQzonePic);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",pcmForVadPath=");
    localStringBuilder2.append(this.pcmForVadPath);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransferRequest
 * JD-Core Version:    0.7.0.1
 */