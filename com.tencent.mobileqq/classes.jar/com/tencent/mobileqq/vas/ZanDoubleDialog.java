package com.tencent.mobileqq.vas;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ZanDoubleDialog
  extends ReportDialog
{
  private static int d = 150;
  private static int e = 56;
  ImageView a;
  ZanDoubleDialog.BtnClickListener b;
  View.OnClickListener c = new ZanDoubleDialog.1(this);
  
  public ZanDoubleDialog(Context paramContext)
  {
    super(paramContext, 2131952034);
  }
  
  public void a(ZanDoubleDialog.BtnClickListener paramBtnClickListener)
  {
    this.b = paramBtnClickListener;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131628465);
    findViewById(2131443130).setOnClickListener(this.c);
    findViewById(2131443131).setOnClickListener(this.c);
    findViewById(2131443132).setOnClickListener(this.c);
    this.a = ((ImageView)findViewById(2131443133));
    paramBundle = new ColorDrawable(15856629);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    float f = localResources.getDisplayMetrics().density;
    localURLDrawableOptions.mRequestWidth = ((int)(localResources.getDisplayMetrics().widthPixels - e * f));
    localURLDrawableOptions.mRequestHeight = ((int)(f * d));
    localURLDrawableOptions.mFailedDrawable = paramBundle;
    localURLDrawableOptions.mLoadingDrawable = paramBundle;
    paramBundle = URLDrawable.getDrawable("https://gxh.vip.qq.com/xydata/like/app/zanDoubleConfig/single.png", localURLDrawableOptions);
    this.a.setImageDrawable(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ZanDoubleDialog
 * JD-Core Version:    0.7.0.1
 */