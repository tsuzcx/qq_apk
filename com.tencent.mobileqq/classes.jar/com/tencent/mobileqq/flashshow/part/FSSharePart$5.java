package com.tencent.mobileqq.flashshow.part;

import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;

class FSSharePart$5
  implements ShareActionSheetClickListener
{
  FSSharePart$5(FSSharePart paramFSSharePart) {}
  
  public void cancelPushDisable()
  {
    FSSharePart.a(this.a, false);
  }
  
  public void delete()
  {
    FSSharePart.f(this.a);
    FSSharePart.a(this.a, false, true);
  }
  
  public void deleteHasPush()
  {
    FSSharePart.a(this.a, false, true);
  }
  
  public void feedback()
  {
    FSSharePart.e(this.a);
    FSSharePart.a(this.a, false);
  }
  
  public void hideHim()
  {
    FSSharePart.a(this.a, false);
  }
  
  public void hideThisWork()
  {
    FSSharePart.a(this.a, false);
  }
  
  public void jumpQcirclePrivateMessage()
  {
    FSSharePart.a(this.a, false);
  }
  
  public void miniAppDebugOn()
  {
    FSSharePart.i(this.a);
    FSSharePart.a(this.a, false);
  }
  
  public void report()
  {
    FSSharePart.d(this.a);
    FSSharePart.a(this.a, false);
  }
  
  public void save()
  {
    FSSharePart.h(this.a);
    FSSharePart.a(this.a, false);
  }
  
  public void shareToQQ()
  {
    FSSharePart.b(this.a);
    FSSharePart.a(this.a, false);
  }
  
  public void shareToQZone()
  {
    FSSharePart.c(this.a);
    FSSharePart.a(this.a, false);
  }
  
  public void shareToSpecifiedFriend(String paramString, int paramInt)
  {
    FSSharePart.a(this.a, paramString, paramInt);
    FSSharePart.a(this.a, false);
  }
  
  public void shareToWeChat()
  {
    FSSharePart.b(this.a, true);
    FSSharePart.a(this.a, false);
  }
  
  public void shareToWeChatCircle()
  {
    FSSharePart.b(this.a, false);
    FSSharePart.a(this.a, false);
  }
  
  public void showReportDisLike()
  {
    FSSharePart.g(this.a);
    FSSharePart.a(this.a, false);
  }
  
  public void switchBarrageClose() {}
  
  public void switchBarrageOpen() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSSharePart.5
 * JD-Core Version:    0.7.0.1
 */