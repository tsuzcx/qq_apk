package com.tencent.mobileqq.emoticonview;

import acef;
import aceg;
import acei;
import acej;
import acek;
import acel;
import acen;
import aceo;
import acep;
import aceq;
import acer;
import aceu;
import acev;
import acew;
import acex;
import acez;
import acfa;
import acfb;
import acfc;
import acfd;
import acfe;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class EmoticonMainPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, EmoticonPackageChangedListener
{
  public static long a;
  public static int c;
  public static int e;
  public static boolean f;
  static boolean l;
  static volatile boolean n;
  static volatile boolean o;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  public Context a;
  View jdField_a_of_type_AndroidViewView;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new acej(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public QQAppInterface a;
  public SyncListener a;
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new aceg(this);
  EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  EmoticonTabAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter;
  public EmotionPanelViewPagerAdapter a;
  public HorizontalListViewEx a;
  private StickerGestureDetector jdField_a_of_type_ComTencentMobileqqEmoticonviewStickerGestureDetector;
  public PreloadProcHitSession a;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  Runnable jdField_a_of_type_JavaLangRunnable = new acei(this);
  public List a;
  public boolean a;
  int jdField_b_of_type_Int;
  public View b;
  public ImageView b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public List b;
  public boolean b;
  private View c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  private View jdField_d_of_type_AndroidViewView;
  public boolean d;
  public boolean e;
  int f;
  public int g;
  public boolean g;
  public int h;
  public boolean h;
  public boolean i = true;
  public boolean j;
  boolean k;
  public volatile boolean m = false;
  public boolean p;
  public boolean q;
  public boolean r;
  private boolean s;
  
  static
  {
    jdField_c_of_type_Int = -1;
    jdField_f_of_type_Boolean = true;
    l = true;
    jdField_e_of_type_Int = 2;
  }
  
  public EmoticonMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("emoticon_panel", "com.tencent.mobileqq:tool");
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener = new acel(this);
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    int i1;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0))
    {
      i1 = paramInt;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {}
    }
    else
    {
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "switchTabMode selectIndex = " + i1);
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0);
    if (((SharedPreferences)localObject).getBoolean("force_to_recommend_panel_sp", false)) {
      if ((this.jdField_a_of_type_JavaUtilList == null) || ((this.jdField_a_of_type_JavaUtilList.size() > jdField_e_of_type_Int) && (((EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(jdField_e_of_type_Int)).jdField_a_of_type_Int == 8)))
      {
        jdField_c_of_type_Int = jdField_e_of_type_Int;
        i1 = jdField_e_of_type_Int;
        ((SharedPreferences)localObject).edit().putBoolean("force_to_recommend_panel_sp", false).apply();
        label170:
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "switchTabMode after recommend calculate, selectIndex = " + i1);
        }
        if (!this.j) {
          b(i1);
        }
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
          break label312;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(null);
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_EmoticonPanel_EnterSecond", null);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] switchTabMode to , duration:" + (System.currentTimeMillis() - paramLong) + ",mSecondTabInited:" + this.j);
      }
      return;
      jdField_c_of_type_Int = i1;
      break;
      jdField_c_of_type_Int = i1;
      break label170;
      label312:
      paramInt = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.getSelectedItemPosition();
      if ((paramInt != i1) || (paramInt == 0))
      {
        if (i1 == jdField_e_of_type_Int) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(i1);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getAdapter() != this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter);
      }
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] switchTabMode to , setAdapter duration: " + (System.currentTimeMillis() - l1));
      }
      d(i1);
      if ((this.k) && (i1 == 0))
      {
        localObject = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b((EmotionPanelInfo)localObject);
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
        VasQuickUpdateManager.a(paramQQAppInterface, "watch_focus.json", true, null);
        return;
      }
      localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      l1 = localSharedPreferences.getLong("last_get_recommendemotion_time_" + paramQQAppInterface.c(), 0L);
      paramInt = localSharedPreferences.getInt("recommendSeqinterval", 7200);
    } while (System.currentTimeMillis() - l1 < paramInt * 1000);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "sendRecommendSSORequest send req to recommend");
    }
    ((EmoticonHandler)paramQQAppInterface.a(12)).b();
    localSharedPreferences.edit().putLong("last_get_recommendemotion_time_" + paramQQAppInterface.c(), System.currentTimeMillis()).apply();
  }
  
  private void a(boolean paramBoolean, acfe paramacfe)
  {
    QLog.d("EmoticonMainPanel", 1, "asyncInitPanelDataList begin");
    ThreadManager.post(new acex(this, paramBoolean, paramacfe), 5, null, true);
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "[realShowApolloEmoticonGuide]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject2;
    URLDrawable localURLDrawable;
    ViewGroup localViewGroup;
    do
    {
      do
      {
        do
        {
          return false;
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(0);
          localObject2 = super.getResources();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ((Resources)localObject2).getDimensionPixelSize(2131558715);
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ((Resources)localObject2).getDimensionPixelSize(2131558716);
          localObject2 = URLDrawable.getDrawable("http://cmshow.gtimg.cn/client/img/apollo_face_guide_main.png", (URLDrawable.URLDrawableOptions)localObject1);
          if (((URLDrawable)localObject2).getStatus() != 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonMainPanel", 2, "[realShowApolloEmoticonGuide] main guide image not ready");
            }
            ((URLDrawable)localObject2).startDownload();
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(0);
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(0);
          localURLDrawable = URLDrawable.getDrawable("http://cmshow.gtimg.cn/client/img/apollo_face_guide_list_v3.png", (URLDrawable.URLDrawableOptions)localObject1);
          if (localURLDrawable.getStatus() != 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonMainPanel", 2, "[realShowApolloEmoticonGuide] face list image not ready");
            }
            localURLDrawable.startDownload();
          }
          if ((AbsDownloader.a("http://cmshow.gtimg.cn/client/img/apollo_face_guide_main.png")) && (AbsDownloader.a("http://cmshow.gtimg.cn/client/img/apollo_face_guide_list_v3.png"))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("EmoticonMainPanel", 2, "[realShowApolloEmoticonGuide] image file not ready");
        return false;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968676, null));
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
      localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
    } while (localViewGroup == null);
    Object localObject1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString;
    }
    ((URLImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363132)).setImageDrawable((Drawable)localObject2);
    ((URLImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363129)).setImageDrawable(localURLDrawable);
    ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363131)).setOnClickListener(new acev(this, (String)localObject1));
    SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "emoticon_panel", true);
    localViewGroup.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "0X8008231", (String)localObject1, 0, 0, new String[] { "0", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
    return true;
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
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Object localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramString);
        int i2;
        int i1;
        if ((localObject != null) && ((((EmoticonPackage)localObject).jobType == 3) || (((EmoticonPackage)localObject).jobType == 5)))
        {
          i2 = 1;
          int i3 = this.jdField_a_of_type_JavaUtilList.size();
          i1 = 0;
          label72:
          if (i1 >= i3) {
            break label162;
          }
          localObject = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
          if ((localObject == null) || (((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (!paramString.equals(((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
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
          if ((i2 == 0) || (localObject == null) || (((EmotionPanelInfo)localObject).jdField_a_of_type_Int != 9))
          {
            i1 += 1;
            break label72;
            i1 = -1;
          }
        }
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.j) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    this.jdField_a_of_type_JavaUtilList = EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_h_of_type_Int, this.r);
  }
  
  private void m()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewStickerGestureDetector == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
      {
        int i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null)
        {
          GestureDetector localGestureDetector = ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureDetector();
          i1 = i2;
          if ((localGestureDetector instanceof StickerGestureDetector))
          {
            i1 = 1;
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewStickerGestureDetector = ((StickerGestureDetector)localGestureDetector);
          }
        }
        if (i1 == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewStickerGestureDetector = new StickerGestureDetector(this.jdField_a_of_type_AndroidContentContext, ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).getGestureListener(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
          ((TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c).setGestureDetector(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewStickerGestureDetector);
        }
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewStickerGestureDetector.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewStickerGestureDetector.d = false;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewStickerGestureDetector.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.getBottom();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, new Object[] { "[showApolloEmoticonGuide] sApolloEmoticonGuideShown=", Boolean.valueOf(o), ", sApolloEmoticonGuideFlagLoaded=", Boolean.valueOf(n), ", sessionType=", Integer.valueOf(this.jdField_d_of_type_Int) });
    }
    if (((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 3000)) || (o) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    String str;
    do
    {
      do
      {
        SharedPreferences localSharedPreferences;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.w("EmoticonMainPanel", 2, "[showApolloEmoticonGuide] not apollo user, abort");
              return;
              str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              if (!TextUtils.isEmpty(str)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("EmoticonMainPanel", 2, "[showApolloEmoticonGuide] uin null, abort");
            return;
            if (n) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonMainPanel", 2, "[showApolloEmoticonGuide] sp guide flag not loaded, load async");
            }
            localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
            str = "emoticon_action_guide_shown_v2" + str;
            o = localSharedPreferences.getBoolean(str, false);
            n = true;
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonMainPanel", 2, new Object[] { "[showApolloEmoticonGuide] load guide async, sApolloEmoticonGuideShown=", Boolean.valueOf(o) });
            }
          } while (o);
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "[showApolloEmoticonGuide] show guide state one");
          }
          o = a();
        } while (!o);
        localSharedPreferences.edit().putBoolean(str, true).apply();
        return;
      } while (o);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[showApolloEmoticonGuide] show guide state two");
      }
      o = a();
    } while (!o);
    SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0).edit().putBoolean("emoticon_action_guide_shown_v2" + str, true).apply();
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "[removeApolloEmoticonGuide]");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
      if (localViewGroup != null)
      {
        localViewGroup.removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
      }
    }
  }
  
  int a(EmotionPanelInfo paramEmotionPanelInfo)
  {
    int i1 = 1;
    if (paramEmotionPanelInfo == null)
    {
      QLog.e("EmoticonMainPanel", 1, "getMoreBtnStatusByEmotionInfo info = null");
      i1 = -1;
    }
    while ((paramEmotionPanelInfo.jdField_a_of_type_Int != 7) && (paramEmotionPanelInfo.jdField_a_of_type_Int != 10)) {
      return i1;
    }
    return 2;
  }
  
  public int a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    int i2 = this.jdField_a_of_type_JavaUtilList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
      if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 6)
      {
        localObject = ((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
        if ((localObject != null) && (paramString.equals(((EmoticonPackage)localObject).epId)))
        {
          if (jdField_f_of_type_Boolean) {
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
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf("100610.100611"));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "emoji mall has redpoint.");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B8", 0, 0, "", "", "", "");
      if (getContext().getSharedPreferences("mobileQQ", 0).getBoolean("emo_panel_mall_new_played", false)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    postDelayed(new acef(this), 200L);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload begins.");
    }
    EmotionPanelPayBackListenerManager.a().a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload ends.");
    }
  }
  
  void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "initEmoticonView 2, selectIndex = " + paramInt + ", defaultEpId = " + paramString);
    }
    m();
    this.p = false;
    long l1 = System.currentTimeMillis();
    int i1 = paramInt;
    if (!EmoticonUtils.c(this.jdField_d_of_type_Int))
    {
      i1 = paramInt;
      if (paramInt >= 2) {
        i1 = 1;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
    SharedPreferences localSharedPreferences = getContext().getSharedPreferences("mobileQQ", 0);
    String str = localSharedPreferences.getString("LAST_ADD_EMO_PACKAGE", "");
    if (!TextUtils.isEmpty(str))
    {
      this.j = false;
      this.jdField_g_of_type_Boolean = false;
      localSharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE").apply();
      localSharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE_MAGIC").apply();
      paramInt = 0;
      if (paramString == null) {
        break label257;
      }
    }
    for (;;)
    {
      new QueryTask(new aceu(this, paramInt), new acew(this, l1)).a(paramString);
      return;
      paramInt = i1;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      paramInt = i1;
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "new pkg downloaded in panel, refresh");
      }
      this.j = false;
      paramInt = i1;
      break;
      label257:
      if (!TextUtils.isEmpty(str)) {
        paramString = str;
      } else {
        paramString = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, paramBaseChatPie, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "init");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = paramInt2;
    this.jdField_f_of_type_Int = super.getResources().getConfiguration().orientation;
    this.r = paramBoolean;
    if (paramInt1 == 99999)
    {
      paramInt1 = 1;
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131364498));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter = new EmotionPanelViewPagerAdapter(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_h_of_type_Int, paramBoolean);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364497));
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131364504);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx = ((HorizontalListViewEx)super.findViewById(2131364505));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter = new EmoticonTabAdapter(paramQQAppInterface, paramContext, this.jdField_h_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364506));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!this.jdField_e_of_type_Boolean) {
        break label442;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364503));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramContext.getResources().getColor(2131494037));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramContext.getResources().getColor(2131494036));
      super.findViewById(2131362952).setBackgroundColor(paramContext.getResources().getColor(2131494035));
      EmojiListenerManager.a().a(this);
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      this.k = true;
      this.jdField_c_of_type_AndroidViewView = findViewById(2131364494);
      this.jdField_d_of_type_AndroidViewView = findViewById(2131364496);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364495));
      this.s = paramContext.getSharedPreferences("emo_tip_sp", 0).getBoolean(paramQQAppInterface.c() + "emo_tip_sp_key_show", true);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      a(paramString);
      return;
      paramInt1 = 0;
      break;
      label442:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageDeleted");
    }
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {}
    int i2;
    do
    {
      return;
      int i1 = 0;
      int i3;
      for (i2 = -1; i1 < this.jdField_a_of_type_JavaUtilList.size(); i2 = i3)
      {
        Object localObject = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
        i3 = i2;
        if (localObject != null)
        {
          i3 = i2;
          if (((EmotionPanelInfo)localObject).jdField_a_of_type_Int == 6)
          {
            localObject = ((EmotionPanelInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
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
    for (this.jdField_a_of_type_Int += 1;; this.jdField_a_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1)) {
      do
      {
        this.jdField_h_of_type_Boolean = true;
        return;
      } while ((i2 != jdField_c_of_type_Int) || (i2 != this.jdField_a_of_type_JavaUtilList.size() - 1));
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPackageMoved");
    }
    this.jdField_h_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "initEmoticonView 1");
    }
    a(jdField_c_of_type_Int, paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      EmojiManager localEmojiManager = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
      if (!localEmojiManager.d)
      {
        localEmojiManager.d = true;
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "doSyncFavEmotion");
        }
        f();
      }
      if (!localEmojiManager.jdField_c_of_type_Boolean)
      {
        Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "newPanelDataList.size() = " + ((ArrayList)localObject).size());
        }
        localObject = ((ArrayList)localObject).iterator();
        int i1 = 0;
        while (((Iterator)localObject).hasNext())
        {
          EmoticonPackage localEmoticonPackage = ((EmotionPanelInfo)((Iterator)localObject).next()).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
          i1 += 1;
          if ((localEmoticonPackage != null) && ((localEmoticonPackage.jobType == 0) || (localEmoticonPackage.jobType == 4)) && (localEmoticonPackage.status != 2))
          {
            localEmojiManager.jdField_c_of_type_Boolean = true;
            if (i1 <= 10) {
              EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonPackage, this.jdField_h_of_type_Int);
            }
          }
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (this.j) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
    } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0));
    if (paramInt == jdField_e_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
    }
    Object localObject1 = "";
    int i2 = this.jdField_a_of_type_JavaUtilList.size();
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    label98:
    Object localObject2;
    EmoticonTabAdapter.EmoticonTabItem localEmoticonTabItem;
    if (i1 < i2)
    {
      localObject2 = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(i1);
      localEmoticonTabItem = new EmoticonTabAdapter.EmoticonTabItem();
      localEmoticonTabItem.jdField_a_of_type_Int = ((EmotionPanelInfo)localObject2).jdField_a_of_type_Int;
      if (((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 8) {
        localObject1 = "推荐面板";
      }
    }
    for (;;)
    {
      localEmoticonTabItem.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localArrayList.add(localEmoticonTabItem);
      i1 += 1;
      break label98;
      if (((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 9)
      {
        localObject1 = "魔法表情面板";
      }
      else if (((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 4)
      {
        localObject1 = "收藏表情面板";
      }
      else if (((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 7)
      {
        localObject1 = "经典表情面板";
      }
      else if (((((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 6) || (((EmotionPanelInfo)localObject2).jdField_a_of_type_Int == 10)) && (((EmotionPanelInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null))
      {
        EmoticonPackage localEmoticonPackage = ((EmotionPanelInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
        localObject2 = localEmoticonPackage.name + "面板";
        localObject1 = localObject2;
        if (localEmoticonPackage.status != 2) {
          localObject1 = (String)localObject2 + ",未下载";
        }
        localEmoticonTabItem.jdField_a_of_type_JavaLangString = localEmoticonPackage.epId;
        localEmoticonTabItem.jdField_b_of_type_Int = localEmoticonPackage.subType;
        if (localEmoticonPackage.status == 2) {}
        for (boolean bool = true;; bool = false)
        {
          localEmoticonTabItem.jdField_a_of_type_Boolean = bool;
          break;
        }
        if (localArrayList.size() > 0)
        {
          if (this.i) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.a(paramInt);
          }
          this.i = true;
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonTabAdapter.a(localArrayList);
        }
        this.j = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonMainPanel", 2, "[Performance] initSecondTabView duration:" + (System.currentTimeMillis() - l1));
        return;
      }
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
    this.jdField_h_of_type_Boolean = true;
    ThreadManager.getUIHandler().post(new acfd(this, paramEmoticonPackage));
  }
  
  public void c()
  {
    StartupTracker.a(null, "AIO_EmoticonPanel_OnResume");
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    if ((getVisibility() == 0) && (this.jdField_h_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "onResume, Emoticon pkg moved、added or deleted, refresh");
      }
      this.j = false;
      jdField_c_of_type_Int -= this.jdField_a_of_type_Int;
      if (jdField_c_of_type_Int < 0) {
        jdField_c_of_type_Int = 0;
      }
      a(jdField_c_of_type_Int, null);
      this.jdField_a_of_type_Int = 0;
      this.jdField_h_of_type_Boolean = false;
    }
    for (;;)
    {
      StartupTracker.a("AIO_EmoticonPanel_OnResume", null);
      return;
      if (isShown())
      {
        if ((EmoticonUtils.c(this.jdField_d_of_type_Int)) && (!TextUtils.isEmpty(getContext().getSharedPreferences("mobileQQ", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonMainPanel", 2, "download in market, initEmoticonView");
          }
          a(0, null);
        }
        i();
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "switchTabMode selectIndex = " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_EnterSecond");
    if (!this.j)
    {
      a(this.jdField_a_of_type_Boolean, new acez(this, paramInt, l1));
      return;
    }
    a(l1, paramInt);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "showPanelByTabIndex tabIndex = " + paramInt);
    }
    EmotionPanelInfo localEmotionPanelInfo = null;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      localEmotionPanelInfo = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if (localEmotionPanelInfo != null)
    {
      int i1 = a(localEmotionPanelInfo);
      if (this.jdField_b_of_type_Int != i1)
      {
        this.jdField_b_of_type_Int = i1;
        if ((!this.jdField_a_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) {
          break label126;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843983);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt, false);
      return;
      label126:
      if ((this.jdField_b_of_type_Int == 2) && (!this.jdField_e_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843972);
        this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(10.0F * this.jdField_a_of_type_Float), 0, 0, 0);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "onPageSelected, show del pic");
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
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
    if (l)
    {
      i1 = 1;
      paramCanvas.put("panelMode", "2");
      paramCanvas.put("duration", String.valueOf(l1));
      ThreadManager.post(new aceq(this, i1, l1, paramCanvas), 5, null, true);
      StartupTracker.a("AIO_EmoticonPanel_OpenDuration", null);
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonMainPanel", 2, "[Performance] dispatchDraw over, duration=" + l1 + ",openCondition=" + i1 + ",panelMode=" + "2");
        QLog.d("StressTesting.Emoticon.PanelCreate", 2, "open EmoticonPanel duration=" + l1);
      }
      jdField_a_of_type_Long = -1L;
      this.k = false;
      l = false;
      return;
    }
    if (this.k) {}
    for (int i1 = 2;; i1 = 3) {
      break;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "OnDestory");
    }
    EmojiListenerManager.a().b(this);
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    HorizontalListViewEx.a();
    o();
    EmotionPanelPayBackListenerManager.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.j = false;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = (FavroamingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(102);
      if (localObject != null) {
        ((FavroamingManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
      }
      localObject = (CommonUsedSystemEmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(171);
      if (localObject != null) {
        ((CommonUsedSystemEmojiManager)localObject).b();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("commonUsedSystemEmoji_sp", 0);
      long l1 = ((SharedPreferences)localObject).getLong("lastRequestTime", 0L);
      if ((System.currentTimeMillis() - l1 > 43200000L) || (System.currentTimeMillis() - l1 < 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "onDestroy commonused send");
        }
        ThreadManager.executeOnFileThread(new acfb(this, (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12), (SharedPreferences)localObject));
      }
      localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (localObject != null) {
        ((EmoticonManager)localObject).f();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewStickerGestureDetector != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null))
    {
      localObject = (TopGestureLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
      GestureDetector localGestureDetector = ((TopGestureLayout)localObject).getGestureDetector();
      if ((localGestureDetector instanceof StickerGestureDetector))
      {
        ((TopGestureLayout)localObject).post(new acfc(this, (TopGestureLayout)localObject, localGestureDetector));
        com.tencent.mobileqq.emoticon.EmojiStickerManager.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(false);
      }
      ((TopGestureLayout)localObject).restoreGestureDetector();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewStickerGestureDetector = null;
    }
  }
  
  public void f()
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
    ThreadManager.post(new acek(this, bool, localSharedPreferences, str), 5, null, false);
  }
  
  public void g()
  {
    if ((!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    FavroamingManager localFavroamingManager;
    VipComicMqqHandler localVipComicMqqHandler;
    do
    {
      return;
      localFavroamingManager = (FavroamingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(102);
      localVipComicMqqHandler = (VipComicMqqHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(80);
    } while (!localFavroamingManager.a());
    localVipComicMqqHandler.b();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "comicHandler.GetMyComicFavorEmotIcons");
    }
    localFavroamingManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
    localFavroamingManager.b();
    this.jdField_a_of_type_JavaLangRunnable.run();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CED", "0X8005CED", 0, 0, "", "", "", "");
  }
  
  public void h()
  {
    if (!isShown()) {
      return;
    }
    postDelayed(new acen(this), 200L);
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "refresh fav emoticon panel");
    }
    postDelayed(new aceo(this), 200L);
  }
  
  public void j()
  {
    postDelayed(new acep(this), 200L);
  }
  
  public void k()
  {
    ThreadManager.getSubThreadHandler().post(new acer(this));
  }
  
  public void l()
  {
    View localView = super.findViewById(2131363031);
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131364506: 
      do
      {
        return;
        if ((this.jdField_b_of_type_Int != 2) || (this.jdField_a_of_type_Boolean)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback == null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.b();
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B7", 0, 0, "", "", "", "");
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B9", 0, 0, "", "", "", "");
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf("100610.100611"));
        getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", false).apply();
      }
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
      EmojiHomeUiPlugin.openEmojiHomePage((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1, bool, "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
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
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.s = false;
      this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("emo_tip_sp", 0).edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "emo_tip_sp_key_show", false).apply();
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.m = true;
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i1 == 1) || (i1 == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_PageScroll");
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((localEmotionPanelInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.b(localEmotionPanelInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "onPageSelected, position=" + paramInt + "panelInfo = " + localEmotionPanelInfo);
    }
    int i1 = a(localEmotionPanelInfo);
    if (this.jdField_b_of_type_Int != i1)
    {
      this.jdField_b_of_type_Int = i1;
      if ((this.jdField_a_of_type_Boolean) && (!this.jdField_e_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843983);
      }
    }
    else
    {
      label150:
      if (jdField_c_of_type_Int == paramInt) {
        break label376;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(paramInt);
      if (paramInt == jdField_e_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
      }
      label205:
      jdField_c_of_type_Int = paramInt;
      if (localEmotionPanelInfo != null)
      {
        paramInt = localEmotionPanelInfo.jdField_a_of_type_Int;
        if (4 != paramInt) {
          break label491;
        }
        if (!this.s) {
          break label479;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438032);
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_EmoticonPanel_PageScroll", null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonMainPanel", 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - l1));
      return;
      if ((this.jdField_b_of_type_Int == 2) && (!this.jdField_e_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843972);
        this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(10.0F * this.jdField_a_of_type_Float), 0, 0, 0);
        if (!QLog.isColorLevel()) {
          break label150;
        }
        QLog.d("EmoticonMainPanel", 2, "onPageSelected, show del pic");
        break label150;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label150;
      label376:
      if ((localEmotionPanelInfo == null) || (localEmotionPanelInfo.jdField_a_of_type_Int != 8)) {
        break label205;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, "", paramInt + "", "", "");
      if (!QLog.isColorLevel()) {
        break label205;
      }
      QLog.d("EmoticonMainPanel", 2, "view times report. cur page:" + paramInt);
      break label205;
      label479:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      continue;
      label491:
      if (6 == paramInt)
      {
        if (4 == localEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.subType)
        {
          if (this.s)
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438033);
          }
          else
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          }
        }
        else {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
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
      if (!this.jdField_h_of_type_Boolean) {
        break label186;
      }
      this.j = false;
      jdField_c_of_type_Int -= this.jdField_a_of_type_Int;
      if (jdField_c_of_type_Int < 0) {
        jdField_c_of_type_Int = 0;
      }
      a(null);
      this.jdField_a_of_type_Int = 0;
      this.jdField_h_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_f_of_type_Int = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "[Performance] reopen in aio, duration=" + (System.currentTimeMillis() - l1));
      }
      a();
      File localFile = new File(AppConstants.br);
      if (!localFile.exists())
      {
        boolean bool = localFile.mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "root dir not exist. try to make it. success:" + bool);
        }
      }
      return;
      label186:
      this.j = false;
      a(null);
    }
    label199:
    postDelayed(new acfa(this), 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel
 * JD-Core Version:    0.7.0.1
 */