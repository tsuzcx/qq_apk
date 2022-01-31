package com.tencent.qg.video.videodecoder;

import bfxv;
import bfya;
import bfyc;
import wxe;

class MediaDecoder$DecodeRunnable
  implements Runnable
{
  private final Object a;
  public volatile boolean a;
  
  private MediaDecoder$DecodeRunnable(MediaDecoder paramMediaDecoder)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private void a()
  {
    wxe.b("Q.qqstory.mediadecoderMediaDecoder", "release");
    MediaDecoder.a(this.this$0).b();
    if (MediaDecoder.a(this.this$0)) {
      MediaDecoder.a(this.this$0).b();
    }
    if (MediaDecoder.a(this.this$0) != null) {
      MediaDecoder.a(this.this$0).interrupt();
    }
    MediaDecoder.a(this.this$0, null);
  }
  
  private boolean a()
  {
    MediaDecoder localMediaDecoder = this.this$0;
    if ((MediaDecoder.c(this.this$0)) && (MediaDecoder.a(this.this$0).a())) {}
    for (boolean bool = true;; bool = false)
    {
      MediaDecoder.b(localMediaDecoder, bool);
      return MediaDecoder.a(this.this$0).a();
    }
  }
  
  private void b()
  {
    wxe.b("Q.qqstory.mediadecoderMediaDecoder", "onPauseFinish");
    MediaDecoder.a(this.this$0).a();
    if (MediaDecoder.a(this.this$0)) {
      MediaDecoder.a(this.this$0).a();
    }
  }
  
  private boolean b()
  {
    if (MediaDecoder.a(this.this$0)) {
      MediaDecoder.a(this.this$0).b();
    }
    boolean bool = MediaDecoder.a(this.this$0).b();
    wxe.a("Q.qqstory.mediadecoderMediaDecoder", "start finish : %s", Boolean.valueOf(bool));
    return bool;
  }
  
  private boolean c()
  {
    boolean bool = true;
    if (MediaDecoder.a(this.this$0).a() / 1000L <= System.currentTimeMillis() - MediaDecoder.a(this.this$0).b())
    {
      MediaDecoder.a(this.this$0).c();
      MediaDecoder.a(this.this$0).a(MediaDecoder.a(this.this$0).a());
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (MediaDecoder.a(this.this$0))
      {
        j = i;
        if (MediaDecoder.a(this.this$0).a() <= MediaDecoder.a(this.this$0).a() - 500000L)
        {
          MediaDecoder.a(this.this$0).c();
          j = 1;
        }
      }
      if (j == 0) {}
      try
      {
        wxe.b("Q.qqstory.mediadecoderMediaDecoder", "no render decode in this round !");
        Thread.sleep(10L);
        if (MediaDecoder.a(this.this$0).c())
        {
          if (MediaDecoder.d(this.this$0))
          {
            MediaDecoder.a(this.this$0).a(0L);
            if (MediaDecoder.a(this.this$0)) {
              MediaDecoder.a(this.this$0).a(0L);
            }
            MediaDecoder.a(this.this$0).d();
          }
        }
        else {
          bool = false;
        }
        return bool;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          wxe.b("Q.qqstory.mediadecoderMediaDecoder", "decodeFrame sleep error :%s", localInterruptedException);
        }
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   4: invokestatic 148	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfxz;
    //   7: getfield 153	bfxz:a	J
    //   10: ldc 155
    //   12: invokestatic 160	bfxu:a	(JLjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   19: iconst_0
    //   20: invokestatic 162	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
    //   23: pop
    //   24: aload_0
    //   25: invokespecial 163	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:a	()Z
    //   28: ifne +81 -> 109
    //   31: aload_0
    //   32: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   35: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   38: sipush 1000
    //   41: new 165	java/lang/Exception
    //   44: dup
    //   45: ldc 167
    //   47: invokespecial 170	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   50: invokeinterface 173 3 0
    //   55: aload_0
    //   56: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   59: iconst_0
    //   60: invokestatic 162	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
    //   63: pop
    //   64: aload_0
    //   65: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   68: invokestatic 40	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfya;
    //   71: invokevirtual 130	bfya:c	()Z
    //   74: ifeq +20 -> 94
    //   77: aload_0
    //   78: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   81: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   84: invokeinterface 174 1 0
    //   89: aload_0
    //   90: invokespecial 175	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:a	()V
    //   93: return
    //   94: aload_0
    //   95: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   98: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   101: invokeinterface 176 1 0
    //   106: goto -17 -> 89
    //   109: aload_0
    //   110: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   113: invokestatic 148	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfxz;
    //   116: getfield 153	bfxz:a	J
    //   119: ldc 178
    //   121: invokestatic 160	bfxu:a	(JLjava/lang/String;)V
    //   124: aload_0
    //   125: invokespecial 179	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:b	()Z
    //   128: ifne +81 -> 209
    //   131: aload_0
    //   132: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   135: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   138: sipush 1001
    //   141: new 165	java/lang/Exception
    //   144: dup
    //   145: ldc 181
    //   147: invokespecial 170	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   150: invokeinterface 173 3 0
    //   155: aload_0
    //   156: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   159: iconst_0
    //   160: invokestatic 162	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
    //   163: pop
    //   164: aload_0
    //   165: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   168: invokestatic 40	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfya;
    //   171: invokevirtual 130	bfya:c	()Z
    //   174: ifeq +20 -> 194
    //   177: aload_0
    //   178: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   181: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   184: invokeinterface 174 1 0
    //   189: aload_0
    //   190: invokespecial 175	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:a	()V
    //   193: return
    //   194: aload_0
    //   195: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   198: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   201: invokeinterface 176 1 0
    //   206: goto -17 -> 189
    //   209: aload_0
    //   210: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   213: invokestatic 148	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfxz;
    //   216: getfield 153	bfxz:a	J
    //   219: ldc 183
    //   221: invokestatic 160	bfxu:a	(JLjava/lang/String;)V
    //   224: aload_0
    //   225: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   228: iconst_1
    //   229: invokestatic 162	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
    //   232: pop
    //   233: aload_0
    //   234: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   237: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   240: invokeinterface 184 1 0
    //   245: invokestatic 187	java/lang/Thread:interrupted	()Z
    //   248: ifne +96 -> 344
    //   251: aload_0
    //   252: getfield 189	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   255: ifne +89 -> 344
    //   258: aload_0
    //   259: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   262: invokestatic 192	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)J
    //   265: lconst_0
    //   266: lcmp
    //   267: iflt +68 -> 335
    //   270: aload_0
    //   271: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   274: invokestatic 40	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfya;
    //   277: aload_0
    //   278: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   281: invokestatic 192	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)J
    //   284: ldc2_w 99
    //   287: lmul
    //   288: invokevirtual 136	bfya:a	(J)J
    //   291: pop2
    //   292: aload_0
    //   293: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   296: invokestatic 47	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Z
    //   299: ifeq +25 -> 324
    //   302: aload_0
    //   303: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   306: invokestatic 50	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfxv;
    //   309: aload_0
    //   310: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   313: invokestatic 192	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)J
    //   316: ldc2_w 99
    //   319: lmul
    //   320: invokevirtual 137	bfxv:a	(J)J
    //   323: pop2
    //   324: aload_0
    //   325: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   328: ldc2_w 193
    //   331: invokestatic 197	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;J)J
    //   334: pop2
    //   335: aload_0
    //   336: invokespecial 198	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:c	()Z
    //   339: istore_1
    //   340: iload_1
    //   341: ifeq +42 -> 383
    //   344: aload_0
    //   345: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   348: iconst_0
    //   349: invokestatic 162	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
    //   352: pop
    //   353: aload_0
    //   354: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   357: invokestatic 40	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfya;
    //   360: invokevirtual 130	bfya:c	()Z
    //   363: ifeq +143 -> 506
    //   366: aload_0
    //   367: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   370: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   373: invokeinterface 174 1 0
    //   378: aload_0
    //   379: invokespecial 175	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:a	()V
    //   382: return
    //   383: aload_0
    //   384: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   387: invokestatic 200	com/tencent/qg/video/videodecoder/MediaDecoder:b	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Z
    //   390: istore_1
    //   391: iload_1
    //   392: ifeq -147 -> 245
    //   395: aload_0
    //   396: getfield 20	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   399: astore_2
    //   400: aload_2
    //   401: monitorenter
    //   402: aload_0
    //   403: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   406: iconst_0
    //   407: invokestatic 162	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
    //   410: pop
    //   411: aload_0
    //   412: getfield 189	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   415: ifne +10 -> 425
    //   418: aload_0
    //   419: getfield 20	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   422: invokevirtual 203	java/lang/Object:wait	()V
    //   425: aload_2
    //   426: monitorexit
    //   427: aload_0
    //   428: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   431: iconst_1
    //   432: invokestatic 162	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
    //   435: pop
    //   436: aload_0
    //   437: invokespecial 204	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:b	()V
    //   440: goto -195 -> 245
    //   443: astore_2
    //   444: ldc 27
    //   446: ldc 206
    //   448: aload_2
    //   449: invokestatic 144	wxe:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   452: aload_0
    //   453: iconst_1
    //   454: putfield 189	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   457: goto -212 -> 245
    //   460: astore_2
    //   461: aload_0
    //   462: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   465: iconst_0
    //   466: invokestatic 162	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
    //   469: pop
    //   470: aload_0
    //   471: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   474: invokestatic 40	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfya;
    //   477: invokevirtual 130	bfya:c	()Z
    //   480: ifeq +41 -> 521
    //   483: aload_0
    //   484: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   487: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   490: invokeinterface 174 1 0
    //   495: aload_0
    //   496: invokespecial 175	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:a	()V
    //   499: aload_2
    //   500: athrow
    //   501: astore_3
    //   502: aload_2
    //   503: monitorexit
    //   504: aload_3
    //   505: athrow
    //   506: aload_0
    //   507: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   510: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   513: invokeinterface 176 1 0
    //   518: goto -140 -> 378
    //   521: aload_0
    //   522: getfield 15	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
    //   525: invokestatic 112	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lbfyc;
    //   528: invokeinterface 176 1 0
    //   533: goto -38 -> 495
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	this	DecodeRunnable
    //   339	53	1	bool	boolean
    //   443	6	2	localInterruptedException	InterruptedException
    //   460	43	2	localObject2	Object
    //   501	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   395	402	443	java/lang/InterruptedException
    //   427	440	443	java/lang/InterruptedException
    //   504	506	443	java/lang/InterruptedException
    //   0	55	460	finally
    //   109	155	460	finally
    //   209	245	460	finally
    //   245	324	460	finally
    //   324	335	460	finally
    //   335	340	460	finally
    //   383	391	460	finally
    //   395	402	460	finally
    //   427	440	460	finally
    //   444	457	460	finally
    //   504	506	460	finally
    //   402	425	501	finally
    //   425	427	501	finally
    //   502	504	501	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */