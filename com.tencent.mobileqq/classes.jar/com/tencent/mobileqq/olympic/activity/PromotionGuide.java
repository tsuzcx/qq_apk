package com.tencent.mobileqq.olympic.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionPath;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

public class PromotionGuide
{
  static final String jdField_a_of_type_JavaLangString;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  private PromotionGuide.OnPromotionStatusListener jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide$OnPromotionStatusListener;
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PromotionUtil.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_Guide");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public PromotionGuide(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131381191));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131381192));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131381190));
  }
  
  private boolean a()
  {
    PromotionGuide.OnPromotionStatusListener localOnPromotionStatusListener = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide$OnPromotionStatusListener;
    return (localOnPromotionStatusListener == null) || ((localOnPromotionStatusListener != null) && (!localOnPromotionStatusListener.j_()));
  }
  
  public void a(int paramInt)
  {
    boolean bool = a();
    int i = 1;
    StringBuilder localStringBuilder;
    if (bool)
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showText, isDestroyed, textIndex[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide$OnPromotionStatusListener;
    if (localObject == null)
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showText, mPromotionRes为null, textIndex[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    localObject = ((PromotionGuide.OnPromotionStatusListener)localObject).a();
    if (localObject != null)
    {
      localObject = ((PromotionConfigInfo.PromotionItem)localObject).a(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramInt = i;
        break label166;
      }
    }
    paramInt = 0;
    label166:
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramInt != 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    if (paramInt != 0)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(this.jdField_a_of_type_AndroidWidgetImageView.getVisibility());
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    paramAppInterface = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramAppInterface != null) {
      paramAppInterface.setImageDrawable(null);
    }
    paramAppInterface = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (paramAppInterface != null)
    {
      paramAppInterface.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
    }
  }
  
  public void a(PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadRes, hadLoad[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (a()) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    localObject = this.jdField_a_of_type_AndroidAppActivity.getResources();
    int i = ((Resources)localObject).getDisplayMetrics().densityDpi;
    int j = ((Resources)localObject).getDisplayMetrics().densityDpi;
    paramPromotionItem = PromotionPath.b(paramPromotionItem);
    if (TextUtils.isEmpty(paramPromotionItem))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "PromotionGuide, path is null");
      return;
    }
    if (!new File(paramPromotionItem).exists())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "PromotionGuide, file not exist");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramPromotionItem);
    ((StringBuilder)localObject).append("guide.json");
    localObject = ((StringBuilder)localObject).toString();
    paramPromotionItem = new PromotionGuide.1(this, paramPromotionItem, i, j);
    try
    {
      LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_AndroidAppActivity, new FileInputStream((String)localObject), paramPromotionItem);
      return;
    }
    catch (Exception paramPromotionItem)
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadWorldCupGuideAnimation failed. err = ");
      localStringBuilder.append(paramPromotionItem.getMessage());
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void a(PromotionGuide.OnPromotionStatusListener paramOnPromotionStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionGuide$OnPromotionStatusListener = paramOnPromotionStatusListener;
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(this.jdField_a_of_type_AndroidWidgetTextView.getVisibility());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionGuide
 * JD-Core Version:    0.7.0.1
 */