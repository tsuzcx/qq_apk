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
    if (this.mKey == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mPeerUin);
      localStringBuilder.append("_");
      localStringBuilder.append(this.mFileType);
      localStringBuilder.append("_");
      localStringBuilder.append(this.mUniseq);
      localStringBuilder.append("_");
      localStringBuilder.append(this.mSubMsgId);
      return localStringBuilder.toString();
    }
    return this.mKey;
  }
  
  public String getKeyForTransfer()
  {
    return this.mPeerUin + this.mUniseq;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TransferRequest\n");
    localStringBuilder.append("mUniseq=" + this.mUniseq);
    localStringBuilder.append(",mMd5=" + this.mMd5);
    localStringBuilder.append(",mIsIp=" + this.mIsUp);
    localStringBuilder.append(",mUinType=" + this.mUinType);
    localStringBuilder.append(",mFileType=" + this.mFileType);
    localStringBuilder.append(",mSelfUin=" + this.mSelfUin);
    localStringBuilder.append(",mPeerUin=" + this.mPeerUin);
    localStringBuilder.append(",mSecondId=" + this.mSecondId);
    localStringBuilder.append(",mServerPath=" + this.mServerPath);
    localStringBuilder.append(",mLocalPath=" + this.mLocalPath);
    localStringBuilder.append(",mBusiType=" + this.mBusiType);
    localStringBuilder.append(",mGroupFileID=" + this.mGroupFileID);
    localStringBuilder.append(",mExtraObj={" + this.mExtraObj + "}");
    localStringBuilder.append(",mPrioty=" + this.mPrioty);
    localStringBuilder.append(",mLogicCallBack=" + this.mUpCallBack);
    localStringBuilder.append(",bEnableEnc=" + this.bEnableEnc);
    localStringBuilder.append(",isQzonePic=" + this.isQzonePic);
    localStringBuilder.append(",pcmForVadPath=" + this.pcmForVadPath);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransferRequest
 * JD-Core Version:    0.7.0.1
 */