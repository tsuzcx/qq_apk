package com.tencent.mobileqq.popanim;

import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.StickerBubbleAnimationCallback;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PopOutEmoticonReceive
  implements StickerBubbleAnimationView.StickerBubbleAnimationCallback, Runnable
{
  private Handler a = ThreadManager.getUIHandlerV2();
  private ViewGroup b;
  private PopOutAnimConfig c;
  private int d;
  private int e;
  private AppRuntime f = MobileQQ.sMobileQQ.waitAppRuntime(null);
  private boolean g;
  private boolean h;
  private int[] i;
  private int j;
  private boolean k;
  private boolean l;
  private boolean m;
  private Runnable n = new PopOutEmoticonReceive.1(this);
  
  public PopOutEmoticonReceive(ViewGroup paramViewGroup, PopOutAnimConfig paramPopOutAnimConfig, int paramInt1, int paramInt2)
  {
    this.b = paramViewGroup;
    this.c = paramPopOutAnimConfig;
    this.d = QQSysFaceUtil.convertToLocal(paramInt1);
    this.e = paramInt2;
    this.l = (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.f) ^ true);
    PopOutAnimViewHolder.a().a(this, false);
  }
  
  private void b()
  {
    this.g = true;
    this.a.removeCallbacksAndMessages(null);
    this.c.stopShakeAnimation();
    PopOutAnimViewHolder.a().b(this, false);
    if (this.l)
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.f, "StickerBubble", false);
      this.m = true;
    }
  }
  
  @NonNull
  private int[] c()
  {
    int[] arrayOfInt = this.c.itemCountRecShowAppear;
    if (this.e * 80 < 5000) {
      return arrayOfInt;
    }
    int i5 = arrayOfInt.length;
    int i4 = 0;
    int i2 = 0;
    int i3;
    for (int i1 = 0; i2 < i5; i1 = i3)
    {
      i3 = i1;
      if (arrayOfInt[i2] <= this.e) {
        i3 = i1 + 1;
      }
      i2 += 1;
    }
    arrayOfInt = new int[i1];
    i5 = 62 / i1;
    for (i2 = i4; i2 < i1; i2 = i3)
    {
      i3 = i2 + 1;
      arrayOfInt[i2] = (i5 * i3);
    }
    return arrayOfInt;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt)
  {
    b();
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopOutEmoticonReceive", 2, "showReceiveAnimationView from runnable");
    }
    if (this.g) {
      return;
    }
    if ((this.l) && (!this.m))
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.f, "StickerBubble", true);
      this.m = true;
    }
    StickerBubbleAnimationView localStickerBubbleAnimationView = PopOutAnimViewHolder.a().b(this.b, this.c.typeface);
    if (!this.h)
    {
      localStickerBubbleAnimationView.bringToFront();
      this.h = true;
    }
    this.j += 1;
    int i1 = this.j;
    if ((i1 <= this.e) && (i1 * 80 <= 5000))
    {
      if (i1 == 2)
      {
        this.c.startShakeAnimation();
        this.k = false;
      }
      if (this.i == null) {
        this.i = c();
      }
      i1 = this.b.getResources().getDisplayMetrics().widthPixels;
      boolean bool = PopOutEmoticonUtil.a(this.j, this.i);
      String str = PopOutEmoticonUtil.a(this.d, this.c.apngSoLoaded);
      PopOutAnimViewHolder.a();
      localStickerBubbleAnimationView.a(PopOutAnimViewHolder.a(i1, str, bool));
      this.a.postDelayed(this, 80L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PopOutEmoticonReceive", 2, "receiver animation sending finished ");
    }
    this.k = true;
    this.a.postDelayed(this.n, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutEmoticonReceive
 * JD-Core Version:    0.7.0.1
 */