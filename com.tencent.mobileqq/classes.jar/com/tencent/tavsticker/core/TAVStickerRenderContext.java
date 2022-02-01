package com.tencent.tavsticker.core;

import android.graphics.PointF;
import android.opengl.EGLContext;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerProvider;
import com.tencent.tavsticker.model.TAVStickerQuality;
import com.tencent.tavsticker.model.TAVStickerTexture;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.libpag.PAGImage;
import org.libpag.PAGSurface;

public class TAVStickerRenderContext
{
  private static final String TAG = TAVStickerRenderContext.class.getSimpleName();
  protected List<TAVSourceImage> cacheImagesForRelease = null;
  protected List<TAVStickerRenderContext> childContexts = new ArrayList();
  protected volatile PAGSurface pagSurface = null;
  protected long presentationTimeMs = 0L;
  protected List<TAVStickerProvider> providers = Collections.synchronizedList(new ArrayList());
  protected TAVStickerQuality quality = TAVStickerQuality.TAVStickerQualityHigh;
  protected ITAVRenderContextDataSource renderContextDataSource = null;
  protected CGSize renderSize = CGSize.CGSizeZero;
  protected int stickerLayerIndex = 0;
  protected Surface stickerSurface = null;
  protected TAVStickerTexture stickerTexture = null;
  protected List<TAVSticker> stickers = Collections.synchronizedList(new ArrayList());
  
  protected void checkChildContexts()
  {
    if (this.childContexts == null) {
      this.childContexts = new ArrayList();
    }
  }
  
  protected void checkStickerList()
  {
    if (this.stickers == null) {
      this.stickers = Collections.synchronizedList(new ArrayList());
    }
  }
  
  protected void checkStickerProviderList()
  {
    if (this.providers == null) {
      this.providers = Collections.synchronizedList(new ArrayList());
    }
  }
  
  public boolean containSticker(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker == null) {
      return false;
    }
    checkStickerList();
    return this.stickers.contains(paramTAVSticker);
  }
  
  @Deprecated
  public TAVStickerRenderContext copy()
  {
    TAVStickerRenderContext localTAVStickerRenderContext = new TAVStickerRenderContext();
    localTAVStickerRenderContext.checkStickerList();
    if (this.stickers != null) {
      localTAVStickerRenderContext.stickers = this.stickers;
    }
    localTAVStickerRenderContext.setRenderSize(this.renderSize);
    localTAVStickerRenderContext.stickerLayerIndex = this.stickerLayerIndex;
    localTAVStickerRenderContext.renderContextDataSource = this.renderContextDataSource;
    localTAVStickerRenderContext.quality = this.quality;
    checkChildContexts();
    this.childContexts.add(localTAVStickerRenderContext);
    return localTAVStickerRenderContext;
  }
  
  public TAVStickerRenderContext copyRenderContext()
  {
    TAVStickerRenderContext localTAVStickerRenderContext = new TAVStickerRenderContext();
    localTAVStickerRenderContext.checkStickerList();
    if (this.stickers != null) {
      localTAVStickerRenderContext.stickers = this.stickers;
    }
    localTAVStickerRenderContext.setRenderSize(this.renderSize);
    localTAVStickerRenderContext.stickerLayerIndex = this.stickerLayerIndex;
    localTAVStickerRenderContext.renderContextDataSource = this.renderContextDataSource;
    localTAVStickerRenderContext.quality = this.quality;
    checkChildContexts();
    this.childContexts.add(localTAVStickerRenderContext);
    return localTAVStickerRenderContext;
  }
  
  protected void createSurface()
  {
    try
    {
      if ((TAVStickerUtil.isValidCGSize(this.renderSize)) && ((this.stickerSurface == null) || (!this.stickerSurface.isValid())))
      {
        if (this.stickerTexture != null) {
          this.stickerTexture.release();
        }
        this.stickerTexture = new TAVStickerTexture((int)this.renderSize.width, (int)this.renderSize.height);
        if (this.stickerSurface != null) {
          this.stickerSurface.release();
        }
        this.stickerSurface = new Surface(this.stickerTexture.surfaceTexture());
      }
      return;
    }
    finally {}
  }
  
  public int getStickerCount()
  {
    checkStickerList();
    return this.stickers.size();
  }
  
  public TAVStickerTexture getStickerTexture()
  {
    return this.stickerTexture;
  }
  
  public List<TAVSticker> getStickers()
  {
    checkStickerList();
    return this.stickers;
  }
  
  protected TAVSticker getTouchedSticker(float paramFloat1, float paramFloat2)
  {
    checkStickerList();
    int i = this.stickers.size() - 1;
    if (i >= 0)
    {
      TAVSticker localTAVSticker = (TAVSticker)this.stickers.get(i);
      if (localTAVSticker == null) {}
      while ((!TAVStickerUtil.isPresentationTimeInStickerTimeRange(this.presentationTimeMs, localTAVSticker)) || (!localTAVSticker.isEditable()) || (!isTouchOnTavSticker(localTAVSticker, paramFloat1, paramFloat2)))
      {
        i -= 1;
        break;
      }
      return localTAVSticker;
    }
    return null;
  }
  
  public void getUnderPointLayerItems(float paramFloat1, float paramFloat2, ITAVTouchStickerLayerListener paramITAVTouchStickerLayerListener)
  {
    if (paramITAVTouchStickerLayerListener == null) {
      return;
    }
    TAVSticker localTAVSticker = getTouchedSticker(paramFloat1, paramFloat2);
    if (localTAVSticker != null)
    {
      checkStickerProviderList();
      Iterator localIterator = this.providers.iterator();
      while (localIterator.hasNext())
      {
        TAVStickerProvider localTAVStickerProvider = (TAVStickerProvider)localIterator.next();
        if ((localTAVStickerProvider != null) && (localTAVSticker == localTAVStickerProvider.getSticker()))
        {
          paramITAVTouchStickerLayerListener.onTouchSticker(localTAVSticker, localTAVStickerProvider.getUnderPointLayerItems(paramFloat1, paramFloat2));
          return;
        }
      }
    }
    paramITAVTouchStickerLayerListener.onTouchSticker(localTAVSticker, null);
  }
  
  protected boolean isTouchOnTavSticker(TAVSticker paramTAVSticker, float paramFloat1, float paramFloat2)
  {
    if (paramTAVSticker == null)
    {
      TLog.e(TAG, "isTouchOnTavSticker -> parameter tavSticker is null!");
      return false;
    }
    if (!TAVStickerUtil.isValidCGSize(this.renderSize))
    {
      TLog.e(TAG, "isTouchOnTavSticker -> renderSize invalid!");
      return false;
    }
    PointF[] arrayOfPointF = TAVStickerUtil.computeRectanglePoints(TAVStickerUtil.getMatrix(paramTAVSticker, (int)this.renderSize.width, (int)this.renderSize.height), paramTAVSticker.getWidth(), paramTAVSticker.getHeight());
    TLog.d(TAG, "isTouchOnTavSticker -> x : " + paramFloat1 + ", y : " + paramFloat2);
    if (TAVStickerUtil.inQuadrangle(arrayOfPointF[0], arrayOfPointF[1], arrayOfPointF[2], arrayOfPointF[3], new PointF(paramFloat1, paramFloat2)))
    {
      TLog.d(TAG, "isTouchOnTavSticker -> 点中了贴纸, " + paramTAVSticker.getFilePath());
      return true;
    }
    TLog.d(TAG, "isTouchOnTavSticker -> 没有点中贴纸, " + paramTAVSticker.getFilePath());
    return false;
  }
  
  public void loadSticker(TAVSticker paramTAVSticker)
  {
    loadSticker(paramTAVSticker, false);
  }
  
  public void loadSticker(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    checkStickerList();
    if ((paramTAVSticker != null) && (!containSticker(paramTAVSticker)))
    {
      paramTAVSticker.setMode(TAVStickerMode.INACTIVE);
      if (-1 == paramTAVSticker.getLayerIndex())
      {
        int i = this.stickerLayerIndex;
        this.stickerLayerIndex = (i + 1);
        paramTAVSticker.setLayerIndex(i);
      }
      this.stickers.add(paramTAVSticker);
      sortedAllStickers();
      reloadAllProviders();
      sortedAllProviders();
      syncAllChildContext();
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/tencent/tavsticker/core/TAVStickerRenderContext:providers	Ljava/util/List;
    //   6: invokeinterface 192 1 0
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface 197 1 0
    //   18: ifeq +32 -> 50
    //   21: aload_1
    //   22: invokeinterface 201 1 0
    //   27: checkcast 203	com/tencent/tavsticker/model/TAVStickerProvider
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull -20 -> 12
    //   35: aload_2
    //   36: invokevirtual 315	com/tencent/tavsticker/model/TAVStickerProvider:release	()V
    //   39: goto -27 -> 12
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 318	java/lang/Exception:printStackTrace	()V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 58	com/tencent/tavsticker/core/TAVStickerRenderContext:providers	Ljava/util/List;
    //   54: invokeinterface 321 1 0
    //   59: aload_0
    //   60: iconst_0
    //   61: putfield 60	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerLayerIndex	I
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 64	com/tencent/tavsticker/core/TAVStickerRenderContext:renderContextDataSource	Lcom/tencent/tavsticker/core/ITAVRenderContextDataSource;
    //   69: aload_0
    //   70: getfield 75	com/tencent/tavsticker/core/TAVStickerRenderContext:pagSurface	Lorg/libpag/PAGSurface;
    //   73: ifnull +22 -> 95
    //   76: aload_0
    //   77: getfield 75	com/tencent/tavsticker/core/TAVStickerRenderContext:pagSurface	Lorg/libpag/PAGSurface;
    //   80: invokevirtual 326	org/libpag/PAGSurface:freeCache	()V
    //   83: aload_0
    //   84: getfield 75	com/tencent/tavsticker/core/TAVStickerRenderContext:pagSurface	Lorg/libpag/PAGSurface;
    //   87: invokevirtual 327	org/libpag/PAGSurface:release	()V
    //   90: aload_0
    //   91: aconst_null
    //   92: putfield 75	com/tencent/tavsticker/core/TAVStickerRenderContext:pagSurface	Lorg/libpag/PAGSurface;
    //   95: aload_0
    //   96: getfield 77	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerTexture	Lcom/tencent/tavsticker/model/TAVStickerTexture;
    //   99: ifnull +15 -> 114
    //   102: aload_0
    //   103: getfield 77	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerTexture	Lcom/tencent/tavsticker/model/TAVStickerTexture;
    //   106: invokevirtual 134	com/tencent/tavsticker/model/TAVStickerTexture:release	()V
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 77	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerTexture	Lcom/tencent/tavsticker/model/TAVStickerTexture;
    //   114: aload_0
    //   115: getfield 79	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerSurface	Landroid/view/Surface;
    //   118: ifnull +15 -> 133
    //   121: aload_0
    //   122: getfield 79	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerSurface	Landroid/view/Surface;
    //   125: invokevirtual 145	android/view/Surface:release	()V
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 79	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerSurface	Landroid/view/Surface;
    //   133: getstatic 41	com/tencent/tavsticker/core/TAVStickerRenderContext:TAG	Ljava/lang/String;
    //   136: new 242	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 329
    //   146: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokestatic 335	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   152: invokevirtual 338	java/lang/Thread:getName	()Ljava/lang/String;
    //   155: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 340
    //   161: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: new 342	java/lang/RuntimeException
    //   167: dup
    //   168: invokespecial 343	java/lang/RuntimeException:<init>	()V
    //   171: invokestatic 349	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   174: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 224	com/tencent/tavsticker/log/TLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: goto -136 -> 47
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	TAVStickerRenderContext
    //   11	11	1	localIterator	Iterator
    //   42	2	1	localException	java.lang.Exception
    //   186	4	1	localObject	Object
    //   30	6	2	localTAVStickerProvider	TAVStickerProvider
    // Exception table:
    //   from	to	target	type
    //   2	12	42	java/lang/Exception
    //   12	31	42	java/lang/Exception
    //   35	39	42	java/lang/Exception
    //   50	95	42	java/lang/Exception
    //   95	114	42	java/lang/Exception
    //   114	133	42	java/lang/Exception
    //   133	183	42	java/lang/Exception
    //   2	12	186	finally
    //   12	31	186	finally
    //   35	39	186	finally
    //   43	47	186	finally
    //   50	95	186	finally
    //   95	114	186	finally
    //   114	133	186	finally
    //   133	183	186	finally
  }
  
  protected void releaseCacheImages(@NonNull List<TAVSourceImage> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TAVSourceImage localTAVSourceImage = (TAVSourceImage)localIterator.next();
      if ((localTAVSourceImage != null) && (localTAVSourceImage.getPagImage() != null)) {
        localTAVSourceImage.getPagImage().release();
      }
    }
    paramList.clear();
  }
  
  public void reloadAllProviders()
  {
    checkStickerProviderList();
    Object localObject2 = new ArrayList(this.providers);
    Object localObject1 = new ArrayList(this.stickers);
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TAVStickerProvider localTAVStickerProvider = (TAVStickerProvider)((Iterator)localObject2).next();
      if (localTAVStickerProvider != null)
      {
        TAVSticker localTAVSticker = localTAVStickerProvider.getSticker();
        if (localTAVSticker != null) {
          if (!this.stickers.contains(localTAVStickerProvider.getSticker()))
          {
            this.providers.remove(localTAVStickerProvider);
          }
          else
          {
            localTAVStickerProvider.setRenderSize(this.renderSize);
            ((ArrayList)localObject1).remove(localTAVSticker);
          }
        }
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TAVSticker)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = new TAVStickerProvider((TAVSticker)localObject2);
        if (TAVStickerQuality.TAVStickerQualityHigh == this.quality) {}
        for (boolean bool = true;; bool = false)
        {
          ((TAVStickerProvider)localObject2).setHighQuality(bool);
          ((TAVStickerProvider)localObject2).setRenderSize(this.renderSize);
          this.providers.add(localObject2);
          break;
        }
      }
    }
  }
  
  public void reloadAllStickers()
  {
    checkStickerList();
    Iterator localIterator = this.stickers.iterator();
    while (localIterator.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
      if (localTAVSticker != null)
      {
        localTAVSticker.updateImageData();
        localTAVSticker.updateTextData();
        localTAVSticker.setMode(TAVStickerMode.INACTIVE);
      }
    }
  }
  
  public void reloadStickers(List<TAVSticker> paramList)
  {
    checkStickerList();
    if (!CollectionUtil.isEmptyList(paramList))
    {
      removeAllStickers();
      this.stickers.addAll(paramList);
      reloadAllStickers();
      reloadAllProviders();
      sortedAllProviders();
    }
  }
  
  public void removeAllStickers()
  {
    checkStickerList();
    this.stickers.clear();
    syncAllChildContext();
  }
  
  public boolean removeSticker(TAVSticker paramTAVSticker)
  {
    checkStickerList();
    boolean bool = this.stickers.remove(paramTAVSticker);
    syncAllChildContext();
    return bool;
  }
  
  public CMSampleBuffer renderSticker(long paramLong, List<TAVSourceImage> paramList, EGLContext paramEGLContext)
  {
    if (!TAVStickerUtil.isValidCGSize(this.renderSize))
    {
      TLog.e(TAG, "renderSticker -> renderSize is invalid!");
      return null;
    }
    createSurface();
    if (this.stickerSurface == null)
    {
      TLog.e(TAG, "renderSticker -> stickerSurface is null!");
      return null;
    }
    if (this.stickerTexture == null)
    {
      TLog.e(TAG, "renderSticker -> stickerTexture is null!");
      return null;
    }
    boolean bool = renderSticker(this.stickerSurface, paramLong, paramList, paramEGLContext);
    return new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(paramLong)), this.stickerTexture.getTextureInfo(), bool);
  }
  
  public boolean renderSticker(Surface paramSurface, long paramLong, List<TAVSourceImage> paramList, EGLContext paramEGLContext)
  {
    this.presentationTimeMs = paramLong;
    checkStickerList();
    checkStickerProviderList();
    if ((this.pagSurface == null) && (paramSurface != null)) {
      if (paramEGLContext == null) {
        break label48;
      }
    }
    label48:
    for (this.pagSurface = PAGSurface.FromSurface(paramSurface, paramEGLContext); this.pagSurface == null; this.pagSurface = PAGSurface.FromSurface(paramSurface)) {
      return false;
    }
    if (this.cacheImagesForRelease != null) {
      releaseCacheImages(this.cacheImagesForRelease);
    }
    if (this.stickers.size() != this.providers.size())
    {
      reloadAllProviders();
      sortedAllProviders();
    }
    paramSurface = this.providers.iterator();
    while (paramSurface.hasNext())
    {
      paramEGLContext = (TAVStickerProvider)paramSurface.next();
      if ((paramEGLContext != null) && (shouldRenderSticker(paramEGLContext.getSticker(), paramLong)))
      {
        paramEGLContext.setRenderSize(this.renderSize);
        paramEGLContext.setPagSurface(this.pagSurface);
        paramEGLContext.replaceSourceImages(paramList);
        paramEGLContext.updateRender(paramLong);
      }
    }
    if (!CollectionUtil.isEmptyList(paramList)) {
      this.cacheImagesForRelease = new ArrayList(paramList);
    }
    return this.pagSurface.present();
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    if (this.providers != null)
    {
      Iterator localIterator = this.providers.iterator();
      while (localIterator.hasNext())
      {
        TAVStickerProvider localTAVStickerProvider = (TAVStickerProvider)localIterator.next();
        if (localTAVStickerProvider != null) {
          localTAVStickerProvider.setCacheEnabled(paramBoolean);
        }
      }
    }
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    if ((TAVStickerUtil.isValidCGSize(paramCGSize)) && (!paramCGSize.equals(this.renderSize)))
    {
      TLog.d(TAG, "setRenderSize -> render size changed, oldRenderSize : " + this.renderSize + ", newRenderSize : " + paramCGSize);
      this.renderSize = paramCGSize;
      if (this.stickerTexture != null) {
        this.stickerTexture.updateStickerTextureSize((int)this.renderSize.width, (int)this.renderSize.height);
      }
      if (this.pagSurface != null)
      {
        this.pagSurface.updateSize();
        TLog.d(TAG, "setRenderSize  renderSize = " + this.renderSize.toString() + "   pagSurface width = " + this.pagSurface.width() + "   pagSurface height = " + this.pagSurface.height());
      }
    }
  }
  
  public void setStickerRenderQuality(TAVStickerQuality paramTAVStickerQuality)
  {
    if (paramTAVStickerQuality != null) {
      this.quality = paramTAVStickerQuality;
    }
  }
  
  public void setTavRenderContextDataSource(ITAVRenderContextDataSource paramITAVRenderContextDataSource)
  {
    this.renderContextDataSource = paramITAVRenderContextDataSource;
  }
  
  protected boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    if (paramTAVSticker == null) {}
    for (;;)
    {
      return false;
      if (this.renderContextDataSource != null) {
        return this.renderContextDataSource.shouldRenderSticker(paramTAVSticker, paramLong);
      }
      CMTimeRange localCMTimeRange = paramTAVSticker.getTimeRange();
      if (localCMTimeRange == null) {}
      for (boolean bool = true; (bool) && (TAVStickerMode.INACTIVE == paramTAVSticker.getMode()); bool = localCMTimeRange.containsTime(new CMTime(paramLong, 1000))) {
        return true;
      }
    }
  }
  
  protected void sortedAllProviders()
  {
    checkStickerProviderList();
    Collections.sort(this.providers, new TAVStickerRenderContext.1(this));
  }
  
  protected void sortedAllStickers()
  {
    checkStickerList();
    Collections.sort(this.stickers, new TAVStickerRenderContext.2(this));
  }
  
  protected void syncAllChildContext()
  {
    checkChildContexts();
    Iterator localIterator = this.childContexts.iterator();
    while (localIterator.hasNext())
    {
      TAVStickerRenderContext localTAVStickerRenderContext = (TAVStickerRenderContext)localIterator.next();
      if (localTAVStickerRenderContext != null)
      {
        localTAVStickerRenderContext.checkStickerList();
        localTAVStickerRenderContext.checkStickerProviderList();
        localTAVStickerRenderContext.providers.clear();
        if (this.stickers != null) {
          localTAVStickerRenderContext.stickers = this.stickers;
        }
        localTAVStickerRenderContext.setRenderSize(this.renderSize);
        localTAVStickerRenderContext.stickerLayerIndex = this.stickerLayerIndex;
        localTAVStickerRenderContext.renderContextDataSource = this.renderContextDataSource;
        localTAVStickerRenderContext.quality = this.quality;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerRenderContext
 * JD-Core Version:    0.7.0.1
 */