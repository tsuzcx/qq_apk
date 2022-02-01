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
  private static final String TAG = "TAVStickerRenderContext";
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
    List localList = this.stickers;
    if (localList != null) {
      localTAVStickerRenderContext.stickers = localList;
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
    List localList = this.stickers;
    if (localList != null) {
      localTAVStickerRenderContext.stickers = localList;
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
    while (i >= 0)
    {
      TAVSticker localTAVSticker = (TAVSticker)this.stickers.get(i);
      if ((localTAVSticker != null) && (TAVStickerUtil.isPresentationTimeInStickerTimeRange(this.presentationTimeMs, localTAVSticker)) && (localTAVSticker.isEditable()) && (isTouchOnTavSticker(localTAVSticker, paramFloat1, paramFloat2))) {
        return localTAVSticker;
      }
      i -= 1;
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
    Object localObject1 = TAVStickerUtil.computeRectanglePoints(TAVStickerUtil.getMatrix(paramTAVSticker, (int)this.renderSize.width, (int)this.renderSize.height), paramTAVSticker.getWidth(), paramTAVSticker.getHeight());
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isTouchOnTavSticker -> x : ");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(", y : ");
    localStringBuilder.append(paramFloat2);
    TLog.d((String)localObject2, localStringBuilder.toString());
    if (TAVStickerUtil.inQuadrangle(localObject1[0], localObject1[1], localObject1[2], localObject1[3], new PointF(paramFloat1, paramFloat2)))
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isTouchOnTavSticker -> 点中了贴纸, ");
      ((StringBuilder)localObject2).append(paramTAVSticker.getFilePath());
      TLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
      return true;
    }
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("isTouchOnTavSticker -> 没有点中贴纸, ");
    ((StringBuilder)localObject2).append(paramTAVSticker.getFilePath());
    TLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
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
    //   3: getfield 52	com/tencent/tavsticker/core/TAVStickerRenderContext:providers	Ljava/util/List;
    //   6: invokeinterface 186 1 0
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface 191 1 0
    //   18: ifeq +24 -> 42
    //   21: aload_1
    //   22: invokeinterface 195 1 0
    //   27: checkcast 197	com/tencent/tavsticker/model/TAVStickerProvider
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull -20 -> 12
    //   35: aload_2
    //   36: invokevirtual 312	com/tencent/tavsticker/model/TAVStickerProvider:release	()V
    //   39: goto -27 -> 12
    //   42: aload_0
    //   43: getfield 52	com/tencent/tavsticker/core/TAVStickerRenderContext:providers	Ljava/util/List;
    //   46: invokeinterface 315 1 0
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 54	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerLayerIndex	I
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 58	com/tencent/tavsticker/core/TAVStickerRenderContext:renderContextDataSource	Lcom/tencent/tavsticker/core/ITAVRenderContextDataSource;
    //   61: aload_0
    //   62: getfield 69	com/tencent/tavsticker/core/TAVStickerRenderContext:pagSurface	Lorg/libpag/PAGSurface;
    //   65: ifnull +22 -> 87
    //   68: aload_0
    //   69: getfield 69	com/tencent/tavsticker/core/TAVStickerRenderContext:pagSurface	Lorg/libpag/PAGSurface;
    //   72: invokevirtual 320	org/libpag/PAGSurface:freeCache	()V
    //   75: aload_0
    //   76: getfield 69	com/tencent/tavsticker/core/TAVStickerRenderContext:pagSurface	Lorg/libpag/PAGSurface;
    //   79: invokevirtual 321	org/libpag/PAGSurface:release	()V
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 69	com/tencent/tavsticker/core/TAVStickerRenderContext:pagSurface	Lorg/libpag/PAGSurface;
    //   87: aload_0
    //   88: getfield 71	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerTexture	Lcom/tencent/tavsticker/model/TAVStickerTexture;
    //   91: ifnull +15 -> 106
    //   94: aload_0
    //   95: getfield 71	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerTexture	Lcom/tencent/tavsticker/model/TAVStickerTexture;
    //   98: invokevirtual 128	com/tencent/tavsticker/model/TAVStickerTexture:release	()V
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 71	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerTexture	Lcom/tencent/tavsticker/model/TAVStickerTexture;
    //   106: aload_0
    //   107: getfield 73	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerSurface	Landroid/view/Surface;
    //   110: ifnull +15 -> 125
    //   113: aload_0
    //   114: getfield 73	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerSurface	Landroid/view/Surface;
    //   117: invokevirtual 139	android/view/Surface:release	()V
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 73	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerSurface	Landroid/view/Surface;
    //   125: getstatic 212	com/tencent/tavsticker/core/TAVStickerRenderContext:TAG	Ljava/lang/String;
    //   128: astore_1
    //   129: new 238	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   136: astore_2
    //   137: aload_2
    //   138: ldc_w 323
    //   141: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_2
    //   146: invokestatic 329	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   149: invokevirtual 332	java/lang/Thread:getName	()Ljava/lang/String;
    //   152: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: ldc_w 334
    //   160: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: new 336	java/lang/RuntimeException
    //   168: dup
    //   169: invokespecial 337	java/lang/RuntimeException:<init>	()V
    //   172: invokestatic 343	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   175: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_1
    //   180: aload_2
    //   181: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 220	com/tencent/tavsticker/log/TLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: goto +12 -> 199
    //   190: astore_1
    //   191: goto +11 -> 202
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 346	java/lang/Exception:printStackTrace	()V
    //   199: aload_0
    //   200: monitorexit
    //   201: return
    //   202: aload_0
    //   203: monitorexit
    //   204: goto +5 -> 209
    //   207: aload_1
    //   208: athrow
    //   209: goto -2 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	TAVStickerRenderContext
    //   11	169	1	localObject1	Object
    //   190	1	1	localObject2	Object
    //   194	14	1	localException	java.lang.Exception
    //   30	151	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	190	finally
    //   12	31	190	finally
    //   35	39	190	finally
    //   42	87	190	finally
    //   87	106	190	finally
    //   106	125	190	finally
    //   125	187	190	finally
    //   195	199	190	finally
    //   2	12	194	java/lang/Exception
    //   12	31	194	java/lang/Exception
    //   35	39	194	java/lang/Exception
    //   42	87	194	java/lang/Exception
    //   87	106	194	java/lang/Exception
    //   106	125	194	java/lang/Exception
    //   125	187	194	java/lang/Exception
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
        boolean bool;
        if (TAVStickerQuality.TAVStickerQualityHigh == this.quality) {
          bool = true;
        } else {
          bool = false;
        }
        ((TAVStickerProvider)localObject2).setHighQuality(bool);
        ((TAVStickerProvider)localObject2).setRenderSize(this.renderSize);
        this.providers.add(localObject2);
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
    Surface localSurface = this.stickerSurface;
    if (localSurface == null)
    {
      TLog.e(TAG, "renderSticker -> stickerSurface is null!");
      return null;
    }
    if (this.stickerTexture == null)
    {
      TLog.e(TAG, "renderSticker -> stickerTexture is null!");
      return null;
    }
    boolean bool = renderSticker(localSurface, paramLong, paramList, paramEGLContext);
    return new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(paramLong)), this.stickerTexture.getTextureInfo(), bool);
  }
  
  public boolean renderSticker(Surface paramSurface, long paramLong, List<TAVSourceImage> paramList, EGLContext paramEGLContext)
  {
    this.presentationTimeMs = paramLong;
    checkStickerList();
    checkStickerProviderList();
    if ((this.pagSurface == null) && (paramSurface != null)) {
      if (paramEGLContext != null) {
        this.pagSurface = PAGSurface.FromSurface(paramSurface, paramEGLContext);
      } else {
        this.pagSurface = PAGSurface.FromSurface(paramSurface);
      }
    }
    if (this.pagSurface == null) {
      return false;
    }
    paramSurface = this.cacheImagesForRelease;
    if (paramSurface != null) {
      releaseCacheImages(paramSurface);
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
      if (paramEGLContext != null)
      {
        paramEGLContext.setRenderSize(this.renderSize);
        paramEGLContext.setPagSurface(this.pagSurface);
        if (shouldRenderSticker(paramEGLContext.getSticker(), paramLong))
        {
          paramEGLContext.replaceSourceImages(paramList);
          paramEGLContext.updateRender(paramLong);
        }
      }
    }
    if (!CollectionUtil.isEmptyList(paramList)) {
      this.cacheImagesForRelease = new ArrayList(paramList);
    }
    return this.pagSurface.present();
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    Object localObject = this.providers;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TAVStickerProvider localTAVStickerProvider = (TAVStickerProvider)((Iterator)localObject).next();
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
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRenderSize -> render size changed, oldRenderSize : ");
      localStringBuilder.append(this.renderSize);
      localStringBuilder.append(", newRenderSize : ");
      localStringBuilder.append(paramCGSize);
      TLog.d((String)localObject, localStringBuilder.toString());
      this.renderSize = paramCGSize;
      paramCGSize = this.stickerTexture;
      if (paramCGSize != null) {
        paramCGSize.updateStickerTextureSize((int)this.renderSize.width, (int)this.renderSize.height);
      }
      if (this.pagSurface != null)
      {
        this.pagSurface.updateSize();
        paramCGSize = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setRenderSize  renderSize = ");
        ((StringBuilder)localObject).append(this.renderSize.toString());
        ((StringBuilder)localObject).append("   pagSurface width = ");
        ((StringBuilder)localObject).append(this.pagSurface.width());
        ((StringBuilder)localObject).append("   pagSurface height = ");
        ((StringBuilder)localObject).append(this.pagSurface.height());
        TLog.d(paramCGSize, ((StringBuilder)localObject).toString());
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
    if (paramTAVSticker == null) {
      return false;
    }
    Object localObject = this.renderContextDataSource;
    if (localObject != null) {
      return ((ITAVRenderContextDataSource)localObject).shouldRenderSticker(paramTAVSticker, paramLong);
    }
    localObject = paramTAVSticker.getTimeRange();
    boolean bool;
    if (localObject == null) {
      bool = true;
    } else {
      bool = ((CMTimeRange)localObject).containsTime(new CMTime(paramLong, 1000));
    }
    return (bool) && (TAVStickerMode.INACTIVE == paramTAVSticker.getMode());
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
        List localList = this.stickers;
        if (localList != null) {
          localTAVStickerRenderContext.stickers = localList;
        }
        localTAVStickerRenderContext.setRenderSize(this.renderSize);
        localTAVStickerRenderContext.stickerLayerIndex = this.stickerLayerIndex;
        localTAVStickerRenderContext.renderContextDataSource = this.renderContextDataSource;
        localTAVStickerRenderContext.quality = this.quality;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerRenderContext
 * JD-Core Version:    0.7.0.1
 */