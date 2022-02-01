package com.tencent.mobileqq.portal;

import com.tencent.mobileqq.activity.springfestival.HBEntryShareActivity;
import com.tencent.mobileqq.activity.springfestival.entry.model.OnGrabActivityData.Share;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ConversationHongBaoV2$ShowSharePageTask
{
  private List<String> b;
  private OnGrabActivityData.Share c;
  private String d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public ConversationHongBaoV2$ShowSharePageTask(List<String> paramList, OnGrabActivityData.Share paramShare, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramShare;
    this.c = paramString;
    this.d = paramInt1;
    this.e = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    int i;
    this.f = i;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "ShowSharePageTask invoke");
    }
    HBEntryShareActivity.a((BaseActivity)ConversationHongBaoV2.q(this.a), this.d, this.e, this.g, this.h, this.f, this.c.logoImgUrl, this.c.nameWording, this.c.greetWording, this.c.bgUrl, this.c.shareBgUrl, this.c.qrImgUrl, this.c.bottomWording, this.b, this.c.middleBgUrl, this.c.middleShareBgUrl, this.c.btnImgUrl, this.c.btnPressImgUrl, this.c.btnImgApngUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.ShowSharePageTask
 * JD-Core Version:    0.7.0.1
 */