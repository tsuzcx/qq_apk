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
import azth;
import bhqb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;

public class ZanBannerView
  extends FrameLayout
{
  private static String jdField_a_of_type_JavaLangString = "spKeyZanBannerIndex";
  private int jdField_a_of_type_Int = -1;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private azth jdField_a_of_type_Azth;
  private bhqb jdField_a_of_type_Bhqb;
  private List<azth> jdField_a_of_type_JavaUtilList;
  
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
  
  private azth a()
  {
    if (a()) {
      return null;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    this.jdField_a_of_type_Azth = ((azth)localList.get(i % this.jdField_a_of_type_JavaUtilList.size()));
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int).commit();
    return this.jdField_a_of_type_Azth;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131561961, null));
    this.jdField_a_of_type_Bhqb = new bhqb(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Int = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt(jdField_a_of_type_JavaLangString, 0);
    if (this.jdField_a_of_type_Int > 100) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  private void a(bhqb parambhqb)
  {
    Object localObject = a();
    int i;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (localObject != null)
    {
      parambhqb.jdField_a_of_type_AndroidWidgetTextView.setText(((azth)localObject).jdField_a_of_type_JavaLangString);
      parambhqb.jdField_b_of_type_AndroidWidgetTextView.setText(((azth)localObject).b);
      if (((azth)localObject).jdField_a_of_type_JavaUtilVector != null)
      {
        i = ((azth)localObject).jdField_a_of_type_JavaUtilVector.size();
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int j = ViewUtils.dpToPx(36.0F);
        localURLDrawableOptions.mRequestWidth = j;
        localURLDrawableOptions.mRequestHeight = j;
        if (i != 1) {
          break label118;
        }
        localURLDrawable = URLDrawable.getDrawable((String)((azth)localObject).jdField_a_of_type_JavaUtilVector.get(0), localURLDrawableOptions);
        parambhqb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        parambhqb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    label118:
    while (i <= 1) {
      return;
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable((String)((azth)localObject).jdField_a_of_type_JavaUtilVector.get(0), localURLDrawableOptions);
    localObject = URLDrawable.getDrawable((String)((azth)localObject).jdField_a_of_type_JavaUtilVector.get(1), localURLDrawableOptions);
    parambhqb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
    parambhqb.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    parambhqb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Azth != null) {
      return this.jdField_a_of_type_Azth.c;
    }
    return null;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Azth != null) {
      return this.jdField_a_of_type_Azth.d;
    }
    return "";
  }
  
  public void setInfoList(List<azth> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    a(this.jdField_a_of_type_Bhqb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ZanBannerView
 * JD-Core Version:    0.7.0.1
 */