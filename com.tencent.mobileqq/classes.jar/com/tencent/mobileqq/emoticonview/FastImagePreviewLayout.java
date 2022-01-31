package com.tencent.mobileqq.emoticonview;

import abyw;
import abyx;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class FastImagePreviewLayout
  extends LinearLayout
{
  public static String a;
  float a;
  public long a;
  public Context a;
  public URLDrawable a;
  public MqqHandler a;
  final String b = "/tencent/zebra/cache/";
  
  static
  {
    jdField_a_of_type_JavaLangString = FastImagePreviewLayout.class.getSimpleName();
  }
  
  public FastImagePreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "showFastImage called, path = " + PlusPanelUtils.b);
    }
    removeAllViews();
    Object localObject = inflate(this.jdField_a_of_type_AndroidContentContext, 2130968637, null);
    ((ImageView)((View)localObject).findViewById(2131362968)).setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    addView((View)localObject);
    setVisibility(0);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    setAnimation((Animation)localObject);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    startAnimation((Animation)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "removeFastImage called");
    }
    setVisibility(8);
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      setAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      startAnimation(localAlphaAnimation);
      localAlphaAnimation.setAnimationListener(new abyw(this));
      return;
    }
    removeAllViews();
  }
  
  public void b()
  {
    ThreadManager.getSubThreadHandler().post(new abyx(this));
  }
  
  public void setHandler(MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FastImagePreviewLayout
 * JD-Core Version:    0.7.0.1
 */