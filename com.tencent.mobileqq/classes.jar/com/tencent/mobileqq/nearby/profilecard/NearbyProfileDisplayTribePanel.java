package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
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
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.jungle.nearby.nio.proto.nearby.BarInfo;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.jungle.nearby.nio.proto.nearby.FansInfo;
import com.tencent.jungle.nearby.nio.proto.nearby.FeedInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.NearbyTribeAppController;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.nearby.api.FaceScoreUtils;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.api.NearbyProxy;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.ViewHolder;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.entity.ProfileBusiEntry;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyProfileDisplayTribePanel
  extends NearbyProfileDisplayBasePanel
  implements View.OnClickListener, OnTagClickListener, BounceScrollView.OnScrollChangedListener
{
  public static String[] b;
  public static String[] c;
  int jdField_a_of_type_Int = 0;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback;
  Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NewVoteAnimHelper jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  protected FaceScoreConfig a;
  private NearbyTribeAppController jdField_a_of_type_ComTencentMobileqqNearbyNearbyTribeAppController;
  private NearbyCardVoteView jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
  NearbyPeopleProfileActivity jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
  private NearbyProfileDisplayTribePanel.AvatarWallAdapter jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter;
  ProfileQiqiLiveController jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController = null;
  SavorTagImg jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
  protected ProfileBusiEntry a;
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  ProgressButton jdField_a_of_type_ComTencentMobileqqWidgetProgressButton;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  String jdField_a_of_type_JavaLangString;
  private WeakReference<FaceDrawable> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList;
  protected final Map<String, View> a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private byte[] jdField_a_of_type_ArrayOfByte;
  int[] jdField_a_of_type_ArrayOfInt = { 2131369856, 2131369850, 2131369849, 2131369857 };
  RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout;
  private URLImageView[] jdField_a_of_type_ArrayOfComTencentImageURLImageView;
  InterestTag[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag;
  SavorTagIcon[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon;
  SavorTagImg[] jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public boolean b;
  int[] jdField_b_of_type_ArrayOfInt = { 2131369854, 2131369855, 2131369851 };
  RelativeLayout[] jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout;
  int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public boolean c;
  int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  public boolean d;
  int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  public boolean e;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  protected String f;
  public boolean f;
  private LinearLayout jdField_g_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_g_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  private LinearLayout jdField_h_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_h_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  public boolean h;
  private LinearLayout jdField_i_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_i_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  public boolean i;
  private RelativeLayout jdField_j_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  public boolean j;
  private RelativeLayout jdField_k_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  public boolean k;
  private RelativeLayout jdField_l_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  public boolean l;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  boolean jdField_m_of_type_Boolean;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  boolean jdField_n_of_type_Boolean;
  private TextView jdField_o_of_type_AndroidWidgetTextView;
  boolean jdField_o_of_type_Boolean;
  private TextView jdField_p_of_type_AndroidWidgetTextView;
  boolean jdField_p_of_type_Boolean;
  private TextView jdField_q_of_type_AndroidWidgetTextView;
  boolean jdField_q_of_type_Boolean;
  private TextView jdField_r_of_type_AndroidWidgetTextView;
  boolean jdField_r_of_type_Boolean;
  private TextView jdField_s_of_type_AndroidWidgetTextView;
  boolean jdField_s_of_type_Boolean;
  boolean t;
  protected boolean u;
  private boolean v = false;
  private boolean w;
  
  static
  {
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "0X800553B", "0X800553C", "0X800553D", "0X800553E", "0X800553F", "0X8005540", "0X8005541" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "0X8005542", "0X8005543", "0X8005544", "0X8005545", "0X8005546", "0X8005547", "0X8005548" };
  }
  
  public NearbyProfileDisplayTribePanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    boolean bool = true;
    this.jdField_m_of_type_Boolean = true;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new NearbyProfileDisplayTribePanel.1(this);
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new NearbyProfileDisplayTribePanel.5(this);
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.t = false;
    this.jdField_f_of_type_JavaLangString = null;
    this.u = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new NearbyProfileDisplayTribePanel.27(this);
    this.jdField_a_of_type_AndroidOsHandler = new NearbyProfileDisplayTribePanel.29(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new NearbyProfileDisplayTribePanel.30(this);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new NearbyProfileDisplayTribePanel.31(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (paramNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) != 35) {
      bool = false;
    }
    this.jdField_p_of_type_Boolean = bool;
    this.jdField_o_of_type_Boolean = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_werewolves", false);
  }
  
  private List<StrangerInfo> a(List<Object> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof StrangerInfo)) {
        localArrayList.add((StrangerInfo)localObject);
      }
    }
    return localArrayList;
  }
  
  private void a(TextView paramTextView)
  {
    int i1 = paramTextView.getWidth();
    int i2 = paramTextView.getHeight();
    Object localObject2 = new StringBuilder();
    if (this.jdField_f_of_type_Int > 0) {
      localObject1 = "+ ";
    } else {
      localObject1 = "- ";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(String.valueOf(Math.abs(this.jdField_f_of_type_Int)));
    paramTextView.setText(((StringBuilder)localObject2).toString());
    if (paramTextView.getVisibility() != 0) {
      paramTextView.setVisibility(0);
    }
    Object localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, i1 / 2, i2 / 2);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 17432584);
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.setDuration(1500L);
    paramTextView.setAnimation(localAnimationSet);
    localAnimationSet.start();
    this.jdField_f_of_type_Int = 0;
  }
  
  private void a(String paramString)
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
  
  private void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mFromDatingSubject == 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mFromDatingId)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mIsPub))
    {
      String str = NearbyManagerHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a();
      localObject = str;
      if (str == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131698747);
      }
      AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, paramString, (String)localObject, 1010);
    }
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ChatActivity.class);
    ((Intent)localObject).putExtra("PREVIOUS_WINDOW", QQNearbyManager.b().getName());
    ((Intent)localObject).putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    ((Intent)localObject).putExtra("cSpecialFlag", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mEnterProfileIntent.getExtras().getInt("cSpecialFlag"));
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("uintype", paramInt);
    ((Intent)localObject).putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatEntrance != 0) {
      ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatEntrance);
    }
    if (paramInt == 1001)
    {
      ((Intent)localObject).putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatCookie);
      ((Intent)localObject).putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
    }
    else if (paramInt == 1010)
    {
      ((Intent)localObject).putExtra("rich_date_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatCookie);
      ((Intent)localObject).putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
    }
    ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.nickname);
    ((Intent)localObject).addFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
  }
  
  private void a(List<StrangerInfo> paramList)
  {
    int i1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateVistorHeader visitor count:");
      if (paramList == null) {
        i1 = 0;
      } else {
        i1 = paramList.size();
      }
      ((StringBuilder)localObject1).append(i1);
      QLog.d("Q.nearby.visitor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).buildRedTouchAppInfo(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new Object[] { Integer.valueOf(4105), "100510.100523" });
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramList.size() > 3) {
        i1 = 3;
      } else {
        i1 = paramList.size();
      }
      localObject1 = new ArrayList(3);
      int i2 = 0;
      while (i2 < i1)
      {
        localObject2 = (StrangerInfo)paramList.get(i2);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        i2 += 1;
      }
      int i3 = ((List)localObject1).size();
      paramList = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
      Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      i1 = ((RelativeLayout.LayoutParams)localObject2).width;
      i2 = this.jdField_b_of_type_Int;
      int i4 = i3 - 1;
      int i5 = this.jdField_c_of_type_Int;
      if (i1 != i3 * i2 + i4 * i5)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = (i2 * i3 + i4 * i5);
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != AIOUtils.b(35.0F, paramList))) {}
      for (((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(35.0F, paramList);; ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(45.0F, paramList))
      {
        i2 = 1;
        break;
        i2 = i1;
        if (!this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c()) {
          break;
        }
        i2 = i1;
        if (((RelativeLayout.LayoutParams)localObject2).rightMargin == AIOUtils.b(45.0F, paramList)) {
          break;
        }
      }
      if (i2 != 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i1 = 0;
      while (i1 < i3)
      {
        localObject2 = new LinearLayout.LayoutParams(AIOUtils.b(30.0F, paramList), AIOUtils.b(30.0F, paramList));
        ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(5.0F, paramList);
        StrangerInfo localStrangerInfo = (StrangerInfo)((List)localObject1).get(i1);
        if (localStrangerInfo != null)
        {
          CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
          Drawable localDrawable = localCustomImgView.a();
          if ((localDrawable != null) && ((localDrawable instanceof AsynLoadDrawable))) {
            ((AsynLoadDrawable)localDrawable).cancel();
          }
          localCustomImgView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 200, String.valueOf(localStrangerInfo.tinyId), true));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject2);
        }
        i1 += 1;
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
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
  
  private void b(int paramInt)
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
        QLog.e("NearbyProfileDisplayTribePanel", 2, localJSONException.toString());
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i1;
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
            if (this.w) {
              i1 = 2131696368;
            } else {
              i1 = 2131696366;
            }
            if (this.w) {
              localObject1 = "exp_followed";
            } else {
              localObject1 = "exp_follow";
            }
            ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", (String)localObject1, 0, 0, "", "", "", "");
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
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_msg", 0, 0, "", "", "", "");
    }
    if (i1 == 0)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
    ((View)localObject1).setVisibility(0);
    if (paramInt1 == 0) {
      ((View)localObject1).setVisibility(8);
    }
    Object localObject2;
    Object localObject3;
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
      localObject3 = new DataTag(paramInt2, null);
      ((Button)localObject2).setTag(localObject3);
      ((View)localObject1).setTag(localObject3);
      if ((paramInt2 == 60) && (this.w))
      {
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167091));
        ((Button)localObject2).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839319));
        return;
      }
      if ((paramInt2 == 8) && (this.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
      {
        ((Button)localObject2).setBackgroundResource(2130850380);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      if ((paramInt2 == 36) && (this.jdField_r_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
      {
        ((Button)localObject2).setBackgroundResource(2130850380);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    else
    {
      ((Button)((View)localObject1).findViewById(2131379994)).setVisibility(8);
      localObject2 = new DataTag(paramInt2, null);
      localObject3 = (ProgressButton)((View)localObject1).findViewById(2131373136);
      if (localObject3 != null)
      {
        ((ProgressButton)localObject3).setVisibility(0);
        ((ProgressButton)localObject3).setText(i1);
        if (paramInt2 == 38)
        {
          ((ProgressButton)localObject3).setBackgroundResource(2130850380);
          ((ProgressButton)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165586));
        }
        ((ProgressButton)localObject3).setOnClickListener(this);
        ((ProgressButton)localObject3).setTag(localObject2);
      }
      ((View)localObject1).setTag(localObject2);
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramArrayOfByte != null)
    {
      RichStatus localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = null;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165327));
      }
      Object localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.actionText)))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mStatusManager != null) {
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mStatusManager.a(localRichStatus.actionId, 200);
        } else {
          paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130849881);
        }
        paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
        int i1 = (int)(this.jdField_r_of_type_AndroidWidgetTextView.getTextSize() * 1.1F + 0.5F);
        paramArrayOfByte.setBounds(0, 0, i1, i1);
        paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
        paramArrayOfByte.setOffset(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, 3, 17);
        this.jdField_r_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
        return;
      }
      paramArrayOfByte = StringUtil.d(((SpannableString)localObject).toString());
      if (TextUtils.isEmpty(paramArrayOfByte))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_r_of_type_AndroidWidgetTextView.setText(paramArrayOfByte.trim());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyTribeAppController.a();
  }
  
  private void p()
  {
    ArrayList localArrayList1 = new ArrayList(4);
    Object localObject = new ArrayList(3);
    ArrayList localArrayList2 = new ArrayList(9);
    if (this.jdField_f_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      localArrayList2.add(this.jdField_f_of_type_AndroidWidgetRelativeLayout);
    }
    int i1 = 0;
    String str;
    StringBuilder localStringBuilder;
    int i2;
    while (i1 < 3)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[(i1 + 4)].jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        ((List)localObject).add(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1]);
        localArrayList2.add(this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1]);
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(0);
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
          str = "1";
        } else {
          str = "2";
        }
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int <= 4)
        {
          localStringBuilder = new StringBuilder();
          i2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int + 3;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          i2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int - 4;
        }
        localStringBuilder.append(i2);
        localStringBuilder.append("");
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", "exp_tag", 0, 0, str, "", localStringBuilder.toString(), "");
      }
      else
      {
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(8);
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < 4)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localArrayList1.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1]);
        localArrayList2.add(this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1]);
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
          str = "1";
        } else {
          str = "2";
        }
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int <= 4)
        {
          localStringBuilder = new StringBuilder();
          i2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int + 3;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          i2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int - 4;
        }
        localStringBuilder.append(i2);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "data_card", "exp_tag", 0, 0, str, "", localStringBuilder.toString(), "");
      }
      else
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(8);
      }
      i1 += 1;
    }
    if (localArrayList2.size() > 0) {
      ((View)localArrayList2.get(0)).setBackgroundDrawable(null);
    } else if (localArrayList2.size() == 0) {
      this.jdField_c_of_type_AndroidViewView.findViewById(2131369807).setVisibility(8);
    }
    if (localArrayList2.size() > 1) {
      ((View)localArrayList2.get(localArrayList2.size() - 1)).setBackgroundResource(2130850708);
    }
  }
  
  private void q()
  {
    this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    LinearLayout localLinearLayout = this.jdField_h_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
    }
  }
  
  private void r()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHasNewPhoto) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)))
    {
      u();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void s()
  {
    this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130845707);
    this.jdField_m_of_type_AndroidWidgetTextView.setOnClickListener(null);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_l_of_type_AndroidWidgetTextView.setText(2131695122);
      this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(new NearbyProfileDisplayTribePanel.15(this));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_l_of_type_AndroidWidgetTextView.setText(2131695122);
    this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(new NearbyProfileDisplayTribePanel.16(this));
  }
  
  private void t()
  {
    ProfileBusiEntry localProfileBusiEntry = this.jdField_a_of_type_ComTencentMobileqqProfilecardEntityProfileBusiEntry;
    if (localProfileBusiEntry != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(localProfileBusiEntry);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mCardHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 0, 1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label57:
      break label57;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.nearby_people_card.", 2, "NumberFormatException");
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167203));
    try
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845703));
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label43:
      Object localObject1;
      Object localObject2;
      boolean bool;
      double d1;
      int i1;
      int i2;
      int i3;
      break label43;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall getDrawable oom.");
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(null);
    localObject1 = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 200, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), 3);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
    localObject2 = this.jdField_a_of_type_ComTencentWidgetCustomImgView;
    bool = false;
    ((CustomImgView)localObject2).setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject1);
    d1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity * 70.0F;
    Double.isNaN(d1);
    i1 = (int)(d1 + 0.5D);
    d1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity * 2.0F;
    Double.isNaN(d1);
    i2 = (int)(d1 + 0.5D);
    localObject1 = new Paint();
    ((Paint)localObject1).setColor(-1);
    ((Paint)localObject1).setStyle(Paint.Style.STROKE);
    ((Paint)localObject1).setStrokeWidth(i2);
    ((Paint)localObject1).setAntiAlias(true);
    i3 = i2 * 2 + i1;
    try
    {
      localObject2 = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
      if (localObject2 == null) {
        break label309;
      }
      new Canvas((Bitmap)localObject2).drawCircle(i1 / 2 + i2, i1 / 2 + i2, i1 / 2, (Paint)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label293:
      break label293;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall create bitmap oom.");
    }
    label309:
    this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(null);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo.isEmpty())
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130845706);
        bool = true;
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130845705);
      }
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setTag(Boolean.valueOf(bool));
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.refreshStrangerFace();
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    AlbumUtil.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, false);
  }
  
  private void w()
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
        localLikeItem.d = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource;
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
  
  protected int a()
  {
    return 2131561217;
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
      QLog.d("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((RelativeLayout)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    Object localObject2 = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((CustomImgView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.imageWidth));
    ((RelativeLayout)localObject1).addView((View)localObject2, new LinearLayout.LayoutParams(-1, -1));
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
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131707364));
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
      if (!StringUtil.a(paramPicInfo.a))
      {
        paramPicInfo = NearbyImgDownloader.convertURL(paramPicInfo.a);
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
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(this.jdField_f_of_type_Int);
    if ((!this.v) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3))
    {
      SavorTagIcon[] arrayOfSavorTagIcon = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon;
      int i3 = 0;
      if (arrayOfSavorTagIcon != null)
      {
        i1 = 0;
        while (i1 < 4)
        {
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a())
          {
            i1 = 1;
            break label73;
          }
          i1 += 1;
        }
      }
      int i1 = 0;
      label73:
      int i2 = i1;
      if (i1 == 0)
      {
        i2 = i1;
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg != null) {
          for (;;)
          {
            i2 = i1;
            if (i3 >= 3) {
              break;
            }
            if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i3].a())
            {
              i2 = 1;
              break;
            }
            i3 += 1;
          }
        }
      }
      if (i2 != 0)
      {
        this.v = true;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005549", "0X8005549", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    if (this.jdField_f_of_type_Int == 0) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prepare2ScoreAnim() diff=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Charm", 2, ((StringBuilder)localObject).toString());
    }
    TextView localTextView = (TextView)this.jdField_g_of_type_AndroidWidgetRelativeLayout.findViewById(2131365744);
    if (localTextView.getTag() == null)
    {
      localObject = new Rect();
      localTextView.setTag(localObject);
    }
    else
    {
      localObject = (Rect)localTextView.getTag();
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView();
    localTextView.getGlobalVisibleRect((Rect)localObject);
    if (((Rect)localObject).bottom < localView.getHeight())
    {
      a(localTextView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.sendEmptyMessageDelayed(202, 2500L);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
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
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo);
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bigImageWidth - this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity * 150.0F;
    Animation localAnimation;
    if ((paramInt2 > paramInt4) && (paramInt2 >= f1) && (this.jdField_h_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8)) {
      localAnimation = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    } else if ((paramInt2 < paramInt4) && (paramInt2 <= f1) && (this.jdField_h_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      localAnimation = this.jdField_b_of_type_AndroidViewAnimationAnimation;
    } else {
      localAnimation = null;
    }
    if ((localAnimation != null) && (localAnimation != this.jdField_h_of_type_AndroidWidgetRelativeLayout.getAnimation()))
    {
      localAnimation.reset();
      this.jdField_h_of_type_AndroidWidgetRelativeLayout.startAnimation(localAnimation);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation(localAnimation);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    long l2;
    if (paramInt1 != 1000) {
      if (paramInt1 != 1018)
      {
        if (paramInt1 != 1028) {
          return;
        }
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
        l2 = 0L;
      }
    }
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    }
    catch (Exception localException)
    {
      long l1;
      label120:
      StringBuilder localStringBuilder;
      break label120;
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
  }
  
  protected void a(View paramView)
  {
    this.jdField_c_of_type_AndroidViewView = paramView;
    this.jdField_k_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369788));
    this.jdField_l_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369791));
    this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369813));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378619));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378556));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378519));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378521));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380068));
    this.jdField_i_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369812));
    this.jdField_j_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369889));
    paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    this.jdField_b_of_type_Int = paramView.getDimensionPixelSize(2131297470);
    this.jdField_c_of_type_Int = paramView.getDimensionPixelSize(2131297469);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131380964));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_j_of_type_AndroidWidgetRelativeLayout).b(21).d(30).a();
    this.jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[] { (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368671), (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368672), (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368673) };
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368717));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380076));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView = ((NearbyCardVoteView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380996));
    if (this.jdField_p_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131368151));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363784));
    this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378501));
    this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378542));
    this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378500));
    this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381299));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378562));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378558));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378557));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369820));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369775));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369808));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369771));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131365688));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378498));
    this.jdField_e_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131376750);
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369249));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369202));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369233));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369224));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368720));
    this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(436207616);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368739));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368740));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368729));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368730));
    if (this.jdField_p_of_type_Boolean)
    {
      paramView = this.jdField_c_of_type_AndroidViewView.findViewById(2131380357);
      localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 90.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_c_of_type_AndroidViewView.findViewById(2131378881));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131363731));
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131363781);
    paramView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131371955);
    Object localObject = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131380480);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131370026);
    NearbyProfileDisplayTribePanel.2 local2 = new NearbyProfileDisplayTribePanel.2(this, paramView, (ImageView)localObject, localImageView);
    paramView.setOnClickListener(local2);
    ((ImageView)localObject).setOnClickListener(local2);
    localImageView.setOnClickListener(local2);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null))
    {
      paramView.setImageResource(2130845726);
      ((ImageView)localObject).setImageResource(2130845728);
      localImageView.setImageResource(2130845724);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131368282));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369819));
    this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378561));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131363919));
    paramView = (RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131371881);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null)) {
      paramView.setBackgroundResource(2130845683);
    } else {
      paramView.setBackgroundResource(2130845682);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager = ((AvatarWallViewPager)this.jdField_c_of_type_AndroidViewView.findViewById(2131363168));
    paramView = new RelativeLayout.LayoutParams(-1, -2);
    paramView.addRule(12);
    paramView.bottomMargin = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 28.0F);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setDotLayoutParams(paramView);
    this.jdField_h_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131376753));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131379113));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370330));
    this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131376705);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368728));
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
    {
      this.jdField_j_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    paramView = (LinearLayout.LayoutParams)((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131376689)).getLayoutParams();
    if (paramView != null) {
      paramView.height = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bigImageWidth;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845060));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
    paramView.mScrollFlag = 1;
    paramView.setOnScrollChangedListener(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_k_of_type_AndroidWidgetTextView.setText(2131690529);
    this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(new NearbyProfileDisplayTribePanel.3(this));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setAppInterface(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    this.jdField_g_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369867));
    this.jdField_i_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370526));
    this.jdField_i_of_type_AndroidWidgetLinearLayout.setOnClickListener(new NearbyProfileDisplayTribePanel.4(this));
    this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379631));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyTribeAppController = new NearbyTribeAppController(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyTribeAppController.a(this.jdField_s_of_type_AndroidWidgetTextView);
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
      ThreadManager.post(new NearbyProfileDisplayTribePanel.28(this, paramInt), 5, null, false);
      return;
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a("NearbyProfileDisplayTribePanel", new Object[] { "onTagClick", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode), Integer.valueOf(paramInt), paramInterestTagInfo });
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if (paramNearbyPeopleCard == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
    if (localObject1 != null) {
      ((NearbyCardVoteView)localObject1).setNearbyPeopleCard(paramNearbyPeopleCard);
    }
    paramNearbyPeopleCard = SharedPreUtils.l(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (!TextUtils.isEmpty(paramNearbyPeopleCard)) {
      try
      {
        this.jdField_e_of_type_JavaLangString = new JSONObject(paramNearbyPeopleCard).getString("ownerLikeJumpURL");
      }
      catch (JSONException paramNearbyPeopleCard)
      {
        paramNearbyPeopleCard.printStackTrace();
      }
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
    boolean bool = this.t;
    int i3 = 0;
    if (!bool)
    {
      this.t = true;
      this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getStringArray(2130968666);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon = new SavorTagIcon[4];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg = new SavorTagImg[3];
      this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[3];
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[4];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag = new InterestTag[7];
      for (i1 = 0; i1 < 7; i1 = i2)
      {
        paramNearbyPeopleCard = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag;
        i2 = i1 + 1;
        paramNearbyPeopleCard[i1] = new InterestTag(i2);
      }
      i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167056);
      i1 = 0;
      while (i1 < 4)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1] = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[i1])).inflate());
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1] = ((SavorTagIcon)this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].findViewById(2131376897));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a(this.jdField_a_of_type_ArrayOfJavaLangString[i1], this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList, this);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setRightArrowVisible(false);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setTitleTextColor(i2);
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setClickable(true);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < 3)
      {
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1] = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(this.jdField_b_of_type_ArrayOfInt[i1])).inflate());
        i4 = i1 + 4;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1] = ((SavorTagImg)this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].findViewById(2131376897));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].a(this.jdField_a_of_type_ArrayOfJavaLangString[i4], this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i4].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i4].jdField_a_of_type_JavaUtilArrayList, this);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setRightArrowVisible(false);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setTitleTextColor(i2);
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setClickable(true);
        }
        i1 += 1;
      }
    }
    if (this.jdField_f_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(2131369858)).inflate());
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg = ((SavorTagImg)this.jdField_f_of_type_AndroidWidgetRelativeLayout.findViewById(2131376897));
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    paramNearbyPeopleCard = new StringBuilder();
    localObject1 = "";
    paramNearbyPeopleCard.append("");
    paramNearbyPeopleCard.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    Object localObject3 = paramNearbyPeopleCard.toString();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
      paramNearbyPeopleCard = "1";
    } else {
      paramNearbyPeopleCard = "2";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from % 20);
    ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", (String)localObject3, "data_card", "exp", 0, 0, paramNearbyPeopleCard, localStringBuilder.toString(), "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2)
    {
      this.jdField_j_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    else
    {
      this.jdField_j_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_j_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new NearbyProfileDisplayTribePanel.10(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new NearbyProfileDisplayTribePanel.11(this));
      ((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(1402, new NearbyProfileDisplayTribePanel.12(this));
      ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "my_point", 0, 0, "", "", "", "");
    }
    if (NearbyProfileCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from))
    {
      this.jdField_q_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsgForTribar;
      this.jdField_r_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTipsForTribar;
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;
    }
    else
    {
      this.jdField_q_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsg;
      this.jdField_r_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTips;
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips;
    }
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.highScoreNum;
    n();
    a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
    s();
    h();
    paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    int i2 = paramNearbyPeopleCard.getColor(2131167056);
    int i4 = paramNearbyPeopleCard.getColor(2131167144);
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser()) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isFuXiaoJin()))
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetRelativeLayout.findViewById(2131368742).setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131368742).setVisibility(8);
    }
    else
    {
      this.jdField_h_of_type_AndroidWidgetRelativeLayout.findViewById(2131368742).setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841373);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2)
    {
      paramNearbyPeopleCard = (TextView)this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131378556);
      localObject2 = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) {
        i1 = 2131707336;
      } else {
        i1 = 2131707317;
      }
      ((StringBuilder)localObject2).append(HardCodeUtil.a(i1));
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131707370));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject2).toString());
    }
    else
    {
      ((TextView)this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131378556)).setText(HardCodeUtil.a(2131707313));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1)
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1) {
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130846086);
      } else {
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130846085);
      }
      ThreadManager.post(new NearbyProfileDisplayTribePanel.13(this), 8, null, true);
    }
    else
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    localObject2 = new StringBuilder();
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
    {
      ((StringBuilder)localObject2).append("男 ");
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundColor(-12348939);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1)
    {
      ((StringBuilder)localObject2).append("女 ");
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundColor(-38511);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0)
    {
      paramNearbyPeopleCard = new StringBuilder();
      paramNearbyPeopleCard.append("");
      paramNearbyPeopleCard.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age);
      paramNearbyPeopleCard.append("岁 ");
      ((StringBuilder)localObject2).append(paramNearbyPeopleCard.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1))
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        paramNearbyPeopleCard = "1";
      } else {
        paramNearbyPeopleCard = "2";
      }
      ReportController.b((AppRuntime)localObject3, "dc00899", "grp_lbs", "", "data_card", "exp_info", 0, 0, paramNearbyPeopleCard, "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation != 0) && (ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation) != null))
    {
      paramNearbyPeopleCard = new StringBuilder();
      paramNearbyPeopleCard.append(ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation));
      paramNearbyPeopleCard.append(" ");
      ((StringBuilder)localObject2).append(paramNearbyPeopleCard.toString());
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        paramNearbyPeopleCard = "1";
      } else {
        paramNearbyPeopleCard = "2";
      }
      ReportController.b((AppRuntime)localObject3, "dc00899", "grp_lbs", "", "data_card", "exp_xing", 0, 0, paramNearbyPeopleCard, "", "", "");
    }
    if ((!StringUtil.a(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1))) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus != 1))
    {
      ((StringBuilder)localObject2).append(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
        paramNearbyPeopleCard = "1";
      } else {
        paramNearbyPeopleCard = "2";
      }
      ReportController.b((AppRuntime)localObject3, "dc00899", "grp_lbs", "", "data_card", "exp_relation", 0, 0, paramNearbyPeopleCard, "", "", "");
    }
    if (((StringBuilder)localObject2).toString().length() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig = FaceScoreUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig.a()) {
      ((NearbyFaceScoreManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(QQManagerFactory.FACE_SCORE_MANAGER)).a(new NearbyProfileDisplayTribePanel.14(this));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType == 31) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.aioDistance)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2))
    {
      paramNearbyPeopleCard = this.jdField_h_of_type_AndroidWidgetTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.aioDistance);
      ((StringBuilder)localObject2).append("·");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131707296));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject2).toString());
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotChatDistance", 2, "bindData, use aioDistance");
      }
    }
    else if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2))
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime.replace(" ", "·"));
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)))
    {
      paramNearbyPeopleCard = this.jdField_h_of_type_AndroidWidgetTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance);
      ((StringBuilder)localObject2).append("·");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131707393));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject2).toString());
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      paramNearbyPeopleCard = new StringBuilder();
      paramNearbyPeopleCard.append("bindData, mCard.videoInfo = ");
      paramNearbyPeopleCard.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo);
      QLog.d("NearbyProfileDisplayTribePanel", 2, paramNearbyPeopleCard.toString());
    }
    if ((((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).isAuthVideoEnable()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.a, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.equals("")))
      {
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.trim();
      }
      else
      {
        paramNearbyPeopleCard = (NearbyPeopleCard)localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname != null) {
          paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
        }
      }
    }
    else
    {
      paramNearbyPeopleCard = (NearbyPeopleCard)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname != null) {
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
      }
    }
    if (!TextUtils.isEmpty(paramNearbyPeopleCard)) {
      this.jdField_i_of_type_AndroidWidgetTextView.setText(paramNearbyPeopleCard.trim());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
    {
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ((TextView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131380096)).setText(paramNearbyPeopleCard);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_m_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707353));
    }
    b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charm == 0L) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3))
    {
      this.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    else
    {
      this.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strLevelType);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
      {
        paramNearbyPeopleCard = this.jdField_j_of_type_AndroidWidgetTextView;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.mHeartNum);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707358));
        paramNearbyPeopleCard.setText(((StringBuilder)localObject1).toString());
        this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167056));
      }
      this.jdField_g_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode != 2) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
    }
    paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    paramNearbyPeopleCard.company = StringUtil.d(paramNearbyPeopleCard.company);
    if (StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
      {
        this.jdField_o_of_type_AndroidWidgetTextView.setTextColor(i4);
        this.jdField_o_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707375));
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850717);
        }
      }
    }
    else
    {
      this.jdField_o_of_type_AndroidWidgetTextView.setTextColor(i2);
      this.jdField_o_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company, 1, 16));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_company", 0, 0, "", "", "", "");
    }
    this.jdField_p_of_type_AndroidWidgetTextView.setTextColor(i4);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job < NearbyProfileUtil.d.length))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_work", 0, 0, "", "", "", "");
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_p_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.d[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
      this.jdField_p_of_type_AndroidWidgetTextView.setTextColor(i2);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
    {
      this.jdField_p_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707402));
    }
    else
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)) {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850717);
      }
    }
    paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    paramNearbyPeopleCard.college = StringUtil.d(paramNearbyPeopleCard.college);
    if (StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
      {
        this.jdField_q_of_type_AndroidWidgetTextView.setTextColor(i4);
        this.jdField_q_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707288));
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      else
      {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    else
    {
      this.jdField_q_of_type_AndroidWidgetTextView.setTextColor(i2);
      this.jdField_q_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, 1, 16));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_school", 0, 0, "", "", "", "");
    }
    t();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
    {
      if (this.jdField_p_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_face_score").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.uin).a();
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        i();
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      m();
    }
    r();
    j();
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
    int i1 = 0;
    for (;;)
    {
      i2 = i3;
      if (i1 >= 4) {
        break;
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        paramNearbyPeopleCard = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon;
        paramNearbyPeopleCard[i1].setContentDescription(paramNearbyPeopleCard[i1].a());
      }
      i1 += 1;
    }
    while (i2 < 3)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i2].a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[(i2 + 4)].jdField_a_of_type_JavaUtilArrayList);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        paramNearbyPeopleCard = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg;
        paramNearbyPeopleCard[i2].setContentDescription(paramNearbyPeopleCard[i2].a());
      }
      i2 += 1;
    }
    p();
    new StringBuilder();
    q();
  }
  
  public void a(PicInfo paramPicInfo, RelativeLayout paramRelativeLayout)
  {
    CustomImgView localCustomImgView = (CustomImgView)paramRelativeLayout.getChildAt(0);
    paramRelativeLayout = (ImageView)paramRelativeLayout.getChildAt(1);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130851081);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bigImageWidth;
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.bigImageWidth;
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mUseMemoryCache = false;
    if (ShortVideoUtils.isVideoSoLibLoaded())
    {
      localObject = new VideoDrawable.VideoDrawableParams();
      ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDynamicAvatarFPS;
      localURLDrawableOptions.mExtraInfo = localObject;
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(DynamicAvatarDownloadManager.a(paramPicInfo.jdField_d_of_type_JavaLangString), localURLDrawableOptions));
    }
    else if (!TextUtils.isEmpty(paramPicInfo.a))
    {
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo.a, localURLDrawableOptions));
    }
    if (paramRelativeLayout.getVisibility() == 0) {
      paramRelativeLayout.setVisibility(8);
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.a = paramString1;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString1.mRequestWidth = AIOUtils.b(43.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      paramString1.mRequestHeight = AIOUtils.b(43.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      paramString1.mFailedDrawable = ImageUtil.e();
      paramString1.mLoadingDrawable = ImageUtil.e();
      paramString1.mMemoryCacheKeySuffix = "NearbyVideoRoundIcon";
      paramString1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.a, paramString1);
      paramString1.setDecodeHandler(URLDrawableDecodeHandler.a);
      if (paramString1.getStatus() != 1) {
        paramString1.restartDownload();
      }
    }
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
      QLog.d("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject).toString());
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
            QLog.e("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish went error .., holder is null or holder.data is null");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish went error .., view is not a instance of RelativeLayout");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideCharmChanged() showAnim=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Charm", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (TextView)this.jdField_g_of_type_AndroidWidgetRelativeLayout.findViewById(2131365744);
    if (paramBoolean)
    {
      int i1 = ((TextView)localObject).getWidth();
      int i2 = ((TextView)localObject).getHeight();
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, i1 / 2, i2 / 2);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 17432584);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setDuration(1500L);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setFillBefore(false);
      ((TextView)localObject).setAnimation(localAnimationSet);
      localAnimationSet.start();
      return;
    }
    ((TextView)localObject).setVisibility(4);
  }
  
  public void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList)
  {
    ProfileBusiEntry localProfileBusiEntry;
    if ((paramBoolean) && (paramList != null) && (paramList.size() != 0) && (paramInt == 0))
    {
      paramList = (ShowExternalTroop)paramList.get(0);
      this.jdField_f_of_type_JavaLangString = paramList.troopUin;
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
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_f_of_type_JavaLangString, "1", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_f_of_type_JavaLangString, "0", "", "");
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
    if (paramArrayOfByte == null)
    {
      this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_k_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject2 = new nearby.Cmd0x1RspBody();
    try
    {
      ((nearby.Cmd0x1RspBody)localObject2).mergeFrom(paramArrayOfByte);
      localObject1 = ((nearby.Cmd0x1RspBody)localObject2).bytes_bars_url.get().toStringUtf8();
      this.jdField_d_of_type_JavaLangString = ((nearby.Cmd0x1RspBody)localObject2).bytes_qunlist_url.get().toStringUtf8();
      this.jdField_a_of_type_ArrayOfByte = ((nearby.Cmd0x1RspBody)localObject2).bytes_chat_sig.get().toByteArray();
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getMsgCache().h(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ArrayOfByte);
      this.w = ((nearby.Cmd0x1RspBody)localObject2).bool_follow.get();
      int i1 = ((nearby.Cmd0x1RspBody)localObject2).uint32_if_mask_msg.get();
      boolean bool2 = true;
      int i2 = 0;
      boolean bool1;
      if (i1 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_q_of_type_Boolean = bool1;
      if (((nearby.Cmd0x1RspBody)localObject2).uint32_if_mask_gift.get() == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.jdField_r_of_type_Boolean = bool1;
      paramArrayOfByte = ((nearby.Cmd0x1RspBody)localObject2).bytes_feed_wording_title.get().toStringUtf8();
      Object localObject3 = ((nearby.Cmd0x1RspBody)localObject2).bytes_feed_wording.get().toStringUtf8();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramArrayOfByte);
      paramArrayOfByte = MsgBoxUtil.b((String)localObject3);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(MsgBoxUtil.a(paramArrayOfByte, 16));
      if (((nearby.Cmd0x1RspBody)localObject2).bytes_mask_msg_reason.has()) {
        this.jdField_b_of_type_JavaLangString = ((nearby.Cmd0x1RspBody)localObject2).bytes_mask_msg_reason.get().toStringUtf8();
      }
      if (((nearby.Cmd0x1RspBody)localObject2).bytes_mask_gift_reason.has()) {
        this.jdField_c_of_type_JavaLangString = ((nearby.Cmd0x1RspBody)localObject2).bytes_mask_gift_reason.get().toStringUtf8();
      }
      localObject3 = new ArrayList();
      if ((((nearby.Cmd0x1RspBody)localObject2).rpt_BarInfo_bars.has()) && (((nearby.Cmd0x1RspBody)localObject2).rpt_BarInfo_bars.get().size() > 0))
      {
        this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramArrayOfByte = ((nearby.Cmd0x1RspBody)localObject2).rpt_BarInfo_bars.get().iterator();
      }
      Object localObject4;
      while (paramArrayOfByte.hasNext())
      {
        localObject4 = (nearby.BarInfo)paramArrayOfByte.next();
        if (((ArrayList)localObject3).size() < 12)
        {
          InterestTagInfo localInterestTagInfo = new InterestTagInfo();
          localInterestTagInfo.tagName = ((nearby.BarInfo)localObject4).bytes_bar_name.get().toStringUtf8();
          localInterestTagInfo.tagIconUrl = ((nearby.BarInfo)localObject4).bytes_bar_pic.get().toStringUtf8();
          localInterestTagInfo.tagJumpUrl = ((nearby.BarInfo)localObject4).bytes_bar_url.get().toStringUtf8();
          localInterestTagInfo.tagType = 10;
          ((ArrayList)localObject3).add(localInterestTagInfo);
          continue;
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
      }
      i1 = ((nearby.Cmd0x1RspBody)localObject2).uint32_bars_num.get();
      if (i1 > 12)
      {
        if (((ArrayList)localObject3).size() > 11)
        {
          ((ArrayList)localObject3).remove(11);
        }
        else if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("buluo num > 12 but the list's size < 12??? buluoNum:");
          paramArrayOfByte.append(i1);
          paramArrayOfByte.append("   list.Size:");
          paramArrayOfByte.append(((ArrayList)localObject3).size());
          QLog.w("NearbyProfileDisplayTribePanel", 2, paramArrayOfByte.toString());
        }
        paramArrayOfByte = new InterestTagInfo();
        paramArrayOfByte.tagName = " ";
        paramArrayOfByte.tagIconUrl = "icon_more_url";
        paramArrayOfByte.tagJumpUrl = "icon_more_url";
        paramArrayOfByte.tagType = 10;
        ((ArrayList)localObject3).add(paramArrayOfByte);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
          paramArrayOfByte = "1";
        } else {
          paramArrayOfByte = "2";
        }
        ReportController.b((AppRuntime)localObject4, "dc00899", "grp_lbs", "", "data_card", "exp_more_tribe", 0, 0, paramArrayOfByte, "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a((List)localObject3);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a(HardCodeUtil.a(2131707334), 10, (List)localObject3, new NearbyProfileDisplayTribePanel.6(this, (String)localObject1));
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.setRightArrowVisible(false);
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.jdField_a_of_type_AndroidWidgetTextView;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707376));
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(")");
      paramArrayOfByte.setText(((StringBuilder)localObject1).toString());
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
      {
        localObject1 = (nearby.FansInfo)((nearby.Cmd0x1RspBody)localObject2).FansInfo_fans.get();
        i1 = ((nearby.FansInfo)localObject1).uint32_fans_num.get();
        int i3 = ((nearby.FansInfo)localObject1).uint32_follows_num.get();
        paramArrayOfByte = ((nearby.FansInfo)localObject1).bytes_fans_url.get().toStringUtf8();
        localObject1 = ((nearby.FansInfo)localObject1).bytes_follows_url.get().toStringUtf8();
        localObject3 = this.jdField_f_of_type_AndroidWidgetTextView;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(HardCodeUtil.a(2131707378));
        ((StringBuilder)localObject4).append(i1);
        ((StringBuilder)localObject4).append(HardCodeUtil.a(2131707400));
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
        localObject3 = this.jdField_g_of_type_AndroidWidgetTextView;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(HardCodeUtil.a(2131707379));
        ((StringBuilder)localObject4).append(i3);
        ((StringBuilder)localObject4).append(HardCodeUtil.a(2131707300));
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
        this.jdField_k_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new NearbyProfileDisplayTribePanel.7(this, paramArrayOfByte));
        this.jdField_l_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new NearbyProfileDisplayTribePanel.8(this, (String)localObject1));
      }
      else
      {
        this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_k_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if ((((nearby.Cmd0x1RspBody)localObject2).rpt_FeedInfo_feeds.has()) && (((nearby.Cmd0x1RspBody)localObject2).rpt_FeedInfo_feeds.get().size() > 0))
      {
        localObject3 = ((nearby.Cmd0x1RspBody)localObject2).rpt_FeedInfo_feeds.get();
        i2 = ((List)localObject3).size();
        if (((List)localObject3).size() > 0)
        {
          i1 = 0;
          while ((i1 < i2) && (i1 < 3))
          {
            paramArrayOfByte = URLDrawable.URLDrawableOptions.obtain();
            paramArrayOfByte.mLoadingDrawable = paramArrayOfByte.mFailedDrawable;
            paramArrayOfByte.mRequestWidth = ((int)(SavorTagImg.jdField_a_of_type_ArrayOfInt[0] * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity));
            paramArrayOfByte.mRequestHeight = ((int)(SavorTagImg.jdField_a_of_type_ArrayOfInt[0] * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mDensity));
            if (!TextUtils.isEmpty(((nearby.FeedInfo)((List)localObject3).get(i1)).bytes_pic.get().toStringUtf8())) {
              try
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("");
                ((StringBuilder)localObject1).append(((nearby.FeedInfo)((List)localObject3).get(i1)).bytes_pic.get().toStringUtf8());
                paramArrayOfByte = URLDrawable.getDrawable(((StringBuilder)localObject1).toString(), paramArrayOfByte);
              }
              catch (Exception paramArrayOfByte)
              {
                QLog.w("NearbyProfileDisplayTribePanel", 2, paramArrayOfByte.toString());
              }
            } else {
              paramArrayOfByte = null;
            }
            localObject4 = this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1];
            localObject1 = paramArrayOfByte;
            if (paramArrayOfByte == null) {
              localObject1 = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165886));
            }
            ((URLImageView)localObject4).setImageDrawable((Drawable)localObject1);
            this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setBackgroundColor(0);
            i1 += 1;
          }
        }
        i1 = 2;
        while ((i1 >= i2) && (i1 >= 0))
        {
          this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setVisibility(8);
          i1 -= 1;
        }
        this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        i1 = i2;
      }
      else
      {
        i1 = 0;
        while (i1 < 3)
        {
          this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setVisibility(8);
          i1 += 1;
        }
        this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i1 = i2;
      }
      paramArrayOfByte = new NearbyProfileDisplayTribePanel.9(this, ((nearby.Cmd0x1RspBody)localObject2).bytes_feeds_url.get().toStringUtf8());
      this.jdField_i_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramArrayOfByte);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramArrayOfByte);
      if (this.jdField_f_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
          paramArrayOfByte = "1";
        } else {
          paramArrayOfByte = "2";
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(i1);
        ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_pub", 0, 0, paramArrayOfByte, "", ((StringBuilder)localObject2).toString(), "");
      }
      if (this.jdField_f_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2) {
          paramArrayOfByte = "1";
        } else {
          paramArrayOfByte = "2";
        }
        ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_tribe", 0, 0, paramArrayOfByte, "", "", "");
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Cmd0x1RspBody error !:");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        QLog.w("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_k_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "content_timer", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(0);
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
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(4);
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
  }
  
  public void d() {}
  
  protected void d(boolean paramBoolean)
  {
    if ((this.jdField_r_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
    {
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_c_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
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
  
  public void e() {}
  
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
      w();
    }
  }
  
  public void g()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (FaceDrawable)((WeakReference)localObject).get();
      if (localObject != null) {
        ((FaceDrawable)localObject).cancel();
      }
    }
    if (NearbyManagerHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a() != null) {
      NearbyManagerHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a().clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyTribeAppController.b();
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).shouldShowLikeBtn()) && (!this.jdField_p_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(0);
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
      ((NearbyCardVoteView)localObject).a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, null, false, false, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.praiseList);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(4);
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
      if (!this.jdField_o_of_type_Boolean) {
        b(2, 8);
      } else {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa != 41) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa != 42) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType != 14) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa != 86) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa != 87) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa != 88) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa != 79) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa != 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa != 89))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
        } else {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg())) {
        b(0, 36);
      } else {
        b(2, 40);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa == 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatCookie == null) && (!b())) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        } else if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.jdField_o_of_type_Boolean)) {
          b(2, 8);
        } else {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.pa == 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatCookie == null) && (!b())) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
      } else if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.jdField_o_of_type_Boolean)) {
        b(0, 8);
      } else {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
      }
      b(1, 60);
    }
    Button localButton;
    if ((!this.w) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() != 0))
    {
      localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131379994);
      localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167089));
      localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839280));
    }
    else
    {
      ((Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131379994)).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839319));
    }
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).getVisibility() != 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() != 0))
    {
      localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).findViewById(2131379994);
      localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131167089));
      localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130839280));
    }
  }
  
  public void j()
  {
    Object localObject;
    if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHasNewPhoto) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter = new NearbyProfileDisplayTribePanel.AvatarWallAdapter(this, this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHasNewPhoto)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mPicInfo);
      }
      else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl))
      {
        localObject = new PicInfo();
        ((PicInfo)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter.a(localArrayList);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_head", 0, 0, (String)localObject, "", "", "");
  }
  
  public void k()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHeadSize == 640) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHeadSize == 0)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mGetHeadUrl)) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHasNewPhoto)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.downloadHDAvatar(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHeadSize, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mGetHeadUrl, false);
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
    if ((localObject != null) && (!StringUtil.a(((NearbyPeopleCard)localObject).uin))) {
      a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, i1);
    }
  }
  
  void m()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void n()
  {
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentUin())));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_stranger_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_gender.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_god_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localReqBody.uint32_req_likeinfo.set(1);
    localReqBody.uint32_req_pansocialinfo.set(1);
    localReqBody.uint32_req_giftinfo.set(1);
    localReqBody.uint32_req_configinfo.set(1);
    localReqBody.uint32_req_visitor.set(3);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1643);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.f());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new NearbyProfileDisplayTribePanel.32(this), ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), "OidbSvc.0x66b");
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.getTag();
    Object localObject1 = "";
    int i4 = 0;
    boolean bool = false;
    int i3 = 2;
    int i1;
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
        QLog.i("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject2).toString());
      }
      i1 = paramView.jdField_a_of_type_Int;
      i2 = 8;
      if (i1 != 8) {
        if (i1 != 30) {
          if (i1 != 33) {
            if (i1 != 42) {
              if (i1 != 58) {
                if (i1 != 60) {
                  if ((i1 != 27) && (i1 != 28)) {
                    if (i1 != 36) {
                      if (i1 != 37) {
                        if (i1 != 39) {
                          if (i1 != 40) {
                            switch (i1)
                            {
                            default: 
                              return;
                            case 22: 
                              if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
                              {
                                paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
                                if (!StringUtil.a(paramView.strJumpUrl)) {
                                  a(paramView.strJumpUrl);
                                }
                              }
                              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CB", "0X80050CB ", ProfileEntryUtils.getProfileEntryType(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone)), "", "", "");
                              return;
                            case 21: 
                              if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
                              {
                                localObject2 = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
                                if (!StringUtil.a(((ProfileBusiEntry)localObject2).strJumpUrl))
                                {
                                  paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
                                  paramView.putExtra("portraitOnly", true);
                                  if (!StringUtil.a(((ProfileBusiEntry)localObject2).strJumpUrl)) {
                                    localObject1 = ((ProfileBusiEntry)localObject2).strJumpUrl;
                                  }
                                  paramView.putExtra("url", (String)localObject1);
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
      label423:
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
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "click_bootstrap", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
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
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_pause", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
            return;
          }
          if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
          {
            if (this.jdField_m_of_type_Boolean)
            {
              paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
              DialogUtil.a(paramView, 230, paramView.getString(2131698754), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131698753), 0, 2131699178, new NearbyProfileDisplayTribePanel.19(this), null).show();
              this.jdField_m_of_type_Boolean = false;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
            }
            else
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
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
              i1 = i2;
              if (((NearbyPeopleProfileActivity)localObject1).allinone.profileEntryType != 17)
              {
                i1 = i2;
                if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType != 18) {
                  if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType == 19) {
                    i1 = i2;
                  } else {
                    i1 = 4;
                  }
                }
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
              paramView.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), i2, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.chatCookie);
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
                      if (this.w) {
                        paramView = "clk_followed";
                      } else {
                        paramView = "clk_follow";
                      }
                      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", paramView, 0, 0, "", "", "", "");
                      ((INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, Integer.valueOf(1));
                      bool = NearbyProfileCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.from);
                      if (bool) {
                        paramView = "1";
                      } else if (this.jdField_o_of_type_Boolean) {
                        paramView = "6";
                      } else {
                        paramView = "2";
                      }
                      if (!bool) {
                        bool = this.jdField_o_of_type_Boolean;
                      }
                      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
                      localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
                      if (this.w) {
                        localObject1 = "2";
                      } else {
                        localObject1 = "1";
                      }
                      NearbyHandler.a((QQAppInterface)localObject2, (String)localObject3, paramView, (String)localObject1, 1, new NearbyProfileDisplayTribePanel.18(this));
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
                                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_f_of_type_JavaLangString, "1", "", "");
                                return;
                              }
                              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
                              {
                                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_f_of_type_JavaLangString, "0", "", "");
                                return;
                                if ((this.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend))
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
                                  if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isSendMsgBtnDownloadAppOpen) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl))) {
                                    NearbyCardManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl, 1);
                                  } else if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
                                    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_b_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
                                  }
                                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "msg_fail", 0, 0, "", "", "", "");
                                  return;
                                }
                                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "msg_suc", 0, 0, "", "", "", "");
                                this.jdField_d_of_type_Boolean = true;
                                l();
                                ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_msg", 0, 0, "", "", "", "");
                                localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
                                i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType;
                                localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
                                paramView = (View)localObject1;
                                if (localObject3 != null)
                                {
                                  paramView = (View)localObject1;
                                  if (((NearbyPeopleCard)localObject3).uin != null) {
                                    paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
                                  }
                                }
                                ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8004826", "0X8004826", i1, 0, paramView, "", "", "");
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
          if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
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
            ((StringBuilder)localObject2).append(this.jdField_e_of_type_JavaLangString);
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
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.execute(new NearbyProfileDisplayTribePanel.20(this));
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
              QLog.i("NearbyProfileDisplayTribePanel", 2, "mCard is null,vote failed !");
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
            QLog.i("NearbyProfileDisplayTribePanel", 2, paramView.toString());
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
            paramView.append("Profile->onClickVote, uin=");
            paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
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
                localObject4 = new NearbyProfileDisplayTribePanel.21(this);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(i3);
                localStringBuilder.append("");
                paramView.a((Activity)localObject1, localObject2, (String)localObject3, localObject4, localStringBuilder.toString());
              }
              else
              {
                c(true);
                this.u = true;
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
            if (this.u) {
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
              i3 = 2131707390;
            } else {
              i3 = 2131707308;
            }
            paramView = HardCodeUtil.a(i3);
            if (!this.jdField_s_of_type_Boolean)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFriend)
              {
                paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, HardCodeUtil.a(2131707406), "", HardCodeUtil.a(2131707350), new NearbyProfileDisplayTribePanel.22(this), null);
              }
              else
              {
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(HardCodeUtil.a(2131707293));
                ((StringBuilder)localObject4).append(paramView);
                ((StringBuilder)localObject4).append(HardCodeUtil.a(2131707380));
                paramView = DialogUtil.a((Context)localObject3, 230, null, ((StringBuilder)localObject4).toString(), HardCodeUtil.a(2131707342), HardCodeUtil.a(2131707366), new NearbyProfileDisplayTribePanel.23(this), new NearbyProfileDisplayTribePanel.24(this));
              }
              paramView.show();
              this.jdField_s_of_type_Boolean = true;
              paramView.setOnDismissListener(new NearbyProfileDisplayTribePanel.25(this));
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
      else if (paramView == this.jdField_a_of_type_ComTencentWidgetCustomImgView)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          paramView = (Boolean)paramView.getTag();
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.switchToEditPanel(100L);
          if ((paramView != null) && (!paramView.booleanValue())) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mHandler.postDelayed(new NearbyProfileDisplayTribePanel.26(this), 300L);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050C9", "0X80050C9", 0, 0, "", "", "", "");
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
        {
          localObject1 = new PicInfo();
          ((PicInfo)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCustomFaceFilePath(32, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), 200);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("on mode guest small head clicked: uin is: ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
            ((StringBuilder)localObject2).append(" local path is: ");
            ((StringBuilder)localObject2).append(((PicInfo)localObject1).jdField_c_of_type_JavaLangString);
            QLog.e("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
          }
          paramView = AnimationUtils.a(paramView);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.showBigPhoto((PicInfo)localObject1, paramView);
        }
        if (ProfileEntryUtils.isFromHotChat(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.profileEntryType)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005240", "0X8005240", 0, 0, "", "", "", "");
        }
      }
      else if (paramView == this.jdField_g_of_type_AndroidWidgetRelativeLayout)
      {
        this.jdField_i_of_type_Boolean = true;
        localObject1 = "https://buluo.qq.com/mobile/my_heart.html?from=zlk";
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3)
        {
          paramView = NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.allinone.uin);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("https://buluo.qq.com/mobile/my_heart.html?from=zlk");
          ((StringBuilder)localObject1).append("&strangerUin=");
          ((StringBuilder)localObject1).append(paramView);
          paramView = ((StringBuilder)localObject1).toString();
          this.jdField_a_of_type_Boolean = true;
        }
        else
        {
          paramView = (View)localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
          {
            this.jdField_a_of_type_Boolean = true;
            paramView = (View)localObject1;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_rank", 0, 0, (String)localObject1, "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_rank", 0, 0, (String)localObject1, "", "", "");
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 2)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052AC", "0X80052AC", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.mMode == 3) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052AD", "0X80052AD", 0, 0, "", "", "", "");
        }
      }
      else if (paramView == this.jdField_f_of_type_AndroidWidgetImageView)
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
        if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
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
        if (paramView != this.jdField_g_of_type_AndroidWidgetLinearLayout) {
          paramView = this.jdField_h_of_type_AndroidWidgetLinearLayout;
        }
      }
      return;
    }
    catch (SecurityException paramView)
    {
      break label423;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel
 * JD-Core Version:    0.7.0.1
 */