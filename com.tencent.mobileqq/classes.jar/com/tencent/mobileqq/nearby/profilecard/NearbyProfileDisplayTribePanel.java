package com.tencent.mobileqq.nearby.profilecard;

import afjo;
import afjp;
import afjq;
import afjr;
import afjs;
import afju;
import afjv;
import afjw;
import afjz;
import afkb;
import afkc;
import afke;
import afkf;
import afkg;
import afkh;
import afki;
import afkj;
import afkk;
import afkl;
import afkm;
import afkn;
import afko;
import afkp;
import afkq;
import afkr;
import afks;
import afkt;
import afku;
import afkv;
import afkw;
import afkx;
import afky;
import afkz;
import afla;
import aflb;
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
import android.text.style.ForegroundColorSpan;
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
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.FaceScoreUtils;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.NearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.ViewHolder;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
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
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x814.oidb_0x814.Activity;
import tencent.im.oidb.cmd0x814.oidb_0x814.RspBody;
import tencent.im.oidb.cmd0x8b4.GroupInfo;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyProfileDisplayTribePanel
  extends NearbyProfileDisplayBasePanel
  implements View.OnClickListener, OnTagClickListener, BounceScrollView.OnScrollChangedListener
{
  public static String[] b;
  public static String[] c;
  public int a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new afkt(this);
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new afjo(this);
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afkq(this);
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new afky(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected URLImageView a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NewVoteAnimHelper jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  public FaceScoreConfig a;
  private NearbyCardVoteView jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
  public NearbyPeopleProfileActivity a;
  private NearbyProfileDisplayTribePanel.AvatarWallAdapter jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter;
  public ProfileQiqiLiveController a;
  SavorTagImg jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
  protected ProfileBusiEntry a;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  public ProgressButton a;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new afku(this);
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  protected String a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public List a;
  protected final Map a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private byte[] jdField_a_of_type_ArrayOfByte;
  int[] jdField_a_of_type_ArrayOfInt = { 2131370788, 2131370789, 2131370790, 2131370791 };
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
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  SavorTagImg jdField_b_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg;
  public String b;
  AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean b;
  int[] jdField_b_of_type_ArrayOfInt = { 2131370785, 2131370786, 2131370787 };
  RelativeLayout[] jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout;
  int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  SavorTagImg jdField_c_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg;
  String jdField_c_of_type_JavaLangString = "";
  AtomicInteger jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean c;
  public int d;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  public boolean d;
  int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  public String e;
  public boolean e;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString = "";
  public boolean f;
  private View jdField_g_of_type_AndroidViewView;
  private LinearLayout jdField_g_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_g_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  protected String g;
  public boolean g;
  private LinearLayout jdField_h_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_h_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  private String jdField_h_of_type_JavaLangString;
  public boolean h;
  private LinearLayout jdField_i_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_i_of_type_AndroidWidgetRelativeLayout;
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
  private RelativeLayout jdField_m_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  boolean jdField_m_of_type_Boolean = true;
  private RelativeLayout jdField_n_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  public boolean n;
  private RelativeLayout jdField_o_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_o_of_type_AndroidWidgetTextView;
  boolean jdField_o_of_type_Boolean = false;
  private TextView p;
  public boolean p;
  private TextView jdField_q_of_type_AndroidWidgetTextView;
  boolean jdField_q_of_type_Boolean = false;
  private TextView jdField_r_of_type_AndroidWidgetTextView;
  boolean jdField_r_of_type_Boolean = false;
  private TextView s;
  public boolean s;
  private TextView jdField_t_of_type_AndroidWidgetTextView;
  boolean jdField_t_of_type_Boolean = false;
  private TextView u;
  public boolean u;
  private TextView jdField_v_of_type_AndroidWidgetTextView;
  private boolean jdField_v_of_type_Boolean;
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
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_n_of_type_Boolean = true;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_u_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new afks(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (paramNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) == 35) {}
    for (;;)
    {
      this.jdField_p_of_type_Boolean = bool;
      this.jdField_o_of_type_Boolean = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_werewolves", false);
      return;
      bool = false;
    }
  }
  
  private void a(TextView paramTextView)
  {
    int i1 = paramTextView.getWidth();
    int i2 = paramTextView.getHeight();
    Object localObject2 = new StringBuilder();
    if (this.jdField_f_of_type_Int > 0) {}
    for (Object localObject1 = "+ ";; localObject1 = "- ")
    {
      paramTextView.setText((String)localObject1 + String.valueOf(Math.abs(this.jdField_f_of_type_Int)));
      if (paramTextView.getVisibility() != 0) {
        paramTextView.setVisibility(0);
      }
      localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, i1 / 2, i2 / 2);
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 17432584);
      localAnimationSet.addAnimation((Animation)localObject1);
      localAnimationSet.addAnimation((Animation)localObject2);
      localAnimationSet.setDuration(1500L);
      paramTextView.setAnimation(localAnimationSet);
      localAnimationSet.start();
      this.jdField_f_of_type_Int = 0;
      return;
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = String.format("http://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin });
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
  
  private void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Int == 5) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a();
      localObject = str;
      if (str == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131437731);
      }
      AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, paramString, (String)localObject, 1010);
    }
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ChatActivity.class);
    ((Intent)localObject).putExtra("PREVIOUS_WINDOW", NearbyPeopleProfileActivity.class.getName());
    ((Intent)localObject).putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
    ((Intent)localObject).putExtra("cSpecialFlag", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("cSpecialFlag"));
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("uintype", paramInt);
    ((Intent)localObject).putExtra("aio_msg_source", 3);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.j != 0) {
      ((Intent)localObject).putExtra("entrance", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.j);
    }
    if (paramInt == 1001)
    {
      ((Intent)localObject).putExtra("rich_accost_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
      ((Intent)localObject).putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString);
      ((Intent)localObject).addFlags(67108864);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
      return;
      if (paramInt == 1010)
      {
        ((Intent)localObject).putExtra("rich_date_sig", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        ((Intent)localObject).putExtra("gender", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender);
      }
    }
  }
  
  private void a(List paramList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateVistorHeader visitor count:");
      if (paramList != null) {
        break label106;
      }
    }
    label106:
    for (int i1 = 0;; i1 = paramList.size())
    {
      QLog.d("Q.nearby.visitor", 2, i1);
      localObject1 = NearbyMineHelper.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new Object[] { Integer.valueOf(4105), "100510.100523" });
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
      if ((paramList != null) && (paramList.size() != 0)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    if (paramList.size() > 3) {}
    int i2;
    for (i1 = 3;; i1 = paramList.size())
    {
      localObject1 = new ArrayList(3);
      i2 = 0;
      while (i2 < i1)
      {
        localObject2 = (StrangerInfo)paramList.get(i2);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        i2 += 1;
      }
    }
    int i3 = ((List)localObject1).size();
    paramList = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (((RelativeLayout.LayoutParams)localObject2).width != this.jdField_b_of_type_Int * i3 + (i3 - 1) * this.jdField_c_of_type_Int) {
      ((RelativeLayout.LayoutParams)localObject2).width = (this.jdField_b_of_type_Int * i3 + (i3 - 1) * this.jdField_c_of_type_Int);
    }
    for (i1 = 1;; i1 = 0)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != AIOUtils.a(35.0F, paramList)))
      {
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(35.0F, paramList);
        i2 = 1;
      }
      for (;;)
      {
        if (i2 != 0) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i1 = 0;
        while (i1 < i3)
        {
          localObject2 = new LinearLayout.LayoutParams(AIOUtils.a(30.0F, paramList), AIOUtils.a(30.0F, paramList));
          ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(5.0F, paramList);
          StrangerInfo localStrangerInfo = (StrangerInfo)((List)localObject1).get(i1);
          if (localStrangerInfo != null)
          {
            CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
            Drawable localDrawable = localCustomImgView.a();
            if ((localDrawable != null) && ((localDrawable instanceof AsynLoadDrawable))) {
              ((AsynLoadDrawable)localDrawable).a();
            }
            localCustomImgView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 202, String.valueOf(localStrangerInfo.tinyId), true));
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject2);
          }
          i1 += 1;
        }
        i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a())
        {
          i2 = i1;
          if (((RelativeLayout.LayoutParams)localObject2).rightMargin != AIOUtils.a(45.0F, paramList))
          {
            ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(45.0F, paramList);
            i2 = 1;
          }
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
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
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().m(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyProfileDisplayTribePanel", 2, localJSONException.toString());
    }
  }
  
  private void b(int paramInt1, int paramInt2)
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
    Object localObject1;
    label184:
    do
    {
      return;
      i1 = 2131437984;
      break;
      i1 = 2131437738;
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_gift", 0, 0, "", "", "", "");
      break;
      if (this.w)
      {
        i1 = 2131430518;
        if (!this.w) {
          break label184;
        }
      }
      for (localObject1 = "exp_followed";; localObject1 = "exp_follow")
      {
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", (String)localObject1, 0, 0, "", "", "", "");
        break;
        i1 = 2131430516;
        break label135;
      }
      i1 = 2131433661;
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_msg", 0, 0, "", "", "", "");
      break;
      i1 = 2131435812;
      break;
      i1 = 2131437462;
      break;
      i1 = 2131438113;
      break;
      localObject1 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
      ((View)localObject1).setVisibility(0);
      if (paramInt2 == 40) {
        break label488;
      }
      localObject2 = (Button)((View)localObject1).findViewById(2131365278);
      ((Button)localObject2).setText(i1);
      if (paramInt2 == 38)
      {
        ((Button)localObject2).setBackgroundResource(2130845905);
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131493196));
      }
      ((Button)localObject2).setOnClickListener(this);
      localObject3 = new DataTag(paramInt2, null);
      ((Button)localObject2).setTag(localObject3);
      ((View)localObject1).setTag(localObject3);
      if ((paramInt2 == 60) && (this.w))
      {
        ((Button)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131494244));
        ((Button)localObject2).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130838537));
        return;
      }
      if ((paramInt2 == 8) && (this.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
      {
        ((Button)localObject2).setBackgroundResource(2130845905);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
    } while ((paramInt2 != 36) || (!this.jdField_r_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean));
    ((Button)localObject2).setBackgroundResource(2130845905);
    ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
    return;
    label488:
    ((Button)((View)localObject1).findViewById(2131365278)).setVisibility(8);
    Object localObject2 = new DataTag(paramInt2, null);
    Object localObject3 = (ProgressButton)((View)localObject1).findViewById(2131368924);
    if (localObject3 != null)
    {
      ((ProgressButton)localObject3).setVisibility(0);
      ((ProgressButton)localObject3).setText(i1);
      if (paramInt2 == 38)
      {
        ((ProgressButton)localObject3).setBackgroundResource(2130845905);
        ((ProgressButton)localObject3).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131493196));
      }
      ((ProgressButton)localObject3).setOnClickListener(this);
      ((ProgressButton)localObject3).setTag(localObject2);
    }
    ((View)localObject1).setTag(localObject2);
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
  
  private void d(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    this.jdField_v_of_type_AndroidWidgetTextView.setVisibility(0);
    if (paramArrayOfByte != null)
    {
      RichStatus localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131492971));
      }
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.actionText)))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {}
        for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.actionId, 200);; paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130845537))
        {
          paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
          int i1 = (int)(this.jdField_v_of_type_AndroidWidgetTextView.getTextSize() * 1.1F + 0.5F);
          paramArrayOfByte.setBounds(0, 0, i1, i1);
          paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
          paramArrayOfByte.a(-0.1F);
          ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
          this.jdField_v_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
          return;
        }
      }
      paramArrayOfByte = StringUtil.c(((SpannableString)localObject).toString());
      if (TextUtils.isEmpty(paramArrayOfByte))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
        {
          this.jdField_v_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        this.jdField_v_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_v_of_type_AndroidWidgetTextView.setText(paramArrayOfByte.trim());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
    {
      this.jdField_v_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_v_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void o()
  {
    ArrayList localArrayList1 = new ArrayList(4);
    Object localObject = new ArrayList(3);
    ArrayList localArrayList2 = new ArrayList(9);
    if (this.jdField_h_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      localArrayList2.add(this.jdField_h_of_type_AndroidWidgetRelativeLayout);
    }
    if (this.jdField_g_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      localArrayList2.add(this.jdField_g_of_type_AndroidWidgetRelativeLayout);
    }
    if (this.jdField_i_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      localArrayList2.add(this.jdField_i_of_type_AndroidWidgetRelativeLayout);
    }
    int i1 = 0;
    String str1;
    label183:
    String str2;
    if (i1 < 3)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[(i1 + 4)].jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        ((List)localObject).add(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1]);
        localArrayList2.add(this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1]);
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(0);
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
        {
          str1 = "1";
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int > 4) {
            break label267;
          }
          str2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int + 3 + "";
          label226:
          ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", "exp_tag", 0, 0, str1, "", str2, "");
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        str1 = "2";
        break label183;
        label267:
        str2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int - 4 + "";
        break label226;
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(8);
      }
    }
    i1 = 0;
    if (i1 < 4)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localArrayList1.add(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1]);
        localArrayList2.add(this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1]);
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
        {
          str1 = "1";
          label398:
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int > 4) {
            break label482;
          }
          str2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int + 3 + "";
          label441:
          ReportController.b((QQAppInterface)localObject, "dc00899", "grp_lbs", "", "data_card", "exp_tag", 0, 0, str1, "", str2, "");
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        str1 = "2";
        break label398;
        label482:
        str2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int - 4 + "";
        break label441;
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].setVisibility(8);
      }
    }
    if (localArrayList2.size() > 0) {
      ((View)localArrayList2.get(0)).setBackgroundDrawable(null);
    }
    for (;;)
    {
      if (localArrayList2.size() > 1) {
        ((View)localArrayList2.get(localArrayList2.size() - 1)).setBackgroundResource(2130846088);
      }
      return;
      if (localArrayList2.size() == 0) {
        this.jdField_c_of_type_AndroidViewView.findViewById(2131370780).setVisibility(8);
      }
    }
  }
  
  private void p()
  {
    this.jdField_h_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (this.jdField_i_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_i_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)))
    {
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    t();
  }
  
  private void r()
  {
    this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130842898);
    this.jdField_q_of_type_AndroidWidgetTextView.setOnClickListener(null);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_p_of_type_AndroidWidgetTextView.setText(2131436771);
      this.jdField_p_of_type_AndroidWidgetTextView.setOnClickListener(new afkb(this));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_p_of_type_AndroidWidgetTextView.setText(2131436771);
    this.jdField_p_of_type_AndroidWidgetTextView.setOnClickListener(new afkc(this));
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null));
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 0, 1);
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.nearby_people_card.", 2, "NumberFormatException");
  }
  
  private void t()
  {
    bool = true;
    this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131494311));
    this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842894));
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(null);
    Object localObject = FaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 200, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), 3);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable((Drawable)localObject);
    int i1 = (int)(70.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D);
    int i2 = (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D);
    localObject = new Paint();
    ((Paint)localObject).setColor(-1);
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    ((Paint)localObject).setStrokeWidth(i2);
    ((Paint)localObject).setAntiAlias(true);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i2 * 2 + i1, i2 * 2 + i1, Bitmap.Config.ARGB_8888);
      if (localBitmap != null)
      {
        new Canvas(localBitmap).drawCircle(i1 / 2 + i2, i2 + i1 / 2, i1 / 2, (Paint)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall create bitmap oom.");
          continue;
          this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130842896);
          bool = false;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
          }
        }
      }
    }
    this.jdField_g_of_type_AndroidViewView.setBackgroundDrawable(null);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130842897);
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setTag(Boolean.valueOf(bool));
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.g();
        return;
      }
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, false);
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
        break label253;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vCookies, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.favoriteSource, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), 0);
        bool = ((NearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(206)).c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin).longValue());
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
    return 2130970482;
  }
  
  View a(int paramInt, PicInfo paramPicInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayTribePanel", 2, "getAvatarWallItemView, position = " + paramInt + ", info = " + paramPicInfo.toString());
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localCustomImgView.setLayoutParams(new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int));
    localRelativeLayout.addView(localCustomImgView, new LinearLayout.LayoutParams(-1, -1));
    Object localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((ImageView)localObject1).setBackgroundResource(2130839467);
    ((ImageView)localObject1).setImageResource(2130843135);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setVisibility(8);
    int i1 = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 24.0F);
    Object localObject2 = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842478));
    localCustomImgView.setTag(paramPicInfo);
    localCustomImgView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.jdField_b_of_type_Boolean) {
      localRelativeLayout.setContentDescription("图片" + paramInt);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130843019);
    try
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_o_of_type_Boolean) || (TextUtils.isEmpty(paramPicInfo.jdField_d_of_type_JavaLangString))) {
        break label533;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramPicInfo.jdField_d_of_type_JavaLangString, localRelativeLayout);
      if (DynamicAvatarDownloadManager.b(paramPicInfo.jdField_d_of_type_JavaLangString))
      {
        localRelativeLayout.getChildAt(1).setVisibility(8);
        a(paramPicInfo, localRelativeLayout);
        return localRelativeLayout;
      }
      if (!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity)) {
        break label520;
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
        localRelativeLayout.getChildAt(1).setVisibility(0);
        continue;
        localRelativeLayout.getChildAt(1).setVisibility(8);
      }
      if (StringUtil.a(paramPicInfo.jdField_a_of_type_JavaLangString)) {
        break label638;
      }
      paramPicInfo = NearbyImgDownloader.a(paramPicInfo.jdField_a_of_type_JavaLangString);
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_f_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      paramPicInfo = URLDrawable.getDrawable(paramPicInfo, (URLDrawable.URLDrawableOptions)localObject2);
      paramPicInfo.setDownloadListener(new ImgDownloadListener(BaseApplicationImpl.getApplication(), "actNearbyPeoplePicDownload"));
      localCustomImgView.setImageDrawable(paramPicInfo);
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
    label520:
    label533:
    label638:
    return localRelativeLayout;
  }
  
  public void a()
  {
    DownloadApi.a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(this.jdField_f_of_type_Int);
    if (!this.jdField_v_of_type_Boolean)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int;
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if (i1 == 3)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon == null) {
          break label167;
        }
        i1 = 0;
        if (i1 >= 4) {
          break label167;
        }
        if (!this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a()) {
          break label151;
        }
      }
    }
    label151:
    label167:
    for (int i1 = 1;; i1 = 0)
    {
      int i3 = i1;
      int i2;
      if (i1 == 0)
      {
        i3 = i1;
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg != null) {
          i2 = 0;
        }
      }
      for (;;)
      {
        i3 = i1;
        if (i2 < 3)
        {
          if (this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i2].a()) {
            i3 = 1;
          }
        }
        else
        {
          if (i3 != 0)
          {
            this.jdField_v_of_type_Boolean = true;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005549", "0X8005549", 0, 0, "", "", "", "");
          }
          return;
          i1 += 1;
          break;
        }
        i2 += 1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    if (this.jdField_f_of_type_Int == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "prepare2ScoreAnim() diff=" + paramInt);
    }
    TextView localTextView = (TextView)this.jdField_j_of_type_AndroidWidgetRelativeLayout.findViewById(2131370739);
    Rect localRect;
    if (localTextView.getTag() == null)
    {
      localRect = new Rect();
      localTextView.setTag(localRect);
    }
    for (;;)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView();
      localTextView.getGlobalVisibleRect(localRect);
      if (localRect.bottom >= localView.getHeight()) {
        break;
      }
      a(localTextView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(202, 2500L);
      return;
      localRect = (Rect)localTextView.getTag();
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
        String str = ProfileCardUtil.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin));
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
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList);
          }
          if (paramInt2 == 1) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.g();
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Int - 150.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float;
    Object localObject2 = null;
    Object localObject1;
    if ((paramInt2 > paramInt4) && (paramInt2 >= f1) && (this.jdField_k_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8)) {
      localObject1 = this.jdField_a_of_type_AndroidViewAnimationAnimation;
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1 != this.jdField_k_of_type_AndroidWidgetRelativeLayout.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.jdField_k_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject1);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation((Animation)localObject1);
      }
      return;
      localObject1 = localObject2;
      if (paramInt2 < paramInt4)
      {
        localObject1 = localObject2;
        if (paramInt2 <= f1)
        {
          localObject1 = localObject2;
          if (this.jdField_k_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
            localObject1 = this.jdField_b_of_type_AndroidViewAnimationAnimation;
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
    case 1000: 
    case 11000: 
    case 1018: 
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.setResult(-1);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
          return;
        } while (paramIntent == null);
        return;
      } while (paramInt2 != -1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 25;
      i();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "NearbyPeopleProfileActivity->doOnActivityResult, resultCode=" + paramInt2);
    }
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
      paramInt1 = 510;
    }
    for (;;)
    {
      paramIntent = (NearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(60);
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
          if (QLog.isColorLevel()) {
            QLog.e("NearbyLikeLimitManager", 2, "doOnActivityResult req NearbyLikeLimitInfo: mCard.uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          }
          long l1 = 0L;
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(105)).d.put(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, Integer.valueOf(1));
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
    Object localObject;
    label103:
    int i1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime.split(" ")[0];
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
        break label352;
      }
      localObject = "1";
      str = this.jdField_a_of_type_JavaLangString + "&tinyid=" + paramLong + "&distance=" + str + "&_from=" + (String)localObject;
      localIntent.putExtra("url", str);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProfileDisplayTribePanel", 2, "openFaceScorePage, url = " + str);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
      i1 = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_JavaLangString;
      if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int) {
        break label360;
      }
    }
    label352:
    label360:
    for (String str = "1";; str = "2")
    {
      FaceScoreUtils.a("clk_data", (String)localObject, new String[] { str, i1 + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1 + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording });
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance;
      break;
      localObject = "0";
      break label103;
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_c_of_type_AndroidViewView = paramView;
    this.jdField_n_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370751));
    this.jdField_o_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370754));
    this.jdField_g_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370769));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370750));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370770));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370753));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370756));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370699));
    this.jdField_l_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370771));
    this.jdField_m_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370748));
    paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    this.jdField_b_of_type_Int = paramView.getDimensionPixelSize(2131559280);
    this.jdField_c_of_type_Int = paramView.getDimensionPixelSize(2131559281);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370551));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_m_of_type_AndroidWidgetRelativeLayout).a(21).c(30).a();
    this.jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[] { (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370772), (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370773), (URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370774) };
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370712));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363702));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView = ((NearbyCardVoteView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370545));
    if (this.jdField_p_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370086));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370696));
    this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370762));
    this.jdField_t_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370765));
    this.jdField_u_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370768));
    this.jdField_v_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370675));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370747));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370775));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370776));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370745));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370740));
    if (this.jdField_p_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370742));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370741));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370743));
    this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370744));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370760));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370763));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370766));
    this.jdField_j_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370733));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370735));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370736));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370738));
    this.jdField_g_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131370707);
    this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363400));
    this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363262));
    this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363447));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370714));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370725));
    this.jdField_b_of_type_ComTencentImageURLImageView.setColorFilter(436207616);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370726));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370727));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370728));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370729));
    if (this.jdField_p_of_type_Boolean)
    {
      paramView = this.jdField_c_of_type_AndroidViewView.findViewById(2131370792);
      localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 90.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_c_of_type_AndroidViewView.findViewById(2131363398));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131363065));
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131370718);
    paramView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131370719);
    Object localObject = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131370720);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131368335);
    afke localafke = new afke(this, paramView, (ImageView)localObject, localImageView);
    paramView.setOnClickListener(localafke);
    ((ImageView)localObject).setOnClickListener(localafke);
    localImageView.setOnClickListener(localafke);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null))
    {
      paramView.setImageResource(2130842913);
      ((ImageView)localObject).setImageResource(2130842915);
      localImageView.setImageResource(2130842911);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(0);
    }
    this.jdField_e_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131370730);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(new afko(this));
    this.jdField_f_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131370731);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(new afkw(this));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370722));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370757));
    this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370759));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131370723));
    paramView = (RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131363957);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null)) {
      paramView.setBackgroundResource(2130842878);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager = ((AvatarWallViewPager)this.jdField_c_of_type_AndroidViewView.findViewById(2131370697));
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      paramView.addRule(12);
      paramView.bottomMargin = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 28.0F);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setDotLayoutParams(paramView);
      this.jdField_k_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370709));
      this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370793));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370710));
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131370732);
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370711));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
      {
        this.jdField_m_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      paramView = (LinearLayout.LayoutParams)((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131369950)).getLayoutParams();
      if (paramView != null) {
        paramView.height = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842483));
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(this);
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateInterpolator());
      this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_o_of_type_AndroidWidgetTextView.setText(2131432425);
      this.jdField_o_of_type_AndroidWidgetTextView.setOnClickListener(new afkx(this));
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setAppInterface(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
      this.jdField_h_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131370777));
      return;
      paramView.setBackgroundResource(2130842877);
    }
  }
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if ((paramInterestTagInfo == null) || (paramInt == 0) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 1))
    {
      if (NearbyUtils.b()) {
        NearbyUtils.a("NearbyProfileDisplayTribePanel", new Object[] { "onTagClick", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int), Integer.valueOf(paramInt), paramInterestTagInfo });
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
      ThreadManager.post(new afkr(this, paramInt), 5, null, false);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setNearbyPeopleCard(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    }
    String str1 = SharedPreUtils.k(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    if (!TextUtils.isEmpty(str1)) {}
    int i1;
    int i2;
    int i3;
    Object localObject2;
    Object localObject3;
    try
    {
      this.jdField_f_of_type_JavaLangString = new JSONObject(str1).getString("ownerLikeJumpURL");
      this.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      if (!this.jdField_t_of_type_Boolean)
      {
        this.jdField_t_of_type_Boolean = true;
        this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getStringArray(2131296320);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon = new SavorTagIcon[4];
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg = new SavorTagImg[3];
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[3];
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[4];
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag = new InterestTag[7];
        i1 = 0;
        while (i1 < 7)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1] = new InterestTag(i1 + 1);
          i1 += 1;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
      i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131494220);
      i1 = 0;
      while (i1 < 4)
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1] = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(this.jdField_a_of_type_ArrayOfInt[i1])).inflate());
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1] = ((SavorTagIcon)this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].findViewById(2131370685));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a(this.jdField_a_of_type_ArrayOfJavaLangString[i1], this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList, this);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setRightArrowVisible(false);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setTitleTextColor(i2);
        if (AppSetting.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setClickable(true);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < 3)
      {
        this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1] = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(this.jdField_b_of_type_ArrayOfInt[i1])).inflate());
        i3 = i1 + 4;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1] = ((SavorTagImg)this.jdField_b_of_type_ArrayOfAndroidWidgetRelativeLayout[i1].findViewById(2131370685));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].a(this.jdField_a_of_type_ArrayOfJavaLangString[i3], this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i3].jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i3].jdField_a_of_type_JavaUtilArrayList, this);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setRightArrowVisible(false);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setTitleTextColor(i2);
        if (AppSetting.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setClickable(true);
        }
        i1 += 1;
      }
      if (this.jdField_g_of_type_AndroidWidgetRelativeLayout == null)
      {
        this.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(2131370783)).inflate());
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg = ((SavorTagImg)this.jdField_g_of_type_AndroidWidgetRelativeLayout.findViewById(2131370685));
      }
      if (this.jdField_h_of_type_AndroidWidgetRelativeLayout == null)
      {
        this.jdField_h_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(2131370782)).inflate());
        this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg = ((SavorTagImg)this.jdField_h_of_type_AndroidWidgetRelativeLayout.findViewById(2131370685));
      }
      if (this.jdField_i_of_type_AndroidWidgetRelativeLayout == null)
      {
        this.jdField_i_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((ViewStub)this.jdField_c_of_type_AndroidViewView.findViewById(2131370784)).inflate());
        this.jdField_c_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg = ((SavorTagImg)this.jdField_i_of_type_AndroidWidgetRelativeLayout.findViewById(2131370685));
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      localObject3 = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
        break label2291;
      }
    }
    Object localObject1 = "1";
    for (;;)
    {
      ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", (String)localObject3, "data_card", "exp", 0, 0, (String)localObject1, "" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j % 20, "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2)
      {
        this.jdField_m_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      try
      {
        label757:
        b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vActivityList);
        label825:
        Object localObject4;
        if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j))
        {
          this.jdField_q_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsgForTribar;
          this.jdField_r_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTipsForTribar;
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;
          this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.highScoreNum;
          n();
          a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
          c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGroupList);
          r();
          h();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
          i3 = ((Resources)localObject2).getColor(2131494220);
          int i4 = ((Resources)localObject2).getColor(2131494275);
          if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser()) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isFuXiaoJin())) {
            break label2452;
          }
          this.jdField_k_of_type_AndroidWidgetRelativeLayout.findViewById(2131370794).setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130839474);
          label951:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {
            break label2502;
          }
          localObject3 = (TextView)this.jdField_g_of_type_AndroidWidgetLinearLayout.findViewById(2131370770);
          localObject4 = new StringBuilder();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
            break label2494;
          }
          localObject1 = "他";
          label1001:
          ((TextView)localObject3).setText((String)localObject1 + "的更新");
          label1022:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) {
            break label2537;
          }
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            break label2524;
          }
          this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130843171);
          label1062:
          ThreadManager.post(new afjw(this), 8, null, true);
          label1077:
          localObject3 = new StringBuilder();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
            break label2549;
          }
          ((StringBuilder)localObject3).append("男 ");
          this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundColor(-12348939);
          label1115:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0) {
            ((StringBuilder)localObject3).append("" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age + "岁 ");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1))
          {
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
              break label2582;
            }
            localObject1 = "1";
            label1218:
            ReportController.b((QQAppInterface)localObject4, "dc00899", "grp_lbs", "", "data_card", "exp_info", 0, 0, (String)localObject1, "", "", "");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation != 0) && (ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation) != null))
          {
            ((StringBuilder)localObject3).append(ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation) + " ");
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
              break label2590;
            }
            localObject1 = "1";
            label1330:
            ReportController.b((QQAppInterface)localObject4, "dc00899", "grp_lbs", "", "data_card", "exp_xing", 0, 0, (String)localObject1, "", "", "");
          }
          if ((!StringUtil.a(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1))) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus != 1)) {
            break label2598;
          }
          if (((StringBuilder)localObject3).toString().length() <= 0) {
            break label2681;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          label1416:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig == null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig = FaceScoreUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface());
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig.a()) {
            break label2693;
          }
          ((NearbyFaceScoreManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(203)).a(new afjz(this));
          label1474:
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 31) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.q)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)) {
            break label2704;
          }
          this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.q + "·" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + "前");
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
          if (QLog.isColorLevel()) {
            QLog.d("Q.hotChatDistance", 2, "bindData, use aioDistance");
          }
          label1605:
          if (QLog.isColorLevel()) {
            QLog.d("NearbyProfileDisplayTribePanel", 2, "bindData, mCard.videoInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo);
          }
          if (!NearbyVideoUtils.a()) {
            break label2892;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo == null) {
            break label2872;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_d_of_type_JavaLangString);
          label1684:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
            break label2938;
          }
          if (((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.equals(""))) {
            break label2913;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.trim();
          label1748:
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            this.jdField_i_of_type_AndroidWidgetTextView.setText(((String)localObject1).trim());
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
            break label2963;
          }
          this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          ((TextView)this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131370713)).setText((CharSequence)localObject1);
          label1814:
          d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charm != 0L) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3)) {
            break label3004;
          }
          this.jdField_j_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
          }
          this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company = StringUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
          if (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
            break label3384;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break label3351;
          }
          this.jdField_s_of_type_AndroidWidgetTextView.setTextColor(i4);
          this.jdField_s_of_type_AndroidWidgetTextView.setText("未填写");
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          label1944:
          this.jdField_t_of_type_AndroidWidgetTextView.setTextColor(i4);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job >= NearbyProfileUtil.d.length)) {
            break label3470;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_work", 0, 0, "", "", "", "");
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_t_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.d[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job]);
          this.jdField_t_of_type_AndroidWidgetTextView.setTextColor(i3);
          label2046:
          this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college = StringUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
          if (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
            break label3551;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break label3539;
          }
          this.jdField_u_of_type_AndroidWidgetTextView.setTextColor(i4);
          this.jdField_u_of_type_AndroidWidgetTextView.setText("未填写");
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          label2114:
          s();
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
            break label3670;
          }
          if (!this.jdField_p_of_type_Boolean) {
            break label3637;
          }
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_face_score").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).a();
        }
        for (;;)
        {
          q();
          j();
          this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag);
          i1 = 0;
          while (i1 < 4)
          {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[i1].jdField_a_of_type_JavaUtilArrayList);
            if (AppSetting.jdField_b_of_type_Boolean) {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].setContentDescription(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagIcon[i1].a());
            }
            i1 += 1;
          }
          label2291:
          localObject1 = "2";
          break;
          this.jdField_m_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_m_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new afjs(this));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new afju(this));
          ((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(112)).a(1402, new afjv(this));
          ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "my_point", 0, 0, "", "", "", "");
          break label757;
          this.jdField_q_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsg;
          this.jdField_r_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
          this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTips;
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips;
          break label825;
          label2452:
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_k_of_type_AndroidWidgetRelativeLayout.findViewById(2131370794).setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131370794).setVisibility(8);
          break label951;
          label2494:
          localObject1 = "她";
          break label1001;
          label2502:
          ((TextView)this.jdField_g_of_type_AndroidWidgetLinearLayout.findViewById(2131370770)).setText("我的更新");
          break label1022;
          label2524:
          this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130843170);
          break label1062;
          label2537:
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
          break label1077;
          label2549:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            break label1115;
          }
          ((StringBuilder)localObject3).append("女 ");
          this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundColor(-38511);
          break label1115;
          label2582:
          localObject1 = "2";
          break label1218;
          label2590:
          localObject1 = "2";
          break label1330;
          label2598:
          ((StringBuilder)localObject3).append(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {}
          for (localObject1 = "1";; localObject1 = "2")
          {
            ReportController.b((QQAppInterface)localObject4, "dc00899", "grp_lbs", "", "data_card", "exp_relation", 0, 0, (String)localObject1, "", "", "");
            break;
          }
          label2681:
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          break label1416;
          label2693:
          a(this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreConfig);
          break label1474;
          label2704:
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2))
          {
            this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime.replace(" ", "·"));
            this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
            break label1605;
          }
          if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff))) {
            break label1605;
          }
          this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance + "·" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + "前");
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
          break label1605;
          label2872:
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.jdField_f_of_type_AndroidViewView.setVisibility(0);
          break label1684;
          label2892:
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          break label1684;
          label2913:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname == null) {
            break label3783;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
          break label1748;
          label2938:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname == null) {
            break label3783;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
          break label1748;
          label2963:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break label1814;
          }
          this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_q_of_type_AndroidWidgetTextView.setText("我的交友资料");
          break label1814;
          label3004:
          this.jdField_j_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_j_of_type_AndroidWidgetTextView.setText("LV" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel);
          localObject1 = NearbyFlowerUtil.a(this.jdField_j_of_type_AndroidWidgetTextView.getContext());
          i2 = Color.parseColor("#FFCC59");
          i1 = i2;
          if (localObject1 != null)
          {
            i1 = i2;
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel < localObject1.length) {
              i1 = localObject1[this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel];
            }
          }
          this.jdField_j_of_type_AndroidWidgetTextView.setBackgroundDrawable(TroopUtils.a(this.jdField_j_of_type_AndroidWidgetTextView.getContext().getResources(), i1));
          this.jdField_j_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(4.0F, (Resources)localObject2), 0, AIOUtils.a(4.0F, (Resources)localObject2), 0);
          this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strLevelType);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
          {
            this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.mHeartNum + "颗心");
            this.jdField_k_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131494220));
            if (paramNearbyPeopleCard.taskTotal > 0)
            {
              localObject1 = "领心" + paramNearbyPeopleCard.taskFinished + "/" + paramNearbyPeopleCard.taskTotal;
              localObject2 = new SpannableString((CharSequence)localObject1);
              paramNearbyPeopleCard = String.valueOf(paramNearbyPeopleCard.taskFinished);
              i1 = ((String)localObject1).indexOf(paramNearbyPeopleCard);
              ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#36FF0000")), i1, paramNearbyPeopleCard.length() + i1, 33);
              this.jdField_l_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            }
          }
          for (;;)
          {
            this.jdField_j_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
            break;
            this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          label3351:
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break label1944;
          }
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130846097);
          break label1944;
          label3384:
          this.jdField_s_of_type_AndroidWidgetTextView.setTextColor(i3);
          this.jdField_s_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company, 1, 16));
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_company", 0, 0, "", "", "", "");
          break label1944;
          label3470:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
          {
            this.jdField_t_of_type_AndroidWidgetTextView.setText("未填写");
            break label2046;
          }
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2)) {
            break label2046;
          }
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130846097);
          break label2046;
          label3539:
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          break label2114;
          label3551:
          this.jdField_u_of_type_AndroidWidgetTextView.setTextColor(i3);
          this.jdField_u_of_type_AndroidWidgetTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college, 1, 16));
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
          this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_school", 0, 0, "", "", "", "");
          break label2114;
          label3637:
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          i();
          continue;
          label3670:
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          m();
        }
        i1 = 0;
        while (i1 < 3)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].a(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyInterestTagInterestTag[(i1 + 4)].jdField_a_of_type_JavaUtilArrayList);
          if (AppSetting.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].setContentDescription(this.jdField_a_of_type_ArrayOfComTencentMobileqqNearbyProfilecardSavorTagImg[i1].a());
          }
          i1 += 1;
        }
        o();
        new StringBuilder();
        p();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          label3783:
          String str2 = "";
        }
      }
    }
  }
  
  public void a(FaceScoreConfig paramFaceScoreConfig)
  {
    if (paramFaceScoreConfig == null) {
      return;
    }
    if (this.jdField_p_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    boolean bool = ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).equals("1000");
    label137:
    label204:
    int i1;
    label269:
    label277:
    label287:
    String str1;
    if ((paramFaceScoreConfig.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.entryAbility != 0))
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 1)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording)) {
          break label632;
        }
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_m_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording);
        if (bool)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWordingColor != 0) {
            break label515;
          }
          this.jdField_m_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#000000"));
        }
        this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreIconUrl)) || ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreIconUrl.startsWith("http://")) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreIconUrl.startsWith("https://")))) {
          break label561;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundURL(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreIconUrl);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWording)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)) {
          break label620;
        }
        this.jdField_n_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWording);
        if (bool)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWordingColor != 0) {
            break label574;
          }
          this.jdField_n_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#000000"));
        }
        this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        i1 = 1;
        if (i1 != 0)
        {
          i1 = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
          String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_JavaLangString;
          if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int) {
            break label646;
          }
          str1 = "1";
          label343:
          FaceScoreUtils.a("exp_data", str2, new String[] { str1, i1 + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1 + "", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWording });
        }
      }
      label422:
      if (2 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int) {
        break label666;
      }
      this.jdField_a_of_type_JavaLangString = paramFaceScoreConfig.b;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.entryAbility != 1)) {
        break label688;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_m_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break;
      }
      paramFaceScoreConfig = (RelativeLayout.LayoutParams)this.jdField_m_of_type_AndroidWidgetTextView.getLayoutParams();
      paramFaceScoreConfig.rightMargin = 15;
      this.jdField_m_of_type_AndroidWidgetTextView.setLayoutParams(paramFaceScoreConfig);
      return;
      label515:
      str1 = "#" + Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreWordingColor);
      this.jdField_m_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(str1));
      break label137;
      label561:
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130839477);
      break label204;
      label574:
      str1 = "#" + Integer.toHexString(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.faceScoreTailWordingColor);
      this.jdField_n_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(str1));
      break label269;
      label620:
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
      break label277;
      label632:
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      i1 = 0;
      break label287;
      label646:
      str1 = "2";
      break label343;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label422;
      label666:
      if (3 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int) {
        this.jdField_a_of_type_JavaLangString = paramFaceScoreConfig.jdField_c_of_type_JavaLangString;
      }
    }
    label688:
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  public void a(PicInfo paramPicInfo, RelativeLayout paramRelativeLayout)
  {
    CustomImgView localCustomImgView = (CustomImgView)paramRelativeLayout.getChildAt(0);
    paramRelativeLayout = (ImageView)paramRelativeLayout.getChildAt(1);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130846525);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Int;
    localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Int;
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mUseMemoryCache = false;
    if (ShortVideoUtils.a())
    {
      localObject = new VideoDrawable.VideoDrawableParams();
      ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_n_of_type_Int;
      localURLDrawableOptions.mExtraInfo = localObject;
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(DynamicAvatarDownloadManager.a(paramPicInfo.jdField_d_of_type_JavaLangString), localURLDrawableOptions));
    }
    for (;;)
    {
      if (paramRelativeLayout.getVisibility() == 0) {
        paramRelativeLayout.setVisibility(8);
      }
      return;
      if (!TextUtils.isEmpty(paramPicInfo.jdField_a_of_type_JavaLangString)) {
        localCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString = paramString1;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString1.mRequestWidth = AIOUtils.a(43.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      paramString1.mRequestHeight = AIOUtils.a(43.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources());
      paramString1.mFailedDrawable = ImageUtil.b();
      paramString1.mLoadingDrawable = ImageUtil.b();
      paramString1.mMemoryCacheKeySuffix = "NearbyVideoRoundIcon";
      paramString1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString, paramString1);
      paramString1.setDecodeHandler(URLDrawableDecodeHandler.a);
      if (paramString1.getStatus() != 1) {
        paramString1.restartDownload();
      }
      ((URLImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131362730)).setBackgroundDrawable(paramString1);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish, url = " + paramString + ", isSuccess = " + paramBoolean);
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
        localViewHolder = (AvatarWallPagerAdapter.ViewHolder)paramString.getTag(2131362441);
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
      QLog.e("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish went error .., holder is null or holder.data is null");
      return;
    }
    label129:
    QLog.e("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish went error .., view is not a instance of RelativeLayout");
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "hideCharmChanged() showAnim=" + paramBoolean);
    }
    TextView localTextView = (TextView)this.jdField_j_of_type_AndroidWidgetRelativeLayout.findViewById(2131370739);
    if (paramBoolean)
    {
      int i1 = localTextView.getWidth();
      int i2 = localTextView.getHeight();
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, i1 / 2, i2 / 2);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 17432584);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setDuration(1500L);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setFillBefore(false);
      localTextView.setAnimation(localAnimationSet);
      localAnimationSet.start();
      return;
    }
    localTextView.setVisibility(4);
  }
  
  public void a(boolean paramBoolean, int paramInt, List paramList)
  {
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.removeBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
      }
    }
    do
    {
      return;
      paramList = (ShowExternalTroop)paramList.get(0);
      this.jdField_g_of_type_JavaLangString = paramList.troopUin;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = new ProfileBusiEntry();
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_Int = 1024;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.b = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131430397);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_c_of_type_JavaLangString = paramList.troopName;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = paramList.strFaceUrl;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_c_of_type_JavaLangString == null));
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_g_of_type_JavaLangString, "1", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_g_of_type_JavaLangString, "0", "", "");
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "http://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, GameCenterActivity.class);
      paramString.putExtra("url", HtmlOffline.a(str, "plat=qq&tt=1&_wv=3&qappid=" + AppSetting.jdField_a_of_type_Int + "&osv=" + Build.VERSION.RELEASE + "&vuin=" + NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString) + "&vname=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString + "&bn=" + paramBoolean));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      this.jdField_o_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_n_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    label181:
    label349:
    label379:
    int i1;
    label412:
    label478:
    label1020:
    do
    {
      return;
      nearby.Cmd0x1RspBody localCmd0x1RspBody = new nearby.Cmd0x1RspBody();
      int i2;
      try
      {
        localCmd0x1RspBody.mergeFrom(paramArrayOfByte);
        localObject1 = localCmd0x1RspBody.bytes_bars_url.get().toStringUtf8();
        this.jdField_e_of_type_JavaLangString = localCmd0x1RspBody.bytes_qunlist_url.get().toStringUtf8();
        this.jdField_a_of_type_ArrayOfByte = localCmd0x1RspBody.bytes_chat_sig.get().toByteArray();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().i(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ArrayOfByte);
        this.w = localCmd0x1RspBody.bool_follow.get();
        if (localCmd0x1RspBody.uint32_if_mask_msg.get() != 1) {
          break label1066;
        }
        bool = true;
        this.jdField_q_of_type_Boolean = bool;
        if (localCmd0x1RspBody.uint32_if_mask_gift.get() != 1) {
          break label1072;
        }
        bool = true;
        this.jdField_r_of_type_Boolean = bool;
        paramArrayOfByte = localCmd0x1RspBody.bytes_feed_wording_title.get().toStringUtf8();
        localObject2 = localCmd0x1RspBody.bytes_feed_wording.get().toStringUtf8();
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramArrayOfByte);
        paramArrayOfByte = MsgBoxUtil.b((String)localObject2);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(MsgBoxUtil.a(paramArrayOfByte, 16));
        if (localCmd0x1RspBody.bytes_mask_msg_reason.has()) {
          this.jdField_c_of_type_JavaLangString = localCmd0x1RspBody.bytes_mask_msg_reason.get().toStringUtf8();
        }
        if (localCmd0x1RspBody.bytes_mask_gift_reason.has()) {
          this.jdField_d_of_type_JavaLangString = localCmd0x1RspBody.bytes_mask_gift_reason.get().toStringUtf8();
        }
        localObject2 = new ArrayList();
        if ((!localCmd0x1RspBody.rpt_BarInfo_bars.has()) || (localCmd0x1RspBody.rpt_BarInfo_bars.get().size() <= 0)) {
          break label1153;
        }
        this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramArrayOfByte = localCmd0x1RspBody.rpt_BarInfo_bars.get().iterator();
        if (paramArrayOfByte.hasNext())
        {
          localObject3 = (nearby.BarInfo)paramArrayOfByte.next();
          if (((ArrayList)localObject2).size() < 12) {
            break label1078;
          }
        }
        i1 = localCmd0x1RspBody.uint32_bars_num.get();
        if (i1 > 12)
        {
          if (((ArrayList)localObject2).size() <= 11) {
            break label1165;
          }
          ((ArrayList)localObject2).remove(11);
          paramArrayOfByte = new InterestTagInfo();
          paramArrayOfByte.tagName = " ";
          paramArrayOfByte.tagIconUrl = "icon_more_url";
          paramArrayOfByte.tagJumpUrl = "icon_more_url";
          paramArrayOfByte.tagType = 10;
          ((ArrayList)localObject2).add(paramArrayOfByte);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break label1215;
          }
          paramArrayOfByte = "1";
          ReportController.b((QQAppInterface)localObject3, "dc00899", "grp_lbs", "", "data_card", "exp_more_tribe", 0, 0, paramArrayOfByte, "", "", "");
        }
        if (this.jdField_c_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.jdField_a_of_type_ComTencentWidgetHorizontalListView == null) {
          break label1222;
        }
        this.jdField_c_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a((List)localObject2);
        this.jdField_c_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.jdField_a_of_type_AndroidWidgetTextView.setText("加入的部落(" + i1 + ")");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label1257;
        }
        localObject1 = (nearby.FansInfo)localCmd0x1RspBody.FansInfo_fans.get();
        i1 = ((nearby.FansInfo)localObject1).uint32_fans_num.get();
        i2 = ((nearby.FansInfo)localObject1).uint32_follows_num.get();
        paramArrayOfByte = ((nearby.FansInfo)localObject1).bytes_fans_url.get().toStringUtf8();
        localObject1 = ((nearby.FansInfo)localObject1).bytes_follows_url.get().toStringUtf8();
        this.jdField_f_of_type_AndroidWidgetTextView.setText("有" + i1 + "个粉丝");
        this.jdField_g_of_type_AndroidWidgetTextView.setText("关注了" + i2 + "个人");
        this.jdField_n_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new afla(this, paramArrayOfByte));
        this.jdField_o_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aflb(this, (String)localObject1));
        if ((!localCmd0x1RspBody.rpt_FeedInfo_feeds.has()) || (localCmd0x1RspBody.rpt_FeedInfo_feeds.get().size() <= 0)) {
          break;
        }
        localObject2 = localCmd0x1RspBody.rpt_FeedInfo_feeds.get();
        i2 = ((List)localObject2).size();
        if (((List)localObject2).size() <= 0) {
          break label1304;
        }
        i1 = 0;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        try
        {
          paramArrayOfByte = URLDrawable.getDrawable("" + ((nearby.FeedInfo)((List)localObject2).get(i1)).bytes_pic.get().toStringUtf8(), paramArrayOfByte);
          localObject3 = this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1];
          localObject1 = paramArrayOfByte;
          if (paramArrayOfByte == null) {
            localObject1 = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131493213));
          }
          ((URLImageView)localObject3).setImageDrawable((Drawable)localObject1);
          this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setScaleType(ImageView.ScaleType.CENTER_CROP);
          this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setBackgroundColor(0);
          i1 += 1;
        }
        catch (Exception paramArrayOfByte)
        {
          boolean bool;
          Object localObject2;
          Object localObject3;
          QLog.w("NearbyProfileDisplayTribePanel", 2, paramArrayOfByte.toString());
        }
        paramArrayOfByte = paramArrayOfByte;
        if (!QLog.isColorLevel()) {
          break label1020;
        }
        QLog.w("NearbyProfileDisplayTribePanel", 2, "Cmd0x1RspBody error !:" + paramArrayOfByte);
        this.jdField_o_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_n_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
      }
      if ((i1 < i2) && (i1 < 3))
      {
        paramArrayOfByte = URLDrawable.URLDrawableOptions.obtain();
        paramArrayOfByte.mLoadingDrawable = paramArrayOfByte.mFailedDrawable;
        paramArrayOfByte.mRequestWidth = ((int)(SavorTagImg.jdField_a_of_type_ArrayOfInt[0] * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float));
        paramArrayOfByte.mRequestHeight = ((int)(SavorTagImg.jdField_a_of_type_ArrayOfInt[0] * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float));
        if (!TextUtils.isEmpty(((nearby.FeedInfo)((List)localObject2).get(i1)).bytes_pic.get().toStringUtf8())) {}
        for (;;)
        {
          bool = false;
          break;
          bool = false;
          break label181;
          InterestTagInfo localInterestTagInfo = new InterestTagInfo();
          localInterestTagInfo.tagName = ((nearby.BarInfo)localObject3).bytes_bar_name.get().toStringUtf8();
          localInterestTagInfo.tagIconUrl = ((nearby.BarInfo)localObject3).bytes_bar_pic.get().toStringUtf8();
          localInterestTagInfo.tagJumpUrl = ((nearby.BarInfo)localObject3).bytes_bar_url.get().toStringUtf8();
          localInterestTagInfo.tagType = 10;
          ((ArrayList)localObject2).add(localInterestTagInfo);
          break label349;
          this.jdField_i_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          break label379;
          if (!QLog.isColorLevel()) {
            break label412;
          }
          QLog.w("NearbyProfileDisplayTribePanel", 2, "buluo num > 12 but the list's size < 12??? buluoNum:" + i1 + "   list.Size:" + ((ArrayList)localObject2).size());
          break label412;
          paramArrayOfByte = "2";
          break label478;
          this.jdField_c_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a("加入的部落", 10, (List)localObject2, new afkz(this, (String)localObject1));
          this.jdField_c_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.setRightArrowVisible(false);
          break label525;
          this.jdField_o_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_n_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_o_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          break label727;
          paramArrayOfByte = null;
        }
      }
      i1 = 2;
      while ((i1 >= i2) && (i1 >= 0))
      {
        this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setVisibility(8);
        i1 -= 1;
      }
      this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i1 = i2;
      paramArrayOfByte = new afjp(this, localCmd0x1RspBody.bytes_feeds_url.get().toStringUtf8());
      this.jdField_l_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramArrayOfByte);
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramArrayOfByte);
      if (this.jdField_g_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label1577;
        }
        paramArrayOfByte = "1";
        ReportController.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_pub", 0, 0, paramArrayOfByte, "", "" + i1, "");
      }
    } while (this.jdField_i_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0);
    label525:
    label727:
    label1257:
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
    label1066:
    label1072:
    label1078:
    label1215:
    label1222:
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {}
    label1153:
    label1165:
    label1304:
    for (paramArrayOfByte = "1";; paramArrayOfByte = "2")
    {
      ReportController.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_tribe", 0, 0, paramArrayOfByte, "", "", "");
      return;
      i1 = 0;
      while (i1 < 3)
      {
        this.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setVisibility(8);
        i1 += 1;
      }
      this.jdField_l_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i1 = 0;
      break;
      label1577:
      paramArrayOfByte = "2";
      break label1421;
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
    int i11 = 1;
    int i1;
    int i2;
    label21:
    int i3;
    label30:
    int i4;
    label40:
    int i5;
    label50:
    int i6;
    label60:
    int i7;
    label70:
    int i8;
    label80:
    int i9;
    label90:
    int i10;
    if (this.jdField_l_of_type_Boolean)
    {
      i1 = 1;
      if (!this.jdField_k_of_type_Boolean) {
        break label169;
      }
      i2 = 1;
      if (!this.jdField_j_of_type_Boolean) {
        break label174;
      }
      i3 = 1;
      if (!this.jdField_i_of_type_Boolean) {
        break label179;
      }
      i4 = 1;
      if (!this.jdField_h_of_type_Boolean) {
        break label185;
      }
      i5 = 1;
      if (!this.jdField_g_of_type_Boolean) {
        break label191;
      }
      i6 = 1;
      if (!this.jdField_f_of_type_Boolean) {
        break label197;
      }
      i7 = 1;
      if (!this.jdField_e_of_type_Boolean) {
        break label203;
      }
      i8 = 1;
      if (!this.jdField_d_of_type_Boolean) {
        break label209;
      }
      i9 = 1;
      if (!this.jdField_c_of_type_Boolean) {
        break label215;
      }
      i10 = 1;
      label100:
      if (!this.jdField_b_of_type_Boolean) {
        break label221;
      }
    }
    for (;;)
    {
      return i10 << 1 | i1 << 10 | i2 << 9 | i3 << 8 | i4 << 7 | i5 << 6 | i6 << 5 | i7 << 4 | i8 << 3 | i9 << 2 | i11 << 0;
      i1 = 0;
      break;
      label169:
      i2 = 0;
      break label21;
      label174:
      i3 = 0;
      break label30;
      label179:
      i4 = 0;
      break label40;
      label185:
      i5 = 0;
      break label50;
      label191:
      i6 = 0;
      break label60;
      label197:
      i7 = 0;
      break label70;
      label203:
      i8 = 0;
      break label80;
      label209:
      i9 = 0;
      break label90;
      label215:
      i10 = 0;
      break label100;
      label221:
      i11 = 0;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "content_timer", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
    }
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
      {
        bool1 = true;
        NearbyCardVoteView localNearbyCardVoteView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0) {
          break label127;
        }
        bool2 = true;
        label67:
        localNearbyCardVoteView.a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, null, true, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.praiseList);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
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
      label127:
      bool2 = false;
      break label67;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(4);
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    this.jdField_h_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    Object localObject1 = new oidb_0x814.RspBody();
    if (paramArrayOfByte == null) {
      return;
    }
    label386:
    label580:
    for (;;)
    {
      Object localObject2;
      ArrayList localArrayList;
      oidb_0x814.Activity localActivity;
      int i1;
      try
      {
        ((oidb_0x814.RspBody)localObject1).mergeFrom(paramArrayOfByte);
        if ((((oidb_0x814.RspBody)localObject1).total.has()) && (((oidb_0x814.RspBody)localObject1).total.get() > 0))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
          {
            paramArrayOfByte = "1";
            ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_ac", 0, 0, paramArrayOfByte, "", "", "");
            localObject2 = ((oidb_0x814.RspBody)localObject1).url.get();
            this.jdField_h_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            localArrayList = new ArrayList();
            paramArrayOfByte = ((oidb_0x814.RspBody)localObject1).activity_list.get().iterator();
            if (paramArrayOfByte.hasNext())
            {
              localActivity = (oidb_0x814.Activity)paramArrayOfByte.next();
              if (localArrayList.size() < 12) {
                break label386;
              }
            }
            i1 = ((oidb_0x814.RspBody)localObject1).total.get();
            if (i1 > 12)
            {
              if (localArrayList.size() <= 11) {
                break label452;
              }
              localArrayList.remove(11);
              paramArrayOfByte = new InterestTagInfo();
              paramArrayOfByte.tagName = " ";
              paramArrayOfByte.tagIconUrl = "icon_more_url";
              paramArrayOfByte.tagJumpUrl = "icon_more_url";
              paramArrayOfByte.tagType = 11;
              localArrayList.add(paramArrayOfByte);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
                break label502;
              }
              paramArrayOfByte = "1";
              ReportController.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_more_ac", 0, 0, paramArrayOfByte, "", "", "");
            }
            if (this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.jdField_a_of_type_ComTencentWidgetHorizontalListView == null) {
              break label509;
            }
            this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a(localArrayList);
          }
        }
        else
        {
          if (this.jdField_h_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
            break;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break label580;
          }
          paramArrayOfByte = "1";
          ReportController.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_act", 0, 0, paramArrayOfByte, "", "", "");
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      paramArrayOfByte = "2";
      continue;
      InterestTagInfo localInterestTagInfo = new InterestTagInfo();
      localInterestTagInfo.tagName = localActivity.name.get();
      localInterestTagInfo.tagIconUrl = localActivity.cover.get();
      localInterestTagInfo.tagJumpUrl = localActivity.url.get();
      localInterestTagInfo.tagType = 11;
      localArrayList.add(localInterestTagInfo);
      continue;
      label452:
      if (QLog.isColorLevel())
      {
        QLog.w("NearbyProfileDisplayTribePanel", 2, "act num > 12 but the list's size < 12??? actNum:" + i1 + "   list.Size:" + localArrayList.size());
        continue;
        label502:
        paramArrayOfByte = "2";
        continue;
        label509:
        this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a("参与的活动", 11, localArrayList, new afjq(this, (String)localObject2));
        this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.setRightArrowVisible(false);
        this.jdField_b_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.jdField_a_of_type_AndroidWidgetTextView.setText("参与的活动(" + i1 + ")");
        continue;
        paramArrayOfByte = "2";
      }
    }
  }
  
  boolean b()
  {
    return (Utils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_Int != 2);
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_p_of_type_Boolean = true;
      b(paramBoolean);
      return;
      if (paramBoolean) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      } else {
        this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      }
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    Object localObject2 = new cmd0x8b4.RspBody();
    if (paramArrayOfByte == null) {
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      try
      {
        ((cmd0x8b4.RspBody)localObject2).mergeFrom(paramArrayOfByte);
        if ((((cmd0x8b4.RspBody)localObject2).rpt_group_info.has()) && (((cmd0x8b4.RspBody)localObject2).rpt_group_info.get().size() > 0))
        {
          this.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          localObject1 = new ArrayList();
          localObject2 = ((cmd0x8b4.RspBody)localObject2).rpt_group_info.get();
          paramArrayOfByte = ((List)localObject2).iterator();
          if (paramArrayOfByte.hasNext())
          {
            localObject3 = (cmd0x8b4.GroupInfo)paramArrayOfByte.next();
            if (((ArrayList)localObject1).size() < 12) {}
          }
          else
          {
            if (((List)localObject2).size() > 12)
            {
              ((ArrayList)localObject1).remove(11);
              paramArrayOfByte = new InterestTagInfo();
              paramArrayOfByte.tagName = " ";
              paramArrayOfByte.tagIconUrl = "icon_more_url";
              paramArrayOfByte.tagJumpUrl = "icon_more_url";
              paramArrayOfByte.tagType = 9;
              ((ArrayList)localObject1).add(paramArrayOfByte);
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
              if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
                break label480;
              }
              paramArrayOfByte = "1";
              ReportController.b((QQAppInterface)localObject3, "dc00899", "grp_lbs", "", "data_card", "exp_more_grp", 0, 0, paramArrayOfByte, "", "", "");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.jdField_a_of_type_ComTencentWidgetHorizontalListView == null) {
              break label487;
            }
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a((List)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.jdField_a_of_type_AndroidWidgetTextView.setText("加入的群(" + ((List)localObject2).size() + ")");
          }
        }
        else
        {
          if (this.jdField_g_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
            break;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break label520;
          }
          paramArrayOfByte = "1";
          ReportController.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_grp", 0, 0, paramArrayOfByte, "", "", "");
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      InterestTagInfo localInterestTagInfo = new InterestTagInfo();
      long l1 = ((cmd0x8b4.GroupInfo)localObject3).uint64_gc.get();
      localInterestTagInfo.tagName = ((cmd0x8b4.GroupInfo)localObject3).str_group_name.get();
      localInterestTagInfo.tagIconUrl = ("http://p.qlogo.cn/gh/" + l1 + "/" + l1 + "/140");
      localInterestTagInfo.tagJumpUrl = ("" + l1);
      localInterestTagInfo.tagType = 9;
      ((ArrayList)localObject1).add(localInterestTagInfo);
      continue;
      label480:
      paramArrayOfByte = "2";
      continue;
      label487:
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.a("加入的群", 9, (List)localObject1, new afjr(this));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardSavorTagImg.setRightArrowVisible(false);
      continue;
      label520:
      paramArrayOfByte = "2";
    }
  }
  
  public void d() {}
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_r_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
    {
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_d_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131435458));
      return;
    }
  }
  
  public void e() {}
  
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
      v();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      FaceDrawable localFaceDrawable = (FaceDrawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFaceDrawable != null) {
        localFaceDrawable.a();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void h()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn()) && (!this.jdField_p_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setHeartLayout(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
      {
        bool1 = true;
        NearbyCardVoteView localNearbyCardVoteView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVoted == 0) {
          break label132;
        }
        label73:
        localNearbyCardVoteView.a(bool1, bool2, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc, null, false, false, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.praiseList);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setOnClickListener(this);
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
      label132:
      bool2 = false;
      break label73;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(4);
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
      if (!this.jdField_o_of_type_Boolean)
      {
        b(2, 8);
        if ((this.w) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() == 0)) {
          break label702;
        }
        localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131365278);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131494242));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130838497));
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).getVisibility() != 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() != 0))
      {
        localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).findViewById(2131365278);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131494242));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130838497));
      }
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 14) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 86) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 87) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 88) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 79) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 89)) {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()))
        {
          b(0, 36);
          label441:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid != 0L) {
            break label608;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b != null) || (b())) {
            break label565;
          }
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
      }
      for (;;)
      {
        b(1, 60);
        break;
        b(2, 40);
        break label441;
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uRoomid == 0L)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
          break label441;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        break label441;
        label565:
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.jdField_o_of_type_Boolean))
        {
          b(2, 8);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          continue;
          label608:
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b == null) && (!b())) {
            this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
          } else if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.jdField_o_of_type_Boolean)) {
            b(0, 8);
          } else {
            this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
          }
        }
      }
      label702:
      ((Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131365278)).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130838537));
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter = new NearbyProfileDisplayTribePanel.AvatarWallAdapter(this, this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager);
        this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
          break label203;
        }
      }
    }
    label203:
    for (Object localObject = "2";; localObject = "1")
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_head", 0, 0, (String)localObject, "", "", "");
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl)) {
        break;
      }
      localObject = new PicInfo();
      ((PicInfo)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bVideoHeadUrl;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayTribePanel$AvatarWallAdapter.a(localArrayList);
      break;
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setVisibility(8);
      break;
    }
  }
  
  public void k()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l == 640) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l == 0)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b)) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b, false);
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
    while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
    {
      Intent localIntent;
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, i1);
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
    localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c())));
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
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.c());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, new afkv(this), ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), "OidbSvc.0x66b");
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof DataTag)))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482E", "0X800482E", 0, 0, "", "", "", "");
      paramView = (DataTag)localObject1;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyProfileDisplayTribePanel", 2, "click  data.nType= [" + paramView.jdField_a_of_type_Int + "]");
      }
      switch (paramView.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      return;
      if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
      {
        paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
        if (!StringUtil.a(paramView.jdField_d_of_type_JavaLangString))
        {
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("portraitOnly", true);
          if (!StringUtil.a(paramView.jdField_d_of_type_JavaLangString)) {
            break label388;
          }
          paramView = "";
          label312:
          ((Intent)localObject1).putExtra("url", paramView);
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        label331:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CC", "0X80050CC", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        label388:
        paramView = paramView.jdField_d_of_type_JavaLangString;
        break label312;
        if ((paramView.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramView = (Object[])paramView.jdField_a_of_type_JavaLangObject;
          a(((Boolean)paramView[0]).booleanValue(), (String)paramView[1]);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CA", "0X80050CA ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
        {
          paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
          if (!StringUtil.a(paramView.jdField_d_of_type_JavaLangString)) {
            a(paramView.jdField_d_of_type_JavaLangString);
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CB", "0X80050CB ", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        Object localObject2;
        if ((paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry))
        {
          localObject1 = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
          if (!StringUtil.a(((ProfileBusiEntry)localObject1).jdField_d_of_type_JavaLangString))
          {
            localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", ((ProfileBusiEntry)localObject1).jdField_d_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("hide_operation_bar", true);
            ((Intent)localObject2).putExtra("hide_more_button", true);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject2);
          }
        }
        if (28 != paramView.jdField_a_of_type_Int) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CD", "0X80050CD", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if (!(paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
          continue;
        }
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, ShowExternalTroopListActivity.class);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.putExtra("isHost", bool);
          paramView.putExtra("dest_uin_str", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_g_of_type_JavaLangString, "1", "", "");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_g_of_type_JavaLangString, "0", "", "");
        return;
        if (!(paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
          continue;
        }
        paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString + "&_webviewtype=1");
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005102", "0X8005102", 0, 0, "", "", "", "");
        return;
        label1145:
        label1150:
        String str1;
        if (this.w)
        {
          paramView = "clk_followed";
          ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", paramView, 0, 0, "", "", "", "");
          ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(105)).d.put(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, Integer.valueOf(1));
          paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
          bool = NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j);
          if (!bool) {
            break label1207;
          }
          paramView = "1";
          if (!bool) {
            break label1228;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
          str1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          if (!this.w) {
            break label1241;
          }
        }
        label1207:
        label1228:
        label1241:
        for (localObject1 = "2";; localObject1 = "1")
        {
          NearbyHandler.a((QQAppInterface)localObject2, str1, paramView, (String)localObject1, 1, new afkf(this));
          return;
          paramView = "clk_follow";
          break;
          if (this.jdField_o_of_type_Boolean)
          {
            paramView = "6";
            break label1145;
          }
          paramView = "2";
          break label1145;
          if (this.jdField_o_of_type_Boolean) {
            break label1150;
          }
          break label1150;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname;
          ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, paramView, (String)localObject1, null, true, null, true, true, null, "from_internal");
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.nearby_people_card.", 2, "mCard == null , or mCard.uin is Empty, " + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean);
        return;
        if ((this.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby.tribeAppDownload", 2, "sendMsgBtnClick, isSendMsgBtnDownloadAppOpen=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isSendMsgBtnDownloadAppOpen + ", sendMsgBtnDownloadAppTips:" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isSendMsgBtnDownloadAppOpen) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl))) {
            NearbyCardManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.sendMsgBtnDownloadAppTips, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tribeAppDownloadPageUrl, 1);
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "msg_fail", 0, 0, "", "", "", "");
            return;
            if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_c_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
            }
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "msg_suc", 0, 0, "", "", "", "");
        this.jdField_d_of_type_Boolean = true;
        l();
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_msg", 0, 0, "", "", "", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin != null)) {}
        for (paramView = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;; paramView = "")
        {
          ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8004826", "0X8004826", i1, 0, paramView, "", "", "");
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 75) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 76)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004944", "0X8004944", 0, 0, "", "", "", "");
          }
          NearbyPeopleProfileActivity.m = 0;
          if (!ProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800523D", "0X800523D", 0, 0, "", "", "", "");
          return;
        }
        if (!ProfileActivity.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005CAA", "0X8005CAA", 0, 0, "", "", "", "");
        return;
        d(false);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app == null) {
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528B", "0X800528B", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_n_of_type_Boolean)
        {
          DatingUtil.c("nearbyprofilecard", new Object[] { "have click sayhello, wating for resp" });
          return;
        }
        paramView = (NearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(60);
        if (paramView == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_n_of_type_Boolean = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 17) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 18) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 19))
        {
          i1 = 8;
          label2128:
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag == 1) {
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label2215;
            }
          }
        }
        label2215:
        for (int i2 = 1;; i2 = 2)
        {
          i2 = i1 | i2;
          paramView.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), i2, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(204, 1000L);
          return;
          i1 = 4;
          break label2128;
        }
        if (!(paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80055CA", "0X80055CA", 0, 0, "", "", "", "");
        paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        return;
        if (!(paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005D14", "0X8005D14", 0, 0, "", "", "", "");
        paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        return;
        if (!(paramView.jdField_a_of_type_JavaLangObject instanceof ProfileBusiEntry)) {
          continue;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "0X8006E05", "0X8006E05", 1, 0, new String[0]);
        paramView = (ProfileBusiEntry)paramView.jdField_a_of_type_JavaLangObject;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView.jdField_d_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
          continue;
        }
        if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131433023, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131558448));
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
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131438120);
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(3);
          this.jdField_a_of_type_Int = 2;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_pause", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          return;
        }
        if (NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          if (this.jdField_m_of_type_Boolean)
          {
            DialogUtil.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131438114), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131438115), 0, 2131438119, new afkg(this), null).show();
            this.jdField_m_of_type_Boolean = false;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(2);
            if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 0)) {
              break;
            }
            this.jdField_a_of_type_Int = 1;
            return;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          }
        }
        if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 0))
        {
          DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131438114), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131438116), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener).show();
          this.jdField_a_of_type_Int = 1;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(2);
        return;
        if (paramView == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView)
        {
          if (2 == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "clk_list", 0, 0, "", "", "", "");
            if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
            {
              paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, VisitorsActivity.class);
              if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
              {
                i1 = 0;
                localObject1 = new Bundle();
                ((Bundle)localObject1).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin()).longValue());
                ((Bundle)localObject1).putLong("totalVoters", i1);
                ((Bundle)localObject1).putBoolean("isStartedByProfileCard", true);
                ((Bundle)localObject1).putBoolean("votersOnly", true);
                if (i1 <= 0) {
                  break label3432;
                }
              }
              label3432:
              for (bool = true;; bool = false)
              {
                ((Bundle)localObject1).putBoolean("hasVoters", bool);
                ((Bundle)localObject1).putBoolean("extra_show_rank", true);
                ((Bundle)localObject1).putInt("frome_where", 4);
                paramView.putExtras((Bundle)localObject1);
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
                NearbyProxy.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCountInc = 0;
                  h();
                  this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(new afkh(this));
                }
                if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
                  this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.jdField_b_of_type_Boolean = true;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("IS_NEARBY_REDDOT_INCOME", false)) {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005249", "0X8005249", 0, 0, "", "", "", "");
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800657A", "0X800657A", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
                localObject1 = "2";
                paramView = (View)localObject1;
                if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a != null)
                {
                  paramView = (View)localObject1;
                  if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.a.getVisibility() == 0) {
                    paramView = "1";
                  }
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00898", "", "", "0X8007610", "0X8007610", 2, 0, paramView, "", "", "");
                return;
                i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.likeCount;
                break;
              }
            }
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            if (d() == 10002) {}
            for (paramView = "6";; paramView = "1")
            {
              ((Intent)localObject1).putExtra("url", this.jdField_f_of_type_JavaLangString + "&SOURCETYPE=" + paramView + "&SIGN=" + a() + "&UIN=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getCurrentAccountUin());
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
              break;
            }
          }
          if (3 != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int) {
            continue;
          }
          this.jdField_b_of_type_Boolean = true;
          localObject1 = new HashMap();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131435803));
            ((HashMap)localObject1).put("param_FailCode", "-210");
            StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("NearbyProfileDisplayTribePanel", 2, "mCard is null,vote failed !");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyProfileDisplayTribePanel", 2, "Click Vote View, mCard.bAvailVoteCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ",mCard.bHaveVotedCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt + ",mCard.strVoteLimitedNotice = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strVoteLimitedNotice);
          }
          label3757:
          label3779:
          int i3;
          label3884:
          label4028:
          String str2;
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt <= 0)
          {
            i1 = 1;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt > 0) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt > 0)) {
              break label4254;
            }
            i2 = 1;
            if (QLog.isColorLevel()) {
              QLog.d("NearbyLikeLimitManager", 2, "Profile->onClickVote, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + ", isFriend=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean + ", bAvailVoteCnt=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ", bHaveVotedCnt=" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt);
            }
            if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
              break label4259;
            }
            i3 = 510;
            if ((i1 != 0) || (i2 != 0)) {
              break label4435;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler == null) || (!NetworkUtil.d(BaseApplication.getContext()))) {
              break label4280;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
              break label4267;
            }
            ((NearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(206)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, new afki(this), i3 + "");
            label3986:
            str1 = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
              break label4412;
            }
            paramView = "2";
            str2 = i3 + "";
            if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
              break label4419;
            }
            localObject1 = "1";
            label4065:
            if (!this.jdField_u_of_type_Boolean) {
              break label4427;
            }
          }
          label4254:
          label4259:
          label4267:
          label4280:
          label4412:
          label4419:
          label4427:
          for (localObject2 = "2";; localObject2 = "1")
          {
            ReportController.b(null, "dc00899", "grp_lbs", str1, "data_card", "like_head", 0, 0, paramView, str2, (String)localObject1, (String)localObject2);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004825", "0X8004825", c(), 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "", "");
            if (ProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005241", "0X8005241", 0, 0, "", "", "", "");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) {
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
              break label4751;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528C", "0X800528C", 1, 0, "", "", "", "");
            return;
            i1 = 0;
            break label3757;
            i2 = 0;
            break label3779;
            i3 = 509;
            break label3884;
            c(true);
            this.jdField_u_of_type_Boolean = true;
            break label3986;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler != null)
            {
              ((HashMap)localObject1).put("param_FailCode", "-203");
              StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131435782));
              break label3986;
            }
            ((HashMap)localObject1).put("param_FailCode", "-204");
            StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131435803));
            break label3986;
            paramView = "1";
            break label4028;
            localObject1 = "2";
            break label4065;
          }
          label4435:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0)
          {
            paramView = "他";
            label4449:
            if (!this.jdField_s_of_type_Boolean)
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
                break label4634;
              }
              paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, "已经达到今日点赞上限~", "", "确定", new afkj(this), null);
              paramView.show();
              this.jdField_s_of_type_Boolean = true;
              paramView.setOnDismissListener(new afkm(this));
            }
            ReportController.b(null, "dc00899", "grp_lbs", "", "data_like", "exp_toast", 0, 0, "", "", "", "");
            if (i2 == 0) {
              break label4697;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006579", "0X8006579", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), "", "", "");
          }
          for (;;)
          {
            label4495:
            StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            break;
            paramView = "她";
            break label4449;
            label4634:
            paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, "点赞还不够，送个礼物给" + paramView + "吧！", "取消", "送礼物", new afkk(this), new afkl(this));
            break label4495;
            label4697:
            if (i1 != 0) {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006578", "0X8006578", 2, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), "", "", "");
            }
          }
          label4751:
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800528D", "0X800528D", 1, 0, "", "", "", "");
          return;
        }
        if (paramView == this.jdField_a_of_type_ComTencentWidgetCustomImgView)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
          {
            paramView = (Boolean)paramView.getTag();
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(100L);
            if ((paramView != null) && (!paramView.booleanValue())) {
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new afkn(this), 300L);
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050C9", "0X80050C9", 0, 0, "", "", "", "");
          }
          while (ProfileActivity.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8005240", "0X8005240", 0, 0, "", "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
            {
              localObject1 = new PicInfo();
              ((PicInfo)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(32, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin), 200);
              if (QLog.isColorLevel()) {
                QLog.e("Q.nearby_people_card.", 2, "on mode guest small head clicked: uin is: " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin + " local path is: " + ((PicInfo)localObject1).jdField_c_of_type_JavaLangString);
              }
              paramView = AnimationUtils.a(paramView);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a((PicInfo)localObject1, paramView);
            }
          }
        }
        if (paramView == this.jdField_j_of_type_AndroidWidgetRelativeLayout)
        {
          this.jdField_i_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
          {
            paramView = NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            paramView = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747" + "&strangerUin=" + paramView;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
              break label5326;
            }
            localObject1 = "2";
            label5151:
            ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_rank", 0, 0, (String)localObject1, "", "", "");
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
              break label5334;
            }
          }
          label5326:
          label5334:
          for (localObject1 = "2";; localObject1 = "1")
          {
            ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_rank", 0, 0, (String)localObject1, "", "", "");
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
              break label5342;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052AC", "0X80052AC", 0, 0, "", "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {
              this.jdField_a_of_type_Boolean = true;
            }
            paramView = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747";
            break;
            localObject1 = "1";
            break label5151;
          }
          label5342:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80052AD", "0X80052AD", 0, 0, "", "", "", "");
          return;
        }
        if (paramView == this.jdField_f_of_type_AndroidWidgetImageView)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin();
          if ((!Friends.isValidUin(paramView)) || (!Friends.isValidUin(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin))) {
            continue;
          }
          bool = paramView.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin);
          if (bool)
          {
            i1 = 0;
            if (!bool) {
              break label5524;
            }
          }
          for (;;)
          {
            paramView = String.format("http://ti.qq.com/paihangbanggl/index.html?_wv=1027&isguest=%d&uin=%s", new Object[] { Integer.valueOf(i1), paramView });
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("portraitOnly", true);
            ((Intent)localObject1).putExtra("url", paramView);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
            return;
            i1 = 1;
            break;
            label5524:
            paramView = "";
          }
        }
        if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "clk_edit", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_i_of_type_Int == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b();
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(300L);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004B38", "0X8004B38", 0, 0, "", "", "", "");
          return;
        }
        if (paramView == this.jdField_c_of_type_AndroidWidgetRelativeLayout)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Long <= 0L)
          {
            paramView = (NearbyFaceScoreManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getManager(203);
            long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_d_of_type_JavaLangString);
            paramView.a(l1, new afkp(this, l1));
            return;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Long);
          return;
        }
        if ((paramView == this.jdField_h_of_type_AndroidWidgetLinearLayout) || (paramView != this.jdField_i_of_type_AndroidWidgetLinearLayout)) {
          continue;
        }
        return;
      }
      catch (SecurityException paramView)
      {
        break label331;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel
 * JD-Core Version:    0.7.0.1
 */