package com.tencent.mobileqq.data;

import acmt;
import ajjy;
import android.text.TextUtils;
import awav;
import bace;
import com.tencent.image.QQLiveDrawable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class MessageForLightVideo
  extends MessageForShortVideo
  implements acmt
{
  public static final int LIGHT_VIDEO_STATUS_MUTE_PLAY = 3;
  public static final int LIGHT_VIDEO_STATUS_PAUSE = 2;
  public static final int LIGHT_VIDEO_STATUS_PLAYING = 1;
  public static final int LIGHT_VIDEO_STATUS_STOP = 0;
  public boolean hasShowInAIO;
  public boolean isLightVideoRead;
  public QQLiveDrawable mCurrQQLive;
  public int videoStatus;
  
  public boolean checkForward()
  {
    return false;
  }
  
  public void doParse()
  {
    super.doParse();
    if ("1".equals(getExtInfoFromExtStr(awav.u)))
    {
      this.isLightVideoRead = true;
      return;
    }
    this.isLightVideoRead = false;
  }
  
  public String getSummaryMsg()
  {
    if (TextUtils.isEmpty(this.msg)) {
      return ajjy.a(2131640788);
    }
    return this.msg;
  }
  
  public boolean isAllReady()
  {
    return (bace.b(ShortVideoUtils.a(this, "mp4"))) && ((!isSendFromLocal()) || (isStatusReady()));
  }
  
  public boolean isStatusReady()
  {
    return (this.videoFileStatus == 1003) || (this.videoFileStatus == 2003);
  }
  
  public void postRead()
  {
    parse();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLightVideo
 * JD-Core Version:    0.7.0.1
 */