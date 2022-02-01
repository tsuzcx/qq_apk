package com.tencent.mobileqq.config.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigListener;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import oicq.wlogin_sdk.tools.MD5;

public class PicAndAdConf
  extends BaseConf
  implements ImgConfHandler
{
  public boolean g = true;
  private HashSet<String> h;
  private HashMap<String, Long> i = new HashMap(8);
  
  public PicAndAdConf(short paramShort, byte paramByte)
  {
    super(paramShort, paramByte);
  }
  
  private void a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isFile())
      {
        paramFile.delete();
      }
      else if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile == null) {
          return;
        }
        int j = 0;
        while (j < arrayOfFile.length)
        {
          a(arrayOfFile[j]);
          j += 1;
        }
      }
      paramFile.delete();
    }
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 32	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 36	java/io/File:exists	()Z
    //   13: ifne +11 -> 24
    //   16: aload_2
    //   17: invokevirtual 60	java/io/File:createNewFile	()Z
    //   20: pop
    //   21: goto +13 -> 34
    //   24: aload_2
    //   25: invokevirtual 42	java/io/File:delete	()Z
    //   28: pop
    //   29: aload_2
    //   30: invokevirtual 60	java/io/File:createNewFile	()Z
    //   33: pop
    //   34: new 62	java/io/FileOutputStream
    //   37: dup
    //   38: aload_2
    //   39: iconst_1
    //   40: invokespecial 65	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_1
    //   46: invokevirtual 69	java/io/FileOutputStream:write	([B)V
    //   49: aload_2
    //   50: invokevirtual 73	java/io/FileOutputStream:flush	()V
    //   53: aload_2
    //   54: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   57: invokestatic 82	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   60: ldc 84
    //   62: iconst_0
    //   63: invokevirtual 88	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   66: invokeinterface 94 1 0
    //   71: astore_1
    //   72: aload_1
    //   73: ldc 96
    //   75: lload_3
    //   76: invokeinterface 102 4 0
    //   81: pop
    //   82: aload_1
    //   83: invokeinterface 105 1 0
    //   88: pop
    //   89: aload_2
    //   90: astore_1
    //   91: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +13 -> 107
    //   97: ldc 112
    //   99: iconst_2
    //   100: ldc 114
    //   102: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_2
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   111: return
    //   112: astore_1
    //   113: goto +9 -> 122
    //   116: goto +18 -> 134
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   130: aload_1
    //   131: athrow
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: ifnull +8 -> 143
    //   138: aload_2
    //   139: astore_1
    //   140: goto -33 -> 107
    //   143: return
    //   144: astore_1
    //   145: goto -13 -> 132
    //   148: astore_1
    //   149: goto -33 -> 116
    //   152: astore_1
    //   153: return
    //   154: astore_2
    //   155: goto -25 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	PicAndAdConf
    //   0	158	1	paramArrayOfByte	byte[]
    //   0	158	2	paramString	String
    //   0	158	3	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   44	89	112	finally
    //   91	105	112	finally
    //   9	21	119	finally
    //   24	34	119	finally
    //   34	44	119	finally
    //   9	21	144	java/lang/Exception
    //   24	34	144	java/lang/Exception
    //   34	44	144	java/lang/Exception
    //   44	89	148	java/lang/Exception
    //   91	105	148	java/lang/Exception
    //   107	111	152	java/lang/Exception
    //   126	130	154	java/lang/Exception
  }
  
  /* Error */
  private boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: new 123	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: invokestatic 82	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: invokevirtual 129	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: ldc 139
    //   25: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: new 32	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore 5
    //   42: new 123	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: invokestatic 82	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   54: invokevirtual 129	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   57: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: ldc 144
    //   67: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_3
    //   72: aload_2
    //   73: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: new 32	java/io/File
    //   80: dup
    //   81: aload_3
    //   82: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore_2
    //   89: aconst_null
    //   90: astore 4
    //   92: aconst_null
    //   93: astore_3
    //   94: aload 5
    //   96: invokevirtual 36	java/io/File:exists	()Z
    //   99: ifne +9 -> 108
    //   102: aload 5
    //   104: invokevirtual 147	java/io/File:mkdirs	()Z
    //   107: pop
    //   108: aload_2
    //   109: invokevirtual 36	java/io/File:exists	()Z
    //   112: ifne +11 -> 123
    //   115: aload_2
    //   116: invokevirtual 60	java/io/File:createNewFile	()Z
    //   119: pop
    //   120: goto +13 -> 133
    //   123: aload_2
    //   124: invokevirtual 42	java/io/File:delete	()Z
    //   127: pop
    //   128: aload_2
    //   129: invokevirtual 60	java/io/File:createNewFile	()Z
    //   132: pop
    //   133: new 62	java/io/FileOutputStream
    //   136: dup
    //   137: aload_2
    //   138: iconst_1
    //   139: invokespecial 65	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   142: astore_2
    //   143: aload_2
    //   144: aload_1
    //   145: invokevirtual 69	java/io/FileOutputStream:write	([B)V
    //   148: aload_2
    //   149: invokevirtual 73	java/io/FileOutputStream:flush	()V
    //   152: aload_2
    //   153: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_1
    //   159: goto +9 -> 168
    //   162: goto +24 -> 186
    //   165: astore_1
    //   166: aload_3
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +15 -> 184
    //   172: aload_2
    //   173: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   176: goto +8 -> 184
    //   179: astore_2
    //   180: aload_2
    //   181: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   184: aload_1
    //   185: athrow
    //   186: aload_2
    //   187: ifnull +14 -> 201
    //   190: aload_2
    //   191: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_1
    //   204: aload 4
    //   206: astore_2
    //   207: goto -21 -> 186
    //   210: astore_1
    //   211: goto -49 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	PicAndAdConf
    //   0	214	1	paramArrayOfByte	byte[]
    //   0	214	2	paramString	String
    //   7	160	3	localStringBuilder	StringBuilder
    //   90	115	4	localObject	Object
    //   40	63	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   143	156	158	finally
    //   94	108	165	finally
    //   108	120	165	finally
    //   123	133	165	finally
    //   133	143	165	finally
    //   172	176	179	java/io/IOException
    //   190	194	196	java/io/IOException
    //   94	108	203	java/lang/Exception
    //   108	120	203	java/lang/Exception
    //   123	133	203	java/lang/Exception
    //   133	143	203	java/lang/Exception
    //   143	156	210	java/lang/Exception
  }
  
  /* Error */
  private boolean b(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: new 123	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: invokestatic 82	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: invokevirtual 129	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: ldc 153
    //   25: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_3
    //   30: ldc 155
    //   32: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: new 32	java/io/File
    //   39: dup
    //   40: aload_3
    //   41: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 5
    //   49: new 123	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   56: astore_3
    //   57: aload_3
    //   58: invokestatic 82	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   61: invokevirtual 129	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   64: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   67: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_3
    //   72: ldc 153
    //   74: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: ldc 155
    //   81: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_3
    //   86: ldc 153
    //   88: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: aload_2
    //   94: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: new 32	java/io/File
    //   101: dup
    //   102: aload_3
    //   103: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore 6
    //   111: aconst_null
    //   112: astore 4
    //   114: aconst_null
    //   115: astore_3
    //   116: aload_3
    //   117: astore_2
    //   118: aload 5
    //   120: invokevirtual 36	java/io/File:exists	()Z
    //   123: ifne +11 -> 134
    //   126: aload_3
    //   127: astore_2
    //   128: aload 5
    //   130: invokevirtual 147	java/io/File:mkdirs	()Z
    //   133: pop
    //   134: aload_3
    //   135: astore_2
    //   136: aload 6
    //   138: invokevirtual 36	java/io/File:exists	()Z
    //   141: ifne +14 -> 155
    //   144: aload_3
    //   145: astore_2
    //   146: aload 6
    //   148: invokevirtual 60	java/io/File:createNewFile	()Z
    //   151: pop
    //   152: goto +19 -> 171
    //   155: aload_3
    //   156: astore_2
    //   157: aload 6
    //   159: invokevirtual 42	java/io/File:delete	()Z
    //   162: pop
    //   163: aload_3
    //   164: astore_2
    //   165: aload 6
    //   167: invokevirtual 60	java/io/File:createNewFile	()Z
    //   170: pop
    //   171: aload_3
    //   172: astore_2
    //   173: new 62	java/io/FileOutputStream
    //   176: dup
    //   177: aload 6
    //   179: iconst_1
    //   180: invokespecial 65	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   183: astore_3
    //   184: aload_3
    //   185: aload_1
    //   186: invokevirtual 69	java/io/FileOutputStream:write	([B)V
    //   189: aload_3
    //   190: invokevirtual 73	java/io/FileOutputStream:flush	()V
    //   193: aload_3
    //   194: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   197: iconst_1
    //   198: ireturn
    //   199: astore_1
    //   200: aload_3
    //   201: astore_2
    //   202: goto +55 -> 257
    //   205: astore_2
    //   206: aload_3
    //   207: astore_1
    //   208: aload_2
    //   209: astore_3
    //   210: goto +11 -> 221
    //   213: astore_1
    //   214: goto +43 -> 257
    //   217: astore_3
    //   218: aload 4
    //   220: astore_1
    //   221: aload_1
    //   222: astore_2
    //   223: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +14 -> 240
    //   229: aload_1
    //   230: astore_2
    //   231: ldc 157
    //   233: iconst_2
    //   234: ldc 159
    //   236: aload_3
    //   237: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   240: aload_1
    //   241: ifnull +14 -> 255
    //   244: aload_1
    //   245: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   248: iconst_0
    //   249: ireturn
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   255: iconst_0
    //   256: ireturn
    //   257: aload_2
    //   258: ifnull +15 -> 273
    //   261: aload_2
    //   262: invokevirtual 76	java/io/FileOutputStream:close	()V
    //   265: goto +8 -> 273
    //   268: astore_2
    //   269: aload_2
    //   270: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   273: aload_1
    //   274: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	PicAndAdConf
    //   0	275	1	paramArrayOfByte	byte[]
    //   0	275	2	paramString	String
    //   7	203	3	localObject1	Object
    //   217	20	3	localException	Exception
    //   112	107	4	localObject2	Object
    //   47	82	5	localFile1	File
    //   109	69	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   184	197	199	finally
    //   184	197	205	java/lang/Exception
    //   118	126	213	finally
    //   128	134	213	finally
    //   136	144	213	finally
    //   146	152	213	finally
    //   157	163	213	finally
    //   165	171	213	finally
    //   173	184	213	finally
    //   223	229	213	finally
    //   231	240	213	finally
    //   118	126	217	java/lang/Exception
    //   128	134	217	java/lang/Exception
    //   136	144	217	java/lang/Exception
    //   146	152	217	java/lang/Exception
    //   157	163	217	java/lang/Exception
    //   165	171	217	java/lang/Exception
    //   173	184	217	java/lang/Exception
    //   244	248	250	java/io/IOException
    //   261	265	268	java/io/IOException
  }
  
  public PicAndAdConf.PicStruct a(long paramLong, String paramString1, byte paramByte, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort, String paramString6)
  {
    PicAndAdConf.PicStruct localPicStruct = new PicAndAdConf.PicStruct(this);
    localPicStruct.a = paramLong;
    localPicStruct.b = paramString1;
    localPicStruct.c = paramString2;
    localPicStruct.f = paramString3;
    localPicStruct.g = paramByte;
    localPicStruct.d = paramString4;
    localPicStruct.h = paramString5;
    localPicStruct.i = paramShort;
    localPicStruct.j = paramString6;
    localPicStruct.k = 0;
    return localPicStruct;
  }
  
  public PicAndAdConf.PicStruct a(long paramLong, String paramString1, byte paramByte, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    PicAndAdConf.PicStruct localPicStruct = new PicAndAdConf.PicStruct(this);
    localPicStruct.a = paramLong;
    localPicStruct.b = paramString1;
    localPicStruct.c = paramString2;
    localPicStruct.e = paramArrayOfByte;
    localPicStruct.f = paramString3;
    localPicStruct.g = paramByte;
    localPicStruct.k = 0;
    return localPicStruct;
  }
  
  public PicAndAdConf.PicStruct a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort)
  {
    return a(paramLong, paramString1, (byte)3, paramString2, paramString3, paramString4, paramString5, paramShort, "");
  }
  
  public PicAndAdConf.PicStruct a(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    return a(paramLong, paramString1, (byte)3, paramString2, paramArrayOfByte, paramString3);
  }
  
  public String a(String paramString, byte paramByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject;
    if (paramByte != 1)
    {
      localObject = paramString;
      if (paramByte != 2) {
        if (paramByte != 3)
        {
          localObject = paramString;
        }
        else if ((paramString.startsWith("http://")) && (!paramString.endsWith(".png")))
        {
          if (this.e == 6)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("_");
            ((StringBuilder)localObject).append(Config.b);
            ((StringBuilder)localObject).append("_");
            ((StringBuilder)localObject).append(Config.a);
            ((StringBuilder)localObject).append(".png");
            localObject = ((StringBuilder)localObject).toString();
          }
          else if (this.e == 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("_");
            ((StringBuilder)localObject).append(Config.a - 2);
            ((StringBuilder)localObject).append(".png");
            localObject = ((StringBuilder)localObject).toString();
          }
          else if ((this.e == 1) && (paramString.contains("[]")))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(DeviceInfoUtil.B());
            ((StringBuilder)localObject).append("x");
            ((StringBuilder)localObject).append(DeviceInfoUtil.C());
            localObject = paramString.replace("[]", ((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("_");
            ((StringBuilder)localObject).append(Config.a);
            ((StringBuilder)localObject).append(".png");
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        else
        {
          localObject = paramString;
          if (paramString.startsWith("http://"))
          {
            localObject = paramString;
            if (this.e == 1)
            {
              localObject = paramString;
              if (paramString.contains("[]"))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(DeviceInfoUtil.B());
                ((StringBuilder)localObject).append("x");
                ((StringBuilder)localObject).append(DeviceInfoUtil.C());
                localObject = paramString.replace("[]", ((StringBuilder)localObject).toString());
              }
            }
          }
        }
      }
    }
    else
    {
      localObject = paramString;
      if (!paramString.startsWith("/"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("flashlogo final request url = ");
      paramString.append((String)localObject);
      QLog.d("ShanPing", 2, paramString.toString());
    }
    return localObject;
  }
  
  public short a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.f.size())) {
      return ((PicAndAdConf.PicStruct)this.f.get(paramInt)).i;
    }
    return -1;
  }
  
  public void a()
  {
    a(true);
    long l = this.d;
    this.c = -1L;
    this.d = -1L;
    this.f.clear();
    int j = this.e;
    Object localObject;
    if (j != 0)
    {
      if (j != 1)
      {
        if ((j == 2) || (j == 6)) {
          break label131;
        }
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("flashlogo.png");
      localObject = new File(((StringBuilder)localObject).toString());
    }
    try
    {
      if (((File)localObject).exists())
      {
        ((File)localObject).delete();
        return;
        f();
      }
      label131:
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(DataInputStream paramDataInputStream)
  {
    this.a = paramDataInputStream.readShort();
    this.b = paramDataInputStream.readLong();
    this.c = paramDataInputStream.readLong();
    this.d = paramDataInputStream.readLong();
    this.e = paramDataInputStream.readByte();
    int k = paramDataInputStream.readInt();
    if (k > 0)
    {
      int j = 0;
      while (j < k)
      {
        PicAndAdConf.PicStruct localPicStruct = new PicAndAdConf.PicStruct(this);
        if (this.e == 2) {
          localPicStruct.b(paramDataInputStream);
        } else {
          localPicStruct.a(paramDataInputStream);
        }
        a(localPicStruct);
        j += 1;
      }
    }
  }
  
  public void a(DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.writeShort(this.a);
    paramDataOutputStream.writeLong(this.b);
    paramDataOutputStream.writeLong(this.c);
    paramDataOutputStream.writeLong(this.d);
    paramDataOutputStream.writeByte(this.e);
    Object localObject = this.f;
    int j = 0;
    int k;
    if ((localObject != null) && (this.f.size() != 0))
    {
      k = this.f.size();
      paramDataOutputStream.writeInt(k);
    }
    while (j < k)
    {
      localObject = (PicAndAdConf.PicStruct)this.f.get(j);
      if (this.e == 2) {
        ((PicAndAdConf.PicStruct)localObject).b(paramDataOutputStream);
      } else {
        ((PicAndAdConf.PicStruct)localObject).a(paramDataOutputStream);
      }
      j += 1;
      continue;
      paramDataOutputStream.writeInt(0);
    }
  }
  
  public void a(String paramString, byte[] arg2)
  {
    if ((??? != null) && (???.length > 0) && (paramString != null) && (paramString.length() > 0))
    {
      ArrayList localArrayList = Config.d();
      int j = 0;
      while (j < this.f.size())
      {
        PicAndAdConf.PicStruct localPicStruct = (PicAndAdConf.PicStruct)this.f.get(j);
        if (paramString.startsWith(localPicStruct.c))
        {
          if (this.e == 1)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
            localStringBuilder.append("/");
            localStringBuilder.append("flashlogo.png");
            localPicStruct.d = localStringBuilder.toString();
            a(???, localPicStruct.d, this.c);
            if (localArrayList == null) {
              break;
            }
            ??? = localArrayList.iterator();
            while (???.hasNext()) {
              ((ConfigListener)???.next()).a(true, this.a, j, paramString);
            }
          }
          if (this.e == 0)
          {
            a(???, String.valueOf(localPicStruct.j));
            try
            {
              ??? = new File(localPicStruct.d);
              if (!MD5.getFileMD5(???).equalsIgnoreCase(localPicStruct.j))
              {
                ???.delete();
                if (localPicStruct.k < 1)
                {
                  localPicStruct.k += 1;
                  b(localPicStruct.c);
                }
              }
            }
            catch (Exception ???)
            {
              ???.printStackTrace();
            }
            if (localArrayList == null) {
              break;
            }
            ??? = localArrayList.iterator();
            while (???.hasNext()) {
              ((ConfigListener)???.next()).a(true, this.a, j, paramString);
            }
          }
          if (this.e != 2) {
            break;
          }
          b(???, String.valueOf(localPicStruct.j));
          try
          {
            ??? = new File(localPicStruct.d);
            paramString = MD5.getFileMD5(???);
            if (!paramString.equalsIgnoreCase(localPicStruct.j))
            {
              ???.delete();
              if (localPicStruct.k < 1)
              {
                localPicStruct.k += 1;
                b(localPicStruct.c);
              }
              else
              {
                synchronized (this.i)
                {
                  this.i.put(localPicStruct.c, Long.valueOf(System.currentTimeMillis()));
                }
              }
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            ??? = new StringBuilder();
            ???.append("handle download NearbyBanner image, cid = ");
            ???.append(localPicStruct.a);
            ???.append(", md5 is ");
            ???.append(paramString.equalsIgnoreCase(localPicStruct.j));
            QLog.d("PicAndAdConf", 2, ???.toString());
            return;
          }
          catch (Exception paramString)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          ??? = new StringBuilder();
          ???.append("handleImgData exception, item md5 = ");
          ???.append(localPicStruct.j);
          QLog.d("PicAndAdConf", 2, ???.toString(), paramString);
          return;
        }
        j += 1;
      }
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.i)
      {
        this.i.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
    }
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.f.size())) {
      return ((PicAndAdConf.PicStruct)this.f.get(paramInt)).h;
    }
    return "";
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("http://")) {
        return;
      }
      if (this.e == 2) {
        synchronized (this.i)
        {
          if ((this.i.containsKey(paramString)) && (Math.abs(System.currentTimeMillis() - ((Long)this.i.get(paramString)).longValue()) < 36000L))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("sendImgRequest | retry interval is too small, ");
              localStringBuilder.append(paramString);
              QLog.d("PicAndAdConf", 2, localStringBuilder.toString());
            }
            return;
          }
        }
      }
      if (this.h == null) {
        this.h = new HashSet();
      }
      this.h.add(paramString);
      ??? = Config.b();
      if (??? != null) {
        ((HttpCommunicator)???).sendMsg(new HttpMsg(paramString, null, this, true));
      }
    }
  }
  
  public String c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.f.size())) {
      return ((PicAndAdConf.PicStruct)this.f.get(paramInt)).j;
    }
    return "";
  }
  
  /* Error */
  public android.graphics.Bitmap d(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 6
    //   11: astore 5
    //   13: iload_1
    //   14: iflt +472 -> 486
    //   17: iload_1
    //   18: aload_0
    //   19: getfield 269	com/tencent/mobileqq/config/struct/PicAndAdConf:f	Ljava/util/ArrayList;
    //   22: invokevirtual 275	java/util/ArrayList:size	()I
    //   25: if_icmplt +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: aload 8
    //   32: astore 4
    //   34: aload_0
    //   35: getfield 269	com/tencent/mobileqq/config/struct/PicAndAdConf:f	Ljava/util/ArrayList;
    //   38: iload_1
    //   39: invokevirtual 279	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   42: checkcast 165	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct
    //   45: astore 9
    //   47: aload 8
    //   49: astore 4
    //   51: aload 9
    //   53: getfield 183	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:g	B
    //   56: istore_2
    //   57: iload_2
    //   58: iconst_1
    //   59: if_icmpeq +382 -> 441
    //   62: aload 6
    //   64: astore 5
    //   66: iload_2
    //   67: iconst_2
    //   68: if_icmpeq +418 -> 486
    //   71: iload_2
    //   72: iconst_3
    //   73: if_icmpeq +5 -> 78
    //   76: aconst_null
    //   77: areturn
    //   78: aload 8
    //   80: astore 4
    //   82: aload_0
    //   83: getfield 269	com/tencent/mobileqq/config/struct/PicAndAdConf:f	Ljava/util/ArrayList;
    //   86: iload_1
    //   87: invokevirtual 279	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   90: checkcast 165	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct
    //   93: getfield 202	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:e	[B
    //   96: astore 10
    //   98: aload 8
    //   100: astore 4
    //   102: aload_0
    //   103: getfield 269	com/tencent/mobileqq/config/struct/PicAndAdConf:f	Ljava/util/ArrayList;
    //   106: iload_1
    //   107: invokevirtual 279	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   110: checkcast 165	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct
    //   113: getfield 185	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:d	Ljava/lang/String;
    //   116: astore 5
    //   118: aload 5
    //   120: ifnull +47 -> 167
    //   123: aload 8
    //   125: astore 4
    //   127: aload_0
    //   128: getfield 230	com/tencent/mobileqq/config/struct/PicAndAdConf:e	B
    //   131: iconst_1
    //   132: if_icmpne +35 -> 167
    //   135: aload 8
    //   137: astore 4
    //   139: aload_0
    //   140: invokevirtual 463	com/tencent/mobileqq/config/struct/PicAndAdConf:c	()Z
    //   143: ifne +24 -> 167
    //   146: aload 8
    //   148: astore 4
    //   150: aload_0
    //   151: invokevirtual 465	com/tencent/mobileqq/config/struct/PicAndAdConf:d	()Z
    //   154: ifne +13 -> 167
    //   157: aload 8
    //   159: astore 4
    //   161: aload 5
    //   163: invokestatic 470	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   166: areturn
    //   167: aload 5
    //   169: ifnull +110 -> 279
    //   172: aload 8
    //   174: astore 4
    //   176: aload_0
    //   177: getfield 230	com/tencent/mobileqq/config/struct/PicAndAdConf:e	B
    //   180: ifne +99 -> 279
    //   183: aload 8
    //   185: astore 4
    //   187: new 32	java/io/File
    //   190: dup
    //   191: aload 5
    //   193: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   196: invokevirtual 36	java/io/File:exists	()Z
    //   199: ifeq +65 -> 264
    //   202: aload 8
    //   204: astore 4
    //   206: aload 5
    //   208: invokestatic 470	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   211: astore 6
    //   213: aload 6
    //   215: astore 5
    //   217: aload 6
    //   219: ifnonnull +267 -> 486
    //   222: aload 6
    //   224: astore 4
    //   226: aload 6
    //   228: astore 5
    //   230: aload 9
    //   232: getfield 473	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:l	Z
    //   235: ifeq +251 -> 486
    //   238: aload 6
    //   240: astore 4
    //   242: aload 9
    //   244: iconst_0
    //   245: putfield 473	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:l	Z
    //   248: aload 6
    //   250: astore 4
    //   252: aload_0
    //   253: aload 9
    //   255: getfield 177	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:c	Ljava/lang/String;
    //   258: invokevirtual 387	com/tencent/mobileqq/config/struct/PicAndAdConf:b	(Ljava/lang/String;)V
    //   261: aload 6
    //   263: areturn
    //   264: aload 8
    //   266: astore 4
    //   268: aload_0
    //   269: aload 9
    //   271: getfield 177	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:c	Ljava/lang/String;
    //   274: invokevirtual 387	com/tencent/mobileqq/config/struct/PicAndAdConf:b	(Ljava/lang/String;)V
    //   277: aconst_null
    //   278: areturn
    //   279: aload 8
    //   281: astore 4
    //   283: aload 5
    //   285: invokestatic 215	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifne +114 -> 402
    //   291: aload 8
    //   293: astore 4
    //   295: aload_0
    //   296: getfield 230	com/tencent/mobileqq/config/struct/PicAndAdConf:e	B
    //   299: iconst_2
    //   300: if_icmpne +102 -> 402
    //   303: aload 8
    //   305: astore 4
    //   307: new 32	java/io/File
    //   310: dup
    //   311: aload 5
    //   313: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   316: invokevirtual 36	java/io/File:exists	()Z
    //   319: istore_3
    //   320: aload 7
    //   322: astore 6
    //   324: iload_3
    //   325: ifeq +52 -> 377
    //   328: aload 8
    //   330: astore 4
    //   332: aload 5
    //   334: invokestatic 470	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   337: astore 6
    //   339: goto +38 -> 377
    //   342: astore 5
    //   344: aload 7
    //   346: astore 6
    //   348: aload 8
    //   350: astore 4
    //   352: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +22 -> 377
    //   358: aload 8
    //   360: astore 4
    //   362: ldc 157
    //   364: iconst_2
    //   365: ldc_w 475
    //   368: aload 5
    //   370: invokestatic 162	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   373: aload 7
    //   375: astore 6
    //   377: aload 6
    //   379: astore 5
    //   381: aload 6
    //   383: ifnonnull +103 -> 486
    //   386: aload 6
    //   388: astore 4
    //   390: aload_0
    //   391: aload 9
    //   393: getfield 177	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:c	Ljava/lang/String;
    //   396: invokevirtual 387	com/tencent/mobileqq/config/struct/PicAndAdConf:b	(Ljava/lang/String;)V
    //   399: aload 6
    //   401: areturn
    //   402: aload 6
    //   404: astore 5
    //   406: aload 10
    //   408: ifnull +78 -> 486
    //   411: aload 8
    //   413: astore 4
    //   415: aload 10
    //   417: arraylength
    //   418: istore_1
    //   419: aload 6
    //   421: astore 5
    //   423: iload_1
    //   424: ifle +62 -> 486
    //   427: aload 10
    //   429: iconst_0
    //   430: aload 10
    //   432: arraylength
    //   433: invokestatic 481	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   436: astore 4
    //   438: aload 4
    //   440: areturn
    //   441: aload 8
    //   443: astore 4
    //   445: aload 9
    //   447: getfield 177	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:c	Ljava/lang/String;
    //   450: invokestatic 470	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   453: astore 5
    //   455: aload 5
    //   457: areturn
    //   458: astore 6
    //   460: aload 4
    //   462: astore 5
    //   464: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq +19 -> 486
    //   470: ldc_w 483
    //   473: iconst_2
    //   474: aload 6
    //   476: invokestatic 487	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   479: invokestatic 489	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: aload 4
    //   484: astore 5
    //   486: aload 5
    //   488: areturn
    //   489: astore 4
    //   491: aload 7
    //   493: astore 6
    //   495: goto -118 -> 377
    //   498: astore 4
    //   500: aconst_null
    //   501: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	502	0	this	PicAndAdConf
    //   0	502	1	paramInt	int
    //   56	18	2	j	int
    //   319	6	3	bool	boolean
    //   32	451	4	localObject1	Object
    //   489	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   498	1	4	localThrowable1	java.lang.Throwable
    //   11	322	5	localObject2	Object
    //   342	27	5	localException	Exception
    //   379	108	5	localObject3	Object
    //   4	416	6	localObject4	Object
    //   458	17	6	localThrowable2	java.lang.Throwable
    //   493	1	6	localObject5	Object
    //   7	485	7	localObject6	Object
    //   1	441	8	localObject7	Object
    //   45	401	9	localPicStruct	PicAndAdConf.PicStruct
    //   96	335	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   332	339	342	java/lang/Exception
    //   34	47	458	java/lang/Throwable
    //   51	57	458	java/lang/Throwable
    //   82	98	458	java/lang/Throwable
    //   102	118	458	java/lang/Throwable
    //   127	135	458	java/lang/Throwable
    //   139	146	458	java/lang/Throwable
    //   150	157	458	java/lang/Throwable
    //   161	167	458	java/lang/Throwable
    //   176	183	458	java/lang/Throwable
    //   187	202	458	java/lang/Throwable
    //   206	213	458	java/lang/Throwable
    //   230	238	458	java/lang/Throwable
    //   242	248	458	java/lang/Throwable
    //   252	261	458	java/lang/Throwable
    //   268	277	458	java/lang/Throwable
    //   283	291	458	java/lang/Throwable
    //   295	303	458	java/lang/Throwable
    //   307	320	458	java/lang/Throwable
    //   332	339	458	java/lang/Throwable
    //   352	358	458	java/lang/Throwable
    //   362	373	458	java/lang/Throwable
    //   390	399	458	java/lang/Throwable
    //   415	419	458	java/lang/Throwable
    //   445	455	458	java/lang/Throwable
    //   332	339	489	java/lang/OutOfMemoryError
    //   427	438	498	java/lang/Throwable
    //   445	455	498	java/lang/Exception
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 != null)
    {
      if (paramHttpMsg2 == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShanPing", 2, "flashlogo request huibao decode ");
      }
      a(paramHttpMsg1.getUrl(), paramHttpMsg2.getRecvData());
    }
  }
  
  public String e(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.f.size())) {
      return ((PicAndAdConf.PicStruct)this.f.get(paramInt)).f;
    }
    return "";
  }
  
  public long f(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.f.size())) {
      return ((PicAndAdConf.PicStruct)this.f.get(paramInt)).a;
    }
    return 0L;
  }
  
  public void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append("/ADPic");
    localObject = new File(((StringBuilder)localObject).toString());
    try
    {
      a((File)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void g()
  {
    if (this.e == 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownload NearbyBanner image");
      int j = 0;
      while (j < this.f.size())
      {
        PicAndAdConf.PicStruct localPicStruct = (PicAndAdConf.PicStruct)this.f.get(j);
        if (localPicStruct.d != null)
        {
          File localFile = new File(localPicStruct.d);
          if ((!localFile.exists()) || (!localFile.canRead()))
          {
            localStringBuilder.append(" | ");
            localStringBuilder.append(localPicStruct.a);
            ThreadManager.post(new PicAndAdConf.1(this, localPicStruct), 5, null, false);
          }
        }
        j += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicAndAdConf", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    int j = 0;
    while (j < this.f.size())
    {
      paramHttpMsg2 = (PicAndAdConf.PicStruct)this.f.get(j);
      if (paramHttpMsg1.getUrl().startsWith(paramHttpMsg2.c))
      {
        paramHttpMsg2 = Config.d();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2 = paramHttpMsg2.iterator();
        while (paramHttpMsg2.hasNext()) {
          ((ConfigListener)paramHttpMsg2.next()).a(false, this.a, j, paramHttpMsg1.getUrl());
        }
      }
      j += 1;
    }
  }
  
  public void handleRedirect(String paramString) {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (paramInt == 3)
    {
      paramHttpMsg2 = paramHttpMsg2.getResponseProperty("Content-Type");
      paramHttpMsg1 = null;
      if (paramHttpMsg2 != null) {
        paramHttpMsg1 = paramHttpMsg2.toLowerCase();
      }
      if ((paramHttpMsg1 != null) && (paramHttpMsg1.indexOf("image") != -1)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.PicAndAdConf
 * JD-Core Version:    0.7.0.1
 */