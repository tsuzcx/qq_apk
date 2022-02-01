package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.image.ImageUtils;
import java.io.File;

public class KandianProgressView
  extends LinearLayout
{
  public Bundle a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new KandianProgressView.1(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianProgressView.ClickCallBack jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianProgressView$ClickCallBack;
  String jdField_a_of_type_JavaLangString;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView d;
  TextView e;
  
  public KandianProgressView(Context paramContext, Bundle paramBundle, String paramString1, String paramString2, KandianProgressView.ClickCallBack paramClickCallBack)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131560388, this);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianProgressView$ClickCallBack = paramClickCallBack;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    b();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(0);
      c(8);
      return;
    }
    b(8);
    c(0);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366459));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376883));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376500));
    this.d = ((TextView)findViewById(2131365508));
    this.e = ((TextView)findViewById(2131371981));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373132));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365288));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376493));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365494));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    setCoverImg();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(paramInt);
    this.e.setVisibility(paramInt);
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.d.setVisibility(paramInt);
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    TextView localTextView = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131706013));
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    localTextView.setText(localStringBuilder.toString());
    a(true);
  }
  
  protected void a(String paramString)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      localObject = new BitmapFactory.Options();
      int j = 1;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      int i = AIOUtils.b(100.0F, getResources());
      int k = AIOUtils.b(100.0F, getResources());
      float f1 = ((BitmapFactory.Options)localObject).outWidth / i;
      float f2 = ((BitmapFactory.Options)localObject).outHeight / k;
      i = j;
      if (f1 >= 1.0F)
      {
        i = j;
        if (f2 >= 1.0F) {
          i = (int)Math.floor(Math.min(f1, f2));
        }
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = i;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      paramString = ImageUtils.a(ImageUtils.a(paramString), (Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      label172:
      break label172;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void setCoverImg()
  {
    a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void setViewInformation(Bundle paramBundle, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    setCoverImg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.KandianProgressView
 * JD-Core Version:    0.7.0.1
 */