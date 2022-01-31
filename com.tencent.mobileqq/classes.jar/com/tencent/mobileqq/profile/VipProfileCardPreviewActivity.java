package com.tencent.mobileqq.profile;

import alpg;
import alpk;
import alpq;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import awqr;
import awra;
import awrb;
import awsc;
import awse;
import awsf;
import awsg;
import awug;
import awuk;
import awul;
import azqs;
import bddf;
import bety;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ProfileCardScrollImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.widget.CirclePageIndicator;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VipProfileCardPreviewActivity
  extends VipProfileCardBaseActivity
  implements View.OnClickListener
{
  public int A;
  int B = 0;
  public int C = -1;
  public Drawable a;
  public View a;
  public Button a;
  public ImageView a;
  public awqr a;
  public VipProfileCardPreviewActivity.StylePagerAdapter a;
  public VipScaledViewPager a;
  public CirclePageIndicator a;
  HashMap<String, String> a;
  public List<awrb> a;
  public float b;
  public long b;
  public alpq b;
  Runnable b;
  public ArrayList<Long> b;
  public List<String> b;
  public float c;
  private volatile long c;
  public String c;
  public boolean c;
  public float d;
  String d;
  public boolean d;
  public float e;
  public String e;
  public boolean e;
  public boolean f;
  volatile boolean g = false;
  public int m = -1;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  public int w;
  public int x = -1;
  public int y;
  public int z;
  
  public VipProfileCardPreviewActivity()
  {
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_d_of_type_Float = 1.666667F;
    this.jdField_e_of_type_Float = 1.775F;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = "is_binding_shop";
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_Alpq = new awsf(this);
  }
  
  int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int i1 = j;
    if (paramInt1 != 0)
    {
      i1 = j;
      if (paramInt2 != 0)
      {
        i1 = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          i1 = j;
        }
      }
    }
    label43:
    int k;
    label55:
    do
    {
      do
      {
        return i1;
        j = paramOptions.outHeight;
        k = paramOptions.outWidth;
        i1 = i;
      } while (j <= paramInt2);
      i1 = i;
    } while (k <= paramInt1);
    int i2 = Math.round(j / paramInt2);
    i1 = Math.round(k / paramInt1);
    if (i2 > i1) {}
    for (;;)
    {
      i1 = i;
      if (i2 < 2) {
        break;
      }
      k /= 2;
      j /= 2;
      i *= 2;
      break label55;
      i2 = i1;
    }
  }
  
  long a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
    return ((awrb)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Awra.jdField_o_of_type_Long;
  }
  
  /* Error */
  android.graphics.Bitmap a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: getstatic 168	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   6: astore 4
    //   8: iconst_1
    //   9: istore_3
    //   10: aload 8
    //   12: astore 6
    //   14: iload_3
    //   15: iconst_2
    //   16: if_icmpgt +185 -> 201
    //   19: new 121	android/graphics/BitmapFactory$Options
    //   22: dup
    //   23: invokespecial 169	android/graphics/BitmapFactory$Options:<init>	()V
    //   26: astore 9
    //   28: aload 9
    //   30: aload 4
    //   32: putfield 172	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   35: aload 9
    //   37: aload_0
    //   38: getfield 175	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   41: putfield 178	android/graphics/BitmapFactory$Options:inDensity	I
    //   44: aload 9
    //   46: aload_0
    //   47: getfield 175	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   50: putfield 181	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   53: aload 9
    //   55: aload_0
    //   56: getfield 175	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   59: putfield 184	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   62: new 186	java/io/BufferedInputStream
    //   65: dup
    //   66: new 188	java/io/FileInputStream
    //   69: dup
    //   70: new 190	java/io/File
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 193	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 199	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore 4
    //   86: iload_2
    //   87: ifeq +37 -> 124
    //   90: aload 9
    //   92: iconst_1
    //   93: putfield 202	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   96: aload 4
    //   98: aconst_null
    //   99: aload 9
    //   101: invokestatic 208	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   104: pop
    //   105: aload 9
    //   107: aload_0
    //   108: aload 9
    //   110: aload_0
    //   111: getfield 210	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   114: aload_0
    //   115: getfield 212	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	I
    //   118: invokevirtual 214	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   121: putfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   124: aload 9
    //   126: iconst_0
    //   127: putfield 202	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   130: new 186	java/io/BufferedInputStream
    //   133: dup
    //   134: new 188	java/io/FileInputStream
    //   137: dup
    //   138: new 190	java/io/File
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 193	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   149: invokespecial 199	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   152: astore 5
    //   154: aload 5
    //   156: astore 6
    //   158: aload 4
    //   160: astore 7
    //   162: aload 5
    //   164: aconst_null
    //   165: aload 9
    //   167: invokestatic 208	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   170: astore 9
    //   172: aload 9
    //   174: astore_1
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   185: aload_1
    //   186: astore 6
    //   188: aload 5
    //   190: ifnull +11 -> 201
    //   193: aload 5
    //   195: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   198: aload_1
    //   199: astore 6
    //   201: aload 6
    //   203: areturn
    //   204: astore 4
    //   206: ldc 222
    //   208: iconst_1
    //   209: ldc 224
    //   211: aload 4
    //   213: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload_1
    //   217: areturn
    //   218: astore 4
    //   220: aconst_null
    //   221: astore 5
    //   223: aconst_null
    //   224: astore 4
    //   226: aload 5
    //   228: astore 6
    //   230: aload 4
    //   232: astore 7
    //   234: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +45 -> 282
    //   240: aload 5
    //   242: astore 6
    //   244: aload 4
    //   246: astore 7
    //   248: ldc 222
    //   250: iconst_2
    //   251: new 235	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   258: ldc 238
    //   260: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_1
    //   264: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 244
    //   269: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: iload_3
    //   273: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload 5
    //   284: astore 6
    //   286: aload 4
    //   288: astore 7
    //   290: getstatic 257	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   293: astore 9
    //   295: aload 4
    //   297: ifnull +8 -> 305
    //   300: aload 4
    //   302: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   305: aload 5
    //   307: ifnull +8 -> 315
    //   310: aload 5
    //   312: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   315: iload_3
    //   316: iconst_1
    //   317: iadd
    //   318: istore_3
    //   319: aload 9
    //   321: astore 4
    //   323: goto -313 -> 10
    //   326: astore 4
    //   328: ldc 222
    //   330: iconst_1
    //   331: ldc 224
    //   333: aload 4
    //   335: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: goto -23 -> 315
    //   341: astore 6
    //   343: aconst_null
    //   344: astore 4
    //   346: aconst_null
    //   347: astore 5
    //   349: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +51 -> 403
    //   355: ldc 222
    //   357: iconst_2
    //   358: new 235	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   365: ldc 238
    //   367: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_1
    //   371: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: ldc_w 259
    //   377: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 6
    //   382: invokevirtual 262	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc 244
    //   390: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: iload_3
    //   394: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: aload 5
    //   405: ifnull +8 -> 413
    //   408: aload 5
    //   410: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   413: aload 8
    //   415: astore 6
    //   417: aload 4
    //   419: ifnull -218 -> 201
    //   422: aload 4
    //   424: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   427: aconst_null
    //   428: areturn
    //   429: astore_1
    //   430: ldc 222
    //   432: iconst_1
    //   433: ldc 224
    //   435: aload_1
    //   436: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   439: aconst_null
    //   440: areturn
    //   441: astore_1
    //   442: aconst_null
    //   443: astore 4
    //   445: aconst_null
    //   446: astore 5
    //   448: aload 5
    //   450: ifnull +8 -> 458
    //   453: aload 5
    //   455: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   458: aload 4
    //   460: ifnull +8 -> 468
    //   463: aload 4
    //   465: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   468: aload_1
    //   469: athrow
    //   470: astore 4
    //   472: ldc 222
    //   474: iconst_1
    //   475: ldc 224
    //   477: aload 4
    //   479: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   482: goto -14 -> 468
    //   485: astore_1
    //   486: aload 4
    //   488: astore 5
    //   490: aconst_null
    //   491: astore 4
    //   493: goto -45 -> 448
    //   496: astore_1
    //   497: aload 7
    //   499: astore 5
    //   501: aload 6
    //   503: astore 4
    //   505: goto -57 -> 448
    //   508: astore_1
    //   509: goto -61 -> 448
    //   512: astore 6
    //   514: aload 4
    //   516: astore 5
    //   518: aconst_null
    //   519: astore 4
    //   521: goto -172 -> 349
    //   524: astore 6
    //   526: aload 4
    //   528: astore 7
    //   530: aload 5
    //   532: astore 4
    //   534: aload 7
    //   536: astore 5
    //   538: goto -189 -> 349
    //   541: astore 5
    //   543: aconst_null
    //   544: astore 5
    //   546: goto -320 -> 226
    //   549: astore 6
    //   551: goto -325 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	this	VipProfileCardPreviewActivity
    //   0	554	1	paramString	String
    //   0	554	2	paramBoolean	boolean
    //   9	385	3	i	int
    //   6	175	4	localObject1	Object
    //   204	8	4	localException1	Exception
    //   218	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   224	98	4	localObject2	Object
    //   326	8	4	localException2	Exception
    //   344	120	4	localObject3	Object
    //   470	17	4	localException3	Exception
    //   491	42	4	localObject4	Object
    //   152	385	5	localObject5	Object
    //   541	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   544	1	5	localObject6	Object
    //   12	273	6	localObject7	Object
    //   341	40	6	localException4	Exception
    //   415	87	6	localObject8	Object
    //   512	1	6	localException5	Exception
    //   524	1	6	localException6	Exception
    //   549	1	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   160	375	7	localObject9	Object
    //   1	413	8	localObject10	Object
    //   26	294	9	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   180	185	204	java/lang/Exception
    //   193	198	204	java/lang/Exception
    //   19	86	218	java/lang/OutOfMemoryError
    //   300	305	326	java/lang/Exception
    //   310	315	326	java/lang/Exception
    //   19	86	341	java/lang/Exception
    //   408	413	429	java/lang/Exception
    //   422	427	429	java/lang/Exception
    //   19	86	441	finally
    //   453	458	470	java/lang/Exception
    //   463	468	470	java/lang/Exception
    //   90	124	485	finally
    //   124	154	485	finally
    //   162	172	496	finally
    //   234	240	496	finally
    //   248	282	496	finally
    //   290	295	496	finally
    //   349	403	508	finally
    //   90	124	512	java/lang/Exception
    //   124	154	512	java/lang/Exception
    //   162	172	524	java/lang/Exception
    //   90	124	541	java/lang/OutOfMemoryError
    //   124	154	541	java/lang/OutOfMemoryError
    //   162	172	549	java/lang/OutOfMemoryError
  }
  
  public List<String> a(awrb paramawrb)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramawrb == null) || (paramawrb.jdField_a_of_type_Awra == null)) {}
    for (;;)
    {
      return localArrayList;
      if (this.h == 1) {
        localArrayList.add(paramawrb.jdField_a_of_type_Awra.k);
      }
      while (paramawrb.jdField_a_of_type_Awra.d == 2)
      {
        if (this.h != 1) {
          break label95;
        }
        localArrayList.add(paramawrb.jdField_a_of_type_Awra.jdField_o_of_type_JavaLangString);
        return localArrayList;
        localArrayList.add(paramawrb.jdField_a_of_type_Awra.g);
      }
    }
    label95:
    localArrayList.add(paramawrb.jdField_a_of_type_Awra.s);
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) {
      return;
    }
    d(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem());
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    Object localObject;
    do
    {
      do
      {
        awrb localawrb;
        do
        {
          do
          {
            do
            {
              return;
              localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
            } while ((localObject == null) || (((View)localObject).getTag() == null));
            localObject = (awsg)((View)localObject).getTag();
          } while (localObject == null);
          localObject = ((awsg)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView;
          localawrb = (awrb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        } while (localawrb == null);
        switch (localawrb.jdField_a_of_type_Awra.d)
        {
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_NONE");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_SCROLL");
      }
      ((ProfileCardScrollImageView)localObject).a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_FADE_IN_OUT");
      }
      if (this.jdField_b_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      localObject = ((ProfileCardScrollImageView)localObject).getDrawable();
    } while ((localObject == null) || (!(localObject instanceof TransitionDrawable)));
    ((TransitionDrawable)localObject).resetTransition();
  }
  
  public void a(int paramInt, awrb paramawrb)
  {
    if (paramawrb == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startDownload pos = " + paramInt + ", status = " + paramawrb.jdField_a_of_type_Int);
      }
    } while ((paramawrb.jdField_a_of_type_Int == 2) || (paramawrb.jdField_a_of_type_Int == 1));
    paramawrb.jdField_a_of_type_Int = 1;
    paramawrb = a(paramawrb);
    this.jdField_b_of_type_JavaUtilList.addAll(paramawrb);
    a(paramInt, paramawrb);
  }
  
  public void a(int paramInt, String paramString)
  {
    ThreadManager.post(new VipProfileCardPreviewActivity.4(this, paramInt, paramString), 5, null, true);
  }
  
  public void a(int paramInt, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramInt, (String)paramList.next());
      }
    }
  }
  
  /* Error */
  public void a(awsg paramawsg, awrb paramawrb, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 383	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Lawrb;)Z
    //   5: ifeq +69 -> 74
    //   8: aload_2
    //   9: iconst_2
    //   10: putfield 341	awrb:jdField_a_of_type_Int	I
    //   13: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +35 -> 51
    //   19: ldc 222
    //   21: iconst_2
    //   22: new 235	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 385
    //   32: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_3
    //   36: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 387
    //   42: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: aload_2
    //   53: invokevirtual 343	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Lawrb;)Ljava/util/List;
    //   56: astore 7
    //   58: aload 7
    //   60: ifnull +13 -> 73
    //   63: aload 7
    //   65: invokeinterface 289 1 0
    //   70: ifne +43 -> 113
    //   73: return
    //   74: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -4 -> 73
    //   80: ldc 222
    //   82: iconst_2
    //   83: new 235	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 385
    //   93: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload_3
    //   97: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc_w 389
    //   103: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: return
    //   113: aload_2
    //   114: getfield 153	awrb:jdField_a_of_type_Awra	Lawra;
    //   117: getfield 157	awra:jdField_o_of_type_Long	J
    //   120: getstatic 391	awra:n	J
    //   123: lcmp
    //   124: ifne +239 -> 363
    //   127: aload_1
    //   128: getfield 394	awsg:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   131: iconst_0
    //   132: invokevirtual 399	com/tencent/mobileqq/hiboom/HiBoomTextView:setVisibility	(I)V
    //   135: sipush 2000
    //   138: istore 5
    //   140: getstatic 403	awsm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: astore 8
    //   145: getstatic 406	awsm:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   148: ifnull +205 -> 353
    //   151: getstatic 406	awsm:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   154: invokevirtual 409	android/util/SparseArray:size	()I
    //   157: ifle +196 -> 353
    //   160: getstatic 406	awsm:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   163: iconst_0
    //   164: invokevirtual 413	android/util/SparseArray:keyAt	(I)I
    //   167: istore 5
    //   169: aload_1
    //   170: getfield 394	awsg:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   173: iload 5
    //   175: iconst_1
    //   176: getstatic 418	assg:b	Lasrz;
    //   179: invokevirtual 422	com/tencent/mobileqq/hiboom/HiBoomTextView:setHiBoom	(IILasrz;)V
    //   182: aload_1
    //   183: getfield 394	awsg:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   186: aload 8
    //   188: invokevirtual 426	com/tencent/mobileqq/hiboom/HiBoomTextView:setText	(Ljava/lang/CharSequence;)V
    //   191: aload_0
    //   192: getfield 210	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   195: i2f
    //   196: aload_0
    //   197: invokevirtual 430	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:getResources	()Landroid/content/res/Resources;
    //   200: invokevirtual 436	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   203: getfield 441	android/util/DisplayMetrics:widthPixels	I
    //   206: i2f
    //   207: fdiv
    //   208: fstore 4
    //   210: aload_1
    //   211: getfield 394	awsg:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   214: fload 4
    //   216: invokevirtual 445	com/tencent/mobileqq/hiboom/HiBoomTextView:setScaleX	(F)V
    //   219: aload_1
    //   220: getfield 394	awsg:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   223: fload 4
    //   225: invokevirtual 448	com/tencent/mobileqq/hiboom/HiBoomTextView:setScaleY	(F)V
    //   228: aload_2
    //   229: getfield 153	awrb:jdField_a_of_type_Awra	Lawra;
    //   232: getfield 275	awra:d	I
    //   235: tableswitch	default:+25 -> 260, 0:+26->261, 1:+140->375, 2:+549->784
    //   261: aload_1
    //   262: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   265: iconst_0
    //   266: invokevirtual 452	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   269: new 235	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 454
    //   279: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_0
    //   283: getfield 457	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   286: aload 7
    //   288: iconst_0
    //   289: invokeinterface 148 2 0
    //   294: checkcast 376	java/lang/String
    //   297: invokestatic 462	bddf:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   300: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload_0
    //   307: getfield 210	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   310: aload_0
    //   311: getfield 212	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	I
    //   314: aload_1
    //   315: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   318: invokevirtual 329	com/tencent/mobileqq/widget/ProfileCardScrollImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   321: aload_1
    //   322: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   325: invokevirtual 329	com/tencent/mobileqq/widget/ProfileCardScrollImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   328: iconst_0
    //   329: invokestatic 467	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)Lcom/tencent/image/URLDrawable;
    //   332: astore_2
    //   333: aload_1
    //   334: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   337: aload_2
    //   338: invokevirtual 471	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   341: aload_1
    //   342: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   345: iload_3
    //   346: invokestatic 477	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: invokevirtual 481	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   352: return
    //   353: aload_0
    //   354: getfield 485	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   357: invokestatic 488	awsm:a	(Lmqq/app/AppRuntime;)V
    //   360: goto -191 -> 169
    //   363: aload_1
    //   364: getfield 394	awsg:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   367: bipush 8
    //   369: invokevirtual 399	com/tencent/mobileqq/hiboom/HiBoomTextView:setVisibility	(I)V
    //   372: goto -144 -> 228
    //   375: aload_1
    //   376: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   379: iconst_1
    //   380: invokevirtual 452	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   383: aload_0
    //   384: getfield 457	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   387: aload 7
    //   389: iconst_0
    //   390: invokeinterface 148 2 0
    //   395: checkcast 376	java/lang/String
    //   398: invokestatic 462	bddf:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   401: astore 8
    //   403: new 186	java/io/BufferedInputStream
    //   406: dup
    //   407: new 188	java/io/FileInputStream
    //   410: dup
    //   411: new 190	java/io/File
    //   414: dup
    //   415: aload 8
    //   417: invokespecial 193	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   423: invokespecial 199	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   426: astore 7
    //   428: aload 7
    //   430: astore_2
    //   431: new 121	android/graphics/BitmapFactory$Options
    //   434: dup
    //   435: invokespecial 169	android/graphics/BitmapFactory$Options:<init>	()V
    //   438: astore 9
    //   440: aload 7
    //   442: astore_2
    //   443: aload 9
    //   445: iconst_1
    //   446: putfield 202	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   449: aload 7
    //   451: astore_2
    //   452: aload 9
    //   454: aload_0
    //   455: getfield 175	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   458: putfield 178	android/graphics/BitmapFactory$Options:inDensity	I
    //   461: aload 7
    //   463: astore_2
    //   464: aload 9
    //   466: aload_0
    //   467: getfield 175	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   470: putfield 181	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   473: aload 7
    //   475: astore_2
    //   476: aload 9
    //   478: aload_0
    //   479: getfield 175	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   482: putfield 184	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   485: aload 7
    //   487: astore_2
    //   488: aload 7
    //   490: aconst_null
    //   491: aload 9
    //   493: invokestatic 208	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   496: pop
    //   497: aload 7
    //   499: astore_2
    //   500: aload 9
    //   502: getfield 127	android/graphics/BitmapFactory$Options:outWidth	I
    //   505: istore 5
    //   507: aload 7
    //   509: astore_2
    //   510: aload 9
    //   512: getfield 124	android/graphics/BitmapFactory$Options:outHeight	I
    //   515: aload_0
    //   516: getfield 210	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   519: imul
    //   520: iload 5
    //   522: idiv
    //   523: istore 6
    //   525: aload 7
    //   527: astore_2
    //   528: aload_0
    //   529: aload_0
    //   530: getfield 212	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	I
    //   533: iload 6
    //   535: isub
    //   536: putfield 490	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:A	I
    //   539: aload 7
    //   541: astore_2
    //   542: aload_1
    //   543: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   546: getstatic 496	android/widget/ImageView$ScaleType:MATRIX	Landroid/widget/ImageView$ScaleType;
    //   549: invokevirtual 500	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   552: aload 7
    //   554: astore_2
    //   555: new 502	android/graphics/Matrix
    //   558: dup
    //   559: invokespecial 503	android/graphics/Matrix:<init>	()V
    //   562: astore 9
    //   564: aload 7
    //   566: astore_2
    //   567: aload 9
    //   569: aload_0
    //   570: getfield 210	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   573: i2f
    //   574: iload 5
    //   576: i2f
    //   577: fdiv
    //   578: aload_0
    //   579: getfield 210	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   582: i2f
    //   583: iload 5
    //   585: i2f
    //   586: fdiv
    //   587: invokevirtual 507	android/graphics/Matrix:postScale	(FF)Z
    //   590: pop
    //   591: aload 7
    //   593: astore_2
    //   594: aload_1
    //   595: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   598: aload 9
    //   600: invokevirtual 511	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageMatrix	(Landroid/graphics/Matrix;)V
    //   603: aload 7
    //   605: astore_2
    //   606: getstatic 517	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   609: aload 8
    //   611: invokevirtual 522	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   614: checkcast 524	android/graphics/drawable/Drawable
    //   617: astore 9
    //   619: aload 9
    //   621: ifnull +71 -> 692
    //   624: aload 7
    //   626: astore_2
    //   627: aload_1
    //   628: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   631: aload 9
    //   633: invokevirtual 471	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   636: aload 7
    //   638: astore_2
    //   639: aload_1
    //   640: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   643: iload_3
    //   644: invokestatic 477	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   647: invokevirtual 481	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   650: aload 7
    //   652: astore_2
    //   653: aload_0
    //   654: getfield 62	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:x	I
    //   657: iload_3
    //   658: if_icmpne +11 -> 669
    //   661: aload 7
    //   663: astore_2
    //   664: aload_0
    //   665: iload_3
    //   666: invokevirtual 526	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:b	(I)V
    //   669: aload 7
    //   671: ifnull -598 -> 73
    //   674: aload 7
    //   676: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   679: return
    //   680: astore_1
    //   681: ldc 222
    //   683: iconst_1
    //   684: ldc_w 528
    //   687: aload_1
    //   688: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   691: return
    //   692: aload 7
    //   694: astore_2
    //   695: new 530	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$5
    //   698: dup
    //   699: aload_0
    //   700: aload 8
    //   702: iload_3
    //   703: invokespecial 533	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$5:<init>	(Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;Ljava/lang/String;I)V
    //   706: bipush 8
    //   708: aconst_null
    //   709: iconst_1
    //   710: invokestatic 362	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   713: goto -44 -> 669
    //   716: astore_2
    //   717: aload 7
    //   719: astore_1
    //   720: aload_2
    //   721: astore 7
    //   723: aload_1
    //   724: astore_2
    //   725: ldc 222
    //   727: iconst_1
    //   728: ldc_w 528
    //   731: aload 7
    //   733: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   736: aload_1
    //   737: ifnull -664 -> 73
    //   740: aload_1
    //   741: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   744: return
    //   745: astore_1
    //   746: ldc 222
    //   748: iconst_1
    //   749: ldc_w 528
    //   752: aload_1
    //   753: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   756: return
    //   757: astore_1
    //   758: aconst_null
    //   759: astore_2
    //   760: aload_2
    //   761: ifnull +7 -> 768
    //   764: aload_2
    //   765: invokevirtual 220	java/io/BufferedInputStream:close	()V
    //   768: aload_1
    //   769: athrow
    //   770: astore_2
    //   771: ldc 222
    //   773: iconst_1
    //   774: ldc_w 528
    //   777: aload_2
    //   778: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   781: goto -13 -> 768
    //   784: aload_1
    //   785: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   788: iconst_0
    //   789: invokevirtual 452	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   792: aload 7
    //   794: invokeinterface 289 1 0
    //   799: iconst_1
    //   800: if_icmple -727 -> 73
    //   803: aload 7
    //   805: iconst_0
    //   806: invokeinterface 148 2 0
    //   811: checkcast 535	java/lang/CharSequence
    //   814: invokestatic 541	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   817: ifne -744 -> 73
    //   820: aload 7
    //   822: iconst_1
    //   823: invokeinterface 148 2 0
    //   828: checkcast 535	java/lang/CharSequence
    //   831: invokestatic 541	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   834: ifne -761 -> 73
    //   837: new 235	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   844: aload 7
    //   846: iconst_0
    //   847: invokeinterface 148 2 0
    //   852: checkcast 376	java/lang/String
    //   855: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: aload 7
    //   860: iconst_1
    //   861: invokeinterface 148 2 0
    //   866: checkcast 376	java/lang/String
    //   869: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: astore_2
    //   876: getstatic 517	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   879: aload_2
    //   880: invokevirtual 522	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   883: instanceof 543
    //   886: ifeq +53 -> 939
    //   889: getstatic 517	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   892: aload_2
    //   893: invokevirtual 522	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   896: checkcast 543	android/util/Pair
    //   899: getfield 547	android/util/Pair:first	Ljava/lang/Object;
    //   902: checkcast 524	android/graphics/drawable/Drawable
    //   905: astore_2
    //   906: aload_1
    //   907: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   910: aload_2
    //   911: invokevirtual 471	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   914: aload_1
    //   915: getfield 304	awsg:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   918: iload_3
    //   919: invokestatic 477	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   922: invokevirtual 481	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   925: aload_0
    //   926: getfield 62	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:x	I
    //   929: iload_3
    //   930: if_icmpne -857 -> 73
    //   933: aload_0
    //   934: iload_3
    //   935: invokevirtual 526	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:b	(I)V
    //   938: return
    //   939: new 549	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$6
    //   942: dup
    //   943: aload_0
    //   944: aload 7
    //   946: aload_2
    //   947: iload_3
    //   948: invokespecial 552	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$6:<init>	(Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;Ljava/util/List;Ljava/lang/String;I)V
    //   951: bipush 8
    //   953: aconst_null
    //   954: iconst_1
    //   955: invokestatic 362	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   958: return
    //   959: astore_1
    //   960: goto -200 -> 760
    //   963: astore 7
    //   965: aconst_null
    //   966: astore_1
    //   967: goto -244 -> 723
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	970	0	this	VipProfileCardPreviewActivity
    //   0	970	1	paramawsg	awsg
    //   0	970	2	paramawrb	awrb
    //   0	970	3	paramInt	int
    //   208	16	4	f1	float
    //   138	446	5	i	int
    //   523	13	6	j	int
    //   56	889	7	localObject1	Object
    //   963	1	7	localException	Exception
    //   143	558	8	str	String
    //   438	194	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   674	679	680	java/lang/Exception
    //   431	440	716	java/lang/Exception
    //   443	449	716	java/lang/Exception
    //   452	461	716	java/lang/Exception
    //   464	473	716	java/lang/Exception
    //   476	485	716	java/lang/Exception
    //   488	497	716	java/lang/Exception
    //   500	507	716	java/lang/Exception
    //   510	525	716	java/lang/Exception
    //   528	539	716	java/lang/Exception
    //   542	552	716	java/lang/Exception
    //   555	564	716	java/lang/Exception
    //   567	591	716	java/lang/Exception
    //   594	603	716	java/lang/Exception
    //   606	619	716	java/lang/Exception
    //   627	636	716	java/lang/Exception
    //   639	650	716	java/lang/Exception
    //   653	661	716	java/lang/Exception
    //   664	669	716	java/lang/Exception
    //   695	713	716	java/lang/Exception
    //   740	744	745	java/lang/Exception
    //   403	428	757	finally
    //   764	768	770	java/lang/Exception
    //   431	440	959	finally
    //   443	449	959	finally
    //   452	461	959	finally
    //   464	473	959	finally
    //   476	485	959	finally
    //   488	497	959	finally
    //   500	507	959	finally
    //   510	525	959	finally
    //   528	539	959	finally
    //   542	552	959	finally
    //   555	564	959	finally
    //   567	591	959	finally
    //   594	603	959	finally
    //   606	619	959	finally
    //   627	636	959	finally
    //   639	650	959	finally
    //   653	661	959	finally
    //   664	669	959	finally
    //   695	713	959	finally
    //   725	736	959	finally
    //   403	428	963	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = bddf.a(this.jdField_a_of_type_AndroidContentContext, paramString);
      localObject = new File(paramString);
      if ((((File)localObject).isFile()) && (((File)localObject).exists()))
      {
        localObject = "profilecard_preview:" + paramString;
        Pair localPair = (Pair)BaseApplicationImpl.sImageCache.get(localObject);
        if ((localPair == null) || (localPair.first == null)) {
          break label129;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "get image form sImageCache filePath=" + paramString);
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable.ConstantState)localPair.first).newDrawable();
      }
    }
    return;
    label129:
    a(paramString, (String)localObject);
  }
  
  public void a(String paramString, UpsImageUploadResult paramUpsImageUploadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "url from UPS:" + paramUpsImageUploadResult.url);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramUpsImageUploadResult.url);
    b(paramString, paramUpsImageUploadResult.url);
  }
  
  void a(String paramString1, String paramString2)
  {
    ThreadManager.post(new VipProfileCardPreviewActivity.7(this, paramString1, paramString2), 8, null, true);
  }
  
  void a(long[] paramArrayOfLong)
  {
    label147:
    int i1;
    if (paramArrayOfLong != null)
    {
      int i = 0;
      if (i < paramArrayOfLong.length)
      {
        l = paramArrayOfLong[i];
        if (l == awra.h)
        {
          k = 0;
          Object localObject = this.jdField_a_of_type_AndroidContentContext;
          Context localContext = this.jdField_a_of_type_AndroidContentContext;
          localObject = ((Context)localObject).getSharedPreferences("is_binding_shop", 0);
          j = k;
          if (localObject != null)
          {
            boolean bool = ((SharedPreferences)localObject).getBoolean(this.jdField_e_of_type_JavaLangString, false);
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "isBinding=" + bool);
            }
            j = k;
            if (bool)
            {
              this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(l));
              j = 1;
            }
          }
          this.jdField_f_of_type_Boolean = true;
          if (this.x == i)
          {
            this.x = 0;
            if (this.jdField_a_of_type_Long == awra.jdField_a_of_type_Long) {
              this.x = 0;
            }
            if ((j != 0) && (this.x == 0)) {
              azqs.b(this.app, "CliOper", "", "", "Shop_Malltemplate", "0X8005B93", 0, 0, "", "", "", "");
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (j == 0) {
            break label147;
          }
          this.x += 1;
          break label147;
          this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        }
      }
      long l = awra.h;
      if ((this.jdField_b_of_type_JavaUtilArrayList.contains(Long.valueOf(l))) && (this.jdField_b_of_type_JavaUtilArrayList.contains(Long.valueOf(awra.n))))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(Long.valueOf(l));
        this.jdField_b_of_type_JavaUtilArrayList.add(1, Long.valueOf(l));
      }
      int j = 0;
      i = 0;
      int k = 0;
      i1 = i;
      if (j < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        l = ((Long)this.jdField_b_of_type_JavaUtilArrayList.get(j)).longValue();
        if (l == this.jdField_a_of_type_Long)
        {
          i = 1;
          i1 = 1;
          this.x = j;
        }
        for (;;)
        {
          j += 1;
          k = i1;
          break;
          i1 = k;
          if (l == this.jdField_b_of_type_Long)
          {
            int i2 = 1;
            i = i2;
            i1 = k;
            if (k == 0)
            {
              this.x = j;
              i = i2;
              i1 = k;
            }
          }
        }
      }
    }
    else
    {
      i1 = 0;
    }
    if ((i1 == 0) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(this.jdField_b_of_type_Long));
      if (this.x == -1) {
        this.x = (this.jdField_b_of_type_JavaUtilArrayList.size() - 1);
      }
    }
    if (this.x == -1)
    {
      this.x = 0;
      this.jdField_c_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg mWebStyleList = " + this.jdField_b_of_type_JavaUtilArrayList.toString() + ", mCurrentStyleId = " + this.jdField_a_of_type_Long + ", mWebStyleId = " + this.jdField_b_of_type_Long + ", mCurrentViewPos = " + this.x + ", mStyleListNull = " + this.jdField_c_of_type_Boolean);
    }
  }
  
  boolean a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
    awrb localawrb = (awrb)this.jdField_a_of_type_JavaUtilList.get(i);
    if ((localawrb != null) && (localawrb.jdField_a_of_type_Awra != null)) {
      return localawrb.jdField_a_of_type_Awra.jdField_o_of_type_Long == awra.n;
    }
    return false;
  }
  
  @TargetApi(16)
  protected boolean a(Message paramMessage)
  {
    int i = 0;
    switch (paramMessage.what)
    {
    default: 
      if (paramMessage.what != 2) {
        break label396;
      }
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      break;
    }
    for (;;)
    {
      return true;
      paramMessage = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getLayoutParams();
      paramMessage.height = this.m;
      paramMessage.topMargin = this.u;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayoutParams(paramMessage);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setScale(this.jdField_b_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setGap(this.v);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity$StylePagerAdapter);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setVisibility(0);
      k();
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setCurrentItem(this.x);
      d(this.x);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initiate now mCurrentViewPos = " + this.x);
      }
      if (this.jdField_f_of_type_Boolean)
      {
        paramMessage = (alpk)this.app.a(2);
        if (paramMessage != null)
        {
          long l = NetConnInfoCenter.getServerTimeMillis();
          if (Math.abs(l - this.jdField_c_of_type_Long) <= 60000L) {
            break label286;
          }
          this.jdField_c_of_type_Long = l;
          paramMessage.a(this.app.getCurrentAccountUin());
        }
      }
      for (;;)
      {
        return true;
        label286:
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "try getShoppingBindNo too frequently to req");
        }
      }
      int j = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getChildCount();
      while (i < j)
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getChildAt(i);
        if ((paramMessage.getTag() instanceof awsg)) {
          ((awsg)paramMessage.getTag()).jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        i += 1;
      }
      return true;
      c(paramMessage.arg1);
      return true;
      c(paramMessage.arg1);
      return true;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label396:
    if (paramMessage.what == 3)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131695610, 0).show();
      return true;
    }
    if (paramMessage.what == 20)
    {
      c(paramMessage.arg1);
      return true;
    }
    if (paramMessage.what == 5)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131695638, 0).show();
      if ((this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 2)) {
        if (this.B == 1) {
          BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.closeWeb"), "com.tencent.msg.permission.pushnotify");
        }
      }
      for (;;)
      {
        o();
        finish();
        return true;
        paramMessage = new Intent();
        paramMessage.putExtra("uin", this.app.getCurrentAccountUin());
        paramMessage.putExtra("entryId", this.jdField_f_of_type_Int);
        setResult(-1, paramMessage);
        continue;
        paramMessage = new Intent(this, FriendProfileCardActivity.class);
        paramMessage.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0));
        paramMessage.setFlags(67108864);
        startActivity(paramMessage);
      }
    }
    if (paramMessage.what == 21)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        ((awrb)this.jdField_a_of_type_JavaUtilList.get(paramMessage.arg1)).jdField_a_of_type_Int = -1;
      }
      return true;
    }
    if ((paramMessage.what == 24) || (paramMessage.what == 25))
    {
      if (paramMessage.what == 25) {
        b();
      }
      Toast.makeText(getApplicationContext(), getResources().getString(2131695643), 1).show();
      return true;
    }
    return false;
  }
  
  public boolean a(awrb paramawrb)
  {
    if ((paramawrb == null) || (paramawrb.jdField_a_of_type_Awra == null)) {
      return false;
    }
    paramawrb = a(paramawrb);
    if ((paramawrb == null) || (paramawrb.size() == 0)) {
      return false;
    }
    paramawrb = paramawrb.iterator();
    while (paramawrb.hasNext())
    {
      String str = (String)paramawrb.next();
      if (!bddf.a(this.jdField_a_of_type_AndroidContentContext, str)) {
        return false;
      }
    }
    return true;
  }
  
  public void addObserver(alpg paramalpg)
  {
    if (this.app != null) {
      this.app.addObserver(paramalpg);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.C != -1)
    {
      a(this.C);
      this.C = -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    do
    {
      awrb localawrb;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
              } while ((localObject == null) || (((View)localObject).getTag() == null));
              localObject = (awsg)((View)localObject).getTag();
            } while (localObject == null);
            localObject = ((awsg)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView;
            localawrb = (awrb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          } while ((localawrb == null) || (((ProfileCardScrollImageView)localObject).getTag() == null));
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startAnimation pos = " + paramInt);
          }
          switch (localawrb.jdField_a_of_type_Awra.d)
          {
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "no animation to start !");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_SCROLL");
        }
      } while (localawrb.jdField_a_of_type_Awra.jdField_o_of_type_Long == awra.n);
      ((ProfileCardScrollImageView)localObject).setScrollDuration(1500);
      ((ProfileCardScrollImageView)localObject).a(this.A);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_FADE_IN_OUT");
      }
      localObject = ((ProfileCardScrollImageView)localObject).getDrawable();
    } while (!(localObject instanceof TransitionDrawable));
    Object localObject = (TransitionDrawable)localObject;
    ((TransitionDrawable)localObject).setCrossFadeEnabled(true);
    ((TransitionDrawable)localObject).startTransition(1500);
    this.jdField_b_of_type_JavaLangRunnable = new VipProfileCardPreviewActivity.3(this, (TransitionDrawable)localObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
  }
  
  void b(String paramString)
  {
    awse localawse = new awse(this, Long.parseLong(this.app.getCurrentAccountUin()), paramString, awug.a(this.app), "qqprofile", paramString);
    localawse.a = awug.a(this.app);
    localawse.i = awug.a(this.app, paramString);
    m();
    paramString = (awul)this.app.getManager(90);
    paramString.a(this.app, null);
    localawse.a();
    paramString.a(this.app, localawse, null);
  }
  
  void b(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    awqr localawqr;
    awra localawra;
    do
    {
      return;
      localawqr = new awqr();
      localawqr.jdField_a_of_type_Int = 160;
      localawra = ((awrb)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem())).jdField_a_of_type_Awra;
    } while ((localawra == null) || (this.g) || (isFinishing()) || (!a(localawra, localawqr, true)));
    a(a(), 0L, paramString2, bddf.a(paramString1));
  }
  
  void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
    } while ((localView == null) || (localView.getTag() == null));
    a((awsg)localView.getTag(), (awrb)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilList.get(paramInt) == null)) {
      return;
    }
    awrb localawrb = (awrb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localawrb.jdField_a_of_type_Awra.jdField_o_of_type_Long == awra.n)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695624);
      this.jdField_c_of_type_JavaLangString = "3";
      return;
    }
    a(localawrb.jdField_a_of_type_Awra, this.jdField_a_of_type_Awqr, false);
    if (this.jdField_b_of_type_Int == 4)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695632);
      this.jdField_c_of_type_JavaLangString = "2";
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695633);
      this.jdField_c_of_type_JavaLangString = "1";
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131695627);
    this.jdField_c_of_type_JavaLangString = "0";
  }
  
  @TargetApi(16)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.g = false;
    setContentView(2131561840);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373577);
    float f1;
    label420:
    QQAppInterface localQQAppInterface;
    if ((this.app != null) && (ThemeUtil.isInNightMode(this.app)))
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.app != null) {
        this.jdField_e_of_type_JavaLangString += this.app.getCurrentAccountUin();
      }
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131371556));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371362));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager = ((VipScaledViewPager)findViewById(2131379940));
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity$StylePagerAdapter = new VipProfileCardPreviewActivity.StylePagerAdapter(this, this.jdField_a_of_type_AndroidContentContext);
      if (Build.MODEL.equals("HUAWEI C8812E")) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayerType(1, null);
      }
      this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float / 2.0F);
      if (this.j / this.k <= (this.jdField_d_of_type_Float + this.jdField_e_of_type_Float) / 2.0F) {
        break label792;
      }
      f1 = this.j / (1136.0F * this.jdField_c_of_type_Float);
      this.n = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.o = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.p = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.q = bddf.c(this.jdField_a_of_type_AndroidContentContext, 45);
      this.r = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 3) * f1);
      this.t = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 7) * f1);
      this.s = Math.round(bddf.a(this.jdField_a_of_type_AndroidContentContext, 14.5F) * f1);
      this.u = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 20) * f1);
      this.v = Math.round(f1 * bddf.c(this.jdField_a_of_type_AndroidContentContext, 15));
      this.jdField_b_of_type_Float = 0.824503F;
      this.w = 18;
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      paramBundle.height = this.q;
      int i = this.p;
      paramBundle.leftMargin = i;
      paramBundle.rightMargin = i;
      paramBundle.bottomMargin = this.o;
      this.jdField_a_of_type_AndroidWidgetButton.setTextSize(1, this.w);
      this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramBundle);
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.getLayoutParams();
      paramBundle.topMargin = this.s;
      paramBundle.bottomMargin = this.s;
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setLayoutParams(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding(this.t);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setRadius(this.r);
      i = getResources().getDimensionPixelSize(2131298914);
      int j = bddf.a(getResources());
      this.m = (this.j - this.u - this.o - this.q - this.r * 2 - this.s * 2 - i - j);
      this.y = this.m;
      this.z = Math.round(this.y / 1.78F);
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setStrokeWidth(0.0F);
      addObserver(this.jdField_b_of_type_Alpq);
      ThreadManager.post(new VipProfileCardPreviewActivity.1(this), 8, null, true);
      i();
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.app != null) {
        this.app.addObserver(this.jdField_a_of_type_Alpq, true);
      }
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setOnPageChangeListener(new awsc(this));
      if (this.app != null)
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_Awqr != null) {
          break label988;
        }
      }
    }
    label792:
    label988:
    for (paramBundle = "";; paramBundle = Integer.toString(this.jdField_a_of_type_Awqr.jdField_a_of_type_Int))
    {
      azqs.b(localQQAppInterface, "CliOper", "", "", "card_mall", "0X8004D59", 0, 0, paramBundle, "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
      return true;
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break;
      f1 = this.j / (800.0F * this.jdField_c_of_type_Float);
      this.n = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 11) * f1);
      this.o = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 10) * f1);
      this.p = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 11) * f1);
      this.q = bddf.c(this.jdField_a_of_type_AndroidContentContext, 40);
      this.r = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 3) * f1);
      this.t = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 7) * f1);
      this.s = Math.round(bddf.a(this.jdField_a_of_type_AndroidContentContext, 16.5F) * f1);
      this.u = Math.round(bddf.c(this.jdField_a_of_type_AndroidContentContext, 20) * f1);
      this.v = Math.round(f1 * bddf.c(this.jdField_a_of_type_AndroidContentContext, 15));
      this.w = 16;
      this.jdField_b_of_type_Float = 0.8192771F;
      break label420;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.g = true;
    if (this.jdField_b_of_type_Alpq != null)
    {
      this.app.removeObserver(this.jdField_b_of_type_Alpq);
      this.jdField_b_of_type_Alpq = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_Alpq);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.app != null) {
      this.app.addObserver(this.jdField_a_of_type_Alpq, true);
    }
  }
  
  public void i()
  {
    setLeftViewName(2131690623);
    setTitle(2131695623);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData start.");
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilArrayList == null)) {
      return;
    }
    Object localObject2 = null;
    ArrayList localArrayList = a();
    if (this.jdField_b_of_type_Long == 0L)
    {
      localObject1 = new awra();
      ((awra)localObject1).jdField_o_of_type_Long = 0L;
      ((awra)localObject1).i = "http://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((awra)localObject1).jdField_e_of_type_JavaLangString = "http://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((awra)localObject1).k = "http://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((awra)localObject1).g = "http://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((awra)localObject1).jdField_c_of_type_JavaLangString = "0";
      ((awra)localObject1).jdField_a_of_type_JavaLangString = getString(2131695616);
      localArrayList.add(localObject1);
    }
    Object localObject1 = localObject2;
    int i;
    Object localObject3;
    label413:
    int j;
    int k;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        localObject1 = new ArrayList();
        if (this.jdField_c_of_type_Boolean)
        {
          i = 0;
          if (i < localArrayList.size())
          {
            localObject2 = (awra)localArrayList.get(i);
            if (this.jdField_a_of_type_Long == ((awra)localObject2).jdField_o_of_type_Long) {
              this.x = i;
            }
            if (((awra)localObject2).jdField_o_of_type_Long == awra.h)
            {
              this.jdField_f_of_type_Boolean = true;
              localObject3 = this.jdField_a_of_type_AndroidContentContext;
              Context localContext = this.jdField_a_of_type_AndroidContentContext;
              localObject3 = ((Context)localObject3).getSharedPreferences("is_binding_shop", 0);
              if ((localObject3 != null) && (((SharedPreferences)localObject3).getBoolean(this.jdField_e_of_type_JavaLangString, false))) {
                this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(((awra)localObject2).jdField_o_of_type_Long));
              }
              if (this.x == i)
              {
                this.x = 0;
                azqs.b(this.app, "CliOper", "", "", "Shop_Malltemplate", "0X8005B93", 0, 0, "", "", "", "");
              }
            }
            for (;;)
            {
              i += 1;
              break;
              this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(((awra)localObject2).jdField_o_of_type_Long));
            }
          }
          long l = awra.h;
          if ((this.jdField_b_of_type_JavaUtilArrayList.contains(Long.valueOf(l))) && (this.jdField_b_of_type_JavaUtilArrayList.contains(Long.valueOf(awra.n))))
          {
            this.jdField_b_of_type_JavaUtilArrayList.remove(Long.valueOf(l));
            this.jdField_b_of_type_JavaUtilArrayList.add(1, Long.valueOf(l));
          }
        }
        i = 0;
        if (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          j = 0;
          k = 0;
          label428:
          if (k < localArrayList.size())
          {
            localObject2 = (awra)localArrayList.get(k);
            if (((Long)this.jdField_b_of_type_JavaUtilArrayList.get(i)).longValue() != ((awra)localObject2).jdField_o_of_type_Long) {
              break label927;
            }
            localObject3 = new awrb();
            ((awrb)localObject3).jdField_a_of_type_Awra = ((awra)localObject2);
            if (a((awrb)localObject3))
            {
              ((awrb)localObject3).jdField_a_of_type_Int = 2;
              label502:
              a(((awrb)localObject3).jdField_a_of_type_Awra);
              ((ArrayList)localObject1).add(localObject3);
              j = 1;
            }
          }
        }
      }
    }
    label914:
    label927:
    for (;;)
    {
      k += 1;
      break label428;
      ((awrb)localObject3).jdField_a_of_type_Int = 0;
      break label502;
      if (j == 0)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(i);
        if ((this.x > 0) && (i <= this.x)) {
          this.x -= 1;
        }
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break label413;
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList != null)) {
              this.jdField_a_of_type_JavaUtilList.clear();
            }
            if (this.jdField_a_of_type_JavaUtilList == null) {
              break;
            }
            this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
            this.jdField_d_of_type_Boolean = true;
            if (!QLog.isColorLevel()) {
              break label914;
            }
            i = 0;
          }
          for (;;)
          {
            if (i < this.jdField_a_of_type_JavaUtilList.size())
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData, style : " + ((awrb)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Awra.jdField_o_of_type_Long + ", status : " + ((awrb)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int + ", position : " + i);
              }
              i += 1;
              continue;
              localObject1 = new ArrayList();
              i = 0;
              if (i < localArrayList.size())
              {
                localObject2 = new awrb();
                ((awrb)localObject2).jdField_a_of_type_Awra = ((awra)localArrayList.get(i));
                if (a((awrb)localObject2))
                {
                  ((awrb)localObject2).jdField_a_of_type_Int = 2;
                  label830:
                  a(((awrb)localObject2).jdField_a_of_type_Awra);
                  if (((awrb)localObject2).jdField_a_of_type_Awra.jdField_o_of_type_Long != awra.h) {
                    break label870;
                  }
                }
                for (;;)
                {
                  i += 1;
                  break;
                  ((awrb)localObject2).jdField_a_of_type_Int = 0;
                  break label830;
                  label870:
                  ((ArrayList)localObject1).add(localObject2);
                }
              }
              if (this.jdField_a_of_type_JavaUtilList == null) {
                break;
              }
              this.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
              this.jdField_d_of_type_Boolean = true;
            }
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (this.x != -1)
      {
        awrb localawrb = (awrb)this.jdField_a_of_type_JavaUtilList.get(this.x);
        a(this.x, localawrb);
      }
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.x != -1) && (i == this.x)) {}
        for (;;)
        {
          i += 1;
          break;
          a(i, (awrb)this.jdField_a_of_type_JavaUtilList.get(i));
        }
      }
    }
  }
  
  public void l()
  {
    int i = 0;
    h();
    Object localObject = getIntent();
    if (localObject != null)
    {
      String str;
      if (((Intent)localObject).hasExtra("preview"))
      {
        this.B = 0;
        str = ((Intent)localObject).getStringExtra("preview");
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg preview = " + str);
        }
        try
        {
          localObject = new JSONObject(str);
          if (((JSONObject)localObject).has("entryId")) {
            this.jdField_f_of_type_Int = ((JSONObject)localObject).getInt("entryId");
          }
          localObject = ((JSONObject)localObject).getJSONObject("item");
          this.jdField_a_of_type_Awqr = new awqr();
          this.jdField_a_of_type_Awqr.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("id");
          this.jdField_a_of_type_Awqr.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("name");
          this.jdField_a_of_type_Awqr.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("type");
          this.jdField_a_of_type_Awqr.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("image_url");
          this.jdField_a_of_type_Awqr.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("thumb_url");
          this.jdField_a_of_type_Awqr.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("auth");
          this.jdField_a_of_type_Awqr.d = ((JSONObject)localObject).optInt("limitefree_type");
          this.jdField_a_of_type_Awqr.e = ((JSONObject)localObject).optInt("limitefree_btime");
          this.jdField_a_of_type_Awqr.jdField_f_of_type_Int = ((JSONObject)localObject).optInt("limitefree_etime");
          this.jdField_a_of_type_Awqr.l = ((JSONObject)localObject).optInt("color");
          this.jdField_a_of_type_Awqr.g = ((JSONObject)localObject).optInt("tag");
          this.jdField_a_of_type_Awqr.h = ((JSONObject)localObject).optInt("tag_btime");
          this.jdField_a_of_type_Awqr.i = ((JSONObject)localObject).optInt("tag_etime");
          this.jdField_a_of_type_Awqr.j = ((JSONObject)localObject).optInt("background_btime");
          this.jdField_a_of_type_Awqr.k = ((JSONObject)localObject).optInt("background_etime");
          this.h = this.jdField_a_of_type_Awqr.l;
          a(this.jdField_a_of_type_Awqr);
          this.jdField_b_of_type_Long = ((JSONObject)localObject).optInt("style");
          if (this.jdField_a_of_type_Awqr.jdField_a_of_type_Int == 160)
          {
            this.jdField_b_of_type_Long = 1L;
            localObject = a();
            a((long[])localObject);
            a(this.jdField_a_of_type_Awqr.jdField_b_of_type_JavaLangString);
            return;
          }
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("style_list");
          long[] arrayOfLong = new long[localJSONArray.length()];
          for (;;)
          {
            localObject = arrayOfLong;
            if (i >= localJSONArray.length()) {
              break;
            }
            arrayOfLong[i] = localJSONArray.getLong(i);
            i += 1;
          }
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initStyleAndBg JSONException json = " + str);
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
      }
      else if (localJSONException.hasExtra("custom_card_background"))
      {
        this.B = 1;
        this.jdField_d_of_type_JavaLangString = localJSONException.getStringExtra("custom_card_background");
        this.jdField_a_of_type_Awqr = new awqr();
        this.jdField_a_of_type_Awqr.jdField_a_of_type_Int = 160;
        this.jdField_b_of_type_Long = 1L;
        a(a());
        a(this.jdField_d_of_type_JavaLangString, null);
      }
    }
  }
  
  void m()
  {
    this.jdField_a_of_type_Bety = new bety(this, getTitleBarHeight());
    this.jdField_a_of_type_Bety.setCancelable(false);
    this.jdField_a_of_type_Bety.c(2131695644);
    try
    {
      this.jdField_a_of_type_Bety.show();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(25, 30000L);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void n()
  {
    b();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(25);
  }
  
  void o()
  {
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      File localFile = new File(this.jdField_d_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    azqs.b(this.app, "CliOper", "", "", "card_mall", "0X8004C28", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0));
        if (this.B != 0) {
          break;
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
        paramView = (awrb)this.jdField_a_of_type_JavaUtilList.get(i);
        azqs.b(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.jdField_c_of_type_JavaLangString, Long.toString(paramView.jdField_a_of_type_Awra.jdField_o_of_type_Long), "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
        if (paramView.jdField_a_of_type_Awra.jdField_o_of_type_Long == awra.h) {
          azqs.b(this.app, "CliOper", "", "", "Shop_Malltemplateclk", "0X8005B92", 0, 0, "", "", "", "");
        }
      } while (!a(paramView.jdField_a_of_type_Awra, this.jdField_a_of_type_Awqr, true));
      if (this.jdField_a_of_type_Awqr.jdField_a_of_type_Int != 160)
      {
        a(paramView.jdField_a_of_type_Awra.jdField_o_of_type_Long, this.jdField_a_of_type_Awqr.jdField_a_of_type_Int);
        return;
      }
      a(a(), this.jdField_a_of_type_Awqr.jdField_a_of_type_Int, this.jdField_a_of_type_Awqr.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Awqr.l);
      return;
    } while (this.B != 1);
    azqs.b(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.jdField_c_of_type_JavaLangString, "-1", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
    if (a())
    {
      paramView = new Intent(this, VipProfileCardDiyActivity.class);
      paramView.putExtra("extra_from", 3);
      paramView.putExtra("extra_card_id", 0L);
      paramView.putExtra("extra_card_path", this.jdField_d_of_type_JavaLangString);
      startActivity(paramView);
      return;
    }
    bddf.a(this.jdField_d_of_type_JavaLangString, 100, 0.56338F);
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString)))
    {
      b(this.jdField_d_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString));
      return;
    }
    b(this.jdField_d_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity
 * JD-Core Version:    0.7.0.1
 */