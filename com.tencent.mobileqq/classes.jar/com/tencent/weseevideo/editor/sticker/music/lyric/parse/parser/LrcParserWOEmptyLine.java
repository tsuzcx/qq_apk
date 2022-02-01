package com.tencent.weseevideo.editor.sticker.music.lyric.parse.parser;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.util.ArrayList;
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
  
  /* Error */
  private void parseLine(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +447 -> 448
    //   4: aload_1
    //   5: invokevirtual 61	java/lang/String:length	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: getstatic 35	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mPattern	Ljava/util/regex/Pattern;
    //   15: aload_1
    //   16: invokevirtual 65	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   19: astore 10
    //   21: new 48	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 49	java/util/ArrayList:<init>	()V
    //   28: astore 9
    //   30: iconst_m1
    //   31: istore_2
    //   32: iconst_m1
    //   33: istore_3
    //   34: aload 10
    //   36: invokevirtual 71	java/util/regex/Matcher:find	()Z
    //   39: ifeq +198 -> 237
    //   42: aload 10
    //   44: invokevirtual 75	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   47: astore 8
    //   49: aload 8
    //   51: astore 7
    //   53: aload 8
    //   55: ifnonnull +7 -> 62
    //   58: ldc 77
    //   60: astore 7
    //   62: new 79	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   69: astore 8
    //   71: aload 8
    //   73: ldc 82
    //   75: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 8
    //   81: aload 7
    //   83: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 8
    //   89: ldc 88
    //   91: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: aload 8
    //   98: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokevirtual 95	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   104: istore 4
    //   106: iload_3
    //   107: iconst_m1
    //   108: if_icmpeq +109 -> 217
    //   111: iload 4
    //   113: iload_3
    //   114: isub
    //   115: iload_2
    //   116: iconst_2
    //   117: iadd
    //   118: if_icmple +99 -> 217
    //   121: aload_1
    //   122: iload_3
    //   123: iload_2
    //   124: iadd
    //   125: iconst_2
    //   126: iadd
    //   127: iload 4
    //   129: invokevirtual 99	java/lang/String:substring	(II)Ljava/lang/String;
    //   132: astore 8
    //   134: aload 9
    //   136: invokevirtual 103	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   139: astore 11
    //   141: aload 11
    //   143: invokeinterface 108 1 0
    //   148: ifeq +64 -> 212
    //   151: aload_0
    //   152: aload 11
    //   154: invokeinterface 112 1 0
    //   159: checkcast 57	java/lang/String
    //   162: invokespecial 116	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:parseTime	(Ljava/lang/String;)J
    //   165: lstore 5
    //   167: lload 5
    //   169: ldc2_w 117
    //   172: lcmp
    //   173: ifeq -32 -> 141
    //   176: new 120	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   179: dup
    //   180: invokespecial 121	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:<init>	()V
    //   183: astore 12
    //   185: aload 12
    //   187: aload 8
    //   189: putfield 124	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mText	Ljava/lang/String;
    //   192: aload 12
    //   194: lload 5
    //   196: putfield 128	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mStartTime	J
    //   199: aload_0
    //   200: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   203: aload 12
    //   205: invokevirtual 132	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   208: pop
    //   209: goto -68 -> 141
    //   212: aload 9
    //   214: invokevirtual 135	java/util/ArrayList:clear	()V
    //   217: aload 9
    //   219: aload 7
    //   221: invokevirtual 132	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   224: pop
    //   225: aload 7
    //   227: invokevirtual 61	java/lang/String:length	()I
    //   230: istore_2
    //   231: iload 4
    //   233: istore_3
    //   234: goto -200 -> 34
    //   237: aload 9
    //   239: invokevirtual 138	java/util/ArrayList:isEmpty	()Z
    //   242: ifeq +4 -> 246
    //   245: return
    //   246: iload_2
    //   247: iconst_2
    //   248: iadd
    //   249: iload_3
    //   250: iadd
    //   251: istore_3
    //   252: iload_3
    //   253: istore_2
    //   254: iload_3
    //   255: aload_1
    //   256: invokevirtual 61	java/lang/String:length	()I
    //   259: if_icmple +8 -> 267
    //   262: aload_1
    //   263: invokevirtual 61	java/lang/String:length	()I
    //   266: istore_2
    //   267: aload_1
    //   268: iload_2
    //   269: invokevirtual 141	java/lang/String:substring	(I)Ljava/lang/String;
    //   272: invokevirtual 144	java/lang/String:trim	()Ljava/lang/String;
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 61	java/lang/String:length	()I
    //   280: ifne +56 -> 336
    //   283: aload_0
    //   284: getfield 146	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mOffset	I
    //   287: ifne +49 -> 336
    //   290: aload 9
    //   292: invokevirtual 103	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   295: astore_1
    //   296: aload_1
    //   297: invokeinterface 108 1 0
    //   302: ifeq +28 -> 330
    //   305: aload_0
    //   306: aload_1
    //   307: invokeinterface 112 1 0
    //   312: checkcast 57	java/lang/String
    //   315: invokespecial 149	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:parseOffset	(Ljava/lang/String;)I
    //   318: istore_2
    //   319: iload_2
    //   320: ldc 150
    //   322: if_icmpeq -26 -> 296
    //   325: aload_0
    //   326: iload_2
    //   327: putfield 146	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mOffset	I
    //   330: aload 9
    //   332: invokevirtual 135	java/util/ArrayList:clear	()V
    //   335: return
    //   336: aload 9
    //   338: invokevirtual 103	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   341: astore 7
    //   343: aload 7
    //   345: invokeinterface 108 1 0
    //   350: ifeq +85 -> 435
    //   353: aload_0
    //   354: aload 7
    //   356: invokeinterface 112 1 0
    //   361: checkcast 57	java/lang/String
    //   364: invokespecial 116	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:parseTime	(Ljava/lang/String;)J
    //   367: lstore 5
    //   369: lload 5
    //   371: ldc2_w 117
    //   374: lcmp
    //   375: ifeq -32 -> 343
    //   378: aload_1
    //   379: invokevirtual 61	java/lang/String:length	()I
    //   382: ifle -39 -> 343
    //   385: new 120	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   388: dup
    //   389: invokespecial 121	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:<init>	()V
    //   392: astore 8
    //   394: aload 8
    //   396: aload_1
    //   397: putfield 124	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mText	Ljava/lang/String;
    //   400: aload 8
    //   402: lload 5
    //   404: putfield 128	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mStartTime	J
    //   407: aload_0
    //   408: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   411: aload 8
    //   413: invokevirtual 132	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   416: pop
    //   417: goto -74 -> 343
    //   420: astore_1
    //   421: goto +20 -> 441
    //   424: astore_1
    //   425: ldc 13
    //   427: aload_1
    //   428: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   431: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   434: pop
    //   435: aload 9
    //   437: invokevirtual 135	java/util/ArrayList:clear	()V
    //   440: return
    //   441: aload 9
    //   443: invokevirtual 135	java/util/ArrayList:clear	()V
    //   446: aload_1
    //   447: athrow
    //   448: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	LrcParserWOEmptyLine
    //   0	449	1	paramString	String
    //   31	296	2	i	int
    //   33	227	3	j	int
    //   104	128	4	k	int
    //   165	238	5	l	long
    //   51	304	7	localObject1	Object
    //   47	365	8	localObject2	Object
    //   28	414	9	localArrayList	ArrayList
    //   19	24	10	localMatcher	java.util.regex.Matcher
    //   139	14	11	localIterator	java.util.Iterator
    //   183	21	12	localSentence	Sentence
    // Exception table:
    //   from	to	target	type
    //   254	267	420	finally
    //   267	296	420	finally
    //   296	319	420	finally
    //   325	330	420	finally
    //   336	343	420	finally
    //   343	369	420	finally
    //   378	417	420	finally
    //   425	435	420	finally
    //   254	267	424	java/lang/Exception
    //   267	296	424	java/lang/Exception
    //   296	319	424	java/lang/Exception
    //   325	330	424	java/lang/Exception
    //   336	343	424	java/lang/Exception
    //   343	369	424	java/lang/Exception
    //   378	417	424	java/lang/Exception
  }
  
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
      Log.e("LrcParserWOEmptyLine", paramString.toString());
    }
    return 0;
  }
  
  private long parseTime(String paramString)
  {
    paramString = paramString.split("\\:|\\.");
    if (paramString.length < 2) {
      return -1L;
    }
    if (paramString.length == 2) {}
    try
    {
      if ((this.mOffset == 0) && (paramString[0].equalsIgnoreCase("offset")))
      {
        this.mOffset = Integer.parseInt(paramString[1]);
        return -1L;
      }
      i = Integer.parseInt(paramString[0]);
      j = Integer.parseInt(paramString[1]);
      if ((i >= 0) && (j >= 0) && (j < 60)) {
        return (i * 60 + j) * 1000L;
      }
      throw new RuntimeException("数字不合法!");
    }
    catch (Exception paramString)
    {
      int i;
      int j;
      return -1L;
    }
    if (paramString.length == 3) {}
    try
    {
      i = Integer.parseInt(paramString[0]);
      j = Integer.parseInt(paramString[1]);
      int k = Integer.parseInt(paramString[2]);
      if ((i >= 0) && (j >= 0) && (j < 60) && (k >= 0) && (k <= 999)) {
        return (i * 60 + j) * 1000L + k * 10;
      }
      throw new RuntimeException("数字不合法!");
    }
    catch (Exception paramString) {}
    return -1L;
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
    //   22: astore_2
    //   23: aload_3
    //   24: invokevirtual 202	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +17 -> 48
    //   34: aload_3
    //   35: astore_2
    //   36: aload_0
    //   37: aload 4
    //   39: invokevirtual 144	java/lang/String:trim	()Ljava/lang/String;
    //   42: invokespecial 204	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:parseLine	(Ljava/lang/String;)V
    //   45: goto -24 -> 21
    //   48: aload_3
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   54: getstatic 43	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineComparator	Lcom/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine$LyricComparator;
    //   57: invokestatic 210	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   60: iconst_0
    //   61: istore_1
    //   62: aload_3
    //   63: astore_2
    //   64: iload_1
    //   65: aload_0
    //   66: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   69: invokevirtual 213	java/util/ArrayList:size	()I
    //   72: if_icmpge +90 -> 162
    //   75: aload_3
    //   76: astore_2
    //   77: iload_1
    //   78: aload_0
    //   79: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   82: invokevirtual 213	java/util/ArrayList:size	()I
    //   85: iconst_1
    //   86: isub
    //   87: if_icmpge +53 -> 140
    //   90: aload_3
    //   91: astore_2
    //   92: aload_0
    //   93: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   96: iload_1
    //   97: invokevirtual 217	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   100: checkcast 120	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   103: aload_0
    //   104: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   107: iload_1
    //   108: iconst_1
    //   109: iadd
    //   110: invokevirtual 217	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   113: checkcast 120	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   116: getfield 128	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mStartTime	J
    //   119: aload_0
    //   120: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   123: iload_1
    //   124: invokevirtual 217	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   127: checkcast 120	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   130: getfield 128	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mStartTime	J
    //   133: lsub
    //   134: putfield 220	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mDuration	J
    //   137: goto +154 -> 291
    //   140: aload_3
    //   141: astore_2
    //   142: aload_0
    //   143: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   146: iload_1
    //   147: invokevirtual 217	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   150: checkcast 120	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   153: ldc2_w 221
    //   156: putfield 220	com/tencent/weseevideo/editor/sticker/music/lyric/data/Sentence:mDuration	J
    //   159: goto +132 -> 291
    //   162: aload_3
    //   163: astore_2
    //   164: new 224	com/tencent/weseevideo/editor/sticker/music/lyric/data/Lyric
    //   167: dup
    //   168: iconst_1
    //   169: aload_0
    //   170: getfield 146	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mOffset	I
    //   173: aload_0
    //   174: getfield 51	com/tencent/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWOEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   177: invokespecial 227	com/tencent/weseevideo/editor/sticker/music/lyric/data/Lyric:<init>	(IILjava/util/ArrayList;)V
    //   180: astore 4
    //   182: aload_3
    //   183: invokevirtual 230	java/io/BufferedReader:close	()V
    //   186: aload 4
    //   188: areturn
    //   189: astore_2
    //   190: ldc 13
    //   192: aload_2
    //   193: invokevirtual 231	java/io/IOException:toString	()Ljava/lang/String;
    //   196: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   199: pop
    //   200: aload 4
    //   202: areturn
    //   203: astore 4
    //   205: goto +13 -> 218
    //   208: astore_2
    //   209: aconst_null
    //   210: astore_3
    //   211: goto +50 -> 261
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_3
    //   218: aload_3
    //   219: astore_2
    //   220: ldc 13
    //   222: aload 4
    //   224: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   227: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   230: pop
    //   231: aload_3
    //   232: ifnull +20 -> 252
    //   235: aload_3
    //   236: invokevirtual 230	java/io/BufferedReader:close	()V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_2
    //   242: ldc 13
    //   244: aload_2
    //   245: invokevirtual 231	java/io/IOException:toString	()Ljava/lang/String;
    //   248: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   251: pop
    //   252: aconst_null
    //   253: areturn
    //   254: astore 4
    //   256: aload_2
    //   257: astore_3
    //   258: aload 4
    //   260: astore_2
    //   261: aload_3
    //   262: ifnull +21 -> 283
    //   265: aload_3
    //   266: invokevirtual 230	java/io/BufferedReader:close	()V
    //   269: goto +14 -> 283
    //   272: astore_3
    //   273: ldc 13
    //   275: aload_3
    //   276: invokevirtual 231	java/io/IOException:toString	()Ljava/lang/String;
    //   279: invokestatic 157	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   282: pop
    //   283: goto +5 -> 288
    //   286: aload_2
    //   287: athrow
    //   288: goto -2 -> 286
    //   291: iload_1
    //   292: iconst_1
    //   293: iadd
    //   294: istore_1
    //   295: goto -233 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	LrcParserWOEmptyLine
    //   61	234	1	i	int
    //   4	160	2	localObject1	Object
    //   189	4	2	localIOException1	java.io.IOException
    //   208	1	2	localObject2	Object
    //   219	1	2	localObject3	Object
    //   241	16	2	localIOException2	java.io.IOException
    //   260	27	2	localObject4	Object
    //   20	246	3	localObject5	Object
    //   272	4	3	localIOException3	java.io.IOException
    //   27	174	4	localObject6	Object
    //   203	1	4	localException1	Exception
    //   214	9	4	localException2	Exception
    //   254	5	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   182	186	189	java/io/IOException
    //   23	29	203	java/lang/Exception
    //   36	45	203	java/lang/Exception
    //   50	60	203	java/lang/Exception
    //   64	75	203	java/lang/Exception
    //   77	90	203	java/lang/Exception
    //   92	137	203	java/lang/Exception
    //   142	159	203	java/lang/Exception
    //   164	182	203	java/lang/Exception
    //   5	21	208	finally
    //   5	21	214	java/lang/Exception
    //   235	239	241	java/io/IOException
    //   23	29	254	finally
    //   36	45	254	finally
    //   50	60	254	finally
    //   64	75	254	finally
    //   77	90	254	finally
    //   92	137	254	finally
    //   142	159	254	finally
    //   164	182	254	finally
    //   220	231	254	finally
    //   265	269	272	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.parse.parser.LrcParserWOEmptyLine
 * JD-Core Version:    0.7.0.1
 */