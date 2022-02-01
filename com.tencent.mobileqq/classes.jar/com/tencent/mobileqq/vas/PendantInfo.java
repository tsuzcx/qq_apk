package com.tencent.mobileqq.vas;

import agej;
import agmb;
import agmc;
import amru;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import bdgb;
import bhjx;
import bhkt;
import bhmi;
import bhnv;
import bhyq;
import bhyr;
import bhys;
import bihw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PendantInfo
  implements agmc
{
  static int jdField_a_of_type_Int = 1000;
  static ConcurrentHashMap<Long, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
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
  public bhyr a;
  bihw jdField_a_of_type_Bihw = null;
  public PendantInfo.AnimationLruCache a;
  protected Object a;
  String jdField_a_of_type_JavaLangString = null;
  final List<Long> jdField_a_of_type_JavaUtilList = new LinkedList();
  Map<String, Long> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public MqqHandler a;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  boolean c;
  int n;
  public int o;
  int p;
  protected int q = -1;
  public int r = m;
  private int s;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
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
    this.jdField_a_of_type_MqqOsMqqHandler = new bhyq(this, Looper.getMainLooper(), null);
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_Bihw = ((bihw)localQQAppInterface.getManager(47));
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache = new PendantInfo.AnimationLruCache(this, jdField_b_of_type_Int);
  }
  
  private int a(String paramString, int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    String str;
    if (paramInt2 != -1)
    {
      int i2 = paramString.indexOf(",", paramInt2 + 6);
      i1 = paramInt1;
      if (i2 != -1) {
        str = paramString.substring(paramInt2 + 7, i2);
      }
    }
    try
    {
      i1 = Integer.parseInt(str.trim());
      paramInt1 = i1;
      if (QLog.isColorLevel())
      {
        paramInt1 = i1;
        QLog.d("PendantInfo", 2, "pendant type=" + i1);
      }
      paramInt1 = i1;
      this.n = i1;
      paramInt1 = i1;
      bhkt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(i1));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramInt1 = Integer.parseInt(paramString.trim());
          if (QLog.isColorLevel()) {
            QLog.d("PendantInfo", 2, "pendant isDiy=" + paramInt1);
          }
          bhkt.b.put(Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(paramInt1));
          return i1;
        }
        catch (Exception paramString)
        {
          a(1, 7, 0L);
        }
        localException = localException;
        a(1, 7, 0L);
        i1 = paramInt1;
      }
    }
    paramInt1 = paramString.indexOf("\"isDiy\":");
    if (paramInt1 != -1)
    {
      paramInt2 = paramString.indexOf(",", paramInt1 + 7);
      if (paramInt2 != -1) {
        paramString = paramString.substring(paramInt1 + 8, paramInt2);
      }
    }
    return i1;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(Message paramMessage)
  {
    long l1 = paramMessage.getData().getLong("targetId");
    if (g == l1)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
      while (paramMessage.hasNext())
      {
        Drawable localDrawable = (Drawable)paramMessage.next();
        if ((localDrawable != null) && ((localDrawable instanceof agmb))) {
          a((agmb)localDrawable, l1);
        }
      }
    }
    paramMessage = (Drawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l1));
    if ((paramMessage != null) && ((paramMessage instanceof agmb))) {
      a((agmb)paramMessage, l1);
    }
  }
  
  public static boolean a(Message paramMessage, long paramLong)
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
      QLog.e("PendantInfo", 1, "pendant can not display because of system error!");
    }
    return false;
  }
  
  private void b(Message paramMessage)
  {
    this.jdField_b_of_type_Boolean = true;
    this.q = a(this.q);
    Bitmap localBitmap;
    long l1;
    if ((paramMessage.obj instanceof Bitmap))
    {
      Object localObject = (Bitmap)paramMessage.obj;
      if ((localObject != null) && (b() != localObject))
      {
        localBitmap = a();
        if (localBitmap != null)
        {
          if ((localBitmap.isMutable()) && (Build.VERSION.SDK_INT > 11)) {
            this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
          }
        }
        else {
          a((Bitmap)localObject);
        }
      }
      else
      {
        l1 = paramMessage.getData().getLong("targetId");
        try
        {
          if (g != l1) {
            break label286;
          }
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
          while (paramMessage.hasNext())
          {
            localObject = (Drawable)paramMessage.next();
            if (localObject != null) {
              ((Drawable)localObject).invalidateSelf();
            }
          }
          if (2 != this.o) {
            break label272;
          }
        }
        catch (Exception paramMessage)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PendantInfo", 2, "handleMessage, exception:" + paramMessage.getMessage());
          }
        }
        label190:
        if (!this.jdField_c_of_type_Boolean) {
          break label357;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PendantInfo", 2, "cancel decode pendant in market:" + this.jdField_a_of_type_Long);
        }
        this.jdField_c_of_type_Boolean = false;
        l1 = g;
        this.q = 0;
        this.r = 3;
      }
    }
    label272:
    label286:
    label357:
    for (;;)
    {
      if (this.r == 0) {
        this.jdField_a_of_type_Bhyr = null;
      }
      do
      {
        return;
        localBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        break;
        paramMessage = (Drawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l1));
        if (paramMessage == null) {
          break label190;
        }
        paramMessage.invalidateSelf();
        break label190;
        b(l1);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PendantInfo", 2, "wrong type , msg.obj = " + paramMessage.obj.getClass());
      return;
    }
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
    int i1;
    if (paramFile == null)
    {
      i1 = -1;
      return i1;
    }
    Integer localInteger = (Integer)bhkt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(this.jdField_a_of_type_Long));
    Object localObject1 = null;
    Object localObject2;
    if ((paramFile.exists()) && ((localInteger == null) || (-1 == this.n)))
    {
      localObject2 = bhmi.a(paramFile);
      if (localObject2 != null)
      {
        localObject1 = new String((byte[])localObject2);
        i1 = a((String)localObject1, -2147483648, ((String)localObject1).indexOf("\"type\":"));
        label88:
        if (i1 == -2147483648)
        {
          paramFile.delete();
          a(1, 7, 0L);
        }
      }
    }
    for (;;)
    {
      if ((-1 == this.p) && (paramInt == 2))
      {
        if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(this.jdField_a_of_type_Long))) {
          break label348;
        }
        this.p = ((Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(this.jdField_a_of_type_Long))).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("PendantInfo", 2, "parsePendantConfig, read interval from cache=" + this.p + ", id=" + this.jdField_a_of_type_Long);
        }
      }
      i1 = paramInt;
      if (localInteger == null) {
        break;
      }
      i1 = paramInt;
      if (localInteger.intValue() != 0) {
        break;
      }
      i1 = paramInt;
      if (paramInt != 2) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PendantInfo", 2, "static pendant, abort dynamic request");
      }
      this.o = 5;
      this.jdField_b_of_type_JavaLangString = bhkt.b(this.jdField_a_of_type_Long, this.o);
      localObject1 = agej.a();
      if (this.o == 2) {}
      for (paramFile = "dynamic_pendant";; paramFile = "static_pendant") {
        for (;;)
        {
          this.jdField_a_of_type_JavaLangString = (paramFile + "_" + this.jdField_a_of_type_Long + "_" + this.o);
          return this.o;
          localInteger = (Integer)bhkt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(this.jdField_a_of_type_Long));
          break;
          label348:
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (!paramFile.exists()) {}
          }
          try
          {
            localObject2 = bhmi.b(paramFile);
            a((String)localObject2);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              localObject2 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.e("PendantInfo", 2, "parsePendantConfig, read config file exception: " + paramFile + ", " + MsfSdkUtils.getStackTraceString(localIOException));
                localObject2 = localObject1;
              }
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              Object localObject3 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.e("PendantInfo", 2, "parsePendantConfig, read config file oom: " + paramFile);
                localObject3 = localObject1;
              }
            }
          }
        }
      }
      i1 = -2147483648;
      break label88;
      localObject1 = null;
    }
  }
  
  public Bitmap a()
  {
    return b();
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public Bitmap a(int paramInt1, Object paramObject, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: iload_1
    //   7: iconst_2
    //   8: if_icmpne +638 -> 646
    //   11: aload_2
    //   12: ifnonnull +10 -> 22
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 85	com/tencent/mobileqq/vas/PendantInfo:jdField_b_of_type_Boolean	Z
    //   20: aconst_null
    //   21: areturn
    //   22: new 442	android/graphics/BitmapFactory$Options
    //   25: dup
    //   26: invokespecial 443	android/graphics/BitmapFactory$Options:<init>	()V
    //   29: astore 11
    //   31: aload_2
    //   32: checkcast 444	[Ljava/lang/String;
    //   35: checkcast 444	[Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: iload_3
    //   41: iconst_1
    //   42: iadd
    //   43: aload_2
    //   44: arraylength
    //   45: irem
    //   46: aaload
    //   47: astore 10
    //   49: aload 11
    //   51: sipush 320
    //   54: putfield 447	android/graphics/BitmapFactory$Options:inDensity	I
    //   57: aload 11
    //   59: invokestatic 233	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   62: invokevirtual 451	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   65: invokevirtual 457	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   68: getfield 462	android/util/DisplayMetrics:densityDpi	I
    //   71: putfield 465	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   74: aload 11
    //   76: getfield 447	android/graphics/BitmapFactory$Options:inDensity	I
    //   79: aload 11
    //   81: getfield 465	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   84: if_icmpge +13 -> 97
    //   87: aload 11
    //   89: aload 11
    //   91: getfield 465	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   94: putfield 447	android/graphics/BitmapFactory$Options:inDensity	I
    //   97: new 467	java/io/FileInputStream
    //   100: dup
    //   101: aload 10
    //   103: invokespecial 469	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   106: astore 9
    //   108: getstatic 322	android/os/Build$VERSION:SDK_INT	I
    //   111: bipush 11
    //   113: if_icmple +655 -> 768
    //   116: aload 11
    //   118: getfield 447	android/graphics/BitmapFactory$Options:inDensity	I
    //   121: aload 11
    //   123: getfield 465	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   126: if_icmpgt +642 -> 768
    //   129: new 442	android/graphics/BitmapFactory$Options
    //   132: dup
    //   133: invokespecial 443	android/graphics/BitmapFactory$Options:<init>	()V
    //   136: astore 8
    //   138: aload 8
    //   140: iconst_1
    //   141: putfield 472	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   144: new 474	java/io/BufferedInputStream
    //   147: dup
    //   148: new 467	java/io/FileInputStream
    //   151: dup
    //   152: aload 10
    //   154: invokespecial 469	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   157: invokespecial 477	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   160: astore_2
    //   161: aload_2
    //   162: astore 5
    //   164: aload_2
    //   165: astore 4
    //   167: aload_2
    //   168: aconst_null
    //   169: aload 8
    //   171: invokestatic 483	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   174: pop
    //   175: aload_2
    //   176: astore 5
    //   178: aload_2
    //   179: astore 4
    //   181: aload_0
    //   182: getfield 324	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   185: ifnull +124 -> 309
    //   188: aload_2
    //   189: astore 5
    //   191: aload_2
    //   192: astore 4
    //   194: aload_0
    //   195: getfield 324	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   198: aload 8
    //   200: getfield 486	android/graphics/BitmapFactory$Options:outWidth	I
    //   203: aload 8
    //   205: getfield 489	android/graphics/BitmapFactory$Options:outHeight	I
    //   208: invokestatic 494	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:a	(Landroid/graphics/Bitmap;II)Z
    //   211: ifeq +98 -> 309
    //   214: aload_2
    //   215: astore 5
    //   217: aload_2
    //   218: astore 4
    //   220: aload 11
    //   222: aload_0
    //   223: getfield 324	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   226: putfield 497	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   229: aload_2
    //   230: astore 5
    //   232: aload_2
    //   233: astore 4
    //   235: aload 11
    //   237: iconst_1
    //   238: putfield 500	android/graphics/BitmapFactory$Options:inMutable	Z
    //   241: aload_2
    //   242: astore 5
    //   244: aload_2
    //   245: astore 4
    //   247: aload 11
    //   249: iconst_1
    //   250: putfield 503	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   253: aload_2
    //   254: astore 5
    //   256: aload_2
    //   257: astore 4
    //   259: new 474	java/io/BufferedInputStream
    //   262: dup
    //   263: aload 9
    //   265: invokespecial 477	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   268: aconst_null
    //   269: aload 11
    //   271: invokestatic 506	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   274: astore 8
    //   276: aload 8
    //   278: astore 4
    //   280: aload_2
    //   281: astore 5
    //   283: aload 5
    //   285: ifnull +8 -> 293
    //   288: aload 5
    //   290: invokevirtual 509	java/io/BufferedInputStream:close	()V
    //   293: aload 9
    //   295: invokevirtual 512	java/io/InputStream:close	()V
    //   298: aload 4
    //   300: areturn
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 515	java/io/IOException:printStackTrace	()V
    //   306: aload 4
    //   308: areturn
    //   309: aload_2
    //   310: astore 5
    //   312: aload_2
    //   313: astore 4
    //   315: aload 11
    //   317: aconst_null
    //   318: putfield 497	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   321: goto -92 -> 229
    //   324: astore_2
    //   325: ldc 184
    //   327: iconst_1
    //   328: new 186	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 517
    //   338: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_2
    //   342: invokestatic 430	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   345: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload 7
    //   356: astore 4
    //   358: goto -75 -> 283
    //   361: astore 5
    //   363: aconst_null
    //   364: astore_2
    //   365: ldc 184
    //   367: iconst_1
    //   368: new 186	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   375: ldc_w 519
    //   378: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 5
    //   383: invokestatic 430	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   386: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload 11
    //   397: aconst_null
    //   398: putfield 497	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   401: aload 11
    //   403: iconst_0
    //   404: putfield 500	android/graphics/BitmapFactory$Options:inMutable	Z
    //   407: new 474	java/io/BufferedInputStream
    //   410: dup
    //   411: aload 9
    //   413: invokespecial 477	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   416: aconst_null
    //   417: aload 11
    //   419: invokestatic 506	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   422: astore 4
    //   424: aload 4
    //   426: astore 6
    //   428: ldc 184
    //   430: iconst_1
    //   431: new 186	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 521
    //   441: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 10
    //   446: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: aload_0
    //   456: getfield 324	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   459: ifnull +51 -> 510
    //   462: ldc 184
    //   464: iconst_1
    //   465: new 186	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 523
    //   475: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_0
    //   479: getfield 324	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   482: invokevirtual 526	android/graphics/Bitmap:getWidth	()I
    //   485: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: ldc_w 528
    //   491: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_0
    //   495: getfield 324	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   498: invokevirtual 531	android/graphics/Bitmap:getHeight	()I
    //   501: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: aload 6
    //   512: astore 4
    //   514: aload_2
    //   515: astore 5
    //   517: aload 6
    //   519: ifnull -236 -> 283
    //   522: ldc 184
    //   524: iconst_1
    //   525: new 186	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 533
    //   535: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 6
    //   540: invokevirtual 526	android/graphics/Bitmap:getWidth	()I
    //   543: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: ldc_w 528
    //   549: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload 6
    //   554: invokevirtual 531	android/graphics/Bitmap:getHeight	()I
    //   557: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: aload 6
    //   568: astore 4
    //   570: aload_2
    //   571: astore 5
    //   573: goto -290 -> 283
    //   576: astore 4
    //   578: ldc 184
    //   580: iconst_1
    //   581: new 186	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 535
    //   591: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload 4
    //   596: invokestatic 430	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   599: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: goto -180 -> 428
    //   611: astore 4
    //   613: ldc 184
    //   615: iconst_1
    //   616: new 186	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   623: ldc_w 537
    //   626: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload 4
    //   631: invokestatic 430	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   634: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: goto -215 -> 428
    //   646: new 442	android/graphics/BitmapFactory$Options
    //   649: dup
    //   650: invokespecial 443	android/graphics/BitmapFactory$Options:<init>	()V
    //   653: astore 4
    //   655: aload_2
    //   656: checkcast 539	bhys
    //   659: astore_2
    //   660: aload 4
    //   662: sipush 320
    //   665: putfield 447	android/graphics/BitmapFactory$Options:inDensity	I
    //   668: aload 4
    //   670: invokestatic 233	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   673: invokevirtual 451	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   676: invokevirtual 457	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   679: getfield 462	android/util/DisplayMetrics:densityDpi	I
    //   682: putfield 465	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   685: aload 4
    //   687: getfield 447	android/graphics/BitmapFactory$Options:inDensity	I
    //   690: aload 4
    //   692: getfield 465	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   695: if_icmpge +13 -> 708
    //   698: aload 4
    //   700: aload 4
    //   702: getfield 465	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   705: putfield 447	android/graphics/BitmapFactory$Options:inDensity	I
    //   708: new 474	java/io/BufferedInputStream
    //   711: dup
    //   712: new 467	java/io/FileInputStream
    //   715: dup
    //   716: aload_2
    //   717: getfield 540	bhys:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   720: invokespecial 469	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   723: invokespecial 477	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   726: aconst_null
    //   727: aload 4
    //   729: invokestatic 506	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   732: astore_2
    //   733: aload_2
    //   734: areturn
    //   735: astore_2
    //   736: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   739: ifeq -719 -> 20
    //   742: ldc 184
    //   744: iconst_2
    //   745: ldc_w 542
    //   748: invokestatic 544	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aconst_null
    //   752: areturn
    //   753: astore 5
    //   755: aload 4
    //   757: astore_2
    //   758: goto -393 -> 365
    //   761: astore_2
    //   762: aconst_null
    //   763: astore 5
    //   765: goto -440 -> 325
    //   768: aconst_null
    //   769: astore_2
    //   770: goto -517 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	773	0	this	PendantInfo
    //   0	773	1	paramInt1	int
    //   0	773	2	paramObject	Object
    //   0	773	3	paramInt2	int
    //   165	404	4	localObject1	Object
    //   576	19	4	localOutOfMemoryError	OutOfMemoryError
    //   611	19	4	localException	Exception
    //   653	103	4	localOptions1	android.graphics.BitmapFactory.Options
    //   162	149	5	localObject2	Object
    //   361	21	5	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   515	57	5	localObject3	Object
    //   753	1	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   763	1	5	localObject4	Object
    //   1	566	6	localObject5	Object
    //   4	351	7	localObject6	Object
    //   136	141	8	localObject7	Object
    //   106	306	9	localFileInputStream	java.io.FileInputStream
    //   47	398	10	str	String
    //   29	389	11	localOptions2	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   288	293	301	java/io/IOException
    //   293	298	301	java/io/IOException
    //   167	175	324	java/lang/OutOfMemoryError
    //   181	188	324	java/lang/OutOfMemoryError
    //   194	214	324	java/lang/OutOfMemoryError
    //   220	229	324	java/lang/OutOfMemoryError
    //   235	241	324	java/lang/OutOfMemoryError
    //   247	253	324	java/lang/OutOfMemoryError
    //   259	276	324	java/lang/OutOfMemoryError
    //   315	321	324	java/lang/OutOfMemoryError
    //   108	161	361	java/lang/IllegalArgumentException
    //   407	424	576	java/lang/OutOfMemoryError
    //   407	424	611	java/lang/Exception
    //   708	733	735	java/lang/OutOfMemoryError
    //   167	175	753	java/lang/IllegalArgumentException
    //   181	188	753	java/lang/IllegalArgumentException
    //   194	214	753	java/lang/IllegalArgumentException
    //   220	229	753	java/lang/IllegalArgumentException
    //   235	241	753	java/lang/IllegalArgumentException
    //   247	253	753	java/lang/IllegalArgumentException
    //   259	276	753	java/lang/IllegalArgumentException
    //   315	321	753	java/lang/IllegalArgumentException
    //   108	161	761	java/lang/OutOfMemoryError
  }
  
  public Drawable a(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.o = paramInt1;
    StringBuilder localStringBuilder = agej.a();
    Object localObject;
    if (this.o == 2)
    {
      localObject = "dynamic_pendant";
      this.jdField_a_of_type_JavaLangString = ((String)localObject + "_" + this.jdField_a_of_type_Long + "_" + this.o);
      localObject = (Drawable)this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(paramLong));
      if ((TextUtils.isEmpty(paramString)) || (paramInt2 <= 0)) {
        break label205;
      }
      if ((localObject != null) && ((localObject instanceof amru))) {
        break label256;
      }
      localObject = paramString + "_" + paramInt2;
      paramString = new amru(BaseApplicationImpl.getApplication().getResources());
      paramString.b((String)localObject);
      paramString.a(this);
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.put(Long.valueOf(paramLong), paramString);
    }
    label256:
    for (;;)
    {
      ThreadManager.post(new PendantInfo.2(this, paramInt1, paramLong, paramString), 8, null, true);
      return paramString;
      localObject = "static_pendant";
      break;
      label205:
      if ((localObject == null) || ((localObject instanceof amru)))
      {
        paramString = new agmb(BaseApplicationImpl.getApplication().getResources());
        paramString.a(this);
        this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.put(Long.valueOf(paramLong), paramString);
      }
      else
      {
        paramString = (String)localObject;
      }
    }
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 104	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_Long	J
    //   18: bipush 8
    //   20: invokestatic 403	bhkt:b	(JI)Ljava/lang/String;
    //   23: astore_3
    //   24: aload_3
    //   25: invokestatic 579	bhmi:a	(Ljava/lang/String;)Z
    //   28: ifeq -17 -> 11
    //   31: aload_3
    //   32: invokestatic 582	bhmi:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   35: astore 4
    //   37: aload 4
    //   39: invokevirtual 587	java/util/ArrayList:size	()I
    //   42: ifle -31 -> 11
    //   45: aload_0
    //   46: aload 4
    //   48: invokevirtual 587	java/util/ArrayList:size	()I
    //   51: anewarray 158	java/lang/String
    //   54: putfield 112	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   57: new 186	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   64: astore 4
    //   66: aload 4
    //   68: aload_3
    //   69: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: getstatic 590	java/io/File:separator	Ljava/lang/String;
    //   75: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 4
    //   81: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore_3
    //   85: iconst_0
    //   86: istore_1
    //   87: aload_0
    //   88: getfield 112	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   91: arraylength
    //   92: istore_2
    //   93: iload_1
    //   94: iload_2
    //   95: if_icmpge -84 -> 11
    //   98: aload_0
    //   99: getfield 112	com/tencent/mobileqq/vas/PendantInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   102: iload_1
    //   103: invokestatic 410	agej:a	()Ljava/lang/StringBuilder;
    //   106: aload_3
    //   107: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload_1
    //   111: iconst_1
    //   112: iadd
    //   113: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: ldc_w 592
    //   119: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aastore
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_1
    //   130: goto -37 -> 93
    //   133: astore_3
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_3
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	PendantInfo
    //   86	44	1	i1	int
    //   92	4	2	i2	int
    //   6	101	3	localObject1	Object
    //   133	4	3	localObject2	Object
    //   35	45	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	133	finally
    //   14	85	133	finally
    //   87	93	133	finally
    //   98	126	133	finally
  }
  
  void a(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("PendantInfo", 2, "download pendant report actionResult=" + paramInt1 + ",pendantId=" + this.jdField_a_of_type_Long + ",type=" + paramInt2);
      }
      int i1 = bhnv.a(this.jdField_a_of_type_AndroidContentContext);
      if (paramLong < 3600000L) {
        VasWebviewUtil.reportVasStatus("AvatarPendant", "download", String.valueOf(this.jdField_a_of_type_Long), 0, 0, paramInt1, i1, String.valueOf(paramLong), String.valueOf(paramInt2));
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void a(int paramInt, long paramLong)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      File localFile = new File(bhkt.b(this.jdField_a_of_type_Long, 4));
      if (!localFile.exists())
      {
        ((VasQuickUpdateManager)localQQAppInterface.getManager(184)).downloadItem(4L, bhkt.a(this.jdField_a_of_type_Long, 4), "PendantInfo");
        this.jdField_a_of_type_JavaUtilMap.put(bhkt.a(this.jdField_a_of_type_Long, 4), Long.valueOf(paramInt));
        return;
      }
      paramInt = a(localFile, paramInt);
    } while (paramInt <= -1);
    a(paramLong, paramInt);
  }
  
  public void a(long paramLong)
  {
    File localFile = new File(bhkt.b(this.jdField_a_of_type_Long, 4));
    int i1 = 1;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhkt.a(this.jdField_a_of_type_Long, 4))) {
      i1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(bhkt.a(this.jdField_a_of_type_Long, 4))).intValue();
    }
    i1 = a(localFile, i1);
    if (i1 > -1) {
      a(paramLong, i1);
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (paramInt == 2) {}
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(this.jdField_a_of_type_Long)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PendantInfo", 2, "downloadPendantDrawable pendant " + this.jdField_a_of_type_Long + " is downloading");
        }
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(this.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("PendantInfo", 2, "downloadPendantDrawable pendant " + this.jdField_a_of_type_Long + " add to list");
      }
      ??? = a();
      if (??? != null)
      {
        ((VasQuickUpdateManager)((QQAppInterface)???).getManager(184)).downloadItem(4L, bhkt.a(this.jdField_a_of_type_Long, paramInt), "PendantInfo");
        this.jdField_a_of_type_JavaUtilMap.put(bhkt.a(this.jdField_a_of_type_Long, paramInt), Long.valueOf(paramLong));
        return;
      }
    }
  }
  
  void a(agmb paramagmb, long paramLong)
  {
    if ((paramagmb == null) || (this.jdField_a_of_type_ArrayOfJavaLangString == null)) {}
    label151:
    label172:
    for (;;)
    {
      return;
      paramagmb.a(this.jdField_a_of_type_ArrayOfJavaLangString, this.p);
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      this.s = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      boolean bool;
      if ((!this.jdField_c_of_type_Boolean) && (this.r > 3))
      {
        bool = true;
        if (paramLong != i) {
          break label151;
        }
        this.jdField_c_of_type_Boolean = false;
        this.r = l;
        b(i);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label172;
        }
        QLog.d("PendantInfo", 2, "setPngsDrawable repeatCount:" + this.r + ",targetID:" + paramLong + ",pendantInMarket:" + bool);
        return;
        bool = false;
        break;
        if (!bool)
        {
          this.r = m;
          b(g);
        }
      }
    }
  }
  
  void a(Bitmap paramBitmap)
  {
    int i1 = bhjx.a(paramBitmap);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), paramBitmap);
    localBitmapDrawable.setTargetDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics());
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PendantInfo", 4, "setPendantBitmap cache key equal null");
      }
      localStringBuilder = agej.a();
      if (this.o != 2) {
        break label138;
      }
    }
    label138:
    for (paramBitmap = "dynamic_pendant";; paramBitmap = "static_pendant")
    {
      this.jdField_a_of_type_JavaLangString = (paramBitmap + "_" + this.jdField_a_of_type_Long + "_" + this.o);
      BaseApplicationImpl.sImageCache.put(this.jdField_a_of_type_JavaLangString, new Pair(localBitmapDrawable.getConstantState(), Integer.valueOf(i1)));
      return;
    }
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean, long paramLong)
  {
    if (paramDrawable == null) {}
    for (;;)
    {
      return;
      try
      {
        d();
        this.r = 0;
        if ((paramDrawable instanceof agmb)) {
          ((agmb)paramDrawable).a(this.jdField_b_of_type_JavaLangString);
        }
        paramDrawable = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16);
        if (paramBoolean) {
          paramLong = g;
        }
        if (!a(paramDrawable, paramLong)) {
          continue;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramDrawable);
      }
      finally {}
    }
  }
  
  public void a(View paramView, int paramInt, long paramLong)
  {
    a(paramView, paramInt, paramLong, "", 0);
  }
  
  public void a(View paramView, int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    if (bdgb.b()) {
      if (QLog.isColorLevel()) {
        QLog.i("PendantInfo", 2, "setDrawable, SimpleUIMode is open now");
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_JavaLangString = bhkt.b(this.jdField_a_of_type_Long, paramInt1);
      paramString = a(paramInt1, paramLong, paramString, paramInt2);
      if ((paramView instanceof BaseChatItemLayout))
      {
        ((BaseChatItemLayout)paramView).setPendantImage(paramString);
        return;
      }
    } while (!(paramView instanceof ImageView));
    ((ImageView)paramView).setImageDrawable(paramString);
  }
  
  void a(String paramString)
  {
    int i1;
    if (paramString != null)
    {
      i1 = paramString.indexOf("\"interval\":");
      if (i1 == -1) {
        break label111;
      }
      int i2 = paramString.indexOf(",", i1 + 10);
      if (i2 == -1) {
        break label111;
      }
      paramString = paramString.substring(i1 + 11, i2);
      if (paramString == null) {
        break label111;
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(paramString.trim());
        if (-2147483648 != i1)
        {
          this.p = i1;
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.p));
          return;
        }
      }
      catch (Exception paramString)
      {
        i1 = -2147483648;
        continue;
        this.p = k;
        a(1, 7, 0L);
        return;
      }
      label111:
      i1 = -2147483648;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(18);
      if (a(localMessage, g)) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, jdField_a_of_type_Int);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PendantInfo", 2, "bundle exception" + localException.getMessage());
    }
  }
  
  boolean a()
  {
    Pair localPair = (Pair)BaseApplicationImpl.sImageCache.get(this.jdField_a_of_type_JavaLangString);
    return (localPair != null) && (localPair.first != null);
  }
  
  Bitmap b()
  {
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PendantInfo", 4, "getPendantBitmap cache key equal null");
      }
      StringBuilder localStringBuilder = agej.a();
      if (this.o == 2)
      {
        localObject = "dynamic_pendant";
        this.jdField_a_of_type_JavaLangString = ((String)localObject + "_" + this.jdField_a_of_type_Long + "_" + this.o);
      }
    }
    else
    {
      if (BaseApplicationImpl.sImageCache == null) {
        break label137;
      }
    }
    label137:
    for (Object localObject = (Pair)BaseApplicationImpl.sImageCache.get(this.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if ((localObject == null) || (((Pair)localObject).first == null)) {
        break label142;
      }
      return ((BitmapDrawable)((Drawable.ConstantState)((Pair)localObject).first).newDrawable(BaseApplicationImpl.getApplication().getResources())).getBitmap();
      localObject = "static_pendant";
      break;
    }
    label142:
    return null;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void b(long paramLong)
  {
    long l1;
    long l2;
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      l1 = SystemClock.uptimeMillis();
      l2 = this.p;
      this.jdField_a_of_type_Bhyr = new bhyr(this, this.jdField_a_of_type_ArrayOfJavaLangString, paramLong);
    }
    try
    {
      this.jdField_a_of_type_Bhyr.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.q), Long.valueOf(this.o) });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PendantInfo", 1, "decodeBigImage, e=" + MsfSdkUtils.getStackTraceString(localException));
    }
  }
  
  void b(long paramLong, int paramInt)
  {
    long l1 = g;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(bhkt.a(this.jdField_a_of_type_Long, paramInt))) {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get(bhkt.a(this.jdField_a_of_type_Long, paramInt))).longValue();
    }
    File localFile;
    if ((2 == paramInt) && (this.n == 1))
    {
      ??? = new File(bhkt.b(paramLong, paramInt));
      if (((File)???).exists())
      {
        localFile = new File(bhkt.b(paramLong, 8));
        if (!bihw.a((File)???, localFile, true)) {
          break label228;
        }
        a();
        ??? = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(20);
        if (a((Message)???, l1)) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)???);
        }
      }
    }
    label228:
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramLong)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PendantInfo", 2, "onDoneDownloadImage remove " + paramLong + " from list");
          }
          this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(paramLong));
        }
        while (!QLog.isColorLevel())
        {
          return;
          if (((File)???).exists()) {
            ((File)???).delete();
          }
          if (!localFile.exists()) {
            break;
          }
          localFile.delete();
          break;
        }
        QLog.d("PendantInfo", 2, "onDoneDownloadImage remove " + paramLong + " fail, list not contain");
      }
      ??? = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(19);
    } while (!a((Message)???, g));
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)???);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.clear();
    e();
  }
  
  public void d()
  {
    try
    {
      if (((this.jdField_a_of_type_JavaLangObject instanceof bhys)) && (a()))
      {
        if ((this.jdField_a_of_type_JavaLangObject != null) && (((bhys)this.jdField_a_of_type_JavaLangObject).jdField_a_of_type_JavaLangString != null) && (((bhys)this.jdField_a_of_type_JavaLangObject).jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) {
          return;
        }
        if (this.jdField_a_of_type_Boolean) {}
      }
      else if (this.jdField_a_of_type_Bhyr != null)
      {
        Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16);
        if (!a(localMessage, g)) {
          return;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("PendantInfo", 1, "decodeBigImage, e=" + MsfSdkUtils.getStackTraceString(localException));
      return;
    }
    this.jdField_a_of_type_JavaLangObject = new bhys(this, this.jdField_b_of_type_JavaLangString);
    this.r = 0;
    this.jdField_a_of_type_Bhyr = new bhyr(this, this.jdField_a_of_type_JavaLangObject, g);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.p;
    this.jdField_a_of_type_Bhyr.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.q), Long.valueOf(this.o) });
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bhyr != null)
    {
      this.jdField_a_of_type_Bhyr.cancel(false);
      this.jdField_a_of_type_Bhyr = null;
    }
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.PendantInfo
 * JD-Core Version:    0.7.0.1
 */