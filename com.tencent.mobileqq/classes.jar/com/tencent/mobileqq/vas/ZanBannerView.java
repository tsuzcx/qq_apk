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
import auwv;
import bbll;
import bbsl;
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
  private auwv jdField_a_of_type_Auwv;
  private bbsl jdField_a_of_type_Bbsl;
  private List<auwv> jdField_a_of_type_JavaUtilList;
  
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
  
  private auwv a()
  {
    if (a()) {
      return null;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    this.jdField_a_of_type_Auwv = ((auwv)localList.get(i % this.jdField_a_of_type_JavaUtilList.size()));
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int).commit();
    return this.jdField_a_of_type_Auwv;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131561528, null));
    this.jdField_a_of_type_Bbsl = new bbsl(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Int = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt(jdField_a_of_type_JavaLangString, 0);
    if (this.jdField_a_of_type_Int > 100) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  private void a(bbsl parambbsl)
  {
    Object localObject = a();
    int i;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (localObject != null)
    {
      parambbsl.jdField_a_of_type_AndroidWidgetTextView.setText(((auwv)localObject).jdField_a_of_type_JavaLangString);
      parambbsl.jdField_b_of_type_AndroidWidgetTextView.setText(((auwv)localObject).b);
      if (((auwv)localObject).jdField_a_of_type_JavaUtilVector != null)
      {
        i = ((auwv)localObject).jdField_a_of_type_JavaUtilVector.size();
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int j = bbll.b(36.0F);
        localURLDrawableOptions.mRequestWidth = j;
        localURLDrawableOptions.mRequestHeight = j;
        if (i != 1) {
          break label118;
        }
        localURLDrawable = URLDrawable.getDrawable((String)((auwv)localObject).jdField_a_of_type_JavaUtilVector.get(0), localURLDrawableOptions);
        parambbsl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        parambbsl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    label118:
    while (i <= 1) {
      return;
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable((String)((auwv)localObject).jdField_a_of_type_JavaUtilVector.get(0), localURLDrawableOptions);
    localObject = URLDrawable.getDrawable((String)((auwv)localObject).jdField_a_of_type_JavaUtilVector.get(1), localURLDrawableOptions);
    parambbsl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
    parambbsl.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    parambbsl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Auwv != null) {
      return this.jdField_a_of_type_Auwv.c;
    }
    return null;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Auwv != null) {
      return this.jdField_a_of_type_Auwv.d;
    }
    return "";
  }
  
  public void setInfoList(List<auwv> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    a(this.jdField_a_of_type_Bbsl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ZanBannerView
 * JD-Core Version:    0.7.0.1
 */