package com.tencent.mobileqq.vas;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable.MutilePlayInfo;
import com.tencent.mobileqq.addon.DiyPendantDrawable;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class PendantInfo
  implements VipPendantDrawable.MutilePlayInfo
{
  static int jdField_a_of_type_Int = 1000;
  static ConcurrentHashMap<Long, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  static int jdField_b_of_type_Int = 20;
  public static int c;
  public static int d = 2;
  public static int e = 3;
  public static int f = 4;
  public static int g = 5;
  public static int h = 6;
  public static int i = 7;
  public static int j = -2147483648;
  public static int k = 100;
  public static int l = 2147483647;
  public static int m = 3;
  long jdField_a_of_type_Long;
  protected Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  PendantInfo.AnimationLruCache jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache;
  PendantInfo.DecodeNextFrameTask jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask;
  DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  protected Object a;
  String jdField_a_of_type_JavaLangString = null;
  final List<Long> jdField_a_of_type_JavaUtilList = new LinkedList();
  Map<String, Long> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public MqqHandler a;
  boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private String jdField_b_of_type_JavaLangString;
  protected boolean b;
  boolean c;
  int n;
  int o;
  int p;
  protected int q = -1;
  int r = m;
  private int s = 0;
  
  static
  {
    jdField_c_of_type_Int = 1;
  }
  
  public PendantInfo(long paramLong)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = paramLong;
    this.o = -1;
    this.p = -1;
    this.n = -1;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_MqqOsMqqHandler = new PendantInfo.1(this, Looper.getMainLooper(), null);
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)localQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY));
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache = new PendantInfo.AnimationLruCache(this, jdField_b_of_type_Int);
  }
  
  private int a(int paramInt, Integer paramInteger)
  {
    int i1 = paramInt;
    if (paramInteger != null)
    {
      i1 = paramInt;
      if (paramInteger.intValue() == 0)
      {
        i1 = paramInt;
        if (paramInt == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PendantInfo", 2, "static pendant, abort dynamic request");
          }
          this.o = 5;
          this.jdField_b_of_type_JavaLangString = AvatarPendantUtil.b(this.jdField_a_of_type_Long, this.o);
          StringBuilder localStringBuilder = AIOUtils.a();
          if (this.o == 2) {
            paramInteger = "dynamic_pendant";
          } else {
            paramInteger = "static_pendant";
          }
          localStringBuilder.append(paramInteger);
          localStringBuilder.append("_");
          localStringBuilder.append(this.jdField_a_of_type_Long);
          localStringBuilder.append("_");
          localStringBuilder.append(this.o);
          this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
          i1 = this.o;
        }
      }
    }
    return i1;
  }
  
  private int a(String paramString, int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    Object localObject;
    if (paramInt2 != -1)
    {
      int i2 = paramString.indexOf(",", paramInt2 + 6);
      i1 = paramInt1;
      if (i2 != -1) {
        localObject = paramString.substring(paramInt2 + 7, i2);
      }
    }
    try
    {
      i1 = Integer.parseInt(((String)localObject).trim());
      paramInt1 = i1;
      if (QLog.isColorLevel())
      {
        paramInt1 = i1;
        localObject = new StringBuilder();
        paramInt1 = i1;
        ((StringBuilder)localObject).append("pendant type=");
        paramInt1 = i1;
        ((StringBuilder)localObject).append(i1);
        paramInt1 = i1;
        QLog.d("PendantInfo", 2, ((StringBuilder)localObject).toString());
      }
      paramInt1 = i1;
      this.n = i1;
      paramInt1 = i1;
      AvatarPendantUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(i1));
    }
    catch (Exception localException)
    {
      label142:
      break label142;
    }
    a(1, 7, 0L);
    i1 = paramInt1;
    paramInt1 = paramString.indexOf("\"isDiy\":");
    if (paramInt1 != -1)
    {
      paramInt2 = paramString.indexOf(",", paramInt1 + 7);
      if (paramInt2 != -1) {
        paramString = paramString.substring(paramInt1 + 8, paramInt2);
      }
    }
    try
    {
      paramInt1 = Integer.parseInt(paramString.trim());
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("pendant isDiy=");
        paramString.append(paramInt1);
        QLog.d("PendantInfo", 2, paramString.toString());
      }
      AvatarPendantUtil.b.put(Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(paramInt1));
      return i1;
    }
    catch (Exception paramString)
    {
      label259:
      break label259;
    }
    a(1, 7, 0L);
    return i1;
  }
  
  @Nullable
  private Bitmap a(BitmapFactory.Options paramOptions, String paramString, InputStream paramInputStream, Bitmap paramBitmap, IllegalArgumentException paramIllegalArgumentException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doDecodeNext, IllegalArgumentException=");
    localStringBuilder.append(MsfSdkUtils.getStackTraceString(paramIllegalArgumentException));
    QLog.e("PendantInfo", 1, localStringBuilder.toString());
    paramOptions.inBitmap = null;
    paramOptions.inMutable = false;
    try
    {
      paramOptions = SafeBitmapFactory.decodeStream(new BufferedInputStream(paramInputStream), null, paramOptions);
      paramBitmap = paramOptions;
    }
    catch (Exception paramOptions)
    {
      paramInputStream = new StringBuilder();
      paramInputStream.append("doDecodeNext, try not reuse bitmap, exception=");
      paramInputStream.append(MsfSdkUtils.getStackTraceString(paramOptions));
      QLog.e("PendantInfo", 1, paramInputStream.toString());
    }
    catch (OutOfMemoryError paramOptions)
    {
      paramInputStream = new StringBuilder();
      paramInputStream.append("doDecodeNext, try not reuse bitmap, oom=");
      paramInputStream.append(MsfSdkUtils.getStackTraceString(paramOptions));
      QLog.e("PendantInfo", 1, paramInputStream.toString());
    }
    paramOptions = new StringBuilder();
    paramOptions.append("doDecodeNext, maybe reuse failed, path=");
    paramOptions.append(paramString);
    QLog.e("PendantInfo", 1, paramOptions.toString());
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      paramOptions = new StringBuilder();
      paramOptions.append("doDecodeNext, mRecycleBitmap width=");
      paramOptions.append(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
      paramOptions.append(", height=");
      paramOptions.append(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      QLog.e("PendantInfo", 1, paramOptions.toString());
    }
    if (paramBitmap != null)
    {
      paramOptions = new StringBuilder();
      paramOptions.append("doDecodeNext, bitmap width=");
      paramOptions.append(paramBitmap.getWidth());
      paramOptions.append(", height=");
      paramOptions.append(paramBitmap.getHeight());
      QLog.e("PendantInfo", 1, paramOptions.toString());
    }
    return paramBitmap;
  }
  
  @Nullable
  private Bitmap a(PendantInfo.SourcesBigPng paramSourcesBigPng)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi;
    if (localOptions.inDensity < localOptions.inTargetDensity) {
      localOptions.inDensity = localOptions.inTargetDensity;
    }
    try
    {
      paramSourcesBigPng = SafeBitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramSourcesBigPng.jdField_a_of_type_JavaLangString)), null, localOptions);
      return paramSourcesBigPng;
    }
    catch (OutOfMemoryError paramSourcesBigPng)
    {
      label76:
      break label76;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PendantInfo", 2, "decodeFile failed OOM");
    }
    return null;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private BufferedInputStream a(BitmapFactory.Options paramOptions, String paramString, BufferedInputStream paramBufferedInputStream)
  {
    BufferedInputStream localBufferedInputStream = paramBufferedInputStream;
    if (Build.VERSION.SDK_INT > 11)
    {
      localBufferedInputStream = paramBufferedInputStream;
      if (paramOptions.inDensity <= paramOptions.inTargetDensity)
      {
        paramBufferedInputStream = new BitmapFactory.Options();
        paramBufferedInputStream.inJustDecodeBounds = true;
        localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramString));
        BitmapFactory.decodeStream(localBufferedInputStream, null, paramBufferedInputStream);
        paramString = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((paramString != null) && (FriendProfileCardBgDrawable.a(paramString, paramBufferedInputStream.outWidth, paramBufferedInputStream.outHeight))) {
          paramOptions.inBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
        } else {
          paramOptions.inBitmap = null;
        }
        paramOptions.inMutable = true;
        paramOptions.inSampleSize = 1;
      }
    }
    return localBufferedInputStream;
  }
  
  private void a(long paramLong1, long paramLong2, File paramFile)
  {
    if (paramFile.exists())
    {
      File localFile = new File(AvatarPendantUtil.b(paramLong1, 8));
      if (DownloaderFactory.a(paramFile, localFile, true))
      {
        a();
        paramFile = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(20);
        if (a(paramFile, paramLong2)) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramFile);
        }
      }
      else
      {
        if (paramFile.exists()) {
          paramFile.delete();
        }
        if (localFile.exists()) {
          localFile.delete();
        }
      }
    }
  }
  
  private void a(Message paramMessage)
  {
    if (paramMessage.what == 16)
    {
      c(paramMessage);
      return;
    }
    if (paramMessage.what == 17)
    {
      f(paramMessage);
      return;
    }
    if (paramMessage.what == 18)
    {
      b(paramMessage);
      return;
    }
    if (paramMessage.what == 19)
    {
      d(paramMessage);
      return;
    }
    if (paramMessage.what == 20) {
      e(paramMessage);
    }
  }
  
  /* Error */
  private void a(File paramFile, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: aload_0
    //   2: getfield 108	com/tencent/mobileqq/vas/PendantInfo:p	I
    //   5: if_icmpne +250 -> 255
    //   8: iload_2
    //   9: iconst_2
    //   10: if_icmpne +245 -> 255
    //   13: getstatic 54	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: aload_0
    //   17: getfield 104	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_Long	J
    //   20: invokestatic 244	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   23: invokevirtual 445	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   26: ifeq +85 -> 111
    //   29: aload_0
    //   30: getstatic 54	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: aload_0
    //   34: getfield 104	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_Long	J
    //   37: invokestatic 244	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   40: invokevirtual 449	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 161	java/lang/Integer
    //   46: invokevirtual 165	java/lang/Integer:intValue	()I
    //   49: putfield 108	com/tencent/mobileqq/vas/PendantInfo:p	I
    //   52: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +200 -> 255
    //   58: new 196	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   65: astore_1
    //   66: aload_1
    //   67: ldc_w 451
    //   70: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_1
    //   75: aload_0
    //   76: getfield 108	com/tencent/mobileqq/vas/PendantInfo:p	I
    //   79: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_1
    //   84: ldc_w 453
    //   87: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: aload_0
    //   93: getfield 104	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_Long	J
    //   96: invokevirtual 205	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 173
    //   102: iconst_2
    //   103: aload_1
    //   104: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: return
    //   111: aload_3
    //   112: astore 4
    //   114: aload_3
    //   115: ifnonnull +134 -> 249
    //   118: aload_3
    //   119: astore 4
    //   121: aload_1
    //   122: invokevirtual 393	java/io/File:exists	()Z
    //   125: ifeq +124 -> 249
    //   128: aload_1
    //   129: invokestatic 459	com/tencent/mobileqq/utils/FileUtils:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   132: astore 4
    //   134: goto +115 -> 249
    //   137: new 196	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   144: astore 4
    //   146: aload 4
    //   148: ldc_w 461
    //   151: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 4
    //   157: aload_1
    //   158: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: ldc 173
    //   164: iconst_2
    //   165: aload 4
    //   167: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_3
    //   174: astore 4
    //   176: goto +73 -> 249
    //   179: astore 5
    //   181: aload_3
    //   182: astore 4
    //   184: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +62 -> 249
    //   190: new 196	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   197: astore 4
    //   199: aload 4
    //   201: ldc_w 466
    //   204: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 4
    //   210: aload_1
    //   211: invokevirtual 464	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 4
    //   217: ldc_w 468
    //   220: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 4
    //   226: aload 5
    //   228: invokestatic 274	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   231: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: ldc 173
    //   237: iconst_2
    //   238: aload 4
    //   240: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload_3
    //   247: astore 4
    //   249: aload_0
    //   250: aload 4
    //   252: invokevirtual 470	com/tencent/mobileqq/vas/PendantInfo:a	(Ljava/lang/String;)V
    //   255: return
    //   256: astore 4
    //   258: goto -121 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	PendantInfo
    //   0	261	1	paramFile	File
    //   0	261	2	paramInt	int
    //   0	261	3	paramString	String
    //   112	139	4	localObject	Object
    //   256	1	4	localOutOfMemoryError	OutOfMemoryError
    //   179	48	5	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   128	134	179	java/io/IOException
    //   128	134	256	java/lang/OutOfMemoryError
  }
  
  static boolean a(Message paramMessage, long paramLong)
  {
    Bundle localBundle = paramMessage.getData();
    if (localBundle == null)
    {
      localBundle = new Bundle();
      localBundle.putLong("targetId", paramLong);
      paramMessage.setData(localBundle);
      return true;
    }
    try
    {
      localBundle.putLong("targetId", paramLong);
      return true;
    }
    catch (ClassCastException paramMessage)
    {
      label42:
      break label42;
    }
    QLog.e("PendantInfo", 1, "pendant can not display because of system error!");
    return false;
  }
  
  private void b(Message paramMessage)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.o == 2) && (this.r > 0))
    {
      b(paramMessage.getData().getLong("targetId"));
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.o == 1)) {
      d();
    }
  }
  
  private void c(long paramLong)
  {
    try
    {
      if (g == paramLong)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Drawable)((Iterator)localObject1).next();
          if (localObject2 != null) {
            ((Drawable)localObject2).invalidateSelf();
          }
        }
      }
      Object localObject1 = (Drawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(paramLong));
      if (localObject1 != null)
      {
        ((Drawable)localObject1).invalidateSelf();
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleMessage, exception:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.d("PendantInfo", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void c(long paramLong, int paramInt)
  {
    int i1 = this.n;
    Object localObject;
    if ((i1 != -1) && (this.p != -1))
    {
      if (i1 != 0)
      {
        localObject = this.jdField_a_of_type_MqqOsMqqHandler;
        if (localObject != null)
        {
          localObject = ((MqqHandler)localObject).obtainMessage(20);
          if (a((Message)localObject, paramLong)) {
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
          }
        }
      }
    }
    else
    {
      if (a(new File(AvatarPendantUtil.b(this.jdField_a_of_type_Long, 4)), paramInt) > -1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        if (this.n == 0)
        {
          QLog.d("PendantInfo", 2, "static type request dynamic resources");
          return;
        }
        localObject = this.jdField_a_of_type_MqqOsMqqHandler;
        if (localObject != null)
        {
          localObject = ((MqqHandler)localObject).obtainMessage(20);
          if (a((Message)localObject, paramLong)) {
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
          }
        }
      }
      else
      {
        a(paramInt, paramLong);
      }
    }
  }
  
  private void c(Message paramMessage)
  {
    long l1 = paramMessage.getData().getLong("targetId");
    if (g == l1)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
      while (paramMessage.hasNext())
      {
        Drawable localDrawable = (Drawable)paramMessage.next();
        if (localDrawable != null) {
          localDrawable.invalidateSelf();
        }
      }
    }
    paramMessage = (Drawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l1));
    if (paramMessage != null) {
      paramMessage.invalidateSelf();
    }
  }
  
  private void d(Message paramMessage)
  {
    long l1 = paramMessage.getData().getLong("targetId");
    if (g == l1)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
      while (paramMessage.hasNext())
      {
        Drawable localDrawable = (Drawable)paramMessage.next();
        if (localDrawable != null) {
          a(localDrawable, true, 0L);
        }
      }
    }
    paramMessage = (Drawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l1));
    if (paramMessage != null) {
      a(paramMessage, false, 0L);
    }
  }
  
  private void e(Message paramMessage)
  {
    long l1 = paramMessage.getData().getLong("targetId");
    if (g == l1)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
      while (paramMessage.hasNext())
      {
        Drawable localDrawable = (Drawable)paramMessage.next();
        if ((localDrawable != null) && ((localDrawable instanceof VipPendantDrawable))) {
          a((VipPendantDrawable)localDrawable, l1);
        }
      }
    }
    paramMessage = (Drawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l1));
    if ((paramMessage != null) && ((paramMessage instanceof VipPendantDrawable))) {
      a((VipPendantDrawable)paramMessage, l1);
    }
  }
  
  private void f(Message paramMessage)
  {
    this.jdField_b_of_type_Boolean = true;
    this.q = a(this.q);
    if ((paramMessage.obj instanceof Bitmap))
    {
      localObject = (Bitmap)paramMessage.obj;
      if ((localObject != null) && (b() != localObject))
      {
        Bitmap localBitmap = a();
        if (localBitmap != null) {
          if ((localBitmap.isMutable()) && (Build.VERSION.SDK_INT > 11))
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
          }
          else
          {
            localBitmap.recycle();
            this.jdField_a_of_type_AndroidGraphicsBitmap = null;
          }
        }
        a((Bitmap)localObject);
      }
      long l1 = paramMessage.getData().getLong("targetId");
      c(l1);
      if (2 == this.o)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          paramMessage = new StringBuilder();
          paramMessage.append("cancel decode pendant in market:");
          paramMessage.append(this.jdField_a_of_type_Long);
          QLog.d("PendantInfo", 2, paramMessage.toString());
          this.jdField_c_of_type_Boolean = false;
          l1 = g;
          this.q = 0;
          this.r = 3;
        }
        if (this.r == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = null;
          return;
        }
        b(l1);
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("wrong type , msg.obj = ");
    ((StringBuilder)localObject).append(paramMessage.obj.getClass());
    QLog.d("PendantInfo", 2, ((StringBuilder)localObject).toString());
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == this.s - 1)
    {
      this.r -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  int a(File paramFile, int paramInt)
  {
    if (paramFile == null) {
      return -1;
    }
    Integer localInteger2 = (Integer)AvatarPendantUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(this.jdField_a_of_type_Long));
    Object localObject3 = null;
    Object localObject2 = null;
    Integer localInteger1 = localInteger2;
    Object localObject1 = localObject3;
    if (paramFile.exists()) {
      if (localInteger2 != null)
      {
        localInteger1 = localInteger2;
        localObject1 = localObject3;
        if (-1 != this.n) {}
      }
      else
      {
        localObject1 = FileUtils.fileToBytes(paramFile);
        int i1;
        if (localObject1 != null)
        {
          localObject1 = new String((byte[])localObject1);
          i1 = a((String)localObject1, -2147483648, ((String)localObject1).indexOf("\"type\":"));
        }
        else
        {
          i1 = -2147483648;
          localObject1 = localObject2;
        }
        if (i1 == -2147483648)
        {
          paramFile.delete();
          a(1, 7, 0L);
          localInteger1 = localInteger2;
        }
        else
        {
          localInteger1 = (Integer)AvatarPendantUtil.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(this.jdField_a_of_type_Long));
        }
      }
    }
    a(paramFile, paramInt, (String)localObject1);
    return a(paramInt, localInteger1);
  }
  
  public Bitmap a()
  {
    return b();
  }
  
  @TargetApi(11)
  protected Bitmap a(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      if (paramObject == null)
      {
        this.jdField_b_of_type_Boolean = true;
        return null;
      }
      Object localObject3 = new BitmapFactory.Options();
      paramObject = (String[])paramObject;
      String str = paramObject[((paramInt2 + 1) % paramObject.length)];
      ((BitmapFactory.Options)localObject3).inDensity = 320;
      ((BitmapFactory.Options)localObject3).inTargetDensity = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi;
      if (((BitmapFactory.Options)localObject3).inDensity < ((BitmapFactory.Options)localObject3).inTargetDensity) {
        ((BitmapFactory.Options)localObject3).inDensity = ((BitmapFactory.Options)localObject3).inTargetDensity;
      }
      FileInputStream localFileInputStream = new FileInputStream(str);
      Object localObject2 = null;
      try
      {
        paramObject = a((BitmapFactory.Options)localObject3, str, null);
        try
        {
          Bitmap localBitmap1 = SafeBitmapFactory.decodeStream(new BufferedInputStream(localFileInputStream), null, (BitmapFactory.Options)localObject3);
        }
        catch (IllegalArgumentException localIllegalArgumentException1) {}catch (OutOfMemoryError localOutOfMemoryError1) {}
        Bitmap localBitmap2;
        localObject3 = new StringBuilder();
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        paramObject = null;
        localBitmap2 = a((BitmapFactory.Options)localObject3, str, localFileInputStream, null, localIllegalArgumentException2);
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        paramObject = null;
      }
      ((StringBuilder)localObject3).append("doDecodeNext, oom=");
      ((StringBuilder)localObject3).append(MsfSdkUtils.getStackTraceString(localOutOfMemoryError2));
      QLog.e("PendantInfo", 1, ((StringBuilder)localObject3).toString());
      Object localObject1 = localObject2;
      if (paramObject != null) {}
      try
      {
        paramObject.close();
        localFileInputStream.close();
        return localObject1;
      }
      catch (IOException paramObject)
      {
        paramObject.printStackTrace();
        return localObject1;
      }
    }
    return a((PendantInfo.SourcesBigPng)paramObject);
  }
  
  public Drawable a(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.o = paramInt1;
    Object localObject2 = AIOUtils.a();
    Object localObject1;
    if (this.o == 2) {
      localObject1 = "dynamic_pendant";
    } else {
      localObject1 = "static_pendant";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.o);
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    localObject2 = (Drawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(paramLong));
    if ((!TextUtils.isEmpty(paramString)) && (paramInt2 > 0))
    {
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof DiyPendantDrawable)) {}
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(paramInt2);
        paramString = ((StringBuilder)localObject1).toString();
        localObject1 = new DiyPendantDrawable(BaseApplicationImpl.getApplication().getResources());
        ((DiyPendantDrawable)localObject1).b(paramString);
        ((DiyPendantDrawable)localObject1).a(this);
        this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.put(Long.valueOf(paramLong), localObject1);
      }
    }
    else if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!(localObject2 instanceof DiyPendantDrawable)) {}
    }
    else
    {
      localObject1 = new VipPendantDrawable(BaseApplicationImpl.getApplication().getResources());
      ((VipPendantDrawable)localObject1).a(this);
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.put(Long.valueOf(paramLong), localObject1);
    }
    ThreadManager.post(new PendantInfo.2(this, paramInt1, paramLong, (Drawable)localObject1), 8, null, true);
    return localObject1;
  }
  
  void a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (localObject1 != null) {
        return;
      }
      localObject1 = AvatarPendantUtil.b(this.jdField_a_of_type_Long, 8);
      if (FileUtils.fileExists((String)localObject1))
      {
        Object localObject3 = FileUtils.getChildFiles((String)localObject1);
        int i1 = ((ArrayList)localObject3).size();
        if (i1 <= 0) {
          return;
        }
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[((ArrayList)localObject3).size()];
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(File.separator);
        localObject1 = ((StringBuilder)localObject3).toString();
        i1 = 0;
        int i3 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
        while (i1 < i3)
        {
          localObject3 = this.jdField_a_of_type_ArrayOfJavaLangString;
          StringBuilder localStringBuilder = AIOUtils.a();
          localStringBuilder.append((String)localObject1);
          int i2 = i1 + 1;
          localStringBuilder.append(i2);
          localStringBuilder.append(".png");
          localObject3[i1] = localStringBuilder.toString();
          i1 = i2;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void a(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("download pendant report actionResult=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",pendantId=");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append(",type=");
        localStringBuilder.append(paramInt2);
        QLog.i("PendantInfo", 2, localStringBuilder.toString());
      }
      int i1 = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_AndroidContentContext);
      if (paramLong < 3600000L)
      {
        VasWebviewUtil.a("AvatarPendant", "download", String.valueOf(this.jdField_a_of_type_Long), 0, 0, paramInt1, i1, String.valueOf(paramLong), String.valueOf(paramInt2));
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void a(int paramInt, long paramLong)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    File localFile = new File(AvatarPendantUtil.b(this.jdField_a_of_type_Long, 4));
    if (!localFile.exists())
    {
      ((IVasQuickUpdateService)localQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(4L, AvatarPendantUtil.a(this.jdField_a_of_type_Long, 4), "PendantInfo");
      this.jdField_a_of_type_JavaUtilMap.put(AvatarPendantUtil.a(this.jdField_a_of_type_Long, 4), Long.valueOf(paramInt));
      return;
    }
    paramInt = a(localFile, paramInt);
    if (paramInt > -1) {
      a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    File localFile = new File(AvatarPendantUtil.b(this.jdField_a_of_type_Long, 4));
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(AvatarPendantUtil.a(this.jdField_a_of_type_Long, 4))) {
      i1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(AvatarPendantUtil.a(this.jdField_a_of_type_Long, 4))).intValue();
    } else {
      i1 = 1;
    }
    int i1 = a(localFile, i1);
    if (i1 > -1) {
      a(paramLong, i1);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (paramInt == 2) {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        StringBuilder localStringBuilder;
        if (this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(this.jdField_a_of_type_Long)))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("downloadPendantDrawable pendant ");
            localStringBuilder.append(this.jdField_a_of_type_Long);
            localStringBuilder.append(" is downloading");
            QLog.d("PendantInfo", 2, localStringBuilder.toString());
          }
          return;
        }
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(this.jdField_a_of_type_Long));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadPendantDrawable pendant ");
          localStringBuilder.append(this.jdField_a_of_type_Long);
          localStringBuilder.append(" add to list");
          QLog.d("PendantInfo", 2, localStringBuilder.toString());
        }
      }
    }
    ??? = a();
    if (??? == null) {
      return;
    }
    ((IVasQuickUpdateService)((QQAppInterface)???).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(4L, AvatarPendantUtil.a(this.jdField_a_of_type_Long, paramInt), "PendantInfo");
    this.jdField_a_of_type_JavaUtilMap.put(AvatarPendantUtil.a(this.jdField_a_of_type_Long, paramInt), Long.valueOf(paramLong));
  }
  
  void a(Bitmap paramBitmap)
  {
    int i1 = Utils.a(paramBitmap);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramBitmap);
    localBitmapDrawable.setTargetDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics());
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PendantInfo", 4, "setPendantBitmap cache key equal null");
      }
      StringBuilder localStringBuilder = AIOUtils.a();
      if (this.o == 2) {
        paramBitmap = "dynamic_pendant";
      } else {
        paramBitmap = "static_pendant";
      }
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("_");
      localStringBuilder.append(this.o);
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
    GlobalImageCache.a.put(this.jdField_a_of_type_JavaLangString, new Pair(localBitmapDrawable.getConstantState(), Integer.valueOf(i1)));
  }
  
  void a(Drawable paramDrawable, boolean paramBoolean, long paramLong)
  {
    if (paramDrawable == null) {
      return;
    }
    try
    {
      d();
      this.r = 0;
      if ((paramDrawable instanceof VipPendantDrawable)) {
        ((VipPendantDrawable)paramDrawable).a(this.jdField_b_of_type_JavaLangString);
      }
      paramDrawable = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16);
      if (paramBoolean) {
        paramLong = g;
      }
      if (a(paramDrawable, paramLong)) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramDrawable);
      }
      return;
    }
    finally {}
  }
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt, paramLong, "", 0);
  }
  
  public void a(View paramView, int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    if (SimpleUIUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("PendantInfo", 2, "setDrawable, SimpleUIMode is open now");
      }
      return;
    }
    this.jdField_b_of_type_JavaLangString = AvatarPendantUtil.b(this.jdField_a_of_type_Long, paramInt1);
    paramString = a(paramInt1, paramLong, paramString, paramInt2);
    if ((paramView instanceof BaseChatItemLayout))
    {
      ((BaseChatItemLayout)paramView).setPendantImage(paramString);
      return;
    }
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(paramString);
    }
  }
  
  void a(VipPendantDrawable paramVipPendantDrawable, long paramLong)
  {
    if (paramVipPendantDrawable != null)
    {
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (arrayOfString == null) {
        return;
      }
      paramVipPendantDrawable.a(arrayOfString, this.p);
      paramVipPendantDrawable = this.jdField_a_of_type_ArrayOfJavaLangString;
      this.jdField_a_of_type_JavaLangObject = paramVipPendantDrawable;
      this.s = paramVipPendantDrawable.length;
      boolean bool;
      if ((!this.jdField_c_of_type_Boolean) && (this.r > 3)) {
        bool = true;
      } else {
        bool = false;
      }
      int i1 = i;
      if (paramLong == i1)
      {
        this.jdField_c_of_type_Boolean = false;
        this.r = l;
        b(i1);
      }
      else if (!bool)
      {
        this.r = m;
        b(g);
      }
      if (QLog.isColorLevel())
      {
        paramVipPendantDrawable = new StringBuilder();
        paramVipPendantDrawable.append("setPngsDrawable repeatCount:");
        paramVipPendantDrawable.append(this.r);
        paramVipPendantDrawable.append(",targetID:");
        paramVipPendantDrawable.append(paramLong);
        paramVipPendantDrawable.append(",pendantInMarket:");
        paramVipPendantDrawable.append(bool);
        QLog.d("PendantInfo", 2, paramVipPendantDrawable.toString());
      }
    }
  }
  
  void a(String paramString)
  {
    if (paramString != null)
    {
      i1 = paramString.indexOf("\"interval\":");
      if (i1 != -1)
      {
        int i2 = paramString.indexOf(",", i1 + 10);
        if (i2 != -1)
        {
          paramString = paramString.substring(i1 + 11, i2);
          if (paramString == null) {}
        }
      }
    }
    try
    {
      i1 = Integer.parseInt(paramString.trim());
    }
    catch (Exception paramString)
    {
      label58:
      break label58;
    }
    int i1 = -2147483648;
    if (-2147483648 != i1)
    {
      this.p = i1;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.p));
      return;
    }
    this.p = k;
    a(1, 7, 0L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(18);
      if (a(localMessage, g))
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, jdField_a_of_type_Int);
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bundle exception");
      localStringBuilder.append(localException.getMessage());
      QLog.e("PendantInfo", 2, localStringBuilder.toString());
    }
  }
  
  boolean a()
  {
    Pair localPair = (Pair)GlobalImageCache.a.get(this.jdField_a_of_type_JavaLangString);
    return (localPair != null) && (localPair.first != null);
  }
  
  Bitmap b()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PendantInfo", 4, "getPendantBitmap cache key equal null");
      }
      StringBuilder localStringBuilder = AIOUtils.a();
      if (this.o == 2) {
        localObject = "dynamic_pendant";
      } else {
        localObject = "static_pendant";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("_");
      localStringBuilder.append(this.o);
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
    if (GlobalImageCache.a != null) {
      localObject = (Pair)GlobalImageCache.a.get(this.jdField_a_of_type_JavaLangString);
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Pair)localObject).first != null)) {
      return ((BitmapDrawable)((Drawable.ConstantState)((Pair)localObject).first).newDrawable(BaseApplicationImpl.getApplication().getResources())).getBitmap();
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void b(long paramLong)
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.p;
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = new PendantInfo.DecodeNextFrameTask(this, this.jdField_a_of_type_ArrayOfJavaLangString, paramLong);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.q), Long.valueOf(this.o) });
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeBigImage, e=");
        localStringBuilder.append(MsfSdkUtils.getStackTraceString(localException));
        QLog.e("PendantInfo", 1, localStringBuilder.toString());
      }
    }
  }
  
  void b(long paramLong, int paramInt)
  {
    long l1 = g;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(AvatarPendantUtil.a(this.jdField_a_of_type_Long, paramInt))) {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(AvatarPendantUtil.a(this.jdField_a_of_type_Long, paramInt))).longValue();
    }
    if ((2 == paramInt) && (this.n == 1))
    {
      a(paramLong, l1, new File(AvatarPendantUtil.b(paramLong, paramInt)));
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        StringBuilder localStringBuilder;
        if (this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramLong)))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onDoneDownloadImage remove ");
            localStringBuilder.append(paramLong);
            localStringBuilder.append(" from list");
            QLog.d("PendantInfo", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(paramLong));
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDoneDownloadImage remove ");
          localStringBuilder.append(paramLong);
          localStringBuilder.append(" fail, list not contain");
          QLog.d("PendantInfo", 2, localStringBuilder.toString());
        }
        return;
      }
    }
    ??? = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(19);
    if (a((Message)???, g)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)???);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.clear();
    e();
  }
  
  void d()
  {
    try
    {
      if (((this.jdField_a_of_type_JavaLangObject instanceof PendantInfo.SourcesBigPng)) && (a()))
      {
        if ((this.jdField_a_of_type_JavaLangObject != null) && (((PendantInfo.SourcesBigPng)this.jdField_a_of_type_JavaLangObject).jdField_a_of_type_JavaLangString != null) && (((PendantInfo.SourcesBigPng)this.jdField_a_of_type_JavaLangObject).jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) {
          break label244;
        }
        if (this.jdField_a_of_type_Boolean) {}
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask != null)
      {
        Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16);
        if (!a(localMessage, g)) {
          return;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
        return;
      }
      this.jdField_a_of_type_JavaLangObject = new PendantInfo.SourcesBigPng(this, this.jdField_b_of_type_JavaLangString);
      this.r = 0;
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = new PendantInfo.DecodeNextFrameTask(this, this.jdField_a_of_type_JavaLangObject, g);
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.p;
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.q), Long.valueOf(this.o) });
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeBigImage, e=");
      localStringBuilder.append(MsfSdkUtils.getStackTraceString(localException));
      QLog.e("PendantInfo", 1, localStringBuilder.toString());
      return;
    }
    label244:
    return;
  }
  
  public void e()
  {
    PendantInfo.DecodeNextFrameTask localDecodeNextFrameTask = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask;
    if (localDecodeNextFrameTask != null)
    {
      localDecodeNextFrameTask.cancel(false);
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = null;
    }
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo
 * JD-Core Version:    0.7.0.1
 */