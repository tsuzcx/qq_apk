package com.tencent.youtu.ytcommon.tools;

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
import java.util.List<Landroid.hardware.Camera.Size;>;

public class YTCameraSetting
{
  private static final String TAG = "YTCameraSetting";
  public static int mCameraFacing = 1;
  static int mDesiredPreviewHeight = 480;
  static int mDesiredPreviewWidth;
  public static int mRotate = 0;
  
  static
  {
    mDesiredPreviewWidth = 640;
  }
  
  private static int chooseFixedPreviewFps(Camera.Parameters paramParameters, int paramInt)
  {
    int j = 0;
    Object localObject = paramParameters.getSupportedPreviewFpsRange().iterator();
    while (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt = (int[])((Iterator)localObject).next();
      YTLogger.d("YTCameraSetting", "entry: " + arrayOfInt[0] + " - " + arrayOfInt[1]);
      if ((arrayOfInt[0] == arrayOfInt[1]) && (arrayOfInt[0] == paramInt))
      {
        paramParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
        YTLogger.d("YTCameraSetting", "use preview fps range: " + arrayOfInt[0] + " " + arrayOfInt[1]);
        return arrayOfInt[0];
      }
    }
    localObject = new int[2];
    paramParameters.getPreviewFpsRange((int[])localObject);
    int i;
    int k;
    if (localObject[0] == localObject[1])
    {
      paramInt = localObject[0];
      localObject = paramParameters.get("preview-frame-rate-values");
      i = paramInt;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = paramInt;
        if (!((String)localObject).contains("" + paramInt / 1000))
        {
          localObject = ((String)localObject).split(",");
          k = localObject.length;
          i = j;
        }
      }
    }
    else
    {
      for (;;)
      {
        if (i >= k) {
          break label317;
        }
        j = Integer.parseInt(localObject[i]) * 1000;
        if (paramInt < j)
        {
          paramParameters.setPreviewFrameRate(j / 1000);
          return j;
          i = paramInt;
          if (paramInt > localObject[1]) {
            i = localObject[1];
          }
          paramInt = i;
          if (i >= localObject[0]) {
            break;
          }
          paramInt = localObject[0];
          break;
        }
        i += 1;
      }
      label317:
      i = paramInt;
      if (localObject.length > 0)
      {
        j = Integer.parseInt(localObject[(localObject.length - 1)]) * 1000;
        i = paramInt;
        if (paramInt > j) {
          i = j;
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
    Object localObject2;
    if (paramList == null)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    int i = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    double d2 = i / paramInt1;
    YTLogger.d("YTCameraSetting", "sizes size=" + paramList.size());
    Iterator localIterator = paramList.iterator();
    label75:
    while (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if (Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - d2) <= 0.001D)
      {
        if (Math.abs(((Camera.Size)localObject2).height - paramInt1) >= d1) {
          break label249;
        }
        d1 = Math.abs(((Camera.Size)localObject2).height - paramInt1);
        localObject1 = localObject2;
      }
    }
    label249:
    for (;;)
    {
      break label75;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      YTLogger.d("YTCameraSetting", "No preview size match the aspect ratio");
      d1 = 1.7976931348623157E+308D;
      localIterator = paramList.iterator();
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Camera.Size)localIterator.next();
      if (Math.abs(paramList.height - paramInt1) < d1) {
        d1 = Math.abs(paramList.height - paramInt1);
      }
      for (;;)
      {
        localObject1 = paramList;
        break;
        paramList = (List<Camera.Size>)localObject1;
      }
    }
  }
  
  public static int getRotate(Context paramContext, int paramInt1, int paramInt2)
  {
    return getRotateTag(getVideoRotate(paramContext, paramInt1));
  }
  
  public static int getRotateTag(int paramInt)
  {
    if (paramInt == 90) {
      paramInt = 7;
    }
    while (mCameraFacing == 1)
    {
      return paramInt;
      if (paramInt == 180)
      {
        paramInt = 3;
      }
      else if (paramInt == 270)
      {
        paramInt = 5;
      }
      else
      {
        YTLogger.i("YTCameraSetting", "camera rotate not 90degree or 180degree, input: " + paramInt);
        paramInt = 1;
      }
    }
    return transBackFacingCameraRatateTag(paramInt);
  }
  
  public static int getVideoRotate(Context paramContext, int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    switch (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = 0;
      if (localCameraInfo.facing != 1) {
        break;
      }
    }
    for (int i = (360 - (localCameraInfo.orientation + paramInt) % 360) % 360;; i = (localCameraInfo.orientation - paramInt + 360) % 360)
    {
      YTLogger.i("YTCameraSetting", "debug camera orientation is " + localCameraInfo.orientation + " ui degrees is " + paramInt);
      return i;
      paramInt = 0;
      break;
      paramInt = 90;
      break;
      paramInt = 180;
      break;
      paramInt = 270;
      break;
    }
  }
  
  /* Error */
  public static int initCamera(Context paramContext, Camera paramCamera, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 229	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 232	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: aload 5
    //   18: invokeinterface 145 1 0
    //   23: if_icmpge +67 -> 90
    //   26: ldc 8
    //   28: new 55	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   35: ldc 234
    //   37: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_3
    //   41: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc 236
    //   46: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 5
    //   51: iload_3
    //   52: invokeinterface 239 2 0
    //   57: checkcast 105	java/lang/String
    //   60: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 242	com/tencent/youtu/ytcommon/tools/YTLogger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: iload_3
    //   70: iconst_1
    //   71: iadd
    //   72: istore_3
    //   73: goto -58 -> 15
    //   76: astore_0
    //   77: ldc 8
    //   79: ldc 244
    //   81: invokestatic 247	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_0
    //   85: invokestatic 253	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   88: iconst_1
    //   89: ireturn
    //   90: aload 5
    //   92: ifnull +321 -> 413
    //   95: aload 5
    //   97: ldc 255
    //   99: invokeinterface 259 2 0
    //   104: iflt +309 -> 413
    //   107: aload 4
    //   109: ldc 255
    //   111: invokevirtual 263	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   114: ldc 8
    //   116: ldc_w 265
    //   119: invokestatic 77	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_1
    //   123: aload 4
    //   125: invokevirtual 269	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   128: aload_1
    //   129: invokevirtual 229	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   132: astore 4
    //   134: aload_0
    //   135: iload_2
    //   136: invokestatic 172	com/tencent/youtu/ytcommon/tools/YTCameraSetting:getVideoRotate	(Landroid/content/Context;I)I
    //   139: istore_3
    //   140: aload_1
    //   141: iload_3
    //   142: invokevirtual 272	android/hardware/Camera:setDisplayOrientation	(I)V
    //   145: ldc 8
    //   147: new 55	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 274
    //   157: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload_3
    //   161: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 77	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: iload_2
    //   171: iconst_4
    //   172: invokestatic 280	android/media/CamcorderProfile:hasProfile	(II)Z
    //   175: ifeq +339 -> 514
    //   178: iload_2
    //   179: iconst_4
    //   180: invokestatic 283	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   183: astore_0
    //   184: ldc 8
    //   186: new 55	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 285
    //   196: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_0
    //   200: getfield 288	android/media/CamcorderProfile:videoFrameWidth	I
    //   203: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: ldc_w 290
    //   209: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_0
    //   213: getfield 293	android/media/CamcorderProfile:videoFrameHeight	I
    //   216: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 77	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload 4
    //   227: aload_0
    //   228: invokestatic 297	com/tencent/youtu/ytcommon/tools/YTCameraSetting:setVideoSize	(Landroid/hardware/Camera$Parameters;Landroid/media/CamcorderProfile;)V
    //   231: aload 4
    //   233: getstatic 21	com/tencent/youtu/ytcommon/tools/YTCameraSetting:mDesiredPreviewWidth	I
    //   236: getstatic 23	com/tencent/youtu/ytcommon/tools/YTCameraSetting:mDesiredPreviewHeight	I
    //   239: invokevirtual 300	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   242: aload 4
    //   244: bipush 17
    //   246: invokevirtual 303	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   249: aload_1
    //   250: aload 4
    //   252: invokevirtual 269	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   255: aload_1
    //   256: invokevirtual 229	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   259: astore_0
    //   260: aload_0
    //   261: sipush 30000
    //   264: invokestatic 305	com/tencent/youtu/ytcommon/tools/YTCameraSetting:chooseFixedPreviewFps	(Landroid/hardware/Camera$Parameters;I)I
    //   267: istore_2
    //   268: ldc 8
    //   270: new 55	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 307
    //   280: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: iload_2
    //   284: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 77	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_1
    //   294: aload_0
    //   295: invokevirtual 269	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   298: aload_1
    //   299: invokevirtual 229	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   302: astore_0
    //   303: iconst_2
    //   304: newarray int
    //   306: astore_1
    //   307: aload_0
    //   308: aload_1
    //   309: invokevirtual 89	android/hardware/Camera$Parameters:getPreviewFpsRange	([I)V
    //   312: aload_0
    //   313: invokevirtual 310	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   316: istore_2
    //   317: ldc 8
    //   319: new 55	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 312
    //   329: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_1
    //   333: iconst_0
    //   334: iaload
    //   335: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: ldc_w 314
    //   341: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload_1
    //   345: iconst_1
    //   346: iaload
    //   347: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc_w 316
    //   353: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: iload_2
    //   357: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   360: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 77	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_0
    //   367: invokevirtual 320	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   370: astore_0
    //   371: ldc 8
    //   373: new 55	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 322
    //   383: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_0
    //   387: getfield 150	android/hardware/Camera$Size:width	I
    //   390: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: ldc 85
    //   395: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_0
    //   399: getfield 153	android/hardware/Camera$Size:height	I
    //   402: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 77	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: iconst_0
    //   412: ireturn
    //   413: aload 5
    //   415: ifnull +35 -> 450
    //   418: aload 5
    //   420: ldc_w 324
    //   423: invokeinterface 259 2 0
    //   428: iflt +22 -> 450
    //   431: aload 4
    //   433: ldc_w 324
    //   436: invokevirtual 263	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   439: ldc 8
    //   441: ldc_w 326
    //   444: invokestatic 77	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: goto -325 -> 122
    //   450: ldc 8
    //   452: ldc_w 328
    //   455: invokestatic 77	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: goto -336 -> 122
    //   461: astore 4
    //   463: ldc 8
    //   465: new 55	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 330
    //   475: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload 4
    //   480: invokevirtual 333	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   483: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 247	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload 4
    //   494: invokestatic 253	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   497: aload_1
    //   498: invokevirtual 229	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   501: astore 4
    //   503: goto -369 -> 134
    //   506: astore_0
    //   507: aload_1
    //   508: invokevirtual 229	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   511: pop
    //   512: aload_0
    //   513: athrow
    //   514: iload_2
    //   515: iconst_5
    //   516: invokestatic 280	android/media/CamcorderProfile:hasProfile	(II)Z
    //   519: ifeq +53 -> 572
    //   522: iload_2
    //   523: iconst_5
    //   524: invokestatic 283	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   527: astore_0
    //   528: ldc 8
    //   530: new 55	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 335
    //   540: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload_0
    //   544: getfield 288	android/media/CamcorderProfile:videoFrameWidth	I
    //   547: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   550: ldc_w 290
    //   553: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_0
    //   557: getfield 293	android/media/CamcorderProfile:videoFrameHeight	I
    //   560: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 77	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   569: goto -344 -> 225
    //   572: iload_2
    //   573: iconst_1
    //   574: invokestatic 283	android/media/CamcorderProfile:get	(II)Landroid/media/CamcorderProfile;
    //   577: astore_0
    //   578: ldc 8
    //   580: new 55	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 337
    //   590: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_0
    //   594: getfield 288	android/media/CamcorderProfile:videoFrameWidth	I
    //   597: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: ldc_w 290
    //   603: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload_0
    //   607: getfield 293	android/media/CamcorderProfile:videoFrameHeight	I
    //   610: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 77	com/tencent/youtu/ytcommon/tools/YTLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: goto -394 -> 225
    //   622: astore_0
    //   623: ldc 8
    //   625: new 55	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 330
    //   635: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_0
    //   639: invokevirtual 333	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   642: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 247	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: aload_0
    //   652: invokestatic 253	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   655: goto -400 -> 255
    //   658: astore_0
    //   659: ldc 8
    //   661: new 55	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   668: ldc_w 339
    //   671: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload_0
    //   675: invokevirtual 333	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   678: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 247	com/tencent/youtu/ytcommon/tools/YTLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   687: aload_0
    //   688: invokestatic 253	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   691: goto -393 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	694	0	paramContext	Context
    //   0	694	1	paramCamera	Camera
    //   0	694	2	paramInt	int
    //   14	147	3	i	int
    //   4	428	4	localParameters1	Camera.Parameters
    //   461	32	4	localException	java.lang.Exception
    //   501	1	4	localParameters2	Camera.Parameters
    //   11	408	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   0	6	76	java/lang/Exception
    //   122	128	461	java/lang/Exception
    //   122	128	506	finally
    //   463	497	506	finally
    //   249	255	622	java/lang/Exception
    //   293	298	658	java/lang/Exception
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
      YTLogger.d("YTCameraSetting", "video size from profile is : " + paramCamcorderProfile.videoFrameWidth + " " + paramCamcorderProfile.videoFrameHeight);
      if (getOptimalPreviewSize((List)localObject, paramCamcorderProfile.videoFrameWidth, paramCamcorderProfile.videoFrameHeight) == null)
      {
        YTLogger.d("YTCameraSetting", "do not find proper preview size, use default");
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
    YTLogger.d("YTCameraSetting", "select video size camcorderProfile:" + paramCamcorderProfile.videoFrameWidth + "x" + paramCamcorderProfile.videoFrameHeight);
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
    YTLogger.w("YTCameraSetting", "[YTCameraSetting.transBackFacingCameraRatateTag] unsurported rotateTag: " + paramInt);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.tools.YTCameraSetting
 * JD-Core Version:    0.7.0.1
 */