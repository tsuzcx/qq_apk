package com.tencent.raft.codegenmeta.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils
{
  public static final String TAG = "FileUtils";
  
  public static List<Pair<String, String>> analyzeIndexFile(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = new File(paramString1);
    try
    {
      if ((paramString1.isFile()) && (paramString1.exists()))
      {
        paramString1 = new InputStreamReader(new FileInputStream(paramString1));
        BufferedReader localBufferedReader = new BufferedReader(paramString1);
        for (;;)
        {
          Object localObject1 = localBufferedReader.readLine();
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((String)localObject1).split(":");
          if (localObject1.length == 2)
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramString2);
            ((StringBuilder)localObject2).append(File.separator);
            ((StringBuilder)localObject2).append(localObject1[1]);
            localObject2 = ((StringBuilder)localObject2).toString();
            localArrayList.add(new Pair(localObject1[0], localObject2));
          }
        }
        localBufferedReader.close();
        paramString1.close();
        return localArrayList;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("analyzeIndexFile error: ");
      paramString2.append(paramString1);
      RLog.d("FileUtils", new Object[] { paramString2.toString() });
    }
    return localArrayList;
  }
  
  public static boolean deleteFile(File paramFile)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      if (arrayOfString == null) {
        return true;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (!deleteFile(new File(paramFile, arrayOfString[i]))) {
          return false;
        }
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  /* Error */
  public static void writeToIndexFile(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 8
    //   12: new 22	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 10
    //   22: new 123	java/io/FileOutputStream
    //   25: dup
    //   26: aload 10
    //   28: iconst_1
    //   29: invokespecial 126	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   32: invokevirtual 130	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   35: astore 7
    //   37: aload 8
    //   39: astore 6
    //   41: aload 7
    //   43: astore 5
    //   45: aload 9
    //   47: astore_0
    //   48: aload 7
    //   50: astore 4
    //   52: new 132	java/io/RandomAccessFile
    //   55: dup
    //   56: aload 10
    //   58: ldc 134
    //   60: invokespecial 135	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore 10
    //   65: aload 8
    //   67: astore 6
    //   69: aload 7
    //   71: astore 5
    //   73: aload 9
    //   75: astore_0
    //   76: aload 7
    //   78: astore 4
    //   80: aload 10
    //   82: aload 10
    //   84: invokevirtual 139	java/io/RandomAccessFile:length	()J
    //   87: invokevirtual 143	java/io/RandomAccessFile:seek	(J)V
    //   90: aload 8
    //   92: astore 6
    //   94: aload 7
    //   96: astore 5
    //   98: aload 9
    //   100: astore_0
    //   101: aload 7
    //   103: astore 4
    //   105: aload 10
    //   107: invokevirtual 144	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   110: astore 7
    //   112: aload 8
    //   114: astore 6
    //   116: aload 7
    //   118: astore 5
    //   120: aload 9
    //   122: astore_0
    //   123: aload 7
    //   125: astore 4
    //   127: aload 7
    //   129: invokevirtual 150	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   132: astore 8
    //   134: aload 8
    //   136: astore 6
    //   138: aload 7
    //   140: astore 5
    //   142: aload 8
    //   144: astore_0
    //   145: aload 7
    //   147: astore 4
    //   149: aload_2
    //   150: aload_3
    //   151: ldc 152
    //   153: invokevirtual 156	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   156: astore_2
    //   157: aload 8
    //   159: astore 6
    //   161: aload 7
    //   163: astore 5
    //   165: aload 8
    //   167: astore_0
    //   168: aload 7
    //   170: astore 4
    //   172: new 61	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   179: astore_3
    //   180: aload 8
    //   182: astore 6
    //   184: aload 7
    //   186: astore 5
    //   188: aload 8
    //   190: astore_0
    //   191: aload 7
    //   193: astore 4
    //   195: aload_3
    //   196: aload_1
    //   197: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 8
    //   203: astore 6
    //   205: aload 7
    //   207: astore 5
    //   209: aload 8
    //   211: astore_0
    //   212: aload 7
    //   214: astore 4
    //   216: aload_3
    //   217: ldc 53
    //   219: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 8
    //   225: astore 6
    //   227: aload 7
    //   229: astore 5
    //   231: aload 8
    //   233: astore_0
    //   234: aload 7
    //   236: astore 4
    //   238: aload_3
    //   239: aload_2
    //   240: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 8
    //   246: astore 6
    //   248: aload 7
    //   250: astore 5
    //   252: aload 8
    //   254: astore_0
    //   255: aload 7
    //   257: astore 4
    //   259: aload_3
    //   260: ldc 158
    //   262: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 8
    //   268: astore 6
    //   270: aload 7
    //   272: astore 5
    //   274: aload 8
    //   276: astore_0
    //   277: aload 7
    //   279: astore 4
    //   281: aload 7
    //   283: aload_3
    //   284: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokevirtual 162	java/lang/String:getBytes	()[B
    //   290: invokestatic 168	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   293: invokevirtual 172	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   296: pop
    //   297: aload 8
    //   299: ifnull +16 -> 315
    //   302: aload 8
    //   304: invokevirtual 177	java/nio/channels/FileLock:release	()V
    //   307: goto +8 -> 315
    //   310: astore_0
    //   311: aload_0
    //   312: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   315: aload 7
    //   317: ifnull +74 -> 391
    //   320: aload 7
    //   322: invokevirtual 181	java/nio/channels/FileChannel:close	()V
    //   325: return
    //   326: astore_1
    //   327: goto +19 -> 346
    //   330: astore_1
    //   331: aconst_null
    //   332: astore_2
    //   333: aload 4
    //   335: astore_0
    //   336: aload_2
    //   337: astore 4
    //   339: goto +54 -> 393
    //   342: astore_1
    //   343: aconst_null
    //   344: astore 5
    //   346: aload 6
    //   348: astore_0
    //   349: aload 5
    //   351: astore 4
    //   353: aload_1
    //   354: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   357: aload 6
    //   359: ifnull +16 -> 375
    //   362: aload 6
    //   364: invokevirtual 177	java/nio/channels/FileLock:release	()V
    //   367: goto +8 -> 375
    //   370: astore_0
    //   371: aload_0
    //   372: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   375: aload 5
    //   377: ifnull +14 -> 391
    //   380: aload 5
    //   382: invokevirtual 181	java/nio/channels/FileChannel:close	()V
    //   385: return
    //   386: astore_0
    //   387: aload_0
    //   388: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   391: return
    //   392: astore_1
    //   393: aload_0
    //   394: ifnull +15 -> 409
    //   397: aload_0
    //   398: invokevirtual 177	java/nio/channels/FileLock:release	()V
    //   401: goto +8 -> 409
    //   404: astore_0
    //   405: aload_0
    //   406: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   409: aload 4
    //   411: ifnull +16 -> 427
    //   414: aload 4
    //   416: invokevirtual 181	java/nio/channels/FileChannel:close	()V
    //   419: goto +8 -> 427
    //   422: astore_0
    //   423: aload_0
    //   424: invokevirtual 180	java/io/IOException:printStackTrace	()V
    //   427: aload_1
    //   428: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramString1	String
    //   0	429	1	paramString2	String
    //   0	429	2	paramString3	String
    //   0	429	3	paramString4	String
    //   7	408	4	localObject1	Object
    //   43	338	5	localFileChannel1	java.nio.channels.FileChannel
    //   1	362	6	localObject2	Object
    //   35	286	7	localFileChannel2	java.nio.channels.FileChannel
    //   10	293	8	localFileLock	java.nio.channels.FileLock
    //   4	117	9	localObject3	Object
    //   20	86	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   302	307	310	java/io/IOException
    //   52	65	326	java/io/IOException
    //   80	90	326	java/io/IOException
    //   105	112	326	java/io/IOException
    //   127	134	326	java/io/IOException
    //   149	157	326	java/io/IOException
    //   172	180	326	java/io/IOException
    //   195	201	326	java/io/IOException
    //   216	223	326	java/io/IOException
    //   238	244	326	java/io/IOException
    //   259	266	326	java/io/IOException
    //   281	297	326	java/io/IOException
    //   12	37	330	finally
    //   12	37	342	java/io/IOException
    //   362	367	370	java/io/IOException
    //   320	325	386	java/io/IOException
    //   380	385	386	java/io/IOException
    //   52	65	392	finally
    //   80	90	392	finally
    //   105	112	392	finally
    //   127	134	392	finally
    //   149	157	392	finally
    //   172	180	392	finally
    //   195	201	392	finally
    //   216	223	392	finally
    //   238	244	392	finally
    //   259	266	392	finally
    //   281	297	392	finally
    //   353	357	392	finally
    //   397	401	404	java/io/IOException
    //   414	419	422	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */