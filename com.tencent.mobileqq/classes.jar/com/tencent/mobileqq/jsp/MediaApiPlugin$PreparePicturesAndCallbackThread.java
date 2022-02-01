package com.tencent.mobileqq.jsp;

class MediaApiPlugin$PreparePicturesAndCallbackThread
  extends Thread
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString = "[]";
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  
  public MediaApiPlugin$PreparePicturesAndCallbackThread(MediaApiPlugin paramMediaApiPlugin, String paramString1, boolean paramBoolean, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_JavaLangString = paramString2;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 53	org/json/JSONArray
    //   3: dup
    //   4: invokespecial 54	org/json/JSONArray:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 39	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   12: arraylength
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: iload_2
    //   18: if_icmpge +55 -> 73
    //   21: aload_0
    //   22: invokevirtual 58	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:isInterrupted	()Z
    //   25: ifne +40 -> 65
    //   28: aload_3
    //   29: aload_0
    //   30: getfield 39	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   33: iload_1
    //   34: aaload
    //   35: aload_0
    //   36: getfield 35	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_Int	I
    //   39: aload_0
    //   40: getfield 37	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_d_of_type_Int	I
    //   43: aload_0
    //   44: getfield 31	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_Int	I
    //   47: aload_0
    //   48: getfield 33	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_Int	I
    //   51: invokestatic 63	com/tencent/mobileqq/jsp/MediaApiPlugin:a	(Ljava/lang/String;IIII)Lorg/json/JSONObject;
    //   54: invokevirtual 67	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   57: pop
    //   58: iload_1
    //   59: iconst_1
    //   60: iadd
    //   61: istore_1
    //   62: goto -46 -> 16
    //   65: new 51	java/lang/InterruptedException
    //   68: dup
    //   69: invokespecial 68	java/lang/InterruptedException:<init>	()V
    //   72: athrow
    //   73: aload_0
    //   74: invokevirtual 58	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:isInterrupted	()Z
    //   77: ifne +135 -> 212
    //   80: aload_0
    //   81: ldc 70
    //   83: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_3
    //   88: invokevirtual 76	org/json/JSONArray:toString	()Ljava/lang/String;
    //   91: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   94: aload_0
    //   95: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   98: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   101: ifnull +26 -> 127
    //   104: aload_0
    //   105: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   108: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   111: invokevirtual 84	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   114: ifeq +13 -> 127
    //   117: aload_0
    //   118: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   121: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   124: invokevirtual 87	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   127: aload_0
    //   128: getfield 27	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_Boolean	Z
    //   131: ifeq +6 -> 137
    //   134: goto +424 -> 558
    //   137: aload_0
    //   138: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   141: aload_0
    //   142: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   145: iconst_2
    //   146: anewarray 89	java/lang/String
    //   149: dup
    //   150: iconst_0
    //   151: aload_0
    //   152: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_0
    //   159: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   162: aastore
    //   163: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   166: return
    //   167: invokestatic 98	java/lang/System:gc	()V
    //   170: aload_0
    //   171: ldc 100
    //   173: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   176: aload_0
    //   177: ldc 23
    //   179: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   182: aload_0
    //   183: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   186: aload_0
    //   187: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: iconst_2
    //   191: anewarray 89	java/lang/String
    //   194: dup
    //   195: iconst_0
    //   196: aload_0
    //   197: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   200: aastore
    //   201: dup
    //   202: iconst_1
    //   203: aload_0
    //   204: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   207: aastore
    //   208: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   211: return
    //   212: new 51	java/lang/InterruptedException
    //   215: dup
    //   216: invokespecial 68	java/lang/InterruptedException:<init>	()V
    //   219: athrow
    //   220: astore_3
    //   221: goto +562 -> 783
    //   224: aload_0
    //   225: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   228: getfield 104	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   231: invokevirtual 109	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   234: astore_3
    //   235: aload_3
    //   236: ifnull +22 -> 258
    //   239: aload_3
    //   240: invokevirtual 114	android/app/Activity:isFinishing	()Z
    //   243: ifne +15 -> 258
    //   246: aload_0
    //   247: ldc 116
    //   249: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   252: aload_0
    //   253: ldc 23
    //   255: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   258: aload_0
    //   259: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   262: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   265: ifnull +26 -> 291
    //   268: aload_0
    //   269: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   272: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   275: invokevirtual 84	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   278: ifeq +13 -> 291
    //   281: aload_0
    //   282: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   285: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   288: invokevirtual 87	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   291: aload_0
    //   292: getfield 27	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_Boolean	Z
    //   295: ifeq +6 -> 301
    //   298: goto +260 -> 558
    //   301: aload_0
    //   302: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   305: aload_0
    //   306: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   309: iconst_2
    //   310: anewarray 89	java/lang/String
    //   313: dup
    //   314: iconst_0
    //   315: aload_0
    //   316: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   319: aastore
    //   320: dup
    //   321: iconst_1
    //   322: aload_0
    //   323: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   326: aastore
    //   327: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   330: return
    //   331: invokestatic 98	java/lang/System:gc	()V
    //   334: aload_0
    //   335: ldc 100
    //   337: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   340: aload_0
    //   341: ldc 23
    //   343: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   346: aload_0
    //   347: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   350: aload_0
    //   351: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   354: iconst_2
    //   355: anewarray 89	java/lang/String
    //   358: dup
    //   359: iconst_0
    //   360: aload_0
    //   361: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   364: aastore
    //   365: dup
    //   366: iconst_1
    //   367: aload_0
    //   368: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   371: aastore
    //   372: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   375: return
    //   376: aload_0
    //   377: ldc 118
    //   379: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   382: aload_0
    //   383: ldc 23
    //   385: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   388: aload_0
    //   389: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   392: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   395: ifnull +26 -> 421
    //   398: aload_0
    //   399: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   402: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   405: invokevirtual 84	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   408: ifeq +13 -> 421
    //   411: aload_0
    //   412: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   415: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   418: invokevirtual 87	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   421: aload_0
    //   422: getfield 27	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_Boolean	Z
    //   425: ifeq +6 -> 431
    //   428: goto +130 -> 558
    //   431: aload_0
    //   432: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   435: aload_0
    //   436: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   439: iconst_2
    //   440: anewarray 89	java/lang/String
    //   443: dup
    //   444: iconst_0
    //   445: aload_0
    //   446: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   449: aastore
    //   450: dup
    //   451: iconst_1
    //   452: aload_0
    //   453: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   456: aastore
    //   457: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   460: return
    //   461: invokestatic 98	java/lang/System:gc	()V
    //   464: aload_0
    //   465: ldc 100
    //   467: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   470: aload_0
    //   471: ldc 23
    //   473: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   476: aload_0
    //   477: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   480: aload_0
    //   481: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   484: iconst_2
    //   485: anewarray 89	java/lang/String
    //   488: dup
    //   489: iconst_0
    //   490: aload_0
    //   491: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   494: aastore
    //   495: dup
    //   496: iconst_1
    //   497: aload_0
    //   498: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   501: aastore
    //   502: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   505: return
    //   506: aload_0
    //   507: ldc 118
    //   509: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   512: aload_0
    //   513: ldc 23
    //   515: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   518: aload_0
    //   519: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   522: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   525: ifnull +26 -> 551
    //   528: aload_0
    //   529: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   532: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   535: invokevirtual 84	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   538: ifeq +13 -> 551
    //   541: aload_0
    //   542: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   545: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   548: invokevirtual 87	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   551: aload_0
    //   552: getfield 27	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_Boolean	Z
    //   555: ifeq +20 -> 575
    //   558: aload_0
    //   559: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   562: aload_0
    //   563: getfield 41	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   566: iconst_0
    //   567: aload_0
    //   568: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   571: invokevirtual 122	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   574: return
    //   575: aload_0
    //   576: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   579: aload_0
    //   580: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   583: iconst_2
    //   584: anewarray 89	java/lang/String
    //   587: dup
    //   588: iconst_0
    //   589: aload_0
    //   590: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   593: aastore
    //   594: dup
    //   595: iconst_1
    //   596: aload_0
    //   597: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   600: aastore
    //   601: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   604: return
    //   605: invokestatic 98	java/lang/System:gc	()V
    //   608: aload_0
    //   609: ldc 100
    //   611: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   614: aload_0
    //   615: ldc 23
    //   617: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   620: aload_0
    //   621: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   624: aload_0
    //   625: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   628: iconst_2
    //   629: anewarray 89	java/lang/String
    //   632: dup
    //   633: iconst_0
    //   634: aload_0
    //   635: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   638: aastore
    //   639: dup
    //   640: iconst_1
    //   641: aload_0
    //   642: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   645: aastore
    //   646: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   649: return
    //   650: invokestatic 98	java/lang/System:gc	()V
    //   653: aload_0
    //   654: ldc 100
    //   656: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   659: aload_0
    //   660: ldc 23
    //   662: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   665: aload_0
    //   666: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   669: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   672: ifnull +26 -> 698
    //   675: aload_0
    //   676: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   679: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   682: invokevirtual 84	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   685: ifeq +13 -> 698
    //   688: aload_0
    //   689: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   692: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   695: invokevirtual 87	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   698: aload_0
    //   699: getfield 27	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_Boolean	Z
    //   702: ifeq +6 -> 708
    //   705: goto -147 -> 558
    //   708: aload_0
    //   709: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   712: aload_0
    //   713: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   716: iconst_2
    //   717: anewarray 89	java/lang/String
    //   720: dup
    //   721: iconst_0
    //   722: aload_0
    //   723: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   726: aastore
    //   727: dup
    //   728: iconst_1
    //   729: aload_0
    //   730: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   733: aastore
    //   734: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   737: return
    //   738: invokestatic 98	java/lang/System:gc	()V
    //   741: aload_0
    //   742: ldc 100
    //   744: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   747: aload_0
    //   748: ldc 23
    //   750: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   753: aload_0
    //   754: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   757: aload_0
    //   758: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   761: iconst_2
    //   762: anewarray 89	java/lang/String
    //   765: dup
    //   766: iconst_0
    //   767: aload_0
    //   768: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   771: aastore
    //   772: dup
    //   773: iconst_1
    //   774: aload_0
    //   775: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   778: aastore
    //   779: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   782: return
    //   783: aload_0
    //   784: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   787: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   790: ifnull +26 -> 816
    //   793: aload_0
    //   794: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   797: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   800: invokevirtual 84	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   803: ifeq +13 -> 816
    //   806: aload_0
    //   807: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   810: getfield 79	com/tencent/mobileqq/jsp/MediaApiPlugin:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   813: invokevirtual 87	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   816: aload_0
    //   817: getfield 27	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_Boolean	Z
    //   820: ifeq +22 -> 842
    //   823: aload_0
    //   824: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   827: aload_0
    //   828: getfield 41	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   831: iconst_0
    //   832: aload_0
    //   833: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   836: invokevirtual 122	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs4OpenApiIfNeeded	(Ljava/lang/String;ILjava/lang/String;)V
    //   839: goto +79 -> 918
    //   842: aload_0
    //   843: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   846: aload_0
    //   847: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   850: iconst_2
    //   851: anewarray 89	java/lang/String
    //   854: dup
    //   855: iconst_0
    //   856: aload_0
    //   857: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   860: aastore
    //   861: dup
    //   862: iconst_1
    //   863: aload_0
    //   864: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   867: aastore
    //   868: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   871: goto +47 -> 918
    //   874: invokestatic 98	java/lang/System:gc	()V
    //   877: aload_0
    //   878: ldc 100
    //   880: putfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   883: aload_0
    //   884: ldc 23
    //   886: putfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   889: aload_0
    //   890: getfield 18	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:this$0	Lcom/tencent/mobileqq/jsp/MediaApiPlugin;
    //   893: aload_0
    //   894: getfield 29	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   897: iconst_2
    //   898: anewarray 89	java/lang/String
    //   901: dup
    //   902: iconst_0
    //   903: aload_0
    //   904: getfield 72	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   907: aastore
    //   908: dup
    //   909: iconst_1
    //   910: aload_0
    //   911: getfield 25	com/tencent/mobileqq/jsp/MediaApiPlugin$PreparePicturesAndCallbackThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   914: aastore
    //   915: invokevirtual 93	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   918: goto +5 -> 923
    //   921: aload_3
    //   922: athrow
    //   923: goto -2 -> 921
    //   926: astore_3
    //   927: goto -277 -> 650
    //   930: astore_3
    //   931: goto -425 -> 506
    //   934: astore_3
    //   935: goto -559 -> 376
    //   938: astore_3
    //   939: goto -715 -> 224
    //   942: astore_3
    //   943: goto -776 -> 167
    //   946: astore_3
    //   947: goto -616 -> 331
    //   950: astore_3
    //   951: goto -490 -> 461
    //   954: astore_3
    //   955: goto -350 -> 605
    //   958: astore_3
    //   959: goto -221 -> 738
    //   962: astore 4
    //   964: goto -90 -> 874
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	967	0	this	PreparePicturesAndCallbackThread
    //   15	47	1	i	int
    //   13	6	2	j	int
    //   7	81	3	localJSONArray	org.json.JSONArray
    //   220	1	3	localObject	java.lang.Object
    //   234	688	3	localActivity	android.app.Activity
    //   926	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   930	1	3	localIOException	java.io.IOException
    //   934	1	3	localJSONException	org.json.JSONException
    //   938	1	3	localInterruptedException	java.lang.InterruptedException
    //   942	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   946	1	3	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   950	1	3	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   954	1	3	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   958	1	3	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   962	1	4	localOutOfMemoryError7	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   8	14	220	finally
    //   21	58	220	finally
    //   65	73	220	finally
    //   73	94	220	finally
    //   212	220	220	finally
    //   224	235	220	finally
    //   239	258	220	finally
    //   376	388	220	finally
    //   506	518	220	finally
    //   650	665	220	finally
    //   8	14	926	java/lang/OutOfMemoryError
    //   21	58	926	java/lang/OutOfMemoryError
    //   65	73	926	java/lang/OutOfMemoryError
    //   73	94	926	java/lang/OutOfMemoryError
    //   212	220	926	java/lang/OutOfMemoryError
    //   8	14	930	java/io/IOException
    //   21	58	930	java/io/IOException
    //   65	73	930	java/io/IOException
    //   73	94	930	java/io/IOException
    //   212	220	930	java/io/IOException
    //   8	14	934	org/json/JSONException
    //   21	58	934	org/json/JSONException
    //   65	73	934	org/json/JSONException
    //   73	94	934	org/json/JSONException
    //   212	220	934	org/json/JSONException
    //   8	14	938	java/lang/InterruptedException
    //   21	58	938	java/lang/InterruptedException
    //   65	73	938	java/lang/InterruptedException
    //   73	94	938	java/lang/InterruptedException
    //   212	220	938	java/lang/InterruptedException
    //   137	166	942	java/lang/OutOfMemoryError
    //   301	330	946	java/lang/OutOfMemoryError
    //   431	460	950	java/lang/OutOfMemoryError
    //   575	604	954	java/lang/OutOfMemoryError
    //   708	737	958	java/lang/OutOfMemoryError
    //   842	871	962	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin.PreparePicturesAndCallbackThread
 * JD-Core Version:    0.7.0.1
 */