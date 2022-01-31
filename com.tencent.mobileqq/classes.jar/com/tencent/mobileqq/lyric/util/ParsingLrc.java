package com.tencent.mobileqq.lyric.util;

import adpm;
import android.util.Log;
import com.tencent.mobileqq.lyric.data.Sentence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingLrc
{
  private static final adpm jdField_a_of_type_Adpm = new adpm(null);
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("(?<=\\[).*?(?=\\])");
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ParsingLrc(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private int a(String paramString)
  {
    int j = 0;
    paramString = paramString.split("\\:");
    int i = j;
    try
    {
      if (paramString.length == 2)
      {
        i = j;
        if ("offset".equalsIgnoreCase(paramString[0])) {
          i = Integer.parseInt(paramString[1].trim());
        }
      }
      return i;
    }
    catch (Exception paramString)
    {
      Log.e("ParsingLrc", paramString.toString());
    }
    return 0;
  }
  
  private long a(String paramString)
  {
    paramString = paramString.split("\\:|\\.");
    if (paramString.length < 2) {}
    do
    {
      return -1L;
      if (paramString.length == 2) {}
      int i;
      int j;
      int k;
      try
      {
        if ((this.jdField_a_of_type_Int == 0) && (paramString[0].equalsIgnoreCase("offset")))
        {
          this.jdField_a_of_type_Int = Integer.parseInt(paramString[1]);
          return -1L;
        }
        i = Integer.parseInt(paramString[0]);
        j = Integer.parseInt(paramString[1]);
        if ((i < 0) || (j < 0) || (j >= 60)) {
          throw new RuntimeException("数字不合法!");
        }
        return (i * 60 + j) * 1000L;
      }
      catch (Exception paramString) {}
    } while (paramString.length != 3);
    try
    {
      i = Integer.parseInt(paramString[0]);
      j = Integer.parseInt(paramString[1]);
      k = Integer.parseInt(paramString[2]);
      if ((i < 0) || (j < 0) || (j >= 60) || (k < 0) || (k > 99)) {
        throw new RuntimeException("数字不合法!");
      }
    }
    catch (Exception paramString)
    {
      return -1L;
    }
    return (i * 60 + j) * 1000L + k * 10;
    return -1L;
  }
  
  private void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    Object localObject2 = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    int i = -1;
    int j = -1;
    label36:
    Object localObject1;
    if (((Matcher)localObject2).find())
    {
      localObject1 = ((Matcher)localObject2).group();
      if (localObject1 != null) {
        break label455;
      }
      localObject1 = "";
    }
    label455:
    for (;;)
    {
      for (;;)
      {
        int k = paramString.indexOf("[" + (String)localObject1 + "]");
        long l;
        if ((j != -1) && (k - j > i + 2))
        {
          String str = paramString.substring(i + j + 2, k);
          Iterator localIterator = localArrayList.iterator();
          while (localIterator.hasNext())
          {
            l = a((String)localIterator.next());
            if (l != -1L)
            {
              Sentence localSentence = new Sentence();
              localSentence.jdField_a_of_type_JavaLangString = str;
              localSentence.jdField_a_of_type_Long = l;
              this.jdField_a_of_type_JavaUtilArrayList.add(localSentence);
            }
          }
          localArrayList.clear();
        }
        localArrayList.add(localObject1);
        i = ((String)localObject1).length();
        j = k;
        break label36;
        if (localArrayList.isEmpty()) {
          break;
        }
        j = i + 2 + j;
        i = j;
        try
        {
          if (j > paramString.length()) {
            i = paramString.length();
          }
          paramString = paramString.substring(i).trim();
          if ((paramString.length() == 0) && (this.jdField_a_of_type_Int == 0))
          {
            paramString = localArrayList.iterator();
            while (paramString.hasNext())
            {
              i = a((String)paramString.next());
              if (i != 2147483647) {
                this.jdField_a_of_type_Int = i;
              }
            }
            return;
          }
          localObject1 = localArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            l = a((String)((Iterator)localObject1).next());
            if ((l != -1L) && (paramString.length() > 0))
            {
              localObject2 = new Sentence();
              ((Sentence)localObject2).jdField_a_of_type_JavaLangString = paramString;
              ((Sentence)localObject2).jdField_a_of_type_Long = l;
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
        }
        catch (Exception paramString)
        {
          Log.e("ParsingLrc", paramString.toString());
          return;
          return;
        }
        finally
        {
          if (localArrayList != null) {
            localArrayList.clear();
          }
        }
      }
    }
  }
  
  /* Error */
  public com.tencent.mobileqq.lyric.data.Lyric a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: ifnonnull +7 -> 11
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_3
    //   10: areturn
    //   11: aload_0
    //   12: getfield 41	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +69 -> 86
    //   20: new 177	java/io/BufferedReader
    //   23: dup
    //   24: new 179	java/io/StringReader
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 180	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 183	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore 4
    //   37: aload 4
    //   39: invokevirtual 186	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +44 -> 88
    //   47: aload_0
    //   48: aload_3
    //   49: invokevirtual 62	java/lang/String:trim	()Ljava/lang/String;
    //   52: invokespecial 188	com/tencent/mobileqq/lyric/util/ParsingLrc:a	(Ljava/lang/String;)V
    //   55: goto -18 -> 37
    //   58: astore 5
    //   60: aload 4
    //   62: astore_3
    //   63: aload 5
    //   65: astore 4
    //   67: ldc 69
    //   69: aload 4
    //   71: invokevirtual 72	java/lang/Exception:toString	()Ljava/lang/String;
    //   74: invokestatic 78	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   77: pop
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 191	java/io/BufferedReader:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: aload_0
    //   89: getfield 39	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   92: getstatic 30	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_Adpm	Ladpm;
    //   95: invokestatic 197	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   98: iconst_0
    //   99: istore_2
    //   100: iload_2
    //   101: aload_0
    //   102: getfield 39	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   105: invokevirtual 200	java/util/ArrayList:size	()I
    //   108: if_icmpge +97 -> 205
    //   111: iload_2
    //   112: aload_0
    //   113: getfield 39	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   116: invokevirtual 200	java/util/ArrayList:size	()I
    //   119: iconst_1
    //   120: isub
    //   121: if_icmpge +51 -> 172
    //   124: aload_0
    //   125: getfield 39	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   128: iload_2
    //   129: invokevirtual 204	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   132: checkcast 148	com/tencent/mobileqq/lyric/data/Sentence
    //   135: aload_0
    //   136: getfield 39	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   139: iload_2
    //   140: iconst_1
    //   141: iadd
    //   142: invokevirtual 204	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   145: checkcast 148	com/tencent/mobileqq/lyric/data/Sentence
    //   148: getfield 153	com/tencent/mobileqq/lyric/data/Sentence:jdField_a_of_type_Long	J
    //   151: aload_0
    //   152: getfield 39	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   155: iload_2
    //   156: invokevirtual 204	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   159: checkcast 148	com/tencent/mobileqq/lyric/data/Sentence
    //   162: getfield 153	com/tencent/mobileqq/lyric/data/Sentence:jdField_a_of_type_Long	J
    //   165: lsub
    //   166: putfield 207	com/tencent/mobileqq/lyric/data/Sentence:b	J
    //   169: goto +139 -> 308
    //   172: aload_0
    //   173: getfield 39	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   176: iload_2
    //   177: invokevirtual 204	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   180: checkcast 148	com/tencent/mobileqq/lyric/data/Sentence
    //   183: ldc2_w 208
    //   186: putfield 207	com/tencent/mobileqq/lyric/data/Sentence:b	J
    //   189: goto +119 -> 308
    //   192: astore_3
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 191	java/io/BufferedReader:close	()V
    //   203: aload_3
    //   204: athrow
    //   205: new 211	com/tencent/mobileqq/lyric/data/Lyric
    //   208: dup
    //   209: iconst_1
    //   210: aload_0
    //   211: getfield 85	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_Int	I
    //   214: aload_0
    //   215: getfield 39	com/tencent/mobileqq/lyric/util/ParsingLrc:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   218: invokespecial 214	com/tencent/mobileqq/lyric/data/Lyric:<init>	(IILjava/util/ArrayList;)V
    //   221: astore 5
    //   223: aload 5
    //   225: astore_3
    //   226: aload 4
    //   228: ifnull -219 -> 9
    //   231: aload 4
    //   233: invokevirtual 191	java/io/BufferedReader:close	()V
    //   236: aload 5
    //   238: areturn
    //   239: astore_3
    //   240: ldc 69
    //   242: aload_3
    //   243: invokevirtual 215	java/io/IOException:toString	()Ljava/lang/String;
    //   246: invokestatic 78	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   249: pop
    //   250: aload 5
    //   252: areturn
    //   253: astore_3
    //   254: ldc 69
    //   256: aload_3
    //   257: invokevirtual 215	java/io/IOException:toString	()Ljava/lang/String;
    //   260: invokestatic 78	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   263: pop
    //   264: goto -178 -> 86
    //   267: astore 4
    //   269: ldc 69
    //   271: aload 4
    //   273: invokevirtual 215	java/io/IOException:toString	()Ljava/lang/String;
    //   276: invokestatic 78	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   279: pop
    //   280: goto -77 -> 203
    //   283: astore_3
    //   284: aconst_null
    //   285: astore 4
    //   287: goto -94 -> 193
    //   290: astore 5
    //   292: aload_3
    //   293: astore 4
    //   295: aload 5
    //   297: astore_3
    //   298: goto -105 -> 193
    //   301: astore 4
    //   303: aconst_null
    //   304: astore_3
    //   305: goto -238 -> 67
    //   308: iload_2
    //   309: iconst_1
    //   310: iadd
    //   311: istore_2
    //   312: goto -212 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	ParsingLrc
    //   0	315	1	paramBoolean	boolean
    //   99	213	2	i	int
    //   8	75	3	localObject1	Object
    //   192	12	3	localObject2	Object
    //   225	1	3	localObject3	Object
    //   239	4	3	localIOException1	java.io.IOException
    //   253	4	3	localIOException2	java.io.IOException
    //   283	10	3	localObject4	Object
    //   297	8	3	localObject5	Object
    //   35	197	4	localObject6	Object
    //   267	5	4	localIOException3	java.io.IOException
    //   285	9	4	localObject7	Object
    //   301	1	4	localException1	Exception
    //   58	6	5	localException2	Exception
    //   221	30	5	localLyric	com.tencent.mobileqq.lyric.data.Lyric
    //   290	6	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   37	43	58	java/lang/Exception
    //   47	55	58	java/lang/Exception
    //   88	98	58	java/lang/Exception
    //   100	169	58	java/lang/Exception
    //   172	189	58	java/lang/Exception
    //   205	223	58	java/lang/Exception
    //   37	43	192	finally
    //   47	55	192	finally
    //   88	98	192	finally
    //   100	169	192	finally
    //   172	189	192	finally
    //   205	223	192	finally
    //   231	236	239	java/io/IOException
    //   82	86	253	java/io/IOException
    //   198	203	267	java/io/IOException
    //   20	37	283	finally
    //   67	78	290	finally
    //   20	37	301	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.util.ParsingLrc
 * JD-Core Version:    0.7.0.1
 */