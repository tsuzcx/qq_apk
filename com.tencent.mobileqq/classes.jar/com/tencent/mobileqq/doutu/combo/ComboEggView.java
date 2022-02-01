package com.tencent.mobileqq.doutu.combo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.AnimationEndListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class ComboEggView
  extends RelativeLayout
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  public static final float[] a;
  public static final int[] a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  CustomFrameAnimationDrawable jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  ComboObject jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject;
  private ComboUIManager jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  ImageView b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 8, 18, 88, 888 };
    jdField_a_of_type_ArrayOfFloat = new float[] { 0.2786667F, 0.1706667F, 0.1706667F, 0.09066667F };
  }
  
  public ComboEggView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static final boolean a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.j();
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager.a(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
      if (localCustomFrameAnimationDrawable != null)
      {
        localCustomFrameAnimationDrawable.g();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.j();
      }
      paramViewGroup.removeView(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(ComboUIManager paramComboUIManager, BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.b = ((ImageView)findViewById(2131362346));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362345));
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getFileThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager = paramComboUIManager;
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject = new ComboObject(null, 0);
  }
  
  public boolean a(ComboObject paramComboObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject = paramComboObject;
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      if (paramComboObject.jdField_a_of_type_Int == jdField_a_of_type_ArrayOfInt[i]) {
        break label39;
      }
      i += 1;
    }
    i = -1;
    label39:
    if (i == -1) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramComboObject.jdField_a_of_type_JavaLangString)) && (this.b.getVisibility() == 0)) {
      this.b.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, 1, paramComboObject.jdField_a_of_type_JavaLangString));
    }
    int j = getContext().getResources().getDisplayMetrics().widthPixels;
    int k = getContext().getResources().getDisplayMetrics().heightPixels;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    float f = j;
    localLayoutParams.setMargins((int)(jdField_a_of_type_ArrayOfFloat[i] * f), 0, 0, 0);
    i = (int)(f * 0.1573333F);
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    File[] arrayOfFile = ComboResource.a(paramComboObject.jdField_a_of_type_Int);
    if (arrayOfFile == null) {
      return false;
    }
    paramComboObject = new BitmapFactory.Options();
    paramComboObject.inSampleSize = 1;
    paramComboObject.inMutable = true;
    String str = arrayOfFile[0].getAbsolutePath();
    localLayoutParams = null;
    try
    {
      paramComboObject = BaseImageUtil.a(str, paramComboObject);
    }
    catch (OutOfMemoryError paramComboObject)
    {
      label221:
      break label221;
    }
    paramComboObject = localLayoutParams;
    if (QLog.isColorLevel())
    {
      QLog.d("ComboUIManager", 2, " ComboEggView play first bmp oom");
      paramComboObject = localLayoutParams;
    }
    if (paramComboObject == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = new CustomFrameAnimationDrawable(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApp().getResources(), paramComboObject, this.jdField_a_of_type_MqqOsMqqHandler);
    i = 1;
    while (i < arrayOfFile.length)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(i - 1, 77, arrayOfFile[i].getAbsolutePath());
      i += 1;
    }
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboEggView
 * JD-Core Version:    0.7.0.1
 */