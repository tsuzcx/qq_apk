package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awoh;
import bdkf;
import bdrf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;

public class ZanBannerView
  extends FrameLayout
{
  private static String jdField_a_of_type_JavaLangString = "spKeyZanBannerIndex";
  private int jdField_a_of_type_Int = -1;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private awoh jdField_a_of_type_Awoh;
  private bdrf jdField_a_of_type_Bdrf;
  private List<awoh> jdField_a_of_type_JavaUtilList;
  
  public ZanBannerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ZanBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ZanBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private awoh a()
  {
    if (a()) {
      return null;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    this.jdField_a_of_type_Awoh = ((awoh)localList.get(i % this.jdField_a_of_type_JavaUtilList.size()));
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int).commit();
    return this.jdField_a_of_type_Awoh;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131561719, null));
    this.jdField_a_of_type_Bdrf = new bdrf(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Int = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt(jdField_a_of_type_JavaLangString, 0);
    if (this.jdField_a_of_type_Int > 100) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  private void a(bdrf parambdrf)
  {
    Object localObject = a();
    int i;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (localObject != null)
    {
      parambdrf.jdField_a_of_type_AndroidWidgetTextView.setText(((awoh)localObject).jdField_a_of_type_JavaLangString);
      parambdrf.jdField_b_of_type_AndroidWidgetTextView.setText(((awoh)localObject).b);
      if (((awoh)localObject).jdField_a_of_type_JavaUtilVector != null)
      {
        i = ((awoh)localObject).jdField_a_of_type_JavaUtilVector.size();
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int j = bdkf.b(36.0F);
        localURLDrawableOptions.mRequestWidth = j;
        localURLDrawableOptions.mRequestHeight = j;
        if (i != 1) {
          break label118;
        }
        localURLDrawable = URLDrawable.getDrawable((String)((awoh)localObject).jdField_a_of_type_JavaUtilVector.get(0), localURLDrawableOptions);
        parambdrf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        parambdrf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    label118:
    while (i <= 1) {
      return;
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable((String)((awoh)localObject).jdField_a_of_type_JavaUtilVector.get(0), localURLDrawableOptions);
    localObject = URLDrawable.getDrawable((String)((awoh)localObject).jdField_a_of_type_JavaUtilVector.get(1), localURLDrawableOptions);
    parambdrf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
    parambdrf.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    parambdrf.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Awoh != null) {
      return this.jdField_a_of_type_Awoh.c;
    }
    return null;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Awoh != null) {
      return this.jdField_a_of_type_Awoh.d;
    }
    return "";
  }
  
  public void setInfoList(List<awoh> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    a(this.jdField_a_of_type_Bdrf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ZanBannerView
 * JD-Core Version:    0.7.0.1
 */