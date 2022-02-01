package com.tencent.superplayer.utils;

import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.api.TVideoNetInfo.DefinitionInfo;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils
{
  public static final String TAG = Utils.class.getSimpleName();
  
  public static String calculateFileIDForVideoInfo(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getFileId())) {
      return paramSuperPlayerVideoInfo.getFileId();
    }
    if ((!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getVid())) && (paramSuperPlayerVideoInfo.getTVideoNetInfo() != null) && (paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition() != null)) {
      return paramSuperPlayerVideoInfo.getVid() + paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition().getDefn();
    }
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) {
      return calculateMD5ForInput(paramSuperPlayerVideoInfo.getPlayUrl());
    }
    return null;
  }
  
  public static String calculateMD5ForInput(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString != null)
    {
      localObject1 = localObject3;
      if ("".equals(paramString)) {}
    }
    try
    {
      localObject1 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject1).update(paramString.getBytes());
      paramString = new BigInteger(1, ((MessageDigest)localObject1).digest()).toString(16);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
    {
      try
      {
        while (paramString.length() < 32)
        {
          localObject1 = "0" + paramString;
          paramString = (String)localObject1;
        }
        localObject1 = paramString.toUpperCase();
        return localObject1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        break label97;
      }
      localNoSuchAlgorithmException1 = localNoSuchAlgorithmException1;
      paramString = localObject2;
    }
    label97:
    localNoSuchAlgorithmException1.printStackTrace();
    return paramString;
  }
  
  /* Error */
  public static Object convertBytesToObject(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 125	java/io/ByteArrayInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 127	java/io/ByteArrayInputStream:<init>	([B)V
    //   10: astore_0
    //   11: new 129	java/io/ObjectInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 132	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_1
    //   20: aload_1
    //   21: astore_0
    //   22: aload_1
    //   23: invokeinterface 138 1 0
    //   28: astore_2
    //   29: aload_2
    //   30: astore_0
    //   31: aload_0
    //   32: astore_2
    //   33: aload_1
    //   34: ifnull +11 -> 45
    //   37: aload_1
    //   38: invokeinterface 141 1 0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_2
    //   46: areturn
    //   47: astore_1
    //   48: getstatic 16	com/tencent/superplayer/utils/Utils:TAG	Ljava/lang/String;
    //   51: aload_1
    //   52: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   55: invokestatic 148	com/tencent/superplayer/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: areturn
    //   60: astore_2
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_1
    //   64: astore_0
    //   65: getstatic 16	com/tencent/superplayer/utils/Utils:TAG	Ljava/lang/String;
    //   68: aload_2
    //   69: invokevirtual 149	java/lang/Exception:toString	()Ljava/lang/String;
    //   72: invokestatic 148	com/tencent/superplayer/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_3
    //   76: astore_2
    //   77: aload_1
    //   78: ifnull -33 -> 45
    //   81: aload_1
    //   82: invokeinterface 141 1 0
    //   87: aconst_null
    //   88: areturn
    //   89: astore_0
    //   90: getstatic 16	com/tencent/superplayer/utils/Utils:TAG	Ljava/lang/String;
    //   93: aload_0
    //   94: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   97: invokestatic 148	com/tencent/superplayer/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +9 -> 115
    //   109: aload_0
    //   110: invokeinterface 141 1 0
    //   115: aload_1
    //   116: athrow
    //   117: astore_0
    //   118: getstatic 16	com/tencent/superplayer/utils/Utils:TAG	Ljava/lang/String;
    //   121: aload_0
    //   122: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   125: invokestatic 148	com/tencent/superplayer/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: goto -13 -> 115
    //   131: astore_1
    //   132: goto -27 -> 105
    //   135: astore_2
    //   136: goto -73 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramArrayOfByte	byte[]
    //   19	19	1	localObjectInputStream	java.io.ObjectInputStream
    //   47	5	1	localIOException	java.io.IOException
    //   62	20	1	localObject1	Object
    //   102	14	1	localObject2	Object
    //   131	1	1	localObject3	Object
    //   28	18	2	localObject4	Object
    //   60	9	2	localException1	Exception
    //   76	1	2	localObject5	Object
    //   135	1	2	localException2	Exception
    //   1	75	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   37	43	47	java/io/IOException
    //   11	20	60	java/lang/Exception
    //   81	87	89	java/io/IOException
    //   11	20	102	finally
    //   109	115	117	java/io/IOException
    //   22	29	131	finally
    //   65	75	131	finally
    //   22	29	135	java/lang/Exception
  }
  
  public static byte[] convertObjectToBytes(Serializable paramSerializable)
  {
    byte[] arrayOfByte = new byte[0];
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramSerializable);
      localObjectOutputStream.flush();
      paramSerializable = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        return paramSerializable;
      }
      catch (Exception localException1)
      {
        LogUtil.e(TAG, localException1.toString());
        return paramSerializable;
      }
      try
      {
        localByteArrayOutputStream.close();
        throw paramSerializable;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          LogUtil.e(TAG, localException2.toString());
        }
      }
    }
    catch (Exception paramSerializable)
    {
      paramSerializable = paramSerializable;
      LogUtil.e(TAG, paramSerializable.toString());
      try
      {
        localByteArrayOutputStream.close();
        return localException1;
      }
      catch (Exception paramSerializable)
      {
        LogUtil.e(TAG, paramSerializable.toString());
        return localException1;
      }
    }
    finally {}
  }
  
  public static int convertPlayerMsg(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    default: 
      return 0;
    case 101: 
      return 100;
    case 102: 
      return 106;
    case 103: 
      return 102;
    case 104: 
      return 103;
    case 105: 
      return 104;
    case 106: 
      return 105;
    case 107: 
      return 106;
    case 150: 
      return 107;
    case 151: 
      return 108;
    case 152: 
      return 109;
    case 154: 
      return 110;
    case 200: 
      return 112;
    case 201: 
      return 113;
    case 203: 
      return 114;
    case 204: 
      return 115;
    case 205: 
      return 116;
    case 206: 
      return 117;
    case 207: 
      return 118;
    case 208: 
      return 119;
    case 501: 
      return 123;
    case 500: 
      return 122;
    case 1000: 
      return 124;
    case 1001: 
      return 201;
    case 1003: 
      return 204;
    case 1004: 
      return 206;
    case 1005: 
      return 205;
    case 1006: 
      return 207;
    }
    return 208;
  }
  
  public static int getDownloadProxyServiceType(int paramInt)
  {
    if (SuperPlayerSDKMgr.getPlatform() <= 0) {
      return 0;
    }
    String str2 = String.valueOf(SuperPlayerSDKMgr.getPlatform());
    String str1 = str2;
    if (paramInt >= 0) {
      str1 = str2 + String.valueOf(paramInt);
    }
    return Integer.valueOf(str1).intValue();
  }
  
  public static boolean initDataTransportDataFolder(int paramInt)
  {
    if (TextUtils.isEmpty(SuperPlayerSDKMgr.getDataCacheFolder())) {
      return false;
    }
    String str = SuperPlayerSDKMgr.getDataCacheFolder() + File.separator + paramInt;
    try
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        localFile.mkdirs();
        LogUtil.d(TAG, "业务缓存目录创建成功，path = " + str);
      }
      for (;;)
      {
        TPPlayerMgr.setProxyConfigsWithServiceType(paramInt, str, str, null);
        return true;
        LogUtil.d(TAG, "业务缓存目录已存在，path = " + str);
      }
      return false;
    }
    catch (Exception localException)
    {
      LogUtil.d(TAG, "业务缓存目录创建失败，path = " + str + ", error = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.Utils
 * JD-Core Version:    0.7.0.1
 */