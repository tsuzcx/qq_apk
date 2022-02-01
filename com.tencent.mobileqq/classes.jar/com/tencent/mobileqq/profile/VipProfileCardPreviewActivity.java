package com.tencent.mobileqq.profile;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask;
import com.tencent.mobileqq.profile.upload.task.VipImageUploadManager;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ProfileCardScrollImageView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  public ProfileCardBackground a;
  public VipProfileCardPreviewActivity.StylePagerAdapter a;
  public VipScaledViewPager a;
  public CirclePageIndicator a;
  HashMap<String, String> a;
  public List<ProfileCardTemplateInfo> a;
  public float b;
  public long b;
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
  volatile boolean f;
  public int m = -1;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public int q = 0;
  public int r = 0;
  public int s = 0;
  public int t = 0;
  public int u = 0;
  public int v = 0;
  public int w = 0;
  public int x = -1;
  public int y;
  public int z;
  
  public VipProfileCardPreviewActivity()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Float = 1.666667F;
    this.jdField_e_of_type_Float = 1.775F;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "is_binding_shop";
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_f_of_type_Boolean = false;
  }
  
  int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 1;
    int i1 = j;
    if (paramInt1 != 0)
    {
      i1 = j;
      if (paramInt2 != 0)
      {
        i1 = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          j = paramOptions.outHeight;
          int k = paramOptions.outWidth;
          for (;;)
          {
            i1 = i;
            if (j <= paramInt2) {
              break;
            }
            i1 = i;
            if (k <= paramInt1) {
              break;
            }
            int i2 = Math.round(j / paramInt2);
            i1 = Math.round(k / paramInt1);
            if (i2 <= i1) {
              i2 = i1;
            }
            i1 = i;
            if (i2 < 2) {
              break;
            }
            k /= 2;
            j /= 2;
            i *= 2;
          }
        }
      }
    }
    return i1;
  }
  
  long a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
    return ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.styleId;
  }
  
  /* Error */
  android.graphics.Bitmap a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 190	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   3: astore 4
    //   5: iconst_1
    //   6: istore_3
    //   7: aconst_null
    //   8: astore 6
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 9
    //   16: iload_3
    //   17: iconst_2
    //   18: if_icmpgt +610 -> 628
    //   21: new 142	android/graphics/BitmapFactory$Options
    //   24: dup
    //   25: invokespecial 191	android/graphics/BitmapFactory$Options:<init>	()V
    //   28: astore 7
    //   30: aload 7
    //   32: aload 4
    //   34: putfield 194	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   37: aload 7
    //   39: aload_0
    //   40: getfield 197	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   43: putfield 200	android/graphics/BitmapFactory$Options:inDensity	I
    //   46: aload 7
    //   48: aload_0
    //   49: getfield 197	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   52: putfield 203	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   55: aload 7
    //   57: aload_0
    //   58: getfield 197	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   61: putfield 206	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   64: new 208	java/io/BufferedInputStream
    //   67: dup
    //   68: new 210	java/io/FileInputStream
    //   71: dup
    //   72: new 212	java/io/File
    //   75: dup
    //   76: aload_1
    //   77: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 221	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore 4
    //   88: iload_2
    //   89: ifeq +37 -> 126
    //   92: aload 7
    //   94: iconst_1
    //   95: putfield 224	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   98: aload 4
    //   100: aconst_null
    //   101: aload 7
    //   103: invokestatic 230	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   106: pop
    //   107: aload 7
    //   109: aload_0
    //   110: aload 7
    //   112: aload_0
    //   113: getfield 232	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   116: aload_0
    //   117: getfield 234	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	I
    //   120: invokevirtual 236	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   123: putfield 239	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   126: aload 7
    //   128: iconst_0
    //   129: putfield 224	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   132: new 208	java/io/BufferedInputStream
    //   135: dup
    //   136: new 210	java/io/FileInputStream
    //   139: dup
    //   140: new 212	java/io/File
    //   143: dup
    //   144: aload_1
    //   145: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   151: invokespecial 221	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   154: astore 6
    //   156: aload 4
    //   158: astore 8
    //   160: aload 6
    //   162: astore 5
    //   164: aload 6
    //   166: aconst_null
    //   167: aload 7
    //   169: invokestatic 230	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   172: astore 7
    //   174: aload 7
    //   176: astore_1
    //   177: aload 4
    //   179: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   182: aload 7
    //   184: astore_1
    //   185: aload 6
    //   187: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   190: aload 7
    //   192: areturn
    //   193: astore 4
    //   195: ldc 244
    //   197: iconst_1
    //   198: ldc 246
    //   200: aload 4
    //   202: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_1
    //   206: areturn
    //   207: astore 5
    //   209: aload 4
    //   211: astore 7
    //   213: aload 6
    //   215: astore 4
    //   217: aload 5
    //   219: astore 6
    //   221: goto +53 -> 274
    //   224: astore_1
    //   225: goto +365 -> 590
    //   228: astore 6
    //   230: aconst_null
    //   231: astore 5
    //   233: aload 4
    //   235: astore 7
    //   237: aload 5
    //   239: astore 4
    //   241: goto +33 -> 274
    //   244: aconst_null
    //   245: astore 6
    //   247: aload 4
    //   249: astore 5
    //   251: aload 6
    //   253: astore 4
    //   255: goto +212 -> 467
    //   258: astore_1
    //   259: aconst_null
    //   260: astore 4
    //   262: goto +328 -> 590
    //   265: astore 6
    //   267: aconst_null
    //   268: astore 7
    //   270: aload 7
    //   272: astore 4
    //   274: aload 7
    //   276: astore 8
    //   278: aload 4
    //   280: astore 5
    //   282: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +139 -> 424
    //   288: aload 7
    //   290: astore 8
    //   292: aload 4
    //   294: astore 5
    //   296: new 257	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   303: astore 10
    //   305: aload 7
    //   307: astore 8
    //   309: aload 4
    //   311: astore 5
    //   313: aload 10
    //   315: ldc_w 260
    //   318: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 7
    //   324: astore 8
    //   326: aload 4
    //   328: astore 5
    //   330: aload 10
    //   332: aload_1
    //   333: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 7
    //   339: astore 8
    //   341: aload 4
    //   343: astore 5
    //   345: aload 10
    //   347: ldc_w 266
    //   350: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 7
    //   356: astore 8
    //   358: aload 4
    //   360: astore 5
    //   362: aload 10
    //   364: aload 6
    //   366: invokevirtual 270	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   369: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 7
    //   375: astore 8
    //   377: aload 4
    //   379: astore 5
    //   381: aload 10
    //   383: ldc_w 272
    //   386: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 7
    //   392: astore 8
    //   394: aload 4
    //   396: astore 5
    //   398: aload 10
    //   400: iload_3
    //   401: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload 7
    //   407: astore 8
    //   409: aload 4
    //   411: astore 5
    //   413: ldc 244
    //   415: iconst_2
    //   416: aload 10
    //   418: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: aload 7
    //   426: ifnull +11 -> 437
    //   429: aload 9
    //   431: astore_1
    //   432: aload 7
    //   434: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   437: aload 4
    //   439: ifnull +189 -> 628
    //   442: aload 9
    //   444: astore_1
    //   445: aload 4
    //   447: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   450: aconst_null
    //   451: areturn
    //   452: astore_1
    //   453: aload 5
    //   455: astore 4
    //   457: goto +125 -> 582
    //   460: aconst_null
    //   461: astore 4
    //   463: aload 6
    //   465: astore 5
    //   467: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   470: ifeq +55 -> 525
    //   473: new 257	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   480: astore 6
    //   482: aload 6
    //   484: ldc_w 260
    //   487: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload 6
    //   493: aload_1
    //   494: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload 6
    //   500: ldc_w 272
    //   503: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 6
    //   509: iload_3
    //   510: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: ldc 244
    //   516: iconst_2
    //   517: aload 6
    //   519: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: getstatic 284	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   528: astore 6
    //   530: aload 5
    //   532: ifnull +11 -> 543
    //   535: aload 5
    //   537: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   540: goto +3 -> 543
    //   543: aload 4
    //   545: ifnull +21 -> 566
    //   548: aload 4
    //   550: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   553: goto +13 -> 566
    //   556: ldc 244
    //   558: iconst_1
    //   559: ldc 246
    //   561: aload 4
    //   563: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   566: iload_3
    //   567: iconst_1
    //   568: iadd
    //   569: istore_3
    //   570: aload 6
    //   572: astore 4
    //   574: goto -567 -> 7
    //   577: astore_1
    //   578: aload 5
    //   580: astore 8
    //   582: aload 4
    //   584: astore 5
    //   586: aload 8
    //   588: astore 4
    //   590: aload 4
    //   592: ifnull +11 -> 603
    //   595: aload 4
    //   597: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   600: goto +3 -> 603
    //   603: aload 5
    //   605: ifnull +21 -> 626
    //   608: aload 5
    //   610: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   613: goto +13 -> 626
    //   616: ldc 244
    //   618: iconst_1
    //   619: ldc 246
    //   621: aload 4
    //   623: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   626: aload_1
    //   627: athrow
    //   628: aconst_null
    //   629: areturn
    //   630: astore 4
    //   632: goto -172 -> 460
    //   635: astore 5
    //   637: goto -393 -> 244
    //   640: astore 5
    //   642: goto -395 -> 247
    //   645: astore 4
    //   647: goto -91 -> 556
    //   650: astore 4
    //   652: goto -36 -> 616
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	this	VipProfileCardPreviewActivity
    //   0	655	1	paramString	String
    //   0	655	2	paramBoolean	boolean
    //   6	564	3	i	int
    //   3	175	4	localObject1	Object
    //   193	17	4	localException1	Exception
    //   215	407	4	localObject2	Object
    //   630	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   645	1	4	localException2	Exception
    //   650	1	4	localException3	Exception
    //   11	152	5	localObject3	Object
    //   207	11	5	localException4	Exception
    //   231	378	5	localObject4	Object
    //   635	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   640	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   8	212	6	localObject5	Object
    //   228	1	6	localException5	Exception
    //   245	7	6	localObject6	Object
    //   265	199	6	localException6	Exception
    //   480	91	6	localObject7	Object
    //   28	405	7	localObject8	Object
    //   158	429	8	localObject9	Object
    //   14	429	9	localObject10	Object
    //   303	114	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   177	182	193	java/lang/Exception
    //   185	190	193	java/lang/Exception
    //   432	437	193	java/lang/Exception
    //   445	450	193	java/lang/Exception
    //   164	174	207	java/lang/Exception
    //   92	126	224	finally
    //   126	156	224	finally
    //   92	126	228	java/lang/Exception
    //   126	156	228	java/lang/Exception
    //   21	88	258	finally
    //   21	88	265	java/lang/Exception
    //   164	174	452	finally
    //   282	288	452	finally
    //   296	305	452	finally
    //   313	322	452	finally
    //   330	337	452	finally
    //   345	354	452	finally
    //   362	373	452	finally
    //   381	390	452	finally
    //   398	405	452	finally
    //   413	424	452	finally
    //   467	525	577	finally
    //   525	530	577	finally
    //   21	88	630	java/lang/OutOfMemoryError
    //   92	126	635	java/lang/OutOfMemoryError
    //   126	156	635	java/lang/OutOfMemoryError
    //   164	174	640	java/lang/OutOfMemoryError
    //   535	540	645	java/lang/Exception
    //   548	553	645	java/lang/Exception
    //   595	600	650	java/lang/Exception
    //   608	613	650	java/lang/Exception
  }
  
  public List<String> a(ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramProfileCardTemplateInfo != null)
    {
      if (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate == null) {
        return localArrayList;
      }
      if (this.h == 1) {
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.imageWhiteSmall);
      } else {
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.imageBlackSmall);
      }
      if (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.animation == 2)
      {
        if (this.h == 1)
        {
          localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.frameWhiteSmall);
          return localArrayList;
        }
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.frameBlackSmall);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    VipScaledViewPager localVipScaledViewPager = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager;
    if (localVipScaledViewPager == null) {
      return;
    }
    d(localVipScaledViewPager.getCurrentItem());
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager != null)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (paramInt >= 0))
      {
        if (paramInt >= ((List)localObject).size()) {
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
        if (localObject != null)
        {
          if (((View)localObject).getTag() == null) {
            return;
          }
          localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag();
          if (localObject != null)
          {
            localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView;
            ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
            if (localProfileCardTemplateInfo != null)
            {
              paramInt = localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.animation;
              if (paramInt != 0)
              {
                if (paramInt != 1)
                {
                  if (paramInt != 2) {
                    return;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_FADE_IN_OUT");
                  }
                  if (this.jdField_b_of_type_JavaLangRunnable != null) {
                    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
                  }
                  localObject = ((ProfileCardScrollImageView)localObject).getDrawable();
                  if ((localObject != null) && ((localObject instanceof TransitionDrawable))) {
                    ((TransitionDrawable)localObject).resetTransition();
                  }
                }
                else
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_SCROLL");
                  }
                  ((ProfileCardScrollImageView)localObject).a();
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "cancel ANIMATION_NONE");
              }
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    if (paramProfileCardTemplateInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownload pos = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", status = ");
      localStringBuilder.append(paramProfileCardTemplateInfo.jdField_a_of_type_Int);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, localStringBuilder.toString());
    }
    if ((paramProfileCardTemplateInfo.jdField_a_of_type_Int != 2) && (paramProfileCardTemplateInfo.jdField_a_of_type_Int != 1))
    {
      paramProfileCardTemplateInfo.jdField_a_of_type_Int = 1;
      paramProfileCardTemplateInfo = a(paramProfileCardTemplateInfo);
      this.jdField_b_of_type_JavaUtilList.addAll(paramProfileCardTemplateInfo);
      a(paramInt, paramProfileCardTemplateInfo);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    ThreadManager.post(new VipProfileCardPreviewActivity.4(this, paramInt, paramString), 5, null, true);
  }
  
  public void a(int paramInt, List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramInt, (String)paramList.next());
      }
    }
  }
  
  /* Error */
  public void a(VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder paramViewHolder, ProfileCardTemplateInfo paramProfileCardTemplateInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 409	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Lcom/tencent/mobileqq/profile/ProfileCardTemplateInfo;)Z
    //   5: ifeq +870 -> 875
    //   8: aload_2
    //   9: iconst_2
    //   10: putfield 367	com/tencent/mobileqq/profile/ProfileCardTemplateInfo:jdField_a_of_type_Int	I
    //   13: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +48 -> 64
    //   19: new 257	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   26: astore 8
    //   28: aload 8
    //   30: ldc_w 411
    //   33: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 8
    //   39: iload_3
    //   40: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 8
    //   46: ldc_w 413
    //   49: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 244
    //   55: iconst_2
    //   56: aload 8
    //   58: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: aload_2
    //   66: invokevirtual 369	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Lcom/tencent/mobileqq/profile/ProfileCardTemplateInfo;)Ljava/util/List;
    //   69: astore 8
    //   71: aload 8
    //   73: ifnull +801 -> 874
    //   76: aload 8
    //   78: invokeinterface 315 1 0
    //   83: ifne +4 -> 87
    //   86: return
    //   87: aload_2
    //   88: getfield 174	com/tencent/mobileqq/profile/ProfileCardTemplateInfo:jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate	Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;
    //   91: getfield 179	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:styleId	J
    //   94: getstatic 416	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:PROFILE_CARD_STYLE_DIY	J
    //   97: lcmp
    //   98: ifne +117 -> 215
    //   101: aload_1
    //   102: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   105: iconst_0
    //   106: invokevirtual 424	com/tencent/mobileqq/hiboom/HiBoomTextView:setVisibility	(I)V
    //   109: sipush 2000
    //   112: istore 6
    //   114: getstatic 428	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   117: astore 9
    //   119: getstatic 431	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   122: ifnull +24 -> 146
    //   125: getstatic 431	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   128: invokevirtual 434	android/util/SparseArray:size	()I
    //   131: ifle +15 -> 146
    //   134: getstatic 431	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   137: iconst_0
    //   138: invokevirtual 438	android/util/SparseArray:keyAt	(I)I
    //   141: istore 6
    //   143: goto +10 -> 153
    //   146: aload_0
    //   147: getfield 442	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   150: invokestatic 445	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:a	(Lmqq/app/AppRuntime;)V
    //   153: aload_1
    //   154: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   157: iload 6
    //   159: iconst_1
    //   160: getstatic 450	com/tencent/mobileqq/hiboom/HiBoomConstants:a	Lcom/tencent/mobileqq/hiboom/HiBoomFont$HiBoomFontDownloader;
    //   163: invokevirtual 454	com/tencent/mobileqq/hiboom/HiBoomTextView:setHiBoom	(IILcom/tencent/mobileqq/hiboom/HiBoomFont$HiBoomFontDownloader;)V
    //   166: aload_1
    //   167: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   170: aload 9
    //   172: invokevirtual 458	com/tencent/mobileqq/hiboom/HiBoomTextView:setText	(Ljava/lang/CharSequence;)V
    //   175: aload_0
    //   176: getfield 232	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   179: i2f
    //   180: aload_0
    //   181: invokevirtual 462	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:getResources	()Landroid/content/res/Resources;
    //   184: invokevirtual 468	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   187: getfield 473	android/util/DisplayMetrics:widthPixels	I
    //   190: i2f
    //   191: fdiv
    //   192: fstore 4
    //   194: aload_1
    //   195: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   198: fload 4
    //   200: invokevirtual 477	com/tencent/mobileqq/hiboom/HiBoomTextView:setScaleX	(F)V
    //   203: aload_1
    //   204: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   207: fload 4
    //   209: invokevirtual 480	com/tencent/mobileqq/hiboom/HiBoomTextView:setScaleY	(F)V
    //   212: goto +12 -> 224
    //   215: aload_1
    //   216: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   219: bipush 8
    //   221: invokevirtual 424	com/tencent/mobileqq/hiboom/HiBoomTextView:setVisibility	(I)V
    //   224: aload_2
    //   225: getfield 174	com/tencent/mobileqq/profile/ProfileCardTemplateInfo:jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate	Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;
    //   228: getfield 301	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:animation	I
    //   231: istore 6
    //   233: iload 6
    //   235: ifeq +546 -> 781
    //   238: aconst_null
    //   239: astore 9
    //   241: aconst_null
    //   242: astore_2
    //   243: iload 6
    //   245: iconst_1
    //   246: if_icmpeq +193 -> 439
    //   249: iload 6
    //   251: iconst_2
    //   252: if_icmpeq +4 -> 256
    //   255: return
    //   256: aload_1
    //   257: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   260: iconst_0
    //   261: invokevirtual 484	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   264: aload 8
    //   266: invokeinterface 315 1 0
    //   271: iconst_1
    //   272: if_icmple +602 -> 874
    //   275: aload 8
    //   277: iconst_0
    //   278: invokeinterface 169 2 0
    //   283: checkcast 486	java/lang/CharSequence
    //   286: invokestatic 492	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifne +149 -> 438
    //   292: aload 8
    //   294: iconst_1
    //   295: invokeinterface 169 2 0
    //   300: checkcast 486	java/lang/CharSequence
    //   303: invokestatic 492	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   306: ifeq +4 -> 310
    //   309: return
    //   310: new 257	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   317: astore_2
    //   318: aload_2
    //   319: aload 8
    //   321: iconst_0
    //   322: invokeinterface 169 2 0
    //   327: checkcast 402	java/lang/String
    //   330: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: aload 8
    //   337: iconst_1
    //   338: invokeinterface 169 2 0
    //   343: checkcast 402	java/lang/String
    //   346: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_2
    //   351: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: astore_2
    //   355: getstatic 497	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   358: aload_2
    //   359: invokevirtual 502	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   362: instanceof 504
    //   365: ifeq +53 -> 418
    //   368: getstatic 497	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   371: aload_2
    //   372: invokevirtual 502	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   375: checkcast 504	android/util/Pair
    //   378: getfield 508	android/util/Pair:first	Ljava/lang/Object;
    //   381: checkcast 510	android/graphics/drawable/Drawable
    //   384: astore_2
    //   385: aload_1
    //   386: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   389: aload_2
    //   390: invokevirtual 514	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   393: aload_1
    //   394: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   397: iload_3
    //   398: invokestatic 520	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   401: invokevirtual 524	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   404: aload_0
    //   405: getfield 84	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:x	I
    //   408: iload_3
    //   409: if_icmpne +465 -> 874
    //   412: aload_0
    //   413: iload_3
    //   414: invokevirtual 526	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:b	(I)V
    //   417: return
    //   418: new 528	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$6
    //   421: dup
    //   422: aload_0
    //   423: aload 8
    //   425: aload_2
    //   426: iload_3
    //   427: invokespecial 531	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$6:<init>	(Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;Ljava/util/List;Ljava/lang/String;I)V
    //   430: bipush 8
    //   432: aconst_null
    //   433: iconst_1
    //   434: invokestatic 388	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   437: return
    //   438: return
    //   439: aload_1
    //   440: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   443: iconst_1
    //   444: invokevirtual 484	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   447: aload 8
    //   449: iconst_0
    //   450: invokeinterface 169 2 0
    //   455: checkcast 402	java/lang/String
    //   458: invokestatic 536	com/tencent/mobileqq/util/ProfileCardUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   461: astore 10
    //   463: new 208	java/io/BufferedInputStream
    //   466: dup
    //   467: new 210	java/io/FileInputStream
    //   470: dup
    //   471: new 212	java/io/File
    //   474: dup
    //   475: aload 10
    //   477: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   480: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   483: invokespecial 221	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   486: astore 8
    //   488: new 142	android/graphics/BitmapFactory$Options
    //   491: dup
    //   492: invokespecial 191	android/graphics/BitmapFactory$Options:<init>	()V
    //   495: astore_2
    //   496: aload_2
    //   497: iconst_1
    //   498: putfield 224	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   501: aload_2
    //   502: aload_0
    //   503: getfield 197	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   506: putfield 200	android/graphics/BitmapFactory$Options:inDensity	I
    //   509: aload_2
    //   510: aload_0
    //   511: getfield 197	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   514: putfield 203	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   517: aload_2
    //   518: aload_0
    //   519: getfield 197	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   522: putfield 206	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   525: aload 8
    //   527: aconst_null
    //   528: aload_2
    //   529: invokestatic 230	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   532: pop
    //   533: aload_2
    //   534: getfield 148	android/graphics/BitmapFactory$Options:outWidth	I
    //   537: istore 6
    //   539: aload_2
    //   540: getfield 145	android/graphics/BitmapFactory$Options:outHeight	I
    //   543: aload_0
    //   544: getfield 232	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   547: imul
    //   548: iload 6
    //   550: idiv
    //   551: istore 7
    //   553: aload_0
    //   554: aload_0
    //   555: getfield 234	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	I
    //   558: iload 7
    //   560: isub
    //   561: putfield 538	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:A	I
    //   564: aload_1
    //   565: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   568: getstatic 544	android/widget/ImageView$ScaleType:MATRIX	Landroid/widget/ImageView$ScaleType;
    //   571: invokevirtual 548	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   574: new 550	android/graphics/Matrix
    //   577: dup
    //   578: invokespecial 551	android/graphics/Matrix:<init>	()V
    //   581: astore_2
    //   582: aload_0
    //   583: getfield 232	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   586: i2f
    //   587: fstore 4
    //   589: iload 6
    //   591: i2f
    //   592: fstore 5
    //   594: aload_2
    //   595: fload 4
    //   597: fload 5
    //   599: fdiv
    //   600: aload_0
    //   601: getfield 232	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   604: i2f
    //   605: fload 5
    //   607: fdiv
    //   608: invokevirtual 555	android/graphics/Matrix:postScale	(FF)Z
    //   611: pop
    //   612: aload_1
    //   613: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   616: aload_2
    //   617: invokevirtual 559	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageMatrix	(Landroid/graphics/Matrix;)V
    //   620: getstatic 497	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   623: aload 10
    //   625: invokevirtual 502	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   628: checkcast 510	android/graphics/drawable/Drawable
    //   631: astore_2
    //   632: aload_2
    //   633: ifnull +38 -> 671
    //   636: aload_1
    //   637: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   640: aload_2
    //   641: invokevirtual 514	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   644: aload_1
    //   645: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   648: iload_3
    //   649: invokestatic 520	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: invokevirtual 524	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   655: aload_0
    //   656: getfield 84	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:x	I
    //   659: iload_3
    //   660: if_icmpne +29 -> 689
    //   663: aload_0
    //   664: iload_3
    //   665: invokevirtual 526	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:b	(I)V
    //   668: goto +21 -> 689
    //   671: new 561	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$5
    //   674: dup
    //   675: aload_0
    //   676: aload 10
    //   678: iload_3
    //   679: invokespecial 564	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$5:<init>	(Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;Ljava/lang/String;I)V
    //   682: bipush 8
    //   684: aconst_null
    //   685: iconst_1
    //   686: invokestatic 388	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   689: aload 8
    //   691: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   694: return
    //   695: astore_1
    //   696: goto +59 -> 755
    //   699: astore_2
    //   700: aload 8
    //   702: astore_1
    //   703: aload_2
    //   704: astore 8
    //   706: goto +15 -> 721
    //   709: astore_1
    //   710: aload_2
    //   711: astore 8
    //   713: goto +42 -> 755
    //   716: astore 8
    //   718: aload 9
    //   720: astore_1
    //   721: aload_1
    //   722: astore_2
    //   723: ldc 244
    //   725: iconst_1
    //   726: ldc_w 566
    //   729: aload 8
    //   731: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   734: aload_1
    //   735: ifnull +139 -> 874
    //   738: aload_1
    //   739: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   742: return
    //   743: astore_1
    //   744: ldc 244
    //   746: iconst_1
    //   747: ldc_w 566
    //   750: aload_1
    //   751: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   754: return
    //   755: aload 8
    //   757: ifnull +22 -> 779
    //   760: aload 8
    //   762: invokevirtual 242	java/io/BufferedInputStream:close	()V
    //   765: goto +14 -> 779
    //   768: astore_2
    //   769: ldc 244
    //   771: iconst_1
    //   772: ldc_w 566
    //   775: aload_2
    //   776: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   779: aload_1
    //   780: athrow
    //   781: aload_1
    //   782: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   785: iconst_0
    //   786: invokevirtual 484	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   789: new 257	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   796: astore_2
    //   797: aload_2
    //   798: ldc_w 568
    //   801: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload_2
    //   806: aload 8
    //   808: iconst_0
    //   809: invokeinterface 169 2 0
    //   814: checkcast 402	java/lang/String
    //   817: invokestatic 536	com/tencent/mobileqq/util/ProfileCardUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   820: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload_2
    //   825: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: aload_0
    //   829: getfield 232	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   832: aload_0
    //   833: getfield 234	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	I
    //   836: aload_1
    //   837: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   840: invokevirtual 349	com/tencent/mobileqq/widget/ProfileCardScrollImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   843: aload_1
    //   844: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   847: invokevirtual 349	com/tencent/mobileqq/widget/ProfileCardScrollImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   850: iconst_0
    //   851: invokestatic 573	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)Lcom/tencent/image/URLDrawable;
    //   854: astore_2
    //   855: aload_1
    //   856: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   859: aload_2
    //   860: invokevirtual 514	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   863: aload_1
    //   864: getfield 330	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   867: iload_3
    //   868: invokestatic 520	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   871: invokevirtual 524	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   874: return
    //   875: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq +43 -> 921
    //   881: new 257	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   888: astore_1
    //   889: aload_1
    //   890: ldc_w 411
    //   893: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload_1
    //   898: iload_3
    //   899: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: aload_1
    //   904: ldc_w 575
    //   907: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: ldc 244
    //   913: iconst_2
    //   914: aload_1
    //   915: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   918: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   921: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	922	0	this	VipProfileCardPreviewActivity
    //   0	922	1	paramViewHolder	VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder
    //   0	922	2	paramProfileCardTemplateInfo	ProfileCardTemplateInfo
    //   0	922	3	paramInt	int
    //   192	404	4	f1	float
    //   592	14	5	f2	float
    //   112	478	6	i	int
    //   551	10	7	j	int
    //   26	686	8	localObject	Object
    //   716	91	8	localException	Exception
    //   117	602	9	str1	String
    //   461	216	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   488	589	695	finally
    //   594	632	695	finally
    //   636	668	695	finally
    //   671	689	695	finally
    //   488	589	699	java/lang/Exception
    //   594	632	699	java/lang/Exception
    //   636	668	699	java/lang/Exception
    //   671	689	699	java/lang/Exception
    //   463	488	709	finally
    //   723	734	709	finally
    //   463	488	716	java/lang/Exception
    //   689	694	743	java/lang/Exception
    //   738	742	743	java/lang/Exception
    //   760	765	768	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = ProfileCardUtil.a(paramString);
      Object localObject1 = new File(paramString);
      if ((((File)localObject1).isFile()) && (((File)localObject1).exists()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("profilecard_preview:");
        ((StringBuilder)localObject1).append(paramString);
        Object localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = (Pair)GlobalImageCache.a.get(localObject2);
        if ((localObject1 != null) && (((Pair)localObject1).first != null))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("get image form sImageCache filePath=");
            ((StringBuilder)localObject2).append(paramString);
            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, ((StringBuilder)localObject2).toString());
          }
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable.ConstantState)((Pair)localObject1).first).newDrawable();
          return;
        }
        a(paramString, (String)localObject2);
      }
    }
  }
  
  void a(String paramString, UpsImageUploadResult paramUpsImageUploadResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url from UPS:");
      localStringBuilder.append(paramUpsImageUploadResult.url);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, localStringBuilder.toString());
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
    if (paramArrayOfLong != null)
    {
      int i = 0;
      long l;
      while (i < paramArrayOfLong.length)
      {
        l = paramArrayOfLong[i];
        this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        i += 1;
      }
      int j = 0;
      i = 0;
      for (int k = 0;; k = i1)
      {
        i1 = i;
        if (j >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
          break;
        }
        l = ((Long)this.jdField_b_of_type_JavaUtilArrayList.get(j)).longValue();
        if (l == this.jdField_a_of_type_Long)
        {
          this.x = j;
          i = 1;
          i1 = 1;
        }
        else
        {
          i1 = k;
          if (l == this.jdField_b_of_type_Long)
          {
            if (k == 0) {
              this.x = j;
            }
            i = 1;
            i1 = k;
          }
        }
        j += 1;
      }
    }
    int i1 = 0;
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
    if (QLog.isColorLevel())
    {
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("initStyleAndBg mWebStyleList = ");
      paramArrayOfLong.append(this.jdField_b_of_type_JavaUtilArrayList.toString());
      paramArrayOfLong.append(", mCurrentStyleId = ");
      paramArrayOfLong.append(this.jdField_a_of_type_Long);
      paramArrayOfLong.append(", mWebStyleId = ");
      paramArrayOfLong.append(this.jdField_b_of_type_Long);
      paramArrayOfLong.append(", mCurrentViewPos = ");
      paramArrayOfLong.append(this.x);
      paramArrayOfLong.append(", mStyleListNull = ");
      paramArrayOfLong.append(this.jdField_c_of_type_Boolean);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, paramArrayOfLong.toString());
    }
  }
  
  boolean a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
    ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localProfileCardTemplateInfo != null)
    {
      bool1 = bool2;
      if (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate != null)
      {
        bool1 = bool2;
        if (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.styleId == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @TargetApi(16)
  protected boolean a(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 0;
    if (j != 1)
    {
      switch (j)
      {
      default: 
        if (paramMessage.what == 2)
        {
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackground(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            return true;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          return true;
        }
        if (paramMessage.what == 3)
        {
          Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131695120, 0).show();
          return true;
        }
        if (paramMessage.what == 20)
        {
          c(paramMessage.arg1);
          return true;
        }
        if (paramMessage.what == 5)
        {
          Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131695131, 0).show();
          if ((this.jdField_f_of_type_Int != 1) && (this.jdField_f_of_type_Int != 2))
          {
            paramMessage = new AllInOne(this.app.getCurrentAccountUin(), 0);
            paramMessage = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this, paramMessage);
            paramMessage.setFlags(67108864);
            startActivity(paramMessage);
          }
          else if (this.B == 1)
          {
            BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.closeWeb"), "com.tencent.msg.permission.pushnotify");
          }
          else
          {
            paramMessage = new Intent();
            paramMessage.putExtra("uin", this.app.getCurrentAccountUin());
            paramMessage.putExtra("entryId", this.jdField_f_of_type_Int);
            setResult(-1, paramMessage);
          }
          o();
          finish();
          return true;
        }
        if (paramMessage.what == 21)
        {
          List localList = this.jdField_a_of_type_JavaUtilList;
          if (localList != null) {
            ((ProfileCardTemplateInfo)localList.get(paramMessage.arg1)).jdField_a_of_type_Int = -1;
          }
          return true;
        }
        if ((paramMessage.what != 24) && (paramMessage.what != 25)) {
          return false;
        }
        if (paramMessage.what == 25) {
          b();
        }
        Toast.makeText(getApplicationContext(), getResources().getString(2131695134), 1).show();
        return true;
      case 29: 
        c(paramMessage.arg1);
        return true;
      case 28: 
        c(paramMessage.arg1);
        return true;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getChildCount();
      while (i < j)
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getChildAt(i);
        if ((paramMessage.getTag() instanceof VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)) {
          ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)paramMessage.getTag()).jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        i += 1;
      }
      return true;
    }
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
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("initiate now mCurrentViewPos = ");
      paramMessage.append(this.x);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, paramMessage.toString());
    }
    return true;
  }
  
  public boolean a(ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    if (paramProfileCardTemplateInfo != null)
    {
      if (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate == null) {
        return false;
      }
      paramProfileCardTemplateInfo = a(paramProfileCardTemplateInfo);
      if (paramProfileCardTemplateInfo != null)
      {
        if (paramProfileCardTemplateInfo.size() == 0) {
          return false;
        }
        paramProfileCardTemplateInfo = paramProfileCardTemplateInfo.iterator();
        while (paramProfileCardTemplateInfo.hasNext()) {
          if (!ProfileCardUtil.a((String)paramProfileCardTemplateInfo.next())) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.addObserver(paramBusinessObserver);
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.C;
    if (i != -1)
    {
      a(i);
      this.C = -1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager != null)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (paramInt >= 0))
      {
        if (paramInt >= ((List)localObject).size()) {
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
        if (localObject != null)
        {
          if (((View)localObject).getTag() == null) {
            return;
          }
          localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag();
          if (localObject != null)
          {
            localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView;
            ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
            if (localProfileCardTemplateInfo != null)
            {
              if (((ProfileCardScrollImageView)localObject).getTag() == null) {
                return;
              }
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("startAnimation pos = ");
                localStringBuilder.append(paramInt);
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, localStringBuilder.toString());
              }
              paramInt = localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.animation;
              if (paramInt != 0)
              {
                if (paramInt != 1)
                {
                  if (paramInt != 2) {
                    return;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_FADE_IN_OUT");
                  }
                  localObject = ((ProfileCardScrollImageView)localObject).getDrawable();
                  if ((localObject instanceof TransitionDrawable))
                  {
                    localObject = (TransitionDrawable)localObject;
                    ((TransitionDrawable)localObject).setCrossFadeEnabled(true);
                    ((TransitionDrawable)localObject).startTransition(1500);
                    this.jdField_b_of_type_JavaLangRunnable = new VipProfileCardPreviewActivity.3(this, (TransitionDrawable)localObject);
                    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2000L);
                  }
                }
                else
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_SCROLL");
                  }
                  if (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.styleId != ProfileCardTemplate.PROFILE_CARD_STYLE_DIY)
                  {
                    ((ProfileCardScrollImageView)localObject).setScrollDuration(1500);
                    ((ProfileCardScrollImageView)localObject).a(this.A);
                  }
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "no animation to start !");
              }
            }
          }
        }
      }
    }
  }
  
  void b(String paramString)
  {
    VipProfileCardPreviewActivity.8 local8 = new VipProfileCardPreviewActivity.8(this, Long.parseLong(this.app.getCurrentAccountUin()), paramString, VipUploadUtils.a(this.app), "qqprofile", paramString);
    local8.b = VipUploadUtils.a(this.app);
    local8.i = VipUploadUtils.a(this.app, paramString);
    m();
    paramString = (VipImageUploadManager)this.app.getManager(QQManagerFactory.IMAGE_UPLOAD_MANAGER);
    paramString.a(this.app, null);
    local8.a();
    paramString.a(this.app, local8, null);
  }
  
  void b(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = new ProfileCardBackground();
      ((ProfileCardBackground)localObject).jdField_a_of_type_Int = 160;
      ProfileCardTemplate localProfileCardTemplate = ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem())).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate;
      if ((localProfileCardTemplate != null) && (!this.jdField_f_of_type_Boolean) && (!isFinishing()) && (a(localProfileCardTemplate, (ProfileCardBackground)localObject, true))) {
        a(a(), 0L, paramString2, ProfileCardUtil.a(paramString1));
      }
    }
  }
  
  void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      localObject = ((VipScaledViewPager)localObject).findViewById(paramInt);
      if (localObject != null)
      {
        if (((View)localObject).getTag() == null) {
          return;
        }
        a((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag(), (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
      }
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      if (this.jdField_a_of_type_JavaUtilList.get(paramInt) == null) {
        return;
      }
      localObject = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (((ProfileCardTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.styleId == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131695124);
        this.jdField_c_of_type_JavaLangString = "3";
        return;
      }
      a(((ProfileCardTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground, false);
      if (this.jdField_b_of_type_Int == 4)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131695126);
        this.jdField_c_of_type_JavaLangString = "2";
        return;
      }
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131695127);
        this.jdField_c_of_type_JavaLangString = "1";
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695125);
      this.jdField_c_of_type_JavaLangString = "0";
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @TargetApi(16)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_f_of_type_Boolean = false;
    setContentView(2131562033);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374298);
    if ((this.app != null) && (ThemeUtil.isInNightMode(this.app)))
    {
      paramBundle = this.jdField_a_of_type_AndroidViewView;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    else
    {
      paramBundle = this.jdField_a_of_type_AndroidViewView;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    if (this.app != null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(this.jdField_e_of_type_JavaLangString);
      paramBundle.append(this.app.getCurrentAccountUin());
      this.jdField_e_of_type_JavaLangString = paramBundle.toString();
    }
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131372285));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131372083));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager = ((VipScaledViewPager)findViewById(2131380851));
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity$StylePagerAdapter = new VipProfileCardPreviewActivity.StylePagerAdapter(this, this.jdField_a_of_type_AndroidContentContext);
    if (Build.MODEL.equals("HUAWEI C8812E")) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayerType(1, null);
    }
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float / 2.0F);
    float f1;
    if (this.j / this.k > (this.jdField_d_of_type_Float + this.jdField_e_of_type_Float) / 2.0F)
    {
      f1 = this.j / (this.jdField_c_of_type_Float * 1136.0F);
      this.n = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.o = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.p = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15) * f1);
      this.q = ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 45);
      this.r = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 3) * f1);
      this.t = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 7) * f1);
      this.s = Math.round(ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.5F) * f1);
      this.u = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 20) * f1);
      this.v = Math.round(f1 * ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15));
      this.jdField_b_of_type_Float = 0.824503F;
      this.w = 18;
    }
    else
    {
      f1 = this.j / (this.jdField_c_of_type_Float * 800.0F);
      this.n = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 11) * f1);
      this.o = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 10) * f1);
      this.p = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 11) * f1);
      this.q = ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 40);
      this.r = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 3) * f1);
      this.t = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 7) * f1);
      this.s = Math.round(ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, 16.5F) * f1);
      this.u = Math.round(ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 20) * f1);
      this.v = Math.round(f1 * ProfileCardUtil.c(this.jdField_a_of_type_AndroidContentContext, 15));
      this.w = 16;
      this.jdField_b_of_type_Float = 0.8192771F;
    }
    paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    paramBundle.height = this.q;
    int i = this.p;
    paramBundle.leftMargin = i;
    paramBundle.rightMargin = i;
    paramBundle.bottomMargin = this.o;
    this.jdField_a_of_type_AndroidWidgetButton.setTextSize(1, this.w);
    this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramBundle);
    paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.getLayoutParams();
    i = this.s;
    paramBundle.topMargin = i;
    paramBundle.bottomMargin = i;
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setLayoutParams(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding(this.t);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setRadius(this.r);
    i = getResources().getDimensionPixelSize(2131299168);
    int j = ProfileCardUtil.a(getResources());
    this.m = (this.j - this.u - this.o - this.q - this.r * 2 - this.s * 2 - i - j);
    this.y = this.m;
    this.z = Math.round(this.y / 1.78F);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setStrokeWidth(0.0F);
    ThreadManager.post(new VipProfileCardPreviewActivity.1(this), 8, null, true);
    i();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.app != null) {
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    }
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setOnPageChangeListener(new VipProfileCardPreviewActivity.2(this));
    if (this.app != null)
    {
      QQAppInterface localQQAppInterface = this.app;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground;
      if (paramBundle == null) {
        paramBundle = "";
      } else {
        paramBundle = Integer.toString(paramBundle.jdField_a_of_type_Int);
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "card_mall", "0X8004D59", 0, 0, paramBundle, "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_f_of_type_Boolean = true;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.app != null) {
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    }
  }
  
  public void i()
  {
    setLeftViewName(2131690706);
    setTitle(2131695123);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData start.");
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        return;
      }
      Object localObject2 = null;
      ArrayList localArrayList = a();
      if (this.jdField_b_of_type_Long == 0L)
      {
        localObject1 = new ProfileCardTemplate();
        ((ProfileCardTemplate)localObject1).styleId = 0L;
        ((ProfileCardTemplate)localObject1).imageWhiteMin = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
        ((ProfileCardTemplate)localObject1).imageBlackMin = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
        ((ProfileCardTemplate)localObject1).imageWhiteSmall = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
        ((ProfileCardTemplate)localObject1).imageBlackSmall = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
        ((ProfileCardTemplate)localObject1).auth = "0";
        ((ProfileCardTemplate)localObject1).name = getString(2131695121);
        localArrayList.add(localObject1);
      }
      int i1 = 0;
      Object localObject1 = localObject2;
      int i;
      if (localArrayList != null)
      {
        localObject1 = localObject2;
        if (localArrayList.size() > 0)
        {
          localObject2 = new ArrayList();
          if (this.jdField_c_of_type_Boolean)
          {
            i = 0;
            while (i < localArrayList.size())
            {
              localObject1 = (ProfileCardTemplate)localArrayList.get(i);
              if (this.jdField_a_of_type_Long == ((ProfileCardTemplate)localObject1).styleId) {
                this.x = i;
              }
              this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(((ProfileCardTemplate)localObject1).styleId));
              i += 1;
            }
          }
          int j;
          for (i = 0;; i = j + 1)
          {
            localObject1 = localObject2;
            if (i >= this.jdField_b_of_type_JavaUtilArrayList.size()) {
              break;
            }
            j = 0;
            int k = 0;
            while (j < localArrayList.size())
            {
              localObject1 = (ProfileCardTemplate)localArrayList.get(j);
              if (((Long)this.jdField_b_of_type_JavaUtilArrayList.get(i)).longValue() == ((ProfileCardTemplate)localObject1).styleId)
              {
                ProfileCardTemplateInfo localProfileCardTemplateInfo = new ProfileCardTemplateInfo();
                localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate = ((ProfileCardTemplate)localObject1);
                if (a(localProfileCardTemplateInfo)) {
                  localProfileCardTemplateInfo.jdField_a_of_type_Int = 2;
                } else {
                  localProfileCardTemplateInfo.jdField_a_of_type_Int = 0;
                }
                a(localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate);
                ((ArrayList)localObject2).add(localProfileCardTemplateInfo);
                k = 1;
              }
              j += 1;
            }
            j = i;
            if (k == 0)
            {
              this.jdField_b_of_type_JavaUtilArrayList.remove(i);
              j = this.x;
              if ((j > 0) && (i <= j)) {
                this.x = (j - 1);
              }
              j = i - 1;
            }
          }
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          if (!this.jdField_e_of_type_Boolean)
          {
            localObject2 = this.jdField_a_of_type_JavaUtilList;
            if (localObject2 != null) {
              ((List)localObject2).clear();
            }
          }
          localObject2 = this.jdField_a_of_type_JavaUtilList;
          if (localObject2 == null) {
            return;
          }
          ((List)localObject2).addAll((Collection)localObject1);
          this.jdField_d_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            i = i1;
          }
        }
        else
        {
          while (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("initTemplateListData, style : ");
              ((StringBuilder)localObject1).append(((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.styleId);
              ((StringBuilder)localObject1).append(", status : ");
              ((StringBuilder)localObject1).append(((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int);
              ((StringBuilder)localObject1).append(", position : ");
              ((StringBuilder)localObject1).append(i);
              QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, ((StringBuilder)localObject1).toString());
            }
            i += 1;
            continue;
            localObject1 = new ArrayList();
            i = 0;
            while (i < localArrayList.size())
            {
              localObject2 = new ProfileCardTemplateInfo();
              ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate = ((ProfileCardTemplate)localArrayList.get(i));
              if (a((ProfileCardTemplateInfo)localObject2)) {
                ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_Int = 2;
              } else {
                ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_Int = 0;
              }
              a(((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate);
              if (((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.styleId != ProfileCardTemplate.PROFILE_CARD_STYLE_SHOPPING) {
                ((ArrayList)localObject1).add(localObject2);
              }
              i += 1;
            }
            localObject2 = this.jdField_a_of_type_JavaUtilList;
            if (localObject2 == null) {
              return;
            }
            ((List)localObject2).clear();
            this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
            this.jdField_d_of_type_Boolean = true;
          }
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void k()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = this.x;
      if (i != -1)
      {
        localObject = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        a(this.x, (ProfileCardTemplateInfo)localObject);
      }
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        int j = this.x;
        if ((j == -1) || (i != j)) {
          a(i, (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public void l()
  {
    h();
    Object localObject = getIntent();
    int i;
    String str;
    if (localObject != null) {
      if (((Intent)localObject).hasExtra("preview"))
      {
        i = 0;
        this.B = 0;
        str = ((Intent)localObject).getStringExtra("preview");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initStyleAndBg preview = ");
          ((StringBuilder)localObject).append(str);
          QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    try
    {
      localObject = new JSONObject(str);
      if (((JSONObject)localObject).has("entryId")) {
        this.jdField_f_of_type_Int = ((JSONObject)localObject).getInt("entryId");
      }
      localObject = ((JSONObject)localObject).getJSONObject("item");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground = new ProfileCardBackground();
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("id");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("name");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("type");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("image_url");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("thumb_url");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("auth");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.d = ((JSONObject)localObject).optInt("limitefree_type");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.e = ((JSONObject)localObject).optInt("limitefree_btime");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_f_of_type_Int = ((JSONObject)localObject).optInt("limitefree_etime");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.l = ((JSONObject)localObject).optInt("color");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.g = ((JSONObject)localObject).optInt("tag");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.h = ((JSONObject)localObject).optInt("tag_btime");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.i = ((JSONObject)localObject).optInt("tag_etime");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.j = ((JSONObject)localObject).optInt("background_btime");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.k = ((JSONObject)localObject).optInt("background_etime");
      this.h = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.l;
      a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground);
      this.jdField_b_of_type_Long = ((JSONObject)localObject).optInt("style");
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int == 160)
      {
        this.jdField_b_of_type_Long = 1L;
        localObject = a();
      }
      else
      {
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("style_list");
        localObject = new long[localJSONArray.length()];
        while (i < localJSONArray.length())
        {
          localObject[i] = localJSONArray.getLong(i);
          i += 1;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    a((long[])localObject);
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString);
    return;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initStyleAndBg JSONException json = ");
      ((StringBuilder)localObject).append(str);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, ((StringBuilder)localObject).toString());
      return;
      if (((Intent)localObject).hasExtra("custom_card_background"))
      {
        this.B = 1;
        this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("custom_card_background");
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground = new ProfileCardBackground();
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int = 160;
        this.jdField_b_of_type_Long = 1L;
        a(a());
        a(this.jdField_d_of_type_JavaLangString, null);
      }
    }
  }
  
  void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131695135);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(25, 30000L);
      return;
    }
    catch (Exception localException) {}
  }
  
  void n()
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
  
  protected boolean onBackEvent()
  {
    ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X8004C28", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131372083) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager != null))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i = this.B;
        if (i == 0)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
          localObject = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.jdField_c_of_type_JavaLangString, Long.toString(((ProfileCardTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.styleId), "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
          if (a(((ProfileCardTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground, true)) {
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int != 160) {
              a(((ProfileCardTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqProfilecardTemplateProfileCardTemplate.styleId, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int);
            } else {
              a(a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.l);
            }
          }
        }
        else if (i == 1)
        {
          ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.jdField_c_of_type_JavaLangString, "-1", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
          if (a())
          {
            localObject = new Intent(this, VipProfileCardDiyActivity.class);
            ((Intent)localObject).putExtra("extra_from", 3);
            ((Intent)localObject).putExtra("extra_card_id", 0L);
            ((Intent)localObject).putExtra("extra_card_path", this.jdField_d_of_type_JavaLangString);
            startActivity((Intent)localObject);
          }
          else
          {
            ProfileCardUtil.a(this.jdField_d_of_type_JavaLangString, 100, 0.56338F);
            if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString)))
            {
              localObject = this.jdField_d_of_type_JavaLangString;
              b((String)localObject, (String)this.jdField_a_of_type_JavaUtilHashMap.get(localObject));
            }
            else
            {
              b(this.jdField_d_of_type_JavaLangString);
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity
 * JD-Core Version:    0.7.0.1
 */