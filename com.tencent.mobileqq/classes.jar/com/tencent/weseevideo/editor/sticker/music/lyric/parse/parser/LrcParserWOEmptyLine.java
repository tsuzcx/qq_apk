package com.tencent.weseevideo.editor.sticker.music.lyric.parse.parser;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LrcParserWOEmptyLine
  implements IParser
{
  private static final String OFFSET_TAG = "offset";
  public static final String TAG = "LrcParserWOEmptyLine";
  private static final LrcParserWOEmptyLine.LyricComparator mLineComparator = new LrcParserWOEmptyLine.LyricComparator(null);
  private static final Pattern mPattern = Pattern.compile("(?<=\\[).*?(?=\\])");
  private ArrayList<Sentence> mLineLyricList = new ArrayList();
  private int mOffset;
  private String mString;
  
  private void parseLine(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    Object localObject2 = mPattern.matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    int i = -1;
    int j = -1;
    label34:
    Object localObject1;
    if (((Matcher)localObject2).find())
    {
      localObject1 = ((Matcher)localObject2).group();
      if (localObject1 != null) {
        break label453;
      }
      localObject1 = "";
    }
    label453:
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
            l = parseTime((String)localIterator.next());
            if (l != -1L)
            {
              Sentence localSentence = new Sentence();
              localSentence.mText = str;
              localSentence.mStartTime = l;
              this.mLineLyricList.add(localSentence);
            }
          }
          localArrayList.clear();
        }
        localArrayList.add(localObject1);
        i = ((String)localObject1).length();
        j = k;
        break label34;
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
          if ((paramString.length() == 0) && (this.mOffset == 0))
          {
            paramString = localArrayList.iterator();
            while (paramString.hasNext())
            {
              i = parseOffset((String)paramString.next());
              if (i != 2147483647) {
                this.mOffset = i;
              }
            }
            return;
          }
          localObject1 = localArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            l = parseTime((String)((Iterator)localObject1).next());
            if ((l != -1L) && (paramString.length() > 0))
            {
              localObject2 = new Sentence();
              ((Sentence)localObject2).mText = paramString;
              ((Sentence)localObject2).mStartTime = l;
              this.mLineLyricList.add(localObject2);
            }
          }
        }
        catch (Exception paramString)
        {
          Log.e("LrcParserWOEmptyLine", paramString.toString());
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
  
  private int parseOffset(String paramString)
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
      Log.e("LrcParserWOEmptyLine", paramString.toString());
    }
    return 0;
  }
  
  private long parseTime(String paramString)
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
        if ((this.mOffset == 0) && (paramString[0].equalsIgnoreCase("offset")))
        {
          this.mOffset = Integer.parseInt(paramString[1]);
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
      if ((i < 0) || (j < 0) || (j >= 60) || (k < 0) || (k > 999)) {
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
  
  public void init(@NonNull String paramString)
  {
    this.mString = paramString;
  }
  
  /* Error */
  public com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric parse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 186	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mString	Ljava/lang/String;
    //   4: astore_2
    //   5: new 193	java/io/BufferedReader
    //   8: dup
    //   9: new 195	java/io/StringReader
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 196	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 199	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 202	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +43 -> 70
    //   30: aload_0
    //   31: aload_2
    //   32: invokevirtual 144	java/lang/String:trim	()Ljava/lang/String;
    //   35: invokespecial 204	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:parseLine	(Ljava/lang/String;)V
    //   38: goto -17 -> 21
    //   41: astore 4
    //   43: aload_3
    //   44: astore_2
    //   45: aload 4
    //   47: astore_3
    //   48: ldc 13
    //   50: aload_3
    //   51: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   54: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   57: pop
    //   58: aload_2
    //   59: ifnull +7 -> 66
    //   62: aload_2
    //   63: invokevirtual 207	java/io/BufferedReader:close	()V
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_2
    //   69: areturn
    //   70: aload_0
    //   71: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   74: getstatic 43	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineComparator	Lcom/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine$LyricComparator;
    //   77: invokestatic 213	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   80: iconst_0
    //   81: istore_1
    //   82: iload_1
    //   83: aload_0
    //   84: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   87: invokevirtual 216	java/util/ArrayList:size	()I
    //   90: if_icmpge +95 -> 185
    //   93: iload_1
    //   94: aload_0
    //   95: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   98: invokevirtual 216	java/util/ArrayList:size	()I
    //   101: iconst_1
    //   102: isub
    //   103: if_icmpge +51 -> 154
    //   106: aload_0
    //   107: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   110: iload_1
    //   111: invokevirtual 220	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   114: checkcast 120	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   117: aload_0
    //   118: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   121: iload_1
    //   122: iconst_1
    //   123: iadd
    //   124: invokevirtual 220	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   127: checkcast 120	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   130: getfield 128	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mStartTime	J
    //   133: aload_0
    //   134: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   137: iload_1
    //   138: invokevirtual 220	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   141: checkcast 120	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   144: getfield 128	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mStartTime	J
    //   147: lsub
    //   148: putfield 223	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mDuration	J
    //   151: goto +130 -> 281
    //   154: aload_0
    //   155: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   158: iload_1
    //   159: invokevirtual 220	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   162: checkcast 120	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   165: ldc2_w 224
    //   168: putfield 223	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mDuration	J
    //   171: goto +110 -> 281
    //   174: astore_2
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 207	java/io/BufferedReader:close	()V
    //   183: aload_2
    //   184: athrow
    //   185: new 227	com/tencent/weseevideo/editor/sticker/music/lyric/data/Lyric
    //   188: dup
    //   189: iconst_1
    //   190: aload_0
    //   191: getfield 146	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mOffset	I
    //   194: aload_0
    //   195: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   198: invokespecial 230	com/tencent/weseevideo/editor/sticker/music/lyric/data/Lyric:<init>	(IILjava/util/ArrayList;)V
    //   201: astore 4
    //   203: aload 4
    //   205: astore_2
    //   206: aload_3
    //   207: ifnull -139 -> 68
    //   210: aload_3
    //   211: invokevirtual 207	java/io/BufferedReader:close	()V
    //   214: aload 4
    //   216: areturn
    //   217: astore_2
    //   218: ldc 13
    //   220: aload_2
    //   221: invokevirtual 231	java/io/IOException:toString	()Ljava/lang/String;
    //   224: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   227: pop
    //   228: aload 4
    //   230: areturn
    //   231: astore_2
    //   232: ldc 13
    //   234: aload_2
    //   235: invokevirtual 231	java/io/IOException:toString	()Ljava/lang/String;
    //   238: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   241: pop
    //   242: goto -176 -> 66
    //   245: astore_3
    //   246: ldc 13
    //   248: aload_3
    //   249: invokevirtual 231	java/io/IOException:toString	()Ljava/lang/String;
    //   252: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   255: pop
    //   256: goto -73 -> 183
    //   259: astore_2
    //   260: aconst_null
    //   261: astore_3
    //   262: goto -87 -> 175
    //   265: astore 4
    //   267: aload_2
    //   268: astore_3
    //   269: aload 4
    //   271: astore_2
    //   272: goto -97 -> 175
    //   275: astore_3
    //   276: aconst_null
    //   277: astore_2
    //   278: goto -230 -> 48
    //   281: iload_1
    //   282: iconst_1
    //   283: iadd
    //   284: istore_1
    //   285: goto -203 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	LrcParserWOEmptyLine
    //   81	204	1	i	int
    //   4	65	2	localObject1	Object
    //   174	10	2	localObject2	Object
    //   205	1	2	localObject3	Object
    //   217	4	2	localIOException1	java.io.IOException
    //   231	4	2	localIOException2	java.io.IOException
    //   259	9	2	localObject4	Object
    //   271	7	2	localObject5	Object
    //   20	191	3	localObject6	Object
    //   245	4	3	localIOException3	java.io.IOException
    //   261	8	3	localObject7	Object
    //   275	1	3	localException1	Exception
    //   41	5	4	localException2	Exception
    //   201	28	4	localLyric	com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric
    //   265	5	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   21	26	41	java/lang/Exception
    //   30	38	41	java/lang/Exception
    //   70	80	41	java/lang/Exception
    //   82	151	41	java/lang/Exception
    //   154	171	41	java/lang/Exception
    //   185	203	41	java/lang/Exception
    //   21	26	174	finally
    //   30	38	174	finally
    //   70	80	174	finally
    //   82	151	174	finally
    //   154	171	174	finally
    //   185	203	174	finally
    //   210	214	217	java/io/IOException
    //   62	66	231	java/io/IOException
    //   179	183	245	java/io/IOException
    //   5	21	259	finally
    //   48	58	265	finally
    //   5	21	275	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.parse.parser.LrcParserWOEmptyLine
 * JD-Core Version:    0.7.0.1
 */