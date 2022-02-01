package com.tencent.mobileqq.minicode;

import android.content.Context;
import android.util.Log;
import java.io.File;

public class Utils
{
  public static void checkResIsOK(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      File localFile = new File(paramString1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Log.i("checkResIsOK", "exception !!!!!!!!!!!!", localException);
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (!new File(paramString1).exists())
      {
        copyFileFromAssets(paramContext, paramString2, paramString1);
        return;
      }
    }
    catch (Exception paramContext)
    {
      Log.i("checkResIsOK", "exception !!!!!!!!!!!!", paramContext);
      paramContext.printStackTrace();
    }
  }
  
  /* Error */
  public static void copyFileFromAssets(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   10: aload_1
    //   11: invokevirtual 63	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_0
    //   15: new 65	java/io/FileOutputStream
    //   18: dup
    //   19: new 15	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: sipush 1024
    //   34: newarray byte
    //   36: astore_1
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 74	java/io/InputStream:read	([B)I
    //   42: istore_3
    //   43: iload_3
    //   44: iconst_m1
    //   45: if_icmpeq +13 -> 58
    //   48: aload_2
    //   49: aload_1
    //   50: iconst_0
    //   51: iload_3
    //   52: invokevirtual 78	java/io/FileOutputStream:write	([BII)V
    //   55: goto -18 -> 37
    //   58: aload_2
    //   59: invokevirtual 81	java/io/FileOutputStream:flush	()V
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 84	java/io/InputStream:close	()V
    //   70: aload_2
    //   71: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   74: return
    //   75: astore_1
    //   76: goto +74 -> 150
    //   79: astore_1
    //   80: goto +13 -> 93
    //   83: astore_1
    //   84: aload 5
    //   86: astore_2
    //   87: goto +63 -> 150
    //   90: astore_1
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_0
    //   94: astore 4
    //   96: aload_2
    //   97: astore_0
    //   98: goto +15 -> 113
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload 5
    //   106: astore_2
    //   107: goto +43 -> 150
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_0
    //   113: aload_1
    //   114: invokevirtual 28	java/lang/Exception:printStackTrace	()V
    //   117: aload 4
    //   119: ifnull +11 -> 130
    //   122: aload 4
    //   124: invokevirtual 84	java/io/InputStream:close	()V
    //   127: goto +3 -> 130
    //   130: aload_0
    //   131: ifnull +12 -> 143
    //   134: aload_0
    //   135: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   138: return
    //   139: aload_0
    //   140: invokevirtual 28	java/lang/Exception:printStackTrace	()V
    //   143: return
    //   144: astore_1
    //   145: aload_0
    //   146: astore_2
    //   147: aload 4
    //   149: astore_0
    //   150: aload_0
    //   151: ifnull +10 -> 161
    //   154: aload_0
    //   155: invokevirtual 84	java/io/InputStream:close	()V
    //   158: goto +3 -> 161
    //   161: aload_2
    //   162: ifnull +14 -> 176
    //   165: aload_2
    //   166: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   169: goto +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 28	java/lang/Exception:printStackTrace	()V
    //   176: goto +5 -> 181
    //   179: aload_1
    //   180: athrow
    //   181: goto -2 -> 179
    //   184: astore_0
    //   185: goto -46 -> 139
    //   188: astore_0
    //   189: goto -17 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   0	192	1	paramString1	String
    //   0	192	2	paramString2	String
    //   42	10	3	i	int
    //   4	144	4	localContext	Context
    //   1	104	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	37	75	finally
    //   37	43	75	finally
    //   48	55	75	finally
    //   58	62	75	finally
    //   31	37	79	java/lang/Exception
    //   37	43	79	java/lang/Exception
    //   48	55	79	java/lang/Exception
    //   58	62	79	java/lang/Exception
    //   15	31	83	finally
    //   15	31	90	java/lang/Exception
    //   6	15	101	finally
    //   6	15	110	java/lang/Exception
    //   113	117	144	finally
    //   66	70	184	java/lang/Exception
    //   70	74	184	java/lang/Exception
    //   122	127	184	java/lang/Exception
    //   134	138	184	java/lang/Exception
    //   154	158	188	java/lang/Exception
    //   165	169	188	java/lang/Exception
  }
  
  /* Error */
  public static String readModelFile(String paramString)
  {
    // Byte code:
    //   0: new 39	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 5
    //   16: new 91	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: astore_2
    //   27: new 94	java/io/BufferedReader
    //   30: dup
    //   31: new 96	java/io/InputStreamReader
    //   34: dup
    //   35: aload_0
    //   36: ldc 98
    //   38: invokespecial 101	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   41: invokespecial 104	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore_3
    //   45: aload_3
    //   46: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +37 -> 88
    //   54: new 39	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   61: astore_2
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_2
    //   69: bipush 10
    //   71: invokevirtual 110	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 6
    //   77: aload_2
    //   78: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: goto -40 -> 45
    //   88: aload_3
    //   89: invokevirtual 111	java/io/BufferedReader:close	()V
    //   92: aload_0
    //   93: invokevirtual 112	java/io/FileInputStream:close	()V
    //   96: goto +62 -> 158
    //   99: astore_1
    //   100: aload_3
    //   101: astore_2
    //   102: goto +69 -> 171
    //   105: astore 4
    //   107: goto +24 -> 131
    //   110: astore 4
    //   112: aload 5
    //   114: astore_3
    //   115: goto +16 -> 131
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_0
    //   121: goto +50 -> 171
    //   124: astore 4
    //   126: aconst_null
    //   127: astore_0
    //   128: aload 5
    //   130: astore_3
    //   131: aload_3
    //   132: astore_1
    //   133: aload_0
    //   134: astore_2
    //   135: aload 4
    //   137: invokevirtual 28	java/lang/Exception:printStackTrace	()V
    //   140: aload_3
    //   141: ifnull +10 -> 151
    //   144: aload_3
    //   145: invokevirtual 111	java/io/BufferedReader:close	()V
    //   148: goto +3 -> 151
    //   151: aload_0
    //   152: ifnull +6 -> 158
    //   155: goto -63 -> 92
    //   158: aload 6
    //   160: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: areturn
    //   164: astore_3
    //   165: aload_2
    //   166: astore_0
    //   167: aload_1
    //   168: astore_2
    //   169: aload_3
    //   170: astore_1
    //   171: aload_2
    //   172: ifnull +10 -> 182
    //   175: aload_2
    //   176: invokevirtual 111	java/io/BufferedReader:close	()V
    //   179: goto +3 -> 182
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 112	java/io/FileInputStream:close	()V
    //   190: goto +5 -> 195
    //   193: aload_1
    //   194: athrow
    //   195: goto -2 -> 193
    //   198: astore_1
    //   199: goto -107 -> 92
    //   202: astore_0
    //   203: goto -45 -> 158
    //   206: astore_1
    //   207: goto -56 -> 151
    //   210: astore_2
    //   211: goto -29 -> 182
    //   214: astore_0
    //   215: goto -25 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString	String
    //   10	54	1	str	String
    //   99	1	1	localObject1	Object
    //   118	1	1	localObject2	Object
    //   132	62	1	localObject3	Object
    //   198	1	1	localIOException1	java.io.IOException
    //   206	1	1	localIOException2	java.io.IOException
    //   12	164	2	localObject4	Object
    //   210	1	2	localIOException3	java.io.IOException
    //   44	101	3	localObject5	Object
    //   164	6	3	localObject6	Object
    //   105	1	4	localException1	Exception
    //   110	1	4	localException2	Exception
    //   124	12	4	localException3	Exception
    //   14	115	5	localObject7	Object
    //   7	152	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   45	50	99	finally
    //   54	85	99	finally
    //   45	50	105	java/lang/Exception
    //   54	85	105	java/lang/Exception
    //   27	45	110	java/lang/Exception
    //   16	25	118	finally
    //   16	25	124	java/lang/Exception
    //   27	45	164	finally
    //   135	140	164	finally
    //   88	92	198	java/io/IOException
    //   92	96	202	java/io/IOException
    //   144	148	206	java/io/IOException
    //   175	179	210	java/io/IOException
    //   186	190	214	java/io/IOException
  }
  
  /* Error */
  public static boolean saveBitmapToFile(android.graphics.Bitmap paramBitmap, String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 15	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: iconst_0
    //   11: istore 6
    //   13: iconst_0
    //   14: istore 5
    //   16: new 15	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: iconst_0
    //   22: aload_1
    //   23: ldc 116
    //   25: invokevirtual 122	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   28: invokevirtual 126	java/lang/String:substring	(II)Ljava/lang/String;
    //   31: invokespecial 18	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 22	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_1
    //   43: invokevirtual 25	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aconst_null
    //   48: astore 8
    //   50: aconst_null
    //   51: astore_1
    //   52: aload 7
    //   54: invokevirtual 22	java/io/File:exists	()Z
    //   57: ifne +24 -> 81
    //   60: aload 7
    //   62: invokevirtual 129	java/io/File:createNewFile	()Z
    //   65: pop
    //   66: goto +15 -> 81
    //   69: astore 9
    //   71: ldc 131
    //   73: iconst_1
    //   74: ldc 133
    //   76: aload 9
    //   78: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   81: new 141	java/io/BufferedOutputStream
    //   84: dup
    //   85: new 65	java/io/FileOutputStream
    //   88: dup
    //   89: aload 7
    //   91: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: invokespecial 144	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   97: astore 7
    //   99: aload_0
    //   100: aload_2
    //   101: iload_3
    //   102: aload 7
    //   104: invokevirtual 150	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   107: istore 6
    //   109: iload 6
    //   111: istore 5
    //   113: aload 7
    //   115: invokevirtual 151	java/io/BufferedOutputStream:flush	()V
    //   118: iload 4
    //   120: ifeq +11 -> 131
    //   123: iload 6
    //   125: istore 5
    //   127: aload_0
    //   128: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   131: iload 6
    //   133: istore 4
    //   135: aload 7
    //   137: invokevirtual 155	java/io/BufferedOutputStream:close	()V
    //   140: iload 6
    //   142: ireturn
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   148: iload 4
    //   150: ireturn
    //   151: astore_0
    //   152: aload 7
    //   154: astore_1
    //   155: goto +48 -> 203
    //   158: astore_2
    //   159: aload 7
    //   161: astore_0
    //   162: goto +15 -> 177
    //   165: astore_0
    //   166: goto +37 -> 203
    //   169: astore_2
    //   170: aload 8
    //   172: astore_0
    //   173: iload 6
    //   175: istore 5
    //   177: aload_0
    //   178: astore_1
    //   179: ldc 131
    //   181: iconst_1
    //   182: ldc 158
    //   184: aload_2
    //   185: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload_0
    //   189: ifnull +11 -> 200
    //   192: iload 5
    //   194: istore 4
    //   196: aload_0
    //   197: invokevirtual 155	java/io/BufferedOutputStream:close	()V
    //   200: iload 5
    //   202: ireturn
    //   203: aload_1
    //   204: ifnull +15 -> 219
    //   207: aload_1
    //   208: invokevirtual 155	java/io/BufferedOutputStream:close	()V
    //   211: goto +8 -> 219
    //   214: astore_1
    //   215: aload_1
    //   216: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   219: aload_0
    //   220: athrow
    //   221: astore_1
    //   222: goto -175 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramBitmap	android.graphics.Bitmap
    //   0	225	1	paramString	String
    //   0	225	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	225	3	paramInt	int
    //   0	225	4	paramBoolean	boolean
    //   14	187	5	bool1	boolean
    //   11	163	6	bool2	boolean
    //   8	152	7	localObject1	Object
    //   48	123	8	localObject2	Object
    //   69	8	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   60	66	69	java/lang/Exception
    //   135	140	143	java/io/IOException
    //   196	200	143	java/io/IOException
    //   99	109	151	finally
    //   113	118	151	finally
    //   127	131	151	finally
    //   99	109	158	java/lang/Exception
    //   113	118	158	java/lang/Exception
    //   127	131	158	java/lang/Exception
    //   81	99	165	finally
    //   179	188	165	finally
    //   81	99	169	java/lang/Exception
    //   207	211	214	java/io/IOException
    //   16	47	221	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.Utils
 * JD-Core Version:    0.7.0.1
 */