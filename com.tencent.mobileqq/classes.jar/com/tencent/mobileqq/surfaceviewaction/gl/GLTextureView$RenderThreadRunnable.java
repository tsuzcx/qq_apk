package com.tencent.mobileqq.surfaceviewaction.gl;

class GLTextureView$RenderThreadRunnable
  implements Runnable
{
  public boolean a = false;
  
  private GLTextureView$RenderThreadRunnable(GLTextureView paramGLTextureView) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 36
    //   8: iconst_2
    //   9: ldc 38
    //   11: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: ldc 44
    //   16: monitorenter
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 19	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:a	Z
    //   22: ldc 44
    //   24: monitorexit
    //   25: aload_0
    //   26: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   29: iconst_1
    //   30: invokestatic 47	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;Z)Z
    //   33: pop
    //   34: aload_0
    //   35: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   38: invokestatic 49	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
    //   41: goto +44 -> 85
    //   44: astore 7
    //   46: new 51	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   53: astore 8
    //   55: aload 8
    //   57: ldc 54
    //   59: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 8
    //   65: aload 7
    //   67: invokestatic 62	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   70: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: ldc 36
    //   76: iconst_2
    //   77: aload 8
    //   79: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_0
    //   86: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   89: invokestatic 72	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:b	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
    //   92: iconst_0
    //   93: istore_2
    //   94: iconst_0
    //   95: istore_1
    //   96: iload_1
    //   97: aload_0
    //   98: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   101: invokestatic 76	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   104: invokeinterface 82 1 0
    //   109: if_icmpge +31 -> 140
    //   112: aload_0
    //   113: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   116: invokestatic 76	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   119: iload_1
    //   120: invokeinterface 86 2 0
    //   125: checkcast 88	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$OnSurfaceChangedListener
    //   128: invokeinterface 90 1 0
    //   133: iload_1
    //   134: iconst_1
    //   135: iadd
    //   136: istore_1
    //   137: goto -41 -> 96
    //   140: aload_0
    //   141: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   144: new 92	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable$1
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 95	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable$1:<init>	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable;)V
    //   152: invokevirtual 99	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:post	(Ljava/lang/Runnable;)Z
    //   155: pop
    //   156: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   159: lstore_3
    //   160: aload_0
    //   161: getfield 19	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:a	Z
    //   164: ifeq +317 -> 481
    //   167: aload_0
    //   168: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   171: invokestatic 108	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:d	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   174: ifnonnull +15 -> 189
    //   177: ldc2_w 109
    //   180: invokestatic 116	java/lang/Thread:sleep	(J)V
    //   183: goto -16 -> 167
    //   186: goto -19 -> 167
    //   189: aload_0
    //   190: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   193: invokestatic 119	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:e	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
    //   196: ifeq +28 -> 224
    //   199: aload_0
    //   200: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   203: astore 7
    //   205: aload 7
    //   207: aload 7
    //   209: invokestatic 108	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:d	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   212: invokestatic 122	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;Landroid/opengl/GLSurfaceView$Renderer;)V
    //   215: aload_0
    //   216: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   219: iconst_0
    //   220: invokestatic 47	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:a	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;Z)Z
    //   223: pop
    //   224: aload_0
    //   225: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   228: invokestatic 125	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:f	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
    //   231: ifne +182 -> 413
    //   234: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   237: lstore_3
    //   238: aload_0
    //   239: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   242: invokestatic 129	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:g	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/lang/Object;
    //   245: astore 7
    //   247: aload 7
    //   249: monitorenter
    //   250: iconst_0
    //   251: istore_1
    //   252: iload_1
    //   253: aload_0
    //   254: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   257: invokestatic 132	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:h	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   260: invokeinterface 82 1 0
    //   265: if_icmpge +31 -> 296
    //   268: aload_0
    //   269: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   272: invokestatic 132	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:h	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   275: iload_1
    //   276: invokeinterface 86 2 0
    //   281: checkcast 6	java/lang/Runnable
    //   284: invokeinterface 134 1 0
    //   289: iload_1
    //   290: iconst_1
    //   291: iadd
    //   292: istore_1
    //   293: goto -41 -> 252
    //   296: aload_0
    //   297: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   300: invokestatic 132	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:h	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   303: invokeinterface 137 1 0
    //   308: aload 7
    //   310: monitorexit
    //   311: ldc 44
    //   313: monitorenter
    //   314: aload_0
    //   315: getfield 19	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:a	Z
    //   318: ifeq +75 -> 393
    //   321: aload_0
    //   322: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   325: invokestatic 140	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:i	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
    //   328: ifne +65 -> 393
    //   331: aload_0
    //   332: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   335: invokestatic 143	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:j	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
    //   338: goto +55 -> 393
    //   341: astore 7
    //   343: goto +56 -> 399
    //   346: astore 7
    //   348: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +42 -> 393
    //   354: new 51	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   361: astore 8
    //   363: aload 8
    //   365: ldc 145
    //   367: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 8
    //   373: aload 7
    //   375: invokestatic 62	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   378: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: ldc 36
    //   384: iconst_2
    //   385: aload 8
    //   387: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: ldc 44
    //   395: monitorexit
    //   396: goto +17 -> 413
    //   399: ldc 44
    //   401: monitorexit
    //   402: aload 7
    //   404: athrow
    //   405: astore 8
    //   407: aload 7
    //   409: monitorexit
    //   410: aload 8
    //   412: athrow
    //   413: aload_0
    //   414: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   417: invokestatic 125	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:f	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
    //   420: ifne +49 -> 469
    //   423: aload_0
    //   424: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   427: invokestatic 140	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:i	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Z
    //   430: ifeq +6 -> 436
    //   433: goto +36 -> 469
    //   436: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   439: lstore 5
    //   441: ldc2_w 146
    //   444: aload_0
    //   445: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   448: invokestatic 151	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:k	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)I
    //   451: i2l
    //   452: lload 5
    //   454: lload_3
    //   455: lsub
    //   456: lsub
    //   457: invokestatic 157	java/lang/Math:max	(JJ)J
    //   460: invokestatic 116	java/lang/Thread:sleep	(J)V
    //   463: lload 5
    //   465: lstore_3
    //   466: goto -306 -> 160
    //   469: ldc2_w 109
    //   472: invokestatic 116	java/lang/Thread:sleep	(J)V
    //   475: goto -315 -> 160
    //   478: goto -318 -> 160
    //   481: aload_0
    //   482: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   485: invokestatic 129	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:g	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/lang/Object;
    //   488: astore 7
    //   490: aload 7
    //   492: monitorenter
    //   493: iconst_0
    //   494: istore_1
    //   495: iload_1
    //   496: aload_0
    //   497: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   500: invokestatic 132	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:h	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   503: invokeinterface 82 1 0
    //   508: if_icmpge +31 -> 539
    //   511: aload_0
    //   512: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   515: invokestatic 132	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:h	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   518: iload_1
    //   519: invokeinterface 86 2 0
    //   524: checkcast 6	java/lang/Runnable
    //   527: invokeinterface 134 1 0
    //   532: iload_1
    //   533: iconst_1
    //   534: iadd
    //   535: istore_1
    //   536: goto -41 -> 495
    //   539: aload_0
    //   540: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   543: invokestatic 132	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:h	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   546: invokeinterface 137 1 0
    //   551: aload 7
    //   553: monitorexit
    //   554: aload_0
    //   555: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   558: invokestatic 160	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:l	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)V
    //   561: iload_2
    //   562: istore_1
    //   563: iload_1
    //   564: aload_0
    //   565: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   568: invokestatic 76	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   571: invokeinterface 82 1 0
    //   576: if_icmpge +31 -> 607
    //   579: aload_0
    //   580: getfield 14	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$RenderThreadRunnable:this$0	Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;
    //   583: invokestatic 76	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView:c	(Lcom/tencent/mobileqq/surfaceviewaction/gl/GLTextureView;)Ljava/util/List;
    //   586: iload_1
    //   587: invokeinterface 86 2 0
    //   592: checkcast 88	com/tencent/mobileqq/surfaceviewaction/gl/GLTextureView$OnSurfaceChangedListener
    //   595: invokeinterface 163 1 0
    //   600: iload_1
    //   601: iconst_1
    //   602: iadd
    //   603: istore_1
    //   604: goto -41 -> 563
    //   607: return
    //   608: astore 8
    //   610: aload 7
    //   612: monitorexit
    //   613: aload 8
    //   615: athrow
    //   616: astore 7
    //   618: ldc 44
    //   620: monitorexit
    //   621: goto +6 -> 627
    //   624: aload 7
    //   626: athrow
    //   627: goto -3 -> 624
    //   630: astore 7
    //   632: goto -446 -> 186
    //   635: astore 7
    //   637: goto -159 -> 478
    //   640: astore 7
    //   642: goto -179 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	this	RenderThreadRunnable
    //   95	509	1	i	int
    //   93	469	2	j	int
    //   159	307	3	l1	long
    //   439	25	5	l2	long
    //   44	22	7	localException1	java.lang.Exception
    //   203	106	7	localObject1	Object
    //   341	1	7	localObject2	Object
    //   346	62	7	localException2	java.lang.Exception
    //   488	123	7	localObject3	Object
    //   616	9	7	localObject4	Object
    //   630	1	7	localInterruptedException1	java.lang.InterruptedException
    //   635	1	7	localInterruptedException2	java.lang.InterruptedException
    //   640	1	7	localInterruptedException3	java.lang.InterruptedException
    //   53	333	8	localStringBuilder	java.lang.StringBuilder
    //   405	6	8	localObject5	Object
    //   608	6	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   34	41	44	java/lang/Exception
    //   314	338	341	finally
    //   348	393	341	finally
    //   393	396	341	finally
    //   399	402	341	finally
    //   314	338	346	java/lang/Exception
    //   252	289	405	finally
    //   296	311	405	finally
    //   407	410	405	finally
    //   495	532	608	finally
    //   539	554	608	finally
    //   610	613	608	finally
    //   17	25	616	finally
    //   618	621	616	finally
    //   177	183	630	java/lang/InterruptedException
    //   413	433	635	java/lang/InterruptedException
    //   436	441	635	java/lang/InterruptedException
    //   469	475	635	java/lang/InterruptedException
    //   441	463	640	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView.RenderThreadRunnable
 * JD-Core Version:    0.7.0.1
 */