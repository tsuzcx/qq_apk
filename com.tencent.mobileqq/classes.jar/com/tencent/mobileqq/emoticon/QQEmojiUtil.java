package com.tencent.mobileqq.emoticon;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QQEmojiUtil
{
  public static int EMOJI_COUNT = 165;
  public static final String TAG = "EmojiUtil";
  
  public static boolean containsEmoji(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.codePointAt(i);
        if (EmotcationConstants.EMOJI_MAP.get(j, -1) >= 0) {}
        for (j = 1; j != 0; j = 0) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static int getEmojiCount()
  {
    int j = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getConfigEmoCount();
    int i = j;
    if (j < EmotcationConstants.EMOJI_CODES.length) {
      i = EmotcationConstants.EMOJI_CODES.length;
    }
    return i;
  }
  
  public static String getEmojiDescription(int paramInt)
  {
    String str2 = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getDescription(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if ((paramInt >= 0) && (paramInt < EmotcationConstants.EMOJI_CONTENT_DESC.length)) {
        str1 = EmotcationConstants.EMOJI_CONTENT_DESC[paramInt];
      }
    }
    else {
      return str1;
    }
    return "未知";
  }
  
  public static Drawable getEmojiDrawable(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji static index: " + paramInt);
    }
    Object localObject = BaseApplication.getContext().getResources();
    if (paramInt >= 1000) {
      localObject = loadEmojiFromDisk((Resources)localObject, paramInt);
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      if (paramInt < EmotcationConstants.VALID_EMOJI_COUNT)
      {
        paramInt = EmotcationConstants.FIRST_EMOJI_RES + paramInt;
        if (GlobalImageCache.a != null) {
          return getResourceDrawableThroughImageCache((Resources)localObject, paramInt);
        }
        return ((Resources)localObject).getDrawable(paramInt);
      }
      localDrawable = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getDrawable(paramInt);
      localObject = localDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("EmojiUtil", 2, "getEmojiDrawable in new way");
    return localDrawable;
  }
  
  public static int getEmojiLocalId(int paramInt)
  {
    int j = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getLocalId(paramInt);
    int i = j;
    if (j == -1) {
      i = EmotcationConstants.EMOJI_MAP.get(paramInt, -1);
    }
    return i;
  }
  
  public static int getEmojiUnicode(int paramInt)
  {
    int j = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getServerId(paramInt);
    int i = j;
    if (j == -1)
    {
      if ((paramInt >= 0) && (paramInt < EmotcationConstants.EMOJI_CODES.length)) {
        i = EmotcationConstants.EMOJI_CODES[paramInt];
      }
    }
    else {
      return i;
    }
    QLog.d("EmojiUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
    return j;
  }
  
  public static int getLocalIdFromEMCode(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = QQSysAndEmojiResMgr.getInstance().getResImpl(2);
    if ((localQQSysAndEmojiResInfo instanceof QQEmojiResImpl)) {
      return ((QQEmojiResImpl)localQQSysAndEmojiResInfo).getLocalIdFromEMCode(paramString);
    }
    return -1;
  }
  
  public static ArrayList<Integer> getOrderList()
  {
    ArrayList localArrayList = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getOrderList();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return localArrayList;
    }
    localArrayList = new ArrayList(EMOJI_COUNT);
    int i = 0;
    while (i < EMOJI_COUNT)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public static Drawable getResourceDrawableThroughImageCache(Resources paramResources, int paramInt)
  {
    String str = "android.resource://" + paramInt;
    Object localObject = (Pair)GlobalImageCache.a.get(str);
    if (localObject != null) {
      paramResources = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramResources);
    }
    for (;;)
    {
      return paramResources;
      try
      {
        localObject = paramResources.getDrawable(paramInt);
        paramInt = SkinUtils.a((Drawable)localObject);
        paramResources = (Resources)localObject;
        if (paramInt > 0)
        {
          GlobalImageCache.a.put(str, new Pair(((Drawable)localObject).getConstantState(), Integer.valueOf(paramInt)));
          return localObject;
        }
      }
      catch (Exception paramResources) {}
    }
    return null;
  }
  
  public static boolean isEmoReady(int paramInt)
  {
    return QQSysAndEmojiResMgr.getInstance().getResImpl(2).isResReady(paramInt);
  }
  
  public static boolean isValidEmojiId(int paramInt)
  {
    int j = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getMaxLocalId();
    int i = j;
    if (j <= 0) {
      i = EmotcationConstants.EMOJI_CODES.length - 1;
    }
    return (paramInt >= 0) && (paramInt <= i);
  }
  
  /* Error */
  public static final Drawable loadEmojiFromDisk(Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: new 86	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7: ldc 245
    //   9: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: iload_1
    //   13: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: astore 7
    //   21: getstatic 129	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   24: ifnull +36 -> 60
    //   27: getstatic 129	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   30: aload 7
    //   32: invokevirtual 202	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 204	android/util/Pair
    //   38: astore 5
    //   40: aload 5
    //   42: ifnull +18 -> 60
    //   45: aload 5
    //   47: getfield 208	android/util/Pair:first	Ljava/lang/Object;
    //   50: checkcast 210	android/graphics/drawable/Drawable$ConstantState
    //   53: aload_0
    //   54: invokevirtual 214	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   57: astore_0
    //   58: aload_0
    //   59: areturn
    //   60: invokestatic 250	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   63: getstatic 255	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   66: invokevirtual 258	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   69: astore 5
    //   71: iload_1
    //   72: sipush 1000
    //   75: isub
    //   76: i2l
    //   77: lstore_3
    //   78: aload 5
    //   80: astore_0
    //   81: aload 5
    //   83: lload_3
    //   84: invokevirtual 264	java/io/RandomAccessFile:seek	(J)V
    //   87: aload 5
    //   89: astore_0
    //   90: invokestatic 270	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   93: iconst_4
    //   94: invokevirtual 274	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   97: astore 6
    //   99: aload 5
    //   101: astore_0
    //   102: aload 5
    //   104: aload 6
    //   106: iconst_0
    //   107: iconst_4
    //   108: invokevirtual 278	java/io/RandomAccessFile:read	([BII)I
    //   111: pop
    //   112: aload 5
    //   114: astore_0
    //   115: aload 6
    //   117: invokestatic 282	com/tencent/mobileqq/text/AppleEmojiManager:bytesToInt	([B)I
    //   120: istore_2
    //   121: aload 5
    //   123: astore_0
    //   124: invokestatic 270	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   127: aload 6
    //   129: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   132: aload 5
    //   134: astore_0
    //   135: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +458 -> 596
    //   141: aload 5
    //   143: astore_0
    //   144: ldc_w 288
    //   147: iconst_2
    //   148: new 86	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 290
    //   158: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload_2
    //   162: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: goto +425 -> 596
    //   174: aload 5
    //   176: astore_0
    //   177: ldc_w 288
    //   180: iconst_4
    //   181: new 86	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 292
    //   191: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload_1
    //   195: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload 5
    //   206: ifnull +12 -> 218
    //   209: invokestatic 250	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   212: getstatic 255	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   215: invokevirtual 294	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   218: aconst_null
    //   219: areturn
    //   220: aload 5
    //   222: astore_0
    //   223: invokestatic 270	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   226: sipush 4096
    //   229: invokevirtual 274	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   232: astore 6
    //   234: aload 5
    //   236: astore_0
    //   237: aload 6
    //   239: iconst_0
    //   240: aload 5
    //   242: aload 6
    //   244: iconst_0
    //   245: iload_2
    //   246: invokevirtual 278	java/io/RandomAccessFile:read	([BII)I
    //   249: invokestatic 300	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   252: astore 6
    //   254: aload 5
    //   256: astore_0
    //   257: aload 6
    //   259: invokestatic 305	com/tencent/mobileqq/util/Utils:a	(Landroid/graphics/Bitmap;)I
    //   262: istore_2
    //   263: aload 5
    //   265: astore_0
    //   266: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +33 -> 302
    //   272: aload 5
    //   274: astore_0
    //   275: ldc_w 288
    //   278: iconst_2
    //   279: new 86	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 307
    //   289: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: iload_2
    //   293: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: iload_2
    //   303: ifle +155 -> 458
    //   306: aload 5
    //   308: astore_0
    //   309: new 309	android/graphics/drawable/BitmapDrawable
    //   312: dup
    //   313: aload 6
    //   315: invokespecial 312	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   318: astore 6
    //   320: aload 5
    //   322: astore_0
    //   323: getstatic 129	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   326: ifnull +70 -> 396
    //   329: aload 5
    //   331: astore_0
    //   332: getstatic 129	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   335: aload 7
    //   337: new 204	android/util/Pair
    //   340: dup
    //   341: aload 6
    //   343: invokevirtual 225	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   346: iload_2
    //   347: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: invokespecial 228	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   353: invokevirtual 232	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   356: pop
    //   357: aload 5
    //   359: astore_0
    //   360: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +33 -> 396
    //   366: aload 5
    //   368: astore_0
    //   369: ldc_w 288
    //   372: iconst_2
    //   373: new 86	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 314
    //   383: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: iload_1
    //   387: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: aload 5
    //   398: astore_0
    //   399: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +36 -> 438
    //   405: aload 5
    //   407: astore_0
    //   408: ldc_w 288
    //   411: iconst_2
    //   412: iconst_3
    //   413: anewarray 4	java/lang/Object
    //   416: dup
    //   417: iconst_0
    //   418: ldc_w 316
    //   421: aastore
    //   422: dup
    //   423: iconst_1
    //   424: iload_1
    //   425: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: aastore
    //   429: dup
    //   430: iconst_2
    //   431: ldc_w 318
    //   434: aastore
    //   435: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   438: aload 6
    //   440: astore_0
    //   441: aload 5
    //   443: ifnull -385 -> 58
    //   446: invokestatic 250	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   449: getstatic 255	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   452: invokevirtual 294	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   455: aload 6
    //   457: areturn
    //   458: aload 5
    //   460: ifnull +12 -> 472
    //   463: invokestatic 250	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   466: getstatic 255	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   469: invokevirtual 294	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   472: aconst_null
    //   473: areturn
    //   474: astore 6
    //   476: aconst_null
    //   477: astore 5
    //   479: aload 5
    //   481: astore_0
    //   482: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   485: ifeq +18 -> 503
    //   488: aload 5
    //   490: astore_0
    //   491: ldc_w 288
    //   494: iconst_2
    //   495: ldc_w 319
    //   498: aload 6
    //   500: invokestatic 323	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   503: aload 5
    //   505: ifnonnull +9 -> 514
    //   508: aload 5
    //   510: astore_0
    //   511: invokestatic 326	com/tencent/mobileqq/text/EmotcationConstants:reDownloadAppleEmoji	()V
    //   514: aload 5
    //   516: ifnull +12 -> 528
    //   519: invokestatic 250	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   522: getstatic 255	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   525: invokevirtual 294	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   528: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq +33 -> 564
    //   534: ldc_w 288
    //   537: iconst_2
    //   538: iconst_3
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: ldc_w 316
    //   547: aastore
    //   548: dup
    //   549: iconst_1
    //   550: iload_1
    //   551: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   554: aastore
    //   555: dup
    //   556: iconst_2
    //   557: ldc_w 328
    //   560: aastore
    //   561: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   564: aconst_null
    //   565: areturn
    //   566: astore 5
    //   568: aconst_null
    //   569: astore_0
    //   570: aload_0
    //   571: ifnull +12 -> 583
    //   574: invokestatic 250	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   577: getstatic 255	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   580: invokevirtual 294	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   583: aload 5
    //   585: athrow
    //   586: astore 5
    //   588: goto -18 -> 570
    //   591: astore 6
    //   593: goto -114 -> 479
    //   596: iload_2
    //   597: iflt -423 -> 174
    //   600: iload_2
    //   601: sipush 4096
    //   604: if_icmple -384 -> 220
    //   607: goto -433 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	paramResources	Resources
    //   0	610	1	paramInt	int
    //   120	485	2	i	int
    //   77	7	3	l	long
    //   38	477	5	localObject1	Object
    //   566	18	5	localObject2	Object
    //   586	1	5	localObject3	Object
    //   97	359	6	localObject4	Object
    //   474	25	6	localThrowable1	java.lang.Throwable
    //   591	1	6	localThrowable2	java.lang.Throwable
    //   19	317	7	str	String
    // Exception table:
    //   from	to	target	type
    //   60	71	474	java/lang/Throwable
    //   60	71	566	finally
    //   81	87	586	finally
    //   90	99	586	finally
    //   102	112	586	finally
    //   115	121	586	finally
    //   124	132	586	finally
    //   135	141	586	finally
    //   144	171	586	finally
    //   177	204	586	finally
    //   223	234	586	finally
    //   237	254	586	finally
    //   257	263	586	finally
    //   266	272	586	finally
    //   275	302	586	finally
    //   309	320	586	finally
    //   323	329	586	finally
    //   332	357	586	finally
    //   360	366	586	finally
    //   369	396	586	finally
    //   399	405	586	finally
    //   408	438	586	finally
    //   482	488	586	finally
    //   491	503	586	finally
    //   511	514	586	finally
    //   81	87	591	java/lang/Throwable
    //   90	99	591	java/lang/Throwable
    //   102	112	591	java/lang/Throwable
    //   115	121	591	java/lang/Throwable
    //   124	132	591	java/lang/Throwable
    //   135	141	591	java/lang/Throwable
    //   144	171	591	java/lang/Throwable
    //   177	204	591	java/lang/Throwable
    //   223	234	591	java/lang/Throwable
    //   237	254	591	java/lang/Throwable
    //   257	263	591	java/lang/Throwable
    //   266	272	591	java/lang/Throwable
    //   275	302	591	java/lang/Throwable
    //   309	320	591	java/lang/Throwable
    //   323	329	591	java/lang/Throwable
    //   332	357	591	java/lang/Throwable
    //   360	366	591	java/lang/Throwable
    //   369	396	591	java/lang/Throwable
    //   399	405	591	java/lang/Throwable
    //   408	438	591	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQEmojiUtil
 * JD-Core Version:    0.7.0.1
 */