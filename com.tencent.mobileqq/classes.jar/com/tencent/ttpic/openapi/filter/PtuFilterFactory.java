package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.PicBaseFilter;
import com.tencent.filter.QImage;
import com.tencent.view.FilterEngineFactory;
import com.tencent.view.RendererUtils;
import java.util.HashMap;
import java.util.Map;

public class PtuFilterFactory
  extends FilterFactory
{
  public static BaseFilter createFilter(int paramInt)
  {
    return FilterFactory.createFilter(paramInt);
  }
  
  public static BaseFilter createFilter(String paramString, int paramInt)
  {
    paramString = createFilter(filterIdFromString(paramString, paramInt));
    HashMap localHashMap = new HashMap();
    localHashMap.put("effectIndex", Integer.valueOf(paramInt));
    paramString.setParameterDic(localHashMap);
    localHashMap.clear();
    return paramString;
  }
  
  public static int filterIdFromString(String paramString, int paramInt)
  {
    return FilterFactory.filterIdFromString(paramString, paramInt);
  }
  
  public static boolean isSupportOrignalProcess(int paramInt)
  {
    return FilterFactory.isSupportOrignalProcess(paramInt);
  }
  
  public static void renderBitmapByFilterID(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat)
  {
    Object localObject1 = createFilter(paramInt1);
    PicBaseFilter localPicBaseFilter = new PicBaseFilter((BaseFilter)localObject1);
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("effectIndex", Integer.valueOf(paramInt2));
    ((BaseFilter)localObject1).setParameterDic((Map)localObject2);
    ((Map)localObject2).clear();
    if (((BaseFilter)localObject1).isAdjustFilter()) {
      ((BaseFilter)localObject1).setAdjustParam(paramFloat);
    }
    Object localObject3;
    if (((BaseFilter)localObject1).isGPUProcess())
    {
      ((BaseFilter)localObject1).applyFilterChain(true, paramBitmap.getWidth(), paramBitmap.getHeight());
      if ((!((BaseFilter)localObject1).isAdjustFilter()) && (paramFloat < 1.0F))
      {
        localObject2 = FilterFactory.createFilter(117);
        ((BaseFilter)localObject1).getLastFilter().setNextFilter((BaseFilter)localObject2, new int[] { -1 });
        ((BaseFilter)localObject2).setAdjustParam(paramFloat);
        ((BaseFilter)localObject2).applyFilterChain(true, paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      localObject2 = new Frame();
      localObject3 = QImage.BindBitmap(paramBitmap);
      localPicBaseFilter.RendProcessImage((QImage)localObject3, (Frame)localObject2);
      ((QImage)localObject3).UnBindBitmap(paramBitmap);
      localPicBaseFilter.clear();
      ((BaseFilter)localObject1).clearGLSL();
      ((Frame)localObject2).clear();
      return;
    }
    localObject2 = QImage.Bitmap2QImage(paramBitmap);
    if ((!((BaseFilter)localObject1).isAdjustFilter()) && (paramFloat < 1.0F))
    {
      localObject1 = QImage.Bitmap2QImage(paramBitmap);
      localObject3 = FilterFactory.createFilter(1);
      ((BaseFilter)localObject3).setAdjustParam(paramFloat);
      ((BaseFilter)localObject3).applyFilterChain(true, ((QImage)localObject2).getWidth(), ((QImage)localObject2).getHeight());
      paramInt1 = RendererUtils.createTexture();
      GLSLRender.nativeTextImage((QImage)localObject2, paramInt1);
      ((BaseFilter)localObject3).setTextureParam(paramInt1, 0);
      Frame localFrame = new Frame();
      localPicBaseFilter.RendProcessImage((QImage)localObject1, localFrame);
      localPicBaseFilter.clear();
      localFrame.clear();
      ((BaseFilter)localObject3).clearGLSL();
      RendererUtils.clearTexture(paramInt1);
      ((QImage)localObject1).ToBitmap(paramBitmap);
      ((QImage)localObject1).Dispose();
    }
    else
    {
      ((QImage)localObject2).ToBitmap(paramBitmap);
    }
    ((QImage)localObject2).Dispose();
  }
  
  public static void renderBitmapByFilterIDAsync(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat, Runnable paramRunnable)
  {
    paramBitmap = new PtuFilterFactory.2(paramBitmap, paramInt1, paramInt2, paramFloat, paramRunnable);
    FilterEngineFactory.getInstance().queue(paramBitmap);
  }
  
  public static void renderBitmapByFilterIDAsync(Bitmap paramBitmap, String paramString, int paramInt, float paramFloat, Runnable paramRunnable)
  {
    renderBitmapByFilterIDAsync(paramBitmap, filterIdFromString(paramString, paramInt), paramInt, paramFloat, paramRunnable);
  }
  
  /* Error */
  public static void renderBitmapByFilterIDSync(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat)
  {
    // Byte code:
    //   0: new 165	java/util/concurrent/atomic/AtomicBoolean
    //   3: dup
    //   4: iconst_0
    //   5: invokespecial 168	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   8: astore 4
    //   10: new 170	com/tencent/ttpic/openapi/filter/PtuFilterFactory$1
    //   13: dup
    //   14: aload_0
    //   15: iload_1
    //   16: iload_2
    //   17: fload_3
    //   18: aload 4
    //   20: invokespecial 173	com/tencent/ttpic/openapi/filter/PtuFilterFactory$1:<init>	(Landroid/graphics/Bitmap;IIFLjava/util/concurrent/atomic/AtomicBoolean;)V
    //   23: astore_0
    //   24: invokestatic 153	com/tencent/view/FilterEngineFactory:getInstance	()Lcom/tencent/view/FilterEngineFactory;
    //   27: aload_0
    //   28: invokevirtual 157	com/tencent/view/FilterEngineFactory:queue	(Ljava/lang/Runnable;)V
    //   31: aload_0
    //   32: monitorenter
    //   33: aload 4
    //   35: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   38: ifne +22 -> 60
    //   41: aload_0
    //   42: invokevirtual 181	java/lang/Object:wait	()V
    //   45: goto -12 -> 33
    //   48: astore 4
    //   50: goto +13 -> 63
    //   53: astore 4
    //   55: aload 4
    //   57: invokevirtual 184	java/lang/InterruptedException:printStackTrace	()V
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: aload_0
    //   64: monitorexit
    //   65: goto +6 -> 71
    //   68: aload 4
    //   70: athrow
    //   71: goto -3 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramBitmap	Bitmap
    //   0	74	1	paramInt1	int
    //   0	74	2	paramInt2	int
    //   0	74	3	paramFloat	float
    //   8	26	4	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    //   48	1	4	localObject	Object
    //   53	16	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   33	45	48	finally
    //   55	60	48	finally
    //   60	62	48	finally
    //   63	65	48	finally
    //   33	45	53	java/lang/InterruptedException
  }
  
  public static void renderBitmapByFilterIDSync(Bitmap paramBitmap, String paramString, int paramInt, float paramFloat)
  {
    renderBitmapByFilterIDSync(paramBitmap, filterIdFromString(paramString, paramInt), paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.PtuFilterFactory
 * JD-Core Version:    0.7.0.1
 */