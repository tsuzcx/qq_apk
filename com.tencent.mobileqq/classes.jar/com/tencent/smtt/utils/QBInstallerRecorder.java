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
    //   41: ifne +26 -> 67
    //   44: ldc 53
    //   46: astore_1
    //   47: iconst_0
    //   48: ifeq -39 -> 9
    //   51: new 67	java/lang/NullPointerException
    //   54: dup
    //   55: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   58: athrow
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   64: ldc 53
    //   66: areturn
    //   67: aload_2
    //   68: astore_1
    //   69: aload 5
    //   71: invokestatic 75	com/tencent/smtt/utils/FileUtil:read	(Ljava/io/File;)[B
    //   74: astore 6
    //   76: aload 6
    //   78: ifnull +11 -> 89
    //   81: aload_2
    //   82: astore_1
    //   83: aload 6
    //   85: arraylength
    //   86: ifgt +26 -> 112
    //   89: ldc 53
    //   91: astore_1
    //   92: iconst_0
    //   93: ifeq -84 -> 9
    //   96: new 67	java/lang/NullPointerException
    //   99: dup
    //   100: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   103: athrow
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   109: ldc 53
    //   111: areturn
    //   112: aload_2
    //   113: astore_1
    //   114: new 77	java/io/DataInputStream
    //   117: dup
    //   118: aload 5
    //   120: invokestatic 81	com/tencent/smtt/utils/FileUtil:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   123: invokespecial 84	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   126: astore_2
    //   127: aload_2
    //   128: invokevirtual 87	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   131: astore_3
    //   132: aload_3
    //   133: astore_1
    //   134: aload_2
    //   135: ifnull -126 -> 9
    //   138: aload_2
    //   139: invokevirtual 90	java/io/DataInputStream:close	()V
    //   142: aload_3
    //   143: areturn
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   149: aload_3
    //   150: areturn
    //   151: astore_3
    //   152: aload 4
    //   154: astore_2
    //   155: aload_2
    //   156: astore_1
    //   157: aload_3
    //   158: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 90	java/io/DataInputStream:close	()V
    //   169: ldc 53
    //   171: areturn
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   177: goto -8 -> 169
    //   180: astore_1
    //   181: aload_3
    //   182: astore_2
    //   183: aload_1
    //   184: astore_3
    //   185: aload_2
    //   186: astore_1
    //   187: aload_3
    //   188: invokevirtual 92	java/lang/Error:printStackTrace	()V
    //   191: aload_2
    //   192: ifnull -23 -> 169
    //   195: aload_2
    //   196: invokevirtual 90	java/io/DataInputStream:close	()V
    //   199: goto -30 -> 169
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   207: goto -38 -> 169
    //   210: astore_3
    //   211: aload_1
    //   212: astore_2
    //   213: aload_3
    //   214: astore_1
    //   215: aload_2
    //   216: ifnull +7 -> 223
    //   219: aload_2
    //   220: invokevirtual 90	java/io/DataInputStream:close	()V
    //   223: aload_1
    //   224: athrow
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   230: goto -7 -> 223
    //   233: astore_1
    //   234: goto -19 -> 215
    //   237: astore_3
    //   238: goto -53 -> 185
    //   241: astore_3
    //   242: goto -87 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	QBInstallerRecorder
    //   8	39	1	localObject1	Object
    //   59	2	1	localIOException1	java.io.IOException
    //   68	24	1	localObject2	Object
    //   104	2	1	localIOException2	java.io.IOException
    //   113	21	1	localObject3	Object
    //   144	2	1	localIOException3	java.io.IOException
    //   156	1	1	localObject4	Object
    //   172	2	1	localIOException4	java.io.IOException
    //   180	4	1	localError1	java.lang.Error
    //   186	1	1	localObject5	Object
    //   202	10	1	localIOException5	java.io.IOException
    //   214	10	1	localObject6	Object
    //   233	1	1	localObject7	Object
    //   14	206	2	localObject8	Object
    //   225	2	2	localIOException6	java.io.IOException
    //   12	138	3	str	String
    //   151	31	3	localException1	Exception
    //   184	4	3	localError2	java.lang.Error
    //   210	4	3	localObject9	Object
    //   237	1	3	localError3	java.lang.Error
    //   241	1	3	localException2	Exception
    //   16	137	4	localObject10	Object
    //   32	87	5	localFile	java.io.File
    //   74	10	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   51	59	59	java/io/IOException
    //   96	104	104	java/io/IOException
    //   138	142	144	java/io/IOException
    //   20	34	151	java/lang/Exception
    //   36	44	151	java/lang/Exception
    //   69	76	151	java/lang/Exception
    //   83	89	151	java/lang/Exception
    //   114	127	151	java/lang/Exception
    //   165	169	172	java/io/IOException
    //   20	34	180	java/lang/Error
    //   36	44	180	java/lang/Error
    //   69	76	180	java/lang/Error
    //   83	89	180	java/lang/Error
    //   114	127	180	java/lang/Error
    //   195	199	202	java/io/IOException
    //   20	34	210	finally
    //   36	44	210	finally
    //   69	76	210	finally
    //   83	89	210	finally
    //   114	127	210	finally
    //   157	161	210	finally
    //   187	191	210	finally
    //   219	223	225	java/io/IOException
    //   127	132	233	finally
    //   127	132	237	java/lang/Error
    //   127	132	241	java/lang/Exception
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
    //   112: aload_1
    //   113: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   116: return
    //   117: astore_1
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokevirtual 133	java/io/DataOutputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   133: goto -7 -> 126
    //   136: astore_1
    //   137: aload_3
    //   138: astore_2
    //   139: goto -21 -> 118
    //   142: astore_2
    //   143: aload_3
    //   144: astore_1
    //   145: aload_2
    //   146: astore_3
    //   147: goto -51 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	QBInstallerRecorder
    //   0	150	1	paramString	String
    //   13	110	2	localObject1	Object
    //   128	2	2	localIOException	java.io.IOException
    //   138	1	2	localException1	Exception
    //   142	4	2	localException2	Exception
    //   8	74	3	localDataOutputStream	java.io.DataOutputStream
    //   92	52	3	localException3	Exception
    //   146	1	3	localObject2	Object
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
    //   14	28	117	finally
    //   30	38	117	finally
    //   40	46	117	finally
    //   48	68	117	finally
    //   98	102	117	finally
    //   122	126	128	java/io/IOException
    //   68	77	136	finally
    //   68	77	142	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.QBInstallerRecorder
 * JD-Core Version:    0.7.0.1
 */