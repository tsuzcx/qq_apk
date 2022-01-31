package com.tencent.tavsticker.core;

import android.content.Context;
import android.opengl.EGLContext;
import android.support.annotation.MainThread;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.ScreenUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TAVStickerContext
  extends TAVStickerRenderContext
{
  private static final String TAG = TAVStickerContext.class.getSimpleName();
  private Context mContext = null;
  private TAVSticker mCurrentSticker = null;
  private ITAVStickerContextDataSource mDataSource = null;
  private TAVStickerContentView.DispatchTouchEventListener mDispatchTouchEventListener = new TAVStickerContext.1(this);
  private List<WeakReference<ITAVStickerContextObserver>> mObserverRefs = new ArrayList();
  private TAVStickerContext.OnTouchStickerOutsideListener mOnTouchStickerOutsideListener = null;
  private ViewGroup mStickerContainer = null;
  private TAVStickerContentView mStickerContainerView = null;
  private Map<String, TAVStickerEditView> mStickerViewCacheMap = new HashMap();
  private boolean touchable = true;
  
  public TAVStickerContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void checkObserverList()
  {
    if (this.mObserverRefs == null) {
      this.mObserverRefs = new ArrayList();
    }
  }
  
  private void checkStickerViewCacheMap()
  {
    if (this.mStickerViewCacheMap == null) {
      this.mStickerViewCacheMap = new HashMap();
    }
  }
  
  private int getContainerHeight()
  {
    int j = getTavStickerContentViewSafely().getHeight();
    int i = j;
    if (j <= 0) {
      i = ScreenUtil.getScreenHeight();
    }
    return i;
  }
  
  private int getContainerWidth()
  {
    int j = getTavStickerContentViewSafely().getWidth();
    int i = j;
    if (j <= 0) {
      i = ScreenUtil.getScreenWidth();
    }
    return i;
  }
  
  private TAVStickerContentView getTavStickerContentViewSafely()
  {
    if (this.mStickerContainerView == null)
    {
      this.mStickerContainerView = new TAVStickerContentView(this.mContext);
      this.mStickerContainerView.setDispatchTouchEventListener(this.mDispatchTouchEventListener);
    }
    return this.mStickerContainerView;
  }
  
  private void notifyCurrentStickerStateChanged(boolean paramBoolean)
  {
    checkObserverList();
    Iterator localIterator = this.mObserverRefs.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((ITAVStickerContextObserver)localWeakReference.get()).onCurrentStickerStateChanged(this, paramBoolean);
      }
    }
  }
  
  private void notifyStickerActive(TAVStickerEditView paramTAVStickerEditView)
  {
    checkObserverList();
    Iterator localIterator = this.mObserverRefs.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((ITAVStickerContextObserver)localWeakReference.get()).onStickerActive(this, paramTAVStickerEditView);
      }
    }
  }
  
  private void notifyStickerAdd(TAVStickerEditView paramTAVStickerEditView)
  {
    checkObserverList();
    Iterator localIterator = this.mObserverRefs.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((ITAVStickerContextObserver)localWeakReference.get()).onStickerAdd(this, paramTAVStickerEditView);
      }
    }
  }
  
  private void notifyStickerListChanged()
  {
    checkObserverList();
    Iterator localIterator = this.mObserverRefs.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((ITAVStickerContextObserver)localWeakReference.get()).onStickerListChanged(this);
      }
    }
  }
  
  private void notifyStickerRemove(TAVStickerEditView paramTAVStickerEditView)
  {
    checkObserverList();
    Iterator localIterator = this.mObserverRefs.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((ITAVStickerContextObserver)localWeakReference.get()).onStickerRemove(this, paramTAVStickerEditView);
      }
    }
  }
  
  private void notifyStickerResign(TAVStickerEditView paramTAVStickerEditView)
  {
    checkObserverList();
    Iterator localIterator = this.mObserverRefs.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((ITAVStickerContextObserver)localWeakReference.get()).onStickerResign(this, paramTAVStickerEditView);
      }
    }
  }
  
  private void renderStickerEditView(long paramLong)
  {
    TAVStickerEditView localTAVStickerEditView = getCurrentStickerEditView();
    if ((localTAVStickerEditView != null) && (this.mCurrentSticker != null)) {
      if (!shouldShowSticker(this.mCurrentSticker, paramLong)) {
        break label59;
      }
    }
    label59:
    for (int i = 0;; i = 4)
    {
      if (i != localTAVStickerEditView.getVisibility()) {
        localTAVStickerEditView.post(new TAVStickerContext.2(this, localTAVStickerEditView, i));
      }
      return;
    }
  }
  
  private void resignStickerInner(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    if (paramTAVSticker != null)
    {
      paramTAVSticker.setMode(TAVStickerMode.INACTIVE);
      getTavStickerContentViewSafely().removeAllViews();
      paramTAVSticker = paramTAVSticker.getUniqueId();
      checkStickerViewCacheMap();
      paramTAVSticker = (TAVStickerEditView)this.mStickerViewCacheMap.get(paramTAVSticker);
      if (paramTAVSticker != null) {
        paramTAVSticker.setMode(TAVStickerMode.INACTIVE);
      }
      this.mCurrentSticker = null;
      notifyStickerResign(paramTAVSticker);
      if (paramBoolean) {
        notifyCurrentStickerStateChanged(false);
      }
      syncAllChildContext();
    }
  }
  
  private boolean shouldShowSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    if (paramTAVSticker == null) {}
    do
    {
      return false;
      if (this.mRenderContextDataSource != null) {
        return this.mRenderContextDataSource.shouldRenderSticker(paramTAVSticker, paramLong);
      }
    } while ((!TAVStickerUtil.isPresentationTimeInStickerTimeRange(paramLong, paramTAVSticker)) || (TAVStickerMode.ACTIVE != paramTAVSticker.getMode()));
    return true;
  }
  
  private void updateAllStickerLayerIndex()
  {
    checkStickerList();
    this.mStickerLayerIndex = 0;
    Iterator localIterator = this.mStickers.iterator();
    while (localIterator.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
      if ((localTAVSticker != null) && (-1 == localTAVSticker.getLayerIndex()))
      {
        int i = this.mStickerLayerIndex;
        this.mStickerLayerIndex = (i + 1);
        localTAVSticker.setLayerIndex(i);
      }
    }
  }
  
  @MainThread
  public void activeSticker(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null)
    {
      if ((this.mCurrentSticker != null) && (!paramTAVSticker.equals(this.mCurrentSticker))) {
        resignStickerInner(this.mCurrentSticker, false);
      }
      paramTAVSticker.setMode(TAVStickerMode.ACTIVE);
      this.mCurrentSticker = paramTAVSticker;
      checkStickerViewCacheMap();
      Object localObject = paramTAVSticker.getUniqueId();
      localObject = (TAVStickerEditView)this.mStickerViewCacheMap.get(localObject);
      if (localObject != null)
      {
        getTavStickerContentViewSafely().removeAllViews();
        getTavStickerContentViewSafely().addView((View)localObject);
        ((TAVStickerEditView)localObject).setMode(TAVStickerMode.ACTIVE);
        if (paramTAVSticker.isAutoPlay()) {
          ((TAVStickerEditView)localObject).play(0);
        }
        notifyStickerActive((TAVStickerEditView)localObject);
      }
      notifyCurrentStickerStateChanged(true);
      syncAllChildContext();
    }
  }
  
  public TAVStickerEditView fetchStickerView(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker == null) {
      return null;
    }
    checkStickerViewCacheMap();
    return (TAVStickerEditView)this.mStickerViewCacheMap.get(paramTAVSticker.getUniqueId());
  }
  
  public TAVSticker getCurrentSticker()
  {
    return this.mCurrentSticker;
  }
  
  public TAVStickerEditView getCurrentStickerEditView()
  {
    return fetchStickerView(this.mCurrentSticker);
  }
  
  protected TAVSticker getTouchedSticker(float paramFloat1, float paramFloat2)
  {
    if ((this.mCurrentSticker != null) && (TAVStickerUtil.isPresentationTimeInStickerTimeRange(this.mPresentationTimeMs, this.mCurrentSticker)) && (this.mCurrentSticker.isEditable()) && (isTouchOnTavSticker(this.mCurrentSticker, paramFloat1, paramFloat2))) {
      return this.mCurrentSticker;
    }
    return super.getTouchedSticker(paramFloat1, paramFloat2);
  }
  
  public boolean isTouchable()
  {
    return this.touchable;
  }
  
  @MainThread
  public void loadSticker(TAVSticker paramTAVSticker)
  {
    loadSticker(paramTAVSticker, true);
  }
  
  @MainThread
  public void loadSticker(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    String str;
    if (paramTAVSticker != null)
    {
      checkStickerViewCacheMap();
      str = paramTAVSticker.getUniqueId();
      if (!this.mStickerViewCacheMap.containsKey(paramTAVSticker.getUniqueId())) {}
    }
    else
    {
      return;
    }
    if ((this.mCurrentSticker != null) && (!paramTAVSticker.equals(this.mCurrentSticker))) {
      resignStickerInner(this.mCurrentSticker, false);
    }
    super.loadSticker(paramTAVSticker, paramBoolean);
    Object localObject1;
    label84:
    label108:
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = TAVStickerMode.ACTIVE;
      paramTAVSticker.setMode((TAVStickerMode)localObject1);
      if (!paramBoolean) {
        break label210;
      }
      localObject1 = paramTAVSticker;
      this.mCurrentSticker = ((TAVSticker)localObject1);
      if (this.mDataSource == null) {
        break label215;
      }
      localObject1 = this.mDataSource.loadSticker(this, paramTAVSticker);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new TAVStickerEditView(this.mContext, paramTAVSticker);
      }
      this.mStickerViewCacheMap.put(str, localObject2);
      if (!paramBoolean) {
        break label229;
      }
      paramTAVSticker = TAVStickerMode.ACTIVE;
      label151:
      ((TAVStickerEditView)localObject2).setMode(paramTAVSticker);
      getTavStickerContentViewSafely().removeAllViews();
      if (paramBoolean) {
        getTavStickerContentViewSafely().addView((View)localObject2);
      }
      notifyStickerAdd((TAVStickerEditView)localObject2);
      if (!paramBoolean) {
        break label236;
      }
      notifyStickerActive((TAVStickerEditView)localObject2);
    }
    for (;;)
    {
      notifyCurrentStickerStateChanged(paramBoolean);
      notifyStickerListChanged();
      return;
      localObject1 = TAVStickerMode.INACTIVE;
      break;
      label210:
      localObject1 = null;
      break label84;
      label215:
      TLog.w(TAG, "loadSticker -> you did not call the setTavStickerContextDataSource method!");
      localObject1 = null;
      break label108;
      label229:
      paramTAVSticker = TAVStickerMode.INACTIVE;
      break label151;
      label236:
      notifyStickerResign((TAVStickerEditView)localObject2);
    }
  }
  
  public void registerObserver(ITAVStickerContextObserver paramITAVStickerContextObserver)
  {
    checkObserverList();
    if (paramITAVStickerContextObserver != null) {
      this.mObserverRefs.add(new WeakReference(paramITAVStickerContextObserver));
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 362	com/tencent/tavsticker/core/TAVStickerRenderContext:release	()V
    //   6: aload_0
    //   7: aconst_null
    //   8: putfield 47	com/tencent/tavsticker/core/TAVStickerContext:mStickerContainerView	Lcom/tencent/tavsticker/core/TAVStickerContentView;
    //   11: aload_0
    //   12: getfield 56	com/tencent/tavsticker/core/TAVStickerContext:mObserverRefs	Ljava/util/List;
    //   15: invokeinterface 365 1 0
    //   20: aload_0
    //   21: getfield 61	com/tencent/tavsticker/core/TAVStickerContext:mStickerViewCacheMap	Ljava/util/Map;
    //   24: invokeinterface 366 1 0
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 63	com/tencent/tavsticker/core/TAVStickerContext:mCurrentSticker	Lcom/tencent/tavsticker/model/TAVSticker;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 65	com/tencent/tavsticker/core/TAVStickerContext:mDataSource	Lcom/tencent/tavsticker/core/ITAVStickerContextDataSource;
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 67	com/tencent/tavsticker/core/TAVStickerContext:mOnTouchStickerOutsideListener	Lcom/tencent/tavsticker/core/TAVStickerContext$OnTouchStickerOutsideListener;
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 369	java/lang/Exception:printStackTrace	()V
    //   52: goto -8 -> 44
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	TAVStickerContext
    //   47	2	1	localException	java.lang.Exception
    //   55	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	44	47	java/lang/Exception
    //   2	6	55	finally
    //   6	44	55	finally
    //   48	52	55	finally
  }
  
  @MainThread
  public void reloadAllStickers()
  {
    super.reloadAllStickers();
    checkStickerViewCacheMap();
    updateAllStickerLayerIndex();
    sortedAllStickers();
    if (this.mStickers != null)
    {
      getTavStickerContentViewSafely().removeAllViews();
      Iterator localIterator = this.mStickers.iterator();
      while (localIterator.hasNext())
      {
        TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
        if (localTAVSticker != null)
        {
          Object localObject = localTAVSticker.getUniqueId();
          localObject = (TAVStickerEditView)this.mStickerViewCacheMap.get(localObject);
          if (localObject != null) {
            getTavStickerContentViewSafely().addView((View)localObject);
          } else {
            loadSticker(localTAVSticker);
          }
        }
      }
    }
  }
  
  @MainThread
  public void reloadStickers(List<TAVSticker> paramList)
  {
    super.reloadStickers(paramList);
    reloadAllStickers();
    notifyStickerListChanged();
  }
  
  @MainThread
  public void removeAllStickers()
  {
    super.removeAllStickers();
    checkStickerViewCacheMap();
    if (!CollectionUtil.isEmptyMap(this.mStickerViewCacheMap))
    {
      Object localObject = this.mStickerViewCacheMap.values();
      if (localObject != null)
      {
        localObject = ((Collection)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          notifyStickerRemove((TAVStickerEditView)((Iterator)localObject).next());
        }
      }
      notifyStickerListChanged();
    }
    this.mStickerViewCacheMap.clear();
    getTavStickerContentViewSafely().removeAllViews();
    setCurrentSticker(null);
  }
  
  @MainThread
  public boolean removeCurrentSticker()
  {
    return removeSticker(this.mCurrentSticker);
  }
  
  @MainThread
  public boolean removeSticker(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null)
    {
      checkStickerViewCacheMap();
      boolean bool = super.removeSticker(paramTAVSticker);
      Object localObject = paramTAVSticker.getUniqueId();
      localObject = (TAVStickerEditView)this.mStickerViewCacheMap.remove(localObject);
      if (localObject != null) {
        getTavStickerContentViewSafely().removeView((View)localObject);
      }
      if ((this.mCurrentSticker != null) && (paramTAVSticker.equals(this.mCurrentSticker))) {
        this.mCurrentSticker = null;
      }
      notifyStickerRemove((TAVStickerEditView)localObject);
      notifyStickerListChanged();
      return bool;
    }
    return false;
  }
  
  public CMSampleBuffer renderSticker(long paramLong, List<TAVSourceImage> paramList, EGLContext paramEGLContext)
  {
    renderStickerEditView(paramLong);
    return super.renderSticker(paramLong, paramList, paramEGLContext);
  }
  
  public boolean renderSticker(Surface paramSurface, long paramLong, List<TAVSourceImage> paramList, EGLContext paramEGLContext)
  {
    renderStickerEditView(paramLong);
    return super.renderSticker(paramSurface, paramLong, paramList, paramEGLContext);
  }
  
  @MainThread
  public void resignCurrentSticker()
  {
    resignSticker(this.mCurrentSticker);
  }
  
  @MainThread
  public void resignSticker(TAVSticker paramTAVSticker)
  {
    resignStickerInner(paramTAVSticker, true);
  }
  
  public void setCurrentSticker(TAVSticker paramTAVSticker)
  {
    this.mCurrentSticker = paramTAVSticker;
  }
  
  public void setOnTouchStickerOutsideListener(TAVStickerContext.OnTouchStickerOutsideListener paramOnTouchStickerOutsideListener)
  {
    this.mOnTouchStickerOutsideListener = paramOnTouchStickerOutsideListener;
  }
  
  public void setStickerContainer(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      this.mStickerContainer = paramViewGroup;
      paramViewGroup = new ViewGroup.LayoutParams(-1, -1);
      this.mStickerContainer.addView(getTavStickerContentViewSafely(), paramViewGroup);
    }
  }
  
  public void setTavStickerContentView(TAVStickerContentView paramTAVStickerContentView)
  {
    if ((paramTAVStickerContentView != null) && (paramTAVStickerContentView != this.mStickerContainerView))
    {
      this.mStickerContainerView = paramTAVStickerContentView;
      this.mStickerContainerView.setDispatchTouchEventListener(this.mDispatchTouchEventListener);
    }
  }
  
  public void setTavStickerContextDataSource(ITAVStickerContextDataSource paramITAVStickerContextDataSource)
  {
    this.mDataSource = paramITAVStickerContextDataSource;
  }
  
  public void setTouchable(boolean paramBoolean)
  {
    this.touchable = paramBoolean;
  }
  
  public void unRegisterObserver(ITAVStickerContextObserver paramITAVStickerContextObserver)
  {
    checkObserverList();
    if (paramITAVStickerContextObserver != null)
    {
      Iterator localIterator = new ArrayList(this.mObserverRefs).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (paramITAVStickerContextObserver == localWeakReference.get())) {
          this.mObserverRefs.remove(localWeakReference);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerContext
 * JD-Core Version:    0.7.0.1
 */