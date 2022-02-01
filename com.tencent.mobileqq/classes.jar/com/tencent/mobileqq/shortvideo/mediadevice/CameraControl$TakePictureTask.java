package com.tencent.mobileqq.shortvideo.mediadevice;

import android.hardware.Camera;
import android.os.AsyncTask;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class CameraControl$TakePictureTask
  extends AsyncTask<Void, Void, String>
{
  CameraControl.TakePictureData jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData;
  
  public CameraControl$TakePictureTask(CameraControl paramCameraControl, CameraControl.TakePictureData paramTakePictureData)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData = paramTakePictureData;
    LogTag.a();
  }
  
  /* Error */
  private String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   4: getfield 32	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_ArrayOfByte	[B
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   13: getfield 35	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   16: astore 5
    //   18: invokestatic 21	com/tencent/mobileqq/utils/LogTag:a	()V
    //   21: aconst_null
    //   22: astore 4
    //   24: aload 5
    //   26: ifnonnull +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: aload 6
    //   33: ifnull +453 -> 486
    //   36: aload_0
    //   37: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   40: getfield 40	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_ComTencentMobileqqCameraCameraHolder	Lcom/tencent/mobileqq/camera/CameraHolder;
    //   43: aload_0
    //   44: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   47: getfield 43	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_Int	I
    //   50: aload_0
    //   51: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   54: getfield 44	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_Int	I
    //   57: invokestatic 49	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Lcom/tencent/mobileqq/camera/CameraHolder;II)I
    //   60: istore_1
    //   61: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +91 -> 155
    //   67: getstatic 59	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	Ljava/lang/String;
    //   70: astore 7
    //   72: new 61	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   79: astore 8
    //   81: aload 8
    //   83: ldc 64
    //   85: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 8
    //   91: aload_0
    //   92: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   95: getfield 71	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_Boolean	Z
    //   98: invokevirtual 74	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 8
    //   104: ldc 76
    //   106: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 8
    //   112: aload_0
    //   113: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   116: getfield 40	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_ComTencentMobileqqCameraCameraHolder	Lcom/tencent/mobileqq/camera/CameraHolder;
    //   119: invokevirtual 81	com/tencent/mobileqq/camera/CameraHolder:a	()Lcom/tencent/mobileqq/camera/adapter/CameraWrapper;
    //   122: invokevirtual 85	com/tencent/mobileqq/camera/adapter/CameraWrapper:b	()Z
    //   125: invokevirtual 74	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 8
    //   131: ldc 87
    //   133: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 8
    //   139: iload_1
    //   140: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 7
    //   146: iconst_2
    //   147: aload 8
    //   149: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   159: aload_0
    //   160: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   163: getfield 100	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_AndroidHardwareCamera$Size	Landroid/hardware/Camera$Size;
    //   166: getfield 105	android/hardware/Camera$Size:width	I
    //   169: aload_0
    //   170: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   173: getfield 100	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_AndroidHardwareCamera$Size	Landroid/hardware/Camera$Size;
    //   176: getfield 108	android/hardware/Camera$Size:height	I
    //   179: aload_0
    //   180: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   183: getfield 111	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   186: invokevirtual 116	android/graphics/Rect:width	()I
    //   189: aload_0
    //   190: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   193: getfield 111	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   196: invokevirtual 118	android/graphics/Rect:height	()I
    //   199: invokestatic 121	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;IIII)Z
    //   202: istore_3
    //   203: aload_0
    //   204: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   207: getfield 71	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_Boolean	Z
    //   210: ifeq +302 -> 512
    //   213: aload_0
    //   214: getfield 12	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   217: getfield 40	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:jdField_a_of_type_ComTencentMobileqqCameraCameraHolder	Lcom/tencent/mobileqq/camera/CameraHolder;
    //   220: invokevirtual 81	com/tencent/mobileqq/camera/CameraHolder:a	()Lcom/tencent/mobileqq/camera/adapter/CameraWrapper;
    //   223: invokevirtual 85	com/tencent/mobileqq/camera/adapter/CameraWrapper:b	()Z
    //   226: ifne +286 -> 512
    //   229: iconst_1
    //   230: istore_2
    //   231: goto +3 -> 234
    //   234: aload 6
    //   236: aload_0
    //   237: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   240: getfield 111	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   243: iload_2
    //   244: iload_1
    //   245: invokestatic 124	com/tencent/mobileqq/camera/utils/CameraUtils:b	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   248: astore 6
    //   250: ldc 126
    //   252: invokestatic 131	com/tencent/mobileqq/activity/richmedia/NewFlowCameraReporter:a	(Ljava/lang/String;)V
    //   255: aload 6
    //   257: aload_0
    //   258: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   261: getfield 134	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:c	I
    //   264: aload 5
    //   266: invokestatic 139	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   269: pop
    //   270: iconst_0
    //   271: aload_0
    //   272: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   275: getfield 100	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_AndroidHardwareCamera$Size	Landroid/hardware/Camera$Size;
    //   278: getfield 105	android/hardware/Camera$Size:width	I
    //   281: aload_0
    //   282: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   285: getfield 100	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_AndroidHardwareCamera$Size	Landroid/hardware/Camera$Size;
    //   288: getfield 108	android/hardware/Camera$Size:height	I
    //   291: aload_0
    //   292: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   295: getfield 111	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   298: invokevirtual 116	android/graphics/Rect:width	()I
    //   301: aload_0
    //   302: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   305: getfield 111	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   308: invokevirtual 118	android/graphics/Rect:height	()I
    //   311: iload_3
    //   312: iload_1
    //   313: iload_2
    //   314: invokestatic 142	com/tencent/mobileqq/activity/richmedia/NewFlowCameraReporter:a	(ZIIIIZIZ)V
    //   317: ldc 144
    //   319: invokestatic 131	com/tencent/mobileqq/activity/richmedia/NewFlowCameraReporter:a	(Ljava/lang/String;)V
    //   322: goto +97 -> 419
    //   325: astore 4
    //   327: goto +156 -> 483
    //   330: astore 6
    //   332: aload 6
    //   334: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   337: aconst_null
    //   338: invokestatic 150	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   341: pop
    //   342: goto +77 -> 419
    //   345: astore 6
    //   347: getstatic 59	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	Ljava/lang/String;
    //   350: astore 7
    //   352: new 61	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   359: astore 8
    //   361: aload 8
    //   363: ldc 152
    //   365: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 8
    //   371: aload_0
    //   372: getfield 17	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   375: getfield 44	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:jdField_a_of_type_Int	I
    //   378: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 8
    //   384: ldc 154
    //   386: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 8
    //   392: aload 6
    //   394: invokevirtual 157	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 7
    //   403: iconst_2
    //   404: aload 8
    //   406: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: aload 6
    //   411: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   414: aconst_null
    //   415: invokestatic 150	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   418: pop
    //   419: aload 5
    //   421: invokevirtual 166	java/io/File:exists	()Z
    //   424: ifeq +51 -> 475
    //   427: getstatic 171	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   430: astore 6
    //   432: new 61	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   439: astore 7
    //   441: aload 7
    //   443: aload 5
    //   445: invokevirtual 174	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   448: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload 7
    //   454: ldc 176
    //   456: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 6
    //   462: aload 7
    //   464: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: aconst_null
    //   468: invokevirtual 182	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: goto +14 -> 486
    //   475: aconst_null
    //   476: invokestatic 150	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   479: pop
    //   480: goto +6 -> 486
    //   483: aload 4
    //   485: athrow
    //   486: getstatic 59	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	Ljava/lang/String;
    //   489: ldc 184
    //   491: invokestatic 187	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload 5
    //   496: invokevirtual 166	java/io/File:exists	()Z
    //   499: ifeq +10 -> 509
    //   502: aload 5
    //   504: invokevirtual 174	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   507: astore 4
    //   509: aload 4
    //   511: areturn
    //   512: iconst_0
    //   513: istore_2
    //   514: goto -280 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	TakePictureTask
    //   60	253	1	i	int
    //   230	284	2	bool1	boolean
    //   202	110	3	bool2	boolean
    //   22	1	4	localObject1	Object
    //   325	159	4	localObject2	Object
    //   507	3	4	str	String
    //   16	487	5	localFile	File
    //   7	249	6	localObject3	Object
    //   330	3	6	localIOException	IOException
    //   345	65	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   430	31	6	localMQLruCache	android.support.v4.util.MQLruCache
    //   70	393	7	localObject4	Object
    //   79	326	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   155	229	325	finally
    //   234	322	325	finally
    //   332	342	325	finally
    //   347	419	325	finally
    //   155	229	330	java/io/IOException
    //   234	322	330	java/io/IOException
    //   155	229	345	java/lang/OutOfMemoryError
    //   234	322	345	java/lang/OutOfMemoryError
  }
  
  private void a(File paramFile, byte[] paramArrayOfByte)
  {
    try
    {
      paramFile = new FileOutputStream(paramFile);
      try
      {
        paramFile.write(paramArrayOfByte);
        paramFile.flush();
        paramFile.close();
        return;
      }
      catch (Exception paramArrayOfByte) {}
      paramArrayOfByte.printStackTrace();
    }
    catch (Exception paramArrayOfByte)
    {
      paramFile = null;
    }
    if (paramFile != null) {
      try
      {
        paramFile.close();
        return;
      }
      catch (IOException paramFile)
      {
        paramFile.printStackTrace();
      }
    }
  }
  
  private String b()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData.jdField_a_of_type_ArrayOfByte;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData.jdField_a_of_type_AndroidGraphicsRect;
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData.jdField_a_of_type_JavaIoFile;
    if (QLog.isColorLevel()) {
      QLog.i(CameraControl.b, 2, "Do not clip photo");
    }
    LogTag.a();
    a((File)localObject, arrayOfByte);
    boolean bool = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.j);
    int i = 6;
    if (bool)
    {
      ImageUtil.a(((File)localObject).getAbsolutePath(), "Orientation", String.valueOf(6));
    }
    else if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.k))
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData.jdField_a_of_type_Int % 360;
      if (j != 0)
      {
        if (j == 90) {
          break label164;
        }
        if (j == 180) {
          break label162;
        }
        if (j == 270) {}
      }
      else
      {
        i = 0;
        break label164;
      }
      i = 8;
      break label164;
      label162:
      i = 3;
      label164:
      ImageUtil.a(((File)localObject).getAbsolutePath(), "Orientation", String.valueOf(i));
    }
    LogTag.a(CameraControl.b, "TakePictureTask_writePhotoFile");
    if (((File)localObject).exists()) {
      return ((File)localObject).getAbsolutePath();
    }
    return null;
  }
  
  protected String a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData.d == 0) {
      return b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData.d == 1) {
      return a();
    }
    return null;
  }
  
  protected void a(String paramString)
  {
    
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$TakePictureData.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback.a(paramString);
      if ((paramString == null) && (QLog.isColorLevel())) {
        QLog.i(CameraControl.b, 2, "Picture bitmap data error or output file not exist");
      }
    }
    LogTag.a(CameraControl.b, "TakePictureTask_onPictureTokenCb");
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl.jdField_a_of_type_AndroidHardwareCamera.startPreview();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl.jdField_a_of_type_Boolean = true;
      }
      catch (RuntimeException paramString)
      {
        paramString.printStackTrace();
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString = CameraControl.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onPostExecute]mCamera is ");
      localStringBuilder.append(null);
      QLog.i(paramString, 2, localStringBuilder.toString());
    }
    LogTag.a(CameraControl.b, "TakePictureTask");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.TakePictureTask
 * JD-Core Version:    0.7.0.1
 */