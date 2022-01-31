package com.tencent.ttpic.openapi.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.HashMap;

public class ImageWMElement
  extends WMElement
{
  private static final String TAG = ImageWMElement.class.getSimpleName();
  private long firstTimestamp;
  private boolean loadImageSuccess;
  
  public ImageWMElement(WMElementConfig paramWMElementConfig)
  {
    super(paramWMElementConfig);
  }
  
  private int getFrameIndex(long paramLong)
  {
    if (this.firstTimestamp <= 0L) {
      this.firstTimestamp = paramLong;
    }
    if (this.frames <= 0) {
      return 0;
    }
    return (int)((paramLong - this.firstTimestamp) / this.frameDuration) % this.frames;
  }
  
  private String getValue(int paramInt)
  {
    if (!TextUtils.isEmpty(this.userValue)) {
      return this.userValue;
    }
    localObject3 = "";
    Object localObject1 = localObject3;
    if ((this.imgPath == null) || (!this.numberSource.equals(""))) {}
    for (;;)
    {
      try
      {
        int i = Integer.parseInt((String)LogicDataManager.getInstance().mFollowData.get(this.numberSource));
        if (((!this.showCaseMin.equals("")) || (!this.showCaseMax.equals(""))) && ((i < Integer.parseInt(this.showCaseMin)) || (i > Integer.parseInt(this.showCaseMax)))) {
          continue;
        }
        localObject1 = this.imgPath;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject2 = localObject3;
        continue;
        localObject2 = "";
        continue;
      }
      localObject3 = localObject1;
      if (this.logic != null)
      {
        localObject3 = ((String)localObject1).replace("[logic]", this.logic.getValue(this.userValue, this));
        LogicDataManager.getInstance().mFollowData.put(this.id, String.valueOf(this.logic.getDays()));
      }
      return LogicDataManager.getInstance().replaceWithData((String)localObject3, this.dataKeys, this).replace("%d", String.valueOf(paramInt));
      localObject1 = this.imgPath;
    }
  }
  
  private boolean needUpdateImage()
  {
    return (!this.curValue.equals(this.lastValue)) || (!this.loadImageSuccess) || (!TextUtils.isEmpty(this.animateType));
  }
  
  public Bitmap getBitmap()
  {
    this.lastValue = this.curValue;
    setContentChanged(false);
    return super.getBitmap();
  }
  
  public void init()
  {
    super.init();
    this.curValue = getValue(0);
  }
  
  public void reset()
  {
    this.firstTimestamp = 0L;
    setContentChanged(false);
  }
  
  /* Error */
  public boolean updateBitmap(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iconst_0
    //   4: istore 10
    //   6: iconst_0
    //   7: istore 9
    //   9: ldc 163
    //   11: invokestatic 169	com/tencent/ttpic/baseutils/fps/BenchUtil:benchStart	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: aload_0
    //   16: aload_0
    //   17: lload_1
    //   18: invokespecial 171	com/tencent/ttpic/openapi/model/ImageWMElement:getFrameIndex	(J)I
    //   21: invokespecial 156	com/tencent/ttpic/openapi/model/ImageWMElement:getValue	(I)Ljava/lang/String;
    //   24: putfield 135	com/tencent/ttpic/openapi/model/ImageWMElement:curValue	Ljava/lang/String;
    //   27: iload 10
    //   29: istore 8
    //   31: aload_0
    //   32: invokespecial 173	com/tencent/ttpic/openapi/model/ImageWMElement:needUpdateImage	()Z
    //   35: ifne +11 -> 46
    //   38: iload 11
    //   40: istore 8
    //   42: iload_3
    //   43: ifeq +323 -> 366
    //   46: aconst_null
    //   47: astore 12
    //   49: iload 4
    //   51: ifeq +324 -> 375
    //   54: iload 10
    //   56: istore 8
    //   58: aload_0
    //   59: getfield 176	com/tencent/ttpic/openapi/model/ImageWMElement:dataPath	Ljava/lang/String;
    //   62: invokestatic 49	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifne +310 -> 375
    //   68: iload 10
    //   70: istore 8
    //   72: aload_0
    //   73: getfield 135	com/tencent/ttpic/openapi/model/ImageWMElement:curValue	Ljava/lang/String;
    //   76: ldc 51
    //   78: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifne +557 -> 638
    //   84: iload 10
    //   86: istore 8
    //   88: invokestatic 182	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   91: new 184	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   98: aload_0
    //   99: getfield 176	com/tencent/ttpic/openapi/model/ImageWMElement:dataPath	Ljava/lang/String;
    //   102: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: getstatic 195	java/io/File:separator	Ljava/lang/String;
    //   108: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 198	com/tencent/ttpic/openapi/model/ImageWMElement:itemId	Ljava/lang/String;
    //   115: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: getstatic 195	java/io/File:separator	Ljava/lang/String;
    //   121: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 135	com/tencent/ttpic/openapi/model/ImageWMElement:curValue	Ljava/lang/String;
    //   128: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: iconst_1
    //   135: invokestatic 207	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:decodeSampleBitmap	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   138: astore 12
    //   140: iload 9
    //   142: istore_3
    //   143: iload 10
    //   145: istore 8
    //   147: aload_0
    //   148: getfield 210	com/tencent/ttpic/openapi/model/ImageWMElement:isNeedShow	Z
    //   151: ifeq +151 -> 302
    //   154: iload 9
    //   156: istore_3
    //   157: iload 10
    //   159: istore 8
    //   161: aload_0
    //   162: getfield 57	com/tencent/ttpic/openapi/model/ImageWMElement:numberSource	Ljava/lang/String;
    //   165: ldc 51
    //   167: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifne +132 -> 302
    //   173: iload 10
    //   175: istore 8
    //   177: invokestatic 69	com/tencent/ttpic/openapi/watermark/LogicDataManager:getInstance	()Lcom/tencent/ttpic/openapi/watermark/LogicDataManager;
    //   180: getfield 73	com/tencent/ttpic/openapi/watermark/LogicDataManager:mFollowData	Ljava/util/HashMap;
    //   183: aload_0
    //   184: getfield 57	com/tencent/ttpic/openapi/model/ImageWMElement:numberSource	Ljava/lang/String;
    //   187: invokevirtual 79	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   190: checkcast 59	java/lang/String
    //   193: astore 13
    //   195: iload 9
    //   197: istore_3
    //   198: aload 13
    //   200: ifnull +102 -> 302
    //   203: iload 10
    //   205: istore 8
    //   207: aload 13
    //   209: invokestatic 85	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   212: istore 5
    //   214: iload 10
    //   216: istore 8
    //   218: aload_0
    //   219: getfield 88	com/tencent/ttpic/openapi/model/ImageWMElement:showCaseMin	Ljava/lang/String;
    //   222: ldc 51
    //   224: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   227: ifne +403 -> 630
    //   230: iload 10
    //   232: istore 8
    //   234: aload_0
    //   235: getfield 91	com/tencent/ttpic/openapi/model/ImageWMElement:showCaseMax	Ljava/lang/String;
    //   238: ldc 51
    //   240: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   243: ifne +387 -> 630
    //   246: iload 10
    //   248: istore 8
    //   250: aload_0
    //   251: getfield 88	com/tencent/ttpic/openapi/model/ImageWMElement:showCaseMin	Ljava/lang/String;
    //   254: invokestatic 85	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   257: istore 6
    //   259: iload 10
    //   261: istore 8
    //   263: aload_0
    //   264: getfield 91	com/tencent/ttpic/openapi/model/ImageWMElement:showCaseMax	Ljava/lang/String;
    //   267: invokestatic 85	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   270: istore 7
    //   272: iload 5
    //   274: iload 6
    //   276: if_icmplt +10 -> 286
    //   279: iload 5
    //   281: iload 7
    //   283: if_icmple +347 -> 630
    //   286: iload 10
    //   288: istore 8
    //   290: aload_0
    //   291: iconst_1
    //   292: invokevirtual 149	com/tencent/ttpic/openapi/model/ImageWMElement:setContentChanged	(Z)V
    //   295: aload_0
    //   296: iconst_0
    //   297: putfield 210	com/tencent/ttpic/openapi/model/ImageWMElement:isNeedShow	Z
    //   300: iconst_1
    //   301: istore_3
    //   302: aload 12
    //   304: ifnull +255 -> 559
    //   307: iload_3
    //   308: istore 8
    //   310: aload 12
    //   312: invokevirtual 215	android/graphics/Bitmap:isRecycled	()Z
    //   315: ifne +244 -> 559
    //   318: iload_3
    //   319: istore 8
    //   321: aload_0
    //   322: aload 12
    //   324: invokevirtual 219	com/tencent/ttpic/openapi/model/ImageWMElement:setIdleBitmap	(Landroid/graphics/Bitmap;)V
    //   327: iload_3
    //   328: istore 8
    //   330: aload_0
    //   331: invokevirtual 222	com/tencent/ttpic/openapi/model/ImageWMElement:swapActiveBitmap	()V
    //   334: iload_3
    //   335: istore 8
    //   337: aload_0
    //   338: iconst_1
    //   339: invokevirtual 149	com/tencent/ttpic/openapi/model/ImageWMElement:setContentChanged	(Z)V
    //   342: iload_3
    //   343: istore 8
    //   345: aload_0
    //   346: iconst_1
    //   347: putfield 140	com/tencent/ttpic/openapi/model/ImageWMElement:loadImageSuccess	Z
    //   350: iload_3
    //   351: istore 8
    //   353: aload_0
    //   354: iconst_1
    //   355: putfield 225	com/tencent/ttpic/openapi/model/ImageWMElement:firstDrew	Z
    //   358: aload_0
    //   359: iconst_1
    //   360: putfield 210	com/tencent/ttpic/openapi/model/ImageWMElement:isNeedShow	Z
    //   363: iconst_1
    //   364: istore 8
    //   366: ldc 163
    //   368: invokestatic 229	com/tencent/ttpic/baseutils/fps/BenchUtil:benchEnd	(Ljava/lang/String;)J
    //   371: pop2
    //   372: iload 8
    //   374: ireturn
    //   375: iload 10
    //   377: istore 8
    //   379: aload_0
    //   380: getfield 232	com/tencent/ttpic/openapi/model/ImageWMElement:isWM260	Z
    //   383: ifeq +137 -> 520
    //   386: iload 10
    //   388: istore 8
    //   390: aload_0
    //   391: getfield 135	com/tencent/ttpic/openapi/model/ImageWMElement:curValue	Ljava/lang/String;
    //   394: ldc 51
    //   396: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   399: ifne +23 -> 422
    //   402: iload 10
    //   404: istore 8
    //   406: invokestatic 237	com/tencent/ttpic/openapi/cache/VideoMemoryManager:getInstance	()Lcom/tencent/ttpic/openapi/cache/VideoMemoryManager;
    //   409: aload_0
    //   410: getfield 198	com/tencent/ttpic/openapi/model/ImageWMElement:itemId	Ljava/lang/String;
    //   413: aload_0
    //   414: getfield 135	com/tencent/ttpic/openapi/model/ImageWMElement:curValue	Ljava/lang/String;
    //   417: invokevirtual 241	com/tencent/ttpic/openapi/cache/VideoMemoryManager:loadWM260Image	(Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   420: astore 12
    //   422: iload 10
    //   424: istore 8
    //   426: aload 12
    //   428: invokestatic 245	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:isLegal	(Landroid/graphics/Bitmap;)Z
    //   431: ifne +204 -> 635
    //   434: iload 10
    //   436: istore 8
    //   438: aload_0
    //   439: getfield 225	com/tencent/ttpic/openapi/model/ImageWMElement:firstDrew	Z
    //   442: ifne +193 -> 635
    //   445: iload 10
    //   447: istore 8
    //   449: aload_0
    //   450: getfield 135	com/tencent/ttpic/openapi/model/ImageWMElement:curValue	Ljava/lang/String;
    //   453: ldc 51
    //   455: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   458: ifne +177 -> 635
    //   461: iload 10
    //   463: istore 8
    //   465: invokestatic 182	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   468: new 184	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   475: aload_0
    //   476: getfield 176	com/tencent/ttpic/openapi/model/ImageWMElement:dataPath	Ljava/lang/String;
    //   479: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: getstatic 195	java/io/File:separator	Ljava/lang/String;
    //   485: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_0
    //   489: getfield 198	com/tencent/ttpic/openapi/model/ImageWMElement:itemId	Ljava/lang/String;
    //   492: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: getstatic 195	java/io/File:separator	Ljava/lang/String;
    //   498: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload_0
    //   502: getfield 135	com/tencent/ttpic/openapi/model/ImageWMElement:curValue	Ljava/lang/String;
    //   505: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: iconst_1
    //   512: invokestatic 207	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:decodeSampleBitmap	(Landroid/content/Context;Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   515: astore 12
    //   517: goto -377 -> 140
    //   520: iload 10
    //   522: istore 8
    //   524: aload_0
    //   525: getfield 135	com/tencent/ttpic/openapi/model/ImageWMElement:curValue	Ljava/lang/String;
    //   528: ldc 51
    //   530: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   533: ifne -111 -> 422
    //   536: iload 10
    //   538: istore 8
    //   540: invokestatic 237	com/tencent/ttpic/openapi/cache/VideoMemoryManager:getInstance	()Lcom/tencent/ttpic/openapi/cache/VideoMemoryManager;
    //   543: aload_0
    //   544: getfield 198	com/tencent/ttpic/openapi/model/ImageWMElement:itemId	Ljava/lang/String;
    //   547: aload_0
    //   548: getfield 135	com/tencent/ttpic/openapi/model/ImageWMElement:curValue	Ljava/lang/String;
    //   551: invokevirtual 248	com/tencent/ttpic/openapi/cache/VideoMemoryManager:loadImage	(Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   554: astore 12
    //   556: goto -134 -> 422
    //   559: iload_3
    //   560: istore 8
    //   562: aload_0
    //   563: iconst_0
    //   564: putfield 140	com/tencent/ttpic/openapi/model/ImageWMElement:loadImageSuccess	Z
    //   567: iload_3
    //   568: istore 8
    //   570: goto -204 -> 366
    //   573: astore 12
    //   575: getstatic 20	com/tencent/ttpic/openapi/model/ImageWMElement:TAG	Ljava/lang/String;
    //   578: new 184	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   585: ldc 250
    //   587: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload 12
    //   592: invokevirtual 253	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   595: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 259	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: goto -238 -> 366
    //   607: astore 12
    //   609: iconst_1
    //   610: istore 8
    //   612: goto -37 -> 575
    //   615: astore 13
    //   617: iload 9
    //   619: istore_3
    //   620: goto -318 -> 302
    //   623: astore 13
    //   625: iconst_1
    //   626: istore_3
    //   627: goto -325 -> 302
    //   630: iconst_0
    //   631: istore_3
    //   632: goto -330 -> 302
    //   635: goto -495 -> 140
    //   638: aconst_null
    //   639: astore 12
    //   641: goto -501 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	ImageWMElement
    //   0	644	1	paramLong	long
    //   0	644	3	paramBoolean1	boolean
    //   0	644	4	paramBoolean2	boolean
    //   212	72	5	i	int
    //   257	20	6	j	int
    //   270	14	7	k	int
    //   29	582	8	bool1	boolean
    //   7	611	9	bool2	boolean
    //   4	533	10	bool3	boolean
    //   1	38	11	bool4	boolean
    //   47	508	12	localBitmap	Bitmap
    //   573	18	12	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   607	1	12	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   639	1	12	localObject	Object
    //   193	15	13	str	String
    //   615	1	13	localNumberFormatException1	NumberFormatException
    //   623	1	13	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   31	38	573	java/lang/OutOfMemoryError
    //   58	68	573	java/lang/OutOfMemoryError
    //   72	84	573	java/lang/OutOfMemoryError
    //   88	140	573	java/lang/OutOfMemoryError
    //   147	154	573	java/lang/OutOfMemoryError
    //   161	173	573	java/lang/OutOfMemoryError
    //   177	195	573	java/lang/OutOfMemoryError
    //   207	214	573	java/lang/OutOfMemoryError
    //   218	230	573	java/lang/OutOfMemoryError
    //   234	246	573	java/lang/OutOfMemoryError
    //   250	259	573	java/lang/OutOfMemoryError
    //   263	272	573	java/lang/OutOfMemoryError
    //   290	295	573	java/lang/OutOfMemoryError
    //   310	318	573	java/lang/OutOfMemoryError
    //   321	327	573	java/lang/OutOfMemoryError
    //   330	334	573	java/lang/OutOfMemoryError
    //   337	342	573	java/lang/OutOfMemoryError
    //   345	350	573	java/lang/OutOfMemoryError
    //   353	358	573	java/lang/OutOfMemoryError
    //   379	386	573	java/lang/OutOfMemoryError
    //   390	402	573	java/lang/OutOfMemoryError
    //   406	422	573	java/lang/OutOfMemoryError
    //   426	434	573	java/lang/OutOfMemoryError
    //   438	445	573	java/lang/OutOfMemoryError
    //   449	461	573	java/lang/OutOfMemoryError
    //   465	517	573	java/lang/OutOfMemoryError
    //   524	536	573	java/lang/OutOfMemoryError
    //   540	556	573	java/lang/OutOfMemoryError
    //   562	567	573	java/lang/OutOfMemoryError
    //   295	300	607	java/lang/OutOfMemoryError
    //   358	363	607	java/lang/OutOfMemoryError
    //   207	214	615	java/lang/NumberFormatException
    //   218	230	615	java/lang/NumberFormatException
    //   234	246	615	java/lang/NumberFormatException
    //   250	259	615	java/lang/NumberFormatException
    //   263	272	615	java/lang/NumberFormatException
    //   290	295	615	java/lang/NumberFormatException
    //   295	300	623	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.ImageWMElement
 * JD-Core Version:    0.7.0.1
 */