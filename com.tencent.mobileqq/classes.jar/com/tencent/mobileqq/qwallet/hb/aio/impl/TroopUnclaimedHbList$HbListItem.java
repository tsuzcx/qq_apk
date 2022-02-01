package com.tencent.mobileqq.qwallet.hb.aio.impl;

import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;

class TroopUnclaimedHbList$HbListItem
  extends FrameLayout
{
  FrameLayout a;
  ImageView b;
  QQWalletTroopHbItem c;
  LinearLayout d;
  Context e;
  
  public TroopUnclaimedHbList$HbListItem(TroopUnclaimedHbList paramTroopUnclaimedHbList, @NonNull Context paramContext, QQWalletTroopHbItem paramQQWalletTroopHbItem)
  {
    super(paramContext);
    this.e = paramContext;
    this.c = paramQQWalletTroopHbItem;
    this.d = new LinearLayout(paramContext);
    this.d.setOrientation(1);
    this.d.setClickable(true);
    addView(this.d);
    paramTroopUnclaimedHbList = (FrameLayout.LayoutParams)this.d.getLayoutParams();
    paramTroopUnclaimedHbList.width = -2;
    paramTroopUnclaimedHbList.height = -2;
    this.a = new FrameLayout(paramContext);
    if (!SimpleUIUtil.e()) {
      this.a.setBackgroundResource(R.drawable.ar);
    }
    this.d.addView(this.a);
    paramTroopUnclaimedHbList = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    paramTroopUnclaimedHbList.width = ScreenUtil.dip2px(29.0F);
    paramTroopUnclaimedHbList.height = ScreenUtil.dip2px(29.0F);
    paramTroopUnclaimedHbList.gravity = 1;
    this.b = new ImageView(paramContext);
    this.a.addView(this.b);
    paramTroopUnclaimedHbList = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    paramTroopUnclaimedHbList.width = ScreenUtil.dip2px(28.0F);
    paramTroopUnclaimedHbList.height = ScreenUtil.dip2px(28.0F);
    paramTroopUnclaimedHbList.gravity = 17;
  }
  
  public void a(RedPackGrapInfo paramRedPackGrapInfo)
  {
    if (this.b != null)
    {
      localObject = FaceDrawable.getUserFaceDrawable(TroopUnclaimedHbList.a(this.f), String.valueOf(paramRedPackGrapInfo.lUin), (byte)3);
      this.b.setImageDrawable((Drawable)localObject);
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((QQWalletTroopHbItem)localObject).a(paramRedPackGrapInfo);
      localObject = this.c.a(this.d);
      if (localObject != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = ScreenUtil.dip2px(11.5F);
        localLayoutParams.gravity = 16;
        ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
        this.c.a((FrameLayout)localObject, paramRedPackGrapInfo, new TroopUnclaimedHbList.HbListItem.1(this));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TroopUnclaimedRedPacketList", 2, "red packet item layout is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.HbListItem
 * JD-Core Version:    0.7.0.1
 */