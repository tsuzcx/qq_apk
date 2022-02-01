package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class LrcParserWEmptyLine
  implements IParser
{
  private static final String OFFSET_TAG = "offset";
  public static final String TAG = "LrcParserWEmptyLine";
  private static final LrcParserWEmptyLine.LyricComparator mLineComparator = new LrcParserWEmptyLine.LyricComparator(null);
  private static final Pattern mPattern = Pattern.compile("(?<=\\[).*?(?=\\])");
  private ArrayList<Sentence> mLineLyricList = new ArrayList();
  private int mOffset;
  private String mString;
  
  /* Error */
  private void parseLine(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +462 -> 463
    //   4: aload_1
    //   5: invokevirtual 61	java/lang/String:length	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: getstatic 35	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mPattern	Ljava/util/regex/Pattern;
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
    //   162: invokespecial 116	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:parseTime	(Ljava/lang/String;)J
    //   165: lstore 5
    //   167: lload 5
    //   169: ldc2_w 117
    //   172: lcmp
    //   173: ifeq -32 -> 141
    //   176: new 120	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   179: dup
    //   180: invokespecial 121	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence:<init>	()V
    //   183: astore 12
    //   185: aload 12
    //   187: aload 8
    //   189: putfield 124	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence:mText	Ljava/lang/String;
    //   192: aload 12
    //   194: lload 5
    //   196: putfield 128	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence:mStartTime	J
    //   199: aload_0
    //   200: getfield 51	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineLyricList	Ljava/util/ArrayList;
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
    //   275: astore 7
    //   277: aload 7
    //   279: astore_1
    //   280: aload 7
    //   282: invokevirtual 61	java/lang/String:length	()I
    //   285: ifne +6 -> 291
    //   288: ldc 146
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 61	java/lang/String:length	()I
    //   295: ifne +56 -> 351
    //   298: aload_0
    //   299: getfield 148	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mOffset	I
    //   302: ifne +49 -> 351
    //   305: aload 9
    //   307: invokevirtual 103	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   310: astore_1
    //   311: aload_1
    //   312: invokeinterface 108 1 0
    //   317: ifeq +28 -> 345
    //   320: aload_0
    //   321: aload_1
    //   322: invokeinterface 112 1 0
    //   327: checkcast 57	java/lang/String
    //   330: invokespecial 151	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:parseOffset	(Ljava/lang/String;)I
    //   333: istore_2
    //   334: iload_2
    //   335: ldc 152
    //   337: if_icmpeq -26 -> 311
    //   340: aload_0
    //   341: iload_2
    //   342: putfield 148	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mOffset	I
    //   345: aload 9
    //   347: invokevirtual 135	java/util/ArrayList:clear	()V
    //   350: return
    //   351: aload 9
    //   353: invokevirtual 103	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   356: astore 7
    //   358: aload 7
    //   360: invokeinterface 108 1 0
    //   365: ifeq +85 -> 450
    //   368: aload_0
    //   369: aload 7
    //   371: invokeinterface 112 1 0
    //   376: checkcast 57	java/lang/String
    //   379: invokespecial 116	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:parseTime	(Ljava/lang/String;)J
    //   382: lstore 5
    //   384: lload 5
    //   386: ldc2_w 117
    //   389: lcmp
    //   390: ifeq -32 -> 358
    //   393: aload_1
    //   394: invokevirtual 61	java/lang/String:length	()I
    //   397: ifle -39 -> 358
    //   400: new 120	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   403: dup
    //   404: invokespecial 121	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence:<init>	()V
    //   407: astore 8
    //   409: aload 8
    //   411: aload_1
    //   412: putfield 124	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence:mText	Ljava/lang/String;
    //   415: aload 8
    //   417: lload 5
    //   419: putfield 128	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence:mStartTime	J
    //   422: aload_0
    //   423: getfield 51	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   426: aload 8
    //   428: invokevirtual 132	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   431: pop
    //   432: goto -74 -> 358
    //   435: astore_1
    //   436: goto +20 -> 456
    //   439: astore_1
    //   440: ldc 13
    //   442: aload_1
    //   443: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   446: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   449: pop
    //   450: aload 9
    //   452: invokevirtual 135	java/util/ArrayList:clear	()V
    //   455: return
    //   456: aload 9
    //   458: invokevirtual 135	java/util/ArrayList:clear	()V
    //   461: aload_1
    //   462: athrow
    //   463: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	LrcParserWEmptyLine
    //   0	464	1	paramString	String
    //   31	311	2	i	int
    //   33	227	3	j	int
    //   104	128	4	k	int
    //   165	253	5	l	long
    //   51	319	7	localObject1	Object
    //   47	380	8	localObject2	Object
    //   28	429	9	localArrayList	ArrayList
    //   19	24	10	localMatcher	java.util.regex.Matcher
    //   139	14	11	localIterator	java.util.Iterator
    //   183	21	12	localSentence	Sentence
    // Exception table:
    //   from	to	target	type
    //   254	267	435	finally
    //   267	277	435	finally
    //   280	288	435	finally
    //   291	311	435	finally
    //   311	334	435	finally
    //   340	345	435	finally
    //   351	358	435	finally
    //   358	384	435	finally
    //   393	432	435	finally
    //   440	450	435	finally
    //   254	267	439	java/lang/Exception
    //   267	277	439	java/lang/Exception
    //   280	288	439	java/lang/Exception
    //   291	311	439	java/lang/Exception
    //   311	334	439	java/lang/Exception
    //   340	345	439	java/lang/Exception
    //   351	358	439	java/lang/Exception
    //   358	384	439	java/lang/Exception
    //   393	432	439	java/lang/Exception
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
      Log.e("LrcParserWEmptyLine", paramString.toString());
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
  public com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric parse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 188	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mString	Ljava/lang/String;
    //   4: astore_2
    //   5: new 195	java/io/BufferedReader
    //   8: dup
    //   9: new 197	java/io/StringReader
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 198	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 201	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: invokevirtual 204	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +17 -> 48
    //   34: aload_3
    //   35: astore_2
    //   36: aload_0
    //   37: aload 4
    //   39: invokevirtual 144	java/lang/String:trim	()Ljava/lang/String;
    //   42: invokespecial 206	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:parseLine	(Ljava/lang/String;)V
    //   45: goto -24 -> 21
    //   48: aload_3
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 51	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   54: getstatic 43	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineComparator	Lcom/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine$LyricComparator;
    //   57: invokestatic 212	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   60: iconst_0
    //   61: istore_1
    //   62: aload_3
    //   63: astore_2
    //   64: iload_1
    //   65: aload_0
    //   66: getfield 51	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   69: invokevirtual 215	java/util/ArrayList:size	()I
    //   72: if_icmpge +90 -> 162
    //   75: aload_3
    //   76: astore_2
    //   77: iload_1
    //   78: aload_0
    //   79: getfield 51	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   82: invokevirtual 215	java/util/ArrayList:size	()I
    //   85: iconst_1
    //   86: isub
    //   87: if_icmpge +53 -> 140
    //   90: aload_3
    //   91: astore_2
    //   92: aload_0
    //   93: getfield 51	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   96: iload_1
    //   97: invokevirtual 219	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   100: checkcast 120	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   103: aload_0
    //   104: getfield 51	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   107: iload_1
    //   108: iconst_1
    //   109: iadd
    //   110: invokevirtual 219	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   113: checkcast 120	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   116: getfield 128	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence:mStartTime	J
    //   119: aload_0
    //   120: getfield 51	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   123: iload_1
    //   124: invokevirtual 219	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   127: checkcast 120	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   130: getfield 128	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence:mStartTime	J
    //   133: lsub
    //   134: putfield 222	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence:mDuration	J
    //   137: goto +154 -> 291
    //   140: aload_3
    //   141: astore_2
    //   142: aload_0
    //   143: getfield 51	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   146: iload_1
    //   147: invokevirtual 219	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   150: checkcast 120	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence
    //   153: ldc2_w 223
    //   156: putfield 222	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Sentence:mDuration	J
    //   159: goto +132 -> 291
    //   162: aload_3
    //   163: astore_2
    //   164: new 226	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Lyric
    //   167: dup
    //   168: iconst_1
    //   169: aload_0
    //   170: getfield 148	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mOffset	I
    //   173: aload_0
    //   174: getfield 51	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/parse/parser/LrcParserWEmptyLine:mLineLyricList	Ljava/util/ArrayList;
    //   177: invokespecial 229	com/tencent/qcircle/weseevideo/editor/sticker/music/lyric/data/Lyric:<init>	(IILjava/util/ArrayList;)V
    //   180: astore 4
    //   182: aload_3
    //   183: invokevirtual 232	java/io/BufferedReader:close	()V
    //   186: aload 4
    //   188: areturn
    //   189: astore_2
    //   190: ldc 13
    //   192: aload_2
    //   193: invokevirtual 233	java/io/IOException:toString	()Ljava/lang/String;
    //   196: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
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
    //   224: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   227: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   230: pop
    //   231: aload_3
    //   232: ifnull +20 -> 252
    //   235: aload_3
    //   236: invokevirtual 232	java/io/BufferedReader:close	()V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_2
    //   242: ldc 13
    //   244: aload_2
    //   245: invokevirtual 233	java/io/IOException:toString	()Ljava/lang/String;
    //   248: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
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
    //   266: invokevirtual 232	java/io/BufferedReader:close	()V
    //   269: goto +14 -> 283
    //   272: astore_3
    //   273: ldc 13
    //   275: aload_3
    //   276: invokevirtual 233	java/io/IOException:toString	()Ljava/lang/String;
    //   279: invokestatic 159	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
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
    //   0	298	0	this	LrcParserWEmptyLine
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.LrcParserWEmptyLine
 * JD-Core Version:    0.7.0.1
 */