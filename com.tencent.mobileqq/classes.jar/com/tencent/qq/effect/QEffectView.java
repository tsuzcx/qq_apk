package com.tencent.qq.effect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
        Object localObject1 = QEffectEngine.getInstance().getEffectView(this.mContext, localQEffectData.type);
        Object localObject2;
        if (!(localObject1 instanceof View))
        {
          localObject1 = this.TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" effect is null, module mame is png, src:");
          ((StringBuilder)localObject2).append(localQEffectData.src);
          Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject2 = Layout.getLayoutParams(getContext(), localQEffectData, getWidth(), getHeight());
          Object localObject3 = (View)localObject1;
          ((View)localObject3).setId(localQEffectData.effectId);
          addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
          if (this.mIQEffectViewMap.get(localQEffectData.effectId) != null)
          {
            localObject2 = this.TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(" ID duplicate, please check ID:");
            ((StringBuilder)localObject3).append(localQEffectData.effectId);
            Log.e((String)localObject2, ((StringBuilder)localObject3).toString());
          }
          this.mIQEffectViewMap.put(localQEffectData.effectId, new WeakReference(localObject1));
          QEffectEngine.getInstance().load(this.mContext, this, (IQEffect)localObject1, localQEffectData);
          QEffectEngine.getInstance().onAttachedToWindow((IQEffect)localObject1);
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
    Object localObject = this.mIQEffect;
    if (localObject != null) {
      ((IQEffect)localObject).pause();
    }
    if (this.mIQEffectViewMap != null)
    {
      int i = 0;
      while (i < this.mIQEffectViewMap.size())
      {
        localObject = (WeakReference)this.mIQEffectViewMap.valueAt(i);
        if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
          ((IQEffect)((WeakReference)localObject).get()).pause();
        }
        i += 1;
      }
    }
  }
  
  public void resume()
  {
    QEffectEngine.getInstance().getGravitySensor().resume();
    Object localObject = this.mIQEffect;
    if (localObject != null) {
      ((IQEffect)localObject).resume();
    }
    if (this.mIQEffectViewMap != null)
    {
      int i = 0;
      while (i < this.mIQEffectViewMap.size())
      {
        localObject = (WeakReference)this.mIQEffectViewMap.valueAt(i);
        if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
          ((IQEffect)((WeakReference)localObject).get()).resume();
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
    Object localObject = this.mIQEffect;
    if (localObject != null)
    {
      removeView((View)localObject);
      this.mIQEffect = null;
    }
    this.mIQEffect = QEffectEngine.getInstance().getEffectView(this.mContext, paramInt1);
    if (!(this.mIQEffect instanceof View))
    {
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" effect is null, module mame is png, src:");
      localStringBuilder.append(paramObject);
      Log.e((String)localObject, localStringBuilder.toString());
      return;
    }
    localObject = new QEffectData();
    ((QEffectData)localObject).type = paramInt1;
    ((QEffectData)localObject).resType = paramInt2;
    ((QEffectData)localObject).h = -1.0F;
    ((QEffectData)localObject).w = -1.0F;
    if ((paramInt2 == 3) && ((paramObject instanceof Integer))) {
      ((QEffectData)localObject).resId = ((Integer)paramObject).intValue();
    } else {
      ((QEffectData)localObject).src = ((String)paramObject);
    }
    setSrc((QEffectData)localObject);
  }
  
  public void setSrc(String paramString)
  {
    setSrc(paramString, null);
  }
  
  public void setSrc(String paramString1, String paramString2)
  {
    if (paramString1.equals(this.mSrc))
    {
      paramString2 = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" src重复设置，这次不会生效:");
      ((StringBuilder)localObject).append(paramString1);
      Log.e(paramString2, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = QEffectUtils.getFileType(paramString1);
    }
    if (localObject == null)
    {
      paramString2 = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" setSrc fileType is null src:");
      ((StringBuilder)localObject).append(paramString1);
      Log.e(paramString2, ((StringBuilder)localObject).toString());
      return;
    }
    int i = QEffectUtils.getFileLoadType(paramString1);
    setSrc(paramString1, QEffectEngine.getInstance().getFileType((String)localObject), i);
    this.mSrc = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.QEffectView
 * JD-Core Version:    0.7.0.1
 */