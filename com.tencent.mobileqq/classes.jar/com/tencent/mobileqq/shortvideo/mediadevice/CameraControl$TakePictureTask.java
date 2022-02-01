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
  CameraControl.TakePictureData a;
  
  public CameraControl$TakePictureTask(CameraControl paramCameraControl, CameraControl.TakePictureData paramTakePictureData)
  {
    this.a = paramTakePictureData;
    LogTag.a();
  }
  
  /* Error */
  private String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   4: getfield 33	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:a	[B
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   13: getfield 36	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:b	Ljava/io/File;
    //   16: astore 5
    //   18: invokestatic 22	com/tencent/mobileqq/utils/LogTag:a	()V
    //   21: aconst_null
    //   22: astore 4
    //   24: aload 5
    //   26: ifnonnull +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: aload 6
    //   33: ifnull +453 -> 486
    //   36: aload_0
    //   37: getfield 13	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:b	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   40: getfield 42	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:p	Lcom/tencent/mobileqq/camera/CameraHolder;
    //   43: aload_0
    //   44: getfield 13	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:b	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   47: getfield 46	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:g	I
    //   50: aload_0
    //   51: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   54: getfield 49	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:e	I
    //   57: invokestatic 54	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Lcom/tencent/mobileqq/camera/CameraHolder;II)I
    //   60: istore_1
    //   61: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +91 -> 155
    //   67: getstatic 63	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	Ljava/lang/String;
    //   70: astore 7
    //   72: new 65	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   79: astore 8
    //   81: aload 8
    //   83: ldc 68
    //   85: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 8
    //   91: aload_0
    //   92: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   95: getfield 75	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:g	Z
    //   98: invokevirtual 78	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 8
    //   104: ldc 80
    //   106: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 8
    //   112: aload_0
    //   113: getfield 13	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:b	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   116: getfield 42	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:p	Lcom/tencent/mobileqq/camera/CameraHolder;
    //   119: invokevirtual 85	com/tencent/mobileqq/camera/CameraHolder:b	()Lcom/tencent/mobileqq/camera/adapter/CameraWrapper;
    //   122: invokevirtual 90	com/tencent/mobileqq/camera/adapter/CameraWrapper:c	()Z
    //   125: invokevirtual 78	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 8
    //   131: ldc 92
    //   133: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 8
    //   139: iload_1
    //   140: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 7
    //   146: iconst_2
    //   147: aload 8
    //   149: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: getfield 13	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:b	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   159: aload_0
    //   160: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   163: getfield 106	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:j	Landroid/hardware/Camera$Size;
    //   166: getfield 111	android/hardware/Camera$Size:width	I
    //   169: aload_0
    //   170: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   173: getfield 106	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:j	Landroid/hardware/Camera$Size;
    //   176: getfield 114	android/hardware/Camera$Size:height	I
    //   179: aload_0
    //   180: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   183: getfield 117	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:c	Landroid/graphics/Rect;
    //   186: invokevirtual 122	android/graphics/Rect:width	()I
    //   189: aload_0
    //   190: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   193: getfield 117	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:c	Landroid/graphics/Rect;
    //   196: invokevirtual 124	android/graphics/Rect:height	()I
    //   199: invokestatic 127	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:a	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;IIII)Z
    //   202: istore_3
    //   203: aload_0
    //   204: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   207: getfield 75	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:g	Z
    //   210: ifeq +302 -> 512
    //   213: aload_0
    //   214: getfield 13	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:b	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl;
    //   217: getfield 42	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:p	Lcom/tencent/mobileqq/camera/CameraHolder;
    //   220: invokevirtual 85	com/tencent/mobileqq/camera/CameraHolder:b	()Lcom/tencent/mobileqq/camera/adapter/CameraWrapper;
    //   223: invokevirtual 90	com/tencent/mobileqq/camera/adapter/CameraWrapper:c	()Z
    //   226: ifne +286 -> 512
    //   229: iconst_1
    //   230: istore_2
    //   231: goto +3 -> 234
    //   234: aload 6
    //   236: aload_0
    //   237: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   240: getfield 117	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:c	Landroid/graphics/Rect;
    //   243: iload_2
    //   244: iload_1
    //   245: invokestatic 130	com/tencent/mobileqq/camera/utils/CameraUtils:b	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   248: astore 6
    //   250: ldc 132
    //   252: invokestatic 137	com/tencent/mobileqq/activity/richmedia/NewFlowCameraReporter:a	(Ljava/lang/String;)V
    //   255: aload 6
    //   257: aload_0
    //   258: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   261: getfield 140	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:h	I
    //   264: aload 5
    //   266: invokestatic 145	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   269: pop
    //   270: iconst_0
    //   271: aload_0
    //   272: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   275: getfield 106	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:j	Landroid/hardware/Camera$Size;
    //   278: getfield 111	android/hardware/Camera$Size:width	I
    //   281: aload_0
    //   282: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   285: getfield 106	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:j	Landroid/hardware/Camera$Size;
    //   288: getfield 114	android/hardware/Camera$Size:height	I
    //   291: aload_0
    //   292: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   295: getfield 117	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:c	Landroid/graphics/Rect;
    //   298: invokevirtual 122	android/graphics/Rect:width	()I
    //   301: aload_0
    //   302: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   305: getfield 117	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:c	Landroid/graphics/Rect;
    //   308: invokevirtual 124	android/graphics/Rect:height	()I
    //   311: iload_3
    //   312: iload_1
    //   313: iload_2
    //   314: invokestatic 148	com/tencent/mobileqq/activity/richmedia/NewFlowCameraReporter:a	(ZIIIIZIZ)V
    //   317: ldc 150
    //   319: invokestatic 137	com/tencent/mobileqq/activity/richmedia/NewFlowCameraReporter:a	(Ljava/lang/String;)V
    //   322: goto +97 -> 419
    //   325: astore 4
    //   327: goto +156 -> 483
    //   330: astore 6
    //   332: aload 6
    //   334: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   337: aconst_null
    //   338: invokestatic 156	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   341: pop
    //   342: goto +77 -> 419
    //   345: astore 6
    //   347: getstatic 63	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	Ljava/lang/String;
    //   350: astore 7
    //   352: new 65	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   359: astore 8
    //   361: aload 8
    //   363: ldc 158
    //   365: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 8
    //   371: aload_0
    //   372: getfield 18	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureTask:a	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData;
    //   375: getfield 49	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl$TakePictureData:e	I
    //   378: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 8
    //   384: ldc 160
    //   386: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 8
    //   392: aload 6
    //   394: invokevirtual 163	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 7
    //   403: iconst_2
    //   404: aload 8
    //   406: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: aload 6
    //   411: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   414: aconst_null
    //   415: invokestatic 156	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   418: pop
    //   419: aload 5
    //   421: invokevirtual 171	java/io/File:exists	()Z
    //   424: ifeq +51 -> 475
    //   427: getstatic 176	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   430: astore 6
    //   432: new 65	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   439: astore 7
    //   441: aload 7
    //   443: aload 5
    //   445: invokevirtual 179	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   448: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload 7
    //   454: ldc 181
    //   456: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 6
    //   462: aload 7
    //   464: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: aconst_null
    //   468: invokevirtual 187	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   471: pop
    //   472: goto +14 -> 486
    //   475: aconst_null
    //   476: invokestatic 156	com/tencent/mobileqq/camera/utils/CameraUtils:a	(Landroid/graphics/Bitmap;)Z
    //   479: pop
    //   480: goto +6 -> 486
    //   483: aload 4
    //   485: athrow
    //   486: getstatic 63	com/tencent/mobileqq/shortvideo/mediadevice/CameraControl:b	Ljava/lang/String;
    //   489: ldc 189
    //   491: invokestatic 192	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload 5
    //   496: invokevirtual 171	java/io/File:exists	()Z
    //   499: ifeq +10 -> 509
    //   502: aload 5
    //   504: invokevirtual 179	java/io/File:getAbsolutePath	()Ljava/lang/String;
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
    byte[] arrayOfByte = this.a.a;
    Object localObject = this.a.c;
    localObject = this.a.b;
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
      int j = this.a.e % 360;
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
    if (this.a.i == 0) {
      return b();
    }
    if (this.a.i == 1) {
      return a();
    }
    return null;
  }
  
  protected void a(String paramString)
  {
    
    if (this.a.d != null)
    {
      this.a.d.a(paramString);
      if ((paramString == null) && (QLog.isColorLevel())) {
        QLog.i(CameraControl.b, 2, "Picture bitmap data error or output file not exist");
      }
    }
    LogTag.a(CameraControl.b, "TakePictureTask_onPictureTokenCb");
    if (this.b.d != null)
    {
      try
      {
        this.b.d.startPreview();
        this.b.n = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.TakePictureTask
 * JD-Core Version:    0.7.0.1
 */