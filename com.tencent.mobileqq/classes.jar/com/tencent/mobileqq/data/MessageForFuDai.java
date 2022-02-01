package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.FrameListener;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;

public class MessageForFuDai
  extends ChatMessage
  implements CustomFrameAnimationDrawable.FrameListener
{
  private static final String TAG = "MessageForFuDai";
  public String aioTails = "";
  public int busiId;
  public int currentFrame;
  public int expireTime;
  public String fdId = "";
  public String fdTxt = "";
  private String highlightMsg = "";
  public String hostUin = "";
  public int shareType;
  private int state;
  public String targetId = "";
  public int themeId;
  public boolean useDefaultImag;
  
  protected void doParse()
  {
    MessageForFuDai.Decoder.a(this.msgData, this);
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public String getSummaryMsg()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSummaryMsg() called fdTxt=");
      localStringBuilder.append(this.fdTxt);
      QLog.d("MessageForFuDai", 2, localStringBuilder.toString());
    }
    return this.fdTxt;
  }
  
  public String highlightMsg()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("highlightMsg Txt=");
      localStringBuilder.append(this.highlightMsg);
      QLog.d("MessageForFuDai", 2, localStringBuilder.toString());
    }
    return this.highlightMsg;
  }
  
  public boolean isEmpty()
  {
    return this.state == 4;
  }
  
  public boolean isExpired()
  {
    return true;
  }
  
  public boolean isGrabByMe()
  {
    int i = this.state;
    return (i == 3) || (i == 7);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void onUpdate(int paramInt)
  {
    this.currentFrame = paramInt;
  }
  
  protected void prewrite()
  {
    this.msgData = MessageForFuDai.Encoder.a(this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MessageForFuDai{hostUin='");
    localStringBuilder.append(MsfSdkUtils.getShortUin(this.hostUin));
    localStringBuilder.append('\'');
    localStringBuilder.append(", fdId='");
    localStringBuilder.append(this.fdId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareType=");
    localStringBuilder.append(this.shareType);
    localStringBuilder.append(", targetId='");
    localStringBuilder.append(this.targetId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fdTxt='");
    localStringBuilder.append(this.fdTxt);
    localStringBuilder.append('\'');
    localStringBuilder.append(", aioTails='");
    localStringBuilder.append(this.aioTails);
    localStringBuilder.append('\'');
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.state);
    localStringBuilder.append(", busiId=");
    localStringBuilder.append(this.busiId);
    localStringBuilder.append(", highlightMsg='");
    localStringBuilder.append(this.highlightMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", themeId=");
    localStringBuilder.append(this.themeId);
    localStringBuilder.append(", expireTime=");
    localStringBuilder.append(this.expireTime);
    localStringBuilder.append(", currentFrame=");
    localStringBuilder.append(this.currentFrame);
    localStringBuilder.append(", useDefaultImag=");
    localStringBuilder.append(this.useDefaultImag);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFuDai
 * JD-Core Version:    0.7.0.1
 */