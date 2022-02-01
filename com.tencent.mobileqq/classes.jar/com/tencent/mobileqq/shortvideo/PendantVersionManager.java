package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

public class PendantVersionManager
{
  /* Error */
  private static ArrayList<String> a(File paramFile)
  {
    // Byte code:
    //   0: new 17	java/util/ArrayList
    //   3: dup
    //   4: iconst_1
    //   5: invokespecial 20	java/util/ArrayList:<init>	(I)V
    //   8: astore 6
    //   10: aconst_null
    //   11: astore_1
    //   12: aconst_null
    //   13: astore_2
    //   14: aconst_null
    //   15: astore 5
    //   17: new 22	java/io/FileReader
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 25	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   25: astore_0
    //   26: aload_0
    //   27: astore_2
    //   28: new 27	java/io/BufferedReader
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 30	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual 34	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +18 -> 61
    //   46: aload 6
    //   48: aload_1
    //   49: invokevirtual 38	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload_3
    //   54: invokevirtual 34	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore_1
    //   58: goto -16 -> 42
    //   61: aload_3
    //   62: invokevirtual 41	java/io/BufferedReader:close	()V
    //   65: goto +8 -> 73
    //   68: astore_1
    //   69: aload_1
    //   70: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   73: aload_0
    //   74: invokevirtual 45	java/io/FileReader:close	()V
    //   77: aload 6
    //   79: areturn
    //   80: astore_1
    //   81: aload_3
    //   82: astore_2
    //   83: goto +93 -> 176
    //   86: astore 4
    //   88: goto +24 -> 112
    //   91: astore 4
    //   93: aload 5
    //   95: astore_3
    //   96: goto +16 -> 112
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_0
    //   102: goto +74 -> 176
    //   105: astore 4
    //   107: aconst_null
    //   108: astore_0
    //   109: aload 5
    //   111: astore_3
    //   112: aload_3
    //   113: astore_1
    //   114: aload_0
    //   115: astore_2
    //   116: aload 4
    //   118: invokevirtual 46	java/lang/Exception:printStackTrace	()V
    //   121: aload_3
    //   122: astore_1
    //   123: aload_0
    //   124: astore_2
    //   125: ldc 48
    //   127: ldc 50
    //   129: aload 4
    //   131: invokestatic 56	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: aload_3
    //   135: ifnull +15 -> 150
    //   138: aload_3
    //   139: invokevirtual 41	java/io/BufferedReader:close	()V
    //   142: goto +8 -> 150
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   150: aload_0
    //   151: ifnull +15 -> 166
    //   154: aload_0
    //   155: invokevirtual 45	java/io/FileReader:close	()V
    //   158: aload 6
    //   160: areturn
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   166: aload 6
    //   168: areturn
    //   169: astore_3
    //   170: aload_2
    //   171: astore_0
    //   172: aload_1
    //   173: astore_2
    //   174: aload_3
    //   175: astore_1
    //   176: aload_2
    //   177: ifnull +15 -> 192
    //   180: aload_2
    //   181: invokevirtual 41	java/io/BufferedReader:close	()V
    //   184: goto +8 -> 192
    //   187: astore_2
    //   188: aload_2
    //   189: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   192: aload_0
    //   193: ifnull +15 -> 208
    //   196: aload_0
    //   197: invokevirtual 45	java/io/FileReader:close	()V
    //   200: goto +8 -> 208
    //   203: astore_0
    //   204: aload_0
    //   205: invokevirtual 44	java/io/IOException:printStackTrace	()V
    //   208: goto +5 -> 213
    //   211: aload_1
    //   212: athrow
    //   213: goto -2 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramFile	File
    //   11	47	1	str	String
    //   68	2	1	localIOException1	java.io.IOException
    //   80	1	1	localObject1	Object
    //   99	1	1	localObject2	Object
    //   113	10	1	localObject3	Object
    //   145	28	1	localIOException2	java.io.IOException
    //   175	37	1	localObject4	Object
    //   13	168	2	localObject5	Object
    //   187	2	2	localIOException3	java.io.IOException
    //   36	103	3	localObject6	Object
    //   169	6	3	localObject7	Object
    //   86	1	4	localException1	java.lang.Exception
    //   91	1	4	localException2	java.lang.Exception
    //   105	25	4	localException3	java.lang.Exception
    //   15	95	5	localObject8	Object
    //   8	159	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   61	65	68	java/io/IOException
    //   37	42	80	finally
    //   46	58	80	finally
    //   37	42	86	java/lang/Exception
    //   46	58	86	java/lang/Exception
    //   28	37	91	java/lang/Exception
    //   17	26	99	finally
    //   17	26	105	java/lang/Exception
    //   138	142	145	java/io/IOException
    //   73	77	161	java/io/IOException
    //   154	158	161	java/io/IOException
    //   28	37	169	finally
    //   116	121	169	finally
    //   125	134	169	finally
    //   180	184	187	java/io/IOException
    //   196	200	203	java/io/IOException
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    Object localObject = paramString.trim();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkSignatureVersionIsOK signature=");
    localStringBuilder.append(paramString);
    VideoEnvironment.LogDownLoad("PendantVersionManager", localStringBuilder.toString(), null);
    paramString = ShortVideoSoManager.a((String)localObject);
    int i = paramString.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkSignatureVersionIsOK errCode=");
    localStringBuilder.append(i);
    localStringBuilder.append(",trimSignature=");
    localStringBuilder.append((String)localObject);
    VideoEnvironment.LogDownLoad("PendantVersionManager", localStringBuilder.toString(), null);
    if (i == 0)
    {
      paramString = paramString.b().trim();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkSignatureVersionIsOK versionValid=");
      ((StringBuilder)localObject).append(paramString);
      VideoEnvironment.LogDownLoad("PendantVersionManager", ((StringBuilder)localObject).toString(), null);
      i = Integer.parseInt(paramString);
      paramString = new StringBuilder();
      paramString.append("checkSignatureVersionIsOK version=");
      paramString.append(i);
      paramString.append(",limitVersion=");
      paramString.append(paramInt);
      VideoEnvironment.LogDownLoad("PendantVersionManager", paramString.toString(), null);
      if (i >= paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(paramString2);
    paramString2 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkUnzipFileListSizeIsOK configPath=");
    ((StringBuilder)localObject1).append(paramString2);
    VideoEnvironment.LogDownLoad("PendantVersionManager", ((StringBuilder)localObject1).toString(), null);
    localObject1 = new File(paramString2);
    if (!((File)localObject1).exists())
    {
      paramString1 = new StringBuilder();
      paramString1.append("checkUnzipFileListSizeIsOK configPath=");
      paramString1.append(paramString2);
      paramString1.append(",exists=false");
      VideoEnvironment.LogDownLoad("PendantVersionManager", paramString1.toString(), null);
      return false;
    }
    paramString2 = a((File)localObject1);
    if (paramString2.size() <= 0)
    {
      paramString1 = new StringBuilder();
      paramString1.append("checkUnzipFileListSizeIsOK configData.size()=");
      paramString1.append(paramString2.size());
      VideoEnvironment.LogDownLoad("PendantVersionManager", paramString1.toString(), null);
      return false;
    }
    int i = 0;
    while (i < paramString2.size())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkUnzipFileListSizeIsOK itemLineValue=");
      ((StringBuilder)localObject1).append((String)paramString2.get(i));
      VideoEnvironment.LogDownLoad("PendantVersionManager", ((StringBuilder)localObject1).toString(), null);
      Object localObject2;
      int j;
      if (!TextUtils.isEmpty((CharSequence)paramString2.get(i)))
      {
        localObject2 = ((String)paramString2.get(i)).trim();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkUnzipFileListSizeIsOK trimValue=");
          ((StringBuilder)localObject1).append((String)localObject2);
          VideoEnvironment.LogDownLoad("PendantVersionManager", ((StringBuilder)localObject1).toString(), null);
          localObject1 = ShortVideoSoManager.a((String)localObject2);
          j = ((ShortVideoSoManager.CfgParser)localObject1).a('|');
          if (j != 0) {
            break label484;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append(((ShortVideoSoManager.CfgParser)localObject1).c());
          localObject2 = ((StringBuilder)localObject2).toString();
          File localFile = new File((String)localObject2);
          if (!localFile.exists())
          {
            paramString1 = new StringBuilder();
            paramString1.append("checkUnzipFileListSizeIsOK[exists=false] fileName=");
            paramString1.append((String)localObject2);
            VideoEnvironment.LogDownLoad("PendantVersionManager", paramString1.toString(), null);
            return false;
          }
          j = Integer.parseInt(((ShortVideoSoManager.CfgParser)localObject1).d());
          long l = localFile.length();
          if (j != l)
          {
            paramString1 = new StringBuilder();
            paramString1.append("checkUnzipFileListSizeIsOK sizeConfig=");
            paramString1.append(j);
            paramString1.append(",fileSize=");
            paramString1.append(l);
            VideoEnvironment.LogDownLoad("PendantVersionManager", paramString1.toString(), null);
            return false;
          }
        }
      }
      i += 1;
      continue;
      label484:
      paramString1 = new StringBuilder();
      paramString1.append("checkUnzipFileListSizeIsOK[CfgParser] errCode=");
      paramString1.append(j);
      paramString1.append(",trimValue=");
      paramString1.append((String)localObject2);
      VideoEnvironment.LogDownLoad("PendantVersionManager", paramString1.toString(), null);
      return false;
    }
    VideoEnvironment.LogDownLoad("PendantVersionManager", "checkUnzipFileListSizeIsOK[OK]", null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PendantVersionManager
 * JD-Core Version:    0.7.0.1
 */