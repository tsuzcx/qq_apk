package com.tencent.qq.effect.engine;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.tencent.qq.effect.BaseQEffectLoad;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.impls.QEffectImageView;
import com.tencent.qq.effect.impls.QEffectVideoAlphaView;
import com.tencent.qq.effect.impls.QEffectVideoView;
import com.tencent.qq.effect.sensor.GravitySensor;
import com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class QEffectEngine
{
  private static volatile QEffectEngine mInstance;
  private final String TAG = "QEffectEngine";
  private String mCacheFileDir;
  private SparseArray<Class<? extends IQEffect>> mEffectMap = new SparseArray();
  private SparseArray<String> mFileTypeMap = new SparseArray();
  private GravitySensor mGravitySensor = new GravitySensor();
  private QEffectEngine.JsonConvert mJsonConvert;
  private IQEffectLoad mLoad;
  private int mSensorCount = 0;
  
  private QEffectEngine()
  {
    init();
  }
  
  public static QEffectEngine getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new QEffectEngine();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public String getCacheFileDir(Context paramContext)
  {
    String str = this.mCacheFileDir;
    if (str == null) {
      return paramContext.getExternalCacheDir().getAbsolutePath();
    }
    return str;
  }
  
  public IQEffect getEffectView(Context paramContext, int paramInt)
  {
    Class localClass = (Class)this.mEffectMap.get(paramInt);
    if (localClass != null) {
      try
      {
        paramContext = (IQEffect)localClass.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
        return paramContext;
      }
      catch (InvocationTargetException paramContext)
      {
        paramContext.printStackTrace();
      }
      catch (NoSuchMethodException paramContext)
      {
        paramContext.printStackTrace();
      }
      catch (InstantiationException paramContext)
      {
        paramContext.printStackTrace();
      }
      catch (IllegalAccessException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public int getFileType(String paramString)
  {
    int i = 0;
    while (i < this.mFileTypeMap.size())
    {
      int j = this.mFileTypeMap.keyAt(i);
      String str = (String)this.mFileTypeMap.get(j);
      if ((str != null) && (str.equals(paramString))) {
        return j;
      }
      i += 1;
    }
    return 0;
  }
  
  public GravitySensor getGravitySensor()
  {
    return this.mGravitySensor;
  }
  
  public QEffectEngine.JsonConvert getJsonConvert()
  {
    return this.mJsonConvert;
  }
  
  protected void init()
  {
    registerEffect(1, "png,jpg", QEffectImageView.class);
    registerEffect(4, "mp4", QEffectVideoView.class);
    registerEffect(5, "alpha.mp4", QEffectVideoAlphaView.class);
    registerEffect(6, "zip", QEffectImageView.class);
    registerLoad(new BaseQEffectLoad());
  }
  
  public void load(Context paramContext, QEffectView paramQEffectView, IQEffect paramIQEffect, QEffectData paramQEffectData)
  {
    paramIQEffect.load(paramContext, paramQEffectView, this.mLoad, paramQEffectData);
  }
  
  public void onAttachedToWindow(IQEffect paramIQEffect)
  {
    if (!paramIQEffect.isGravityEnable()) {
      return;
    }
    this.mSensorCount += 1;
    if (((paramIQEffect instanceof View)) && (!this.mGravitySensor.isInit())) {
      this.mGravitySensor.init(((View)paramIQEffect).getContext());
    }
    if ((paramIQEffect instanceof GravitySensor.GravitySensorListener)) {
      this.mGravitySensor.addListener((GravitySensor.GravitySensorListener)paramIQEffect);
    }
  }
  
  public void onDetachedFromWindow(IQEffect paramIQEffect)
  {
    paramIQEffect.stop();
    if (!paramIQEffect.isGravityEnable()) {
      return;
    }
    if ((paramIQEffect instanceof GravitySensor.GravitySensorListener)) {
      this.mGravitySensor.removeListener((GravitySensor.GravitySensorListener)paramIQEffect);
    }
    int i = this.mSensorCount - 1;
    this.mSensorCount = i;
    if (i <= 0)
    {
      paramIQEffect = this.mGravitySensor;
      if (paramIQEffect != null)
      {
        this.mSensorCount = 0;
        paramIQEffect.destroy();
      }
    }
  }
  
  public void registerEffect(int paramInt, String paramString, Class<? extends IQEffect> paramClass)
  {
    StringBuilder localStringBuilder;
    if (this.mEffectMap.get(paramInt) != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is already register,");
      localStringBuilder.append(paramClass.getSimpleName());
      localStringBuilder.append(" will override");
      Log.e("QEffectEngine", localStringBuilder.toString());
    }
    if (paramString.indexOf(",") > 0)
    {
      paramString = paramString.split("\\,");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder = paramString[i];
        this.mFileTypeMap.put(paramInt, localStringBuilder);
        i += 1;
      }
    }
    this.mFileTypeMap.put(paramInt, paramString);
    this.mEffectMap.put(paramInt, paramClass);
  }
  
  public void registerLoad(IQEffectLoad paramIQEffectLoad)
  {
    this.mLoad = paramIQEffectLoad;
  }
  
  public void setCacheFileDir(String paramString)
  {
    this.mCacheFileDir = paramString;
  }
  
  public void setJsonConvert(QEffectEngine.JsonConvert paramJsonConvert)
  {
    this.mJsonConvert = paramJsonConvert;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.engine.QEffectEngine
 * JD-Core Version:    0.7.0.1
 */