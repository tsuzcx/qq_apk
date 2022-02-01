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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager;", "", "()V", "observersOfContext", "Ljava/util/HashMap;", "Lcom/tencent/tavsticker/core/TAVStickerRenderContext;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager$SourceImageObserver;", "Lkotlin/collections/HashMap;", "<set-?>", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "renderInfo", "renderInfo$annotations", "getRenderInfo", "()Lcom/tencent/tavkit/composition/video/RenderInfo;", "Lcom/tencent/tavkit/ciimage/CIImage;", "sourceCIImage", "sourceCIImage$annotations", "getSourceCIImage", "()Lcom/tencent/tavkit/ciimage/CIImage;", "getBlurRect", "Lcom/tencent/tav/coremedia/CGRect;", "rotation", "", "sticker", "Lcom/tencent/tavsticker/model/TAVSticker;", "realBlurCiImage", "info", "getBlurredTextureInfo", "Lcom/tencent/tav/coremedia/TextureInfo;", "holderTextureInfo", "blurRadius", "blurScale", "", "horizontalBlurFilter", "Lcom/tencent/autotemplate/filter/GaosiBlurFilter;", "verticalBlurFilter", "scaleSmallTextureFilter", "Lcom/tencent/autotemplate/filter/ScaleTextureFilter;", "scaleBigTextureFilter", "renderWidth", "renderHeight", "getTavTextureInfo", "Lcom/tencent/taveffect/core/TAVTextureInfo;", "getTextureInfo", "rendererWidth", "rendererHeight", "textureAfterBlur", "registerSourceImageObserver", "", "stickerContext", "uniqId", "observer", "release", "unregisterSourceImageObserver", "updateSourceCIImage", "SourceImageObserver", "libtavcut_debug"}, k=1, mv={1, 1, 16})
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
    float f1;
    float f2;
    if (paramInt == 1)
    {
      f1 = paramTAVSticker[1].x;
      f2 = paramTAVSticker[0].x;
    }
    else
    {
      f1 = paramTAVSticker[3].y;
      f2 = paramTAVSticker[0].y;
    }
    ((CGSize)localObject).height = (f1 - f2);
    localObject = paramCIImage.size;
    if (paramInt == 1)
    {
      f1 = paramTAVSticker[3].y;
      f2 = paramTAVSticker[0].y;
    }
    else
    {
      f1 = paramTAVSticker[1].x;
      f2 = paramTAVSticker[0].x;
    }
    ((CGSize)localObject).width = (f1 - f2);
    localObject = paramCIImage.origin;
    if (paramInt == 1) {
      f1 = paramRenderInfo.getRenderSize().height - paramTAVSticker[1].y - paramCIImage.size.width;
    } else {
      f1 = paramTAVSticker[0].x;
    }
    ((PointF)localObject).x = f1;
    localObject = paramCIImage.origin;
    if (paramInt == 1)
    {
      f1 = paramRenderInfo.getRenderSize().width;
      f2 = paramTAVSticker[1].x;
    }
    else
    {
      f1 = paramRenderInfo.getRenderSize().height - paramTAVSticker[1].y;
      f2 = paramCIImage.size.height;
    }
    ((PointF)localObject).y = (f1 - f2);
    return paramCIImage;
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
        if (paramInt3 != 0) {
          break label249;
        }
        i = paramInt1;
      }
      finally {}
      paramGaosiBlurFilter1.setRadius(paramInt4);
      paramGaosiBlurFilter2.setRadius(paramInt4);
      TAVTextureInfo localTAVTextureInfo = INSTANCE.getTavTextureInfo(paramTextureInfo);
      paramInt2 = paramTextureInfo.width;
      double d2 = paramInt2;
      double d1 = paramFloat;
      Double.isNaN(d2);
      Double.isNaN(d1);
      paramInt2 = (int)Math.floor(d2 * d1);
      paramInt3 = paramTextureInfo.height;
      d2 = paramInt3;
      Double.isNaN(d2);
      Double.isNaN(d1);
      paramInt3 = (int)Math.floor(d2 * d1);
      paramGaosiBlurFilter1.setRendererWidth(paramInt2);
      paramGaosiBlurFilter1.setRendererHeight(paramInt3);
      paramGaosiBlurFilter2.setRendererWidth(paramInt2);
      paramGaosiBlurFilter2.setRendererHeight(paramInt3);
      paramScaleTextureFilter1.setRendererWidth(paramInt2);
      paramScaleTextureFilter1.setRendererHeight(paramInt3);
      paramScaleTextureFilter2.setRendererWidth(i);
      paramScaleTextureFilter2.setRendererHeight(paramInt1);
      paramScaleTextureFilter1.scale(paramFloat, 0.0F, 0.0F);
      paramGaosiBlurFilter1 = paramGaosiBlurFilter2.applyFilter(paramGaosiBlurFilter1.applyFilter(paramScaleTextureFilter1.applyFilter(localTAVTextureInfo)));
      paramGaosiBlurFilter2 = INSTANCE;
      Intrinsics.checkExpressionValueIsNotNull(paramGaosiBlurFilter1, "textureAfterBlur");
      paramTextureInfo = paramGaosiBlurFilter2.getTextureInfo(paramTextureInfo, i, paramInt1, paramGaosiBlurFilter1);
      return paramTextureInfo;
      label249:
      int i = paramInt2;
      if (paramInt3 == 0) {
        paramInt1 = paramInt2;
      }
    }
  }
  
  @JvmStatic
  @NotNull
  public static final TextureInfo getBlurredTextureInfo(@NotNull TextureInfo paramTextureInfo, @NotNull RenderInfo paramRenderInfo, int paramInt1, int paramInt2, float paramFloat, @NotNull GaosiBlurFilter paramGaosiBlurFilter1, @NotNull GaosiBlurFilter paramGaosiBlurFilter2, @NotNull ScaleTextureFilter paramScaleTextureFilter1, @NotNull ScaleTextureFilter paramScaleTextureFilter2)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramTextureInfo, "holderTextureInfo");
      Intrinsics.checkParameterIsNotNull(paramRenderInfo, "renderInfo");
      Intrinsics.checkParameterIsNotNull(paramGaosiBlurFilter1, "horizontalBlurFilter");
      Intrinsics.checkParameterIsNotNull(paramGaosiBlurFilter2, "verticalBlurFilter");
      Intrinsics.checkParameterIsNotNull(paramScaleTextureFilter1, "scaleSmallTextureFilter");
      Intrinsics.checkParameterIsNotNull(paramScaleTextureFilter2, "scaleBigTextureFilter");
      int i;
      if (paramInt1 == 0) {
        i = paramRenderInfo.getRenderWidth();
      } else {
        i = paramRenderInfo.getRenderHeight();
      }
      if (paramInt1 == 0) {
        paramInt1 = paramRenderInfo.getRenderHeight();
      } else {
        paramInt1 = paramRenderInfo.getRenderWidth();
      }
      paramGaosiBlurFilter1.setRadius(paramInt2);
      paramGaosiBlurFilter2.setRadius(paramInt2);
      paramRenderInfo = INSTANCE.getTavTextureInfo(paramTextureInfo);
      paramInt2 = paramTextureInfo.width;
      double d2 = paramInt2;
      double d1 = paramFloat;
      Double.isNaN(d2);
      Double.isNaN(d1);
      paramInt2 = (int)Math.floor(d2 * d1);
      int j = paramTextureInfo.height;
      d2 = j;
      Double.isNaN(d2);
      Double.isNaN(d1);
      j = (int)Math.floor(d2 * d1);
      paramGaosiBlurFilter1.setRendererWidth(paramInt2);
      paramGaosiBlurFilter1.setRendererHeight(j);
      paramGaosiBlurFilter2.setRendererWidth(paramInt2);
      paramGaosiBlurFilter2.setRendererHeight(j);
      paramScaleTextureFilter1.setRendererWidth(paramInt2);
      paramScaleTextureFilter1.setRendererHeight(j);
      paramScaleTextureFilter2.setRendererWidth(i);
      paramScaleTextureFilter2.setRendererHeight(paramInt1);
      paramScaleTextureFilter1.scale(paramFloat, 0.0F, 0.0F);
      paramRenderInfo = paramGaosiBlurFilter2.applyFilter(paramGaosiBlurFilter1.applyFilter(paramScaleTextureFilter1.applyFilter(paramRenderInfo)));
      paramScaleTextureFilter2.scale(Math.max(paramInt1 * 1.0F / j, i * 1.0F / paramInt2), 0.0F, 0.0F);
      paramRenderInfo = paramScaleTextureFilter2.applyFilter(paramRenderInfo);
      paramGaosiBlurFilter1 = INSTANCE;
      Intrinsics.checkExpressionValueIsNotNull(paramRenderInfo, "textureAfterBlur");
      paramTextureInfo = paramGaosiBlurFilter1.getTextureInfo(paramTextureInfo, i, paramInt1, paramRenderInfo);
      return paramTextureInfo;
    }
    finally {}
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("register: ");
      ((StringBuilder)localObject).append(paramSourceImageObserver.hashCode());
      Log.d("genglin", ((StringBuilder)localObject).toString());
      if (!observersOfContext.containsKey(paramTAVStickerRenderContext)) {
        ((Map)observersOfContext).put(paramTAVStickerRenderContext, new HashMap());
      }
      localObject = (HashMap)observersOfContext.get(paramTAVStickerRenderContext);
      if ((localObject != null) && (!((HashMap)localObject).containsKey(paramString)))
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
  public static final void release()
  {
    CIImage localCIImage = sourceCIImage;
    if (localCIImage != null) {
      localCIImage.release();
    }
    if (renderInfo != null) {
      renderInfo = (RenderInfo)null;
    }
  }
  
  @JvmStatic
  public static final void unregisterSourceImageObserver(@NotNull TAVStickerRenderContext paramTAVStickerRenderContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVStickerRenderContext, "stickerContext");
    Intrinsics.checkParameterIsNotNull(paramString, "uniqId");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unregister: ");
    ((StringBuilder)localObject).append(paramString);
    Log.d("genglin", ((StringBuilder)localObject).toString());
    localObject = (HashMap)observersOfContext.get(paramTAVStickerRenderContext);
    if (localObject != null) {
      paramString = (WeakReference)((HashMap)localObject).remove(paramString);
    }
    paramString = new StringBuilder();
    paramString.append("unregisterSourceImageObserver: size = ");
    paramTAVStickerRenderContext = (HashMap)observersOfContext.get(paramTAVStickerRenderContext);
    if (paramTAVStickerRenderContext != null) {
      paramTAVStickerRenderContext = Integer.valueOf(paramTAVStickerRenderContext.size());
    } else {
      paramTAVStickerRenderContext = null;
    }
    paramString.append(paramTAVStickerRenderContext);
    Log.d("genglin", paramString.toString());
  }
  
  @JvmStatic
  public static final void updateSourceCIImage(@NotNull TAVStickerRenderContext paramTAVStickerRenderContext, @Nullable CIImage paramCIImage, @Nullable RenderInfo paramRenderInfo)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramTAVStickerRenderContext, "stickerContext");
      sourceCIImage = paramCIImage;
      renderInfo = paramRenderInfo;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateSourceCIImage: thread = ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      ((StringBuilder)localObject).append(localThread.getName());
      Log.d("sticker_size", ((StringBuilder)localObject).toString());
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
    for (;;)
    {
      throw paramTAVStickerRenderContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSOverLayBlurManager
 * JD-Core Version:    0.7.0.1
 */