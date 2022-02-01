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
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  public boolean a;
  
  public PicAndAdConf(short paramShort, byte paramByte)
  {
    super(paramShort, paramByte);
    this.jdField_a_of_type_Boolean = true;
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
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          i += 1;
        }
      }
      paramFile.delete();
    }
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 29	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 33	java/io/File:exists	()Z
    //   13: ifne +11 -> 24
    //   16: aload_2
    //   17: invokevirtual 57	java/io/File:createNewFile	()Z
    //   20: pop
    //   21: goto +13 -> 34
    //   24: aload_2
    //   25: invokevirtual 39	java/io/File:delete	()Z
    //   28: pop
    //   29: aload_2
    //   30: invokevirtual 57	java/io/File:createNewFile	()Z
    //   33: pop
    //   34: new 59	java/io/FileOutputStream
    //   37: dup
    //   38: aload_2
    //   39: iconst_1
    //   40: invokespecial 62	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_1
    //   46: invokevirtual 66	java/io/FileOutputStream:write	([B)V
    //   49: aload_2
    //   50: invokevirtual 70	java/io/FileOutputStream:flush	()V
    //   53: aload_2
    //   54: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   57: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   60: ldc 81
    //   62: iconst_0
    //   63: invokevirtual 85	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   66: invokeinterface 91 1 0
    //   71: astore_1
    //   72: aload_1
    //   73: ldc 93
    //   75: lload_3
    //   76: invokeinterface 99 4 0
    //   81: pop
    //   82: aload_1
    //   83: invokeinterface 102 1 0
    //   88: pop
    //   89: aload_2
    //   90: astore_1
    //   91: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +13 -> 107
    //   97: ldc 109
    //   99: iconst_2
    //   100: ldc 111
    //   102: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_2
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 73	java/io/FileOutputStream:close	()V
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
    //   127: invokevirtual 73	java/io/FileOutputStream:close	()V
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
    //   0: new 120	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: invokevirtual 126	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: ldc 136
    //   25: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: new 29	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore 5
    //   42: new 120	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   54: invokevirtual 126	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   57: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: ldc 141
    //   67: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_3
    //   72: aload_2
    //   73: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: new 29	java/io/File
    //   80: dup
    //   81: aload_3
    //   82: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore_2
    //   89: aconst_null
    //   90: astore 4
    //   92: aconst_null
    //   93: astore_3
    //   94: aload 5
    //   96: invokevirtual 33	java/io/File:exists	()Z
    //   99: ifne +9 -> 108
    //   102: aload 5
    //   104: invokevirtual 144	java/io/File:mkdirs	()Z
    //   107: pop
    //   108: aload_2
    //   109: invokevirtual 33	java/io/File:exists	()Z
    //   112: ifne +11 -> 123
    //   115: aload_2
    //   116: invokevirtual 57	java/io/File:createNewFile	()Z
    //   119: pop
    //   120: goto +13 -> 133
    //   123: aload_2
    //   124: invokevirtual 39	java/io/File:delete	()Z
    //   127: pop
    //   128: aload_2
    //   129: invokevirtual 57	java/io/File:createNewFile	()Z
    //   132: pop
    //   133: new 59	java/io/FileOutputStream
    //   136: dup
    //   137: aload_2
    //   138: iconst_1
    //   139: invokespecial 62	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   142: astore_2
    //   143: aload_2
    //   144: aload_1
    //   145: invokevirtual 66	java/io/FileOutputStream:write	([B)V
    //   148: aload_2
    //   149: invokevirtual 70	java/io/FileOutputStream:flush	()V
    //   152: aload_2
    //   153: invokevirtual 73	java/io/FileOutputStream:close	()V
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
    //   173: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   176: goto +8 -> 184
    //   179: astore_2
    //   180: aload_2
    //   181: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   184: aload_1
    //   185: athrow
    //   186: aload_2
    //   187: ifnull +14 -> 201
    //   190: aload_2
    //   191: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 147	java/io/IOException:printStackTrace	()V
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
    //   0: new 120	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: invokevirtual 126	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: ldc 150
    //   25: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_3
    //   30: ldc 152
    //   32: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: new 29	java/io/File
    //   39: dup
    //   40: aload_3
    //   41: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 5
    //   49: new 120	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   56: astore_3
    //   57: aload_3
    //   58: invokestatic 79	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   61: invokevirtual 126	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   64: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   67: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_3
    //   72: ldc 150
    //   74: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: ldc 152
    //   81: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_3
    //   86: ldc 150
    //   88: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: aload_2
    //   94: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: new 29	java/io/File
    //   101: dup
    //   102: aload_3
    //   103: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore 6
    //   111: aconst_null
    //   112: astore 4
    //   114: aconst_null
    //   115: astore_3
    //   116: aload_3
    //   117: astore_2
    //   118: aload 5
    //   120: invokevirtual 33	java/io/File:exists	()Z
    //   123: ifne +11 -> 134
    //   126: aload_3
    //   127: astore_2
    //   128: aload 5
    //   130: invokevirtual 144	java/io/File:mkdirs	()Z
    //   133: pop
    //   134: aload_3
    //   135: astore_2
    //   136: aload 6
    //   138: invokevirtual 33	java/io/File:exists	()Z
    //   141: ifne +14 -> 155
    //   144: aload_3
    //   145: astore_2
    //   146: aload 6
    //   148: invokevirtual 57	java/io/File:createNewFile	()Z
    //   151: pop
    //   152: goto +19 -> 171
    //   155: aload_3
    //   156: astore_2
    //   157: aload 6
    //   159: invokevirtual 39	java/io/File:delete	()Z
    //   162: pop
    //   163: aload_3
    //   164: astore_2
    //   165: aload 6
    //   167: invokevirtual 57	java/io/File:createNewFile	()Z
    //   170: pop
    //   171: aload_3
    //   172: astore_2
    //   173: new 59	java/io/FileOutputStream
    //   176: dup
    //   177: aload 6
    //   179: iconst_1
    //   180: invokespecial 62	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   183: astore_3
    //   184: aload_3
    //   185: aload_1
    //   186: invokevirtual 66	java/io/FileOutputStream:write	([B)V
    //   189: aload_3
    //   190: invokevirtual 70	java/io/FileOutputStream:flush	()V
    //   193: aload_3
    //   194: invokevirtual 73	java/io/FileOutputStream:close	()V
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
    //   223: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   226: ifeq +14 -> 240
    //   229: aload_1
    //   230: astore_2
    //   231: ldc 154
    //   233: iconst_2
    //   234: ldc 156
    //   236: aload_3
    //   237: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   240: aload_1
    //   241: ifnull +14 -> 255
    //   244: aload_1
    //   245: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   248: iconst_0
    //   249: ireturn
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   255: iconst_0
    //   256: ireturn
    //   257: aload_2
    //   258: ifnull +15 -> 273
    //   261: aload_2
    //   262: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   265: goto +8 -> 273
    //   268: astore_2
    //   269: aload_2
    //   270: invokevirtual 147	java/io/IOException:printStackTrace	()V
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
  
  public long a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  /* Error */
  public android.graphics.Bitmap a(int paramInt)
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
    //   14: iflt +470 -> 484
    //   17: iload_1
    //   18: aload_0
    //   19: getfield 163	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   22: invokevirtual 169	java/util/ArrayList:size	()I
    //   25: if_icmplt +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: aload 8
    //   32: astore 4
    //   34: aload_0
    //   35: getfield 163	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   38: iload_1
    //   39: invokevirtual 173	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   42: checkcast 175	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct
    //   45: astore 9
    //   47: aload 8
    //   49: astore 4
    //   51: aload 9
    //   53: getfield 186	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:jdField_a_of_type_Byte	B
    //   56: istore_2
    //   57: iload_2
    //   58: iconst_1
    //   59: if_icmpeq +381 -> 440
    //   62: aload 6
    //   64: astore 5
    //   66: iload_2
    //   67: iconst_2
    //   68: if_icmpeq +416 -> 484
    //   71: iload_2
    //   72: iconst_3
    //   73: if_icmpeq +5 -> 78
    //   76: aconst_null
    //   77: areturn
    //   78: aload 8
    //   80: astore 4
    //   82: aload_0
    //   83: getfield 163	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   86: iload_1
    //   87: invokevirtual 173	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   90: checkcast 175	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct
    //   93: getfield 189	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:jdField_a_of_type_ArrayOfByte	[B
    //   96: astore 10
    //   98: aload 8
    //   100: astore 4
    //   102: aload_0
    //   103: getfield 163	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   106: iload_1
    //   107: invokevirtual 173	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   110: checkcast 175	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct
    //   113: getfield 193	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:c	Ljava/lang/String;
    //   116: astore 5
    //   118: aload 5
    //   120: ifnull +47 -> 167
    //   123: aload 8
    //   125: astore 4
    //   127: aload_0
    //   128: getfield 194	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_Byte	B
    //   131: iconst_1
    //   132: if_icmpne +35 -> 167
    //   135: aload 8
    //   137: astore 4
    //   139: aload_0
    //   140: invokevirtual 196	com/tencent/mobileqq/config/struct/PicAndAdConf:a	()Z
    //   143: ifne +24 -> 167
    //   146: aload 8
    //   148: astore 4
    //   150: aload_0
    //   151: invokevirtual 198	com/tencent/mobileqq/config/struct/PicAndAdConf:b	()Z
    //   154: ifne +13 -> 167
    //   157: aload 8
    //   159: astore 4
    //   161: aload 5
    //   163: invokestatic 203	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   166: areturn
    //   167: aload 5
    //   169: ifnull +110 -> 279
    //   172: aload 8
    //   174: astore 4
    //   176: aload_0
    //   177: getfield 194	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_Byte	B
    //   180: ifne +99 -> 279
    //   183: aload 8
    //   185: astore 4
    //   187: new 29	java/io/File
    //   190: dup
    //   191: aload 5
    //   193: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   196: invokevirtual 33	java/io/File:exists	()Z
    //   199: ifeq +65 -> 264
    //   202: aload 8
    //   204: astore 4
    //   206: aload 5
    //   208: invokestatic 203	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   211: astore 6
    //   213: aload 6
    //   215: astore 5
    //   217: aload 6
    //   219: ifnonnull +265 -> 484
    //   222: aload 6
    //   224: astore 4
    //   226: aload 6
    //   228: astore 5
    //   230: aload 9
    //   232: getfield 204	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:jdField_a_of_type_Boolean	Z
    //   235: ifeq +249 -> 484
    //   238: aload 6
    //   240: astore 4
    //   242: aload 9
    //   244: iconst_0
    //   245: putfield 204	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:jdField_a_of_type_Boolean	Z
    //   248: aload 6
    //   250: astore 4
    //   252: aload_0
    //   253: aload 9
    //   255: getfield 206	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:b	Ljava/lang/String;
    //   258: invokevirtual 208	com/tencent/mobileqq/config/struct/PicAndAdConf:b	(Ljava/lang/String;)V
    //   261: aload 6
    //   263: areturn
    //   264: aload 8
    //   266: astore 4
    //   268: aload_0
    //   269: aload 9
    //   271: getfield 206	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:b	Ljava/lang/String;
    //   274: invokevirtual 208	com/tencent/mobileqq/config/struct/PicAndAdConf:b	(Ljava/lang/String;)V
    //   277: aconst_null
    //   278: areturn
    //   279: aload 8
    //   281: astore 4
    //   283: aload 5
    //   285: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifne +113 -> 401
    //   291: aload 8
    //   293: astore 4
    //   295: aload_0
    //   296: getfield 194	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_Byte	B
    //   299: iconst_2
    //   300: if_icmpne +101 -> 401
    //   303: aload 8
    //   305: astore 4
    //   307: new 29	java/io/File
    //   310: dup
    //   311: aload 5
    //   313: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   316: invokevirtual 33	java/io/File:exists	()Z
    //   319: istore_3
    //   320: aload 7
    //   322: astore 6
    //   324: iload_3
    //   325: ifeq +51 -> 376
    //   328: aload 8
    //   330: astore 4
    //   332: aload 5
    //   334: invokestatic 203	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   337: astore 6
    //   339: goto +37 -> 376
    //   342: astore 5
    //   344: aload 7
    //   346: astore 6
    //   348: aload 8
    //   350: astore 4
    //   352: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +21 -> 376
    //   358: aload 8
    //   360: astore 4
    //   362: ldc 154
    //   364: iconst_2
    //   365: ldc 216
    //   367: aload 5
    //   369: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   372: aload 7
    //   374: astore 6
    //   376: aload 6
    //   378: astore 5
    //   380: aload 6
    //   382: ifnonnull +102 -> 484
    //   385: aload 6
    //   387: astore 4
    //   389: aload_0
    //   390: aload 9
    //   392: getfield 206	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:b	Ljava/lang/String;
    //   395: invokevirtual 208	com/tencent/mobileqq/config/struct/PicAndAdConf:b	(Ljava/lang/String;)V
    //   398: aload 6
    //   400: areturn
    //   401: aload 6
    //   403: astore 5
    //   405: aload 10
    //   407: ifnull +77 -> 484
    //   410: aload 8
    //   412: astore 4
    //   414: aload 10
    //   416: arraylength
    //   417: istore_1
    //   418: aload 6
    //   420: astore 5
    //   422: iload_1
    //   423: ifle +61 -> 484
    //   426: aload 10
    //   428: iconst_0
    //   429: aload 10
    //   431: arraylength
    //   432: invokestatic 222	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   435: astore 4
    //   437: aload 4
    //   439: areturn
    //   440: aload 8
    //   442: astore 4
    //   444: aload 9
    //   446: getfield 206	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:b	Ljava/lang/String;
    //   449: invokestatic 203	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   452: astore 5
    //   454: aload 5
    //   456: areturn
    //   457: astore 6
    //   459: aload 4
    //   461: astore 5
    //   463: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq +18 -> 484
    //   469: ldc 224
    //   471: iconst_2
    //   472: aload 6
    //   474: invokestatic 228	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   477: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload 4
    //   482: astore 5
    //   484: aload 5
    //   486: areturn
    //   487: astore 4
    //   489: aload 7
    //   491: astore 6
    //   493: goto -117 -> 376
    //   496: astore 4
    //   498: aconst_null
    //   499: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	PicAndAdConf
    //   0	500	1	paramInt	int
    //   56	18	2	i	int
    //   319	6	3	bool	boolean
    //   32	449	4	localObject1	Object
    //   487	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   496	1	4	localThrowable1	java.lang.Throwable
    //   11	322	5	localObject2	Object
    //   342	26	5	localException	Exception
    //   378	107	5	localObject3	Object
    //   4	415	6	localObject4	Object
    //   457	16	6	localThrowable2	java.lang.Throwable
    //   491	1	6	localObject5	Object
    //   7	483	7	localObject6	Object
    //   1	440	8	localObject7	Object
    //   45	400	9	localPicStruct	PicAndAdConf.PicStruct
    //   96	334	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   332	339	342	java/lang/Exception
    //   34	47	457	java/lang/Throwable
    //   51	57	457	java/lang/Throwable
    //   82	98	457	java/lang/Throwable
    //   102	118	457	java/lang/Throwable
    //   127	135	457	java/lang/Throwable
    //   139	146	457	java/lang/Throwable
    //   150	157	457	java/lang/Throwable
    //   161	167	457	java/lang/Throwable
    //   176	183	457	java/lang/Throwable
    //   187	202	457	java/lang/Throwable
    //   206	213	457	java/lang/Throwable
    //   230	238	457	java/lang/Throwable
    //   242	248	457	java/lang/Throwable
    //   252	261	457	java/lang/Throwable
    //   268	277	457	java/lang/Throwable
    //   283	291	457	java/lang/Throwable
    //   295	303	457	java/lang/Throwable
    //   307	320	457	java/lang/Throwable
    //   332	339	457	java/lang/Throwable
    //   352	358	457	java/lang/Throwable
    //   362	372	457	java/lang/Throwable
    //   389	398	457	java/lang/Throwable
    //   414	418	457	java/lang/Throwable
    //   444	454	457	java/lang/Throwable
    //   332	339	487	java/lang/OutOfMemoryError
    //   426	437	496	java/lang/Throwable
    //   444	454	496	java/lang/Exception
  }
  
  public PicAndAdConf.PicStruct a(long paramLong, String paramString1, byte paramByte, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort, String paramString6)
  {
    PicAndAdConf.PicStruct localPicStruct = new PicAndAdConf.PicStruct(this);
    localPicStruct.jdField_a_of_type_Long = paramLong;
    localPicStruct.jdField_a_of_type_JavaLangString = paramString1;
    localPicStruct.b = paramString2;
    localPicStruct.d = paramString3;
    localPicStruct.jdField_a_of_type_Byte = paramByte;
    localPicStruct.c = paramString4;
    localPicStruct.e = paramString5;
    localPicStruct.jdField_a_of_type_Short = paramShort;
    localPicStruct.f = paramString6;
    localPicStruct.jdField_a_of_type_Int = 0;
    return localPicStruct;
  }
  
  public PicAndAdConf.PicStruct a(long paramLong, String paramString1, byte paramByte, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    PicAndAdConf.PicStruct localPicStruct = new PicAndAdConf.PicStruct(this);
    localPicStruct.jdField_a_of_type_Long = paramLong;
    localPicStruct.jdField_a_of_type_JavaLangString = paramString1;
    localPicStruct.b = paramString2;
    localPicStruct.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localPicStruct.d = paramString3;
    localPicStruct.jdField_a_of_type_Byte = paramByte;
    localPicStruct.jdField_a_of_type_Int = 0;
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
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).e;
    }
    return "";
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
          if (this.jdField_a_of_type_Byte == 6)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("_");
            ((StringBuilder)localObject).append(Config.b);
            ((StringBuilder)localObject).append("_");
            ((StringBuilder)localObject).append(Config.jdField_a_of_type_Byte);
            ((StringBuilder)localObject).append(".png");
            localObject = ((StringBuilder)localObject).toString();
          }
          else if (this.jdField_a_of_type_Byte == 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("_");
            ((StringBuilder)localObject).append(Config.jdField_a_of_type_Byte - 2);
            ((StringBuilder)localObject).append(".png");
            localObject = ((StringBuilder)localObject).toString();
          }
          else if ((this.jdField_a_of_type_Byte == 1) && (paramString.contains("[]")))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(DeviceInfoUtil.g());
            ((StringBuilder)localObject).append("x");
            ((StringBuilder)localObject).append(DeviceInfoUtil.h());
            localObject = paramString.replace("[]", ((StringBuilder)localObject).toString());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("_");
            ((StringBuilder)localObject).append(Config.jdField_a_of_type_Byte);
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
            if (this.jdField_a_of_type_Byte == 1)
            {
              localObject = paramString;
              if (paramString.contains("[]"))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(DeviceInfoUtil.g());
                ((StringBuilder)localObject).append("x");
                ((StringBuilder)localObject).append(DeviceInfoUtil.h());
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
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Short;
    }
    return -1;
  }
  
  public void a()
  {
    a(true);
    long l = this.c;
    this.b = -1L;
    this.c = -1L;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i = this.jdField_a_of_type_Byte;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i == 2) || (i == 6)) {
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
        c();
      }
      label131:
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(DataInputStream paramDataInputStream)
  {
    this.jdField_a_of_type_Short = paramDataInputStream.readShort();
    this.jdField_a_of_type_Long = paramDataInputStream.readLong();
    this.b = paramDataInputStream.readLong();
    this.c = paramDataInputStream.readLong();
    this.jdField_a_of_type_Byte = paramDataInputStream.readByte();
    int j = paramDataInputStream.readInt();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        PicAndAdConf.PicStruct localPicStruct = new PicAndAdConf.PicStruct(this);
        if (this.jdField_a_of_type_Byte == 2) {
          localPicStruct.b(paramDataInputStream);
        } else {
          localPicStruct.a(paramDataInputStream);
        }
        a(localPicStruct);
        i += 1;
      }
    }
  }
  
  public void a(DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.writeShort(this.jdField_a_of_type_Short);
    paramDataOutputStream.writeLong(this.jdField_a_of_type_Long);
    paramDataOutputStream.writeLong(this.b);
    paramDataOutputStream.writeLong(this.c);
    paramDataOutputStream.writeByte(this.jdField_a_of_type_Byte);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    int j;
    if ((localObject != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      paramDataOutputStream.writeInt(j);
    }
    while (i < j)
    {
      localObject = (PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_a_of_type_Byte == 2) {
        ((PicAndAdConf.PicStruct)localObject).b(paramDataOutputStream);
      } else {
        ((PicAndAdConf.PicStruct)localObject).a(paramDataOutputStream);
      }
      i += 1;
      continue;
      paramDataOutputStream.writeInt(0);
    }
  }
  
  public void a(String paramString, byte[] arg2)
  {
    if ((??? != null) && (???.length > 0) && (paramString != null) && (paramString.length() > 0))
    {
      ArrayList localArrayList = Config.a();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        PicAndAdConf.PicStruct localPicStruct = (PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramString.startsWith(localPicStruct.b))
        {
          if (this.jdField_a_of_type_Byte == 1)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
            localStringBuilder.append("/");
            localStringBuilder.append("flashlogo.png");
            localPicStruct.c = localStringBuilder.toString();
            a(???, localPicStruct.c, this.b);
            if (localArrayList == null) {
              break;
            }
            ??? = localArrayList.iterator();
            while (???.hasNext()) {
              ((ConfigListener)???.next()).a(true, this.jdField_a_of_type_Short, i, paramString);
            }
          }
          if (this.jdField_a_of_type_Byte == 0)
          {
            a(???, String.valueOf(localPicStruct.f));
            try
            {
              ??? = new File(localPicStruct.c);
              if (!MD5.getFileMD5(???).equalsIgnoreCase(localPicStruct.f))
              {
                ???.delete();
                if (localPicStruct.jdField_a_of_type_Int < 1)
                {
                  localPicStruct.jdField_a_of_type_Int += 1;
                  b(localPicStruct.b);
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
              ((ConfigListener)???.next()).a(true, this.jdField_a_of_type_Short, i, paramString);
            }
          }
          if (this.jdField_a_of_type_Byte != 2) {
            break;
          }
          b(???, String.valueOf(localPicStruct.f));
          try
          {
            ??? = new File(localPicStruct.c);
            paramString = MD5.getFileMD5(???);
            if (!paramString.equalsIgnoreCase(localPicStruct.f))
            {
              ???.delete();
              if (localPicStruct.jdField_a_of_type_Int < 1)
              {
                localPicStruct.jdField_a_of_type_Int += 1;
                b(localPicStruct.b);
              }
              else
              {
                synchronized (this.jdField_a_of_type_JavaUtilHashMap)
                {
                  this.jdField_a_of_type_JavaUtilHashMap.put(localPicStruct.b, Long.valueOf(System.currentTimeMillis()));
                }
              }
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            ??? = new StringBuilder();
            ???.append("handle download NearbyBanner image, cid = ");
            ???.append(localPicStruct.jdField_a_of_type_Long);
            ???.append(", md5 is ");
            ???.append(paramString.equalsIgnoreCase(localPicStruct.f));
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
          ???.append(localPicStruct.f);
          QLog.d("PicAndAdConf", 2, ???.toString(), paramString);
          return;
        }
        i += 1;
      }
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
    }
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f;
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
      if (this.jdField_a_of_type_Byte == 2) {
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) && (Math.abs(System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue()) < 36000L))
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
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      ??? = Config.a();
      if (??? != null) {
        ((HttpCommunicator)???).sendMsg(new HttpMsg(paramString, null, this, true));
      }
    }
  }
  
  public String c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d;
    }
    return "";
  }
  
  public void c()
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
  
  public void d()
  {
    if (this.jdField_a_of_type_Byte == 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownload NearbyBanner image");
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        PicAndAdConf.PicStruct localPicStruct = (PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localPicStruct.c != null)
        {
          File localFile = new File(localPicStruct.c);
          if ((!localFile.exists()) || (!localFile.canRead()))
          {
            localStringBuilder.append(" | ");
            localStringBuilder.append(localPicStruct.jdField_a_of_type_Long);
            ThreadManager.post(new PicAndAdConf.1(this, localPicStruct), 5, null, false);
          }
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicAndAdConf", 2, localStringBuilder.toString());
      }
    }
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
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramHttpMsg2 = (PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramHttpMsg1.getUrl().startsWith(paramHttpMsg2.b))
      {
        paramHttpMsg2 = Config.a();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2 = paramHttpMsg2.iterator();
        while (paramHttpMsg2.hasNext()) {
          ((ConfigListener)paramHttpMsg2.next()).a(false, this.jdField_a_of_type_Short, i, paramHttpMsg1.getUrl());
        }
      }
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.PicAndAdConf
 * JD-Core Version:    0.7.0.1
 */