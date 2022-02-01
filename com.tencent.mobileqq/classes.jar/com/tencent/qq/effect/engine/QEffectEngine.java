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
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new QEffectEngine();
      }
      return mInstance;
    }
    finally {}
  }
  
  public String getCacheFileDir(Context paramContext)
  {
    if (this.mCacheFileDir == null) {
      return paramContext.getExternalCacheDir().getAbsolutePath();
    }
    return this.mCacheFileDir;
  }
  
  public IQEffect getEffectView(Context paramContext, int paramInt)
  {
    Class localClass = (Class)this.mEffectMap.get(paramInt);
    if (localClass != null) {}
    try
    {
      paramContext = (IQEffect)localClass.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
      return paramContext;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (InstantiationException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public int getFileType(String paramString)
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.mFileTypeMap.size())
      {
        j = this.mFileTypeMap.keyAt(i);
        String str = (String)this.mFileTypeMap.get(j);
        if ((str == null) || (!str.equals(paramString))) {}
      }
      else
      {
        return j;
      }
      i += 1;
    }
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
    if (!paramIQEffect.isGravityEnable()) {}
    do
    {
      return;
      this.mSensorCount += 1;
      if (((paramIQEffect instanceof View)) && (!this.mGravitySensor.isInit())) {
        this.mGravitySensor.init(((View)paramIQEffect).getContext());
      }
    } while (!(paramIQEffect instanceof GravitySensor.GravitySensorListener));
    this.mGravitySensor.addListener((GravitySensor.GravitySensorListener)paramIQEffect);
  }
  
  public void onDetachedFromWindow(IQEffect paramIQEffect)
  {
    paramIQEffect.stop();
    if (!paramIQEffect.isGravityEnable()) {}
    int i;
    do
    {
      return;
      if ((paramIQEffect instanceof GravitySensor.GravitySensorListener)) {
        this.mGravitySensor.removeListener((GravitySensor.GravitySensorListener)paramIQEffect);
      }
      i = this.mSensorCount - 1;
      this.mSensorCount = i;
    } while ((i > 0) || (this.mGravitySensor == null));
    this.mSensorCount = 0;
    this.mGravitySensor.destroy();
  }
  
  public void registerEffect(int paramInt, String paramString, Class<? extends IQEffect> paramClass)
  {
    if (this.mEffectMap.get(paramInt) != null) {
      Log.e("QEffectEngine", paramInt + " is already register," + paramClass.getSimpleName() + " will override");
    }
    if (paramString.indexOf(",") > 0)
    {
      paramString = paramString.split("\\,");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        this.mFileTypeMap.put(paramInt, localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.engine.QEffectEngine
 * JD-Core Version:    0.7.0.1
 */