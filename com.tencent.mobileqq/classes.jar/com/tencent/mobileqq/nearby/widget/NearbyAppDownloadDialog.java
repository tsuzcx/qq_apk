package com.tencent.mobileqq.nearby.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.nearby.CikeConfigData;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRelativeLayout;

public class NearbyAppDownloadDialog
  extends Dialog
  implements View.OnClickListener
{
  protected int a;
  protected Context a;
  protected Drawable a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected CikeConfigData a;
  protected RoundRelativeLayout a;
  protected int b;
  protected ImageView b;
  protected TextView b;
  
  public NearbyAppDownloadDialog(Context paramContext)
  {
    super(paramContext, 2131756189);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  protected void a()
  {
    setContentView(2131558971);
    this.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout = ((RoundRelativeLayout)findViewById(2131365196));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363840));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363506));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368624));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378745));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371472));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.setRoundLayoutRadius(ScreenUtil.dip2px(3.0F));
    this.jdField_a_of_type_Int = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(28.0F) * 2);
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * 150 / 320);
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init, w=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", h=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      QLog.d("NearbyAppDownloadDialog", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void a(ImageView paramImageView, String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#f4f4f4"));
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadImage, url=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("NearbyAppDownloadDialog", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_b_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      }
      else
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("NearbyAppDownloadDialog", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadImage exp: url=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.w("NearbyAppDownloadDialog", 2, ((StringBuilder)localObject1).toString(), localException);
        localObject1 = localObject2;
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  protected void a(String paramString)
  {
    new ReportTask(null).a("dc00899").b("grp_lbs").c("home").d(paramString).e(this.jdField_a_of_type_ComTencentMobileqqNearbyCikeConfigData.g).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqNearbyCikeConfigData.f }).a();
  }
  
  public boolean a(CikeConfigData paramCikeConfigData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyCikeConfigData = paramCikeConfigData;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initContent=");
      localStringBuilder.append(paramCikeConfigData.toString());
      QLog.d("NearbyAppDownloadDialog", 2, localStringBuilder.toString());
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, paramCikeConfigData.a);
    if (!TextUtils.isEmpty(paramCikeConfigData.c))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(paramCikeConfigData.c);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramCikeConfigData.b))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCikeConfigData.b);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramCikeConfigData.e))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return false;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131368624)
    {
      dismiss();
      a("pop_new_quit");
      return;
    }
    if (i == 2131363840)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("btn onClick, jumpUrl=");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqNearbyCikeConfigData.d);
        QLog.d("NearbyAppDownloadDialog", 2, paramView.toString());
      }
      NearbyPublishMenuHelper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqNearbyCikeConfigData.d);
      dismiss();
      a("pop_new_clk");
      return;
    }
    if (i == 2131371472)
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("more onClick, jumpUrl=");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqNearbyCikeConfigData.e);
        QLog.d("NearbyAppDownloadDialog", 2, paramView.toString());
      }
      NearbyPublishMenuHelper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqNearbyCikeConfigData.e);
    }
  }
  
  public void show()
  {
    super.show();
    a("pop_new_exp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyAppDownloadDialog
 * JD-Core Version:    0.7.0.1
 */