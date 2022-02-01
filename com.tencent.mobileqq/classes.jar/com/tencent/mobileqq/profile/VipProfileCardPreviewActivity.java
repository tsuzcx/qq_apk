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
  public ImageView F;
  public View G;
  public Drawable H = null;
  public ProfileCardBackground I;
  Runnable J;
  public VipScaledViewPager K;
  public CirclePageIndicator L;
  public Button M;
  public VipProfileCardPreviewActivity.StylePagerAdapter N;
  public int O = -1;
  public int P = 0;
  public int Q = 0;
  public int R = 0;
  public int S = 0;
  public int T = 0;
  public int U = 0;
  public int V = 0;
  public int W = 0;
  public int X = 0;
  public float Y = 0.0F;
  public int Z = 0;
  public float aa = 1.0F;
  public int ab = -1;
  public boolean ac = false;
  public float ad = 1.666667F;
  public float ae = 1.775F;
  public long af = -1L;
  public ArrayList<Long> ag = new ArrayList();
  public List<ProfileCardTemplateInfo> ah = Collections.synchronizedList(new ArrayList());
  public List<String> ai = Collections.synchronizedList(new ArrayList());
  public int aj;
  public int ak;
  public int al;
  public String am = "0";
  int an = 0;
  String ao = null;
  public boolean ap = false;
  public boolean aq = false;
  public int ar = -1;
  public String as = "is_binding_shop";
  HashMap<String, String> at = new HashMap();
  volatile boolean au = false;
  private volatile long av = -1L;
  
  int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          j = paramOptions.outHeight;
          int k = paramOptions.outWidth;
          for (;;)
          {
            m = i;
            if (j <= paramInt2) {
              break;
            }
            m = i;
            if (k <= paramInt1) {
              break;
            }
            int n = Math.round(j / paramInt2);
            m = Math.round(k / paramInt1);
            if (n <= m) {
              n = m;
            }
            m = i;
            if (n < 2) {
              break;
            }
            k /= 2;
            j /= 2;
            i *= 2;
          }
        }
      }
    }
    return m;
  }
  
  /* Error */
  android.graphics.Bitmap a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 182	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
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
    //   18: if_icmpgt +608 -> 626
    //   21: new 159	android/graphics/BitmapFactory$Options
    //   24: dup
    //   25: invokespecial 183	android/graphics/BitmapFactory$Options:<init>	()V
    //   28: astore 7
    //   30: aload 7
    //   32: aload 4
    //   34: putfield 186	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   37: aload 7
    //   39: aload_0
    //   40: getfield 189	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:w	I
    //   43: putfield 192	android/graphics/BitmapFactory$Options:inDensity	I
    //   46: aload 7
    //   48: aload_0
    //   49: getfield 189	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:w	I
    //   52: putfield 195	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   55: aload 7
    //   57: aload_0
    //   58: getfield 189	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:w	I
    //   61: putfield 198	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   64: new 200	java/io/BufferedInputStream
    //   67: dup
    //   68: new 202	java/io/FileInputStream
    //   71: dup
    //   72: new 204	java/io/File
    //   75: dup
    //   76: aload_1
    //   77: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 213	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore 4
    //   88: iload_2
    //   89: ifeq +37 -> 126
    //   92: aload 7
    //   94: iconst_1
    //   95: putfield 216	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   98: aload 4
    //   100: aconst_null
    //   101: aload 7
    //   103: invokestatic 222	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   106: pop
    //   107: aload 7
    //   109: aload_0
    //   110: aload 7
    //   112: aload_0
    //   113: getfield 224	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:ak	I
    //   116: aload_0
    //   117: getfield 226	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:aj	I
    //   120: invokevirtual 228	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   123: putfield 231	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   126: aload 7
    //   128: iconst_0
    //   129: putfield 216	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   132: new 200	java/io/BufferedInputStream
    //   135: dup
    //   136: new 202	java/io/FileInputStream
    //   139: dup
    //   140: new 204	java/io/File
    //   143: dup
    //   144: aload_1
    //   145: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   151: invokespecial 213	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   154: astore 6
    //   156: aload 4
    //   158: astore 8
    //   160: aload 6
    //   162: astore 5
    //   164: aload 6
    //   166: aconst_null
    //   167: aload 7
    //   169: invokestatic 222	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   172: astore 7
    //   174: aload 7
    //   176: astore_1
    //   177: aload 4
    //   179: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   182: aload 7
    //   184: astore_1
    //   185: aload 6
    //   187: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   190: aload 7
    //   192: areturn
    //   193: astore 4
    //   195: ldc 236
    //   197: iconst_1
    //   198: ldc 238
    //   200: aload 4
    //   202: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   225: goto +363 -> 588
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
    //   255: goto +211 -> 466
    //   258: astore_1
    //   259: aconst_null
    //   260: astore 4
    //   262: goto +326 -> 588
    //   265: astore 6
    //   267: aconst_null
    //   268: astore 7
    //   270: aload 7
    //   272: astore 4
    //   274: aload 7
    //   276: astore 8
    //   278: aload 4
    //   280: astore 5
    //   282: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +138 -> 423
    //   288: aload 7
    //   290: astore 8
    //   292: aload 4
    //   294: astore 5
    //   296: new 250	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   303: astore 10
    //   305: aload 7
    //   307: astore 8
    //   309: aload 4
    //   311: astore 5
    //   313: aload 10
    //   315: ldc 253
    //   317: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 7
    //   323: astore 8
    //   325: aload 4
    //   327: astore 5
    //   329: aload 10
    //   331: aload_1
    //   332: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 7
    //   338: astore 8
    //   340: aload 4
    //   342: astore 5
    //   344: aload 10
    //   346: ldc_w 259
    //   349: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 7
    //   355: astore 8
    //   357: aload 4
    //   359: astore 5
    //   361: aload 10
    //   363: aload 6
    //   365: invokevirtual 263	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   368: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 7
    //   374: astore 8
    //   376: aload 4
    //   378: astore 5
    //   380: aload 10
    //   382: ldc_w 265
    //   385: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 7
    //   391: astore 8
    //   393: aload 4
    //   395: astore 5
    //   397: aload 10
    //   399: iload_3
    //   400: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload 7
    //   406: astore 8
    //   408: aload 4
    //   410: astore 5
    //   412: ldc 236
    //   414: iconst_2
    //   415: aload 10
    //   417: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: aload 7
    //   425: ifnull +11 -> 436
    //   428: aload 9
    //   430: astore_1
    //   431: aload 7
    //   433: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   436: aload 4
    //   438: ifnull +188 -> 626
    //   441: aload 9
    //   443: astore_1
    //   444: aload 4
    //   446: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   449: aconst_null
    //   450: areturn
    //   451: astore_1
    //   452: aload 5
    //   454: astore 4
    //   456: goto +124 -> 580
    //   459: aconst_null
    //   460: astore 4
    //   462: aload 6
    //   464: astore 5
    //   466: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq +54 -> 523
    //   472: new 250	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   479: astore 6
    //   481: aload 6
    //   483: ldc 253
    //   485: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 6
    //   491: aload_1
    //   492: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 6
    //   498: ldc_w 265
    //   501: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 6
    //   507: iload_3
    //   508: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: ldc 236
    //   514: iconst_2
    //   515: aload 6
    //   517: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: getstatic 278	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   526: astore 6
    //   528: aload 5
    //   530: ifnull +11 -> 541
    //   533: aload 5
    //   535: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   538: goto +3 -> 541
    //   541: aload 4
    //   543: ifnull +21 -> 564
    //   546: aload 4
    //   548: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   551: goto +13 -> 564
    //   554: ldc 236
    //   556: iconst_1
    //   557: ldc 238
    //   559: aload 4
    //   561: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: iload_3
    //   565: iconst_1
    //   566: iadd
    //   567: istore_3
    //   568: aload 6
    //   570: astore 4
    //   572: goto -565 -> 7
    //   575: astore_1
    //   576: aload 5
    //   578: astore 8
    //   580: aload 4
    //   582: astore 5
    //   584: aload 8
    //   586: astore 4
    //   588: aload 4
    //   590: ifnull +11 -> 601
    //   593: aload 4
    //   595: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   598: goto +3 -> 601
    //   601: aload 5
    //   603: ifnull +21 -> 624
    //   606: aload 5
    //   608: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   611: goto +13 -> 624
    //   614: ldc 236
    //   616: iconst_1
    //   617: ldc 238
    //   619: aload 4
    //   621: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   624: aload_1
    //   625: athrow
    //   626: aconst_null
    //   627: areturn
    //   628: astore 4
    //   630: goto -171 -> 459
    //   633: astore 5
    //   635: goto -391 -> 244
    //   638: astore 5
    //   640: goto -393 -> 247
    //   643: astore 4
    //   645: goto -91 -> 554
    //   648: astore 4
    //   650: goto -36 -> 614
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	VipProfileCardPreviewActivity
    //   0	653	1	paramString	String
    //   0	653	2	paramBoolean	boolean
    //   6	562	3	i	int
    //   3	175	4	localObject1	Object
    //   193	17	4	localException1	Exception
    //   215	405	4	localObject2	Object
    //   628	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   643	1	4	localException2	Exception
    //   648	1	4	localException3	Exception
    //   11	152	5	localObject3	Object
    //   207	11	5	localException4	Exception
    //   231	376	5	localObject4	Object
    //   633	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   638	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   8	212	6	localObject5	Object
    //   228	1	6	localException5	Exception
    //   245	7	6	localObject6	Object
    //   265	198	6	localException6	Exception
    //   479	90	6	localObject7	Object
    //   28	404	7	localObject8	Object
    //   158	427	8	localObject9	Object
    //   14	428	9	localObject10	Object
    //   303	113	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   177	182	193	java/lang/Exception
    //   185	190	193	java/lang/Exception
    //   431	436	193	java/lang/Exception
    //   444	449	193	java/lang/Exception
    //   164	174	207	java/lang/Exception
    //   92	126	224	finally
    //   126	156	224	finally
    //   92	126	228	java/lang/Exception
    //   126	156	228	java/lang/Exception
    //   21	88	258	finally
    //   21	88	265	java/lang/Exception
    //   164	174	451	finally
    //   282	288	451	finally
    //   296	305	451	finally
    //   313	321	451	finally
    //   329	336	451	finally
    //   344	353	451	finally
    //   361	372	451	finally
    //   380	389	451	finally
    //   397	404	451	finally
    //   412	423	451	finally
    //   466	523	575	finally
    //   523	528	575	finally
    //   21	88	628	java/lang/OutOfMemoryError
    //   92	126	633	java/lang/OutOfMemoryError
    //   126	156	633	java/lang/OutOfMemoryError
    //   164	174	638	java/lang/OutOfMemoryError
    //   533	538	643	java/lang/Exception
    //   546	551	643	java/lang/Exception
    //   593	598	648	java/lang/Exception
    //   606	611	648	java/lang/Exception
  }
  
  protected void a()
  {
    VipScaledViewPager localVipScaledViewPager = this.K;
    if (localVipScaledViewPager == null) {
      return;
    }
    d(localVipScaledViewPager.getCurrentItem());
  }
  
  void a(int paramInt)
  {
    if (this.K != null)
    {
      Object localObject = this.ah;
      if ((localObject != null) && (paramInt >= 0))
      {
        if (paramInt >= ((List)localObject).size()) {
          return;
        }
        localObject = this.K.findViewById(paramInt);
        if (localObject != null)
        {
          if (((View)localObject).getTag() == null) {
            return;
          }
          localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag();
          if (localObject != null)
          {
            localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localObject).a;
            ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.ah.get(paramInt);
            if (localProfileCardTemplateInfo != null)
            {
              paramInt = localProfileCardTemplateInfo.a.animation;
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
                  if (this.J != null) {
                    this.y.removeCallbacks(this.J);
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
      localStringBuilder.append(paramProfileCardTemplateInfo.b);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, localStringBuilder.toString());
    }
    if ((paramProfileCardTemplateInfo.b != 2) && (paramProfileCardTemplateInfo.b != 1))
    {
      paramProfileCardTemplateInfo.b = 1;
      paramProfileCardTemplateInfo = b(paramProfileCardTemplateInfo);
      this.ai.addAll(paramProfileCardTemplateInfo);
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
    //   2: invokevirtual 406	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Lcom/tencent/mobileqq/profile/ProfileCardTemplateInfo;)Z
    //   5: ifeq +870 -> 875
    //   8: aload_2
    //   9: iconst_2
    //   10: putfield 362	com/tencent/mobileqq/profile/ProfileCardTemplateInfo:b	I
    //   13: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +48 -> 64
    //   19: new 250	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   26: astore 8
    //   28: aload 8
    //   30: ldc_w 408
    //   33: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 8
    //   39: iload_3
    //   40: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 8
    //   46: ldc_w 410
    //   49: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 236
    //   55: iconst_2
    //   56: aload 8
    //   58: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: aload_2
    //   66: invokevirtual 365	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:b	(Lcom/tencent/mobileqq/profile/ProfileCardTemplateInfo;)Ljava/util/List;
    //   69: astore 8
    //   71: aload 8
    //   73: ifnull +801 -> 874
    //   76: aload 8
    //   78: invokeinterface 294 1 0
    //   83: ifne +4 -> 87
    //   86: return
    //   87: aload_2
    //   88: getfield 318	com/tencent/mobileqq/profile/ProfileCardTemplateInfo:a	Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;
    //   91: getfield 413	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:styleId	J
    //   94: getstatic 416	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:PROFILE_CARD_STYLE_DIY	J
    //   97: lcmp
    //   98: ifne +117 -> 215
    //   101: aload_1
    //   102: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:b	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   105: iconst_0
    //   106: invokevirtual 424	com/tencent/mobileqq/hiboom/HiBoomTextView:setVisibility	(I)V
    //   109: sipush 2000
    //   112: istore 6
    //   114: getstatic 429	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:c	Ljava/lang/String;
    //   117: astore 9
    //   119: getstatic 432	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:a	Landroid/util/SparseArray;
    //   122: ifnull +24 -> 146
    //   125: getstatic 432	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:a	Landroid/util/SparseArray;
    //   128: invokevirtual 435	android/util/SparseArray:size	()I
    //   131: ifle +15 -> 146
    //   134: getstatic 432	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:a	Landroid/util/SparseArray;
    //   137: iconst_0
    //   138: invokevirtual 439	android/util/SparseArray:keyAt	(I)I
    //   141: istore 6
    //   143: goto +10 -> 153
    //   146: aload_0
    //   147: getfield 443	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   150: invokestatic 446	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:a	(Lmqq/app/AppRuntime;)V
    //   153: aload_1
    //   154: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:b	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   157: iload 6
    //   159: iconst_1
    //   160: getstatic 451	com/tencent/mobileqq/hiboom/HiBoomConstants:d	Lcom/tencent/mobileqq/hiboom/HiBoomFont$HiBoomFontDownloader;
    //   163: invokevirtual 455	com/tencent/mobileqq/hiboom/HiBoomTextView:setHiBoom	(IILcom/tencent/mobileqq/hiboom/HiBoomFont$HiBoomFontDownloader;)V
    //   166: aload_1
    //   167: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:b	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   170: aload 9
    //   172: invokevirtual 459	com/tencent/mobileqq/hiboom/HiBoomTextView:setText	(Ljava/lang/CharSequence;)V
    //   175: aload_0
    //   176: getfield 224	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:ak	I
    //   179: i2f
    //   180: aload_0
    //   181: invokevirtual 463	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:getResources	()Landroid/content/res/Resources;
    //   184: invokevirtual 469	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   187: getfield 474	android/util/DisplayMetrics:widthPixels	I
    //   190: i2f
    //   191: fdiv
    //   192: fstore 4
    //   194: aload_1
    //   195: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:b	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   198: fload 4
    //   200: invokevirtual 478	com/tencent/mobileqq/hiboom/HiBoomTextView:setScaleX	(F)V
    //   203: aload_1
    //   204: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:b	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   207: fload 4
    //   209: invokevirtual 481	com/tencent/mobileqq/hiboom/HiBoomTextView:setScaleY	(F)V
    //   212: goto +12 -> 224
    //   215: aload_1
    //   216: getfield 419	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:b	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   219: bipush 8
    //   221: invokevirtual 424	com/tencent/mobileqq/hiboom/HiBoomTextView:setVisibility	(I)V
    //   224: aload_2
    //   225: getfield 318	com/tencent/mobileqq/profile/ProfileCardTemplateInfo:a	Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;
    //   228: getfield 323	com/tencent/mobileqq/profilecard/template/ProfileCardTemplate:animation	I
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
    //   257: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   260: iconst_0
    //   261: invokevirtual 485	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   264: aload 8
    //   266: invokeinterface 294 1 0
    //   271: iconst_1
    //   272: if_icmple +602 -> 874
    //   275: aload 8
    //   277: iconst_0
    //   278: invokeinterface 313 2 0
    //   283: checkcast 487	java/lang/CharSequence
    //   286: invokestatic 493	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifne +149 -> 438
    //   292: aload 8
    //   294: iconst_1
    //   295: invokeinterface 313 2 0
    //   300: checkcast 487	java/lang/CharSequence
    //   303: invokestatic 493	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   306: ifeq +4 -> 310
    //   309: return
    //   310: new 250	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   317: astore_2
    //   318: aload_2
    //   319: aload 8
    //   321: iconst_0
    //   322: invokeinterface 313 2 0
    //   327: checkcast 398	java/lang/String
    //   330: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: aload 8
    //   337: iconst_1
    //   338: invokeinterface 313 2 0
    //   343: checkcast 398	java/lang/String
    //   346: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_2
    //   351: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: astore_2
    //   355: getstatic 498	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   358: aload_2
    //   359: invokevirtual 503	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   362: instanceof 505
    //   365: ifeq +53 -> 418
    //   368: getstatic 498	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   371: aload_2
    //   372: invokevirtual 503	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   375: checkcast 505	android/util/Pair
    //   378: getfield 509	android/util/Pair:first	Ljava/lang/Object;
    //   381: checkcast 511	android/graphics/drawable/Drawable
    //   384: astore_2
    //   385: aload_1
    //   386: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   389: aload_2
    //   390: invokevirtual 515	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   393: aload_1
    //   394: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   397: iload_3
    //   398: invokestatic 521	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   401: invokevirtual 525	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   404: aload_0
    //   405: getfield 100	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:ab	I
    //   408: iload_3
    //   409: if_icmpne +465 -> 874
    //   412: aload_0
    //   413: iload_3
    //   414: invokevirtual 527	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:b	(I)V
    //   417: return
    //   418: new 529	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$6
    //   421: dup
    //   422: aload_0
    //   423: aload 8
    //   425: aload_2
    //   426: iload_3
    //   427: invokespecial 532	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$6:<init>	(Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;Ljava/util/List;Ljava/lang/String;I)V
    //   430: bipush 8
    //   432: aconst_null
    //   433: iconst_1
    //   434: invokestatic 384	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   437: return
    //   438: return
    //   439: aload_1
    //   440: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   443: iconst_1
    //   444: invokevirtual 485	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   447: aload 8
    //   449: iconst_0
    //   450: invokeinterface 313 2 0
    //   455: checkcast 398	java/lang/String
    //   458: invokestatic 537	com/tencent/mobileqq/util/ProfileCardUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   461: astore 10
    //   463: new 200	java/io/BufferedInputStream
    //   466: dup
    //   467: new 202	java/io/FileInputStream
    //   470: dup
    //   471: new 204	java/io/File
    //   474: dup
    //   475: aload 10
    //   477: invokespecial 207	java/io/File:<init>	(Ljava/lang/String;)V
    //   480: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   483: invokespecial 213	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   486: astore 8
    //   488: new 159	android/graphics/BitmapFactory$Options
    //   491: dup
    //   492: invokespecial 183	android/graphics/BitmapFactory$Options:<init>	()V
    //   495: astore_2
    //   496: aload_2
    //   497: iconst_1
    //   498: putfield 216	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   501: aload_2
    //   502: aload_0
    //   503: getfield 189	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:w	I
    //   506: putfield 192	android/graphics/BitmapFactory$Options:inDensity	I
    //   509: aload_2
    //   510: aload_0
    //   511: getfield 189	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:w	I
    //   514: putfield 195	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   517: aload_2
    //   518: aload_0
    //   519: getfield 189	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:w	I
    //   522: putfield 198	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   525: aload 8
    //   527: aconst_null
    //   528: aload_2
    //   529: invokestatic 222	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   532: pop
    //   533: aload_2
    //   534: getfield 165	android/graphics/BitmapFactory$Options:outWidth	I
    //   537: istore 6
    //   539: aload_2
    //   540: getfield 162	android/graphics/BitmapFactory$Options:outHeight	I
    //   543: aload_0
    //   544: getfield 224	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:ak	I
    //   547: imul
    //   548: iload 6
    //   550: idiv
    //   551: istore 7
    //   553: aload_0
    //   554: aload_0
    //   555: getfield 226	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:aj	I
    //   558: iload 7
    //   560: isub
    //   561: putfield 539	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:al	I
    //   564: aload_1
    //   565: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   568: getstatic 545	android/widget/ImageView$ScaleType:MATRIX	Landroid/widget/ImageView$ScaleType;
    //   571: invokevirtual 549	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   574: new 551	android/graphics/Matrix
    //   577: dup
    //   578: invokespecial 552	android/graphics/Matrix:<init>	()V
    //   581: astore_2
    //   582: aload_0
    //   583: getfield 224	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:ak	I
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
    //   601: getfield 224	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:ak	I
    //   604: i2f
    //   605: fload 5
    //   607: fdiv
    //   608: invokevirtual 556	android/graphics/Matrix:postScale	(FF)Z
    //   611: pop
    //   612: aload_1
    //   613: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   616: aload_2
    //   617: invokevirtual 560	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageMatrix	(Landroid/graphics/Matrix;)V
    //   620: getstatic 498	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   623: aload 10
    //   625: invokevirtual 503	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   628: checkcast 511	android/graphics/drawable/Drawable
    //   631: astore_2
    //   632: aload_2
    //   633: ifnull +38 -> 671
    //   636: aload_1
    //   637: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   640: aload_2
    //   641: invokevirtual 515	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   644: aload_1
    //   645: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   648: iload_3
    //   649: invokestatic 521	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: invokevirtual 525	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   655: aload_0
    //   656: getfield 100	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:ab	I
    //   659: iload_3
    //   660: if_icmpne +29 -> 689
    //   663: aload_0
    //   664: iload_3
    //   665: invokevirtual 527	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:b	(I)V
    //   668: goto +21 -> 689
    //   671: new 562	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$5
    //   674: dup
    //   675: aload_0
    //   676: aload 10
    //   678: iload_3
    //   679: invokespecial 565	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$5:<init>	(Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;Ljava/lang/String;I)V
    //   682: bipush 8
    //   684: aconst_null
    //   685: iconst_1
    //   686: invokestatic 384	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   689: aload 8
    //   691: invokevirtual 234	java/io/BufferedInputStream:close	()V
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
    //   723: ldc 236
    //   725: iconst_1
    //   726: ldc_w 567
    //   729: aload 8
    //   731: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   734: aload_1
    //   735: ifnull +139 -> 874
    //   738: aload_1
    //   739: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   742: return
    //   743: astore_1
    //   744: ldc 236
    //   746: iconst_1
    //   747: ldc_w 567
    //   750: aload_1
    //   751: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   754: return
    //   755: aload 8
    //   757: ifnull +22 -> 779
    //   760: aload 8
    //   762: invokevirtual 234	java/io/BufferedInputStream:close	()V
    //   765: goto +14 -> 779
    //   768: astore_2
    //   769: ldc 236
    //   771: iconst_1
    //   772: ldc_w 567
    //   775: aload_2
    //   776: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   779: aload_1
    //   780: athrow
    //   781: aload_1
    //   782: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   785: iconst_0
    //   786: invokevirtual 485	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   789: new 250	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   796: astore_2
    //   797: aload_2
    //   798: ldc_w 569
    //   801: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload_2
    //   806: aload 8
    //   808: iconst_0
    //   809: invokeinterface 313 2 0
    //   814: checkcast 398	java/lang/String
    //   817: invokestatic 537	com/tencent/mobileqq/util/ProfileCardUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   820: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload_2
    //   825: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: aload_0
    //   829: getfield 224	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:ak	I
    //   832: aload_0
    //   833: getfield 226	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:aj	I
    //   836: aload_1
    //   837: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   840: invokevirtual 343	com/tencent/mobileqq/widget/ProfileCardScrollImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   843: aload_1
    //   844: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   847: invokevirtual 343	com/tencent/mobileqq/widget/ProfileCardScrollImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   850: iconst_0
    //   851: invokestatic 574	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)Lcom/tencent/image/URLDrawable;
    //   854: astore_2
    //   855: aload_1
    //   856: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   859: aload_2
    //   860: invokevirtual 515	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   863: aload_1
    //   864: getfield 309	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:a	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   867: iload_3
    //   868: invokestatic 521	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   871: invokevirtual 525	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   874: return
    //   875: invokestatic 248	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq +43 -> 921
    //   881: new 250	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   888: astore_1
    //   889: aload_1
    //   890: ldc_w 408
    //   893: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload_1
    //   898: iload_3
    //   899: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: aload_1
    //   904: ldc_w 576
    //   907: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: ldc 236
    //   913: iconst_2
    //   914: aload_1
    //   915: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   918: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
      paramString = ProfileCardUtil.c(paramString);
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
          this.H = ((Drawable.ConstantState)((Pair)localObject1).first).newDrawable();
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
    this.at.put(paramString, paramUpsImageUploadResult.url);
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
        this.ag.add(Long.valueOf(l));
        i += 1;
      }
      int j = 0;
      i = 0;
      for (int k = 0;; k = m)
      {
        m = i;
        if (j >= this.ag.size()) {
          break;
        }
        l = ((Long)this.ag.get(j)).longValue();
        if (l == this.n)
        {
          this.ab = j;
          i = 1;
          m = 1;
        }
        else
        {
          m = k;
          if (l == this.af)
          {
            if (k == 0) {
              this.ab = j;
            }
            i = 1;
            m = k;
          }
        }
        j += 1;
      }
    }
    int m = 0;
    if ((m == 0) && (this.ag.size() > 0))
    {
      this.ag.add(Long.valueOf(this.af));
      if (this.ab == -1) {
        this.ab = (this.ag.size() - 1);
      }
    }
    if (this.ab == -1)
    {
      this.ab = 0;
      this.ac = true;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("initStyleAndBg mWebStyleList = ");
      paramArrayOfLong.append(this.ag.toString());
      paramArrayOfLong.append(", mCurrentStyleId = ");
      paramArrayOfLong.append(this.n);
      paramArrayOfLong.append(", mWebStyleId = ");
      paramArrayOfLong.append(this.af);
      paramArrayOfLong.append(", mCurrentViewPos = ");
      paramArrayOfLong.append(this.ab);
      paramArrayOfLong.append(", mStyleListNull = ");
      paramArrayOfLong.append(this.ac);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, paramArrayOfLong.toString());
    }
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
            this.F.setBackground(this.H);
            return true;
          }
          this.F.setBackgroundDrawable(this.H);
          return true;
        }
        if (paramMessage.what == 3)
        {
          Toast.makeText(this.b.getApplicationContext(), 2131892848, 0).show();
          return true;
        }
        if (paramMessage.what == 20)
        {
          c(paramMessage.arg1);
          return true;
        }
        if (paramMessage.what == 5)
        {
          Toast.makeText(this.b.getApplicationContext(), 2131892859, 0).show();
          if ((this.o != 1) && (this.o != 2))
          {
            paramMessage = new AllInOne(this.app.getCurrentAccountUin(), 0);
            paramMessage = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this, paramMessage);
            paramMessage.setFlags(67108864);
            startActivity(paramMessage);
          }
          else if (this.an == 1)
          {
            BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.closeWeb"), "com.tencent.msg.permission.pushnotify");
          }
          else
          {
            paramMessage = new Intent();
            paramMessage.putExtra("uin", this.app.getCurrentAccountUin());
            paramMessage.putExtra("entryId", this.o);
            setResult(-1, paramMessage);
          }
          s();
          finish();
          return true;
        }
        if (paramMessage.what == 21)
        {
          List localList = this.ah;
          if (localList != null) {
            ((ProfileCardTemplateInfo)localList.get(paramMessage.arg1)).b = -1;
          }
          return true;
        }
        if ((paramMessage.what != 24) && (paramMessage.what != 25)) {
          return false;
        }
        if (paramMessage.what == 25) {
          b();
        }
        Toast.makeText(getApplicationContext(), getResources().getString(2131892862), 1).show();
        return true;
      case 29: 
        c(paramMessage.arg1);
        return true;
      case 28: 
        c(paramMessage.arg1);
        return true;
      }
      j = this.K.getChildCount();
      while (i < j)
      {
        paramMessage = this.K.getChildAt(i);
        if ((paramMessage.getTag() instanceof VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)) {
          ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)paramMessage.getTag()).a.setBackgroundDrawable(this.H);
        }
        i += 1;
      }
      return true;
    }
    paramMessage = (RelativeLayout.LayoutParams)this.K.getLayoutParams();
    paramMessage.height = this.O;
    paramMessage.topMargin = this.W;
    this.K.setLayoutParams(paramMessage);
    this.K.setScale(this.Y);
    this.K.setGap(this.X);
    this.K.setAdapter(this.N);
    this.L.setViewPager(this.K);
    this.L.setVisibility(0);
    m();
    this.K.setCurrentItem(this.ab);
    d(this.ab);
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("initiate now mCurrentViewPos = ");
      paramMessage.append(this.ab);
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, paramMessage.toString());
    }
    return true;
  }
  
  public boolean a(ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    if (paramProfileCardTemplateInfo != null)
    {
      if (paramProfileCardTemplateInfo.a == null) {
        return false;
      }
      paramProfileCardTemplateInfo = b(paramProfileCardTemplateInfo);
      if (paramProfileCardTemplateInfo != null)
      {
        if (paramProfileCardTemplateInfo.size() == 0) {
          return false;
        }
        paramProfileCardTemplateInfo = paramProfileCardTemplateInfo.iterator();
        while (paramProfileCardTemplateInfo.hasNext()) {
          if (!ProfileCardUtil.b((String)paramProfileCardTemplateInfo.next())) {
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
  
  public List<String> b(ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramProfileCardTemplateInfo != null)
    {
      if (paramProfileCardTemplateInfo.a == null) {
        return localArrayList;
      }
      if (this.r == 1) {
        localArrayList.add(paramProfileCardTemplateInfo.a.imageWhiteSmall);
      } else {
        localArrayList.add(paramProfileCardTemplateInfo.a.imageBlackSmall);
      }
      if (paramProfileCardTemplateInfo.a.animation == 2)
      {
        if (this.r == 1)
        {
          localArrayList.add(paramProfileCardTemplateInfo.a.frameWhiteSmall);
          return localArrayList;
        }
        localArrayList.add(paramProfileCardTemplateInfo.a.frameBlackSmall);
      }
    }
    return localArrayList;
  }
  
  public void b(int paramInt)
  {
    int i = this.ar;
    if (i != -1)
    {
      a(i);
      this.ar = -1;
    }
    if (this.K != null)
    {
      Object localObject = this.ah;
      if ((localObject != null) && (paramInt >= 0))
      {
        if (paramInt >= ((List)localObject).size()) {
          return;
        }
        localObject = this.K.findViewById(paramInt);
        if (localObject != null)
        {
          if (((View)localObject).getTag() == null) {
            return;
          }
          localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag();
          if (localObject != null)
          {
            localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localObject).a;
            ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.ah.get(paramInt);
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
              paramInt = localProfileCardTemplateInfo.a.animation;
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
                    this.J = new VipProfileCardPreviewActivity.3(this, (TransitionDrawable)localObject);
                    this.y.postDelayed(this.J, 2000L);
                  }
                }
                else
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "start ANIMATION_SCROLL");
                  }
                  if (localProfileCardTemplateInfo.a.styleId != ProfileCardTemplate.PROFILE_CARD_STYLE_DIY)
                  {
                    ((ProfileCardScrollImageView)localObject).setScrollDuration(1500);
                    ((ProfileCardScrollImageView)localObject).a(this.al);
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
    local8.q = VipUploadUtils.a(this.app);
    local8.B = VipUploadUtils.a(this.app, paramString);
    p();
    paramString = (VipImageUploadManager)this.app.getManager(QQManagerFactory.IMAGE_UPLOAD_MANAGER);
    paramString.a(this.app, null);
    local8.h();
    paramString.a(this.app, local8, null);
  }
  
  void b(String paramString1, String paramString2)
  {
    Object localObject = this.ah;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = new ProfileCardBackground();
      ((ProfileCardBackground)localObject).a = 160;
      ProfileCardTemplate localProfileCardTemplate = ((ProfileCardTemplateInfo)this.ah.get(this.K.getCurrentItem())).a;
      if ((localProfileCardTemplate != null) && (!this.au) && (!isFinishing()) && (a(localProfileCardTemplate, (ProfileCardBackground)localObject, true))) {
        a(r(), 0L, paramString2, ProfileCardUtil.e(paramString1));
      }
    }
  }
  
  void c(int paramInt)
  {
    Object localObject = this.K;
    if (localObject != null)
    {
      if (this.ah == null) {
        return;
      }
      localObject = ((VipScaledViewPager)localObject).findViewById(paramInt);
      if (localObject != null)
      {
        if (((View)localObject).getTag() == null) {
          return;
        }
        a((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag(), (ProfileCardTemplateInfo)this.ah.get(paramInt), paramInt);
      }
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject = this.ah;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      if (this.ah.get(paramInt) == null) {
        return;
      }
      localObject = (ProfileCardTemplateInfo)this.ah.get(paramInt);
      if (((ProfileCardTemplateInfo)localObject).a.styleId == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY)
      {
        this.M.setText(2131892852);
        this.am = "3";
        return;
      }
      a(((ProfileCardTemplateInfo)localObject).a, this.I, false);
      if (this.d == 4)
      {
        this.M.setText(2131892854);
        this.am = "2";
        return;
      }
      if (this.d == 2)
      {
        this.M.setText(2131892855);
        this.am = "1";
        return;
      }
      this.M.setText(2131892853);
      this.am = "0";
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
    this.au = false;
    setContentView(2131628459);
    getWindow().setBackgroundDrawable(null);
    this.b = this;
    this.G = findViewById(2131442461);
    if ((this.app != null) && (ThemeUtil.isInNightMode(this.app)))
    {
      paramBundle = this.G;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    else
    {
      paramBundle = this.G;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    if (this.app != null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(this.as);
      paramBundle.append(this.app.getCurrentAccountUin());
      this.as = paramBundle.toString();
    }
    this.L = ((CirclePageIndicator)findViewById(2131439795));
    this.M = ((Button)findViewById(2131439547));
    this.K = ((VipScaledViewPager)findViewById(2131449829));
    this.N = new VipProfileCardPreviewActivity.StylePagerAdapter(this, this.b);
    if (Build.MODEL.equals("HUAWEI C8812E")) {
      this.K.setLayerType(1, null);
    }
    this.aa = (this.v / 2.0F);
    float f;
    if (this.t / this.u > (this.ad + this.ae) / 2.0F)
    {
      f = this.t / (this.aa * 1136.0F);
      this.P = Math.round(ProfileCardUtil.c(this.b, 15) * f);
      this.Q = Math.round(ProfileCardUtil.c(this.b, 15) * f);
      this.R = Math.round(ProfileCardUtil.c(this.b, 15) * f);
      this.S = ProfileCardUtil.c(this.b, 45);
      this.T = Math.round(ProfileCardUtil.c(this.b, 3) * f);
      this.V = Math.round(ProfileCardUtil.c(this.b, 7) * f);
      this.U = Math.round(ProfileCardUtil.a(this.b, 14.5F) * f);
      this.W = Math.round(ProfileCardUtil.c(this.b, 20) * f);
      this.X = Math.round(f * ProfileCardUtil.c(this.b, 15));
      this.Y = 0.824503F;
      this.Z = 18;
    }
    else
    {
      f = this.t / (this.aa * 800.0F);
      this.P = Math.round(ProfileCardUtil.c(this.b, 11) * f);
      this.Q = Math.round(ProfileCardUtil.c(this.b, 10) * f);
      this.R = Math.round(ProfileCardUtil.c(this.b, 11) * f);
      this.S = ProfileCardUtil.c(this.b, 40);
      this.T = Math.round(ProfileCardUtil.c(this.b, 3) * f);
      this.V = Math.round(ProfileCardUtil.c(this.b, 7) * f);
      this.U = Math.round(ProfileCardUtil.a(this.b, 16.5F) * f);
      this.W = Math.round(ProfileCardUtil.c(this.b, 20) * f);
      this.X = Math.round(f * ProfileCardUtil.c(this.b, 15));
      this.Z = 16;
      this.Y = 0.8192771F;
    }
    paramBundle = (RelativeLayout.LayoutParams)this.M.getLayoutParams();
    paramBundle.height = this.S;
    int i = this.R;
    paramBundle.leftMargin = i;
    paramBundle.rightMargin = i;
    paramBundle.bottomMargin = this.Q;
    this.M.setTextSize(1, this.Z);
    this.M.setLayoutParams(paramBundle);
    paramBundle = (RelativeLayout.LayoutParams)this.L.getLayoutParams();
    i = this.U;
    paramBundle.topMargin = i;
    paramBundle.bottomMargin = i;
    this.L.setLayoutParams(paramBundle);
    this.L.setCirclePadding(this.V);
    this.L.setRadius(this.T);
    i = getResources().getDimensionPixelSize(2131299920);
    int j = ProfileCardUtil.a(getResources());
    this.O = (this.t - this.W - this.Q - this.S - this.T * 2 - this.U * 2 - i - j);
    this.aj = this.O;
    this.ak = Math.round(this.aj / 1.78F);
    this.L.setStrokeWidth(0.0F);
    ThreadManager.post(new VipProfileCardPreviewActivity.1(this), 8, null, true);
    k();
    this.M.setOnClickListener(this);
    if (this.app != null) {
      this.app.addObserver(this.z, true);
    }
    this.L.setOnPageChangeListener(new VipProfileCardPreviewActivity.2(this));
    if (this.app != null)
    {
      QQAppInterface localQQAppInterface = this.app;
      paramBundle = this.I;
      if (paramBundle == null) {
        paramBundle = "";
      } else {
        paramBundle = Integer.toString(paramBundle.a);
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "card_mall", "0X8004D59", 0, 0, paramBundle, "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.au = true;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.app != null) {
      this.app.removeObserver(this.z);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.app != null) {
      this.app.addObserver(this.z, true);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void k()
  {
    setLeftViewName(2131887625);
    setTitle(2131892851);
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData start.");
    }
    if (this.ah != null)
    {
      if (this.ag == null) {
        return;
      }
      Object localObject2 = null;
      ArrayList localArrayList = j();
      if (this.af == 0L)
      {
        localObject1 = new ProfileCardTemplate();
        ((ProfileCardTemplate)localObject1).styleId = 0L;
        ((ProfileCardTemplate)localObject1).imageWhiteMin = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
        ((ProfileCardTemplate)localObject1).imageBlackMin = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
        ((ProfileCardTemplate)localObject1).imageWhiteSmall = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
        ((ProfileCardTemplate)localObject1).imageBlackSmall = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
        ((ProfileCardTemplate)localObject1).auth = "0";
        ((ProfileCardTemplate)localObject1).name = getString(2131892849);
        localArrayList.add(localObject1);
      }
      int m = 0;
      Object localObject1 = localObject2;
      int i;
      if (localArrayList != null)
      {
        localObject1 = localObject2;
        if (localArrayList.size() > 0)
        {
          localObject2 = new ArrayList();
          if (this.ac)
          {
            i = 0;
            while (i < localArrayList.size())
            {
              localObject1 = (ProfileCardTemplate)localArrayList.get(i);
              if (this.n == ((ProfileCardTemplate)localObject1).styleId) {
                this.ab = i;
              }
              this.ag.add(Long.valueOf(((ProfileCardTemplate)localObject1).styleId));
              i += 1;
            }
          }
          int j;
          for (i = 0;; i = j + 1)
          {
            localObject1 = localObject2;
            if (i >= this.ag.size()) {
              break;
            }
            j = 0;
            int k = 0;
            while (j < localArrayList.size())
            {
              localObject1 = (ProfileCardTemplate)localArrayList.get(j);
              if (((Long)this.ag.get(i)).longValue() == ((ProfileCardTemplate)localObject1).styleId)
              {
                ProfileCardTemplateInfo localProfileCardTemplateInfo = new ProfileCardTemplateInfo();
                localProfileCardTemplateInfo.a = ((ProfileCardTemplate)localObject1);
                if (a(localProfileCardTemplateInfo)) {
                  localProfileCardTemplateInfo.b = 2;
                } else {
                  localProfileCardTemplateInfo.b = 0;
                }
                a(localProfileCardTemplateInfo.a);
                ((ArrayList)localObject2).add(localProfileCardTemplateInfo);
                k = 1;
              }
              j += 1;
            }
            j = i;
            if (k == 0)
            {
              this.ag.remove(i);
              j = this.ab;
              if ((j > 0) && (i <= j)) {
                this.ab = (j - 1);
              }
              j = i - 1;
            }
          }
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          if (!this.aq)
          {
            localObject2 = this.ah;
            if (localObject2 != null) {
              ((List)localObject2).clear();
            }
          }
          localObject2 = this.ah;
          if (localObject2 == null) {
            return;
          }
          ((List)localObject2).addAll((Collection)localObject1);
          this.ap = true;
          if (QLog.isColorLevel()) {
            i = m;
          }
        }
        else
        {
          while (i < this.ah.size())
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("initTemplateListData, style : ");
              ((StringBuilder)localObject1).append(((ProfileCardTemplateInfo)this.ah.get(i)).a.styleId);
              ((StringBuilder)localObject1).append(", status : ");
              ((StringBuilder)localObject1).append(((ProfileCardTemplateInfo)this.ah.get(i)).b);
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
              ((ProfileCardTemplateInfo)localObject2).a = ((ProfileCardTemplate)localArrayList.get(i));
              if (a((ProfileCardTemplateInfo)localObject2)) {
                ((ProfileCardTemplateInfo)localObject2).b = 2;
              } else {
                ((ProfileCardTemplateInfo)localObject2).b = 0;
              }
              a(((ProfileCardTemplateInfo)localObject2).a);
              if (((ProfileCardTemplateInfo)localObject2).a.styleId != ProfileCardTemplate.PROFILE_CARD_STYLE_SHOPPING) {
                ((ArrayList)localObject1).add(localObject2);
              }
              i += 1;
            }
            localObject2 = this.ah;
            if (localObject2 == null) {
              return;
            }
            ((List)localObject2).clear();
            this.ah.addAll((Collection)localObject1);
            this.ap = true;
          }
        }
      }
      this.y.sendEmptyMessage(1);
    }
  }
  
  public void m()
  {
    Object localObject = this.ah;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = this.ab;
      if (i != -1)
      {
        localObject = (ProfileCardTemplateInfo)this.ah.get(i);
        a(this.ab, (ProfileCardTemplateInfo)localObject);
      }
      i = 0;
      while (i < this.ah.size())
      {
        int j = this.ab;
        if ((j == -1) || (i != j)) {
          a(i, (ProfileCardTemplateInfo)this.ah.get(i));
        }
        i += 1;
      }
    }
  }
  
  boolean n()
  {
    int i = this.K.getCurrentItem();
    ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.ah.get(i);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localProfileCardTemplateInfo != null)
    {
      bool1 = bool2;
      if (localProfileCardTemplateInfo.a != null)
      {
        bool1 = bool2;
        if (localProfileCardTemplateInfo.a.styleId == ProfileCardTemplate.PROFILE_CARD_STYLE_DIY) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void o()
  {
    h();
    Object localObject = getIntent();
    int i;
    String str;
    if (localObject != null) {
      if (((Intent)localObject).hasExtra("preview"))
      {
        i = 0;
        this.an = 0;
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
        this.o = ((JSONObject)localObject).getInt("entryId");
      }
      localObject = ((JSONObject)localObject).getJSONObject("item");
      this.I = new ProfileCardBackground();
      this.I.a = ((JSONObject)localObject).optInt("id");
      this.I.b = ((JSONObject)localObject).optString("name");
      this.I.c = ((JSONObject)localObject).optInt("type");
      this.I.d = ((JSONObject)localObject).optString("image_url");
      this.I.e = ((JSONObject)localObject).optString("thumb_url");
      this.I.f = ((JSONObject)localObject).optInt("auth");
      this.I.g = ((JSONObject)localObject).optInt("limitefree_type");
      this.I.h = ((JSONObject)localObject).optInt("limitefree_btime");
      this.I.i = ((JSONObject)localObject).optInt("limitefree_etime");
      this.I.o = ((JSONObject)localObject).optInt("color");
      this.I.j = ((JSONObject)localObject).optInt("tag");
      this.I.k = ((JSONObject)localObject).optInt("tag_btime");
      this.I.l = ((JSONObject)localObject).optInt("tag_etime");
      this.I.m = ((JSONObject)localObject).optInt("background_btime");
      this.I.n = ((JSONObject)localObject).optInt("background_etime");
      this.r = this.I.o;
      a(this.I);
      this.af = ((JSONObject)localObject).optInt("style");
      if (this.I.a == 160)
      {
        this.af = 1L;
        localObject = i();
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
    a(this.I.d);
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
        this.an = 1;
        this.ao = ((Intent)localObject).getStringExtra("custom_card_background");
        this.I = new ProfileCardBackground();
        this.I.a = 160;
        this.af = 1L;
        a(i());
        a(this.ao, null);
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
    if ((paramView.getId() == 2131439547) && (this.K != null))
    {
      Object localObject = this.ah;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i = this.an;
        if (i == 0)
        {
          i = this.K.getCurrentItem();
          localObject = (ProfileCardTemplateInfo)this.ah.get(i);
          ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.am, Long.toString(((ProfileCardTemplateInfo)localObject).a.styleId), "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
          if (a(((ProfileCardTemplateInfo)localObject).a, this.I, true)) {
            if (this.I.a != 160) {
              a(((ProfileCardTemplateInfo)localObject).a.styleId, this.I.a);
            } else {
              a(r(), this.I.a, this.I.d, this.I.o);
            }
          }
        }
        else if (i == 1)
        {
          ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.am, "-1", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
          if (n())
          {
            localObject = new Intent(this, VipProfileCardDiyActivity.class);
            ((Intent)localObject).putExtra("extra_from", 3);
            ((Intent)localObject).putExtra("extra_card_id", 0L);
            ((Intent)localObject).putExtra("extra_card_path", this.ao);
            startActivity((Intent)localObject);
          }
          else
          {
            ProfileCardUtil.a(this.ao, 100, 0.56338F);
            if (!TextUtils.isEmpty((CharSequence)this.at.get(this.ao)))
            {
              localObject = this.ao;
              b((String)localObject, (String)this.at.get(localObject));
            }
            else
            {
              b(this.ao);
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
  
  void p()
  {
    this.a = new QQProgressDialog(this, getTitleBarHeight());
    this.a.setCancelable(false);
    this.a.c(2131892863);
    try
    {
      this.a.show();
      this.y.sendEmptyMessageDelayed(25, 30000L);
      return;
    }
    catch (Exception localException) {}
  }
  
  void q()
  {
    b();
    this.y.removeMessages(25);
  }
  
  long r()
  {
    int i = this.K.getCurrentItem();
    return ((ProfileCardTemplateInfo)this.ah.get(i)).a.styleId;
  }
  
  void s()
  {
    if (!TextUtils.isEmpty(this.ao))
    {
      File localFile = new File(this.ao);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity
 * JD-Core Version:    0.7.0.1
 */