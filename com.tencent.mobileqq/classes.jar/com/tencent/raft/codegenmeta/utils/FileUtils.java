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
    BufferedReader localBufferedReader;
    try
    {
      if ((paramString1.isFile()) && (paramString1.exists()))
      {
        paramString1 = new InputStreamReader(new FileInputStream(paramString1));
        localBufferedReader = new BufferedReader(paramString1);
        for (;;)
        {
          Object localObject = localBufferedReader.readLine();
          if (localObject == null) {
            break;
          }
          localObject = ((String)localObject).split(":");
          if (localObject.length == 2)
          {
            String str = paramString2 + File.separator + localObject[1];
            localArrayList.add(new Pair(localObject[0], str));
          }
        }
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      RLog.d("FileUtils", new Object[] { "analyzeIndexFile error: " + paramString1 });
    }
    localBufferedReader.close();
    paramString1.close();
    return localArrayList;
  }
  
  public static boolean deleteFile(File paramFile)
  {
    if (!paramFile.exists()) {}
    String[] arrayOfString;
    do
    {
      return true;
      if (!paramFile.isDirectory()) {
        break;
      }
      arrayOfString = paramFile.list();
    } while (arrayOfString == null);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (!deleteFile(new File(paramFile, arrayOfString[i]))) {
        return false;
      }
      i += 1;
    }
    return paramFile.delete();
  }
  
  /* Error */
  public static void writeToIndexFile(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 6
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
    //   39: astore 4
    //   41: aload 7
    //   43: astore_0
    //   44: aload 9
    //   46: astore 6
    //   48: aload 7
    //   50: astore 5
    //   52: new 132	java/io/RandomAccessFile
    //   55: dup
    //   56: aload 10
    //   58: ldc 134
    //   60: invokespecial 135	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore 10
    //   65: aload 8
    //   67: astore 4
    //   69: aload 7
    //   71: astore_0
    //   72: aload 9
    //   74: astore 6
    //   76: aload 7
    //   78: astore 5
    //   80: aload 10
    //   82: aload 10
    //   84: invokevirtual 139	java/io/RandomAccessFile:length	()J
    //   87: invokevirtual 143	java/io/RandomAccessFile:seek	(J)V
    //   90: aload 8
    //   92: astore 4
    //   94: aload 7
    //   96: astore_0
    //   97: aload 9
    //   99: astore 6
    //   101: aload 7
    //   103: astore 5
    //   105: aload 10
    //   107: invokevirtual 144	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   110: astore 7
    //   112: aload 8
    //   114: astore 4
    //   116: aload 7
    //   118: astore_0
    //   119: aload 9
    //   121: astore 6
    //   123: aload 7
    //   125: astore 5
    //   127: aload 7
    //   129: invokevirtual 150	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   132: astore 8
    //   134: aload 8
    //   136: astore 4
    //   138: aload 7
    //   140: astore_0
    //   141: aload 8
    //   143: astore 6
    //   145: aload 7
    //   147: astore 5
    //   149: aload_2
    //   150: aload_3
    //   151: ldc 152
    //   153: invokevirtual 156	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   156: astore_2
    //   157: aload 8
    //   159: astore 4
    //   161: aload 7
    //   163: astore_0
    //   164: aload 8
    //   166: astore 6
    //   168: aload 7
    //   170: astore 5
    //   172: aload 7
    //   174: new 61	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   181: aload_1
    //   182: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 53
    //   187: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_2
    //   191: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 158
    //   196: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokevirtual 162	java/lang/String:getBytes	()[B
    //   205: invokestatic 168	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   208: invokevirtual 172	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   211: pop
    //   212: aload 8
    //   214: ifnull +8 -> 222
    //   217: aload 8
    //   219: invokevirtual 177	java/nio/channels/FileLock:release	()V
    //   222: aload 7
    //   224: ifnull +8 -> 232
    //   227: aload 7
    //   229: invokevirtual 178	java/nio/channels/FileChannel:close	()V
    //   232: return
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   238: goto -16 -> 222
    //   241: astore_0
    //   242: aload_0
    //   243: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   246: return
    //   247: astore_1
    //   248: aconst_null
    //   249: astore 5
    //   251: aload 6
    //   253: astore 4
    //   255: aload 5
    //   257: astore_0
    //   258: aload_1
    //   259: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   262: aload 6
    //   264: ifnull +8 -> 272
    //   267: aload 6
    //   269: invokevirtual 177	java/nio/channels/FileLock:release	()V
    //   272: aload 5
    //   274: ifnull -42 -> 232
    //   277: aload 5
    //   279: invokevirtual 178	java/nio/channels/FileChannel:close	()V
    //   282: return
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   288: return
    //   289: astore_0
    //   290: aload_0
    //   291: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   294: goto -22 -> 272
    //   297: astore_1
    //   298: aconst_null
    //   299: astore_0
    //   300: aload 4
    //   302: ifnull +8 -> 310
    //   305: aload 4
    //   307: invokevirtual 177	java/nio/channels/FileLock:release	()V
    //   310: aload_0
    //   311: ifnull +7 -> 318
    //   314: aload_0
    //   315: invokevirtual 178	java/nio/channels/FileChannel:close	()V
    //   318: aload_1
    //   319: athrow
    //   320: astore_2
    //   321: aload_2
    //   322: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   325: goto -15 -> 310
    //   328: astore_0
    //   329: aload_0
    //   330: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   333: goto -15 -> 318
    //   336: astore_1
    //   337: goto -37 -> 300
    //   340: astore_1
    //   341: goto -90 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramString1	String
    //   0	344	1	paramString2	String
    //   0	344	2	paramString3	String
    //   0	344	3	paramString4	String
    //   1	305	4	localObject1	Object
    //   50	228	5	localFileChannel1	java.nio.channels.FileChannel
    //   10	258	6	localObject2	Object
    //   35	193	7	localFileChannel2	java.nio.channels.FileChannel
    //   4	214	8	localFileLock	java.nio.channels.FileLock
    //   7	113	9	localObject3	Object
    //   20	86	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   217	222	233	java/io/IOException
    //   227	232	241	java/io/IOException
    //   12	37	247	java/io/IOException
    //   277	282	283	java/io/IOException
    //   267	272	289	java/io/IOException
    //   12	37	297	finally
    //   305	310	320	java/io/IOException
    //   314	318	328	java/io/IOException
    //   52	65	336	finally
    //   80	90	336	finally
    //   105	112	336	finally
    //   127	134	336	finally
    //   149	157	336	finally
    //   172	212	336	finally
    //   258	262	336	finally
    //   52	65	340	java/io/IOException
    //   80	90	340	java/io/IOException
    //   105	112	340	java/io/IOException
    //   127	134	340	java/io/IOException
    //   149	157	340	java/io/IOException
    //   172	212	340	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */