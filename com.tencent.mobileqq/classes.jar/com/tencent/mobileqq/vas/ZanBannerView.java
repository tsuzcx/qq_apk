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
import azzx;
import bhtq;
import biaw;
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
  private azzx jdField_a_of_type_Azzx;
  private biaw jdField_a_of_type_Biaw;
  private List<azzx> jdField_a_of_type_JavaUtilList;
  
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
  
  private azzx a()
  {
    if (a()) {
      return null;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    this.jdField_a_of_type_Azzx = ((azzx)localList.get(i % this.jdField_a_of_type_JavaUtilList.size()));
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int).commit();
    return this.jdField_a_of_type_Azzx;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131562016, null));
    this.jdField_a_of_type_Biaw = new biaw(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Int = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt(jdField_a_of_type_JavaLangString, 0);
    if (this.jdField_a_of_type_Int > 100) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  private void a(biaw parambiaw)
  {
    Object localObject = a();
    int i;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (localObject != null)
    {
      parambiaw.jdField_a_of_type_AndroidWidgetTextView.setText(((azzx)localObject).jdField_a_of_type_JavaLangString);
      parambiaw.jdField_b_of_type_AndroidWidgetTextView.setText(((azzx)localObject).b);
      if (((azzx)localObject).jdField_a_of_type_JavaUtilVector != null)
      {
        i = ((azzx)localObject).jdField_a_of_type_JavaUtilVector.size();
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int j = bhtq.b(36.0F);
        localURLDrawableOptions.mRequestWidth = j;
        localURLDrawableOptions.mRequestHeight = j;
        if (i != 1) {
          break label118;
        }
        localURLDrawable = URLDrawable.getDrawable((String)((azzx)localObject).jdField_a_of_type_JavaUtilVector.get(0), localURLDrawableOptions);
        parambiaw.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        parambiaw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    label118:
    while (i <= 1) {
      return;
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable((String)((azzx)localObject).jdField_a_of_type_JavaUtilVector.get(0), localURLDrawableOptions);
    localObject = URLDrawable.getDrawable((String)((azzx)localObject).jdField_a_of_type_JavaUtilVector.get(1), localURLDrawableOptions);
    parambiaw.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
    parambiaw.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    parambiaw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Azzx != null) {
      return this.jdField_a_of_type_Azzx.c;
    }
    return null;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Azzx != null) {
      return this.jdField_a_of_type_Azzx.d;
    }
    return "";
  }
  
  public void setInfoList(List<azzx> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    a(this.jdField_a_of_type_Biaw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ZanBannerView
 * JD-Core Version:    0.7.0.1
 */