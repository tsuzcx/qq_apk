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
  private CameraObservable a;
  public Map<String, CameraHandler.ParamCache> a;
  public Map<String, CameraHandler.ParamCamera2Cache> b = new HashMap();
  
  public CameraHandler(Looper paramLooper, CameraObservable paramCameraObservable)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable = paramCameraObservable;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable.a(paramInt1, paramInt2, paramString, paramVarArgs);
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
      post(localWaitDoneBundle.jdField_a_of_type_JavaLangRunnable);
      synchronized (localWaitDoneBundle.jdField_a_of_type_JavaLangObject)
      {
        localWaitDoneBundle.jdField_a_of_type_JavaLangObject.wait(paramLong);
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
    //   2: invokespecial 91	android/os/Handler:handleMessage	(Landroid/os/Message;)V
    //   5: aload_1
    //   6: getfield 97	android/os/Message:what	I
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_3
    //   12: iload_2
    //   13: iconst_1
    //   14: if_icmpeq +2375 -> 2389
    //   17: iload_2
    //   18: iconst_2
    //   19: if_icmpeq +2316 -> 2335
    //   22: iload_2
    //   23: iconst_3
    //   24: if_icmpeq +1727 -> 1751
    //   27: iload_2
    //   28: sipush 201
    //   31: if_icmpeq +1659 -> 1690
    //   34: iload_2
    //   35: sipush 301
    //   38: if_icmpeq +1543 -> 1581
    //   41: iload_2
    //   42: sipush 401
    //   45: if_icmpeq +1440 -> 1485
    //   48: iload_2
    //   49: sipush 701
    //   52: if_icmpeq +1417 -> 1469
    //   55: aconst_null
    //   56: astore 4
    //   58: iload_2
    //   59: sipush 1005
    //   62: if_icmpeq +853 -> 915
    //   65: iload_2
    //   66: sipush 1010
    //   69: if_icmpeq +777 -> 846
    //   72: iload_2
    //   73: sipush 1021
    //   76: if_icmpeq +740 -> 816
    //   79: iload_2
    //   80: sipush 1050
    //   83: if_icmpeq +709 -> 792
    //   86: iload_2
    //   87: sipush 601
    //   90: if_icmpeq +688 -> 778
    //   93: iload_2
    //   94: sipush 602
    //   97: if_icmpeq +667 -> 764
    //   100: iload_2
    //   101: sipush 1040
    //   104: if_icmpeq +647 -> 751
    //   107: iload_2
    //   108: sipush 1041
    //   111: if_icmpeq +627 -> 738
    //   114: iload_2
    //   115: tableswitch	default:+25 -> 140, 101:+574->689, 102:+541->656, 103:+492->607
    //   141: tableswitch	default:+27 -> 168, 203:+394->535, 204:+331->472, 205:+283->424
    //   169: tableswitch	default:+27 -> 196, 1001:+176->345, 1002:+126->295, 1003:+117->286
    //   197: tableswitch	default:+27 -> 224, 1030:+69->266, 1031:+60->257, 1032:+30->227
    //   225: iconst_5
    //   226: <illegal opcode>
    //   227: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   230: ifeq +18 -> 248
    //   233: ldc 104
    //   235: iconst_2
    //   236: iconst_1
    //   237: anewarray 76	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: ldc 106
    //   244: aastore
    //   245: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   248: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   251: invokevirtual 118	com/tencent/qqcamerakit/capture/camera2/Camera2Control:d	()V
    //   254: goto +2246 -> 2500
    //   257: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   260: invokevirtual 120	com/tencent/qqcamerakit/capture/camera2/Camera2Control:c	()V
    //   263: goto +2237 -> 2500
    //   266: aload_1
    //   267: getfield 123	android/os/Message:obj	Ljava/lang/Object;
    //   270: checkcast 125	com/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams
    //   273: astore 4
    //   275: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   278: aload 4
    //   280: invokevirtual 128	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Lcom/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams;)V
    //   283: goto +2217 -> 2500
    //   286: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   289: invokevirtual 130	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()V
    //   292: goto +2208 -> 2500
    //   295: aload_1
    //   296: getfield 123	android/os/Message:obj	Ljava/lang/Object;
    //   299: checkcast 132	[Ljava/lang/Object;
    //   302: checkcast 132	[Ljava/lang/Object;
    //   305: astore 6
    //   307: aload 6
    //   309: iconst_0
    //   310: aaload
    //   311: checkcast 134	android/graphics/SurfaceTexture
    //   314: astore 5
    //   316: aload 6
    //   318: iconst_1
    //   319: aaload
    //   320: ifnull +12 -> 332
    //   323: aload 6
    //   325: iconst_1
    //   326: aaload
    //   327: checkcast 136	com/tencent/qqcamerakit/capture/CameraPreviewCallBack
    //   330: astore 4
    //   332: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   335: aload 5
    //   337: aload 4
    //   339: invokevirtual 139	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Landroid/graphics/SurfaceTexture;Lcom/tencent/qqcamerakit/capture/CameraPreviewCallBack;)V
    //   342: goto +2158 -> 2500
    //   345: aload_1
    //   346: getfield 142	android/os/Message:arg1	I
    //   349: istore_2
    //   350: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   353: iload_2
    //   354: aload_0
    //   355: invokevirtual 145	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(ILcom/tencent/qqcamerakit/capture/camera2/Camera2Control$Camera2Listener;)I
    //   358: istore_2
    //   359: iload_2
    //   360: bipush 6
    //   362: if_icmpne +38 -> 400
    //   365: ldc 104
    //   367: iconst_1
    //   368: iconst_1
    //   369: anewarray 76	java/lang/Object
    //   372: dup
    //   373: iconst_0
    //   374: ldc 147
    //   376: aastore
    //   377: invokestatic 149	com/tencent/qqcamerakit/common/QLog:a	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   380: aload_0
    //   381: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   384: iconst_1
    //   385: iconst_0
    //   386: ldc 151
    //   388: iconst_0
    //   389: anewarray 76	java/lang/Object
    //   392: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   395: aload_1
    //   396: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   399: return
    //   400: iload_2
    //   401: ifeq +2099 -> 2500
    //   404: aload_0
    //   405: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   408: iconst_1
    //   409: iload_2
    //   410: iload_2
    //   411: invokestatic 158	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(I)Ljava/lang/String;
    //   414: iconst_0
    //   415: anewarray 76	java/lang/Object
    //   418: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   421: goto +2079 -> 2500
    //   424: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   427: ifeq +18 -> 445
    //   430: ldc 104
    //   432: iconst_2
    //   433: iconst_1
    //   434: anewarray 76	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: ldc 160
    //   441: aastore
    //   442: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   445: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   448: invokevirtual 166	com/tencent/qqcamerakit/capture/camera/CameraControl:f	()Z
    //   451: ifne +2049 -> 2500
    //   454: aload_0
    //   455: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   458: iconst_4
    //   459: iconst_m1
    //   460: ldc 168
    //   462: iconst_0
    //   463: anewarray 76	java/lang/Object
    //   466: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   469: goto +2031 -> 2500
    //   472: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   475: ifeq +18 -> 493
    //   478: ldc 104
    //   480: iconst_2
    //   481: iconst_1
    //   482: anewarray 76	java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: ldc 170
    //   489: aastore
    //   490: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   493: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   496: invokevirtual 173	com/tencent/qqcamerakit/capture/camera/CameraControl:e	()Z
    //   499: ifne +18 -> 517
    //   502: aload_0
    //   503: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   506: iconst_3
    //   507: iconst_m1
    //   508: ldc 175
    //   510: iconst_0
    //   511: anewarray 76	java/lang/Object
    //   514: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   517: aload_0
    //   518: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   521: iconst_3
    //   522: iconst_0
    //   523: ldc 151
    //   525: iconst_0
    //   526: anewarray 76	java/lang/Object
    //   529: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   532: goto +1968 -> 2500
    //   535: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   538: ifeq +18 -> 556
    //   541: ldc 104
    //   543: iconst_2
    //   544: iconst_1
    //   545: anewarray 76	java/lang/Object
    //   548: dup
    //   549: iconst_0
    //   550: ldc 177
    //   552: aastore
    //   553: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   556: aload_1
    //   557: getfield 123	android/os/Message:obj	Ljava/lang/Object;
    //   560: checkcast 136	com/tencent/qqcamerakit/capture/CameraPreviewCallBack
    //   563: astore 4
    //   565: aload_1
    //   566: getfield 142	android/os/Message:arg1	I
    //   569: ifle +1974 -> 2543
    //   572: iconst_1
    //   573: istore_3
    //   574: goto +3 -> 577
    //   577: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   580: aload 4
    //   582: iload_3
    //   583: invokevirtual 180	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Lcom/tencent/qqcamerakit/capture/CameraPreviewCallBack;Z)Z
    //   586: ifne +1914 -> 2500
    //   589: aload_0
    //   590: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   593: iconst_2
    //   594: iconst_m1
    //   595: ldc 182
    //   597: iconst_0
    //   598: anewarray 76	java/lang/Object
    //   601: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   604: goto +1896 -> 2500
    //   607: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   610: ifeq +18 -> 628
    //   613: ldc 104
    //   615: iconst_2
    //   616: iconst_1
    //   617: anewarray 76	java/lang/Object
    //   620: dup
    //   621: iconst_0
    //   622: ldc 184
    //   624: aastore
    //   625: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   628: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   631: invokevirtual 186	com/tencent/qqcamerakit/capture/camera/CameraControl:d	()Z
    //   634: ifeq +1866 -> 2500
    //   637: aload_0
    //   638: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   641: bipush 7
    //   643: iconst_m1
    //   644: ldc 188
    //   646: iconst_0
    //   647: anewarray 76	java/lang/Object
    //   650: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   653: goto +1847 -> 2500
    //   656: aload_1
    //   657: getfield 123	android/os/Message:obj	Ljava/lang/Object;
    //   660: checkcast 125	com/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams
    //   663: astore 4
    //   665: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   668: aload 4
    //   670: getfield 191	com/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   673: aload 4
    //   675: getfield 193	com/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams:b	Landroid/graphics/Rect;
    //   678: aload 4
    //   680: getfield 196	com/tencent/qqcamerakit/capture/cameraextend/FocusOperator$CameraFocusParams:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$CameraAutoFocusCallBack	Lcom/tencent/qqcamerakit/capture/CameraProxy$CameraAutoFocusCallBack;
    //   683: invokevirtual 199	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Landroid/graphics/Rect;Landroid/graphics/Rect;Lcom/tencent/qqcamerakit/capture/CameraProxy$CameraAutoFocusCallBack;)V
    //   686: goto +1814 -> 2500
    //   689: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   692: ifeq +18 -> 710
    //   695: ldc 104
    //   697: iconst_2
    //   698: iconst_1
    //   699: anewarray 76	java/lang/Object
    //   702: dup
    //   703: iconst_0
    //   704: ldc 201
    //   706: aastore
    //   707: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   710: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   713: invokevirtual 203	com/tencent/qqcamerakit/capture/camera/CameraControl:c	()Z
    //   716: ifeq +1784 -> 2500
    //   719: aload_0
    //   720: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   723: bipush 7
    //   725: iconst_m1
    //   726: ldc 188
    //   728: iconst_0
    //   729: anewarray 76	java/lang/Object
    //   732: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   735: goto +1765 -> 2500
    //   738: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   741: aload_1
    //   742: getfield 142	android/os/Message:arg1	I
    //   745: invokevirtual 206	com/tencent/qqcamerakit/capture/camera2/Camera2Control:b	(I)V
    //   748: goto +1752 -> 2500
    //   751: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   754: aload_1
    //   755: getfield 142	android/os/Message:arg1	I
    //   758: invokevirtual 208	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(I)V
    //   761: goto +1739 -> 2500
    //   764: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   767: aload_1
    //   768: getfield 142	android/os/Message:arg1	I
    //   771: invokevirtual 211	com/tencent/qqcamerakit/capture/camera/CameraControl:d	(I)Z
    //   774: pop
    //   775: goto +1725 -> 2500
    //   778: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   781: aload_1
    //   782: getfield 142	android/os/Message:arg1	I
    //   785: invokevirtual 213	com/tencent/qqcamerakit/capture/camera/CameraControl:c	(I)Z
    //   788: pop
    //   789: goto +1711 -> 2500
    //   792: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   795: astore 4
    //   797: aload_1
    //   798: getfield 142	android/os/Message:arg1	I
    //   801: iconst_1
    //   802: if_icmpne +5 -> 807
    //   805: iconst_1
    //   806: istore_3
    //   807: aload 4
    //   809: iload_3
    //   810: invokevirtual 216	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Z)V
    //   813: goto +1687 -> 2500
    //   816: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   819: ifeq +18 -> 837
    //   822: ldc 104
    //   824: iconst_2
    //   825: iconst_1
    //   826: anewarray 76	java/lang/Object
    //   829: dup
    //   830: iconst_0
    //   831: ldc 218
    //   833: aastore
    //   834: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   837: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   840: invokevirtual 220	com/tencent/qqcamerakit/capture/camera2/Camera2Control:e	()V
    //   843: goto +1657 -> 2500
    //   846: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   849: ifeq +18 -> 867
    //   852: ldc 104
    //   854: iconst_2
    //   855: iconst_1
    //   856: anewarray 76	java/lang/Object
    //   859: dup
    //   860: iconst_0
    //   861: ldc 222
    //   863: aastore
    //   864: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   867: aload_1
    //   868: getfield 123	android/os/Message:obj	Ljava/lang/Object;
    //   871: checkcast 224	com/tencent/qqcamerakit/capture/CameraHandler$TakePictureData
    //   874: astore 4
    //   876: aload 4
    //   878: getfield 227	com/tencent/qqcamerakit/capture/CameraHandler$TakePictureData:a	Ljava/lang/String;
    //   881: ifnonnull +23 -> 904
    //   884: aload_0
    //   885: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   888: iconst_2
    //   889: iconst_m1
    //   890: ldc 229
    //   892: iconst_0
    //   893: anewarray 76	java/lang/Object
    //   896: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   899: aload_1
    //   900: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   903: return
    //   904: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   907: aload 4
    //   909: invokevirtual 232	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Lcom/tencent/qqcamerakit/capture/CameraHandler$TakePictureData;)V
    //   912: goto +1588 -> 2500
    //   915: aload_1
    //   916: getfield 123	android/os/Message:obj	Ljava/lang/Object;
    //   919: checkcast 132	[Ljava/lang/Object;
    //   922: checkcast 132	[Ljava/lang/Object;
    //   925: astore 4
    //   927: aload 4
    //   929: iconst_0
    //   930: aaload
    //   931: checkcast 234	com/tencent/qqcamerakit/capture/CameraSize
    //   934: astore 7
    //   936: aload 4
    //   938: iconst_1
    //   939: aaload
    //   940: checkcast 234	com/tencent/qqcamerakit/capture/CameraSize
    //   943: astore 6
    //   945: aload 4
    //   947: iconst_2
    //   948: aaload
    //   949: checkcast 234	com/tencent/qqcamerakit/capture/CameraSize
    //   952: astore 9
    //   954: aload 4
    //   956: iconst_3
    //   957: aaload
    //   958: checkcast 236	java/lang/Integer
    //   961: invokevirtual 240	java/lang/Integer:intValue	()I
    //   964: istore_2
    //   965: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   968: astore 8
    //   970: new 39	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   977: astore 4
    //   979: aload 4
    //   981: getstatic 241	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	Ljava/lang/String;
    //   984: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 4
    //   990: ldc 243
    //   992: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload 4
    //   998: aload 7
    //   1000: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1003: pop
    //   1004: aload 4
    //   1006: ldc 243
    //   1008: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: aload 4
    //   1014: aload 6
    //   1016: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: aload 4
    //   1022: ldc 243
    //   1024: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: pop
    //   1028: aload 4
    //   1030: aload 9
    //   1032: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1035: pop
    //   1036: aload 4
    //   1038: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1041: astore 10
    //   1043: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   1046: ifeq +78 -> 1124
    //   1049: new 39	java/lang/StringBuilder
    //   1052: dup
    //   1053: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1056: astore 4
    //   1058: aload 4
    //   1060: ldc 248
    //   1062: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: pop
    //   1066: aload 4
    //   1068: aload 7
    //   1070: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload 4
    //   1076: ldc 250
    //   1078: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: pop
    //   1082: aload 4
    //   1084: aload 6
    //   1086: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1089: pop
    //   1090: aload 4
    //   1092: ldc 252
    //   1094: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: aload 4
    //   1100: aload 9
    //   1102: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: ldc 104
    //   1108: iconst_2
    //   1109: iconst_1
    //   1110: anewarray 76	java/lang/Object
    //   1113: dup
    //   1114: iconst_0
    //   1115: aload 4
    //   1117: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: aastore
    //   1121: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1124: aload_0
    //   1125: getfield 26	com/tencent/qqcamerakit/capture/CameraHandler:b	Ljava/util/Map;
    //   1128: aload 10
    //   1130: invokeinterface 258 2 0
    //   1135: checkcast 260	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache
    //   1138: astore 5
    //   1140: aload 5
    //   1142: astore 4
    //   1144: aload 5
    //   1146: ifnonnull +26 -> 1172
    //   1149: new 260	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache
    //   1152: dup
    //   1153: invokespecial 261	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:<init>	()V
    //   1156: astore 4
    //   1158: aload_0
    //   1159: getfield 26	com/tencent/qqcamerakit/capture/CameraHandler:b	Ljava/util/Map;
    //   1162: aload 10
    //   1164: aload 4
    //   1166: invokeinterface 265 3 0
    //   1171: pop
    //   1172: aload 4
    //   1174: getfield 268	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1177: invokevirtual 272	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1180: ifne +213 -> 1393
    //   1183: aload 7
    //   1185: aload 6
    //   1187: aload 9
    //   1189: invokestatic 277	com/tencent/qqcamerakit/capture/camerastrategy/ResolutionStrategy:a	(Lcom/tencent/qqcamerakit/capture/CameraSize;Lcom/tencent/qqcamerakit/capture/CameraSize;Lcom/tencent/qqcamerakit/capture/CameraSize;)[Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1192: astore 6
    //   1194: aload 6
    //   1196: ifnull +1352 -> 2548
    //   1199: aload 6
    //   1201: arraylength
    //   1202: iconst_2
    //   1203: if_icmplt +1345 -> 2548
    //   1206: aload 6
    //   1208: iconst_0
    //   1209: aaload
    //   1210: astore 5
    //   1212: aload 6
    //   1214: iconst_1
    //   1215: aaload
    //   1216: astore 6
    //   1218: goto +3 -> 1221
    //   1221: aload 8
    //   1223: new 234	com/tencent/qqcamerakit/capture/CameraSize
    //   1226: dup
    //   1227: aload 7
    //   1229: getfield 279	com/tencent/qqcamerakit/capture/CameraSize:jdField_a_of_type_Int	I
    //   1232: aload 7
    //   1234: getfield 281	com/tencent/qqcamerakit/capture/CameraSize:jdField_b_of_type_Int	I
    //   1237: invokestatic 287	java/lang/Math:max	(II)I
    //   1240: aload 7
    //   1242: getfield 279	com/tencent/qqcamerakit/capture/CameraSize:jdField_a_of_type_Int	I
    //   1245: aload 7
    //   1247: getfield 281	com/tencent/qqcamerakit/capture/CameraSize:jdField_b_of_type_Int	I
    //   1250: invokestatic 290	java/lang/Math:min	(II)I
    //   1253: invokespecial 293	com/tencent/qqcamerakit/capture/CameraSize:<init>	(II)V
    //   1256: invokevirtual 296	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1259: astore 7
    //   1261: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1264: aload 5
    //   1266: invokevirtual 299	com/tencent/qqcamerakit/capture/camera2/Camera2Control:b	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   1269: ifne +25 -> 1294
    //   1272: aload_0
    //   1273: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1276: iconst_2
    //   1277: bipush 21
    //   1279: ldc_w 301
    //   1282: iconst_0
    //   1283: anewarray 76	java/lang/Object
    //   1286: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1289: aload_1
    //   1290: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1293: return
    //   1294: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1297: aload 6
    //   1299: invokevirtual 303	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   1302: ifne +25 -> 1327
    //   1305: aload_0
    //   1306: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1309: iconst_2
    //   1310: bipush 22
    //   1312: ldc_w 305
    //   1315: iconst_0
    //   1316: anewarray 76	java/lang/Object
    //   1319: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1322: aload_1
    //   1323: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1326: return
    //   1327: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1330: iload_2
    //   1331: invokevirtual 307	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(I)Z
    //   1334: ifne +25 -> 1359
    //   1337: aload_0
    //   1338: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1341: iconst_2
    //   1342: bipush 23
    //   1344: ldc_w 309
    //   1347: iconst_0
    //   1348: anewarray 76	java/lang/Object
    //   1351: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1354: aload_1
    //   1355: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1358: return
    //   1359: aload 4
    //   1361: aload 5
    //   1363: putfield 312	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1366: aload 4
    //   1368: aload 6
    //   1370: putfield 314	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1373: aload 4
    //   1375: aload 7
    //   1377: putfield 316	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:c	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1380: aload 4
    //   1382: getfield 268	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1385: iconst_1
    //   1386: invokevirtual 320	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   1389: pop
    //   1390: goto +35 -> 1425
    //   1393: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1396: aload 4
    //   1398: invokevirtual 323	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Lcom/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache;)Z
    //   1401: ifne +24 -> 1425
    //   1404: aload_0
    //   1405: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1408: iconst_2
    //   1409: iconst_m1
    //   1410: ldc_w 325
    //   1413: iconst_0
    //   1414: anewarray 76	java/lang/Object
    //   1417: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1420: aload_1
    //   1421: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1424: return
    //   1425: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1428: invokevirtual 328	com/tencent/qqcamerakit/capture/camera2/Camera2Control:b	()Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1431: astore 4
    //   1433: invokestatic 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control;
    //   1436: invokevirtual 330	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	()Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1439: astore 5
    //   1441: aload_0
    //   1442: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1445: iconst_2
    //   1446: iconst_0
    //   1447: ldc 151
    //   1449: iconst_2
    //   1450: anewarray 76	java/lang/Object
    //   1453: dup
    //   1454: iconst_0
    //   1455: aload 4
    //   1457: aastore
    //   1458: dup
    //   1459: iconst_1
    //   1460: aload 5
    //   1462: aastore
    //   1463: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1466: goto +1034 -> 2500
    //   1469: aload_1
    //   1470: getfield 142	android/os/Message:arg1	I
    //   1473: istore_2
    //   1474: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1477: iload_2
    //   1478: invokevirtual 331	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(I)Z
    //   1481: pop
    //   1482: goto +1018 -> 2500
    //   1485: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   1488: ifeq +19 -> 1507
    //   1491: ldc 104
    //   1493: iconst_2
    //   1494: iconst_1
    //   1495: anewarray 76	java/lang/Object
    //   1498: dup
    //   1499: iconst_0
    //   1500: ldc_w 333
    //   1503: aastore
    //   1504: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1507: aload_1
    //   1508: getfield 142	android/os/Message:arg1	I
    //   1511: iconst_1
    //   1512: if_icmpne +32 -> 1544
    //   1515: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1518: iconst_1
    //   1519: invokevirtual 335	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Z)Z
    //   1522: ifne +978 -> 2500
    //   1525: aload_0
    //   1526: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1529: iconst_5
    //   1530: iconst_m1
    //   1531: ldc_w 337
    //   1534: iconst_0
    //   1535: anewarray 76	java/lang/Object
    //   1538: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1541: goto +959 -> 2500
    //   1544: aload_1
    //   1545: getfield 142	android/os/Message:arg1	I
    //   1548: iconst_2
    //   1549: if_icmpne +951 -> 2500
    //   1552: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1555: iconst_0
    //   1556: invokevirtual 335	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Z)Z
    //   1559: ifne +941 -> 2500
    //   1562: aload_0
    //   1563: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1566: iconst_5
    //   1567: iconst_m1
    //   1568: ldc_w 339
    //   1571: iconst_0
    //   1572: anewarray 76	java/lang/Object
    //   1575: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1578: goto +922 -> 2500
    //   1581: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   1584: ifeq +19 -> 1603
    //   1587: ldc 104
    //   1589: iconst_2
    //   1590: iconst_1
    //   1591: anewarray 76	java/lang/Object
    //   1594: dup
    //   1595: iconst_0
    //   1596: ldc_w 341
    //   1599: aastore
    //   1600: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1603: aload_1
    //   1604: getfield 123	android/os/Message:obj	Ljava/lang/Object;
    //   1607: checkcast 224	com/tencent/qqcamerakit/capture/CameraHandler$TakePictureData
    //   1610: astore 4
    //   1612: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1615: astore 5
    //   1617: aload 5
    //   1619: getfield 344	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_a_of_type_Boolean	Z
    //   1622: ifne +30 -> 1652
    //   1625: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   1628: ifeq +19 -> 1647
    //   1631: ldc 104
    //   1633: iconst_2
    //   1634: iconst_1
    //   1635: anewarray 76	java/lang/Object
    //   1638: dup
    //   1639: iconst_0
    //   1640: ldc_w 346
    //   1643: aastore
    //   1644: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1647: aload_1
    //   1648: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1651: return
    //   1652: aload 4
    //   1654: getfield 227	com/tencent/qqcamerakit/capture/CameraHandler$TakePictureData:a	Ljava/lang/String;
    //   1657: ifnonnull +23 -> 1680
    //   1660: aload_0
    //   1661: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1664: iconst_2
    //   1665: iconst_m1
    //   1666: ldc 229
    //   1668: iconst_0
    //   1669: anewarray 76	java/lang/Object
    //   1672: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1675: aload_1
    //   1676: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1679: return
    //   1680: aload 5
    //   1682: aload 4
    //   1684: invokevirtual 347	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Lcom/tencent/qqcamerakit/capture/CameraHandler$TakePictureData;)V
    //   1687: goto +813 -> 2500
    //   1690: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   1693: ifeq +19 -> 1712
    //   1696: ldc 104
    //   1698: iconst_2
    //   1699: iconst_1
    //   1700: anewarray 76	java/lang/Object
    //   1703: dup
    //   1704: iconst_0
    //   1705: ldc_w 349
    //   1708: aastore
    //   1709: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1712: aload_1
    //   1713: getfield 123	android/os/Message:obj	Ljava/lang/Object;
    //   1716: checkcast 134	android/graphics/SurfaceTexture
    //   1719: astore 4
    //   1721: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1724: aload 4
    //   1726: invokevirtual 352	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Landroid/graphics/SurfaceTexture;)Z
    //   1729: ifne +771 -> 2500
    //   1732: aload_0
    //   1733: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1736: iconst_2
    //   1737: iconst_m1
    //   1738: ldc_w 354
    //   1741: iconst_0
    //   1742: anewarray 76	java/lang/Object
    //   1745: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1748: goto +752 -> 2500
    //   1751: aload_1
    //   1752: getfield 123	android/os/Message:obj	Ljava/lang/Object;
    //   1755: checkcast 132	[Ljava/lang/Object;
    //   1758: checkcast 132	[Ljava/lang/Object;
    //   1761: astore 4
    //   1763: aload 4
    //   1765: iconst_0
    //   1766: aaload
    //   1767: checkcast 234	com/tencent/qqcamerakit/capture/CameraSize
    //   1770: astore 7
    //   1772: aload 4
    //   1774: iconst_1
    //   1775: aaload
    //   1776: checkcast 234	com/tencent/qqcamerakit/capture/CameraSize
    //   1779: astore 8
    //   1781: aload 4
    //   1783: iconst_2
    //   1784: aaload
    //   1785: checkcast 234	com/tencent/qqcamerakit/capture/CameraSize
    //   1788: astore 9
    //   1790: aload 4
    //   1792: iconst_3
    //   1793: aaload
    //   1794: checkcast 236	java/lang/Integer
    //   1797: invokevirtual 240	java/lang/Integer:intValue	()I
    //   1800: istore_2
    //   1801: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   1804: astore 6
    //   1806: new 39	java/lang/StringBuilder
    //   1809: dup
    //   1810: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1813: astore 4
    //   1815: aload 4
    //   1817: aload 6
    //   1819: getfield 355	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_a_of_type_Int	I
    //   1822: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1825: pop
    //   1826: aload 4
    //   1828: ldc 243
    //   1830: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1833: pop
    //   1834: aload 4
    //   1836: aload 7
    //   1838: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1841: pop
    //   1842: aload 4
    //   1844: ldc 243
    //   1846: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: pop
    //   1850: aload 4
    //   1852: aload 8
    //   1854: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1857: pop
    //   1858: aload 4
    //   1860: ldc 243
    //   1862: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1865: pop
    //   1866: aload 4
    //   1868: aload 9
    //   1870: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1873: pop
    //   1874: aload 4
    //   1876: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1879: astore 10
    //   1881: aload_0
    //   1882: getfield 24	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1885: aload 10
    //   1887: invokeinterface 258 2 0
    //   1892: checkcast 360	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache
    //   1895: astore 5
    //   1897: aload 5
    //   1899: astore 4
    //   1901: aload 5
    //   1903: ifnonnull +26 -> 1929
    //   1906: new 360	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache
    //   1909: dup
    //   1910: invokespecial 361	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:<init>	()V
    //   1913: astore 4
    //   1915: aload_0
    //   1916: getfield 24	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1919: aload 10
    //   1921: aload 4
    //   1923: invokeinterface 265 3 0
    //   1928: pop
    //   1929: aload 4
    //   1931: getfield 362	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1934: invokevirtual 272	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1937: ifne +226 -> 2163
    //   1940: aload 6
    //   1942: invokevirtual 364	com/tencent/qqcamerakit/capture/camera/CameraControl:b	()Z
    //   1945: ifne +25 -> 1970
    //   1948: aload_0
    //   1949: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1952: iconst_2
    //   1953: bipush 20
    //   1955: ldc_w 366
    //   1958: iconst_0
    //   1959: anewarray 76	java/lang/Object
    //   1962: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   1965: aload_1
    //   1966: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   1969: return
    //   1970: aload 7
    //   1972: aload 8
    //   1974: aload 9
    //   1976: invokestatic 277	com/tencent/qqcamerakit/capture/camerastrategy/ResolutionStrategy:a	(Lcom/tencent/qqcamerakit/capture/CameraSize;Lcom/tencent/qqcamerakit/capture/CameraSize;Lcom/tencent/qqcamerakit/capture/CameraSize;)[Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   1979: astore 5
    //   1981: aload 6
    //   1983: aload 5
    //   1985: iconst_0
    //   1986: aaload
    //   1987: invokevirtual 367	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   1990: ifne +25 -> 2015
    //   1993: aload_0
    //   1994: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   1997: iconst_2
    //   1998: bipush 21
    //   2000: ldc_w 369
    //   2003: iconst_0
    //   2004: anewarray 76	java/lang/Object
    //   2007: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2010: aload_1
    //   2011: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2014: return
    //   2015: aload 6
    //   2017: aload 5
    //   2019: iconst_1
    //   2020: aaload
    //   2021: invokevirtual 370	com/tencent/qqcamerakit/capture/camera/CameraControl:b	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   2024: ifne +25 -> 2049
    //   2027: aload_0
    //   2028: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2031: iconst_2
    //   2032: bipush 22
    //   2034: ldc_w 372
    //   2037: iconst_0
    //   2038: anewarray 76	java/lang/Object
    //   2041: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2044: aload_1
    //   2045: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2048: return
    //   2049: aload 6
    //   2051: iload_2
    //   2052: invokevirtual 374	com/tencent/qqcamerakit/capture/camera/CameraControl:b	(I)Z
    //   2055: ifne +25 -> 2080
    //   2058: aload_0
    //   2059: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2062: iconst_2
    //   2063: bipush 23
    //   2065: ldc_w 376
    //   2068: iconst_0
    //   2069: anewarray 76	java/lang/Object
    //   2072: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2075: aload_1
    //   2076: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2079: return
    //   2080: aload 4
    //   2082: aload 6
    //   2084: invokevirtual 378	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()I
    //   2087: putfield 379	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:jdField_a_of_type_Int	I
    //   2090: aload 4
    //   2092: aload 6
    //   2094: invokevirtual 380	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2097: putfield 381	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2100: aload 6
    //   2102: invokevirtual 382	com/tencent/qqcamerakit/capture/camera/CameraControl:b	()Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2105: astore 5
    //   2107: aload 5
    //   2109: ifnull +16 -> 2125
    //   2112: aload 4
    //   2114: aload 5
    //   2116: putfield 383	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2119: aload 4
    //   2121: iconst_1
    //   2122: putfield 384	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:jdField_a_of_type_Boolean	Z
    //   2125: aload 6
    //   2127: invokevirtual 387	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()[I
    //   2130: astore 5
    //   2132: aload 4
    //   2134: aload 5
    //   2136: iconst_0
    //   2137: iaload
    //   2138: putfield 388	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:jdField_b_of_type_Int	I
    //   2141: aload 4
    //   2143: aload 5
    //   2145: iconst_1
    //   2146: iaload
    //   2147: putfield 390	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:c	I
    //   2150: aload 4
    //   2152: getfield 362	com/tencent/qqcamerakit/capture/CameraHandler$ParamCache:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2155: iconst_1
    //   2156: invokevirtual 320	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   2159: pop
    //   2160: goto +56 -> 2216
    //   2163: aload 6
    //   2165: aload 4
    //   2167: invokevirtual 393	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(Lcom/tencent/qqcamerakit/capture/CameraHandler$ParamCache;)Z
    //   2170: ifne +24 -> 2194
    //   2173: aload_0
    //   2174: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2177: iconst_2
    //   2178: iconst_m1
    //   2179: ldc_w 395
    //   2182: iconst_0
    //   2183: anewarray 76	java/lang/Object
    //   2186: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2189: aload_1
    //   2190: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2193: return
    //   2194: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   2197: ifeq +19 -> 2216
    //   2200: ldc 104
    //   2202: iconst_2
    //   2203: iconst_1
    //   2204: anewarray 76	java/lang/Object
    //   2207: dup
    //   2208: iconst_0
    //   2209: ldc_w 397
    //   2212: aastore
    //   2213: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2216: aload 6
    //   2218: getfield 398	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_b_of_type_Int	I
    //   2221: iconst_2
    //   2222: if_icmpne +28 -> 2250
    //   2225: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   2228: invokevirtual 203	com/tencent/qqcamerakit/capture/camera/CameraControl:c	()Z
    //   2231: ifne +19 -> 2250
    //   2234: aload_0
    //   2235: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2238: iconst_2
    //   2239: bipush 24
    //   2241: ldc 188
    //   2243: iconst_0
    //   2244: anewarray 76	java/lang/Object
    //   2247: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2250: aload 6
    //   2252: invokevirtual 399	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Z
    //   2255: ifne +25 -> 2280
    //   2258: aload_0
    //   2259: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2262: iconst_2
    //   2263: bipush 25
    //   2265: ldc_w 401
    //   2268: iconst_0
    //   2269: anewarray 76	java/lang/Object
    //   2272: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2275: aload_1
    //   2276: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2279: return
    //   2280: aload 6
    //   2282: invokevirtual 387	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()[I
    //   2285: astore 4
    //   2287: aload 6
    //   2289: invokevirtual 378	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()I
    //   2292: istore_2
    //   2293: aload 6
    //   2295: invokevirtual 380	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   2298: astore 5
    //   2300: aload_0
    //   2301: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2304: iconst_2
    //   2305: iconst_0
    //   2306: ldc 151
    //   2308: iconst_3
    //   2309: anewarray 76	java/lang/Object
    //   2312: dup
    //   2313: iconst_0
    //   2314: aload 5
    //   2316: aastore
    //   2317: dup
    //   2318: iconst_1
    //   2319: iload_2
    //   2320: invokestatic 405	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2323: aastore
    //   2324: dup
    //   2325: iconst_2
    //   2326: aload 4
    //   2328: aastore
    //   2329: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2332: goto +168 -> 2500
    //   2335: invokestatic 102	com/tencent/qqcamerakit/common/QLog:a	()Z
    //   2338: ifeq +19 -> 2357
    //   2341: ldc 104
    //   2343: iconst_2
    //   2344: iconst_1
    //   2345: anewarray 76	java/lang/Object
    //   2348: dup
    //   2349: iconst_0
    //   2350: ldc_w 407
    //   2353: aastore
    //   2354: invokestatic 110	com/tencent/qqcamerakit/common/QLog:c	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2357: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   2360: invokevirtual 408	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()V
    //   2363: ldc2_w 409
    //   2366: invokestatic 415	java/lang/Thread:sleep	(J)V
    //   2369: aload_0
    //   2370: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2373: bipush 9
    //   2375: iconst_0
    //   2376: ldc_w 417
    //   2379: iconst_0
    //   2380: anewarray 76	java/lang/Object
    //   2383: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2386: goto +114 -> 2500
    //   2389: aload_1
    //   2390: getfield 142	android/os/Message:arg1	I
    //   2393: istore_2
    //   2394: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   2397: iload_2
    //   2398: invokevirtual 420	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(I)I
    //   2401: istore_2
    //   2402: iload_2
    //   2403: bipush 6
    //   2405: if_icmpne +23 -> 2428
    //   2408: aload_0
    //   2409: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2412: iconst_1
    //   2413: iconst_0
    //   2414: ldc 151
    //   2416: iconst_0
    //   2417: anewarray 76	java/lang/Object
    //   2420: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2423: aload_1
    //   2424: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2427: return
    //   2428: iload_2
    //   2429: ifeq +25 -> 2454
    //   2432: aload_0
    //   2433: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2436: iconst_1
    //   2437: iload_2
    //   2438: iload_2
    //   2439: invokestatic 158	com/tencent/qqcamerakit/capture/camera/CameraControl:a	(I)Ljava/lang/String;
    //   2442: iconst_0
    //   2443: anewarray 76	java/lang/Object
    //   2446: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2449: aload_1
    //   2450: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2453: return
    //   2454: invokestatic 163	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Lcom/tencent/qqcamerakit/capture/camera/CameraControl;
    //   2457: invokevirtual 399	com/tencent/qqcamerakit/capture/camera/CameraControl:a	()Z
    //   2460: ifne +25 -> 2485
    //   2463: aload_0
    //   2464: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2467: iconst_1
    //   2468: bipush 7
    //   2470: ldc_w 422
    //   2473: iconst_0
    //   2474: anewarray 76	java/lang/Object
    //   2477: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2480: aload_1
    //   2481: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2484: return
    //   2485: aload_0
    //   2486: getfield 28	com/tencent/qqcamerakit/capture/CameraHandler:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraObservable	Lcom/tencent/qqcamerakit/capture/CameraObservable;
    //   2489: iconst_1
    //   2490: iconst_0
    //   2491: ldc 151
    //   2493: iconst_0
    //   2494: anewarray 76	java/lang/Object
    //   2497: invokevirtual 34	com/tencent/qqcamerakit/capture/CameraObservable:a	(IILjava/lang/String;[Ljava/lang/Object;)V
    //   2500: aload_1
    //   2501: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2504: return
    //   2505: astore 4
    //   2507: goto +18 -> 2525
    //   2510: astore 4
    //   2512: ldc 104
    //   2514: iconst_1
    //   2515: ldc 104
    //   2517: aload 4
    //   2519: invokestatic 425	com/tencent/qqcamerakit/common/QLog:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2522: goto -22 -> 2500
    //   2525: aload_1
    //   2526: invokestatic 153	com/tencent/qqcamerakit/capture/CameraHandler$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2529: goto +6 -> 2535
    //   2532: aload 4
    //   2534: athrow
    //   2535: goto -3 -> 2532
    //   2538: astore 4
    //   2540: goto -171 -> 2369
    //   2543: iconst_0
    //   2544: istore_3
    //   2545: goto -1968 -> 577
    //   2548: aconst_null
    //   2549: astore 5
    //   2551: aload 5
    //   2553: astore 6
    //   2555: goto -1334 -> 1221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2558	0	this	CameraHandler
    //   0	2558	1	paramMessage	android.os.Message
    //   9	2430	2	i	int
    //   11	2534	3	bool	boolean
    //   56	2271	4	localObject1	Object
    //   2505	1	4	localObject2	Object
    //   2510	23	4	localException	java.lang.Exception
    //   2538	1	4	localInterruptedException	InterruptedException
    //   314	2238	5	localObject3	Object
    //   305	2249	6	localObject4	Object
    //   934	1037	7	localCameraSize1	CameraSize
    //   968	1005	8	localObject5	Object
    //   952	1023	9	localCameraSize2	CameraSize
    //   1041	879	10	str	String
    // Exception table:
    //   from	to	target	type
    //   227	248	2505	finally
    //   248	254	2505	finally
    //   257	263	2505	finally
    //   266	283	2505	finally
    //   286	292	2505	finally
    //   295	316	2505	finally
    //   323	332	2505	finally
    //   332	342	2505	finally
    //   345	359	2505	finally
    //   365	395	2505	finally
    //   404	421	2505	finally
    //   424	445	2505	finally
    //   445	469	2505	finally
    //   472	493	2505	finally
    //   493	517	2505	finally
    //   517	532	2505	finally
    //   535	556	2505	finally
    //   556	572	2505	finally
    //   577	604	2505	finally
    //   607	628	2505	finally
    //   628	653	2505	finally
    //   656	686	2505	finally
    //   689	710	2505	finally
    //   710	735	2505	finally
    //   738	748	2505	finally
    //   751	761	2505	finally
    //   764	775	2505	finally
    //   778	789	2505	finally
    //   792	797	2505	finally
    //   797	805	2505	finally
    //   807	813	2505	finally
    //   816	837	2505	finally
    //   837	843	2505	finally
    //   846	867	2505	finally
    //   867	899	2505	finally
    //   904	912	2505	finally
    //   915	1124	2505	finally
    //   1124	1140	2505	finally
    //   1149	1172	2505	finally
    //   1172	1194	2505	finally
    //   1199	1206	2505	finally
    //   1221	1289	2505	finally
    //   1294	1322	2505	finally
    //   1327	1354	2505	finally
    //   1359	1390	2505	finally
    //   1393	1420	2505	finally
    //   1425	1466	2505	finally
    //   1469	1482	2505	finally
    //   1485	1507	2505	finally
    //   1507	1541	2505	finally
    //   1544	1578	2505	finally
    //   1581	1603	2505	finally
    //   1603	1647	2505	finally
    //   1652	1675	2505	finally
    //   1680	1687	2505	finally
    //   1690	1712	2505	finally
    //   1712	1748	2505	finally
    //   1751	1897	2505	finally
    //   1906	1929	2505	finally
    //   1929	1965	2505	finally
    //   1970	2010	2505	finally
    //   2015	2044	2505	finally
    //   2049	2075	2505	finally
    //   2080	2107	2505	finally
    //   2112	2125	2505	finally
    //   2125	2160	2505	finally
    //   2163	2189	2505	finally
    //   2194	2216	2505	finally
    //   2216	2250	2505	finally
    //   2250	2275	2505	finally
    //   2280	2332	2505	finally
    //   2335	2357	2505	finally
    //   2357	2363	2505	finally
    //   2363	2369	2505	finally
    //   2369	2386	2505	finally
    //   2389	2402	2505	finally
    //   2408	2423	2505	finally
    //   2432	2449	2505	finally
    //   2454	2480	2505	finally
    //   2485	2500	2505	finally
    //   2512	2522	2505	finally
    //   227	248	2510	java/lang/Exception
    //   248	254	2510	java/lang/Exception
    //   257	263	2510	java/lang/Exception
    //   266	283	2510	java/lang/Exception
    //   286	292	2510	java/lang/Exception
    //   295	316	2510	java/lang/Exception
    //   323	332	2510	java/lang/Exception
    //   332	342	2510	java/lang/Exception
    //   345	359	2510	java/lang/Exception
    //   365	395	2510	java/lang/Exception
    //   404	421	2510	java/lang/Exception
    //   424	445	2510	java/lang/Exception
    //   445	469	2510	java/lang/Exception
    //   472	493	2510	java/lang/Exception
    //   493	517	2510	java/lang/Exception
    //   517	532	2510	java/lang/Exception
    //   535	556	2510	java/lang/Exception
    //   556	572	2510	java/lang/Exception
    //   577	604	2510	java/lang/Exception
    //   607	628	2510	java/lang/Exception
    //   628	653	2510	java/lang/Exception
    //   656	686	2510	java/lang/Exception
    //   689	710	2510	java/lang/Exception
    //   710	735	2510	java/lang/Exception
    //   738	748	2510	java/lang/Exception
    //   751	761	2510	java/lang/Exception
    //   764	775	2510	java/lang/Exception
    //   778	789	2510	java/lang/Exception
    //   792	797	2510	java/lang/Exception
    //   797	805	2510	java/lang/Exception
    //   807	813	2510	java/lang/Exception
    //   816	837	2510	java/lang/Exception
    //   837	843	2510	java/lang/Exception
    //   846	867	2510	java/lang/Exception
    //   867	899	2510	java/lang/Exception
    //   904	912	2510	java/lang/Exception
    //   915	1124	2510	java/lang/Exception
    //   1124	1140	2510	java/lang/Exception
    //   1149	1172	2510	java/lang/Exception
    //   1172	1194	2510	java/lang/Exception
    //   1199	1206	2510	java/lang/Exception
    //   1221	1289	2510	java/lang/Exception
    //   1294	1322	2510	java/lang/Exception
    //   1327	1354	2510	java/lang/Exception
    //   1359	1390	2510	java/lang/Exception
    //   1393	1420	2510	java/lang/Exception
    //   1425	1466	2510	java/lang/Exception
    //   1469	1482	2510	java/lang/Exception
    //   1485	1507	2510	java/lang/Exception
    //   1507	1541	2510	java/lang/Exception
    //   1544	1578	2510	java/lang/Exception
    //   1581	1603	2510	java/lang/Exception
    //   1603	1647	2510	java/lang/Exception
    //   1652	1675	2510	java/lang/Exception
    //   1680	1687	2510	java/lang/Exception
    //   1690	1712	2510	java/lang/Exception
    //   1712	1748	2510	java/lang/Exception
    //   1751	1897	2510	java/lang/Exception
    //   1906	1929	2510	java/lang/Exception
    //   1929	1965	2510	java/lang/Exception
    //   1970	2010	2510	java/lang/Exception
    //   2015	2044	2510	java/lang/Exception
    //   2049	2075	2510	java/lang/Exception
    //   2080	2107	2510	java/lang/Exception
    //   2112	2125	2510	java/lang/Exception
    //   2125	2160	2510	java/lang/Exception
    //   2163	2189	2510	java/lang/Exception
    //   2194	2216	2510	java/lang/Exception
    //   2216	2250	2510	java/lang/Exception
    //   2250	2275	2510	java/lang/Exception
    //   2280	2332	2510	java/lang/Exception
    //   2335	2357	2510	java/lang/Exception
    //   2357	2363	2510	java/lang/Exception
    //   2363	2369	2510	java/lang/Exception
    //   2369	2386	2510	java/lang/Exception
    //   2389	2402	2510	java/lang/Exception
    //   2408	2423	2510	java/lang/Exception
    //   2432	2449	2510	java/lang/Exception
    //   2454	2480	2510	java/lang/Exception
    //   2485	2500	2510	java/lang/Exception
    //   2363	2369	2538	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraHandler
 * JD-Core Version:    0.7.0.1
 */