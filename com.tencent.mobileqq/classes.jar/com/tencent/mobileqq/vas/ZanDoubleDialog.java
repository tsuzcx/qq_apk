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
  private static int jdField_a_of_type_Int = 150;
  private static int b = 56;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ZanDoubleDialog.1(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ZanDoubleDialog.BtnClickListener jdField_a_of_type_ComTencentMobileqqVasZanDoubleDialog$BtnClickListener;
  
  public ZanDoubleDialog(Context paramContext)
  {
    super(paramContext, 2131755176);
  }
  
  public void a(ZanDoubleDialog.BtnClickListener paramBtnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasZanDoubleDialog$BtnClickListener = paramBtnClickListener;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131562202);
    findViewById(2131375427).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    findViewById(2131375428).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    findViewById(2131375429).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375430));
    paramBundle = new ColorDrawable(15856629);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    float f = localResources.getDisplayMetrics().density;
    localURLDrawableOptions.mRequestWidth = ((int)(localResources.getDisplayMetrics().widthPixels - b * f));
    localURLDrawableOptions.mRequestHeight = ((int)(jdField_a_of_type_Int * f));
    localURLDrawableOptions.mFailedDrawable = paramBundle;
    localURLDrawableOptions.mLoadingDrawable = paramBundle;
    paramBundle = URLDrawable.getDrawable("https://gxh.vip.qq.com/xydata/like/app/zanDoubleConfig/single.png", localURLDrawableOptions);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ZanDoubleDialog
 * JD-Core Version:    0.7.0.1
 */