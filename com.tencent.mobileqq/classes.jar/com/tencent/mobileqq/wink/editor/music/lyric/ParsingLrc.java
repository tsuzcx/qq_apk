package com.tencent.mobileqq.wink.editor.music.lyric;

import android.util.Log;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.wink.editor.music.lyric.data.Sentence;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ParsingLrc
{
  private static final Pattern a = Pattern.compile("(?<=\\[).*?(?=\\])");
  private static final ParsingLrc.LyricComparator d = new ParsingLrc.LyricComparator(null);
  private final String b;
  private ArrayList<Sentence> c = new ArrayList();
  private int e;
  
  public ParsingLrc(String paramString)
  {
    this.b = paramString;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +449 -> 450
    //   4: aload_1
    //   5: ldc 50
    //   7: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: getstatic 27	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:a	Ljava/util/regex/Pattern;
    //   17: aload_1
    //   18: invokevirtual 60	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   21: astore 10
    //   23: new 41	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 42	java/util/ArrayList:<init>	()V
    //   30: astore 9
    //   32: iconst_m1
    //   33: istore_2
    //   34: iconst_m1
    //   35: istore_3
    //   36: aload 10
    //   38: invokevirtual 66	java/util/regex/Matcher:find	()Z
    //   41: ifeq +198 -> 239
    //   44: aload 10
    //   46: invokevirtual 70	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   49: astore 8
    //   51: aload 8
    //   53: astore 7
    //   55: aload 8
    //   57: ifnonnull +7 -> 64
    //   60: ldc 50
    //   62: astore 7
    //   64: new 72	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   71: astore 8
    //   73: aload 8
    //   75: ldc 75
    //   77: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 8
    //   83: aload 7
    //   85: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 8
    //   91: ldc 81
    //   93: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_1
    //   98: aload 8
    //   100: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 88	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   106: istore 4
    //   108: iload_3
    //   109: iconst_m1
    //   110: if_icmpeq +109 -> 219
    //   113: iload 4
    //   115: iload_3
    //   116: isub
    //   117: iload_2
    //   118: iconst_2
    //   119: iadd
    //   120: if_icmple +99 -> 219
    //   123: aload_1
    //   124: iload_3
    //   125: iload_2
    //   126: iadd
    //   127: iconst_2
    //   128: iadd
    //   129: iload 4
    //   131: invokevirtual 92	java/lang/String:substring	(II)Ljava/lang/String;
    //   134: astore 8
    //   136: aload 9
    //   138: invokevirtual 96	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   141: astore 11
    //   143: aload 11
    //   145: invokeinterface 101 1 0
    //   150: ifeq +64 -> 214
    //   153: aload_0
    //   154: aload 11
    //   156: invokeinterface 105 1 0
    //   161: checkcast 52	java/lang/String
    //   164: invokespecial 108	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:b	(Ljava/lang/String;)J
    //   167: lstore 5
    //   169: lload 5
    //   171: ldc2_w 109
    //   174: lcmp
    //   175: ifeq -32 -> 143
    //   178: new 112	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence
    //   181: dup
    //   182: invokespecial 113	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence:<init>	()V
    //   185: astore 12
    //   187: aload 12
    //   189: aload 8
    //   191: putfield 115	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence:a	Ljava/lang/String;
    //   194: aload 12
    //   196: lload 5
    //   198: putfield 118	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence:b	J
    //   201: aload_0
    //   202: getfield 44	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	Ljava/util/ArrayList;
    //   205: aload 12
    //   207: invokevirtual 121	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   210: pop
    //   211: goto -68 -> 143
    //   214: aload 9
    //   216: invokevirtual 124	java/util/ArrayList:clear	()V
    //   219: aload 9
    //   221: aload 7
    //   223: invokevirtual 121	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: aload 7
    //   229: invokevirtual 128	java/lang/String:length	()I
    //   232: istore_2
    //   233: iload 4
    //   235: istore_3
    //   236: goto -200 -> 36
    //   239: aload 9
    //   241: invokevirtual 131	java/util/ArrayList:isEmpty	()Z
    //   244: ifeq +4 -> 248
    //   247: return
    //   248: iload_2
    //   249: iconst_2
    //   250: iadd
    //   251: iload_3
    //   252: iadd
    //   253: istore_3
    //   254: iload_3
    //   255: istore_2
    //   256: iload_3
    //   257: aload_1
    //   258: invokevirtual 128	java/lang/String:length	()I
    //   261: if_icmple +8 -> 269
    //   264: aload_1
    //   265: invokevirtual 128	java/lang/String:length	()I
    //   268: istore_2
    //   269: aload_1
    //   270: iload_2
    //   271: invokevirtual 134	java/lang/String:substring	(I)Ljava/lang/String;
    //   274: invokevirtual 137	java/lang/String:trim	()Ljava/lang/String;
    //   277: astore_1
    //   278: aload_1
    //   279: invokevirtual 128	java/lang/String:length	()I
    //   282: ifne +56 -> 338
    //   285: aload_0
    //   286: getfield 139	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:e	I
    //   289: ifne +49 -> 338
    //   292: aload 9
    //   294: invokevirtual 96	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   297: astore_1
    //   298: aload_1
    //   299: invokeinterface 101 1 0
    //   304: ifeq +28 -> 332
    //   307: aload_0
    //   308: aload_1
    //   309: invokeinterface 105 1 0
    //   314: checkcast 52	java/lang/String
    //   317: invokespecial 141	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	(Ljava/lang/String;)I
    //   320: istore_2
    //   321: iload_2
    //   322: ldc 142
    //   324: if_icmpeq -26 -> 298
    //   327: aload_0
    //   328: iload_2
    //   329: putfield 139	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:e	I
    //   332: aload 9
    //   334: invokevirtual 124	java/util/ArrayList:clear	()V
    //   337: return
    //   338: aload 9
    //   340: invokevirtual 96	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   343: astore 7
    //   345: aload 7
    //   347: invokeinterface 101 1 0
    //   352: ifeq +85 -> 437
    //   355: aload_0
    //   356: aload 7
    //   358: invokeinterface 105 1 0
    //   363: checkcast 52	java/lang/String
    //   366: invokespecial 108	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:b	(Ljava/lang/String;)J
    //   369: lstore 5
    //   371: lload 5
    //   373: ldc2_w 109
    //   376: lcmp
    //   377: ifeq -32 -> 345
    //   380: aload_1
    //   381: invokevirtual 128	java/lang/String:length	()I
    //   384: ifle -39 -> 345
    //   387: new 112	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence
    //   390: dup
    //   391: invokespecial 113	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence:<init>	()V
    //   394: astore 8
    //   396: aload 8
    //   398: aload_1
    //   399: putfield 115	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence:a	Ljava/lang/String;
    //   402: aload 8
    //   404: lload 5
    //   406: putfield 118	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence:b	J
    //   409: aload_0
    //   410: getfield 44	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	Ljava/util/ArrayList;
    //   413: aload 8
    //   415: invokevirtual 121	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   418: pop
    //   419: goto -74 -> 345
    //   422: astore_1
    //   423: goto +20 -> 443
    //   426: astore_1
    //   427: ldc 144
    //   429: aload_1
    //   430: invokevirtual 145	java/lang/Exception:toString	()Ljava/lang/String;
    //   433: invokestatic 150	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   436: pop
    //   437: aload 9
    //   439: invokevirtual 124	java/util/ArrayList:clear	()V
    //   442: return
    //   443: aload 9
    //   445: invokevirtual 124	java/util/ArrayList:clear	()V
    //   448: aload_1
    //   449: athrow
    //   450: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	ParsingLrc
    //   0	451	1	paramString	String
    //   33	296	2	i	int
    //   35	227	3	j	int
    //   106	128	4	k	int
    //   167	238	5	l	long
    //   53	304	7	localObject1	Object
    //   49	365	8	localObject2	Object
    //   30	414	9	localArrayList	ArrayList
    //   21	24	10	localMatcher	java.util.regex.Matcher
    //   141	14	11	localIterator	java.util.Iterator
    //   185	21	12	localSentence	Sentence
    // Exception table:
    //   from	to	target	type
    //   256	269	422	finally
    //   269	298	422	finally
    //   298	321	422	finally
    //   327	332	422	finally
    //   338	345	422	finally
    //   345	371	422	finally
    //   380	419	422	finally
    //   427	437	422	finally
    //   256	269	426	java/lang/Exception
    //   269	298	426	java/lang/Exception
    //   298	321	426	java/lang/Exception
    //   327	332	426	java/lang/Exception
    //   338	345	426	java/lang/Exception
    //   345	371	426	java/lang/Exception
    //   380	419	426	java/lang/Exception
  }
  
  private long b(String paramString)
  {
    paramString = paramString.split("\\:|\\.");
    if (paramString.length < 2) {
      return -1L;
    }
    if (paramString.length == 2) {}
    try
    {
      if ((this.e == 0) && (paramString[0].equalsIgnoreCase("offset")))
      {
        this.e = Integer.parseInt(paramString[1]);
        return -1L;
      }
      i = Integer.parseInt(paramString[0]);
      j = Integer.parseInt(paramString[1]);
      if ((i >= 0) && (j >= 0) && (j < 60)) {
        return (i * 60 + j) * 1000L;
      }
      throw new RuntimeException(HardCodeUtil.a(2131905705));
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
      if ((i >= 0) && (j >= 0) && (j < 60) && (k >= 0) && (k <= 99)) {
        return (i * 60 + j) * 1000L + k * 10;
      }
      throw new RuntimeException(HardCodeUtil.a(2131905706));
    }
    catch (Exception paramString) {}
    return -1L;
    return -1L;
  }
  
  private int c(String paramString)
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
      Log.e("ParsingLrc", paramString.toString());
    }
    return 0;
  }
  
  /* Error */
  public com.tencent.mobileqq.wink.editor.music.lyric.data.Lyric a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:b	Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_2
    //   12: ifnull +283 -> 295
    //   15: new 186	java/io/BufferedReader
    //   18: dup
    //   19: new 188	java/io/StringReader
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 189	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 192	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore_3
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: invokevirtual 195	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +17 -> 58
    //   44: aload_3
    //   45: astore_2
    //   46: aload_0
    //   47: aload 4
    //   49: invokevirtual 137	java/lang/String:trim	()Ljava/lang/String;
    //   52: invokespecial 197	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:a	(Ljava/lang/String;)V
    //   55: goto -24 -> 31
    //   58: aload_3
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 44	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	Ljava/util/ArrayList;
    //   64: getstatic 35	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:d	Lcom/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc$LyricComparator;
    //   67: invokestatic 203	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   70: iconst_0
    //   71: istore_1
    //   72: aload_3
    //   73: astore_2
    //   74: iload_1
    //   75: aload_0
    //   76: getfield 44	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	Ljava/util/ArrayList;
    //   79: invokevirtual 206	java/util/ArrayList:size	()I
    //   82: if_icmpge +90 -> 172
    //   85: aload_3
    //   86: astore_2
    //   87: iload_1
    //   88: aload_0
    //   89: getfield 44	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	Ljava/util/ArrayList;
    //   92: invokevirtual 206	java/util/ArrayList:size	()I
    //   95: iconst_1
    //   96: isub
    //   97: if_icmpge +53 -> 150
    //   100: aload_3
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 44	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	Ljava/util/ArrayList;
    //   106: iload_1
    //   107: invokevirtual 210	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   110: checkcast 112	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence
    //   113: aload_0
    //   114: getfield 44	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	Ljava/util/ArrayList;
    //   117: iload_1
    //   118: iconst_1
    //   119: iadd
    //   120: invokevirtual 210	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   123: checkcast 112	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence
    //   126: getfield 118	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence:b	J
    //   129: aload_0
    //   130: getfield 44	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	Ljava/util/ArrayList;
    //   133: iload_1
    //   134: invokevirtual 210	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   137: checkcast 112	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence
    //   140: getfield 118	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence:b	J
    //   143: lsub
    //   144: putfield 212	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence:c	J
    //   147: goto +150 -> 297
    //   150: aload_3
    //   151: astore_2
    //   152: aload_0
    //   153: getfield 44	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	Ljava/util/ArrayList;
    //   156: iload_1
    //   157: invokevirtual 210	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   160: checkcast 112	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence
    //   163: ldc2_w 213
    //   166: putfield 212	com/tencent/mobileqq/wink/editor/music/lyric/data/Sentence:c	J
    //   169: goto +128 -> 297
    //   172: aload_3
    //   173: astore_2
    //   174: new 216	com/tencent/mobileqq/wink/editor/music/lyric/data/Lyric
    //   177: dup
    //   178: iconst_1
    //   179: aload_0
    //   180: getfield 139	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:e	I
    //   183: aload_0
    //   184: getfield 44	com/tencent/mobileqq/wink/editor/music/lyric/ParsingLrc:c	Ljava/util/ArrayList;
    //   187: invokespecial 219	com/tencent/mobileqq/wink/editor/music/lyric/data/Lyric:<init>	(IILjava/util/ArrayList;)V
    //   190: astore 4
    //   192: aload_3
    //   193: invokevirtual 222	java/io/BufferedReader:close	()V
    //   196: aload 4
    //   198: areturn
    //   199: astore_2
    //   200: ldc 144
    //   202: aload_2
    //   203: invokevirtual 223	java/io/IOException:toString	()Ljava/lang/String;
    //   206: invokestatic 150	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   209: pop
    //   210: aload 4
    //   212: areturn
    //   213: astore 4
    //   215: goto +13 -> 228
    //   218: astore_2
    //   219: aconst_null
    //   220: astore_3
    //   221: goto +50 -> 271
    //   224: astore 4
    //   226: aconst_null
    //   227: astore_3
    //   228: aload_3
    //   229: astore_2
    //   230: ldc 144
    //   232: aload 4
    //   234: invokevirtual 145	java/lang/Exception:toString	()Ljava/lang/String;
    //   237: invokestatic 150	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   240: pop
    //   241: aload_3
    //   242: ifnull +53 -> 295
    //   245: aload_3
    //   246: invokevirtual 222	java/io/BufferedReader:close	()V
    //   249: aconst_null
    //   250: areturn
    //   251: astore_2
    //   252: ldc 144
    //   254: aload_2
    //   255: invokevirtual 223	java/io/IOException:toString	()Ljava/lang/String;
    //   258: invokestatic 150	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   261: pop
    //   262: aconst_null
    //   263: areturn
    //   264: astore 4
    //   266: aload_2
    //   267: astore_3
    //   268: aload 4
    //   270: astore_2
    //   271: aload_3
    //   272: ifnull +21 -> 293
    //   275: aload_3
    //   276: invokevirtual 222	java/io/BufferedReader:close	()V
    //   279: goto +14 -> 293
    //   282: astore_3
    //   283: ldc 144
    //   285: aload_3
    //   286: invokevirtual 223	java/io/IOException:toString	()Ljava/lang/String;
    //   289: invokestatic 150	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   292: pop
    //   293: aload_2
    //   294: athrow
    //   295: aconst_null
    //   296: areturn
    //   297: iload_1
    //   298: iconst_1
    //   299: iadd
    //   300: istore_1
    //   301: goto -229 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	ParsingLrc
    //   71	230	1	i	int
    //   4	170	2	localObject1	Object
    //   199	4	2	localIOException1	java.io.IOException
    //   218	1	2	localObject2	Object
    //   229	1	2	localObject3	Object
    //   251	16	2	localIOException2	java.io.IOException
    //   270	24	2	localObject4	Object
    //   30	246	3	localObject5	Object
    //   282	4	3	localIOException3	java.io.IOException
    //   37	174	4	localObject6	Object
    //   213	1	4	localException1	Exception
    //   224	9	4	localException2	Exception
    //   264	5	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   192	196	199	java/io/IOException
    //   33	39	213	java/lang/Exception
    //   46	55	213	java/lang/Exception
    //   60	70	213	java/lang/Exception
    //   74	85	213	java/lang/Exception
    //   87	100	213	java/lang/Exception
    //   102	147	213	java/lang/Exception
    //   152	169	213	java/lang/Exception
    //   174	192	213	java/lang/Exception
    //   15	31	218	finally
    //   15	31	224	java/lang/Exception
    //   245	249	251	java/io/IOException
    //   33	39	264	finally
    //   46	55	264	finally
    //   60	70	264	finally
    //   74	85	264	finally
    //   87	100	264	finally
    //   102	147	264	finally
    //   152	169	264	finally
    //   174	192	264	finally
    //   230	241	264	finally
    //   275	279	282	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.ParsingLrc
 * JD-Core Version:    0.7.0.1
 */