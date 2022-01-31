package com.tencent.mobileqq.troop.activity;

import abje;
import actj;
import agle;
import ajsd;
import ajya;
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
import android.os.Build.VERSION;
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
import android.view.animation.AnimationUtils;
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
import apvd;
import auuf;
import avnm;
import axqy;
import ayoi;
import ayst;
import azfb;
import azfc;
import azfd;
import azfe;
import azff;
import azfg;
import azfh;
import azfi;
import azfj;
import azfk;
import azfl;
import azfm;
import azfo;
import azfp;
import azfq;
import azfu;
import azfv;
import azfw;
import azfx;
import azfy;
import azfz;
import bahv;
import bapd;
import bbdj;
import bbef;
import bbgu;
import bcqf;
import bcql;
import bfpc;
import bfpp;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
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
import lze;
import nol;
import onh;
import org.json.JSONObject;
import osg;
import paf;
import rnu;
import shu;
import whj;
import xpu;

public class TroopAvatarWallPreviewActivity
  extends BaseActivity
{
  static Object jdField_a_of_type_JavaLangObject = new Object();
  static boolean h;
  public int a;
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new azfl(this);
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected View.OnClickListener a;
  protected View a;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  protected FrameLayout a;
  protected ImageButton a;
  public ImageView a;
  protected RelativeLayout a;
  public TextView a;
  public auuf a;
  private azfz jdField_a_of_type_Azfz;
  public bapd a;
  bcqf jdField_a_of_type_Bcqf;
  private PublicAccountShowPictureReport jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport = new PublicAccountShowPictureReport();
  public ImageAnimationView a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  public Gallery a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  public String a;
  protected ArrayList<String> a;
  public List<String> a;
  public boolean a;
  protected boolean[] a;
  public int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new azfw(this);
  public View b;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  protected ImageView b;
  protected RelativeLayout b;
  public TextView b;
  protected String b;
  public ArrayList<String> b;
  protected List<String> b;
  public boolean b;
  protected View c;
  protected ImageView c;
  protected TextView c;
  protected String c;
  public ArrayList<String> c;
  public boolean c;
  protected View d;
  protected TextView d;
  public String d;
  protected ArrayList<Rect> d;
  public boolean d;
  protected ArrayList<String> e;
  public boolean e;
  protected ArrayList<String> f;
  public boolean f;
  protected boolean g;
  protected boolean i;
  public boolean j;
  protected boolean k = true;
  public boolean l;
  public boolean m = false;
  private boolean n = true;
  
  public TroopAvatarWallPreviewActivity()
  {
    this.jdField_a_of_type_Long = 300L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new azfm(this);
    this.jdField_a_of_type_Auuf = new azfq(this);
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
    if (((String)localObject).equals(agle.jdField_a_of_type_JavaLangString)) {}
    for (Object localObject = paramDrawable; localObject == null; localObject = a(paramBoolean, (String)localObject)) {
      return null;
    }
    if ((paramDrawable == null) && ((!paramBoolean) || (localObject == null))) {
      return null;
    }
    int i5;
    int i6;
    int i1;
    label186:
    int i2;
    label197:
    int i4;
    label261:
    int i3;
    if (paramDrawable == null)
    {
      if ((TextUtils.isEmpty(str)) || (str.equals(agle.jdField_a_of_type_JavaLangString))) {
        return null;
      }
      paramDrawable = a(paramBoolean, str);
      if (paramDrawable == null) {
        return null;
      }
      ((URLDrawable)paramDrawable).setAutoDownload(true);
      i5 = this.jdField_a_of_type_ComTencentWidgetGallery.getWidth();
      i6 = this.jdField_a_of_type_ComTencentWidgetGallery.getHeight();
      if (((Drawable)localObject).getIntrinsicWidth() != 0) {
        break label430;
      }
      i1 = 1;
      if (((Drawable)localObject).getIntrinsicHeight() != 0) {
        break label440;
      }
      i2 = 1;
      localObject = xpu.a(this.jdField_a_of_type_ComTencentWidgetGallery);
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
      i4 = 1;
      if (paramDrawable.getIntrinsicHeight() != 0) {
        break label460;
      }
      i3 = 1;
    }
    for (;;)
    {
      float f1 = abje.a(i4, i3);
      paramRect1.set(abje.a(i1, i2, i4, i3));
      paramRect2.set(abje.b(i4, i3, i5, i6));
      paramRect4.set(abje.c(i4, i3, i5, i6));
      abje.a(paramRect1, f1);
      abje.a(paramRect2, f1);
      i1 = (int)(i4 * f1);
      i2 = (int)(i3 * f1);
      try
      {
        paramRect3 = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_4444);
        paramRect4 = new Canvas(paramRect3);
        localObject = new Rect(0, 0, i4, i3);
        abje.a((Rect)localObject, f1);
        paramDrawable.setBounds((Rect)localObject);
        paramRect4.clipRect(abje.a(paramRect1, paramRect2));
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
      i1 = ((Drawable)localObject).getIntrinsicWidth();
      break label186;
      label440:
      i2 = ((Drawable)localObject).getIntrinsicHeight();
      break label197;
      label450:
      i4 = paramDrawable.getIntrinsicWidth();
      break label261;
      label460:
      i3 = paramDrawable.getIntrinsicHeight();
      continue;
      label470:
      i3 = i2;
      i4 = i1;
    }
    label516:
    return null;
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_Bapd.getCount() - 1) || (this.jdField_b_of_type_JavaUtilArrayList == null) || (paramInt > this.jdField_b_of_type_JavaUtilArrayList.size() - 1)) {
      return;
    }
    axqy.b(this.app, "dc00898", "", "", "0X8007FD5", "0X8007FD5", 0, 0, "0", "0", "", "");
    bbdj.a(this, 230).setTitle(getString(2131699302)).setPositiveButton(getString(2131694794), new azfp(this, paramBundle, paramInt)).setNegativeButton(getString(2131690596), new azfo(this)).show();
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = actj.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport) || ("2".equals(this.jdField_b_of_type_JavaLangString)) || ("6".equals(this.jdField_b_of_type_JavaLangString)) || ("4".equals(this.jdField_b_of_type_JavaLangString))) {
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
    onh.a(this, paramArticleInfo);
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString)
  {
    rnu.b("fast_web_show_light_house_1");
    osg.a().a().a(paramString, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
    a(paramArticleInfo, null);
  }
  
  private void a(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bcqf == null) {
        this.jdField_a_of_type_Bcqf = new bcqf(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Bcqf.a(paramString);
    } while (isFinishing());
    this.jdField_a_of_type_Bcqf.show();
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_AndroidViewView.getHeight());
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new azfu(this));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidViewView.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new azfv(this));
  }
  
  private boolean a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((ImageView)((View)localObject1).findViewById(2131367776)).getDrawable();
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
    this.m = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a((Bitmap)localObject2, localRect3, localRect2, localRect1, (Rect)localObject1, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setAnimationListener(new azfi(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new TroopAvatarWallPreviewActivity.18(this), this.jdField_a_of_type_Long);
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setInterpolator(new DecelerateInterpolator());
    ((AlphaAnimation)localObject1).setDuration(500L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
    return true;
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new azff(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void b(String paramString)
  {
    bcql.a(BaseApplication.getContext(), paramString, 0).b(getTitleBarHeight());
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (getIntent().getBooleanExtra("from_photo_wall", false))
    {
      if (getIntent().getBooleanExtra("delete_ability", false)) {
        axqy.b(this.app, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    axqy.b(this.app, "CliOper", "", "", paramString2, paramString2, 0, 0, "", "", "", "");
  }
  
  private boolean b()
  {
    return ("2".equals(this.jdField_b_of_type_JavaLangString)) || ("4".equals(this.jdField_b_of_type_JavaLangString));
  }
  
  private void c()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.parse(localBundle.getString("PublicAccountShowPictureReport"));
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport) {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.showStart();
    }
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131366897));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377032));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375493));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363345));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362998);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131375496));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131364978));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView = ((ImageAnimationView)findViewById(2131362548));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362258));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131371125);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371137));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371639));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_d_of_type_Boolean = localBundle.getBoolean("IS_EDIT");
    label284:
    label332:
    Object localObject1;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_f_of_type_Boolean = localBundle.getBoolean("SHOW_MENU");
      if (!this.jdField_f_of_type_Boolean) {
        break label1402;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837738);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_JavaUtilArrayList = localBundle.getParcelableArrayList("KEY_THUMBNAL_BOUND");
      this.jdField_e_of_type_Boolean = localBundle.getBoolean("is_show_action", true);
      this.k = localBundle.getBoolean("is_need_to_aio", true);
      this.l = localBundle.getBoolean("is_from_plugin", false);
      this.jdField_b_of_type_Boolean = localBundle.getBoolean("needBottomBar");
      if (!this.jdField_b_of_type_Boolean) {
        break label1413;
      }
      localObject1 = ((ViewStub)findViewById(2131376614)).inflate();
      this.jdField_b_of_type_AndroidViewView = ((View)localObject1).findViewById(2131371107);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131371108));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131371105));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131371106));
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130841113);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130847655);
      localObject1 = new IntentFilter("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
      label580:
      this.jdField_a_of_type_ArrayOfBoolean = localBundle.getBooleanArray("likes");
      this.jdField_a_of_type_Bapd = new bapd(this, this.app);
      this.jdField_a_of_type_JavaLangString = localBundle.getString("troop_uin");
      this.jdField_c_of_type_Boolean = localBundle.getBoolean("troop_info_is_member");
      this.jdField_a_of_type_JavaUtilList = localBundle.getStringArrayList("seqNum");
      if ((QLog.isColorLevel()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "Clicl Big Data: first img url:" + (String)this.jdField_a_of_type_JavaUtilList.get(0));
      }
      this.jdField_a_of_type_JavaUtilArrayList = localBundle.getStringArrayList("descs");
      this.jdField_b_of_type_JavaUtilArrayList = localBundle.getStringArrayList("photoIds");
      this.jdField_c_of_type_JavaUtilArrayList = localBundle.getStringArrayList("photoTimes");
      this.jdField_a_of_type_Boolean = localBundle.getBoolean("delete_ability");
      this.g = localBundle.getBoolean("is_not_show_index", true);
      this.jdField_b_of_type_JavaLangString = localBundle.getString("src_id");
      this.jdField_a_of_type_AndroidOsBundle = localBundle.getBundle("bundle_data_extra");
      this.jdField_c_of_type_JavaLangString = localBundle.getString("str_data_extra", "");
      this.jdField_e_of_type_JavaUtilArrayList = localBundle.getStringArrayList("origin_list");
      this.jdField_f_of_type_JavaUtilArrayList = localBundle.getStringArrayList("origin_size_list");
      if (this.jdField_e_of_type_JavaUtilArrayList == null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_b_of_type_JavaLangString != null) {
        axqy.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer", "open", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
      }
      if (!this.g) {
        break label1425;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      this.i = localBundle.getBoolean("is_show_content_url", false);
      this.j = localBundle.getBoolean("is_grid_image_report", false);
      if (this.i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopAvatarWallPreviewActivity", 2, "ReadInJoy Grid Images isShowContentUrl: true");
        }
        Object localObject2 = localBundle.getString("article_title", "");
        localObject1 = localBundle.getString("article_url", "");
        int i1 = localBundle.getInt("channel_id", 0);
        long l1 = localBundle.getLong("articleSeq", 0L);
        ArticleInfo localArticleInfo = osg.a().a(i1, l1);
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidWidgetTextView.getParent() instanceof RelativeLayout)))
        {
          localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).addRule(10);
          ((RelativeLayout.LayoutParams)localObject3).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject3).setMargins(0, actj.a(20.0F, getResources()), 0, 0);
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        Object localObject3 = localBundle.getString("btntext", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.jdField_d_of_type_AndroidViewView = ((ViewStub)findViewById(2131376611)).inflate();
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          if ((this.jdField_d_of_type_AndroidViewView != null) && ((this.jdField_d_of_type_AndroidViewView instanceof LinearLayout)))
          {
            Object localObject4 = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131377350);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((TextView)localObject4).setText((CharSequence)localObject2);
            }
            localObject4 = (Button)this.jdField_d_of_type_AndroidViewView.findViewById(2131374722);
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              ((Button)localObject4).setText((CharSequence)localObject3);
            }
            QLog.d("TroopAvatarWallPreviewActivity", 1, "init,btnText:" + (String)localObject3 + " articleTitle:" + (String)localObject2 + " articleUrl:" + (String)localObject1);
            localObject2 = new GradientDrawable();
            ((GradientDrawable)localObject2).setStroke(actj.a(1.0F, getResources()), -1996488705);
            ((Button)localObject4).setBackgroundDrawable((Drawable)localObject2);
            ((Button)localObject4).setOnClickListener(new azfk(this, localArticleInfo, (String)localObject1));
          }
        }
      }
      ThreadManager.post(new TroopAvatarWallPreviewActivity.3(this, localBundle), 8, null, true);
      if (!b()) {
        break;
      }
      this.jdField_a_of_type_Azfz = new azfz(this, new Handler());
      this.jdField_a_of_type_Azfz.a();
      if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", -1) != 1) {
        break;
      }
      setRequestedOrientation(4);
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
      break label284;
      label1402:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label332;
      label1413:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      break label580;
      label1425:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((localBundle.getBoolean("is_index_show_bottom", false)) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidWidgetTextView.getParent() instanceof RelativeLayout)))
      {
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(10);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, actj.a(20.0F, getResources()), 0, 0);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  private void c(URLDrawable paramURLDrawable)
  {
    d(paramURLDrawable);
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
    {
      ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130847655);
      if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null) {
        a(true);
      }
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
      this.n = false;
      return;
    }
    ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130847656);
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null) {
      a(false);
    }
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.n = true;
  }
  
  private void d(int paramInt)
  {
    int i1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(avnm.a((String)localObject, this.app));
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        i1 = 8;
        localTextView.setVisibility(i1);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ArrayOfBoolean != null) && (this.jdField_a_of_type_ArrayOfBoolean.length > paramInt)) {
        break label101;
      }
      return;
      i1 = 0;
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label101:
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (this.jdField_a_of_type_ArrayOfBoolean[paramInt] != 0) {}
    for (paramInt = 2130847661;; paramInt = 2130847664)
    {
      ((ImageView)localObject).setImageResource(paramInt);
      this.n = LocalMultiProcConfig.getBool("BasePictureViewController#mIsBottomBarUp", true);
      if (!this.n) {
        break;
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130847656);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    ((ImageView)this.jdField_c_of_type_AndroidViewView).setImageResource(2130847655);
  }
  
  private void d(URLDrawable paramURLDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new azfc(this, paramURLDrawable), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      b(paramURLDrawable);
      return;
    }
    b(paramURLDrawable);
  }
  
  private void e()
  {
    Intent localIntent = new Intent("android.intent.action.WEBJSCALL");
    localIntent.putExtra("callback", "{op:3,index:" + this.jdField_a_of_type_Int + "}");
    sendBroadcast(localIntent);
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_e_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_e_of_type_JavaUtilArrayList.size()) && (!TextUtils.isEmpty((CharSequence)this.jdField_e_of_type_JavaUtilArrayList.get(paramInt))) && (ayoi.a((String)this.jdField_e_of_type_JavaUtilArrayList.get(paramInt)) == null))
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
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, getResources().getString(2131695342), new Object[] { apvd.a(l1) }));
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
        this.jdField_d_of_type_AndroidWidgetTextView.setText(2131695339);
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void f()
  {
    Intent localIntent = new Intent("android.intent.action.WEBJSCALL");
    localIntent.putExtra("callback", "{op:1,index:" + this.jdField_a_of_type_Int + "}");
    sendBroadcast(localIntent);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ArrayOfBoolean == null) || (this.jdField_a_of_type_ArrayOfBoolean.length <= this.jdField_a_of_type_Int)) {
      return;
    }
    Object localObject;
    int i1;
    if (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] == 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847661);
      localObject = AnimationUtils.loadAnimation(this, 2130772274);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
      localObject = this.jdField_a_of_type_ArrayOfBoolean;
      i1 = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] != 0) {
        break label153;
      }
    }
    label153:
    for (int i2 = 1;; i2 = 0)
    {
      localObject[i1] = i2;
      localObject = new Intent("android.intent.action.WEBJSCALL");
      ((Intent)localObject).putExtra("callback", "{op:2,index:" + this.jdField_a_of_type_Int + "}");
      sendBroadcast((Intent)localObject);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130847664);
      break;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131367776)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    if ("5".equals(this.jdField_b_of_type_JavaLangString))
    {
      a((URLDrawable)localObject);
      return;
    }
    bfpc localbfpc = (bfpc)bfpp.a(this, null);
    if (this.jdField_e_of_type_Boolean)
    {
      localbfpc.a(2131693384, 1);
      localbfpc.a(2131693394, 1);
      if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
        ThreadManagerV2.excute(new TroopAvatarWallPreviewActivity.8(this, (URLDrawable)localObject, localbfpc), 128, null, false);
      }
    }
    if ((this.jdField_a_of_type_Boolean) && (a(this.jdField_a_of_type_Int))) {
      localbfpc.a(2131693381, 1);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      localbfpc.a(2131698004, 5);
      localbfpc.a(2131693381, 3);
    }
    localbfpc.c(2131690596);
    localbfpc.a(new azfy(this, localbfpc, (URLDrawable)localObject));
    try
    {
      localbfpc.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void i()
  {
    if ((this.jdField_e_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Int < this.jdField_e_of_type_JavaUtilArrayList.size()) && (!TextUtils.isEmpty((CharSequence)this.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int))))
    {
      this.jdField_a_of_type_Bapd.c(true);
      this.jdField_a_of_type_Bapd.a(this.jdField_d_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_Bapd.notifyDataSetChanged();
      LpReportInfo_pf00064.allReport(301, 34, 2);
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
  }
  
  private void k()
  {
    if ((getIntent() == null) || (getIntent().getExtras() == null)) {}
    do
    {
      return;
      localObject = getIntent().getExtras();
    } while (!this.j);
    String str1 = ((Bundle)localObject).getString("article_id", "");
    String str2 = ((Bundle)localObject).getString("to_uin", "");
    String str3 = ((Bundle)localObject).getString("feeds_id", "");
    String str4 = ((Bundle)localObject).getString("scroll_image_r5", "");
    String str5 = ((Bundle)localObject).getString("strategy_id", "");
    if (shu.a(((Bundle)localObject).getLong("channel_id", 0L))) {}
    for (Object localObject = "0X8009364";; localObject = "0X800888B")
    {
      nol.a(null, "CliOper", "", str2, (String)localObject, (String)localObject, 0, 0, str3, str1, str5, str4, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAvatarWallPreviewActivity", 2, new Object[] { "scroll Image report(in TroopAvatarWallPreviewActivity) toUin: ", str2, ", r2(feedsId): ", str3, ", r3(articleId): ", str1, " r4(imagePos): ", Integer.valueOf(this.jdField_a_of_type_Int + 1), ", r5: ", str4 });
      return;
    }
  }
  
  private void l()
  {
    if ((getIntent() == null) || (getIntent().getExtras() == null)) {}
    do
    {
      return;
      localObject = getIntent().getExtras();
    } while (!this.j);
    String str1 = ((Bundle)localObject).getString("to_uin", "");
    String str2 = ((Bundle)localObject).getString("feeds_id", "");
    String str3 = ((Bundle)localObject).getString("article_id", "");
    String str4 = ((Bundle)localObject).getString("read_article_r5", "");
    String str5 = ((Bundle)localObject).getString("strategy_id", "");
    if (shu.a(((Bundle)localObject).getLong("channel_id", 0L))) {}
    for (Object localObject = "0X8009365";; localObject = "0X80088A8")
    {
      nol.a(null, "CliOper", "", str1, (String)localObject, (String)localObject, 0, 0, str2, str3, str5, str4, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAvatarWallPreviewActivity", 2, new Object[] { "readArticle click report(in TroopAvatarWallPreviewActivity) toUin: ", str1, ", r2(feedsId): ", str2, ", r3(articleId): ", str3, " r4(imagePos): ", Integer.valueOf(this.jdField_a_of_type_Int + 1), ", r5: ", str4 });
      return;
    }
  }
  
  Drawable a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      paramString = URLDrawable.getDrawable(ayst.a(paramString));
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    BitmapFactory.Options localOptions = bbef.a(paramString, 100);
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
    if ((str != null) && (str.equals(agle.jdField_a_of_type_JavaLangString))) {
      return agle.jdField_a_of_type_JavaLangString;
    }
    return bahv.a(bahv.a(str, this.jdField_a_of_type_JavaLangString, 1));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.leave_mode = 1;
    if ((!this.m) && (this.jdField_a_of_type_ComTencentWidgetGallery != null) && (!this.jdField_a_of_type_ComTencentWidgetGallery.a(false)))
    {
      if ((this.jdField_d_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemId() != this.jdField_a_of_type_Int)) {
        break label68;
      }
      if (!a()) {
        b();
      }
    }
    return;
    label68:
    b();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_Bapd.getCount() - 1)) {
      return;
    }
    if ((this.jdField_a_of_type_Bapd.getCount() == 2) && (this.jdField_a_of_type_Bapd.a(0) != null) && (this.jdField_a_of_type_Bapd.a(0).equals(agle.jdField_a_of_type_JavaLangString)))
    {
      a();
      return;
    }
    if (this.jdField_a_of_type_Bapd.getCount() > 1)
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
    bcql.a(this, getString(2131696375), 1).b(getTitleBarHeight());
  }
  
  protected void a(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAvatarWallPreviewActivity", 2, "showNearbyActionSheet: extra=" + this.jdField_c_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    do
    {
      return;
      try
      {
        Object localObject = new JSONObject(this.jdField_c_of_type_JavaLangString);
        ((JSONObject)localObject).optString("feedId");
        String str = ((JSONObject)localObject).optString("tinyId");
        ((JSONObject)localObject).optString("reason");
        localObject = ((JSONObject)localObject).optString("uin");
        bfpc localbfpc = (bfpc)bfpp.a(this, null);
        localbfpc.a(2131693394, 1);
        if (!this.app.getCurrentAccountUin().equals(localObject)) {
          localbfpc.a(ajya.a(2131715220), 0);
        }
        localbfpc.c(2131690596);
        localbfpc.a(new azfb(this, localbfpc, paramURLDrawable, str, (String)localObject));
        localbfpc.show();
        return;
      }
      catch (Exception paramURLDrawable) {}
    } while (!QLog.isColorLevel());
    QLog.w("TroopAvatarWallPreviewActivity", 2, "showNearbyActionSheet err:", paramURLDrawable);
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      axqy.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    new azfx(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString1);
    localIntent.putExtra("report_params", whj.a(null, paramString2, null, null, null, 7));
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
    if ((str != null) && (str.equals(agle.jdField_a_of_type_JavaLangString))) {
      return agle.jdField_a_of_type_JavaLangString;
    }
    return bahv.b(bahv.a(str, this.jdField_a_of_type_JavaLangString, 1));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.m = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    if (!"5".equals(this.jdField_b_of_type_JavaLangString)) {
      localAnimationSet.addAnimation(localScaleAnimation);
    }
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new azfj(this));
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new TroopAvatarWallPreviewActivity.20(this);
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    if ((this.i) && (this.jdField_d_of_type_AndroidViewView != null)) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_Bapd.getCount() - 1)) {}
    while ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList == null) || (paramInt > this.jdField_b_of_type_JavaUtilArrayList.size() - 1) || (paramInt > this.jdField_c_of_type_JavaUtilArrayList.size() - 1)) {
      return;
    }
    bbdj.a(this, 230).setTitle(getString(2131695495)).setPositiveButton(getString(2131694794), new azfh(this, paramInt)).setNegativeButton(getString(2131690596), new azfg(this)).show();
    b("0X8006A83", "");
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      axqy.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    new File(ajsd.bc).mkdirs();
    String str = ajsd.bc + this.jdField_a_of_type_JavaLangString + Utils.Crc64String(paramURLDrawable.getURL().toString());
    File localFile = new File(str);
    if (!localFile.exists()) {}
    for (;;)
    {
      try
      {
        if (localFile.createNewFile()) {
          b(paramURLDrawable, localFile.getPath());
        }
        b("0X8006A82", "0X8006A96");
        return;
      }
      catch (IOException paramURLDrawable)
      {
        bcql.a(this, getString(2131695190), 0).a();
        continue;
      }
      bbdj.a(this, 230).setTitle(getString(2131718848)).setMessage(getString(2131695183)).setPositiveButton(getString(2131718724), new azfe(this, paramURLDrawable, str)).setNegativeButton(getString(2131694648), new azfd(this)).show();
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_Bapd.getCount() - 1)) {
      return;
    }
    getIntent().putExtra("default_avator_index", paramInt);
    setResult(-1, getIntent());
    finish();
  }
  
  public boolean doOnCreate(Bundle arg1)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(???);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (h)
      {
        super.finish();
        return false;
      }
      h = true;
      if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())))
      {
        finish();
        return false;
      }
    }
    setContentView(2131559139);
    ThreadManager.post(new TroopAvatarWallPreviewActivity.1(this), 8, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_b_of_type_Boolean)
    {
      LocalMultiProcConfig.putBool("BasePictureViewController#mIsBottomBarUp", this.n);
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.showEnd();
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.report(this.app);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetGallery != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_Azfz != null) {
      this.jdField_a_of_type_Azfz.b();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21) && (this.k)) {
      a(paramIntent.getExtras());
    }
    if ((paramInt1 == 10922) && (paramInt2 == -10069))
    {
      paramIntent = getIntent().getExtras().getString("article_url", "");
      onh.a(getActivity(), paramIntent);
      if (this.j) {
        l();
      }
    }
  }
  
  public void onBackPressed()
  {
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      h = false;
      removeObserver(this.jdField_a_of_type_Auuf);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((82 == paramKeyEvent.getKeyCode()) && (this.jdField_f_of_type_Boolean))
    {
      h();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    lze.a(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    lze.a(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */