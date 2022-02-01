package com.tencent.youtu.sdkkitframework.common;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.List;

public class YtCameraSetting
{
  private static final String TAG = "YtCameraSetting";
  public static int mCameraFacing = 1;
  static int mDesiredPreviewHeight = 480;
  static int mDesiredPreviewWidth = 640;
  public static int mRotate;
  
  private static int chooseFixedPreviewFps(Camera.Parameters paramParameters, int paramInt)
  {
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange().iterator();
    int j;
    do
    {
      boolean bool = ((Iterator)localObject2).hasNext();
      j = 0;
      if (!bool) {
        break;
      }
      localObject1 = (int[])((Iterator)localObject2).next();
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("entry: ");
      localStringBuilder.append(localObject1[0]);
      localStringBuilder.append(" - ");
      localStringBuilder.append(localObject1[1]);
      YtLogger.d(str, localStringBuilder.toString());
    } while ((localObject1[0] != localObject1[1]) || (localObject1[0] != paramInt));
    paramParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
    paramParameters = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("use preview fps range: ");
    ((StringBuilder)localObject2).append(localObject1[0]);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(localObject1[1]);
    YtLogger.d(paramParameters, ((StringBuilder)localObject2).toString());
    return localObject1[0];
    Object localObject1 = new int[2];
    paramParameters.getPreviewFpsRange((int[])localObject1);
    if (localObject1[0] == localObject1[1])
    {
      paramInt = localObject1[0];
    }
    else
    {
      i = paramInt;
      if (paramInt > localObject1[1]) {
        i = localObject1[1];
      }
      paramInt = i;
      if (i < localObject1[0]) {
        paramInt = localObject1[0];
      }
    }
    localObject1 = paramParameters.get("preview-frame-rate-values");
    int i = paramInt;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramInt / 1000);
      i = paramInt;
      if (!((String)localObject1).contains(((StringBuilder)localObject2).toString()))
      {
        localObject1 = ((String)localObject1).split(",");
        int k = localObject1.length;
        i = j;
        while (i < k)
        {
          j = Integer.parseInt(localObject1[i]) * 1000;
          if (paramInt < j)
          {
            paramParameters.setPreviewFrameRate(j / 1000);
            return j;
          }
          i += 1;
        }
        i = paramInt;
        if (localObject1.length > 0)
        {
          j = Integer.parseInt(localObject1[(localObject1.length - 1)]) * 1000;
          i = paramInt;
          if (paramInt > j) {
            i = j;
          }
        }
      }
    }
    paramParameters.setPreviewFrameRate(i / 1000);
    return i;
  }
  
  public static int getDesiredPreviewHeight()
  {
    return mDesiredPreviewHeight;
  }
  
  public static int getDesiredPreviewWidth()
  {
    return mDesiredPreviewWidth;
  }
  
  private static Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    if (paramList == null) {
      return null;
    }
    int i = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    double d1 = i;
    double d2 = paramInt1;
    Double.isNaN(d1);
    Double.isNaN(d2);
    double d3 = d1 / d2;
    Object localObject2 = TAG;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("sizes size=");
    ((StringBuilder)localObject3).append(paramList.size());
    YtLogger.d((String)localObject2, ((StringBuilder)localObject3).toString());
    localObject3 = paramList.iterator();
    d2 = 1.7976931348623157E+308D;
    d1 = 1.7976931348623157E+308D;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Camera.Size)((Iterator)localObject3).next();
      double d4 = ((Camera.Size)localObject2).width;
      double d5 = ((Camera.Size)localObject2).height;
      Double.isNaN(d4);
      Double.isNaN(d5);
      if ((Math.abs(d4 / d5 - d3) <= 0.001D) && (Math.abs(((Camera.Size)localObject2).height - paramInt1) < d1))
      {
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt1);
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      YtLogger.d(TAG, "No preview size match the aspect ratio");
      localObject3 = paramList.iterator();
      d1 = d2;
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        paramList = (Camera.Size)((Iterator)localObject3).next();
        if (Math.abs(paramList.height - paramInt1) < d1)
        {
          d1 = Math.abs(paramList.height - paramInt1);
          localObject1 = paramList;
        }
      }
    }
    return localObject2;
  }
  
  public static int getRotate(Context paramContext, int paramInt1, int paramInt2)
  {
    return getRotateTag(getVideoRotate(paramContext, paramInt1), paramInt2);
  }
  
  public static int getRotateTag(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 90)
    {
      paramInt1 = 7;
    }
    else if (paramInt1 == 180)
    {
      paramInt1 = 3;
    }
    else if (paramInt1 == 270)
    {
      paramInt1 = 5;
    }
    else
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("camera rotate not 90degree or 180degree, input: ");
      localStringBuilder.append(paramInt1);
      YtLogger.i(str, localStringBuilder.toString());
      paramInt1 = 1;
    }
    if (paramInt2 == 1) {
      return paramInt1;
    }
    return transBackFacingCameraRatateTag(paramInt1);
  }
  
  public static int getVideoRotate(Context paramContext, int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    int j = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
    int i = 0;
    paramInt = i;
    if (j != 0) {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            paramInt = i;
          } else {
            paramInt = 270;
          }
        }
        else {
          paramInt = 180;
        }
      }
      else {
        paramInt = 90;
      }
    }
    if (localCameraInfo.facing == 1) {
      i = (360 - (localCameraInfo.orientation + paramInt) % 360) % 360;
    } else {
      i = (localCameraInfo.orientation - paramInt + 360) % 360;
    }
    paramContext = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("debug camera orientation is ");
    localStringBuilder.append(localCameraInfo.orientation);
    localStringBuilder.append(" ui degrees is ");
    localStringBuilder.append(paramInt);
    YtLogger.i(paramContext, localStringBuilder.toString());
    return i;
  }
  
  public static int initCamera(Context paramContext, Camera paramCamera, int paramInt)
  {
    return initCamera(paramContext, paramCamera, paramInt, 4);
  }
  
  /* Error */
  public static int initCamera(Context paramContext, Camera paramCamera, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 240	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   4: astore 5
    //   6: aload 5
    //   8: invokevirtual 243	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   11: astore 6
    //   13: iconst_0
    //   14: istore 4
    //   16: iload 4
    //   18: aload 6
    //   20: invokeinterface 150 1 0
    //   25: if_icmpge +78 -> 103
    //   28: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   31: astore 7
    //   33: new 52	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   40: astore 8
    //   42: aload 8
    //   44: ldc 245
    //   46: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 8
    //   52: iload 4
    //   54: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 8
    //   60: ldc 247
    //   62: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 8
    //   68: aload 6
    //   70: iload 4
    //   72: invokeinterface 250 2 0
    //   77: checkcast 102	java/lang/String
    //   80: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 7
    //   86: aload 8
    //   88: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 253	com/tencent/youtu/sdkkitframework/common/YtLogger:v	(Ljava/lang/String;Ljava/lang/Object;)V
    //   94: iload 4
    //   96: iconst_1
    //   97: iadd
    //   98: istore 4
    //   100: goto -84 -> 16
    //   103: aload 6
    //   105: ifnull +34 -> 139
    //   108: aload 6
    //   110: ldc 255
    //   112: invokeinterface 259 2 0
    //   117: iflt +22 -> 139
    //   120: aload 5
    //   122: ldc 255
    //   124: invokevirtual 263	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   127: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   130: ldc_w 265
    //   133: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   136: goto +50 -> 186
    //   139: aload 6
    //   141: ifnull +36 -> 177
    //   144: aload 6
    //   146: ldc_w 267
    //   149: invokeinterface 259 2 0
    //   154: iflt +23 -> 177
    //   157: aload 5
    //   159: ldc_w 267
    //   162: invokevirtual 263	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   165: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   168: ldc_w 269
    //   171: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   174: goto +12 -> 186
    //   177: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   180: ldc_w 271
    //   183: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   186: aload_1
    //   187: aload 5
    //   189: invokevirtual 275	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   192: aload_1
    //   193: invokevirtual 240	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   196: astore 5
    //   198: goto +56 -> 254
    //   201: astore_0
    //   202: goto +996 -> 1198
    //   205: astore 5
    //   207: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   210: astore 6
    //   212: new 52	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   219: astore 7
    //   221: aload 7
    //   223: ldc_w 277
    //   226: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 7
    //   232: aload 5
    //   234: invokevirtual 280	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   237: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 6
    //   243: aload 7
    //   245: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 283	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: goto -59 -> 192
    //   254: aload_0
    //   255: iload_2
    //   256: invokestatic 179	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:getVideoRotate	(Landroid/content/Context;I)I
    //   259: istore 4
    //   261: aload_1
    //   262: iload 4
    //   264: invokevirtual 286	android/hardware/Camera:setDisplayOrientation	(I)V
    //   267: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   270: astore_0
    //   271: new 52	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   278: astore 6
    //   280: aload 6
    //   282: ldc_w 288
    //   285: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 6
    //   291: iload 4
    //   293: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_0
    //   298: aload 6
    //   300: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   306: iload_2
    //   307: iload_3
    //   308: invokestatic 294	android/media/CamcorderProfile:hasProfile	(II)Z
    //   311: ifeq +74 -> 385
    //   314: iload_2
    //   315: iload_3
    //   316: invokestatic 297	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   319: astore_0
    //   320: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   323: astore 6
    //   325: new 52	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   332: astore 7
    //   334: aload 7
    //   336: ldc_w 299
    //   339: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 7
    //   345: aload_0
    //   346: getfield 302	android/media/CamcorderProfile:videoFrameWidth	I
    //   349: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 7
    //   355: ldc_w 304
    //   358: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 7
    //   364: aload_0
    //   365: getfield 307	android/media/CamcorderProfile:videoFrameHeight	I
    //   368: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 6
    //   374: aload 7
    //   376: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   382: goto +229 -> 611
    //   385: iload_2
    //   386: iconst_4
    //   387: invokestatic 294	android/media/CamcorderProfile:hasProfile	(II)Z
    //   390: ifeq +74 -> 464
    //   393: iload_2
    //   394: iconst_4
    //   395: invokestatic 297	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   398: astore_0
    //   399: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   402: astore 6
    //   404: new 52	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   411: astore 7
    //   413: aload 7
    //   415: ldc_w 309
    //   418: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 7
    //   424: aload_0
    //   425: getfield 302	android/media/CamcorderProfile:videoFrameWidth	I
    //   428: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 7
    //   434: ldc_w 304
    //   437: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 7
    //   443: aload_0
    //   444: getfield 307	android/media/CamcorderProfile:videoFrameHeight	I
    //   447: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload 6
    //   453: aload 7
    //   455: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   461: goto +150 -> 611
    //   464: iload_2
    //   465: iconst_5
    //   466: invokestatic 294	android/media/CamcorderProfile:hasProfile	(II)Z
    //   469: ifeq +74 -> 543
    //   472: iload_2
    //   473: iconst_5
    //   474: invokestatic 297	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   477: astore_0
    //   478: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   481: astore 6
    //   483: new 52	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   490: astore 7
    //   492: aload 7
    //   494: ldc_w 311
    //   497: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 7
    //   503: aload_0
    //   504: getfield 302	android/media/CamcorderProfile:videoFrameWidth	I
    //   507: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 7
    //   513: ldc_w 304
    //   516: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload 7
    //   522: aload_0
    //   523: getfield 307	android/media/CamcorderProfile:videoFrameHeight	I
    //   526: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 6
    //   532: aload 7
    //   534: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   540: goto +71 -> 611
    //   543: iload_2
    //   544: iconst_1
    //   545: invokestatic 297	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   548: astore_0
    //   549: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   552: astore 6
    //   554: new 52	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   561: astore 7
    //   563: aload 7
    //   565: ldc_w 313
    //   568: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 7
    //   574: aload_0
    //   575: getfield 302	android/media/CamcorderProfile:videoFrameWidth	I
    //   578: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 7
    //   584: ldc_w 304
    //   587: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 7
    //   593: aload_0
    //   594: getfield 307	android/media/CamcorderProfile:videoFrameHeight	I
    //   597: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload 6
    //   603: aload 7
    //   605: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   611: aload_1
    //   612: invokevirtual 240	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   615: invokevirtual 316	android/hardware/Camera$Parameters:getSupportedPictureSizes	()Ljava/util/List;
    //   618: astore 7
    //   620: aload_1
    //   621: invokevirtual 240	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   624: invokevirtual 319	android/hardware/Camera$Parameters:getSupportedPreviewSizes	()Ljava/util/List;
    //   627: astore 6
    //   629: iconst_0
    //   630: istore_2
    //   631: iload_2
    //   632: aload 7
    //   634: invokeinterface 150 1 0
    //   639: if_icmpge +74 -> 713
    //   642: aload 7
    //   644: iload_2
    //   645: invokeinterface 250 2 0
    //   650: checkcast 154	android/hardware/Camera$Size
    //   653: astore 8
    //   655: new 52	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   662: astore 9
    //   664: aload 9
    //   666: aload 8
    //   668: getfield 157	android/hardware/Camera$Size:width	I
    //   671: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload 9
    //   677: ldc_w 321
    //   680: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload 9
    //   686: aload 8
    //   688: getfield 160	android/hardware/Camera$Size:height	I
    //   691: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: ldc_w 323
    //   698: aload 9
    //   700: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   706: iload_2
    //   707: iconst_1
    //   708: iadd
    //   709: istore_2
    //   710: goto -79 -> 631
    //   713: iconst_0
    //   714: istore_2
    //   715: iload_2
    //   716: aload 6
    //   718: invokeinterface 150 1 0
    //   723: if_icmpge +74 -> 797
    //   726: aload 6
    //   728: iload_2
    //   729: invokeinterface 250 2 0
    //   734: checkcast 154	android/hardware/Camera$Size
    //   737: astore 7
    //   739: new 52	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   746: astore 8
    //   748: aload 8
    //   750: aload 7
    //   752: getfield 157	android/hardware/Camera$Size:width	I
    //   755: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 8
    //   761: ldc_w 321
    //   764: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 8
    //   770: aload 7
    //   772: getfield 160	android/hardware/Camera$Size:height	I
    //   775: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: ldc_w 325
    //   782: aload 8
    //   784: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   787: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   790: iload_2
    //   791: iconst_1
    //   792: iadd
    //   793: istore_2
    //   794: goto -79 -> 715
    //   797: aload 5
    //   799: aload_0
    //   800: invokestatic 329	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:setVideoSize	(Landroid/hardware/Camera$Parameters;Landroid/media/CamcorderProfile;)V
    //   803: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   806: astore_0
    //   807: new 52	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   814: astore 6
    //   816: aload 6
    //   818: ldc_w 331
    //   821: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload 6
    //   827: getstatic 128	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:mDesiredPreviewWidth	I
    //   830: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload 6
    //   836: ldc_w 333
    //   839: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload 6
    //   845: getstatic 125	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:mDesiredPreviewHeight	I
    //   848: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload_0
    //   853: aload 6
    //   855: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   861: aload 5
    //   863: getstatic 128	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:mDesiredPreviewWidth	I
    //   866: getstatic 125	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:mDesiredPreviewHeight	I
    //   869: invokevirtual 336	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   872: aload 5
    //   874: bipush 17
    //   876: invokevirtual 339	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   879: aload_1
    //   880: aload 5
    //   882: invokevirtual 275	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   885: goto +47 -> 932
    //   888: astore_0
    //   889: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   892: astore 5
    //   894: new 52	java/lang/StringBuilder
    //   897: dup
    //   898: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   901: astore 6
    //   903: aload 6
    //   905: ldc_w 277
    //   908: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: aload 6
    //   914: aload_0
    //   915: invokevirtual 280	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   918: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 5
    //   924: aload 6
    //   926: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: invokestatic 283	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   932: aload_1
    //   933: invokevirtual 240	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   936: astore_0
    //   937: aload_0
    //   938: sipush 30000
    //   941: invokestatic 341	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:chooseFixedPreviewFps	(Landroid/hardware/Camera$Parameters;I)I
    //   944: istore_2
    //   945: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   948: astore 5
    //   950: new 52	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   957: astore 6
    //   959: aload 6
    //   961: ldc_w 343
    //   964: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: pop
    //   968: aload 6
    //   970: iload_2
    //   971: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: aload 5
    //   977: aload 6
    //   979: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   985: aload_1
    //   986: aload_0
    //   987: invokevirtual 275	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   990: goto +47 -> 1037
    //   993: astore_0
    //   994: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   997: astore 5
    //   999: new 52	java/lang/StringBuilder
    //   1002: dup
    //   1003: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1006: astore 6
    //   1008: aload 6
    //   1010: ldc_w 345
    //   1013: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: pop
    //   1017: aload 6
    //   1019: aload_0
    //   1020: invokevirtual 280	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   1023: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: pop
    //   1027: aload 5
    //   1029: aload 6
    //   1031: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1034: invokestatic 283	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1037: aload_1
    //   1038: invokevirtual 240	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   1041: astore_0
    //   1042: iconst_2
    //   1043: newarray int
    //   1045: astore_1
    //   1046: aload_0
    //   1047: aload_1
    //   1048: invokevirtual 86	android/hardware/Camera$Parameters:getPreviewFpsRange	([I)V
    //   1051: aload_0
    //   1052: invokevirtual 348	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   1055: istore_2
    //   1056: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   1059: astore 5
    //   1061: new 52	java/lang/StringBuilder
    //   1064: dup
    //   1065: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1068: astore 6
    //   1070: aload 6
    //   1072: ldc_w 350
    //   1075: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: pop
    //   1079: aload 6
    //   1081: aload_1
    //   1082: iconst_0
    //   1083: iaload
    //   1084: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1087: pop
    //   1088: aload 6
    //   1090: ldc_w 352
    //   1093: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: pop
    //   1097: aload 6
    //   1099: aload_1
    //   1100: iconst_1
    //   1101: iaload
    //   1102: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: aload 6
    //   1108: ldc_w 354
    //   1111: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: pop
    //   1115: aload 6
    //   1117: iload_2
    //   1118: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1121: pop
    //   1122: aload 5
    //   1124: aload 6
    //   1126: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1129: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1132: aload_0
    //   1133: invokevirtual 358	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   1136: astore_0
    //   1137: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   1140: astore_1
    //   1141: new 52	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1148: astore 5
    //   1150: aload 5
    //   1152: ldc_w 360
    //   1155: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: pop
    //   1159: aload 5
    //   1161: aload_0
    //   1162: getfield 157	android/hardware/Camera$Size:width	I
    //   1165: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: aload 5
    //   1171: ldc 82
    //   1173: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: aload 5
    //   1179: aload_0
    //   1180: getfield 160	android/hardware/Camera$Size:height	I
    //   1183: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: aload_1
    //   1188: aload 5
    //   1190: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1193: invokestatic 74	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1196: iconst_0
    //   1197: ireturn
    //   1198: aload_1
    //   1199: invokevirtual 240	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   1202: pop
    //   1203: aload_0
    //   1204: athrow
    //   1205: getstatic 50	com/tencent/youtu/sdkkitframework/common/YtCameraSetting:TAG	Ljava/lang/String;
    //   1208: ldc_w 362
    //   1211: invokestatic 283	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1214: iconst_1
    //   1215: ireturn
    //   1216: astore_0
    //   1217: goto -12 -> 1205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1220	0	paramContext	Context
    //   0	1220	1	paramCamera	Camera
    //   0	1220	2	paramInt1	int
    //   0	1220	3	paramInt2	int
    //   14	278	4	i	int
    //   4	193	5	localParameters	Camera.Parameters
    //   205	676	5	localException	java.lang.Exception
    //   892	297	5	localObject1	Object
    //   11	1114	6	localObject2	Object
    //   31	740	7	localObject3	Object
    //   40	743	8	localObject4	Object
    //   662	37	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   186	192	201	finally
    //   207	251	201	finally
    //   186	192	205	java/lang/Exception
    //   879	885	888	java/lang/Exception
    //   985	990	993	java/lang/Exception
    //   0	6	1216	java/lang/Exception
  }
  
  public static void setCameraFacing(int paramInt)
  {
    mCameraFacing = paramInt;
  }
  
  public static void setCameraRotate(int paramInt)
  {
    mRotate = paramInt;
  }
  
  public static void setVideoSize(Camera.Parameters paramParameters, CamcorderProfile paramCamcorderProfile)
  {
    Object localObject = paramParameters.getSupportedPreviewSizes();
    if (paramParameters.getSupportedVideoSizes() == null)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video size from profile is : ");
      localStringBuilder.append(paramCamcorderProfile.videoFrameWidth);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramCamcorderProfile.videoFrameHeight);
      YtLogger.d(str, localStringBuilder.toString());
      if (getOptimalPreviewSize((List)localObject, paramCamcorderProfile.videoFrameWidth, paramCamcorderProfile.videoFrameHeight) == null)
      {
        YtLogger.d(TAG, "do not find proper preview size, use default");
        paramCamcorderProfile.videoFrameWidth = 640;
        paramCamcorderProfile.videoFrameHeight = 480;
      }
    }
    paramParameters = paramParameters.getSupportedVideoSizes();
    if (paramParameters != null)
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramParameters.size(); j = k)
      {
        localObject = (Camera.Size)paramParameters.get(i);
        k = j;
        if (((Camera.Size)localObject).width == paramCamcorderProfile.videoFrameWidth)
        {
          k = j;
          if (((Camera.Size)localObject).height == paramCamcorderProfile.videoFrameHeight) {
            k = 1;
          }
        }
        i += 1;
      }
      if (j == 0)
      {
        paramCamcorderProfile.videoFrameWidth = 640;
        paramCamcorderProfile.videoFrameHeight = 480;
      }
    }
    paramParameters = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select video size camcorderProfile:");
    ((StringBuilder)localObject).append(paramCamcorderProfile.videoFrameWidth);
    ((StringBuilder)localObject).append("x");
    ((StringBuilder)localObject).append(paramCamcorderProfile.videoFrameHeight);
    YtLogger.d(paramParameters, ((StringBuilder)localObject).toString());
  }
  
  public static int transBackFacingCameraRatateTag(int paramInt)
  {
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 2) {
      return 1;
    }
    if (paramInt == 3) {
      return 4;
    }
    if (paramInt == 4) {
      return 3;
    }
    if (paramInt == 5) {
      return 8;
    }
    if (paramInt == 6) {
      return 7;
    }
    if (paramInt == 7) {
      return 6;
    }
    if (paramInt == 8) {
      return 5;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[YtCameraSetting.transBackFacingCameraRatateTag] unsurported rotateTag: ");
    localStringBuilder.append(paramInt);
    YtLogger.w(str, localStringBuilder.toString());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtCameraSetting
 * JD-Core Version:    0.7.0.1
 */