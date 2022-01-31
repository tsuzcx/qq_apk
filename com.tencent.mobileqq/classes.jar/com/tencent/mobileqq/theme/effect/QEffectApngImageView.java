package com.tencent.mobileqq.theme.effect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import aymv;
import bbql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.impls.QEffectImageView;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;

@SuppressLint({"AppCompatCustomView"})
public class QEffectApngImageView
  extends QEffectImageView
{
  private aymv jdField_a_of_type_Aymv;
  private final String jdField_a_of_type_JavaLangString = "QEffectApngImageView";
  
  public QEffectApngImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static aymv a(int[] paramArrayOfInt, String paramString)
  {
    aymv localaymv = new aymv();
    localaymv.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    localaymv.b = paramString;
    localaymv.jdField_a_of_type_JavaLangString = paramString;
    return localaymv;
  }
  
  public void load(Context paramContext, QEffectView paramQEffectView, IQEffectLoad paramIQEffectLoad, QEffectData paramQEffectData)
  {
    this.mEffectData = paramQEffectData;
    if (this.mEffectData != null) {
      this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
    }
    if (QEffectUtils.isEmpty(paramQEffectData.src))
    {
      Log.e("QEffectApngImageView", " load data.src is null ");
      return;
    }
    paramContext = paramQEffectView.getExtOptions(paramQEffectData.type);
    if ((paramContext != null) && ((paramContext instanceof aymv))) {
      this.jdField_a_of_type_Aymv = ((aymv)paramQEffectView.getExtOptions(paramQEffectData.type));
    }
    for (;;)
    {
      paramContext = new Bundle();
      paramContext.putBoolean("key_double_bitmap", true);
      paramContext = bbql.a(BaseApplicationImpl.sApplication.getRuntime(), paramQEffectData.src, this.jdField_a_of_type_Aymv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aymv.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Aymv.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Aymv.b, paramContext);
      if (paramContext != null) {
        break;
      }
      Log.e("QEffectApngImageView", " load apng is null" + paramQEffectData.repeat);
      return;
      this.jdField_a_of_type_Aymv = new aymv();
      this.jdField_a_of_type_Aymv.jdField_a_of_type_JavaLangString = String.valueOf(paramQEffectData.effectId);
      this.jdField_a_of_type_Aymv.b = String.valueOf(paramQEffectData.effectId);
      this.jdField_a_of_type_Aymv.jdField_a_of_type_ArrayOfInt = new int[] { paramQEffectData.effectId };
    }
    if ((paramContext.getCurrDrawable() instanceof ApngDrawable)) {
      ((ApngDrawable)paramContext.getCurrDrawable()).getImage().apngLoop = paramQEffectData.repeat;
    }
    complete(paramContext);
  }
  
  public void pause()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Aymv.jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      ApngImage.pauseByTag(arrayOfInt[i]);
      i += 1;
    }
  }
  
  public void resume()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Aymv.jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      ApngImage.playByTag(arrayOfInt[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.effect.QEffectApngImageView
 * JD-Core Version:    0.7.0.1
 */