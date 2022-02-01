package com.tencent.mobileqq.emoticonview.anisticker;

import android.util.LruCache;

public class AniStickerSvgHelper
{
  private static final LruCache<String, AniStickerSvgDrawable.SvgResCommand> SVG_RES_CACHE = new LruCache(30);
  private static final String TAG = "AniStickerSvgHelper";
  
  public static void clearCache()
  {
    SVG_RES_CACHE.evictAll();
  }
  
  public static AniStickerSvgDrawable getAniStickerSvgThumb(AniStickerSvgDrawable.SvgResCommand paramSvgResCommand, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    paramSvgResCommand = getDrawableBySvgResCommand(paramSvgResCommand, (int)(paramInt1 * paramFloat2), (int)(paramInt2 * paramFloat2));
    if (paramSvgResCommand != null) {
      paramSvgResCommand.setupGradient(paramInt3, paramFloat1);
    }
    return paramSvgResCommand;
  }
  
  public static AniStickerSvgDrawable getAniStickerSvgThumbFromCache(String paramString, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    paramString = (AniStickerSvgDrawable.SvgResCommand)SVG_RES_CACHE.get(paramString);
    if (paramString != null) {
      return getAniStickerSvgThumb(paramString, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2);
    }
    return null;
  }
  
  public static AniStickerSvgDrawable getDrawableBySvgResCommand(AniStickerSvgDrawable.SvgResCommand paramSvgResCommand, int paramInt1, int paramInt2)
  {
    try
    {
      AniStickerSvgDrawable localAniStickerSvgDrawable = new AniStickerSvgDrawable();
      localAniStickerSvgDrawable.setSvgResCommand(paramSvgResCommand);
      localAniStickerSvgDrawable.width = paramInt1;
      localAniStickerSvgDrawable.height = paramInt2;
      return localAniStickerSvgDrawable;
    }
    catch (Exception paramSvgResCommand)
    {
      label25:
      break label25;
    }
    return null;
  }
  
  public static boolean hasSvgResCommandCache(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    if (SVG_RES_CACHE.get(paramString) != null) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public static AniStickerSvgDrawable syncGetAniStickerSvgThumbFromFile(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: invokestatic 74	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   3: invokevirtual 78	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   6: invokevirtual 84	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   9: astore 6
    //   11: new 86	com/tencent/mobileqq/emoticonview/anisticker/SvgDrawableHandler
    //   14: dup
    //   15: iconst_0
    //   16: iconst_0
    //   17: iload_3
    //   18: iconst_1
    //   19: invokespecial 89	com/tencent/mobileqq/emoticonview/anisticker/SvgDrawableHandler:<init>	(IIIZ)V
    //   22: astore 7
    //   24: aload 6
    //   26: aload 7
    //   28: invokeinterface 95 2 0
    //   33: new 97	java/io/InputStreamReader
    //   36: dup
    //   37: new 99	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   45: invokespecial 105	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: astore 5
    //   50: aload 5
    //   52: astore 4
    //   54: aload 6
    //   56: new 107	org/xml/sax/InputSource
    //   59: dup
    //   60: aload 5
    //   62: invokespecial 110	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   65: invokeinterface 114 2 0
    //   70: aload 5
    //   72: astore 4
    //   74: aload 7
    //   76: invokevirtual 118	com/tencent/mobileqq/emoticonview/anisticker/SvgDrawableHandler:getDrawable	()Lcom/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgDrawable;
    //   79: astore 6
    //   81: aload 6
    //   83: ifnull +103 -> 186
    //   86: aload 5
    //   88: astore 4
    //   90: aload_0
    //   91: invokestatic 120	com/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgHelper:hasSvgResCommandCache	(Ljava/lang/String;)Z
    //   94: ifne +72 -> 166
    //   97: aload 5
    //   99: astore 4
    //   101: new 48	com/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgDrawable$SvgResCommand
    //   104: dup
    //   105: invokespecial 121	com/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgDrawable$SvgResCommand:<init>	()V
    //   108: astore 7
    //   110: aload 5
    //   112: astore 4
    //   114: aload 7
    //   116: new 123	java/util/ArrayList
    //   119: dup
    //   120: aload 6
    //   122: getfield 127	com/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgDrawable:commands	Ljava/util/ArrayList;
    //   125: invokespecial 130	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   128: putfield 131	com/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgDrawable$SvgResCommand:commands	Ljava/util/ArrayList;
    //   131: aload 5
    //   133: astore 4
    //   135: aload 7
    //   137: new 133	java/util/HashMap
    //   140: dup
    //   141: aload 6
    //   143: getfield 137	com/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgDrawable:paints	Ljava/util/HashMap;
    //   146: invokespecial 140	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   149: putfield 141	com/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgDrawable$SvgResCommand:paints	Ljava/util/HashMap;
    //   152: aload 5
    //   154: astore 4
    //   156: getstatic 21	com/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgHelper:SVG_RES_CACHE	Landroid/util/LruCache;
    //   159: aload_0
    //   160: aload 7
    //   162: invokevirtual 145	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: pop
    //   166: aload 5
    //   168: astore 4
    //   170: aload 6
    //   172: iload_1
    //   173: putfield 61	com/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgDrawable:width	I
    //   176: aload 5
    //   178: astore 4
    //   180: aload 6
    //   182: iload_2
    //   183: putfield 64	com/tencent/mobileqq/emoticonview/anisticker/AniStickerSvgDrawable:height	I
    //   186: aload 5
    //   188: invokevirtual 148	java/io/InputStreamReader:close	()V
    //   191: aload 6
    //   193: areturn
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   199: aload 6
    //   201: areturn
    //   202: astore 6
    //   204: aload 5
    //   206: astore_0
    //   207: goto +14 -> 221
    //   210: astore_0
    //   211: aconst_null
    //   212: astore 4
    //   214: goto +40 -> 254
    //   217: astore 6
    //   219: aconst_null
    //   220: astore_0
    //   221: aload_0
    //   222: astore 4
    //   224: ldc 11
    //   226: iconst_2
    //   227: aload 6
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 157	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   236: aload_0
    //   237: ifnull +14 -> 251
    //   240: aload_0
    //   241: invokevirtual 148	java/io/InputStreamReader:close	()V
    //   244: aconst_null
    //   245: areturn
    //   246: astore_0
    //   247: aload_0
    //   248: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   251: aconst_null
    //   252: areturn
    //   253: astore_0
    //   254: aload 4
    //   256: ifnull +18 -> 274
    //   259: aload 4
    //   261: invokevirtual 148	java/io/InputStreamReader:close	()V
    //   264: goto +10 -> 274
    //   267: astore 4
    //   269: aload 4
    //   271: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   274: aload_0
    //   275: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString	String
    //   0	276	1	paramInt1	int
    //   0	276	2	paramInt2	int
    //   0	276	3	paramInt3	int
    //   52	208	4	localObject1	Object
    //   267	3	4	localException1	Exception
    //   48	157	5	localInputStreamReader	java.io.InputStreamReader
    //   9	191	6	localObject2	Object
    //   202	1	6	localException2	Exception
    //   217	11	6	localException3	Exception
    //   22	139	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   186	191	194	java/lang/Exception
    //   54	70	202	java/lang/Exception
    //   74	81	202	java/lang/Exception
    //   90	97	202	java/lang/Exception
    //   101	110	202	java/lang/Exception
    //   114	131	202	java/lang/Exception
    //   135	152	202	java/lang/Exception
    //   156	166	202	java/lang/Exception
    //   170	176	202	java/lang/Exception
    //   180	186	202	java/lang/Exception
    //   0	50	210	finally
    //   0	50	217	java/lang/Exception
    //   240	244	246	java/lang/Exception
    //   54	70	253	finally
    //   74	81	253	finally
    //   90	97	253	finally
    //   101	110	253	finally
    //   114	131	253	finally
    //   135	152	253	finally
    //   156	166	253	finally
    //   170	176	253	finally
    //   180	186	253	finally
    //   224	236	253	finally
    //   259	264	267	java/lang/Exception
  }
  
  public static AniStickerSvgDrawable syncGetAniStickerSvgThumbFromFile(String paramString, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    paramString = syncGetAniStickerSvgThumbFromFile(paramString, (int)(paramInt1 * paramFloat2), (int)(paramInt2 * paramFloat2), paramInt3);
    if (paramString != null) {
      paramString.setupGradient(paramInt3, paramFloat1);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerSvgHelper
 * JD-Core Version:    0.7.0.1
 */