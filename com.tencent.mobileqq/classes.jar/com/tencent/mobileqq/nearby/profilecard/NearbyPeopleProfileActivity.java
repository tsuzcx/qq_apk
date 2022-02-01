package com.tencent.mobileqq.nearby.profilecard;

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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
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
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.OnInterceptTouchEventListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  implements OnInterceptTouchEventListener
{
  public static int a;
  public static HashMap<String, Integer> a;
  public static int b;
  public static int c;
  public static int m;
  float jdField_a_of_type_Float;
  public long a;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler jdField_a_of_type_AndroidOsHandler = new NearbyPeopleProfileActivity.4(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public URLDrawable a;
  ProfileActivity.AllInOne jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
  public TopGestureLayout a;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new NearbyPeopleProfileActivity.18(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  protected FriendListObserver a;
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new NearbyPeopleProfileActivity.14(this);
  protected DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback a;
  private DynamicAvatarDownloadManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager;
  private DynamicAvatarManager jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager;
  protected AvatarObserver a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  OnDrawCompleteListener jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = new NearbyPeopleProfileActivity.24(this);
  NearbyCardHandler jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler;
  public NearbyCardObserver a;
  PicInfo jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
  private NearbyPeopleProfileActivity.DownloadHDAvatarRunnable jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$DownloadHDAvatarRunnable;
  private NearbyProfileDisplayBasePanel jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel;
  private NearbyProfileEditBasePanel jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  public String a;
  ArrayList<PicInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
  public boolean a;
  private long jdField_b_of_type_Long;
  Dialog jdField_b_of_type_AndroidAppDialog = null;
  private View jdField_b_of_type_AndroidViewView;
  protected ConditionSearchManager.IConfigListener b;
  String jdField_b_of_type_JavaLangString;
  ArrayList<PicInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  boolean jdField_b_of_type_Boolean = false;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = true;
  int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean;
  int jdField_g_of_type_Int;
  boolean jdField_g_of_type_Boolean = false;
  int jdField_h_of_type_Int;
  boolean jdField_h_of_type_Boolean = true;
  int jdField_i_of_type_Int = 0;
  boolean jdField_i_of_type_Boolean = false;
  public int j;
  boolean j;
  int jdField_k_of_type_Int = 0;
  boolean jdField_k_of_type_Boolean = true;
  int jdField_l_of_type_Int = -1;
  boolean jdField_l_of_type_Boolean = false;
  public boolean m;
  public int n;
  public boolean n;
  public int o;
  public volatile boolean o;
  private int p;
  public boolean p;
  private int jdField_q_of_type_Int = 0;
  boolean jdField_q_of_type_Boolean = false;
  private int r;
  public boolean r;
  boolean s = false;
  boolean t = false;
  boolean u = false;
  private boolean v = false;
  private boolean w;
  private boolean x = false;
  private boolean y = false;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Int = 18;
    jdField_b_of_type_Int = 12;
    jdField_c_of_type_Int = jdField_b_of_type_Int;
    jdField_m_of_type_Int = 0;
  }
  
  public NearbyPeopleProfileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_n_of_type_Int = 18;
    this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new NearbyPeopleProfileActivity.12(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new NearbyPeopleProfileActivity.13(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new NearbyPeopleProfileActivity.15(this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback = new NearbyPeopleProfileActivity.17(this);
    this.jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new NearbyPeopleProfileActivity.19(this);
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
    ReportController.b(this.app, "dc00899", "grp_lbs", "", "data_card", "up_pho", 0, 0, "", "", "", "");
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
    ThreadManager.post(new NearbyPeopleProfileActivity.3(this), 8, null, false);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 0, getString(paramInt), 2131698944, 2131698943, new NearbyPeopleProfileActivity.5(this), new NearbyPeopleProfileActivity.6(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  void a(int paramInt, Rect paramRect)
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
  
  void a(int paramInt, Rect paramRect, ArrayList<PicInfo> paramArrayList)
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
  
  void a(long paramLong)
  {
    a(paramLong, -1, -1);
  }
  
  void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = 1;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(paramLong);
    localAlphaAnimation.setAnimationListener(new NearbyPeopleProfileActivity.9(this));
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
      BounceScrollView localBounceScrollView = (BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366171);
      localBounceScrollView.setOnInterceptTouchEventListener(this);
      localBounceScrollView.post(new NearbyPeopleProfileActivity.10(this, localBounceScrollView, this.jdField_b_of_type_AndroidViewView.findViewById(2131363856).getScrollY()));
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
    paramDrawable = (NearbyLikeLimitManager)this.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, UIUtils.a(this, 150.0F));
    new NearbyCustomDialog(this).a(paramImageView, localLayoutParams).a(HardCodeUtil.a(2131707250)).b(paramDrawable.a()).a(new BlueButtonInfo(HardCodeUtil.a(2131707245), new NearbyPeopleProfileActivity.16(this))).show();
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    paramDrawable.a();
  }
  
  protected void a(NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean1, boolean paramBoolean2)
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
    {
      jdField_c_of_type_Int = jdField_a_of_type_Int;
      label118:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
          break label370;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005286", "0X8005286", 0, 0, "", "", "", "");
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
        if (!Utils.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getSafetyUin())) {
          break label452;
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("param_mode", 2);
        this.jdField_e_of_type_Int = 2;
      }
      label282:
      if (this.jdField_e_of_type_Int != 1) {
        break label501;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(0L, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId, i1);
      return;
      jdField_c_of_type_Int = jdField_b_of_type_Int;
      break label118;
      label370:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label174;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005287", "0X8005287", 0, 0, "", "", "", "");
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
      paramNearbyPeopleCard = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramNearbyPeopleCard == null) {
        break label282;
      }
      this.jdField_g_of_type_Boolean = paramNearbyPeopleCard.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getSafetyUin());
      break label282;
      label501:
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      break label301;
      break;
    }
  }
  
  void a(PicInfo paramPicInfo, Rect paramRect)
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
  
  void a(String paramString)
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
  
  void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
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
  
  void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
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
      a(2, HardCodeUtil.a(2131707249));
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
        f();
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
      e();
      ThreadManager.post(new NearbyPeopleProfileActivity.23(this), 5, null, true);
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
      if (this.jdField_a_of_type_Boolean)
      {
        c(true);
        finish();
      }
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      a(1, HardCodeUtil.a(2131707246));
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      return;
      a(1, paramString);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    a(true);
    return false;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
  
  void c()
  {
    this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 2131698948, getString(2131698947), 2131690800, 2131698946, new NearbyPeopleProfileActivity.7(this), new NearbyPeopleProfileActivity.8(this));
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.app != null)) {
      ThreadManager.post(new NearbyPeopleProfileActivity.21(this, paramString), 5, null, true);
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
        EventApiPlugin.a("nearbyUserSummaryInfoChange", localJSONObject, localArrayList, null);
        return;
      }
      catch (JSONException localJSONException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, localJSONException.toString());
  }
  
  void d()
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
      if (this.jdField_n_of_type_Boolean)
      {
        if (this.jdField_m_of_type_Boolean)
        {
          Intent localIntent = new Intent(this, NearbyActivity.class);
          localIntent.putExtra("abp_flag", this.jdField_m_of_type_Boolean);
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
    ReportController.b(this.app, "CliOper", "", "", "0X8004A1C", "0X8004A1C", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("param_no_miss", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1D", "0X8004A1D", 0, 0, "", "", "", "");
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
    if ((paramInt1 == 14) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if ((this.jdField_e_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.a(paramInt1, paramInt2, paramIntent);
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1009	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   4: ldc_w 1011
    //   7: iconst_0
    //   8: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11: pop
    //   12: aload_0
    //   13: invokevirtual 1009	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   16: ldc_w 1013
    //   19: invokevirtual 1017	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 698	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +17 -> 42
    //   28: aload_0
    //   29: invokevirtual 1009	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   32: ldc_w 1013
    //   35: ldc_w 1019
    //   38: invokevirtual 831	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   41: pop
    //   42: getstatic 1024	com/tencent/util/ProfilePerformanceReport:a	Lcom/tencent/util/ProfilePerformanceReport;
    //   45: astore 4
    //   47: aload 4
    //   49: ifnull +23 -> 72
    //   52: aload 4
    //   54: invokevirtual 1026	com/tencent/util/ProfilePerformanceReport:a	()Z
    //   57: ifeq +15 -> 72
    //   60: aload 4
    //   62: iconst_0
    //   63: invokevirtual 1028	com/tencent/util/ProfilePerformanceReport:b	(I)V
    //   66: aload 4
    //   68: iconst_1
    //   69: invokevirtual 1030	com/tencent/util/ProfilePerformanceReport:a	(I)V
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 1033	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mActNeedImmersive	Z
    //   77: aload_0
    //   78: iconst_1
    //   79: putfield 1036	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:mNeedStatusTrans	Z
    //   82: aload_1
    //   83: ifnull +11 -> 94
    //   86: aload_1
    //   87: ldc_w 1038
    //   90: aconst_null
    //   91: invokevirtual 1044	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   94: aload_0
    //   95: aload_1
    //   96: invokespecial 1046	android/support/v4/app/FragmentActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   99: pop
    //   100: aload_0
    //   101: getfield 296	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   104: aload_0
    //   105: getfield 165	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver	Lcom/tencent/mobileqq/nearby/business/NearbyCardObserver;
    //   108: invokevirtual 1050	com/tencent/mobileqq/app/QQAppInterface:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   111: aload_0
    //   112: aload_0
    //   113: invokevirtual 1009	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getIntent	()Landroid/content/Intent;
    //   116: putfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   119: aload_0
    //   120: getfield 296	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   123: invokevirtual 1053	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   126: ifeq +10 -> 136
    //   129: aload_0
    //   130: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   133: ifnonnull +9 -> 142
    //   136: aload_0
    //   137: invokevirtual 879	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   140: iconst_0
    //   141: ireturn
    //   142: aload_0
    //   143: ldc_w 1054
    //   146: invokespecial 1057	android/support/v4/app/FragmentActivity:setContentView	(I)V
    //   149: aload_0
    //   150: invokevirtual 744	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getWindow	()Landroid/view/Window;
    //   153: aconst_null
    //   154: invokevirtual 1060	android/view/Window:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   157: aload_0
    //   158: aload_0
    //   159: invokevirtual 1064	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   162: invokevirtual 1070	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   165: getfield 1075	android/util/DisplayMetrics:density	F
    //   168: putfield 1077	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Float	F
    //   171: aload_0
    //   172: aload_0
    //   173: invokevirtual 721	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getTitleBarHeight	()I
    //   176: putfield 443	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_p_of_type_Int	I
    //   179: aload_0
    //   180: aload_0
    //   181: invokevirtual 1064	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   184: invokevirtual 1070	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   187: getfield 1080	android/util/DisplayMetrics:widthPixels	I
    //   190: iconst_3
    //   191: idiv
    //   192: putfield 1082	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_f_of_type_Int	I
    //   195: aload_0
    //   196: aload_0
    //   197: invokevirtual 1064	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:getResources	()Landroid/content/res/Resources;
    //   200: invokevirtual 1070	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   203: getfield 1080	android/util/DisplayMetrics:widthPixels	I
    //   206: putfield 1084	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_g_of_type_Int	I
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 296	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   214: getstatic 1089	com/tencent/mobileqq/app/BusinessHandlerFactory:NEARBY_CARD_HANDLER	Ljava/lang/String;
    //   217: invokevirtual 1093	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   220: checkcast 686	com/tencent/mobileqq/nearby/business/NearbyCardHandler
    //   223: putfield 681	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler	Lcom/tencent/mobileqq/nearby/business/NearbyCardHandler;
    //   226: aload_0
    //   227: aload_0
    //   228: getfield 296	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   231: getstatic 1096	com/tencent/mobileqq/app/QQManagerFactory:STATUS_MANAGER	I
    //   234: invokevirtual 549	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   237: checkcast 1098	com/tencent/mobileqq/richstatus/StatusManager
    //   240: putfield 1100	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager	Lcom/tencent/mobileqq/richstatus/StatusManager;
    //   243: aload_0
    //   244: aload_0
    //   245: getfield 296	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   248: getstatic 1103	com/tencent/mobileqq/app/QQManagerFactory:CONDITION_SEARCH_MANAGER	I
    //   251: invokevirtual 549	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   254: checkcast 1105	com/tencent/mobileqq/app/ConditionSearchManager
    //   257: putfield 1107	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   260: aload_0
    //   261: getfield 1107	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   264: aload_0
    //   265: invokevirtual 1110	com/tencent/mobileqq/app/ConditionSearchManager:a	(Ljava/lang/Object;)V
    //   268: aload_0
    //   269: getfield 1107	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   272: aload_0
    //   273: getfield 189	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener	Lcom/tencent/mobileqq/app/ConditionSearchManager$IConfigListener;
    //   276: invokevirtual 1112	com/tencent/mobileqq/app/ConditionSearchManager:c	(Ljava/lang/Object;)V
    //   279: aload_0
    //   280: aload_0
    //   281: getfield 296	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   284: getstatic 1115	com/tencent/mobileqq/app/QQManagerFactory:DYNAMIC_AVATAR_MANAGER	I
    //   287: invokevirtual 549	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   290: checkcast 1117	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager
    //   293: putfield 1119	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   296: aload_0
    //   297: aload_0
    //   298: getfield 1119	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   301: invokevirtual 1122	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	()Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager;
    //   304: putfield 218	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager;
    //   307: aload_0
    //   308: getfield 1119	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   311: iconst_4
    //   312: invokevirtual 1123	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	(I)Z
    //   315: ifeq +118 -> 433
    //   318: aload_0
    //   319: getfield 1119	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   322: invokevirtual 1124	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	()Z
    //   325: ifeq +108 -> 433
    //   328: iconst_1
    //   329: istore_3
    //   330: aload_0
    //   331: iload_3
    //   332: putfield 1126	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_p_of_type_Boolean	Z
    //   335: aload_0
    //   336: getfield 1119	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   339: invokevirtual 1129	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	()Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarConfig;
    //   342: ifnull +39 -> 381
    //   345: aload_0
    //   346: aload_0
    //   347: getfield 1119	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager;
    //   350: invokevirtual 1129	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	()Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarConfig;
    //   353: getfield 1133	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarConfig:jdField_d_of_type_Int	I
    //   356: putfield 128	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   359: aload_0
    //   360: getfield 128	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   363: iflt +12 -> 375
    //   366: aload_0
    //   367: getfield 128	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   370: bipush 30
    //   372: if_icmple +9 -> 381
    //   375: aload_0
    //   376: bipush 18
    //   378: putfield 128	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_n_of_type_Int	I
    //   381: aload_0
    //   382: aload_0
    //   383: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   386: ldc 242
    //   388: invokevirtual 1137	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   391: checkcast 612	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   394: putfield 605	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   397: aload_0
    //   398: getfield 605	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   401: ifnonnull +77 -> 478
    //   404: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +13 -> 420
    //   410: ldc_w 390
    //   413: iconst_2
    //   414: ldc_w 1139
    //   417: invokestatic 779	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload_0
    //   421: invokevirtual 879	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   424: iconst_1
    //   425: ireturn
    //   426: astore_1
    //   427: aload_0
    //   428: invokevirtual 879	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:finish	()V
    //   431: iconst_0
    //   432: ireturn
    //   433: iconst_0
    //   434: istore_3
    //   435: goto -105 -> 330
    //   438: astore_1
    //   439: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq -45 -> 397
    //   445: ldc_w 390
    //   448: iconst_2
    //   449: new 369	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 1141
    //   459: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_1
    //   463: invokevirtual 1144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   466: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 779	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: goto -78 -> 397
    //   478: aload_0
    //   479: aload_0
    //   480: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   483: ldc 252
    //   485: iconst_0
    //   486: invokevirtual 959	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   489: putfield 116	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   492: aload_0
    //   493: getfield 116	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   496: bipush 35
    //   498: if_icmpne +9 -> 507
    //   501: aload_0
    //   502: iconst_0
    //   503: iconst_1
    //   504: invokestatic 1150	com/tencent/mobileqq/utils/AlbumUtil:anim	(Landroid/app/Activity;ZZ)V
    //   507: aload_0
    //   508: getfield 116	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   511: invokestatic 315	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Z
    //   514: ifeq +373 -> 887
    //   517: aload_0
    //   518: bipush 51
    //   520: putfield 1151	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_d_of_type_Int	I
    //   523: aload_0
    //   524: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   527: ldc_w 677
    //   530: iconst_0
    //   531: invokevirtual 959	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   534: istore_2
    //   535: iload_2
    //   536: iconst_2
    //   537: if_icmpeq +8 -> 545
    //   540: iload_2
    //   541: iconst_1
    //   542: if_icmpne +30 -> 572
    //   545: aload_0
    //   546: getfield 605	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   549: getfield 614	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   552: invokestatic 698	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   555: ifeq +17 -> 572
    //   558: aload_0
    //   559: getfield 605	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   562: aload_0
    //   563: getfield 296	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   566: invokevirtual 1154	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   569: putfield 614	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   572: aload_0
    //   573: aload_0
    //   574: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   577: ldc_w 677
    //   580: iconst_0
    //   581: invokevirtual 959	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   584: putfield 452	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_Int	I
    //   587: aload_0
    //   588: aload_0
    //   589: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   592: ldc_w 1156
    //   595: iconst_0
    //   596: invokevirtual 979	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   599: putfield 106	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Boolean	Z
    //   602: aload_0
    //   603: aload_0
    //   604: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   607: ldc_w 1158
    //   610: lconst_0
    //   611: invokevirtual 1162	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   614: putfield 1164	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Long	J
    //   617: aload_0
    //   618: aload_0
    //   619: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   622: ldc_w 1166
    //   625: lconst_0
    //   626: invokevirtual 1162	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   629: putfield 208	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_Long	J
    //   632: aload_0
    //   633: aload_0
    //   634: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   637: ldc_w 1168
    //   640: iconst_0
    //   641: invokevirtual 959	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   644: putfield 205	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:r	I
    //   647: aload_0
    //   648: aload_0
    //   649: ldc_w 1169
    //   652: invokevirtual 1170	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:findViewById	(I)Landroid/view/View;
    //   655: checkcast 476	android/view/ViewGroup
    //   658: putfield 215	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   661: aload_0
    //   662: getfield 452	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_e_of_type_Int	I
    //   665: iconst_1
    //   666: if_icmpne +250 -> 916
    //   669: aload_0
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 116	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   675: invokevirtual 486	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileEditBasePanel;
    //   678: putfield 228	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel	Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileEditBasePanel;
    //   681: aload_0
    //   682: aload_0
    //   683: getfield 228	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel	Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileEditBasePanel;
    //   686: invokevirtual 489	com/tencent/mobileqq/nearby/profilecard/NearbyProfileEditBasePanel:a	()Landroid/view/View;
    //   689: putfield 211	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   692: aload_0
    //   693: getfield 215	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   696: aload_0
    //   697: getfield 211	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   700: new 491	android/widget/FrameLayout$LayoutParams
    //   703: dup
    //   704: iconst_m1
    //   705: iconst_m1
    //   706: invokespecial 494	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   709: invokevirtual 498	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   712: aload_0
    //   713: aload_0
    //   714: getfield 118	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_k_of_type_Int	I
    //   717: iconst_1
    //   718: iadd
    //   719: putfield 118	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_k_of_type_Int	I
    //   722: aload_0
    //   723: iconst_1
    //   724: putfield 88	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Boolean	Z
    //   727: aload_0
    //   728: getfield 218	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager;
    //   731: ifnull +14 -> 745
    //   734: aload_0
    //   735: getfield 218	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager;
    //   738: aload_0
    //   739: getfield 170	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback	Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback;
    //   742: invokevirtual 1175	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager:a	(Lcom/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarDownloadManager$IDynamicAvatarDownloadCallback;)V
    //   745: aload_0
    //   746: ldc_w 1176
    //   749: invokestatic 573	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   752: invokevirtual 1177	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(Ljava/lang/String;)V
    //   755: new 1179	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$1
    //   758: dup
    //   759: aload_0
    //   760: invokespecial 1180	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$1:<init>	(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;)V
    //   763: iconst_5
    //   764: aconst_null
    //   765: iconst_0
    //   766: invokestatic 337	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   769: aload 4
    //   771: ifnull +17 -> 788
    //   774: aload 4
    //   776: invokevirtual 1026	com/tencent/util/ProfilePerformanceReport:a	()Z
    //   779: ifeq +9 -> 788
    //   782: aload 4
    //   784: iconst_4
    //   785: invokevirtual 1030	com/tencent/util/ProfilePerformanceReport:a	(I)V
    //   788: new 1182	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$2
    //   791: dup
    //   792: aload_0
    //   793: aload 4
    //   795: invokespecial 1185	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity$2:<init>	(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;Lcom/tencent/util/ProfilePerformanceReport;)V
    //   798: bipush 8
    //   800: aconst_null
    //   801: iconst_0
    //   802: invokestatic 337	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   805: aload_0
    //   806: getfield 296	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   809: getstatic 1188	com/tencent/mobileqq/app/QQManagerFactory:DATING_PROXY_MANAGER	I
    //   812: invokevirtual 549	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   815: checkcast 1190	com/tencent/mobileqq/dating/DatingProxyManager
    //   818: astore_1
    //   819: aload_1
    //   820: invokevirtual 1193	com/tencent/mobileqq/dating/DatingProxyManager:a	()Lcom/tencent/mobileqq/dating/widget/VoteEventMgr;
    //   823: invokevirtual 1197	com/tencent/mobileqq/dating/widget/VoteEventMgr:a	()I
    //   826: ifle +10 -> 836
    //   829: aload_1
    //   830: invokevirtual 1193	com/tencent/mobileqq/dating/DatingProxyManager:a	()Lcom/tencent/mobileqq/dating/widget/VoteEventMgr;
    //   833: invokevirtual 1198	com/tencent/mobileqq/dating/widget/VoteEventMgr:a	()V
    //   836: aload_0
    //   837: getfield 605	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   840: ifnull +16 -> 856
    //   843: aload_0
    //   844: getfield 605	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   847: getfield 1200	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   850: sipush 999
    //   853: if_icmpne +184 -> 1037
    //   856: bipush 30
    //   858: istore_2
    //   859: aload_0
    //   860: getfield 296	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   863: aload_0
    //   864: invokevirtual 1206	java/lang/Object:getClass	()Ljava/lang/Class;
    //   867: aload_0
    //   868: invokevirtual 1209	java/lang/Object:hashCode	()I
    //   871: ldc_w 1211
    //   874: iload_2
    //   875: aload_0
    //   876: getfield 1164	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_Long	J
    //   879: invokestatic 1216	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   882: invokestatic 1221	com/tencent/mobileqq/statistics/ViewExposeUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/Class;ILjava/lang/String;ILjava/lang/String;)V
    //   885: iconst_1
    //   886: ireturn
    //   887: aload_0
    //   888: aload_0
    //   889: getfield 605	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   892: getfield 1200	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   895: putfield 1151	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_d_of_type_Int	I
    //   898: aload_0
    //   899: aload_0
    //   900: aload_0
    //   901: getfield 605	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   904: getfield 1200	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   907: invokevirtual 1223	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)I
    //   910: putfield 116	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   913: goto -390 -> 523
    //   916: aload_0
    //   917: aload_0
    //   918: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   921: ldc_w 1225
    //   924: invokevirtual 1017	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   927: putfield 1226	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   930: aload_0
    //   931: aload_0
    //   932: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   935: ldc_w 1228
    //   938: iconst_0
    //   939: invokevirtual 959	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   942: putfield 1229	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_h_of_type_Int	I
    //   945: aload_0
    //   946: aload_0
    //   947: getfield 675	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   950: ldc_w 1231
    //   953: iconst_0
    //   954: invokevirtual 979	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   957: putfield 1233	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_f_of_type_Boolean	Z
    //   960: aload_0
    //   961: aload_0
    //   962: aload_0
    //   963: getfield 116	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_j_of_type_Int	I
    //   966: invokevirtual 1235	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:a	(I)Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel;
    //   969: putfield 224	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel	Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel;
    //   972: aload_0
    //   973: aload_0
    //   974: getfield 224	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel	Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel;
    //   977: invokevirtual 1236	com/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel:a	()Landroid/view/View;
    //   980: putfield 292	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   983: aload_0
    //   984: getfield 224	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel	Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel;
    //   987: invokevirtual 1237	com/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayBasePanel:a	()V
    //   990: aload_0
    //   991: getfield 292	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   994: instanceof 1239
    //   997: ifeq +17 -> 1014
    //   1000: aload_0
    //   1001: getfield 292	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1004: checkcast 1239	com/tencent/mobileqq/widget/PerfRelativeLayout
    //   1007: aload_0
    //   1008: getfield 202	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener	Lcom/tencent/mobileqq/fpsreport/OnDrawCompleteListener;
    //   1011: invokevirtual 1243	com/tencent/mobileqq/widget/PerfRelativeLayout:setOnDrawCompleteListener	(Lcom/tencent/mobileqq/fpsreport/OnDrawCompleteListener;)V
    //   1014: aload_0
    //   1015: getfield 215	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   1018: aload_0
    //   1019: getfield 292	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   1022: new 491	android/widget/FrameLayout$LayoutParams
    //   1025: dup
    //   1026: iconst_m1
    //   1027: iconst_m1
    //   1028: invokespecial 494	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   1031: invokevirtual 498	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1034: goto -307 -> 727
    //   1037: aload_0
    //   1038: getfield 605	com/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1041: getfield 1200	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1044: istore_2
    //   1045: goto -186 -> 859
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1048	0	this	NearbyPeopleProfileActivity
    //   0	1048	1	paramBundle	Bundle
    //   534	511	2	i1	int
    //   329	106	3	bool	boolean
    //   45	749	4	localProfilePerformanceReport	ProfilePerformanceReport
    // Exception table:
    //   from	to	target	type
    //   142	149	426	java/lang/OutOfMemoryError
    //   381	397	438	java/lang/Exception
  }
  
  public void doOnDestroy()
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
    if (this.app.getNearbyProxy().jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i1 = this.app.getNearbyProxy().jdField_a_of_type_JavaUtilArrayList.size();; i1 = 0)
    {
      int i2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null)
      {
        i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.b();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.g();
      }
      for (;;)
      {
        Object localObject = (NearbyPeoplePhotoUploadProcessor)((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).findProcessor(null, 0L);
        if (localObject != null) {
          ((NearbyPeoplePhotoUploadProcessor)localObject).cancelTask();
        }
        try
        {
          if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0) == -2)
          {
            if (this.jdField_q_of_type_Int > 0) {
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
              ReportController.b(this.app, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, String.valueOf(this.jdField_a_of_type_Long), Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_b_of_type_Long), "", "");
              int i3 = (int)(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_b_of_type_Long) / 1000;
              if (NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int, this.jdField_e_of_type_Int)) {
                this.app.getNearbyProxy().a(this.jdField_a_of_type_Long, i3, i1, i2);
              }
            }
            if (!Build.BRAND.startsWith("samsung")) {
              break label479;
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
        label479:
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
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a((PicInfo)localObject)) {
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
    ((Bundle)localObject).putString("key_title", getString(2131717795));
    ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
    ((Bundle)localObject).putBoolean("show_album", false);
    ((Bundle)localObject).putString("key_jump_album_id", this.jdField_d_of_type_JavaLangString);
    ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.forwardToPersonalAlbumSelect(this, paramIntent, (Bundle)localObject, 5);
    return;
    label233:
    NearbyPublishMenuHelper.a(this, 1000, -1, paramIntent);
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
    InputMethodUtil.a(this);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.e();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.d();
    }
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
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
      this.w = true;
      NearbyCardManager localNearbyCardManager = (NearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.jdField_a_of_type_Boolean))
      {
        localNearbyCardManager.d.put(this.app.getCurrentAccountUin(), Integer.valueOf(1));
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.jdField_a_of_type_Boolean = false;
      }
      this.jdField_k_of_type_Boolean = localNearbyCardManager.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
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
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.c();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.w = false;
    this.v = true;
    if ((this.jdField_e_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.h();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.i();
      }
    }
    ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.a;
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
    if (!this.y)
    {
      this.jdField_i_of_type_Int = this.app.getPreferences().getInt("nearby_people_profile_ok_new", 0);
      this.jdField_n_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("is_from_web", false);
      this.jdField_m_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("abp_flag", false);
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 0) == -1)
      {
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("PUSH_CONTENT");
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800524A", "0X800524A", 0, 0, "", "", str1, "");
      }
      this.y = true;
    }
  }
  
  protected void e()
  {
    if (this.jdField_e_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayBasePanel.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      }
      return;
    }
    this.jdField_e_of_type_Int = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.jdField_a_of_type_Boolean = false;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new NearbyPeopleProfileActivity.11(this));
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  protected void f()
  {
    NearPeopleFilters localNearPeopleFilters = new NearPeopleFilters();
    localNearPeopleFilters.jdField_a_of_type_Int = -1;
    NearPeopleFilters.a(this.app.getCurrentAccountUin(), localNearPeopleFilters);
    this.jdField_i_of_type_Int = 1;
    this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", 1).commit();
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_m_of_type_Boolean) {
      overridePendingTransition(2130771990, 2130771991);
    }
  }
  
  protected void g()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.tribeAppDownload", 2, "showUploadPhotoActionSheet, isAddPicBtnDownloadAppOpen=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAddPicBtnDownloadAppOpen() + ", addPicBtnDownloadAppTips:" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
    }
    String[] arrayOfString = getResources().getStringArray(2130968636);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAddPicBtnDownloadAppOpen()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl)))
    {
      NearbyCardManager.a(this, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addPicBtnDownloadAppTips, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl, 2);
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(this);
    localActionSheet.addButton(arrayOfString[28]);
    localActionSheet.addButton(arrayOfString[29]);
    localActionSheet.addCancelButton(arrayOfString[16]);
    localActionSheet.setOnButtonClickListener(new NearbyPeopleProfileActivity.20(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void i()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.app.getCurrentAccountUin();
    localUserInfo.nickname = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", getString(2131717795));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.forwardToPersonalAlbumSelect(this, localUserInfo, localBundle, 5);
    ReportController.b(this.app, "CliOper", "", "", "0X800481F", "0X800481F", 2, 0, "", "", "", "");
  }
  
  public boolean isWrapContent()
  {
    boolean bool = true;
    if (this.jdField_e_of_type_Int == 1) {
      bool = false;
    }
    return bool;
  }
  
  void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.x) || (isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "refreshStangerFace.");
    }
    this.x = true;
    this.jdField_a_of_type_JavaLangRunnable = new NearbyPeopleProfileActivity.22(this);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
  
  public boolean onBackEvent()
  {
    int i1 = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_mode", 0);
    if (i1 == 1)
    {
      a(2131698949);
      return true;
    }
    if ((i1 == 2) && (this.jdField_e_of_type_Int == 1))
    {
      if (this.jdField_i_of_type_Int == 0)
      {
        a(2131698949);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditBasePanel.a())
      {
        a(2131698945);
        return true;
      }
      d();
      return true;
    }
    if (this.jdField_m_of_type_Boolean)
    {
      localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.jdField_m_of_type_Boolean);
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
      localObject = this.app.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 1001);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label563;
      }
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ChatMessage)((Iterator)localObject).next()).isSendFromLocal());
    }
    label558:
    label563:
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
          break label509;
        }
        bool = true;
      }
      for (;;)
      {
        localIntent.putExtra("param_real_video_auth", bool);
        localObject = new nearby.Cmd0x1RspBody();
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo != null) {
            ((nearby.Cmd0x1RspBody)localObject).mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
          }
          localIntent.putExtra("follow_flag", ((nearby.Cmd0x1RspBody)localObject).bool_follow.get());
          setResult(-1, localIntent);
          if (getIntent().getIntExtra("frome_where", 0) == 35)
          {
            i1 = 1;
            if (i1 == 0) {
              break label558;
            }
            finish();
            AlbumUtil.anim(this, false, false);
            return true;
            label509:
            bool = false;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e("Q.nearby_people_card.", 2, "Cmd0x1RspBody merge error !:" + localInvalidProtocolBufferMicroException);
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