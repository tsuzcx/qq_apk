package com.tencent.util;

import com.tencent.mobileqq.app.FrameHelperActivity.QQSettingMeListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.widget.RandomCoverView;

final class DrawerCoverUtil$2
  extends CallBacker
{
  DrawerCoverUtil$2(QBaseActivity paramQBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener, boolean paramBoolean, IVasQuickUpdateService paramIVasQuickUpdateService) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    DrawerCoverUtil.a(this.a, this.b, this.c, this.d, this.e, this.f);
    this.g.removeCallBacker(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.DrawerCoverUtil.2
 * JD-Core Version:    0.7.0.1
 */