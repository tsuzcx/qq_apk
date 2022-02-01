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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.codePointAt(i);
      if (EmotcationConstants.EMOJI_MAP.get(j, -1) >= 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        return true;
      }
      i += 1;
    }
    return false;
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
        return EmotcationConstants.EMOJI_CONTENT_DESC[paramInt];
      }
      str1 = "未知";
    }
    return str1;
  }
  
  public static Drawable getEmojiDrawable(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = BaseApplication.getContext().getResources();
      if (paramInt >= 1000) {
        return loadEmojiFromDisk((Resources)localObject, paramInt);
      }
      if (paramInt < EmotcationConstants.VALID_EMOJI_COUNT)
      {
        paramInt = EmotcationConstants.FIRST_EMOJI_RES + paramInt;
        if (GlobalImageCache.a != null) {
          return getResourceDrawableThroughImageCache((Resources)localObject, paramInt);
        }
        return ((Resources)localObject).getDrawable(paramInt);
      }
      localObject = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getDrawable(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("EmojiUtil", 2, "getEmojiDrawable in new way");
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invaid emoji static index: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
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
    int i = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getServerId(paramInt);
    if (i == -1)
    {
      if ((paramInt >= 0) && (paramInt < EmotcationConstants.EMOJI_CODES.length)) {
        return EmotcationConstants.EMOJI_CODES[paramInt];
      }
      QLog.d("EmojiUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
    }
    return i;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("android.resource://");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    Pair localPair = (Pair)GlobalImageCache.a.get(localObject);
    if (localPair != null) {
      return ((Drawable.ConstantState)localPair.first).newDrawable(paramResources);
    }
    try
    {
      paramResources = paramResources.getDrawable(paramInt);
      paramInt = SkinUtils.b(paramResources);
      if (paramInt > 0) {
        GlobalImageCache.a.put(localObject, new Pair(paramResources.getConstantState(), Integer.valueOf(paramInt)));
      }
      return paramResources;
    }
    catch (Exception paramResources)
    {
      label93:
      break label93;
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
    //   0: new 129	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 246
    //   13: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 5
    //   19: iload_1
    //   20: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 6
    //   31: getstatic 106	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   34: ifnull +34 -> 68
    //   37: getstatic 106	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   40: aload 6
    //   42: invokevirtual 202	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 204	android/util/Pair
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +16 -> 68
    //   55: aload 5
    //   57: getfield 208	android/util/Pair:first	Ljava/lang/Object;
    //   60: checkcast 210	android/graphics/drawable/Drawable$ConstantState
    //   63: aload_0
    //   64: invokevirtual 214	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   67: areturn
    //   68: invokestatic 251	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   71: getstatic 256	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   74: invokevirtual 259	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   77: astore 5
    //   79: iload_1
    //   80: sipush 1000
    //   83: isub
    //   84: i2l
    //   85: lstore_3
    //   86: aload 5
    //   88: astore_0
    //   89: aload 5
    //   91: lload_3
    //   92: invokevirtual 265	java/io/RandomAccessFile:seek	(J)V
    //   95: aload 5
    //   97: astore_0
    //   98: invokestatic 271	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   101: iconst_4
    //   102: invokevirtual 275	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   105: astore 7
    //   107: aload 5
    //   109: astore_0
    //   110: aload 5
    //   112: aload 7
    //   114: iconst_0
    //   115: iconst_4
    //   116: invokevirtual 279	java/io/RandomAccessFile:read	([BII)I
    //   119: pop
    //   120: aload 5
    //   122: astore_0
    //   123: aload 7
    //   125: invokestatic 283	com/tencent/mobileqq/text/AppleEmojiManager:bytesToInt	([B)I
    //   128: istore_2
    //   129: aload 5
    //   131: astore_0
    //   132: invokestatic 271	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   135: aload 7
    //   137: invokevirtual 287	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   140: aload 5
    //   142: astore_0
    //   143: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +531 -> 677
    //   149: aload 5
    //   151: astore_0
    //   152: new 129	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   159: astore 7
    //   161: aload 5
    //   163: astore_0
    //   164: aload 7
    //   166: ldc_w 289
    //   169: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 5
    //   175: astore_0
    //   176: aload 7
    //   178: iload_2
    //   179: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 5
    //   185: astore_0
    //   186: ldc_w 291
    //   189: iconst_2
    //   190: aload 7
    //   192: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: goto +479 -> 677
    //   201: aload 5
    //   203: astore_0
    //   204: invokestatic 271	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   207: sipush 4096
    //   210: invokevirtual 275	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   213: astore 7
    //   215: aload 5
    //   217: astore_0
    //   218: aload 7
    //   220: iconst_0
    //   221: aload 5
    //   223: aload 7
    //   225: iconst_0
    //   226: iload_2
    //   227: invokevirtual 279	java/io/RandomAccessFile:read	([BII)I
    //   230: invokestatic 297	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   233: astore 7
    //   235: aload 5
    //   237: astore_0
    //   238: aload 7
    //   240: invokestatic 302	com/tencent/mobileqq/util/Utils:a	(Landroid/graphics/Bitmap;)I
    //   243: istore_2
    //   244: aload 5
    //   246: astore_0
    //   247: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +52 -> 302
    //   253: aload 5
    //   255: astore_0
    //   256: new 129	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   263: astore 8
    //   265: aload 5
    //   267: astore_0
    //   268: aload 8
    //   270: ldc_w 304
    //   273: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 5
    //   279: astore_0
    //   280: aload 8
    //   282: iload_2
    //   283: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 5
    //   289: astore_0
    //   290: ldc_w 291
    //   293: iconst_2
    //   294: aload 8
    //   296: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: iload_2
    //   303: ifle +171 -> 474
    //   306: aload 5
    //   308: astore_0
    //   309: new 306	android/graphics/drawable/BitmapDrawable
    //   312: dup
    //   313: aload 7
    //   315: invokespecial 309	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   318: astore 7
    //   320: aload 5
    //   322: astore_0
    //   323: getstatic 106	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   326: ifnull +89 -> 415
    //   329: aload 5
    //   331: astore_0
    //   332: getstatic 106	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   335: aload 6
    //   337: new 204	android/util/Pair
    //   340: dup
    //   341: aload 7
    //   343: invokevirtual 226	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   346: iload_2
    //   347: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: invokespecial 229	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   353: invokevirtual 233	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   356: pop
    //   357: aload 5
    //   359: astore_0
    //   360: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +52 -> 415
    //   366: aload 5
    //   368: astore_0
    //   369: new 129	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   376: astore 6
    //   378: aload 5
    //   380: astore_0
    //   381: aload 6
    //   383: ldc_w 311
    //   386: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 5
    //   392: astore_0
    //   393: aload 6
    //   395: iload_1
    //   396: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 5
    //   402: astore_0
    //   403: ldc_w 291
    //   406: iconst_2
    //   407: aload 6
    //   409: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: aload 5
    //   417: astore_0
    //   418: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +36 -> 457
    //   424: aload 5
    //   426: astore_0
    //   427: ldc_w 291
    //   430: iconst_2
    //   431: iconst_3
    //   432: anewarray 4	java/lang/Object
    //   435: dup
    //   436: iconst_0
    //   437: ldc_w 313
    //   440: aastore
    //   441: dup
    //   442: iconst_1
    //   443: iload_1
    //   444: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   447: aastore
    //   448: dup
    //   449: iconst_2
    //   450: ldc_w 315
    //   453: aastore
    //   454: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   457: aload 5
    //   459: ifnull +12 -> 471
    //   462: invokestatic 251	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   465: getstatic 256	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   468: invokevirtual 317	com/tencent/mobileqq/utils/RandomAccessFileManager:b	(Ljava/lang/String;)V
    //   471: aload 7
    //   473: areturn
    //   474: aload 5
    //   476: ifnull +12 -> 488
    //   479: invokestatic 251	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   482: getstatic 256	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   485: invokevirtual 317	com/tencent/mobileqq/utils/RandomAccessFileManager:b	(Ljava/lang/String;)V
    //   488: aconst_null
    //   489: areturn
    //   490: aload 5
    //   492: astore_0
    //   493: new 129	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   500: astore 6
    //   502: aload 5
    //   504: astore_0
    //   505: aload 6
    //   507: ldc_w 319
    //   510: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 5
    //   516: astore_0
    //   517: aload 6
    //   519: iload_1
    //   520: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 5
    //   526: astore_0
    //   527: ldc_w 291
    //   530: iconst_4
    //   531: aload 6
    //   533: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: aload 5
    //   541: ifnull +12 -> 553
    //   544: invokestatic 251	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   547: getstatic 256	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   550: invokevirtual 317	com/tencent/mobileqq/utils/RandomAccessFileManager:b	(Ljava/lang/String;)V
    //   553: aconst_null
    //   554: areturn
    //   555: astore 6
    //   557: goto +15 -> 572
    //   560: astore 5
    //   562: aconst_null
    //   563: astore_0
    //   564: goto +97 -> 661
    //   567: astore 6
    //   569: aconst_null
    //   570: astore 5
    //   572: aload 5
    //   574: astore_0
    //   575: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   578: ifeq +18 -> 596
    //   581: aload 5
    //   583: astore_0
    //   584: ldc_w 291
    //   587: iconst_2
    //   588: ldc_w 320
    //   591: aload 6
    //   593: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   596: aload 5
    //   598: ifnonnull +9 -> 607
    //   601: aload 5
    //   603: astore_0
    //   604: invokestatic 327	com/tencent/mobileqq/text/EmotcationConstants:reDownloadAppleEmoji	()V
    //   607: aload 5
    //   609: ifnull +12 -> 621
    //   612: invokestatic 251	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   615: getstatic 256	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   618: invokevirtual 317	com/tencent/mobileqq/utils/RandomAccessFileManager:b	(Ljava/lang/String;)V
    //   621: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   624: ifeq +33 -> 657
    //   627: ldc_w 291
    //   630: iconst_2
    //   631: iconst_3
    //   632: anewarray 4	java/lang/Object
    //   635: dup
    //   636: iconst_0
    //   637: ldc_w 313
    //   640: aastore
    //   641: dup
    //   642: iconst_1
    //   643: iload_1
    //   644: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   647: aastore
    //   648: dup
    //   649: iconst_2
    //   650: ldc_w 329
    //   653: aastore
    //   654: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   657: aconst_null
    //   658: areturn
    //   659: astore 5
    //   661: aload_0
    //   662: ifnull +12 -> 674
    //   665: invokestatic 251	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   668: getstatic 256	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   671: invokevirtual 317	com/tencent/mobileqq/utils/RandomAccessFileManager:b	(Ljava/lang/String;)V
    //   674: aload 5
    //   676: athrow
    //   677: iload_2
    //   678: iflt -188 -> 490
    //   681: iload_2
    //   682: sipush 4096
    //   685: if_icmple -484 -> 201
    //   688: goto -198 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	691	0	paramResources	Resources
    //   0	691	1	paramInt	int
    //   128	558	2	i	int
    //   85	7	3	l	long
    //   7	533	5	localObject1	Object
    //   560	1	5	localObject2	Object
    //   570	38	5	localObject3	Object
    //   659	16	5	localObject4	Object
    //   29	503	6	localObject5	Object
    //   555	1	6	localThrowable1	java.lang.Throwable
    //   567	25	6	localThrowable2	java.lang.Throwable
    //   105	367	7	localObject6	Object
    //   263	32	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   89	95	555	java/lang/Throwable
    //   98	107	555	java/lang/Throwable
    //   110	120	555	java/lang/Throwable
    //   123	129	555	java/lang/Throwable
    //   132	140	555	java/lang/Throwable
    //   143	149	555	java/lang/Throwable
    //   152	161	555	java/lang/Throwable
    //   164	173	555	java/lang/Throwable
    //   176	183	555	java/lang/Throwable
    //   186	198	555	java/lang/Throwable
    //   204	215	555	java/lang/Throwable
    //   218	235	555	java/lang/Throwable
    //   238	244	555	java/lang/Throwable
    //   247	253	555	java/lang/Throwable
    //   256	265	555	java/lang/Throwable
    //   268	277	555	java/lang/Throwable
    //   280	287	555	java/lang/Throwable
    //   290	302	555	java/lang/Throwable
    //   309	320	555	java/lang/Throwable
    //   323	329	555	java/lang/Throwable
    //   332	357	555	java/lang/Throwable
    //   360	366	555	java/lang/Throwable
    //   369	378	555	java/lang/Throwable
    //   381	390	555	java/lang/Throwable
    //   393	400	555	java/lang/Throwable
    //   403	415	555	java/lang/Throwable
    //   418	424	555	java/lang/Throwable
    //   427	457	555	java/lang/Throwable
    //   493	502	555	java/lang/Throwable
    //   505	514	555	java/lang/Throwable
    //   517	524	555	java/lang/Throwable
    //   527	539	555	java/lang/Throwable
    //   68	79	560	finally
    //   68	79	567	java/lang/Throwable
    //   89	95	659	finally
    //   98	107	659	finally
    //   110	120	659	finally
    //   123	129	659	finally
    //   132	140	659	finally
    //   143	149	659	finally
    //   152	161	659	finally
    //   164	173	659	finally
    //   176	183	659	finally
    //   186	198	659	finally
    //   204	215	659	finally
    //   218	235	659	finally
    //   238	244	659	finally
    //   247	253	659	finally
    //   256	265	659	finally
    //   268	277	659	finally
    //   280	287	659	finally
    //   290	302	659	finally
    //   309	320	659	finally
    //   323	329	659	finally
    //   332	357	659	finally
    //   360	366	659	finally
    //   369	378	659	finally
    //   381	390	659	finally
    //   393	400	659	finally
    //   403	415	659	finally
    //   418	424	659	finally
    //   427	457	659	finally
    //   493	502	659	finally
    //   505	514	659	finally
    //   517	524	659	finally
    //   527	539	659	finally
    //   575	581	659	finally
    //   584	596	659	finally
    //   604	607	659	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQEmojiUtil
 * JD-Core Version:    0.7.0.1
 */