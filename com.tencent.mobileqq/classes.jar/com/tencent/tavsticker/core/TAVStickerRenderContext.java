package com.tencent.tavsticker.core;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGLContext;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.Logger;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerProvider;
import com.tencent.tavsticker.model.TAVStickerQuality;
import com.tencent.tavsticker.model.TAVStickerTexture;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.ScreenUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGImageLayer;
import org.libpag.PAGLayer;
import org.libpag.PAGPlayer;
import org.libpag.PAGSurface;

public class TAVStickerRenderContext
{
  private static final String TAG = "TAVStickerRenderContext";
  protected PAGComposition baseComposition = null;
  protected List<TAVSourceImage> cacheImagesForRelease = null;
  protected List<TAVStickerRenderContext> childContexts = new ArrayList();
  protected boolean isPagSurfaceFromTexture = false;
  protected PAGPlayer pagPlayer = null;
  protected volatile PAGSurface pagSurface = null;
  protected long presentationTimeMs = 0L;
  protected List<TAVStickerProvider> providers = Collections.synchronizedList(new ArrayList());
  protected TAVStickerQuality quality = TAVStickerQuality.TAVStickerQualityHigh;
  protected long realDuration;
  protected ITAVRenderContextDataSource renderContextDataSource = null;
  protected CGSize renderSize = CGSize.CGSizeZero;
  protected PAGComposition rootComposition = null;
  protected int stickerLayerIndex = 0;
  protected Surface stickerSurface = null;
  protected TAVStickerTexture stickerTexture = null;
  protected List<TAVSticker> stickers = Collections.synchronizedList(new ArrayList());
  
  public TAVStickerRenderContext() {}
  
  public TAVStickerRenderContext(@NonNull CGSize paramCGSize, @NonNull long paramLong)
  {
    this.renderSize = paramCGSize;
    this.realDuration = paramLong;
  }
  
  private void rebindComposition()
  {
    if (this.isPagSurfaceFromTexture)
    {
      PAGPlayer localPAGPlayer = this.pagPlayer;
      if (localPAGPlayer != null) {
        localPAGPlayer.setComposition(this.rootComposition);
      }
    }
  }
  
  private void releasePagSurface()
  {
    if (this.pagSurface != null)
    {
      this.pagSurface.freeCache();
      this.pagSurface.release();
      this.pagSurface = null;
    }
  }
  
  private void releaseStickerTexture()
  {
    TAVStickerTexture localTAVStickerTexture = this.stickerTexture;
    if (localTAVStickerTexture != null)
    {
      localTAVStickerTexture.release();
      this.stickerTexture = null;
    }
  }
  
  private void replaceSourceImage(long paramLong, List<TAVSourceImage> paramList)
  {
    if (paramList != null) {
      try
      {
        if (!paramList.isEmpty())
        {
          Object localObject = this.baseComposition;
          if (localObject == null) {
            return;
          }
          int j = this.baseComposition.numLayers();
          TAVSourceImage localTAVSourceImage = null;
          int i = 0;
          for (;;)
          {
            localObject = localTAVSourceImage;
            if (i >= j) {
              break;
            }
            localObject = this.baseComposition.getLayerAt(i);
            if ((localObject != null) && (((PAGLayer)localObject).startTime() <= paramLong))
            {
              long l1 = ((PAGLayer)localObject).startTime();
              long l2 = ((PAGLayer)localObject).duration();
              if (paramLong < l1 + l2) {
                break;
              }
            }
            i += 1;
          }
          if (localObject == null) {
            return;
          }
          if ((localObject instanceof PAGImageLayer))
          {
            ((PAGImageLayer)localObject).replaceImage(((TAVSourceImage)paramList.get(0)).getPagImage());
          }
          else if ((localObject instanceof PAGFile))
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localTAVSourceImage = (TAVSourceImage)paramList.next();
              if (localTAVSourceImage != null) {
                ((PAGFile)localObject).replaceImage(localTAVSourceImage.getIndex(), localTAVSourceImage.getPagImage());
              }
            }
          }
          return;
        }
      }
      finally {}
    }
  }
  
  private void resetComposition()
  {
    if ((this.isPagSurfaceFromTexture) && (this.rootComposition != null)) {
      this.rootComposition = null;
    }
  }
  
  private void resetOrUpdatePagSurface()
  {
    if (!this.isPagSurfaceFromTexture)
    {
      this.pagSurface.updateSize();
    }
    else
    {
      releasePagSurface();
      createPagSurface();
    }
    if (this.pagSurface != null)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRenderSize  renderSize = ");
      localStringBuilder.append(this.renderSize.toString());
      localStringBuilder.append("   pagSurface width = ");
      localStringBuilder.append(this.pagSurface.width());
      localStringBuilder.append("   pagSurface height = ");
      localStringBuilder.append(this.pagSurface.height());
      TLog.d(str, localStringBuilder.toString());
    }
  }
  
  private void resetOrUpdateStickerTexture()
  {
    if (!this.isPagSurfaceFromTexture)
    {
      this.stickerTexture.updateStickerTextureSize((int)this.renderSize.width, (int)this.renderSize.height);
      return;
    }
    releaseStickerTexture();
    createTavStickerTexture();
  }
  
  private void updateAllLayers()
  {
    Iterator localIterator = getStickers().iterator();
    while (localIterator.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
      if (localTAVSticker != null)
      {
        localTAVSticker.getPagFile().setVisible(shouldRenderSticker(localTAVSticker, this.presentationTimeMs));
        localTAVSticker.computeProgress(this.presentationTimeMs);
        Matrix localMatrix = TAVStickerUtil.getMatrix(localTAVSticker, (int)this.renderSize.width, (int)this.renderSize.height);
        localTAVSticker.getPagFile().setMatrix(localMatrix);
      }
    }
  }
  
  private void updateCompositionDuration()
  {
    Iterator localIterator = this.stickers.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
      if (localTAVSticker.getTimeRange() != null) {
        l = Math.max(l, localTAVSticker.getTimeRange().getEndUs());
      } else {
        l = Math.max(l, localTAVSticker.getPagFile().duration());
      }
    }
    this.realDuration = l;
  }
  
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
    TAVStickerRenderContext localTAVStickerRenderContext = new TAVStickerRenderContext(this.renderSize, this.realDuration);
    localTAVStickerRenderContext.checkStickerList();
    List localList = this.stickers;
    if (localList != null) {
      localTAVStickerRenderContext.stickers = localList;
    }
    localTAVStickerRenderContext.stickerLayerIndex = this.stickerLayerIndex;
    localTAVStickerRenderContext.renderContextDataSource = this.renderContextDataSource;
    localTAVStickerRenderContext.quality = this.quality;
    checkChildContexts();
    this.childContexts.add(localTAVStickerRenderContext);
    return localTAVStickerRenderContext;
  }
  
  protected void createCompositionRenderTree()
  {
    try
    {
      updateCompositionDuration();
      this.baseComposition = PAGComposition.Make((int)this.renderSize.width, (int)this.renderSize.height);
      PAGImageLayer localPAGImageLayer = PAGImageLayer.Make((int)this.renderSize.width, (int)this.renderSize.height, this.realDuration);
      if (localPAGImageLayer == null) {
        return;
      }
      localPAGImageLayer.setStartTime(0L);
      this.baseComposition.addLayer(localPAGImageLayer);
      this.rootComposition = PAGComposition.Make((int)this.renderSize.width, (int)this.renderSize.height);
      updateCompositionRenderTree();
      return;
    }
    finally {}
  }
  
  protected void createOrUpdateRenderTree()
  {
    try
    {
      if (this.rootComposition == null) {
        createCompositionRenderTree();
      } else {
        updateCompositionRenderTree();
      }
      return;
    }
    finally {}
  }
  
  protected boolean createPagPlayer()
  {
    createTavStickerTexture();
    if (this.stickerTexture == null)
    {
      TLog.e(TAG, "renderSticker -> mStickerTexture is null!");
      return false;
    }
    createPagSurface();
    if (this.pagSurface == null) {
      return false;
    }
    if (this.pagPlayer == null)
    {
      this.pagPlayer = new PAGPlayer();
      this.pagPlayer.setSurface(this.pagSurface);
      this.pagPlayer.setComposition(this.rootComposition);
      if (TAVStickerUtil.isValidCGSize(this.renderSize)) {
        resetRenderConfigs();
      }
    }
    return true;
  }
  
  protected void createPagSurface()
  {
    if (this.pagSurface == null)
    {
      this.isPagSurfaceFromTexture = true;
      this.pagSurface = PAGSurface.FromTexture(this.stickerTexture.getTextureInfo().textureID, this.stickerTexture.getTextureInfo().width, this.stickerTexture.getTextureInfo().height, true);
      PAGPlayer localPAGPlayer = this.pagPlayer;
      if (localPAGPlayer != null) {
        localPAGPlayer.setSurface(this.pagSurface);
      }
    }
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
  
  protected void createTavStickerTexture()
  {
    if (this.stickerTexture != null) {
      return;
    }
    if (TAVStickerUtil.isValidCGSize(this.renderSize)) {
      this.stickerTexture = new TAVStickerTexture((int)this.renderSize.width, (int)this.renderSize.height, 3553, 0);
    }
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
    createOrUpdateRenderTree();
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	com/tencent/tavsticker/core/TAVStickerRenderContext:providers	Ljava/util/List;
    //   6: invokeinterface 172 1 0
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface 177 1 0
    //   18: ifeq +24 -> 42
    //   21: aload_1
    //   22: invokeinterface 181 1 0
    //   27: checkcast 433	com/tencent/tavsticker/model/TAVStickerProvider
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull -20 -> 12
    //   35: aload_2
    //   36: invokevirtual 524	com/tencent/tavsticker/model/TAVStickerProvider:release	()V
    //   39: goto -27 -> 12
    //   42: aload_0
    //   43: getfield 60	com/tencent/tavsticker/core/TAVStickerRenderContext:providers	Ljava/util/List;
    //   46: invokeinterface 527 1 0
    //   51: aload_0
    //   52: iconst_0
    //   53: putfield 62	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerLayerIndex	I
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 66	com/tencent/tavsticker/core/TAVStickerRenderContext:renderContextDataSource	Lcom/tencent/tavsticker/core/ITAVRenderContextDataSource;
    //   61: aload_0
    //   62: invokespecial 196	com/tencent/tavsticker/core/TAVStickerRenderContext:releasePagSurface	()V
    //   65: aload_0
    //   66: invokespecial 246	com/tencent/tavsticker/core/TAVStickerRenderContext:releaseStickerTexture	()V
    //   69: aload_0
    //   70: getfield 87	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerSurface	Landroid/view/Surface;
    //   73: ifnull +15 -> 88
    //   76: aload_0
    //   77: getfield 87	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerSurface	Landroid/view/Surface;
    //   80: invokevirtual 395	android/view/Surface:release	()V
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 87	com/tencent/tavsticker/core/TAVStickerRenderContext:stickerSurface	Landroid/view/Surface;
    //   88: aload_0
    //   89: getfield 77	com/tencent/tavsticker/core/TAVStickerRenderContext:pagPlayer	Lorg/libpag/PAGPlayer;
    //   92: ifnull +10 -> 102
    //   95: aload_0
    //   96: getfield 77	com/tencent/tavsticker/core/TAVStickerRenderContext:pagPlayer	Lorg/libpag/PAGPlayer;
    //   99: invokevirtual 528	org/libpag/PAGPlayer:release	()V
    //   102: aload_0
    //   103: getfield 79	com/tencent/tavsticker/core/TAVStickerRenderContext:rootComposition	Lorg/libpag/PAGComposition;
    //   106: ifnull +10 -> 116
    //   109: aload_0
    //   110: getfield 79	com/tencent/tavsticker/core/TAVStickerRenderContext:rootComposition	Lorg/libpag/PAGComposition;
    //   113: invokevirtual 531	org/libpag/PAGComposition:removeAllLayers	()V
    //   116: getstatic 201	com/tencent/tavsticker/core/TAVStickerRenderContext:TAG	Ljava/lang/String;
    //   119: astore_1
    //   120: new 203	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   127: astore_2
    //   128: aload_2
    //   129: ldc_w 533
    //   132: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: invokestatic 539	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   140: invokevirtual 542	java/lang/Thread:getName	()Ljava/lang/String;
    //   143: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_2
    //   148: ldc_w 544
    //   151: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_2
    //   156: new 546	java/lang/RuntimeException
    //   159: dup
    //   160: invokespecial 547	java/lang/RuntimeException:<init>	()V
    //   163: invokestatic 553	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   166: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: aload_2
    //   172: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 357	com/tencent/tavsticker/log/TLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: goto +12 -> 190
    //   181: astore_1
    //   182: goto +11 -> 193
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 556	java/lang/Exception:printStackTrace	()V
    //   190: aload_0
    //   191: monitorexit
    //   192: return
    //   193: aload_0
    //   194: monitorexit
    //   195: goto +5 -> 200
    //   198: aload_1
    //   199: athrow
    //   200: goto -2 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	TAVStickerRenderContext
    //   11	160	1	localObject1	Object
    //   181	1	1	localObject2	Object
    //   185	14	1	localException	java.lang.Exception
    //   30	142	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	181	finally
    //   12	31	181	finally
    //   35	39	181	finally
    //   42	88	181	finally
    //   88	102	181	finally
    //   102	116	181	finally
    //   116	178	181	finally
    //   186	190	181	finally
    //   2	12	185	java/lang/Exception
    //   12	31	185	java/lang/Exception
    //   35	39	185	java/lang/Exception
    //   42	88	185	java/lang/Exception
    //   88	102	185	java/lang/Exception
    //   102	116	185	java/lang/Exception
    //   116	178	185	java/lang/Exception
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
    createOrUpdateRenderTree();
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
      createOrUpdateRenderTree();
    }
  }
  
  public void removeAllStickers()
  {
    checkStickerList();
    this.stickers.clear();
    syncAllChildContext();
    createOrUpdateRenderTree();
  }
  
  public boolean removeSticker(TAVSticker paramTAVSticker)
  {
    checkStickerList();
    boolean bool = this.stickers.remove(paramTAVSticker);
    syncAllChildContext();
    createOrUpdateRenderTree();
    return bool;
  }
  
  public CMSampleBuffer renderSticker(long paramLong, List<TAVSourceImage> paramList)
  {
    return renderSticker(paramLong, paramList, null);
  }
  
  public CMSampleBuffer renderSticker(long paramLong, List<TAVSourceImage> paramList, EGLContext paramEGLContext)
  {
    long l1 = System.currentTimeMillis();
    this.presentationTimeMs = paramLong;
    checkStickerList();
    checkStickerProviderList();
    if (this.stickers.isEmpty()) {
      return null;
    }
    if (this.rootComposition == null) {
      createCompositionRenderTree();
    }
    if (!createPagPlayer()) {
      return null;
    }
    paramEGLContext = this.cacheImagesForRelease;
    if (paramEGLContext != null) {
      releaseCacheImages(paramEGLContext);
    }
    updateAllLayers();
    long l2 = 1000L * paramLong;
    replaceSourceImage(l2, paramList);
    this.rootComposition.setCurrentTime(l2);
    boolean bool = this.pagPlayer.flush();
    if (!CollectionUtil.isEmptyList(paramList)) {
      this.cacheImagesForRelease = new ArrayList(paramList);
    }
    l2 = System.currentTimeMillis();
    paramList = TAG;
    paramEGLContext = new StringBuilder();
    paramEGLContext.append("贴纸渲染耗时：");
    paramEGLContext.append(l2 - l1);
    Logger.e(paramList, paramEGLContext.toString(), null);
    return new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(paramLong)), this.stickerTexture.getTextureInfo(), bool);
  }
  
  protected void resetRenderConfigs()
  {
    if (this.pagPlayer == null) {
      return;
    }
    if ((this.quality != TAVStickerQuality.TAVStickerQualityHigh) && (TAVStickerUtil.isValidCGSize(this.renderSize)))
    {
      this.pagPlayer.setMaxFrameRate(24.0F);
      float f3 = ScreenUtil.getScreenWidth();
      float f1 = ScreenUtil.getScreenHeight();
      float f4 = this.renderSize.width;
      float f2 = this.renderSize.height;
      f3 = f4 / (f3 * 1.0F);
      f1 = f2 / (f1 * 1.0F);
      this.pagPlayer.setCacheScale(Math.max(f3, f1));
      return;
    }
    this.pagPlayer.setCacheEnabled(true);
    this.pagPlayer.setMaxFrameRate(60.0F);
    this.pagPlayer.setCacheScale(1.0F);
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
  
  public void setRealDuration(long paramLong)
  {
    this.realDuration = paramLong;
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    if ((TAVStickerUtil.isValidCGSize(paramCGSize)) && (!paramCGSize.equals(this.renderSize)))
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRenderSize -> render size changed, oldRenderSize : ");
      localStringBuilder.append(this.renderSize);
      localStringBuilder.append(", newRenderSize : ");
      localStringBuilder.append(paramCGSize);
      TLog.d(str, localStringBuilder.toString());
      this.renderSize = paramCGSize;
      if (this.stickerTexture != null) {
        resetOrUpdateStickerTexture();
      }
      if (this.pagSurface != null) {
        resetOrUpdatePagSurface();
      }
      resetRenderConfigs();
      resetComposition();
      createOrUpdateRenderTree();
      rebindComposition();
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
  
  protected void sortedStickersByLayerIndex(List<TAVSticker> paramList)
  {
    Collections.sort(paramList, new TAVStickerRenderContext.3(this));
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
        localTAVStickerRenderContext.setRealDuration(this.realDuration);
        localTAVStickerRenderContext.stickerLayerIndex = this.stickerLayerIndex;
        localTAVStickerRenderContext.renderContextDataSource = this.renderContextDataSource;
        localTAVStickerRenderContext.quality = this.quality;
      }
    }
  }
  
  protected void updateCompositionRenderTree()
  {
    try
    {
      this.rootComposition.removeAllLayers();
      this.rootComposition.addLayer(this.baseComposition);
      sortedStickersByLayerIndex(this.stickers);
      if (!this.stickers.isEmpty())
      {
        Iterator localIterator = this.stickers.iterator();
        while (localIterator.hasNext())
        {
          TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
          if ((localTAVSticker != null) && (localTAVSticker.getPagFile() != null))
          {
            localTAVSticker.updateTextData();
            localTAVSticker.updateImageData();
            localTAVSticker.updateLayerColor();
            localTAVSticker.updateTransform(this.renderSize);
            this.rootComposition.addLayer(localTAVSticker.getPagFile());
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerRenderContext
 * JD-Core Version:    0.7.0.1
 */