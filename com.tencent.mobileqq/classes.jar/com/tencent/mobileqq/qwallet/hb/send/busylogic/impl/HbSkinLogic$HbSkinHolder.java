package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import Wallet.SkinInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qwallet.hb.FrameAnimHelper;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class HbSkinLogic$HbSkinHolder
  implements QwAdapter.IViewHolder<HbSkinInfo>
{
  private View b;
  private View c;
  private View d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private AnimationView j;
  private Resources k;
  
  public HbSkinLogic$HbSkinHolder(HbSkinLogic paramHbSkinLogic) {}
  
  public void a(int paramInt, View paramView, HbSkinInfo paramHbSkinInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setItemView info = ");
      ((StringBuilder)localObject).append(paramHbSkinInfo);
      QLog.d("HbSkinLogic", 2, ((StringBuilder)localObject).toString());
    }
    if (HbSkinInfo.d == paramHbSkinInfo.f.skin_id)
    {
      localObject = this.a.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HbSkinLogic.ItemSelectListener)((Iterator)localObject).next()).a(paramHbSkinInfo);
      }
    }
    paramView.setFocusable(true);
    paramView.setFocusableInTouchMode(true);
    FrameAnimHelper.a(this.j, false);
    if ((1 != paramHbSkinInfo.f.is_hide_title) && ((1 == paramHbSkinInfo.f.is_hide_title) || (!TextUtils.isEmpty(paramHbSkinInfo.f.blessing)))) {
      this.i.setText(paramHbSkinInfo.f.blessing);
    } else {
      this.i.setText("");
    }
    paramView = this.b;
    paramInt = paramHbSkinInfo.b;
    int m = 8;
    if (1 == paramInt) {
      paramInt = 8;
    } else {
      paramInt = 0;
    }
    paramView.setVisibility(paramInt);
    paramView = this.c;
    if (1 == paramHbSkinInfo.b) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    paramView.setVisibility(paramInt);
    this.h.setText(paramHbSkinInfo.c);
    paramView = this.d;
    if (HbSkinInfo.d == paramHbSkinInfo.f.skin_id) {
      paramInt = m;
    } else {
      paramInt = 0;
    }
    paramView.setVisibility(paramInt);
    paramView = this.h;
    if (HbSkinInfo.d == paramHbSkinInfo.f.skin_id) {
      paramInt = -16777216;
    } else {
      paramInt = -7829368;
    }
    paramView.setTextColor(paramInt);
    Object localObject = this.g;
    if (paramHbSkinInfo.g.icon == null) {
      paramView = this.k.getDrawable(R.drawable.M);
    } else {
      paramView = new BitmapDrawable(paramHbSkinInfo.g.icon);
    }
    ((ImageView)localObject).setBackgroundDrawable(paramView);
    paramInt = paramHbSkinInfo.b;
    paramView = null;
    if (-1 == paramInt)
    {
      this.e.setImageResource(R.drawable.v);
      this.e.setBackgroundDrawable(this.k.getDrawable(R.drawable.t));
    }
    else if (-2 == paramHbSkinInfo.b)
    {
      this.e.setImageResource(R.drawable.v);
      this.e.setBackgroundDrawable(this.k.getDrawable(R.drawable.t));
      this.j.setImageResource(R.drawable.w);
    }
    else
    {
      if (!TextUtils.isEmpty(paramHbSkinInfo.g.resPath))
      {
        this.e.setImageBitmap(null);
        localObject = QWalletPicHelper.getDrawableForAIO(new File(paramHbSkinInfo.g.resPath, "base_bg.png").toString(), HbSkinLogic.e(this.a).getResources().getDrawable(R.drawable.t));
        this.e.setBackgroundDrawable((Drawable)localObject);
      }
      if (paramHbSkinInfo.g.animInfo == null) {}
    }
    try
    {
      new FrameAnimHelper(this.j, 0, false, null).a(paramHbSkinInfo.g.animInfo);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label560:
      break label560;
    }
    localObject = this.f;
    if (paramHbSkinInfo.g.corner != null) {
      paramView = paramHbSkinInfo.g.corner;
    }
    ((ImageView)localObject).setImageBitmap(paramView);
  }
  
  public QwAdapter.IViewHolder clone()
  {
    return (QwAdapter.IViewHolder)super.clone();
  }
  
  public View initView(int paramInt, View paramView)
  {
    this.k = paramView.getContext().getResources();
    this.d = paramView.findViewById(R.id.aY);
    this.b = paramView.findViewById(R.id.ci);
    this.c = paramView.findViewById(R.id.cj);
    this.f = ((ImageView)paramView.findViewById(R.id.W));
    this.g = ((ImageView)paramView.findViewById(R.id.aa));
    this.e = ((ImageView)paramView.findViewById(R.id.X));
    this.e.setScaleType(ImageView.ScaleType.FIT_START);
    this.h = ((TextView)paramView.findViewById(R.id.Y));
    this.i = ((TextView)paramView.findViewById(R.id.ab));
    this.j = ((AnimationView)paramView.findViewById(R.id.Z));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic.HbSkinHolder
 * JD-Core Version:    0.7.0.1
 */