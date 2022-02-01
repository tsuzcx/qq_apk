package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.jungle.nearby.nio.proto.nearby.FansInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.CikeConfigData;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.now.NowSmallVideoObserver;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.widget.AutoScrollImageView;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.ViewHolder;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.nearby.widget.NearbyAppDownloadDialog;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.OnItemClickListener;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profilecard.entity.ProfileBusiEntry;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.NestViewPager;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowReq;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.GridView;
import com.tencent.widget.ScrollView;
import com.tencent.widget.ScrollView.OnScrollStateChangedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NowAnchorState;

public class NearbyProfileDisplayPanel
  extends NearbyProfileDisplayBasePanel
  implements View.OnClickListener, DecodeTaskCompletionListener, OnTagClickListener, TabBarView.OnTabChangeListener, ScrollView.OnScrollStateChangedListener
{
  public static String[] a;
  public static String[] b;
  int jdField_a_of_type_Int = 0;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new NearbyProfileDisplayPanel.38(this);
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new NearbyProfileDisplayPanel.1(this);
  Handler jdField_a_of_type_AndroidOsHandler = new NearbyProfileDisplayPanel.37(this);
  protected FragmentManager a;
  ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new NearbyProfileDisplayPanel.6(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new NearbyProfileDisplayPanel.32(this);
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new NearbyProfileDisplayPanel.5(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  protected ImageView a;
  protected LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NewVoteAnimHelper jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  NowSmallVideoObserver jdField_a_of_type_ComTencentMobileqqNearbyNowNowSmallVideoObserver = new NearbyProfileDisplayPanel.34(this);
  private NearbyCardVoteView jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
  NearbyPeopleProfileActivity jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
  private NearbyProfileDisplayPanel.AvatarWallAdapter jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$AvatarWallAdapter;
  protected NearbyProfileFragment a;
  private NestScrollLayout jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout;
  ProfileQiqiLiveController jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController = null;
  protected NearbyMomentFragment a;
  private AutoScrollImageView jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
  NearbyPublishMenu.OnItemClickListener jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyPublishMenu$OnItemClickListener = new NearbyProfileDisplayPanel.31(this);
  protected ProfileBusiEntry a;
  protected NestViewPager a;
  ProgressButton jdField_a_of_type_ComTencentMobileqqWidgetProgressButton;
  protected TabBarView a;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new NearbyProfileDisplayPanel.39(this);
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  String jdField_a_of_type_JavaLangString = "";
  protected ArrayList<Fragment> a;
  private List<PicInfo> jdField_a_of_type_JavaUtilList;
  protected final Map<String, View> a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean b;
  int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean c;
  int jdField_d_of_type_Int = 0;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  public boolean d;
  int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  protected String e;
  public boolean e;
  int jdField_f_of_type_Int = -1;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  public boolean f;
  private int jdField_g_of_type_Int;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  private TextView h;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  boolean l = true;
  boolean m = true;
  boolean n = false;
  boolean o = false;
  boolean p = false;
  boolean q = false;
  boolean r = false;
  boolean s = false;
  protected boolean t = true;
  private boolean u;
  private boolean v;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0X800553B", "0X800553C", "0X800553D", "0X800553E", "0X800553F", "0X8005540", "0X8005541" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "0X8005542", "0X8005543", "0X8005544", "0X8005545", "0X8005546", "0X8005547", "0X8005548" };
  }
  
  public NearbyProfileDisplayPanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (paramNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) == 35) {}
    for (;;)
    {
      this.o = bool;
      this.n = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_werewolves", false);
      this.v = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_now_plugin", false);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramNearbyPeopleProfileActivity.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramNearbyPeopleProfileActivity.app);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
      n();
      return;
      bool = false;
    }
  }
  
  private TextView a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, -1, 0);
  }
  
  private TextView a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    int i1 = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
    int i2 = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
    int i3 = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setTextSize(1, 10.0F);
    Object localObject = new LinearLayout.LayoutParams(-2, i2);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F), 0);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(paramInt1);
    ((GradientDrawable)localObject).setCornerRadius(i3);
    localTextView.setBackgroundDrawable((Drawable)localObject);
    localTextView.setTextColor(Color.parseColor("#FFFFFFFF"));
    localTextView.setText(paramString);
    localTextView.setPadding(i1, 0, i1, 0);
    localTextView.setGravity(17);
    if (paramInt2 > 0)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(paramInt2), null, null, null);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView.setCompoundDrawablePadding(paramInt3);
      }
    }
    return localTextView;
  }
  
  private GridView a(List<PicInfo> paramList, int paramInt)
  {
    GridView localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
    paramList = new NearbyProfileDisplayPanel.AvatarGridViewAdapter(this, paramList, paramInt);
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    paramInt = AIOUtils.a(1.0F, localResources);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int = ((localResources.getDisplayMetrics().widthPixels - paramInt * 2) / 3);
    localGridView.setNumColumns(3);
    localGridView.setStretchMode(2);
    localGridView.setSelector(new ColorDrawable(0));
    localGridView.setHorizontalSpacing(paramInt);
    localGridView.setVerticalSpacing(paramInt);
    localGridView.setAdapter(paramList);
    return localGridView;
  }
  
  private String a()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
    }
    return str;
  }
  
  private void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("operation", paramInt);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("nearby.qq.com");
      EventApiPlugin.a("nearbyYanzhiCallback", localJSONObject, localArrayList, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyProfileDisplayPanel", 2, localJSONException.toString());
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_live_status.get() == 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setImageBitmap(paramBitmap);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setVisibility(0);
    }
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_live_status.get() == 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView != null))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = 640;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = 640;
      paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      if (paramString.getStatus() != 1) {
        break label113;
      }
      localObject = paramString.getCurrDrawable();
      if ((localObject instanceof RegionDrawable))
      {
        localObject = ((RegionDrawable)localObject).getBitmap();
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setImageBitmap((Bitmap)localObject);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.12(this, paramString), 128, null, true);
      return;
      label113:
      paramString.setURLDrawableListener(new NearbyProfileDisplayPanel.11(this));
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Int == 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getNearbyProxy().a();
      paramString3 = str;
      if (str == null) {
        paramString3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131698678);
      }
      AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, paramString1, paramString3, 1010);
    }
    paramString1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ChatActivity.class);
    paramString1.putExtra("PREVIOUS_WINDOW", NearbyPeopleProfileActivity.class.getName());
    paramString1.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    paramString1.putExtra("NEARBY_MSG_REPORT_SOURCE", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getStringExtra("NEARBY_MSG_REPORT_SOURCE"));
    paramString1.putExtra("cSpecialFlag", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("cSpecialFlag"));
    paramString1.putExtra("uin", paramString2);
    paramString1.putExtra("uintype", paramInt);
    paramString1.putExtra("ProfileCard_flag", "ProfileCard");
    paramString1.putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.j != 0) {
      paramString1.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.j);
    }
    if (paramInt == 1001)
    {
      paramString1.putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
      paramString1.putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
    }
    for (;;)
    {
      paramString1.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString);
      paramString1.addFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString1);
      return;
      if (paramInt == 1010)
      {
        paramString1.putExtra("rich_date_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        paramString1.putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      }
    }
  }
  
  private byte[] a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Int != 51) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getMsgCache().m(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length != 0) {}
    }
    else
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_Int == 51) {
        localObject2 = this.jdField_a_of_type_ArrayOfByte;
      }
    }
    if ((localObject2 == null) && (QLog.isColorLevel())) {
      QLog.e("Q.nearby_people_card.", 2, "nearbySig is null ");
    }
    return localObject2;
  }
  
  private void b(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = String.format("https://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin });
    }
    paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, MusicGeneQQBrowserActivity.class);
    paramString.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin());
    paramString.putExtra("url", (String)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject = Calendar.getInstance();
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.nearby_people_card.", 4, "musicgene123 startactivity " + (String)localObject);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004182 ", "0X8004182", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  private int c()
  {
    int i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getIntExtra("frome_where", 6);
    int i1;
    if (i2 > 0)
    {
      i1 = i2;
      if (i2 < 6) {}
    }
    else
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int;
      if (i1 != 5) {
        break label47;
      }
      i1 = 1;
    }
    return i1;
    label47:
    if (ProfileActivity.c(i1)) {
      return 3;
    }
    if (((i1 >= 10) && (i1 <= 19)) || (i1 == 30)) {
      return 2;
    }
    return 6;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    switch (paramInt2)
    {
    default: 
      if (i1 == 0) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      break;
    }
    label135:
    Object localObject2;
    Object localObject1;
    label190:
    do
    {
      return;
      i1 = 2131699086;
      break;
      i1 = 2131698677;
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_gift", 0, 0, "", "", "", "");
      break;
      if (this.u)
      {
        i1 = 2131696349;
        localObject2 = a();
        if (!this.u) {
          break label190;
        }
      }
      for (localObject1 = "exp_followed";; localObject1 = "exp_follow")
      {
        ReportController.b(null, "dc00899", "grp_lbs", (String)localObject2, "data_card", (String)localObject1, 0, 0, "", "", "", "");
        break;
        i1 = 2131696347;
        break label135;
      }
      i1 = 2131719035;
      localObject1 = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1).findViewById(2131380726);
      ((Button)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167066));
      ((Button)localObject1).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845814));
      ReportController.b(null, "dc00899", "grp_lbs", a(), "data_card", "exp_msg", 0, 0, "", "", "", "");
      break;
      i1 = 2131693348;
      break;
      i1 = 2131694450;
      break;
      i1 = 2131698688;
      break;
      localObject1 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
      ((View)localObject1).setVisibility(0);
      if (paramInt2 == 40) {
        break label551;
      }
      localObject2 = (Button)((View)localObject1).findViewById(2131380726);
      ((Button)localObject2).setText(i1);
      if (paramInt2 == 38)
      {
        ((Button)localObject2).setBackgroundResource(2130850453);
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165609));
      }
      ((Button)localObject2).setOnClickListener(this);
      DataTag localDataTag = new DataTag(paramInt2, null);
      ((Button)localObject2).setTag(localDataTag);
      ((View)localObject1).setTag(localDataTag);
      if ((paramInt2 == 60) && (this.u))
      {
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167068));
        ((Button)localObject2).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839463));
        return;
      }
      if ((paramInt2 == 8) && (this.jdField_d_of_type_Int != 0) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
      {
        ((Button)localObject2).setBackgroundResource(2130850453);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
    } while ((paramInt2 != 36) || (!this.q) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean));
    ((Button)localObject2).setBackgroundResource(2130850453);
    ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
    return;
    label551:
    ((View)localObject1).setVisibility(8);
  }
  
  private int d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      return 1001;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L) {
      return 0;
    }
    return ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
  }
  
  private void n()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mRequestWidth = ((int)DeviceInfoUtil.k());
    localURLDrawableOptions.mRequestHeight = (localURLDrawableOptions.mRequestWidth / 2);
    URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif", localURLDrawableOptions);
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender;
    Object localObject2;
    if ((i1 == 0) || (i1 == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0))
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (i1 == 1)
      {
        localObject1 = "#ffffafea";
        int i2 = Color.parseColor((String)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age <= 0) {
          break label568;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age + HardCodeUtil.a(2131707335);
        label94:
        ((LinearLayout)localObject2).addView(a(i2, (String)localObject1, NearbyProfileUtil.a(i1), UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 3.0F)));
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
        break label574;
      }
      localObject1 = "1";
      label143:
      ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_info", 0, 0, (String)localObject1, "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation >= 1) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation <= 12))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(Color.parseColor("#ffbfa4f6"), NearbyProfileUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation)));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label581;
        }
        localObject1 = "1";
        label245:
        ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_xing", 0, 0, (String)localObject1, "", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus >= 2) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus <= 5))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(Color.parseColor("#ff89e1b5"), NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1)));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label588;
        }
      }
    }
    label568:
    label574:
    label581:
    label588:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_relation", 0, 0, (String)localObject1, "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.is_authen.get() == 1))
      {
        localObject1 = a(Color.parseColor("#000000"), HardCodeUtil.a(2131707298), 2130845728, UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 3.0F));
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] { Color.parseColor("#ffa98df7"), Color.parseColor("#ff8aafff") });
        ((GradientDrawable)localObject2).setCornerRadius(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
        ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
        ((TextView)localObject1).setOnClickListener(new NearbyProfileDisplayPanel.15(this));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("cike_icon_exp").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId)).a();
      }
      return;
      localObject1 = "#ff96beff";
      break;
      localObject1 = "";
      break label94;
      localObject1 = "2";
      break label143;
      localObject1 = "2";
      break label245;
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new NearbyProfileDisplayPanel.16(this));
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, false);
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
        break label253;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vCookies, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), 0);
        bool = ((NearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue());
        if (PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app) <= 0) {
          break label239;
        }
        if (!bool) {
          break label234;
        }
        i1 = 3;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "P_prof", "Prof_good", 2, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), i1, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), String.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      }
    }
    label234:
    label239:
    label253:
    while ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)) {
      for (;;)
      {
        boolean bool;
        return;
        i1 = 2;
        continue;
        if (bool) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      }
    }
    ArrayList localArrayList = new ArrayList();
    NearbyLikeLimitManager.LikeItem localLikeItem = new NearbyLikeLimitManager.LikeItem();
    localLikeItem.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    localLikeItem.jdField_b_of_type_Int = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    localLikeItem.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue();
    localLikeItem.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource;
    localArrayList.add(localLikeItem);
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {}
    for (int i1 = 510;; i1 = 509)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(localArrayList, i1);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      return;
    }
  }
  
  protected int a()
  {
    return 2131561377;
  }
  
  View a(int paramInt, PicInfo paramPicInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayPanel", 2, "getAvatarWallItemView, position = " + paramInt + ", info = " + paramPicInfo.toString());
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
    CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.addView(localCustomImgView, new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int));
    Object localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((ImageView)localObject1).setBackgroundResource(2130841485);
    ((ImageView)localObject1).setImageResource(2130846155);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setVisibility(8);
    int i1 = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 24.0F);
    Object localObject2 = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845178));
    localCustomImgView.setTag(paramPicInfo);
    localCustomImgView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.jdField_d_of_type_Boolean) {
      localRelativeLayout.setContentDescription(HardCodeUtil.a(2131707259) + paramInt);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845993);
    try
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p) || (TextUtils.isEmpty(paramPicInfo.jdField_d_of_type_JavaLangString))) {
        break label524;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramPicInfo.jdField_d_of_type_JavaLangString, localRelativeLayout);
      if (DynamicAvatarDownloadManager.b(paramPicInfo.jdField_d_of_type_JavaLangString))
      {
        localRelativeLayout.getChildAt(1).setVisibility(8);
        a(paramPicInfo, localRelativeLayout);
        return localRelativeLayout;
      }
      if (!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity)) {
        break label511;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c(paramPicInfo.jdField_d_of_type_JavaLangString);
      localRelativeLayout.getChildAt(1).setVisibility(0);
    }
    catch (MalformedURLException paramPicInfo)
    {
      while (QLog.isColorLevel())
      {
        QLog.d("Q.nearby_people_card.", 2, "PicGallery.getView() new URL(). " + paramPicInfo.getMessage(), paramPicInfo);
        return localRelativeLayout;
        label511:
        localRelativeLayout.getChildAt(1).setVisibility(0);
        continue;
        label524:
        localRelativeLayout.getChildAt(1).setVisibility(8);
      }
      if (StringUtil.a(paramPicInfo.jdField_a_of_type_JavaLangString)) {
        break label632;
      }
      paramPicInfo = NearbyImgDownloader.convertURL(paramPicInfo.jdField_a_of_type_JavaLangString);
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      paramPicInfo = URLDrawable.getDrawable(paramPicInfo, (URLDrawable.URLDrawableOptions)localObject2);
      paramPicInfo.setDownloadListener(new ImgDownloadListener(BaseApplicationImpl.getApplication(), "actNearbyPeoplePicDownload"));
      localCustomImgView.setImageDrawable(paramPicInfo);
      return localRelativeLayout;
      label632:
      if (paramPicInfo.g != "type_qq_head_pic") {
        break label660;
      }
      localCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840453));
    }
    if ((paramPicInfo.jdField_c_of_type_JavaLangString != null) && (paramPicInfo.jdField_c_of_type_JavaLangString.length() > 0))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(new File(paramPicInfo.jdField_c_of_type_JavaLangString).toURL(), (URLDrawable.URLDrawableOptions)localObject2));
      return localRelativeLayout;
    }
    label660:
    return localRelativeLayout;
  }
  
  public void a()
  {
    DownloadApi.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(paramInt2, false);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) || (paramInt1 == 1001))
    {
      NearbyPublishMenuHelper.a(this.jdField_a_of_type_AndroidContentContext, paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a = true;
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 1002) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a = true;
          break;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(-1);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
          return;
        } while (paramIntent == null);
        return;
      } while (paramInt2 != -1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 25;
      i();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "NearbyPeopleProfileActivity->doOnActivityResult, resultCode=" + paramInt2);
      }
      if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
        paramInt1 = 510;
      }
      for (;;)
      {
        paramIntent = (NearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
        long l2 = 0L;
        try
        {
          l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          paramIntent.a(l1, 0L, paramInt1);
          return;
          paramInt1 = 509;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            long l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.e("NearbyLikeLimitManager", 2, "doOnActivityResult req NearbyLikeLimitInfo: mCard.uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
              l1 = l2;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "doOnActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
      }
    } while (paramInt2 != -1);
    for (;;)
    {
      try
      {
        for (;;)
        {
          this.jdField_d_of_type_Int = 0;
          this.p = false;
          paramInt2 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            paramIntent = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
            if ((!(paramIntent.getTag() instanceof DataTag)) || (((DataTag)paramIntent.getTag()).jdField_a_of_type_Int != 8)) {
              break label589;
            }
            if (QLog.isColorLevel()) {
              QLog.d("nearby.bindphone", 2, "updateBottomBtn, idx=" + paramInt1);
            }
            c(paramInt1, 8);
          }
          ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a();
          if (QLog.isColorLevel()) {
            QLog.d("nearby.bindphone", 2, "doOnActivityResult, cleanProfileCardCache");
          }
          try
          {
            paramIntent = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getSystemService("input_method");
            if (paramIntent == null) {
              break;
            }
            paramIntent.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView().getWindowToken(), 0);
            return;
          }
          catch (Exception paramIntent) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("nearby.bindphone", 2, "doOnActivityResult, hideSoftInputPanel exp:" + paramIntent);
        return;
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("nearby.bindphone", 2, "doOnActivityResult, exp=" + paramIntent.toString());
      return;
      label589:
      paramInt1 += 1;
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380369));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380344));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380805));
    paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    this.jdField_b_of_type_Int = paramView.getDimensionPixelSize(2131297481);
    this.jdField_c_of_type_Int = paramView.getDimensionPixelSize(2131297480);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368995));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView = ((NearbyCardVoteView)this.jdField_b_of_type_AndroidViewView.findViewById(2131381767));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setIsTribe(false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131368400));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout = ((NestScrollLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363856));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131377295);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369487));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369509));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369541));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363801));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131363853);
    paramView = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131372373);
    ImageView localImageView1 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381224);
    ImageView localImageView2 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370359);
    NearbyProfileDisplayPanel.2 local2 = new NearbyProfileDisplayPanel.2(this, paramView, localImageView1, localImageView2);
    paramView.setOnClickListener(local2);
    localImageView1.setOnClickListener(local2);
    localImageView2.setOnClickListener(local2);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null))
    {
      paramView.setImageResource(2130845853);
      localImageView1.setImageResource(2130845855);
      localImageView2.setImageResource(2130845851);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131373679));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager = ((AvatarWallViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131363234));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131377298));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372442));
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372440);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372439));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372445));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372444));
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView = ((AutoScrollImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372443));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372438));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370690));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369006));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131379688).setBackgroundResource(2130845809);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690601);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new NearbyProfileDisplayPanel.3(this));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setAppInterface(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager = ((NestViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131381619));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getSupportFragmentManager();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment = new NearbyProfileFragment();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment = new NearbyMomentFragment();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378828));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130851407));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setEnableRepeatedClick(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabTextSize(16);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectColor(Color.parseColor("#0dc4fd"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(Color.parseColor("#777777"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectBgRes(2130845844);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnSelectBgRes(2130845845);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineHeight(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineMargin(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 44.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabHeight(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 45.0F));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager);
    paramView = new LinearLayout.LayoutParams(0, -1);
    paramView.gravity = 17;
    paramView.weight = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabLayoutParams(paramView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, HardCodeUtil.a(2131707254), true, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, HardCodeUtil.a(2131707312), true, true);
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {
      i1 = NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    }
    for (;;)
    {
      if (i1 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, false);
      }
      for (;;)
      {
        if (i1 == -1) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a(new NearbyProfileDisplayPanel.4(this, i1));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378888));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
          break label1241;
        }
        i1 = NearbyDataManager.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
        break;
        if (i1 == 1) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
        }
      }
      label1241:
      i1 = -1;
    }
  }
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if ((paramInterestTagInfo == null) || (paramInt == 0) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 1))
    {
      if (NearbyUtils.b()) {
        NearbyUtils.a("NearbyProfileDisplayPanel", new Object[] { "onTagClick", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int), Integer.valueOf(paramInt), paramInterestTagInfo });
      }
      return;
    }
    QQAppInterface localQQAppInterface;
    if (paramInterestTagInfo.bid != 0L)
    {
      paramView = "https://buluo.qq.com/mobile/barindex.html?bid=" + paramInterestTagInfo.bid + "&_wv=1027";
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (paramInterestTagInfo.bid == 0L) {
        break label310;
      }
      paramView = "tag_same";
      label162:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
        break label317;
      }
      paramInterestTagInfo = "1";
      label177:
      if (paramInt > 4) {
        break label324;
      }
    }
    label310:
    label317:
    label324:
    for (Object localObject = paramInt + 3 + "";; localObject = paramInt - 4 + "")
    {
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", paramView, 0, 0, paramInterestTagInfo, "", (String)localObject, "");
      ThreadManager.post(new NearbyProfileDisplayPanel.33(this, paramInt), 5, null, false);
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      paramView.putExtra("url", "https://buluo.qq.com/mobile/search_result.html?_bid=128&_wv=1027&search_keyword=" + paramInterestTagInfo.tagName + "&from=nearby_tag");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
      break;
      paramView = "clk_tag";
      break label162;
      paramInterestTagInfo = "2";
      break label177;
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {}
    label1158:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getIsHostSelf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin())) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int = 2;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setNearbyPeopleCard(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        }
        paramNearbyPeopleCard = SharedPreUtils.k(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
        if (TextUtils.isEmpty(paramNearbyPeopleCard)) {}
      }
      label1033:
      label1547:
      try
      {
        this.jdField_d_of_type_JavaLangString = new JSONObject(paramNearbyPeopleCard).getString("ownerLikeJumpURL");
        if (!this.s) {
          this.s = true;
        }
        m();
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        String str = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
        {
          paramNearbyPeopleCard = "1";
          ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", str, "data_card", "exp", 0, 0, paramNearbyPeopleCard, "" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j % 20, "", "");
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.getAdapter() == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setAdapter(new NearbyProfileDisplayPanel.NearbyProfilePagerAdapter(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentManager, this.jdField_a_of_type_JavaUtilArrayList));
            i1 = -1;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
              break label1033;
            }
            i1 = NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
            if (i1 != 0) {
              break label1058;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(1, false);
            if (i1 == -1) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(0, false);
            }
          }
          if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
            break label1075;
          }
          this.p = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsgForTribar;
          this.q = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTipsForTribar;
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;
          this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.highScoreNum;
          a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
          p();
          o();
          h();
          if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser()) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isFuXiaoJin())) {
            break label1133;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841492);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) {
            break label1158;
          }
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            break label1145;
          }
          this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130846210);
          ThreadManager.post(new NearbyProfileDisplayPanel.13(this), 8, null, true);
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 31) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.q)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)) {
            break label1170;
          }
          this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.q + " · " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + HardCodeUtil.a(2131707285));
          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
          if (QLog.isColorLevel()) {
            QLog.d("Q.hotChatDistance", 2, "bindData, use aioDistance");
          }
          if (QLog.isColorLevel()) {
            QLog.d("NearbyProfileDisplayPanel", 2, "bindData, mCard.videoInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
            break label1378;
          }
          if (((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.equals(""))) {
            break label1354;
          }
          paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.trim();
          ((TextView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131380833)).setText(paramNearbyPeopleCard);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNowNowSmallVideoObserver);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
            break label1426;
          }
          if (!this.o) {
            break label1402;
          }
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_face_score").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).a();
          j();
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a() != 0) {
              break label1447;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a() != 1) {
            continue;
          }
          localObject = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break label1547;
          }
          paramNearbyPeopleCard = "1";
          ((ReportTask)localObject).a(new String[] { paramNearbyPeopleCard }).a();
          return;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int = 3;
        }
      }
      catch (JSONException paramNearbyPeopleCard)
      {
        label1426:
        for (;;)
        {
          Object localObject;
          int i1;
          paramNearbyPeopleCard.printStackTrace();
          continue;
          paramNearbyPeopleCard = "2";
          continue;
          label1170:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
          {
            i1 = NearbyDataManager.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
            continue;
            label1058:
            if (i1 == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(0, false);
              continue;
              label1075:
              this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maskMsgFlag;
              this.p = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsg;
              this.q = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
              this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTips;
              this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips;
              continue;
              label1133:
              this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
              continue;
              label1145:
              this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130846209);
              continue;
              this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
              continue;
              if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2))
              {
                this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime + HardCodeUtil.a(2131707269));
                this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              else if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)))
              {
                this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance + "·" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + HardCodeUtil.a(2131707384));
                this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
                continue;
                label1354:
                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname != null)
                {
                  paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
                  continue;
                  label1378:
                  if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname != null)
                  {
                    paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
                    continue;
                    label1402:
                    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
                    i();
                    continue;
                    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
                    continue;
                    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                    localObject = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_pub").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
                    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {}
                    for (paramNearbyPeopleCard = "1";; paramNearbyPeopleCard = "2")
                    {
                      ((ReportTask)localObject).a(new String[] { paramNearbyPeopleCard }).a();
                      break;
                    }
                    paramNearbyPeopleCard = "2";
                    continue;
                  }
                }
                label1447:
                paramNearbyPeopleCard = "";
              }
            }
          }
        }
      }
    }
  }
  
  public void a(PicInfo paramPicInfo, RelativeLayout paramRelativeLayout)
  {
    CustomImgView localCustomImgView = (CustomImgView)paramRelativeLayout.getChildAt(0);
    paramRelativeLayout = (ImageView)paramRelativeLayout.getChildAt(1);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130851165);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Int;
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Int;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mUseMemoryCache = false;
    if (!TextUtils.isEmpty(paramPicInfo.jdField_a_of_type_JavaLangString)) {
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
    }
    paramRelativeLayout.setVisibility(0);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131692257, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, HardCodeUtil.a(2131707331), 0).a();
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", paramString2);
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_hdsp_nearby");
    ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).startDownload(paramString1, localBundle, new NearbyProfileDisplayPanel.40(this, paramString3));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayPanel", 2, "onDownloadVideoHeadFinish, url = " + paramString + ", isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      paramString = (View)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString != null)
      {
        if (!(paramString instanceof RelativeLayout)) {
          break label129;
        }
        paramString = (RelativeLayout)paramString;
        localViewHolder = (AvatarWallPagerAdapter.ViewHolder)paramString.getTag(2131378883);
        if ((localViewHolder == null) || (localViewHolder.jdField_a_of_type_JavaLangObject == null)) {
          break label112;
        }
        a((PicInfo)localViewHolder.jdField_a_of_type_JavaLangObject, paramString);
      }
    }
    label112:
    while (!QLog.isColorLevel())
    {
      AvatarWallPagerAdapter.ViewHolder localViewHolder;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("NearbyProfileDisplayPanel", 2, "onDownloadVideoHeadFinish went error .., holder is null or holder.data is null");
      return;
    }
    label129:
    QLog.e("NearbyProfileDisplayPanel", 2, "onDownloadVideoHeadFinish went error .., view is not a instance of RelativeLayout");
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList)
  {
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.removeBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry);
      }
    }
    do
    {
      return;
      paramList = (ShowExternalTroop)paramList.get(0);
      this.jdField_e_of_type_JavaLangString = paramList.troopUin;
      this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry = new ProfileBusiEntry();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry.nBusiEntryType = 1024;
      this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry.strTitle = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131696147);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry.strContent = paramList.troopName;
      this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry.strLogoUrl = paramList.strFaceUrl;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry.strContent == null));
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_e_of_type_JavaLangString, "1", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_e_of_type_JavaLangString, "0", "", "");
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, GameCenterActivity.class);
      paramString.putExtra("url", HtmlOffline.a(str, "plat=qq&tt=1&_wv=3&qappid=" + AppSetting.a() + "&osv=" + Build.VERSION.RELEASE + "&vuin=" + NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString) + "&vname=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString + "&bn=" + paramBoolean));
      paramString.putExtra("big_brother_source_key", "biz_src_zf_games");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new nearby.Cmd0x1RspBody();
    for (;;)
    {
      try
      {
        ((nearby.Cmd0x1RspBody)localObject).mergeFrom(paramArrayOfByte);
        this.jdField_c_of_type_JavaLangString = ((nearby.Cmd0x1RspBody)localObject).bytes_qunlist_url.get().toStringUtf8();
        this.jdField_a_of_type_ArrayOfByte = ((nearby.Cmd0x1RspBody)localObject).bytes_chat_sig.get().toByteArray();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getMsgCache().h(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ArrayOfByte);
        this.u = ((nearby.Cmd0x1RspBody)localObject).bool_follow.get();
        this.jdField_d_of_type_Int = ((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_msg.get();
        if (((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_msg.get() != 1) {
          break label454;
        }
        bool1 = true;
        this.p = bool1;
        if (((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_gift.get() != 1) {
          break label460;
        }
        bool1 = bool2;
        this.q = bool1;
        if (((nearby.Cmd0x1RspBody)localObject).bytes_mask_msg_reason.has()) {
          this.jdField_a_of_type_JavaLangString = ((nearby.Cmd0x1RspBody)localObject).bytes_mask_msg_reason.get().toStringUtf8();
        }
        if (((nearby.Cmd0x1RspBody)localObject).bytes_mask_gift_reason.has()) {
          this.jdField_b_of_type_JavaLangString = ((nearby.Cmd0x1RspBody)localObject).bytes_mask_gift_reason.get().toStringUtf8();
        }
        localObject = (nearby.FansInfo)((nearby.Cmd0x1RspBody)localObject).FansInfo_fans.get();
        int i1 = ((nearby.FansInfo)localObject).uint32_follows_num.get();
        int i2 = ((nearby.FansInfo)localObject).uint32_fans_num.get();
        paramArrayOfByte = ((nearby.FansInfo)localObject).bytes_follows_url.get().toStringUtf8();
        localObject = ((nearby.FansInfo)localObject).bytes_fans_url.get().toStringUtf8();
        this.jdField_b_of_type_AndroidViewView.findViewById(2131367280).setVisibility(0);
        this.jdField_g_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707356) + i1);
        this.jdField_h_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707286) + i2);
        if (QLog.isColorLevel()) {
          QLog.d("NearbyProfileDisplayPanel", 2, "getNearByInfo, followsNum=" + i1 + ", fansNum=" + i2);
        }
        if (!TextUtils.isEmpty(paramArrayOfByte)) {
          this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(new NearbyProfileDisplayPanel.7(this, paramArrayOfByte));
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(new NearbyProfileDisplayPanel.8(this, (String)localObject));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("NearbyProfileDisplayPanel", 2, "Cmd0x1RspBody error !:" + paramArrayOfByte);
      return;
      label454:
      boolean bool1 = false;
      continue;
      label460:
      bool1 = false;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.jdField_b_of_type_Boolean;
    }
    return bool;
  }
  
  public int b()
  {
    int i9 = 1;
    int i10 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.b();
    int i1;
    int i2;
    label30:
    int i3;
    label39:
    int i4;
    label49:
    int i5;
    label59:
    int i6;
    label69:
    int i7;
    label79:
    int i8;
    if (this.k)
    {
      i1 = 1;
      if (!this.j) {
        break label150;
      }
      i2 = 1;
      if (!this.jdField_i_of_type_Boolean) {
        break label155;
      }
      i3 = 1;
      if (!this.jdField_h_of_type_Boolean) {
        break label160;
      }
      i4 = 1;
      if (!this.jdField_g_of_type_Boolean) {
        break label166;
      }
      i5 = 1;
      if (!this.jdField_f_of_type_Boolean) {
        break label172;
      }
      i6 = 1;
      if (!this.jdField_e_of_type_Boolean) {
        break label178;
      }
      i7 = 1;
      if (!this.jdField_d_of_type_Boolean) {
        break label184;
      }
      i8 = 1;
      label89:
      if (!this.jdField_b_of_type_Boolean) {
        break label190;
      }
    }
    for (;;)
    {
      return i8 << 2 | i10 | i1 << 10 | i2 << 9 | i3 << 8 | i4 << 6 | i5 << 5 | i6 << 4 | i7 << 3 | i9 << 0;
      i1 = 0;
      break;
      label150:
      i2 = 0;
      break label30;
      label155:
      i3 = 0;
      break label39;
      label160:
      i4 = 0;
      break label49;
      label166:
      i5 = 0;
      break label59;
      label172:
      i6 = 0;
      break label69;
      label178:
      i7 = 0;
      break label79;
      label184:
      i8 = 0;
      break label89;
      label190:
      i9 = 0;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(10);
    }
    DownloadApi.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "content_timer", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), "", "yes", "android");
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      try
      {
        String str = FaceUtil.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin));
        Object localObject = new URL("profile_img_big", null, str);
        if (paramInt2 == 1) {
          URLDrawable.removeMemoryCacheByUrl(((URL)localObject).toString());
        }
        localObject = new PicInfo();
        ((PicInfo)localObject).jdField_c_of_type_JavaLangString = str;
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_i_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add(0, localObject);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_i_of_type_Boolean = true;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$AvatarWallAdapter != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$AvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList);
          }
          if (paramInt2 == 1) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j();
          return;
          if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.set(0, localObject);
          }
        }
        QLog.i("Q.nearby_people_card.", 2, localMalformedURLException.getMessage());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
    } else if (paramInt2 == 1) {}
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo = paramNearbyPeopleCard.vGiftInfo;
  }
  
  void b(boolean paramBoolean)
  {
    boolean bool1;
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
      {
        bool1 = true;
        NearbyCardVoteView localNearbyCardVoteView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0) {
          break label168;
        }
        bool2 = true;
        label59:
        localNearbyCardVoteView.a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, null, true, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.praiseList);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
        if (QSecFramework.a().a(1001).booleanValue())
        {
          localNearbyCardVoteView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
          QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(41), localNearbyCardVoteView }, null);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.jdField_b_of_type_Boolean = false;
      }
      return;
      bool1 = false;
      break;
      label168:
      bool2 = false;
      break label59;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
  }
  
  boolean b()
  {
    return (Utils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 2);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      ((NearbyPeopleCard)localObject).likeCount += 1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      ((NearbyPeopleCard)localObject).bAvailVoteCnt = ((short)(((NearbyPeopleCard)localObject).bAvailVoteCnt - 1));
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted = 1;
      if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(1))
      {
        localObject = Message.obtain();
        ((Message)localObject).what = 1;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject, 2000L);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.q = true;
      b(paramBoolean);
      if (QSecFramework.a().a(1001).booleanValue()) {
        QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(6), "vote", null }, null);
      }
      return;
      if (paramBoolean) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      } else {
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a();
    }
    if (this.v) {
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.35(this), 16, null, false);
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    if ((this.q) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_b_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    NearbyPeopleProfileActivity.m += 1;
    String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    Object localObject2 = Utils.a(a());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i1;
    if (Friends.isValidUin(str))
    {
      localObject2 = NearbyURLSafeUtil.a(str);
      str = ((String)localObject1).toLowerCase();
      if (d() == 10002)
      {
        i1 = 6;
        if (!paramBoolean) {
          break label317;
        }
        localObject1 = "near.card.like";
        label138:
        localObject1 = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { localObject2, str, Integer.valueOf(i1), localObject1, "" });
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("portraitOnly", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        i1 = NearbyProfileUtil.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int);
        if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
          break label342;
        }
        i1 = 6;
      }
    }
    label317:
    label342:
    for (;;)
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_gift", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052BA", "0X80052BA", i1, 0, "", "", "", "");
      return;
      i1 = 1;
      break;
      localObject1 = "near.card.s";
      break label138;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131693521));
      return;
    }
  }
  
  public void e()
  {
    if (this.v) {
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.36(this), 16, null, false);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a(false);
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(1))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      r();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getNearbyProxy().jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getNearbyProxy().jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNowNowSmallVideoObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn()) && (!this.o))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {}
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
      if (QSecFramework.a().a(1001).booleanValue())
      {
        NearbyCardVoteView localNearbyCardVoteView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(41), localNearbyCardVoteView }, null);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.jdField_b_of_type_Boolean = false;
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
  }
  
  public void i()
  {
    DatingUtil.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getSimpleName(), new Object[] { "card godflag is `", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag), " sayhello flag is ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sayHelloFlag) });
    Button localButton;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
      if (!this.n)
      {
        c(2, 8);
        if ((this.u) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() == 0)) {
          break label391;
        }
        localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131380726);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167066));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845814));
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).getVisibility() != 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() != 0))
      {
        localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).findViewById(2131380726);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167066));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845814));
      }
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b == null) && (!b())) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
      }
      for (;;)
      {
        c(1, 60);
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.n)) {
          c(2, 8);
        } else {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
      }
      label391:
      ((Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131380726)).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845815));
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList;
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        a(((PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
      }
      localObject1 = new NearbyProfileDisplayPanel.AvatarViewPagerAdatper(this, this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setAdapter((AvatarWallPagerAdapter)localObject1);
      localObject2 = new ArrayList();
      this.jdField_g_of_type_Int = ((int)Math.ceil(this.jdField_a_of_type_JavaUtilList.size() / 6.0F));
      int i1 = 0;
      while (i1 < this.jdField_g_of_type_Int)
      {
        ((List)localObject2).add(a(this.jdField_a_of_type_JavaUtilList, i1));
        i1 += 1;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl))
      {
        localObject1 = new PicInfo();
        ((PicInfo)localObject1).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl;
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
      }
      else
      {
        localObject1 = new PicInfo();
        ((PicInfo)localObject1).g = "type_qq_head_pic";
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
      }
    }
    ((NearbyProfileDisplayPanel.AvatarViewPagerAdatper)localObject1).a((List)localObject2);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
    {
      localObject1 = "2";
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_head", 0, 0, (String)localObject1, "", "", "");
      localObject1 = (RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131377229);
      localObject2 = (LinearLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.getLayoutParams();
      if (localObject2 != null)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() <= 3) {
          break label454;
        }
        ((LinearLayout.LayoutParams)localObject2).height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3 * 2);
      }
    }
    for (localLayoutParams.height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3 * 2);; localLayoutParams.height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3))
    {
      ((LinearLayout.LayoutParams)localObject2).topMargin = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131299166) + ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity));
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 4.0F);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setDotLayoutParams((RelativeLayout.LayoutParams)localObject1);
      return;
      localObject1 = "1";
      break;
      label454:
      ((LinearLayout.LayoutParams)localObject2).height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3);
    }
  }
  
  public void k()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l == 640) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l == 0)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_c_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_c_of_type_JavaLangString, false);
    }
  }
  
  public void l()
  {
    ThreadPriorityManager.a(true);
    int i1 = d();
    if (b())
    {
      localIntent = new Intent();
      localIntent.putExtra("finchat", true);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(0, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (StringUtil.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId))))
    {
      Intent localIntent;
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.chatId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), i1);
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData == null)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.bytes_live_url.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProfileDisplayPanel", 2, "now anchor, jumpUrl=" + (String)localObject2);
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_level.get();
    QLog.i("NearbyProfileDisplayPanel", 1, "level: " + i1);
    int i2;
    if (i1 > 0)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      long l1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
      {
        localObject1 = "1";
        ReportController.b((AppRuntime)localObject3, "dc00899", "grp_lbs", String.valueOf(l1), "status_bar", "bar_exp", 0, 0, (String)localObject1, "", "", "");
        localObject1 = HardCodeUtil.a(2131707366);
        i2 = ((String)localObject1).length();
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_live_status.get() != 1) {
          break label544;
        }
        localObject3 = i1 + "";
        localObject1 = new SpannableString((String)localObject1 + (String)localObject3 + HardCodeUtil.a(2131707382));
        ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-4352), i2, ((String)localObject3).length() + i2, 33);
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setRadius(UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 3.0F));
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845818);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845807);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(new NearbyProfileDisplayPanel.9(this, (String)localObject2));
        localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("live_exp").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
          break label517;
        }
        localObject1 = "1";
      }
    }
    for (;;)
    {
      ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1)
      {
        localObject1 = "2";
        break;
      }
      localObject1 = "0";
      break;
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      return;
      label517:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
        localObject1 = "2";
      } else {
        localObject1 = "0";
      }
    }
    label544:
    Object localObject3 = i1 + "";
    Object localObject1 = new SpannableString((String)localObject1 + (String)localObject3 + HardCodeUtil.a(2131707318));
    ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-65536), i2, ((String)localObject3).length() + i2, 33);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845808);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845825);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(new NearbyProfileDisplayPanel.10(this, (String)localObject2));
    localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("nonlive_exp").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
      localObject1 = "1";
    }
    for (;;)
    {
      ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
        localObject1 = "2";
      } else {
        localObject1 = "0";
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof DataTag)))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482E", "0X800482E", 0, 0, "", "", "", "");
      localObject1 = (DataTag)localObject1;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyProfileDisplayPanel", 2, "click  data.nType= [" + ((DataTag)localObject1).jdField_a_of_type_Int + "]");
      }
      switch (((DataTag)localObject1).jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2;
      if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
      {
        localObject1 = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
        if (!StringUtil.a(((ProfileBusiEntry)localObject1).strJumpUrl))
        {
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("portraitOnly", true);
          if (!StringUtil.a(((ProfileBusiEntry)localObject1).strJumpUrl)) {
            break label404;
          }
          localObject1 = "";
          label325:
          ((Intent)localObject2).putExtra("url", (String)localObject1);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        label345:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CC", "0X80050CC", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        continue;
        label404:
        localObject1 = ((ProfileBusiEntry)localObject1).strJumpUrl;
        break label325;
        if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          localObject1 = (Object[])((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
          a(((Boolean)localObject1[0]).booleanValue(), (String)localObject1[1]);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CA", "0X80050CA ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        continue;
        if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
        {
          localObject1 = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
          if (!StringUtil.a(((ProfileBusiEntry)localObject1).strJumpUrl)) {
            b(((ProfileBusiEntry)localObject1).strJumpUrl);
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CB", "0X80050CB ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        continue;
        Object localObject3;
        if ((((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
        {
          localObject2 = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
          if (!StringUtil.a(((ProfileBusiEntry)localObject2).strJumpUrl))
          {
            localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject3).putExtra("url", ((ProfileBusiEntry)localObject2).strJumpUrl);
            ((Intent)localObject3).putExtra("hide_operation_bar", true);
            ((Intent)localObject3).putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject3);
          }
        }
        if (28 != ((DataTag)localObject1).jdField_a_of_type_Int) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CD", "0X80050CD", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        continue;
        if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
          continue;
        }
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ShowExternalTroopListActivity.class);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((Intent)localObject1).putExtra("isHost", bool);
          ((Intent)localObject1).putExtra("dest_uin_str", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break label916;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_e_of_type_JavaLangString, "1", "", "");
          break;
        }
        label916:
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_e_of_type_JavaLangString, "0", "", "");
        continue;
        if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
          continue;
        }
        localObject1 = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((ProfileBusiEntry)localObject1).strJumpUrl + "&_webviewtype=1");
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005102", "0X8005102", 0, 0, "", "", "", "");
        continue;
        localObject2 = a();
        if (this.u) {}
        for (localObject1 = "clk_followed";; localObject1 = "clk_follow")
        {
          ReportController.b(null, "dc00899", "grp_lbs", (String)localObject2, "data_card", (String)localObject1, 0, 0, "", "", "", "");
          if (NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity)) {
            break label1193;
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131694457), 0).a();
          break;
        }
        label1193:
        ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), Integer.valueOf(1));
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType == 1)
        {
          label1251:
          long l1;
          long l2;
          if (this.n)
          {
            i1 = 6;
            localObject1 = new NowShortVideoProtoManager(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue();
            l2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId;
            i2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType;
            if (this.u) {
              break label1338;
            }
          }
          label1338:
          for (bool = true;; bool = false)
          {
            ((NowShortVideoProtoManager)localObject1).a(l1, l2, i2, i1, bool, new NearbyProfileDisplayPanel.18(this));
            break;
            i1 = 2;
            break label1251;
          }
        }
        if (this.u) {}
        for (int i1 = 2;; i1 = 1)
        {
          localObject1 = new NowSummaryCard.NearbyUserFollowReq();
          ((NowSummaryCard.NearbyUserFollowReq)localObject1).from.set(0);
          ((NowSummaryCard.NearbyUserFollowReq)localObject1).id_type.set(0);
          ((NowSummaryCard.NearbyUserFollowReq)localObject1).target_id.set(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId);
          ((NowSummaryCard.NearbyUserFollowReq)localObject1).operation.set(i1);
          ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new NearbyProfileDisplayPanel.19(this), ((NowSummaryCard.NearbyUserFollowReq)localObject1).toByteArray(), "NowSummaryCard.NearbyUserFollow");
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, (String)localObject1, (String)localObject2, null, true, null, true, true, null, "from_internal");
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.nearby_people_card.", 2, "mCard == null , or mCard.uin is Empty, " + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby.tribeAppDownload", 2, "sendMsgBtnClick, isSendMsgBtnDownloadAppOpen=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isSendMsgBtnDownloadAppOpen + ", sendMsgBtnDownloadAppTips:" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
          }
        }
        String str1;
        for (;;)
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) && (this.jdField_d_of_type_Int != 0))
          {
            if (this.jdField_d_of_type_Int == 3)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
              {
                QLog.i("NearbyProfileDisplayPanel", 1, "mMaskMsgFlag == STATE_WX, mCard == null");
                break;
                QLog.w("NearbyProfileDisplayPanel", 1, "onClick DATA_TYPE_CHAT mcard == null!");
                continue;
              }
              bool = PackageUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowPackage);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTip;
              str1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTipLeftBtn;
              if (bool) {}
              for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTipRightBtnInstalled;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTipRightBtnNotInstalled)
              {
                localObject1 = DialogUtil.a((Context)localObject2, 230, null, (CharSequence)localObject3, str1, (String)localObject1, new NearbyProfileDisplayPanel.20(this, bool), new NearbyProfileDisplayPanel.21(this));
                ((QQCustomDialog)localObject1).getBtnight().setTextColor(-15550475);
                ((QQCustomDialog)localObject1).show();
                break;
              }
            }
            if (this.jdField_d_of_type_Int == 2)
            {
              DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_JavaLangString, 2131690800, 2131698942, new NearbyProfileDisplayPanel.22(this), new NearbyProfileDisplayPanel.23(this)).show();
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
                break;
              }
              NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "phone", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
              break;
            }
            if (this.jdField_d_of_type_Int != 1) {
              break;
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
              break;
            }
            NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "blocked", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
            break;
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_msg_switch.has()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_msg_switch.get() == 0))
        {
          localObject1 = CikeConfigData.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getAccount(), 1);
          if (localObject1 != null)
          {
            ((CikeConfigData)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.uint64_uid.get());
            ((CikeConfigData)localObject1).f = "14";
            ((CikeConfigData)localObject1).g = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
            localObject2 = new NearbyAppDownloadDialog(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
            ((NearbyAppDownloadDialog)localObject2).a((CikeConfigData)localObject1);
            ((NearbyAppDownloadDialog)localObject2).show();
            ((NearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId);
            continue;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
          NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "pass", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
        }
        this.jdField_d_of_type_Boolean = true;
        l();
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_msg", 0, 0, "", "", "", "");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin != null)) {}
        for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;; localObject1 = "")
        {
          ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8004826", "0X8004826", i1, 0, (String)localObject1, "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 76)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004944", "0X8004944", 0, 0, "", "", "", "");
          }
          NearbyPeopleProfileActivity.m = 0;
          if (!ProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)) {
            break label2402;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800523D", "0X800523D", 0, 0, "", "", "", "");
          break;
        }
        label2402:
        if (!ProfileActivity.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005CAA", "0X8005CAA", 0, 0, "", "", "", "");
        continue;
        d(false);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app == null) {
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528B", "0X800528B", 0, 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o)
        {
          DatingUtil.c("nearbyprofilecard", new Object[] { "have click sayhello, wating for resp" });
          continue;
        }
        localObject1 = (NearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
        if (localObject1 == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 17) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 18) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 19))
        {
          i1 = 8;
          label2692:
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) {
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label2779;
            }
          }
        }
        label2779:
        for (int i2 = 1;; i2 = 2)
        {
          i2 = i1 | i2;
          ((NearbyCardHandler)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId, i2, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(204, 1000L);
          break;
          i1 = 4;
          break label2692;
        }
        if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80055CA", "0X80055CA", 0, 0, "", "", "", "");
        localObject1 = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((ProfileBusiEntry)localObject1).strJumpUrl);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        continue;
        if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005D14", "0X8005D14", 0, 0, "", "", "", "");
        localObject1 = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((ProfileBusiEntry)localObject1).strJumpUrl);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        continue;
        if (!(((DataTag)localObject1).jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
          continue;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "0X8006E05", "0X8006E05", 1, 0, new String[0]);
        localObject1 = (ProfileBusiEntry)((DataTag)localObject1).jdField_a_of_type_JavaLangObject;
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((ProfileBusiEntry)localObject1).strJumpUrl);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
          continue;
        }
        if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131692257, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131299166));
          continue;
        }
        if (PackageUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "com.guagua.qiqi"))
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "click_bootstrap", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), "", "yes", "android");
          continue;
        }
        if (this.jdField_a_of_type_Int == 1)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131699070);
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(3);
          this.jdField_a_of_type_Int = 2;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_pause", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), "", "yes", "android");
          continue;
        }
        if (NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          if (this.l)
          {
            DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131698685), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131698684), 0, 2131699071, new NearbyProfileDisplayPanel.24(this), null).show();
            this.l = false;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), "", "yes", "android");
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(2);
            if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 0)) {
              break;
            }
            this.jdField_a_of_type_Int = 1;
            break;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), "", "yes", "android");
          }
        }
        if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 0))
        {
          DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131698685), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131698683), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener).show();
          this.jdField_a_of_type_Int = 1;
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(2);
        continue;
        if (paramView == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView)
        {
          if (2 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "clk_list", 0, 0, "", "", "", "");
            if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
            {
              localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, VisitorsActivity.class);
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
              {
                i1 = 0;
                label3691:
                localObject2 = new Bundle();
                ((Bundle)localObject2).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue());
                ((Bundle)localObject2).putLong("totalVoters", i1);
                ((Bundle)localObject2).putBoolean("isStartedByProfileCard", true);
                ((Bundle)localObject2).putBoolean("votersOnly", true);
                if (i1 <= 0) {
                  break label4047;
                }
              }
              label4047:
              for (bool = true;; bool = false)
              {
                ((Bundle)localObject2).putBoolean("hasVoters", bool);
                ((Bundle)localObject2).putBoolean("extra_show_rank", true);
                ((Bundle)localObject2).putInt("frome_where", 4);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
                NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc = 0;
                  h();
                  this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute(new NearbyProfileDisplayPanel.25(this));
                }
                if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
                  this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.jdField_b_of_type_Boolean = true;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("IS_NEARBY_REDDOT_INCOME", false)) {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005249", "0X8005249", 0, 0, "", "", "", "");
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800657A", "0X800657A", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
                localObject2 = "2";
                localObject1 = localObject2;
                if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a != null)
                {
                  localObject1 = localObject2;
                  if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a.getVisibility() == 0) {
                    localObject1 = "1";
                  }
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00898", "", "", "0X8007610", "0X8007610", 2, 0, (String)localObject1, "", "", "");
                break;
                i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount;
                break label3691;
              }
            }
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            if (d() == 10002) {}
            for (localObject1 = "6";; localObject1 = "1")
            {
              ((Intent)localObject2).putExtra("url", this.jdField_d_of_type_JavaLangString + "&SOURCETYPE=" + (String)localObject1 + "&SIGN=" + a() + "&UIN=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getCurrentAccountUin());
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
              break;
            }
          }
          if (3 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int) {
            continue;
          }
          this.jdField_b_of_type_Boolean = true;
          localObject2 = new HashMap();
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131693416));
            ((HashMap)localObject2).put("param_FailCode", "-210");
            StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject2, "", false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("NearbyProfileDisplayPanel", 2, "mCard is null,vote failed !");
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyProfileDisplayPanel", 2, "Click Vote View, mCard.bAvailVoteCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ",mCard.bHaveVotedCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt + ",mCard.strVoteLimitedNotice = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strVoteLimitedNotice);
          }
          label4377:
          label4399:
          int i3;
          label4504:
          label4606:
          String str2;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt <= 0)
          {
            i1 = 1;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt > 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt > 0)) {
              break label4878;
            }
            i2 = 1;
            if (QLog.isColorLevel()) {
              QLog.d("NearbyLikeLimitManager", 2, "Profile->onClickVote, tinyId=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId + ", isFriend=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean + ", bAvailVoteCnt=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ", bHaveVotedCnt=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt);
            }
            if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
              break label4883;
            }
            i3 = 510;
            if ((i1 != 0) || (i2 != 0)) {
              break label5060;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler == null) || (!NetworkUtil.d(BaseApplication.getContext()))) {
              break label4904;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
              break label4891;
            }
            ((NearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, new NearbyProfileDisplayPanel.26(this), i3 + "");
            str1 = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
              break label5036;
            }
            localObject1 = "2";
            label4649:
            str2 = i3 + "";
            if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
              break label5044;
            }
            localObject2 = "1";
            label4686:
            if (!this.t) {
              break label5052;
            }
          }
          label4878:
          label4883:
          label4891:
          label4904:
          label5036:
          label5044:
          label5052:
          for (localObject3 = "2";; localObject3 = "1")
          {
            ReportController.b(null, "dc00899", "grp_lbs", str1, "data_card", "like_head", 0, 0, (String)localObject1, str2, (String)localObject2, (String)localObject3);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004825", "0X8004825", c(), 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "", "");
            if (ProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005241", "0X8005241", 0, 0, "", "", "", "");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label5407;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528C", "0X800528C", 1, 0, "", "", "", "");
            break;
            i1 = 0;
            break label4377;
            i2 = 0;
            break label4399;
            i3 = 509;
            break label4504;
            c(true);
            this.t = true;
            break label4606;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler != null)
            {
              ((HashMap)localObject2).put("param_FailCode", "-203");
              StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject2, "", false);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131720768));
              break label4606;
            }
            ((HashMap)localObject2).put("param_FailCode", "-204");
            StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject2, "", false);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131693416));
            break label4606;
            localObject1 = "1";
            break label4649;
            localObject2 = "2";
            break label4686;
          }
          label5060:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
          {
            localObject1 = HardCodeUtil.a(2131707347);
            label5078:
            if (!this.r)
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
                break label5276;
              }
              localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, HardCodeUtil.a(2131707320), "", HardCodeUtil.a(2131707260), new NearbyProfileDisplayPanel.27(this), null);
              ((Dialog)localObject1).show();
              this.r = true;
              ((Dialog)localObject1).setOnDismissListener(new NearbyProfileDisplayPanel.30(this));
            }
            ReportController.b(null, "dc00899", "grp_lbs", "", "data_like", "exp_toast", 0, 0, "", "", "", "");
            if (i2 == 0) {
              break label5353;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006579", "0X8006579", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), "", "", "");
          }
          for (;;)
          {
            label5131:
            StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject3, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject2, "", false);
            break;
            localObject1 = HardCodeUtil.a(2131707277);
            break label5078;
            label5276:
            localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, HardCodeUtil.a(2131707265) + (String)localObject1 + HardCodeUtil.a(2131707340), HardCodeUtil.a(2131707337), HardCodeUtil.a(2131707314), new NearbyProfileDisplayPanel.28(this), new NearbyProfileDisplayPanel.29(this));
            break label5131;
            label5353:
            if (i1 != 0) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006578", "0X8006578", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), "", "", "");
            }
          }
          label5407:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528D", "0X800528D", 1, 0, "", "", "", "");
          continue;
        }
        if (paramView == this.jdField_f_of_type_AndroidWidgetImageView)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin();
          if ((!Friends.isValidUin((String)localObject1)) || (!Friends.isValidUin(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin))) {
            continue;
          }
          bool = ((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          if (bool)
          {
            i1 = 0;
            label5516:
            if (!bool) {
              break label5599;
            }
          }
          for (;;)
          {
            localObject1 = String.format("https://ti.qq.com/paihangbanggl/index.html?_wv=1027&isguest=%d&uin=%s", new Object[] { Integer.valueOf(i1), localObject1 });
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("portraitOnly", true);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
            break;
            i1 = 1;
            break label5516;
            label5599:
            localObject1 = "";
          }
        }
        if (paramView == this.jdField_b_of_type_AndroidWidgetTextView)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "clk_edit", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_i_of_type_Int == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c();
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(300L);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004B38", "0X8004B38", 0, 0, "", "", "", "");
          continue;
        }
        if (paramView != this.jdField_a_of_type_AndroidWidgetImageView) {
          continue;
        }
        localObject1 = NearbyPublishMenuHelper.a();
        localObject1 = new NearbyPublishMenu(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (ArrayList)localObject1);
        ((NearbyPublishMenu)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyPublishMenu$OnItemClickListener);
        ((NearbyPublishMenu)localObject1).a(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 18.0F), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 22.0F) + this.jdField_a_of_type_AndroidWidgetImageView.getHeight(), 0.2F);
        localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("pub_download_exp").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {}
        for (localObject1 = "1";; localObject1 = "2")
        {
          ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
          break;
        }
      }
      catch (SecurityException localSecurityException)
      {
        break label345;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
    {
      if (this.jdField_a_of_type_ComTencentWidgetCustomImgView != null) {
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageBitmap(paramBitmap);
      }
      a(paramBitmap);
    }
  }
  
  public void onScrollStateChanged(ScrollView paramScrollView, int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel
 * JD-Core Version:    0.7.0.1
 */