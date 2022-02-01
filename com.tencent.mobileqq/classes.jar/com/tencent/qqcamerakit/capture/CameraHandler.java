package com.tencent.qqcamerakit.capture;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.qqcamerakit.capture.camera2.Camera2Control.Camera2Listener;
import java.util.HashMap;
import java.util.Map;

public class CameraHandler
  extends Handler
  implements Camera2Control.Camera2Listener
{
  public Map<String, CameraHandler.ParamCache> a = new HashMap();
  public Map<String, CameraHandler.ParamCamera2Cache> b = new HashMap();
  private CameraObservable c;
  
  public CameraHandler(Looper paramLooper, CameraObservable paramCameraObservable)
  {
    super(paramLooper);
    this.c = paramCameraObservable;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    this.c.a(paramInt1, paramInt2, paramString, paramVarArgs);
  }
  
  public void a(long paramLong, String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("Timeout waiting ");
    ((StringBuilder)???).append(paramLong);
    ((StringBuilder)???).append("ms for ");
    ((StringBuilder)???).append(paramString);
    paramString = ((StringBuilder)???).toString();
    long l = SystemClock.uptimeMillis() + paramLong;
    try
    {
      CameraHandler.WaitDoneBundle localWaitDoneBundle = new CameraHandler.WaitDoneBundle();
      post(localWaitDoneBundle.a);
      synchronized (localWaitDoneBundle.b)
      {
        localWaitDoneBundle.b.wait(paramLong);
        if (SystemClock.uptimeMillis() <= l) {
          return;
        }
        throw new IllegalStateException(paramString);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label120:
      break label120;
    }
    if (SystemClock.uptimeMillis() <= l) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 92	android/os/Handler:handleMessage	(Landroid/os/Message;)V
    //   5: aload_1
    //   6: getfield 98	android/os/Message:what	I
    //   9: istore_2
    //   10: iconst_0
    //   11: istore 4
    //   13: iload_2
    //   14: iconst_1
    //   15: if_icmpeq +2429 -> 2444
    //   18: iload_2
    //   19: iconst_2
    //   20: if_icmpeq +2370 -> 2390
    //   23: iload_2
    //   24: iconst_3
    //   25: if_icmpeq +1770 -> 1795
    //   28: iload_2
    //   29: sipush 201
    //   32: if_icmpeq +1702 -> 1734
    //   35: iload_2
    //   36: sipush 301
    //   39: if_icmpeq +1586 -> 1625
    //   42: iload_2
    //   43: sipush 401
    //   46: if_icmpeq +1483 -> 1529
    //   49: iload_2
    //   50: sipush 701
    //   53: if_icmpeq +1460 -> 1513
    //   56: aconst_null
    //   57: astore 5
    //   59: iload_2
    //   60: sipush 1005
    //   63: if_icmpeq +860 -> 923
    //   66: iload_2
    //   67: sipush 1010
    //   70: if_icmpeq +784 -> 854
    //   73: iload_2
    //   74: sipush 1021
    //   77: if_icmpeq +747 -> 824
    //   80: iload_2
    //   81: sipush 1050
    //   84: if_icmpeq +714 -> 798
    //   87: iload_2
    //   88: sipush 601
    //   91: if_icmpeq +693 -> 784
    //   94: iload_2
    //   95: sipush 602
    //   98: if_icmpeq +672 -> 770
    //   101: iload_2
    //   102: sipush 1040
    //   105: if_icmpeq +652 -> 757
    //   108: iload_2
    //   109: sipush 1041
    //   112: if_icmpeq +632 -> 744
    //   115: iload_2
    //   116: tableswitch	default:+28 -> 144, 101:+579->695, 102:+546->662, 103:+497->613
    //   145: tableswitch	default:+27 -> 172, 203:+394->539, 204:+331->476, 205:+283->428
    //   173: tableswitch	default:+27 -> 200, 1001:+176->349, 1002:+126->299, 1003:+117->290
    //   201: tableswitch	default:+27 -> 228, 1030:+69->270, 1031:+60->261, 1032:+30->231
    //   229: lconst_0
    //   230: fload 184
    //   232: nop
    //   233: dsub
    //   234: ifeq +18 -> 252
    //   237: ldc 105
    //   239: iconst_2
    //   240: iconst_1
    //   241: anewarray 77	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: ldc 107
    //   248: aastore
    //   249: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   252: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   255: invokevirtual 118	com/tencent/qqcamerakit/capture/camera2/Camera2Control:l	()V
    //   258: goto +2297 -> 2555
    //   261: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   264: invokevirtual 121	com/tencent/qqcamerakit/capture/camera2/Camera2Control:k	()V
    //   267: goto +2288 -> 2555
    //   270: aload_1
    //   271: getfield 124	android/os/Message:obj	Ljava/lang/Object;
    //   274: checkcast 126	com/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams
    //   277: astore 5
    //   279: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   282: aload 5
    //   284: invokevirtual 129	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Lcom/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams;)V
    //   287: goto +2268 -> 2555
    //   290: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   293: invokevirtual 132	com/tencent/qqcamerakit/capture/camera2/Camera2Control:h	()V
    //   296: goto +2259 -> 2555
    //   299: aload_1
    //   300: getfield 124	android/os/Message:obj	Ljava/lang/Object;
    //   303: checkcast 134	[Ljava/lang/Object;
    //   306: checkcast 134	[Ljava/lang/Object;
    //   309: astore 7
    //   311: aload 7
    //   313: iconst_0
    //   314: aaload
    //   315: checkcast 136	android/graphics/SurfaceTexture
    //   318: astore 6
    //   320: aload 7
    //   322: iconst_1
    //   323: aaload
    //   324: ifnull +12 -> 336
    //   327: aload 7
    //   329: iconst_1
    //   330: aaload
    //   331: checkcast 138	com/tencent/qqcamerakit/capture/CameraPreviewCallBack
    //   334: astore 5
    //   336: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   339: aload 6
    //   341: aload 5
    //   343: invokevirtual 141	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Landroid/graphics/SurfaceTexture;Lcom/tencent/qqcamerakit/capture/CameraPreviewCallBack;)V
    //   346: goto +2209 -> 2555
    //   349: aload_1
    //   350: getfield 144	android/os/Message:arg1	I
    //   353: istore_2
    //   354: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   357: iload_2
    //   358: aload_0
    //   359: invokevirtual 147	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(ILcom/tencent/qqcamerakit/capture/camera2/Camera2Control$Camera2Listener;)I
    //   362: istore_2
    //   363: iload_2
    //   364: bipush 6
    //   366: if_icmpne +38 -> 404
    //   369: ldc 105
    //   371: iconst_1
    //   372: iconst_1
    //   373: anewarray 77	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: ldc 149
    //   380: aastore
    //   381: invokestatic 151	com/tencent/qqcamerakit/common/QLog:a	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   384: aload_0
    //   385: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   388: iconst_1
    //   389: iconst_0
    //   390: ldc 153
    //   392: iconst_0
    //   393: anewarray 77	java/lang/Object
    //   396: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   399: aload_1
    //   400: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   403: return
    //   404: iload_2
    //   405: ifeq +2150 -> 2555
    //   408: aload_0
    //   409: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   412: iconst_1
    //   413: iload_2
    //   414: iload_2
    //   415: invokestatic 160	com/tencent/qqcamerakit/capture/camera/CameraControl:b	(I)Ljava/lang/String;
    //   418: iconst_0
    //   419: anewarray 77	java/lang/Object
    //   422: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   425: goto +2130 -> 2555
    //   428: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   431: ifeq +18 -> 449
    //   434: ldc 105
    //   436: iconst_2
    //   437: iconst_1
    //   438: anewarray 77	java/lang/Object
    //   441: dup
    //   442: iconst_0
    //   443: ldc 162
    //   445: aastore
    //   446: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   449: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   452: invokevirtual 168	com/tencent/qqcamerakit/capture/camera/CameraControl:o	()Z
    //   455: ifne +2100 -> 2555
    //   458: aload_0
    //   459: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   462: iconst_4
    //   463: iconst_m1
    //   464: ldc 170
    //   466: iconst_0
    //   467: anewarray 77	java/lang/Object
    //   470: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   473: goto +2082 -> 2555
    //   476: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   479: ifeq +18 -> 497
    //   482: ldc 105
    //   484: iconst_2
    //   485: iconst_1
    //   486: anewarray 77	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: ldc 172
    //   493: aastore
    //   494: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   497: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   500: invokevirtual 175	com/tencent/qqcamerakit/capture/camera/CameraControl:m	()Z
    //   503: ifne +18 -> 521
    //   506: aload_0
    //   507: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   510: iconst_3
    //   511: iconst_m1
    //   512: ldc 177
    //   514: iconst_0
    //   515: anewarray 77	java/lang/Object
    //   518: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   521: aload_0
    //   522: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   525: iconst_3
    //   526: iconst_0
    //   527: ldc 153
    //   529: iconst_0
    //   530: anewarray 77	java/lang/Object
    //   533: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   536: goto +2019 -> 2555
    //   539: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   542: ifeq +18 -> 560
    //   545: ldc 105
    //   547: iconst_2
    //   548: iconst_1
    //   549: anewarray 77	java/lang/Object
    //   552: dup
    //   553: iconst_0
    //   554: ldc 179
    //   556: aastore
    //   557: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   560: aload_1
    //   561: getfield 124	android/os/Message:obj	Ljava/lang/Object;
    //   564: checkcast 138	com/tencent/qqcamerakit/capture/CameraPreviewCallBack
    //   567: astore 5
    //   569: aload_1
    //   570: getfield 144	android/os/Message:arg1	I
    //   573: ifle +2025 -> 2598
    //   576: iconst_1
    //   577: istore 4
    //   579: goto +3 -> 582
    //   582: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   585: aload 5
    //   587: iload 4
    //   589: invokevirtual 182	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Lcom/tencent/qqcamerakit/capture/CameraPreviewCallBack;Z)Z
    //   592: ifne +1963 -> 2555
    //   595: aload_0
    //   596: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   599: iconst_2
    //   600: iconst_m1
    //   601: ldc 184
    //   603: iconst_0
    //   604: anewarray 77	java/lang/Object
    //   607: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   610: goto +1945 -> 2555
    //   613: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   616: ifeq +18 -> 634
    //   619: ldc 105
    //   621: iconst_2
    //   622: iconst_1
    //   623: anewarray 77	java/lang/Object
    //   626: dup
    //   627: iconst_0
    //   628: ldc 186
    //   630: aastore
    //   631: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   634: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   637: invokevirtual 188	com/tencent/qqcamerakit/capture/camera/CameraControl:k	()Z
    //   640: ifeq +1915 -> 2555
    //   643: aload_0
    //   644: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   647: bipush 7
    //   649: iconst_m1
    //   650: ldc 190
    //   652: iconst_0
    //   653: anewarray 77	java/lang/Object
    //   656: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   659: goto +1896 -> 2555
    //   662: aload_1
    //   663: getfield 124	android/os/Message:obj	Ljava/lang/Object;
    //   666: checkcast 126	com/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams
    //   669: astore 5
    //   671: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   674: aload 5
    //   676: getfield 193	com/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams:h	Landroid/graphics/Rect;
    //   679: aload 5
    //   681: getfield 196	com/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams:i	Landroid/graphics/Rect;
    //   684: aload 5
    //   686: getfield 200	com/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams:g	Lcom/tencent/qqcamerakit/capture/CameraProxy$CameraAutoFocusCallBack;
    //   689: invokevirtual 203	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Landroid/graphics/Rect;Landroid/graphics/Rect;Lcom/tencent/qqcamerakit/capture/CameraProxy$CameraAutoFocusCallBack;)V
    //   692: goto +1863 -> 2555
    //   695: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   698: ifeq +18 -> 716
    //   701: ldc 105
    //   703: iconst_2
    //   704: iconst_1
    //   705: anewarray 77	java/lang/Object
    //   708: dup
    //   709: iconst_0
    //   710: ldc 205
    //   712: aastore
    //   713: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   716: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   719: invokevirtual 208	com/tencent/qqcamerakit/capture/camera/CameraControl:j	()Z
    //   722: ifeq +1833 -> 2555
    //   725: aload_0
    //   726: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   729: bipush 7
    //   731: iconst_m1
    //   732: ldc 190
    //   734: iconst_0
    //   735: anewarray 77	java/lang/Object
    //   738: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   741: goto +1814 -> 2555
    //   744: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   747: aload_1
    //   748: getfield 144	android/os/Message:arg1	I
    //   751: invokevirtual 212	com/tencent/qqcamerakit/capture/camera2/Camera2Control:f	(I)V
    //   754: goto +1801 -> 2555
    //   757: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   760: aload_1
    //   761: getfield 144	android/os/Message:arg1	I
    //   764: invokevirtual 215	com/tencent/qqcamerakit/capture/camera2/Camera2Control:d	(I)V
    //   767: goto +1788 -> 2555
    //   770: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   773: aload_1
    //   774: getfield 144	android/os/Message:arg1	I
    //   777: invokevirtual 218	com/tencent/qqcamerakit/capture/camera/CameraControl:f	(I)Z
    //   780: pop
    //   781: goto +1774 -> 2555
    //   784: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   787: aload_1
    //   788: getfield 144	android/os/Message:arg1	I
    //   791: invokevirtual 221	com/tencent/qqcamerakit/capture/camera/CameraControl:e	(I)Z
    //   794: pop
    //   795: goto +1760 -> 2555
    //   798: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   801: astore 5
    //   803: aload_1
    //   804: getfield 144	android/os/Message:arg1	I
    //   807: iconst_1
    //   808: if_icmpne +6 -> 814
    //   811: iconst_1
    //   812: istore 4
    //   814: aload 5
    //   816: iload 4
    //   818: invokevirtual 224	com/tencent/qqcamerakit/capture/camera2/Camera2Control:b	(Z)V
    //   821: goto +1734 -> 2555
    //   824: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   827: ifeq +18 -> 845
    //   830: ldc 105
    //   832: iconst_2
    //   833: iconst_1
    //   834: anewarray 77	java/lang/Object
    //   837: dup
    //   838: iconst_0
    //   839: ldc 226
    //   841: aastore
    //   842: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   845: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   848: invokevirtual 228	com/tencent/qqcamerakit/capture/camera2/Camera2Control:m	()V
    //   851: goto +1704 -> 2555
    //   854: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   857: ifeq +18 -> 875
    //   860: ldc 105
    //   862: iconst_2
    //   863: iconst_1
    //   864: anewarray 77	java/lang/Object
    //   867: dup
    //   868: iconst_0
    //   869: ldc 230
    //   871: aastore
    //   872: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   875: aload_1
    //   876: getfield 124	android/os/Message:obj	Ljava/lang/Object;
    //   879: checkcast 232	com/tencent/qqcamerakit/capture/CameraHandler$TakePictureData
    //   882: astore 5
    //   884: aload 5
    //   886: getfield 235	com/tencent/qqcamerakit/capture/CameraHandler$TakePictureData:a	Ljava/lang/String;
    //   889: ifnonnull +23 -> 912
    //   892: aload_0
    //   893: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   896: iconst_2
    //   897: iconst_m1
    //   898: ldc 237
    //   900: iconst_0
    //   901: anewarray 77	java/lang/Object
    //   904: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   907: aload_1
    //   908: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   911: return
    //   912: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   915: aload 5
    //   917: invokevirtual 240	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Lcom/tencent/qqcamerakit/capture/CameraHandler$TakePictureData;)V
    //   920: goto +1635 -> 2555
    //   923: aload_1
    //   924: getfield 124	android/os/Message:obj	Ljava/lang/Object;
    //   927: checkcast 134	[Ljava/lang/Object;
    //   930: checkcast 134	[Ljava/lang/Object;
    //   933: astore 5
    //   935: aload 5
    //   937: iconst_0
    //   938: aaload
    //   939: checkcast 242	com/tencent/qqcamerakit/capture/CameraSize
    //   942: astore 8
    //   944: aload 5
    //   946: iconst_1
    //   947: aaload
    //   948: checkcast 242	com/tencent/qqcamerakit/capture/CameraSize
    //   951: astore 7
    //   953: aload 5
    //   955: iconst_2
    //   956: aaload
    //   957: checkcast 242	com/tencent/qqcamerakit/capture/CameraSize
    //   960: astore 10
    //   962: aload 5
    //   964: iconst_3
    //   965: aaload
    //   966: checkcast 244	java/lang/Integer
    //   969: invokevirtual 248	java/lang/Integer:intValue	()I
    //   972: istore_2
    //   973: aload 5
    //   975: iconst_4
    //   976: aaload
    //   977: checkcast 244	java/lang/Integer
    //   980: invokevirtual 248	java/lang/Integer:intValue	()I
    //   983: istore_3
    //   984: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   987: astore 9
    //   989: new 40	java/lang/StringBuilder
    //   992: dup
    //   993: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   996: astore 5
    //   998: aload 5
    //   1000: getstatic 249	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	Ljava/lang/String;
    //   1003: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: pop
    //   1007: aload 5
    //   1009: ldc 251
    //   1011: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: pop
    //   1015: aload 5
    //   1017: aload 8
    //   1019: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1022: pop
    //   1023: aload 5
    //   1025: ldc 251
    //   1027: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: aload 5
    //   1033: aload 7
    //   1035: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aload 5
    //   1041: ldc 251
    //   1043: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload 5
    //   1049: aload 10
    //   1051: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1054: pop
    //   1055: aload 5
    //   1057: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: astore 11
    //   1062: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   1065: ifeq +97 -> 1162
    //   1068: new 40	java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   1075: astore 5
    //   1077: aload 5
    //   1079: ldc_w 256
    //   1082: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: pop
    //   1086: aload 5
    //   1088: aload 8
    //   1090: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1093: pop
    //   1094: aload 5
    //   1096: ldc_w 258
    //   1099: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: pop
    //   1103: aload 5
    //   1105: aload 7
    //   1107: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload 5
    //   1113: ldc_w 260
    //   1116: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: pop
    //   1120: aload 5
    //   1122: aload 10
    //   1124: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: aload 5
    //   1130: ldc_w 262
    //   1133: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: pop
    //   1137: aload 5
    //   1139: iload_3
    //   1140: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1143: pop
    //   1144: ldc 105
    //   1146: iconst_2
    //   1147: iconst_1
    //   1148: anewarray 77	java/lang/Object
    //   1151: dup
    //   1152: iconst_0
    //   1153: aload 5
    //   1155: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1158: aastore
    //   1159: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1162: aload_0
    //   1163: getfield 27	com/tencent/qqcamerakit/capture/CameraHandler:b	Ljava/util/Map;
    //   1166: aload 11
    //   1168: invokeinterface 271 2 0
    //   1173: checkcast 273	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache
    //   1176: astore 6
    //   1178: aload 6
    //   1180: astore 5
    //   1182: aload 6
    //   1184: ifnonnull +26 -> 1210
    //   1187: new 273	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache
    //   1190: dup
    //   1191: invokespecial 274	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:<init>	()V
    //   1194: astore 5
    //   1196: aload_0
    //   1197: getfield 27	com/tencent/qqcamerakit/capture/CameraHandler:b	Ljava/util/Map;
    //   1200: aload 11
    //   1202: aload 5
    //   1204: invokeinterface 278 3 0
    //   1209: pop
    //   1210: aload 9
    //   1212: iload_3
    //   1213: invokevirtual 280	com/tencent/qqcamerakit/capture/camera2/Camera2Control:c	(I)V
    //   1216: aload 5
    //   1218: getfield 283	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1221: invokevirtual 287	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1224: ifne +213 -> 1437
    //   1227: aload 8
    //   1229: aload 7
    //   1231: aload 10
    //   1233: invokestatic 292	com/tencent/qqcamerakit/capture/camerastrategy/ResolutionStrategy:a	(Lcom/tencent/qqcamerakit/capture/CameraSize;Lcom/tencent/qqcamerakit/capture/CameraSize;Lcom/tencent/qqcamerakit/capture/CameraSize;)[Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1236: astore 7
    //   1238: aload 7
    //   1240: ifnull +1364 -> 2604
    //   1243: aload 7
    //   1245: arraylength
    //   1246: iconst_2
    //   1247: if_icmplt +1357 -> 2604
    //   1250: aload 7
    //   1252: iconst_0
    //   1253: aaload
    //   1254: astore 6
    //   1256: aload 7
    //   1258: iconst_1
    //   1259: aaload
    //   1260: astore 7
    //   1262: goto +3 -> 1265
    //   1265: aload 9
    //   1267: new 242	com/tencent/qqcamerakit/capture/CameraSize
    //   1270: dup
    //   1271: aload 8
    //   1273: getfield 294	com/tencent/qqcamerakit/capture/CameraSize:a	I
    //   1276: aload 8
    //   1278: getfield 296	com/tencent/qqcamerakit/capture/CameraSize:b	I
    //   1281: invokestatic 302	java/lang/Math:max	(II)I
    //   1284: aload 8
    //   1286: getfield 294	com/tencent/qqcamerakit/capture/CameraSize:a	I
    //   1289: aload 8
    //   1291: getfield 296	com/tencent/qqcamerakit/capture/CameraSize:b	I
    //   1294: invokestatic 305	java/lang/Math:min	(II)I
    //   1297: invokespecial 308	com/tencent/qqcamerakit/capture/CameraSize:<init>	(II)V
    //   1300: invokevirtual 311	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1303: astore 8
    //   1305: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1308: aload 6
    //   1310: invokevirtual 314	com/tencent/qqcamerakit/capture/camera2/Camera2Control:e	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   1313: ifne +25 -> 1338
    //   1316: aload_0
    //   1317: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1320: iconst_2
    //   1321: bipush 21
    //   1323: ldc_w 316
    //   1326: iconst_0
    //   1327: anewarray 77	java/lang/Object
    //   1330: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1333: aload_1
    //   1334: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1337: return
    //   1338: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1341: aload 7
    //   1343: invokevirtual 318	com/tencent/qqcamerakit/capture/camera2/Camera2Control:d	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   1346: ifne +25 -> 1371
    //   1349: aload_0
    //   1350: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1353: iconst_2
    //   1354: bipush 22
    //   1356: ldc_w 320
    //   1359: iconst_0
    //   1360: anewarray 77	java/lang/Object
    //   1363: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1366: aload_1
    //   1367: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1370: return
    //   1371: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1374: iload_2
    //   1375: invokevirtual 322	com/tencent/qqcamerakit/capture/camera2/Camera2Control:b	(I)Z
    //   1378: ifne +25 -> 1403
    //   1381: aload_0
    //   1382: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1385: iconst_2
    //   1386: bipush 23
    //   1388: ldc_w 324
    //   1391: iconst_0
    //   1392: anewarray 77	java/lang/Object
    //   1395: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1398: aload_1
    //   1399: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1402: return
    //   1403: aload 5
    //   1405: aload 6
    //   1407: putfield 327	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:b	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1410: aload 5
    //   1412: aload 7
    //   1414: putfield 329	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:c	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1417: aload 5
    //   1419: aload 8
    //   1421: putfield 331	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:d	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1424: aload 5
    //   1426: getfield 283	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1429: iconst_1
    //   1430: invokevirtual 335	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   1433: pop
    //   1434: goto +35 -> 1469
    //   1437: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1440: aload 5
    //   1442: invokevirtual 338	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Lcom/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache;)Z
    //   1445: ifne +24 -> 1469
    //   1448: aload_0
    //   1449: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1452: iconst_2
    //   1453: iconst_m1
    //   1454: ldc_w 340
    //   1457: iconst_0
    //   1458: anewarray 77	java/lang/Object
    //   1461: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1464: aload_1
    //   1465: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1468: return
    //   1469: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1472: invokevirtual 343	com/tencent/qqcamerakit/capture/camera2/Camera2Control:g	()Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1475: astore 5
    //   1477: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1480: invokevirtual 345	com/tencent/qqcamerakit/capture/camera2/Camera2Control:f	()Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1483: astore 6
    //   1485: aload_0
    //   1486: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1489: iconst_2
    //   1490: iconst_0
    //   1491: ldc 153
    //   1493: iconst_2
    //   1494: anewarray 77	java/lang/Object
    //   1497: dup
    //   1498: iconst_0
    //   1499: aload 5
    //   1501: aastore
    //   1502: dup
    //   1503: iconst_1
    //   1504: aload 6
    //   1506: aastore
    //   1507: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1510: goto +1045 -> 2555
    //   1513: aload_1
    //   1514: getfield 144	android/os/Message:arg1	I
    //   1517: istore_2
    //   1518: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1521: iload_2
    //   1522: invokevirtual 347	com/tencent/qqcamerakit/capture/camera/CameraControl:c	(I)Z
    //   1525: pop
    //   1526: goto +1029 -> 2555
    //   1529: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   1532: ifeq +19 -> 1551
    //   1535: ldc 105
    //   1537: iconst_2
    //   1538: iconst_1
    //   1539: anewarray 77	java/lang/Object
    //   1542: dup
    //   1543: iconst_0
    //   1544: ldc_w 349
    //   1547: aastore
    //   1548: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1551: aload_1
    //   1552: getfield 144	android/os/Message:arg1	I
    //   1555: iconst_1
    //   1556: if_icmpne +32 -> 1588
    //   1559: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1562: iconst_1
    //   1563: invokevirtual 351	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Z)Z
    //   1566: ifne +989 -> 2555
    //   1569: aload_0
    //   1570: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1573: iconst_5
    //   1574: iconst_m1
    //   1575: ldc_w 353
    //   1578: iconst_0
    //   1579: anewarray 77	java/lang/Object
    //   1582: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1585: goto +970 -> 2555
    //   1588: aload_1
    //   1589: getfield 144	android/os/Message:arg1	I
    //   1592: iconst_2
    //   1593: if_icmpne +962 -> 2555
    //   1596: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1599: iconst_0
    //   1600: invokevirtual 351	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Z)Z
    //   1603: ifne +952 -> 2555
    //   1606: aload_0
    //   1607: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1610: iconst_5
    //   1611: iconst_m1
    //   1612: ldc_w 355
    //   1615: iconst_0
    //   1616: anewarray 77	java/lang/Object
    //   1619: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1622: goto +933 -> 2555
    //   1625: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   1628: ifeq +19 -> 1647
    //   1631: ldc 105
    //   1633: iconst_2
    //   1634: iconst_1
    //   1635: anewarray 77	java/lang/Object
    //   1638: dup
    //   1639: iconst_0
    //   1640: ldc_w 357
    //   1643: aastore
    //   1644: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1647: aload_1
    //   1648: getfield 124	android/os/Message:obj	Ljava/lang/Object;
    //   1651: checkcast 232	com/tencent/qqcamerakit/capture/CameraHandler$TakePictureData
    //   1654: astore 5
    //   1656: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1659: astore 6
    //   1661: aload 6
    //   1663: getfield 360	com/tencent/qqcamerakit/capture/camera/CameraControl:b	Z
    //   1666: ifne +30 -> 1696
    //   1669: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   1672: ifeq +19 -> 1691
    //   1675: ldc 105
    //   1677: iconst_2
    //   1678: iconst_1
    //   1679: anewarray 77	java/lang/Object
    //   1682: dup
    //   1683: iconst_0
    //   1684: ldc_w 362
    //   1687: aastore
    //   1688: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1691: aload_1
    //   1692: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1695: return
    //   1696: aload 5
    //   1698: getfield 235	com/tencent/qqcamerakit/capture/CameraHandler$TakePictureData:a	Ljava/lang/String;
    //   1701: ifnonnull +23 -> 1724
    //   1704: aload_0
    //   1705: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1708: iconst_2
    //   1709: iconst_m1
    //   1710: ldc 237
    //   1712: iconst_0
    //   1713: anewarray 77	java/lang/Object
    //   1716: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1719: aload_1
    //   1720: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1723: return
    //   1724: aload 6
    //   1726: aload 5
    //   1728: invokevirtual 363	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Lcom/tencent/qqcamerakit/capture/CameraHandler$TakePictureData;)V
    //   1731: goto +824 -> 2555
    //   1734: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   1737: ifeq +19 -> 1756
    //   1740: ldc 105
    //   1742: iconst_2
    //   1743: iconst_1
    //   1744: anewarray 77	java/lang/Object
    //   1747: dup
    //   1748: iconst_0
    //   1749: ldc_w 365
    //   1752: aastore
    //   1753: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1756: aload_1
    //   1757: getfield 124	android/os/Message:obj	Ljava/lang/Object;
    //   1760: checkcast 136	android/graphics/SurfaceTexture
    //   1763: astore 5
    //   1765: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1768: aload 5
    //   1770: invokevirtual 368	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Landroid/graphics/SurfaceTexture;)Z
    //   1773: ifne +782 -> 2555
    //   1776: aload_0
    //   1777: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1780: iconst_2
    //   1781: iconst_m1
    //   1782: ldc_w 370
    //   1785: iconst_0
    //   1786: anewarray 77	java/lang/Object
    //   1789: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1792: goto +763 -> 2555
    //   1795: aload_1
    //   1796: getfield 124	android/os/Message:obj	Ljava/lang/Object;
    //   1799: checkcast 134	[Ljava/lang/Object;
    //   1802: checkcast 134	[Ljava/lang/Object;
    //   1805: astore 5
    //   1807: aload 5
    //   1809: iconst_0
    //   1810: aaload
    //   1811: checkcast 242	com/tencent/qqcamerakit/capture/CameraSize
    //   1814: astore 9
    //   1816: aload 5
    //   1818: iconst_1
    //   1819: aaload
    //   1820: checkcast 242	com/tencent/qqcamerakit/capture/CameraSize
    //   1823: astore 10
    //   1825: aload 5
    //   1827: iconst_2
    //   1828: aaload
    //   1829: checkcast 242	com/tencent/qqcamerakit/capture/CameraSize
    //   1832: astore 11
    //   1834: aload 5
    //   1836: iconst_3
    //   1837: aaload
    //   1838: checkcast 244	java/lang/Integer
    //   1841: invokevirtual 248	java/lang/Integer:intValue	()I
    //   1844: istore_2
    //   1845: aload 5
    //   1847: iconst_4
    //   1848: aaload
    //   1849: checkcast 372	java/lang/String
    //   1852: astore 8
    //   1854: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1857: astore 7
    //   1859: new 40	java/lang/StringBuilder
    //   1862: dup
    //   1863: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   1866: astore 5
    //   1868: aload 5
    //   1870: aload 7
    //   1872: getfield 374	com/tencent/qqcamerakit/capture/camera/CameraControl:c	I
    //   1875: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1878: pop
    //   1879: aload 5
    //   1881: ldc 251
    //   1883: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1886: pop
    //   1887: aload 5
    //   1889: aload 9
    //   1891: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1894: pop
    //   1895: aload 5
    //   1897: ldc 251
    //   1899: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1902: pop
    //   1903: aload 5
    //   1905: aload 10
    //   1907: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1910: pop
    //   1911: aload 5
    //   1913: ldc 251
    //   1915: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1918: pop
    //   1919: aload 5
    //   1921: aload 11
    //   1923: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1926: pop
    //   1927: aload 5
    //   1929: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1932: astore 12
    //   1934: aload_0
    //   1935: getfield 25	com/tencent/qqcamerakit/capture/CameraHandler:a	Ljava/util/Map;
    //   1938: aload 12
    //   1940: invokeinterface 271 2 0
    //   1945: checkcast 376	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache
    //   1948: astore 6
    //   1950: aload 6
    //   1952: astore 5
    //   1954: aload 6
    //   1956: ifnonnull +26 -> 1982
    //   1959: new 376	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache
    //   1962: dup
    //   1963: invokespecial 377	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:<init>	()V
    //   1966: astore 5
    //   1968: aload_0
    //   1969: getfield 25	com/tencent/qqcamerakit/capture/CameraHandler:a	Ljava/util/Map;
    //   1972: aload 12
    //   1974: aload 5
    //   1976: invokeinterface 278 3 0
    //   1981: pop
    //   1982: aload 5
    //   1984: getfield 378	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1987: invokevirtual 287	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1990: ifne +226 -> 2216
    //   1993: aload 7
    //   1995: invokevirtual 380	com/tencent/qqcamerakit/capture/camera/CameraControl:d	()Z
    //   1998: ifne +25 -> 2023
    //   2001: aload_0
    //   2002: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2005: iconst_2
    //   2006: bipush 20
    //   2008: ldc_w 382
    //   2011: iconst_0
    //   2012: anewarray 77	java/lang/Object
    //   2015: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2018: aload_1
    //   2019: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2022: return
    //   2023: aload 9
    //   2025: aload 10
    //   2027: aload 11
    //   2029: invokestatic 292	com/tencent/qqcamerakit/capture/camerastrategy/ResolutionStrategy:a	(Lcom/tencent/qqcamerakit/capture/CameraSize;Lcom/tencent/qqcamerakit/capture/CameraSize;Lcom/tencent/qqcamerakit/capture/CameraSize;)[Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2032: astore 6
    //   2034: aload 7
    //   2036: aload 6
    //   2038: iconst_0
    //   2039: aaload
    //   2040: invokevirtual 384	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   2043: ifne +25 -> 2068
    //   2046: aload_0
    //   2047: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2050: iconst_2
    //   2051: bipush 21
    //   2053: ldc_w 386
    //   2056: iconst_0
    //   2057: anewarray 77	java/lang/Object
    //   2060: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2063: aload_1
    //   2064: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2067: return
    //   2068: aload 7
    //   2070: aload 6
    //   2072: iconst_1
    //   2073: aaload
    //   2074: invokevirtual 388	com/tencent/qqcamerakit/capture/camera/CameraControl:b	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   2077: ifne +25 -> 2102
    //   2080: aload_0
    //   2081: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2084: iconst_2
    //   2085: bipush 22
    //   2087: ldc_w 390
    //   2090: iconst_0
    //   2091: anewarray 77	java/lang/Object
    //   2094: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2097: aload_1
    //   2098: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2101: return
    //   2102: aload 7
    //   2104: iload_2
    //   2105: invokevirtual 392	com/tencent/qqcamerakit/capture/camera/CameraControl:d	(I)Z
    //   2108: ifne +25 -> 2133
    //   2111: aload_0
    //   2112: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2115: iconst_2
    //   2116: bipush 23
    //   2118: ldc_w 394
    //   2121: iconst_0
    //   2122: anewarray 77	java/lang/Object
    //   2125: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2128: aload_1
    //   2129: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2132: return
    //   2133: aload 5
    //   2135: aload 7
    //   2137: invokevirtual 396	com/tencent/qqcamerakit/capture/camera/CameraControl:e	()I
    //   2140: putfield 397	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:b	I
    //   2143: aload 5
    //   2145: aload 7
    //   2147: invokevirtual 398	com/tencent/qqcamerakit/capture/camera/CameraControl:f	()Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2150: putfield 400	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:e	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2153: aload 7
    //   2155: invokevirtual 401	com/tencent/qqcamerakit/capture/camera/CameraControl:g	()Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2158: astore 6
    //   2160: aload 6
    //   2162: ifnull +16 -> 2178
    //   2165: aload 5
    //   2167: aload 6
    //   2169: putfield 403	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:g	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2172: aload 5
    //   2174: iconst_1
    //   2175: putfield 405	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:f	Z
    //   2178: aload 7
    //   2180: invokevirtual 408	com/tencent/qqcamerakit/capture/camera/CameraControl:h	()[I
    //   2183: astore 6
    //   2185: aload 5
    //   2187: aload 6
    //   2189: iconst_0
    //   2190: iaload
    //   2191: putfield 409	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:c	I
    //   2194: aload 5
    //   2196: aload 6
    //   2198: iconst_1
    //   2199: iaload
    //   2200: putfield 411	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:d	I
    //   2203: aload 5
    //   2205: getfield 378	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2208: iconst_1
    //   2209: invokevirtual 335	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   2212: pop
    //   2213: goto +56 -> 2269
    //   2216: aload 7
    //   2218: aload 5
    //   2220: invokevirtual 414	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Lcom/tencent/qqcamerakit/capture/CameraHandler$ParamCache;)Z
    //   2223: ifne +24 -> 2247
    //   2226: aload_0
    //   2227: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2230: iconst_2
    //   2231: iconst_m1
    //   2232: ldc_w 416
    //   2235: iconst_0
    //   2236: anewarray 77	java/lang/Object
    //   2239: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2242: aload_1
    //   2243: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2246: return
    //   2247: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   2250: ifeq +19 -> 2269
    //   2253: ldc 105
    //   2255: iconst_2
    //   2256: iconst_1
    //   2257: anewarray 77	java/lang/Object
    //   2260: dup
    //   2261: iconst_0
    //   2262: ldc_w 418
    //   2265: aastore
    //   2266: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2269: aload 7
    //   2271: getfield 419	com/tencent/qqcamerakit/capture/camera/CameraControl:d	I
    //   2274: iconst_2
    //   2275: if_icmpne +30 -> 2305
    //   2278: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   2281: aload 8
    //   2283: invokevirtual 422	com/tencent/qqcamerakit/capture/camera/CameraControl:b	(Ljava/lang/String;)Z
    //   2286: ifne +19 -> 2305
    //   2289: aload_0
    //   2290: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2293: iconst_2
    //   2294: bipush 24
    //   2296: ldc 190
    //   2298: iconst_0
    //   2299: anewarray 77	java/lang/Object
    //   2302: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2305: aload 7
    //   2307: invokevirtual 424	com/tencent/qqcamerakit/capture/camera/CameraControl:b	()Z
    //   2310: ifne +25 -> 2335
    //   2313: aload_0
    //   2314: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2317: iconst_2
    //   2318: bipush 25
    //   2320: ldc_w 426
    //   2323: iconst_0
    //   2324: anewarray 77	java/lang/Object
    //   2327: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2330: aload_1
    //   2331: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2334: return
    //   2335: aload 7
    //   2337: invokevirtual 408	com/tencent/qqcamerakit/capture/camera/CameraControl:h	()[I
    //   2340: astore 5
    //   2342: aload 7
    //   2344: invokevirtual 396	com/tencent/qqcamerakit/capture/camera/CameraControl:e	()I
    //   2347: istore_2
    //   2348: aload 7
    //   2350: invokevirtual 398	com/tencent/qqcamerakit/capture/camera/CameraControl:f	()Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2353: astore 6
    //   2355: aload_0
    //   2356: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2359: iconst_2
    //   2360: iconst_0
    //   2361: ldc 153
    //   2363: iconst_3
    //   2364: anewarray 77	java/lang/Object
    //   2367: dup
    //   2368: iconst_0
    //   2369: aload 6
    //   2371: aastore
    //   2372: dup
    //   2373: iconst_1
    //   2374: iload_2
    //   2375: invokestatic 430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2378: aastore
    //   2379: dup
    //   2380: iconst_2
    //   2381: aload 5
    //   2383: aastore
    //   2384: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2387: goto +168 -> 2555
    //   2390: invokestatic 103	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   2393: ifeq +19 -> 2412
    //   2396: ldc 105
    //   2398: iconst_2
    //   2399: iconst_1
    //   2400: anewarray 77	java/lang/Object
    //   2403: dup
    //   2404: iconst_0
    //   2405: ldc_w 432
    //   2408: aastore
    //   2409: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2412: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   2415: invokevirtual 435	com/tencent/qqcamerakit/capture/camera/CameraControl:p	()V
    //   2418: ldc2_w 436
    //   2421: invokestatic 442	java/lang/Thread:sleep	(J)V
    //   2424: aload_0
    //   2425: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2428: bipush 9
    //   2430: iconst_0
    //   2431: ldc_w 444
    //   2434: iconst_0
    //   2435: anewarray 77	java/lang/Object
    //   2438: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2441: goto +114 -> 2555
    //   2444: aload_1
    //   2445: getfield 144	android/os/Message:arg1	I
    //   2448: istore_2
    //   2449: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   2452: iload_2
    //   2453: invokevirtual 447	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(I)I
    //   2456: istore_2
    //   2457: iload_2
    //   2458: bipush 6
    //   2460: if_icmpne +23 -> 2483
    //   2463: aload_0
    //   2464: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2467: iconst_1
    //   2468: iconst_0
    //   2469: ldc 153
    //   2471: iconst_0
    //   2472: anewarray 77	java/lang/Object
    //   2475: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2478: aload_1
    //   2479: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2482: return
    //   2483: iload_2
    //   2484: ifeq +25 -> 2509
    //   2487: aload_0
    //   2488: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2491: iconst_1
    //   2492: iload_2
    //   2493: iload_2
    //   2494: invokestatic 160	com/tencent/qqcamerakit/capture/camera/CameraControl:b	(I)Ljava/lang/String;
    //   2497: iconst_0
    //   2498: anewarray 77	java/lang/Object
    //   2501: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2504: aload_1
    //   2505: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2508: return
    //   2509: invokestatic 165	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   2512: invokevirtual 424	com/tencent/qqcamerakit/capture/camera/CameraControl:b	()Z
    //   2515: ifne +25 -> 2540
    //   2518: aload_0
    //   2519: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2522: iconst_1
    //   2523: bipush 7
    //   2525: ldc_w 449
    //   2528: iconst_0
    //   2529: anewarray 77	java/lang/Object
    //   2532: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2535: aload_1
    //   2536: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2539: return
    //   2540: aload_0
    //   2541: getfield 29	com/tencent/qqcamerakit/capture/CameraHandler:c	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2544: iconst_1
    //   2545: iconst_0
    //   2546: ldc 153
    //   2548: iconst_0
    //   2549: anewarray 77	java/lang/Object
    //   2552: invokevirtual 35	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2555: aload_1
    //   2556: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2559: return
    //   2560: astore 5
    //   2562: goto +18 -> 2580
    //   2565: astore 5
    //   2567: ldc 105
    //   2569: iconst_1
    //   2570: ldc 105
    //   2572: aload 5
    //   2574: invokestatic 452	com/tencent/qqcamerakit/common/QLog:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2577: goto -22 -> 2555
    //   2580: aload_1
    //   2581: invokestatic 155	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2584: goto +6 -> 2590
    //   2587: aload 5
    //   2589: athrow
    //   2590: goto -3 -> 2587
    //   2593: astore 5
    //   2595: goto -171 -> 2424
    //   2598: iconst_0
    //   2599: istore 4
    //   2601: goto -2019 -> 582
    //   2604: aconst_null
    //   2605: astore 6
    //   2607: aload 6
    //   2609: astore 7
    //   2611: goto -1346 -> 1265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2614	0	this	CameraHandler
    //   0	2614	1	paramMessage	android.os.Message
    //   9	2485	2	i	int
    //   983	230	3	j	int
    //   11	2589	4	bool	boolean
    //   57	2325	5	localObject1	Object
    //   2560	1	5	localObject2	Object
    //   2565	23	5	localException	java.lang.Exception
    //   2593	1	5	localInterruptedException	InterruptedException
    //   318	2290	6	localObject3	Object
    //   309	2301	7	localObject4	Object
    //   942	1340	8	localObject5	Object
    //   987	1037	9	localObject6	Object
    //   960	1066	10	localCameraSize	CameraSize
    //   1060	968	11	localObject7	Object
    //   1932	41	12	str	String
    // Exception table:
    //   from	to	target	type
    //   231	252	2560	finally
    //   252	258	2560	finally
    //   261	267	2560	finally
    //   270	287	2560	finally
    //   290	296	2560	finally
    //   299	320	2560	finally
    //   327	336	2560	finally
    //   336	346	2560	finally
    //   349	363	2560	finally
    //   369	399	2560	finally
    //   408	425	2560	finally
    //   428	449	2560	finally
    //   449	473	2560	finally
    //   476	497	2560	finally
    //   497	521	2560	finally
    //   521	536	2560	finally
    //   539	560	2560	finally
    //   560	576	2560	finally
    //   582	610	2560	finally
    //   613	634	2560	finally
    //   634	659	2560	finally
    //   662	692	2560	finally
    //   695	716	2560	finally
    //   716	741	2560	finally
    //   744	754	2560	finally
    //   757	767	2560	finally
    //   770	781	2560	finally
    //   784	795	2560	finally
    //   798	803	2560	finally
    //   803	811	2560	finally
    //   814	821	2560	finally
    //   824	845	2560	finally
    //   845	851	2560	finally
    //   854	875	2560	finally
    //   875	907	2560	finally
    //   912	920	2560	finally
    //   923	1162	2560	finally
    //   1162	1178	2560	finally
    //   1187	1210	2560	finally
    //   1210	1238	2560	finally
    //   1243	1250	2560	finally
    //   1265	1333	2560	finally
    //   1338	1366	2560	finally
    //   1371	1398	2560	finally
    //   1403	1434	2560	finally
    //   1437	1464	2560	finally
    //   1469	1510	2560	finally
    //   1513	1526	2560	finally
    //   1529	1551	2560	finally
    //   1551	1585	2560	finally
    //   1588	1622	2560	finally
    //   1625	1647	2560	finally
    //   1647	1691	2560	finally
    //   1696	1719	2560	finally
    //   1724	1731	2560	finally
    //   1734	1756	2560	finally
    //   1756	1792	2560	finally
    //   1795	1950	2560	finally
    //   1959	1982	2560	finally
    //   1982	2018	2560	finally
    //   2023	2063	2560	finally
    //   2068	2097	2560	finally
    //   2102	2128	2560	finally
    //   2133	2160	2560	finally
    //   2165	2178	2560	finally
    //   2178	2213	2560	finally
    //   2216	2242	2560	finally
    //   2247	2269	2560	finally
    //   2269	2305	2560	finally
    //   2305	2330	2560	finally
    //   2335	2387	2560	finally
    //   2390	2412	2560	finally
    //   2412	2418	2560	finally
    //   2418	2424	2560	finally
    //   2424	2441	2560	finally
    //   2444	2457	2560	finally
    //   2463	2478	2560	finally
    //   2487	2504	2560	finally
    //   2509	2535	2560	finally
    //   2540	2555	2560	finally
    //   2567	2577	2560	finally
    //   231	252	2565	java/lang/Exception
    //   252	258	2565	java/lang/Exception
    //   261	267	2565	java/lang/Exception
    //   270	287	2565	java/lang/Exception
    //   290	296	2565	java/lang/Exception
    //   299	320	2565	java/lang/Exception
    //   327	336	2565	java/lang/Exception
    //   336	346	2565	java/lang/Exception
    //   349	363	2565	java/lang/Exception
    //   369	399	2565	java/lang/Exception
    //   408	425	2565	java/lang/Exception
    //   428	449	2565	java/lang/Exception
    //   449	473	2565	java/lang/Exception
    //   476	497	2565	java/lang/Exception
    //   497	521	2565	java/lang/Exception
    //   521	536	2565	java/lang/Exception
    //   539	560	2565	java/lang/Exception
    //   560	576	2565	java/lang/Exception
    //   582	610	2565	java/lang/Exception
    //   613	634	2565	java/lang/Exception
    //   634	659	2565	java/lang/Exception
    //   662	692	2565	java/lang/Exception
    //   695	716	2565	java/lang/Exception
    //   716	741	2565	java/lang/Exception
    //   744	754	2565	java/lang/Exception
    //   757	767	2565	java/lang/Exception
    //   770	781	2565	java/lang/Exception
    //   784	795	2565	java/lang/Exception
    //   798	803	2565	java/lang/Exception
    //   803	811	2565	java/lang/Exception
    //   814	821	2565	java/lang/Exception
    //   824	845	2565	java/lang/Exception
    //   845	851	2565	java/lang/Exception
    //   854	875	2565	java/lang/Exception
    //   875	907	2565	java/lang/Exception
    //   912	920	2565	java/lang/Exception
    //   923	1162	2565	java/lang/Exception
    //   1162	1178	2565	java/lang/Exception
    //   1187	1210	2565	java/lang/Exception
    //   1210	1238	2565	java/lang/Exception
    //   1243	1250	2565	java/lang/Exception
    //   1265	1333	2565	java/lang/Exception
    //   1338	1366	2565	java/lang/Exception
    //   1371	1398	2565	java/lang/Exception
    //   1403	1434	2565	java/lang/Exception
    //   1437	1464	2565	java/lang/Exception
    //   1469	1510	2565	java/lang/Exception
    //   1513	1526	2565	java/lang/Exception
    //   1529	1551	2565	java/lang/Exception
    //   1551	1585	2565	java/lang/Exception
    //   1588	1622	2565	java/lang/Exception
    //   1625	1647	2565	java/lang/Exception
    //   1647	1691	2565	java/lang/Exception
    //   1696	1719	2565	java/lang/Exception
    //   1724	1731	2565	java/lang/Exception
    //   1734	1756	2565	java/lang/Exception
    //   1756	1792	2565	java/lang/Exception
    //   1795	1950	2565	java/lang/Exception
    //   1959	1982	2565	java/lang/Exception
    //   1982	2018	2565	java/lang/Exception
    //   2023	2063	2565	java/lang/Exception
    //   2068	2097	2565	java/lang/Exception
    //   2102	2128	2565	java/lang/Exception
    //   2133	2160	2565	java/lang/Exception
    //   2165	2178	2565	java/lang/Exception
    //   2178	2213	2565	java/lang/Exception
    //   2216	2242	2565	java/lang/Exception
    //   2247	2269	2565	java/lang/Exception
    //   2269	2305	2565	java/lang/Exception
    //   2305	2330	2565	java/lang/Exception
    //   2335	2387	2565	java/lang/Exception
    //   2390	2412	2565	java/lang/Exception
    //   2412	2418	2565	java/lang/Exception
    //   2418	2424	2565	java/lang/Exception
    //   2424	2441	2565	java/lang/Exception
    //   2444	2457	2565	java/lang/Exception
    //   2463	2478	2565	java/lang/Exception
    //   2487	2504	2565	java/lang/Exception
    //   2509	2535	2565	java/lang/Exception
    //   2540	2555	2565	java/lang/Exception
    //   2418	2424	2593	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraHandler
 * JD-Core Version:    0.7.0.1
 */