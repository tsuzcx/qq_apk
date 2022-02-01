package com.tencent.mobileqq.editor.composite.util;

import com.tencent.aelight.camera.aioeditor.capture.paster.AnimationDecodeWrapper;
import com.tencent.aelight.camera.aioeditor.capture.paster.ApngDecodeWrapper;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public class InjectGifDecoder
{
  @ConfigInject(configPath="Foundation/VideoCodec/src/main/resources/Inject_InjectGifDecoderConfig.yml", version=1)
  public static ArrayList<Class<? extends GifDecoderWrapper>> a = new ArrayList();
  
  static
  {
    a.add(ApngDecodeWrapper.class);
    a.add(AnimationDecodeWrapper.class);
  }
  
  public static GifDecoderWrapper a(DynamicStickerData paramDynamicStickerData)
  {
    try
    {
      Iterator localIterator = a.iterator();
      Object localObject1 = null;
      Object localObject2;
      int i;
      int j;
      do
      {
        for (;;)
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break label114;
          }
          localObject2 = ((Class)localIterator.next()).getDeclaredConstructor(new Class[] { String.class, String.class });
          ((Constructor)localObject2).setAccessible(true);
          localObject2 = (GifDecoderWrapper)((Constructor)localObject2).newInstance(new Object[] { paramDynamicStickerData.path, paramDynamicStickerData.data });
          if (localObject1 != null) {
            break;
          }
          localObject1 = localObject2;
        }
        i = ((GifDecoderWrapper)localObject2).a();
        j = paramDynamicStickerData.type;
      } while (i != j);
      label114:
      return localObject2;
    }
    catch (Exception paramDynamicStickerData)
    {
      QLog.e("InjectGifDecoder", 1, paramDynamicStickerData, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.util.InjectGifDecoder
 * JD-Core Version:    0.7.0.1
 */