package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.onlinestatus.OlympicStatusResDownloader;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean.OlympicConfig;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class OlympicShareHelper
{
  public static int a(long paramLong)
  {
    if (paramLong <= 1000000L) {
      return 1;
    }
    if (paramLong <= 10000000L) {
      return 2;
    }
    return 3;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, int paramInt1, String paramString1, Bitmap paramBitmap4, int paramInt2, String paramString2, Bitmap paramBitmap5, int paramInt3, String paramString3)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(750, 1172, Bitmap.Config.ARGB_8888);
      if (localBitmap == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      a(paramBitmap1, 750, 1172, localCanvas);
      a(88, 780, 84, localCanvas);
      a(paramBitmap2, 88, 780, 84, localCanvas);
      a(paramInt1, paramString1, 188, 780, localCanvas);
      a(paramBitmap4, 188, 820, 32, 32, localCanvas);
      b(paramInt2, paramString2, 222, 824, localCanvas);
      b(378, 800, 42, localCanvas);
      b(paramBitmap5, 434, 775, 230, 90, localCanvas);
      c(paramInt3, paramString3, 434, 780, localCanvas);
      b(paramBitmap3, 590, 1026, 100, localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap1)
    {
      QLog.e("OlympicShareHelper", 1, "getOlympicShareBitmap out of Memory", paramBitmap1);
    }
    return null;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {
      localObject = Bitmap.Config.ARGB_8888;
    } else {
      localObject = Bitmap.Config.RGB_565;
    }
    Object localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramDrawable.draw(localCanvas);
    return localObject;
  }
  
  public static Bitmap a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OlympicShareHelper", 2, "getQRBitmap start");
    }
    Object localObject;
    int m;
    int i;
    int j;
    int k;
    try
    {
      localObject = b(paramString, 29);
      m = ((BitMatrix)localObject).a();
      paramString = new int[m * m];
      i = 0;
    }
    catch (Exception localException2)
    {
      localObject = null;
      paramString = (String)localObject;
      if (!QLog.isColorLevel()) {
        break label210;
      }
      QLog.i("OlympicShareHelper", 2, localException2.getMessage());
      paramString = (String)localObject;
      break label210;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      localObject = null;
    }
    if (j < m) {
      if (((BitMatrix)localObject).a(j, i)) {
        k = -16777216;
      }
    }
    label262:
    for (;;)
    {
      localObject = Bitmap.createBitmap(m, m, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, m);
      paramString = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
      try
      {
        new Canvas(paramString).drawBitmap((Bitmap)localObject, null, new Rect(0, 0, paramInt, paramInt), null);
        ((Bitmap)localObject).recycle();
      }
      catch (Exception localException1)
      {
        localObject = paramString;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject = paramString;
      }
      paramString = (String)localObject;
      if (QLog.isColorLevel())
      {
        QLog.i("OlympicShareHelper", 2, localOutOfMemoryError2.getMessage());
        paramString = (String)localObject;
      }
      label210:
      if (QLog.isColorLevel()) {
        QLog.i("OlympicShareHelper", 2, "getQRBitmap end");
      }
      return paramString;
      for (;;)
      {
        if (i >= m) {
          break label262;
        }
        j = 0;
        break;
        k = -1;
        paramString[(i * m + j)] = k;
        j += 1;
        break;
        i += 1;
      }
    }
  }
  
  public static URLDrawable a(boolean paramBoolean, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    if (paramBoolean) {
      paramString = URLDrawable.getFileDrawable(paramString, paramURLDrawableOptions);
    } else {
      paramString = URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
    }
    if (paramString.getStatus() == 1)
    {
      paramURLDrawableListener.onLoadSuccessed(paramString);
      return paramString;
    }
    paramString.setURLDrawableListener(paramURLDrawableListener);
    if (paramBoolean)
    {
      paramString.downloadImediatly(true);
      return paramString;
    }
    paramString.startDownload(true);
    return paramString;
  }
  
  /* Error */
  @android.annotation.TargetApi(8)
  public static String a(android.content.Context paramContext, String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 191	java/io/File
    //   9: dup
    //   10: ldc 193
    //   12: invokestatic 199	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   15: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 205	java/io/File:mkdirs	()Z
    //   23: pop
    //   24: aload_0
    //   25: ifnull +280 -> 305
    //   28: aload_0
    //   29: invokevirtual 208	java/io/File:canWrite	()Z
    //   32: ifeq +273 -> 305
    //   35: new 191	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: invokevirtual 211	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: aload_1
    //   44: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 211	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   52: astore 5
    //   54: aload_0
    //   55: invokevirtual 217	java/io/File:exists	()Z
    //   58: ifeq +8 -> 66
    //   61: aload_0
    //   62: invokevirtual 220	java/io/File:delete	()Z
    //   65: pop
    //   66: new 222	java/io/FileOutputStream
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 225	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_1
    //   75: new 227	java/io/BufferedOutputStream
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 230	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   83: astore 4
    //   85: aload_1
    //   86: astore_0
    //   87: aload 4
    //   89: astore_3
    //   90: aload_2
    //   91: getstatic 236	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   94: bipush 100
    //   96: aload 4
    //   98: invokevirtual 240	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   101: pop
    //   102: aload_1
    //   103: astore_0
    //   104: aload 4
    //   106: astore_3
    //   107: aload 4
    //   109: invokevirtual 243	java/io/BufferedOutputStream:flush	()V
    //   112: aload 4
    //   114: invokevirtual 246	java/io/BufferedOutputStream:close	()V
    //   117: aload_1
    //   118: invokevirtual 247	java/io/FileOutputStream:close	()V
    //   121: aload 5
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   129: aload 5
    //   131: areturn
    //   132: astore_0
    //   133: aload_1
    //   134: astore_2
    //   135: aload 4
    //   137: astore_1
    //   138: aload_0
    //   139: astore 4
    //   141: goto +61 -> 202
    //   144: astore_0
    //   145: aload_1
    //   146: astore_2
    //   147: aload 4
    //   149: astore_1
    //   150: aload_0
    //   151: astore 4
    //   153: goto +85 -> 238
    //   156: astore_0
    //   157: goto +28 -> 185
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_1
    //   165: astore_2
    //   166: aload_0
    //   167: astore_1
    //   168: goto +34 -> 202
    //   171: astore 4
    //   173: aconst_null
    //   174: astore_0
    //   175: aload_1
    //   176: astore_2
    //   177: aload_0
    //   178: astore_1
    //   179: goto +59 -> 238
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_0
    //   188: astore_2
    //   189: aload_1
    //   190: astore_0
    //   191: aload_2
    //   192: astore_1
    //   193: goto +83 -> 276
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_2
    //   200: aload_2
    //   201: astore_1
    //   202: aload_2
    //   203: astore_0
    //   204: aload_1
    //   205: astore_3
    //   206: aload 4
    //   208: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   211: aload_1
    //   212: ifnull +10 -> 222
    //   215: aload_1
    //   216: invokevirtual 246	java/io/BufferedOutputStream:close	()V
    //   219: goto +3 -> 222
    //   222: aload_2
    //   223: ifnull +82 -> 305
    //   226: aload_2
    //   227: invokevirtual 247	java/io/FileOutputStream:close	()V
    //   230: aconst_null
    //   231: areturn
    //   232: astore 4
    //   234: aconst_null
    //   235: astore_2
    //   236: aload_2
    //   237: astore_1
    //   238: aload_2
    //   239: astore_0
    //   240: aload_1
    //   241: astore_3
    //   242: aload 4
    //   244: invokevirtual 251	java/io/FileNotFoundException:printStackTrace	()V
    //   247: aload_1
    //   248: ifnull +10 -> 258
    //   251: aload_1
    //   252: invokevirtual 246	java/io/BufferedOutputStream:close	()V
    //   255: goto +3 -> 258
    //   258: aload_2
    //   259: ifnull +46 -> 305
    //   262: aload_2
    //   263: invokevirtual 247	java/io/FileOutputStream:close	()V
    //   266: aconst_null
    //   267: areturn
    //   268: astore_0
    //   269: aload_0
    //   270: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   273: aconst_null
    //   274: areturn
    //   275: astore_1
    //   276: aload_3
    //   277: ifnull +10 -> 287
    //   280: aload_3
    //   281: invokevirtual 246	java/io/BufferedOutputStream:close	()V
    //   284: goto +3 -> 287
    //   287: aload_0
    //   288: ifnull +15 -> 303
    //   291: aload_0
    //   292: invokevirtual 247	java/io/FileOutputStream:close	()V
    //   295: goto +8 -> 303
    //   298: astore_0
    //   299: aload_0
    //   300: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   303: aload_1
    //   304: athrow
    //   305: aconst_null
    //   306: areturn
    //   307: astore_0
    //   308: goto -191 -> 117
    //   311: astore_0
    //   312: goto -90 -> 222
    //   315: astore_0
    //   316: goto -58 -> 258
    //   319: astore_2
    //   320: goto -33 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramContext	android.content.Context
    //   0	323	1	paramString	String
    //   0	323	2	paramBitmap	Bitmap
    //   89	192	3	localObject1	Object
    //   83	69	4	localObject2	Object
    //   160	1	4	localIOException1	java.io.IOException
    //   171	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   196	11	4	localIOException2	java.io.IOException
    //   232	11	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   52	78	5	str	String
    // Exception table:
    //   from	to	target	type
    //   117	121	124	java/io/IOException
    //   90	102	132	java/io/IOException
    //   107	112	132	java/io/IOException
    //   90	102	144	java/io/FileNotFoundException
    //   107	112	144	java/io/FileNotFoundException
    //   75	85	156	finally
    //   75	85	160	java/io/IOException
    //   75	85	171	java/io/FileNotFoundException
    //   66	75	182	finally
    //   66	75	196	java/io/IOException
    //   66	75	232	java/io/FileNotFoundException
    //   226	230	268	java/io/IOException
    //   262	266	268	java/io/IOException
    //   90	102	275	finally
    //   107	112	275	finally
    //   206	211	275	finally
    //   242	247	275	finally
    //   291	295	298	java/io/IOException
    //   112	117	307	java/io/IOException
    //   215	219	311	java/io/IOException
    //   251	255	315	java/io/IOException
    //   280	284	319	java/io/IOException
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return paramString;
    }
    paramAppInterface = ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
    if (paramAppInterface != null) {
      return paramAppInterface.getFriendNick();
    }
    return paramString;
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt3);
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(6.0F);
    localPaint.setColor(Color.parseColor("#FEDE98"));
    paramCanvas.drawArc(localRectF, -90.0F, 360.0F, false, localPaint);
  }
  
  private static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(28.0F);
    localPaint.setFlags(1);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    paramInt1 = Math.max(2, paramString.length());
    Object localObject2 = paramString;
    if (localPaint.measureText(paramString) > 150.0F)
    {
      Object localObject1;
      do
      {
        paramInt1 -= 2;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString.substring(0, paramInt1));
        ((StringBuilder)localObject1).append("…");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = localObject1;
        if (paramInt1 <= 0) {
          break;
        }
        paramString = (String)localObject1;
      } while (localPaint.measureText((String)localObject1) > 150.0F);
      localObject2 = localObject1;
    }
    paramCanvas.drawText((String)localObject2, 188.0F, 808.0F, localPaint);
  }
  
  public static void a(long paramLong, Activity paramActivity, AppInterface paramAppInterface, OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback)
  {
    ThreadManagerV2.executeOnFileThread(new OlympicShareHelper.1(paramLong, paramAppInterface, paramActivity, paramIShareFinishCallback));
  }
  
  private static void a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Canvas paramCanvas)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      paramCanvas.drawBitmap(paramBitmap, null, new Rect(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2), localPaint);
    }
  }
  
  private static void a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, Canvas paramCanvas)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      Rect localRect = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt3);
      paramCanvas.drawBitmap(BaseImageUtil.c(paramBitmap, paramInt3, paramInt3), null, localRect, localPaint);
    }
  }
  
  private static void a(Bitmap paramBitmap, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
      localPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
    }
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      boolean bool = new File(paramString).exists();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static Bitmap b(OlympicConfBean.OlympicConfig paramOlympicConfig)
  {
    if (paramOlympicConfig.e == 0)
    {
      QLog.i("OlympicShareHelper", 2, "getQrCode qrCodeSwitch = 0");
      return null;
    }
    paramOlympicConfig = OnLineStatusHelper.a().f();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramOlympicConfig.n);
    ((StringBuilder)localObject).append("&from=");
    ((StringBuilder)localObject).append(3);
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareOlympicRank jumpUrl = ");
      localStringBuilder.append((String)localObject);
      QLog.i("OlympicShareHelper", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramOlympicConfig.n)) {
      return null;
    }
    return a((String)localObject, 100);
  }
  
  private static Drawable b(CountDownLatch paramCountDownLatch)
  {
    OnlineStatusItem localOnlineStatusItem = OnLineStatusHelper.a().f();
    if (localOnlineStatusItem == null)
    {
      QLog.e("OlympicShareHelper", 1, "getStatusIcon onlineStatusItem is null");
      return null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = 32;
    localURLDrawableOptions.mRequestHeight = 32;
    return a(false, localOnlineStatusItem.d, localURLDrawableOptions, new OlympicShareHelper.4(paramCountDownLatch));
  }
  
  private static BitMatrix b(String paramString, int paramInt)
  {
    Object localObject = new EnumMap(EncodeHintType.class);
    ((Map)localObject).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    ((Map)localObject).put(EncodeHintType.CHARACTER_SET, "UTF-8");
    ((Map)localObject).put(EncodeHintType.MARGIN, Integer.valueOf(0));
    QRCodeWriter localQRCodeWriter = new QRCodeWriter();
    try
    {
      paramString = localQRCodeWriter.a(paramString, 0, 0, (Map)localObject);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("encode error:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("OlympicShareHelper", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static String b(long paramLong)
  {
    int i = a(paramLong);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return "share/1/";
        }
        return "share/3/";
      }
      return "share/2/";
    }
    return "share/1/";
  }
  
  private static void b(int paramInt1, int paramInt2, int paramInt3, Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setStrokeWidth(2.0F);
    localPaint.setColor(Color.parseColor("#ffffff"));
    float f = paramInt1;
    paramCanvas.drawLine(f, paramInt2, f, paramInt2 + paramInt3, localPaint);
  }
  
  private static void b(int paramInt1, String paramString, int paramInt2, int paramInt3, Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(26.0F);
    localPaint.setFlags(1);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    paramInt1 = Math.max(2, paramString.length());
    Object localObject2 = paramString;
    if (localPaint.measureText(paramString) > 120.0F)
    {
      Object localObject1;
      do
      {
        paramInt1 -= 2;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString.substring(0, paramInt1));
        ((StringBuilder)localObject1).append("…");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = localObject1;
        if (paramInt1 <= 0) {
          break;
        }
        paramString = (String)localObject1;
      } while (localPaint.measureText((String)localObject1) > 150.0F);
      localObject2 = localObject1;
    }
    paramCanvas.drawText((String)localObject2, 222.0F, 850.0F, localPaint);
  }
  
  private static void b(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Canvas paramCanvas)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      paramCanvas.drawBitmap(paramBitmap, null, new Rect(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2), localPaint);
    }
  }
  
  private static void b(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, Canvas paramCanvas)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      paramCanvas.drawBitmap(paramBitmap, null, new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt3 + paramInt2), localPaint);
    }
  }
  
  private static URLDrawable c(long paramLong, CountDownLatch paramCountDownLatch)
  {
    String str = b(paramLong);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OlympicStatusResDownloader.b());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("share_share_bg.png");
    str = ((StringBuilder)localObject).toString();
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = 1172;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = 750;
    if (a(str)) {
      return a(true, str, (URLDrawable.URLDrawableOptions)localObject, new OlympicShareHelper.2(paramCountDownLatch));
    }
    QLog.e("OlympicShareHelper", 1, "getBackgroundBitmap background not ready");
    return null;
  }
  
  private static void c(int paramInt1, String paramString, int paramInt2, int paramInt3, Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(26.0F);
    localPaint.setFlags(1);
    localPaint.setTypeface(Typeface.create("sans-serif-condensed", 1));
    paramInt1 = Math.max(2, paramString.length());
    Object localObject2 = paramString;
    if (localPaint.measureText(paramString) > 230.0F)
    {
      Object localObject1;
      do
      {
        paramInt1 -= 2;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString.substring(0, paramInt1));
        ((StringBuilder)localObject1).append("…");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = localObject1;
        if (paramInt1 <= 0) {
          break;
        }
        paramString = (String)localObject1;
      } while (localPaint.measureText((String)localObject1) > 230.0F);
      localObject2 = localObject1;
    }
    paramCanvas.drawText((String)localObject2, paramInt2 + (230 - (int)localPaint.measureText((String)localObject2)) / 2, paramInt3 + 36, localPaint);
  }
  
  private static URLDrawable d(long paramLong, CountDownLatch paramCountDownLatch)
  {
    String str = b(paramLong);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OlympicStatusResDownloader.b());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("share_share_name_card.png");
    str = ((StringBuilder)localObject).toString();
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = 90;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = 230;
    if (a(str)) {
      return a(true, str, (URLDrawable.URLDrawableOptions)localObject, new OlympicShareHelper.3(paramCountDownLatch));
    }
    QLog.e("OlympicShareHelper", 1, "getRankBackgroundBitmap background not ready");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareHelper
 * JD-Core Version:    0.7.0.1
 */