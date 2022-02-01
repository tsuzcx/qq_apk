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
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;
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
    return ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_o_of_type_Long;
  }
  
  /* Error */
  android.graphics.Bitmap a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: getstatic 189	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   6: astore 4
    //   8: iconst_1
    //   9: istore_3
    //   10: aload 8
    //   12: astore 6
    //   14: iload_3
    //   15: iconst_2
    //   16: if_icmpgt +185 -> 201
    //   19: new 142	android/graphics/BitmapFactory$Options
    //   22: dup
    //   23: invokespecial 190	android/graphics/BitmapFactory$Options:<init>	()V
    //   26: astore 9
    //   28: aload 9
    //   30: aload 4
    //   32: putfield 193	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   35: aload 9
    //   37: aload_0
    //   38: getfield 196	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   41: putfield 199	android/graphics/BitmapFactory$Options:inDensity	I
    //   44: aload 9
    //   46: aload_0
    //   47: getfield 196	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   50: putfield 202	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   53: aload 9
    //   55: aload_0
    //   56: getfield 196	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   59: putfield 205	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   62: new 207	java/io/BufferedInputStream
    //   65: dup
    //   66: new 209	java/io/FileInputStream
    //   69: dup
    //   70: new 211	java/io/File
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: invokespecial 217	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 220	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore 4
    //   86: iload_2
    //   87: ifeq +37 -> 124
    //   90: aload 9
    //   92: iconst_1
    //   93: putfield 223	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   96: aload 4
    //   98: aconst_null
    //   99: aload 9
    //   101: invokestatic 229	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   104: pop
    //   105: aload 9
    //   107: aload_0
    //   108: aload 9
    //   110: aload_0
    //   111: getfield 231	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   114: aload_0
    //   115: getfield 233	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	I
    //   118: invokevirtual 235	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   121: putfield 238	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   124: aload 9
    //   126: iconst_0
    //   127: putfield 223	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   130: new 207	java/io/BufferedInputStream
    //   133: dup
    //   134: new 209	java/io/FileInputStream
    //   137: dup
    //   138: new 211	java/io/File
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: invokespecial 217	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   149: invokespecial 220	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   152: astore 5
    //   154: aload 5
    //   156: astore 6
    //   158: aload 4
    //   160: astore 7
    //   162: aload 5
    //   164: aconst_null
    //   165: aload 9
    //   167: invokestatic 229	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   170: astore 9
    //   172: aload 9
    //   174: astore_1
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   185: aload_1
    //   186: astore 6
    //   188: aload 5
    //   190: ifnull +11 -> 201
    //   193: aload 5
    //   195: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   198: aload_1
    //   199: astore 6
    //   201: aload 6
    //   203: areturn
    //   204: astore 4
    //   206: ldc 243
    //   208: iconst_1
    //   209: ldc 245
    //   211: aload 4
    //   213: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   234: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +47 -> 284
    //   240: aload 5
    //   242: astore 6
    //   244: aload 4
    //   246: astore 7
    //   248: ldc 243
    //   250: iconst_2
    //   251: new 256	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 259
    //   261: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_1
    //   265: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 265
    //   271: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: iload_3
    //   275: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload 5
    //   286: astore 6
    //   288: aload 4
    //   290: astore 7
    //   292: getstatic 278	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   295: astore 9
    //   297: aload 4
    //   299: ifnull +8 -> 307
    //   302: aload 4
    //   304: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   307: aload 5
    //   309: ifnull +8 -> 317
    //   312: aload 5
    //   314: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   317: iload_3
    //   318: iconst_1
    //   319: iadd
    //   320: istore_3
    //   321: aload 9
    //   323: astore 4
    //   325: goto -315 -> 10
    //   328: astore 4
    //   330: ldc 243
    //   332: iconst_1
    //   333: ldc 245
    //   335: aload 4
    //   337: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: goto -23 -> 317
    //   343: astore 6
    //   345: aconst_null
    //   346: astore 4
    //   348: aconst_null
    //   349: astore 5
    //   351: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +53 -> 407
    //   357: ldc 243
    //   359: iconst_2
    //   360: new 256	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 259
    //   370: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_1
    //   374: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: ldc_w 280
    //   380: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload 6
    //   385: invokevirtual 283	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   388: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: ldc_w 265
    //   394: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: iload_3
    //   398: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   401: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload 5
    //   409: ifnull +8 -> 417
    //   412: aload 5
    //   414: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   417: aload 8
    //   419: astore 6
    //   421: aload 4
    //   423: ifnull -222 -> 201
    //   426: aload 4
    //   428: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   431: aconst_null
    //   432: areturn
    //   433: astore_1
    //   434: ldc 243
    //   436: iconst_1
    //   437: ldc 245
    //   439: aload_1
    //   440: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   443: aconst_null
    //   444: areturn
    //   445: astore_1
    //   446: aconst_null
    //   447: astore 4
    //   449: aconst_null
    //   450: astore 5
    //   452: aload 5
    //   454: ifnull +8 -> 462
    //   457: aload 5
    //   459: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   462: aload 4
    //   464: ifnull +8 -> 472
    //   467: aload 4
    //   469: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   472: aload_1
    //   473: athrow
    //   474: astore 4
    //   476: ldc 243
    //   478: iconst_1
    //   479: ldc 245
    //   481: aload 4
    //   483: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   486: goto -14 -> 472
    //   489: astore_1
    //   490: aload 4
    //   492: astore 5
    //   494: aconst_null
    //   495: astore 4
    //   497: goto -45 -> 452
    //   500: astore_1
    //   501: aload 7
    //   503: astore 5
    //   505: aload 6
    //   507: astore 4
    //   509: goto -57 -> 452
    //   512: astore_1
    //   513: goto -61 -> 452
    //   516: astore 6
    //   518: aload 4
    //   520: astore 5
    //   522: aconst_null
    //   523: astore 4
    //   525: goto -174 -> 351
    //   528: astore 6
    //   530: aload 4
    //   532: astore 7
    //   534: aload 5
    //   536: astore 4
    //   538: aload 7
    //   540: astore 5
    //   542: goto -191 -> 351
    //   545: astore 5
    //   547: aconst_null
    //   548: astore 5
    //   550: goto -324 -> 226
    //   553: astore 6
    //   555: goto -329 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	this	VipProfileCardPreviewActivity
    //   0	558	1	paramString	String
    //   0	558	2	paramBoolean	boolean
    //   9	389	3	i	int
    //   6	175	4	localObject1	Object
    //   204	8	4	localException1	Exception
    //   218	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   224	100	4	localObject2	Object
    //   328	8	4	localException2	Exception
    //   346	122	4	localObject3	Object
    //   474	17	4	localException3	Exception
    //   495	42	4	localObject4	Object
    //   152	389	5	localObject5	Object
    //   545	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   548	1	5	localObject6	Object
    //   12	275	6	localObject7	Object
    //   343	41	6	localException4	Exception
    //   419	87	6	localObject8	Object
    //   516	1	6	localException5	Exception
    //   528	1	6	localException6	Exception
    //   553	1	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   160	379	7	localObject9	Object
    //   1	417	8	localObject10	Object
    //   26	296	9	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   180	185	204	java/lang/Exception
    //   193	198	204	java/lang/Exception
    //   19	86	218	java/lang/OutOfMemoryError
    //   302	307	328	java/lang/Exception
    //   312	317	328	java/lang/Exception
    //   19	86	343	java/lang/Exception
    //   412	417	433	java/lang/Exception
    //   426	431	433	java/lang/Exception
    //   19	86	445	finally
    //   457	462	474	java/lang/Exception
    //   467	472	474	java/lang/Exception
    //   90	124	489	finally
    //   124	154	489	finally
    //   162	172	500	finally
    //   234	240	500	finally
    //   248	284	500	finally
    //   292	297	500	finally
    //   351	407	512	finally
    //   90	124	516	java/lang/Exception
    //   124	154	516	java/lang/Exception
    //   162	172	528	java/lang/Exception
    //   90	124	545	java/lang/OutOfMemoryError
    //   124	154	545	java/lang/OutOfMemoryError
    //   162	172	553	java/lang/OutOfMemoryError
  }
  
  public List<String> a(ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramProfileCardTemplateInfo == null) || (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null)) {}
    for (;;)
    {
      return localArrayList;
      if (this.h == 1) {
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.k);
      }
      while (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d == 2)
      {
        if (this.h != 1) {
          break label95;
        }
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_o_of_type_JavaLangString);
        return localArrayList;
        localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.g);
      }
    }
    label95:
    localArrayList.add(paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.s);
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) {
      return;
    }
    d(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem());
  }
  
  void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager == null) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    Object localObject;
    do
    {
      do
      {
        ProfileCardTemplateInfo localProfileCardTemplateInfo;
        do
        {
          do
          {
            do
            {
              return;
              localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.findViewById(paramInt);
            } while ((localObject == null) || (((View)localObject).getTag() == null));
            localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag();
          } while (localObject == null);
          localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView;
          localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        } while (localProfileCardTemplateInfo == null);
        switch (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d)
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
  
  public void a(int paramInt, ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    if (paramProfileCardTemplateInfo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startDownload pos = " + paramInt + ", status = " + paramProfileCardTemplateInfo.jdField_a_of_type_Int);
      }
    } while ((paramProfileCardTemplateInfo.jdField_a_of_type_Int == 2) || (paramProfileCardTemplateInfo.jdField_a_of_type_Int == 1));
    paramProfileCardTemplateInfo.jdField_a_of_type_Int = 1;
    paramProfileCardTemplateInfo = a(paramProfileCardTemplateInfo);
    this.jdField_b_of_type_JavaUtilList.addAll(paramProfileCardTemplateInfo);
    a(paramInt, paramProfileCardTemplateInfo);
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
  public void a(VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder paramViewHolder, ProfileCardTemplateInfo paramProfileCardTemplateInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 405	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Lcom/tencent/mobileqq/profile/ProfileCardTemplateInfo;)Z
    //   5: ifeq +69 -> 74
    //   8: aload_2
    //   9: iconst_2
    //   10: putfield 363	com/tencent/mobileqq/profile/ProfileCardTemplateInfo:jdField_a_of_type_Int	I
    //   13: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +35 -> 51
    //   19: ldc 243
    //   21: iconst_2
    //   22: new 256	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 407
    //   32: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_3
    //   36: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 409
    //   42: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: aload_2
    //   53: invokevirtual 365	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:a	(Lcom/tencent/mobileqq/profile/ProfileCardTemplateInfo;)Ljava/util/List;
    //   56: astore 7
    //   58: aload 7
    //   60: ifnull +13 -> 73
    //   63: aload 7
    //   65: invokeinterface 311 1 0
    //   70: ifne +43 -> 113
    //   73: return
    //   74: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -4 -> 73
    //   80: ldc 243
    //   82: iconst_2
    //   83: new 256	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 407
    //   93: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload_3
    //   97: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc_w 411
    //   103: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 275	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: return
    //   113: aload_2
    //   114: getfield 174	com/tencent/mobileqq/profile/ProfileCardTemplateInfo:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   117: getfield 178	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_o_of_type_Long	J
    //   120: getstatic 413	com/tencent/mobileqq/profile/ProfileCardTemplate:n	J
    //   123: lcmp
    //   124: ifne +239 -> 363
    //   127: aload_1
    //   128: getfield 416	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   131: iconst_0
    //   132: invokevirtual 421	com/tencent/mobileqq/hiboom/HiBoomTextView:setVisibility	(I)V
    //   135: sipush 2000
    //   138: istore 5
    //   140: getstatic 425	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: astore 8
    //   145: getstatic 428	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   148: ifnull +205 -> 353
    //   151: getstatic 428	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   154: invokevirtual 431	android/util/SparseArray:size	()I
    //   157: ifle +196 -> 353
    //   160: getstatic 428	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   163: iconst_0
    //   164: invokevirtual 435	android/util/SparseArray:keyAt	(I)I
    //   167: istore 5
    //   169: aload_1
    //   170: getfield 416	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   173: iload 5
    //   175: iconst_1
    //   176: getstatic 440	com/tencent/mobileqq/hiboom/HiBoomManager:b	Lcom/tencent/mobileqq/hiboom/HiBoomFont$HiBoomFontDownloader;
    //   179: invokevirtual 444	com/tencent/mobileqq/hiboom/HiBoomTextView:setHiBoom	(IILcom/tencent/mobileqq/hiboom/HiBoomFont$HiBoomFontDownloader;)V
    //   182: aload_1
    //   183: getfield 416	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   186: aload 8
    //   188: invokevirtual 448	com/tencent/mobileqq/hiboom/HiBoomTextView:setText	(Ljava/lang/CharSequence;)V
    //   191: aload_0
    //   192: getfield 231	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   195: i2f
    //   196: aload_0
    //   197: invokevirtual 452	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:getResources	()Landroid/content/res/Resources;
    //   200: invokevirtual 458	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   203: getfield 463	android/util/DisplayMetrics:widthPixels	I
    //   206: i2f
    //   207: fdiv
    //   208: fstore 4
    //   210: aload_1
    //   211: getfield 416	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   214: fload 4
    //   216: invokevirtual 467	com/tencent/mobileqq/hiboom/HiBoomTextView:setScaleX	(F)V
    //   219: aload_1
    //   220: getfield 416	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   223: fload 4
    //   225: invokevirtual 470	com/tencent/mobileqq/hiboom/HiBoomTextView:setScaleY	(F)V
    //   228: aload_2
    //   229: getfield 174	com/tencent/mobileqq/profile/ProfileCardTemplateInfo:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   232: getfield 296	com/tencent/mobileqq/profile/ProfileCardTemplate:d	I
    //   235: tableswitch	default:+25 -> 260, 0:+26->261, 1:+140->375, 2:+549->784
    //   261: aload_1
    //   262: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   265: iconst_0
    //   266: invokevirtual 474	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   269: new 256	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 476
    //   279: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_0
    //   283: getfield 479	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   286: aload 7
    //   288: iconst_0
    //   289: invokeinterface 169 2 0
    //   294: checkcast 398	java/lang/String
    //   297: invokestatic 484	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   300: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload_0
    //   307: getfield 231	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   310: aload_0
    //   311: getfield 233	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	I
    //   314: aload_1
    //   315: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   318: invokevirtual 351	com/tencent/mobileqq/widget/ProfileCardScrollImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   321: aload_1
    //   322: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   325: invokevirtual 351	com/tencent/mobileqq/widget/ProfileCardScrollImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   328: iconst_0
    //   329: invokestatic 489	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;IILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)Lcom/tencent/image/URLDrawable;
    //   332: astore_2
    //   333: aload_1
    //   334: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   337: aload_2
    //   338: invokevirtual 493	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   341: aload_1
    //   342: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   345: iload_3
    //   346: invokestatic 499	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: invokevirtual 503	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   352: return
    //   353: aload_0
    //   354: getfield 507	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   357: invokestatic 510	com/tencent/mobileqq/profile/diy/VipProfileDiyCardConfig:a	(Lmqq/app/AppRuntime;)V
    //   360: goto -191 -> 169
    //   363: aload_1
    //   364: getfield 416	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView	Lcom/tencent/mobileqq/hiboom/HiBoomTextView;
    //   367: bipush 8
    //   369: invokevirtual 421	com/tencent/mobileqq/hiboom/HiBoomTextView:setVisibility	(I)V
    //   372: goto -144 -> 228
    //   375: aload_1
    //   376: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   379: iconst_1
    //   380: invokevirtual 474	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   383: aload_0
    //   384: getfield 479	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   387: aload 7
    //   389: iconst_0
    //   390: invokeinterface 169 2 0
    //   395: checkcast 398	java/lang/String
    //   398: invokestatic 484	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   401: astore 8
    //   403: new 207	java/io/BufferedInputStream
    //   406: dup
    //   407: new 209	java/io/FileInputStream
    //   410: dup
    //   411: new 211	java/io/File
    //   414: dup
    //   415: aload 8
    //   417: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: invokespecial 217	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   423: invokespecial 220	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   426: astore 7
    //   428: aload 7
    //   430: astore_2
    //   431: new 142	android/graphics/BitmapFactory$Options
    //   434: dup
    //   435: invokespecial 190	android/graphics/BitmapFactory$Options:<init>	()V
    //   438: astore 9
    //   440: aload 7
    //   442: astore_2
    //   443: aload 9
    //   445: iconst_1
    //   446: putfield 223	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   449: aload 7
    //   451: astore_2
    //   452: aload 9
    //   454: aload_0
    //   455: getfield 196	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   458: putfield 199	android/graphics/BitmapFactory$Options:inDensity	I
    //   461: aload 7
    //   463: astore_2
    //   464: aload 9
    //   466: aload_0
    //   467: getfield 196	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   470: putfield 202	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   473: aload 7
    //   475: astore_2
    //   476: aload 9
    //   478: aload_0
    //   479: getfield 196	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:l	I
    //   482: putfield 205	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   485: aload 7
    //   487: astore_2
    //   488: aload 7
    //   490: aconst_null
    //   491: aload 9
    //   493: invokestatic 229	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   496: pop
    //   497: aload 7
    //   499: astore_2
    //   500: aload 9
    //   502: getfield 148	android/graphics/BitmapFactory$Options:outWidth	I
    //   505: istore 5
    //   507: aload 7
    //   509: astore_2
    //   510: aload 9
    //   512: getfield 145	android/graphics/BitmapFactory$Options:outHeight	I
    //   515: aload_0
    //   516: getfield 231	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   519: imul
    //   520: iload 5
    //   522: idiv
    //   523: istore 6
    //   525: aload 7
    //   527: astore_2
    //   528: aload_0
    //   529: aload_0
    //   530: getfield 233	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:y	I
    //   533: iload 6
    //   535: isub
    //   536: putfield 512	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:A	I
    //   539: aload 7
    //   541: astore_2
    //   542: aload_1
    //   543: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   546: getstatic 518	android/widget/ImageView$ScaleType:MATRIX	Landroid/widget/ImageView$ScaleType;
    //   549: invokevirtual 522	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   552: aload 7
    //   554: astore_2
    //   555: new 524	android/graphics/Matrix
    //   558: dup
    //   559: invokespecial 525	android/graphics/Matrix:<init>	()V
    //   562: astore 9
    //   564: aload 7
    //   566: astore_2
    //   567: aload 9
    //   569: aload_0
    //   570: getfield 231	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   573: i2f
    //   574: iload 5
    //   576: i2f
    //   577: fdiv
    //   578: aload_0
    //   579: getfield 231	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:z	I
    //   582: i2f
    //   583: iload 5
    //   585: i2f
    //   586: fdiv
    //   587: invokevirtual 529	android/graphics/Matrix:postScale	(FF)Z
    //   590: pop
    //   591: aload 7
    //   593: astore_2
    //   594: aload_1
    //   595: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   598: aload 9
    //   600: invokevirtual 533	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageMatrix	(Landroid/graphics/Matrix;)V
    //   603: aload 7
    //   605: astore_2
    //   606: getstatic 538	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   609: aload 8
    //   611: invokevirtual 543	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   614: checkcast 545	android/graphics/drawable/Drawable
    //   617: astore 9
    //   619: aload 9
    //   621: ifnull +71 -> 692
    //   624: aload 7
    //   626: astore_2
    //   627: aload_1
    //   628: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   631: aload 9
    //   633: invokevirtual 493	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   636: aload 7
    //   638: astore_2
    //   639: aload_1
    //   640: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   643: iload_3
    //   644: invokestatic 499	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   647: invokevirtual 503	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   650: aload 7
    //   652: astore_2
    //   653: aload_0
    //   654: getfield 84	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:x	I
    //   657: iload_3
    //   658: if_icmpne +11 -> 669
    //   661: aload 7
    //   663: astore_2
    //   664: aload_0
    //   665: iload_3
    //   666: invokevirtual 547	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:b	(I)V
    //   669: aload 7
    //   671: ifnull -598 -> 73
    //   674: aload 7
    //   676: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   679: return
    //   680: astore_1
    //   681: ldc 243
    //   683: iconst_1
    //   684: ldc_w 549
    //   687: aload_1
    //   688: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   691: return
    //   692: aload 7
    //   694: astore_2
    //   695: new 551	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$5
    //   698: dup
    //   699: aload_0
    //   700: aload 8
    //   702: iload_3
    //   703: invokespecial 554	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$5:<init>	(Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;Ljava/lang/String;I)V
    //   706: bipush 8
    //   708: aconst_null
    //   709: iconst_1
    //   710: invokestatic 384	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   713: goto -44 -> 669
    //   716: astore_2
    //   717: aload 7
    //   719: astore_1
    //   720: aload_2
    //   721: astore 7
    //   723: aload_1
    //   724: astore_2
    //   725: ldc 243
    //   727: iconst_1
    //   728: ldc_w 549
    //   731: aload 7
    //   733: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   736: aload_1
    //   737: ifnull -664 -> 73
    //   740: aload_1
    //   741: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   744: return
    //   745: astore_1
    //   746: ldc 243
    //   748: iconst_1
    //   749: ldc_w 549
    //   752: aload_1
    //   753: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   756: return
    //   757: astore_1
    //   758: aconst_null
    //   759: astore_2
    //   760: aload_2
    //   761: ifnull +7 -> 768
    //   764: aload_2
    //   765: invokevirtual 241	java/io/BufferedInputStream:close	()V
    //   768: aload_1
    //   769: athrow
    //   770: astore_2
    //   771: ldc 243
    //   773: iconst_1
    //   774: ldc_w 549
    //   777: aload_2
    //   778: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   781: goto -13 -> 768
    //   784: aload_1
    //   785: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   788: iconst_0
    //   789: invokevirtual 474	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setIsScroll	(Z)V
    //   792: aload 7
    //   794: invokeinterface 311 1 0
    //   799: iconst_1
    //   800: if_icmple -727 -> 73
    //   803: aload 7
    //   805: iconst_0
    //   806: invokeinterface 169 2 0
    //   811: checkcast 556	java/lang/CharSequence
    //   814: invokestatic 562	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   817: ifne -744 -> 73
    //   820: aload 7
    //   822: iconst_1
    //   823: invokeinterface 169 2 0
    //   828: checkcast 556	java/lang/CharSequence
    //   831: invokestatic 562	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   834: ifne -761 -> 73
    //   837: new 256	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   844: aload 7
    //   846: iconst_0
    //   847: invokeinterface 169 2 0
    //   852: checkcast 398	java/lang/String
    //   855: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: aload 7
    //   860: iconst_1
    //   861: invokeinterface 169 2 0
    //   866: checkcast 398	java/lang/String
    //   869: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: astore_2
    //   876: getstatic 538	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   879: aload_2
    //   880: invokevirtual 543	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   883: instanceof 564
    //   886: ifeq +53 -> 939
    //   889: getstatic 538	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   892: aload_2
    //   893: invokevirtual 543	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   896: checkcast 564	android/util/Pair
    //   899: getfield 568	android/util/Pair:first	Ljava/lang/Object;
    //   902: checkcast 545	android/graphics/drawable/Drawable
    //   905: astore_2
    //   906: aload_1
    //   907: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   910: aload_2
    //   911: invokevirtual 493	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   914: aload_1
    //   915: getfield 326	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$StylePagerAdapter$ViewHolder:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView	Lcom/tencent/mobileqq/widget/ProfileCardScrollImageView;
    //   918: iload_3
    //   919: invokestatic 499	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   922: invokevirtual 503	com/tencent/mobileqq/widget/ProfileCardScrollImageView:setTag	(Ljava/lang/Object;)V
    //   925: aload_0
    //   926: getfield 84	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:x	I
    //   929: iload_3
    //   930: if_icmpne -857 -> 73
    //   933: aload_0
    //   934: iload_3
    //   935: invokevirtual 547	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity:b	(I)V
    //   938: return
    //   939: new 570	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$6
    //   942: dup
    //   943: aload_0
    //   944: aload 7
    //   946: aload_2
    //   947: iload_3
    //   948: invokespecial 573	com/tencent/mobileqq/profile/VipProfileCardPreviewActivity$6:<init>	(Lcom/tencent/mobileqq/profile/VipProfileCardPreviewActivity;Ljava/util/List;Ljava/lang/String;I)V
    //   951: bipush 8
    //   953: aconst_null
    //   954: iconst_1
    //   955: invokestatic 384	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
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
    //   0	970	1	paramViewHolder	VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder
    //   0	970	2	paramProfileCardTemplateInfo	ProfileCardTemplateInfo
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
      paramString = ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, paramString);
      localObject = new File(paramString);
      if ((((File)localObject).isFile()) && (((File)localObject).exists()))
      {
        localObject = "profilecard_preview:" + paramString;
        Pair localPair = (Pair)GlobalImageCache.a.get(localObject);
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
  
  void a(String paramString, UpsImageUploadResult paramUpsImageUploadResult)
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
    int i1;
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
      int k = 0;
      i1 = i;
      if (j < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        l = ((Long)this.jdField_b_of_type_JavaUtilArrayList.get(j)).longValue();
        if (l == this.jdField_a_of_type_Long)
        {
          this.x = j;
          i = 1;
          i1 = 1;
        }
        for (;;)
        {
          j += 1;
          k = i1;
          break;
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
    ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    if ((localProfileCardTemplateInfo != null) && (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null)) {
      return localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_o_of_type_Long == ProfileCardTemplate.n;
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
        break label316;
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
      return true;
      int j = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getChildCount();
      while (i < j)
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getChildAt(i);
        if ((paramMessage.getTag() instanceof VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)) {
          ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)paramMessage.getTag()).jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
    label316:
    if (paramMessage.what == 3)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131695130, 0).show();
      return true;
    }
    if (paramMessage.what == 20)
    {
      c(paramMessage.arg1);
      return true;
    }
    if (paramMessage.what == 5)
    {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131695141, 0).show();
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
        ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramMessage.arg1)).jdField_a_of_type_Int = -1;
      }
      return true;
    }
    if ((paramMessage.what == 24) || (paramMessage.what == 25))
    {
      if (paramMessage.what == 25) {
        b();
      }
      Toast.makeText(getApplicationContext(), getResources().getString(2131695144), 1).show();
      return true;
    }
    return false;
  }
  
  public boolean a(ProfileCardTemplateInfo paramProfileCardTemplateInfo)
  {
    if ((paramProfileCardTemplateInfo == null) || (paramProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null)) {
      return false;
    }
    paramProfileCardTemplateInfo = a(paramProfileCardTemplateInfo);
    if ((paramProfileCardTemplateInfo == null) || (paramProfileCardTemplateInfo.size() == 0)) {
      return false;
    }
    paramProfileCardTemplateInfo = paramProfileCardTemplateInfo.iterator();
    while (paramProfileCardTemplateInfo.hasNext())
    {
      String str = (String)paramProfileCardTemplateInfo.next();
      if (!ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, str)) {
        return false;
      }
    }
    return true;
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    if (this.app != null) {
      this.app.addObserver(paramBusinessObserver);
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
      ProfileCardTemplateInfo localProfileCardTemplateInfo;
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
              localObject = (VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)((View)localObject).getTag();
            } while (localObject == null);
            localObject = ((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProfileCardScrollImageView;
            localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          } while ((localProfileCardTemplateInfo == null) || (((ProfileCardScrollImageView)localObject).getTag() == null));
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "startAnimation pos = " + paramInt);
          }
          switch (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.d)
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
      } while (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_o_of_type_Long == ProfileCardTemplate.n);
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
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    ProfileCardBackground localProfileCardBackground;
    ProfileCardTemplate localProfileCardTemplate;
    do
    {
      return;
      localProfileCardBackground = new ProfileCardBackground();
      localProfileCardBackground.jdField_a_of_type_Int = 160;
      localProfileCardTemplate = ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem())).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
    } while ((localProfileCardTemplate == null) || (this.jdField_f_of_type_Boolean) || (isFinishing()) || (!a(localProfileCardTemplate, localProfileCardBackground, true)));
    a(a(), 0L, paramString2, ProfileCardUtil.a(paramString1));
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
    a((VipProfileCardPreviewActivity.StylePagerAdapter.ViewHolder)localView.getTag(), (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_JavaUtilList.get(paramInt) == null)) {
      return;
    }
    ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_o_of_type_Long == ProfileCardTemplate.n)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695134);
      this.jdField_c_of_type_JavaLangString = "3";
      return;
    }
    a(localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground, false);
    if (this.jdField_b_of_type_Int == 4)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695136);
      this.jdField_c_of_type_JavaLangString = "2";
      return;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131695137);
      this.jdField_c_of_type_JavaLangString = "1";
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131695135);
    this.jdField_c_of_type_JavaLangString = "0";
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
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_f_of_type_Boolean = false;
    setContentView(2131562196);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374762);
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
      this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131372707));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131372500));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager = ((VipScaledViewPager)findViewById(2131381619));
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity$StylePagerAdapter = new VipProfileCardPreviewActivity.StylePagerAdapter(this, this.jdField_a_of_type_AndroidContentContext);
      if (Build.MODEL.equals("HUAWEI C8812E")) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayerType(1, null);
      }
      this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float / 2.0F);
      if (this.j / this.k <= (this.jdField_d_of_type_Float + this.jdField_e_of_type_Float) / 2.0F) {
        break label784;
      }
      f1 = this.j / (1136.0F * this.jdField_c_of_type_Float);
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
      i = getResources().getDimensionPixelSize(2131299166);
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
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground != null) {
          break label980;
        }
      }
    }
    label784:
    label980:
    for (paramBundle = "";; paramBundle = Integer.toString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int))
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "card_mall", "0X8004D59", 0, 0, paramBundle, "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
      return true;
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break;
      f1 = this.j / (800.0F * this.jdField_c_of_type_Float);
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
      break label420;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.app != null) {
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    }
  }
  
  public void i()
  {
    setLeftViewName(2131690778);
    setTitle(2131695133);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    int i1 = 0;
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
      localObject1 = new ProfileCardTemplate();
      ((ProfileCardTemplate)localObject1).jdField_o_of_type_Long = 0L;
      ((ProfileCardTemplate)localObject1).i = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).jdField_e_of_type_JavaLangString = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).k = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).g = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).jdField_c_of_type_JavaLangString = "0";
      ((ProfileCardTemplate)localObject1).jdField_a_of_type_JavaLangString = getString(2131695131);
      localArrayList.add(localObject1);
    }
    Object localObject1 = localObject2;
    int i;
    label227:
    int k;
    int j;
    label242:
    ProfileCardTemplateInfo localProfileCardTemplateInfo;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        localObject1 = new ArrayList();
        if (this.jdField_c_of_type_Boolean)
        {
          i = 0;
          while (i < localArrayList.size())
          {
            localObject2 = (ProfileCardTemplate)localArrayList.get(i);
            if (this.jdField_a_of_type_Long == ((ProfileCardTemplate)localObject2).jdField_o_of_type_Long) {
              this.x = i;
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(((ProfileCardTemplate)localObject2).jdField_o_of_type_Long));
            i += 1;
          }
        }
        i = 0;
        if (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          k = 0;
          j = 0;
          if (k < localArrayList.size())
          {
            localObject2 = (ProfileCardTemplate)localArrayList.get(k);
            if (((Long)this.jdField_b_of_type_JavaUtilArrayList.get(i)).longValue() != ((ProfileCardTemplate)localObject2).jdField_o_of_type_Long) {
              break label742;
            }
            localProfileCardTemplateInfo = new ProfileCardTemplateInfo();
            localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = ((ProfileCardTemplate)localObject2);
            if (a(localProfileCardTemplateInfo))
            {
              localProfileCardTemplateInfo.jdField_a_of_type_Int = 2;
              label316:
              a(localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate);
              ((ArrayList)localObject1).add(localProfileCardTemplateInfo);
              j = 1;
            }
          }
        }
      }
    }
    label645:
    label685:
    label729:
    label742:
    for (;;)
    {
      k += 1;
      break label242;
      localProfileCardTemplateInfo.jdField_a_of_type_Int = 0;
      break label316;
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
        break label227;
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
              break label729;
            }
            i = i1;
          }
          for (;;)
          {
            if (i < this.jdField_a_of_type_JavaUtilList.size())
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData, style : " + ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_o_of_type_Long + ", status : " + ((ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int + ", position : " + i);
              }
              i += 1;
              continue;
              localObject1 = new ArrayList();
              i = 0;
              if (i < localArrayList.size())
              {
                localObject2 = new ProfileCardTemplateInfo();
                ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = ((ProfileCardTemplate)localArrayList.get(i));
                if (a((ProfileCardTemplateInfo)localObject2))
                {
                  ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_Int = 2;
                  a(((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate);
                  if (((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_o_of_type_Long != ProfileCardTemplate.h) {
                    break label685;
                  }
                }
                for (;;)
                {
                  i += 1;
                  break;
                  ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_Int = 0;
                  break label645;
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
        ProfileCardTemplateInfo localProfileCardTemplateInfo = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(this.x);
        a(this.x, localProfileCardTemplateInfo);
      }
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.x != -1) && (i == this.x)) {}
        for (;;)
        {
          i += 1;
          break;
          a(i, (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i));
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
            a((long[])localObject);
            a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131695145);
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
  
  public boolean onBackEvent()
  {
    ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X8004C28", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Object localObject;
        if (this.B == 0)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getCurrentItem();
          localObject = (ProfileCardTemplateInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          ReportController.b(this.app, "CliOper", "", "", "card_mall", "0X8004C27", 0, 0, this.jdField_c_of_type_JavaLangString, Long.toString(((ProfileCardTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_o_of_type_Long), "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
          if (a(((ProfileCardTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground, true)) {
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int != 160) {
              a(((ProfileCardTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_o_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int);
            } else {
              a(a(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardBackground.l);
            }
          }
        }
        else if (this.B == 1)
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
            if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString))) {
              b(this.jdField_d_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString));
            } else {
              b(this.jdField_d_of_type_JavaLangString);
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity
 * JD-Core Version:    0.7.0.1
 */