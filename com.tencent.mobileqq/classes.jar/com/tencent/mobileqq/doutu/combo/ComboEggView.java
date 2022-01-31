package com.tencent.mobileqq.doutu.combo;

import afkw;
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
import apkj;
import apkk;
import apkm;
import bdbk;
import bdhj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class ComboEggView
  extends RelativeLayout
  implements afkw
{
  public static final float[] a;
  public static final int[] a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public apkj a;
  private apkm jdField_a_of_type_Apkm;
  CustomFrameAnimationDrawable jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < jdField_a_of_type_ArrayOfInt.length)
      {
        if (paramInt == jdField_a_of_type_ArrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apkm != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.j();
      this.jdField_a_of_type_Apkm.a(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.g();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.j();
      }
      paramViewGroup.removeView(this);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(apkm paramapkm, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = ((ImageView)findViewById(2131362264));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362263));
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getFileThreadLooper());
    this.jdField_a_of_type_Apkm = paramapkm;
    this.jdField_a_of_type_Apkj = new apkj(null, 0);
  }
  
  public boolean a(apkj paramapkj)
  {
    this.jdField_a_of_type_Apkj = paramapkj;
    int i = 0;
    if (i < jdField_a_of_type_ArrayOfInt.length) {
      if (paramapkj.jdField_a_of_type_Int != jdField_a_of_type_ArrayOfInt[i]) {}
    }
    for (;;)
    {
      if (i == -1) {}
      for (;;)
      {
        return false;
        i += 1;
        break;
        if ((!TextUtils.isEmpty(paramapkj.jdField_a_of_type_JavaLangString)) && (this.b.getVisibility() == 0)) {
          this.b.setImageDrawable(bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramapkj.jdField_a_of_type_JavaLangString));
        }
        int j = getContext().getResources().getDisplayMetrics().widthPixels;
        int k = getContext().getResources().getDisplayMetrics().heightPixels;
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
        float f = j;
        localLayoutParams.setMargins((int)(jdField_a_of_type_ArrayOfFloat[i] * f), 0, 0, 0);
        localLayoutParams.width = ((int)(j * 0.1573333F));
        localLayoutParams.height = ((int)(j * 0.1573333F));
        File[] arrayOfFile = apkk.a(paramapkj.jdField_a_of_type_Int);
        if (arrayOfFile != null)
        {
          paramapkj = new BitmapFactory.Options();
          paramapkj.inSampleSize = 1;
          paramapkj.inMutable = true;
          String str = arrayOfFile[0].getAbsolutePath();
          localLayoutParams = null;
          try
          {
            paramapkj = bdhj.a(str, paramapkj);
            if (paramapkj != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = new CustomFrameAnimationDrawable(BaseApplicationImpl.getContext().getResources(), paramapkj, this.jdField_a_of_type_MqqOsMqqHandler);
              i = 1;
              while (i < arrayOfFile.length)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(i - 1, 77, arrayOfFile[i].getAbsolutePath());
                i += 1;
              }
            }
          }
          catch (OutOfMemoryError paramapkj)
          {
            for (;;)
            {
              paramapkj = localLayoutParams;
              if (QLog.isColorLevel())
              {
                QLog.d("ComboUIManager", 2, " ComboEggView play first bmp oom");
                paramapkj = localLayoutParams;
              }
            }
          }
        }
      }
      return true;
      i = -1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboEggView
 * JD-Core Version:    0.7.0.1
 */