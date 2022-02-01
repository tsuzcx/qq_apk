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
  public static final int[] a = { 8, 18, 88, 888 };
  public static final float[] b = { 0.2786667F, 0.1706667F, 0.1706667F, 0.09066667F };
  CustomFrameAnimationDrawable c;
  ImageView d;
  ImageView e;
  ComboObject f;
  private MqqHandler g;
  private BaseQQAppInterface h;
  private ComboUIManager i;
  
  public ComboEggView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static final boolean a(int paramInt)
  {
    int j = 0;
    for (;;)
    {
      int[] arrayOfInt = a;
      if (j >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[j]) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public void a()
  {
    if (this.i != null)
    {
      this.c.m();
      this.i.a(this);
    }
    this.g.removeCallbacksAndMessages(null);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = this.c;
      if (localCustomFrameAnimationDrawable != null)
      {
        localCustomFrameAnimationDrawable.g();
        this.c.m();
      }
      paramViewGroup.removeView(this);
    }
    this.g.removeCallbacksAndMessages(null);
  }
  
  public void a(ComboUIManager paramComboUIManager, BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.h = paramBaseQQAppInterface;
    this.e = ((ImageView)findViewById(2131427946));
    this.d = ((ImageView)findViewById(2131427945));
    this.g = new MqqHandler(ThreadManager.getFileThreadLooper());
    this.i = paramComboUIManager;
    this.f = new ComboObject(null, 0);
  }
  
  public boolean a(ComboObject paramComboObject)
  {
    this.f = paramComboObject;
    int j = 0;
    while (j < a.length)
    {
      if (paramComboObject.b == a[j]) {
        break label39;
      }
      j += 1;
    }
    j = -1;
    label39:
    if (j == -1) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramComboObject.a)) && (this.e.getVisibility() == 0)) {
      this.e.setImageDrawable(FaceDrawable.getFaceDrawable(this.h, 1, paramComboObject.a));
    }
    int k = getContext().getResources().getDisplayMetrics().widthPixels;
    int m = getContext().getResources().getDisplayMetrics().heightPixels;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    float f1 = k;
    localLayoutParams.setMargins((int)(b[j] * f1), 0, 0, 0);
    j = (int)(f1 * 0.1573333F);
    localLayoutParams.width = j;
    localLayoutParams.height = j;
    File[] arrayOfFile = ComboResource.a(paramComboObject.b);
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
    this.c = new CustomFrameAnimationDrawable(this.h.getApp().getResources(), paramComboObject, this.g);
    j = 1;
    while (j < arrayOfFile.length)
    {
      this.c.a(j - 1, 77, arrayOfFile[j].getAbsolutePath());
      j += 1;
    }
    return true;
  }
  
  public void b()
  {
    this.c.i();
    this.c.a(this);
    this.d.setImageDrawable(this.c);
    this.c.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboEggView
 * JD-Core Version:    0.7.0.1
 */