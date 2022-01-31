package com.tencent.mobileqq.troop.activity;

import aivy;
import aivz;
import aiwa;
import aiwb;
import aiwc;
import aiwd;
import aiwe;
import aiwf;
import aiwg;
import aiwh;
import aiwi;
import aiwk;
import aiwp;
import aiwq;
import aiwr;
import aiws;
import aiwu;
import aiww;
import aiwx;
import aiwy;
import aixa;
import aixb;
import aixc;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ImagePreviewAnimationUtil;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelObserver;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Gallery;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TroopAvatarWallPreviewActivity
  extends BaseActivity
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  static boolean i;
  public int a;
  protected long a;
  private aixc jdField_a_of_type_Aixc;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aiwh(this);
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected View.OnClickListener a;
  protected View a;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  protected FrameLayout a;
  protected ImageButton a;
  public ImageView a;
  protected RelativeLayout a;
  public TextView a;
  private PublicAccountShowPictureReport jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport = new PublicAccountShowPictureReport();
  public PersonalityLabelObserver a;
  public TroopAvatarBigPhotoAdapter a;
  public ImageAnimationView a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public CookieManager a;
  public Gallery a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  public String a;
  protected ArrayList a;
  public List a;
  public boolean a;
  protected boolean[] a;
  public int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new aiww(this);
  public View b;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  protected ImageView b;
  protected RelativeLayout b;
  public TextView b;
  public String b;
  public ArrayList b;
  protected List b;
  public boolean b;
  protected View c;
  protected ImageView c;
  protected TextView c;
  public String c;
  public ArrayList c;
  public boolean c;
  protected View d;
  protected TextView d;
  protected ArrayList d;
  public boolean d;
  public ArrayList e;
  public boolean e;
  protected ArrayList f;
  public boolean f;
  protected boolean g;
  protected boolean h;
  protected boolean j;
  public boolean k;
  public boolean l = false;
  private boolean m = true;
  
  public TroopAvatarWallPreviewActivity()
  {
    this.jdField_a_of_type_Long = 300L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aiwi(this);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelObserver = new aiwr(this);
  }
  
  private Bitmap a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, Drawable paramDrawable, boolean paramBoolean)
  {
    Rect localRect;
    if (this.jdField_d_of_type_JavaUtilArrayList != null)
    {
      localRect = (Rect)this.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      localObject = a(paramBoolean);
      if ((localObject == null) || (localRect == null)) {
        return null;
      }
    }
    else
    {
      return null;
    }
    String str = b(paramBoolean);
    if (((String)localObject).equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString)) {}
    for (Object localObject = paramDrawable; localObject == null; localObject = a(paramBoolean, (String)localObject)) {
      return null;
    }
    if ((paramDrawable == null) && ((!paramBoolean) || (localObject == null))) {
      return null;
    }
    int i4;
    int i5;
    int n;
    label186:
    int i1;
    label197:
    int i3;
    label261:
    int i2;
    if (paramDrawable == null)
    {
      if ((TextUtils.isEmpty(str)) || (str.equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString))) {
        return null;
      }
      paramDrawable = a(paramBoolean, str);
      if (paramDrawable == null) {
        return null;
      }
      ((URLDrawable)paramDrawable).setAutoDownload(true);
      i4 = this.jdField_a_of_type_ComTencentWidgetGallery.getWidth();
      i5 = this.jdField_a_of_type_ComTencentWidgetGallery.getHeight();
      if (((Drawable)localObject).getIntrinsicWidth() != 0) {
        break label430;
      }
      n = 1;
      if (((Drawable)localObject).getIntrinsicHeight() != 0) {
        break label440;
      }
      i1 = 1;
      localObject = com.tencent.common.galleryactivity.AnimationUtils.a(this.jdField_a_of_type_ComTencentWidgetGallery);
      if (localObject != null) {
        localRect.offset(((Rect)localObject).left, -((Rect)localObject).top);
      }
      paramRect3.set(localRect);
      if ((!paramBoolean) || (((URLDrawable)paramDrawable).getStatus() != 1)) {
        break label470;
      }
      if (paramDrawable.getIntrinsicWidth() != 0) {
        break label450;
      }
      i3 = 1;
      if (paramDrawable.getIntrinsicHeight() != 0) {
        break label460;
      }
      i2 = 1;
    }
    for (;;)
    {
      float f1 = ImagePreviewAnimationUtil.a(i3, i2);
      paramRect1.set(ImagePreviewAnimationUtil.a(n, i1, i3, i2));
      paramRect2.set(ImagePreviewAnimationUtil.b(i3, i2, i4, i5));
      paramRect4.set(ImagePreviewAnimationUtil.c(i3, i2, i4, i5));
      ImagePreviewAnimationUtil.a(paramRect1, f1);
      ImagePreviewAnimationUtil.a(paramRect2, f1);
      n = (int)(i3 * f1);
      i1 = (int)(i2 * f1);
      try
      {
        paramRect3 = Bitmap.createBitmap(n, i1, Bitmap.Config.ARGB_4444);
        paramRect4 = new Canvas(paramRect3);
        localObject = new Rect(0, 0, i3, i2);
        ImagePreviewAnimationUtil.a((Rect)localObject, f1);
        paramDrawable.setBounds((Rect)localObject);
        paramRect4.clipRect(ImagePreviewAnimationUtil.a(paramRect1, paramRect2));
        paramDrawable.draw(paramRect4);
        return paramRect3;
      }
      catch (Throwable paramRect1)
      {
        if (!QLog.isColorLevel()) {
          break label516;
        }
        QLog.e("ImagePreveiew", 2, "makeAnimationRect " + paramRect1.getMessage());
      }
      break;
      label430:
      n = ((Drawable)localObject).getIntrinsicWidth();
      break label186;
      label440:
      i1 = ((Drawable)localObject).getIntrinsicHeight();
      break label197;
      label450:
      i3 = paramDrawable.getIntrinsicWidth();
      break label261;
      label460:
      i2 = paramDrawable.getIntrinsicHeight();
      continue;
      label470:
      i2 = i1;
      i3 = n;
    }
    label516:
    return null;
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1) || (this.jdField_b_of_type_JavaUtilArrayList == null) || (paramInt > this.jdField_b_of_type_JavaUtilArrayList.size() - 1)) {
      return;
    }
    ReportController.b(this.app, "dc00898", "", "", "0X8007FD5", "0X8007FD5", 0, 0, "0", "0", "", "");
    DialogUtil.a(this, 230).setTitle(getString(2131439084)).setPositiveButton(getString(2131433016), new aiwq(this, paramBundle, paramInt)).setNegativeButton(getString(2131433015), new aiwp(this)).show();
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport) || ("2".equals(this.jdField_b_of_type_JavaLangString))) {
      ForwardUtils.a(this.app, this, this, localIntent, null);
    }
    for (;;)
    {
      finish();
      return;
      startActivity(localIntent);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    TimeUtil.a("FastWebActivity.show");
    ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramFastWebArticleInfo = new Intent(this, FastWebActivity.class);
    paramFastWebArticleInfo.putExtra("fast_web_article_info", paramArticleInfo);
    startActivityForResult(paramFastWebArticleInfo, 10922);
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    ReadInJoyLogicEngine.a().a().a(paramString, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
    a(paramArticleInfo, null);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (getIntent().getBooleanExtra("from_photo_wall", false))
    {
      if (getIntent().getBooleanExtra("delete_ability", false)) {
        ReportController.b(this.app, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", paramString2, paramString2, 0, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_AndroidViewView.getHeight());
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new aiws(this));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidViewView.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new aiwu(this));
  }
  
  private boolean a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((ImageView)((View)localObject1).findViewById(2131361846)).getDrawable();
    if ((localObject2 != null) && ((localObject2 instanceof URLDrawable)))
    {
      if (((URLDrawable)localObject2).getStatus() != 1) {
        return false;
      }
    }
    else if (localObject2 == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setVisibility(0);
    localObject1 = new Rect();
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    localObject2 = a(localRect2, localRect3, (Rect)localObject1, localRect1, (Drawable)localObject2, localObject2 instanceof URLDrawable);
    if (localObject2 == null) {
      return false;
    }
    this.l = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a((Bitmap)localObject2, localRect3, localRect2, localRect1, (Rect)localObject1, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setAnimationListener(new aiwd(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new aiwe(this), this.jdField_a_of_type_Long);
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setInterpolator(new DecelerateInterpolator());
    ((AlphaAnimation)localObject1).setDuration(500L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
    return true;
  }
  
  /* Error */
  private boolean a(File paramFile)
  {
    // Byte code:
    //   0: iconst_2
    //   1: iconst_0
    //   2: ldc_w 579
    //   5: ldc_w 581
    //   8: invokestatic 586	com/tencent/qbar/QbarNativeImpl:a	(IILjava/lang/String;Ljava/lang/String;)I
    //   11: pop
    //   12: iconst_2
    //   13: newarray int
    //   15: astore 5
    //   17: aload 5
    //   19: iconst_0
    //   20: iconst_2
    //   21: iastore
    //   22: aload 5
    //   24: iconst_1
    //   25: iconst_0
    //   26: iastore
    //   27: aload 5
    //   29: aload 5
    //   31: arraylength
    //   32: invokestatic 589	com/tencent/qbar/QbarNativeImpl:a	([II)I
    //   35: pop
    //   36: new 237	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 591
    //   46: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 596	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 602	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   62: astore_1
    //   63: iconst_m1
    //   64: istore_3
    //   65: aload_0
    //   66: invokevirtual 606	com/tencent/mobileqq/troop/activity/TroopAvatarWallPreviewActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   69: astore 7
    //   71: new 608	android/graphics/BitmapFactory$Options
    //   74: dup
    //   75: invokespecial 609	android/graphics/BitmapFactory$Options:<init>	()V
    //   78: astore 6
    //   80: aload 6
    //   82: iconst_1
    //   83: putfield 612	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   86: aload 7
    //   88: aload_1
    //   89: invokevirtual 618	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   92: astore 5
    //   94: aload 5
    //   96: aconst_null
    //   97: aload 6
    //   99: invokestatic 624	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   102: pop
    //   103: aload 5
    //   105: invokevirtual 629	java/io/InputStream:close	()V
    //   108: aload 6
    //   110: getfield 632	android/graphics/BitmapFactory$Options:outWidth	I
    //   113: istore_2
    //   114: aload 6
    //   116: getfield 635	android/graphics/BitmapFactory$Options:outHeight	I
    //   119: istore 4
    //   121: aload 6
    //   123: iconst_0
    //   124: putfield 612	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   127: iload_2
    //   128: iload 4
    //   130: imul
    //   131: ldc_w 636
    //   134: if_icmple +160 -> 294
    //   137: aload 6
    //   139: iload_2
    //   140: iload 4
    //   142: imul
    //   143: i2d
    //   144: invokestatic 642	java/lang/Math:sqrt	(D)D
    //   147: ldc2_w 643
    //   150: ddiv
    //   151: invokestatic 647	java/lang/Math:ceil	(D)D
    //   154: d2i
    //   155: putfield 650	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   158: aload 7
    //   160: aload_1
    //   161: invokevirtual 618	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   164: astore_1
    //   165: aload_1
    //   166: aconst_null
    //   167: aload 6
    //   169: invokestatic 624	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   172: astore 6
    //   174: aload_1
    //   175: invokevirtual 629	java/io/InputStream:close	()V
    //   178: aload 6
    //   180: invokevirtual 651	android/graphics/Bitmap:getWidth	()I
    //   183: istore_2
    //   184: aload 6
    //   186: invokevirtual 652	android/graphics/Bitmap:getHeight	()I
    //   189: istore 4
    //   191: iload_2
    //   192: iload 4
    //   194: imul
    //   195: newarray int
    //   197: astore 5
    //   199: aload 6
    //   201: aload 5
    //   203: iconst_0
    //   204: iload_2
    //   205: iconst_0
    //   206: iconst_0
    //   207: iload_2
    //   208: iload 4
    //   210: invokevirtual 656	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   213: aload 6
    //   215: invokevirtual 659	android/graphics/Bitmap:recycle	()V
    //   218: iload_2
    //   219: iload 4
    //   221: imul
    //   222: newarray byte
    //   224: astore 6
    //   226: aload 5
    //   228: aload 6
    //   230: iload_2
    //   231: iload 4
    //   233: invokestatic 664	com/tencent/imageboost/ImgProcessScan:a	([I[BII)I
    //   236: pop
    //   237: aload 6
    //   239: iload_2
    //   240: iload 4
    //   242: iconst_0
    //   243: invokestatic 667	com/tencent/qbar/QbarNativeImpl:a	([BIII)I
    //   246: istore_2
    //   247: invokestatic 669	com/tencent/qbar/QbarNativeImpl:a	()I
    //   250: pop
    //   251: iload_2
    //   252: iconst_1
    //   253: if_icmpne +138 -> 391
    //   256: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +13 -> 272
    //   262: ldc_w 671
    //   265: iconst_2
    //   266: ldc_w 673
    //   269: invokestatic 675	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: iconst_1
    //   273: ireturn
    //   274: astore_1
    //   275: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +14 -> 292
    //   281: ldc_w 671
    //   284: iconst_2
    //   285: aload_1
    //   286: invokevirtual 676	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   289: invokestatic 679	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: iconst_0
    //   293: ireturn
    //   294: aload 6
    //   296: iconst_1
    //   297: putfield 650	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   300: goto -142 -> 158
    //   303: astore_1
    //   304: iload_3
    //   305: istore_2
    //   306: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq -62 -> 247
    //   312: ldc_w 671
    //   315: iconst_2
    //   316: aload_1
    //   317: invokevirtual 680	java/io/IOException:toString	()Ljava/lang/String;
    //   320: invokestatic 679	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: iload_3
    //   324: istore_2
    //   325: goto -78 -> 247
    //   328: astore_1
    //   329: aload 5
    //   331: astore_1
    //   332: aload_1
    //   333: invokevirtual 629	java/io/InputStream:close	()V
    //   336: iconst_m1
    //   337: istore_2
    //   338: goto -91 -> 247
    //   341: astore_1
    //   342: iload_3
    //   343: istore_2
    //   344: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -100 -> 247
    //   350: ldc_w 671
    //   353: iconst_2
    //   354: aload_1
    //   355: invokevirtual 681	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   358: invokestatic 679	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: iload_3
    //   362: istore_2
    //   363: goto -116 -> 247
    //   366: astore_1
    //   367: iload_3
    //   368: istore_2
    //   369: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq -125 -> 247
    //   375: ldc_w 671
    //   378: iconst_2
    //   379: aload_1
    //   380: invokevirtual 676	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   383: invokestatic 679	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: iload_3
    //   387: istore_2
    //   388: goto -141 -> 247
    //   391: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +13 -> 407
    //   397: ldc_w 671
    //   400: iconst_2
    //   401: ldc_w 683
    //   404: invokestatic 675	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: iconst_0
    //   408: ireturn
    //   409: astore 5
    //   411: goto -79 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	TroopAvatarWallPreviewActivity
    //   0	414	1	paramFile	File
    //   113	275	2	n	int
    //   64	323	3	i1	int
    //   119	122	4	i2	int
    //   15	315	5	localObject1	Object
    //   409	1	5	localOutOfMemoryError	OutOfMemoryError
    //   78	217	6	localObject2	Object
    //   69	90	7	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   0	17	274	java/lang/UnsatisfiedLinkError
    //   27	36	274	java/lang/UnsatisfiedLinkError
    //   65	127	303	java/io/IOException
    //   137	158	303	java/io/IOException
    //   158	165	303	java/io/IOException
    //   165	247	303	java/io/IOException
    //   294	300	303	java/io/IOException
    //   332	336	303	java/io/IOException
    //   158	165	328	java/lang/OutOfMemoryError
    //   65	127	341	java/lang/RuntimeException
    //   137	158	341	java/lang/RuntimeException
    //   158	165	341	java/lang/RuntimeException
    //   165	247	341	java/lang/RuntimeException
    //   294	300	341	java/lang/RuntimeException
    //   332	336	341	java/lang/RuntimeException
    //   65	127	366	java/lang/UnsatisfiedLinkError
    //   137	158	366	java/lang/UnsatisfiedLinkError
    //   158	165	366	java/lang/UnsatisfiedLinkError
    //   165	247	366	java/lang/UnsatisfiedLinkError
    //   294	300	366	java/lang/UnsatisfiedLinkError
    //   332	336	366	java/lang/UnsatisfiedLinkError
    //   165	247	409	java/lang/OutOfMemoryError
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new aiwa(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void b(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    } while (isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private boolean b()
  {
    return ("2".equals(this.jdField_b_of_type_JavaLangString)) || ("4".equals(this.jdField_b_of_type_JavaLangString));
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
    {
      ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130844984);
      if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null) {
        a(true);
      }
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
      this.m = false;
      return;
    }
    ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130844985);
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null) {
      a(false);
    }
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.m = true;
  }
  
  private void c(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(getTitleBarHeight());
  }
  
  private void d()
  {
    Intent localIntent = new Intent("android.intent.action.WEBJSCALL");
    localIntent.putExtra("callback", "{op:3,index:" + this.jdField_a_of_type_Int + "}");
    sendBroadcast(localIntent);
  }
  
  private void d(int paramInt)
  {
    int n;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(QzoneContactsFeedUtils.a((String)localObject, this.app));
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        n = 8;
        localTextView.setVisibility(n);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ArrayOfBoolean != null) && (this.jdField_a_of_type_ArrayOfBoolean.length > paramInt)) {
        break label101;
      }
      return;
      n = 0;
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label101:
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (this.jdField_a_of_type_ArrayOfBoolean[paramInt] != 0) {}
    for (paramInt = 2130844990;; paramInt = 2130844993)
    {
      ((ImageView)localObject).setImageResource(paramInt);
      this.m = LocalMultiProcConfig.getBool("BasePictureViewController#mIsBottomBarUp", true);
      if (!this.m) {
        break;
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130844985);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130844984);
  }
  
  private void e()
  {
    Intent localIntent = new Intent("android.intent.action.WEBJSCALL");
    localIntent.putExtra("callback", "{op:1,index:" + this.jdField_a_of_type_Int + "}");
    sendBroadcast(localIntent);
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_e_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_e_of_type_JavaUtilArrayList.size()) && (!TextUtils.isEmpty((CharSequence)this.jdField_e_of_type_JavaUtilArrayList.get(paramInt))) && (AbsDownloader.a((String)this.jdField_e_of_type_JavaUtilArrayList.get(paramInt)) == null))
    {
      if ((this.jdField_f_of_type_JavaUtilArrayList != null) && (!TextUtils.isEmpty((CharSequence)this.jdField_f_of_type_JavaUtilArrayList.get(paramInt)))) {}
      for (;;)
      {
        try
        {
          paramInt = Integer.parseInt((String)this.jdField_f_of_type_JavaUtilArrayList.get(paramInt));
          l1 = paramInt;
          if (l1 <= 0L) {
            break label173;
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, getResources().getString(2131436112), new Object[] { FileUtil.a(l1) }));
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          LpReportInfo_pf00064.allReport(301, 34, 1);
          return;
        }
        catch (Exception localException)
        {
          QLog.e("TroopAvatarWallPreviewActivity", 2, "setOriginButton exception", localException);
        }
        long l1 = -1L;
        continue;
        label173:
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131436111);
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ArrayOfBoolean == null) || (this.jdField_a_of_type_ArrayOfBoolean.length <= this.jdField_a_of_type_Int)) {
      return;
    }
    Object localObject;
    int n;
    if (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844990);
      localObject = android.view.animation.AnimationUtils.loadAnimation(this, 2131034376);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
      localObject = this.jdField_a_of_type_ArrayOfBoolean;
      n = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] != 0) {
        break label153;
      }
    }
    label153:
    for (int i1 = 1;; i1 = 0)
    {
      localObject[n] = i1;
      localObject = new Intent("android.intent.action.WEBJSCALL");
      ((Intent)localObject).putExtra("callback", "{op:2,index:" + this.jdField_a_of_type_Int + "}");
      sendBroadcast((Intent)localObject);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844993);
      break;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      QQToast.a(this, getString(2131435548), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131435548), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131361846)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      QQToast.a(this, getString(2131435548), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      QQToast.a(this, getString(2131435548), 0).a();
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (this.jdField_e_of_type_Boolean)
    {
      localActionSheet.a(2131435871, 1);
      localActionSheet.a(2131435877, 1);
      if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
        ThreadManager.executeOnFileThread(new aiwy(this, (URLDrawable)localObject, localActionSheet));
      }
    }
    if ((this.jdField_a_of_type_Boolean) && (a(this.jdField_a_of_type_Int))) {
      localActionSheet.a(2131435885, 1);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      localActionSheet.a(2131430242, 5);
      localActionSheet.a(2131435885, 3);
    }
    localActionSheet.c(2131433015);
    localActionSheet.a(new aixa(this, localActionSheet, (URLDrawable)localObject));
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void h()
  {
    if ((this.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Int < this.jdField_e_of_type_JavaUtilArrayList.size()) && (!TextUtils.isEmpty((CharSequence)this.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int))))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.c(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_d_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.notifyDataSetChanged();
      LpReportInfo_pf00064.allReport(301, 34, 2);
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void j()
  {
    if ((getIntent() == null) || (getIntent().getExtras() == null)) {}
    Object localObject;
    String str1;
    String str2;
    String str3;
    do
    {
      do
      {
        return;
        localObject = getIntent().getExtras();
      } while (!this.k);
      str1 = ((Bundle)localObject).getString("article_id", "");
      str2 = ((Bundle)localObject).getString("to_uin", "");
      str3 = ((Bundle)localObject).getString("feeds_id", "");
      localObject = ((Bundle)localObject).getString("scroll_image_r5", "");
      PublicAccountReportUtils.a(null, "CliOper", "", str2, "0X800888B", "0X800888B", 0, 0, str3, str1, Integer.toString(this.jdField_a_of_type_Int + 1), (String)localObject, false);
    } while (!QLog.isColorLevel());
    QLog.d("TroopAvatarWallPreviewActivity", 2, new Object[] { "scroll Image report(in TroopAvatarWallPreviewActivity) toUin: ", str2, ", r2(feedsId): ", str3, ", r3(articleId): ", str1, " r4(imagePos): ", Integer.valueOf(this.jdField_a_of_type_Int + 1), ", r5: ", localObject });
  }
  
  private void k()
  {
    if ((getIntent() == null) || (getIntent().getExtras() == null)) {}
    Object localObject;
    String str1;
    String str2;
    String str3;
    do
    {
      do
      {
        return;
        localObject = getIntent().getExtras();
      } while (!this.k);
      str1 = ((Bundle)localObject).getString("to_uin", "");
      str2 = ((Bundle)localObject).getString("feeds_id", "");
      str3 = ((Bundle)localObject).getString("article_id", "");
      localObject = ((Bundle)localObject).getString("read_article_r5", "");
      PublicAccountReportUtils.a(null, "CliOper", "", str1, "0X80088A8", "0X80088A8", 0, 0, str2, str3, Integer.toString(this.jdField_a_of_type_Int + 1), (String)localObject, false);
    } while (!QLog.isColorLevel());
    QLog.d("TroopAvatarWallPreviewActivity", 2, new Object[] { "readArticle click report(in TroopAvatarWallPreviewActivity) toUin: ", str1, ", r2(feedsId): ", str2, ", r3(articleId): ", str3, " r4(imagePos): ", Integer.valueOf(this.jdField_a_of_type_Int + 1), ", r5: ", localObject });
  }
  
  Drawable a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      paramString = URLDrawable.getDrawable(NearbyImgDownloader.a(paramString));
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    BitmapFactory.Options localOptions = ImageUtil.a(paramString, 100);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return new BitmapDrawable(paramString);
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "getDrawable out off memory");
      }
      System.gc();
      return null;
    }
    return null;
  }
  
  public String a(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "picIndex" + this.jdField_a_of_type_Int + ",mSeqNumList.size()" + this.jdField_a_of_type_JavaUtilList.size());
      }
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      localObject = str;
    } while (!paramBoolean);
    if ((str != null) && (str.equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString))) {
      return AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString;
    }
    return AvatarTroopUtil.a(AvatarTroopUtil.a(str, this.jdField_a_of_type_JavaLangString, 1));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.leave_mode = 1;
    if ((!this.l) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      if ((this.jdField_d_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemId() != this.jdField_a_of_type_Int)) {
        break label61;
      }
      if (!a()) {
        b();
      }
    }
    return;
    label61:
    b();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(0) != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(0).equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString)))
    {
      a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() > 1)
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_b_of_type_JavaUtilList.add("" + paramInt);
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        getIntent().putStringArrayListExtra("del_list", (ArrayList)this.jdField_b_of_type_JavaUtilList);
        setResult(-1, getIntent());
      }
      finish();
      return;
    }
    QQToast.a(this, getString(2131430228), 1).b(getTitleBarHeight());
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (this.h) {
      ReportController.b(this.app, "dc00899", "Grp_talk", "", "obj", "aio_save", 0, 0, this.jdField_a_of_type_JavaLangString + "", "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    new File(AppConstants.aP).mkdirs();
    String str = AppConstants.aP + this.jdField_a_of_type_JavaLangString + Utils.Crc64String(paramURLDrawable.getURL().toString());
    File localFile = new File(str);
    if (!localFile.exists()) {}
    for (;;)
    {
      try
      {
        if (localFile.createNewFile()) {
          b(paramURLDrawable, localFile.getPath());
        }
        a("0X8006A82", "0X8006A96");
        return;
      }
      catch (IOException paramURLDrawable)
      {
        QQToast.a(this, getString(2131434583), 0).a();
        continue;
      }
      DialogUtil.a(this, 230).setTitle(getString(2131434586)).setMessage(getString(2131434588)).setPositiveButton(getString(2131434587), new aivz(this, paramURLDrawable, str)).setNegativeButton(getString(2131433012), new aixb(this)).show();
    }
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (this.h) {
      ReportController.b(this.app, "dc00899", "Grp_talk", "", "obj", "aio_repost", 0, 0, this.jdField_a_of_type_JavaLangString + "", "", "", "");
    }
    new aiwx(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    startActivity(localIntent);
  }
  
  public boolean a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (paramInt <= this.jdField_b_of_type_JavaUtilArrayList.size() - 1) && (this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("from_personality_label", false))) {
      return true;
    }
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList == null) || (paramInt > this.jdField_b_of_type_JavaUtilArrayList.size() - 1) || (paramInt > this.jdField_c_of_type_JavaUtilArrayList.size() - 1)) {
      return false;
    }
    return !TextUtils.isEmpty((String)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public String b(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "picIndex" + this.jdField_a_of_type_Int + ",mSeqNumList.size()" + this.jdField_a_of_type_JavaUtilList.size());
      }
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      localObject = str;
    } while (!paramBoolean);
    if ((str != null) && (str.equals(AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString))) {
      return AvatarWallAdapter.AvatarInfo.jdField_a_of_type_JavaLangString;
    }
    return AvatarTroopUtil.b(AvatarTroopUtil.a(str, this.jdField_a_of_type_JavaLangString, 1));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.l = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new aiwf(this));
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new aiwg(this);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    if ((this.j) && (this.jdField_d_of_type_AndroidViewView != null)) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1)) {}
    while ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList == null) || (paramInt > this.jdField_b_of_type_JavaUtilArrayList.size() - 1) || (paramInt > this.jdField_c_of_type_JavaUtilArrayList.size() - 1)) {
      return;
    }
    DialogUtil.a(this, 230).setTitle(getString(2131437168)).setPositiveButton(getString(2131433016), new aiwc(this, paramInt)).setNegativeButton(getString(2131433015), new aiwb(this)).show();
    a("0X8006A83", "");
  }
  
  public void c(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.getCount() - 1)) {
      return;
    }
    getIntent().putExtra("default_avator_index", paramInt);
    setResult(-1, getIntent());
    finish();
  }
  
  protected boolean doOnCreate(Bundle arg1)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(???);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (i)
      {
        super.finish();
        return false;
      }
      i = true;
      if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())))
      {
        finish();
        return false;
      }
    }
    setContentView(2130969029);
    ??? = getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.parse(???.getString("PublicAccountShowPictureReport"));
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport) {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.showStart();
    }
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131364796));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363632));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362840));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364799));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362745);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131364795));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131362740));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView = ((ImageAnimationView)findViewById(2131364797));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364798));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364803);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364800));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364801));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_d_of_type_Boolean = ???.getBoolean("IS_EDIT");
    label399:
    Object localObject2;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_f_of_type_Boolean = ???.getBoolean("SHOW_MENU");
      if (!this.jdField_f_of_type_Boolean) {
        break label1283;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837595);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_JavaUtilArrayList = ???.getParcelableArrayList("KEY_THUMBNAL_BOUND");
      this.jdField_e_of_type_Boolean = ???.getBoolean("is_show_action", true);
      this.jdField_b_of_type_Boolean = ???.getBoolean("needBottomBar");
      if (!this.jdField_b_of_type_Boolean) {
        break label1294;
      }
      localObject2 = ((ViewStub)findViewById(2131364802)).inflate();
      this.jdField_b_of_type_AndroidViewView = ((View)localObject2).findViewById(2131364658);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131364659));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131364660));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131364661));
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130846446);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130844984);
      localObject2 = new IntentFilter("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      label618:
      this.jdField_a_of_type_ArrayOfBoolean = ???.getBooleanArray("likes");
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter = new TroopAvatarBigPhotoAdapter(this, this.app);
      this.jdField_a_of_type_JavaLangString = ???.getString("troop_uin");
      this.jdField_c_of_type_Boolean = ???.getBoolean("troop_info_is_member");
      this.jdField_a_of_type_JavaUtilList = ???.getStringArrayList("seqNum");
      this.jdField_a_of_type_JavaUtilArrayList = ???.getStringArrayList("descs");
      this.jdField_b_of_type_JavaUtilArrayList = ???.getStringArrayList("photoIds");
      this.jdField_c_of_type_JavaUtilArrayList = ???.getStringArrayList("photoTimes");
      this.jdField_a_of_type_Boolean = ???.getBoolean("delete_ability");
      this.h = ???.getBoolean("is_from_troop_topic");
      this.g = ???.getBoolean("is_not_show_index", true);
      this.jdField_b_of_type_JavaLangString = ???.getString("src_id");
      this.jdField_a_of_type_AndroidOsBundle = ???.getBundle("bundle_data_extra");
      this.jdField_e_of_type_JavaUtilArrayList = ???.getStringArrayList("origin_list");
      this.jdField_f_of_type_JavaUtilArrayList = ???.getStringArrayList("origin_size_list");
      if (this.jdField_e_of_type_JavaUtilArrayList == null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_b_of_type_JavaLangString != null) {
        ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer", "open", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
      }
      if (!this.g) {
        break label1306;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      this.j = ???.getBoolean("is_show_content_url", false);
      this.k = ???.getBoolean("is_grid_image_report", false);
      if (this.j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopAvatarWallPreviewActivity", 2, "ReadInJoy Grid Images isShowContentUrl: true");
        }
        Object localObject3 = ???.getString("article_title", "");
        localObject2 = ???.getString("article_url", "");
        int n = ???.getInt("channel_id", 0);
        long l1 = ???.getLong("articleSeq", 0L);
        ArticleInfo localArticleInfo = ReadInJoyLogicEngine.a().a(n, l1);
        Object localObject4;
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidWidgetTextView.getParent() instanceof RelativeLayout)))
        {
          localObject4 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject4).addRule(10);
          ((RelativeLayout.LayoutParams)localObject4).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject4).setMargins(0, AIOUtils.a(20.0F, getResources()), 0, 0);
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_d_of_type_AndroidViewView = ((ViewStub)findViewById(2131364804)).inflate();
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          if ((this.jdField_d_of_type_AndroidViewView != null) && ((this.jdField_d_of_type_AndroidViewView instanceof LinearLayout)))
          {
            localObject4 = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131363378);
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              ((TextView)localObject4).setText((CharSequence)localObject3);
            }
            localObject3 = (Button)this.jdField_d_of_type_AndroidViewView.findViewById(2131364824);
            localObject4 = new GradientDrawable();
            ((GradientDrawable)localObject4).setStroke(AIOUtils.a(1.0F, getResources()), -1996488705);
            ((Button)localObject3).setBackgroundDrawable((Drawable)localObject4);
            ((Button)localObject3).setOnClickListener(new aivy(this, (String)localObject2, localArticleInfo));
          }
        }
      }
      ThreadManager.post(new aiwk(this, ???), 8, null, true);
      if (b())
      {
        this.jdField_a_of_type_Aixc = new aixc(this, new Handler());
        this.jdField_a_of_type_Aixc.a();
        if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", -1) == 1) {
          setRequestedOrientation(4);
        }
      }
      return true;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      break;
      label1283:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label399;
      label1294:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      break label618;
      label1306:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((???.getBoolean("is_index_show_bottom", false)) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidWidgetTextView.getParent() instanceof RelativeLayout)))
      {
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, 0);
        ((RelativeLayout.LayoutParams)localObject2).setMargins(0, AIOUtils.a(20.0F, getResources()), 0, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_b_of_type_Boolean) {
      LocalMultiProcConfig.putBool("BasePictureViewController#mIsBottomBarUp", this.m);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.showEnd();
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.report(this.app);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetGallery != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_Aixc != null) {
      this.jdField_a_of_type_Aixc.b();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      a(paramIntent.getExtras());
    }
    if ((paramInt1 == 10922) && (paramInt2 == -10069))
    {
      paramIntent = getIntent().getExtras().getString("article_url", "");
      ReadInJoyUtils.a(getActivity(), paramIntent);
      if (this.k) {
        k();
      }
    }
  }
  
  public void onBackPressed()
  {
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      i = false;
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelObserver);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((82 == paramKeyEvent.getKeyCode()) && (this.jdField_f_of_type_Boolean))
    {
      g();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  protected void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */