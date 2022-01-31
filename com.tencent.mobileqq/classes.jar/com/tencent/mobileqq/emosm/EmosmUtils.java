package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
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

public class EmosmUtils
{
  public static String a = "ipsite.png";
  
  public static int a(int paramInt)
  {
    int i = 11001;
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "default RESULT_CODE_OTHER_ERROR .");
      }
      paramInt = 11011;
    }
    label304:
    label358:
    label380:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return paramInt;
                              paramInt = 11002;
                            } while (!QLog.isColorLevel());
                            QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_NET_UNKNOWN_HOST ");
                            return 11002;
                            paramInt = 11003;
                          } while (!QLog.isColorLevel());
                          QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_NET_UNUSABLE .");
                          return 11003;
                          paramInt = 11006;
                        } while (!QLog.isColorLevel());
                        QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_CONTENT_LOSSY .");
                        return 11006;
                        paramInt = 11007;
                      } while (!QLog.isColorLevel());
                      QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_USER_CANCEL .");
                      return 11007;
                      paramInt = 11004;
                    } while (!QLog.isColorLevel());
                    QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_NET_CONNECT_TIMEOUT .");
                    return 11004;
                    paramInt = 11005;
                  } while (!QLog.isColorLevel());
                  QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_NET_SO_TIMEOUT .");
                  return 11005;
                  paramInt = 11012;
                } while (!QLog.isColorLevel());
                QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_SOCKET_EXCEPTION_ERROR .");
                return 11012;
                if (!Utils.a()) {
                  break label304;
                }
                if (Utils.b() >= 1048576L) {
                  break;
                }
                paramInt = i;
              } while (!QLog.isColorLevel());
              QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_SDCARD less 1mb .");
              return 11001;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_DOWNLOAD_OTHER_ERROR .");
              return 11011;
              if (!QLog.isColorLevel()) {
                break label464;
              }
              QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_SDCARD_UNUSABLE .");
              return 11000;
              if (!Utils.a()) {
                break label380;
              }
              if (Utils.b() >= 1048576L) {
                break label358;
              }
              paramInt = i;
            } while (!QLog.isColorLevel());
            QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_SDCARD less 1mb .");
            return 11001;
            paramInt = 11013;
          } while (!QLog.isColorLevel());
          QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_LOCAL_FILESYSTEM_FAIL .");
          return 11013;
          if (!QLog.isColorLevel()) {
            break label464;
          }
          QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_SDCARD_UNUSABLE .");
          return 11000;
          paramInt = 11016;
        } while (!QLog.isColorLevel());
        QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_HTTP_RESPONSE_NO_OK .");
        return 11016;
        paramInt = 11014;
      } while (!QLog.isColorLevel());
      QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_URL_STRING_ILLEGAL .");
      return 11014;
      paramInt = 11021;
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, " RESULT_CODE_IS_HTML .");
    return 11021;
    label464:
    return 11000;
  }
  
  public static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
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
  
  public static int a(byte[] paramArrayOfByte, String paramString)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      i = 11017;
    }
    boolean bool;
    do
    {
      return i;
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return 11018;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. encryptFi,desData.len=" + paramArrayOfByte.length + " file=" + paramString + " time=" + System.currentTimeMillis());
      }
      bool = FileUtils.a(paramString, paramArrayOfByte, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. write to file " + bool + ",data.len=" + paramArrayOfByte.length + " file=" + paramString + " time=" + System.currentTimeMillis());
      }
    } while (bool);
    return 11019;
  }
  
  public static int a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      i = 11017;
    }
    boolean bool;
    do
    {
      return i;
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "doing decryptTEA,srcData.len=" + paramArrayOfByte.length + " emoKey=" + paramString1 + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
      paramArrayOfByte = a(paramArrayOfByte, paramString1.getBytes());
      if (paramArrayOfByte == null) {
        return 11017;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. decryptTEA,clearData.len=" + paramArrayOfByte.length + " emoKey=" + paramString1 + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return 11018;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. encryptFi,desData.len=" + paramArrayOfByte.length + " emoKey=" + paramString1 + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
      bool = FileUtils.a(paramString2, paramArrayOfByte, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "done. write to file " + bool + ",data.len=" + paramArrayOfByte.length + " file=" + paramString2 + " time=" + System.currentTimeMillis());
      }
    } while (bool);
    return 11019;
  }
  
  public static Drawable a(int paramInt, String paramString)
  {
    Object localObject = null;
    File localFile = new File(a(paramInt, paramString));
    paramString = localObject;
    if (localFile.exists()) {
      paramString = URLDrawable.getDrawable(localFile, null);
    }
    return paramString;
  }
  
  public static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(EmoticonUtils.n.replace("[epId]", paramString));
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("color.png");
      continue;
      localStringBuilder.append("gray.png");
      continue;
      localStringBuilder.append("list.png");
      continue;
      localStringBuilder.append("drainage.png");
      continue;
      localStringBuilder.append(a);
    }
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    a = "ipsite_" + paramString2 + ".png";
    return a(paramInt, paramString1);
  }
  
  public static String a(Context paramContext, QQMessageFacade.Message paramMessage)
  {
    if ((paramContext == null) || (paramMessage == null)) {
      return null;
    }
    MessageForMarketFace localMessageForMarketFace = new MessageForMarketFace();
    localMessageForMarketFace.msgData = paramMessage.msgData;
    localMessageForMarketFace.parse();
    if ((localMessageForMarketFace.mMarkFaceMessage != null) && (!TextUtils.isEmpty(localMessageForMarketFace.mMarkFaceMessage.faceName)))
    {
      paramContext = new StringBuilder();
      paramContext.append("[").append(localMessageForMarketFace.mMarkFaceMessage.faceName).append("]");
      return paramContext.toString();
    }
    return paramContext.getString(2131436259);
  }
  
  public static String a(String paramString)
  {
    int i = a(paramString);
    if (i == -1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/" + i % 10 + "/" + paramString + "_android.json");
    return a("VIP_emosm", localStringBuilder.toString());
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i = a(paramString);
    if (i == -1) {
      return null;
    }
    i %= 10;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/audio.zip");
    }
    for (;;)
    {
      return a("VIP_emosm", localStringBuilder.toString());
      if (1 == paramInt) {
        if ("sbig".equalsIgnoreCase(MagicfaceResLoader.a())) {
          localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidsbig.zip");
        } else if ("xbig".equalsIgnoreCase(MagicfaceResLoader.a())) {
          localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidxbig.zip");
        } else if ("big".equalsIgnoreCase(MagicfaceResLoader.a())) {
          localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidbig.zip");
        } else {
          localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i + "/" + paramString + "/androidsmall.zip");
        }
      }
    }
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
    return PkgTools.a(paramArrayOfByte).toLowerCase();
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    SecurityUtile.a(paramArrayOfByte, paramInt1, paramInt2, paramLong, 200);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = NetworkUtil.d(BaseApplicationImpl.getContext());
    if (!bool) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131432992, 0).a();
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString) != -1;
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 144	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 153	java/io/File:exists	()Z
    //   11: ifeq +63 -> 74
    //   14: new 314	java/io/FileInputStream
    //   17: dup
    //   18: new 144	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 317	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: invokevirtual 321	java/io/FileInputStream:available	()I
    //   36: newarray byte
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 325	java/io/FileInputStream:read	([B)I
    //   46: pop
    //   47: aload_1
    //   48: ifnull +7 -> 55
    //   51: aload_1
    //   52: invokevirtual 328	java/io/FileInputStream:close	()V
    //   55: aload_2
    //   56: areturn
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: astore_0
    //   62: aload_2
    //   63: invokevirtual 329	java/io/FileNotFoundException:printStackTrace	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 328	java/io/FileInputStream:close	()V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_2
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: aload_2
    //   82: invokevirtual 330	java/io/IOException:printStackTrace	()V
    //   85: aload_1
    //   86: ifnull -12 -> 74
    //   89: aload_1
    //   90: invokevirtual 328	java/io/FileInputStream:close	()V
    //   93: goto -19 -> 74
    //   96: astore_0
    //   97: goto -23 -> 74
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_0
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 328	java/io/FileInputStream:close	()V
    //   111: aload_1
    //   112: athrow
    //   113: astore_0
    //   114: aload_2
    //   115: areturn
    //   116: astore_0
    //   117: goto -43 -> 74
    //   120: astore_0
    //   121: goto -10 -> 111
    //   124: astore_1
    //   125: goto -22 -> 103
    //   128: astore_2
    //   129: goto -50 -> 79
    //   132: astore_2
    //   133: goto -73 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   29	61	1	localFileInputStream	java.io.FileInputStream
    //   100	12	1	localObject1	Object
    //   124	1	1	localObject2	Object
    //   38	18	2	arrayOfByte	byte[]
    //   57	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   76	39	2	localIOException1	java.io.IOException
    //   128	1	2	localIOException2	java.io.IOException
    //   132	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   14	30	57	java/io/FileNotFoundException
    //   14	30	76	java/io/IOException
    //   89	93	96	java/io/IOException
    //   14	30	100	finally
    //   51	55	113	java/io/IOException
    //   70	74	116	java/io/IOException
    //   107	111	120	java/io/IOException
    //   32	39	124	finally
    //   41	47	124	finally
    //   62	66	124	finally
    //   81	85	124	finally
    //   32	39	128	java/io/IOException
    //   41	47	128	java/io/IOException
    //   32	39	132	java/io/FileNotFoundException
    //   41	47	132	java/io/FileNotFoundException
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    Object localObject = null;
    if ((paramInt == 0) || (paramInt == 2) || (paramInt == 4))
    {
      int i = paramString.length() / 2;
      byte[] arrayOfByte = new byte[i];
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfByte;
        if (paramInt >= i) {
          break;
        }
        arrayOfByte[paramInt] = Integer.valueOf(paramString.substring(paramInt * 2, paramInt * 2 + 2), 16).byteValue();
        paramInt += 1;
      }
    }
    if (paramInt == 1) {
      localObject = paramString.getBytes();
    }
    return localObject;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return SecurityUtile.a(paramArrayOfByte, 200);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte;
    if (!VersionUtils.b()) {
      arrayOfByte = new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
    }
    do
    {
      return arrayOfByte;
      arrayOfByte = null;
    } while (0 != 0);
    return new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static char[] a(int paramInt1, int paramInt2)
  {
    return new char[] { (char)(paramInt1 >> 8), (char)(paramInt1 & 0xFF), (char)paramInt2, 'ÿ' };
  }
  
  public static int[] a(char[] paramArrayOfChar)
  {
    return new int[] { a(new byte[] { (byte)paramArrayOfChar[0], (byte)paramArrayOfChar[1] }, 2), paramArrayOfChar[2] };
  }
  
  public static String b(int paramInt, String paramString)
  {
    int i = a(paramString);
    if (i == -1) {
      return null;
    }
    i %= 10;
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt)
    {
    }
    for (;;)
    {
      return a("VIP_emosm", localStringBuilder.toString());
      localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/img/parcel/" + i + "/" + paramString + "/60x60_color.png");
      continue;
      localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/img/parcel/" + i + "/" + paramString + "/60x60_gray.png");
      continue;
      localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/img/parcel/" + i + "/" + paramString + "/126x126.png");
      continue;
      localStringBuilder.append("http://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_" + paramString + "/color.png");
      continue;
      localStringBuilder.append("http://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_" + paramString + "/gray.png");
      continue;
      localStringBuilder.append("http://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_" + paramString + "/list.png");
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      i = a(paramString);
    } while (i == -1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://i.gtimg.cn/club/item/parcel/").append(i % 10).append("/").append(paramString).append("/").append("h5.zip");
    return a("VIP_emosm", localStringBuilder.toString());
  }
  
  public static boolean b(String paramString)
  {
    paramString = new EmosmRandomAccessFile(paramString, "r");
    byte[] arrayOfByte = new byte[10];
    paramString.read(arrayOfByte);
    if ((arrayOfByte[0] != 71) || (arrayOfByte[1] != 73) || (arrayOfByte[2] != 70))
    {
      paramString.close();
      return false;
    }
    paramString.close();
    return true;
  }
  
  public static byte[] b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return b(paramString);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    SecurityUtile.a(paramArrayOfByte, 0, paramArrayOfByte.length, 0L, 200);
    return paramArrayOfByte;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(EmoticonUtils.n.replace("[epId]", paramString));
    localStringBuilder.append("h5.zip");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.EmosmUtils
 * JD-Core Version:    0.7.0.1
 */