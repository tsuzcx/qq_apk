package com.tencent.mobileqq.nearby.profilecard;

import Override;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import anrz;
import ansd;
import anvi;
import anvk;
import anvx;
import anwo;
import aqeh;
import aqej;
import aqeq;
import auvj;
import avzm;
import axnu;
import axny;
import axpb;
import axpp;
import axqc;
import axqt;
import axqx;
import aydr;
import ayds;
import aydt;
import aydu;
import aydw;
import aydx;
import aydy;
import aydz;
import ayea;
import ayeb;
import ayec;
import ayed;
import ayee;
import ayef;
import ayeg;
import ayeh;
import ayej;
import ayek;
import ayfx;
import ayhc;
import ayhd;
import ayih;
import aynh;
import aynn;
import aynv;
import bbvn;
import bdla;
import bdmb;
import bdmc;
import bhbx;
import bhdj;
import bisl;
import bkxz;
import bkye;
import bkzi;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyPeopleProfileActivity
  extends FragmentActivity
{
  public static int a;
  public static HashMap<String, Integer> a;
  public static int b;
  public static int c;
  public static int m;
  public float a;
  public long a;
  public Dialog a;
  public Intent a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public anrz a;
  public ansd a;
  protected anvi a;
  anwo jdField_a_of_type_Anwo = new aydt(this);
  private aqeh jdField_a_of_type_Aqeh;
  protected aqej a;
  private aqeq jdField_a_of_type_Aqeq;
  auvj jdField_a_of_type_Auvj = new ayeb(this);
  public axqt a;
  public axqx a;
  private ayej jdField_a_of_type_Ayej;
  private ayhc jdField_a_of_type_Ayhc;
  public bbvn a;
  bisl jdField_a_of_type_Bisl;
  public URLDrawable a;
  public ProfileActivity.AllInOne a;
  public TopGestureLayout a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  PicInfo jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
  private NearbyPeopleProfileActivity.DownloadHDAvatarRunnable jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$DownloadHDAvatarRunnable;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public String a;
  public ArrayList<PicInfo> a;
  public boolean a;
  private long jdField_b_of_type_Long;
  public Dialog b;
  private View jdField_b_of_type_AndroidViewView;
  protected ansd b;
  public String b;
  ArrayList<PicInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  public boolean b;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public int j;
  public boolean j;
  public int k;
  boolean k;
  public int l;
  public boolean l;
  public boolean m;
  public int n;
  public boolean n;
  public int o;
  public volatile boolean o;
  private int p;
  public boolean p;
  private int q;
  public boolean q;
  private int r;
  public boolean r;
  boolean s = false;
  public boolean t = false;
  boolean u = false;
  private boolean v;
  private boolean w;
  private boolean x;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Int = 18;
    jdField_b_of_type_Int = 12;
    jdField_c_of_type_Int = jdField_b_of_type_Int;
  }
  
  public NearbyPeopleProfileActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = -1;
    this.jdField_n_of_type_Int = 18;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new ayec(this);
    this.jdField_a_of_type_AndroidAppDialog = null;
    this.jdField_b_of_type_AndroidAppDialog = null;
    this.jdField_a_of_type_Anvi = new ayds(this);
    this.jdField_a_of_type_Axqx = new aydu(this);
    this.jdField_a_of_type_Aqej = new aydx(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
    this.jdField_a_of_type_Ansd = new aydy(this);
    this.jdField_b_of_type_Ansd = new aydz(this);
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle)
  {
    a(paramContext, paramAllInOne, paramBundle, 6);
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("frome_where", paramInt);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 22) {}
    while ((paramInt >= 7) && (paramInt <= 12) && (paramInt != 11)) {
      return true;
    }
    return false;
  }
  
  private void k()
  {
    bdla.b(this.app, "dc00899", "grp_lbs", "", "data_card", "up_pho", 0, 0, "", "", "", "");
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 11;
    case 10: 
      return 1;
    case 5: 
      return 3;
    case 32: 
    case 34: 
    case 35: 
      return 4;
    case 20: 
    case 31: 
    case 33: 
      return 5;
    case 21: 
      return 6;
    case 99: 
      return 13;
    }
    return 14;
  }
  
  public ayej a(int paramInt)
  {
    if (a(paramInt)) {
      return new ayfx(this);
    }
    return new ayek(this);
  }
  
  public ayhc a(int paramInt)
  {
    if (a(paramInt)) {
      return new ayih(this);
    }
    return new ayhd(this);
  }
  
  public void a()
  {
    ThreadManager.post(new NearbyPeopleProfileActivity.3(this), 8, null, false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 0, getString(paramInt), 2131698641, 2131698640, new ayed(this), new ayee(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void a(int paramInt, Rect paramRect)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("showBigPhoto, currentPosition = ").append(paramInt).append(", rect = ").append(paramRect).append(", mPicInfo.size = ");
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          break label84;
        }
      }
      label84:
      for (paramRect = "null";; paramRect = Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        QLog.e("Q.nearby_people_card.", 2, paramRect);
        return;
      }
    }
    Object localObject = new Intent(this, NearbyProfilePicBrowserActivity.class);
    ((Intent)localObject).putExtra("intent_param_index", paramInt);
    ((Intent)localObject).putExtra("intent_param_pic_infos", this.jdField_a_of_type_JavaUtilArrayList);
    ((Intent)localObject).putExtra("report_visited_pic", true);
    ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", paramRect);
    ((Intent)localObject).addFlags(536870912);
    startActivity((Intent)localObject);
  }
  
  public void a(int paramInt, Rect paramRect, ArrayList<PicInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("showBigPhotoWithDelAndSetHeadView, currentPosition = ").append(paramInt).append(", rect = ").append(paramRect).append(", picInfos.size = ");
        if (paramArrayList != null) {
          break label77;
        }
      }
      label77:
      for (paramRect = "null";; paramRect = Integer.valueOf(paramArrayList.size()))
      {
        QLog.e("Q.nearby_people_card.", 2, paramRect);
        return;
      }
    }
    Object localObject = new Intent(this, NearbyProfilePicBrowserActivity.class);
    ((Intent)localObject).putExtra("intent_param_index", paramInt);
    ((Intent)localObject).putExtra("intent_param_pic_infos", paramArrayList);
    ((Intent)localObject).putExtra("report_visited_pic", true);
    ((Intent)localObject).putExtra("intent_param_show_del_pic_and_set_head", true);
    ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", paramRect);
    ((Intent)localObject).addFlags(536870912);
    startActivityForResult((Intent)localObject, 14);
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(this.jdField_p_of_type_Int);
  }
  
  public void a(long paramLong)
  {
    a(paramLong, -1, -1);
  }
  
  void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = 1;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(paramLong);
    localAlphaAnimation.setAnimationListener(new ayeh(this));
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    try
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
      label65:
      if (this.jdField_a_of_type_Ayhc != null) {
        this.jdField_a_of_type_Ayhc.a();
      }
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Ayhc = null;
      this.jdField_a_of_type_Ayhc = a(this.jdField_j_of_type_Int);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Ayhc.a();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-1, -1));
      BounceScrollView localBounceScrollView = (BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366006);
      localBounceScrollView.post(new NearbyPeopleProfileActivity.10(this, localBounceScrollView, this.jdField_b_of_type_AndroidViewView.findViewById(2131363760).getScrollY()));
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      g();
      return;
    }
    catch (Exception localException)
    {
      break label65;
    }
  }
  
  public void a(ImageView paramImageView, Drawable paramDrawable)
  {
    if (isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "showVoteUpdateDialog invoke, but activity is finishing");
      }
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
    paramDrawable = (axpb)this.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, UIUtils.dip2px(this, 150.0F));
    new aynn(this).a(paramImageView, localLayoutParams).a(anvx.a(2131706711)).b(paramDrawable.a()).a(new aynh(anvx.a(2131706706), new aydw(this))).show();
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    paramDrawable.a();
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.jdField_e_of_type_Int != 1))
    {
      this.jdField_a_of_type_Ayej.b(paramNearbyPeopleCard);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vTempChatSig != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vTempChatSig;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_JavaLangString != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_b_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
    {
      jdField_c_of_type_Int = jdField_a_of_type_Int;
      label118:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
          break label370;
        }
        bdla.b(this.app, "CliOper", "", "", "0X8005286", "0X8005286", 0, 0, "", "", "", "");
      }
      label174:
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.isEmpty())) {
        break label420;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList);
      this.jdField_h_of_type_Boolean = true;
      label237:
      if (this.jdField_e_of_type_Int == 3)
      {
        if (!bhbx.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getSafetyUin())) {
          break label452;
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("param_mode", 2);
        this.jdField_e_of_type_Int = 2;
      }
      label282:
      if (this.jdField_e_of_type_Int != 1) {
        break label501;
      }
      this.jdField_a_of_type_Ayhc.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      label301:
      if ((this.s) || (this.jdField_e_of_type_Int == 1) || (this.jdField_g_of_type_Boolean)) {
        break label513;
      }
      this.s = true;
      if (!a(this.jdField_j_of_type_Int)) {
        break label515;
      }
    }
    label513:
    label515:
    for (int i1 = 510;; i1 = 509)
    {
      this.jdField_a_of_type_Axqt.a(0L, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId, i1);
      return;
      jdField_c_of_type_Int = jdField_b_of_type_Int;
      break label118;
      label370:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label174;
      }
      bdla.b(this.app, "CliOper", "", "", "0X8005287", "0X8005287", 0, 0, "", "", "", "");
      break label174;
      label420:
      if (1 == this.jdField_e_of_type_Int) {
        break label237;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "onNearbyCardDownload need to getQzoneCover.");
      }
      this.jdField_h_of_type_Boolean = false;
      break label237;
      label452:
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getSafetyUin())) {
        break label282;
      }
      paramNearbyPeopleCard = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramNearbyPeopleCard == null) {
        break label282;
      }
      this.jdField_g_of_type_Boolean = paramNearbyPeopleCard.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getSafetyUin());
      break label282;
      label501:
      this.jdField_a_of_type_Ayej.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      break label301;
      break;
    }
  }
  
  public void a(PicInfo paramPicInfo, Rect paramRect)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPicInfo);
    paramPicInfo = new Intent(this, NearbyProfilePicBrowserActivity.class);
    paramPicInfo.putExtra("intent_param_index", 0);
    paramPicInfo.putExtra("intent_param_pic_infos", localArrayList);
    paramPicInfo.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    paramPicInfo.addFlags(536870912);
    startActivity(paramPicInfo);
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bisl == null) {
        this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Bisl.a(paramString);
    } while (isFinishing());
    this.jdField_a_of_type_Bisl.show();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (this.u)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "downloadHDAvatar is updated HDAvatar true");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$DownloadHDAvatarRunnable = new NearbyPeopleProfileActivity.DownloadHDAvatarRunnable(this, paramString1, paramInt, paramString2, paramBoolean);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$DownloadHDAvatarRunnable, 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      View localView = getWindow().getDecorView();
      if ((localView != null) && ((localView instanceof ViewGroup)))
      {
        localView = ((ViewGroup)localView).getChildAt(0);
        if ((localView != null) && ((localView instanceof TopGestureLayout))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localView);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "editNearbyProfileCardResult() called with: isSuccess = [" + paramBoolean1 + "], card = [" + paramNearbyPeopleCard + "], isHeadChanged = [" + paramBoolean2 + "], errorTips = [" + paramString + "]");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "editNearbyProfileCardResult|[" + paramBoolean1 + "," + paramNearbyPeopleCard + "]");
    }
    b();
    if ((paramBoolean1) && (paramNearbyPeopleCard != null))
    {
      this.jdField_c_of_type_Boolean = false;
      a(2, anvx.a(2131706710));
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, paramNearbyPeopleCard.college))
      {
        axqc.a(this.app.getCurrentAccountUin(), "school_name", paramNearbyPeopleCard.college);
        axqc.a(this.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(this.o));
      }
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag = false;
        this.jdField_d_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList);
        this.jdField_h_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo;
      if (paramBoolean2) {
        axny.a(this.app);
      }
      if (this.jdField_i_of_type_Int != 1) {
        f();
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      if (this.jdField_a_of_type_Ayej != null) {
        this.jdField_a_of_type_Ayej.j();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("param_mode", 2);
      e();
      ThreadManager.post(new NearbyPeopleProfileActivity.22(this), 5, null, true);
      paramNearbyPeopleCard = new Intent();
      paramNearbyPeopleCard.putExtra("param_xuan_yan", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      paramNearbyPeopleCard.putExtra("param_nickname", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      paramNearbyPeopleCard.putExtra("param_gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      paramNearbyPeopleCard.putExtra("param_age", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age);
      paramNearbyPeopleCard.putExtra("param_career", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job);
      paramNearbyPeopleCard.putExtra("param_constellation", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation);
      paramNearbyPeopleCard.putExtra("param_marital_status", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus);
      paramNearbyPeopleCard.putExtra("param_god_flag", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag);
      int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      paramNearbyPeopleCard.putExtra("param_photo_count", i1);
      int i2 = ((Integer)axqc.a(this.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      bdla.b(this.app, "dc00899", "grp_lbs", "", "data_card", "upload_suc", 0, 0, i1 + "", i2 + "", "", "");
      setResult(-1, paramNearbyPeopleCard);
      if (this.jdField_a_of_type_Boolean)
      {
        c(true);
        finish();
      }
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      a(1, anvx.a(2131706707));
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      return;
      a(1, paramString);
    }
  }
  
  public boolean a(PicInfo paramPicInfo1, PicInfo paramPicInfo2)
  {
    if ((paramPicInfo1 == null) || (paramPicInfo2 == null)) {}
    while (paramPicInfo1.jdField_a_of_type_Int != paramPicInfo2.jdField_a_of_type_Int) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void b(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(this.jdField_p_of_type_Int);
  }
  
  public void b(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.NearbyJsInterface");
    localIntent.putExtra("command_type", 3);
    localIntent.putExtra("exit_mode", this.jdField_e_of_type_Int);
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      localIntent.putExtra("exit_action", i1);
      sendBroadcast(localIntent);
      return;
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidAppDialog = bhdj.a(this, 2131698645, getString(2131698644), 2131690697, 2131698643, new ayef(this), new ayeg(this));
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.app != null)) {
      ThreadManager.post(new NearbyPeopleProfileActivity.20(this, paramString), 5, null, true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("isSuccess", paramBoolean);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("*.qq.com");
        avzm.a("nearbyUserSummaryInfoChange", localJSONObject, localArrayList, null);
        return;
      }
      catch (JSONException localJSONException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, localJSONException.toString());
  }
  
  public void d()
  {
    bkxz.a(this);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Ayej != null) {
      this.jdField_a_of_type_Ayej.j();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_Axqt.a(new ArrayList());
    }
    int i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0);
    if (i1 == 1)
    {
      bdla.b(this.app, "CliOper", "", "", "0X8004A1B", "0X8004A1B", 0, 0, "", "", "", "");
      if (this.jdField_n_of_type_Boolean)
      {
        if (this.m)
        {
          Intent localIntent = new Intent(this, NearbyActivity.class);
          localIntent.putExtra("abp_flag", this.m);
          localIntent.setFlags(67108864);
          startActivity(localIntent);
        }
        finish();
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      c(false);
      return;
      d(false);
      continue;
      if ((i1 == 2) && (this.jdField_e_of_type_Int == 1)) {
        e();
      }
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      f();
    }
    bdla.b(this.app, "CliOper", "", "", "0X8004A1C", "0X8004A1C", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_no_miss", false)) {
      bdla.b(this.app, "CliOper", "", "", "0X8004A1D", "0X8004A1D", 0, 0, "", "", "", "");
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 14)
    {
      this.jdField_a_of_type_Ayhc.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (this.jdField_e_of_type_Int == 1)
    {
      this.jdField_a_of_type_Ayhc.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.jdField_a_of_type_Ayej.a(paramInt1, paramInt2, paramIntent);
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 980	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   4: ldc_w 982
    //   7: iconst_0
    //   8: invokevirtual 226	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11: pop
    //   12: aload_0
    //   13: invokevirtual 980	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   16: ldc_w 984
    //   19: invokevirtual 988	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 665	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +17 -> 42
    //   28: aload_0
    //   29: invokevirtual 980	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   32: ldc_w 984
    //   35: ldc_w 990
    //   38: invokevirtual 798	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   41: pop
    //   42: getstatic 995	bkye:a	Lbkye;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +20 -> 67
    //   50: aload_3
    //   51: invokevirtual 997	bkye:a	()Z
    //   54: ifeq +13 -> 67
    //   57: aload_3
    //   58: iconst_0
    //   59: invokevirtual 999	bkye:b	(I)V
    //   62: aload_3
    //   63: iconst_1
    //   64: invokevirtual 1001	bkye:a	(I)V
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 1004	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mActNeedImmersive	Z
    //   72: aload_0
    //   73: iconst_1
    //   74: putfield 1007	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mNeedStatusTrans	Z
    //   77: aload_1
    //   78: ifnull +11 -> 89
    //   81: aload_1
    //   82: ldc_w 1009
    //   85: aconst_null
    //   86: invokevirtual 1015	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   89: aload_0
    //   90: aload_1
    //   91: invokespecial 1017	android/support/v4/app/FragmentActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   94: pop
    //   95: aload_0
    //   96: getfield 266	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   99: aload_0
    //   100: getfield 142	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Axqx	Laxqx;
    //   103: invokevirtual 1021	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   106: aload_0
    //   107: aload_0
    //   108: invokevirtual 980	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   111: putfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   114: aload_0
    //   115: getfield 266	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   118: invokevirtual 1024	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   121: ifeq +10 -> 131
    //   124: aload_0
    //   125: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   128: ifnonnull +9 -> 137
    //   131: aload_0
    //   132: invokevirtual 848	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   135: iconst_0
    //   136: ireturn
    //   137: aload_0
    //   138: ldc_w 1025
    //   141: invokespecial 1028	android/support/v4/app/FragmentActivity:setContentView	(I)V
    //   144: aload_0
    //   145: invokevirtual 711	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getWindow	()Landroid/view/Window;
    //   148: aconst_null
    //   149: invokevirtual 1031	android/view/Window:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   152: aload_0
    //   153: aload_0
    //   154: invokevirtual 1035	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   157: invokevirtual 1041	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   160: getfield 1046	android/util/DisplayMetrics:density	F
    //   163: putfield 1048	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Float	F
    //   166: aload_0
    //   167: aload_0
    //   168: invokevirtual 688	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getTitleBarHeight	()I
    //   171: putfield 413	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_p_of_type_Int	I
    //   174: aload_0
    //   175: aload_0
    //   176: invokevirtual 1035	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   179: invokevirtual 1041	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   182: getfield 1051	android/util/DisplayMetrics:widthPixels	I
    //   185: iconst_3
    //   186: idiv
    //   187: putfield 1053	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_f_of_type_Int	I
    //   190: aload_0
    //   191: aload_0
    //   192: invokevirtual 1035	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   195: invokevirtual 1041	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   198: getfield 1051	android/util/DisplayMetrics:widthPixels	I
    //   201: putfield 1055	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_g_of_type_Int	I
    //   204: aload_0
    //   205: aload_0
    //   206: getfield 266	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   209: getstatic 1060	com/tencent/mobileqq/app/BusinessHandlerFactory:NEARBY_CARD_HANDLER	I
    //   212: invokevirtual 1064	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   215: checkcast 653	axqt
    //   218: putfield 648	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Axqt	Laxqt;
    //   221: aload_0
    //   222: aload_0
    //   223: getfield 266	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   226: getstatic 1067	com/tencent/mobileqq/app/QQManagerFactory:STATUS_MANAGER	I
    //   229: invokevirtual 515	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   232: checkcast 1069	bbvn
    //   235: putfield 1071	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Bbvn	Lbbvn;
    //   238: aload_0
    //   239: aload_0
    //   240: getfield 266	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: getstatic 1074	com/tencent/mobileqq/app/QQManagerFactory:CONDITION_SEARCH_MANAGER	I
    //   246: invokevirtual 515	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   249: checkcast 1076	anrz
    //   252: putfield 1078	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Anrz	Lanrz;
    //   255: aload_0
    //   256: getfield 1078	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Anrz	Lanrz;
    //   259: aload_0
    //   260: invokevirtual 1081	anrz:a	(Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 1078	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Anrz	Lanrz;
    //   267: aload_0
    //   268: getfield 166	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Ansd	Lansd;
    //   271: invokevirtual 1083	anrz:c	(Ljava/lang/Object;)V
    //   274: aload_0
    //   275: aload_0
    //   276: getfield 266	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   279: getstatic 1086	com/tencent/mobileqq/app/QQManagerFactory:DYNAMIC_AVATAR_MANAGER	I
    //   282: invokevirtual 515	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   285: checkcast 1088	aqeq
    //   288: putfield 1090	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Aqeq	Laqeq;
    //   291: aload_0
    //   292: aload_0
    //   293: getfield 1090	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Aqeq	Laqeq;
    //   296: invokevirtual 1093	aqeq:a	()Laqeh;
    //   299: putfield 189	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Aqeh	Laqeh;
    //   302: aload_0
    //   303: aload_0
    //   304: getfield 1090	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Aqeq	Laqeq;
    //   307: iconst_4
    //   308: invokevirtual 1094	aqeq:a	(I)Z
    //   311: putfield 1096	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_p_of_type_Boolean	Z
    //   314: aload_0
    //   315: getfield 1090	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Aqeq	Laqeq;
    //   318: invokevirtual 1099	aqeq:a	()Laqeg;
    //   321: ifnull +39 -> 360
    //   324: aload_0
    //   325: aload_0
    //   326: getfield 1090	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Aqeq	Laqeq;
    //   329: invokevirtual 1099	aqeq:a	()Laqeg;
    //   332: getfield 1103	aqeg:jdField_d_of_type_Int	I
    //   335: putfield 110	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   338: aload_0
    //   339: getfield 110	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   342: iflt +12 -> 354
    //   345: aload_0
    //   346: getfield 110	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   349: bipush 30
    //   351: if_icmple +9 -> 360
    //   354: aload_0
    //   355: bipush 18
    //   357: putfield 110	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   360: aload_0
    //   361: aload_0
    //   362: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   365: ldc 213
    //   367: invokevirtual 1107	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   370: checkcast 579	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   373: putfield 572	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   376: aload_0
    //   377: getfield 572	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   380: ifnonnull +72 -> 452
    //   383: invokestatic 246	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +13 -> 399
    //   389: ldc_w 360
    //   392: iconst_2
    //   393: ldc_w 1109
    //   396: invokestatic 746	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: aload_0
    //   400: invokevirtual 848	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   403: iconst_1
    //   404: ireturn
    //   405: astore_1
    //   406: aload_0
    //   407: invokevirtual 848	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   410: iconst_0
    //   411: ireturn
    //   412: astore_1
    //   413: invokestatic 246	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   416: ifeq -40 -> 376
    //   419: ldc_w 360
    //   422: iconst_2
    //   423: new 339	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   430: ldc_w 1111
    //   433: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload_1
    //   437: invokevirtual 1114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   440: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 746	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: goto -73 -> 376
    //   452: aload_0
    //   453: aload_0
    //   454: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   457: ldc 223
    //   459: iconst_0
    //   460: invokevirtual 925	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   463: putfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   466: aload_0
    //   467: getfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   470: bipush 35
    //   472: if_icmpne +9 -> 481
    //   475: aload_0
    //   476: iconst_0
    //   477: iconst_1
    //   478: invokestatic 1120	com/tencent/mobileqq/utils/AlbumUtil:anim	(Landroid/app/Activity;ZZ)V
    //   481: aload_0
    //   482: getfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   485: invokestatic 285	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Z
    //   488: ifeq +369 -> 857
    //   491: aload_0
    //   492: bipush 51
    //   494: putfield 1121	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_d_of_type_Int	I
    //   497: aload_0
    //   498: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   501: ldc_w 644
    //   504: iconst_0
    //   505: invokevirtual 925	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   508: istore_2
    //   509: iload_2
    //   510: iconst_2
    //   511: if_icmpeq +8 -> 519
    //   514: iload_2
    //   515: iconst_1
    //   516: if_icmpne +30 -> 546
    //   519: aload_0
    //   520: getfield 572	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   523: getfield 581	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   526: invokestatic 665	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   529: ifeq +17 -> 546
    //   532: aload_0
    //   533: getfield 572	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   536: aload_0
    //   537: getfield 266	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   540: invokevirtual 1124	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   543: putfield 581	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   546: aload_0
    //   547: aload_0
    //   548: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   551: ldc_w 644
    //   554: iconst_0
    //   555: invokevirtual 925	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   558: putfield 422	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_Int	I
    //   561: aload_0
    //   562: aload_0
    //   563: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   566: ldc_w 1126
    //   569: iconst_0
    //   570: invokevirtual 949	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   573: putfield 98	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Boolean	Z
    //   576: aload_0
    //   577: aload_0
    //   578: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   581: ldc_w 1128
    //   584: lconst_0
    //   585: invokevirtual 1132	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   588: putfield 1134	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Long	J
    //   591: aload_0
    //   592: aload_0
    //   593: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   596: ldc_w 1136
    //   599: lconst_0
    //   600: invokevirtual 1132	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   603: putfield 179	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Long	J
    //   606: aload_0
    //   607: aload_0
    //   608: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   611: ldc_w 1138
    //   614: iconst_0
    //   615: invokevirtual 925	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   618: putfield 176	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:r	I
    //   621: aload_0
    //   622: aload_0
    //   623: ldc_w 1139
    //   626: invokevirtual 1140	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:findViewById	(I)Landroid/view/View;
    //   629: checkcast 446	android/view/ViewGroup
    //   632: putfield 186	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   635: aload_0
    //   636: getfield 422	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_Int	I
    //   639: iconst_1
    //   640: if_icmpne +246 -> 886
    //   643: aload_0
    //   644: aload_0
    //   645: aload_0
    //   646: getfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   649: invokevirtual 456	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Layhc;
    //   652: putfield 196	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Ayhc	Layhc;
    //   655: aload_0
    //   656: aload_0
    //   657: getfield 196	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Ayhc	Layhc;
    //   660: invokevirtual 459	ayhc:a	()Landroid/view/View;
    //   663: putfield 182	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   666: aload_0
    //   667: getfield 186	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   670: aload_0
    //   671: getfield 182	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   674: new 461	android/widget/FrameLayout$LayoutParams
    //   677: dup
    //   678: iconst_m1
    //   679: iconst_m1
    //   680: invokespecial 464	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   683: invokevirtual 468	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   686: aload_0
    //   687: aload_0
    //   688: getfield 106	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_k_of_type_Int	I
    //   691: iconst_1
    //   692: iadd
    //   693: putfield 106	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_k_of_type_Int	I
    //   696: aload_0
    //   697: iconst_1
    //   698: putfield 843	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Boolean	Z
    //   701: aload_0
    //   702: getfield 189	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Aqeh	Laqeh;
    //   705: ifnull +14 -> 719
    //   708: aload_0
    //   709: getfield 189	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Aqeh	Laqeh;
    //   712: aload_0
    //   713: getfield 147	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Aqej	Laqej;
    //   716: invokevirtual 1145	aqeh:a	(Laqej;)V
    //   719: aload_0
    //   720: ldc_w 1146
    //   723: invokestatic 540	anvx:a	(I)Ljava/lang/String;
    //   726: invokevirtual 1147	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(Ljava/lang/String;)V
    //   729: new 1149	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$1
    //   732: dup
    //   733: aload_0
    //   734: invokespecial 1150	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$1:<init>	(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;)V
    //   737: iconst_5
    //   738: aconst_null
    //   739: iconst_0
    //   740: invokestatic 307	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   743: aload_3
    //   744: ifnull +15 -> 759
    //   747: aload_3
    //   748: invokevirtual 997	bkye:a	()Z
    //   751: ifeq +8 -> 759
    //   754: aload_3
    //   755: iconst_4
    //   756: invokevirtual 1001	bkye:a	(I)V
    //   759: new 1152	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$2
    //   762: dup
    //   763: aload_0
    //   764: aload_3
    //   765: invokespecial 1155	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$2:<init>	(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;Lbkye;)V
    //   768: bipush 8
    //   770: aconst_null
    //   771: iconst_0
    //   772: invokestatic 307	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   775: aload_0
    //   776: getfield 266	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   779: getstatic 1158	com/tencent/mobileqq/app/QQManagerFactory:DATING_PROXY_MANAGER	I
    //   782: invokevirtual 515	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   785: checkcast 1160	arxv
    //   788: astore_1
    //   789: aload_1
    //   790: invokevirtual 1163	arxv:a	()Laryz;
    //   793: invokevirtual 1167	aryz:a	()I
    //   796: ifle +10 -> 806
    //   799: aload_1
    //   800: invokevirtual 1163	arxv:a	()Laryz;
    //   803: invokevirtual 1168	aryz:a	()V
    //   806: aload_0
    //   807: getfield 572	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   810: ifnull +16 -> 826
    //   813: aload_0
    //   814: getfield 572	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   817: getfield 1170	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   820: sipush 999
    //   823: if_icmpne +184 -> 1007
    //   826: bipush 30
    //   828: istore_2
    //   829: aload_0
    //   830: getfield 266	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   833: aload_0
    //   834: invokevirtual 1176	java/lang/Object:getClass	()Ljava/lang/Class;
    //   837: aload_0
    //   838: invokevirtual 1179	java/lang/Object:hashCode	()I
    //   841: ldc_w 1181
    //   844: iload_2
    //   845: aload_0
    //   846: getfield 1134	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Long	J
    //   849: invokestatic 1186	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   852: invokestatic 1191	bdmb:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/Class;ILjava/lang/String;ILjava/lang/String;)V
    //   855: iconst_1
    //   856: ireturn
    //   857: aload_0
    //   858: aload_0
    //   859: getfield 572	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   862: getfield 1170	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   865: putfield 1121	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_d_of_type_Int	I
    //   868: aload_0
    //   869: aload_0
    //   870: aload_0
    //   871: getfield 572	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   874: getfield 1170	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   877: invokevirtual 1193	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)I
    //   880: putfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   883: goto -386 -> 497
    //   886: aload_0
    //   887: aload_0
    //   888: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   891: ldc_w 1195
    //   894: invokevirtual 988	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   897: putfield 1196	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   900: aload_0
    //   901: aload_0
    //   902: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   905: ldc_w 1198
    //   908: iconst_0
    //   909: invokevirtual 925	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   912: putfield 1199	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_h_of_type_Int	I
    //   915: aload_0
    //   916: aload_0
    //   917: getfield 642	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   920: ldc_w 1201
    //   923: iconst_0
    //   924: invokevirtual 949	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   927: putfield 1203	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_f_of_type_Boolean	Z
    //   930: aload_0
    //   931: aload_0
    //   932: aload_0
    //   933: getfield 104	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   936: invokevirtual 1205	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Layej;
    //   939: putfield 192	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Ayej	Layej;
    //   942: aload_0
    //   943: aload_0
    //   944: getfield 192	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Ayej	Layej;
    //   947: invokevirtual 1206	ayej:a	()Landroid/view/View;
    //   950: putfield 262	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   953: aload_0
    //   954: getfield 192	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Ayej	Layej;
    //   957: invokevirtual 1207	ayej:a	()V
    //   960: aload_0
    //   961: getfield 262	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   964: instanceof 1209
    //   967: ifeq +17 -> 984
    //   970: aload_0
    //   971: getfield 262	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   974: checkcast 1209	com/tencent/mobileqq/widget/PerfRelativeLayout
    //   977: aload_0
    //   978: getfield 173	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Auvj	Lauvj;
    //   981: invokevirtual 1213	com/tencent/mobileqq/widget/PerfRelativeLayout:setOnDrawCompleteListener	(Lauvj;)V
    //   984: aload_0
    //   985: getfield 186	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   988: aload_0
    //   989: getfield 262	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   992: new 461	android/widget/FrameLayout$LayoutParams
    //   995: dup
    //   996: iconst_m1
    //   997: iconst_m1
    //   998: invokespecial 464	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   1001: invokevirtual 468	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1004: goto -303 -> 701
    //   1007: aload_0
    //   1008: getfield 572	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1011: getfield 1170	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1014: istore_2
    //   1015: goto -186 -> 829
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1018	0	this	NearbyPeopleProfileActivity
    //   0	1018	1	paramBundle	Bundle
    //   508	507	2	i1	int
    //   45	720	3	localbkye	bkye
    // Exception table:
    //   from	to	target	type
    //   137	144	405	java/lang/OutOfMemoryError
    //   360	376	412	java/lang/Exception
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Axqx);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Anrz != null)
    {
      this.jdField_a_of_type_Anrz.d(this.jdField_b_of_type_Ansd);
      this.jdField_a_of_type_Anrz.d(this.jdField_a_of_type_Ansd);
      this.jdField_a_of_type_Anrz.b(this);
    }
    if (this.jdField_a_of_type_Ayhc != null) {
      this.jdField_a_of_type_Ayhc.a();
    }
    if (this.app.getNearbyProxy().jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i1 = this.app.getNearbyProxy().jdField_a_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      int i2;
      if (this.jdField_a_of_type_Ayej != null)
      {
        i2 = this.jdField_a_of_type_Ayej.b();
        this.jdField_a_of_type_Ayej.g();
      }
      for (;;)
      {
        Object localObject = (NearbyPeoplePhotoUploadProcessor)this.app.getTransFileController().findProcessor(null, 0L);
        if (localObject != null) {
          ((NearbyPeoplePhotoUploadProcessor)localObject).cancelTask();
        }
        try
        {
          if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0) == -2)
          {
            if (this.jdField_q_of_type_Int > 0) {
              bdla.b(this.app, "CliOper", "", "", "0X80059BB", "0X80059BB", 0, 0, "", "", "", "");
            }
          }
          else
          {
            if (this.jdField_a_of_type_Ayej != null) {
              this.jdField_a_of_type_Ayej.b();
            }
            localObject = bdmb.a(getClass(), hashCode());
            if (localObject != null)
            {
              bdla.b(this.app, "CliOper", "", "", ((bdmc)localObject).jdField_a_of_type_JavaLangString, ((bdmc)localObject).jdField_a_of_type_JavaLangString, ((bdmc)localObject).jdField_a_of_type_Int, 0, String.valueOf(this.jdField_a_of_type_Long), Long.toString(SystemClock.elapsedRealtime() - ((bdmc)localObject).jdField_b_of_type_Long), "", "");
              int i3 = (int)(SystemClock.elapsedRealtime() - ((bdmc)localObject).jdField_b_of_type_Long) / 1000;
              if (axpp.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int, this.jdField_e_of_type_Int)) {
                this.app.getNearbyProxy().a(this.jdField_a_of_type_Long, i3, i1, i2);
              }
            }
            if (!Build.BRAND.startsWith("samsung")) {
              break label471;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              localObject = Class.forName("android.text.MeasuredText").getDeclaredField("sCached");
              ((Field)localObject).setAccessible(true);
              localObject = (Object[])((Field)localObject).get(null);
              i1 = 0;
              if (i1 >= localObject.length) {
                break;
              }
              localObject[i1] = null;
              i1 += 1;
              continue;
              bdla.b(this.app, "CliOper", "", "", "0X80059BC", "0X80059BC", 0, 0, "", "", "", "");
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
            localException = localException;
          }
        }
        label471:
        return;
        i2 = 0;
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_e_of_type_Int != 1) {
          break label233;
        }
        paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if ((paramIntent == null) || (paramIntent.size() <= 0)) {
          break;
        }
        this.jdField_d_of_type_JavaLangString = null;
        int i1 = 0;
        while (i1 < paramIntent.size())
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() < jdField_c_of_type_Int)
          {
            localObject = new PicInfo();
            ((PicInfo)localObject).c = ((String)paramIntent.get(i1));
            if (this.jdField_a_of_type_Ayhc.a((PicInfo)localObject)) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 1000L);
            }
          }
          i1 += 1;
        }
      }
    } while (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString));
    paramIntent = QZoneHelper.UserInfo.getInstance();
    paramIntent.qzone_uin = this.app.getCurrentAccountUin();
    paramIntent.nickname = this.app.getCurrentNickname();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_title", getString(2131717300));
    ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
    ((Bundle)localObject).putBoolean("show_album", false);
    ((Bundle)localObject).putString("key_jump_album_id", this.jdField_d_of_type_JavaLangString);
    ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.forwardToPersonalAlbumSelect(this, paramIntent, (Bundle)localObject, 5);
    return;
    label233:
    aynv.a(this, 1000, -1, paramIntent);
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
    bkxz.a(this);
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
    this.app.removeObserver(this.jdField_a_of_type_Anwo);
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    if (this.jdField_a_of_type_Ayej != null) {
      this.jdField_a_of_type_Ayej.e();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_Ayej != null) {
      this.jdField_a_of_type_Ayej.d();
    }
    this.app.addObserver(this.jdField_a_of_type_Anvi);
    this.app.addObserver(this.jdField_a_of_type_Anwo);
    ApngImage.playByTag(15);
    AbstractVideoImage.resumeAll();
    if (getApplication() == null) {
      finish();
    }
    do
    {
      return;
      super.doOnResume();
      axny localaxny = (axny)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if ((this.jdField_a_of_type_Ayej != null) && (this.jdField_a_of_type_Ayej.jdField_a_of_type_Boolean))
      {
        localaxny.d.put(this.app.getCurrentAccountUin(), Integer.valueOf(1));
        this.jdField_a_of_type_Ayej.jdField_a_of_type_Boolean = false;
      }
      this.jdField_k_of_type_Boolean = localaxny.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "doOnResume, isNeedUpdateProfile=" + this.jdField_k_of_type_Boolean + ", isForceUpdateOnResume=" + this.jdField_l_of_type_Boolean);
      }
      if ((this.jdField_k_of_type_Boolean) || (this.jdField_l_of_type_Boolean))
      {
        this.jdField_l_of_type_Boolean = false;
        a();
        this.v = false;
        return;
      }
      if ((!this.v) || (this.jdField_e_of_type_Int != 3) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!this.jdField_k_of_type_Boolean)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L);
    a();
    this.v = false;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Ayej != null) {
      this.jdField_a_of_type_Ayej.c();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.v = true;
    if ((this.jdField_e_of_type_Int == 2) && (this.jdField_a_of_type_Ayej != null) && (this.jdField_a_of_type_Ayej.a()))
    {
      this.jdField_a_of_type_Ayej.h();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) && (this.jdField_a_of_type_Ayej != null)) {
        this.jdField_a_of_type_Ayej.i();
      }
    }
    bkye localbkye = bkye.a;
    if ((localbkye != null) && (localbkye.a(true))) {
      localbkye.a(this.app.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_Ayej != null) {
      this.jdField_a_of_type_Ayej.f();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (!this.x)
    {
      this.jdField_i_of_type_Int = this.app.getPreferences().getInt("nearby_people_profile_ok_new", 0);
      this.jdField_n_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_from_web", false);
      this.m = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("abp_flag", false);
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0) == -1)
      {
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("PUSH_CONTENT");
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        bdla.b(this.app, "CliOper", "", "", "0X800524A", "0X800524A", 0, 0, "", "", str1, "");
      }
      this.x = true;
    }
  }
  
  protected void e()
  {
    if (this.jdField_e_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Ayej != null) {
        this.jdField_a_of_type_Ayej.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      }
      return;
    }
    this.jdField_e_of_type_Int = 2;
    if (this.jdField_a_of_type_Ayhc != null) {
      this.jdField_a_of_type_Ayhc.jdField_a_of_type_Boolean = false;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new aydr(this));
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  protected void f()
  {
    axnu localaxnu = new axnu();
    localaxnu.jdField_a_of_type_Int = -1;
    axnu.a(this.app.getCurrentAccountUin(), localaxnu);
    this.jdField_i_of_type_Int = 1;
    this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", 1).commit();
  }
  
  public void finish()
  {
    super.finish();
    if (this.m) {
      overridePendingTransition(2130771988, 2130771989);
    }
  }
  
  protected void g()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.tribeAppDownload", 2, "showUploadPhotoActionSheet, isAddPicBtnDownloadAppOpen=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAddPicBtnDownloadAppOpen() + ", addPicBtnDownloadAppTips:" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
    }
    String[] arrayOfString = getResources().getStringArray(2130968636);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAddPicBtnDownloadAppOpen()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl)))
    {
      axny.a(this, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl, 2);
      return;
    }
    bkzi localbkzi = bkzi.a(this);
    localbkzi.c(arrayOfString[28]);
    localbkzi.c(arrayOfString[29]);
    localbkzi.d(arrayOfString[16]);
    localbkzi.a(new ayea(this, localbkzi));
    localbkzi.show();
  }
  
  public void i()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.app.getCurrentAccountUin();
    localUserInfo.nickname = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", getString(2131717300));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.forwardToPersonalAlbumSelect(this, localUserInfo, localBundle, 5);
    bdla.b(this.app, "CliOper", "", "", "0X800481F", "0X800481F", 2, 0, "", "", "", "");
  }
  
  public boolean isWrapContent()
  {
    boolean bool = true;
    if (this.jdField_e_of_type_Int == 1) {
      bool = false;
    }
    return bool;
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.w) || (isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "refreshStangerFace.");
    }
    this.w = true;
    this.jdField_a_of_type_JavaLangRunnable = new NearbyPeopleProfileActivity.21(this);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
  
  public boolean onBackEvent()
  {
    int i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0);
    if (i1 == 1)
    {
      a(2131698646);
      return true;
    }
    if ((i1 == 2) && (this.jdField_e_of_type_Int == 1))
    {
      if (this.jdField_i_of_type_Int == 0)
      {
        a(2131698646);
        return true;
      }
      if (this.jdField_a_of_type_Ayhc.a())
      {
        a(2131698642);
        return true;
      }
      d();
      return true;
    }
    if (this.m)
    {
      localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.m);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      localIntent.putExtra("nearby_profile_nickname", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      localIntent.putExtra("param_gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      localIntent.putExtra("param_vote_num", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount);
      localIntent.putExtra("param_vote_num_add", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc);
      localIntent.putExtra("param_level", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel);
    }
    Object localObject;
    if ((getIntent().getBooleanExtra("from_newer_guide", false)) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      localObject = this.app.getMessageFacade().getAIOList(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 1001);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label553;
      }
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ChatMessage)((Iterator)localObject).next()).isSendFromLocal());
    }
    label548:
    label553:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "onBackEvent hasSayHi: " + bool);
      }
      localIntent.putExtra("has_operation", bool);
      localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
      localIntent.putExtra("intent_key_has_ever_vote", this.jdField_q_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_d_of_type_JavaLangString))) {
          break label499;
        }
        bool = true;
      }
      for (;;)
      {
        localIntent.putExtra("param_real_video_auth", bool);
        localObject = new nearby.Cmd0x1RspBody();
        try
        {
          ((nearby.Cmd0x1RspBody)localObject).mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
          localIntent.putExtra("follow_flag", ((nearby.Cmd0x1RspBody)localObject).bool_follow.get());
          setResult(-1, localIntent);
          if (getIntent().getIntExtra("frome_where", 0) == 35)
          {
            i1 = 1;
            if (i1 == 0) {
              break label548;
            }
            finish();
            AlbumUtil.anim(this, false, false);
            return true;
            label499:
            bool = false;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.w("Q.nearby_people_card.", 2, "Cmd0x1RspBody error !:" + localInvalidProtocolBufferMicroException);
              continue;
              i1 = 0;
            }
          }
        }
      }
      return super.onBackEvent();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity
 * JD-Core Version:    0.7.0.1
 */