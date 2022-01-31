package com.tencent.mobileqq.emoticonview;

import actn;
import aega;
import ajsf;
import ajtj;
import ajvp;
import ajwb;
import ajyc;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anrs;
import anrz;
import anss;
import anta;
import antu;
import anvr;
import anvs;
import anwe;
import anwf;
import anwj;
import anxd;
import anxx;
import anyb;
import anyg;
import anyh;
import anyi;
import anyj;
import anyk;
import anyl;
import anym;
import anyn;
import anyo;
import anyp;
import anyq;
import anyr;
import anyu;
import anyv;
import anyw;
import anyx;
import anyy;
import anyz;
import anza;
import anze;
import anzj;
import anzk;
import anzm;
import aoak;
import aoal;
import aoan;
import aoap;
import aoci;
import aocn;
import aqyd;
import askd;
import avpq;
import axqw;
import bbcv;
import bbev;
import bbgg;
import bbjv;
import bbjw;
import bbkv;
import bfob;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class EmoticonMainPanel
  extends RelativeLayout
  implements aega, ViewPager.OnPageChangeListener, View.OnClickListener, anwe, aoal
{
  public static long a;
  public static int c;
  public static int e = 3;
  public static boolean g;
  protected static int i;
  static boolean jdField_m_of_type_Boolean;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  ajtj jdField_a_of_type_Ajtj = new anym(this);
  ajwb jdField_a_of_type_Ajwb = new anyn(this);
  public Context a;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new anyi(this);
  View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new anyk(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public anta<CustomEmotionData> a;
  anwf jdField_a_of_type_Anwf = new anyj(this);
  anyb jdField_a_of_type_Anyb;
  private anyg jdField_a_of_type_Anyg;
  private anyz jdField_a_of_type_Anyz;
  anzj jdField_a_of_type_Anzj;
  private aoci jdField_a_of_type_Aoci;
  public aqyd a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public QQAppInterface a;
  public EmotionPanelViewPagerAdapter a;
  public HorizontalListViewEx a;
  public QQViewPager a;
  Runnable jdField_a_of_type_JavaLangRunnable = new EmoticonMainPanel.18(this);
  public List<aoak> a;
  public boolean a;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  public volatile long b;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public List<EmoticonPackage> b;
  public boolean b;
  ImageView c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  public boolean d;
  public boolean e;
  int f;
  public boolean f;
  int g;
  public int h;
  public boolean h;
  boolean i;
  int j;
  public boolean j;
  int k;
  public boolean k;
  private int jdField_l_of_type_Int;
  boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  public volatile boolean n = false;
  public boolean o;
  public boolean p;
  public boolean q;
  private boolean r;
  private boolean s;
  
  static
  {
    jdField_c_of_type_Int = -1;
    jdField_g_of_type_Boolean = true;
    jdField_m_of_type_Boolean = true;
  }
  
  public EmoticonMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aqyd = new aqyd("emoticon_panel", "com.tencent.mobileqq:tool");
    this.jdField_h_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Anta = new anyq(this);
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int i1;
    if ((localObject != null) && (paramInt >= 0))
    {
      i1 = paramInt;
      if (paramInt < ((List)localObject).size()) {}
    }
    else
    {
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "switchTabMode selectIndex = " + i1);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0);
    if (localSharedPreferences.getBoolean("force_to_recommend_panel_sp", false)) {
      if ((localObject == null) || ((((List)localObject).size() > e) && (((aoak)((List)localObject).get(e)).jdField_a_of_type_Int == 8)))
      {
        jdField_c_of_type_Int = e;
        i1 = e;
        localSharedPreferences.edit().putBoolean("force_to_recommend_panel_sp", false).apply();
        label166:
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "switchTabMode after recommend calculate, selectIndex = " + i1);
        }
        if (!this.jdField_k_of_type_Boolean) {
          c(i1);
        }
        if ((localObject != null) && (((List)localObject).size() != 0)) {
          break label307;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(null);
      }
    }
    for (;;)
    {
      bbjv.a("AIO_EmoticonPanel_EnterSecond", null);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] switchTabMode to , duration:" + (System.currentTimeMillis() - paramLong) + ",mSecondTabInited:" + this.jdField_k_of_type_Boolean);
      }
      return;
      jdField_c_of_type_Int = i1;
      break;
      jdField_c_of_type_Int = i1;
      break label166;
      label307:
      paramInt = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.getSelectedItemPosition();
      if ((paramInt != i1) || (paramInt == 0))
      {
        if (i1 == e) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(i1);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a((List)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getAdapter() != this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter);
      }
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] switchTabMode to , setAdapter duration: " + (System.currentTimeMillis() - l1));
      }
      e(i1);
      if ((this.jdField_l_of_type_Boolean) && (i1 == 0))
      {
        localObject = (aoak)((List)localObject).get(i1);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b((aoak)localObject);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    SharedPreferences localSharedPreferences;
    long l1;
    do
    {
      return;
      if (paramInt == 1)
      {
        ThreadManagerV2.excute(new EmoticonMainPanel.6(paramQQAppInterface), 128, null, true);
        return;
      }
      localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      l1 = localSharedPreferences.getLong("last_get_recommendemotion_time_" + paramQQAppInterface.c(), 0L);
      paramInt = localSharedPreferences.getInt("recommendSeqinterval", 7200);
    } while (System.currentTimeMillis() - l1 < paramInt * 1000);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "sendRecommendSSORequest send req to recommend");
    }
    ((ajvp)paramQQAppInterface.a(12)).a();
    localSharedPreferences.edit().putLong("last_get_recommendemotion_time_" + paramQQAppInterface.c(), System.currentTimeMillis()).apply();
  }
  
  private int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label133:
    label162:
    label165:
    for (;;)
    {
      return 0;
      List localList = this.jdField_a_of_type_JavaUtilList;
      if (localList != null)
      {
        Object localObject = ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramString);
        int i2;
        int i1;
        if ((localObject != null) && ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5)))
        {
          i2 = 1;
          int i3 = localList.size();
          i1 = 0;
          label74:
          if (i1 >= i3) {
            break label162;
          }
          localObject = (aoak)localList.get(i1);
          if ((localObject == null) || (((aoak)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (!paramString.equals(((aoak)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
            break label133;
          }
        }
        for (;;)
        {
          if (i1 == -1) {
            break label165;
          }
          return i1;
          i2 = 0;
          break;
          if ((i2 == 0) || (localObject == null) || (((aoak)localObject).jdField_a_of_type_Int != 9))
          {
            i1 += 1;
            break label74;
            i1 = -1;
          }
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    aoak localaoak;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (jdField_c_of_type_Int >= 0) && (jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localaoak = (aoak)this.jdField_a_of_type_JavaUtilList.get(jdField_c_of_type_Int);
      if (localaoak.jdField_a_of_type_Int != 7) {
        break label86;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
    }
    label86:
    do
    {
      return;
      if (localaoak.jdField_a_of_type_Int == 4)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
        return;
      }
      if (localaoak.jdField_a_of_type_Int == 11)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 3, 0, "", "", "", "");
        return;
      }
      if (localaoak.jdField_a_of_type_Int == 8)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 4, 0, "", "", "", "");
        return;
      }
      if (localaoak.jdField_a_of_type_Int == 10)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 5, 0, "", "", "", "");
        return;
      }
    } while ((localaoak.jdField_a_of_type_Int != 9) && (localaoak.jdField_a_of_type_Int != 6));
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 6, 0, "", "", "", "");
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_k_of_type_Boolean) {}
    while (this.jdField_a_of_type_Anyg == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Anyg.a(paramBoolean, this.jdField_b_of_type_Boolean);
  }
  
  private boolean c()
  {
    return (jdField_i_of_type_Int > this.jdField_l_of_type_Int) && (b());
  }
  
  private void f(int paramInt)
  {
    if (CameraEmoAllSend.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      CameraEmoAllSend.jdField_a_of_type_Boolean = bool;
      if ((!CameraEmoAllSend.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Anzj == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager == null)) {
        break;
      }
      paramInt = this.jdField_a_of_type_Anzj.a(11);
      if ((BaseActivity.sTopActivity == null) || (getVisibility() != 0) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem() != paramInt)) {
        break;
      }
      bbcv.a(BaseActivity.sTopActivity, this.jdField_a_of_type_AndroidContentContext.getString(2131691989), 2131691990, 2131691996, new anyo(this), new anyp(this)).show();
      return;
    }
  }
  
  private void u()
  {
    this.jdField_l_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
    if (jdField_i_of_type_Int > this.jdField_l_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onShow " + AppSetting.g() + " init panelH " + this.jdField_l_of_type_Int + " needExtendPanel" + bool);
      }
      return;
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "timtest tryShowCameraEmoGuide start.");
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) && (this.jdField_a_of_type_AndroidViewViewStub == null)) {
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
      x();
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363836);
      if (localImageView != null) {
        localImageView.setOnClickListener(new anyl(this));
      }
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165551));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "timtest tryHiddenCameraEmoGuide start.");
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void x()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363838);
    } while ((localImageView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager == null));
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getMeasuredHeight() != 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      localLayoutParams.height = ((int)(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getMeasuredHeight() * 0.6F));
      localLayoutParams.width = ((int)(localLayoutParams.height * 1.3F));
      localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getMeasuredHeight() * 0.08F));
      localImageView.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getViewTreeObserver().addOnGlobalLayoutListener(new anyw(this, localImageView));
  }
  
  private void y()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Aoci == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        int i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null)
        {
          GestureDetector localGestureDetector = ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureDetector();
          i1 = i2;
          if ((localGestureDetector instanceof aoci))
          {
            i1 = 1;
            this.jdField_a_of_type_Aoci = ((aoci)localGestureDetector);
          }
        }
        if (i1 == 0)
        {
          this.jdField_a_of_type_Aoci = new aoci(this.jdField_a_of_type_AndroidContentContext, ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureListener(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).setGestureDetector(this.jdField_a_of_type_Aoci);
        }
      }
      return;
    }
    this.jdField_a_of_type_Aoci.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Aoci.d = false;
    this.jdField_a_of_type_Aoci.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.getBottom();
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (!ApolloUtil.c()) {
      return;
    }
    if (this.jdField_d_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(super.getContext());
      this.jdField_d_of_type_AndroidWidgetImageView.setId(2131362249);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130837708);
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_d_of_type_AndroidWidgetImageView.getParent() != null) {
      ((ViewGroup)this.jdField_d_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_d_of_type_AndroidWidgetImageView);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = actn.a(52.0F, getContext().getResources());
    localLayoutParams.rightMargin = actn.a(15.0F, getContext().getResources());
    super.addView(this.jdField_d_of_type_AndroidWidgetImageView, localLayoutParams);
    ApolloUtil.b();
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "expresstab_bubble_view", 0, 0, new String[0]);
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_Anzj == null) {
      return 0;
    }
    return this.jdField_a_of_type_Anzj.a(paramInt);
  }
  
  int a(aoak paramaoak)
  {
    int i1 = 1;
    if (paramaoak == null)
    {
      QLog.e("EmoticonMainPanel", 1, "getMoreBtnStatusByEmotionInfo info = null");
      i1 = -1;
    }
    while ((paramaoak.jdField_a_of_type_Int != 7) && (paramaoak.jdField_a_of_type_Int != 10)) {
      return i1;
    }
    return 2;
  }
  
  public int a(String paramString)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList == null) || (localList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    int i2 = localList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (aoak)localList.get(i1);
      if (((aoak)localObject).jdField_a_of_type_Int == 6)
      {
        localObject = ((aoak)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
        if ((localObject != null) && (paramString.equals(((EmoticonPackage)localObject).epId)))
        {
          if (jdField_g_of_type_Boolean) {
            return i1 - 3;
          }
          return i1 - 2;
        }
      }
      i1 += 1;
    }
    return -1;
  }
  
  @TargetApi(11)
  void a()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf("100610.100611"));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "emoji mall has redpoint.");
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B8", 0, 0, "", "", "", "");
      if (getContext().getSharedPreferences("mobileQQ", 0).getBoolean("emo_panel_mall_new_played", false)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonMainPanel.1(this), 200L);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "initEmoticonView 2");
    }
    jdField_c_of_type_Int = a(paramInt);
    a(jdField_c_of_type_Int, null);
    this.r = true;
    u();
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new anyx(this));
    localValueAnimator.start();
  }
  
  void a(int paramInt, String paramString)
  {
    int i1 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "initEmoticonView 2, selectIndex = " + paramInt + ", defaultEpId = " + paramString);
    }
    y();
    this.o = false;
    long l1 = System.currentTimeMillis();
    Object localObject = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
    int i2;
    if ((localObject != null) && (this.jdField_a_of_type_Anzj != null) && (((anrs)localObject).c()) && (paramInt == this.jdField_a_of_type_Anzj.a(11)))
    {
      i2 = 1;
      if (anzm.c(this.jdField_d_of_type_Int)) {
        break label379;
      }
      if (paramInt < 2) {
        break label374;
      }
      label124:
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("mobileQQ", 0);
      localObject = localSharedPreferences.getString("LAST_ADD_EMO_PACKAGE", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_k_of_type_Boolean = false;
        this.jdField_h_of_type_Boolean = false;
        localSharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE").apply();
        localSharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE_MAGIC").apply();
        i1 = 0;
        label226:
        if (paramString == null) {
          break label349;
        }
        localObject = paramString;
      }
      for (;;)
      {
        label233:
        if ((i2 != 0) && (paramString == null)) {
          paramString = null;
        }
        for (;;)
        {
          new QueryTask(new anyr(this, paramInt), new anyv(this, l1)).a(paramString);
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ep_mall", "show_mine", "", 0, 0, 0, "", "", "");
          return;
          i2 = 0;
          break;
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_h_of_type_Boolean))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonMainPanel", 2, "new pkg downloaded in panel, refresh");
            }
            this.jdField_k_of_type_Boolean = false;
          }
          break label226;
          label349:
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label368;
          }
          break label233;
          paramString = (String)localObject;
          paramInt = i1;
        }
        label368:
        localObject = null;
      }
      label374:
      i1 = paramInt;
      break label124;
      label379:
      i1 = paramInt;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, paramInt3, paramBaseChatPie, false, new anyy(this, null));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, BaseChatPie paramBaseChatPie, boolean paramBoolean, anyg paramanyg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "init");
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = paramInt2;
    this.jdField_f_of_type_Int = super.getResources().getConfiguration().orientation;
    this.q = paramBoolean;
    this.r = false;
    switch (paramInt1)
    {
    case 100000: 
    default: 
      this.jdField_h_of_type_Int = 0;
      this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131379147));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter = new EmotionPanelViewPagerAdapter(paramQQAppInterface, paramContext, this.jdField_a_of_type_Anyb, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_h_of_type_Int, paramBoolean);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365629));
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131364685);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = ((HorizontalListViewEx)super.findViewById(2131376819));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_Anzj = new anzj(paramQQAppInterface, paramContext, this.jdField_h_of_type_Int);
      this.jdField_a_of_type_Anzj.a(b());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setTabAnimateEnable(b());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setAdapter(this.jdField_a_of_type_Anzj);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363585));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363659));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (this.jdField_h_of_type_Int == 3) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        label353:
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365596));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131165551));
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramContext.getResources().getColor(2131165550));
        super.findViewById(2131376784).setBackgroundColor(paramContext.getResources().getColor(2131165549));
        anvr.a().a(this);
        anvr.a().a(this.jdField_a_of_type_Anwf);
        this.jdField_l_of_type_Boolean = true;
        this.jdField_a_of_type_Anyg = paramanyg;
        if (paramInt3 == -1) {
          break label558;
        }
        a(paramInt3);
        label461:
        this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131379343));
        if (!((anrs)paramQQAppInterface.getManager(334)).c()) {
          break label567;
        }
      }
      break;
    }
    label558:
    label567:
    for (e = 3;; e = 2)
    {
      jdField_i_of_type_Int = (int)(getResources().getDisplayMetrics().heightPixels * 0.6D);
      return;
      this.jdField_h_of_type_Int = 1;
      break;
      this.jdField_h_of_type_Int = 2;
      break;
      this.jdField_h_of_type_Int = 3;
      break;
      this.jdField_h_of_type_Int = 4;
      break;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break label353;
      a(paramString);
      break label461;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, false, new anyy(this, null));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, paramBoolean, new anyy(this, null));
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie, boolean paramBoolean, anyg paramanyg)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, paramBoolean, paramanyg);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageDeleted");
    }
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    List localList;
    int i2;
    do
    {
      return;
      localList = this.jdField_a_of_type_JavaUtilList;
      int i1 = 0;
      int i3;
      for (i2 = -1; i1 < localList.size(); i2 = i3)
      {
        Object localObject = (aoak)localList.get(i1);
        i3 = i2;
        if (localObject != null)
        {
          i3 = i2;
          if (((aoak)localObject).jdField_a_of_type_Int == 6)
          {
            localObject = ((aoak)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
            i3 = i2;
            if (localObject != null)
            {
              i3 = i2;
              if (paramEmoticonPackage.epId.equals(((EmoticonPackage)localObject).epId)) {
                i3 = i1;
              }
            }
          }
        }
        i1 += 1;
      }
    } while (i2 == -1);
    if (i2 < jdField_c_of_type_Int) {}
    for (this.jdField_a_of_type_Int += 1;; this.jdField_a_of_type_Int = (localList.size() - 1)) {
      do
      {
        this.jdField_i_of_type_Boolean = true;
        return;
      } while ((i2 != jdField_c_of_type_Int) || (i2 != localList.size() - 1));
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageMoved");
    }
    this.jdField_i_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "initEmoticonView 1");
    }
    a(jdField_c_of_type_Int, paramString);
    u();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
  }
  
  protected void a(boolean paramBoolean, anza paramanza)
  {
    QLog.d("EmoticonMainPanel", 1, "asyncInitPanelDataList begin");
    ThreadManager.post(new EmoticonMainPanel.10(this, paramBoolean, paramanza), 5, null, true);
  }
  
  public boolean a()
  {
    return XPanelContainer.jdField_a_of_type_Int == jdField_i_of_type_Int;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!c()) {}
    float f1;
    int i1;
    do
    {
      do
      {
        return false;
        switch (paramMotionEvent.getAction())
        {
        }
      } while (getParent() == null);
      getParent().requestDisallowInterceptTouchEvent(false);
      return false;
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_k_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
      return false;
      f1 = paramMotionEvent.getY();
      i1 = (int)(f1 - this.jdField_b_of_type_Float + 0.5F);
    } while ((!b()) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null) || (Math.abs(i1) <= this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() * 0.6F));
    this.jdField_b_of_type_Float = f1;
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonMainPanel.8(this), 200L);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload begins.");
    }
    anwj.a().a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload ends.");
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      QLog.e("EmoticonMainPanel", 1, "onPackageAdded: ep = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageAdded: ep = " + paramEmoticonPackage);
    }
    this.jdField_i_of_type_Boolean = true;
    ThreadManager.getUIHandler().post(new EmoticonMainPanel.15(this, paramEmoticonPackage));
  }
  
  public void b(boolean paramBoolean)
  {
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onHide.");
      }
      if (paramBoolean) {
        break label67;
      }
      XPanelContainer.jdField_a_of_type_Int = this.jdField_l_of_type_Int;
    }
    for (;;)
    {
      this.jdField_m_of_type_Int = 0;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(null);
      }
      return;
      label67:
      if (this.jdField_m_of_type_Int != 0) {
        XPanelContainer.jdField_a_of_type_Int = this.jdField_m_of_type_Int;
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (!this.q) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (!c()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      int i1 = (int)(paramMotionEvent.getY() - this.jdField_b_of_type_Float + 0.5F);
      int i2 = XPanelContainer.jdField_a_of_type_Int;
      XPanelContainer.jdField_a_of_type_Int -= i1;
      if (XPanelContainer.jdField_a_of_type_Int > jdField_i_of_type_Int) {
        XPanelContainer.jdField_a_of_type_Int = jdField_i_of_type_Int;
      }
      while (XPanelContainer.jdField_a_of_type_Int != i2)
      {
        AbstractGifImage.pauseAll();
        if (!(getParent() instanceof XPanelContainer)) {
          break;
        }
        getParent().requestLayout();
        break;
        if (XPanelContainer.jdField_a_of_type_Int < this.jdField_l_of_type_Int) {
          XPanelContainer.jdField_a_of_type_Int = this.jdField_l_of_type_Int;
        }
      }
      i2 = XPanelContainer.jdField_a_of_type_Int;
      if ((i2 != jdField_i_of_type_Int) && (i2 != this.jdField_l_of_type_Int))
      {
        if (i2 > this.jdField_k_of_type_Int)
        {
          i1 = jdField_i_of_type_Int;
          label167:
          if (Math.abs(i2 - this.jdField_k_of_type_Int) <= 100) {
            break label274;
          }
          i2 = 1;
          label183:
          if (i2 == 0) {
            break label279;
          }
          label187:
          if ((i2 == 0) || (i1 != this.jdField_l_of_type_Int)) {
            break label287;
          }
          b("0X800A847");
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonMainPanel", 2, "report panel close");
          }
        }
        for (;;)
        {
          paramMotionEvent = ValueAnimator.ofInt(new int[] { XPanelContainer.jdField_a_of_type_Int, i1 });
          paramMotionEvent.setDuration(150L);
          paramMotionEvent.addUpdateListener(new anyu(this, i1));
          paramMotionEvent.start();
          break;
          i1 = this.jdField_l_of_type_Int;
          break label167;
          label274:
          i2 = 0;
          break label183;
          label279:
          i1 = this.jdField_k_of_type_Int;
          break label187;
          label287:
          if ((i2 != 0) && (i1 == jdField_i_of_type_Int))
          {
            b("0X800A846");
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonMainPanel", 2, "report panel open");
            }
          }
        }
      }
      AbstractGifImage.resumeAll();
    }
  }
  
  public void c()
  {
    if (!c()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.jdField_a_of_type_Int != this.jdField_l_of_type_Int);
      a(200, XPanelContainer.jdField_a_of_type_Int, jdField_i_of_type_Int);
      b("0X800A846");
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonMainPanel", 2, "onPullUp");
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_k_of_type_Boolean) {}
    long l1;
    List localList;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      localList = this.jdField_a_of_type_JavaUtilList;
    } while ((localList == null) || (localList.size() == 0));
    if (paramInt == e) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
    }
    Object localObject1 = "";
    int i2 = localList.size();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    label98:
    Object localObject2;
    anzk localanzk;
    if (i1 < i2)
    {
      localObject2 = (aoak)localList.get(i1);
      localanzk = new anzk();
      localanzk.jdField_a_of_type_Int = ((aoak)localObject2).jdField_a_of_type_Int;
      if (((aoak)localObject2).jdField_a_of_type_Int == 8) {
        localObject1 = ajyc.a(2131704049);
      }
    }
    for (;;)
    {
      localanzk.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localArrayList.add(localanzk);
      i1 += 1;
      break label98;
      if (((aoak)localObject2).jdField_a_of_type_Int == 9)
      {
        localObject1 = ajyc.a(2131704051);
      }
      else if (((aoak)localObject2).jdField_a_of_type_Int == 4)
      {
        localObject1 = ajyc.a(2131704073);
      }
      else if (((aoak)localObject2).jdField_a_of_type_Int == 7)
      {
        localObject1 = ajyc.a(2131704072);
      }
      else if ((((aoak)localObject2).jdField_a_of_type_Int == 6) || (((aoak)localObject2).jdField_a_of_type_Int == 10))
      {
        if (((aoak)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
        {
          EmoticonPackage localEmoticonPackage = ((aoak)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
          localObject2 = localEmoticonPackage.name + ajyc.a(2131704092);
          localObject1 = localObject2;
          if (localEmoticonPackage.status != 2) {
            localObject1 = (String)localObject2 + ajyc.a(2131704094);
          }
          localanzk.jdField_a_of_type_JavaLangString = localEmoticonPackage.epId;
          localanzk.jdField_b_of_type_Int = localEmoticonPackage.subType;
          if (localEmoticonPackage.status == 2) {}
          for (boolean bool = true;; bool = false)
          {
            localanzk.jdField_a_of_type_Boolean = bool;
            break;
          }
        }
      }
      else if (((aoak)localObject2).jdField_a_of_type_Int == 11)
      {
        localObject1 = ajyc.a(2131704037);
        continue;
        if (localArrayList.size() > 0)
        {
          if (this.jdField_j_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.resetCurrentX(paramInt);
          }
          this.jdField_j_of_type_Boolean = true;
          this.jdField_a_of_type_Anzj.a(localArrayList);
        }
        this.jdField_k_of_type_Boolean = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonMainPanel", 2, "[Performance] initSecondTabView duration:" + (System.currentTimeMillis() - l1));
        return;
      }
    }
  }
  
  public void d()
  {
    if (!c()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.jdField_a_of_type_Int != jdField_i_of_type_Int);
      a(250, XPanelContainer.jdField_a_of_type_Int, this.jdField_l_of_type_Int);
      b("0X800A847");
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonMainPanel", 2, "onPullDown");
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "switchTabMode selectIndex = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    bbjv.a(null, "AIO_EmoticonPanel_EnterSecond");
    if (!this.jdField_k_of_type_Boolean)
    {
      a(this.jdField_a_of_type_Boolean, new anyh(this, paramInt, l1));
      return;
    }
    a(l1, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    long l1;
    do
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        if (jdField_a_of_type_Long == -1L) {
          return;
        }
      }
      catch (StackOverflowError paramCanvas)
      {
        QLog.e("EmoticonMainPanel", 1, "dispatchDraw, StackOverflowError, stack:" + MsfSdkUtils.getStackTraceString(paramCanvas));
        return;
      }
      l1 = System.currentTimeMillis() - jdField_a_of_type_Long;
    } while (l1 <= 0L);
    paramCanvas = new HashMap(2);
    if (jdField_m_of_type_Boolean)
    {
      i1 = 1;
      paramCanvas.put("panelMode", "2");
      paramCanvas.put("duration", String.valueOf(l1));
      ThreadManager.post(new EmoticonMainPanel.31(this, i1, l1, paramCanvas), 5, null, true);
      bbjv.a("AIO_EmoticonPanel_OpenDuration", null);
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonMainPanel", 2, "[Performance] dispatchDraw over, duration=" + l1 + ",openCondition=" + i1 + ",panelMode=" + "2");
        QLog.d("StressTesting.Emoticon.PanelCreate", 2, "open EmoticonPanel duration=" + l1);
      }
      jdField_a_of_type_Long = -1L;
      this.jdField_l_of_type_Boolean = false;
      jdField_m_of_type_Boolean = false;
      return;
    }
    if (this.jdField_l_of_type_Boolean) {}
    for (int i1 = 2;; i1 = 3) {
      break;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_Anyz != null) && (this.jdField_a_of_type_Anyz.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void e()
  {
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onShow.");
      }
      this.jdField_m_of_type_Int = 0;
      u();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) && (this.jdField_a_of_type_JavaUtilList != null) && (jdField_c_of_type_Int >= 0) && (jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()))
      {
        Object localObject = (aoak)this.jdField_a_of_type_JavaUtilList.get(jdField_c_of_type_Int);
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a((aoak)localObject);
        if ((localObject != null) && (((anxd)localObject).a() != null))
        {
          bfob localbfob = ((anxd)localObject).a().getOnScrollListener();
          if ((localbfob instanceof anze)) {
            ((anze)localbfob).a(((anxd)localObject).a());
          }
        }
      }
    }
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "showPanelByTabIndex tabIndex = " + paramInt);
    }
    Object localObject = null;
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (paramInt < localList.size()) {
      localObject = (aoak)localList.get(paramInt);
    }
    if (localObject != null)
    {
      int i1 = a((aoak)localObject);
      if (this.jdField_b_of_type_Int != i1)
      {
        this.jdField_b_of_type_Int = i1;
        if ((!this.jdField_a_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) {
          break label200;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846222);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt, false);
      if (((aoak)localObject).jdField_a_of_type_Int != 11) {
        break;
      }
      k();
      localObject = (anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
      if (((anrs)localObject).b()) {
        ((anrs)localObject).a(false);
      }
      if (((anrz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(333)).a() == 0) {
        v();
      }
      return;
      label200:
      if ((this.jdField_b_of_type_Int == 2) && (!this.jdField_f_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846211);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "onPageSelected, show del pic");
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    w();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      anvs localanvs = (anvs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
      if (!localanvs.e)
      {
        localanvs.e = true;
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "doSyncFavEmotion");
        }
        l();
      }
      if (!localanvs.d)
      {
        Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "newPanelDataList.size() = " + ((ArrayList)localObject).size());
        }
        localObject = ((ArrayList)localObject).iterator();
        int i1 = 0;
        while (((Iterator)localObject).hasNext())
        {
          EmoticonPackage localEmoticonPackage = ((aoak)((Iterator)localObject).next()).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
          i1 += 1;
          if ((localEmoticonPackage != null) && ((localEmoticonPackage.jobType == 0) || (localEmoticonPackage.jobType == 4)) && (localEmoticonPackage.status != 2))
          {
            localanvs.d = true;
            if (i1 <= 10) {
              anzm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonPackage, this.jdField_h_of_type_Int);
            }
          }
        }
      }
    }
  }
  
  public void g()
  {
    bbjv.a(null, "AIO_EmoticonPanel_OnResume");
    this.s = true;
    anvr.a().a(this.jdField_a_of_type_Anwf);
    if ((getVisibility() == 0) && (this.jdField_i_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onResume, Emoticon pkg moved、added or deleted, refresh");
      }
      this.jdField_k_of_type_Boolean = false;
      jdField_c_of_type_Int -= this.jdField_a_of_type_Int;
      if (jdField_c_of_type_Int < 0) {
        jdField_c_of_type_Int = 0;
      }
      a(jdField_c_of_type_Int, null);
      this.jdField_a_of_type_Int = 0;
      this.jdField_i_of_type_Boolean = false;
    }
    for (;;)
    {
      bbjv.a("AIO_EmoticonPanel_OnResume", null);
      return;
      if (isShown())
      {
        if ((anzm.c(this.jdField_d_of_type_Int)) && (!TextUtils.isEmpty(getContext().getSharedPreferences("mobileQQ", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "download in market, initEmoticonView");
          }
          a(0, null);
        }
        p();
        o();
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.s = false;
    anvr.a().b(this.jdField_a_of_type_Anwf);
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "OnDestory");
    }
    anvr.a().b(this);
    anvr.a().b(this.jdField_a_of_type_Anwf);
    HorizontalListViewEx.a();
    anwj.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    t();
    this.jdField_k_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajtj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajwb);
      localObject = (anxx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(172);
      if (localObject != null) {
        ((anxx)localObject).b();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("commonUsedSystemEmoji_sp", 0);
      long l1 = ((SharedPreferences)localObject).getLong("lastRequestTime", 0L);
      if ((System.currentTimeMillis() - l1 > 43200000L) || (System.currentTimeMillis() - l1 < 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "onDestroy commonused send");
        }
        ThreadManagerV2.excute(new EmoticonMainPanel.13(this, (SharedPreferences)localObject), 64, null, true);
      }
      localObject = (askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if (localObject != null) {
        ((askd)localObject).f();
      }
    }
    this.jdField_a_of_type_Aqyd.d();
    this.jdField_a_of_type_Anta = null;
    this.jdField_a_of_type_Anyb = null;
    if ((this.jdField_a_of_type_Aoci != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null))
    {
      localObject = (TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
      GestureDetector localGestureDetector = ((TopGestureLayout)localObject).getGestureDetector();
      if ((localGestureDetector instanceof aoci))
      {
        ThreadManagerV2.getUIHandlerV2().post(new EmoticonMainPanel.14(this, (TopGestureLayout)localObject, localGestureDetector));
        com.tencent.mobileqq.emoticon.EmojiStickerManager.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.p(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.p(false);
      }
      ((TopGestureLayout)localObject).restoreGestureDetector();
      this.jdField_a_of_type_Aoci = null;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Anyb != null) {
      this.jdField_a_of_type_Anyb.b();
    }
    aoak localaoak;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (jdField_c_of_type_Int >= 0) && (jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localaoak = (aoak)this.jdField_a_of_type_JavaUtilList.get(jdField_c_of_type_Int);
      if (localaoak.jdField_a_of_type_Int != 7) {
        break label106;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A845", "0X800A845", 1, 0, "", "", "", "");
    }
    label106:
    while (localaoak.jdField_a_of_type_Int != 10) {
      return;
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A845", "0X800A845", 2, 0, "", "", "", "");
  }
  
  void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "doSyncCameraEmotion");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ThreadManager.excute(new EmoticonMainPanel.20(this), 128, null, false);
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    boolean bool = localSharedPreferences.getBoolean("local_overflow" + str, false);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "isDelOverflow=" + bool);
    }
    ThreadManager.post(new EmoticonMainPanel.25(this, bool, localSharedPreferences, str), 5, null, false);
  }
  
  void m()
  {
    if ((!bbev.d(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    anss localanss;
    antu localantu;
    do
    {
      return;
      localanss = (anss)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103);
      localantu = (antu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(80);
    } while (!localanss.a());
    localantu.a();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "comicHandler.GetMyComicFavorEmotIcons");
    }
    localanss.a(this.jdField_a_of_type_Anta);
    localanss.c();
    this.jdField_a_of_type_JavaLangRunnable.run();
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
  }
  
  public void n()
  {
    if (!isShown()) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonMainPanel.27(this), 200L);
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "refresh camera emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonMainPanel.28(this), 200L);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajtj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajwb);
    }
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363659: 
    case 2131363585: 
      do
      {
        return;
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ep_mall", "click_mine", "", 0, 0, 0, "", "", "");
        EmojiHomeUiPlugin.openEmosmActivity((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1, false, "");
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x800a56d", "0x800a56d", 0, 0, "", "", "", "");
        return;
        if ((this.jdField_b_of_type_Int != 2) || (this.jdField_a_of_type_Boolean)) {
          break;
        }
      } while (this.jdField_a_of_type_Anyb == null);
      this.jdField_a_of_type_Anyb.b();
      return;
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B7", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B9", 0, 0, "", "", "", "");
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        ((avpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf("100610.100611"));
        getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", false).apply();
      }
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      bbkv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Aqyd.b();
      EmojiHomeUiPlugin.openEmojiHomePage((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1, bool, "");
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("emoticon_panel_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        if (paramView != null) {
          paramView.edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).apply();
        }
      }
      if (WebProcessManager.c()) {}
      for (int i1 = 1;; i1 = 0)
      {
        VasWebviewUtil.reportVasStatus("personal_web_preload_hit_rit", "emoticon_main_panel_plus", "0", 0, 0, i1, 0, "", "");
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x800a56c", "0x800a56c", 0, 0, "", "", "", "");
        return;
      }
      paramView = this.jdField_a_of_type_JavaUtilList;
      if ((paramView != null) && (paramView.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null))
      {
        paramView = (aoak)paramView.get(0);
        paramView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(paramView);
        if ((paramView != null) && ((paramView instanceof aocn))) {
          ((aocn)paramView).d();
        }
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "expresstab_bubble_click", 0, 0, new String[0]);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.n = true;
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajtj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajwb);
    }
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_m_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
      XPanelContainer.jdField_a_of_type_Int = this.jdField_l_of_type_Int;
    }
    aoan.a().a();
    aoap.a().a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewParent localViewParent = getParent();
    int i1;
    if (localViewParent != null)
    {
      i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 != 0) {
        break label35;
      }
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label35:
      if ((i1 == 1) || (i1 == 3)) {
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_Int;
      if (paramInt1 != paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "onMeasure: oldWidth=" + paramInt2 + " newWidth=" + paramInt1);
        }
        aoap.a().a();
        aoap.jdField_a_of_type_Int = paramInt1;
        localEmotionPanelViewPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter;
        if (paramInt1 / localDisplayMetrics.widthPixels >= 0.66F) {
          break label146;
        }
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      localEmotionPanelViewPagerAdapter.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.jdField_a_of_type_Int = paramInt1;
      ThreadManagerV2.getUIHandlerV2().post(new EmoticonMainPanel.7(this));
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    bbjv.a(null, "AIO_EmoticonPanel_PageScroll");
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      return;
    }
    localObject = (aoak)((List)localObject).get(paramInt);
    int i1;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b((aoak)localObject);
      if (((aoak)localObject).jdField_a_of_type_Int != 7) {
        break label366;
      }
      i1 = 1;
    }
    for (;;)
    {
      label69:
      if (i1 > 0) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x800a572", "0x800a572", 0, 0, i1 + "", i1 + "", i1 + "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onPageSelected, position=" + paramInt + "panelInfo = " + localObject);
      }
      i1 = a((aoak)localObject);
      if (this.jdField_b_of_type_Int != i1)
      {
        this.jdField_b_of_type_Int = i1;
        if ((this.jdField_a_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846222);
        }
      }
      else
      {
        label255:
        if (jdField_c_of_type_Int == paramInt) {
          break label544;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(paramInt);
        if (paramInt == e) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
      }
      for (;;)
      {
        jdField_c_of_type_Int = paramInt;
        if (paramInt != 0) {
          t();
        }
        bbjv.a("AIO_EmoticonPanel_PageScroll", null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonMainPanel", 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - l1));
        return;
        label366:
        if ((((aoak)localObject).jdField_a_of_type_Int == 5) || (((aoak)localObject).jdField_a_of_type_Int == 4))
        {
          i1 = 2;
          break label69;
        }
        if (((aoak)localObject).jdField_a_of_type_Int == 11)
        {
          i1 = 3;
          break label69;
        }
        if (((aoak)localObject).jdField_a_of_type_Int == 8)
        {
          i1 = 4;
          break label69;
        }
        if (((aoak)localObject).jdField_a_of_type_Int == 9)
        {
          i1 = 5;
          break label69;
        }
        if ((((aoak)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (bbjw.a(((aoak)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
          break label647;
        }
        i1 = 6;
        break label69;
        if ((this.jdField_b_of_type_Int == 2) && (!this.jdField_f_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846211);
          this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(10.0F * this.jdField_a_of_type_Float), 0, 0, 0);
          if (!QLog.isColorLevel()) {
            break label255;
          }
          QLog.d("EmoticonMainPanel", 2, "onPageSelected, show del pic");
          break label255;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label255;
        label544:
        if ((localObject != null) && (((aoak)localObject).jdField_a_of_type_Int == 8))
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, "", paramInt + "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "view times report. cur page:" + paramInt);
          }
        }
      }
      label647:
      i1 = -1;
    }
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonMainPanel.29(this), 200L);
  }
  
  public void q()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonMainPanel.30(this), 200L);
  }
  
  public void r()
  {
    ThreadManager.getSubThreadHandler().post(new EmoticonMainPanel.32(this));
  }
  
  public void s()
  {
    View localView = super.findViewById(2131376832);
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void setCallBack(anyb paramanyb)
  {
    this.jdField_a_of_type_Anyb = paramanyb;
  }
  
  public void setDispatchKeyEventListener(anyz paramanyz)
  {
    this.jdField_a_of_type_Anyz = paramanyz;
  }
  
  public void setVisibility(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (paramInt != getVisibility())
    {
      super.setVisibility(paramInt);
      if (paramInt != 0) {
        break label199;
      }
      paramInt = super.getResources().getConfiguration().orientation;
      if (!this.jdField_i_of_type_Boolean) {
        break label186;
      }
      this.jdField_k_of_type_Boolean = false;
      jdField_c_of_type_Int -= this.jdField_a_of_type_Int;
      if (jdField_c_of_type_Int < 0) {
        jdField_c_of_type_Int = 0;
      }
      a(null);
      this.jdField_a_of_type_Int = 0;
      this.jdField_i_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_f_of_type_Int = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] reopen in aio, duration=" + (System.currentTimeMillis() - l1));
      }
      a();
      File localFile = new File(ajsf.bR);
      if (!localFile.exists())
      {
        boolean bool = localFile.mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "root dir not exist. try to make it. success:" + bool);
        }
      }
      return;
      label186:
      this.jdField_k_of_type_Boolean = false;
      a(null);
    }
    label199:
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonMainPanel.12(this), 1L);
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "[removePopupGuide]");
    }
    if ((this.jdField_d_of_type_AndroidWidgetImageView != null) && (this.jdField_d_of_type_AndroidWidgetImageView.getParent() != null)) {
      ((ViewGroup)this.jdField_d_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_d_of_type_AndroidWidgetImageView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel
 * JD-Core Version:    0.7.0.1
 */