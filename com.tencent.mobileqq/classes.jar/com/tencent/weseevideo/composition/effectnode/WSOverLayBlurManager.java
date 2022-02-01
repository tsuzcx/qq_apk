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
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class WSOverLayBlurManager
{
  private static volatile WSOverLayBlurManager instance;
  private HashMap<String, WeakReference<WSOverLayBlurManager.SourceImageObserver>> observers = new HashMap();
  private RenderInfo renderInfo;
  private CIImage sourceCIImage;
  
  @NotNull
  public static CGRect getBlurRect(int paramInt, TAVSticker paramTAVSticker, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    paramTAVSticker = TAVStickerUtil.computeRectanglePoints(WsStickerUtil.getRatioChangeMatrix(paramTAVSticker, (int)paramRenderInfo.getRenderSize().width, (int)paramRenderInfo.getRenderSize().height), paramTAVSticker.getWidth(), paramTAVSticker.getHeight());
    paramCIImage = new CGRect();
    Object localObject = paramCIImage.size;
    if (paramInt == 1)
    {
      f = paramTAVSticker[1].x - paramTAVSticker[0].x;
      ((CGSize)localObject).height = f;
      localObject = paramCIImage.size;
      if (paramInt != 1) {
        break label204;
      }
      f = paramTAVSticker[3].y - paramTAVSticker[0].y;
      label101:
      ((CGSize)localObject).width = f;
      localObject = paramCIImage.origin;
      if (paramInt != 1) {
        break label222;
      }
      f = paramRenderInfo.getRenderSize().height - paramTAVSticker[1].y - paramCIImage.size.width;
      label143:
      ((PointF)localObject).x = f;
      localObject = paramCIImage.origin;
      if (paramInt != 1) {
        break label233;
      }
    }
    label204:
    label222:
    label233:
    for (float f = paramRenderInfo.getRenderSize().width - paramTAVSticker[1].x;; f = paramRenderInfo.getRenderSize().height - paramTAVSticker[1].y - paramCIImage.size.height)
    {
      ((PointF)localObject).y = f;
      return paramCIImage;
      f = paramTAVSticker[3].y - paramTAVSticker[0].y;
      break;
      f = paramTAVSticker[1].x - paramTAVSticker[0].x;
      break label101;
      f = paramTAVSticker[0].x;
      break label143;
    }
  }
  
  public static WSOverLayBlurManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new WSOverLayBlurManager();
      }
      return instance;
    }
    finally {}
  }
  
  @NotNull
  public static TAVTextureInfo getTavTextureInfo(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo.getTextureMatrix() != null)
    {
      float[] arrayOfFloat = new float[9];
      paramTextureInfo.getTextureMatrix().getValues(arrayOfFloat);
      return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, arrayOfFloat, paramTextureInfo.preferRotation);
    }
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, null, paramTextureInfo.preferRotation);
  }
  
  @NotNull
  public static TextureInfo getTextureInfo(TextureInfo paramTextureInfo, int paramInt1, int paramInt2, TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramInt1, paramInt2, paramTextureInfo.getTextureMatrix(), paramTextureInfo.preferRotation);
  }
  
  public TextureInfo getBlurredTextureInfo(TextureInfo paramTextureInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, GaosiBlurFilter paramGaosiBlurFilter1, GaosiBlurFilter paramGaosiBlurFilter2, ScaleTextureFilter paramScaleTextureFilter1, ScaleTextureFilter paramScaleTextureFilter2)
  {
    int i;
    if (paramInt3 == 0)
    {
      i = paramInt1;
      if (paramInt3 != 0) {
        break label160;
      }
    }
    for (;;)
    {
      label160:
      try
      {
        paramGaosiBlurFilter1.setRadius(paramInt4);
        paramGaosiBlurFilter2.setRadius(paramInt4);
        TAVTextureInfo localTAVTextureInfo = getTavTextureInfo(paramTextureInfo);
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
        paramTextureInfo = getTextureInfo(paramTextureInfo, i, paramInt2, paramGaosiBlurFilter2.applyFilter(paramGaosiBlurFilter1.applyFilter(paramScaleTextureFilter1.applyFilter(localTAVTextureInfo))));
        return paramTextureInfo;
      }
      finally {}
      i = paramInt2;
      break;
      paramInt2 = paramInt1;
    }
  }
  
  /* Error */
  @NotNull
  public TextureInfo getBlurredTextureInfo(TextureInfo paramTextureInfo, RenderInfo paramRenderInfo, int paramInt1, int paramInt2, float paramFloat, GaosiBlurFilter paramGaosiBlurFilter1, GaosiBlurFilter paramGaosiBlurFilter2, ScaleTextureFilter paramScaleTextureFilter1, ScaleTextureFilter paramScaleTextureFilter2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifne +193 -> 196
    //   6: aload_2
    //   7: invokevirtual 168	com/tencent/tavkit/composition/video/RenderInfo:getRenderWidth	()I
    //   10: istore 10
    //   12: iload_3
    //   13: ifne +192 -> 205
    //   16: aload_2
    //   17: invokevirtual 171	com/tencent/tavkit/composition/video/RenderInfo:getRenderHeight	()I
    //   20: istore_3
    //   21: aload 6
    //   23: iload 4
    //   25: invokevirtual 135	com/tencent/autotemplate/filter/GaosiBlurFilter:setRadius	(I)V
    //   28: aload 7
    //   30: iload 4
    //   32: invokevirtual 135	com/tencent/autotemplate/filter/GaosiBlurFilter:setRadius	(I)V
    //   35: aload_1
    //   36: invokestatic 137	com/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager:getTavTextureInfo	(Lcom/tencent/tav/coremedia/TextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   39: astore_2
    //   40: aload_1
    //   41: getfield 112	com/tencent/tav/coremedia/TextureInfo:width	I
    //   44: i2f
    //   45: fload 5
    //   47: fmul
    //   48: f2d
    //   49: invokestatic 143	java/lang/Math:floor	(D)D
    //   52: d2i
    //   53: istore 4
    //   55: aload_1
    //   56: getfield 114	com/tencent/tav/coremedia/TextureInfo:height	I
    //   59: i2f
    //   60: fload 5
    //   62: fmul
    //   63: f2d
    //   64: invokestatic 143	java/lang/Math:floor	(D)D
    //   67: d2i
    //   68: istore 11
    //   70: aload 6
    //   72: iload 4
    //   74: invokevirtual 146	com/tencent/autotemplate/filter/GaosiBlurFilter:setRendererWidth	(I)V
    //   77: aload 6
    //   79: iload 11
    //   81: invokevirtual 149	com/tencent/autotemplate/filter/GaosiBlurFilter:setRendererHeight	(I)V
    //   84: aload 7
    //   86: iload 4
    //   88: invokevirtual 146	com/tencent/autotemplate/filter/GaosiBlurFilter:setRendererWidth	(I)V
    //   91: aload 7
    //   93: iload 11
    //   95: invokevirtual 149	com/tencent/autotemplate/filter/GaosiBlurFilter:setRendererHeight	(I)V
    //   98: aload 8
    //   100: iload 4
    //   102: invokevirtual 152	com/tencent/autotemplate/filter/ScaleTextureFilter:setRendererWidth	(I)V
    //   105: aload 8
    //   107: iload 11
    //   109: invokevirtual 153	com/tencent/autotemplate/filter/ScaleTextureFilter:setRendererHeight	(I)V
    //   112: aload 9
    //   114: iload 10
    //   116: invokevirtual 152	com/tencent/autotemplate/filter/ScaleTextureFilter:setRendererWidth	(I)V
    //   119: aload 9
    //   121: iload_3
    //   122: invokevirtual 153	com/tencent/autotemplate/filter/ScaleTextureFilter:setRendererHeight	(I)V
    //   125: aload 8
    //   127: fload 5
    //   129: fconst_0
    //   130: fconst_0
    //   131: invokevirtual 157	com/tencent/autotemplate/filter/ScaleTextureFilter:scale	(FFF)V
    //   134: aload 7
    //   136: aload 6
    //   138: aload 8
    //   140: aload_2
    //   141: invokevirtual 161	com/tencent/autotemplate/filter/ScaleTextureFilter:applyFilter	(Lcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   144: invokevirtual 162	com/tencent/autotemplate/filter/GaosiBlurFilter:applyFilter	(Lcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   147: invokevirtual 162	com/tencent/autotemplate/filter/GaosiBlurFilter:applyFilter	(Lcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   150: astore_2
    //   151: aload 9
    //   153: fconst_1
    //   154: iload_3
    //   155: i2f
    //   156: fmul
    //   157: iload 11
    //   159: i2f
    //   160: fdiv
    //   161: fconst_1
    //   162: iload 10
    //   164: i2f
    //   165: fmul
    //   166: iload 4
    //   168: i2f
    //   169: fdiv
    //   170: invokestatic 175	java/lang/Math:max	(FF)F
    //   173: fconst_0
    //   174: fconst_0
    //   175: invokevirtual 157	com/tencent/autotemplate/filter/ScaleTextureFilter:scale	(FFF)V
    //   178: aload_1
    //   179: iload 10
    //   181: iload_3
    //   182: aload 9
    //   184: aload_2
    //   185: invokevirtual 161	com/tencent/autotemplate/filter/ScaleTextureFilter:applyFilter	(Lcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   188: invokestatic 164	com/tencent/weseevideo/composition/effectnode/WSOverLayBlurManager:getTextureInfo	(Lcom/tencent/tav/coremedia/TextureInfo;IILcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/tav/coremedia/TextureInfo;
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: areturn
    //   196: aload_2
    //   197: invokevirtual 171	com/tencent/tavkit/composition/video/RenderInfo:getRenderHeight	()I
    //   200: istore 10
    //   202: goto -190 -> 12
    //   205: aload_2
    //   206: invokevirtual 168	com/tencent/tavkit/composition/video/RenderInfo:getRenderWidth	()I
    //   209: istore_3
    //   210: goto -189 -> 21
    //   213: astore_1
    //   214: aload_0
    //   215: monitorexit
    //   216: aload_1
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	WSOverLayBlurManager
    //   0	218	1	paramTextureInfo	TextureInfo
    //   0	218	2	paramRenderInfo	RenderInfo
    //   0	218	3	paramInt1	int
    //   0	218	4	paramInt2	int
    //   0	218	5	paramFloat	float
    //   0	218	6	paramGaosiBlurFilter1	GaosiBlurFilter
    //   0	218	7	paramGaosiBlurFilter2	GaosiBlurFilter
    //   0	218	8	paramScaleTextureFilter1	ScaleTextureFilter
    //   0	218	9	paramScaleTextureFilter2	ScaleTextureFilter
    //   10	191	10	i	int
    //   68	90	11	j	int
    // Exception table:
    //   from	to	target	type
    //   6	12	213	finally
    //   16	21	213	finally
    //   21	192	213	finally
    //   196	202	213	finally
    //   205	210	213	finally
  }
  
  public RenderInfo getRenderInfo()
  {
    try
    {
      RenderInfo localRenderInfo = this.renderInfo;
      return localRenderInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CIImage getSourceCIImage()
  {
    try
    {
      CIImage localCIImage = this.sourceCIImage;
      return localCIImage;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void registerSourceImageObserver(String paramString, WSOverLayBlurManager.SourceImageObserver paramSourceImageObserver)
  {
    if (paramSourceImageObserver != null)
    {
      Log.d("genglin", "register: " + paramSourceImageObserver.hashCode());
      if (!this.observers.containsKey(paramString))
      {
        paramSourceImageObserver = new WeakReference(paramSourceImageObserver);
        this.observers.put(paramString, paramSourceImageObserver);
      }
    }
  }
  
  public void unregisterSourceImageObserver(String paramString)
  {
    Log.d("genglin", "unregister: " + paramString);
    this.observers.remove(paramString);
    Log.d("genglin", "unregisterSourceImageObserver: size = " + this.observers.size());
  }
  
  public void updateSourceCIImage(CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    try
    {
      this.sourceCIImage = paramCIImage;
      this.renderInfo = paramRenderInfo;
      Log.d("sticker_size", "updateSourceCIImage: thread = " + Thread.currentThread().getName());
      if ((this.observers != null) && (this.observers.size() > 0))
      {
        Iterator localIterator = this.observers.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if ((localEntry.getValue() != null) && (((WeakReference)localEntry.getValue()).get() != null)) {
            ((WSOverLayBlurManager.SourceImageObserver)((WeakReference)localEntry.getValue()).get()).onSourceImageUpdated(paramCIImage, paramRenderInfo);
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSOverLayBlurManager
 * JD-Core Version:    0.7.0.1
 */