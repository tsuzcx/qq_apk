package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.LineNumberReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CueItemParser
  extends AudioPlayListItemParser
{
  public static final String TAG = "CueItemParser";
  private LineNumberReader mReader;
  protected List<TrackInfo> mTrackInfoList;
  
  public CueItemParser(String paramString)
  {
    this.mUri = paramString;
    this.mTrackInfoList = new LinkedList();
  }
  
  private long convertTimeStrToMs(String paramString)
  {
    paramString = paramString.split(":");
    return (Long.parseLong(paramString[0]) * 60L + Long.parseLong(paramString[1])) * 1000L + Long.parseLong(paramString[2]) * 10L;
  }
  
  private String guessCharsetEncoding(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CueItemParser.guessCharsetEncoding, filePath: ");
    localStringBuilder.append(paramString);
    Logger.i("CueItemParser", localStringBuilder.toString());
    return guessCharsetEncoding(new FileInputStream(paramString));
  }
  
  public boolean isParseSuccess()
  {
    return this.mTrackInfoList.isEmpty() ^ true;
  }
  
  public Iterator<TrackInfo> iterator()
  {
    return this.mTrackInfoList.iterator();
  }
  
  /* Error */
  public void parse()
  {
    // Byte code:
    //   0: ldc 96
    //   2: astore 15
    //   4: new 52	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   11: astore 10
    //   13: aload 10
    //   15: ldc 98
    //   17: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 10
    //   23: aload_0
    //   24: getfield 21	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   27: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc 8
    //   33: aload 10
    //   35: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 69	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: new 100	java/io/File
    //   44: dup
    //   45: aload_0
    //   46: getfield 21	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   49: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore 16
    //   54: aload_0
    //   55: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   58: invokeinterface 104 1 0
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 21	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   68: invokespecial 106	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:guessCharsetEncoding	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 10
    //   73: aload_0
    //   74: new 108	java/io/LineNumberReader
    //   77: dup
    //   78: new 110	java/io/InputStreamReader
    //   81: dup
    //   82: new 71	java/io/FileInputStream
    //   85: dup
    //   86: aload 16
    //   88: invokespecial 113	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: aload 10
    //   93: invokespecial 116	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   96: invokespecial 119	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   99: putfield 121	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   102: aconst_null
    //   103: astore 11
    //   105: aload 11
    //   107: astore 12
    //   109: aload 12
    //   111: astore 14
    //   113: aload 14
    //   115: astore 13
    //   117: iconst_0
    //   118: istore_1
    //   119: lconst_0
    //   120: lstore 7
    //   122: iconst_0
    //   123: istore_2
    //   124: iconst_0
    //   125: istore_3
    //   126: iconst_0
    //   127: istore 5
    //   129: iload 5
    //   131: istore 4
    //   133: aload_0
    //   134: getfield 121	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   137: invokevirtual 124	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   140: astore 18
    //   142: iload 5
    //   144: istore 4
    //   146: aload_0
    //   147: getfield 121	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   150: invokevirtual 128	java/io/LineNumberReader:getLineNumber	()I
    //   153: istore 6
    //   155: iload 6
    //   157: istore 4
    //   159: aload 18
    //   161: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: istore 9
    //   166: iload 9
    //   168: ifne +1100 -> 1268
    //   171: aload 14
    //   173: astore 10
    //   175: iload_1
    //   176: ifne +38 -> 214
    //   179: aload 14
    //   181: astore 10
    //   183: iload 6
    //   185: istore 4
    //   187: aload 18
    //   189: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   192: invokevirtual 139	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   195: ldc 141
    //   197: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   200: ifeq +14 -> 214
    //   203: iload 6
    //   205: istore 4
    //   207: aload 18
    //   209: invokestatic 148	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 10
    //   214: iload_1
    //   215: ifne +1355 -> 1570
    //   218: iload 6
    //   220: istore 4
    //   222: aload 18
    //   224: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   227: invokevirtual 139	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   230: ldc 150
    //   232: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   235: ifeq +17 -> 252
    //   238: iload 6
    //   240: istore 4
    //   242: aload 18
    //   244: invokestatic 148	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   247: astore 12
    //   249: goto +3 -> 252
    //   252: iload 6
    //   254: istore 4
    //   256: aload 18
    //   258: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   261: invokevirtual 139	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   264: ldc 152
    //   266: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   269: ifeq +1307 -> 1576
    //   272: iload_1
    //   273: istore 5
    //   275: iload_1
    //   276: ifeq +6 -> 282
    //   279: iconst_0
    //   280: istore 5
    //   282: lload 7
    //   284: lconst_0
    //   285: lcmp
    //   286: ifeq +19 -> 305
    //   289: aload 11
    //   291: ifnull +14 -> 305
    //   294: iload 6
    //   296: istore 4
    //   298: aload 11
    //   300: lload 7
    //   302: invokevirtual 158	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   305: iload 6
    //   307: istore 4
    //   309: aload 18
    //   311: invokestatic 148	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   314: astore 17
    //   316: iload 6
    //   318: istore 4
    //   320: aload 16
    //   322: invokevirtual 161	java/io/File:getParent	()Ljava/lang/String;
    //   325: astore 13
    //   327: iload 6
    //   329: istore 4
    //   331: aload 13
    //   333: aload 15
    //   335: invokevirtual 164	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   338: ifne +1235 -> 1573
    //   341: iload 6
    //   343: istore 4
    //   345: new 52	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   352: astore 14
    //   354: iload 6
    //   356: istore 4
    //   358: aload 14
    //   360: aload 13
    //   362: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: iload 6
    //   368: istore 4
    //   370: aload 14
    //   372: aload 15
    //   374: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: iload 6
    //   380: istore 4
    //   382: aload 14
    //   384: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: astore 13
    //   389: goto +3 -> 392
    //   392: aload 17
    //   394: astore 14
    //   396: iload 6
    //   398: istore 4
    //   400: aload 17
    //   402: aload 15
    //   404: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   407: ifeq +15 -> 422
    //   410: iload 6
    //   412: istore 4
    //   414: aload 17
    //   416: iconst_1
    //   417: invokevirtual 168	java/lang/String:substring	(I)Ljava/lang/String;
    //   420: astore 14
    //   422: iload 6
    //   424: istore 4
    //   426: new 52	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   433: astore 17
    //   435: iload 6
    //   437: istore 4
    //   439: aload 17
    //   441: aload 13
    //   443: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: iload 6
    //   449: istore 4
    //   451: aload 17
    //   453: aload 14
    //   455: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: iload 6
    //   461: istore 4
    //   463: aload 17
    //   465: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: astore 13
    //   470: iload 6
    //   472: istore 4
    //   474: new 100	java/io/File
    //   477: dup
    //   478: aload 13
    //   480: invokespecial 101	java/io/File:<init>	(Ljava/lang/String;)V
    //   483: invokevirtual 171	java/io/File:exists	()Z
    //   486: ifeq +146 -> 632
    //   489: iload 6
    //   491: istore 4
    //   493: new 173	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder
    //   496: dup
    //   497: invokespecial 174	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:<init>	()V
    //   500: astore 14
    //   502: iload 6
    //   504: istore 4
    //   506: aload 14
    //   508: new 176	com/tencent/qqmusic/mediaplayer/upstream/FileDataSource
    //   511: dup
    //   512: aload 13
    //   514: invokespecial 177	com/tencent/qqmusic/mediaplayer/upstream/FileDataSource:<init>	(Ljava/lang/String;)V
    //   517: invokevirtual 181	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)I
    //   520: istore_1
    //   521: iload_1
    //   522: ifne +20 -> 542
    //   525: iload 6
    //   527: istore 4
    //   529: aload 14
    //   531: invokevirtual 185	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   534: invokevirtual 191	com/tencent/qqmusic/mediaplayer/AudioInformation:getDuration	()J
    //   537: lstore 7
    //   539: goto +77 -> 616
    //   542: iload 6
    //   544: istore 4
    //   546: new 52	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   553: astore 17
    //   555: iload 6
    //   557: istore 4
    //   559: aload 17
    //   561: ldc 193
    //   563: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: iload 6
    //   569: istore 4
    //   571: aload 17
    //   573: iload_1
    //   574: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: iload 6
    //   580: istore 4
    //   582: aload 17
    //   584: ldc 198
    //   586: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: iload 6
    //   592: istore 4
    //   594: aload 17
    //   596: aload 13
    //   598: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: iload 6
    //   604: istore 4
    //   606: ldc 8
    //   608: aload 17
    //   610: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 201	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: iload 5
    //   618: istore_1
    //   619: iload 6
    //   621: istore 4
    //   623: aload 14
    //   625: invokevirtual 204	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   628: pop
    //   629: goto +59 -> 688
    //   632: iload 6
    //   634: istore 4
    //   636: new 52	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   643: astore 10
    //   645: iload 6
    //   647: istore 4
    //   649: aload 10
    //   651: ldc 206
    //   653: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: iload 6
    //   659: istore 4
    //   661: aload 10
    //   663: aload_0
    //   664: getfield 21	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mUri	Ljava/lang/String;
    //   667: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: iload 6
    //   673: istore 4
    //   675: new 92	java/io/IOException
    //   678: dup
    //   679: aload 10
    //   681: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokespecial 207	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   687: athrow
    //   688: iload 6
    //   690: istore 4
    //   692: aload 18
    //   694: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   697: invokevirtual 139	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   700: ldc 209
    //   702: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   705: ifeq +874 -> 1579
    //   708: iload 6
    //   710: istore 4
    //   712: new 154	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   715: dup
    //   716: getstatic 215	com/tencent/qqmusic/mediaplayer/audioplaylist/AudioPlayListItemInfo:TYPE_CUE	I
    //   719: invokespecial 218	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:<init>	(I)V
    //   722: astore 14
    //   724: iload 6
    //   726: istore 4
    //   728: aload 14
    //   730: aload 13
    //   732: invokevirtual 221	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setFilePath	(Ljava/lang/String;)V
    //   735: iload_3
    //   736: iconst_1
    //   737: iadd
    //   738: istore_1
    //   739: iconst_1
    //   740: istore_3
    //   741: goto +3 -> 744
    //   744: iload_3
    //   745: ifeq +37 -> 782
    //   748: iload 6
    //   750: istore 4
    //   752: aload 18
    //   754: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   757: invokevirtual 139	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   760: ldc 150
    //   762: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   765: ifeq +17 -> 782
    //   768: iload 6
    //   770: istore 4
    //   772: aload 14
    //   774: aload 18
    //   776: invokestatic 148	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   779: invokevirtual 224	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setTitle	(Ljava/lang/String;)V
    //   782: iload_3
    //   783: ifeq +37 -> 820
    //   786: iload 6
    //   788: istore 4
    //   790: aload 18
    //   792: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   795: invokevirtual 139	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   798: ldc 141
    //   800: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   803: ifeq +17 -> 820
    //   806: iload 6
    //   808: istore 4
    //   810: aload 14
    //   812: aload 18
    //   814: invokestatic 148	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:delSeprator	(Ljava/lang/String;)Ljava/lang/String;
    //   817: invokevirtual 227	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setPerformer	(Ljava/lang/String;)V
    //   820: iload_1
    //   821: iconst_1
    //   822: if_icmpne +85 -> 907
    //   825: iload 6
    //   827: istore 4
    //   829: aload 18
    //   831: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   834: invokevirtual 139	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   837: ldc 229
    //   839: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   842: ifeq +65 -> 907
    //   845: iload 6
    //   847: istore 4
    //   849: aload 18
    //   851: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   854: ldc 231
    //   856: invokevirtual 234	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   859: ifeq +34 -> 893
    //   862: iload 6
    //   864: istore 4
    //   866: aload 14
    //   868: aload_0
    //   869: aload 18
    //   871: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   874: ldc 231
    //   876: invokevirtual 37	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   879: iconst_1
    //   880: aaload
    //   881: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   884: invokespecial 236	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   887: invokevirtual 239	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setStartPosition	(J)V
    //   890: goto +17 -> 907
    //   893: iload 6
    //   895: istore 4
    //   897: new 92	java/io/IOException
    //   900: dup
    //   901: ldc 241
    //   903: invokespecial 207	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   906: athrow
    //   907: iload_1
    //   908: iconst_2
    //   909: if_icmplt +685 -> 1594
    //   912: iload 6
    //   914: istore 4
    //   916: aload 18
    //   918: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   921: invokevirtual 139	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   924: ldc 229
    //   926: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   929: ifeq +665 -> 1594
    //   932: iload 6
    //   934: istore 4
    //   936: aload 18
    //   938: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   941: ldc 243
    //   943: invokevirtual 234	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   946: ifeq +58 -> 1004
    //   949: iload 6
    //   951: istore 4
    //   953: aload 18
    //   955: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   958: ldc 243
    //   960: invokevirtual 37	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   963: iconst_1
    //   964: aaload
    //   965: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   968: astore 11
    //   970: iload 6
    //   972: istore 4
    //   974: aload_0
    //   975: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   978: iload_1
    //   979: iconst_2
    //   980: isub
    //   981: invokeinterface 247 2 0
    //   986: checkcast 154	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   989: aload_0
    //   990: aload 11
    //   992: invokespecial 236	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   995: invokevirtual 158	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   998: iconst_1
    //   999: istore 5
    //   1001: goto +156 -> 1157
    //   1004: iload 6
    //   1006: istore 4
    //   1008: aload 18
    //   1010: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   1013: ldc 231
    //   1015: invokevirtual 234	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1018: ifeq +74 -> 1092
    //   1021: iload 6
    //   1023: istore 4
    //   1025: aload 18
    //   1027: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   1030: ldc 231
    //   1032: invokevirtual 37	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1035: iconst_1
    //   1036: aaload
    //   1037: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   1040: astore 11
    //   1042: iload 6
    //   1044: istore 4
    //   1046: aload 14
    //   1048: aload_0
    //   1049: aload 11
    //   1051: invokespecial 236	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   1054: invokevirtual 239	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setStartPosition	(J)V
    //   1057: iload_2
    //   1058: ifne +536 -> 1594
    //   1061: iload 6
    //   1063: istore 4
    //   1065: aload_0
    //   1066: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1069: iload_1
    //   1070: iconst_2
    //   1071: isub
    //   1072: invokeinterface 247 2 0
    //   1077: checkcast 154	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1080: aload_0
    //   1081: aload 11
    //   1083: invokespecial 236	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:convertTimeStrToMs	(Ljava/lang/String;)J
    //   1086: invokevirtual 158	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   1089: goto +505 -> 1594
    //   1092: iload 6
    //   1094: istore 4
    //   1096: new 52	java/lang/StringBuilder
    //   1099: dup
    //   1100: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1103: astore 10
    //   1105: iload 6
    //   1107: istore 4
    //   1109: aload 10
    //   1111: ldc 249
    //   1113: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: iload 6
    //   1119: istore 4
    //   1121: aload 10
    //   1123: iload_1
    //   1124: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: iload 6
    //   1130: istore 4
    //   1132: aload 10
    //   1134: ldc 251
    //   1136: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: pop
    //   1140: iload 6
    //   1142: istore 4
    //   1144: new 92	java/io/IOException
    //   1147: dup
    //   1148: aload 10
    //   1150: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokespecial 207	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1156: athrow
    //   1157: aload 14
    //   1159: astore 11
    //   1161: iload 5
    //   1163: istore_2
    //   1164: iload_1
    //   1165: iconst_1
    //   1166: if_icmplt +434 -> 1600
    //   1169: iload 6
    //   1171: istore 4
    //   1173: aload 14
    //   1175: astore 11
    //   1177: iload 5
    //   1179: istore_2
    //   1180: aload 18
    //   1182: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   1185: invokevirtual 139	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1188: ldc 229
    //   1190: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1193: ifeq +407 -> 1600
    //   1196: iload 6
    //   1198: istore 4
    //   1200: aload 14
    //   1202: astore 11
    //   1204: iload 5
    //   1206: istore_2
    //   1207: aload 18
    //   1209: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   1212: ldc 231
    //   1214: invokevirtual 234	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1217: ifeq +383 -> 1600
    //   1220: iload 6
    //   1222: istore 4
    //   1224: aload_0
    //   1225: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1228: aload 14
    //   1230: invokeinterface 255 2 0
    //   1235: pop
    //   1236: iload 6
    //   1238: istore 4
    //   1240: new 154	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1243: dup
    //   1244: getstatic 215	com/tencent/qqmusic/mediaplayer/audioplaylist/AudioPlayListItemInfo:TYPE_CUE	I
    //   1247: invokespecial 218	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:<init>	(I)V
    //   1250: astore 11
    //   1252: iload 6
    //   1254: istore 4
    //   1256: aload 11
    //   1258: aload 13
    //   1260: invokevirtual 221	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setFilePath	(Ljava/lang/String;)V
    //   1263: iconst_0
    //   1264: istore_2
    //   1265: goto +335 -> 1600
    //   1268: iload 6
    //   1270: istore 4
    //   1272: aload_0
    //   1273: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1276: invokeinterface 83 1 0
    //   1281: ifne +207 -> 1488
    //   1284: iload 6
    //   1286: istore 4
    //   1288: aload_0
    //   1289: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1292: aload_0
    //   1293: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1296: invokeinterface 258 1 0
    //   1301: iconst_1
    //   1302: isub
    //   1303: invokeinterface 247 2 0
    //   1308: checkcast 154	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1311: astore 10
    //   1313: lload 7
    //   1315: lconst_0
    //   1316: lcmp
    //   1317: ifeq +302 -> 1619
    //   1320: iload 6
    //   1322: istore 4
    //   1324: aload 10
    //   1326: invokevirtual 262	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getRange	()Landroid/util/Pair;
    //   1329: ifnull +290 -> 1619
    //   1332: iload 6
    //   1334: istore 4
    //   1336: aload 10
    //   1338: invokevirtual 262	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getRange	()Landroid/util/Pair;
    //   1341: getfield 268	android/util/Pair:second	Ljava/lang/Object;
    //   1344: checkcast 39	java/lang/Long
    //   1347: invokevirtual 271	java/lang/Long:longValue	()J
    //   1350: lconst_0
    //   1351: lcmp
    //   1352: ifne +267 -> 1619
    //   1355: iload 6
    //   1357: istore 4
    //   1359: aload 10
    //   1361: lload 7
    //   1363: invokevirtual 158	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setEndPostion	(J)V
    //   1366: goto +253 -> 1619
    //   1369: iload 6
    //   1371: istore 4
    //   1373: iload_1
    //   1374: aload_0
    //   1375: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1378: invokeinterface 258 1 0
    //   1383: if_icmpge +105 -> 1488
    //   1386: iload 6
    //   1388: istore 4
    //   1390: aload_0
    //   1391: getfield 26	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mTrackInfoList	Ljava/util/List;
    //   1394: iload_1
    //   1395: invokeinterface 247 2 0
    //   1400: checkcast 154	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo
    //   1403: astore 10
    //   1405: iload 6
    //   1407: istore 4
    //   1409: aload 12
    //   1411: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1414: ifne +29 -> 1443
    //   1417: iload 6
    //   1419: istore 4
    //   1421: aload 10
    //   1423: invokevirtual 274	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getAlbum	()Ljava/lang/String;
    //   1426: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1429: ifeq +14 -> 1443
    //   1432: iload 6
    //   1434: istore 4
    //   1436: aload 10
    //   1438: aload 12
    //   1440: invokevirtual 277	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setAlbum	(Ljava/lang/String;)V
    //   1443: iload 6
    //   1445: istore 4
    //   1447: aload 14
    //   1449: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1452: ifne +29 -> 1481
    //   1455: iload 6
    //   1457: istore 4
    //   1459: aload 10
    //   1461: invokevirtual 280	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:getPerformer	()Ljava/lang/String;
    //   1464: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1467: ifeq +14 -> 1481
    //   1470: iload 6
    //   1472: istore 4
    //   1474: aload 10
    //   1476: aload 14
    //   1478: invokevirtual 227	com/tencent/qqmusic/mediaplayer/audioplaylist/TrackInfo:setPerformer	(Ljava/lang/String;)V
    //   1481: iload_1
    //   1482: iconst_1
    //   1483: iadd
    //   1484: istore_1
    //   1485: goto -116 -> 1369
    //   1488: aload_0
    //   1489: getfield 121	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   1492: invokevirtual 283	java/io/LineNumberReader:close	()V
    //   1495: return
    //   1496: astore 10
    //   1498: ldc 8
    //   1500: ldc_w 285
    //   1503: aload 10
    //   1505: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1508: return
    //   1509: astore 10
    //   1511: goto +13 -> 1524
    //   1514: astore 10
    //   1516: goto +23 -> 1539
    //   1519: astore 10
    //   1521: iconst_0
    //   1522: istore 4
    //   1524: new 290	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/ParseException
    //   1527: dup
    //   1528: ldc_w 292
    //   1531: aload 10
    //   1533: iload 4
    //   1535: invokespecial 295	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/ParseException:<init>	(Ljava/lang/String;Ljava/lang/Exception;I)V
    //   1538: athrow
    //   1539: aload_0
    //   1540: getfield 121	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/CueItemParser:mReader	Ljava/io/LineNumberReader;
    //   1543: invokevirtual 283	java/io/LineNumberReader:close	()V
    //   1546: goto +15 -> 1561
    //   1549: astore 11
    //   1551: ldc 8
    //   1553: ldc_w 285
    //   1556: aload 11
    //   1558: invokestatic 288	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1561: goto +6 -> 1567
    //   1564: aload 10
    //   1566: athrow
    //   1567: goto -3 -> 1564
    //   1570: goto -1318 -> 252
    //   1573: goto -1181 -> 392
    //   1576: goto -888 -> 688
    //   1579: iload_1
    //   1580: istore 4
    //   1582: iload_3
    //   1583: istore_1
    //   1584: iload 4
    //   1586: istore_3
    //   1587: aload 11
    //   1589: astore 14
    //   1591: goto -847 -> 744
    //   1594: iload_2
    //   1595: istore 5
    //   1597: goto -440 -> 1157
    //   1600: iload_3
    //   1601: istore 4
    //   1603: iload_1
    //   1604: istore_3
    //   1605: iload 4
    //   1607: istore_1
    //   1608: aload 10
    //   1610: astore 14
    //   1612: iload 6
    //   1614: istore 5
    //   1616: goto -1487 -> 129
    //   1619: iconst_0
    //   1620: istore_1
    //   1621: goto -252 -> 1369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1624	0	this	CueItemParser
    //   118	1503	1	i	int
    //   123	1472	2	j	int
    //   125	1480	3	k	int
    //   131	1475	4	m	int
    //   127	1488	5	n	int
    //   153	1460	6	i1	int
    //   120	1242	7	l	long
    //   164	3	9	bool	boolean
    //   11	1464	10	localObject1	java.lang.Object
    //   1496	8	10	localException1	java.lang.Exception
    //   1509	1	10	localIOException1	java.io.IOException
    //   1514	1	10	localObject2	java.lang.Object
    //   1519	90	10	localIOException2	java.io.IOException
    //   103	1154	11	localObject3	java.lang.Object
    //   1549	39	11	localException2	java.lang.Exception
    //   107	1332	12	localObject4	java.lang.Object
    //   115	1144	13	localObject5	java.lang.Object
    //   111	1500	14	localObject6	java.lang.Object
    //   2	401	15	str1	String
    //   52	269	16	localFile	java.io.File
    //   314	295	17	localObject7	java.lang.Object
    //   140	1068	18	str2	String
    // Exception table:
    //   from	to	target	type
    //   1488	1495	1496	java/lang/Exception
    //   133	142	1509	java/io/IOException
    //   146	155	1509	java/io/IOException
    //   159	166	1509	java/io/IOException
    //   187	203	1509	java/io/IOException
    //   207	214	1509	java/io/IOException
    //   222	238	1509	java/io/IOException
    //   242	249	1509	java/io/IOException
    //   256	272	1509	java/io/IOException
    //   298	305	1509	java/io/IOException
    //   309	316	1509	java/io/IOException
    //   320	327	1509	java/io/IOException
    //   331	341	1509	java/io/IOException
    //   345	354	1509	java/io/IOException
    //   358	366	1509	java/io/IOException
    //   370	378	1509	java/io/IOException
    //   382	389	1509	java/io/IOException
    //   400	410	1509	java/io/IOException
    //   414	422	1509	java/io/IOException
    //   426	435	1509	java/io/IOException
    //   439	447	1509	java/io/IOException
    //   451	459	1509	java/io/IOException
    //   463	470	1509	java/io/IOException
    //   474	489	1509	java/io/IOException
    //   493	502	1509	java/io/IOException
    //   506	521	1509	java/io/IOException
    //   529	539	1509	java/io/IOException
    //   546	555	1509	java/io/IOException
    //   559	567	1509	java/io/IOException
    //   571	578	1509	java/io/IOException
    //   582	590	1509	java/io/IOException
    //   594	602	1509	java/io/IOException
    //   606	616	1509	java/io/IOException
    //   623	629	1509	java/io/IOException
    //   636	645	1509	java/io/IOException
    //   649	657	1509	java/io/IOException
    //   661	671	1509	java/io/IOException
    //   675	688	1509	java/io/IOException
    //   692	708	1509	java/io/IOException
    //   712	724	1509	java/io/IOException
    //   728	735	1509	java/io/IOException
    //   752	768	1509	java/io/IOException
    //   772	782	1509	java/io/IOException
    //   790	806	1509	java/io/IOException
    //   810	820	1509	java/io/IOException
    //   829	845	1509	java/io/IOException
    //   849	862	1509	java/io/IOException
    //   866	890	1509	java/io/IOException
    //   897	907	1509	java/io/IOException
    //   916	932	1509	java/io/IOException
    //   936	949	1509	java/io/IOException
    //   953	970	1509	java/io/IOException
    //   974	998	1509	java/io/IOException
    //   1008	1021	1509	java/io/IOException
    //   1025	1042	1509	java/io/IOException
    //   1046	1057	1509	java/io/IOException
    //   1065	1089	1509	java/io/IOException
    //   1096	1105	1509	java/io/IOException
    //   1109	1117	1509	java/io/IOException
    //   1121	1128	1509	java/io/IOException
    //   1132	1140	1509	java/io/IOException
    //   1144	1157	1509	java/io/IOException
    //   1180	1196	1509	java/io/IOException
    //   1207	1220	1509	java/io/IOException
    //   1224	1236	1509	java/io/IOException
    //   1240	1252	1509	java/io/IOException
    //   1256	1263	1509	java/io/IOException
    //   1272	1284	1509	java/io/IOException
    //   1288	1313	1509	java/io/IOException
    //   1324	1332	1509	java/io/IOException
    //   1336	1355	1509	java/io/IOException
    //   1359	1366	1509	java/io/IOException
    //   1373	1386	1509	java/io/IOException
    //   1390	1405	1509	java/io/IOException
    //   1409	1417	1509	java/io/IOException
    //   1421	1432	1509	java/io/IOException
    //   1436	1443	1509	java/io/IOException
    //   1447	1455	1509	java/io/IOException
    //   1459	1470	1509	java/io/IOException
    //   1474	1481	1509	java/io/IOException
    //   63	102	1514	finally
    //   133	142	1514	finally
    //   146	155	1514	finally
    //   159	166	1514	finally
    //   187	203	1514	finally
    //   207	214	1514	finally
    //   222	238	1514	finally
    //   242	249	1514	finally
    //   256	272	1514	finally
    //   298	305	1514	finally
    //   309	316	1514	finally
    //   320	327	1514	finally
    //   331	341	1514	finally
    //   345	354	1514	finally
    //   358	366	1514	finally
    //   370	378	1514	finally
    //   382	389	1514	finally
    //   400	410	1514	finally
    //   414	422	1514	finally
    //   426	435	1514	finally
    //   439	447	1514	finally
    //   451	459	1514	finally
    //   463	470	1514	finally
    //   474	489	1514	finally
    //   493	502	1514	finally
    //   506	521	1514	finally
    //   529	539	1514	finally
    //   546	555	1514	finally
    //   559	567	1514	finally
    //   571	578	1514	finally
    //   582	590	1514	finally
    //   594	602	1514	finally
    //   606	616	1514	finally
    //   623	629	1514	finally
    //   636	645	1514	finally
    //   649	657	1514	finally
    //   661	671	1514	finally
    //   675	688	1514	finally
    //   692	708	1514	finally
    //   712	724	1514	finally
    //   728	735	1514	finally
    //   752	768	1514	finally
    //   772	782	1514	finally
    //   790	806	1514	finally
    //   810	820	1514	finally
    //   829	845	1514	finally
    //   849	862	1514	finally
    //   866	890	1514	finally
    //   897	907	1514	finally
    //   916	932	1514	finally
    //   936	949	1514	finally
    //   953	970	1514	finally
    //   974	998	1514	finally
    //   1008	1021	1514	finally
    //   1025	1042	1514	finally
    //   1046	1057	1514	finally
    //   1065	1089	1514	finally
    //   1096	1105	1514	finally
    //   1109	1117	1514	finally
    //   1121	1128	1514	finally
    //   1132	1140	1514	finally
    //   1144	1157	1514	finally
    //   1180	1196	1514	finally
    //   1207	1220	1514	finally
    //   1224	1236	1514	finally
    //   1240	1252	1514	finally
    //   1256	1263	1514	finally
    //   1272	1284	1514	finally
    //   1288	1313	1514	finally
    //   1324	1332	1514	finally
    //   1336	1355	1514	finally
    //   1359	1366	1514	finally
    //   1373	1386	1514	finally
    //   1390	1405	1514	finally
    //   1409	1417	1514	finally
    //   1421	1432	1514	finally
    //   1436	1443	1514	finally
    //   1447	1455	1514	finally
    //   1459	1470	1514	finally
    //   1474	1481	1514	finally
    //   1524	1539	1514	finally
    //   63	102	1519	java/io/IOException
    //   1539	1546	1549	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.CueItemParser
 * JD-Core Version:    0.7.0.1
 */