import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;

public class ljj
  implements Runnable
{
  public ljj(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore_3
    //   8: new 21	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   15: aload_0
    //   16: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   19: invokestatic 27	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   22: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 33
    //   27: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 26
    //   35: iload 4
    //   37: istore_1
    //   38: iload 5
    //   40: istore_2
    //   41: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +40 -> 84
    //   47: iload 4
    //   49: istore_1
    //   50: iload 5
    //   52: istore_2
    //   53: ldc 45
    //   55: iconst_2
    //   56: new 21	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   63: ldc 47
    //   65: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   72: invokestatic 50	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Z
    //   75: invokevirtual 53	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   78: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: iload 4
    //   86: istore_1
    //   87: iload 5
    //   89: istore_2
    //   90: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   93: lstore 9
    //   95: iload 4
    //   97: istore_1
    //   98: iload 5
    //   100: istore_2
    //   101: aload_0
    //   102: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   105: invokestatic 66	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/content/Context;
    //   108: aload_0
    //   109: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   112: invokestatic 69	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Lcom/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView;
    //   115: invokevirtual 74	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:c	()Ljava/lang/String;
    //   118: aload 26
    //   120: invokestatic 79	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)I
    //   123: istore 6
    //   125: iload 4
    //   127: istore_1
    //   128: iload 5
    //   130: istore_2
    //   131: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   134: lstore 11
    //   136: lconst_0
    //   137: lload 11
    //   139: lload 9
    //   141: lsub
    //   142: ladd
    //   143: lstore 7
    //   145: iload 4
    //   147: istore_1
    //   148: iload 5
    //   150: istore_2
    //   151: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +48 -> 202
    //   157: iload 4
    //   159: istore_1
    //   160: iload 5
    //   162: istore_2
    //   163: ldc 45
    //   165: iconst_2
    //   166: new 21	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   173: ldc 81
    //   175: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 6
    //   180: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 86
    //   185: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: lload 11
    //   190: lload 9
    //   192: lsub
    //   193: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   196: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: iload 6
    //   204: ifne +495 -> 699
    //   207: iload 4
    //   209: istore_1
    //   210: iload 5
    //   212: istore_2
    //   213: aload_0
    //   214: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   217: invokestatic 50	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Z
    //   220: ifeq +520 -> 740
    //   223: iload 4
    //   225: istore_1
    //   226: iload 5
    //   228: istore_2
    //   229: aload_0
    //   230: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   233: invokestatic 92	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:b	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   236: invokestatic 97	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   239: istore 25
    //   241: iload 25
    //   243: ifne +40 -> 283
    //   246: aload_0
    //   247: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   250: invokestatic 100	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/os/Handler;
    //   253: new 102	ljk
    //   256: dup
    //   257: aload_0
    //   258: invokespecial 105	ljk:<init>	(Lljj;)V
    //   261: invokevirtual 111	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   264: pop
    //   265: aload 26
    //   267: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   270: pop
    //   271: aload_0
    //   272: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   275: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   278: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   281: pop
    //   282: return
    //   283: iload 4
    //   285: istore_1
    //   286: iload 5
    //   288: istore_2
    //   289: aload_0
    //   290: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   293: invokestatic 92	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:b	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   296: astore 27
    //   298: iload 4
    //   300: istore_1
    //   301: iload 5
    //   303: istore_2
    //   304: aload_0
    //   305: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   308: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   311: astore 28
    //   313: iload 4
    //   315: istore_1
    //   316: iload 5
    //   318: istore_2
    //   319: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   322: lstore 9
    //   324: iload 4
    //   326: istore_1
    //   327: iload 5
    //   329: istore_2
    //   330: aload_0
    //   331: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   334: invokestatic 66	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/content/Context;
    //   337: aload 26
    //   339: aload 27
    //   341: aload 28
    //   343: invokestatic 118	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraVideoMergeHelper:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   346: istore_3
    //   347: iload 4
    //   349: istore_1
    //   350: iload 5
    //   352: istore_2
    //   353: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   356: lstore 11
    //   358: iload 4
    //   360: istore_1
    //   361: iload 5
    //   363: istore_2
    //   364: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +47 -> 414
    //   370: iload 4
    //   372: istore_1
    //   373: iload 5
    //   375: istore_2
    //   376: ldc 45
    //   378: iconst_2
    //   379: new 21	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   386: ldc 120
    //   388: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: iload_3
    //   392: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc 86
    //   397: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: lload 11
    //   402: lload 9
    //   404: lsub
    //   405: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   408: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   414: iload_3
    //   415: ifeq +40 -> 455
    //   418: aload_0
    //   419: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   422: invokestatic 100	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/os/Handler;
    //   425: new 102	ljk
    //   428: dup
    //   429: aload_0
    //   430: invokespecial 105	ljk:<init>	(Lljj;)V
    //   433: invokevirtual 111	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   436: pop
    //   437: aload 26
    //   439: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   442: pop
    //   443: aload_0
    //   444: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   447: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   450: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   453: pop
    //   454: return
    //   455: iconst_1
    //   456: istore 5
    //   458: iconst_1
    //   459: istore 6
    //   461: iconst_1
    //   462: istore 4
    //   464: iload 5
    //   466: istore_1
    //   467: iload 6
    //   469: istore_2
    //   470: aload_0
    //   471: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   474: aload 28
    //   476: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;Ljava/lang/String;)V
    //   479: iload 5
    //   481: istore_1
    //   482: iload 6
    //   484: istore_2
    //   485: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +105 -> 593
    //   491: iload 5
    //   493: istore_1
    //   494: iload 6
    //   496: istore_2
    //   497: ldc 45
    //   499: iconst_2
    //   500: new 21	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   507: ldc 125
    //   509: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 28
    //   514: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: ldc 127
    //   519: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: lload 7
    //   524: lload 11
    //   526: lload 9
    //   528: lsub
    //   529: ladd
    //   530: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   533: ldc 129
    //   535: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   542: invokestatic 69	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Lcom/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView;
    //   545: invokevirtual 133	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:h	()I
    //   548: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: ldc 135
    //   553: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_0
    //   557: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   560: invokestatic 69	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Lcom/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView;
    //   563: invokevirtual 138	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:f	()I
    //   566: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: ldc 140
    //   571: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_0
    //   575: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   578: invokestatic 69	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Lcom/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView;
    //   581: invokevirtual 143	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:g	()I
    //   584: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   587: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: iload 5
    //   595: istore_1
    //   596: iload 6
    //   598: istore_2
    //   599: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   602: lstore 7
    //   604: iload 5
    //   606: istore_1
    //   607: iload 6
    //   609: istore_2
    //   610: aload_0
    //   611: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   614: invokestatic 69	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Lcom/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView;
    //   617: invokevirtual 74	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:c	()Ljava/lang/String;
    //   620: invokestatic 146	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)V
    //   623: iload 5
    //   625: istore_1
    //   626: iload 6
    //   628: istore_2
    //   629: aload 26
    //   631: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   634: pop
    //   635: iload 5
    //   637: istore_1
    //   638: iload 6
    //   640: istore_2
    //   641: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   644: lstore 9
    //   646: iload 4
    //   648: istore_3
    //   649: iload 5
    //   651: istore_1
    //   652: iload 6
    //   654: istore_2
    //   655: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq +41 -> 699
    //   661: iload 5
    //   663: istore_1
    //   664: iload 6
    //   666: istore_2
    //   667: ldc 45
    //   669: iconst_2
    //   670: new 21	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   677: ldc 148
    //   679: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: lload 9
    //   684: lload 7
    //   686: lsub
    //   687: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   690: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: iload 4
    //   698: istore_3
    //   699: iload_3
    //   700: ifne -418 -> 282
    //   703: aload_0
    //   704: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   707: invokestatic 100	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/os/Handler;
    //   710: new 102	ljk
    //   713: dup
    //   714: aload_0
    //   715: invokespecial 105	ljk:<init>	(Lljj;)V
    //   718: invokevirtual 111	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   721: pop
    //   722: aload 26
    //   724: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   727: pop
    //   728: aload_0
    //   729: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   732: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   735: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   738: pop
    //   739: return
    //   740: iload 4
    //   742: istore_1
    //   743: iload 5
    //   745: istore_2
    //   746: aload_0
    //   747: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   750: invokestatic 69	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Lcom/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView;
    //   753: invokevirtual 150	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:d	()Ljava/lang/String;
    //   756: astore 27
    //   758: iload 4
    //   760: istore_1
    //   761: iload 5
    //   763: istore_2
    //   764: new 21	java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   771: aload_0
    //   772: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   775: invokestatic 27	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   778: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: ldc 152
    //   783: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   789: astore 28
    //   791: iload 4
    //   793: istore_1
    //   794: iload 5
    //   796: istore_2
    //   797: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   800: lstore 9
    //   802: iload 4
    //   804: istore_1
    //   805: iload 5
    //   807: istore_2
    //   808: aload 27
    //   810: aload 28
    //   812: invokestatic 155	com/tencent/mobileqq/utils/FileUtils:f	(Ljava/lang/String;Ljava/lang/String;)Z
    //   815: istore 25
    //   817: iload 4
    //   819: istore_1
    //   820: iload 5
    //   822: istore_2
    //   823: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   826: lstore 11
    //   828: iload 4
    //   830: istore_1
    //   831: iload 5
    //   833: istore_2
    //   834: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq +48 -> 885
    //   840: iload 4
    //   842: istore_1
    //   843: iload 5
    //   845: istore_2
    //   846: ldc 45
    //   848: iconst_2
    //   849: new 21	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   856: ldc 157
    //   858: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: iload 25
    //   863: invokevirtual 53	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   866: ldc 86
    //   868: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: lload 11
    //   873: lload 9
    //   875: lsub
    //   876: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   879: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   885: iload 25
    //   887: ifne +40 -> 927
    //   890: aload_0
    //   891: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   894: invokestatic 100	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/os/Handler;
    //   897: new 102	ljk
    //   900: dup
    //   901: aload_0
    //   902: invokespecial 105	ljk:<init>	(Lljj;)V
    //   905: invokevirtual 111	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   908: pop
    //   909: aload 26
    //   911: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   914: pop
    //   915: aload_0
    //   916: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   919: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   922: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   925: pop
    //   926: return
    //   927: iload 4
    //   929: istore_1
    //   930: iload 5
    //   932: istore_2
    //   933: new 21	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   940: aload_0
    //   941: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   944: invokestatic 27	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   947: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: ldc 159
    //   952: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   958: astore 29
    //   960: iload 4
    //   962: istore_1
    //   963: iload 5
    //   965: istore_2
    //   966: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   969: lstore 13
    //   971: iload 4
    //   973: istore_1
    //   974: iload 5
    //   976: istore_2
    //   977: aconst_null
    //   978: aconst_null
    //   979: iconst_0
    //   980: invokestatic 164	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   983: astore 30
    //   985: iload 4
    //   987: istore_1
    //   988: iload 5
    //   990: istore_2
    //   991: aload 30
    //   993: aload 29
    //   995: putfield 169	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:b	Ljava/lang/String;
    //   998: iload 4
    //   1000: istore_1
    //   1001: iload 5
    //   1003: istore_2
    //   1004: aload 30
    //   1006: aload 28
    //   1008: putfield 171	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:a	Ljava/lang/String;
    //   1011: iload 4
    //   1013: istore_1
    //   1014: iload 5
    //   1016: istore_2
    //   1017: aload 28
    //   1019: invokestatic 174	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;)I
    //   1022: istore_3
    //   1023: iload 4
    //   1025: istore_1
    //   1026: iload 5
    //   1028: istore_2
    //   1029: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   1032: lstore 15
    //   1034: iload 4
    //   1036: istore_1
    //   1037: iload 5
    //   1039: istore_2
    //   1040: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1043: ifeq +47 -> 1090
    //   1046: iload 4
    //   1048: istore_1
    //   1049: iload 5
    //   1051: istore_2
    //   1052: ldc 45
    //   1054: iconst_2
    //   1055: new 21	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   1062: ldc 176
    //   1064: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: iload_3
    //   1068: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1071: ldc 178
    //   1073: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: lload 15
    //   1078: lload 13
    //   1080: lsub
    //   1081: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1084: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: iload_3
    //   1091: ifeq +40 -> 1131
    //   1094: aload_0
    //   1095: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1098: invokestatic 100	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/os/Handler;
    //   1101: new 102	ljk
    //   1104: dup
    //   1105: aload_0
    //   1106: invokespecial 105	ljk:<init>	(Lljj;)V
    //   1109: invokevirtual 111	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1112: pop
    //   1113: aload 26
    //   1115: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1118: pop
    //   1119: aload_0
    //   1120: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1123: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   1126: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1129: pop
    //   1130: return
    //   1131: iload 4
    //   1133: istore_1
    //   1134: iload 5
    //   1136: istore_2
    //   1137: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   1140: lstore 17
    //   1142: iload 4
    //   1144: istore_1
    //   1145: iload 5
    //   1147: istore_2
    //   1148: aload 30
    //   1150: invokestatic 181	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;)I
    //   1153: istore_3
    //   1154: iload 4
    //   1156: istore_1
    //   1157: iload 5
    //   1159: istore_2
    //   1160: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   1163: lstore 19
    //   1165: iload 4
    //   1167: istore_1
    //   1168: iload 5
    //   1170: istore_2
    //   1171: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1174: ifeq +47 -> 1221
    //   1177: iload 4
    //   1179: istore_1
    //   1180: iload 5
    //   1182: istore_2
    //   1183: ldc 45
    //   1185: iconst_2
    //   1186: new 21	java/lang/StringBuilder
    //   1189: dup
    //   1190: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   1193: ldc 183
    //   1195: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: iload_3
    //   1199: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1202: ldc 86
    //   1204: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: lload 19
    //   1209: lload 17
    //   1211: lsub
    //   1212: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1215: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1218: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1221: iload_3
    //   1222: ifeq +40 -> 1262
    //   1225: aload_0
    //   1226: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1229: invokestatic 100	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/os/Handler;
    //   1232: new 102	ljk
    //   1235: dup
    //   1236: aload_0
    //   1237: invokespecial 105	ljk:<init>	(Lljj;)V
    //   1240: invokevirtual 111	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1243: pop
    //   1244: aload 26
    //   1246: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1249: pop
    //   1250: aload_0
    //   1251: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1254: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   1257: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1260: pop
    //   1261: return
    //   1262: iload 4
    //   1264: istore_1
    //   1265: iload 5
    //   1267: istore_2
    //   1268: aload_0
    //   1269: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1272: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   1275: astore 30
    //   1277: iload 4
    //   1279: istore_1
    //   1280: iload 5
    //   1282: istore_2
    //   1283: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   1286: lstore 21
    //   1288: iload 4
    //   1290: istore_1
    //   1291: iload 5
    //   1293: istore_2
    //   1294: aload 26
    //   1296: aload 29
    //   1298: aload 30
    //   1300: iconst_0
    //   1301: invokestatic 188	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)I
    //   1304: istore_3
    //   1305: iload 4
    //   1307: istore_1
    //   1308: iload 5
    //   1310: istore_2
    //   1311: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   1314: lstore 23
    //   1316: iload 4
    //   1318: istore_1
    //   1319: iload 5
    //   1321: istore_2
    //   1322: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1325: ifeq +47 -> 1372
    //   1328: iload 4
    //   1330: istore_1
    //   1331: iload 5
    //   1333: istore_2
    //   1334: ldc 45
    //   1336: iconst_2
    //   1337: new 21	java/lang/StringBuilder
    //   1340: dup
    //   1341: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   1344: ldc 190
    //   1346: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: iload_3
    //   1350: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1353: ldc 86
    //   1355: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: lload 23
    //   1360: lload 21
    //   1362: lsub
    //   1363: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1366: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1372: iload_3
    //   1373: ifeq +40 -> 1413
    //   1376: aload_0
    //   1377: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1380: invokestatic 100	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/os/Handler;
    //   1383: new 102	ljk
    //   1386: dup
    //   1387: aload_0
    //   1388: invokespecial 105	ljk:<init>	(Lljj;)V
    //   1391: invokevirtual 111	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1394: pop
    //   1395: aload 26
    //   1397: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1400: pop
    //   1401: aload_0
    //   1402: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1405: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   1408: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1411: pop
    //   1412: return
    //   1413: iload 4
    //   1415: istore_1
    //   1416: iload 5
    //   1418: istore_2
    //   1419: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1422: ifeq +123 -> 1545
    //   1425: iload 4
    //   1427: istore_1
    //   1428: iload 5
    //   1430: istore_2
    //   1431: ldc 45
    //   1433: iconst_2
    //   1434: new 21	java/lang/StringBuilder
    //   1437: dup
    //   1438: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   1441: ldc 192
    //   1443: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: aload 30
    //   1448: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: ldc 127
    //   1453: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1456: lload 7
    //   1458: lload 11
    //   1460: lload 9
    //   1462: lsub
    //   1463: ladd
    //   1464: lload 15
    //   1466: lload 13
    //   1468: lsub
    //   1469: ladd
    //   1470: lload 19
    //   1472: lload 17
    //   1474: lsub
    //   1475: ladd
    //   1476: lload 23
    //   1478: lload 21
    //   1480: lsub
    //   1481: ladd
    //   1482: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1485: ldc 129
    //   1487: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: aload_0
    //   1491: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1494: invokestatic 69	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Lcom/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView;
    //   1497: invokevirtual 133	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:h	()I
    //   1500: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1503: ldc 135
    //   1505: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: aload_0
    //   1509: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1512: invokestatic 69	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Lcom/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView;
    //   1515: invokevirtual 138	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:f	()I
    //   1518: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1521: ldc 140
    //   1523: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: aload_0
    //   1527: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1530: invokestatic 69	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Lcom/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView;
    //   1533: invokevirtual 143	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:g	()I
    //   1536: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1539: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1542: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1545: iconst_1
    //   1546: istore 5
    //   1548: iconst_1
    //   1549: istore 6
    //   1551: iconst_1
    //   1552: istore 4
    //   1554: iload 5
    //   1556: istore_1
    //   1557: iload 6
    //   1559: istore_2
    //   1560: aload_0
    //   1561: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1564: aload 30
    //   1566: invokestatic 123	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;Ljava/lang/String;)V
    //   1569: iload 5
    //   1571: istore_1
    //   1572: iload 6
    //   1574: istore_2
    //   1575: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   1578: lstore 7
    //   1580: iload 5
    //   1582: istore_1
    //   1583: iload 6
    //   1585: istore_2
    //   1586: aload 27
    //   1588: invokestatic 146	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)V
    //   1591: iload 5
    //   1593: istore_1
    //   1594: iload 6
    //   1596: istore_2
    //   1597: aload 28
    //   1599: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1602: pop
    //   1603: iload 5
    //   1605: istore_1
    //   1606: iload 6
    //   1608: istore_2
    //   1609: aload 29
    //   1611: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1614: pop
    //   1615: iload 5
    //   1617: istore_1
    //   1618: iload 6
    //   1620: istore_2
    //   1621: aload_0
    //   1622: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1625: invokestatic 69	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Lcom/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView;
    //   1628: invokevirtual 74	com/tencent/mobileqq/richmedia/capture/view/SplitEffectsCameraCaptureView:c	()Ljava/lang/String;
    //   1631: invokestatic 146	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)V
    //   1634: iload 5
    //   1636: istore_1
    //   1637: iload 6
    //   1639: istore_2
    //   1640: aload 26
    //   1642: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1645: pop
    //   1646: iload 5
    //   1648: istore_1
    //   1649: iload 6
    //   1651: istore_2
    //   1652: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   1655: lstore 9
    //   1657: iload 4
    //   1659: istore_3
    //   1660: iload 5
    //   1662: istore_1
    //   1663: iload 6
    //   1665: istore_2
    //   1666: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1669: ifeq -970 -> 699
    //   1672: iload 5
    //   1674: istore_1
    //   1675: iload 6
    //   1677: istore_2
    //   1678: ldc 45
    //   1680: iconst_2
    //   1681: new 21	java/lang/StringBuilder
    //   1684: dup
    //   1685: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   1688: ldc 194
    //   1690: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1693: lload 9
    //   1695: lload 7
    //   1697: lsub
    //   1698: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1701: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1704: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1707: iload 4
    //   1709: istore_3
    //   1710: goto -1011 -> 699
    //   1713: astore 27
    //   1715: iload_1
    //   1716: istore_2
    //   1717: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1720: ifeq +15 -> 1735
    //   1723: iload_1
    //   1724: istore_2
    //   1725: ldc 45
    //   1727: iconst_2
    //   1728: ldc 196
    //   1730: aload 27
    //   1732: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1735: aload_0
    //   1736: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1739: invokestatic 100	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/os/Handler;
    //   1742: new 102	ljk
    //   1745: dup
    //   1746: aload_0
    //   1747: invokespecial 105	ljk:<init>	(Lljj;)V
    //   1750: invokevirtual 111	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1753: pop
    //   1754: aload 26
    //   1756: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1759: pop
    //   1760: aload_0
    //   1761: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1764: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   1767: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1770: pop
    //   1771: return
    //   1772: astore 27
    //   1774: iload_2
    //   1775: ifne +39 -> 1814
    //   1778: aload_0
    //   1779: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1782: invokestatic 100	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:a	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Landroid/os/Handler;
    //   1785: new 102	ljk
    //   1788: dup
    //   1789: aload_0
    //   1790: invokespecial 105	ljk:<init>	(Lljj;)V
    //   1793: invokevirtual 111	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1796: pop
    //   1797: aload 26
    //   1799: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1802: pop
    //   1803: aload_0
    //   1804: getfield 12	ljj:a	Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;
    //   1807: invokestatic 115	com/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity:c	(Lcom/tencent/biz/pubaccount/readinjoy/capture/ReadInJoyCameraCaptureActivity;)Ljava/lang/String;
    //   1810: invokestatic 113	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1813: pop
    //   1814: aload 27
    //   1816: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1817	0	this	ljj
    //   37	1687	1	i	int
    //   40	1735	2	j	int
    //   7	1703	3	k	int
    //   1	1707	4	m	int
    //   4	1669	5	n	int
    //   123	1553	6	i1	int
    //   143	1553	7	l1	long
    //   93	1601	9	l2	long
    //   134	1325	11	l3	long
    //   969	498	13	l4	long
    //   1032	433	15	l5	long
    //   1140	333	17	l6	long
    //   1163	308	19	l7	long
    //   1286	193	21	l8	long
    //   1314	163	23	l9	long
    //   239	647	25	bool	boolean
    //   33	1765	26	str1	java.lang.String
    //   296	1291	27	str2	java.lang.String
    //   1713	18	27	localException	java.lang.Exception
    //   1772	43	27	localObject1	Object
    //   311	1287	28	str3	java.lang.String
    //   958	652	29	str4	java.lang.String
    //   983	582	30	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   41	47	1713	java/lang/Exception
    //   53	84	1713	java/lang/Exception
    //   90	95	1713	java/lang/Exception
    //   101	125	1713	java/lang/Exception
    //   131	136	1713	java/lang/Exception
    //   151	157	1713	java/lang/Exception
    //   163	202	1713	java/lang/Exception
    //   213	223	1713	java/lang/Exception
    //   229	241	1713	java/lang/Exception
    //   289	298	1713	java/lang/Exception
    //   304	313	1713	java/lang/Exception
    //   319	324	1713	java/lang/Exception
    //   330	347	1713	java/lang/Exception
    //   353	358	1713	java/lang/Exception
    //   364	370	1713	java/lang/Exception
    //   376	414	1713	java/lang/Exception
    //   470	479	1713	java/lang/Exception
    //   485	491	1713	java/lang/Exception
    //   497	593	1713	java/lang/Exception
    //   599	604	1713	java/lang/Exception
    //   610	623	1713	java/lang/Exception
    //   629	635	1713	java/lang/Exception
    //   641	646	1713	java/lang/Exception
    //   655	661	1713	java/lang/Exception
    //   667	696	1713	java/lang/Exception
    //   746	758	1713	java/lang/Exception
    //   764	791	1713	java/lang/Exception
    //   797	802	1713	java/lang/Exception
    //   808	817	1713	java/lang/Exception
    //   823	828	1713	java/lang/Exception
    //   834	840	1713	java/lang/Exception
    //   846	885	1713	java/lang/Exception
    //   933	960	1713	java/lang/Exception
    //   966	971	1713	java/lang/Exception
    //   977	985	1713	java/lang/Exception
    //   991	998	1713	java/lang/Exception
    //   1004	1011	1713	java/lang/Exception
    //   1017	1023	1713	java/lang/Exception
    //   1029	1034	1713	java/lang/Exception
    //   1040	1046	1713	java/lang/Exception
    //   1052	1090	1713	java/lang/Exception
    //   1137	1142	1713	java/lang/Exception
    //   1148	1154	1713	java/lang/Exception
    //   1160	1165	1713	java/lang/Exception
    //   1171	1177	1713	java/lang/Exception
    //   1183	1221	1713	java/lang/Exception
    //   1268	1277	1713	java/lang/Exception
    //   1283	1288	1713	java/lang/Exception
    //   1294	1305	1713	java/lang/Exception
    //   1311	1316	1713	java/lang/Exception
    //   1322	1328	1713	java/lang/Exception
    //   1334	1372	1713	java/lang/Exception
    //   1419	1425	1713	java/lang/Exception
    //   1431	1545	1713	java/lang/Exception
    //   1560	1569	1713	java/lang/Exception
    //   1575	1580	1713	java/lang/Exception
    //   1586	1591	1713	java/lang/Exception
    //   1597	1603	1713	java/lang/Exception
    //   1609	1615	1713	java/lang/Exception
    //   1621	1634	1713	java/lang/Exception
    //   1640	1646	1713	java/lang/Exception
    //   1652	1657	1713	java/lang/Exception
    //   1666	1672	1713	java/lang/Exception
    //   1678	1707	1713	java/lang/Exception
    //   41	47	1772	finally
    //   53	84	1772	finally
    //   90	95	1772	finally
    //   101	125	1772	finally
    //   131	136	1772	finally
    //   151	157	1772	finally
    //   163	202	1772	finally
    //   213	223	1772	finally
    //   229	241	1772	finally
    //   289	298	1772	finally
    //   304	313	1772	finally
    //   319	324	1772	finally
    //   330	347	1772	finally
    //   353	358	1772	finally
    //   364	370	1772	finally
    //   376	414	1772	finally
    //   470	479	1772	finally
    //   485	491	1772	finally
    //   497	593	1772	finally
    //   599	604	1772	finally
    //   610	623	1772	finally
    //   629	635	1772	finally
    //   641	646	1772	finally
    //   655	661	1772	finally
    //   667	696	1772	finally
    //   746	758	1772	finally
    //   764	791	1772	finally
    //   797	802	1772	finally
    //   808	817	1772	finally
    //   823	828	1772	finally
    //   834	840	1772	finally
    //   846	885	1772	finally
    //   933	960	1772	finally
    //   966	971	1772	finally
    //   977	985	1772	finally
    //   991	998	1772	finally
    //   1004	1011	1772	finally
    //   1017	1023	1772	finally
    //   1029	1034	1772	finally
    //   1040	1046	1772	finally
    //   1052	1090	1772	finally
    //   1137	1142	1772	finally
    //   1148	1154	1772	finally
    //   1160	1165	1772	finally
    //   1171	1177	1772	finally
    //   1183	1221	1772	finally
    //   1268	1277	1772	finally
    //   1283	1288	1772	finally
    //   1294	1305	1772	finally
    //   1311	1316	1772	finally
    //   1322	1328	1772	finally
    //   1334	1372	1772	finally
    //   1419	1425	1772	finally
    //   1431	1545	1772	finally
    //   1560	1569	1772	finally
    //   1575	1580	1772	finally
    //   1586	1591	1772	finally
    //   1597	1603	1772	finally
    //   1609	1615	1772	finally
    //   1621	1634	1772	finally
    //   1640	1646	1772	finally
    //   1652	1657	1772	finally
    //   1666	1672	1772	finally
    //   1678	1707	1772	finally
    //   1717	1723	1772	finally
    //   1725	1735	1772	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljj
 * JD-Core Version:    0.7.0.1
 */