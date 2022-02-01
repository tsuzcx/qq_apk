package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class CameraProxy$Camera2Handler
  extends Handler
  implements Camera.AutoFocusCallback
{
  CameraProxy$Camera2Handler(CameraProxy paramCameraProxy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(14)
  private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    Camera.Parameters localParameters = CameraControl.a().a();
    if ((Build.VERSION.SDK_INT >= 14) && (paramRect1 != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[handleMessage] focus area = ");
        ((StringBuilder)localObject).append(paramRect1);
        QLog.i("CameraProxy", 2, ((StringBuilder)localObject).toString());
      }
      localParameters.setFocusMode("auto");
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new Camera.Area(paramRect1, 1000));
      localParameters.setFocusAreas((List)localObject);
      if ((localParameters.getMaxNumMeteringAreas() > 0) && (paramRect2 != null))
      {
        paramRect1 = new ArrayList(1);
        paramRect1.add(new Camera.Area(new Rect(paramRect2), 1000));
        localParameters.setMeteringAreas(paramRect1);
      }
      CameraControl.a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    paramRect1 = paramAutoFocusCallback;
    if (paramAutoFocusCallback == null) {
      paramRect1 = new CameraProxy.Camera2Handler.1(this);
    }
    CameraControl.a().a(paramRect1);
  }
  
  public String a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] getDefaultFocusMode: Build.MANUFACTURER=");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("VERSION.SDK_INT=");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.i("CameraProxy", 2, localStringBuilder.toString());
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
      int i = Build.VERSION.SDK_INT;
    }
    return "continuous-picture";
  }
  
  public String b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] getRecordingFocusMode: Build.MANUFACTURER=");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("VERSION.SDK_INT=");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.i("CameraProxy", 2, localStringBuilder.toString());
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 14)) {
      return "continuous-picture";
    }
    return "continuous-video";
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 159	android/os/Handler:handleMessage	(Landroid/os/Message;)V
    //   5: aload_1
    //   6: getfield 164	android/os/Message:what	I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpeq +5252 -> 5264
    //   15: iload_2
    //   16: iconst_2
    //   17: if_icmpeq +5179 -> 5196
    //   20: iload_2
    //   21: bipush 6
    //   23: if_icmpeq +3854 -> 3877
    //   26: iload_2
    //   27: bipush 7
    //   29: if_icmpeq +2991 -> 3020
    //   32: iload_2
    //   33: sipush 301
    //   36: if_icmpeq +2849 -> 2885
    //   39: iload_2
    //   40: sipush 601
    //   43: if_icmpeq +2812 -> 2855
    //   46: iload_2
    //   47: sipush 701
    //   50: if_icmpeq +2776 -> 2826
    //   53: iload_2
    //   54: sipush 1005
    //   57: if_icmpeq +2141 -> 2198
    //   60: iload_2
    //   61: sipush 1010
    //   64: if_icmpeq +2006 -> 2070
    //   67: iload_2
    //   68: sipush 1021
    //   71: if_icmpeq +1975 -> 2046
    //   74: iload_2
    //   75: sipush 1040
    //   78: if_icmpeq +1939 -> 2017
    //   81: iload_2
    //   82: sipush 1050
    //   85: if_icmpeq +1901 -> 1986
    //   88: iload_2
    //   89: sipush 1060
    //   92: if_icmpeq +1866 -> 1958
    //   95: iload_2
    //   96: sipush 1070
    //   99: if_icmpeq +1659 -> 1758
    //   102: iload_2
    //   103: sipush 401
    //   106: if_icmpeq +1510 -> 1616
    //   109: iload_2
    //   110: sipush 402
    //   113: if_icmpeq +1402 -> 1515
    //   116: iload_2
    //   117: sipush 501
    //   120: if_icmpeq +1314 -> 1434
    //   123: iload_2
    //   124: sipush 502
    //   127: if_icmpeq +1140 -> 1267
    //   130: iload_2
    //   131: tableswitch	default:+29 -> 160, 101:+1055->1186, 102:+1001->1132, 103:+970->1101, 104:+910->1041
    //   161: tableswitch	default:+35 -> 196, 201:+821->982, 202:+762->923, 203:+688->849, 204:+467->628, 205:+380->541
    //   197: tableswitch	default:+27 -> 224, 1001:+198->395, 1002:+163->360, 1003:+147->344
    //   225: tableswitch	default:+27 -> 252, 1030:+99->324, 1031:+90->315, 1032:+67->292
    //   253: nop
    //   254: aaload
    //   255: dup
    //   256: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   259: astore 6
    //   261: aload 6
    //   263: ldc 166
    //   265: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 6
    //   271: aload_1
    //   272: getfield 164	android/os/Message:what	I
    //   275: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: new 168	java/lang/RuntimeException
    //   282: dup
    //   283: aload 6
    //   285: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokespecial 170	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   291: athrow
    //   292: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +11 -> 306
    //   298: ldc 28
    //   300: iconst_2
    //   301: ldc 172
    //   303: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   309: invokevirtual 179	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:b	()V
    //   312: goto +5198 -> 5510
    //   315: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   318: invokevirtual 181	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()V
    //   321: goto +5189 -> 5510
    //   324: aload_1
    //   325: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   328: checkcast 187	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$FocusData
    //   331: astore 6
    //   333: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   336: aload 6
    //   338: invokevirtual 190	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$FocusData;)V
    //   341: goto +5169 -> 5510
    //   344: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   347: invokevirtual 193	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:e	()V
    //   350: ldc 28
    //   352: ldc 195
    //   354: invokestatic 200	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: goto +5153 -> 5510
    //   360: aload_1
    //   361: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   364: checkcast 202	[Ljava/lang/Object;
    //   367: checkcast 202	[Ljava/lang/Object;
    //   370: iconst_0
    //   371: aaload
    //   372: checkcast 204	android/graphics/SurfaceTexture
    //   375: astore 6
    //   377: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   380: aload 6
    //   382: invokevirtual 207	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(Landroid/graphics/SurfaceTexture;)V
    //   385: ldc 28
    //   387: ldc 209
    //   389: invokestatic 200	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: goto +5118 -> 5510
    //   395: ldc 28
    //   397: ldc 211
    //   399: invokestatic 200	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: aload_1
    //   403: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   406: checkcast 202	[Ljava/lang/Object;
    //   409: checkcast 202	[Ljava/lang/Object;
    //   412: astore 6
    //   414: aload 6
    //   416: iconst_0
    //   417: aaload
    //   418: checkcast 213	java/lang/Integer
    //   421: invokevirtual 216	java/lang/Integer:intValue	()I
    //   424: istore_2
    //   425: aload 6
    //   427: iconst_1
    //   428: aaload
    //   429: instanceof 218
    //   432: ifeq +5131 -> 5563
    //   435: aload 6
    //   437: iconst_1
    //   438: aaload
    //   439: checkcast 218	com/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Listener
    //   442: astore 6
    //   444: goto +3 -> 447
    //   447: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   450: invokevirtual 220	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:b	()Z
    //   453: ifeq +14 -> 467
    //   456: iconst_1
    //   457: ldc 222
    //   459: invokestatic 227	com/tencent/mobileqq/shortvideo/camera2/Camera2Utils:a	(ILjava/lang/String;)V
    //   462: aload_1
    //   463: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   466: return
    //   467: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   470: iload_2
    //   471: aload 6
    //   473: invokevirtual 234	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(ILcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Listener;)I
    //   476: istore_2
    //   477: iload_2
    //   478: ifeq +5032 -> 5510
    //   481: new 50	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   488: astore 6
    //   490: aload 6
    //   492: ldc 236
    //   494: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 6
    //   500: iload_2
    //   501: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: ldc 28
    //   507: aload 6
    //   509: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 239	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload_0
    //   516: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   519: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   522: bipush 13
    //   524: iconst_1
    //   525: anewarray 246	java/lang/Object
    //   528: dup
    //   529: iconst_0
    //   530: iload_2
    //   531: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   534: aastore
    //   535: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   538: goto +4972 -> 5510
    //   541: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +12 -> 556
    //   547: ldc 28
    //   549: iconst_2
    //   550: ldc_w 257
    //   553: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: ldc 28
    //   558: ldc_w 259
    //   561: invokestatic 200	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   567: invokevirtual 260	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	()Z
    //   570: ifne +27 -> 597
    //   573: aload_0
    //   574: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   577: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   580: iconst_4
    //   581: iconst_1
    //   582: anewarray 246	java/lang/Object
    //   585: dup
    //   586: iconst_0
    //   587: ldc_w 262
    //   590: aastore
    //   591: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   594: goto +4916 -> 5510
    //   597: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   600: astore 6
    //   602: aload 6
    //   604: invokevirtual 264	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:d	()Z
    //   607: ifeq +4903 -> 5510
    //   610: aload_0
    //   611: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   614: invokestatic 267	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;)Landroid/hardware/Camera$FaceDetectionListener;
    //   617: ifnull +4893 -> 5510
    //   620: aload 6
    //   622: invokevirtual 269	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:d	()V
    //   625: goto +4885 -> 5510
    //   628: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   631: istore 5
    //   633: iload 5
    //   635: ifeq +12 -> 647
    //   638: ldc 28
    //   640: iconst_2
    //   641: ldc_w 271
    //   644: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   650: invokevirtual 273	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Z
    //   653: ifne +50 -> 703
    //   656: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   659: ifeq +12 -> 671
    //   662: ldc 28
    //   664: iconst_2
    //   665: ldc_w 275
    //   668: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   671: ldc 28
    //   673: ldc_w 271
    //   676: invokestatic 200	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   679: aload_0
    //   680: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   683: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   686: iconst_3
    //   687: iconst_1
    //   688: anewarray 246	java/lang/Object
    //   691: dup
    //   692: iconst_0
    //   693: ldc_w 277
    //   696: aastore
    //   697: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   700: goto +4810 -> 5510
    //   703: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   706: astore 6
    //   708: aload 6
    //   710: getfield 279	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Int	I
    //   713: iconst_1
    //   714: if_icmpne +4796 -> 5510
    //   717: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   720: ifeq +43 -> 763
    //   723: new 50	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   730: astore 7
    //   732: aload 7
    //   734: ldc_w 281
    //   737: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload 7
    //   743: aload 6
    //   745: getfield 279	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Int	I
    //   748: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: ldc 28
    //   754: iconst_2
    //   755: aload 7
    //   757: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: new 50	java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   770: astore 7
    //   772: aload 7
    //   774: ldc_w 283
    //   777: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload 7
    //   783: aload 6
    //   785: getfield 279	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Int	I
    //   788: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: ldc 28
    //   794: aload 7
    //   796: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 200	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: aload 6
    //   804: invokevirtual 264	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:d	()Z
    //   807: ifeq +4703 -> 5510
    //   810: aload_0
    //   811: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   814: invokestatic 267	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;)Landroid/hardware/Camera$FaceDetectionListener;
    //   817: ifnull +4693 -> 5510
    //   820: ldc 28
    //   822: iconst_2
    //   823: ldc_w 285
    //   826: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   829: aload 6
    //   831: aload_0
    //   832: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   835: invokestatic 267	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;)Landroid/hardware/Camera$FaceDetectionListener;
    //   838: invokevirtual 288	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Landroid/hardware/Camera$FaceDetectionListener;)V
    //   841: aload 6
    //   843: invokevirtual 291	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:c	()V
    //   846: goto +4664 -> 5510
    //   849: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   852: ifeq +12 -> 864
    //   855: ldc 28
    //   857: iconst_2
    //   858: ldc_w 293
    //   861: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   864: aload_1
    //   865: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   868: checkcast 295	android/hardware/Camera$PreviewCallback
    //   871: astore 6
    //   873: aload_1
    //   874: getfield 298	android/os/Message:arg1	I
    //   877: ifle +4692 -> 5569
    //   880: iconst_1
    //   881: istore 5
    //   883: goto +3 -> 886
    //   886: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   889: aload 6
    //   891: iload 5
    //   893: invokevirtual 301	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Landroid/hardware/Camera$PreviewCallback;Z)Z
    //   896: ifne +4614 -> 5510
    //   899: aload_0
    //   900: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   903: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   906: iconst_2
    //   907: iconst_1
    //   908: anewarray 246	java/lang/Object
    //   911: dup
    //   912: iconst_0
    //   913: ldc_w 303
    //   916: aastore
    //   917: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   920: goto +4590 -> 5510
    //   923: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   926: ifeq +12 -> 938
    //   929: ldc 28
    //   931: iconst_2
    //   932: ldc_w 305
    //   935: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   938: aload_1
    //   939: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   942: checkcast 307	android/view/SurfaceHolder
    //   945: astore 6
    //   947: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   950: aload 6
    //   952: invokevirtual 310	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Landroid/view/SurfaceHolder;)Z
    //   955: ifne +4555 -> 5510
    //   958: aload_0
    //   959: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   962: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   965: iconst_2
    //   966: iconst_1
    //   967: anewarray 246	java/lang/Object
    //   970: dup
    //   971: iconst_0
    //   972: ldc_w 312
    //   975: aastore
    //   976: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   979: goto +4531 -> 5510
    //   982: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   985: ifeq +12 -> 997
    //   988: ldc 28
    //   990: iconst_2
    //   991: ldc_w 314
    //   994: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: aload_1
    //   998: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   1001: checkcast 204	android/graphics/SurfaceTexture
    //   1004: astore 6
    //   1006: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1009: aload 6
    //   1011: invokevirtual 317	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Landroid/graphics/SurfaceTexture;)Z
    //   1014: ifne +4496 -> 5510
    //   1017: aload_0
    //   1018: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1021: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1024: iconst_2
    //   1025: iconst_1
    //   1026: anewarray 246	java/lang/Object
    //   1029: dup
    //   1030: iconst_0
    //   1031: ldc_w 319
    //   1034: aastore
    //   1035: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1038: goto +4472 -> 5510
    //   1041: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1044: ifeq +12 -> 1056
    //   1047: ldc 28
    //   1049: iconst_2
    //   1050: ldc_w 321
    //   1053: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1056: aload_0
    //   1057: invokevirtual 323	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:b	()Ljava/lang/String;
    //   1060: astore 6
    //   1062: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1065: aload 6
    //   1067: invokevirtual 325	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Ljava/lang/String;)Z
    //   1070: ifne +4440 -> 5510
    //   1073: aload_0
    //   1074: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1077: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1080: bipush 9
    //   1082: iconst_1
    //   1083: anewarray 246	java/lang/Object
    //   1086: dup
    //   1087: iconst_0
    //   1088: ldc_w 326
    //   1091: invokestatic 331	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1094: aastore
    //   1095: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1098: goto +4412 -> 5510
    //   1101: aload_1
    //   1102: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   1105: checkcast 187	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$FocusData
    //   1108: astore 6
    //   1110: aload_0
    //   1111: aload 6
    //   1113: getfield 334	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$FocusData:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   1116: aload 6
    //   1118: getfield 336	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$FocusData:b	Landroid/graphics/Rect;
    //   1121: aload 6
    //   1123: getfield 339	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$FocusData:jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback	Landroid/hardware/Camera$AutoFocusCallback;
    //   1126: invokespecial 341	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	(Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/hardware/Camera$AutoFocusCallback;)V
    //   1129: goto +4381 -> 5510
    //   1132: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1135: ifeq +12 -> 1147
    //   1138: ldc 28
    //   1140: iconst_2
    //   1141: ldc_w 343
    //   1144: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1147: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1150: ldc 68
    //   1152: invokevirtual 325	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Ljava/lang/String;)Z
    //   1155: ifne +4355 -> 5510
    //   1158: aload_0
    //   1159: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1162: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1165: bipush 9
    //   1167: iconst_1
    //   1168: anewarray 246	java/lang/Object
    //   1171: dup
    //   1172: iconst_0
    //   1173: ldc_w 344
    //   1176: invokestatic 331	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1179: aastore
    //   1180: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1183: goto +4327 -> 5510
    //   1186: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1189: ifeq +12 -> 1201
    //   1192: ldc 28
    //   1194: iconst_2
    //   1195: ldc_w 346
    //   1198: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1201: aload_0
    //   1202: invokevirtual 348	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	()Ljava/lang/String;
    //   1205: astore 6
    //   1207: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1210: aload 6
    //   1212: invokevirtual 325	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Ljava/lang/String;)Z
    //   1215: ifne +4295 -> 5510
    //   1218: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1221: ldc 68
    //   1223: invokevirtual 325	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Ljava/lang/String;)Z
    //   1226: ifne +4284 -> 5510
    //   1229: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1232: aload_0
    //   1233: invokevirtual 122	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Landroid/hardware/Camera$AutoFocusCallback;)Z
    //   1236: ifne +4274 -> 5510
    //   1239: aload_0
    //   1240: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1243: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1246: bipush 9
    //   1248: iconst_1
    //   1249: anewarray 246	java/lang/Object
    //   1252: dup
    //   1253: iconst_0
    //   1254: ldc_w 349
    //   1257: invokestatic 331	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   1260: aastore
    //   1261: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1264: goto +4246 -> 5510
    //   1267: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1270: ifeq +42 -> 1312
    //   1273: new 50	java/lang/StringBuilder
    //   1276: dup
    //   1277: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1280: astore 6
    //   1282: aload 6
    //   1284: ldc_w 351
    //   1287: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload 6
    //   1293: aload_1
    //   1294: getfield 298	android/os/Message:arg1	I
    //   1297: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1300: pop
    //   1301: ldc 28
    //   1303: iconst_2
    //   1304: aload 6
    //   1306: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1309: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1312: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1315: astore 6
    //   1317: aload 6
    //   1319: invokevirtual 264	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:d	()Z
    //   1322: ifeq +4188 -> 5510
    //   1325: aload_0
    //   1326: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1329: invokestatic 267	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;)Landroid/hardware/Camera$FaceDetectionListener;
    //   1332: ifnull +4178 -> 5510
    //   1335: aload_1
    //   1336: getfield 298	android/os/Message:arg1	I
    //   1339: iconst_1
    //   1340: if_icmpne +78 -> 1418
    //   1343: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1346: ifeq +43 -> 1389
    //   1349: new 50	java/lang/StringBuilder
    //   1352: dup
    //   1353: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1356: astore 7
    //   1358: aload 7
    //   1360: ldc_w 353
    //   1363: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: pop
    //   1367: aload 7
    //   1369: aload 6
    //   1371: getfield 279	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Int	I
    //   1374: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1377: pop
    //   1378: ldc 28
    //   1380: iconst_2
    //   1381: aload 7
    //   1383: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1386: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1389: aload 6
    //   1391: getfield 279	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Int	I
    //   1394: iconst_1
    //   1395: if_icmpne +4115 -> 5510
    //   1398: aload 6
    //   1400: aload_0
    //   1401: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1404: invokestatic 267	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;)Landroid/hardware/Camera$FaceDetectionListener;
    //   1407: invokevirtual 288	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Landroid/hardware/Camera$FaceDetectionListener;)V
    //   1410: aload 6
    //   1412: invokevirtual 291	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:c	()V
    //   1415: goto +4095 -> 5510
    //   1418: aload_1
    //   1419: getfield 298	android/os/Message:arg1	I
    //   1422: iconst_2
    //   1423: if_icmpne +4087 -> 5510
    //   1426: aload 6
    //   1428: invokevirtual 269	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:d	()V
    //   1431: goto +4079 -> 5510
    //   1434: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1437: ifeq +42 -> 1479
    //   1440: new 50	java/lang/StringBuilder
    //   1443: dup
    //   1444: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1447: astore 6
    //   1449: aload 6
    //   1451: ldc_w 355
    //   1454: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: pop
    //   1458: aload 6
    //   1460: aload_1
    //   1461: getfield 298	android/os/Message:arg1	I
    //   1464: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1467: pop
    //   1468: ldc 28
    //   1470: iconst_2
    //   1471: aload 6
    //   1473: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1476: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1479: aload_1
    //   1480: getfield 298	android/os/Message:arg1	I
    //   1483: iconst_1
    //   1484: if_icmpne +13 -> 1497
    //   1487: aload_0
    //   1488: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1491: invokestatic 358	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;)V
    //   1494: goto +4016 -> 5510
    //   1497: aload_1
    //   1498: getfield 298	android/os/Message:arg1	I
    //   1501: iconst_2
    //   1502: if_icmpne +4008 -> 5510
    //   1505: aload_0
    //   1506: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1509: invokestatic 360	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:b	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;)V
    //   1512: goto +3998 -> 5510
    //   1515: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1518: ifeq +12 -> 1530
    //   1521: ldc 28
    //   1523: iconst_2
    //   1524: ldc_w 362
    //   1527: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1530: aload_1
    //   1531: getfield 298	android/os/Message:arg1	I
    //   1534: iconst_1
    //   1535: if_icmpne +38 -> 1573
    //   1538: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1541: iconst_1
    //   1542: invokevirtual 365	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Z)Z
    //   1545: ifne +3965 -> 5510
    //   1548: aload_0
    //   1549: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1552: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1555: bipush 6
    //   1557: iconst_1
    //   1558: anewarray 246	java/lang/Object
    //   1561: dup
    //   1562: iconst_0
    //   1563: ldc_w 367
    //   1566: aastore
    //   1567: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1570: goto +3940 -> 5510
    //   1573: aload_1
    //   1574: getfield 298	android/os/Message:arg1	I
    //   1577: iconst_2
    //   1578: if_icmpne +3932 -> 5510
    //   1581: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1584: iconst_0
    //   1585: invokevirtual 365	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Z)Z
    //   1588: ifne +3922 -> 5510
    //   1591: aload_0
    //   1592: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1595: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1598: bipush 6
    //   1600: iconst_1
    //   1601: anewarray 246	java/lang/Object
    //   1604: dup
    //   1605: iconst_0
    //   1606: ldc_w 369
    //   1609: aastore
    //   1610: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1613: goto +3897 -> 5510
    //   1616: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1619: ifeq +12 -> 1631
    //   1622: ldc 28
    //   1624: iconst_2
    //   1625: ldc_w 371
    //   1628: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1631: aload_1
    //   1632: getfield 298	android/os/Message:arg1	I
    //   1635: ifne +37 -> 1672
    //   1638: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1641: invokevirtual 374	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:f	()Z
    //   1644: ifne +3866 -> 5510
    //   1647: aload_0
    //   1648: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1651: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1654: bipush 6
    //   1656: iconst_1
    //   1657: anewarray 246	java/lang/Object
    //   1660: dup
    //   1661: iconst_0
    //   1662: ldc_w 376
    //   1665: aastore
    //   1666: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1669: goto +3841 -> 5510
    //   1672: aload_1
    //   1673: getfield 298	android/os/Message:arg1	I
    //   1676: iconst_1
    //   1677: if_icmpne +38 -> 1715
    //   1680: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1683: iconst_1
    //   1684: invokevirtual 378	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	(Z)Z
    //   1687: ifne +3823 -> 5510
    //   1690: aload_0
    //   1691: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1694: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1697: bipush 6
    //   1699: iconst_1
    //   1700: anewarray 246	java/lang/Object
    //   1703: dup
    //   1704: iconst_0
    //   1705: ldc_w 367
    //   1708: aastore
    //   1709: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1712: goto +3798 -> 5510
    //   1715: aload_1
    //   1716: getfield 298	android/os/Message:arg1	I
    //   1719: iconst_2
    //   1720: if_icmpne +3790 -> 5510
    //   1723: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   1726: iconst_0
    //   1727: invokevirtual 378	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	(Z)Z
    //   1730: ifne +3780 -> 5510
    //   1733: aload_0
    //   1734: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1737: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1740: bipush 6
    //   1742: iconst_1
    //   1743: anewarray 246	java/lang/Object
    //   1746: dup
    //   1747: iconst_0
    //   1748: ldc_w 369
    //   1751: aastore
    //   1752: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1755: goto +3755 -> 5510
    //   1758: new 50	java/lang/StringBuilder
    //   1761: dup
    //   1762: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1765: astore 6
    //   1767: aload 6
    //   1769: ldc_w 380
    //   1772: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: pop
    //   1776: aload 6
    //   1778: aload_1
    //   1779: getfield 298	android/os/Message:arg1	I
    //   1782: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1785: pop
    //   1786: iconst_2
    //   1787: aload 6
    //   1789: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1792: invokestatic 227	com/tencent/mobileqq/shortvideo/camera2/Camera2Utils:a	(ILjava/lang/String;)V
    //   1795: new 50	java/lang/StringBuilder
    //   1798: dup
    //   1799: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1802: astore 6
    //   1804: aload 6
    //   1806: ldc_w 382
    //   1809: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1812: pop
    //   1813: aload 6
    //   1815: aload_1
    //   1816: getfield 298	android/os/Message:arg1	I
    //   1819: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1822: pop
    //   1823: ldc 28
    //   1825: aload 6
    //   1827: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1830: invokestatic 239	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1833: aload_1
    //   1834: getfield 298	android/os/Message:arg1	I
    //   1837: istore_2
    //   1838: iload_2
    //   1839: bipush 151
    //   1841: if_icmpeq +91 -> 1932
    //   1844: iload_2
    //   1845: bipush 154
    //   1847: if_icmpeq +85 -> 1932
    //   1850: iload_2
    //   1851: tableswitch	default:+3724 -> 5575, -203:+25->1876, -202:+25->1876, -201:+25->1876
    //   1877: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1880: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1883: astore 6
    //   1885: new 50	java/lang/StringBuilder
    //   1888: dup
    //   1889: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1892: astore 7
    //   1894: aload 7
    //   1896: ldc_w 384
    //   1899: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1902: pop
    //   1903: aload 7
    //   1905: iload_2
    //   1906: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1909: pop
    //   1910: aload 6
    //   1912: bipush 14
    //   1914: iconst_1
    //   1915: anewarray 246	java/lang/Object
    //   1918: dup
    //   1919: iconst_0
    //   1920: aload 7
    //   1922: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1925: aastore
    //   1926: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1929: goto +3581 -> 5510
    //   1932: aload_0
    //   1933: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   1936: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   1939: bipush 13
    //   1941: iconst_1
    //   1942: anewarray 246	java/lang/Object
    //   1945: dup
    //   1946: iconst_0
    //   1947: iload_2
    //   1948: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1951: aastore
    //   1952: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   1955: goto +3555 -> 5510
    //   1958: aload_1
    //   1959: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   1962: checkcast 202	[Ljava/lang/Object;
    //   1965: checkcast 202	[Ljava/lang/Object;
    //   1968: iconst_0
    //   1969: aaload
    //   1970: checkcast 295	android/hardware/Camera$PreviewCallback
    //   1973: astore 6
    //   1975: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   1978: aload 6
    //   1980: invokevirtual 387	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(Landroid/hardware/Camera$PreviewCallback;)V
    //   1983: goto +3527 -> 5510
    //   1986: aload_1
    //   1987: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   1990: checkcast 202	[Ljava/lang/Object;
    //   1993: checkcast 202	[Ljava/lang/Object;
    //   1996: iconst_0
    //   1997: aaload
    //   1998: checkcast 389	java/lang/Boolean
    //   2001: invokevirtual 392	java/lang/Boolean:booleanValue	()Z
    //   2004: istore 5
    //   2006: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2009: iload 5
    //   2011: invokevirtual 395	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(Z)V
    //   2014: goto +3496 -> 5510
    //   2017: aload_1
    //   2018: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   2021: checkcast 202	[Ljava/lang/Object;
    //   2024: checkcast 202	[Ljava/lang/Object;
    //   2027: iconst_0
    //   2028: aaload
    //   2029: checkcast 213	java/lang/Integer
    //   2032: invokevirtual 216	java/lang/Integer:intValue	()I
    //   2035: istore_2
    //   2036: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2039: iload_2
    //   2040: invokevirtual 397	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(I)V
    //   2043: goto +3467 -> 5510
    //   2046: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2049: ifeq +12 -> 2061
    //   2052: ldc 28
    //   2054: iconst_2
    //   2055: ldc_w 399
    //   2058: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2061: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2064: invokevirtual 400	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:c	()V
    //   2067: goto +3443 -> 5510
    //   2070: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2073: ifeq +12 -> 2085
    //   2076: ldc 28
    //   2078: iconst_2
    //   2079: ldc_w 402
    //   2082: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2085: aload_1
    //   2086: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   2089: checkcast 404	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData
    //   2092: astore 6
    //   2094: aload 6
    //   2096: getfield 407	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2099: ifnonnull +29 -> 2128
    //   2102: aload_0
    //   2103: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   2106: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   2109: iconst_2
    //   2110: iconst_1
    //   2111: anewarray 246	java/lang/Object
    //   2114: dup
    //   2115: iconst_0
    //   2116: ldc_w 409
    //   2119: aastore
    //   2120: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   2123: aload_1
    //   2124: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2127: return
    //   2128: new 411	com/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2PictureData
    //   2131: dup
    //   2132: invokespecial 412	com/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2PictureData:<init>	()V
    //   2135: astore 7
    //   2137: aload 7
    //   2139: aload 6
    //   2141: getfield 415	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback	Lcom/tencent/mobileqq/activity/richmedia/view/CameraCover$PictureCallback;
    //   2144: putfield 416	com/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2PictureData:jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback	Lcom/tencent/mobileqq/activity/richmedia/view/CameraCover$PictureCallback;
    //   2147: aload 7
    //   2149: aload 6
    //   2151: getfield 419	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_Boolean	Z
    //   2154: putfield 420	com/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2PictureData:jdField_a_of_type_Boolean	Z
    //   2157: aload 7
    //   2159: aload 6
    //   2161: getfield 421	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_Int	I
    //   2164: putfield 422	com/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2PictureData:jdField_a_of_type_Int	I
    //   2167: aload 7
    //   2169: aload 6
    //   2171: getfield 407	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2174: putfield 423	com/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2PictureData:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2177: aload 7
    //   2179: aload 6
    //   2181: getfield 424	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   2184: putfield 425	com/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2PictureData:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   2187: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2190: aload 7
    //   2192: invokevirtual 428	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2PictureData;)V
    //   2195: goto +3315 -> 5510
    //   2198: aload_1
    //   2199: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   2202: checkcast 202	[Ljava/lang/Object;
    //   2205: checkcast 202	[Ljava/lang/Object;
    //   2208: astore 9
    //   2210: aload 9
    //   2212: iconst_0
    //   2213: aaload
    //   2214: checkcast 430	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize
    //   2217: astore 8
    //   2219: aload 9
    //   2221: iconst_1
    //   2222: aaload
    //   2223: checkcast 430	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize
    //   2226: astore 10
    //   2228: aload 9
    //   2230: iconst_4
    //   2231: aaload
    //   2232: checkcast 389	java/lang/Boolean
    //   2235: invokevirtual 392	java/lang/Boolean:booleanValue	()Z
    //   2238: istore 5
    //   2240: new 50	java/lang/StringBuilder
    //   2243: dup
    //   2244: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2247: astore 6
    //   2249: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2252: pop
    //   2253: aload 6
    //   2255: getstatic 432	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	Ljava/lang/String;
    //   2258: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2261: pop
    //   2262: aload 6
    //   2264: ldc_w 434
    //   2267: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: pop
    //   2271: aload 6
    //   2273: aload 8
    //   2275: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2278: pop
    //   2279: aload 6
    //   2281: ldc_w 434
    //   2284: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2287: pop
    //   2288: aload 6
    //   2290: aload 10
    //   2292: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2295: pop
    //   2296: aload 6
    //   2298: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2301: astore 11
    //   2303: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2306: ifeq +74 -> 2380
    //   2309: new 50	java/lang/StringBuilder
    //   2312: dup
    //   2313: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   2316: astore 6
    //   2318: aload 6
    //   2320: ldc_w 436
    //   2323: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2326: pop
    //   2327: aload 6
    //   2329: aload 8
    //   2331: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2334: pop
    //   2335: aload 6
    //   2337: ldc_w 438
    //   2340: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2343: pop
    //   2344: aload 6
    //   2346: aload 10
    //   2348: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2351: pop
    //   2352: aload 6
    //   2354: ldc_w 440
    //   2357: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: pop
    //   2361: aload 6
    //   2363: iload 5
    //   2365: invokevirtual 443	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2368: pop
    //   2369: ldc 28
    //   2371: iconst_2
    //   2372: aload 6
    //   2374: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2377: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2380: aload_0
    //   2381: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   2384: getfield 446	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2387: aload 11
    //   2389: invokeinterface 452 2 0
    //   2394: checkcast 454	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCamera2Cache
    //   2397: astore 7
    //   2399: aload 7
    //   2401: astore 6
    //   2403: aload 7
    //   2405: ifnonnull +29 -> 2434
    //   2408: new 454	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCamera2Cache
    //   2411: dup
    //   2412: invokespecial 455	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCamera2Cache:<init>	()V
    //   2415: astore 6
    //   2417: aload_0
    //   2418: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   2421: getfield 446	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2424: aload 11
    //   2426: aload 6
    //   2428: invokeinterface 459 3 0
    //   2433: pop
    //   2434: aload 6
    //   2436: getfield 462	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCamera2Cache:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2439: invokevirtual 466	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2442: ifne +301 -> 2743
    //   2445: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2448: invokevirtual 469	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Info;
    //   2451: astore 7
    //   2453: iload 5
    //   2455: ifne +33 -> 2488
    //   2458: aload 8
    //   2460: getfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   2463: aload 8
    //   2465: getfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   2468: aload 10
    //   2470: getfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   2473: aload 10
    //   2475: getfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   2478: aload 7
    //   2480: invokestatic 475	com/tencent/mobileqq/shortvideo/camera2/Camera2Utils:a	(IIIILcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Info;)[Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   2483: astore 7
    //   2485: goto +30 -> 2515
    //   2488: aload 8
    //   2490: getfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   2493: aload 8
    //   2495: getfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   2498: aload 10
    //   2500: getfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   2503: aload 10
    //   2505: getfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   2508: aload 7
    //   2510: invokestatic 477	com/tencent/mobileqq/shortvideo/camera2/Camera2Utils:b	(IIIILcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Info;)[Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   2513: astore 7
    //   2515: aload 7
    //   2517: ifnull +3061 -> 5578
    //   2520: aload 7
    //   2522: arraylength
    //   2523: iconst_2
    //   2524: if_icmplt +3054 -> 5578
    //   2527: aload 7
    //   2529: iconst_0
    //   2530: aaload
    //   2531: astore 8
    //   2533: aload 7
    //   2535: iconst_1
    //   2536: aaload
    //   2537: astore 7
    //   2539: goto +3 -> 2542
    //   2542: new 430	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize
    //   2545: dup
    //   2546: aload 10
    //   2548: getfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   2551: aload 10
    //   2553: getfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   2556: invokestatic 483	java/lang/Math:max	(II)I
    //   2559: aload 10
    //   2561: getfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   2564: aload 10
    //   2566: getfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   2569: invokestatic 486	java/lang/Math:min	(II)I
    //   2572: invokespecial 489	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:<init>	(II)V
    //   2575: astore 10
    //   2577: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2580: aload 10
    //   2582: invokevirtual 492	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;)Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   2585: astore 10
    //   2587: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2590: aload 8
    //   2592: invokevirtual 495	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;)Z
    //   2595: ifne +30 -> 2625
    //   2598: aload_0
    //   2599: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   2602: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   2605: bipush 14
    //   2607: iconst_1
    //   2608: anewarray 246	java/lang/Object
    //   2611: dup
    //   2612: iconst_0
    //   2613: ldc_w 497
    //   2616: aastore
    //   2617: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   2620: aload_1
    //   2621: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2624: return
    //   2625: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2628: aload 7
    //   2630: invokevirtual 499	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:b	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;)Z
    //   2633: ifne +30 -> 2663
    //   2636: aload_0
    //   2637: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   2640: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   2643: bipush 14
    //   2645: iconst_1
    //   2646: anewarray 246	java/lang/Object
    //   2649: dup
    //   2650: iconst_0
    //   2651: ldc_w 501
    //   2654: aastore
    //   2655: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   2658: aload_1
    //   2659: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2662: return
    //   2663: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2666: aload 9
    //   2668: iconst_3
    //   2669: aaload
    //   2670: checkcast 213	java/lang/Integer
    //   2673: invokevirtual 216	java/lang/Integer:intValue	()I
    //   2676: invokevirtual 504	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(I)Z
    //   2679: ifne +30 -> 2709
    //   2682: aload_0
    //   2683: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   2686: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   2689: bipush 14
    //   2691: iconst_1
    //   2692: anewarray 246	java/lang/Object
    //   2695: dup
    //   2696: iconst_0
    //   2697: ldc_w 506
    //   2700: aastore
    //   2701: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   2704: aload_1
    //   2705: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2708: return
    //   2709: aload 6
    //   2711: aload 8
    //   2713: putfield 509	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCamera2Cache:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   2716: aload 6
    //   2718: aload 7
    //   2720: putfield 511	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCamera2Cache:jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   2723: aload 6
    //   2725: aload 10
    //   2727: putfield 513	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCamera2Cache:c	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   2730: aload 6
    //   2732: getfield 462	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCamera2Cache:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2735: iconst_1
    //   2736: invokevirtual 516	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   2739: pop
    //   2740: goto +41 -> 2781
    //   2743: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2746: aload 6
    //   2748: invokevirtual 519	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCamera2Cache;)Z
    //   2751: ifne +30 -> 2781
    //   2754: aload_0
    //   2755: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   2758: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   2761: bipush 14
    //   2763: iconst_1
    //   2764: anewarray 246	java/lang/Object
    //   2767: dup
    //   2768: iconst_0
    //   2769: ldc_w 521
    //   2772: aastore
    //   2773: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   2776: aload_1
    //   2777: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2780: return
    //   2781: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2784: invokevirtual 524	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:b	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   2787: astore 6
    //   2789: invokestatic 177	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control;
    //   2792: invokevirtual 526	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   2795: astore 7
    //   2797: aload_0
    //   2798: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   2801: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   2804: bipush 14
    //   2806: iconst_2
    //   2807: anewarray 246	java/lang/Object
    //   2810: dup
    //   2811: iconst_0
    //   2812: aload 6
    //   2814: aastore
    //   2815: dup
    //   2816: iconst_1
    //   2817: aload 7
    //   2819: aastore
    //   2820: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   2823: goto +2687 -> 5510
    //   2826: aload_1
    //   2827: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   2830: checkcast 202	[Ljava/lang/Object;
    //   2833: checkcast 202	[Ljava/lang/Object;
    //   2836: iconst_0
    //   2837: aaload
    //   2838: checkcast 140	java/lang/String
    //   2841: astore 6
    //   2843: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   2846: aload 6
    //   2848: invokevirtual 528	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	(Ljava/lang/String;)Z
    //   2851: pop
    //   2852: goto +2658 -> 5510
    //   2855: aload_1
    //   2856: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   2859: checkcast 202	[Ljava/lang/Object;
    //   2862: checkcast 202	[Ljava/lang/Object;
    //   2865: iconst_0
    //   2866: aaload
    //   2867: checkcast 213	java/lang/Integer
    //   2870: invokevirtual 216	java/lang/Integer:intValue	()I
    //   2873: istore_2
    //   2874: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   2877: iload_2
    //   2878: invokevirtual 530	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	(I)Z
    //   2881: pop
    //   2882: goto +2628 -> 5510
    //   2885: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2888: ifeq +12 -> 2900
    //   2891: ldc 28
    //   2893: iconst_2
    //   2894: ldc_w 532
    //   2897: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2900: ldc_w 534
    //   2903: invokestatic 538	com/tencent/mobileqq/activity/richmedia/NewFlowCameraReporter:a	(Ljava/lang/String;)V
    //   2906: aload_1
    //   2907: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   2910: checkcast 404	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData
    //   2913: astore 6
    //   2915: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   2918: astore 7
    //   2920: aload 7
    //   2922: getfield 539	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Boolean	Z
    //   2925: ifne +23 -> 2948
    //   2928: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2931: ifeq +12 -> 2943
    //   2934: ldc 28
    //   2936: iconst_2
    //   2937: ldc_w 541
    //   2940: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2943: aload_1
    //   2944: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2947: return
    //   2948: aload 6
    //   2950: getfield 407	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2953: ifnonnull +29 -> 2982
    //   2956: aload_0
    //   2957: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   2960: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   2963: iconst_2
    //   2964: iconst_1
    //   2965: anewarray 246	java/lang/Object
    //   2968: dup
    //   2969: iconst_0
    //   2970: ldc_w 409
    //   2973: aastore
    //   2974: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   2977: aload_1
    //   2978: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   2981: return
    //   2982: aload 7
    //   2984: aload 6
    //   2986: getfield 407	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2989: aload 6
    //   2991: getfield 424	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   2994: aload 6
    //   2996: getfield 415	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback	Lcom/tencent/mobileqq/activity/richmedia/view/CameraCover$PictureCallback;
    //   2999: aload 6
    //   3001: getfield 421	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_Int	I
    //   3004: aload 6
    //   3006: getfield 419	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_a_of_type_Boolean	Z
    //   3009: aload 6
    //   3011: getfield 542	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$TakePictureData:jdField_b_of_type_Int	I
    //   3014: invokevirtual 545	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Ljava/io/File;Landroid/graphics/Rect;Lcom/tencent/mobileqq/activity/richmedia/view/CameraCover$PictureCallback;IZI)V
    //   3017: goto +2493 -> 5510
    //   3020: aload_1
    //   3021: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   3024: checkcast 202	[Ljava/lang/Object;
    //   3027: checkcast 202	[Ljava/lang/Object;
    //   3030: astore 6
    //   3032: aload 6
    //   3034: iconst_0
    //   3035: aaload
    //   3036: checkcast 430	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize
    //   3039: astore 9
    //   3041: aload 6
    //   3043: iconst_1
    //   3044: aaload
    //   3045: checkcast 430	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize
    //   3048: astore 10
    //   3050: aload 6
    //   3052: iconst_2
    //   3053: aaload
    //   3054: checkcast 213	java/lang/Integer
    //   3057: invokevirtual 216	java/lang/Integer:intValue	()I
    //   3060: istore_2
    //   3061: aload 6
    //   3063: iconst_3
    //   3064: aaload
    //   3065: checkcast 213	java/lang/Integer
    //   3068: invokevirtual 216	java/lang/Integer:intValue	()I
    //   3071: istore_3
    //   3072: aload 6
    //   3074: iconst_4
    //   3075: aaload
    //   3076: checkcast 389	java/lang/Boolean
    //   3079: invokevirtual 392	java/lang/Boolean:booleanValue	()Z
    //   3082: istore 5
    //   3084: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3087: ifeq +90 -> 3177
    //   3090: new 50	java/lang/StringBuilder
    //   3093: dup
    //   3094: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3097: astore 6
    //   3099: aload 6
    //   3101: ldc_w 547
    //   3104: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3107: pop
    //   3108: aload 6
    //   3110: aload 9
    //   3112: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3115: pop
    //   3116: aload 6
    //   3118: ldc_w 438
    //   3121: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3124: pop
    //   3125: aload 6
    //   3127: aload 10
    //   3129: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3132: pop
    //   3133: aload 6
    //   3135: ldc_w 549
    //   3138: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3141: pop
    //   3142: aload 6
    //   3144: iload_2
    //   3145: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3148: pop
    //   3149: aload 6
    //   3151: ldc_w 551
    //   3154: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3157: pop
    //   3158: aload 6
    //   3160: iload 5
    //   3162: invokevirtual 443	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3165: pop
    //   3166: ldc 28
    //   3168: iconst_2
    //   3169: aload 6
    //   3171: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3174: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3177: aload_0
    //   3178: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3181: iconst_0
    //   3182: putfield 552	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Boolean	Z
    //   3185: aload_0
    //   3186: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3189: iconst_0
    //   3190: invokestatic 555	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;Z)Z
    //   3193: pop
    //   3194: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3197: astore 8
    //   3199: new 50	java/lang/StringBuilder
    //   3202: dup
    //   3203: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3206: astore 6
    //   3208: aload 6
    //   3210: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3213: getfield 279	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Int	I
    //   3216: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3219: pop
    //   3220: aload 6
    //   3222: ldc_w 434
    //   3225: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3228: pop
    //   3229: aload 6
    //   3231: aload 9
    //   3233: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3236: pop
    //   3237: aload 6
    //   3239: ldc_w 434
    //   3242: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3245: pop
    //   3246: aload 6
    //   3248: aload 10
    //   3250: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3253: pop
    //   3254: aload 6
    //   3256: ldc_w 434
    //   3259: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3262: pop
    //   3263: aload 6
    //   3265: iload_2
    //   3266: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3269: pop
    //   3270: aload 6
    //   3272: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3275: astore 11
    //   3277: aload_0
    //   3278: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3281: getfield 557	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   3284: aload 11
    //   3286: invokeinterface 452 2 0
    //   3291: checkcast 559	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache
    //   3294: astore 7
    //   3296: aload 7
    //   3298: astore 6
    //   3300: aload 7
    //   3302: ifnonnull +29 -> 3331
    //   3305: new 559	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache
    //   3308: dup
    //   3309: invokespecial 560	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:<init>	()V
    //   3312: astore 6
    //   3314: aload_0
    //   3315: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3318: getfield 557	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   3321: aload 11
    //   3323: aload 6
    //   3325: invokeinterface 459 3 0
    //   3330: pop
    //   3331: aload 6
    //   3333: getfield 561	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3336: invokevirtual 466	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3339: ifne +330 -> 3669
    //   3342: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3345: invokevirtual 563	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:e	()Z
    //   3348: ifne +29 -> 3377
    //   3351: aload_0
    //   3352: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3355: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   3358: iconst_2
    //   3359: iconst_1
    //   3360: anewarray 246	java/lang/Object
    //   3363: dup
    //   3364: iconst_0
    //   3365: ldc_w 565
    //   3368: aastore
    //   3369: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   3372: aload_1
    //   3373: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   3376: return
    //   3377: iload 5
    //   3379: ifne +33 -> 3412
    //   3382: aload 8
    //   3384: aload 9
    //   3386: getfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   3389: aload 9
    //   3391: getfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   3394: aload 10
    //   3396: getfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   3399: aload 10
    //   3401: getfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   3404: invokevirtual 568	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(IIII)[Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   3407: astore 7
    //   3409: goto +30 -> 3439
    //   3412: aload 8
    //   3414: aload 9
    //   3416: getfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   3419: aload 9
    //   3421: getfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   3424: aload 10
    //   3426: getfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   3429: aload 10
    //   3431: getfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   3434: invokevirtual 570	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	(IIII)[Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   3437: astore 7
    //   3439: aload 7
    //   3441: iconst_0
    //   3442: aaload
    //   3443: astore 9
    //   3445: aload 7
    //   3447: iconst_1
    //   3448: aaload
    //   3449: astore 7
    //   3451: aload 9
    //   3453: ifnull +2134 -> 5587
    //   3456: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3459: aload 9
    //   3461: invokevirtual 571	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;)Z
    //   3464: istore 5
    //   3466: goto +3 -> 3469
    //   3469: iload 5
    //   3471: ifne +62 -> 3533
    //   3474: aload_0
    //   3475: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3478: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   3481: astore 6
    //   3483: new 50	java/lang/StringBuilder
    //   3486: dup
    //   3487: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3490: astore 7
    //   3492: aload 7
    //   3494: ldc_w 573
    //   3497: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3500: pop
    //   3501: aload 7
    //   3503: ldc_w 575
    //   3506: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3509: pop
    //   3510: aload 6
    //   3512: iconst_2
    //   3513: iconst_1
    //   3514: anewarray 246	java/lang/Object
    //   3517: dup
    //   3518: iconst_0
    //   3519: aload 7
    //   3521: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3524: aastore
    //   3525: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   3528: aload_1
    //   3529: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   3532: return
    //   3533: aload 7
    //   3535: ifnull +11 -> 3546
    //   3538: aload 8
    //   3540: aload 7
    //   3542: invokevirtual 576	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;)Z
    //   3545: pop
    //   3546: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3549: iload_3
    //   3550: invokevirtual 577	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(I)Z
    //   3553: ifne +29 -> 3582
    //   3556: aload_0
    //   3557: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3560: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   3563: iconst_2
    //   3564: iconst_1
    //   3565: anewarray 246	java/lang/Object
    //   3568: dup
    //   3569: iconst_0
    //   3570: ldc_w 579
    //   3573: aastore
    //   3574: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   3577: aload_1
    //   3578: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   3581: return
    //   3582: aload 6
    //   3584: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3587: invokevirtual 581	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()I
    //   3590: putfield 582	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_Int	I
    //   3593: aload 6
    //   3595: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3598: invokevirtual 583	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   3601: putfield 584	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   3604: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3607: invokevirtual 585	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   3610: astore 7
    //   3612: aload 7
    //   3614: ifnull +16 -> 3630
    //   3617: aload 6
    //   3619: aload 7
    //   3621: putfield 586	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   3624: aload 6
    //   3626: iconst_1
    //   3627: putfield 587	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_Boolean	Z
    //   3630: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3633: invokevirtual 590	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()[I
    //   3636: astore 7
    //   3638: aload 6
    //   3640: aload 7
    //   3642: iconst_0
    //   3643: iaload
    //   3644: putfield 591	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_b_of_type_Int	I
    //   3647: aload 6
    //   3649: aload 7
    //   3651: iconst_1
    //   3652: iaload
    //   3653: putfield 593	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_c_of_type_Int	I
    //   3656: aload 6
    //   3658: getfield 561	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3661: iconst_1
    //   3662: invokevirtual 516	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   3665: pop
    //   3666: goto +55 -> 3721
    //   3669: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3672: aload 6
    //   3674: invokevirtual 596	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache;)Z
    //   3677: ifne +29 -> 3706
    //   3680: aload_0
    //   3681: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3684: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   3687: iconst_2
    //   3688: iconst_1
    //   3689: anewarray 246	java/lang/Object
    //   3692: dup
    //   3693: iconst_0
    //   3694: ldc_w 598
    //   3697: aastore
    //   3698: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   3701: aload_1
    //   3702: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   3705: return
    //   3706: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3709: ifeq +12 -> 3721
    //   3712: ldc 28
    //   3714: iconst_2
    //   3715: ldc_w 600
    //   3718: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3721: aload_0
    //   3722: invokevirtual 348	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	()Ljava/lang/String;
    //   3725: astore 6
    //   3727: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3730: aload 6
    //   3732: invokevirtual 325	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Ljava/lang/String;)Z
    //   3735: ifne +49 -> 3784
    //   3738: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3741: ldc 68
    //   3743: invokevirtual 325	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Ljava/lang/String;)Z
    //   3746: ifne +38 -> 3784
    //   3749: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3752: aload_0
    //   3753: invokevirtual 122	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Landroid/hardware/Camera$AutoFocusCallback;)Z
    //   3756: ifne +28 -> 3784
    //   3759: aload_0
    //   3760: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3763: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   3766: bipush 9
    //   3768: iconst_1
    //   3769: anewarray 246	java/lang/Object
    //   3772: dup
    //   3773: iconst_0
    //   3774: ldc_w 601
    //   3777: invokestatic 331	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   3780: aastore
    //   3781: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   3784: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3787: invokevirtual 603	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:c	()Z
    //   3790: ifne +29 -> 3819
    //   3793: aload_0
    //   3794: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3797: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   3800: iconst_2
    //   3801: iconst_1
    //   3802: anewarray 246	java/lang/Object
    //   3805: dup
    //   3806: iconst_0
    //   3807: ldc_w 605
    //   3810: aastore
    //   3811: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   3814: aload_1
    //   3815: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   3818: return
    //   3819: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3822: invokevirtual 590	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()[I
    //   3825: astore 6
    //   3827: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3830: invokevirtual 581	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()I
    //   3833: istore_2
    //   3834: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   3837: invokevirtual 583	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   3840: astore 7
    //   3842: aload_0
    //   3843: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3846: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   3849: iconst_2
    //   3850: iconst_3
    //   3851: anewarray 246	java/lang/Object
    //   3854: dup
    //   3855: iconst_0
    //   3856: aload 7
    //   3858: aastore
    //   3859: dup
    //   3860: iconst_1
    //   3861: iload_2
    //   3862: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3865: aastore
    //   3866: dup
    //   3867: iconst_2
    //   3868: aload 6
    //   3870: aastore
    //   3871: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   3874: goto +1636 -> 5510
    //   3877: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3880: ifeq +12 -> 3892
    //   3883: ldc 28
    //   3885: iconst_2
    //   3886: ldc_w 607
    //   3889: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3892: aload_1
    //   3893: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   3896: invokevirtual 608	java/lang/Object:toString	()Ljava/lang/String;
    //   3899: invokestatic 612	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   3902: istore_2
    //   3903: aload_1
    //   3904: getfield 298	android/os/Message:arg1	I
    //   3907: istore_3
    //   3908: aload_1
    //   3909: getfield 615	android/os/Message:arg2	I
    //   3912: istore 4
    //   3914: aload_0
    //   3915: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3918: iconst_0
    //   3919: putfield 552	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Boolean	Z
    //   3922: aload_0
    //   3923: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   3926: iconst_0
    //   3927: invokestatic 555	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;Z)Z
    //   3930: pop
    //   3931: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3934: ifeq +72 -> 4006
    //   3937: new 50	java/lang/StringBuilder
    //   3940: dup
    //   3941: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   3944: astore 6
    //   3946: aload 6
    //   3948: ldc_w 617
    //   3951: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3954: pop
    //   3955: aload 6
    //   3957: iload_2
    //   3958: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3961: pop
    //   3962: aload 6
    //   3964: ldc_w 619
    //   3967: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3970: pop
    //   3971: aload 6
    //   3973: iload_3
    //   3974: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3977: pop
    //   3978: aload 6
    //   3980: ldc_w 621
    //   3983: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3986: pop
    //   3987: aload 6
    //   3989: iload 4
    //   3991: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3994: pop
    //   3995: ldc 28
    //   3997: iconst_2
    //   3998: aload 6
    //   4000: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4003: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4006: iload_3
    //   4007: istore_2
    //   4008: aload_0
    //   4009: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4012: getfield 622	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_b_of_type_Int	I
    //   4015: ifle +24 -> 4039
    //   4018: iload_3
    //   4019: istore_2
    //   4020: iload_3
    //   4021: aload_0
    //   4022: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4025: getfield 622	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_b_of_type_Int	I
    //   4028: if_icmple +11 -> 4039
    //   4031: aload_0
    //   4032: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4035: getfield 622	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_b_of_type_Int	I
    //   4038: istore_2
    //   4039: iload 4
    //   4041: istore_3
    //   4042: aload_0
    //   4043: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4046: getfield 623	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_c_of_type_Int	I
    //   4049: ifle +26 -> 4075
    //   4052: iload 4
    //   4054: istore_3
    //   4055: iload 4
    //   4057: aload_0
    //   4058: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4061: getfield 623	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_c_of_type_Int	I
    //   4064: if_icmple +11 -> 4075
    //   4067: aload_0
    //   4068: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4071: getfield 623	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_c_of_type_Int	I
    //   4074: istore_3
    //   4075: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4078: astore 10
    //   4080: getstatic 48	android/os/Build$VERSION:SDK_INT	I
    //   4083: bipush 10
    //   4085: if_icmpgt +10 -> 4095
    //   4088: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4091: invokevirtual 260	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	()Z
    //   4094: pop
    //   4095: aload_0
    //   4096: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4099: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4102: iconst_1
    //   4103: if_icmpne +15 -> 4118
    //   4106: aload_0
    //   4107: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4110: getfield 627	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache;
    //   4113: astore 6
    //   4115: goto +248 -> 4363
    //   4118: aload_0
    //   4119: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4122: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4125: iconst_3
    //   4126: if_icmpne +67 -> 4193
    //   4129: getstatic 630	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:jdField_a_of_type_Int	I
    //   4132: iconst_1
    //   4133: if_icmpne +15 -> 4148
    //   4136: aload_0
    //   4137: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4140: getfield 632	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache;
    //   4143: astore 6
    //   4145: goto +218 -> 4363
    //   4148: getstatic 630	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:jdField_a_of_type_Int	I
    //   4151: iconst_2
    //   4152: if_icmpne +15 -> 4167
    //   4155: aload_0
    //   4156: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4159: getfield 634	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache;
    //   4162: astore 6
    //   4164: goto +199 -> 4363
    //   4167: aload_0
    //   4168: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4171: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   4174: iconst_2
    //   4175: iconst_1
    //   4176: anewarray 246	java/lang/Object
    //   4179: dup
    //   4180: iconst_0
    //   4181: ldc_w 636
    //   4184: aastore
    //   4185: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   4188: aload_1
    //   4189: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   4192: return
    //   4193: aload_0
    //   4194: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4197: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4200: iconst_2
    //   4201: if_icmpne +67 -> 4268
    //   4204: getstatic 630	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:jdField_a_of_type_Int	I
    //   4207: iconst_1
    //   4208: if_icmpne +15 -> 4223
    //   4211: aload_0
    //   4212: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4215: getfield 638	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:e	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache;
    //   4218: astore 6
    //   4220: goto +143 -> 4363
    //   4223: getstatic 630	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:jdField_a_of_type_Int	I
    //   4226: iconst_2
    //   4227: if_icmpne +15 -> 4242
    //   4230: aload_0
    //   4231: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4234: getfield 640	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:d	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache;
    //   4237: astore 6
    //   4239: goto +124 -> 4363
    //   4242: aload_0
    //   4243: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4246: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   4249: iconst_2
    //   4250: iconst_1
    //   4251: anewarray 246	java/lang/Object
    //   4254: dup
    //   4255: iconst_0
    //   4256: ldc_w 642
    //   4259: aastore
    //   4260: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   4263: aload_1
    //   4264: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   4267: return
    //   4268: aload_0
    //   4269: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4272: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4275: iconst_4
    //   4276: if_icmpne +67 -> 4343
    //   4279: getstatic 630	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:jdField_a_of_type_Int	I
    //   4282: iconst_1
    //   4283: if_icmpne +15 -> 4298
    //   4286: aload_0
    //   4287: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4290: getfield 645	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:g	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache;
    //   4293: astore 6
    //   4295: goto +68 -> 4363
    //   4298: getstatic 630	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:jdField_a_of_type_Int	I
    //   4301: iconst_2
    //   4302: if_icmpne +15 -> 4317
    //   4305: aload_0
    //   4306: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4309: getfield 647	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:f	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache;
    //   4312: astore 6
    //   4314: goto +49 -> 4363
    //   4317: aload_0
    //   4318: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4321: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   4324: iconst_2
    //   4325: iconst_1
    //   4326: anewarray 246	java/lang/Object
    //   4329: dup
    //   4330: iconst_0
    //   4331: ldc_w 636
    //   4334: aastore
    //   4335: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   4338: aload_1
    //   4339: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   4342: return
    //   4343: aload_0
    //   4344: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4347: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4350: iconst_5
    //   4351: if_icmpne +819 -> 5170
    //   4354: aload_0
    //   4355: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4358: getfield 650	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:h	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache;
    //   4361: astore 6
    //   4363: aload 6
    //   4365: getfield 561	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4368: invokevirtual 466	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   4371: ifne +591 -> 4962
    //   4374: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4377: invokevirtual 563	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:e	()Z
    //   4380: ifne +29 -> 4409
    //   4383: aload_0
    //   4384: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4387: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   4390: iconst_2
    //   4391: iconst_1
    //   4392: anewarray 246	java/lang/Object
    //   4395: dup
    //   4396: iconst_0
    //   4397: ldc_w 565
    //   4400: aastore
    //   4401: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   4404: aload_1
    //   4405: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   4408: return
    //   4409: ldc_w 575
    //   4412: astore 7
    //   4414: aload_0
    //   4415: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4418: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4421: iconst_1
    //   4422: if_icmpeq +171 -> 4593
    //   4425: aload_0
    //   4426: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4429: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4432: iconst_3
    //   4433: if_icmpeq +160 -> 4593
    //   4436: aload_0
    //   4437: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4440: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4443: iconst_4
    //   4444: if_icmpne +6 -> 4450
    //   4447: goto +146 -> 4593
    //   4450: aload_0
    //   4451: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4454: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4457: iconst_2
    //   4458: if_icmpne +40 -> 4498
    //   4461: aload 10
    //   4463: getstatic 655	com/tencent/mobileqq/editor/composite/CodecParam:DST_VIDEO_WIDTH	I
    //   4466: getstatic 658	com/tencent/mobileqq/editor/composite/CodecParam:DST_VIDEO_HEIGHT	I
    //   4469: iload_2
    //   4470: iload_3
    //   4471: invokevirtual 661	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(IIII)Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   4474: astore 9
    //   4476: aload 7
    //   4478: astore 8
    //   4480: aload 9
    //   4482: ifnull +1116 -> 5598
    //   4485: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4488: aload 9
    //   4490: invokevirtual 571	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;)Z
    //   4493: istore 5
    //   4495: goto +1110 -> 5605
    //   4498: aload_0
    //   4499: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4502: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4505: iconst_5
    //   4506: if_icmpne +1087 -> 5593
    //   4509: getstatic 131	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   4512: ldc_w 663
    //   4515: invokevirtual 666	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4518: ifeq +43 -> 4561
    //   4521: getstatic 669	android/os/Build:MODEL	Ljava/lang/String;
    //   4524: ldc_w 671
    //   4527: invokevirtual 666	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4530: ifeq +31 -> 4561
    //   4533: new 430	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize
    //   4536: dup
    //   4537: invokespecial 672	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:<init>	()V
    //   4540: astore 9
    //   4542: aload 9
    //   4544: sipush 640
    //   4547: putfield 470	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_a_of_type_Int	I
    //   4550: aload 9
    //   4552: sipush 480
    //   4555: putfield 472	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize:jdField_b_of_type_Int	I
    //   4558: goto +13 -> 4571
    //   4561: aload 10
    //   4563: sipush 480
    //   4566: invokevirtual 675	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(I)Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   4569: astore 9
    //   4571: aload 7
    //   4573: astore 8
    //   4575: aload 9
    //   4577: ifnull +1021 -> 5598
    //   4580: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4583: aload 9
    //   4585: invokevirtual 571	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;)Z
    //   4588: istore 5
    //   4590: goto +1015 -> 5605
    //   4593: aload 10
    //   4595: getstatic 655	com/tencent/mobileqq/editor/composite/CodecParam:DST_VIDEO_WIDTH	I
    //   4598: getstatic 658	com/tencent/mobileqq/editor/composite/CodecParam:DST_VIDEO_HEIGHT	I
    //   4601: aload_0
    //   4602: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4605: getfield 622	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_b_of_type_Int	I
    //   4608: aload_0
    //   4609: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4612: getfield 623	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_c_of_type_Int	I
    //   4615: invokevirtual 677	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:c	(IIII)[Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   4618: astore 8
    //   4620: aload 8
    //   4622: iconst_0
    //   4623: aaload
    //   4624: astore 9
    //   4626: aload 8
    //   4628: iconst_1
    //   4629: aaload
    //   4630: astore 8
    //   4632: aload 9
    //   4634: ifnull +977 -> 5611
    //   4637: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4640: aload 9
    //   4642: invokevirtual 571	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;)Z
    //   4645: istore 5
    //   4647: goto +967 -> 5614
    //   4650: iload 5
    //   4652: ifne +61 -> 4713
    //   4655: aload_0
    //   4656: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4659: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   4662: astore 6
    //   4664: new 50	java/lang/StringBuilder
    //   4667: dup
    //   4668: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   4671: astore 8
    //   4673: aload 8
    //   4675: ldc_w 573
    //   4678: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4681: pop
    //   4682: aload 8
    //   4684: aload 7
    //   4686: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4689: pop
    //   4690: aload 6
    //   4692: iconst_2
    //   4693: iconst_1
    //   4694: anewarray 246	java/lang/Object
    //   4697: dup
    //   4698: iconst_0
    //   4699: aload 8
    //   4701: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4704: aastore
    //   4705: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   4708: aload_1
    //   4709: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   4712: return
    //   4713: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4716: getstatic 680	com/tencent/mobileqq/editor/composite/CodecParam:VIDEO_FPS	I
    //   4719: invokevirtual 577	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(I)Z
    //   4722: ifne +29 -> 4751
    //   4725: aload_0
    //   4726: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4729: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   4732: iconst_2
    //   4733: iconst_1
    //   4734: anewarray 246	java/lang/Object
    //   4737: dup
    //   4738: iconst_0
    //   4739: ldc_w 579
    //   4742: aastore
    //   4743: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   4746: aload_1
    //   4747: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   4750: return
    //   4751: aload_0
    //   4752: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4755: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4758: iconst_1
    //   4759: if_icmpeq +38 -> 4797
    //   4762: aload_0
    //   4763: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4766: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4769: iconst_4
    //   4770: if_icmpeq +27 -> 4797
    //   4773: aload_0
    //   4774: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4777: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4780: iconst_5
    //   4781: if_icmpeq +16 -> 4797
    //   4784: aload 8
    //   4786: ifnull +11 -> 4797
    //   4789: aload 10
    //   4791: aload 8
    //   4793: invokevirtual 576	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;)Z
    //   4796: pop
    //   4797: aload 6
    //   4799: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4802: invokevirtual 581	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()I
    //   4805: putfield 582	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_Int	I
    //   4808: aload 6
    //   4810: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4813: invokevirtual 583	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   4816: putfield 584	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   4819: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4822: invokevirtual 585	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   4825: astore 7
    //   4827: aload 7
    //   4829: ifnull +16 -> 4845
    //   4832: aload 6
    //   4834: aload 7
    //   4836: putfield 586	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   4839: aload 6
    //   4841: iconst_1
    //   4842: putfield 587	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_Boolean	Z
    //   4845: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4848: invokevirtual 590	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()[I
    //   4851: astore 7
    //   4853: aload 6
    //   4855: aload 7
    //   4857: iconst_0
    //   4858: iaload
    //   4859: putfield 591	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_b_of_type_Int	I
    //   4862: aload 6
    //   4864: aload 7
    //   4866: iconst_1
    //   4867: iaload
    //   4868: putfield 593	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_c_of_type_Int	I
    //   4871: aload_0
    //   4872: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4875: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4878: iconst_1
    //   4879: if_icmpeq +53 -> 4932
    //   4882: aload_0
    //   4883: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4886: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4889: iconst_3
    //   4890: if_icmpeq +42 -> 4932
    //   4893: aload_0
    //   4894: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4897: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4900: iconst_4
    //   4901: if_icmpeq +31 -> 4932
    //   4904: aload_0
    //   4905: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4908: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4911: iconst_5
    //   4912: if_icmpeq +20 -> 4932
    //   4915: aload 6
    //   4917: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4920: invokevirtual 585	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   4923: putfield 586	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   4926: aload 6
    //   4928: iconst_1
    //   4929: putfield 587	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_Boolean	Z
    //   4932: aload_0
    //   4933: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4936: getfield 624	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Int	I
    //   4939: iconst_4
    //   4940: if_icmpne +9 -> 4949
    //   4943: aload 6
    //   4945: iconst_0
    //   4946: putfield 587	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_Boolean	Z
    //   4949: aload 6
    //   4951: getfield 561	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4954: iconst_1
    //   4955: invokevirtual 516	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   4958: pop
    //   4959: goto +55 -> 5014
    //   4962: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   4965: aload 6
    //   4967: invokevirtual 596	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$ParamCache;)Z
    //   4970: ifne +29 -> 4999
    //   4973: aload_0
    //   4974: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   4977: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   4980: iconst_2
    //   4981: iconst_1
    //   4982: anewarray 246	java/lang/Object
    //   4985: dup
    //   4986: iconst_0
    //   4987: ldc_w 598
    //   4990: aastore
    //   4991: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   4994: aload_1
    //   4995: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   4998: return
    //   4999: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5002: ifeq +12 -> 5014
    //   5005: ldc 28
    //   5007: iconst_2
    //   5008: ldc_w 682
    //   5011: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5014: aload_0
    //   5015: invokevirtual 348	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	()Ljava/lang/String;
    //   5018: astore 6
    //   5020: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   5023: aload 6
    //   5025: invokevirtual 325	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Ljava/lang/String;)Z
    //   5028: ifne +49 -> 5077
    //   5031: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   5034: ldc 68
    //   5036: invokevirtual 325	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Ljava/lang/String;)Z
    //   5039: ifne +38 -> 5077
    //   5042: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   5045: aload_0
    //   5046: invokevirtual 122	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Landroid/hardware/Camera$AutoFocusCallback;)Z
    //   5049: ifne +28 -> 5077
    //   5052: aload_0
    //   5053: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5056: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   5059: bipush 9
    //   5061: iconst_1
    //   5062: anewarray 246	java/lang/Object
    //   5065: dup
    //   5066: iconst_0
    //   5067: ldc_w 683
    //   5070: invokestatic 331	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   5073: aastore
    //   5074: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   5077: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   5080: invokevirtual 603	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:c	()Z
    //   5083: ifne +29 -> 5112
    //   5086: aload_0
    //   5087: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5090: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   5093: iconst_2
    //   5094: iconst_1
    //   5095: anewarray 246	java/lang/Object
    //   5098: dup
    //   5099: iconst_0
    //   5100: ldc_w 605
    //   5103: aastore
    //   5104: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   5107: aload_1
    //   5108: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   5111: return
    //   5112: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   5115: invokevirtual 590	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()[I
    //   5118: astore 6
    //   5120: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   5123: invokevirtual 581	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()I
    //   5126: istore_2
    //   5127: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   5130: invokevirtual 583	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$CustomSize;
    //   5133: astore 7
    //   5135: aload_0
    //   5136: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5139: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   5142: iconst_2
    //   5143: iconst_3
    //   5144: anewarray 246	java/lang/Object
    //   5147: dup
    //   5148: iconst_0
    //   5149: aload 7
    //   5151: aastore
    //   5152: dup
    //   5153: iconst_1
    //   5154: iload_2
    //   5155: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5158: aastore
    //   5159: dup
    //   5160: iconst_2
    //   5161: aload 6
    //   5163: aastore
    //   5164: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   5167: goto +343 -> 5510
    //   5170: aload_0
    //   5171: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5174: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   5177: iconst_2
    //   5178: iconst_1
    //   5179: anewarray 246	java/lang/Object
    //   5182: dup
    //   5183: iconst_0
    //   5184: ldc_w 685
    //   5187: aastore
    //   5188: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   5191: aload_1
    //   5192: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   5195: return
    //   5196: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5199: ifeq +12 -> 5211
    //   5202: ldc 28
    //   5204: iconst_2
    //   5205: ldc_w 687
    //   5208: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5211: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   5214: invokevirtual 688	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	()V
    //   5217: aload_0
    //   5218: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5221: iconst_1
    //   5222: putfield 552	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Boolean	Z
    //   5225: ldc2_w 689
    //   5228: invokestatic 696	java/lang/Thread:sleep	(J)V
    //   5231: ldc 28
    //   5233: ldc_w 698
    //   5236: invokestatic 200	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5239: aload_0
    //   5240: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5243: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   5246: bipush 11
    //   5248: iconst_1
    //   5249: anewarray 246	java/lang/Object
    //   5252: dup
    //   5253: iconst_0
    //   5254: ldc_w 700
    //   5257: aastore
    //   5258: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   5261: goto +249 -> 5510
    //   5264: ldc 28
    //   5266: ldc_w 702
    //   5269: invokestatic 200	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5272: aload_1
    //   5273: getfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   5276: checkcast 202	[Ljava/lang/Object;
    //   5279: checkcast 202	[Ljava/lang/Object;
    //   5282: iconst_0
    //   5283: aaload
    //   5284: checkcast 213	java/lang/Integer
    //   5287: invokevirtual 216	java/lang/Integer:intValue	()I
    //   5290: istore_2
    //   5291: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5294: ifeq +12 -> 5306
    //   5297: ldc 28
    //   5299: iconst_2
    //   5300: ldc_w 704
    //   5303: invokestatic 34	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5306: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   5309: iload_2
    //   5310: invokevirtual 707	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(I)I
    //   5313: istore_2
    //   5314: new 50	java/lang/StringBuilder
    //   5317: dup
    //   5318: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   5321: astore 6
    //   5323: aload 6
    //   5325: ldc_w 709
    //   5328: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5331: pop
    //   5332: aload 6
    //   5334: iload_2
    //   5335: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5338: pop
    //   5339: ldc 28
    //   5341: aload 6
    //   5343: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5346: invokestatic 200	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5349: iload_2
    //   5350: iconst_5
    //   5351: if_icmpne +30 -> 5381
    //   5354: aload_0
    //   5355: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5358: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   5361: iconst_1
    //   5362: iconst_1
    //   5363: anewarray 246	java/lang/Object
    //   5366: dup
    //   5367: iconst_0
    //   5368: iconst_1
    //   5369: invokestatic 712	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5372: aastore
    //   5373: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   5376: aload_1
    //   5377: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   5380: return
    //   5381: iload_2
    //   5382: ifeq +63 -> 5445
    //   5385: aload_0
    //   5386: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5389: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   5392: astore 6
    //   5394: new 50	java/lang/StringBuilder
    //   5397: dup
    //   5398: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   5401: astore 7
    //   5403: aload 7
    //   5405: ldc_w 714
    //   5408: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5411: pop
    //   5412: aload 7
    //   5414: iload_2
    //   5415: invokestatic 715	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(I)Ljava/lang/String;
    //   5418: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5421: pop
    //   5422: aload 6
    //   5424: iconst_1
    //   5425: iconst_1
    //   5426: anewarray 246	java/lang/Object
    //   5429: dup
    //   5430: iconst_0
    //   5431: aload 7
    //   5433: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5436: aastore
    //   5437: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   5440: aload_1
    //   5441: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   5444: return
    //   5445: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   5448: invokevirtual 603	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:c	()Z
    //   5451: ifne +29 -> 5480
    //   5454: aload_0
    //   5455: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5458: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   5461: iconst_1
    //   5462: iconst_1
    //   5463: anewarray 246	java/lang/Object
    //   5466: dup
    //   5467: iconst_0
    //   5468: ldc_w 717
    //   5471: aastore
    //   5472: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   5475: aload_1
    //   5476: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   5479: return
    //   5480: aload_0
    //   5481: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5484: getfield 244	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable;
    //   5487: iconst_1
    //   5488: iconst_1
    //   5489: anewarray 246	java/lang/Object
    //   5492: dup
    //   5493: iconst_0
    //   5494: iconst_1
    //   5495: invokestatic 712	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5498: aastore
    //   5499: invokevirtual 255	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$CameraPreviewObservable:a	(I[Ljava/lang/Object;)V
    //   5502: aload_0
    //   5503: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   5506: iconst_0
    //   5507: putfield 552	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_Boolean	Z
    //   5510: aload_1
    //   5511: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   5514: return
    //   5515: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5518: ifeq -8 -> 5510
    //   5521: ldc 28
    //   5523: iconst_2
    //   5524: ldc_w 719
    //   5527: aload 6
    //   5529: invokestatic 722	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5532: goto -22 -> 5510
    //   5535: aload_1
    //   5536: invokestatic 231	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$WaitDoneBundle:a	(Landroid/os/Message;)V
    //   5539: goto +6 -> 5545
    //   5542: aload 6
    //   5544: athrow
    //   5545: goto -3 -> 5542
    //   5548: astore 6
    //   5550: goto -319 -> 5231
    //   5553: astore 6
    //   5555: goto -20 -> 5535
    //   5558: astore 6
    //   5560: goto -45 -> 5515
    //   5563: aconst_null
    //   5564: astore 6
    //   5566: goto -5119 -> 447
    //   5569: iconst_0
    //   5570: istore 5
    //   5572: goto -4686 -> 886
    //   5575: goto -65 -> 5510
    //   5578: aconst_null
    //   5579: astore 7
    //   5581: aconst_null
    //   5582: astore 8
    //   5584: goto -3042 -> 2542
    //   5587: iconst_0
    //   5588: istore 5
    //   5590: goto -2121 -> 3469
    //   5593: ldc_w 724
    //   5596: astore 8
    //   5598: iconst_0
    //   5599: istore 5
    //   5601: aload 8
    //   5603: astore 7
    //   5605: aconst_null
    //   5606: astore 8
    //   5608: goto -958 -> 4650
    //   5611: iconst_0
    //   5612: istore 5
    //   5614: goto -964 -> 4650
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5617	0	this	Camera2Handler
    //   0	5617	1	paramMessage	android.os.Message
    //   9	5406	2	i	int
    //   3071	1400	3	j	int
    //   3912	153	4	k	int
    //   631	4982	5	bool	boolean
    //   259	5284	6	localObject1	Object
    //   5548	1	6	localInterruptedException	java.lang.InterruptedException
    //   5553	1	6	localObject2	Object
    //   5558	1	6	localException	java.lang.Exception
    //   5564	1	6	localObject3	Object
    //   730	4874	7	localObject4	Object
    //   2217	3390	8	localObject5	Object
    //   2208	2433	9	localObject6	Object
    //   2226	2564	10	localObject7	Object
    //   2301	1021	11	str	String
    // Exception table:
    //   from	to	target	type
    //   5225	5231	5548	java/lang/InterruptedException
    //   252	292	5553	finally
    //   292	306	5553	finally
    //   306	312	5553	finally
    //   315	321	5553	finally
    //   324	341	5553	finally
    //   344	357	5553	finally
    //   360	392	5553	finally
    //   395	444	5553	finally
    //   447	462	5553	finally
    //   467	477	5553	finally
    //   481	538	5553	finally
    //   541	556	5553	finally
    //   556	594	5553	finally
    //   597	625	5553	finally
    //   628	633	5553	finally
    //   638	647	5553	finally
    //   647	671	5553	finally
    //   671	700	5553	finally
    //   703	763	5553	finally
    //   763	846	5553	finally
    //   849	864	5553	finally
    //   864	880	5553	finally
    //   886	920	5553	finally
    //   923	938	5553	finally
    //   938	979	5553	finally
    //   982	997	5553	finally
    //   997	1038	5553	finally
    //   1041	1056	5553	finally
    //   1056	1098	5553	finally
    //   1101	1129	5553	finally
    //   1132	1147	5553	finally
    //   1147	1183	5553	finally
    //   1186	1201	5553	finally
    //   1201	1264	5553	finally
    //   1267	1312	5553	finally
    //   1312	1389	5553	finally
    //   1389	1415	5553	finally
    //   1418	1431	5553	finally
    //   1434	1479	5553	finally
    //   1479	1494	5553	finally
    //   1497	1512	5553	finally
    //   1515	1530	5553	finally
    //   1530	1570	5553	finally
    //   1573	1613	5553	finally
    //   1616	1631	5553	finally
    //   1631	1669	5553	finally
    //   1672	1712	5553	finally
    //   1715	1755	5553	finally
    //   1758	1838	5553	finally
    //   1876	1929	5553	finally
    //   1932	1955	5553	finally
    //   1958	1983	5553	finally
    //   1986	2014	5553	finally
    //   2017	2043	5553	finally
    //   2046	2061	5553	finally
    //   2061	2067	5553	finally
    //   2070	2085	5553	finally
    //   2085	2123	5553	finally
    //   2128	2195	5553	finally
    //   2198	2380	5553	finally
    //   2380	2399	5553	finally
    //   2408	2434	5553	finally
    //   2434	2453	5553	finally
    //   2458	2485	5553	finally
    //   2488	2515	5553	finally
    //   2520	2527	5553	finally
    //   2542	2620	5553	finally
    //   2625	2658	5553	finally
    //   2663	2704	5553	finally
    //   2709	2740	5553	finally
    //   2743	2776	5553	finally
    //   2781	2823	5553	finally
    //   2826	2852	5553	finally
    //   2855	2882	5553	finally
    //   2885	2900	5553	finally
    //   2900	2943	5553	finally
    //   2948	2977	5553	finally
    //   2982	3017	5553	finally
    //   3020	3177	5553	finally
    //   3177	3296	5553	finally
    //   3305	3331	5553	finally
    //   3331	3372	5553	finally
    //   3382	3409	5553	finally
    //   3412	3439	5553	finally
    //   3456	3466	5553	finally
    //   3474	3528	5553	finally
    //   3538	3546	5553	finally
    //   3546	3577	5553	finally
    //   3582	3612	5553	finally
    //   3617	3630	5553	finally
    //   3630	3666	5553	finally
    //   3669	3701	5553	finally
    //   3706	3721	5553	finally
    //   3721	3784	5553	finally
    //   3784	3814	5553	finally
    //   3819	3874	5553	finally
    //   3877	3892	5553	finally
    //   3892	4006	5553	finally
    //   4008	4018	5553	finally
    //   4020	4039	5553	finally
    //   4042	4052	5553	finally
    //   4055	4075	5553	finally
    //   4075	4095	5553	finally
    //   4095	4115	5553	finally
    //   4118	4145	5553	finally
    //   4148	4164	5553	finally
    //   4167	4188	5553	finally
    //   4193	4220	5553	finally
    //   4223	4239	5553	finally
    //   4242	4263	5553	finally
    //   4268	4295	5553	finally
    //   4298	4314	5553	finally
    //   4317	4338	5553	finally
    //   4343	4363	5553	finally
    //   4363	4404	5553	finally
    //   4414	4447	5553	finally
    //   4450	4476	5553	finally
    //   4485	4495	5553	finally
    //   4498	4558	5553	finally
    //   4561	4571	5553	finally
    //   4580	4590	5553	finally
    //   4593	4620	5553	finally
    //   4637	4647	5553	finally
    //   4655	4708	5553	finally
    //   4713	4746	5553	finally
    //   4751	4784	5553	finally
    //   4789	4797	5553	finally
    //   4797	4827	5553	finally
    //   4832	4845	5553	finally
    //   4845	4932	5553	finally
    //   4932	4949	5553	finally
    //   4949	4959	5553	finally
    //   4962	4994	5553	finally
    //   4999	5014	5553	finally
    //   5014	5077	5553	finally
    //   5077	5107	5553	finally
    //   5112	5167	5553	finally
    //   5170	5191	5553	finally
    //   5196	5211	5553	finally
    //   5211	5225	5553	finally
    //   5225	5231	5553	finally
    //   5231	5261	5553	finally
    //   5264	5306	5553	finally
    //   5306	5349	5553	finally
    //   5354	5376	5553	finally
    //   5385	5440	5553	finally
    //   5445	5475	5553	finally
    //   5480	5510	5553	finally
    //   5515	5532	5553	finally
    //   252	292	5558	java/lang/Exception
    //   292	306	5558	java/lang/Exception
    //   306	312	5558	java/lang/Exception
    //   315	321	5558	java/lang/Exception
    //   324	341	5558	java/lang/Exception
    //   344	357	5558	java/lang/Exception
    //   360	392	5558	java/lang/Exception
    //   395	444	5558	java/lang/Exception
    //   447	462	5558	java/lang/Exception
    //   467	477	5558	java/lang/Exception
    //   481	538	5558	java/lang/Exception
    //   541	556	5558	java/lang/Exception
    //   556	594	5558	java/lang/Exception
    //   597	625	5558	java/lang/Exception
    //   628	633	5558	java/lang/Exception
    //   638	647	5558	java/lang/Exception
    //   647	671	5558	java/lang/Exception
    //   671	700	5558	java/lang/Exception
    //   703	763	5558	java/lang/Exception
    //   763	846	5558	java/lang/Exception
    //   849	864	5558	java/lang/Exception
    //   864	880	5558	java/lang/Exception
    //   886	920	5558	java/lang/Exception
    //   923	938	5558	java/lang/Exception
    //   938	979	5558	java/lang/Exception
    //   982	997	5558	java/lang/Exception
    //   997	1038	5558	java/lang/Exception
    //   1041	1056	5558	java/lang/Exception
    //   1056	1098	5558	java/lang/Exception
    //   1101	1129	5558	java/lang/Exception
    //   1132	1147	5558	java/lang/Exception
    //   1147	1183	5558	java/lang/Exception
    //   1186	1201	5558	java/lang/Exception
    //   1201	1264	5558	java/lang/Exception
    //   1267	1312	5558	java/lang/Exception
    //   1312	1389	5558	java/lang/Exception
    //   1389	1415	5558	java/lang/Exception
    //   1418	1431	5558	java/lang/Exception
    //   1434	1479	5558	java/lang/Exception
    //   1479	1494	5558	java/lang/Exception
    //   1497	1512	5558	java/lang/Exception
    //   1515	1530	5558	java/lang/Exception
    //   1530	1570	5558	java/lang/Exception
    //   1573	1613	5558	java/lang/Exception
    //   1616	1631	5558	java/lang/Exception
    //   1631	1669	5558	java/lang/Exception
    //   1672	1712	5558	java/lang/Exception
    //   1715	1755	5558	java/lang/Exception
    //   1758	1838	5558	java/lang/Exception
    //   1876	1929	5558	java/lang/Exception
    //   1932	1955	5558	java/lang/Exception
    //   1958	1983	5558	java/lang/Exception
    //   1986	2014	5558	java/lang/Exception
    //   2017	2043	5558	java/lang/Exception
    //   2046	2061	5558	java/lang/Exception
    //   2061	2067	5558	java/lang/Exception
    //   2070	2085	5558	java/lang/Exception
    //   2085	2123	5558	java/lang/Exception
    //   2128	2195	5558	java/lang/Exception
    //   2198	2380	5558	java/lang/Exception
    //   2380	2399	5558	java/lang/Exception
    //   2408	2434	5558	java/lang/Exception
    //   2434	2453	5558	java/lang/Exception
    //   2458	2485	5558	java/lang/Exception
    //   2488	2515	5558	java/lang/Exception
    //   2520	2527	5558	java/lang/Exception
    //   2542	2620	5558	java/lang/Exception
    //   2625	2658	5558	java/lang/Exception
    //   2663	2704	5558	java/lang/Exception
    //   2709	2740	5558	java/lang/Exception
    //   2743	2776	5558	java/lang/Exception
    //   2781	2823	5558	java/lang/Exception
    //   2826	2852	5558	java/lang/Exception
    //   2855	2882	5558	java/lang/Exception
    //   2885	2900	5558	java/lang/Exception
    //   2900	2943	5558	java/lang/Exception
    //   2948	2977	5558	java/lang/Exception
    //   2982	3017	5558	java/lang/Exception
    //   3020	3177	5558	java/lang/Exception
    //   3177	3296	5558	java/lang/Exception
    //   3305	3331	5558	java/lang/Exception
    //   3331	3372	5558	java/lang/Exception
    //   3382	3409	5558	java/lang/Exception
    //   3412	3439	5558	java/lang/Exception
    //   3456	3466	5558	java/lang/Exception
    //   3474	3528	5558	java/lang/Exception
    //   3538	3546	5558	java/lang/Exception
    //   3546	3577	5558	java/lang/Exception
    //   3582	3612	5558	java/lang/Exception
    //   3617	3630	5558	java/lang/Exception
    //   3630	3666	5558	java/lang/Exception
    //   3669	3701	5558	java/lang/Exception
    //   3706	3721	5558	java/lang/Exception
    //   3721	3784	5558	java/lang/Exception
    //   3784	3814	5558	java/lang/Exception
    //   3819	3874	5558	java/lang/Exception
    //   3877	3892	5558	java/lang/Exception
    //   3892	4006	5558	java/lang/Exception
    //   4008	4018	5558	java/lang/Exception
    //   4020	4039	5558	java/lang/Exception
    //   4042	4052	5558	java/lang/Exception
    //   4055	4075	5558	java/lang/Exception
    //   4075	4095	5558	java/lang/Exception
    //   4095	4115	5558	java/lang/Exception
    //   4118	4145	5558	java/lang/Exception
    //   4148	4164	5558	java/lang/Exception
    //   4167	4188	5558	java/lang/Exception
    //   4193	4220	5558	java/lang/Exception
    //   4223	4239	5558	java/lang/Exception
    //   4242	4263	5558	java/lang/Exception
    //   4268	4295	5558	java/lang/Exception
    //   4298	4314	5558	java/lang/Exception
    //   4317	4338	5558	java/lang/Exception
    //   4343	4363	5558	java/lang/Exception
    //   4363	4404	5558	java/lang/Exception
    //   4414	4447	5558	java/lang/Exception
    //   4450	4476	5558	java/lang/Exception
    //   4485	4495	5558	java/lang/Exception
    //   4498	4558	5558	java/lang/Exception
    //   4561	4571	5558	java/lang/Exception
    //   4580	4590	5558	java/lang/Exception
    //   4593	4620	5558	java/lang/Exception
    //   4637	4647	5558	java/lang/Exception
    //   4655	4708	5558	java/lang/Exception
    //   4713	4746	5558	java/lang/Exception
    //   4751	4784	5558	java/lang/Exception
    //   4789	4797	5558	java/lang/Exception
    //   4797	4827	5558	java/lang/Exception
    //   4832	4845	5558	java/lang/Exception
    //   4845	4932	5558	java/lang/Exception
    //   4932	4949	5558	java/lang/Exception
    //   4949	4959	5558	java/lang/Exception
    //   4962	4994	5558	java/lang/Exception
    //   4999	5014	5558	java/lang/Exception
    //   5014	5077	5558	java/lang/Exception
    //   5077	5107	5558	java/lang/Exception
    //   5112	5167	5558	java/lang/Exception
    //   5170	5191	5558	java/lang/Exception
    //   5196	5211	5558	java/lang/Exception
    //   5211	5225	5558	java/lang/Exception
    //   5225	5231	5558	java/lang/Exception
    //   5231	5261	5558	java/lang/Exception
    //   5264	5306	5558	java/lang/Exception
    //   5306	5349	5558	java/lang/Exception
    //   5354	5376	5558	java/lang/Exception
    //   5385	5440	5558	java/lang/Exception
    //   5445	5475	5558	java/lang/Exception
    //   5480	5510	5558	java/lang/Exception
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel())
    {
      paramCamera = new StringBuilder();
      paramCamera.append("[onAutoFocus]success ");
      paramCamera.append(paramBoolean);
      QLog.i("CameraProxy", 2, paramCamera.toString());
    }
    paramCamera = a();
    CameraControl.a().a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.Camera2Handler
 * JD-Core Version:    0.7.0.1
 */