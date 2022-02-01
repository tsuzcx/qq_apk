package com.tencent.weseevideo.editor.sticker.music.lyric.parse.parser;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.LyricCharacter;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QrcNoDecryptParserWOEmptyLine
  implements IParser
{
  private static final String OFFSET_TAG = "offset";
  private static final String QRC_XML_END = "/>";
  private static final String QRC_XML_KEY = "LyricContent";
  private static final String QRC_XML_LINK = "=";
  private static final String QRC_XML_MARK = "\"";
  public static final String TAG = "QrcNoDecParWEmptyLine";
  private static final QrcNoDecryptParserWOEmptyLine.LyricComparator mLineComparator = new QrcNoDecryptParserWOEmptyLine.LyricComparator(null);
  private static final Pattern mPattern = Pattern.compile("(?<=\\[).*?(?=\\])");
  private static final Pattern mPatternForQrc = Pattern.compile("(?<=\\()-?[0-9]*,-?[0-9]*(?=\\))");
  private ArrayList<Sentence> mLineLyricList = new ArrayList();
  private int mOffset;
  private String mString;
  
  private int parseOffset(String paramString)
  {
    paramString = paramString.split("\\:");
    try
    {
      if ((paramString.length == 2) && ("offset".equalsIgnoreCase(paramString[0])))
      {
        int i = Integer.parseInt(paramString[1].trim());
        return i;
      }
    }
    catch (Exception paramString)
    {
      Log.e("QrcNoDecParWEmptyLine", paramString.toString());
    }
    return 0;
  }
  
  private void parseQrcLine(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      Matcher localMatcher = mPattern.matcher(paramString);
      Object localObject3 = new ArrayList();
      int i = -1;
      Object localObject2;
      Object localObject1;
      int k;
      for (int j = -1; localMatcher.find(); j = k)
      {
        localObject2 = localMatcher.group();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        k = paramString.indexOf(((StringBuilder)localObject2).toString());
        if ((j != -1) && (k - j > i + 2))
        {
          localObject2 = paramString.substring(j + i + 2, k);
          Iterator localIterator = ((ArrayList)localObject3).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            Sentence localSentence = new Sentence();
            if (parseTimeForQrc(str, localSentence) != -1L)
            {
              parseQrcWord((String)localObject2, localSentence);
              this.mLineLyricList.add(localSentence);
            }
          }
          ((ArrayList)localObject3).clear();
        }
        ((ArrayList)localObject3).add(localObject1);
        i = ((String)localObject1).length();
      }
      if (((ArrayList)localObject3).isEmpty()) {
        return;
      }
      j = i + 2 + j;
      i = j;
      try
      {
        if (j > paramString.length()) {
          i = paramString.length();
        }
        paramString = paramString.substring(i).trim();
        if ((paramString.length() == 0) && (this.mOffset == 0)) {
          paramString = ((ArrayList)localObject3).iterator();
        }
        while (paramString.hasNext())
        {
          i = parseOffset((String)paramString.next());
          if (i != 2147483647)
          {
            this.mOffset = i;
            return;
            localObject1 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              localObject3 = new Sentence();
              if (parseTimeForQrc((String)localObject2, (Sentence)localObject3) != -1L)
              {
                parseQrcWord(paramString, (Sentence)localObject3);
                this.mLineLyricList.add(localObject3);
              }
            }
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        Log.e("QrcNoDecParWEmptyLine", paramString.toString());
      }
    }
  }
  
  private void parseQrcWord(String paramString, Sentence paramSentence)
  {
    try
    {
      paramSentence.mText = "";
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          return;
        }
        Matcher localMatcher = mPatternForQrc.matcher(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = paramString;
        while (localMatcher.find())
        {
          Object localObject2 = localMatcher.group();
          paramString = (String)localObject2;
          if (localObject2 == null) {
            paramString = "";
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("(");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(")");
          int i = ((String)localObject1).indexOf(((StringBuilder)localObject2).toString());
          int j = localStringBuilder.length();
          localStringBuilder.append(((String)localObject1).substring(0, i));
          localObject2 = ((String)localObject1).substring(i + paramString.length() + 2, ((String)localObject1).length());
          localObject1 = null;
          if (localArrayList.size() > 0) {
            localObject1 = (LyricCharacter)localArrayList.get(localArrayList.size() - 1);
          }
          paramString = parseWordTimeForQrc(paramString, j, localStringBuilder.length(), (LyricCharacter)localObject1);
          localObject1 = localObject2;
          if (paramString != null)
          {
            localArrayList.add(paramString);
            localObject1 = localObject2;
          }
        }
        paramSentence.mText = localStringBuilder.toString();
        paramSentence.mCharacters = localArrayList;
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.e("QrcNoDecParWEmptyLine", "", paramString);
    }
  }
  
  private long parseTimeForQrc(String paramString, Sentence paramSentence)
  {
    String[] arrayOfString = paramString.split("\\,");
    if (arrayOfString.length < 2)
    {
      paramString = paramString.split("\\:");
      if ((this.mOffset == 0) && (paramString[0].equalsIgnoreCase("offset"))) {
        this.mOffset = Integer.parseInt(paramString[1]);
      }
      return -1L;
    }
    if (arrayOfString.length == 2) {}
    try
    {
      long l1 = Long.parseLong(arrayOfString[1]);
      long l2 = Long.parseLong(arrayOfString[0]);
      paramSentence.mDuration = l1;
      paramSentence.mStartTime = l2;
      return l2;
    }
    catch (Exception paramString) {}
    return -1L;
    return -1L;
  }
  
  private LyricCharacter parseWordTimeForQrc(String paramString, int paramInt1, int paramInt2, LyricCharacter paramLyricCharacter)
  {
    paramString = paramString.split("\\,");
    if (paramString.length < 2) {
      return null;
    }
    if (paramString.length == 2)
    {
      long l1 = Long.parseLong(paramString[1]);
      long l2 = Long.parseLong(paramString[0]);
      if (l1 < 0L) {
        l1 = 0L;
      }
      if (l2 < 0L) {
        l2 = 0L;
      }
      return new LyricCharacter(l2, l1, paramInt1, paramInt2);
    }
    return null;
  }
  
  public void init(@NonNull String paramString)
  {
    this.mString = paramString;
  }
  
  /* Error */
  public com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric parse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 235	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/QrcNoDecryptParserWOEmptyLine:mString	Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +371 -> 377
    //   9: aload_3
    //   10: ldc 16
    //   12: invokevirtual 244	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +13 -> 28
    //   18: aload_3
    //   19: ldc 16
    //   21: invokevirtual 138	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   24: istore_1
    //   25: goto +5 -> 30
    //   28: iconst_m1
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_m1
    //   32: if_icmpeq +345 -> 377
    //   35: aload_3
    //   36: invokevirtual 108	java/lang/String:length	()I
    //   39: istore_2
    //   40: iload_1
    //   41: bipush 12
    //   43: iadd
    //   44: istore_1
    //   45: iload_2
    //   46: iload_1
    //   47: iconst_1
    //   48: iadd
    //   49: if_icmple +328 -> 377
    //   52: aload_3
    //   53: iload_1
    //   54: invokevirtual 181	java/lang/String:substring	(I)Ljava/lang/String;
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   62: ldc 19
    //   64: invokevirtual 247	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   67: ifne +5 -> 72
    //   70: aconst_null
    //   71: areturn
    //   72: aload_3
    //   73: aload_3
    //   74: ldc 19
    //   76: invokevirtual 138	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   79: iconst_1
    //   80: iadd
    //   81: invokevirtual 181	java/lang/String:substring	(I)Ljava/lang/String;
    //   84: astore_3
    //   85: aload_3
    //   86: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   89: ldc 22
    //   91: invokevirtual 247	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   94: ifne +5 -> 99
    //   97: aconst_null
    //   98: areturn
    //   99: aload_3
    //   100: aload_3
    //   101: ldc 22
    //   103: invokevirtual 138	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   106: iconst_1
    //   107: iadd
    //   108: invokevirtual 181	java/lang/String:substring	(I)Ljava/lang/String;
    //   111: astore_3
    //   112: aload_3
    //   113: ldc 13
    //   115: invokevirtual 244	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   118: ifeq +13 -> 131
    //   121: aload_3
    //   122: ldc 13
    //   124: invokevirtual 250	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   127: istore_1
    //   128: goto +5 -> 133
    //   131: iconst_m1
    //   132: istore_1
    //   133: iload_1
    //   134: iconst_m1
    //   135: if_icmpne +5 -> 140
    //   138: aconst_null
    //   139: areturn
    //   140: aload_3
    //   141: iconst_0
    //   142: iload_1
    //   143: invokevirtual 142	java/lang/String:substring	(II)Ljava/lang/String;
    //   146: astore_3
    //   147: aload_3
    //   148: ldc 22
    //   150: invokevirtual 244	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   153: ifeq +13 -> 166
    //   156: aload_3
    //   157: ldc 22
    //   159: invokevirtual 250	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   162: istore_1
    //   163: goto +5 -> 168
    //   166: iconst_m1
    //   167: istore_1
    //   168: iload_1
    //   169: iconst_m1
    //   170: if_icmpne +5 -> 175
    //   173: aconst_null
    //   174: areturn
    //   175: aload_3
    //   176: iconst_0
    //   177: iload_1
    //   178: invokevirtual 142	java/lang/String:substring	(II)Ljava/lang/String;
    //   181: astore_3
    //   182: new 252	java/io/BufferedReader
    //   185: dup
    //   186: new 254	java/io/StringReader
    //   189: dup
    //   190: aload_3
    //   191: invokespecial 256	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   194: invokespecial 259	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   197: astore 4
    //   199: aload 4
    //   201: astore_3
    //   202: aload 4
    //   204: invokevirtual 262	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   207: astore 5
    //   209: aload 5
    //   211: ifnull +18 -> 229
    //   214: aload 4
    //   216: astore_3
    //   217: aload_0
    //   218: aload 5
    //   220: invokevirtual 88	java/lang/String:trim	()Ljava/lang/String;
    //   223: invokespecial 264	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/QrcNoDecryptParserWOEmptyLine:parseQrcLine	(Ljava/lang/String;)V
    //   226: goto -27 -> 199
    //   229: aload 4
    //   231: astore_3
    //   232: aload_0
    //   233: getfield 68	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/QrcNoDecryptParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   236: getstatic 60	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/QrcNoDecryptParserWOEmptyLine:mLineComparator	Lcom/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/QrcNoDecryptParserWOEmptyLine$LyricComparator;
    //   239: invokestatic 270	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   242: aload 4
    //   244: astore_3
    //   245: new 272	com/tencent/weseevideo/editor/sticker/music/lyric/data/Lyric
    //   248: dup
    //   249: iconst_2
    //   250: aload_0
    //   251: getfield 183	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/QrcNoDecryptParserWOEmptyLine:mOffset	I
    //   254: aload_0
    //   255: getfield 68	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/QrcNoDecryptParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   258: invokespecial 275	com/tencent/weseevideo/editor/sticker/music/lyric/data/Lyric:<init>	(IILjava/util/ArrayList;)V
    //   261: astore 5
    //   263: aload 4
    //   265: invokevirtual 278	java/io/BufferedReader:close	()V
    //   268: aload 5
    //   270: areturn
    //   271: astore_3
    //   272: ldc 25
    //   274: aload_3
    //   275: invokevirtual 279	java/io/IOException:toString	()Ljava/lang/String;
    //   278: invokestatic 102	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   281: pop
    //   282: aload 5
    //   284: areturn
    //   285: astore 5
    //   287: goto +15 -> 302
    //   290: astore_3
    //   291: aconst_null
    //   292: astore 4
    //   294: goto +55 -> 349
    //   297: astore 5
    //   299: aconst_null
    //   300: astore 4
    //   302: aload 4
    //   304: astore_3
    //   305: ldc 25
    //   307: aload 5
    //   309: invokevirtual 96	java/lang/Exception:toString	()Ljava/lang/String;
    //   312: invokestatic 102	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   315: pop
    //   316: aload 4
    //   318: ifnull +59 -> 377
    //   321: aload 4
    //   323: invokevirtual 278	java/io/BufferedReader:close	()V
    //   326: aconst_null
    //   327: areturn
    //   328: astore_3
    //   329: ldc 25
    //   331: aload_3
    //   332: invokevirtual 279	java/io/IOException:toString	()Ljava/lang/String;
    //   335: invokestatic 102	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   338: pop
    //   339: aconst_null
    //   340: areturn
    //   341: astore 5
    //   343: aload_3
    //   344: astore 4
    //   346: aload 5
    //   348: astore_3
    //   349: aload 4
    //   351: ifnull +24 -> 375
    //   354: aload 4
    //   356: invokevirtual 278	java/io/BufferedReader:close	()V
    //   359: goto +16 -> 375
    //   362: astore 4
    //   364: ldc 25
    //   366: aload 4
    //   368: invokevirtual 279	java/io/IOException:toString	()Ljava/lang/String;
    //   371: invokestatic 102	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   374: pop
    //   375: aload_3
    //   376: athrow
    //   377: aconst_null
    //   378: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	QrcNoDecryptParserWOEmptyLine
    //   24	154	1	i	int
    //   39	11	2	j	int
    //   4	241	3	localObject1	Object
    //   271	4	3	localIOException1	java.io.IOException
    //   290	1	3	localObject2	Object
    //   304	1	3	localObject3	Object
    //   328	16	3	localIOException2	java.io.IOException
    //   348	28	3	localObject4	Object
    //   197	158	4	localObject5	Object
    //   362	5	4	localIOException3	java.io.IOException
    //   207	76	5	localObject6	Object
    //   285	1	5	localException1	Exception
    //   297	11	5	localException2	Exception
    //   341	6	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   263	268	271	java/io/IOException
    //   202	209	285	java/lang/Exception
    //   217	226	285	java/lang/Exception
    //   232	242	285	java/lang/Exception
    //   245	263	285	java/lang/Exception
    //   182	199	290	finally
    //   182	199	297	java/lang/Exception
    //   321	326	328	java/io/IOException
    //   202	209	341	finally
    //   217	226	341	finally
    //   232	242	341	finally
    //   245	263	341	finally
    //   305	316	341	finally
    //   354	359	362	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.parse.parser.QrcNoDecryptParserWOEmptyLine
 * JD-Core Version:    0.7.0.1
 */