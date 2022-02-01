package com.tencent.mobileqq.kandian.repo.reddot;

import android.text.TextUtils;
import java.io.Serializable;

public abstract class KandianMsgBoxRedPntInfo
  implements Serializable
{
  public static final int DATA_TYPE_CARD = 1;
  public static final int DATA_TYPE_TIPS = 0;
  public static final String ENABLE_RECEIVE_RED_PNT_SWITCH = "sp_msg_box_80a_enable_receive";
  public static final String PRIVATE_CHAT_MESSAGE_ID_SP_KEY = "kandian_msg_box_private_chat_message_id_sp_key";
  public static final String PRIVATE_CHAT_SEQ_SP_KEY = "kandian_msg_box_private_chat_seq_sp_key";
  public static final String SP_KEY = "kandian_msg_box_sp_key_new";
  private static final long serialVersionUID = -3014381608481056753L;
  public boolean canDoAnimation = true;
  public int dataType = 0;
  public String feedsID;
  public int feedsType;
  public boolean isExpose;
  public boolean isFromNotification = false;
  public boolean isRead = false;
  public String mArticlePicUrl;
  public String mCardSummary;
  public String mExtraData;
  public String mIconUrl;
  public String mJumpUrl;
  private int mMsgCnt;
  public String mMsgId;
  public String mMsgText;
  public long mMsgTime;
  public int mMsgType;
  public boolean mNeedShowInFolder = false;
  public String mOrangeWord;
  public long mPrivateChatSeq;
  public int mRedType;
  public long mSeq;
  public String mSummary;
  public long mUin;
  public int messageType;
  public int sysMsgFrom;
  public String sysMsgID;
  
  public abstract void asyncWriteToSP();
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (KandianMsgBoxRedPntInfo)paramObject;
      return (this.mSeq == paramObject.mSeq) && (this.mPrivateChatSeq == paramObject.mPrivateChatSeq) && (this.mMsgCnt == paramObject.mMsgCnt) && (this.mMsgTime == paramObject.mMsgTime) && (this.mUin == paramObject.mUin) && (this.mMsgType == paramObject.mMsgType) && (this.mNeedShowInFolder == paramObject.mNeedShowInFolder) && (this.mRedType == paramObject.mRedType) && (this.dataType == paramObject.dataType) && (this.sysMsgFrom == paramObject.sysMsgFrom) && (this.feedsType == paramObject.feedsType) && (this.messageType == paramObject.messageType) && (TextUtils.equals(this.mJumpUrl, paramObject.mJumpUrl)) && (TextUtils.equals(this.mIconUrl, paramObject.mIconUrl)) && (TextUtils.equals(this.mSummary, paramObject.mSummary)) && (TextUtils.equals(this.mOrangeWord, paramObject.mOrangeWord)) && (TextUtils.equals(this.mCardSummary, paramObject.mCardSummary)) && (TextUtils.equals(this.mArticlePicUrl, paramObject.mArticlePicUrl)) && (TextUtils.equals(this.mExtraData, paramObject.mExtraData)) && (TextUtils.equals(this.sysMsgID, paramObject.sysMsgID)) && (TextUtils.equals(this.feedsID, paramObject.feedsID)) && (this.isExpose == paramObject.isExpose);
    }
    return false;
  }
  
  public int getMsgCnt()
  {
    return this.mMsgCnt;
  }
  
  public int hashCode()
  {
    String str = this.mSummary;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (int)(this.mSeq + this.mPrivateChatSeq + this.mUin + this.mMsgCnt + i);
  }
  
  public abstract void removeFromSP();
  
  public void setMsgCnt(int paramInt)
  {
    this.mMsgCnt = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KandianMsgBoxRedPntInfo{mSeq=");
    localStringBuilder.append(this.mSeq);
    localStringBuilder.append(", mPrivateChatSeq=");
    localStringBuilder.append(this.mPrivateChatSeq);
    localStringBuilder.append(", mMsgCnt=");
    localStringBuilder.append(this.mMsgCnt);
    localStringBuilder.append(", mMsgTime=");
    localStringBuilder.append(this.mMsgTime);
    localStringBuilder.append(", mUin=");
    localStringBuilder.append(this.mUin);
    localStringBuilder.append(", mMsgType=");
    localStringBuilder.append(this.mMsgType);
    localStringBuilder.append(", mJumpUrl='");
    localStringBuilder.append(this.mJumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIconUrl='");
    localStringBuilder.append(this.mIconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMsgText='");
    localStringBuilder.append(this.mMsgText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMsgId='");
    localStringBuilder.append(this.mMsgId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isRead=");
    localStringBuilder.append(this.isRead);
    localStringBuilder.append(", mNeedShowInFolder=");
    localStringBuilder.append(this.mNeedShowInFolder);
    localStringBuilder.append(", mRedType=");
    localStringBuilder.append(this.mRedType);
    localStringBuilder.append(", mSummary='");
    localStringBuilder.append(this.mSummary);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mOrangeWord='");
    localStringBuilder.append(this.mOrangeWord);
    localStringBuilder.append('\'');
    localStringBuilder.append(", canDoAnimation=");
    localStringBuilder.append(this.canDoAnimation);
    localStringBuilder.append(", mCardSummary='");
    localStringBuilder.append(this.mCardSummary);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mArticlePicUrl='");
    localStringBuilder.append(this.mArticlePicUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mExtraData='");
    localStringBuilder.append(this.mExtraData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isExpose='");
    localStringBuilder.append(this.isExpose);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public abstract void writeToSP();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo
 * JD-Core Version:    0.7.0.1
 */