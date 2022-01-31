package com.tencent.mobileqq.ptt.player;

import android.app.Application;
import android.media.AudioTrack;
import bbis;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;

class SilkPlayer$SilkPlayerThread
  extends Thread
{
  private int jdField_a_of_type_Int;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private SilkCodecWrapper jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper;
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  
  public SilkPlayer$SilkPlayerThread(SilkPlayer paramSilkPlayer, Application paramApplication)
  {
    this.jdField_b_of_type_Int = bbis.a(SilkPlayer.a(paramSilkPlayer));
    this.jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper = new SilkCodecWrapper(paramApplication, false);
    this.jdField_a_of_type_Int = bbis.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "SilkPlayerThread sampleRate=" + this.jdField_b_of_type_Int + ", oneFrameSize=" + this.jdField_a_of_type_Int + ", currenttime:" + System.currentTimeMillis());
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_2
    //   1: newarray byte
    //   3: astore 11
    //   5: bipush 237
    //   7: invokestatic 105	android/os/Process:setThreadPriority	(I)V
    //   10: aload_0
    //   11: getfield 39	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   14: aload_0
    //   15: getfield 32	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_b_of_type_Int	I
    //   18: iconst_0
    //   19: iconst_1
    //   20: invokevirtual 108	com/tencent/mobileqq/utils/SilkCodecWrapper:a	(III)V
    //   23: aload_0
    //   24: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   27: invokestatic 111	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)F
    //   30: invokestatic 116	com/tencent/mobileqq/activity/aio/MediaPlayerManager:a	(F)Z
    //   33: ifeq +1138 -> 1171
    //   36: getstatic 121	adwv:c	Z
    //   39: ifeq +1132 -> 1171
    //   42: new 123	com/tencent/mobileqq/ptt/pttspeed/Sonic
    //   45: dup
    //   46: aload_0
    //   47: getfield 32	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_b_of_type_Int	I
    //   50: iconst_1
    //   51: invokespecial 126	com/tencent/mobileqq/ptt/pttspeed/Sonic:<init>	(II)V
    //   54: astore 10
    //   56: aload 10
    //   58: aload_0
    //   59: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   62: invokestatic 111	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)F
    //   65: invokevirtual 129	com/tencent/mobileqq/ptt/pttspeed/Sonic:a	(F)V
    //   68: sipush 2048
    //   71: newarray byte
    //   73: astore 7
    //   75: aload_0
    //   76: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   79: invokestatic 132	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)Lavcf;
    //   82: ifnull +15 -> 97
    //   85: aload_0
    //   86: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   89: invokestatic 132	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)Lavcf;
    //   92: invokeinterface 136 1 0
    //   97: aload_0
    //   98: getfield 32	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_b_of_type_Int	I
    //   101: iconst_4
    //   102: iconst_2
    //   103: invokestatic 142	android/media/AudioTrack:getMinBufferSize	(III)I
    //   106: istore_1
    //   107: aload_0
    //   108: new 138	android/media/AudioTrack
    //   111: dup
    //   112: aload_0
    //   113: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   116: invokestatic 145	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   119: aload_0
    //   120: getfield 32	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_b_of_type_Int	I
    //   123: iconst_4
    //   124: iconst_2
    //   125: iload_1
    //   126: iconst_1
    //   127: invokespecial 148	android/media/AudioTrack:<init>	(IIIIII)V
    //   130: putfield 150	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   133: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +66 -> 202
    //   139: ldc 56
    //   141: iconst_2
    //   142: new 58	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   149: ldc 152
    //   151: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   158: invokestatic 145	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   161: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: ldc 154
    //   166: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: getfield 32	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_b_of_type_Int	I
    //   173: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc 156
    //   178: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload_1
    //   182: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: ldc 158
    //   187: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   193: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   196: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload_0
    //   203: getfield 150	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   206: invokevirtual 161	android/media/AudioTrack:play	()V
    //   209: aload_0
    //   210: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   213: invokestatic 163	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   216: iconst_m1
    //   217: if_icmpeq +263 -> 480
    //   220: aload_0
    //   221: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   224: invokestatic 163	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   227: aload_0
    //   228: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   231: invokevirtual 166	com/tencent/mobileqq/ptt/player/SilkPlayer:a	()I
    //   234: if_icmpne +228 -> 462
    //   237: aload_0
    //   238: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   241: invokestatic 168	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   244: istore_2
    //   245: aload_0
    //   246: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   249: invokestatic 168	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   252: istore_1
    //   253: aload_0
    //   254: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   257: iconst_m1
    //   258: invokestatic 171	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;I)I
    //   261: pop
    //   262: new 173	java/io/FileInputStream
    //   265: dup
    //   266: aload_0
    //   267: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   270: invokestatic 176	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)Ljava/lang/String;
    //   273: invokespecial 179	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   276: astore 9
    //   278: iload_2
    //   279: ifne +208 -> 487
    //   282: aload 9
    //   284: ldc2_w 180
    //   287: invokevirtual 185	java/io/FileInputStream:skip	(J)J
    //   290: pop2
    //   291: iload_1
    //   292: bipush 10
    //   294: iadd
    //   295: istore_2
    //   296: aload_0
    //   297: getfield 93	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_Boolean	Z
    //   300: ifeq +853 -> 1153
    //   303: aload 9
    //   305: ifnull +848 -> 1153
    //   308: aload 9
    //   310: aload 11
    //   312: iconst_0
    //   313: iconst_2
    //   314: invokevirtual 189	java/io/FileInputStream:read	([BII)I
    //   317: istore_3
    //   318: iload_2
    //   319: iconst_2
    //   320: iadd
    //   321: istore_1
    //   322: iload_3
    //   323: iconst_m1
    //   324: if_icmpne +180 -> 504
    //   327: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +832 -> 1162
    //   333: ldc 56
    //   335: iconst_2
    //   336: new 58	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   343: ldc 191
    //   345: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_0
    //   349: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   352: invokestatic 193	com/tencent/mobileqq/ptt/player/SilkPlayer:d	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   355: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   358: ldc 195
    //   360: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_0
    //   364: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   367: invokestatic 168	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   370: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: iconst_1
    //   380: istore_1
    //   381: aload 9
    //   383: astore 7
    //   385: aload_0
    //   386: iconst_0
    //   387: putfield 93	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_Boolean	Z
    //   390: aload_0
    //   391: getfield 150	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   394: ifnull +39 -> 433
    //   397: aload_0
    //   398: getfield 150	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   401: invokevirtual 198	android/media/AudioTrack:getState	()I
    //   404: ifeq +29 -> 433
    //   407: aload_0
    //   408: getfield 150	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   411: invokevirtual 201	android/media/AudioTrack:pause	()V
    //   414: aload_0
    //   415: getfield 150	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   418: invokevirtual 204	android/media/AudioTrack:flush	()V
    //   421: aload_0
    //   422: getfield 150	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   425: invokevirtual 207	android/media/AudioTrack:release	()V
    //   428: aload_0
    //   429: aconst_null
    //   430: putfield 150	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   433: aload_0
    //   434: getfield 39	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   437: invokevirtual 208	com/tencent/mobileqq/utils/SilkCodecWrapper:b	()V
    //   440: iload_1
    //   441: ifeq +10 -> 451
    //   444: aload_0
    //   445: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   448: invokevirtual 209	com/tencent/mobileqq/ptt/player/SilkPlayer:b	()V
    //   451: aload 7
    //   453: ifnull +8 -> 461
    //   456: aload 7
    //   458: invokevirtual 212	java/io/FileInputStream:close	()V
    //   461: return
    //   462: aload_0
    //   463: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   466: iconst_0
    //   467: invokestatic 214	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;I)I
    //   470: pop
    //   471: aload_0
    //   472: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   475: iconst_0
    //   476: invokestatic 216	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;I)I
    //   479: pop
    //   480: iconst_0
    //   481: istore_2
    //   482: iconst_0
    //   483: istore_1
    //   484: goto -222 -> 262
    //   487: iload_2
    //   488: i2l
    //   489: lstore 5
    //   491: aload 9
    //   493: lload 5
    //   495: invokevirtual 185	java/io/FileInputStream:skip	(J)J
    //   498: pop2
    //   499: iload_1
    //   500: istore_2
    //   501: goto -205 -> 296
    //   504: aload_0
    //   505: getfield 93	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_Boolean	Z
    //   508: ifne +12 -> 520
    //   511: iconst_0
    //   512: istore_1
    //   513: aload 9
    //   515: astore 7
    //   517: goto -132 -> 385
    //   520: aload 11
    //   522: invokestatic 219	bbis:a	([B)I
    //   525: istore_3
    //   526: iload_3
    //   527: ifgt +51 -> 578
    //   530: aload_0
    //   531: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   534: iconst_1
    //   535: invokevirtual 221	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(I)V
    //   538: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq +612 -> 1153
    //   544: ldc 56
    //   546: iconst_2
    //   547: new 58	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   554: ldc 223
    //   556: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: iload_3
    //   560: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: iconst_0
    //   570: istore_1
    //   571: aload 9
    //   573: astore 7
    //   575: goto -190 -> 385
    //   578: aload_0
    //   579: getfield 93	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_Boolean	Z
    //   582: ifne +12 -> 594
    //   585: iconst_0
    //   586: istore_1
    //   587: aload 9
    //   589: astore 7
    //   591: goto -206 -> 385
    //   594: aload_0
    //   595: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   598: invokestatic 163	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   601: iconst_m1
    //   602: if_icmpne +485 -> 1087
    //   605: aload 9
    //   607: aload_0
    //   608: getfield 46	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_ArrayOfByte	[B
    //   611: iconst_0
    //   612: iload_3
    //   613: invokevirtual 189	java/io/FileInputStream:read	([BII)I
    //   616: istore 4
    //   618: iload_1
    //   619: iload_3
    //   620: iadd
    //   621: istore_2
    //   622: iload 4
    //   624: iconst_m1
    //   625: if_icmpne +51 -> 676
    //   628: aload_0
    //   629: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   632: iconst_2
    //   633: invokevirtual 221	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(I)V
    //   636: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +514 -> 1153
    //   642: ldc 56
    //   644: iconst_2
    //   645: new 58	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   652: ldc 225
    //   654: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: iload_3
    //   658: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   661: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   667: iconst_0
    //   668: istore_1
    //   669: aload 9
    //   671: astore 7
    //   673: goto -288 -> 385
    //   676: aload_0
    //   677: getfield 93	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_Boolean	Z
    //   680: ifne +12 -> 692
    //   683: iconst_0
    //   684: istore_1
    //   685: aload 9
    //   687: astore 7
    //   689: goto -304 -> 385
    //   692: aload_0
    //   693: getfield 39	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_ComTencentMobileqqUtilsSilkCodecWrapper	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
    //   696: aload_0
    //   697: getfield 46	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_ArrayOfByte	[B
    //   700: aload_0
    //   701: getfield 48	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_b_of_type_ArrayOfByte	[B
    //   704: iload_3
    //   705: aload_0
    //   706: getfield 48	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_b_of_type_ArrayOfByte	[B
    //   709: arraylength
    //   710: invokevirtual 228	com/tencent/mobileqq/utils/SilkCodecWrapper:a	([B[BII)I
    //   713: istore_3
    //   714: iload_3
    //   715: ifne +34 -> 749
    //   718: aload_0
    //   719: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   722: iconst_3
    //   723: invokevirtual 221	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(I)V
    //   726: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   729: ifeq +424 -> 1153
    //   732: ldc 56
    //   734: iconst_2
    //   735: ldc 230
    //   737: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: iconst_0
    //   741: istore_1
    //   742: aload 9
    //   744: astore 7
    //   746: goto -361 -> 385
    //   749: aload 7
    //   751: astore 8
    //   753: iload_2
    //   754: istore_1
    //   755: aload_0
    //   756: getfield 93	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_Boolean	Z
    //   759: ifeq +99 -> 858
    //   762: aload_0
    //   763: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   766: invokestatic 111	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)F
    //   769: invokestatic 116	com/tencent/mobileqq/activity/aio/MediaPlayerManager:a	(F)Z
    //   772: ifeq +257 -> 1029
    //   775: aload 7
    //   777: ifnull +252 -> 1029
    //   780: getstatic 121	adwv:c	Z
    //   783: ifeq +246 -> 1029
    //   786: iload_3
    //   787: ifle +234 -> 1021
    //   790: aload 10
    //   792: aload_0
    //   793: getfield 48	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_b_of_type_ArrayOfByte	[B
    //   796: iload_3
    //   797: invokevirtual 233	com/tencent/mobileqq/ptt/pttspeed/Sonic:a	([BI)Z
    //   800: pop
    //   801: aload 10
    //   803: invokevirtual 234	com/tencent/mobileqq/ptt/pttspeed/Sonic:a	()I
    //   806: istore_3
    //   807: aload 7
    //   809: astore 8
    //   811: iload_2
    //   812: istore_1
    //   813: iload_3
    //   814: ifle +44 -> 858
    //   817: aload 7
    //   819: astore 8
    //   821: aload 7
    //   823: arraylength
    //   824: iload_3
    //   825: if_icmpge +10 -> 835
    //   828: iload_3
    //   829: iconst_2
    //   830: imul
    //   831: newarray byte
    //   833: astore 8
    //   835: aload 10
    //   837: aload 8
    //   839: iload_3
    //   840: invokevirtual 237	com/tencent/mobileqq/ptt/pttspeed/Sonic:a	([BI)I
    //   843: pop
    //   844: aload_0
    //   845: getfield 150	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   848: aload 8
    //   850: iconst_0
    //   851: iload_3
    //   852: invokevirtual 240	android/media/AudioTrack:write	([BII)I
    //   855: pop
    //   856: iload_2
    //   857: istore_1
    //   858: ldc 56
    //   860: monitorenter
    //   861: aload_0
    //   862: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   865: iload_1
    //   866: invokestatic 216	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;I)I
    //   869: pop
    //   870: aload_0
    //   871: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   874: invokestatic 243	com/tencent/mobileqq/ptt/player/SilkPlayer:e	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   877: pop
    //   878: aload_0
    //   879: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   882: invokestatic 163	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   885: iconst_m1
    //   886: if_icmpne +20 -> 906
    //   889: aload_0
    //   890: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   893: aload_0
    //   894: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   897: invokestatic 193	com/tencent/mobileqq/ptt/player/SilkPlayer:d	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   900: bipush 20
    //   902: imul
    //   903: invokevirtual 245	com/tencent/mobileqq/ptt/player/SilkPlayer:d	(I)V
    //   906: ldc 56
    //   908: monitorexit
    //   909: aload 8
    //   911: astore 7
    //   913: iload_1
    //   914: istore_2
    //   915: aload_0
    //   916: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   919: invokestatic 163	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   922: iconst_m1
    //   923: if_icmpeq -627 -> 296
    //   926: aload 8
    //   928: astore 7
    //   930: iload_1
    //   931: istore_2
    //   932: aload_0
    //   933: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   936: invokevirtual 166	com/tencent/mobileqq/ptt/player/SilkPlayer:a	()I
    //   939: aload_0
    //   940: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   943: invokestatic 163	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
    //   946: if_icmplt -650 -> 296
    //   949: aload_0
    //   950: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   953: iconst_m1
    //   954: invokestatic 171	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;I)I
    //   957: pop
    //   958: aload 8
    //   960: astore 7
    //   962: iload_1
    //   963: istore_2
    //   964: goto -668 -> 296
    //   967: astore 8
    //   969: iconst_0
    //   970: istore_1
    //   971: aload 9
    //   973: astore 7
    //   975: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   978: ifeq +32 -> 1010
    //   981: ldc 56
    //   983: iconst_2
    //   984: new 58	java/lang/StringBuilder
    //   987: dup
    //   988: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   991: ldc 247
    //   993: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: aload 8
    //   998: invokevirtual 248	java/lang/Exception:toString	()Ljava/lang/String;
    //   1001: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1007: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1010: aload_0
    //   1011: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   1014: iconst_4
    //   1015: invokevirtual 221	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(I)V
    //   1018: goto -633 -> 385
    //   1021: aload 10
    //   1023: invokevirtual 249	com/tencent/mobileqq/ptt/pttspeed/Sonic:b	()V
    //   1026: goto -225 -> 801
    //   1029: aload_0
    //   1030: getfield 150	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_AndroidMediaAudioTrack	Landroid/media/AudioTrack;
    //   1033: aload_0
    //   1034: getfield 48	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_b_of_type_ArrayOfByte	[B
    //   1037: iconst_0
    //   1038: aload_0
    //   1039: getfield 44	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_a_of_type_Int	I
    //   1042: invokevirtual 240	android/media/AudioTrack:write	([BII)I
    //   1045: pop
    //   1046: aload 7
    //   1048: astore 8
    //   1050: iload_2
    //   1051: istore_1
    //   1052: aload_0
    //   1053: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   1056: invokestatic 252	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)Lavcd;
    //   1059: ifnull -201 -> 858
    //   1062: aload_0
    //   1063: getfield 17	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
    //   1066: invokestatic 252	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)Lavcd;
    //   1069: aload_0
    //   1070: getfield 48	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:jdField_b_of_type_ArrayOfByte	[B
    //   1073: invokeinterface 257 2 0
    //   1078: aload 7
    //   1080: astore 8
    //   1082: iload_2
    //   1083: istore_1
    //   1084: goto -226 -> 858
    //   1087: iload_1
    //   1088: iload_3
    //   1089: iadd
    //   1090: istore_1
    //   1091: aload 9
    //   1093: iload_3
    //   1094: i2l
    //   1095: invokevirtual 185	java/io/FileInputStream:skip	(J)J
    //   1098: pop2
    //   1099: aload 7
    //   1101: astore 8
    //   1103: goto -245 -> 858
    //   1106: astore 7
    //   1108: ldc 56
    //   1110: monitorexit
    //   1111: aload 7
    //   1113: athrow
    //   1114: astore 8
    //   1116: aload 8
    //   1118: invokevirtual 260	java/lang/Exception:printStackTrace	()V
    //   1121: goto -693 -> 428
    //   1124: astore 7
    //   1126: aload 7
    //   1128: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   1131: return
    //   1132: astore 8
    //   1134: aconst_null
    //   1135: astore 7
    //   1137: iconst_0
    //   1138: istore_1
    //   1139: goto -164 -> 975
    //   1142: astore 8
    //   1144: iconst_1
    //   1145: istore_1
    //   1146: aload 9
    //   1148: astore 7
    //   1150: goto -175 -> 975
    //   1153: iconst_0
    //   1154: istore_1
    //   1155: aload 9
    //   1157: astore 7
    //   1159: goto -774 -> 385
    //   1162: iconst_1
    //   1163: istore_1
    //   1164: aload 9
    //   1166: astore 7
    //   1168: goto -783 -> 385
    //   1171: aconst_null
    //   1172: astore 7
    //   1174: aconst_null
    //   1175: astore 10
    //   1177: goto -1102 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1180	0	this	SilkPlayerThread
    //   106	1058	1	i	int
    //   244	839	2	j	int
    //   317	777	3	k	int
    //   616	10	4	m	int
    //   489	5	5	l	long
    //   73	1027	7	localObject1	java.lang.Object
    //   1106	6	7	localObject2	java.lang.Object
    //   1124	3	7	localIOException	java.io.IOException
    //   1135	38	7	localObject3	java.lang.Object
    //   751	208	8	localObject4	java.lang.Object
    //   967	30	8	localException1	java.lang.Exception
    //   1048	54	8	localObject5	java.lang.Object
    //   1114	3	8	localException2	java.lang.Exception
    //   1132	1	8	localException3	java.lang.Exception
    //   1142	1	8	localException4	java.lang.Exception
    //   276	889	9	localFileInputStream	java.io.FileInputStream
    //   54	1122	10	localSonic	com.tencent.mobileqq.ptt.pttspeed.Sonic
    //   3	518	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   282	291	967	java/lang/Exception
    //   296	303	967	java/lang/Exception
    //   308	318	967	java/lang/Exception
    //   491	499	967	java/lang/Exception
    //   504	511	967	java/lang/Exception
    //   520	526	967	java/lang/Exception
    //   530	569	967	java/lang/Exception
    //   578	585	967	java/lang/Exception
    //   594	618	967	java/lang/Exception
    //   628	667	967	java/lang/Exception
    //   676	683	967	java/lang/Exception
    //   692	714	967	java/lang/Exception
    //   718	740	967	java/lang/Exception
    //   755	775	967	java/lang/Exception
    //   780	786	967	java/lang/Exception
    //   790	801	967	java/lang/Exception
    //   801	807	967	java/lang/Exception
    //   821	835	967	java/lang/Exception
    //   835	856	967	java/lang/Exception
    //   858	861	967	java/lang/Exception
    //   915	926	967	java/lang/Exception
    //   932	958	967	java/lang/Exception
    //   1021	1026	967	java/lang/Exception
    //   1029	1046	967	java/lang/Exception
    //   1052	1078	967	java/lang/Exception
    //   1091	1099	967	java/lang/Exception
    //   1111	1114	967	java/lang/Exception
    //   861	906	1106	finally
    //   906	909	1106	finally
    //   1108	1111	1106	finally
    //   407	428	1114	java/lang/Exception
    //   456	461	1124	java/io/IOException
    //   10	75	1132	java/lang/Exception
    //   75	97	1132	java/lang/Exception
    //   97	202	1132	java/lang/Exception
    //   202	262	1132	java/lang/Exception
    //   262	278	1132	java/lang/Exception
    //   462	480	1132	java/lang/Exception
    //   327	379	1142	java/lang/Exception
  }
  
  public void start()
  {
    this.jdField_a_of_type_Boolean = true;
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.player.SilkPlayer.SilkPlayerThread
 * JD-Core Version:    0.7.0.1
 */