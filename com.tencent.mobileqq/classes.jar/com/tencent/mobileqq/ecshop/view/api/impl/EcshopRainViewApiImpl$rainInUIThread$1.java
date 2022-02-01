package com.tencent.mobileqq.ecshop.view.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.ecshop.view.EcShopRainView;
import com.tencent.mobileqq.ecshop.view.EcShopRainView.Conf;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class EcshopRainViewApiImpl$rainInUIThread$1
  implements Runnable
{
  EcshopRainViewApiImpl$rainInUIThread$1(Context paramContext, RelativeLayout paramRelativeLayout, Bitmap paramBitmap) {}
  
  public final void run()
  {
    int i = DisplayUtil.a(this.a, 60.0F);
    EcShopRainView localEcShopRainView = new EcShopRainView(this.a);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.b.addView((View)localEcShopRainView, (ViewGroup.LayoutParams)localLayoutParams);
    localEcShopRainView.post((Runnable)new EcshopRainViewApiImpl.rainInUIThread.1.1(localEcShopRainView, new EcShopRainView.Conf(this.c, i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.api.impl.EcshopRainViewApiImpl.rainInUIThread.1
 * JD-Core Version:    0.7.0.1
 */