package com.tencent.tavsticker.core;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.EGLContext;
import android.support.annotation.MainThread;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.tav.coremedia.CGSize;
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
  private static final int CLICK_DURATION = 200;
  private static final String TAG = "TAVStickerContext";
  private Context context = null;
  private TAVSticker currentSticker = null;
  private ITAVStickerContextDataSource dataSource = null;
  private TAVStickerContext.DispatchTouchEventListener dispatchTouchEventListener = new TAVStickerContext.DispatchTouchEventListener(this);
  private List<WeakReference<ITAVStickerContextObserver>> observerRefs = new ArrayList();
  private TAVStickerContext.OnTouchStickerOutsideListener onTouchStickerOutsideListener = null;
  private ViewGroup stickerContainer = null;
  private TAVStickerContentView stickerContainerView = null;
  private Map<String, TAVStickerEditView> stickerViewCacheMap = new HashMap();
  private boolean touchable = true;
  
  public TAVStickerContext(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private boolean checkClickInterval(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() < 200L;
  }
  
  private void checkObserverList()
  {
    if (this.observerRefs == null) {
      this.observerRefs = new ArrayList();
    }
  }
  
  private void checkStickerViewCacheMap()
  {
    if (this.stickerViewCacheMap == null) {
      this.stickerViewCacheMap = new HashMap();
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
  
  private PointF getCovertCoordinate(PointF paramPointF)
  {
    float f1 = paramPointF.x;
    float f2 = paramPointF.y;
    if (getContainerWidth() != this.renderSize.width) {
      f1 = TAVStickerUtil.covertCoordinate(paramPointF.x, getContainerWidth(), (int)this.renderSize.width);
    }
    if (getContainerHeight() != this.renderSize.height) {
      f2 = TAVStickerUtil.covertCoordinate(paramPointF.y, getContainerHeight(), (int)this.renderSize.height);
    }
    return new PointF(f1, f2);
  }
  
  private TAVSticker getTouchStickerFromUI(PointF paramPointF)
  {
    paramPointF = getCovertCoordinate(paramPointF);
    return getTouchedSticker(paramPointF.x, paramPointF.y);
  }
  
  private void notifyCurrentStickerStateChanged(boolean paramBoolean)
  {
    checkObserverList();
    Iterator localIterator = this.observerRefs.iterator();
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
    Iterator localIterator = this.observerRefs.iterator();
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
    Iterator localIterator = this.observerRefs.iterator();
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
    Iterator localIterator = this.observerRefs.iterator();
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
    Iterator localIterator = this.observerRefs.iterator();
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
    Iterator localIterator = this.observerRefs.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((ITAVStickerContextObserver)localWeakReference.get()).onStickerResign(this, paramTAVStickerEditView);
      }
    }
  }
  
  private void resignStickerInner(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    if (paramTAVSticker != null)
    {
      paramTAVSticker.setMode(TAVStickerMode.INACTIVE);
      removeAllViews();
      paramTAVSticker = paramTAVSticker.getUniqueId();
      checkStickerViewCacheMap();
      paramTAVSticker = (TAVStickerEditView)this.stickerViewCacheMap.get(paramTAVSticker);
      if (paramTAVSticker != null) {
        paramTAVSticker.setMode(TAVStickerMode.INACTIVE);
      }
      this.currentSticker = null;
      notifyStickerResign(paramTAVSticker);
      if (paramBoolean) {
        notifyCurrentStickerStateChanged(false);
      }
      syncAllChildContext();
    }
  }
  
  private boolean shouldShowSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    if (paramTAVSticker == null) {
      return false;
    }
    if (this.renderContextDataSource != null) {
      return this.renderContextDataSource.shouldRenderSticker(paramTAVSticker, paramLong);
    }
    return (TAVStickerUtil.isPresentationTimeInStickerTimeRange(paramLong, paramTAVSticker)) && (TAVStickerMode.ACTIVE == paramTAVSticker.getMode());
  }
  
  private void updateAllStickerLayerIndex()
  {
    checkStickerList();
    this.stickerLayerIndex = 0;
    Iterator localIterator = this.stickers.iterator();
    while (localIterator.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
      if ((localTAVSticker != null) && (-1 == localTAVSticker.getLayerIndex()))
      {
        int i = this.stickerLayerIndex;
        this.stickerLayerIndex = (i + 1);
        localTAVSticker.setLayerIndex(i);
      }
    }
  }
  
  @MainThread
  public void activeSticker(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null)
    {
      Object localObject = this.currentSticker;
      if ((localObject != null) && (!paramTAVSticker.equals(localObject))) {
        resignStickerInner(this.currentSticker, false);
      }
      paramTAVSticker.setMode(TAVStickerMode.ACTIVE);
      this.currentSticker = paramTAVSticker;
      checkStickerViewCacheMap();
      localObject = paramTAVSticker.getUniqueId();
      localObject = (TAVStickerEditView)this.stickerViewCacheMap.get(localObject);
      if (localObject != null)
      {
        removeAllViews();
        addView((View)localObject, true);
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
  
  public void addView(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      getTavStickerContentViewSafely().addView(paramView);
    }
  }
  
  public TAVStickerEditView fetchStickerView(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker == null) {
      return null;
    }
    checkStickerViewCacheMap();
    return (TAVStickerEditView)this.stickerViewCacheMap.get(paramTAVSticker.getUniqueId());
  }
  
  public TAVSticker getCurrentSticker()
  {
    return this.currentSticker;
  }
  
  public TAVStickerEditView getCurrentStickerEditView()
  {
    return fetchStickerView(this.currentSticker);
  }
  
  public TAVStickerContext.DispatchTouchEventListener getDispatchTouchEventListener()
  {
    return this.dispatchTouchEventListener;
  }
  
  protected TAVStickerContentView getTavStickerContentViewSafely()
  {
    if (this.stickerContainerView == null)
    {
      this.stickerContainerView = new TAVStickerContentView(this.context);
      this.stickerContainerView.setDispatchTouchEventListener(this.dispatchTouchEventListener);
    }
    return this.stickerContainerView;
  }
  
  protected TAVSticker getTouchedSticker(float paramFloat1, float paramFloat2)
  {
    if ((this.currentSticker != null) && (TAVStickerUtil.isPresentationTimeInStickerTimeRange(this.presentationTimeMs, this.currentSticker)) && (this.currentSticker.isEditable()) && (isTouchOnTavSticker(this.currentSticker, paramFloat1, paramFloat2))) {
      return this.currentSticker;
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
    if (paramTAVSticker != null)
    {
      checkStickerViewCacheMap();
      String str = paramTAVSticker.getUniqueId();
      if (this.stickerViewCacheMap.containsKey(paramTAVSticker.getUniqueId())) {
        return;
      }
      Object localObject1 = this.currentSticker;
      if ((localObject1 != null) && (!paramTAVSticker.equals(localObject1))) {
        resignStickerInner(this.currentSticker, false);
      }
      super.loadSticker(paramTAVSticker, paramBoolean);
      if (paramBoolean) {
        localObject1 = TAVStickerMode.ACTIVE;
      } else {
        localObject1 = TAVStickerMode.INACTIVE;
      }
      paramTAVSticker.setMode((TAVStickerMode)localObject1);
      Object localObject2 = null;
      if (paramBoolean) {
        localObject1 = paramTAVSticker;
      } else {
        localObject1 = null;
      }
      this.currentSticker = ((TAVSticker)localObject1);
      localObject1 = this.dataSource;
      if (localObject1 != null)
      {
        localObject1 = ((ITAVStickerContextDataSource)localObject1).loadSticker(this, paramTAVSticker);
      }
      else
      {
        TLog.w(TAG, "loadSticker -> you did not call the setTavStickerContextDataSource method!");
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new TAVStickerEditView(this.context, paramTAVSticker);
      }
      this.stickerViewCacheMap.put(str, localObject2);
      if (paramBoolean) {
        paramTAVSticker = TAVStickerMode.ACTIVE;
      } else {
        paramTAVSticker = TAVStickerMode.INACTIVE;
      }
      ((TAVStickerEditView)localObject2).setMode(paramTAVSticker);
      removeAllViews();
      addView((View)localObject2, paramBoolean);
      if (paramBoolean) {
        this.dispatchTouchEventListener.a();
      }
      notifyStickerAdd((TAVStickerEditView)localObject2);
      if (paramBoolean) {
        notifyStickerActive((TAVStickerEditView)localObject2);
      } else {
        notifyStickerResign((TAVStickerEditView)localObject2);
      }
      notifyCurrentStickerStateChanged(paramBoolean);
      notifyStickerListChanged();
    }
  }
  
  public void registerObserver(ITAVStickerContextObserver paramITAVStickerContextObserver)
  {
    checkObserverList();
    if (paramITAVStickerContextObserver != null) {
      this.observerRefs.add(new WeakReference(paramITAVStickerContextObserver));
    }
  }
  
  public void release()
  {
    try
    {
      super.release();
      try
      {
        this.stickerContainerView = null;
        this.observerRefs.clear();
        this.stickerViewCacheMap.clear();
        this.currentSticker = null;
        this.dataSource = null;
        this.onTouchStickerOutsideListener = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
    }
    finally {}
  }
  
  @MainThread
  public void reloadAllStickers()
  {
    super.reloadAllStickers();
    checkStickerViewCacheMap();
    updateAllStickerLayerIndex();
    sortedAllStickers();
    if (this.stickers != null)
    {
      getTavStickerContentViewSafely().removeAllViews();
      Iterator localIterator = this.stickers.iterator();
      while (localIterator.hasNext())
      {
        TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
        if (localTAVSticker != null)
        {
          Object localObject = localTAVSticker.getUniqueId();
          localObject = (TAVStickerEditView)this.stickerViewCacheMap.get(localObject);
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
    if (!CollectionUtil.isEmptyMap(this.stickerViewCacheMap))
    {
      Object localObject = this.stickerViewCacheMap.values();
      if (localObject != null)
      {
        localObject = ((Collection)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          notifyStickerRemove((TAVStickerEditView)((Iterator)localObject).next());
        }
      }
      notifyStickerListChanged();
    }
    this.stickerViewCacheMap.clear();
    getTavStickerContentViewSafely().removeAllViews();
    setCurrentSticker(null);
  }
  
  public void removeAllViews()
  {
    getTavStickerContentViewSafely().removeAllViews();
  }
  
  @MainThread
  public boolean removeCurrentSticker()
  {
    return removeSticker(this.currentSticker);
  }
  
  @MainThread
  public boolean removeSticker(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker != null)
    {
      checkStickerViewCacheMap();
      boolean bool = super.removeSticker(paramTAVSticker);
      Object localObject = paramTAVSticker.getUniqueId();
      localObject = (TAVStickerEditView)this.stickerViewCacheMap.remove(localObject);
      if (localObject != null) {
        getTavStickerContentViewSafely().removeView((View)localObject);
      }
      TAVSticker localTAVSticker = this.currentSticker;
      if ((localTAVSticker != null) && (paramTAVSticker.equals(localTAVSticker))) {
        this.currentSticker = null;
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
  
  protected void renderStickerEditView(long paramLong)
  {
    TAVStickerEditView localTAVStickerEditView = getCurrentStickerEditView();
    if (localTAVStickerEditView != null)
    {
      TAVSticker localTAVSticker = this.currentSticker;
      if (localTAVSticker != null)
      {
        int i;
        if (shouldShowSticker(localTAVSticker, paramLong)) {
          i = 0;
        } else {
          i = 4;
        }
        if (i != localTAVStickerEditView.getVisibility()) {
          localTAVStickerEditView.post(new TAVStickerContext.1(this, localTAVStickerEditView, i));
        }
      }
    }
  }
  
  @MainThread
  public void resignCurrentSticker()
  {
    resignSticker(this.currentSticker);
  }
  
  @MainThread
  public void resignSticker(TAVSticker paramTAVSticker)
  {
    resignStickerInner(paramTAVSticker, true);
  }
  
  public void setCurrentSticker(TAVSticker paramTAVSticker)
  {
    this.currentSticker = paramTAVSticker;
  }
  
  public void setOnTouchStickerOutsideListener(TAVStickerContext.OnTouchStickerOutsideListener paramOnTouchStickerOutsideListener)
  {
    this.onTouchStickerOutsideListener = paramOnTouchStickerOutsideListener;
  }
  
  public void setStickerContainer(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      this.stickerContainer = paramViewGroup;
      paramViewGroup = new ViewGroup.LayoutParams(-1, -1);
      this.stickerContainer.addView(getTavStickerContentViewSafely(), paramViewGroup);
    }
  }
  
  public void setTavStickerContentView(TAVStickerContentView paramTAVStickerContentView)
  {
    if ((paramTAVStickerContentView != null) && (paramTAVStickerContentView != this.stickerContainerView))
    {
      this.stickerContainerView = paramTAVStickerContentView;
      this.stickerContainerView.setDispatchTouchEventListener(this.dispatchTouchEventListener);
    }
  }
  
  public void setTavStickerContextDataSource(ITAVStickerContextDataSource paramITAVStickerContextDataSource)
  {
    this.dataSource = paramITAVStickerContextDataSource;
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
      Iterator localIterator = new ArrayList(this.observerRefs).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (paramITAVStickerContextObserver == localWeakReference.get())) {
          this.observerRefs.remove(localWeakReference);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerContext
 * JD-Core Version:    0.7.0.1
 */