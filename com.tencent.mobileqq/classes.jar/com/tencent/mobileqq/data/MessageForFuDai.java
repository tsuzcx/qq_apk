package com.tencent.mobileqq.data;

import adob;
import anix;
import aniy;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;

public class MessageForFuDai
  extends ChatMessage
  implements adob
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
    anix.a(this.msgData, this);
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public String getSummaryMsg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForFuDai", 2, "getSummaryMsg() called fdTxt=" + this.fdTxt);
    }
    return this.fdTxt;
  }
  
  public String highlightMsg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForFuDai", 2, "highlightMsg Txt=" + this.highlightMsg);
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
    return (this.state == 3) || (this.state == 7);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void onUpdate(int paramInt)
  {
    this.currentFrame = paramInt;
  }
  
  public void prewrite()
  {
    this.msgData = aniy.a(this);
  }
  
  public String toString()
  {
    return "MessageForFuDai{hostUin='" + MsfSdkUtils.getShortUin(this.hostUin) + '\'' + ", fdId='" + this.fdId + '\'' + ", shareType=" + this.shareType + ", targetId='" + this.targetId + '\'' + ", fdTxt='" + this.fdTxt + '\'' + ", aioTails='" + this.aioTails + '\'' + ", state=" + this.state + ", busiId=" + this.busiId + ", highlightMsg='" + this.highlightMsg + '\'' + ", themeId=" + this.themeId + ", expireTime=" + this.expireTime + ", currentFrame=" + this.currentFrame + ", useDefaultImag=" + this.useDefaultImag + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForFuDai
 * JD-Core Version:    0.7.0.1
 */