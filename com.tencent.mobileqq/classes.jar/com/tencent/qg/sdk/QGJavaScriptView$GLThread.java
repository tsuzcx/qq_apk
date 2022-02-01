package com.tencent.qg.sdk;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

class QGJavaScriptView$GLThread
  extends Thread
{
  private QGJavaScriptView.EglHelper mEglHelper;
  private ArrayList<Runnable> mEventQueue = new ArrayList();
  private boolean mExited;
  private Runnable mFinishDrawingRunnable = null;
  private boolean mFinishedCreatingEglSurface;
  private WeakReference<QGJavaScriptView> mGLSurfaceViewWeakRef;
  private boolean mHasSurface;
  private boolean mHaveEglContext;
  private boolean mHaveEglSurface;
  private int mHeight = 0;
  private boolean mPaused;
  private boolean mRenderComplete;
  private int mRenderMode = 1;
  private boolean mRequestPaused;
  private boolean mRequestRender = true;
  private boolean mShouldExit;
  private boolean mShouldReleaseEglContext;
  private boolean mSizeChanged = true;
  private boolean mSurfaceIsBad;
  private boolean mWaitingForSurface;
  private boolean mWantRenderNotification = false;
  private int mWidth = 0;
  
  QGJavaScriptView$GLThread(WeakReference<QGJavaScriptView> paramWeakReference)
  {
    this.mGLSurfaceViewWeakRef = paramWeakReference;
  }
  
  /* Error */
  private void guardedRun()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 72	com/tencent/qg/sdk/QGJavaScriptView$EglHelper
    //   4: dup
    //   5: aload_0
    //   6: getfield 60	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 74	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 76	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 78	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglContext	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 80	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 58	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWantRenderNotification	Z
    //   30: aconst_null
    //   31: astore 24
    //   33: iconst_0
    //   34: istore 6
    //   36: iconst_0
    //   37: istore 4
    //   39: iconst_0
    //   40: istore 16
    //   42: aconst_null
    //   43: astore 22
    //   45: iconst_0
    //   46: istore 5
    //   48: iconst_0
    //   49: istore_3
    //   50: iconst_0
    //   51: istore 11
    //   53: iconst_0
    //   54: istore 13
    //   56: iconst_0
    //   57: istore 12
    //   59: aconst_null
    //   60: astore 25
    //   62: iconst_0
    //   63: istore_2
    //   64: iconst_0
    //   65: istore_1
    //   66: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   69: astore 27
    //   71: aload 27
    //   73: monitorenter
    //   74: iload 16
    //   76: istore 7
    //   78: iload 4
    //   80: istore 8
    //   82: aload_0
    //   83: getfield 88	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mShouldExit	Z
    //   86: ifeq +63 -> 149
    //   89: aload_0
    //   90: getfield 60	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   93: invokevirtual 94	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   96: checkcast 82	com/tencent/qg/sdk/QGJavaScriptView
    //   99: astore 22
    //   101: aload 22
    //   103: ifnull +15 -> 118
    //   106: aload 22
    //   108: getfield 98	com/tencent/qg/sdk/QGJavaScriptView:mRenderer	Lcom/tencent/qg/sdk/QGJavaScriptView$Renderer;
    //   111: aload 24
    //   113: invokeinterface 104 2 0
    //   118: aload 27
    //   120: monitorexit
    //   121: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   124: astore 22
    //   126: aload 22
    //   128: monitorenter
    //   129: aload_0
    //   130: invokespecial 107	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglSurfaceLocked	()V
    //   133: aload_0
    //   134: invokespecial 110	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglContextLocked	()V
    //   137: aload 22
    //   139: monitorexit
    //   140: return
    //   141: astore 23
    //   143: aload 22
    //   145: monitorexit
    //   146: aload 23
    //   148: athrow
    //   149: aload_0
    //   150: getfield 44	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEventQueue	Ljava/util/ArrayList;
    //   153: invokevirtual 114	java/util/ArrayList:isEmpty	()Z
    //   156: ifne +39 -> 195
    //   159: aload_0
    //   160: getfield 44	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEventQueue	Ljava/util/ArrayList;
    //   163: iconst_0
    //   164: invokevirtual 118	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   167: checkcast 120	java/lang/Runnable
    //   170: astore 26
    //   172: iload 8
    //   174: istore 4
    //   176: iload 7
    //   178: istore 16
    //   180: iload 11
    //   182: istore 7
    //   184: iload 13
    //   186: istore 19
    //   188: iload 12
    //   190: istore 20
    //   192: goto +594 -> 786
    //   195: aload_0
    //   196: getfield 122	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mPaused	Z
    //   199: aload_0
    //   200: getfield 124	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mRequestPaused	Z
    //   203: if_icmpeq +1137 -> 1340
    //   206: aload_0
    //   207: getfield 124	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mRequestPaused	Z
    //   210: istore 21
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 124	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mRequestPaused	Z
    //   217: putfield 122	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mPaused	Z
    //   220: aload_0
    //   221: getfield 60	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   224: invokevirtual 94	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   227: checkcast 82	com/tencent/qg/sdk/QGJavaScriptView
    //   230: astore 23
    //   232: aload 23
    //   234: ifnull +15 -> 249
    //   237: aload 23
    //   239: getfield 98	com/tencent/qg/sdk/QGJavaScriptView:mRenderer	Lcom/tencent/qg/sdk/QGJavaScriptView$Renderer;
    //   242: aload 24
    //   244: invokeinterface 127 2 0
    //   249: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   252: invokevirtual 132	java/lang/Object:notifyAll	()V
    //   255: goto +3 -> 258
    //   258: iload 7
    //   260: istore 4
    //   262: aload_0
    //   263: getfield 134	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mShouldReleaseEglContext	Z
    //   266: ifeq +19 -> 285
    //   269: aload_0
    //   270: invokespecial 107	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglSurfaceLocked	()V
    //   273: aload_0
    //   274: invokespecial 110	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglContextLocked	()V
    //   277: aload_0
    //   278: iconst_0
    //   279: putfield 134	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mShouldReleaseEglContext	Z
    //   282: iconst_1
    //   283: istore 4
    //   285: iload 6
    //   287: istore 14
    //   289: iload 6
    //   291: ifeq +14 -> 305
    //   294: aload_0
    //   295: invokespecial 107	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglSurfaceLocked	()V
    //   298: aload_0
    //   299: invokespecial 110	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglContextLocked	()V
    //   302: iconst_0
    //   303: istore 14
    //   305: iload 21
    //   307: ifeq +14 -> 321
    //   310: aload_0
    //   311: getfield 80	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
    //   314: ifeq +7 -> 321
    //   317: aload_0
    //   318: invokespecial 107	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglSurfaceLocked	()V
    //   321: iload 21
    //   323: ifeq +49 -> 372
    //   326: aload_0
    //   327: getfield 78	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglContext	Z
    //   330: ifeq +42 -> 372
    //   333: aload_0
    //   334: getfield 60	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   337: invokevirtual 94	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   340: checkcast 82	com/tencent/qg/sdk/QGJavaScriptView
    //   343: astore 23
    //   345: aload 23
    //   347: ifnonnull +9 -> 356
    //   350: iconst_0
    //   351: istore 21
    //   353: goto +10 -> 363
    //   356: aload 23
    //   358: getfield 137	com/tencent/qg/sdk/QGJavaScriptView:mPreserveEGLContextOnPause	Z
    //   361: istore 21
    //   363: iload 21
    //   365: ifne +7 -> 372
    //   368: aload_0
    //   369: invokespecial 110	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglContextLocked	()V
    //   372: aload_0
    //   373: getfield 139	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHasSurface	Z
    //   376: ifne +41 -> 417
    //   379: aload_0
    //   380: getfield 141	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWaitingForSurface	Z
    //   383: ifne +34 -> 417
    //   386: aload_0
    //   387: getfield 80	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
    //   390: ifeq +956 -> 1346
    //   393: aload_0
    //   394: iconst_0
    //   395: putfield 80	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
    //   398: goto +3 -> 401
    //   401: aload_0
    //   402: iconst_1
    //   403: putfield 141	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWaitingForSurface	Z
    //   406: aload_0
    //   407: iconst_0
    //   408: putfield 143	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mSurfaceIsBad	Z
    //   411: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   414: invokevirtual 132	java/lang/Object:notifyAll	()V
    //   417: aload_0
    //   418: getfield 139	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHasSurface	Z
    //   421: ifeq +21 -> 442
    //   424: aload_0
    //   425: getfield 141	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWaitingForSurface	Z
    //   428: ifeq +14 -> 442
    //   431: aload_0
    //   432: iconst_0
    //   433: putfield 141	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWaitingForSurface	Z
    //   436: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   439: invokevirtual 132	java/lang/Object:notifyAll	()V
    //   442: iload 8
    //   444: istore 15
    //   446: iload 8
    //   448: ifeq +22 -> 470
    //   451: aload_0
    //   452: iconst_0
    //   453: putfield 58	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWantRenderNotification	Z
    //   456: aload_0
    //   457: iconst_1
    //   458: putfield 145	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mRenderComplete	Z
    //   461: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   464: invokevirtual 132	java/lang/Object:notifyAll	()V
    //   467: iconst_0
    //   468: istore 15
    //   470: aload_0
    //   471: getfield 48	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mFinishDrawingRunnable	Ljava/lang/Runnable;
    //   474: ifnull +875 -> 1349
    //   477: aload_0
    //   478: getfield 48	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mFinishDrawingRunnable	Ljava/lang/Runnable;
    //   481: astore 23
    //   483: aload_0
    //   484: aconst_null
    //   485: putfield 48	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mFinishDrawingRunnable	Ljava/lang/Runnable;
    //   488: goto +3 -> 491
    //   491: aload_0
    //   492: invokespecial 148	com/tencent/qg/sdk/QGJavaScriptView$GLThread:readyToDraw	()Z
    //   495: ifeq +735 -> 1230
    //   498: aload_0
    //   499: getfield 78	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglContext	Z
    //   502: istore 21
    //   504: iload 4
    //   506: istore 8
    //   508: iload_2
    //   509: istore 9
    //   511: iload 21
    //   513: ifne +57 -> 570
    //   516: iload 4
    //   518: ifeq +12 -> 530
    //   521: iconst_0
    //   522: istore 8
    //   524: iload_2
    //   525: istore 9
    //   527: goto +43 -> 570
    //   530: aload_0
    //   531: getfield 76	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
    //   534: invokevirtual 151	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:start	()V
    //   537: aload_0
    //   538: iconst_1
    //   539: putfield 78	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglContext	Z
    //   542: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   545: invokevirtual 132	java/lang/Object:notifyAll	()V
    //   548: iconst_1
    //   549: istore 9
    //   551: iload 4
    //   553: istore 8
    //   555: goto +15 -> 570
    //   558: astore 22
    //   560: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   563: aload_0
    //   564: invokevirtual 157	com/tencent/qg/sdk/QGJavaScriptView$GLThreadManager:releaseEglContextLocked	(Lcom/tencent/qg/sdk/QGJavaScriptView$GLThread;)V
    //   567: aload 22
    //   569: athrow
    //   570: iload 5
    //   572: istore 10
    //   574: iload_3
    //   575: istore 4
    //   577: iload_1
    //   578: istore_2
    //   579: aload_0
    //   580: getfield 78	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglContext	Z
    //   583: ifeq +32 -> 615
    //   586: iload 5
    //   588: istore 10
    //   590: iload_3
    //   591: istore 4
    //   593: iload_1
    //   594: istore_2
    //   595: aload_0
    //   596: getfield 80	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
    //   599: ifne +16 -> 615
    //   602: aload_0
    //   603: iconst_1
    //   604: putfield 80	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
    //   607: iconst_1
    //   608: istore 10
    //   610: iconst_1
    //   611: istore 4
    //   613: iconst_1
    //   614: istore_2
    //   615: iload 8
    //   617: istore 18
    //   619: iload 10
    //   621: istore 17
    //   623: iload 4
    //   625: istore 16
    //   627: iload 9
    //   629: istore 7
    //   631: iload_2
    //   632: istore 6
    //   634: aload_0
    //   635: getfield 80	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHaveEglSurface	Z
    //   638: ifeq +757 -> 1395
    //   641: aload_0
    //   642: getfield 46	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mSizeChanged	Z
    //   645: ifeq +711 -> 1356
    //   648: aload_0
    //   649: getfield 50	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWidth	I
    //   652: istore 13
    //   654: aload_0
    //   655: getfield 52	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mHeight	I
    //   658: istore 12
    //   660: aload_0
    //   661: iconst_1
    //   662: putfield 58	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWantRenderNotification	Z
    //   665: aload_0
    //   666: iconst_0
    //   667: putfield 46	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mSizeChanged	Z
    //   670: iconst_1
    //   671: istore 17
    //   673: iconst_1
    //   674: istore 18
    //   676: goto +3 -> 679
    //   679: aload_0
    //   680: iconst_0
    //   681: putfield 54	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mRequestRender	Z
    //   684: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   687: invokevirtual 132	java/lang/Object:notifyAll	()V
    //   690: aload 23
    //   692: astore 22
    //   694: iload 14
    //   696: istore 6
    //   698: iload 15
    //   700: istore 4
    //   702: iload 8
    //   704: istore 16
    //   706: iload 10
    //   708: istore 5
    //   710: iload 17
    //   712: istore_3
    //   713: iload 11
    //   715: istore 7
    //   717: iload 13
    //   719: istore 19
    //   721: iload 12
    //   723: istore 20
    //   725: aload 25
    //   727: astore 26
    //   729: iload 9
    //   731: istore_2
    //   732: iload 18
    //   734: istore_1
    //   735: aload_0
    //   736: getfield 58	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mWantRenderNotification	Z
    //   739: ifeq +47 -> 786
    //   742: iconst_1
    //   743: istore 7
    //   745: iload 18
    //   747: istore_1
    //   748: iload 9
    //   750: istore_2
    //   751: aload 25
    //   753: astore 26
    //   755: iload 12
    //   757: istore 20
    //   759: iload 13
    //   761: istore 19
    //   763: iload 17
    //   765: istore_3
    //   766: iload 10
    //   768: istore 5
    //   770: iload 8
    //   772: istore 16
    //   774: iload 15
    //   776: istore 4
    //   778: iload 14
    //   780: istore 6
    //   782: aload 23
    //   784: astore 22
    //   786: aload 27
    //   788: monitorexit
    //   789: aload 26
    //   791: ifnull +28 -> 819
    //   794: aload 26
    //   796: invokeinterface 160 1 0
    //   801: aconst_null
    //   802: astore 25
    //   804: iload 7
    //   806: istore 11
    //   808: iload 19
    //   810: istore 13
    //   812: iload 20
    //   814: istore 12
    //   816: goto -750 -> 66
    //   819: iload_1
    //   820: istore 8
    //   822: iload_1
    //   823: ifeq +87 -> 910
    //   826: aload_0
    //   827: getfield 76	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
    //   830: invokevirtual 163	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:createSurface	()Z
    //   833: ifeq +39 -> 872
    //   836: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   839: astore 23
    //   841: aload 23
    //   843: monitorenter
    //   844: aload_0
    //   845: iconst_1
    //   846: putfield 165	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mFinishedCreatingEglSurface	Z
    //   849: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   852: invokevirtual 132	java/lang/Object:notifyAll	()V
    //   855: aload 23
    //   857: monitorexit
    //   858: iconst_0
    //   859: istore 8
    //   861: goto +49 -> 910
    //   864: astore 22
    //   866: aload 23
    //   868: monitorexit
    //   869: aload 22
    //   871: athrow
    //   872: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   875: astore 23
    //   877: aload 23
    //   879: monitorenter
    //   880: aload_0
    //   881: iconst_1
    //   882: putfield 165	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mFinishedCreatingEglSurface	Z
    //   885: aload_0
    //   886: iconst_1
    //   887: putfield 143	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mSurfaceIsBad	Z
    //   890: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   893: invokevirtual 132	java/lang/Object:notifyAll	()V
    //   896: aload 23
    //   898: monitorexit
    //   899: goto +467 -> 1366
    //   902: astore 22
    //   904: aload 23
    //   906: monitorexit
    //   907: aload 22
    //   909: athrow
    //   910: iload 5
    //   912: istore 9
    //   914: iload 5
    //   916: ifeq +18 -> 934
    //   919: aload_0
    //   920: getfield 76	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
    //   923: invokevirtual 169	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:createGL	()Ljavax/microedition/khronos/opengles/GL;
    //   926: checkcast 171	javax/microedition/khronos/opengles/GL10
    //   929: astore 24
    //   931: iconst_0
    //   932: istore 9
    //   934: iload_2
    //   935: istore_1
    //   936: iload_2
    //   937: ifeq +58 -> 995
    //   940: aload_0
    //   941: getfield 60	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   944: invokevirtual 94	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   947: checkcast 82	com/tencent/qg/sdk/QGJavaScriptView
    //   950: astore 23
    //   952: aload 23
    //   954: ifnull +431 -> 1385
    //   957: ldc 173
    //   959: invokestatic 179	android/os/Trace:beginSection	(Ljava/lang/String;)V
    //   962: aload 23
    //   964: getfield 98	com/tencent/qg/sdk/QGJavaScriptView:mRenderer	Lcom/tencent/qg/sdk/QGJavaScriptView$Renderer;
    //   967: aload 24
    //   969: aload_0
    //   970: getfield 76	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
    //   973: getfield 183	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   976: invokeinterface 187 3 0
    //   981: invokestatic 190	android/os/Trace:endSection	()V
    //   984: goto +401 -> 1385
    //   987: astore 22
    //   989: invokestatic 190	android/os/Trace:endSection	()V
    //   992: aload 22
    //   994: athrow
    //   995: iload_3
    //   996: istore_2
    //   997: iload_3
    //   998: ifeq +55 -> 1053
    //   1001: aload_0
    //   1002: getfield 60	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1005: invokevirtual 94	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1008: checkcast 82	com/tencent/qg/sdk/QGJavaScriptView
    //   1011: astore 23
    //   1013: aload 23
    //   1015: ifnull +375 -> 1390
    //   1018: ldc 192
    //   1020: invokestatic 179	android/os/Trace:beginSection	(Ljava/lang/String;)V
    //   1023: aload 23
    //   1025: getfield 98	com/tencent/qg/sdk/QGJavaScriptView:mRenderer	Lcom/tencent/qg/sdk/QGJavaScriptView$Renderer;
    //   1028: aload 24
    //   1030: iload 19
    //   1032: iload 20
    //   1034: invokeinterface 196 4 0
    //   1039: invokestatic 190	android/os/Trace:endSection	()V
    //   1042: goto +348 -> 1390
    //   1045: astore 22
    //   1047: invokestatic 190	android/os/Trace:endSection	()V
    //   1050: aload 22
    //   1052: athrow
    //   1053: aload_0
    //   1054: getfield 60	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   1057: invokevirtual 94	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1060: checkcast 82	com/tencent/qg/sdk/QGJavaScriptView
    //   1063: astore 25
    //   1065: aload 22
    //   1067: astore 23
    //   1069: aload 25
    //   1071: ifnull +53 -> 1124
    //   1074: ldc 198
    //   1076: invokestatic 179	android/os/Trace:beginSection	(Ljava/lang/String;)V
    //   1079: aload 25
    //   1081: getfield 98	com/tencent/qg/sdk/QGJavaScriptView:mRenderer	Lcom/tencent/qg/sdk/QGJavaScriptView$Renderer;
    //   1084: aload 24
    //   1086: invokeinterface 201 2 0
    //   1091: aload 22
    //   1093: astore 23
    //   1095: aload 22
    //   1097: ifnull +13 -> 1110
    //   1100: aload 22
    //   1102: invokeinterface 160 1 0
    //   1107: aconst_null
    //   1108: astore 23
    //   1110: invokestatic 190	android/os/Trace:endSection	()V
    //   1113: goto +11 -> 1124
    //   1116: astore 22
    //   1118: invokestatic 190	android/os/Trace:endSection	()V
    //   1121: aload 22
    //   1123: athrow
    //   1124: aload 23
    //   1126: astore 22
    //   1128: aload_0
    //   1129: getfield 76	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mEglHelper	Lcom/tencent/qg/sdk/QGJavaScriptView$EglHelper;
    //   1132: invokevirtual 205	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:getError	()I
    //   1135: istore_3
    //   1136: iload_3
    //   1137: sipush 12288
    //   1140: if_icmpeq +57 -> 1197
    //   1143: iload_3
    //   1144: sipush 12302
    //   1147: if_icmpeq +44 -> 1191
    //   1150: ldc 207
    //   1152: ldc 209
    //   1154: iload_3
    //   1155: invokestatic 213	com/tencent/qg/sdk/QGJavaScriptView$EglHelper:logEglErrorAsWarning	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1158: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   1161: astore 23
    //   1163: aload 23
    //   1165: monitorenter
    //   1166: aload_0
    //   1167: iconst_1
    //   1168: putfield 143	com/tencent/qg/sdk/QGJavaScriptView$GLThread:mSurfaceIsBad	Z
    //   1171: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   1174: invokevirtual 132	java/lang/Object:notifyAll	()V
    //   1177: aload 23
    //   1179: monitorexit
    //   1180: goto +17 -> 1197
    //   1183: astore 22
    //   1185: aload 23
    //   1187: monitorexit
    //   1188: aload 22
    //   1190: athrow
    //   1191: iconst_1
    //   1192: istore 6
    //   1194: goto +3 -> 1197
    //   1197: iload 7
    //   1199: istore 10
    //   1201: iload 7
    //   1203: ifeq +9 -> 1212
    //   1206: iconst_1
    //   1207: istore 4
    //   1209: iconst_0
    //   1210: istore 10
    //   1212: iload 9
    //   1214: istore 5
    //   1216: iload_2
    //   1217: istore_3
    //   1218: iload 10
    //   1220: istore 7
    //   1222: iload_1
    //   1223: istore_2
    //   1224: iload 8
    //   1226: istore_1
    //   1227: goto +139 -> 1366
    //   1230: iload 4
    //   1232: istore 18
    //   1234: iload 5
    //   1236: istore 17
    //   1238: iload_3
    //   1239: istore 16
    //   1241: iload_2
    //   1242: istore 7
    //   1244: iload_1
    //   1245: istore 6
    //   1247: aload 23
    //   1249: ifnull +146 -> 1395
    //   1252: ldc 215
    //   1254: ldc 217
    //   1256: invokestatic 223	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   1259: pop
    //   1260: aload 23
    //   1262: invokeinterface 160 1 0
    //   1267: aconst_null
    //   1268: astore 22
    //   1270: goto +3 -> 1273
    //   1273: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   1276: invokevirtual 226	java/lang/Object:wait	()V
    //   1279: iload 14
    //   1281: istore 6
    //   1283: iload 15
    //   1285: istore 8
    //   1287: iload 4
    //   1289: istore 7
    //   1291: goto -1209 -> 82
    //   1294: astore 22
    //   1296: aload 27
    //   1298: monitorexit
    //   1299: aload 22
    //   1301: athrow
    //   1302: astore 23
    //   1304: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   1307: astore 22
    //   1309: aload 22
    //   1311: monitorenter
    //   1312: aload_0
    //   1313: invokespecial 107	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglSurfaceLocked	()V
    //   1316: aload_0
    //   1317: invokespecial 110	com/tencent/qg/sdk/QGJavaScriptView$GLThread:stopEglContextLocked	()V
    //   1320: aload 22
    //   1322: monitorexit
    //   1323: aload 23
    //   1325: athrow
    //   1326: astore 23
    //   1328: aload 22
    //   1330: monitorexit
    //   1331: goto +6 -> 1337
    //   1334: aload 23
    //   1336: athrow
    //   1337: goto -3 -> 1334
    //   1340: iconst_0
    //   1341: istore 21
    //   1343: goto -1085 -> 258
    //   1346: goto -945 -> 401
    //   1349: aload 22
    //   1351: astore 23
    //   1353: goto -862 -> 491
    //   1356: iload 4
    //   1358: istore 17
    //   1360: iload_2
    //   1361: istore 18
    //   1363: goto -684 -> 679
    //   1366: iload 7
    //   1368: istore 11
    //   1370: iload 19
    //   1372: istore 13
    //   1374: iload 20
    //   1376: istore 12
    //   1378: aload 26
    //   1380: astore 25
    //   1382: goto -1316 -> 66
    //   1385: iconst_0
    //   1386: istore_1
    //   1387: goto -392 -> 995
    //   1390: iconst_0
    //   1391: istore_2
    //   1392: goto -339 -> 1053
    //   1395: aload 23
    //   1397: astore 22
    //   1399: iload 18
    //   1401: istore 4
    //   1403: iload 17
    //   1405: istore 5
    //   1407: iload 16
    //   1409: istore_3
    //   1410: iload 7
    //   1412: istore_2
    //   1413: iload 6
    //   1415: istore_1
    //   1416: goto -143 -> 1273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1419	0	this	GLThread
    //   65	1351	1	i	int
    //   63	1350	2	j	int
    //   49	1361	3	k	int
    //   37	1365	4	m	int
    //   46	1360	5	n	int
    //   34	1380	6	i1	int
    //   76	1335	7	i2	int
    //   80	1206	8	i3	int
    //   509	704	9	i4	int
    //   572	647	10	i5	int
    //   51	1318	11	i6	int
    //   57	1320	12	i7	int
    //   54	1319	13	i8	int
    //   287	993	14	i9	int
    //   444	840	15	i10	int
    //   40	1368	16	i11	int
    //   621	783	17	i12	int
    //   617	783	18	i13	int
    //   186	1185	19	i14	int
    //   190	1185	20	i15	int
    //   210	1132	21	bool	boolean
    //   43	101	22	localObject1	Object
    //   558	10	22	localRuntimeException	java.lang.RuntimeException
    //   692	93	22	localObject2	Object
    //   864	6	22	localObject3	Object
    //   902	6	22	localObject4	Object
    //   987	6	22	localObject5	Object
    //   1045	56	22	localObject6	Object
    //   1116	6	22	localObject7	Object
    //   1126	1	22	localObject8	Object
    //   1183	6	22	localObject9	Object
    //   1268	1	22	localObject10	Object
    //   1294	6	22	localObject11	Object
    //   1307	91	22	localObject12	Object
    //   141	6	23	localObject13	Object
    //   230	1031	23	localObject14	Object
    //   1302	22	23	localObject15	Object
    //   1326	9	23	localObject16	Object
    //   1351	45	23	localObject17	Object
    //   31	1054	24	localGL10	javax.microedition.khronos.opengles.GL10
    //   60	1321	25	localObject18	Object
    //   170	1209	26	localObject19	Object
    //   69	1228	27	localGLThreadManager	QGJavaScriptView.GLThreadManager
    // Exception table:
    //   from	to	target	type
    //   129	140	141	finally
    //   143	146	141	finally
    //   530	537	558	java/lang/RuntimeException
    //   844	858	864	finally
    //   866	869	864	finally
    //   880	899	902	finally
    //   904	907	902	finally
    //   957	981	987	finally
    //   1018	1039	1045	finally
    //   1074	1091	1116	finally
    //   1100	1107	1116	finally
    //   1166	1180	1183	finally
    //   1185	1188	1183	finally
    //   82	101	1294	finally
    //   106	118	1294	finally
    //   118	121	1294	finally
    //   149	172	1294	finally
    //   195	232	1294	finally
    //   237	249	1294	finally
    //   249	255	1294	finally
    //   262	282	1294	finally
    //   294	302	1294	finally
    //   310	321	1294	finally
    //   326	345	1294	finally
    //   356	363	1294	finally
    //   368	372	1294	finally
    //   372	398	1294	finally
    //   401	417	1294	finally
    //   417	442	1294	finally
    //   451	467	1294	finally
    //   470	488	1294	finally
    //   491	504	1294	finally
    //   530	537	1294	finally
    //   537	548	1294	finally
    //   560	570	1294	finally
    //   579	586	1294	finally
    //   595	607	1294	finally
    //   634	670	1294	finally
    //   679	690	1294	finally
    //   735	742	1294	finally
    //   786	789	1294	finally
    //   1252	1267	1294	finally
    //   1273	1279	1294	finally
    //   1296	1299	1294	finally
    //   66	74	1302	finally
    //   794	801	1302	finally
    //   826	844	1302	finally
    //   869	872	1302	finally
    //   872	880	1302	finally
    //   907	910	1302	finally
    //   919	931	1302	finally
    //   940	952	1302	finally
    //   981	984	1302	finally
    //   989	995	1302	finally
    //   1001	1013	1302	finally
    //   1039	1042	1302	finally
    //   1047	1053	1302	finally
    //   1053	1065	1302	finally
    //   1110	1113	1302	finally
    //   1118	1124	1302	finally
    //   1128	1136	1302	finally
    //   1150	1166	1302	finally
    //   1188	1191	1302	finally
    //   1299	1302	1302	finally
    //   1312	1323	1326	finally
    //   1328	1331	1326	finally
  }
  
  private boolean readyToDraw()
  {
    boolean bool2 = this.mPaused;
    boolean bool1 = true;
    if ((!bool2) && (this.mHasSurface) && (!this.mSurfaceIsBad) && (this.mWidth > 0) && (this.mHeight > 0))
    {
      if (this.mRequestRender) {
        return bool1;
      }
      if (this.mRenderMode == 1) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  private void stopEglContextLocked()
  {
    if (this.mHaveEglContext)
    {
      this.mEglHelper.finish();
      this.mHaveEglContext = false;
      QGJavaScriptView.sGLThreadManager.releaseEglContextLocked(this);
    }
  }
  
  private void stopEglSurfaceLocked()
  {
    if (this.mHaveEglSurface)
    {
      this.mHaveEglSurface = false;
      this.mEglHelper.destroySurface();
    }
  }
  
  public boolean ableToDraw()
  {
    return (this.mHaveEglContext) && (this.mHaveEglSurface) && (readyToDraw());
  }
  
  public int getRenderMode()
  {
    synchronized (QGJavaScriptView.sGLThreadManager)
    {
      int i = this.mRenderMode;
      return i;
    }
  }
  
  public void onPause()
  {
    synchronized (QGJavaScriptView.sGLThreadManager)
    {
      this.mRequestPaused = true;
      QGJavaScriptView.sGLThreadManager.notifyAll();
      while (!this.mExited)
      {
        boolean bool = this.mPaused;
        if (bool) {
          break;
        }
        try
        {
          QGJavaScriptView.sGLThreadManager.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label42:
          break label42;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void onResume()
  {
    synchronized (QGJavaScriptView.sGLThreadManager)
    {
      this.mRequestPaused = false;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      QGJavaScriptView.sGLThreadManager.notifyAll();
      while ((!this.mExited) && (this.mPaused))
      {
        boolean bool = this.mRenderComplete;
        if (bool) {
          break;
        }
        try
        {
          QGJavaScriptView.sGLThreadManager.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label59:
          break label59;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void onWindowResize(int paramInt1, int paramInt2)
  {
    synchronized (QGJavaScriptView.sGLThreadManager)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.mSizeChanged = true;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      if (Thread.currentThread() == this) {
        return;
      }
      QGJavaScriptView.sGLThreadManager.notifyAll();
      while ((!this.mExited) && (!this.mPaused) && (!this.mRenderComplete))
      {
        boolean bool = ableToDraw();
        if (!bool) {
          break;
        }
        try
        {
          QGJavaScriptView.sGLThreadManager.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label89:
          break label89;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mEventQueue.add(paramRunnable);
        QGJavaScriptView.sGLThreadManager.notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("r must not be null");
  }
  
  public void requestExitAndWait()
  {
    synchronized (QGJavaScriptView.sGLThreadManager)
    {
      this.mShouldExit = true;
      QGJavaScriptView.sGLThreadManager.notifyAll();
      for (;;)
      {
        boolean bool = this.mExited;
        if (bool) {
          break;
        }
        try
        {
          QGJavaScriptView.sGLThreadManager.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label35:
          break label35;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void requestReleaseEglContextLocked()
  {
    this.mShouldReleaseEglContext = true;
    QGJavaScriptView.sGLThreadManager.notifyAll();
  }
  
  public void requestRender()
  {
    synchronized (QGJavaScriptView.sGLThreadManager)
    {
      this.mRequestRender = true;
      QGJavaScriptView.sGLThreadManager.notifyAll();
      return;
    }
  }
  
  public void requestRenderAndNotify(Runnable paramRunnable)
  {
    synchronized (QGJavaScriptView.sGLThreadManager)
    {
      if (Thread.currentThread() == this) {
        return;
      }
      this.mWantRenderNotification = true;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      this.mFinishDrawingRunnable = paramRunnable;
      QGJavaScriptView.sGLThreadManager.notifyAll();
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 267	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc_w 270
    //   12: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 278	com/tencent/qg/sdk/QGJavaScriptView$GLThread:getId	()J
    //   21: invokevirtual 281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 288	com/tencent/qg/sdk/QGJavaScriptView$GLThread:setName	(Ljava/lang/String;)V
    //   33: bipush 236
    //   35: invokestatic 294	android/os/Process:setThreadPriority	(I)V
    //   38: aload_0
    //   39: invokespecial 296	com/tencent/qg/sdk/QGJavaScriptView$GLThread:guardedRun	()V
    //   42: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   45: aload_0
    //   46: invokevirtual 299	com/tencent/qg/sdk/QGJavaScriptView$GLThreadManager:threadExiting	(Lcom/tencent/qg/sdk/QGJavaScriptView$GLThread;)V
    //   49: return
    //   50: astore_1
    //   51: getstatic 86	com/tencent/qg/sdk/QGJavaScriptView:sGLThreadManager	Lcom/tencent/qg/sdk/QGJavaScriptView$GLThreadManager;
    //   54: aload_0
    //   55: invokevirtual 299	com/tencent/qg/sdk/QGJavaScriptView$GLThreadManager:threadExiting	(Lcom/tencent/qg/sdk/QGJavaScriptView$GLThread;)V
    //   58: aload_1
    //   59: athrow
    //   60: astore_1
    //   61: goto -19 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	GLThread
    //   7	20	1	localStringBuilder	java.lang.StringBuilder
    //   50	9	1	localObject	Object
    //   60	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   38	42	50	finally
    //   38	42	60	java/lang/InterruptedException
  }
  
  public void setRenderMode(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      synchronized (QGJavaScriptView.sGLThreadManager)
      {
        this.mRenderMode = paramInt;
        QGJavaScriptView.sGLThreadManager.notifyAll();
        return;
      }
    }
    throw new IllegalArgumentException("renderMode");
  }
  
  public void surfaceCreated()
  {
    synchronized (QGJavaScriptView.sGLThreadManager)
    {
      this.mHasSurface = true;
      this.mFinishedCreatingEglSurface = false;
      QGJavaScriptView.sGLThreadManager.notifyAll();
      while ((this.mWaitingForSurface) && (!this.mFinishedCreatingEglSurface))
      {
        boolean bool = this.mExited;
        if (bool) {
          break;
        }
        try
        {
          QGJavaScriptView.sGLThreadManager.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label54:
          break label54;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public void surfaceDestroyed()
  {
    synchronized (QGJavaScriptView.sGLThreadManager)
    {
      this.mHasSurface = false;
      QGJavaScriptView.sGLThreadManager.notifyAll();
      while (!this.mWaitingForSurface)
      {
        boolean bool = this.mExited;
        if (bool) {
          break;
        }
        try
        {
          QGJavaScriptView.sGLThreadManager.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label42:
          break label42;
        }
        Thread.currentThread().interrupt();
      }
      return;
    }
  }
  
  public int swap()
  {
    return this.mEglHelper.swap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView.GLThread
 * JD-Core Version:    0.7.0.1
 */