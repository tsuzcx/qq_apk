package com.tencent.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Log;
import com.tencent.autotemplate.filter.GaosiBlurFilter;
import com.tencent.autotemplate.filter.ScaleTextureFilter;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager;", "", "()V", "observersOfContext", "Ljava/util/HashMap;", "Lcom/tencent/tavsticker/core/TAVStickerRenderContext;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager$SourceImageObserver;", "Lkotlin/collections/HashMap;", "<set-?>", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "renderInfo", "renderInfo$annotations", "getRenderInfo", "()Lcom/tencent/tavkit/composition/video/RenderInfo;", "Lcom/tencent/tavkit/ciimage/CIImage;", "sourceCIImage", "sourceCIImage$annotations", "getSourceCIImage", "()Lcom/tencent/tavkit/ciimage/CIImage;", "getBlurRect", "Lcom/tencent/tav/coremedia/CGRect;", "rotation", "", "sticker", "Lcom/tencent/tavsticker/model/TAVSticker;", "realBlurCiImage", "info", "getBlurredTextureInfo", "Lcom/tencent/tav/coremedia/TextureInfo;", "holderTextureInfo", "blurRadius", "blurScale", "", "horizontalBlurFilter", "Lcom/tencent/autotemplate/filter/GaosiBlurFilter;", "verticalBlurFilter", "scaleSmallTextureFilter", "Lcom/tencent/autotemplate/filter/ScaleTextureFilter;", "scaleBigTextureFilter", "renderWidth", "renderHeight", "getTavTextureInfo", "Lcom/tencent/taveffect/core/TAVTextureInfo;", "getTextureInfo", "rendererWidth", "rendererHeight", "textureAfterBlur", "registerSourceImageObserver", "", "stickerContext", "uniqId", "observer", "unregisterSourceImageObserver", "updateSourceCIImage", "SourceImageObserver", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class WSOverLayBlurManager
{
  public static final WSOverLayBlurManager INSTANCE = new WSOverLayBlurManager();
  private static final HashMap<TAVStickerRenderContext, HashMap<String, WeakReference<WSOverLayBlurManager.SourceImageObserver>>> observersOfContext = new HashMap();
  @Nullable
  private static RenderInfo renderInfo;
  @Nullable
  private static CIImage sourceCIImage;
  
  @JvmStatic
  @NotNull
  public static final CGRect getBlurRect(int paramInt, @NotNull TAVSticker paramTAVSticker, @Nullable CIImage paramCIImage, @NotNull RenderInfo paramRenderInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVSticker, "sticker");
    Intrinsics.checkParameterIsNotNull(paramRenderInfo, "info");
    paramTAVSticker = TAVStickerUtil.computeRectanglePoints(WsStickerUtil.getRatioChangeMatrix(paramTAVSticker, (int)paramRenderInfo.getRenderSize().width, (int)paramRenderInfo.getRenderSize().height), paramTAVSticker.getWidth(), paramTAVSticker.getHeight());
    paramCIImage = new CGRect();
    Object localObject = paramCIImage.size;
    if (paramInt == 1)
    {
      f = paramTAVSticker[1].x - paramTAVSticker[0].x;
      ((CGSize)localObject).height = f;
      localObject = paramCIImage.size;
      if (paramInt != 1) {
        break label216;
      }
      f = paramTAVSticker[3].y - paramTAVSticker[0].y;
      label113:
      ((CGSize)localObject).width = f;
      localObject = paramCIImage.origin;
      if (paramInt != 1) {
        break label234;
      }
      f = paramRenderInfo.getRenderSize().height - paramTAVSticker[1].y - paramCIImage.size.width;
      label155:
      ((PointF)localObject).x = f;
      localObject = paramCIImage.origin;
      if (paramInt != 1) {
        break label245;
      }
    }
    label216:
    label234:
    label245:
    for (float f = paramRenderInfo.getRenderSize().width - paramTAVSticker[1].x;; f = paramRenderInfo.getRenderSize().height - paramTAVSticker[1].y - paramCIImage.size.height)
    {
      ((PointF)localObject).y = f;
      return paramCIImage;
      f = paramTAVSticker[3].y - paramTAVSticker[0].y;
      break;
      f = paramTAVSticker[1].x - paramTAVSticker[0].x;
      break label113;
      f = paramTAVSticker[0].x;
      break label155;
    }
  }
  
  @JvmStatic
  @NotNull
  public static final TextureInfo getBlurredTextureInfo(@NotNull TextureInfo paramTextureInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, @NotNull GaosiBlurFilter paramGaosiBlurFilter1, @NotNull GaosiBlurFilter paramGaosiBlurFilter2, @NotNull ScaleTextureFilter paramScaleTextureFilter1, @NotNull ScaleTextureFilter paramScaleTextureFilter2)
  {
    for (;;)
    {
      try
      {
        Intrinsics.checkParameterIsNotNull(paramTextureInfo, "holderTextureInfo");
        Intrinsics.checkParameterIsNotNull(paramGaosiBlurFilter1, "horizontalBlurFilter");
        Intrinsics.checkParameterIsNotNull(paramGaosiBlurFilter2, "verticalBlurFilter");
        Intrinsics.checkParameterIsNotNull(paramScaleTextureFilter1, "scaleSmallTextureFilter");
        Intrinsics.checkParameterIsNotNull(paramScaleTextureFilter2, "scaleBigTextureFilter");
        int i;
        if (paramInt3 == 0)
        {
          i = paramInt1;
          break label221;
          paramGaosiBlurFilter1.setRadius(paramInt4);
          paramGaosiBlurFilter2.setRadius(paramInt4);
          TAVTextureInfo localTAVTextureInfo = INSTANCE.getTavTextureInfo(paramTextureInfo);
          paramInt1 = (int)Math.floor(paramTextureInfo.width * paramFloat);
          paramInt3 = (int)Math.floor(paramTextureInfo.height * paramFloat);
          paramGaosiBlurFilter1.setRendererWidth(paramInt1);
          paramGaosiBlurFilter1.setRendererHeight(paramInt3);
          paramGaosiBlurFilter2.setRendererWidth(paramInt1);
          paramGaosiBlurFilter2.setRendererHeight(paramInt3);
          paramScaleTextureFilter1.setRendererWidth(paramInt1);
          paramScaleTextureFilter1.setRendererHeight(paramInt3);
          paramScaleTextureFilter2.setRendererWidth(i);
          paramScaleTextureFilter2.setRendererHeight(paramInt2);
          paramScaleTextureFilter1.scale(paramFloat, 0.0F, 0.0F);
          paramGaosiBlurFilter1 = paramGaosiBlurFilter2.applyFilter(paramGaosiBlurFilter1.applyFilter(paramScaleTextureFilter1.applyFilter(localTAVTextureInfo)));
          paramGaosiBlurFilter2 = INSTANCE;
          Intrinsics.checkExpressionValueIsNotNull(paramGaosiBlurFilter1, "textureAfterBlur");
          paramTextureInfo = paramGaosiBlurFilter2.getTextureInfo(paramTextureInfo, i, paramInt2, paramGaosiBlurFilter1);
          return paramTextureInfo;
        }
        else
        {
          i = paramInt2;
        }
      }
      finally {}
      paramInt2 = paramInt1;
      continue;
      label221:
      if (paramInt3 != 0) {}
    }
  }
  
  /* Error */
  @JvmStatic
  @NotNull
  public static final TextureInfo getBlurredTextureInfo(@NotNull TextureInfo paramTextureInfo, @NotNull RenderInfo paramRenderInfo, int paramInt1, int paramInt2, float paramFloat, @NotNull GaosiBlurFilter paramGaosiBlurFilter1, @NotNull GaosiBlurFilter paramGaosiBlurFilter2, @NotNull ScaleTextureFilter paramScaleTextureFilter1, @NotNull ScaleTextureFilter paramScaleTextureFilter2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 156
    //   6: invokestatic 95	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_1
    //   10: ldc 210
    //   12: invokestatic 95	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload 5
    //   17: ldc 157
    //   19: invokestatic 95	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   22: aload 6
    //   24: ldc 158
    //   26: invokestatic 95	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload 7
    //   31: ldc 159
    //   33: invokestatic 95	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   36: aload 8
    //   38: ldc 160
    //   40: invokestatic 95	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   43: iload_2
    //   44: ifne +205 -> 249
    //   47: aload_1
    //   48: invokevirtual 213	com/tencent/tavkit/composition/video/RenderInfo:getRenderWidth	()I
    //   51: istore 9
    //   53: iload_2
    //   54: ifne +204 -> 258
    //   57: aload_1
    //   58: invokevirtual 216	com/tencent/tavkit/composition/video/RenderInfo:getRenderHeight	()I
    //   61: istore_2
    //   62: aload 5
    //   64: iload_3
    //   65: invokevirtual 166	com/tencent/autotemplate/filter/GaosiBlurFilter:setRadius	(I)V
    //   68: aload 6
    //   70: iload_3
    //   71: invokevirtual 166	com/tencent/autotemplate/filter/GaosiBlurFilter:setRadius	(I)V
    //   74: getstatic 78	com/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager:INSTANCE	Lcom/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager;
    //   77: aload_0
    //   78: invokespecial 169	com/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager:getTavTextureInfo	(Lcom/tencent/tav/coremedia/TextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 174	com/tencent/tav/coremedia/TextureInfo:width	I
    //   86: i2d
    //   87: fload 4
    //   89: f2d
    //   90: dmul
    //   91: invokestatic 180	java/lang/Math:floor	(D)D
    //   94: d2i
    //   95: istore_3
    //   96: aload_0
    //   97: getfield 182	com/tencent/tav/coremedia/TextureInfo:height	I
    //   100: i2d
    //   101: fload 4
    //   103: f2d
    //   104: dmul
    //   105: invokestatic 180	java/lang/Math:floor	(D)D
    //   108: d2i
    //   109: istore 10
    //   111: aload 5
    //   113: iload_3
    //   114: invokevirtual 185	com/tencent/autotemplate/filter/GaosiBlurFilter:setRendererWidth	(I)V
    //   117: aload 5
    //   119: iload 10
    //   121: invokevirtual 188	com/tencent/autotemplate/filter/GaosiBlurFilter:setRendererHeight	(I)V
    //   124: aload 6
    //   126: iload_3
    //   127: invokevirtual 185	com/tencent/autotemplate/filter/GaosiBlurFilter:setRendererWidth	(I)V
    //   130: aload 6
    //   132: iload 10
    //   134: invokevirtual 188	com/tencent/autotemplate/filter/GaosiBlurFilter:setRendererHeight	(I)V
    //   137: aload 7
    //   139: iload_3
    //   140: invokevirtual 191	com/tencent/autotemplate/filter/ScaleTextureFilter:setRendererWidth	(I)V
    //   143: aload 7
    //   145: iload 10
    //   147: invokevirtual 192	com/tencent/autotemplate/filter/ScaleTextureFilter:setRendererHeight	(I)V
    //   150: aload 8
    //   152: iload 9
    //   154: invokevirtual 191	com/tencent/autotemplate/filter/ScaleTextureFilter:setRendererWidth	(I)V
    //   157: aload 8
    //   159: iload_2
    //   160: invokevirtual 192	com/tencent/autotemplate/filter/ScaleTextureFilter:setRendererHeight	(I)V
    //   163: aload 7
    //   165: fload 4
    //   167: fconst_0
    //   168: fconst_0
    //   169: invokevirtual 196	com/tencent/autotemplate/filter/ScaleTextureFilter:scale	(FFF)V
    //   172: aload 6
    //   174: aload 5
    //   176: aload 7
    //   178: aload_1
    //   179: invokevirtual 200	com/tencent/autotemplate/filter/ScaleTextureFilter:applyFilter	(Lcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   182: invokevirtual 201	com/tencent/autotemplate/filter/GaosiBlurFilter:applyFilter	(Lcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   185: invokevirtual 201	com/tencent/autotemplate/filter/GaosiBlurFilter:applyFilter	(Lcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   188: astore_1
    //   189: aload 8
    //   191: fconst_1
    //   192: iload_2
    //   193: i2f
    //   194: fmul
    //   195: iload 10
    //   197: i2f
    //   198: fdiv
    //   199: fconst_1
    //   200: iload 9
    //   202: i2f
    //   203: fmul
    //   204: iload_3
    //   205: i2f
    //   206: fdiv
    //   207: invokestatic 220	java/lang/Math:max	(FF)F
    //   210: fconst_0
    //   211: fconst_0
    //   212: invokevirtual 196	com/tencent/autotemplate/filter/ScaleTextureFilter:scale	(FFF)V
    //   215: aload 8
    //   217: aload_1
    //   218: invokevirtual 200	com/tencent/autotemplate/filter/ScaleTextureFilter:applyFilter	(Lcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   221: astore_1
    //   222: getstatic 78	com/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager:INSTANCE	Lcom/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager;
    //   225: astore 5
    //   227: aload_1
    //   228: ldc 202
    //   230: invokestatic 205	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   233: aload 5
    //   235: aload_0
    //   236: iload 9
    //   238: iload_2
    //   239: aload_1
    //   240: invokespecial 208	com/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager:getTextureInfo	(Lcom/tencent/tav/coremedia/TextureInfo;IILcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/tav/coremedia/TextureInfo;
    //   243: astore_0
    //   244: ldc 2
    //   246: monitorexit
    //   247: aload_0
    //   248: areturn
    //   249: aload_1
    //   250: invokevirtual 216	com/tencent/tavkit/composition/video/RenderInfo:getRenderHeight	()I
    //   253: istore 9
    //   255: goto -202 -> 53
    //   258: aload_1
    //   259: invokevirtual 213	com/tencent/tavkit/composition/video/RenderInfo:getRenderWidth	()I
    //   262: istore_2
    //   263: goto -201 -> 62
    //   266: astore_0
    //   267: ldc 2
    //   269: monitorexit
    //   270: aload_0
    //   271: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramTextureInfo	TextureInfo
    //   0	272	1	paramRenderInfo	RenderInfo
    //   0	272	2	paramInt1	int
    //   0	272	3	paramInt2	int
    //   0	272	4	paramFloat	float
    //   0	272	5	paramGaosiBlurFilter1	GaosiBlurFilter
    //   0	272	6	paramGaosiBlurFilter2	GaosiBlurFilter
    //   0	272	7	paramScaleTextureFilter1	ScaleTextureFilter
    //   0	272	8	paramScaleTextureFilter2	ScaleTextureFilter
    //   51	203	9	i	int
    //   109	87	10	j	int
    // Exception table:
    //   from	to	target	type
    //   3	43	266	finally
    //   47	53	266	finally
    //   57	62	266	finally
    //   62	244	266	finally
    //   249	255	266	finally
    //   258	263	266	finally
  }
  
  @Nullable
  public static final RenderInfo getRenderInfo()
  {
    try
    {
      RenderInfo localRenderInfo = renderInfo;
      return localRenderInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Nullable
  public static final CIImage getSourceCIImage()
  {
    try
    {
      CIImage localCIImage = sourceCIImage;
      return localCIImage;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final TAVTextureInfo getTavTextureInfo(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo.getTextureMatrix() != null)
    {
      float[] arrayOfFloat = new float[9];
      paramTextureInfo.getTextureMatrix().getValues(arrayOfFloat);
      return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, arrayOfFloat, paramTextureInfo.preferRotation);
    }
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, null, paramTextureInfo.preferRotation);
  }
  
  private final TextureInfo getTextureInfo(TextureInfo paramTextureInfo, int paramInt1, int paramInt2, TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramInt1, paramInt2, paramTextureInfo.getTextureMatrix(), paramTextureInfo.preferRotation);
  }
  
  @JvmStatic
  public static final void registerSourceImageObserver(@NotNull TAVStickerRenderContext paramTAVStickerRenderContext, @NotNull String paramString, @Nullable WSOverLayBlurManager.SourceImageObserver paramSourceImageObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVStickerRenderContext, "stickerContext");
    Intrinsics.checkParameterIsNotNull(paramString, "uniqId");
    if (paramSourceImageObserver != null)
    {
      Log.d("genglin", "register: " + paramSourceImageObserver.hashCode());
      if (!observersOfContext.containsKey(paramTAVStickerRenderContext)) {
        ((Map)observersOfContext).put(paramTAVStickerRenderContext, new HashMap());
      }
      HashMap localHashMap = (HashMap)observersOfContext.get(paramTAVStickerRenderContext);
      if ((localHashMap != null) && (!localHashMap.containsKey(paramString)))
      {
        paramSourceImageObserver = new WeakReference(paramSourceImageObserver);
        paramTAVStickerRenderContext = (HashMap)observersOfContext.get(paramTAVStickerRenderContext);
        if (paramTAVStickerRenderContext != null) {
          paramTAVStickerRenderContext = (WeakReference)paramTAVStickerRenderContext.put(paramString, paramSourceImageObserver);
        }
      }
    }
  }
  
  @JvmStatic
  public static final void unregisterSourceImageObserver(@NotNull TAVStickerRenderContext paramTAVStickerRenderContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVStickerRenderContext, "stickerContext");
    Intrinsics.checkParameterIsNotNull(paramString, "uniqId");
    Log.d("genglin", "unregister: " + paramString);
    HashMap localHashMap = (HashMap)observersOfContext.get(paramTAVStickerRenderContext);
    if (localHashMap != null) {
      paramString = (WeakReference)localHashMap.remove(paramString);
    }
    paramString = new StringBuilder().append("unregisterSourceImageObserver: size = ");
    paramTAVStickerRenderContext = (HashMap)observersOfContext.get(paramTAVStickerRenderContext);
    if (paramTAVStickerRenderContext != null) {}
    for (paramTAVStickerRenderContext = Integer.valueOf(paramTAVStickerRenderContext.size());; paramTAVStickerRenderContext = null)
    {
      Log.d("genglin", paramTAVStickerRenderContext);
      return;
    }
  }
  
  @JvmStatic
  public static final void updateSourceCIImage(@NotNull TAVStickerRenderContext paramTAVStickerRenderContext, @Nullable CIImage paramCIImage, @Nullable RenderInfo paramRenderInfo)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramTAVStickerRenderContext, "stickerContext");
      sourceCIImage = paramCIImage;
      renderInfo = paramRenderInfo;
      Object localObject = new StringBuilder().append("updateSourceCIImage: thread = ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      Log.d("sticker_size", localThread.getName());
      paramTAVStickerRenderContext = (HashMap)observersOfContext.get(paramTAVStickerRenderContext);
      if (paramTAVStickerRenderContext != null)
      {
        paramTAVStickerRenderContext = ((Map)paramTAVStickerRenderContext).entrySet().iterator();
        while (paramTAVStickerRenderContext.hasNext())
        {
          localObject = (WeakReference)((Map.Entry)paramTAVStickerRenderContext.next()).getValue();
          if (localObject != null)
          {
            localObject = (WSOverLayBlurManager.SourceImageObserver)((WeakReference)localObject).get();
            if (localObject != null) {
              ((WSOverLayBlurManager.SourceImageObserver)localObject).onSourceImageUpdated(paramCIImage, paramRenderInfo);
            }
          }
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSOverLayBlurManager
 * JD-Core Version:    0.7.0.1
 */