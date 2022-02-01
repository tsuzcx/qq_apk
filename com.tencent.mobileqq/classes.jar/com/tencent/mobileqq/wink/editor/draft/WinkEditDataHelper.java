package com.tencent.mobileqq.wink.editor.draft;

import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.videocut.model.StickerModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WinkEditDataHelper
{
  /* Error */
  public static WinkEditDataWrapper a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 21	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +12 -> 16
    //   7: ldc 23
    //   9: ldc 25
    //   11: invokestatic 31	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aconst_null
    //   15: areturn
    //   16: invokestatic 36	com/tencent/mobileqq/wink/edit/util/AECameraPrefsUtil:a	()Lcom/tencent/mobileqq/wink/edit/util/AECameraPrefsUtil;
    //   19: astore_1
    //   20: new 38	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   27: astore_2
    //   28: aload_2
    //   29: getstatic 43	com/tencent/mobileqq/wink/edit/util/AECameraPrefsUtil:t	Ljava/lang/String;
    //   32: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: aload_0
    //   38: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: aload_2
    //   44: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: ldc 53
    //   49: iconst_0
    //   50: invokevirtual 57	com/tencent/mobileqq/wink/edit/util/AECameraPrefsUtil:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   53: astore_0
    //   54: aload_0
    //   55: invokestatic 21	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +132 -> 190
    //   61: new 59	java/io/ByteArrayInputStream
    //   64: dup
    //   65: aload_0
    //   66: iconst_0
    //   67: invokestatic 65	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   70: invokespecial 68	java/io/ByteArrayInputStream:<init>	([B)V
    //   73: astore_3
    //   74: new 70	java/io/ObjectInputStream
    //   77: dup
    //   78: aload_3
    //   79: invokespecial 73	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   82: astore_1
    //   83: aload_1
    //   84: astore_0
    //   85: aload_1
    //   86: invokevirtual 77	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   89: checkcast 79	com/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper
    //   92: astore_2
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: invokestatic 82	com/tencent/mobileqq/wink/editor/draft/WinkEditDataHelper:a	(Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;)V
    //   99: aload_3
    //   100: invokevirtual 85	java/io/ByteArrayInputStream:close	()V
    //   103: aload_1
    //   104: invokevirtual 86	java/io/ObjectInputStream:close	()V
    //   107: aload_2
    //   108: areturn
    //   109: astore_0
    //   110: ldc 23
    //   112: aload_0
    //   113: invokestatic 89	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload_2
    //   117: areturn
    //   118: astore_1
    //   119: goto +47 -> 166
    //   122: astore_2
    //   123: goto +12 -> 135
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_0
    //   129: goto +37 -> 166
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_0
    //   137: ldc 23
    //   139: aload_2
    //   140: invokestatic 89	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_3
    //   144: invokevirtual 85	java/io/ByteArrayInputStream:close	()V
    //   147: aload_1
    //   148: ifnull +42 -> 190
    //   151: aload_1
    //   152: invokevirtual 86	java/io/ObjectInputStream:close	()V
    //   155: aconst_null
    //   156: areturn
    //   157: astore_0
    //   158: ldc 23
    //   160: aload_0
    //   161: invokestatic 89	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: aconst_null
    //   165: areturn
    //   166: aload_3
    //   167: invokevirtual 85	java/io/ByteArrayInputStream:close	()V
    //   170: aload_0
    //   171: ifnull +17 -> 188
    //   174: aload_0
    //   175: invokevirtual 86	java/io/ObjectInputStream:close	()V
    //   178: goto +10 -> 188
    //   181: astore_0
    //   182: ldc 23
    //   184: aload_0
    //   185: invokestatic 89	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload_1
    //   189: athrow
    //   190: aconst_null
    //   191: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramString	String
    //   19	85	1	localObject1	Object
    //   118	1	1	localObject2	Object
    //   126	1	1	localObject3	Object
    //   134	55	1	localObject4	Object
    //   27	90	2	localObject5	Object
    //   122	1	2	localException1	java.lang.Exception
    //   132	8	2	localException2	java.lang.Exception
    //   73	94	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   99	107	109	java/io/IOException
    //   85	93	118	finally
    //   95	99	118	finally
    //   137	143	118	finally
    //   85	93	122	java/lang/Exception
    //   95	99	122	java/lang/Exception
    //   74	83	126	finally
    //   74	83	132	java/lang/Exception
    //   143	147	157	java/io/IOException
    //   151	155	157	java/io/IOException
    //   166	170	181	java/io/IOException
    //   174	178	181	java/io/IOException
  }
  
  private static void a(WinkEditDataWrapper paramWinkEditDataWrapper)
  {
    if (paramWinkEditDataWrapper == null) {
      return;
    }
    paramWinkEditDataWrapper = paramWinkEditDataWrapper.getEditDatas();
    if ((paramWinkEditDataWrapper != null) && (paramWinkEditDataWrapper.size() > 0))
    {
      Object localObject1 = paramWinkEditDataWrapper.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        WinkEditData localWinkEditData = (WinkEditData)((Iterator)localObject1).next();
        if (localWinkEditData.getStickerModelMap() != null)
        {
          Iterator localIterator = localWinkEditData.getStickerModelMap().keySet().iterator();
          paramWinkEditDataWrapper = (WinkEditDataWrapper)localObject1;
          for (;;)
          {
            localObject1 = paramWinkEditDataWrapper;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (String)localIterator.next();
            if (localWinkEditData.getStickerExtraMap() != null)
            {
              Object localObject2 = (StickerModel)localWinkEditData.getStickerModelMap().get(localObject1);
              WinkStickerModelExtra localWinkStickerModelExtra = (WinkStickerModelExtra)localWinkEditData.getStickerExtraMap().get(localObject1);
              if (((localObject2 != null) || (localWinkStickerModelExtra != null)) && (localObject2 != null) && (localWinkStickerModelExtra != null))
              {
                localObject2 = new WinkStickerModel(((StickerModel)localObject2).id, ((StickerModel)localObject2).filePath, ((StickerModel)localObject2).startTime, ((StickerModel)localObject2).duration, ((StickerModel)localObject2).layerIndex, ((StickerModel)localObject2).scale, ((StickerModel)localObject2).rotate, ((StickerModel)localObject2).centerX, ((StickerModel)localObject2).centerY, ((StickerModel)localObject2).editable, ((StickerModel)localObject2).width, ((StickerModel)localObject2).height, ((StickerModel)localObject2).minScale, ((StickerModel)localObject2).maxScale, ((StickerModel)localObject2).textItems, ((StickerModel)localObject2).thumbUrl, ((StickerModel)localObject2).timelineTrackIndex, ((StickerModel)localObject2).animationMode, ((StickerModel)localObject2).type, ((StickerModel)localObject2).materialId, ((StickerModel)localObject2).captionInfo, ((StickerModel)localObject2).localThumbId, ((StickerModel)localObject2).editingLayerIndex, ((StickerModel)localObject2).playEndDuration, ((StickerModel)localObject2).actionType, ((StickerModel)localObject2).bgConfig, ((StickerModel)localObject2).bgPath, ((StickerModel)localObject2).configType, ((StickerModel)localObject2).unknownFields(), localWinkStickerModelExtra.getInitStickerScale(), localWinkStickerModelExtra.getDownScaleRecord(), localWinkStickerModelExtra.getOriginPointInView(), localWinkStickerModelExtra.getSizeInView(), localWinkStickerModelExtra.getCenterInView(), localWinkStickerModelExtra.getLeftTopInView(), localWinkStickerModelExtra.getRightBottomInView(), localWinkStickerModelExtra.getMaterial());
                ((WinkStickerModel)localObject2).setLastDownScale(localWinkStickerModelExtra.getLastDownScale());
                ((WinkStickerModel)localObject2).setLastDownRotate(localWinkStickerModelExtra.getLastDownRotate());
                localWinkEditData.getStickerModelMap().put(localObject1, localObject2);
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public static void a(WinkEditDataWrapper paramWinkEditDataWrapper, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 291	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 292	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore_2
    //   19: new 294	java/io/ObjectOutputStream
    //   22: dup
    //   23: aload 5
    //   25: invokespecial 297	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_3
    //   29: aload_3
    //   30: aload_0
    //   31: invokevirtual 301	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   34: new 129	java/lang/String
    //   37: dup
    //   38: aload 5
    //   40: invokevirtual 305	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   43: iconst_0
    //   44: invokestatic 309	android/util/Base64:encode	([BI)[B
    //   47: invokespecial 310	java/lang/String:<init>	([B)V
    //   50: astore_0
    //   51: invokestatic 36	com/tencent/mobileqq/wink/edit/util/AECameraPrefsUtil:a	()Lcom/tencent/mobileqq/wink/edit/util/AECameraPrefsUtil;
    //   54: astore_2
    //   55: new 38	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: getstatic 43	com/tencent/mobileqq/wink/edit/util/AECameraPrefsUtil:t	Ljava/lang/String;
    //   69: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 4
    //   75: aload_1
    //   76: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_2
    //   81: aload 4
    //   83: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: aload_0
    //   87: iconst_0
    //   88: invokevirtual 313	com/tencent/mobileqq/wink/edit/util/AECameraPrefsUtil:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   91: aload 5
    //   93: invokevirtual 314	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_3
    //   97: invokevirtual 315	java/io/ObjectOutputStream:close	()V
    //   100: return
    //   101: astore_0
    //   102: goto +49 -> 151
    //   105: astore_1
    //   106: aload_3
    //   107: astore_0
    //   108: goto +13 -> 121
    //   111: astore_0
    //   112: aload_2
    //   113: astore_3
    //   114: goto +37 -> 151
    //   117: astore_1
    //   118: aload 4
    //   120: astore_0
    //   121: aload_0
    //   122: astore_2
    //   123: ldc 23
    //   125: aload_1
    //   126: invokestatic 89	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload 5
    //   131: invokevirtual 314	java/io/ByteArrayOutputStream:close	()V
    //   134: aload_0
    //   135: ifnull +15 -> 150
    //   138: aload_0
    //   139: invokevirtual 315	java/io/ObjectOutputStream:close	()V
    //   142: return
    //   143: astore_0
    //   144: ldc 23
    //   146: aload_0
    //   147: invokestatic 89	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: return
    //   151: aload 5
    //   153: invokevirtual 314	java/io/ByteArrayOutputStream:close	()V
    //   156: aload_3
    //   157: ifnull +17 -> 174
    //   160: aload_3
    //   161: invokevirtual 315	java/io/ObjectOutputStream:close	()V
    //   164: goto +10 -> 174
    //   167: astore_1
    //   168: ldc 23
    //   170: aload_1
    //   171: invokestatic 89	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_0
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramWinkEditDataWrapper	WinkEditDataWrapper
    //   0	176	1	paramString	String
    //   18	105	2	localObject1	Object
    //   28	133	3	localObject2	Object
    //   15	104	4	localStringBuilder	java.lang.StringBuilder
    //   12	140	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   29	91	101	finally
    //   29	91	105	java/lang/Throwable
    //   19	29	111	finally
    //   123	129	111	finally
    //   19	29	117	java/lang/Throwable
    //   91	100	143	java/io/IOException
    //   129	134	143	java/io/IOException
    //   138	142	143	java/io/IOException
    //   151	156	167	java/io/IOException
    //   160	164	167	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.draft.WinkEditDataHelper
 * JD-Core Version:    0.7.0.1
 */