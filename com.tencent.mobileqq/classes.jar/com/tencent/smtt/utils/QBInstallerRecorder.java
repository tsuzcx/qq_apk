package com.tencent.smtt.utils;

import android.content.Context;
import android.provider.Settings.System;
import android.text.TextUtils;

public class QBInstallerRecorder
{
  private static final String INSTALLER_FILE = "ins.dat";
  private static final String SYS_SETTING_TBS_QB_INSTALLER = "sys_setting_tbs_qb_installer";
  private static final String TAG = "QBInstallerRecorder";
  private static Context mContext = null;
  private static QBInstallerRecorder mIntance = null;
  
  public static QBInstallerRecorder getInstance(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
    if (mIntance == null) {
      mIntance = new QBInstallerRecorder();
    }
    return mIntance;
  }
  
  /* Error */
  private String loadQBInstallerFromSDCard()
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/smtt/utils/FileUtil:hasSDcard	()Z
    //   3: ifne +8 -> 11
    //   6: ldc 53
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_2
    //   15: aconst_null
    //   16: astore 4
    //   18: aload_2
    //   19: astore_1
    //   20: new 55	java/io/File
    //   23: dup
    //   24: invokestatic 59	com/tencent/smtt/utils/FileUtil:getTbsSdcardShareDir	()Ljava/io/File;
    //   27: ldc 8
    //   29: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore 5
    //   34: aload_2
    //   35: astore_1
    //   36: aload 5
    //   38: invokevirtual 65	java/io/File:exists	()Z
    //   41: ifne +29 -> 70
    //   44: ldc 53
    //   46: astore_3
    //   47: aload_3
    //   48: astore_1
    //   49: iconst_0
    //   50: ifeq -41 -> 9
    //   53: new 67	java/lang/NullPointerException
    //   56: dup
    //   57: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   60: athrow
    //   61: astore_2
    //   62: aload_3
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   68: aload_1
    //   69: areturn
    //   70: aload_2
    //   71: astore_1
    //   72: aload 5
    //   74: invokestatic 75	com/tencent/smtt/utils/FileUtil:read	(Ljava/io/File;)[B
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +11 -> 92
    //   84: aload_2
    //   85: astore_1
    //   86: aload 6
    //   88: arraylength
    //   89: ifgt +28 -> 117
    //   92: ldc 53
    //   94: astore_2
    //   95: aload_2
    //   96: astore_1
    //   97: iconst_0
    //   98: ifeq -89 -> 9
    //   101: new 67	java/lang/NullPointerException
    //   104: dup
    //   105: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   108: athrow
    //   109: astore_3
    //   110: aload_2
    //   111: astore_1
    //   112: aload_3
    //   113: astore_2
    //   114: goto -50 -> 64
    //   117: aload_2
    //   118: astore_1
    //   119: new 77	java/io/DataInputStream
    //   122: dup
    //   123: aload 5
    //   125: invokestatic 81	com/tencent/smtt/utils/FileUtil:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   128: invokespecial 84	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   131: astore_2
    //   132: aload_2
    //   133: invokevirtual 87	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   136: astore_3
    //   137: aload_3
    //   138: astore_1
    //   139: aload_2
    //   140: ifnull -131 -> 9
    //   143: aload_2
    //   144: invokevirtual 90	java/io/DataInputStream:close	()V
    //   147: aload_3
    //   148: areturn
    //   149: astore_2
    //   150: aload_3
    //   151: astore_1
    //   152: goto -88 -> 64
    //   155: astore_3
    //   156: aload 4
    //   158: astore_2
    //   159: aload_2
    //   160: astore_1
    //   161: aload_3
    //   162: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 90	java/io/DataInputStream:close	()V
    //   173: ldc 53
    //   175: areturn
    //   176: astore_1
    //   177: aload_3
    //   178: astore_2
    //   179: aload_1
    //   180: astore_3
    //   181: aload_2
    //   182: astore_1
    //   183: aload_3
    //   184: invokevirtual 92	java/lang/Error:printStackTrace	()V
    //   187: aload_2
    //   188: ifnull -15 -> 173
    //   191: aload_2
    //   192: invokevirtual 90	java/io/DataInputStream:close	()V
    //   195: goto -22 -> 173
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   203: goto -30 -> 173
    //   206: astore_3
    //   207: aload_1
    //   208: astore_2
    //   209: aload_3
    //   210: astore_1
    //   211: aload_2
    //   212: ifnull +7 -> 219
    //   215: aload_2
    //   216: invokevirtual 90	java/io/DataInputStream:close	()V
    //   219: aload_1
    //   220: athrow
    //   221: astore_2
    //   222: aload_2
    //   223: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   226: goto -7 -> 219
    //   229: astore_1
    //   230: goto -31 -> 199
    //   233: astore_1
    //   234: goto -23 -> 211
    //   237: astore_3
    //   238: goto -57 -> 181
    //   241: astore_3
    //   242: goto -83 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	QBInstallerRecorder
    //   8	153	1	localObject1	Object
    //   176	4	1	localError1	java.lang.Error
    //   182	1	1	localObject2	Object
    //   198	10	1	localIOException1	java.io.IOException
    //   210	10	1	localObject3	Object
    //   229	1	1	localIOException2	java.io.IOException
    //   233	1	1	localObject4	Object
    //   14	21	2	localObject5	Object
    //   61	24	2	localIOException3	java.io.IOException
    //   94	50	2	localObject6	Object
    //   149	1	2	localIOException4	java.io.IOException
    //   158	58	2	localObject7	Object
    //   221	2	2	localIOException5	java.io.IOException
    //   12	51	3	str1	String
    //   109	4	3	localIOException6	java.io.IOException
    //   136	15	3	str2	String
    //   155	23	3	localException1	Exception
    //   180	4	3	localError2	java.lang.Error
    //   206	4	3	localObject8	Object
    //   237	1	3	localError3	java.lang.Error
    //   241	1	3	localException2	Exception
    //   16	141	4	localObject9	Object
    //   32	92	5	localFile	java.io.File
    //   77	10	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   53	61	61	java/io/IOException
    //   101	109	109	java/io/IOException
    //   143	147	149	java/io/IOException
    //   20	34	155	java/lang/Exception
    //   36	44	155	java/lang/Exception
    //   72	79	155	java/lang/Exception
    //   86	92	155	java/lang/Exception
    //   119	132	155	java/lang/Exception
    //   20	34	176	java/lang/Error
    //   36	44	176	java/lang/Error
    //   72	79	176	java/lang/Error
    //   86	92	176	java/lang/Error
    //   119	132	176	java/lang/Error
    //   191	195	198	java/io/IOException
    //   20	34	206	finally
    //   36	44	206	finally
    //   72	79	206	finally
    //   86	92	206	finally
    //   119	132	206	finally
    //   161	165	206	finally
    //   183	187	206	finally
    //   215	219	221	java/io/IOException
    //   169	173	229	java/io/IOException
    //   132	137	233	finally
    //   132	137	237	java/lang/Error
    //   132	137	241	java/lang/Exception
  }
  
  private String loadQBInstallerFromSysSetting()
  {
    try
    {
      str1 = Settings.System.getString(mContext.getContentResolver(), "sys_setting_tbs_qb_installer");
      String str2 = str1;
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        if (TextUtils.isEmpty(str1)) {
          str2 = "";
        }
        return str2;
      }
      catch (Exception localException2)
      {
        String str1;
        break label30;
      }
      localException1 = localException1;
      str1 = "";
    }
    label30:
    return str1;
  }
  
  /* Error */
  private void recordInstallerToSDCard(String paramString)
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/smtt/utils/FileUtil:hasSDcard	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_3
    //   13: astore_2
    //   14: new 55	java/io/File
    //   17: dup
    //   18: invokestatic 59	com/tencent/smtt/utils/FileUtil:getTbsSdcardShareDir	()Ljava/io/File;
    //   21: ldc 8
    //   23: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 5
    //   28: aload_3
    //   29: astore_2
    //   30: aload 5
    //   32: invokevirtual 65	java/io/File:exists	()Z
    //   35: ifne +11 -> 46
    //   38: aload_3
    //   39: astore_2
    //   40: aload 5
    //   42: invokevirtual 114	java/io/File:createNewFile	()Z
    //   45: pop
    //   46: aload_3
    //   47: astore_2
    //   48: new 116	java/io/DataOutputStream
    //   51: dup
    //   52: new 118	java/io/BufferedOutputStream
    //   55: dup
    //   56: aload 5
    //   58: invokestatic 122	com/tencent/smtt/utils/FileUtil:openOutputStream	(Ljava/io/File;)Ljava/io/FileOutputStream;
    //   61: invokespecial 125	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: invokespecial 126	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore_3
    //   68: aload_3
    //   69: aload_1
    //   70: invokevirtual 129	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   73: aload_3
    //   74: invokevirtual 132	java/io/DataOutputStream:flush	()V
    //   77: aload_3
    //   78: ifnull -72 -> 6
    //   81: aload_3
    //   82: invokevirtual 133	java/io/DataOutputStream:close	()V
    //   85: return
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   91: return
    //   92: astore_3
    //   93: aload 4
    //   95: astore_1
    //   96: aload_1
    //   97: astore_2
    //   98: aload_3
    //   99: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   102: aload_1
    //   103: ifnull -97 -> 6
    //   106: aload_1
    //   107: invokevirtual 133	java/io/DataOutputStream:close	()V
    //   110: return
    //   111: astore_1
    //   112: goto -25 -> 87
    //   115: astore_1
    //   116: aload_2
    //   117: ifnull +7 -> 124
    //   120: aload_2
    //   121: invokevirtual 133	java/io/DataOutputStream:close	()V
    //   124: aload_1
    //   125: athrow
    //   126: astore_2
    //   127: aload_2
    //   128: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   131: goto -7 -> 124
    //   134: astore_1
    //   135: aload_3
    //   136: astore_2
    //   137: goto -21 -> 116
    //   140: astore_2
    //   141: aload_3
    //   142: astore_1
    //   143: aload_2
    //   144: astore_3
    //   145: goto -49 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	QBInstallerRecorder
    //   0	148	1	paramString	String
    //   13	108	2	localObject1	Object
    //   126	2	2	localIOException	java.io.IOException
    //   136	1	2	localException1	Exception
    //   140	4	2	localException2	Exception
    //   8	74	3	localDataOutputStream	java.io.DataOutputStream
    //   92	50	3	localException3	Exception
    //   144	1	3	localObject2	Object
    //   10	84	4	localObject3	Object
    //   26	31	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   81	85	86	java/io/IOException
    //   14	28	92	java/lang/Exception
    //   30	38	92	java/lang/Exception
    //   40	46	92	java/lang/Exception
    //   48	68	92	java/lang/Exception
    //   106	110	111	java/io/IOException
    //   14	28	115	finally
    //   30	38	115	finally
    //   40	46	115	finally
    //   48	68	115	finally
    //   98	102	115	finally
    //   120	124	126	java/io/IOException
    //   68	77	134	finally
    //   68	77	140	java/lang/Exception
  }
  
  private void recordInstallerToSysSetting(String paramString)
  {
    try
    {
      Settings.System.putString(mContext.getContentResolver(), "sys_setting_tbs_qb_installer", paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String getQBInstaller()
  {
    if (!TextUtils.isEmpty(loadQBInstallerFromSDCard())) {
      return "";
    }
    return loadQBInstallerFromSysSetting();
  }
  
  public void recordQBInstaller(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    recordInstallerToSDCard(paramString);
    recordInstallerToSysSetting(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.QBInstallerRecorder
 * JD-Core Version:    0.7.0.1
 */