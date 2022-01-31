package com.tencent.mobileqq.nearby.profilecard;

import afdi;
import afdj;
import afdm;
import afdn;
import afdp;
import afdq;
import afdr;
import afds;
import afdt;
import afdu;
import afdv;
import afdw;
import afdx;
import afdy;
import afdz;
import afea;
import afeb;
import afec;
import afed;
import afee;
import afef;
import afeg;
import afeh;
import afei;
import afej;
import afek;
import afel;
import afem;
import afen;
import afeo;
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
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
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
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.ViewHolder;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.nearby.widget.NearbyFacePowerDialog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
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
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.GridView;
import com.tencent.widget.ScrollView;
import com.tencent.widget.ScrollView.OnScrollStateChangedListener;
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
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NowAnchorState;

public class NearbyProfileDisplayPanel
  extends NearbyProfileDisplayBasePanel
  implements View.OnClickListener, OnTagClickListener, FaceDecoder.DecodeTaskCompletionListener, TabBarView.OnTabChangeListener, ScrollView.OnScrollStateChangedListener
{
  public static String[] a;
  public static String[] b;
  public int a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new afee(this);
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new afdi(this);
  public Handler a;
  public FragmentManager a;
  ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new afek(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afeb(this);
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new afej(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  protected LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NewVoteAnimHelper jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private NearbyCardVoteView jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView;
  public NearbyPeopleProfileActivity a;
  private NearbyProfileDisplayPanel.AvatarWallAdapter jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$AvatarWallAdapter;
  protected NearbyProfileFragment a;
  private NestScrollLayout jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout;
  protected ProfileNowVideoCtrl a;
  public ProfileQiqiLiveController a;
  public NearbyMomentFragment a;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager;
  protected ProfileBusiEntry a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  protected NestViewPager a;
  public ProgressButton a;
  public TabBarView a;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new afef(this);
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  String jdField_a_of_type_JavaLangString = "";
  protected ArrayList a;
  private List jdField_a_of_type_JavaUtilList;
  protected final Map a;
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
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  public boolean d;
  int jdField_e_of_type_Int = -1;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  protected String e;
  public boolean e;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  boolean l = true;
  public boolean m = true;
  boolean n = false;
  public boolean o = false;
  boolean p = false;
  boolean q = false;
  public boolean r = false;
  boolean s = false;
  public boolean t = true;
  private boolean u;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0X800553B", "0X800553C", "0X800553D", "0X800553E", "0X800553F", "0X8005540", "0X8005541" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "0X8005542", "0X8005543", "0X8005544", "0X8005545", "0X8005546", "0X8005547", "0X8005548" };
  }
  
  public NearbyProfileDisplayPanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new afed(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (paramNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) == 35) {}
    for (;;)
    {
      this.o = bool;
      this.n = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_werewolves", false);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramNearbyPeopleProfileActivity.app);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
      return;
      bool = false;
    }
  }
  
  private TextView a(int paramInt, String paramString)
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
    ((GradientDrawable)localObject).setColor(paramInt);
    ((GradientDrawable)localObject).setCornerRadius(i3);
    localTextView.setBackgroundDrawable((Drawable)localObject);
    localTextView.setTextColor(Color.parseColor("#FFFFFFFF"));
    localTextView.setText(paramString);
    localTextView.setPadding(i1, 0, i1, 0);
    localTextView.setGravity(17);
    return localTextView;
  }
  
  private GridView a(List paramList, int paramInt)
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
  
  private void a(CustomImgView paramCustomImgView)
  {
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = paramCustomImgView;
    paramCustomImgView = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 200, (byte)1);
    if (paramCustomImgView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842987));
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, 200, false, 1, true, (byte)0, 1);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageBitmap(paramCustomImgView);
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131437711);
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
    Object localObject;
    label184:
    Button localButton;
    do
    {
      return;
      i1 = 2131437964;
      break;
      i1 = 2131437718;
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_gift", 0, 0, "", "", "", "");
      break;
      if (this.u)
      {
        i1 = 2131430515;
        if (!this.u) {
          break label184;
        }
      }
      for (localObject = "exp_followed";; localObject = "exp_follow")
      {
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", (String)localObject, 0, 0, "", "", "", "");
        break;
        i1 = 2131430513;
        break label135;
      }
      i1 = 2131433647;
      localObject = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1).findViewById(2131365251);
      ((Button)localObject).setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131494236));
      ((Button)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842852));
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_msg", 0, 0, "", "", "", "");
      break;
      i1 = 2131435796;
      break;
      i1 = 2131437442;
      break;
      i1 = 2131438093;
      break;
      localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
      ((View)localObject).setVisibility(0);
      if (paramInt2 == 40) {
        break label543;
      }
      localButton = (Button)((View)localObject).findViewById(2131365251);
      localButton.setText(i1);
      if (paramInt2 == 38)
      {
        localButton.setBackgroundResource(2130845825);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131493196));
      }
      localButton.setOnClickListener(this);
      DataTag localDataTag = new DataTag(paramInt2, null);
      localButton.setTag(localDataTag);
      ((View)localObject).setTag(localDataTag);
      if ((paramInt2 == 60) && (this.u))
      {
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131494238));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130838525));
        return;
      }
      if ((paramInt2 == 8) && (this.p) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
      {
        localButton.setBackgroundResource(2130845825);
        localButton.setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
    } while ((paramInt2 != 36) || (!this.q) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean));
    localButton.setBackgroundResource(2130845825);
    localButton.setTextColor(Color.parseColor("#BBBBBB"));
    return;
    label543:
    ((View)localObject).setVisibility(8);
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
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender;
    Object localObject2;
    if ((i1 == 0) || (i1 == 1))
    {
      localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject1).setImageResource(NearbyProfileUtil.a(i1));
      i1 = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 14.0F);
      localObject2 = new LinearLayout.LayoutParams(i1, i1);
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 2.0F), 0);
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age > 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(Color.parseColor("#ff9cc4f7"), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age + "岁"));
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
      {
        localObject1 = "1";
        ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_info", 0, 0, (String)localObject1, "", "", "");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel >= 1) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(Color.parseColor("#FEDA96"), "LV" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.charmLevel));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation >= 1) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation <= 12))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(Color.parseColor("#ffbfa4f6"), NearbyProfileUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation)));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label459;
        }
        localObject1 = "1";
        label323:
        ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_xing", 0, 0, (String)localObject1, "", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus >= 2) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus <= 5))
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(Color.parseColor("#ff89e1b5"), NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1)));
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
          break label466;
        }
      }
    }
    label459:
    label466:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_relation", 0, 0, (String)localObject1, "", "", "");
      return;
      localObject1 = "2";
      break;
      localObject1 = "2";
      break label323;
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new afdm(this));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new afdn(this));
  }
  
  private void r()
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
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, false);
  }
  
  private void t()
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
    return 2130970468;
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
    ((ImageView)localObject1).setBackgroundResource(2130839448);
    ((ImageView)localObject1).setImageResource(2130843103);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setVisibility(8);
    int i1 = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 24.0F);
    Object localObject2 = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.addView((View)localObject1);
    localCustomImgView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842443));
    localCustomImgView.setTag(paramPicInfo);
    localCustomImgView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.jdField_b_of_type_Boolean) {
      localRelativeLayout.setContentDescription("图片" + paramInt);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842987);
    try
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o) || (TextUtils.isEmpty(paramPicInfo.jdField_d_of_type_JavaLangString))) {
        break label521;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramPicInfo.jdField_d_of_type_JavaLangString, localRelativeLayout);
      if (DynamicAvatarDownloadManager.b(paramPicInfo.jdField_d_of_type_JavaLangString))
      {
        localRelativeLayout.getChildAt(1).setVisibility(8);
        a(paramPicInfo, localRelativeLayout);
        return localRelativeLayout;
      }
      if (!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity)) {
        break label508;
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
        label508:
        localRelativeLayout.getChildAt(1).setVisibility(0);
        continue;
        label521:
        localRelativeLayout.getChildAt(1).setVisibility(8);
      }
      if (StringUtil.a(paramPicInfo.jdField_a_of_type_JavaLangString)) {
        break label629;
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
      return localRelativeLayout;
      label629:
      if (paramPicInfo.g != "type_qq_head_pic") {
        break label645;
      }
      a(localCustomImgView);
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
    label645:
    return localRelativeLayout;
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
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$AvatarWallAdapter != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel$AvatarWallAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList);
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
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370709));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370710));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370708));
    paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources();
    this.jdField_b_of_type_Int = paramView.getDimensionPixelSize(2131559280);
    this.jdField_c_of_type_Int = paramView.getDimensionPixelSize(2131559281);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370721));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView = ((NearbyCardVoteView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370536));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setIsTribe(false);
    if (this.o) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = ((HeartLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370077));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout = ((NestScrollLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370705));
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370716);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363245));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370723));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363060));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370727);
    paramView = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370728);
    ImageView localImageView1 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370729);
    ImageView localImageView2 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131368333);
    afdv localafdv = new afdv(this, paramView, localImageView1, localImageView2);
    paramView.setOnClickListener(localafdv);
    localImageView1.setOnClickListener(localafdv);
    localImageView2.setOnClickListener(localafdv);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, false, null))
    {
      paramView.setImageResource(2130842883);
      localImageView1.setImageResource(2130842885);
      localImageView2.setImageResource(2130842881);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(0);
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370731));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131370732));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370733));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager = ((AvatarWallViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131370706));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370718));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370713));
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370711);
    this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370715);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370714));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370719));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370720));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131369708).setBackgroundResource(2130842847);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131432414);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new afeg(this));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyCardVoteView.setAppInterface(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager = ((NestViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131362804));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getSupportFragmentManager();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment = new NearbyMomentFragment();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment = new NearbyProfileFragment();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363113));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846411));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setEnableRepeatedClick(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabTextSize(16);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectColor(Color.parseColor("#333333"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(Color.parseColor("#777777"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineHeight(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineMargin(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 44.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabHeight(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 45.0F));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNestScrollLayout.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager);
    paramView = new LinearLayout.LayoutParams(0, -1);
    paramView.gravity = 17;
    paramView.weight = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabLayoutParams(paramView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, "动态", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, "资料", true);
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) {
      i1 = NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
    }
    for (;;)
    {
      if (i1 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      }
      for (;;)
      {
        if (i1 == -1) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, false);
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a(new afei(this, i1));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131365207));
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
          break label1174;
        }
        i1 = NearbyDataManager.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
        break;
        if (i1 == 1) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, false);
        }
      }
      label1174:
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
      ThreadManager.post(new afec(this, paramInt), 5, null, false);
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
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3))
      {
        if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
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
      label1167:
      label1430:
      try
      {
        this.jdField_d_of_type_JavaLangString = new JSONObject(paramNearbyPeopleCard).getString("ownerLikeJumpURL");
        if (!this.s) {
          this.s = true;
        }
        m();
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        String str = "" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)
        {
          paramNearbyPeopleCard = "1";
          ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", str, "data_card", "exp", 0, 0, paramNearbyPeopleCard, "" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j % 20, "", "");
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.getAdapter() == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setAdapter(new afeo(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentManager, this.jdField_a_of_type_JavaUtilArrayList));
            i1 = -1;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
              break label1078;
            }
            i1 = NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
            if (i1 != 0) {
              break label1103;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(0, false);
            if (i1 == -1) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(1, false);
            }
          }
          if (!NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.j)) {
            break label1120;
          }
          this.p = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsgForTribar;
          this.q = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsgForTribar;
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTipsForTribar;
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTipsForTribar;
          this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.highScoreNum;
          a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyInfo);
          q();
          p();
          h();
          if ((!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isAuthUser()) && (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isFuXiaoJin())) {
            break label1167;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839455);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.iIsGodFlag != 1) {
            break label1192;
          }
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
            break label1179;
          }
          this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130843139);
          ThreadManager.post(new afdj(this), 8, null, true);
          if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 31) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.q)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 2)) {
            break label1204;
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.q + "·" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + "前·");
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          if (QLog.isColorLevel()) {
            QLog.d("Q.hotChatDistance", 2, "bindData, use aioDistance");
          }
          if (QLog.isColorLevel()) {
            QLog.d("NearbyProfileDisplayPanel", 2, "bindData, mCard.videoInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
            break label1406;
          }
          if (((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.lUserFlag & 0x800) == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.equals(""))) {
            break label1382;
          }
          paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strRemark.trim();
          ((TextView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131370722)).setText(paramNearbyPeopleCard);
          r();
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
            break label1463;
          }
          if (!this.o) {
            break label1430;
          }
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_face_score").e(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).a();
          j();
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a() != 0) {
            break label1506;
          }
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (!NearbyDataManager.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)) {
            break label1496;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_post_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1) }).a();
          new NowVideoReporter().h("data_card").i("shoot_exp").d("2").b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
          return;
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int = 3;
        }
      }
      catch (JSONException paramNearbyPeopleCard)
      {
        label1179:
        label1192:
        label1204:
        for (;;)
        {
          int i1;
          paramNearbyPeopleCard.printStackTrace();
          continue;
          paramNearbyPeopleCard = "2";
          continue;
          label1078:
          label1463:
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
          {
            i1 = NearbyDataManager.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
            continue;
            label1103:
            if (i1 == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(1, false);
              continue;
              label1120:
              this.p = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendMsg;
              this.q = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.isForbidSendGiftMsg;
              this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendMsgBtnTips;
              this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.disableSendGiftBtnTips;
              continue;
              this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
              continue;
              this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130843138);
              continue;
              this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              continue;
              if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2))
              {
                this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.aioDistanceAndTime + "前·");
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              else if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff)))
              {
                this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.distance + "·" + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.timeDiff + "前·");
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
                continue;
                label1382:
                if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname != null)
                {
                  paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
                  continue;
                  label1406:
                  if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname != null)
                  {
                    paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname.trim();
                    continue;
                    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
                    i();
                    continue;
                    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
                    n();
                    continue;
                    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                    return;
                    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                    return;
                  }
                }
                label1496:
                label1506:
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
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130846443);
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
  
  public void a(ScrollView paramScrollView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileNowVideoCtrl != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileNowVideoCtrl.a(paramScrollView, paramInt);
    }
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
        localViewHolder = (AvatarWallPagerAdapter.ViewHolder)paramString.getTag(2131362438);
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
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileFragment.b(paramBoolean);
    }
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
      this.jdField_e_of_type_JavaLangString = paramList.troopUin;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = new ProfileBusiEntry();
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_Int = 1024;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131430394);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_c_of_type_JavaLangString = paramList.troopName;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = paramList.strFaceUrl;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_c_of_type_JavaLangString == null));
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
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
        str = "http://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, GameCenterActivity.class);
      paramString.putExtra("url", HtmlOffline.a(str, "plat=qq&tt=1&_wv=3&qappid=" + AppSetting.jdField_a_of_type_Int + "&osv=" + Build.VERSION.RELEASE + "&vuin=" + NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString) + "&vname=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString + "&bn=" + paramBoolean));
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().i(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ArrayOfByte);
        this.u = ((nearby.Cmd0x1RspBody)localObject).bool_follow.get();
        if (((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_msg.get() != 1) {
          break label393;
        }
        bool1 = true;
        this.p = bool1;
        if (((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_gift.get() != 1) {
          break label399;
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
        this.jdField_b_of_type_AndroidViewView.findViewById(2131370707).setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText("关注" + i1);
        this.jdField_f_of_type_AndroidWidgetTextView.setText("粉丝" + i2);
        if (!TextUtils.isEmpty(paramArrayOfByte)) {
          this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new afel(this, paramArrayOfByte));
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(new afem(this, (String)localObject));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("NearbyProfileDisplayPanel", 2, "Cmd0x1RspBody error !:" + paramArrayOfByte);
      return;
      label393:
      boolean bool1 = false;
      continue;
      label399:
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p = true;
      b(paramBoolean);
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
  }
  
  public void d(boolean paramBoolean)
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131435442));
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
      t();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
  }
  
  public void h()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowLikeBtn()) && (!this.o))
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
      if (!this.n)
      {
        b(2, 8);
        if ((this.u) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() == 0)) {
          break label391;
        }
        localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131365251);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131494236));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842852));
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).getVisibility() != 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).getVisibility() != 0))
      {
        localButton = (Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(0).findViewById(2131365251);
        localButton.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131494236));
        localButton.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130842852));
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
        b(1, 60);
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.shouldShowSendMsg()) && (!this.n)) {
          b(2, 8);
        } else {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
        }
      }
      label391:
      ((Button)this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(1).findViewById(2131365251)).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130838525));
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
      localObject1 = new NearbyProfileDisplayPanel.AvatarViewPagerAdatper(this, this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setAdapter((AvatarWallPagerAdapter)localObject1);
      localObject2 = new ArrayList();
      this.jdField_f_of_type_Int = ((int)Math.ceil(this.jdField_a_of_type_JavaUtilList.size() / 6.0F));
      int i1 = 0;
      while (i1 < this.jdField_f_of_type_Int)
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
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int == 3)
    {
      localObject1 = "2";
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_head", 0, 0, (String)localObject1, "", "", "");
      localObject1 = (LinearLayout.LayoutParams)((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369940)).getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.getLayoutParams();
      if (localObject1 != null)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() <= 3) {
          break label376;
        }
        ((LinearLayout.LayoutParams)localObject1).height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3 * 2);
      }
    }
    for (((RelativeLayout.LayoutParams)localObject2).height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3 * 2);; ((RelativeLayout.LayoutParams)localObject2).height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3))
    {
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 4.0F);
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetAvatarWallViewPager.setDotLayoutParams((RelativeLayout.LayoutParams)localObject1);
      return;
      localObject1 = "1";
      break;
      label376:
      ((LinearLayout.LayoutParams)localObject1).height = (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels / 3);
    }
  }
  
  public void k()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l == 640) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l == 0)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_h_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.l, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_b_of_type_JavaLangString, false);
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
  
  public void m()
  {
    this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_e_of_type_AndroidViewView.getResources().getDrawable(2130842834));
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.bytes_live_url.get().toStringUtf8();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_level.get();
    if (i1 > 0)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      int i2 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.now_anchor_state.uint32_live_status.get();
      String str2 = i1 + "";
      SpannableString localSpannableString = new SpannableString("直播等级 " + str2 + " 级");
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 5, str2.length() + 5, 33);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localSpannableString);
      if (i2 == 1)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("正在直播");
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1610612736);
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(new afen(this, str1));
      }
    }
    else
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText("未直播");
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1610612736);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
  }
  
  void n()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void o()
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131433009, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131558448));
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 0, "开始下载", 0).a();
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", "now.apk");
    UniformDownloadMgr.a().a("http://dldir1.qq.com/huayang/Now/now_52227.apk", localBundle, new afeh(this));
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof DataTag)))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800482E", "0X800482E", 0, 0, "", "", "", "");
      paramView = (DataTag)localObject1;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyProfileDisplayPanel", 2, "click  data.nType= [" + paramView.jdField_a_of_type_Int + "]");
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
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_e_of_type_JavaLangString, "1", "", "");
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_e_of_type_Int != 3) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.jdField_e_of_type_JavaLangString, "0", "", "");
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
        if (this.u)
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
          if (!this.u) {
            break label1241;
          }
        }
        label1207:
        label1228:
        label1241:
        for (localObject1 = "2";; localObject1 = "1")
        {
          NearbyHandler.a((QQAppInterface)localObject2, str1, paramView, (String)localObject1, 1, new afdp(this));
          return;
          paramView = "clk_follow";
          break;
          if (this.n)
          {
            paramView = "6";
            break label1145;
          }
          paramView = "2";
          break label1145;
          if (this.n) {
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
        if ((this.p) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean))
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
            if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_JavaLangString, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
            }
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "msg_suc", 0, 0, "", "", "", "");
        this.jdField_d_of_type_Boolean = true;
        l();
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_msg", 0, 0, "", "", "", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
        i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int;
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
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.n)
        {
          DatingUtil.c("nearbyprofilecard", new Object[] { "have click sayhello, wating for resp" });
          return;
        }
        paramView = (NearbyCardHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(60);
        if (paramView == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.n = true;
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
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131433009, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDimensionPixelSize(2131558448));
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
            this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(2131438100);
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileQiqiLiveController.a(3);
          this.jdField_a_of_type_Int = 2;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_pause", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "", "yes", "android");
          return;
        }
        if (NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity))
        {
          if (this.l)
          {
            DialogUtil.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131438094), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131438095), 0, 2131438099, new afdq(this), null).show();
            this.l = false;
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
          DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131438094), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131438096), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener).show();
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
            if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
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
                  this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(new afdr(this));
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
              ((Intent)localObject1).putExtra("url", this.jdField_d_of_type_JavaLangString + "&SOURCETYPE=" + paramView + "&SIGN=" + a() + "&UIN=" + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getAppInterface().getCurrentAccountUin());
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
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131435787));
            ((HashMap)localObject1).put("param_FailCode", "-210");
            StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("NearbyProfileDisplayPanel", 2, "mCard is null,vote failed !");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyProfileDisplayPanel", 2, "Click Vote View, mCard.bAvailVoteCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bAvailVoteCnt + ",mCard.bHaveVotedCnt = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.bHaveVotedCnt + ",mCard.strVoteLimitedNotice = " + this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.strVoteLimitedNotice);
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
            ((NearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(206)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, new afds(this), i3 + "");
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
            if (!this.t) {
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
            this.t = true;
            break label3986;
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler != null)
            {
              ((HashMap)localObject1).put("param_FailCode", "-203");
              StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
              this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131435766));
              break label3986;
            }
            ((HashMap)localObject1).put("param_FailCode", "-204");
            StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131435787));
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
            if (!this.r)
            {
              if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_g_of_type_Boolean) {
                break label4634;
              }
              paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, "已经达到今日点赞上限~", "", "确定", new afdt(this), null);
              paramView.show();
              this.r = true;
              paramView.setOnDismissListener(new afdx(this));
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
            paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 230, null, "点赞还不够，送个礼物给" + paramView + "吧！", "取消", "送礼物", new afdu(this), new afdw(this));
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
        if (paramView == this.jdField_d_of_type_AndroidWidgetImageView)
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
              break label4933;
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
            label4933:
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
        if (paramView != this.jdField_a_of_type_AndroidWidgetImageView) {
          continue;
        }
        paramView = "";
        if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get() != null))
        {
          i1 = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).uint32_state.get();
          paramView = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).bytes_jump_url.get().toStringUtf8();
          if (i1 == 1)
          {
            paramView = (NowProxy)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(181);
            if (paramView.a())
            {
              paramView.a();
              i1 = 1;
            }
          }
          for (;;)
          {
            new NowVideoReporter().h("data_card").i("shoot_clk").d("2").b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app);
            new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_post_click").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1), "" + i1 }).a();
            return;
            paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "安装NOW客户端，发表附近动态，享受更多滤镜效果", 0, 0, null, null);
            new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_download_view").a(new String[] { "", "" + (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1) }).a();
            paramView.setPositiveButton("立即安装", new afdy(this));
            paramView.setNegativeButton("取消", new afdz(this, paramView));
            paramView.show();
            i1 = 2;
            continue;
            i1 = 3;
            localObject1 = new NearbyFacePowerDialog(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
            ((NearbyFacePowerDialog)localObject1).a(new afea(this, paramView, (NearbyFacePowerDialog)localObject1));
            ((NearbyFacePowerDialog)localObject1).show();
          }
        }
      }
      catch (SecurityException paramView)
      {
        for (;;)
        {
          continue;
          int i1 = 0;
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) && (this.jdField_a_of_type_ComTencentWidgetCustomImgView != null)) {
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageBitmap(paramBitmap);
    }
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqWidgetNestViewPager.setCurrentItem(paramInt2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel
 * JD-Core Version:    0.7.0.1
 */