package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
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
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
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
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.BaseFragment;
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
import com.tencent.mobileqq.dating.NearbyCGIReporter;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.CikeConfigData;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.NearbyProxy;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.now.NowSmallVideoObserver;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
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
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.entity.ProfileBusiEntry;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
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
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback;
  Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  protected ImageView a;
  protected LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected FragmentManager a;
  ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NewVoteAnimHelper jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  NowSmallVideoObserver jdField_a_of_type_ComTencentMobileqqNearbyNowNowSmallVideoObserver;
  private NearbyCardVoteView jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
  NearbyPeopleProfileActivity jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
  private NearbyProfileDisplayPanel.AvatarWallAdapter jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$AvatarWallAdapter;
  protected NearbyProfileFragment a;
  private NestScrollLayout jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout;
  ProfileQiqiLiveController jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController = null;
  protected NearbyMomentFragment a;
  private AutoScrollImageView jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
  NearbyPublishMenu.OnItemClickListener jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyPublishMenu$OnItemClickListener;
  protected ProfileBusiEntry a;
  protected NestViewPager a;
  ProgressButton jdField_a_of_type_ComTencentMobileqqWidgetProgressButton;
  protected TabBarView a;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  String jdField_a_of_type_JavaLangString;
  protected ArrayList<BaseFragment> a;
  private List<PicInfo> jdField_a_of_type_JavaUtilList;
  protected final Map<String, View> a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public boolean b;
  int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public boolean c;
  int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  public boolean d;
  int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  protected String e;
  public boolean e;
  int jdField_f_of_type_Int;
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
  boolean l;
  boolean m;
  boolean n;
  boolean o;
  boolean p;
  boolean q;
  boolean r;
  boolean s;
  protected boolean t;
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
    boolean bool = true;
    this.l = true;
    this.m = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.n = false;
    this.o = false;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new NearbyProfileDisplayPanel.1(this);
    this.jdField_d_of_type_Int = 0;
    this.p = false;
    this.q = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
    this.r = false;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new NearbyProfileDisplayPanel.5(this);
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = new NearbyProfileDisplayPanel.6(this);
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.s = false;
    this.jdField_e_of_type_JavaLangString = null;
    this.t = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyPublishMenu$OnItemClickListener = new NearbyProfileDisplayPanel.33(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new NearbyProfileDisplayPanel.34(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowNowSmallVideoObserver = new NearbyProfileDisplayPanel.36(this);
    this.jdField_a_of_type_AndroidOsHandler = new NearbyProfileDisplayPanel.39(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new NearbyProfileDisplayPanel.40(this);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new NearbyProfileDisplayPanel.41(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (paramNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) != 35) {
      bool = false;
    }
    this.o = bool;
    this.n = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_werewolves", false);
    this.v = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_now_plugin", false);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramNearbyPeopleProfileActivity.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramNearbyPeopleProfileActivity.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    n();
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
    paramInt = AIOUtils.b(1.0F, localResources);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth = ((localResources.getDisplayMetrics().widthPixels - paramInt * 2) / 3);
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
    NearbyPeopleCard localNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if (localNearbyPeopleCard != null) {
      return localNearbyPeopleCard.uin;
    }
    return "";
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
      if (QLog.isColorLevel()) {
        QLog.e("NearbyProfileDisplayPanel", 2, localJSONException.toString());
      }
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_live_status.get() == 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.size() == 0))
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
      if (paramString.getStatus() == 1)
      {
        localObject = paramString.getCurrDrawable();
        if ((localObject instanceof RegionDrawable))
        {
          localObject = ((RegionDrawable)localObject).getBitmap();
          this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setImageBitmap((Bitmap)localObject);
          this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setVisibility(0);
        }
      }
      else
      {
        paramString.setURLDrawableListener(new NearbyProfileDisplayPanel.11(this));
      }
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.12(this, paramString), 128, null, true);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mFromDatingSubject == 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mFromDatingId)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mIsPub))
    {
      String str = NearbyManagerHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a();
      paramString3 = str;
      if (str == null) {
        paramString3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131698747);
      }
      AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, paramString1, paramString3, 1010);
    }
    paramString1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ChatActivity.class);
    paramString1.putExtra("PREVIOUS_WINDOW", QQNearbyManager.b().getName());
    paramString1.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    paramString1.putExtra("NEARBY_MSG_REPORT_SOURCE", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mEnterProfileIntent.getStringExtra("NEARBY_MSG_REPORT_SOURCE"));
    paramString1.putExtra("cSpecialFlag", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mEnterProfileIntent.getExtras().getInt("cSpecialFlag"));
    paramString1.putExtra("uin", paramString2);
    paramString1.putExtra("uintype", paramInt);
    paramString1.putExtra("ProfileCard_flag", "ProfileCard");
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.firstOfficialMsg != null)
    {
      paramString1.putExtra("OFFICIAL_MSG", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.firstOfficialMsg);
      if (this.jdField_d_of_type_Int == 4) {
        paramString1.putExtra("VERIFY_GRAY_TIPS", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.unverifyGrayTips);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.firstOfficialMsg = null;
    }
    paramString1.putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatEntrance != 0) {
      paramString1.putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatEntrance);
    }
    if (paramInt == 1001)
    {
      paramString1.putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatCookie);
      paramString1.putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
    }
    else if (paramInt == 1010)
    {
      paramString1.putExtra("rich_date_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatCookie);
      paramString1.putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
    }
    paramString1.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.nickname);
    paramString1.addFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString1);
    b(paramString2);
  }
  
  private byte[] a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatCookie;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.fetchFromType != 51) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getMsgCache().m(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.uin);
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
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.fetchFromType == 51) {
        localObject2 = this.jdField_a_of_type_ArrayOfByte;
      }
    }
    if ((localObject2 == null) && (QLog.isColorLevel())) {
      QLog.e("Q.nearby_people_card.", 2, "nearbySig is null ");
    }
    return localObject2;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i1;
    Object localObject2;
    if (paramInt2 != 8)
    {
      if (paramInt2 != 20)
      {
        if (paramInt2 != 40)
        {
          if (paramInt2 != 60)
          {
            switch (paramInt2)
            {
            default: 
              i1 = 0;
              break;
            case 38: 
              i1 = 2131694415;
              break;
            case 37: 
              i1 = 2131699193;
              break;
            case 36: 
              i1 = 2131698746;
              ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_gift", 0, 0, "", "", "", "");
              break;
            }
          }
          else
          {
            if (this.u) {
              i1 = 2131696368;
            } else {
              i1 = 2131696366;
            }
            localObject2 = a();
            if (this.u) {
              localObject1 = "exp_followed";
            } else {
              localObject1 = "exp_follow";
            }
            ReportController.b(null, "dc00899", "grp_lbs", (String)localObject2, "data_card", (String)localObject1, 0, 0, "", "", "", "");
          }
        }
        else {
          i1 = 2131698757;
        }
      }
      else {
        i1 = 2131693303;
      }
    }
    else
    {
      i1 = 2131718751;
      localObject1 = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1).findViewById(2131379994);
      ((Button)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167089));
      ((Button)localObject1).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845687));
      ReportController.b(null, "dc00899", "grp_lbs", a(), "data_card", "exp_msg", 0, 0, "", "", "", "");
    }
    if (i1 == 0)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
    ((View)localObject1).setVisibility(0);
    if (paramInt2 != 40)
    {
      localObject2 = (Button)((View)localObject1).findViewById(2131379994);
      ((Button)localObject2).setText(i1);
      if (paramInt2 == 38)
      {
        ((Button)localObject2).setBackgroundResource(2130850380);
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165586));
      }
      ((Button)localObject2).setOnClickListener(this);
      DataTag localDataTag = new DataTag(paramInt2, null);
      ((Button)localObject2).setTag(localDataTag);
      ((View)localObject1).setTag(localDataTag);
      if ((paramInt2 == 60) && (this.u))
      {
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167091));
        ((Button)localObject2).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839319));
        return;
      }
      if ((paramInt2 == 8) && (this.jdField_d_of_type_Int != 0) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
      {
        ((Button)localObject2).setBackgroundResource(2130850380);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      if ((paramInt2 == 36) && (this.q) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
      {
        ((Button)localObject2).setBackgroundResource(2130850380);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    else
    {
      ((View)localObject1).setVisibility(8);
    }
  }
  
  private void b(String paramString)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getNearbyReportJson();
    if (localJSONObject == null) {
      return;
    }
    try
    {
      localJSONObject.put("touin", paramString);
      localJSONObject.put("module", "msg_button");
      localJSONObject.put("action", "click");
      new NearbyCGIReporter().a(localJSONObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.onEnterChat();
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private int c()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mEnterProfileIntent;
    int i1 = 6;
    int i2 = localIntent.getIntExtra("frome_where", 6);
    if ((i2 > 0) && (i2 < 6)) {
      return i2;
    }
    i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType;
    if (i2 == 5) {
      return 1;
    }
    if (ProfileEntryUtils.isFromHotChat(i2)) {
      return 3;
    }
    if (((i2 >= 10) && (i2 <= 19)) || (i2 == 30)) {
      i1 = 2;
    }
    return i1;
  }
  
  private void c(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = String.format("https://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin });
    }
    paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, MusicGeneQQBrowserActivity.class);
    paramString.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin());
    paramString.putExtra("url", (String)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa == 0) {
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    } else {
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
    localObject = Calendar.getInstance();
    if ((localObject != null) && (QLog.isColorLevel()))
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("musicgene123 startactivity ");
        localStringBuilder.append((String)localObject);
        QLog.d("Q.nearby_people_card.", 4, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004182 ", "0X8004182", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone)), "", "", "");
  }
  
  private boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).nearbyNowData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_msg_switch.has()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_msg_switch.get() == 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      localObject = CikeConfigData.a((Context)localObject, ((NearbyPeopleProfileActivity)localObject).app.getAccount(), 1);
      if (localObject != null)
      {
        ((CikeConfigData)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.uint64_uid.get());
        ((CikeConfigData)localObject).f = "14";
        ((CikeConfigData)localObject).g = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
        NearbyAppDownloadDialog localNearbyAppDownloadDialog = new NearbyAppDownloadDialog(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
        localNearbyAppDownloadDialog.a((CikeConfigData)localObject);
        localNearbyAppDownloadDialog.show();
        ((INearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId);
        return false;
      }
    }
    return true;
  }
  
  private int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      if (localNearbyPeopleCard != null)
      {
        if ((localNearbyPeopleCard.lUserFlag & 0x800) != 0L) {
          return 0;
        }
        return ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone);
      }
    }
    return 1001;
  }
  
  private void n()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mRequestWidth = ((int)DeviceInfoUtil.k());
    localURLDrawableOptions.mRequestHeight = (localURLDrawableOptions.mRequestWidth / 2);
    URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif", localURLDrawableOptions);
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender;
    Object localObject1;
    if ((i1 == 0) || (i1 == 1) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0))
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (i1 == 1) {
        localObject1 = "#ffffafea";
      } else {
        localObject1 = "#ff96beff";
      }
      int i2 = Color.parseColor((String)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707360));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      ((LinearLayout)localObject2).addView(a(i2, (String)localObject1, NearbyProfileUtil.a(i1), UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 3.0F)));
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_info", 0, 0, (String)localObject1, "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation >= 1) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation <= 12))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(Color.parseColor("#ffbfa4f6"), NearbyProfileUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation)));
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_xing", 0, 0, (String)localObject1, "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus >= 2) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus <= 5))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(Color.parseColor("#ff89e1b5"), NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1)));
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_relation", 0, 0, (String)localObject1, "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.is_authen.get() == 1))
    {
      localObject1 = a(Color.parseColor("#000000"), HardCodeUtil.a(2131707323), 2130845601, UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 3.0F));
      localObject2 = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] { Color.parseColor("#ffa98df7"), Color.parseColor("#ff8aafff") });
      ((GradientDrawable)localObject2).setCornerRadius(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
      ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
      ((TextView)localObject1).setOnClickListener(new NearbyProfileDisplayPanel.15(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("cike_icon_exp").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId)).a();
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
      NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "blocked", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#datacard");
      localJSONObject.put("module", "blacklist_toast");
      localJSONObject.put("action", "view");
      localJSONObject.put("fromuin", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin());
      localJSONObject.put("appid", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getAppid()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      new NearbyCGIReporter().a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void r()
  {
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_JavaLangString, 2131690728, 2131699021, new NearbyProfileDisplayPanel.25(this), new NearbyProfileDisplayPanel.26(this)).show();
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
      NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "phone", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    }
  }
  
  private void s()
  {
    boolean bool = PackageUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowPackage);
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTip;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTipLeftBtn;
    if (bool) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTipRightBtnInstalled;
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTipRightBtnNotInstalled;
    }
    Object localObject = DialogUtil.a(localNearbyPeopleProfileActivity, 230, null, str1, str2, (String)localObject, new NearbyProfileDisplayPanel.27(this, bool), new NearbyProfileDisplayPanel.28(this));
    ((QQCustomDialog)localObject).getBtnight().setTextColor(-15550475);
    ((QQCustomDialog)localObject).show();
  }
  
  private void t()
  {
    long l1 = System.currentTimeMillis();
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideVerifiedDialogTitle, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTip, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideAppNowTipLeftBtn, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.guideVerifiedDialogRightBtnText, new NearbyProfileDisplayPanel.29(this, l1), new NearbyProfileDisplayPanel.30(this, l1)).show();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("opername", "now#nearby#datacard");
        localJSONObject.put("module", "limit_pop");
        localJSONObject.put("action", "view");
        localJSONObject.put("fromuin", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin());
        if (this.jdField_d_of_type_Int == 4)
        {
          String str1 = "0";
          localJSONObject.put("d4", str1);
          localJSONObject.put("appid", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getAppid()));
          localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
          new NearbyCGIReporter().a(localJSONObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      String str2 = "1";
    }
  }
  
  private void u()
  {
    int i1;
    if (this.u) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    NowSummaryCard.NearbyUserFollowReq localNearbyUserFollowReq = new NowSummaryCard.NearbyUserFollowReq();
    localNearbyUserFollowReq.from.set(0);
    localNearbyUserFollowReq.id_type.set(0);
    localNearbyUserFollowReq.target_id.set(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId);
    localNearbyUserFollowReq.operation.set(i1);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new NearbyProfileDisplayPanel.31(this), localNearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
  }
  
  private void v()
  {
    int i1;
    if (this.n) {
      i1 = 6;
    } else {
      i1 = 2;
    }
    ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).follow(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, i1, this.u ^ true, new NearbyProfileDisplayPanel.32(this));
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, false);
  }
  
  private void x()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mCardHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      int i1;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mCardHandler.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vCookies, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), 0);
          boolean bool = ((INearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue());
          if (PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app) > 0)
          {
            if (bool) {
              i1 = 3;
            } else {
              i1 = 2;
            }
          }
          else if (bool) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "P_prof", "Prof_good", 2, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), i1, Integer.toString(ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType)), String.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        }
      }
      else if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) || (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        INearbyLikeLimitManager.LikeItem localLikeItem = new INearbyLikeLimitManager.LikeItem();
        localLikeItem.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        localLikeItem.jdField_b_of_type_Int = this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        localLikeItem.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue();
        localLikeItem.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource;
        localArrayList.add(localLikeItem);
        if (NearbyProfileCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
          i1 = 510;
        } else {
          i1 = 509;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mCardHandler.a(localArrayList, i1);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      }
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
      NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "pass", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
    }
    this.jdField_d_of_type_Boolean = true;
    l();
    ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_msg", 0, 0, "", "", "", "");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).uin != null)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
    } else {
      localObject = "";
    }
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004826", "0X8004826", i1, 0, (String)localObject, "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa == 76)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004944", "0X8004944", 0, 0, "", "", "", "");
    }
    NearbyPeopleProfileActivity.testGiftCount = 0;
    if (ProfileEntryUtils.isFromHotChat(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800523D", "0X800523D", 0, 0, "", "", "", "");
      return;
    }
    if (ProfileEntryUtils.isFromFreshNews(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005CAA", "0X8005CAA", 0, 0, "", "", "", "");
    }
  }
  
  protected int a()
  {
    return 2131561216;
  }
  
  View a(int paramInt, PicInfo paramPicInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAvatarWallItemView, position = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", info = ");
      ((StringBuilder)localObject1).append(paramPicInfo.toString());
      QLog.d("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((RelativeLayout)localObject1).setLayoutParams(new AbsListView.LayoutParams(-2, -2));
    Object localObject2 = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((RelativeLayout)localObject1).addView((View)localObject2, new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth));
    Object localObject3 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((ImageView)localObject3).setBackgroundResource(2130841366);
    ((ImageView)localObject3).setImageResource(2130846031);
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject3).setVisibility(8);
    int i1 = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 24.0F);
    Object localObject4 = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject4).addRule(13);
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    ((CustomImgView)localObject2).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845055));
    ((CustomImgView)localObject2).setTag(paramPicInfo);
    ((CustomImgView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131707284));
      ((StringBuilder)localObject3).append(paramInt);
      ((RelativeLayout)localObject1).setContentDescription(((StringBuilder)localObject3).toString());
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845868);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mIsPlayDynamicAvatar) && (!TextUtils.isEmpty(paramPicInfo.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramPicInfo.jdField_d_of_type_JavaLangString, localObject1);
        if (DynamicAvatarDownloadManager.b(paramPicInfo.jdField_d_of_type_JavaLangString))
        {
          ((RelativeLayout)localObject1).getChildAt(1).setVisibility(8);
          a(paramPicInfo, (RelativeLayout)localObject1);
          return localObject1;
        }
        if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.downDynamicAvatar(paramPicInfo.jdField_d_of_type_JavaLangString);
          ((RelativeLayout)localObject1).getChildAt(1).setVisibility(0);
        }
        else
        {
          ((RelativeLayout)localObject1).getChildAt(1).setVisibility(0);
        }
      }
      else
      {
        ((RelativeLayout)localObject1).getChildAt(1).setVisibility(8);
      }
      if ((paramPicInfo.jdField_c_of_type_JavaLangString != null) && (paramPicInfo.jdField_c_of_type_JavaLangString.length() > 0))
      {
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        ((CustomImgView)localObject2).setImageDrawable(URLDrawable.getDrawable(new File(paramPicInfo.jdField_c_of_type_JavaLangString).toURL(), (URLDrawable.URLDrawableOptions)localObject4));
        return localObject1;
      }
      if (!StringUtil.a(paramPicInfo.jdField_a_of_type_JavaLangString))
      {
        paramPicInfo = NearbyImgDownloader.convertURL(paramPicInfo.jdField_a_of_type_JavaLangString);
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        paramPicInfo = URLDrawable.getDrawable(paramPicInfo, (URLDrawable.URLDrawableOptions)localObject4);
        paramPicInfo.setDownloadListener(new ImgDownloadListener(BaseApplicationImpl.getApplication(), "actNearbyPeoplePicDownload"));
        ((CustomImgView)localObject2).setImageDrawable(paramPicInfo);
        return localObject1;
      }
      if (paramPicInfo.g == "type_qq_head_pic")
      {
        ((CustomImgView)localObject2).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840322));
        return localObject1;
      }
    }
    catch (MalformedURLException paramPicInfo)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PicGallery.getView() new URL(). ");
        ((StringBuilder)localObject2).append(paramPicInfo.getMessage());
        QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString(), paramPicInfo);
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    DownloadApi.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  public void a(int paramInt1, int paramInt2)
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
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mIsUsingBigHead)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.add(0, localObject);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mIsUsingBigHead = true;
        }
        else if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.isEmpty())
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.set(0, localObject);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$AvatarWallAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$AvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo);
        }
        if (paramInt2 != 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.refreshStrangerFace();
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, localMalformedURLException.getMessage());
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 1000) && (paramInt1 != 1001))
    {
      if (paramInt1 == 1002) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a = true;
      }
    }
    else
    {
      NearbyPublishMenuHelper.a(this.jdField_a_of_type_AndroidContentContext, paramInt1, paramInt2, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a = true;
    }
    if (paramInt1 != 1000) {
      if (paramInt1 != 1018) {
        if (paramInt1 != 1028)
        {
          if (paramInt1 != 1032) {
            return;
          }
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("doOnActivityResult, requestCode=");
            paramIntent.append(paramInt1);
            paramIntent.append(", resultCode=");
            paramIntent.append(paramInt2);
            QLog.d("nearby.bindphone", 2, paramIntent.toString());
          }
          if (paramInt2 != -1) {
            break label619;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_Int = 0;
        this.p = false;
        paramInt2 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount();
        paramInt1 = 0;
        if (paramInt1 < paramInt2)
        {
          paramIntent = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
          if ((!(paramIntent.getTag() instanceof DataTag)) || (((DataTag)paramIntent.getTag()).jdField_a_of_type_Int != 8)) {
            break label625;
          }
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("updateBottomBtn, idx=");
            paramIntent.append(paramInt1);
            QLog.d("nearby.bindphone", 2, paramIntent.toString());
          }
          b(paramInt1, 8);
        }
        ((INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a();
        if (QLog.isColorLevel()) {
          QLog.d("nearby.bindphone", 2, "doOnActivityResult, cleanProfileCardCache");
        }
        try
        {
          paramIntent = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getSystemService("input_method");
          if (paramIntent == null) {
            break label619;
          }
          paramIntent.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView().getWindowToken(), 0);
          return;
        }
        catch (Exception paramIntent)
        {
          if (!QLog.isColorLevel()) {
            break label619;
          }
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnActivityResult, hideSoftInputPanel exp:");
        localStringBuilder.append(paramIntent);
        QLog.e("nearby.bindphone", 2, localStringBuilder.toString());
        return;
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          break label619;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnActivityResult, exp=");
      localStringBuilder.append(paramIntent.toString());
      QLog.e("nearby.bindphone", 2, localStringBuilder.toString());
      return;
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("NearbyPeopleProfileActivity->doOnActivityResult, resultCode=");
        paramIntent.append(paramInt2);
        QLog.d("NearbyLikeLimitManager", 2, paramIntent.toString());
      }
      if (NearbyProfileCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
        paramInt1 = 510;
      } else {
        paramInt1 = 509;
      }
      paramIntent = (INearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
      long l2 = 0L;
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
      }
      catch (Exception localException)
      {
        long l1;
        label514:
        break label514;
      }
      l1 = l2;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnActivityResult req NearbyLikeLimitInfo: mCard.uin=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
        QLog.e("NearbyLikeLimitManager", 2, localStringBuilder.toString());
        l1 = l2;
      }
      paramIntent.a(l1, 0L, paramInt1);
      return;
      if (paramInt2 == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa = 25;
        i();
        return;
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(-1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
      }
      label619:
      return;
      label625:
      paramInt1 += 1;
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379689));
    this.h = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379663));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380068));
    paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    this.jdField_b_of_type_Int = paramView.getDimensionPixelSize(2131297470);
    this.jdField_c_of_type_Int = paramView.getDimensionPixelSize(2131297469);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368717));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView = ((NearbyCardVoteView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380996));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setIsTribe(false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131368151));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout = ((NestScrollLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363784));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131376750);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369224));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369256));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363731));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131363781);
    paramView = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131371955);
    ImageView localImageView1 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380480);
    ImageView localImageView2 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370026);
    NearbyProfileDisplayPanel.2 local2 = new NearbyProfileDisplayPanel.2(this, paramView, localImageView1, localImageView2);
    paramView.setOnClickListener(local2);
    localImageView1.setOnClickListener(local2);
    localImageView2.setOnClickListener(local2);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null))
    {
      paramView.setImageResource(2130845726);
      localImageView1.setImageResource(2130845728);
      localImageView2.setImageResource(2130845724);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131373252));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager = ((AvatarWallViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131363168));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131376753));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372025));
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372023);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372022));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372028));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372027));
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView = ((AutoScrollImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372026));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372021));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370330));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368728));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131379030).setBackgroundResource(2130845682);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690529);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new NearbyProfileDisplayPanel.3(this));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setAppInterface(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager = ((NestViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131380851));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getSupportFragmentManager();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment = new NearbyProfileFragment();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment = new NearbyMomentFragment();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378217));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130851328));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setEnableRepeatedClick(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabTextSize(16);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectColor(Color.parseColor("#0dc4fd"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(Color.parseColor("#777777"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectBgRes(2130845717);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnSelectBgRes(2130845718);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineHeight(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineMargin(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 44.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabHeight(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 45.0F));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager);
    paramView = new LinearLayout.LayoutParams(0, -1);
    paramView.gravity = 17;
    paramView.weight = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabLayoutParams(paramView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, HardCodeUtil.a(2131707279), true, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, HardCodeUtil.a(2131707337), true, true);
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
      i1 = NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    } else if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3) {
      i1 = NearbyDataManager.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    } else {
      i1 = -1;
    }
    if (i1 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, false);
    } else if (i1 == 1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
    }
    if (i1 == -1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a(new NearbyProfileDisplayPanel.4(this, i1));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378277));
  }
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if ((paramInterestTagInfo != null) && (paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 1))
    {
      Object localObject;
      if (paramInterestTagInfo.bid != 0L)
      {
        paramView = new StringBuilder();
        paramView.append("https://buluo.qq.com/mobile/barindex.html?bid=");
        paramView.append(paramInterestTagInfo.bid);
        paramView.append("&_wv=1027");
        paramView = paramView.toString();
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      }
      else
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://buluo.qq.com/mobile/search_result.html?_bid=128&_wv=1027&search_keyword=");
        ((StringBuilder)localObject).append(paramInterestTagInfo.tagName);
        ((StringBuilder)localObject).append("&from=nearby_tag");
        paramView.putExtra("url", ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
      }
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (paramInterestTagInfo.bid != 0L) {
        paramView = "tag_same";
      } else {
        paramView = "clk_tag";
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        paramInterestTagInfo = "1";
      } else {
        paramInterestTagInfo = "2";
      }
      int i1;
      if (paramInt <= 4)
      {
        localObject = new StringBuilder();
        i1 = paramInt + 3;
      }
      else
      {
        localObject = new StringBuilder();
        i1 = paramInt - 4;
      }
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("");
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", paramView, 0, 0, paramInterestTagInfo, "", ((StringBuilder)localObject).toString(), "");
      ThreadManager.post(new NearbyProfileDisplayPanel.35(this, paramInt), 5, null, false);
      return;
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a("NearbyProfileDisplayPanel", new Object[] { "onTagClick", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode), Integer.valueOf(paramInt), paramInterestTagInfo });
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getIsHostSelf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode = 2;
      } else {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode = 3;
      }
    }
    paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
    if (paramNearbyPeopleCard != null) {
      paramNearbyPeopleCard.setNearbyPeopleCard(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    }
    paramNearbyPeopleCard = SharedPreUtils.l(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (!TextUtils.isEmpty(paramNearbyPeopleCard)) {
      try
      {
        this.jdField_d_of_type_JavaLangString = new JSONObject(paramNearbyPeopleCard).getString("ownerLikeJumpURL");
      }
      catch (JSONException paramNearbyPeopleCard)
      {
        paramNearbyPeopleCard.printStackTrace();
      }
    }
    if (!this.s) {
      this.s = true;
    }
    m();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    paramNearbyPeopleCard = new StringBuilder();
    paramNearbyPeopleCard.append("");
    paramNearbyPeopleCard.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId);
    String str2 = paramNearbyPeopleCard.toString();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode;
    String str1 = "1";
    if (i1 == 2) {
      paramNearbyPeopleCard = "1";
    } else {
      paramNearbyPeopleCard = "2";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from % 20);
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", str2, "data_card", "exp", 0, 0, paramNearbyPeopleCard, localStringBuilder.toString(), "", "");
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.getAdapter() == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setAdapter(new NearbyProfileDisplayPanel.NearbyProfilePagerAdapter(this, this.jdField_a_of_type_AndroidxFragmentAppFragmentManager, this.jdField_a_of_type_JavaUtilArrayList));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        i1 = NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
      } else if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3) {
        i1 = NearbyDataManager.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
      } else {
        i1 = -1;
      }
      if (i1 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(1, false);
      } else if (i1 == 1) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(0, false);
      }
      if (i1 == -1) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(0, false);
      }
    }
    if (NearbyProfileCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from))
    {
      this.p = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsgForTribar;
      this.q = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTipsForTribar;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;
    }
    else
    {
      this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maskMsgFlag;
      this.p = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsg;
      this.q = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTips;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips;
    }
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.highScoreNum;
    a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
    p();
    o();
    h();
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser()) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isFuXiaoJin()))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841373);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1)
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130846086);
      } else {
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130846085);
      }
      ThreadManager.post(new NearbyProfileDisplayPanel.13(this), 8, null, true);
    }
    else
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType == 31) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.aioDistance)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2))
    {
      paramNearbyPeopleCard = this.jdField_f_of_type_AndroidWidgetTextView;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.aioDistance);
      ((StringBuilder)localObject).append(" · ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131707310));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject).toString());
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotChatDistance", 2, "bindData, use aioDistance");
      }
    }
    else if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2))
    {
      paramNearbyPeopleCard = this.jdField_f_of_type_AndroidWidgetTextView;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131707294));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject).toString());
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)))
    {
      paramNearbyPeopleCard = this.jdField_f_of_type_AndroidWidgetTextView;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance);
      ((StringBuilder)localObject).append("·");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131707409));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject).toString());
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      paramNearbyPeopleCard = new StringBuilder();
      paramNearbyPeopleCard.append("bindData, mCard.videoInfo = ");
      paramNearbyPeopleCard.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo);
      QLog.d("NearbyProfileDisplayPanel", 2, paramNearbyPeopleCard.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.equals("")))
      {
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.trim();
        break label1243;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname != null)
      {
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
        break label1243;
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname != null)
    {
      paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
      break label1243;
    }
    paramNearbyPeopleCard = "";
    label1243:
    ((TextView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131380096)).setText(paramNearbyPeopleCard);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNowNowSmallVideoObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
    {
      if (this.o)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_face_score").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.uin).a();
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        i();
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    j();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_pub").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
          paramNearbyPeopleCard = "1";
        } else {
          paramNearbyPeopleCard = "2";
        }
        ((ReportTask)localObject).a(new String[] { paramNearbyPeopleCard }).a();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a() == 1)
    {
      localObject = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        paramNearbyPeopleCard = str1;
      } else {
        paramNearbyPeopleCard = "2";
      }
      ((ReportTask)localObject).a(new String[] { paramNearbyPeopleCard }).a();
    }
  }
  
  public void a(PicInfo paramPicInfo, RelativeLayout paramRelativeLayout)
  {
    CustomImgView localCustomImgView = (CustomImgView)paramRelativeLayout.getChildAt(0);
    paramRelativeLayout = (ImageView)paramRelativeLayout.getChildAt(1);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130851081);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bigImageWidth;
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bigImageWidth;
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
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131692183, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, HardCodeUtil.a(2131707356), 0).a();
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", paramString2);
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_hdsp_nearby");
    ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).startDownload(paramString1, localBundle, new NearbyProfileDisplayPanel.42(this, paramString3));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadVideoHeadFinish, url = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramString = (View)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString != null) {
        if ((paramString instanceof RelativeLayout))
        {
          paramString = (RelativeLayout)paramString;
          localObject = (AvatarWallPagerAdapter.ViewHolder)paramString.getTag(2131378272);
          if ((localObject != null) && (((AvatarWallPagerAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangObject != null))
          {
            a((PicInfo)((AvatarWallPagerAdapter.ViewHolder)localObject).jdField_a_of_type_JavaLangObject, paramString);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.e("NearbyProfileDisplayPanel", 2, "onDownloadVideoHeadFinish went error .., holder is null or holder.data is null");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("NearbyProfileDisplayPanel", 2, "onDownloadVideoHeadFinish went error .., view is not a instance of RelativeLayout");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList)
  {
    ProfileBusiEntry localProfileBusiEntry;
    if ((paramBoolean) && (paramList != null) && (paramList.size() != 0) && (paramInt == 0))
    {
      paramList = (ShowExternalTroop)paramList.get(0);
      this.jdField_e_of_type_JavaLangString = paramList.troopUin;
      this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry = new ProfileBusiEntry();
      localProfileBusiEntry = this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry;
      localProfileBusiEntry.nBusiEntryType = 1024;
      localProfileBusiEntry.strTitle = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131696164);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry.strContent = paramList.troopName;
      this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry.strLogoUrl = paramList.strFaceUrl;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry.strContent != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_e_of_type_JavaLangString, "1", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_e_of_type_JavaLangString, "0", "", "");
      }
      return;
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if (paramList != null)
    {
      localProfileBusiEntry = this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry;
      if (localProfileBusiEntry != null) {
        paramList.removeBuisEntry(localProfileBusiEntry);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.uin))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, GameCenterActivity.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("plat=qq&tt=1&_wv=3&qappid=");
      localStringBuilder.append(AppSetting.a());
      localStringBuilder.append("&osv=");
      localStringBuilder.append(Build.VERSION.RELEASE);
      localStringBuilder.append("&vuin=");
      localStringBuilder.append(NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.uin));
      localStringBuilder.append("&vname=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.nickname);
      localStringBuilder.append("&bn=");
      localStringBuilder.append(paramBoolean);
      paramString.putExtra("url", HtmlOffline.a(str, localStringBuilder.toString()));
      paramString.putExtra("big_brother_source_key", "biz_src_zf_games");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new nearby.Cmd0x1RspBody();
    try
    {
      ((nearby.Cmd0x1RspBody)localObject1).mergeFrom(paramArrayOfByte);
      this.jdField_c_of_type_JavaLangString = ((nearby.Cmd0x1RspBody)localObject1).bytes_qunlist_url.get().toStringUtf8();
      this.jdField_a_of_type_ArrayOfByte = ((nearby.Cmd0x1RspBody)localObject1).bytes_chat_sig.get().toByteArray();
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getMsgCache().h(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ArrayOfByte);
      this.u = ((nearby.Cmd0x1RspBody)localObject1).bool_follow.get();
      this.jdField_d_of_type_Int = ((nearby.Cmd0x1RspBody)localObject1).uint32_if_mask_msg.get();
      int i1 = ((nearby.Cmd0x1RspBody)localObject1).uint32_if_mask_msg.get();
      boolean bool2 = true;
      boolean bool1;
      if (i1 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.p = bool1;
      if (((nearby.Cmd0x1RspBody)localObject1).uint32_if_mask_gift.get() == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.q = bool1;
      if (((nearby.Cmd0x1RspBody)localObject1).bytes_mask_msg_reason.has()) {
        this.jdField_a_of_type_JavaLangString = ((nearby.Cmd0x1RspBody)localObject1).bytes_mask_msg_reason.get().toStringUtf8();
      }
      if (((nearby.Cmd0x1RspBody)localObject1).bytes_mask_gift_reason.has()) {
        this.jdField_b_of_type_JavaLangString = ((nearby.Cmd0x1RspBody)localObject1).bytes_mask_gift_reason.get().toStringUtf8();
      }
      localObject1 = (nearby.FansInfo)((nearby.Cmd0x1RspBody)localObject1).FansInfo_fans.get();
      i1 = ((nearby.FansInfo)localObject1).uint32_follows_num.get();
      int i2 = ((nearby.FansInfo)localObject1).uint32_fans_num.get();
      paramArrayOfByte = ((nearby.FansInfo)localObject1).bytes_follows_url.get().toStringUtf8();
      localObject1 = ((nearby.FansInfo)localObject1).bytes_fans_url.get().toStringUtf8();
      this.jdField_b_of_type_AndroidViewView.findViewById(2131367063).setVisibility(0);
      Object localObject2 = this.jdField_g_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131707381));
      localStringBuilder.append(i1);
      ((TextView)localObject2).setText(localStringBuilder.toString());
      localObject2 = this.h;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131707311));
      localStringBuilder.append(i2);
      ((TextView)localObject2).setText(localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getNearByInfo, followsNum=");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(", fansNum=");
        ((StringBuilder)localObject2).append(i2);
        QLog.d("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject2).toString());
      }
      if (!TextUtils.isEmpty(paramArrayOfByte)) {
        this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(new NearbyProfileDisplayPanel.7(this, paramArrayOfByte));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.h.setOnClickListener(new NearbyProfileDisplayPanel.8(this, (String)localObject1));
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Cmd0x1RspBody error !:");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        QLog.w("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public boolean a()
  {
    NewVoteAnimHelper localNewVoteAnimHelper = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
    if (localNewVoteAnimHelper != null) {
      return localNewVoteAnimHelper.jdField_b_of_type_Boolean;
    }
    return false;
  }
  
  public int b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController;
    if (localObject != null) {
      ((ProfileQiqiLiveController)localObject).a(10);
    }
    DownloadApi.b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).uRoomid != 0L)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "content_timer", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), "", "yes", "android");
    }
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo = paramNearbyPeopleCard.vGiftInfo;
  }
  
  void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).shouldShowLikeBtn()))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      boolean bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
      boolean bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((NearbyCardVoteView)localObject).a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, null, true, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.praiseList);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
      if (QSecFramework.a().a(1001).booleanValue())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(41), localObject }, null);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.jdField_b_of_type_Boolean = false;
    }
  }
  
  boolean b()
  {
    return (Utils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.preWinUin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.uin)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.preWinType != 3000) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.preWinType != 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.preWinType != 2);
  }
  
  public void c()
  {
    NearbyCardVoteView localNearbyCardVoteView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
    if (localNearbyCardVoteView != null) {
      localNearbyCardVoteView.a(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    } else if (paramBoolean) {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    } else {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    }
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
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHasEverVote = true;
    b(paramBoolean);
    if (QSecFramework.a().a(1001).booleanValue()) {
      QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(6), "vote", null }, null);
    }
  }
  
  public void d()
  {
    NearbyMomentFragment localNearbyMomentFragment = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment;
    if (localNearbyMomentFragment != null) {
      localNearbyMomentFragment.a();
    }
    if (this.v) {
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.37(this), 16, null, false);
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    if ((this.q) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_b_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    NearbyPeopleProfileActivity.testGiftCount += 1;
    String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.uin;
    Object localObject2 = Utils.a(a());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (Friends.isValidUin(str))
    {
      localObject2 = NearbyURLSafeUtil.a(str);
      str = ((String)localObject1).toLowerCase();
      if (d() == 10002) {
        i1 = 6;
      } else {
        i1 = 1;
      }
      if (paramBoolean) {
        localObject1 = "near.card.like";
      } else {
        localObject1 = "near.card.s";
      }
      localObject1 = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { localObject2, str, Integer.valueOf(i1), localObject1, "" });
      localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("portraitOnly", true);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
      int i1 = NearbyProfileUtil.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType);
      if (NearbyProfileCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
        i1 = 6;
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_gift", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052BA", "0X80052BA", i1, 0, "", "", "", "");
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
    ((NearbyPeopleProfileActivity)localObject1).showToast(((NearbyPeopleProfileActivity)localObject1).getString(2131693476));
  }
  
  public void e()
  {
    if (this.v) {
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.38(this), 16, null, false);
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
    if (localObject != null) {
      ((NewVoteAnimHelper)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
    if (localObject != null) {
      ((NearbyCardVoteView)localObject).a(false);
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(1))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      x();
    }
  }
  
  public void g()
  {
    if (((NearbyProxy)NearbyManagerHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)).a() != null) {
      ((NearbyProxy)NearbyManagerHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)).a().clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNowNowSmallVideoObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).shouldShowLikeBtn()) && (!this.o))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
      if (QSecFramework.a().a(1001).booleanValue())
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(41), localObject }, null);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void i()
  {
    DatingUtil.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getSimpleName(), new Object[] { "card godflag is `", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag), " sayhello flag is ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sayHelloFlag) });
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
      if (!this.n) {
        b(2, 8);
      } else {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa == 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatCookie == null) && (!b())) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
      } else if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.n)) {
        b(2, 8);
      } else {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
      }
      b(1, 60);
    }
    Button localButton;
    if ((!this.u) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() != 0))
    {
      localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131379994);
      localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167089));
      localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845687));
    }
    else
    {
      ((Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131379994)).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845688));
    }
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).getVisibility() != 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() != 0))
    {
      localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).findViewById(2131379994);
      localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167089));
      localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845687));
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHasNewPhoto)
    {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo;
    }
    else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl))
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo;
    int i1 = 0;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.size() > 0)) {
      a(((PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.get(0)).jdField_a_of_type_JavaLangString);
    }
    localObject1 = new NearbyProfileDisplayPanel.AvatarViewPagerAdatper(this, this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setAdapter((AvatarWallPagerAdapter)localObject1);
    Object localObject2 = new ArrayList();
    this.jdField_g_of_type_Int = ((int)Math.ceil(this.jdField_a_of_type_JavaUtilList.size() / 6.0F));
    while (i1 < this.jdField_g_of_type_Int)
    {
      ((List)localObject2).add(a(this.jdField_a_of_type_JavaUtilList, i1));
      i1 += 1;
    }
    ((NearbyProfileDisplayPanel.AvatarViewPagerAdatper)localObject1).a((List)localObject2);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3) {
      localObject1 = "2";
    } else {
      localObject1 = "1";
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_head", 0, 0, (String)localObject1, "", "", "");
    localObject1 = (RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131376689);
    localObject2 = (LinearLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.getLayoutParams();
    if (localObject2 != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 3)
      {
        ((LinearLayout.LayoutParams)localObject2).height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3 * 2);
        localLayoutParams.height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3 * 2);
      }
      else
      {
        ((LinearLayout.LayoutParams)localObject2).height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3);
        localLayoutParams.height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3);
      }
      ((LinearLayout.LayoutParams)localObject2).topMargin = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131299168) + ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity));
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 4.0F);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setDotLayoutParams((RelativeLayout.LayoutParams)localObject1);
  }
  
  public void k()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHeadSize == 640) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHeadSize == 0)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mGetHeadUrl)) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHasNewPhoto)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.downloadHDAvatar(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHeadSize, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mGetHeadUrl, false);
    }
  }
  
  public void l()
  {
    ThreadPriorityManager.a(true);
    int i1 = d();
    if (b())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("finchat", true);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(0, (Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if ((localObject != null) && (!StringUtil.a(String.valueOf(((NearbyPeopleCard)localObject).tinyId)))) {
      a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.chatId), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), i1);
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData == null)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.bytes_live_url.get().toStringUtf8();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("now anchor, jumpUrl=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject1).toString());
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_level.get();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("level: ");
    ((StringBuilder)localObject1).append(i1);
    QLog.i("NearbyProfileDisplayPanel", 1, ((StringBuilder)localObject1).toString());
    if (i1 > 0)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      long l1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId;
      int i2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender;
      String str = "2";
      if (i2 == 0) {
        localObject1 = "1";
      } else if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
        localObject1 = "2";
      } else {
        localObject1 = "0";
      }
      ReportController.b((AppRuntime)localObject3, "dc00899", "grp_lbs", String.valueOf(l1), "status_bar", "bar_exp", 0, 0, (String)localObject1, "", "", "");
      localObject1 = HardCodeUtil.a(2131707391);
      i2 = ((String)localObject1).length();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_live_status.get() == 1)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(i1);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(HardCodeUtil.a(2131707407));
        localObject1 = new SpannableString(localStringBuilder.toString());
        ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-4352), i2, ((String)localObject3).length() + i2, 33);
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setRadius(UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 3.0F));
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845691);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845680);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(new NearbyProfileDisplayPanel.9(this, (String)localObject2));
        localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("live_exp").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
          localObject1 = "1";
        } else if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
          localObject1 = str;
        } else {
          localObject1 = "0";
        }
        ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
        return;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(HardCodeUtil.a(2131707343));
      localObject1 = new SpannableString(localStringBuilder.toString());
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-65536), i2, ((String)localObject3).length() + i2, 33);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAutoScrollImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845681);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845698);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(new NearbyProfileDisplayPanel.10(this, (String)localObject2));
      localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("nonlive_exp").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
        localObject1 = "1";
      } else if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
        localObject1 = str;
      } else {
        localObject1 = "0";
      }
      ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.getTag();
    int i1 = 4;
    Object localObject1 = "";
    int i4 = 0;
    boolean bool = false;
    int i3 = 2;
    int i2;
    if ((localObject2 != null) && ((localObject2 instanceof DataTag)))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482E", "0X800482E", 0, 0, "", "", "", "");
      paramView = (DataTag)localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("click  data.nType= [");
        ((StringBuilder)localObject2).append(paramView.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append("]");
        QLog.i("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject2).toString());
      }
      i2 = paramView.jdField_a_of_type_Int;
      if (i2 != 8) {
        if (i2 != 30) {
          if (i2 != 33) {
            if (i2 != 42) {
              if (i2 != 58) {
                if (i2 != 60) {
                  if ((i2 != 27) && (i2 != 28)) {
                    if (i2 != 36) {
                      if (i2 != 37) {
                        if (i2 != 39) {
                          if (i2 != 40) {
                            switch (i2)
                            {
                            default: 
                              return;
                            case 22: 
                              if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
                              {
                                paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
                                if (!StringUtil.a(paramView.strJumpUrl)) {
                                  c(paramView.strJumpUrl);
                                }
                              }
                              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CB", "0X80050CB ", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone)), "", "", "");
                              return;
                            case 21: 
                              if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
                              {
                                paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
                                if (!StringUtil.a(paramView.strJumpUrl))
                                {
                                  localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
                                  ((Intent)localObject2).putExtra("portraitOnly", true);
                                  if (StringUtil.a(paramView.strJumpUrl)) {
                                    paramView = (View)localObject1;
                                  } else {
                                    paramView = paramView.strJumpUrl;
                                  }
                                  ((Intent)localObject2).putExtra("url", paramView);
                                }
                              }
                              break;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
      label424:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CC", "0X80050CC", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone)), "", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
        if ((paramView != null) && (!TextUtils.isEmpty(paramView.uin)))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, paramView, (String)localObject1, null, true, null, true, true, null, "from_internal");
          return;
        }
      }
      Object localObject3;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("mCard == null , or mCard.uin is Empty, ");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend);
        QLog.i("Q.nearby_people_card.", 2, paramView.toString());
        return;
        if ((paramView.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramView = (Object[])paramView.jdField_a_of_type_JavaLangObject;
          a(((Boolean)paramView[0]).booleanValue(), (String)paramView[1]);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CA", "0X80050CA ", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone)), "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
            return;
          }
          if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131692183, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131299168));
            return;
          }
          if (PackageUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "com.guagua.qiqi"))
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "click_bootstrap", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), "", "yes", "android");
            return;
          }
          if (this.jdField_a_of_type_Int == 1)
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton;
            if (paramView != null) {
              paramView.setText(2131699177);
            }
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(3);
            this.jdField_a_of_type_Int = 2;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_pause", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), "", "yes", "android");
            return;
          }
          if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
          {
            if (this.l)
            {
              paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
              DialogUtil.a(paramView, 230, paramView.getString(2131698754), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131698753), 0, 2131699178, new NearbyProfileDisplayPanel.18(this), null).show();
              this.l = false;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), "", "yes", "android");
            }
            else
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), "", "yes", "android");
            }
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(2);
            i1 = this.jdField_a_of_type_Int;
            if ((i1 == 2) || (i1 == 0)) {
              this.jdField_a_of_type_Int = 1;
            }
          }
          else
          {
            i1 = this.jdField_a_of_type_Int;
            if ((i1 != 2) && (i1 != 0))
            {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(2);
              return;
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
            localObject1 = paramView.getString(2131698754);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131698752);
            localObject3 = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
            DialogUtil.a(paramView, 230, (String)localObject1, (String)localObject2, (DialogInterface.OnClickListener)localObject3, (DialogInterface.OnClickListener)localObject3).show();
            this.jdField_a_of_type_Int = 1;
          }
        }
        else
        {
          return;
          if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80055CA", "0X80055CA", 0, 0, "", "", "", "");
            paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.strJumpUrl);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.waitingForSayhelloLimit)
            {
              DatingUtil.c("nearbyprofilecard", new Object[] { "have click sayhello, wating for resp" });
              return;
            }
            paramView = (INearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
            if (paramView != null)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
              ((NearbyPeopleProfileActivity)localObject1).waitingForSayhelloLimit = true;
              if ((((NearbyPeopleProfileActivity)localObject1).allinone.profileEntryType == 17) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType == 18) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType == 19)) {
                i1 = 8;
              }
              i2 = i1;
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1)
              {
                i2 = i3;
                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
                  i2 = 1;
                }
                i2 = i1 | i2;
              }
              paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId, i2, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatCookie);
              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.sendEmptyMessageDelayed(204, 1000L);
                return;
                d(false);
                if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app != null)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0))
                  {
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
                    return;
                  }
                  if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1))
                  {
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528B", "0X800528B", 0, 0, "", "", "", "");
                    return;
                    if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
                    {
                      localObject1 = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
                      if (!StringUtil.a(((ProfileBusiEntry)localObject1).strJumpUrl))
                      {
                        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
                        ((Intent)localObject2).putExtra("url", ((ProfileBusiEntry)localObject1).strJumpUrl);
                        ((Intent)localObject2).putExtra("hide_operation_bar", true);
                        ((Intent)localObject2).putExtra("hide_more_button", true);
                        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
                      }
                    }
                    if (28 == paramView.jdField_a_of_type_Int)
                    {
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CD", "0X80050CD", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone)), "", "", "");
                      return;
                      localObject1 = a();
                      if (this.u) {
                        paramView = "clk_followed";
                      } else {
                        paramView = "clk_follow";
                      }
                      ReportController.b(null, "dc00899", "grp_lbs", (String)localObject1, "data_card", paramView, 0, 0, "", "", "", "");
                      if (!NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
                      {
                        paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                        QQToast.a(paramView, 0, paramView.getResources().getString(2131694422), 0).a();
                        return;
                      }
                      ((INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), Integer.valueOf(1));
                      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType == 1)
                      {
                        v();
                        return;
                      }
                      u();
                      return;
                      if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
                      {
                        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "0X8006E05", "0X8006E05", 1, 0, new String[0]);
                        paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
                        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
                        ((Intent)localObject1).putExtra("url", paramView.strJumpUrl);
                        ((Intent)localObject1).putExtra("hide_operation_bar", true);
                        ((Intent)localObject1).putExtra("hide_more_button", true);
                        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
                        return;
                        if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
                        {
                          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005D14", "0X8005D14", 0, 0, "", "", "", "");
                          paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
                          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
                          ((Intent)localObject1).putExtra("url", paramView.strJumpUrl);
                          ((Intent)localObject1).putExtra("hide_operation_bar", true);
                          ((Intent)localObject1).putExtra("hide_more_button", true);
                          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
                          return;
                          if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
                          {
                            paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
                            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
                            localObject2 = new StringBuilder();
                            ((StringBuilder)localObject2).append(paramView.strJumpUrl);
                            ((StringBuilder)localObject2).append("&_webviewtype=1");
                            ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
                            ((Intent)localObject1).putExtra("hide_operation_bar", true);
                            ((Intent)localObject1).putExtra("hide_more_button", true);
                            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
                            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005102", "0X8005102", 0, 0, "", "", "", "");
                            return;
                            if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
                            {
                              paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ShowExternalTroopListActivity.class);
                              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa == 0) {
                                bool = true;
                              }
                              paramView.putExtra("isHost", bool);
                              paramView.putExtra("dest_uin_str", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.uin);
                              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
                              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
                              {
                                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_e_of_type_JavaLangString, "1", "", "");
                                return;
                              }
                              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
                              {
                                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_e_of_type_JavaLangString, "0", "", "");
                                return;
                                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
                                {
                                  if (QLog.isColorLevel())
                                  {
                                    paramView = new StringBuilder();
                                    paramView.append("sendMsgBtnClick, isSendMsgBtnDownloadAppOpen=");
                                    paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isSendMsgBtnDownloadAppOpen);
                                    paramView.append(", sendMsgBtnDownloadAppTips:");
                                    paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips);
                                    paramView.append(", tribeAppDownloadPageUrl=");
                                    paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
                                    QLog.d("Q.nearby.tribeAppDownload", 2, paramView.toString());
                                  }
                                }
                                else {
                                  QLog.w("NearbyProfileDisplayPanel", 1, "onClick DATA_TYPE_CHAT mcard == null!");
                                }
                                if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend)
                                {
                                  i1 = this.jdField_d_of_type_Int;
                                  if (i1 != 0)
                                  {
                                    if ((i1 != 4) && (i1 != 5))
                                    {
                                      if (i1 == 3)
                                      {
                                        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
                                        {
                                          QLog.i("NearbyProfileDisplayPanel", 1, "mMaskMsgFlag == STATE_WX, mCard == null");
                                          return;
                                        }
                                        s();
                                        return;
                                      }
                                      if (i1 == 2)
                                      {
                                        r();
                                        return;
                                      }
                                      if (i1 == 1) {
                                        q();
                                      }
                                    }
                                    else
                                    {
                                      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!c())) {
                                        break label2634;
                                      }
                                      t();
                                    }
                                    return;
                                    label2634:
                                    QLog.i("NearbyProfileDisplayPanel", 1, "mMaskMsgFlag == STATE_VERIFY, mCard == null");
                                    return;
                                  }
                                }
                                if (c()) {
                                  y();
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      return;
      if (paramView == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView)
      {
        if (2 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "clk_list", 0, 0, "", "", "", "");
          if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
          {
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, VisitorsActivity.class);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
            if (localObject1 == null) {
              i1 = 0;
            } else {
              i1 = ((NearbyPeopleCard)localObject1).likeCount;
            }
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue());
            ((Bundle)localObject1).putLong("totalVoters", i1);
            ((Bundle)localObject1).putBoolean("isStartedByProfileCard", true);
            ((Bundle)localObject1).putBoolean("votersOnly", true);
            if (i1 > 0) {
              bool = true;
            } else {
              bool = false;
            }
            ((Bundle)localObject1).putBoolean("hasVoters", bool);
            ((Bundle)localObject1).putBoolean("extra_show_rank", true);
            ((Bundle)localObject1).putInt("frome_where", 4);
            paramView.putExtras((Bundle)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
          }
          else
          {
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            if (d() == 10002) {
              paramView = "6";
            } else {
              paramView = "1";
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangString);
            ((StringBuilder)localObject2).append("&SOURCETYPE=");
            ((StringBuilder)localObject2).append(paramView);
            ((StringBuilder)localObject2).append("&SIGN=");
            ((StringBuilder)localObject2).append(a());
            ((StringBuilder)localObject2).append("&UIN=");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getCurrentAccountUin());
            ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
          }
          NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
          if (paramView != null)
          {
            paramView.likeCountInc = 0;
            h();
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute(new NearbyProfileDisplayPanel.19(this));
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
          if (paramView != null) {
            paramView.jdField_b_of_type_Boolean = true;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mEnterProfileIntent.getBooleanExtra("IS_NEARBY_REDDOT_INCOME", false)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005249", "0X8005249", 0, 0, "", "", "", "");
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800657A", "0X800657A", 2, 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone)), "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a.getVisibility() == 0)) {
            paramView = "1";
          } else {
            paramView = "2";
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00898", "", "", "0X8007610", "0X8007610", 2, 0, paramView, "", "", "");
          return;
        }
        if (3 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode)
        {
          this.jdField_b_of_type_Boolean = true;
          localObject1 = new HashMap();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
            paramView.showToast(paramView.getString(2131693371));
            ((HashMap)localObject1).put("param_FailCode", "-210");
            StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            if (QLog.isColorLevel()) {
              QLog.i("NearbyProfileDisplayPanel", 2, "mCard is null,vote failed !");
            }
            return;
          }
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("Click Vote View, mCard.bAvailVoteCnt = ");
            paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt);
            paramView.append(",mCard.bHaveVotedCnt = ");
            paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt);
            paramView.append(",mCard.strVoteLimitedNotice = ");
            paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strVoteLimitedNotice);
            QLog.i("NearbyProfileDisplayPanel", 2, paramView.toString());
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt <= 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          i2 = i4;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt <= 0)
          {
            i2 = i4;
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt <= 0) {
              i2 = 1;
            }
          }
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("Profile->onClickVote, tinyId=");
            paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId);
            paramView.append(", isFriend=");
            paramView.append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend);
            paramView.append(", bAvailVoteCnt=");
            paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt);
            paramView.append(", bHaveVotedCnt=");
            paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt);
            QLog.d("NearbyLikeLimitManager", 2, paramView.toString());
          }
          if (NearbyProfileCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from)) {
            i3 = 510;
          } else {
            i3 = 509;
          }
          Object localObject4;
          if ((i1 == 0) && (i2 == 0))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mCardHandler != null) && (NetworkUtil.isNetSupport(BaseApplication.getContext())))
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend)
              {
                paramView = (INearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                localObject2 = ((NearbyPeopleProfileActivity)localObject1).app;
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
                localObject4 = new NearbyProfileDisplayPanel.20(this);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(i3);
                localStringBuilder.append("");
                paramView.a((Activity)localObject1, localObject2, (String)localObject3, localObject4, localStringBuilder.toString());
              }
              else
              {
                c(true);
                this.t = true;
              }
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mCardHandler != null)
            {
              ((HashMap)localObject1).put("param_FailCode", "-203");
              StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
              paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
              paramView.showToast(paramView.getString(2131720493));
            }
            else
            {
              ((HashMap)localObject1).put("param_FailCode", "-204");
              StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
              paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
              paramView.showToast(paramView.getString(2131693371));
            }
            paramView = new StringBuilder();
            paramView.append("");
            paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
            localObject3 = paramView.toString();
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3) {
              paramView = "2";
            } else {
              paramView = "1";
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i3);
            ((StringBuilder)localObject1).append("");
            localObject4 = ((StringBuilder)localObject1).toString();
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend) {
              localObject1 = "1";
            } else {
              localObject1 = "2";
            }
            if (this.t) {
              localObject2 = "2";
            } else {
              localObject2 = "1";
            }
            ReportController.b(null, "dc00899", "grp_lbs", (String)localObject3, "data_card", "like_head", 0, 0, paramView, (String)localObject4, (String)localObject1, (String)localObject2);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004825", "0X8004825", c(), 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "", "");
            if (ProfileEntryUtils.isFromHotChat(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005241", "0X8005241", 0, 0, "", "", "", "");
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
              paramView = HardCodeUtil.a(2131707372);
            } else {
              paramView = HardCodeUtil.a(2131707302);
            }
            if (!this.r)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend)
              {
                paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, HardCodeUtil.a(2131707345), "", HardCodeUtil.a(2131707285), new NearbyProfileDisplayPanel.21(this), null);
              }
              else
              {
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(HardCodeUtil.a(2131707290));
                ((StringBuilder)localObject4).append(paramView);
                ((StringBuilder)localObject4).append(HardCodeUtil.a(2131707365));
                paramView = DialogUtil.a((Context)localObject3, 230, null, ((StringBuilder)localObject4).toString(), HardCodeUtil.a(2131707362), HardCodeUtil.a(2131707339), new NearbyProfileDisplayPanel.22(this), new NearbyProfileDisplayPanel.23(this));
              }
              paramView.show();
              this.r = true;
              paramView.setOnDismissListener(new NearbyProfileDisplayPanel.24(this));
            }
            ReportController.b(null, "dc00899", "grp_lbs", "", "data_like", "exp_toast", 0, 0, "", "", "", "");
            if (i2 != 0) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006579", "0X8006579", 2, 0, Integer.toString(ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType)), "", "", "");
            } else if (i1 != 0) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006578", "0X8006578", 2, 0, Integer.toString(ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType)), "", "", "");
            }
            StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).collectPerformance((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528C", "0X800528C", 1, 0, "", "", "", "");
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528D", "0X800528D", 1, 0, "", "", "", "");
            }
          }
        }
      }
      else
      {
        localObject1 = "2";
        if (paramView == this.jdField_f_of_type_AndroidWidgetImageView)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin();
          if ((Friends.isValidUin(paramView)) && (Friends.isValidUin(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
          {
            bool = paramView.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
            if (!bool) {
              paramView = "";
            }
            paramView = String.format("https://ti.qq.com/paihangbanggl/index.html?_wv=1027&isguest=%d&uin=%s", new Object[] { Integer.valueOf(bool ^ true), paramView });
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("portraitOnly", true);
            ((Intent)localObject1).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
          }
        }
        else
        {
          if (paramView == this.jdField_b_of_type_AndroidWidgetTextView)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "clk_edit", 0, 0, "", "", "", "");
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mIsProfileOk == 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showPromptDialog();
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.switchToEditPanel(300L);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004B38", "0X8004B38", 0, 0, "", "", "", "");
            return;
          }
          if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
          {
            paramView = NearbyPublishMenuHelper.a();
            paramView = new NearbyPublishMenu(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView);
            paramView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetNearbyPublishMenu$OnItemClickListener);
            paramView.a(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 18.0F), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 22.0F) + this.jdField_a_of_type_AndroidWidgetImageView.getHeight(), 0.2F);
            localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("pub_download_exp").e(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId));
            paramView = (View)localObject1;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
              paramView = "1";
            }
            ((ReportTask)localObject2).a(new String[] { paramView }).a();
          }
        }
      }
      return;
    }
    catch (SecurityException paramView)
    {
      break label424;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
    if ((localObject != null) && (!((NearbyPeopleProfileActivity)localObject).isFinishing()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
      if ((localObject != null) && (TextUtils.equals(paramString, ((NearbyPeopleCard)localObject).uin)))
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetCustomImgView;
        if (paramString != null) {
          paramString.setImageBitmap(paramBitmap);
        }
        a(paramBitmap);
      }
    }
  }
  
  public void onScrollStateChanged(ScrollView paramScrollView, int paramInt, boolean paramBoolean) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(paramInt2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel
 * JD-Core Version:    0.7.0.1
 */