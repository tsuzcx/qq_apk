package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import mqq.app.MobileQQ;

public class EmosmUtils
{
  public static String a = "ipsite.png";
  
  protected static int a()
  {
    if (Utils.b())
    {
      if (Utils.c() < 1048576L)
      {
        e(" RESULT_CODE_SDCARD less 1mb .");
        return 11001;
      }
      e(" RESULT_CODE_DOWNLOAD_OTHER_ERROR .");
      return 11011;
    }
    e(" RESULT_CODE_SDCARD_UNUSABLE .");
    return 11000;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      e("default RESULT_CODE_OTHER_ERROR .");
      return 11011;
    case 15: 
      e(" RESULT_CODE_IS_HTML .");
      return 11021;
    case 14: 
      e(" RESULT_CODE_HTTP_RESPONSE_NO_OK .");
      return 11016;
    case 13: 
      e(" RESULT_CODE_URL_STRING_ILLEGAL .");
      return 11014;
    case 12: 
      return b();
    case 11: 
      e(" RESULT_CODE_SOCKET_EXCEPTION_ERROR .");
      return 11012;
    case 10: 
      e(" RESULT_CODE_NET_UNKNOWN_HOST ");
      return 11002;
    case 9: 
      e(" RESULT_CODE_NET_UNUSABLE .");
      return 11003;
    case 8: 
      e(" RESULT_CODE_CONTENT_LOSSY .");
      return 11006;
    case 6: 
      e(" RESULT_CODE_USER_CANCEL .");
      return 11007;
    case 4: 
      return a();
    case 3: 
      e(" RESULT_CODE_NET_SO_TIMEOUT .");
      return 11005;
    }
    e(" RESULT_CODE_NET_CONNECT_TIMEOUT .");
    return 11004;
  }
  
  public static int a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return 11017;
    }
    paramArrayOfByte = a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return 11018;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("done. encryptFi,desData.len=");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(" file=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" time=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Q.emoji.EmoDown", 2, localStringBuilder.toString());
    }
    int i = 11019;
    boolean bool = FileUtils.pushData2File(paramString, paramArrayOfByte, false);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("done. write to file ");
      localStringBuilder.append(bool);
      localStringBuilder.append(",data.len=");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(" file=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" time=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Q.emoji.EmoDown", 2, localStringBuilder.toString());
    }
    if (bool) {
      i = 0;
    }
    return i;
  }
  
  public static int a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if (paramArrayOfByte == null) {
      return 11017;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doing decryptTEA,srcData.len=");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(" emoKey=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" file=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" time=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Q.emoji.EmoDown", 2, localStringBuilder.toString());
    }
    paramArrayOfByte = a(paramArrayOfByte, paramString1.getBytes());
    if (paramArrayOfByte == null) {
      return 11017;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("done. decryptTEA,clearData.len=");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(" emoKey=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" file=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" time=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Q.emoji.EmoDown", 2, localStringBuilder.toString());
    }
    paramArrayOfByte = a(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return 11018;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("done. encryptFi,desData.len=");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(" emoKey=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" file=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" time=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("Q.emoji.EmoDown", 2, localStringBuilder.toString());
    }
    int i = 11019;
    boolean bool = FileUtils.pushData2File(paramString2, paramArrayOfByte, false);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("done. write to file ");
      paramString1.append(bool);
      paramString1.append(",data.len=");
      paramString1.append(paramArrayOfByte.length);
      paramString1.append(" file=");
      paramString1.append(paramString2);
      paramString1.append(" time=");
      paramString1.append(System.currentTimeMillis());
      QLog.d("Q.emoji.EmoDown", 2, paramString1.toString());
    }
    if (bool) {
      i = 0;
    }
    return i;
  }
  
  public static Drawable a(int paramInt, String paramString)
  {
    paramString = new File(b(paramInt, paramString));
    if (paramString.exists()) {
      return URLDrawable.getDrawable(paramString, null);
    }
    return null;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ipsite_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".png");
    a = localStringBuilder.toString();
    return b(paramInt, paramString1);
  }
  
  public static String a(Context paramContext, Message paramMessage)
  {
    if ((paramContext != null) && (paramMessage != null))
    {
      MessageForMarketFace localMessageForMarketFace = new MessageForMarketFace();
      localMessageForMarketFace.msgData = paramMessage.msgData;
      localMessageForMarketFace.parse();
      if ((localMessageForMarketFace.mMarkFaceMessage != null) && (!TextUtils.isEmpty(localMessageForMarketFace.mMarkFaceMessage.faceName)))
      {
        paramContext = new StringBuilder();
        paramContext.append("[");
        paramContext.append(localMessageForMarketFace.mMarkFaceMessage.faceName);
        paramContext.append("]");
        return paramContext.toString();
      }
      return paramContext.getString(2131888889);
    }
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i = EmoticonPanelUtils.b(paramString);
    if (i == -1) {
      return null;
    }
    i %= 10;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if (paramInt == 0)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/");
      localStringBuilder2.append(i);
      localStringBuilder2.append("/");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("/audio.zip");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else if (1 == paramInt)
    {
      if ("sbig".equalsIgnoreCase(MagicfaceResLoader.a()))
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/");
        localStringBuilder2.append(i);
        localStringBuilder2.append("/");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append("/androidsbig.zip");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      else if ("xbig".equalsIgnoreCase(MagicfaceResLoader.a()))
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/");
        localStringBuilder2.append(i);
        localStringBuilder2.append("/");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append("/androidxbig.zip");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      else if ("big".equalsIgnoreCase(MagicfaceResLoader.a()))
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/");
        localStringBuilder2.append(i);
        localStringBuilder2.append("/");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append("/androidbig.zip");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      else
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/");
        localStringBuilder2.append(i);
        localStringBuilder2.append("/");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append("/androidsmall.zip");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
    }
    return a("VIP_emosm", localStringBuilder1.toString());
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return MsfSdkUtils.insertMtype(paramString1, paramString2);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramInt == 2) {
      return new String(paramArrayOfByte);
    }
    return PkgTools.toHexStr(paramArrayOfByte).toLowerCase();
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    SecurityUtile.xorInLimit(paramArrayOfByte, paramInt1, paramInt2, paramLong, 200);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = NetworkUtil.isNetSupport(MobileQQ.getContext());
    if (!bool) {
      QQToast.makeText(MobileQQ.getContext(), 2131897764, 0).show();
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    return EmoticonPanelUtils.b(paramString) != -1;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return SecurityUtile.xorInLimit(paramArrayOfByte, 200);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (!VersionUtils.b()) {
      return new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
    }
    return new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static char[] a(int paramInt1, int paramInt2)
  {
    return new char[] { 'ÿ', (char)(paramInt1 >> 8), (char)(paramInt1 & 0xFF), (char)paramInt2 };
  }
  
  public static int[] a(char[] paramArrayOfChar)
  {
    return new int[] { b(new byte[] { (byte)paramArrayOfChar[0], (byte)paramArrayOfChar[1] }, 2), paramArrayOfChar[2] };
  }
  
  protected static int b()
  {
    if (Utils.b())
    {
      if (Utils.c() < 1048576L)
      {
        e(" RESULT_CODE_SDCARD less 1mb .");
        return 11001;
      }
      e(" RESULT_CODE_LOCAL_FILESYSTEM_FAIL .");
      return 11013;
    }
    e(" RESULT_CODE_SDCARD_UNUSABLE .");
    return 11000;
  }
  
  public static int b(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j = j << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return j;
  }
  
  public static String b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", paramString));
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 22)
          {
            if (paramInt == 23) {
              localStringBuilder.append(a);
            }
          }
          else {
            localStringBuilder.append("drainage.png");
          }
        }
        else {
          localStringBuilder.append("gray.png");
        }
      }
      else {
        localStringBuilder.append("color.png");
      }
    }
    else {
      localStringBuilder.append("list.png");
    }
    return localStringBuilder.toString();
  }
  
  public static String b(Context paramContext, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.msgData != null) && (paramMessage.msgData.length >= 1))
    {
      paramContext = new MessageForAniSticker();
      paramContext.deserializeMsgData(paramMessage.msgData);
      return paramContext.text;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageForAniSticker", 2, "Get Brief for notification when message null");
    }
    return "";
  }
  
  /* Error */
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: new 139	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 147	java/io/File:exists	()Z
    //   11: ifeq +102 -> 113
    //   14: new 347	java/io/FileInputStream
    //   17: dup
    //   18: new 139	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 350	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: invokevirtual 353	java/io/FileInputStream:available	()I
    //   36: newarray byte
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 357	java/io/FileInputStream:read	([B)I
    //   46: pop
    //   47: aload_1
    //   48: invokevirtual 360	java/io/FileInputStream:close	()V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: goto +16 -> 70
    //   57: astore_2
    //   58: goto +31 -> 89
    //   61: astore_1
    //   62: aconst_null
    //   63: astore_0
    //   64: goto +39 -> 103
    //   67: astore_2
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: aload_2
    //   73: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   76: aload_1
    //   77: ifnull +36 -> 113
    //   80: aload_1
    //   81: invokevirtual 360	java/io/FileInputStream:close	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: astore_0
    //   91: aload_2
    //   92: invokevirtual 364	java/io/FileNotFoundException:printStackTrace	()V
    //   95: aload_1
    //   96: ifnull +17 -> 113
    //   99: goto -19 -> 80
    //   102: astore_1
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 360	java/io/FileInputStream:close	()V
    //   111: aload_1
    //   112: athrow
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: aload_2
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: areturn
    //   121: astore_0
    //   122: goto -11 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   29	19	1	localFileInputStream	java.io.FileInputStream
    //   61	1	1	localObject1	Object
    //   69	27	1	localObject2	Object
    //   102	10	1	localObject3	Object
    //   38	14	2	arrayOfByte	byte[]
    //   53	1	2	localIOException1	java.io.IOException
    //   57	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   67	6	2	localIOException2	java.io.IOException
    //   86	31	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   32	39	53	java/io/IOException
    //   41	47	53	java/io/IOException
    //   32	39	57	java/io/FileNotFoundException
    //   41	47	57	java/io/FileNotFoundException
    //   14	30	61	finally
    //   14	30	67	java/io/IOException
    //   14	30	86	java/io/FileNotFoundException
    //   32	39	102	finally
    //   41	47	102	finally
    //   72	76	102	finally
    //   91	95	102	finally
    //   47	51	115	java/io/IOException
    //   80	84	118	java/io/IOException
    //   107	111	121	java/io/IOException
  }
  
  public static byte[] b(String paramString, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 4))
    {
      if (paramInt == 1) {
        return paramString.getBytes();
      }
      return null;
    }
    int i = paramString.length() / 2;
    byte[] arrayOfByte = new byte[i];
    paramInt = 0;
    while (paramInt < i)
    {
      int j = paramInt * 2;
      arrayOfByte[paramInt] = Integer.valueOf(paramString.substring(j, j + 2), 16).byteValue();
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    SecurityUtile.xorInLimit(paramArrayOfByte, 0, paramArrayOfByte.length, 0L, 200);
    return paramArrayOfByte;
  }
  
  public static char[] b(int paramInt1, int paramInt2)
  {
    return new char[] { (char)(paramInt1 >> 8), (char)(paramInt1 & 0xFF), (char)paramInt2, 'ÿ' };
  }
  
  public static String c(int paramInt, String paramString)
  {
    int i = EmoticonPanelUtils.b(paramString);
    if (i == -1) {
      return null;
    }
    i %= 10;
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt == 13) {
            break label286;
          }
          if (paramInt != 14) {
            switch (paramInt)
            {
            default: 
              break;
            case 19: 
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_");
              localStringBuilder2.append(paramString);
              localStringBuilder2.append("/list.png");
              localStringBuilder1.append(localStringBuilder2.toString());
              break;
            case 18: 
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_");
              localStringBuilder2.append(paramString);
              localStringBuilder2.append("/gray.png");
              localStringBuilder1.append(localStringBuilder2.toString());
              break;
            case 17: 
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_");
              localStringBuilder2.append(paramString);
              localStringBuilder2.append("/color.png");
              localStringBuilder1.append(localStringBuilder2.toString());
              break;
            }
          }
        }
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("https://i.gtimg.cn/club/item/parcel/img/parcel/");
        localStringBuilder2.append(i);
        localStringBuilder2.append("/");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append("/60x60_gray.png");
        localStringBuilder1.append(localStringBuilder2.toString());
        break label407;
      }
      label286:
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("https://i.gtimg.cn/club/item/parcel/img/parcel/");
      localStringBuilder2.append(i);
      localStringBuilder2.append("/");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("/60x60_color.png");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("https://i.gtimg.cn/club/item/parcel/img/parcel/");
      localStringBuilder2.append(i);
      localStringBuilder2.append("/");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("/126x126.png");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    label407:
    return a("VIP_emosm", localStringBuilder1.toString());
  }
  
  public static byte[] c(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return b(paramString);
    }
    return null;
  }
  
  /* Error */
  public static boolean d(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: aconst_null
    //   8: astore 7
    //   10: aconst_null
    //   11: astore 5
    //   13: new 404	com/tencent/mobileqq/emosm/EmosmRandomAccessFile
    //   16: dup
    //   17: aload_0
    //   18: ldc_w 406
    //   21: invokespecial 409	com/tencent/mobileqq/emosm/EmosmRandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: astore_0
    //   25: bipush 10
    //   27: newarray byte
    //   29: astore 5
    //   31: aload_0
    //   32: aload 5
    //   34: invokevirtual 410	com/tencent/mobileqq/emosm/EmosmRandomAccessFile:read	([B)I
    //   37: pop
    //   38: iload_3
    //   39: istore_2
    //   40: aload 5
    //   42: iconst_0
    //   43: baload
    //   44: bipush 71
    //   46: if_icmpne +29 -> 75
    //   49: iload_3
    //   50: istore_2
    //   51: aload 5
    //   53: iconst_1
    //   54: baload
    //   55: bipush 73
    //   57: if_icmpne +18 -> 75
    //   60: aload 5
    //   62: iconst_2
    //   63: baload
    //   64: istore_1
    //   65: iload_3
    //   66: istore_2
    //   67: iload_1
    //   68: bipush 70
    //   70: if_icmpne +5 -> 75
    //   73: iconst_1
    //   74: istore_2
    //   75: aload_0
    //   76: invokevirtual 411	com/tencent/mobileqq/emosm/EmosmRandomAccessFile:close	()V
    //   79: iload_2
    //   80: ireturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   86: iload_2
    //   87: istore_3
    //   88: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +103 -> 194
    //   94: ldc_w 413
    //   97: iconst_2
    //   98: ldc_w 415
    //   101: aload_0
    //   102: invokestatic 418	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: iload_2
    //   106: ireturn
    //   107: astore 6
    //   109: aload_0
    //   110: astore 5
    //   112: aload 6
    //   114: astore_0
    //   115: goto +81 -> 196
    //   118: astore 6
    //   120: goto +12 -> 132
    //   123: astore_0
    //   124: goto +72 -> 196
    //   127: astore 6
    //   129: aload 7
    //   131: astore_0
    //   132: aload_0
    //   133: astore 5
    //   135: aload 6
    //   137: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   140: aload_0
    //   141: astore 5
    //   143: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +18 -> 164
    //   149: aload_0
    //   150: astore 5
    //   152: ldc_w 413
    //   155: iconst_2
    //   156: ldc_w 420
    //   159: aload 6
    //   161: invokestatic 418	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: iload 4
    //   166: istore_3
    //   167: aload_0
    //   168: ifnull +26 -> 194
    //   171: aload_0
    //   172: invokevirtual 411	com/tencent/mobileqq/emosm/EmosmRandomAccessFile:close	()V
    //   175: iconst_0
    //   176: ireturn
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   182: iload 4
    //   184: istore_3
    //   185: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +6 -> 194
    //   191: goto -97 -> 94
    //   194: iload_3
    //   195: ireturn
    //   196: aload 5
    //   198: ifnull +36 -> 234
    //   201: aload 5
    //   203: invokevirtual 411	com/tencent/mobileqq/emosm/EmosmRandomAccessFile:close	()V
    //   206: goto +28 -> 234
    //   209: astore 5
    //   211: aload 5
    //   213: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   216: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +15 -> 234
    //   222: ldc_w 413
    //   225: iconst_2
    //   226: ldc_w 415
    //   229: aload 5
    //   231: invokestatic 418	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: goto +5 -> 239
    //   237: aload_0
    //   238: athrow
    //   239: goto -2 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramString	String
    //   64	7	1	i	int
    //   1	105	2	bool1	boolean
    //   6	189	3	bool2	boolean
    //   3	180	4	bool3	boolean
    //   11	191	5	localObject1	Object
    //   209	21	5	localIOException1	java.io.IOException
    //   107	6	6	localObject2	Object
    //   118	1	6	localIOException2	java.io.IOException
    //   127	33	6	localIOException3	java.io.IOException
    //   8	122	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   75	79	81	java/io/IOException
    //   25	38	107	finally
    //   25	38	118	java/io/IOException
    //   13	25	123	finally
    //   135	140	123	finally
    //   143	149	123	finally
    //   152	164	123	finally
    //   13	25	127	java/io/IOException
    //   171	175	177	java/io/IOException
    //   201	206	209	java/io/IOException
  }
  
  protected static void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoDown", 2, paramString);
    }
  }
  
  public static String f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = EmoticonPanelUtils.b(paramString);
    if (i == -1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://i.gtimg.cn/club/item/parcel/");
    localStringBuilder.append(i % 10);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    localStringBuilder.append("h5.zip");
    return a("VIP_emosm", localStringBuilder.toString());
  }
  
  public static String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(EmotionPanelConstans.emoticonPackageFolderPath.replace("[epId]", paramString));
    localStringBuilder.append("h5.zip");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.EmosmUtils
 * JD-Core Version:    0.7.0.1
 */