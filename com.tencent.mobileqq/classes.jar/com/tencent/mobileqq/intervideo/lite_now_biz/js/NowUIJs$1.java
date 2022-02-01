package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;

class NowUIJs$1
  implements IMiniMsgUnreadCallback
{
  NowUIJs$1(NowUIJs paramNowUIJs) {}
  
  public void destroy() {}
  
  public void hide() {}
  
  public void hideUnread() {}
  
  public boolean show(int paramInt)
  {
    NowUIJs.access$000(this.a, paramInt);
    return true;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle) {}
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    NowUIJs.access$000(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowUIJs.1
 * JD-Core Version:    0.7.0.1
 */