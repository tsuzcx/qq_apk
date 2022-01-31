package com.tencent.mobileqq.nearby.profilecard;

import afhd;
import afhe;
import afhf;
import afhg;
import afhi;
import afhj;
import afhl;
import afhm;
import afho;
import afhp;
import afhs;
import afht;
import afhu;
import afhv;
import afhw;
import afhx;
import afhy;
import afhz;
import afia;
import afib;
import afic;
import afid;
import afie;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.nearby.NearPeopleFilters;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.widget.BlueButtonInfo;
import com.tencent.mobileqq.nearby.widget.NearbyCustomDialog;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.widget.ActionSheet;
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
  public static HashMap a;
  public static int b;
  public static int c;
  public static int m;
  public float a;
  public long a;
  private afie jdField_a_of_type_Afie;
  public Dialog a;
  public Intent a;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public URLDrawable a;
  public ProfileActivity.AllInOne a;
  public TopGestureLayout a;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new afho(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new afhg(this);
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new afhi(this);
  private DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback = new afhm(this);
  private DynamicAvatarDownloadManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
  private DynamicAvatarManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  OnDrawCompleteListener jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = new afhw(this);
  public NearbyCardHandler a;
  public NearbyCardObserver a;
  PicInfo jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
  private NearbyProfileDisplayBasePanel jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel;
  private NearbyProfileEditBasePanel jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  public boolean a;
  public Dialog b;
  private View jdField_b_of_type_AndroidViewView;
  private ConditionSearchManager.IConfigListener jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new afhp(this);
  public String b;
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  public boolean b;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  public String d;
  public boolean d;
  public int e;
  boolean e;
  public int f;
  boolean f;
  int g;
  public boolean g;
  int h;
  public boolean h;
  public int i;
  boolean i;
  public int j;
  boolean j;
  public int k;
  public boolean k;
  public int l;
  public boolean l;
  public boolean m;
  public int n = 18;
  public volatile boolean n;
  public int o;
  public boolean o;
  private int jdField_p_of_type_Int;
  boolean jdField_p_of_type_Boolean = false;
  private int q;
  public boolean q;
  boolean r = false;
  public boolean s = false;
  public boolean t = false;
  private boolean u;
  private boolean v;
  private boolean w;
  
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
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new afhz(this);
    this.jdField_a_of_type_AndroidAppDialog = null;
    this.jdField_b_of_type_AndroidAppDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new afhj(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
  }
  
  private int a(int paramInt)
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
  
  private void a(NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.jdField_e_of_type_Int != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.b(paramNearbyPeopleCard);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
      jdField_c_of_type_Int = jdField_a_of_type_Int;
    }
    for (;;)
    {
      label174:
      label237:
      int i1;
      label282:
      label301:
      long l2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
          ReportController.b(this.app, "CliOper", "", "", "0X8005286", "0X8005286", 0, 0, "", "", "", "");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.isEmpty())) {
          break label430;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList);
        this.jdField_h_of_type_Boolean = true;
        if (this.jdField_e_of_type_Int == 3)
        {
          if (!Utils.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
            break label462;
          }
          this.jdField_a_of_type_AndroidContentIntent.putExtra("param_mode", 2);
          this.jdField_e_of_type_Int = 2;
        }
        if (this.jdField_e_of_type_Int != 1) {
          break label510;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        if ((this.r) || (this.jdField_e_of_type_Int == 1) || (this.jdField_g_of_type_Boolean)) {
          break;
        }
        this.r = true;
        if (!a(this.jdField_j_of_type_Int)) {
          break label524;
        }
        i1 = 510;
        l2 = 0L;
      }
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(l1, 0L, i1);
        return;
        jdField_c_of_type_Int = jdField_b_of_type_Int;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
          break label174;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005287", "0X8005287", 0, 0, "", "", "", "");
        break label174;
        label430:
        if (1 == this.jdField_e_of_type_Int) {
          break label237;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, "onNearbyCardDownload need to getQzoneCover.");
        }
        this.jdField_h_of_type_Boolean = false;
        break label237;
        label462:
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
          break label282;
        }
        paramNearbyPeopleCard = (FriendsManager)this.app.getManager(50);
        if (paramNearbyPeopleCard == null) {
          break label282;
        }
        this.jdField_g_of_type_Boolean = paramNearbyPeopleCard.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        break label282;
        label510:
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        break label301;
        label524:
        i1 = 509;
      }
      catch (Exception paramNearbyPeopleCard)
      {
        for (;;)
        {
          long l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.e("NearbyLikeLimitManager", 2, "req NearbyLikeLimitInfo: mCard.uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
            l1 = l2;
          }
        }
      }
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
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      i();
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004A1C", "0X8004A1C", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_no_miss", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1D", "0X8004A1D", 0, 0, "", "", "", "");
    }
  }
  
  private void h()
  {
    this.jdField_e_of_type_Int = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.jdField_a_of_type_Boolean = false;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new afhf(this));
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  private void i()
  {
    NearPeopleFilters localNearPeopleFilters = new NearPeopleFilters();
    localNearPeopleFilters.jdField_a_of_type_Int = -1;
    NearPeopleFilters.a(this.app.getCurrentAccountUin(), localNearPeopleFilters);
    this.jdField_i_of_type_Int = 1;
    this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", 1).commit();
  }
  
  private void j()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public NearbyProfileDisplayBasePanel a(int paramInt)
  {
    if (a(paramInt)) {
      return new NearbyProfileDisplayTribePanel(this);
    }
    return new NearbyProfileDisplayPanel(this);
  }
  
  public NearbyProfileEditBasePanel a(int paramInt)
  {
    if (a(paramInt)) {
      return new NearbyProfileEditTribePanel(this);
    }
    return new NearbyProfileEditPanel(this);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 0, getString(paramInt), 2131437746, 2131437747, new afia(this), new afib(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void a(int paramInt, Rect paramRect)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        if ("showBigPhoto, currentPosition = " + paramInt + ", rect = " + paramRect + ", mPicInfo.size = " + this.jdField_a_of_type_JavaUtilArrayList != null) {
          break label89;
        }
      }
      label89:
      for (paramRect = "null";; paramRect = Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        QLog.e("Q.nearby_people_card.", 2, new Object[] { paramRect });
        return;
      }
    }
    Intent localIntent = new Intent(this, NearbyProfilePicBrowserActivity.class);
    localIntent.putExtra("intent_param_index", paramInt);
    localIntent.putExtra("intent_param_pic_infos", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("report_visited_pic", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    localIntent.addFlags(536870912);
    startActivity(localIntent);
  }
  
  public void a(int paramInt, Rect paramRect, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        if ("showBigPhotoWithDelAndSetHeadView, currentPosition = " + paramInt + ", rect = " + paramRect + ", picInfos.size = " + paramArrayList != null) {
          break label80;
        }
      }
      label80:
      for (paramRect = "null";; paramRect = Integer.valueOf(paramArrayList.size()))
      {
        QLog.e("Q.nearby_people_card.", 2, new Object[] { paramRect });
        return;
      }
    }
    Intent localIntent = new Intent(this, NearbyProfilePicBrowserActivity.class);
    localIntent.putExtra("intent_param_index", paramInt);
    localIntent.putExtra("intent_param_pic_infos", paramArrayList);
    localIntent.putExtra("report_visited_pic", true);
    localIntent.putExtra("intent_param_show_del_pic_and_set_head", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    localIntent.addFlags(536870912);
    startActivityForResult(localIntent, 14);
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
    localAlphaAnimation.setAnimationListener(new afhd(this));
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    try
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
      label65:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a();
      }
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel = null;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel = a(this.jdField_j_of_type_Int);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-1, -1));
      BounceScrollView localBounceScrollView = (BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370662);
      localBounceScrollView.post(new afhe(this, localBounceScrollView, this.jdField_b_of_type_AndroidViewView.findViewById(2131370696).getScrollY()));
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      j();
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
    paramDrawable = (NearbyLikeLimitManager)this.app.getManager(206);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, UIUtils.a(this, 150.0F));
    new NearbyCustomDialog(this).a(paramImageView, localLayoutParams).a("附近点赞升级啦").b(paramDrawable.a()).a(new BlueButtonInfo("知道了", new afhl(this))).show();
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    paramDrawable.a();
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    } while (isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (this.t)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "downloadHDAvatar is updated HDAvatar true");
      }
      return;
    }
    this.jdField_a_of_type_Afie = new afie(this, paramString1, paramInt, paramString2, paramBoolean);
    ThreadManager.post(this.jdField_a_of_type_Afie, 5, null, true);
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
    if ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard.tinyId != this.jdField_a_of_type_Long) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.update_profile", 2, "editNearbyProfileCardResult|[" + paramBoolean1 + "," + paramNearbyPeopleCard + "]");
      }
      a();
      if ((!paramBoolean1) || (paramNearbyPeopleCard == null)) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      a(2, "资料保存成功");
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, paramNearbyPeopleCard.college))
      {
        NearbySPUtil.a(this.app.getCurrentAccountUin(), "school_name", paramNearbyPeopleCard.college);
        NearbySPUtil.a(this.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(this.jdField_o_of_type_Int));
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
        NearbyCardManager.a(this.app);
      }
      if (this.jdField_i_of_type_Int != 1) {
        i();
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.j();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("param_mode", 2);
      h();
      ThreadManager.post(new afhv(this), 5, null, true);
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
      int i2 = ((Integer)NearbySPUtil.a(this.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      ReportController.b(this.app, "dc00899", "grp_lbs", "", "data_card", "upload_suc", 0, 0, i1 + "", i2 + "", "", "");
      setResult(-1, paramNearbyPeopleCard);
    } while (!this.jdField_a_of_type_Boolean);
    b(true);
    finish();
    return;
    if (TextUtils.isEmpty(paramString)) {
      b("资料保存失败");
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      return;
      b(paramString);
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
  
  void b()
  {
    this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 2131437749, getString(2131437750), 2131433029, 2131437751, new afic(this), new afid(this));
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void b(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(this.jdField_p_of_type_Int);
  }
  
  public void b(boolean paramBoolean)
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
        EventApiPlugin.a("nearbyUserSummaryInfoChange", localJSONObject, localArrayList, null);
        return;
      }
      catch (JSONException localJSONException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, localJSONException.toString());
  }
  
  public void c()
  {
    InputMethodUtil.a(this);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.j();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(new ArrayList());
    }
    int i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0);
    if (i1 == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1B", "0X8004A1B", 0, 0, "", "", "", "");
      if (this.m)
      {
        if (this.jdField_l_of_type_Boolean)
        {
          Intent localIntent = new Intent(this, NearbyActivity.class);
          localIntent.putExtra("abp_flag", this.jdField_l_of_type_Boolean);
          localIntent.setFlags(67108864);
          startActivity(localIntent);
        }
        finish();
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      b(false);
      return;
      c(false);
      continue;
      if ((i1 == 2) && (this.jdField_e_of_type_Int == 1)) {
        h();
      }
    }
  }
  
  void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.app != null)) {
      ThreadManager.post(new afht(this, paramString), 5, null, true);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.tribeAppDownload", 2, "showUploadPhotoActionSheet, isAddPicBtnDownloadAppOpen=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAddPicBtnDownloadAppOpen() + ", addPicBtnDownloadAppTips:" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
    }
    String[] arrayOfString = getResources().getStringArray(2131296278);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAddPicBtnDownloadAppOpen()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl)))
    {
      NearbyCardManager.a(this, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl, 2);
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.c(arrayOfString[28]);
    localActionSheet.c(arrayOfString[29]);
    localActionSheet.d(arrayOfString[16]);
    localActionSheet.a(new afhs(this, localActionSheet));
    localActionSheet.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 14)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (this.jdField_e_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.a(paramInt1, paramInt2, paramIntent);
  }
  
  /* Error */
  protected boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1029	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   4: ldc_w 1031
    //   7: iconst_0
    //   8: invokevirtual 219	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11: pop
    //   12: getstatic 1036	com/tencent/util/ProfilePerformanceReport:b	Lcom/tencent/util/ProfilePerformanceReport;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +20 -> 37
    //   20: aload_3
    //   21: invokevirtual 1038	com/tencent/util/ProfilePerformanceReport:a	()Z
    //   24: ifeq +13 -> 37
    //   27: aload_3
    //   28: iconst_0
    //   29: invokevirtual 1040	com/tencent/util/ProfilePerformanceReport:b	(I)V
    //   32: aload_3
    //   33: iconst_1
    //   34: invokevirtual 1042	com/tencent/util/ProfilePerformanceReport:a	(I)V
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 1045	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mActNeedImmersive	Z
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield 1048	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mNeedStatusTrans	Z
    //   47: aload_0
    //   48: aload_1
    //   49: invokespecial 1050	android/support/v4/app/FragmentActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   52: pop
    //   53: aload_0
    //   54: getfield 294	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: aload_0
    //   58: getfield 137	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver	Lcom/tencent/mobileqq/nearby/business/NearbyCardObserver;
    //   61: invokevirtual 1054	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   64: aload_0
    //   65: aload_0
    //   66: invokevirtual 1029	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   69: putfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   72: aload_0
    //   73: getfield 294	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   76: invokevirtual 1057	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   79: ifeq +10 -> 89
    //   82: aload_0
    //   83: getfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   86: ifnonnull +9 -> 95
    //   89: aload_0
    //   90: invokevirtual 891	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   93: iconst_0
    //   94: ireturn
    //   95: aload_0
    //   96: ldc_w 1058
    //   99: invokespecial 1061	android/support/v4/app/FragmentActivity:setContentView	(I)V
    //   102: aload_0
    //   103: invokevirtual 743	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getWindow	()Landroid/view/Window;
    //   106: aconst_null
    //   107: invokevirtual 1064	android/view/Window:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   110: aload_0
    //   111: aload_0
    //   112: invokevirtual 987	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   115: invokevirtual 1068	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   118: getfield 1073	android/util/DisplayMetrics:density	F
    //   121: putfield 1075	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Float	F
    //   124: aload_0
    //   125: aload_0
    //   126: invokevirtual 716	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getTitleBarHeight	()I
    //   129: putfield 598	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_p_of_type_Int	I
    //   132: aload_0
    //   133: aload_0
    //   134: invokevirtual 987	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   137: invokevirtual 1068	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   140: getfield 1078	android/util/DisplayMetrics:widthPixels	I
    //   143: iconst_3
    //   144: idiv
    //   145: putfield 1080	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_f_of_type_Int	I
    //   148: aload_0
    //   149: aload_0
    //   150: invokevirtual 987	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   153: invokevirtual 1068	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   156: getfield 1078	android/util/DisplayMetrics:widthPixels	I
    //   159: putfield 1082	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_g_of_type_Int	I
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 294	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   167: bipush 60
    //   169: invokevirtual 1085	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   172: checkcast 357	com/tencent/mobileqq/nearby/business/NearbyCardHandler
    //   175: putfield 355	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler	Lcom/tencent/mobileqq/nearby/business/NearbyCardHandler;
    //   178: aload_0
    //   179: aload_0
    //   180: getfield 294	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   183: bipush 14
    //   185: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   188: checkcast 1087	com/tencent/mobileqq/richstatus/StatusManager
    //   191: putfield 1089	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager	Lcom/tencent/mobileqq/richstatus/StatusManager;
    //   194: aload_0
    //   195: aload_0
    //   196: getfield 294	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   199: bipush 58
    //   201: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   204: checkcast 1091	com/tencent/mobileqq/app/ConditionSearchManager
    //   207: putfield 1093	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   210: aload_0
    //   211: getfield 1093	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   214: aload_0
    //   215: invokevirtual 1096	com/tencent/mobileqq/app/ConditionSearchManager:a	(Ljava/lang/Object;)V
    //   218: aload_0
    //   219: getfield 1093	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   222: aload_0
    //   223: getfield 161	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener	Lcom/tencent/mobileqq/app/ConditionSearchManager$IConfigListener;
    //   226: invokevirtual 1098	com/tencent/mobileqq/app/ConditionSearchManager:c	(Ljava/lang/Object;)V
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 294	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   234: sipush 179
    //   237: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   240: checkcast 1100	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager
    //   243: putfield 1102	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   246: aload_0
    //   247: aload_0
    //   248: getfield 1102	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   251: invokevirtual 1105	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	()Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager;
    //   254: putfield 182	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager;
    //   257: aload_0
    //   258: aload_0
    //   259: getfield 1102	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   262: iconst_4
    //   263: invokevirtual 1106	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	(I)Z
    //   266: putfield 1108	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_o_of_type_Boolean	Z
    //   269: aload_0
    //   270: getfield 1102	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   273: invokevirtual 1111	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	()Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarConfig;
    //   276: ifnull +39 -> 315
    //   279: aload_0
    //   280: aload_0
    //   281: getfield 1102	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   284: invokevirtual 1111	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	()Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarConfig;
    //   287: getfield 1115	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarConfig:jdField_d_of_type_Int	I
    //   290: putfield 105	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:n	I
    //   293: aload_0
    //   294: getfield 105	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:n	I
    //   297: iflt +12 -> 309
    //   300: aload_0
    //   301: getfield 105	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:n	I
    //   304: bipush 30
    //   306: if_icmple +9 -> 315
    //   309: aload_0
    //   310: bipush 18
    //   312: putfield 105	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:n	I
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   320: ldc 206
    //   322: invokevirtual 1119	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   325: checkcast 265	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   328: putfield 258	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   331: aload_0
    //   332: getfield 258	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   335: ifnonnull +72 -> 407
    //   338: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +13 -> 354
    //   344: ldc_w 364
    //   347: iconst_2
    //   348: ldc_w 1121
    //   351: invokestatic 788	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload_0
    //   355: invokevirtual 891	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   358: iconst_1
    //   359: ireturn
    //   360: astore_1
    //   361: aload_0
    //   362: invokevirtual 891	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   365: iconst_0
    //   366: ireturn
    //   367: astore_1
    //   368: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq -40 -> 331
    //   374: ldc_w 364
    //   377: iconst_2
    //   378: new 385	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 386	java/lang/StringBuilder:<init>	()V
    //   385: ldc_w 1123
    //   388: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_1
    //   392: invokevirtual 1126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   395: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 393	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 788	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: goto -73 -> 331
    //   407: aload_0
    //   408: aload_0
    //   409: getfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   412: ldc 216
    //   414: iconst_0
    //   415: invokevirtual 945	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   418: putfield 99	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   421: aload_0
    //   422: getfield 99	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   425: bipush 35
    //   427: if_icmpne +9 -> 436
    //   430: aload_0
    //   431: iconst_0
    //   432: iconst_1
    //   433: invokestatic 1131	com/tencent/mobileqq/utils/AlbumUtil:a	(Landroid/app/Activity;ZZ)V
    //   436: aload_0
    //   437: getfield 99	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   440: invokestatic 347	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Z
    //   443: ifeq +335 -> 778
    //   446: aload_0
    //   447: bipush 51
    //   449: putfield 1132	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_d_of_type_Int	I
    //   452: aload_0
    //   453: getfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   456: ldc_w 340
    //   459: iconst_0
    //   460: invokevirtual 945	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   463: istore_2
    //   464: iload_2
    //   465: iconst_2
    //   466: if_icmpeq +8 -> 474
    //   469: iload_2
    //   470: iconst_1
    //   471: if_icmpne +30 -> 501
    //   474: aload_0
    //   475: getfield 258	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   478: getfield 267	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   481: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   484: ifeq +17 -> 501
    //   487: aload_0
    //   488: getfield 258	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   491: aload_0
    //   492: getfield 294	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   495: invokevirtual 1135	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   498: putfield 267	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   501: aload_0
    //   502: aload_0
    //   503: getfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   506: ldc_w 340
    //   509: iconst_0
    //   510: invokevirtual 945	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   513: putfield 251	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_Int	I
    //   516: aload_0
    //   517: aload_0
    //   518: getfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   521: ldc_w 1137
    //   524: iconst_0
    //   525: invokevirtual 411	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   528: putfield 95	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Boolean	Z
    //   531: aload_0
    //   532: aload_0
    //   533: getfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   536: ldc_w 1139
    //   539: lconst_0
    //   540: invokevirtual 1143	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   543: putfield 775	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Long	J
    //   546: aload_0
    //   547: aload_0
    //   548: ldc_w 1144
    //   551: invokevirtual 1145	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:findViewById	(I)Landroid/view/View;
    //   554: checkcast 609	android/view/ViewGroup
    //   557: putfield 179	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   560: aload_0
    //   561: getfield 251	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_Int	I
    //   564: iconst_1
    //   565: if_icmpne +242 -> 807
    //   568: aload_0
    //   569: aload_0
    //   570: aload_0
    //   571: getfield 99	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   574: invokevirtual 617	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileEditBasePanel;
    //   577: putfield 192	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel	Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileEditBasePanel;
    //   580: aload_0
    //   581: aload_0
    //   582: getfield 192	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel	Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileEditBasePanel;
    //   585: invokevirtual 620	com/tencent/mobileqq/nearby/profilecard/NearbyProfileEditBasePanel:a	()Landroid/view/View;
    //   588: putfield 175	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   591: aload_0
    //   592: getfield 179	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   595: aload_0
    //   596: getfield 175	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   599: new 622	android/widget/FrameLayout$LayoutParams
    //   602: dup
    //   603: iconst_m1
    //   604: iconst_m1
    //   605: invokespecial 625	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   608: invokevirtual 629	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   611: aload_0
    //   612: aload_0
    //   613: getfield 101	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_k_of_type_Int	I
    //   616: iconst_1
    //   617: iadd
    //   618: putfield 101	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_k_of_type_Int	I
    //   621: aload_0
    //   622: iconst_1
    //   623: putfield 886	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Boolean	Z
    //   626: aload_0
    //   627: getfield 182	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager;
    //   630: ifnull +14 -> 644
    //   633: aload_0
    //   634: getfield 182	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager;
    //   637: aload_0
    //   638: getfield 142	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback;
    //   641: invokevirtual 1150	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager:a	(Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback;)V
    //   644: aload_0
    //   645: ldc_w 1152
    //   648: invokevirtual 1153	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(Ljava/lang/String;)V
    //   651: new 1155	afhc
    //   654: dup
    //   655: aload_0
    //   656: invokespecial 1156	afhc:<init>	(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;)V
    //   659: iconst_5
    //   660: aconst_null
    //   661: iconst_0
    //   662: invokestatic 737	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   665: aload_3
    //   666: ifnull +15 -> 681
    //   669: aload_3
    //   670: invokevirtual 1038	com/tencent/util/ProfilePerformanceReport:a	()Z
    //   673: ifeq +8 -> 681
    //   676: aload_3
    //   677: iconst_4
    //   678: invokevirtual 1042	com/tencent/util/ProfilePerformanceReport:a	(I)V
    //   681: new 1158	afhq
    //   684: dup
    //   685: aload_0
    //   686: aload_3
    //   687: invokespecial 1161	afhq:<init>	(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;Lcom/tencent/util/ProfilePerformanceReport;)V
    //   690: bipush 8
    //   692: aconst_null
    //   693: iconst_0
    //   694: invokestatic 737	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   697: aload_0
    //   698: getfield 294	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   701: bipush 70
    //   703: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   706: checkcast 1163	com/tencent/mobileqq/dating/DatingProxyManager
    //   709: astore_1
    //   710: aload_1
    //   711: invokevirtual 1166	com/tencent/mobileqq/dating/DatingProxyManager:a	()Lcom/tencent/mobileqq/dating/widget/VoteEventMgr;
    //   714: invokevirtual 1170	com/tencent/mobileqq/dating/widget/VoteEventMgr:a	()I
    //   717: ifle +10 -> 727
    //   720: aload_1
    //   721: invokevirtual 1166	com/tencent/mobileqq/dating/DatingProxyManager:a	()Lcom/tencent/mobileqq/dating/widget/VoteEventMgr;
    //   724: invokevirtual 1171	com/tencent/mobileqq/dating/widget/VoteEventMgr:a	()V
    //   727: aload_0
    //   728: getfield 258	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   731: ifnull +16 -> 747
    //   734: aload_0
    //   735: getfield 258	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   738: getfield 1173	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   741: sipush 999
    //   744: if_icmpne +184 -> 928
    //   747: bipush 30
    //   749: istore_2
    //   750: aload_0
    //   751: getfield 294	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   754: aload_0
    //   755: invokevirtual 1177	java/lang/Object:getClass	()Ljava/lang/Class;
    //   758: aload_0
    //   759: invokevirtual 1180	java/lang/Object:hashCode	()I
    //   762: ldc_w 1182
    //   765: iload_2
    //   766: aload_0
    //   767: getfield 775	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Long	J
    //   770: invokestatic 1185	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   773: invokestatic 1190	com/tencent/mobileqq/statistics/ViewExposeUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/Class;ILjava/lang/String;ILjava/lang/String;)V
    //   776: iconst_1
    //   777: ireturn
    //   778: aload_0
    //   779: aload_0
    //   780: getfield 258	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   783: getfield 1173	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   786: putfield 1132	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_d_of_type_Int	I
    //   789: aload_0
    //   790: aload_0
    //   791: aload_0
    //   792: getfield 258	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   795: getfield 1173	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   798: invokespecial 1192	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)I
    //   801: putfield 99	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   804: goto -352 -> 452
    //   807: aload_0
    //   808: aload_0
    //   809: getfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   812: ldc_w 1194
    //   815: invokevirtual 1198	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   818: putfield 1199	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   821: aload_0
    //   822: aload_0
    //   823: getfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   826: ldc_w 1201
    //   829: iconst_0
    //   830: invokevirtual 945	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   833: putfield 1202	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_h_of_type_Int	I
    //   836: aload_0
    //   837: aload_0
    //   838: getfield 338	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   841: ldc_w 1204
    //   844: iconst_0
    //   845: invokevirtual 411	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   848: putfield 1206	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_f_of_type_Boolean	Z
    //   851: aload_0
    //   852: aload_0
    //   853: aload_0
    //   854: getfield 99	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   857: invokevirtual 1208	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel;
    //   860: putfield 188	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel	Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel;
    //   863: aload_0
    //   864: aload_0
    //   865: getfield 188	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel	Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel;
    //   868: invokevirtual 1209	com/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel:a	()Landroid/view/View;
    //   871: putfield 400	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   874: aload_0
    //   875: getfield 188	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel	Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel;
    //   878: invokevirtual 1210	com/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel:a	()V
    //   881: aload_0
    //   882: getfield 400	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   885: instanceof 1212
    //   888: ifeq +17 -> 905
    //   891: aload_0
    //   892: getfield 400	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   895: checkcast 1212	com/tencent/mobileqq/widget/PerfRelativeLayout
    //   898: aload_0
    //   899: getfield 168	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener	Lcom/tencent/mobileqq/fpsreport/OnDrawCompleteListener;
    //   902: invokevirtual 1216	com/tencent/mobileqq/widget/PerfRelativeLayout:setOnDrawCompleteListener	(Lcom/tencent/mobileqq/fpsreport/OnDrawCompleteListener;)V
    //   905: aload_0
    //   906: getfield 179	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   909: aload_0
    //   910: getfield 400	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   913: new 622	android/widget/FrameLayout$LayoutParams
    //   916: dup
    //   917: iconst_m1
    //   918: iconst_m1
    //   919: invokespecial 625	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   922: invokevirtual 629	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   925: goto -299 -> 626
    //   928: aload_0
    //   929: getfield 258	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   932: getfield 1173	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   935: istore_2
    //   936: goto -186 -> 750
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	939	0	this	NearbyPeopleProfileActivity
    //   0	939	1	paramBundle	Bundle
    //   463	473	2	i1	int
    //   15	672	3	localProfilePerformanceReport	ProfilePerformanceReport
    // Exception table:
    //   from	to	target	type
    //   95	102	360	java/lang/OutOfMemoryError
    //   315	331	367	java/lang/Exception
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a();
    }
    if (this.app.a().jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i1 = this.app.a().jdField_a_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      int i2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null)
      {
        i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.b();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.g();
      }
      for (;;)
      {
        Object localObject = (NearbyPeoplePhotoUploadProcessor)this.app.a().a(null, 0L);
        if (localObject != null) {
          ((NearbyPeoplePhotoUploadProcessor)localObject).f();
        }
        try
        {
          if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0) == -2)
          {
            if (this.q > 0) {
              ReportController.b(this.app, "CliOper", "", "", "0X80059BB", "0X80059BB", 0, 0, "", "", "", "");
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.b();
            }
            localObject = ViewExposeUtil.a(getClass(), hashCode());
            if (localObject != null)
            {
              ReportController.b(this.app, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, String.valueOf(this.jdField_a_of_type_Long), Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).b), "", "");
              int i3 = (int)(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).b) / 1000;
              if (NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int, this.jdField_e_of_type_Int)) {
                this.app.a().a(this.jdField_a_of_type_Long, i3, i1, i2);
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
              ReportController.b(this.app, "CliOper", "", "", "0X80059BC", "0X80059BC", 0, 0, "", "", "", "");
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
  
  protected void doOnNewIntent(Intent paramIntent)
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
        if (this.jdField_e_of_type_Int == 1)
        {
          paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
          if ((paramIntent == null) || (paramIntent.size() <= 0)) {
            break;
          }
          this.jdField_c_of_type_JavaLangString = null;
          int i1 = 0;
          while (i1 < paramIntent.size())
          {
            if (this.jdField_a_of_type_JavaUtilArrayList.size() < jdField_c_of_type_Int)
            {
              localObject = new PicInfo();
              ((PicInfo)localObject).jdField_c_of_type_JavaLangString = ((String)paramIntent.get(i1));
              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a((PicInfo)localObject)) {
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 1000L);
              }
            }
            i1 += 1;
          }
        }
      }
    } while (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString));
    paramIntent = QZoneHelper.UserInfo.a();
    paramIntent.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    paramIntent.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_title", getString(2131432719));
    ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
    ((Bundle)localObject).putBoolean("show_album", false);
    ((Bundle)localObject).putString("key_jump_album_id", this.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.a(this, paramIntent, (Bundle)localObject, 5);
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
    InputMethodUtil.a(this);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.e();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.d();
    }
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    ApngImage.playByTag(15);
    AbstractVideoImage.resumeAll();
    if (getApplication() == null) {
      finish();
    }
    do
    {
      return;
      super.doOnResume();
      NearbyCardManager localNearbyCardManager = (NearbyCardManager)this.app.getManager(105);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.jdField_a_of_type_Boolean))
      {
        localNearbyCardManager.d.put(this.app.getCurrentAccountUin(), Integer.valueOf(1));
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.jdField_a_of_type_Boolean = false;
      }
      this.jdField_k_of_type_Boolean = localNearbyCardManager.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      if (this.jdField_k_of_type_Boolean)
      {
        ThreadManager.post(new afhx(this), 8, null, false);
        this.u = false;
        return;
      }
      if ((!this.u) || (this.jdField_e_of_type_Int != 3) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L);
    ThreadManager.post(new afhy(this), 8, null, false);
    this.u = false;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.c();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.u = true;
    if ((this.jdField_e_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.h();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.i();
      }
    }
    ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.b;
    if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.a(true))) {
      localProfilePerformanceReport.a(this.app.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.f();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (!this.w)
    {
      this.jdField_i_of_type_Int = this.app.getPreferences().getInt("nearby_people_profile_ok_new", 0);
      this.m = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_from_web", false);
      this.jdField_l_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("abp_flag", false);
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0) == -1)
      {
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("PUSH_CONTENT");
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800524A", "0X800524A", 0, 0, "", "", str1, "");
      }
      this.w = true;
    }
  }
  
  public void e()
  {
    Object localObject1 = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
    {
      localObject2 = (PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (!StringUtil.a(((PicInfo)localObject2).jdField_c_of_type_JavaLangString)) {
        ((ArrayList)localObject1).add(((PicInfo)localObject2).jdField_c_of_type_JavaLangString);
      }
      i1 += 1;
    }
    localObject1 = new Intent(this, PhotoListActivity.class);
    ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
    ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    ((Intent)localObject1).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    ((Intent)localObject1).putExtra("PhotoConst.IS_SINGLE_MODE", true);
    ((Intent)localObject1).putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    ((Intent)localObject1).putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    ((Intent)localObject1).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject2 = AppConstants.aK + this.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    ((Intent)localObject1).putExtra("PhotoConst.TARGET_PATH", (String)localObject2 + System.currentTimeMillis() + ".jpg");
    ((Intent)localObject1).putExtra("PhotoConst.CLIP_WIDTH", 640);
    ((Intent)localObject1).putExtra("PhotoConst.CLIP_HEIGHT", 640);
    ((Intent)localObject1).putExtra("PhotoConst.TARGET_WIDTH", 640);
    ((Intent)localObject1).putExtra("PhotoConst.TARGET_HEIGHT", 640);
    ((Intent)localObject1).putExtra("from_nearby", true);
    startActivity((Intent)localObject1);
    AlbumUtil.a(this, false, true);
    ReportController.b(this.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
  }
  
  public void f()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localUserInfo.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", getString(2131432719));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.a(this, localUserInfo, localBundle, 5);
    ReportController.b(this.app, "CliOper", "", "", "0X800481F", "0X800481F", 2, 0, "", "", "", "");
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_l_of_type_Boolean) {
      overridePendingTransition(2131034129, 2131034130);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.v) || (isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "refreshStangerFace.");
    }
    this.v = true;
    this.jdField_a_of_type_JavaLangRunnable = new afhu(this);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
  
  protected boolean isWrapContent()
  {
    boolean bool = true;
    if (this.jdField_e_of_type_Int == 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean onBackEvent()
  {
    int i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0);
    if (i1 == 1)
    {
      a(2131437744);
      return true;
    }
    if ((i1 == 2) && (this.jdField_e_of_type_Int == 1))
    {
      if (this.jdField_i_of_type_Int == 0)
      {
        a(2131437744);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a())
      {
        a(2131437745);
        return true;
      }
      c();
      return true;
    }
    if (this.jdField_l_of_type_Boolean)
    {
      localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.jdField_l_of_type_Boolean);
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
    if ((getIntent().getBooleanExtra("from_newer_guide", false)) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      Object localObject = this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 1001);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label476;
      }
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ChatMessage)((Iterator)localObject).next()).isSendFromLocal());
    }
    label466:
    label471:
    label476:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "onBackEvent hasSayHi: " + bool);
      }
      localIntent.putExtra("has_operation", bool);
      localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
      localIntent.putExtra("intent_key_has_ever_vote", this.jdField_p_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.d)))
        {
          bool = true;
          localIntent.putExtra("param_real_video_auth", bool);
        }
      }
      else
      {
        setResult(-1, localIntent);
        if (getIntent().getIntExtra("frome_where", 0) != 35) {
          break label466;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label471;
        }
        finish();
        AlbumUtil.a(this, false, false);
        return true;
        bool = false;
        break;
      }
      return super.onBackEvent();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity
 * JD-Core Version:    0.7.0.1
 */