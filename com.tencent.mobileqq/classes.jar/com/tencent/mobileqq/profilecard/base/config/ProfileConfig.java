package com.tencent.mobileqq.profilecard.base.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.config.CfgProcess.CfgParseResult;
import com.tencent.mobileqq.config.CfgProcess.OnGetConfigListener;

public class ProfileConfig
  implements CfgProcess.OnGetConfigListener, IProfileConfig
{
  public static final String TAG = "ProfileConfigHelper";
  private QQAppInterface app;
  private IProfileConfigListener mLis;
  private final Boolean[] mSwitchValueArray = new Boolean[15];
  private String mVoiceBtnStr = null;
  
  public ProfileConfig(AppInterface paramAppInterface, IProfileConfigListener paramIProfileConfigListener)
  {
    this.app = ((QQAppInterface)paramAppInterface);
    this.mLis = paramIProfileConfigListener;
    paramAppInterface = this.app;
    if (paramAppInterface != null)
    {
      paramAppInterface.getConfigProcess().a("profile_btn_config", this);
      this.app.getConfigProcess().a("profile_switch_config", this);
    }
  }
  
  /* Error */
  private void initProfileSwitchConfig(String paramString)
  {
    // Byte code:
    //   0: bipush 15
    //   2: newarray int
    //   4: astore 6
    //   6: iconst_0
    //   7: istore_2
    //   8: iload_2
    //   9: bipush 15
    //   11: if_icmpge +19 -> 30
    //   14: aload 6
    //   16: iload_2
    //   17: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   20: iload_2
    //   21: iaload
    //   22: iastore
    //   23: iload_2
    //   24: iconst_1
    //   25: iadd
    //   26: istore_2
    //   27: goto -19 -> 8
    //   30: aload_1
    //   31: astore 4
    //   33: aload_1
    //   34: astore 5
    //   36: aload_1
    //   37: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifeq +44 -> 84
    //   43: aload_1
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 34	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: ifnonnull +10 -> 60
    //   53: ldc 69
    //   55: astore 4
    //   57: goto +15 -> 72
    //   60: aload_1
    //   61: astore 5
    //   63: aload_0
    //   64: getfield 34	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   70: astore 4
    //   72: aload_1
    //   73: astore 5
    //   75: aload 4
    //   77: ldc 50
    //   79: invokestatic 76	com/tencent/mobileqq/config/CfgProcess:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 4
    //   84: aload 4
    //   86: astore 5
    //   88: new 78	org/json/JSONObject
    //   91: dup
    //   92: aload 4
    //   94: invokespecial 80	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   97: astore_1
    //   98: aload 4
    //   100: astore 5
    //   102: aload 6
    //   104: iconst_0
    //   105: aload_1
    //   106: ldc 82
    //   108: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   111: iconst_0
    //   112: iaload
    //   113: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   116: iastore
    //   117: aload 4
    //   119: astore 5
    //   121: aload 6
    //   123: iconst_1
    //   124: aload_1
    //   125: ldc 88
    //   127: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   130: iconst_1
    //   131: iaload
    //   132: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   135: iastore
    //   136: aload 4
    //   138: astore 5
    //   140: aload 6
    //   142: iconst_2
    //   143: aload_1
    //   144: ldc 90
    //   146: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   149: iconst_2
    //   150: iaload
    //   151: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   154: iastore
    //   155: aload 4
    //   157: astore 5
    //   159: aload 6
    //   161: iconst_3
    //   162: aload_1
    //   163: ldc 92
    //   165: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   168: iconst_3
    //   169: iaload
    //   170: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   173: iastore
    //   174: aload 4
    //   176: astore 5
    //   178: aload 6
    //   180: iconst_4
    //   181: aload_1
    //   182: ldc 94
    //   184: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   187: iconst_4
    //   188: iaload
    //   189: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   192: iastore
    //   193: aload 4
    //   195: astore 5
    //   197: aload 6
    //   199: iconst_5
    //   200: aload_1
    //   201: ldc 96
    //   203: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   206: iconst_5
    //   207: iaload
    //   208: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   211: iastore
    //   212: aload 4
    //   214: astore 5
    //   216: aload 6
    //   218: bipush 6
    //   220: aload_1
    //   221: ldc 98
    //   223: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   226: bipush 6
    //   228: iaload
    //   229: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   232: iastore
    //   233: aload 4
    //   235: astore 5
    //   237: aload 6
    //   239: bipush 7
    //   241: aload_1
    //   242: ldc 100
    //   244: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   247: bipush 7
    //   249: iaload
    //   250: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   253: iastore
    //   254: aload 4
    //   256: astore 5
    //   258: aload 6
    //   260: bipush 8
    //   262: aload_1
    //   263: ldc 102
    //   265: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   268: bipush 8
    //   270: iaload
    //   271: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   274: iastore
    //   275: aload 4
    //   277: astore 5
    //   279: aload 6
    //   281: bipush 9
    //   283: aload_1
    //   284: ldc 104
    //   286: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   289: bipush 9
    //   291: iaload
    //   292: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   295: iastore
    //   296: aload 4
    //   298: astore 5
    //   300: aload 6
    //   302: bipush 10
    //   304: aload_1
    //   305: ldc 106
    //   307: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   310: bipush 10
    //   312: iaload
    //   313: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   316: iastore
    //   317: aload 4
    //   319: astore 5
    //   321: aload 6
    //   323: bipush 11
    //   325: aload_1
    //   326: ldc 108
    //   328: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   331: bipush 11
    //   333: iaload
    //   334: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   337: iastore
    //   338: aload 4
    //   340: astore 5
    //   342: aload 6
    //   344: bipush 12
    //   346: aload_1
    //   347: ldc 110
    //   349: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   352: bipush 12
    //   354: iaload
    //   355: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   358: iastore
    //   359: aload 4
    //   361: astore 5
    //   363: aload 6
    //   365: bipush 13
    //   367: aload_1
    //   368: ldc 112
    //   370: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   373: bipush 13
    //   375: iaload
    //   376: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   379: iastore
    //   380: aload 4
    //   382: astore 5
    //   384: aload 6
    //   386: bipush 14
    //   388: aload_1
    //   389: ldc 114
    //   391: getstatic 61	com/tencent/mobileqq/profilecard/base/config/IProfileConfigConst:SWITCH_DEFAULT_VALUES	[I
    //   394: bipush 14
    //   396: iaload
    //   397: invokevirtual 86	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   400: iastore
    //   401: iconst_0
    //   402: istore_2
    //   403: aload 4
    //   405: astore_1
    //   406: iload_2
    //   407: bipush 15
    //   409: if_icmpge +96 -> 505
    //   412: aload_0
    //   413: getfield 28	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:mSwitchValueArray	[Ljava/lang/Boolean;
    //   416: astore_1
    //   417: aload 6
    //   419: iload_2
    //   420: iaload
    //   421: iconst_1
    //   422: if_icmpne +8 -> 430
    //   425: iconst_1
    //   426: istore_3
    //   427: goto +5 -> 432
    //   430: iconst_0
    //   431: istore_3
    //   432: aload_1
    //   433: iload_2
    //   434: iload_3
    //   435: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   438: aastore
    //   439: iload_2
    //   440: iconst_1
    //   441: iadd
    //   442: istore_2
    //   443: goto -40 -> 403
    //   446: astore_1
    //   447: goto +97 -> 544
    //   450: astore_1
    //   451: ldc 12
    //   453: iconst_1
    //   454: ldc 120
    //   456: aload_1
    //   457: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   460: iconst_0
    //   461: istore_2
    //   462: aload 5
    //   464: astore_1
    //   465: iload_2
    //   466: bipush 15
    //   468: if_icmpge +37 -> 505
    //   471: aload_0
    //   472: getfield 28	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:mSwitchValueArray	[Ljava/lang/Boolean;
    //   475: astore_1
    //   476: aload 6
    //   478: iload_2
    //   479: iaload
    //   480: iconst_1
    //   481: if_icmpne +8 -> 489
    //   484: iconst_1
    //   485: istore_3
    //   486: goto +5 -> 491
    //   489: iconst_0
    //   490: istore_3
    //   491: aload_1
    //   492: iload_2
    //   493: iload_3
    //   494: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   497: aastore
    //   498: iload_2
    //   499: iconst_1
    //   500: iadd
    //   501: istore_2
    //   502: goto -40 -> 462
    //   505: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +35 -> 543
    //   511: ldc 12
    //   513: iconst_2
    //   514: ldc 132
    //   516: iconst_2
    //   517: anewarray 4	java/lang/Object
    //   520: dup
    //   521: iconst_0
    //   522: aload_1
    //   523: invokevirtual 137	java/lang/String:trim	()Ljava/lang/String;
    //   526: aastore
    //   527: dup
    //   528: iconst_1
    //   529: aload_0
    //   530: getfield 28	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:mSwitchValueArray	[Ljava/lang/Boolean;
    //   533: invokestatic 143	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   536: aastore
    //   537: invokestatic 147	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   540: invokestatic 151	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: return
    //   544: iconst_0
    //   545: istore_2
    //   546: iload_2
    //   547: bipush 15
    //   549: if_icmpge +39 -> 588
    //   552: aload_0
    //   553: getfield 28	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:mSwitchValueArray	[Ljava/lang/Boolean;
    //   556: astore 4
    //   558: aload 6
    //   560: iload_2
    //   561: iaload
    //   562: iconst_1
    //   563: if_icmpne +8 -> 571
    //   566: iconst_1
    //   567: istore_3
    //   568: goto +5 -> 573
    //   571: iconst_0
    //   572: istore_3
    //   573: aload 4
    //   575: iload_2
    //   576: iload_3
    //   577: invokestatic 118	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   580: aastore
    //   581: iload_2
    //   582: iconst_1
    //   583: iadd
    //   584: istore_2
    //   585: goto -39 -> 546
    //   588: goto +5 -> 593
    //   591: aload_1
    //   592: athrow
    //   593: goto -2 -> 591
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	this	ProfileConfig
    //   0	596	1	paramString	String
    //   7	578	2	i	int
    //   426	151	3	bool	boolean
    //   31	543	4	localObject1	Object
    //   34	429	5	localObject2	Object
    //   4	555	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   36	43	446	finally
    //   46	53	446	finally
    //   63	72	446	finally
    //   75	84	446	finally
    //   88	98	446	finally
    //   102	117	446	finally
    //   121	136	446	finally
    //   140	155	446	finally
    //   159	174	446	finally
    //   178	193	446	finally
    //   197	212	446	finally
    //   216	233	446	finally
    //   237	254	446	finally
    //   258	275	446	finally
    //   279	296	446	finally
    //   300	317	446	finally
    //   321	338	446	finally
    //   342	359	446	finally
    //   363	380	446	finally
    //   384	401	446	finally
    //   451	460	446	finally
    //   36	43	450	java/lang/Exception
    //   46	53	450	java/lang/Exception
    //   63	72	450	java/lang/Exception
    //   75	84	450	java/lang/Exception
    //   88	98	450	java/lang/Exception
    //   102	117	450	java/lang/Exception
    //   121	136	450	java/lang/Exception
    //   140	155	450	java/lang/Exception
    //   159	174	450	java/lang/Exception
    //   178	193	450	java/lang/Exception
    //   197	212	450	java/lang/Exception
    //   216	233	450	java/lang/Exception
    //   237	254	450	java/lang/Exception
    //   258	275	450	java/lang/Exception
    //   279	296	450	java/lang/Exception
    //   300	317	450	java/lang/Exception
    //   321	338	450	java/lang/Exception
    //   342	359	450	java/lang/Exception
    //   363	380	450	java/lang/Exception
    //   384	401	450	java/lang/Exception
  }
  
  /* Error */
  private void initVoiceBtnConfig(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: astore_2
    //   8: aload_1
    //   9: astore_3
    //   10: aload_1
    //   11: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +37 -> 51
    //   17: aload_1
    //   18: astore_3
    //   19: aload_0
    //   20: getfield 34	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: ifnonnull +9 -> 32
    //   26: ldc 69
    //   28: astore_2
    //   29: goto +13 -> 42
    //   32: aload_1
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 34	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   41: astore_2
    //   42: aload_1
    //   43: astore_3
    //   44: aload_2
    //   45: ldc 42
    //   47: invokestatic 76	com/tencent/mobileqq/config/CfgProcess:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_2
    //   51: aload_2
    //   52: astore_3
    //   53: new 78	org/json/JSONObject
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 80	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: ldc 154
    //   63: invokevirtual 158	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 6
    //   68: aload 6
    //   70: astore 4
    //   72: aload_2
    //   73: astore_1
    //   74: aload 6
    //   76: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifeq +39 -> 118
    //   82: aload_2
    //   83: astore_1
    //   84: goto +27 -> 111
    //   87: astore_2
    //   88: goto +69 -> 157
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   96: aload 5
    //   98: astore 4
    //   100: aload_3
    //   101: astore_1
    //   102: aconst_null
    //   103: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +12 -> 118
    //   109: aload_3
    //   110: astore_1
    //   111: ldc 162
    //   113: invokestatic 167	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   116: astore 4
    //   118: aload_0
    //   119: aload 4
    //   121: putfield 30	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:mVoiceBtnStr	Ljava/lang/String;
    //   124: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +29 -> 156
    //   130: ldc 12
    //   132: iconst_2
    //   133: ldc 169
    //   135: iconst_2
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_0
    //   142: getfield 30	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:mVoiceBtnStr	Ljava/lang/String;
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: aload_1
    //   149: aastore
    //   150: invokestatic 147	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   153: invokestatic 151	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: return
    //   157: aload 4
    //   159: astore_1
    //   160: aconst_null
    //   161: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifeq +9 -> 173
    //   167: ldc 162
    //   169: invokestatic 167	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   172: astore_1
    //   173: aload_0
    //   174: aload_1
    //   175: putfield 30	com/tencent/mobileqq/profilecard/base/config/ProfileConfig:mVoiceBtnStr	Ljava/lang/String;
    //   178: aload_2
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	ProfileConfig
    //   0	180	1	paramString	String
    //   7	76	2	str1	String
    //   87	92	2	localObject1	Object
    //   9	101	3	str2	String
    //   1	157	4	localObject2	Object
    //   4	93	5	localObject3	Object
    //   66	9	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   10	17	87	finally
    //   19	26	87	finally
    //   34	42	87	finally
    //   44	51	87	finally
    //   53	68	87	finally
    //   92	96	87	finally
    //   10	17	91	java/lang/Exception
    //   19	26	91	java/lang/Exception
    //   34	42	91	java/lang/Exception
    //   44	51	91	java/lang/Exception
    //   53	68	91	java/lang/Exception
  }
  
  public void destroy()
  {
    QQAppInterface localQQAppInterface = this.app;
    if (localQQAppInterface != null) {
      localQQAppInterface.getConfigProcess().a(this);
    }
    this.app = null;
    this.mLis = null;
  }
  
  public String getVoiceBtnWording()
  {
    if (this.app == null) {
      return HardCodeUtil.a(2131906204);
    }
    if (this.mVoiceBtnStr == null) {
      initVoiceBtnConfig(null);
    }
    return this.mVoiceBtnStr;
  }
  
  public boolean isSwitchEnable(int paramInt)
  {
    if (this.app == null) {
      return false;
    }
    if (paramInt >= 0)
    {
      if (paramInt >= 15) {
        return false;
      }
      if (this.mSwitchValueArray[paramInt] == null) {
        initProfileSwitchConfig(null);
      }
      return this.mSwitchValueArray[paramInt].booleanValue();
    }
    return false;
  }
  
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if (paramCfgParseResult == null) {
      return;
    }
    if ("profile_btn_config".equals(paramString)) {
      initVoiceBtnConfig(paramCfgParseResult.d);
    } else if ("profile_switch_config".equals(paramString)) {
      initProfileSwitchConfig(paramCfgParseResult.d);
    }
    paramQQAppInterface = this.mLis;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.onConfigUpdate(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.config.ProfileConfig
 * JD-Core Version:    0.7.0.1
 */