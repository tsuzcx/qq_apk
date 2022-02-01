package com.tencent.qq.effect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qq.effect.engine.Layout;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.engine.QEffectEngine;
import com.tencent.qq.effect.sensor.GravitySensor;
import com.tencent.qq.effect.utils.QEffectUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class QEffectView
  extends FrameLayout
{
  private String TAG = "QEffectView";
  private Context mContext;
  private String mDefImg;
  private IQEffect mIQEffect;
  private SparseArray<WeakReference<IQEffect>> mIQEffectViewMap;
  private SparseArray<Object> mOptions = new SparseArray();
  private String mSrc;
  
  public QEffectView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public QEffectView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public QEffectView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  private void loadEffectViews(List<QEffectData> paramList)
  {
    if (this.mIQEffectViewMap == null) {
      this.mIQEffectViewMap = new SparseArray();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QEffectData localQEffectData = (QEffectData)paramList.next();
      if ((localQEffectData.support == 0) || (localQEffectData.support == 109))
      {
        IQEffect localIQEffect = QEffectEngine.getInstance().getEffectView(this.mContext, localQEffectData.type);
        if (!(localIQEffect instanceof View))
        {
          Log.e(this.TAG, " effect is null, module mame is png, src:" + localQEffectData.src);
        }
        else
        {
          FrameLayout.LayoutParams localLayoutParams = Layout.getLayoutParams(getContext(), localQEffectData, getWidth(), getHeight());
          ((View)localIQEffect).setId(localQEffectData.effectId);
          addView((View)localIQEffect, localLayoutParams);
          if (this.mIQEffectViewMap.get(localQEffectData.effectId) != null) {
            Log.e(this.TAG, " ID duplicate, please check ID:" + localQEffectData.effectId);
          }
          this.mIQEffectViewMap.put(localQEffectData.effectId, new WeakReference(localIQEffect));
          QEffectEngine.getInstance().load(this.mContext, this, localIQEffect, localQEffectData);
          QEffectEngine.getInstance().onAttachedToWindow(localIQEffect);
        }
      }
    }
  }
  
  public void clear()
  {
    this.mSrc = null;
    if (this.mIQEffect != null)
    {
      QEffectEngine.getInstance().onDetachedFromWindow(this.mIQEffect);
      removeView((View)this.mIQEffect);
      ((View)this.mIQEffect).destroyDrawingCache();
    }
    if (this.mIQEffectViewMap != null)
    {
      int i = 0;
      while (i < this.mIQEffectViewMap.size())
      {
        WeakReference localWeakReference = (WeakReference)this.mIQEffectViewMap.valueAt(i);
        if ((localWeakReference != null) && (localWeakReference.get() != null))
        {
          ((IQEffect)localWeakReference.get()).stop();
          ((View)localWeakReference.get()).setBackgroundResource(0);
          removeView((View)localWeakReference.get());
          QEffectEngine.getInstance().onDetachedFromWindow((IQEffect)localWeakReference.get());
        }
        i += 1;
      }
      this.mIQEffectViewMap.clear();
    }
    removeAllViews();
  }
  
  public IQEffect findById(int paramInt)
  {
    WeakReference localWeakReference = (WeakReference)this.mIQEffectViewMap.get(paramInt);
    if (localWeakReference != null) {
      return (IQEffect)localWeakReference.get();
    }
    return null;
  }
  
  public Object getExtOptions(int paramInt)
  {
    return this.mOptions.get(paramInt);
  }
  
  public IQEffect getQEffectImpl()
  {
    return this.mIQEffect;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mOptions.clear();
    clear();
  }
  
  public void pause()
  {
    QEffectEngine.getInstance().getGravitySensor().pause();
    if (this.mIQEffect != null) {
      this.mIQEffect.pause();
    }
    if (this.mIQEffectViewMap != null)
    {
      int i = 0;
      while (i < this.mIQEffectViewMap.size())
      {
        WeakReference localWeakReference = (WeakReference)this.mIQEffectViewMap.valueAt(i);
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((IQEffect)localWeakReference.get()).pause();
        }
        i += 1;
      }
    }
  }
  
  public void resume()
  {
    QEffectEngine.getInstance().getGravitySensor().resume();
    if (this.mIQEffect != null) {
      this.mIQEffect.resume();
    }
    if (this.mIQEffectViewMap != null)
    {
      int i = 0;
      while (i < this.mIQEffectViewMap.size())
      {
        WeakReference localWeakReference = (WeakReference)this.mIQEffectViewMap.valueAt(i);
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((IQEffect)localWeakReference.get()).resume();
        }
        i += 1;
      }
    }
  }
  
  public void setExtOptions(int paramInt, Object paramObject)
  {
    this.mOptions.put(paramInt, paramObject);
  }
  
  public void setSrc(int paramInt)
  {
    setSrc(paramInt, null);
  }
  
  public void setSrc(int paramInt, String paramString)
  {
    setSrc(Integer.valueOf(paramInt), QEffectEngine.getInstance().getFileType(paramString), 3);
  }
  
  public void setSrc(QEffectData paramQEffectData)
  {
    clear();
    this.mIQEffect = QEffectEngine.getInstance().getEffectView(this.mContext, paramQEffectData.type);
    if (!(this.mIQEffect instanceof View)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = Layout.getLayoutParams(getContext(), paramQEffectData, getWidth(), getHeight());
    addView((View)this.mIQEffect, localLayoutParams);
    new QEffectView.DataLoadTask(this).execute(new QEffectData[] { paramQEffectData });
  }
  
  public void setSrc(Object paramObject, int paramInt1, int paramInt2)
  {
    clear();
    if ((paramInt1 == 6) && ((paramObject instanceof String)))
    {
      new QEffectView.QEFileAsyncTask(this).execute(new String[] { (String)paramObject });
      return;
    }
    if (QEffectEngine.getInstance() == null)
    {
      Log.e(this.TAG, " setSrc engine is null");
      return;
    }
    if (this.mIQEffect != null)
    {
      removeView((View)this.mIQEffect);
      this.mIQEffect = null;
    }
    this.mIQEffect = QEffectEngine.getInstance().getEffectView(this.mContext, paramInt1);
    if (!(this.mIQEffect instanceof View))
    {
      Log.e(this.TAG, " effect is null, module mame is png, src:" + paramObject);
      return;
    }
    QEffectData localQEffectData = new QEffectData();
    localQEffectData.type = paramInt1;
    localQEffectData.resType = paramInt2;
    localQEffectData.h = -1.0F;
    localQEffectData.w = -1.0F;
    if ((paramInt2 == 3) && ((paramObject instanceof Integer))) {
      localQEffectData.resId = ((Integer)paramObject).intValue();
    }
    for (;;)
    {
      setSrc(localQEffectData);
      return;
      localQEffectData.src = ((String)paramObject);
    }
  }
  
  public void setSrc(String paramString)
  {
    setSrc(paramString, null);
  }
  
  public void setSrc(String paramString1, String paramString2)
  {
    if (paramString1.equals(this.mSrc))
    {
      Log.e(this.TAG, " src重复设置，这次不会生效:" + paramString1);
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = QEffectUtils.getFileType(paramString1);
    }
    if (str == null)
    {
      Log.e(this.TAG, " setSrc fileType is null src:" + paramString1);
      return;
    }
    int i = QEffectUtils.getFileLoadType(paramString1);
    setSrc(paramString1, QEffectEngine.getInstance().getFileType(str), i);
    this.mSrc = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.QEffectView
 * JD-Core Version:    0.7.0.1
 */