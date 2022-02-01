package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.abtest.ExpEntityInfo;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.apollo.statistics.product.ApolloCmEmojiReportUtil;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EmoticonPanelController
  implements ViewPager.OnPageChangeListener, EmotionPanelListView.PullAndFastScrollListener, IEmoticonPanelController
{
  private static final String LOG_TAG = "EmoticonPanelController";
  static boolean sIsRecommendExist = true;
  public static int sLastSelectedSecondTabIndex = -1;
  static boolean sOpenFirstTimeInProcess = true;
  static int sRecommendEmoticonViewPoSition = 3;
  List<EmoticonPackage> addEmoPkgList = new ArrayList();
  QQEmoticonMainPanelApp app;
  int businessType = 0;
  protected EmoticonCallback callback;
  RelativeLayout contentLayout;
  public final Context context;
  float density;
  volatile boolean detached = false;
  private StickerGestureDetector gestureDetector;
  boolean hasBigEmotion = true;
  boolean isClickNoChangeTab = false;
  private boolean isFilterSysFaceBeyond255Enable = false;
  public boolean isNeedResetX = true;
  boolean isResumed = false;
  public boolean kanDianBiu = false;
  BaseChatPie mBaseChatPie;
  int mDeleteLeftPkgCount = 0;
  private EmoticonListProvider mEmoticonListProvider;
  protected EmoticonPanelCmshowHelper mEmoticonPanelCmshowHelper;
  EmoticonTabAdapter mEmoticonTabAdapter;
  HorizontalListViewEx mEmoticonTabs;
  private EmoticonHelperProvider mHelperProvider;
  boolean mHideAllSettingTabs;
  boolean mIsOnlySysEmotion;
  boolean mIsPositioningTab = false;
  private EmoticonMainPanel mMainPanel;
  boolean mMarketPgkDownloaded;
  boolean mNeedUpdate;
  ImageView mNewFlag;
  boolean mOpenFirstTimeInAIO;
  int mOrientation;
  private EmoticonPanelCameraHelper mPanelCameraHelper;
  private EmoticonPanelExtendHelper mPanelExtendHelper;
  private EmoticonPanelFavHelper mPanelFavHelper;
  protected EmoticonPanelHotPicSearchHelper mPanelHotPicSearchHelper;
  private EmoticonPanelMallHelper mPanelMallHelper;
  private EmoticonPanelSettingHelper mPanelSettingHelper;
  private EmoticonPanelSystemAndEmojiHelper mPanelSystemAndEmojiHelper;
  protected EmoticonPanelTabSortHelper mPanelTabSortHelper;
  EmoticonPanelController.EmoticonPanelParams mParams;
  View mSecondTabContainer;
  private int[] mSysEmotionOrder = null;
  PreloadProcHitSession mWebPreloadHitSession = new PreloadProcHitSession("emoticon_panel", "com.tencent.mobileqq:tool");
  EmotionPanelViewPagerAdapter pageAdapter;
  List<EmotionPanelInfo> panelDataList;
  int sessionType = 0;
  int toastOffset;
  EmoticonPanelViewPager viewPager;
  
  protected EmoticonPanelController(Context paramContext, EmoticonMainPanel paramEmoticonMainPanel)
  {
    this.mMainPanel = paramEmoticonMainPanel;
    this.context = paramContext;
    this.mParams = new EmoticonPanelController.EmoticonPanelParams(paramEmoticonMainPanel);
    this.mOrientation = paramContext.getResources().getConfiguration().orientation;
    this.density = paramContext.getResources().getDisplayMetrics().density;
    this.isClickNoChangeTab = false;
    this.mHelperProvider = new EmoticonHelperProvider(this);
    this.mPanelExtendHelper = ((EmoticonPanelExtendHelper)getHelper(1));
    this.mPanelFavHelper = ((EmoticonPanelFavHelper)getHelper(2));
    this.mPanelCameraHelper = ((EmoticonPanelCameraHelper)getHelper(3));
    this.mPanelSystemAndEmojiHelper = ((EmoticonPanelSystemAndEmojiHelper)getHelper(4));
    this.mPanelMallHelper = ((EmoticonPanelMallHelper)getHelper(5));
    this.mPanelSettingHelper = ((EmoticonPanelSettingHelper)getHelper(6));
    this.mPanelTabSortHelper = ((EmoticonPanelTabSortHelper)getHelper(8));
    this.mPanelHotPicSearchHelper = ((EmoticonPanelHotPicSearchHelper)getHelper(7));
    this.mEmoticonPanelCmshowHelper = ((EmoticonPanelCmshowHelper)getHelper(9));
  }
  
  private int findTabIndexByEpId(String paramString)
  {
    return this.mPanelMallHelper.findTabIndexByEpId(this.app, paramString, this.panelDataList);
  }
  
  private void hideCmShowItemIfNeed(List<EmotionPanelInfo> paramList)
  {
    int i = 1;
    int j = 0;
    if (paramList == null) {}
    label26:
    label40:
    label87:
    label89:
    label96:
    label99:
    for (;;)
    {
      return;
      if ((this.app != null) && (this.app.getQQAppInterface() == null))
      {
        if (i == 0) {
          break label87;
        }
        int k = paramList.size();
        i = j;
        if (i >= k) {
          break label96;
        }
        if (((EmotionPanelInfo)paramList.get(i)).type != 15) {
          break label89;
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label99;
        }
        paramList.remove(i);
        return;
        if (!CmShowWnsUtils.d()) {
          break label26;
        }
        i = 0;
        break label26;
        break;
        i += 1;
        break label40;
        i = -1;
      }
    }
  }
  
  private void initGestureDetector()
  {
    int j = 0;
    if (this.gestureDetector == null)
    {
      if (this.mBaseChatPie != null)
      {
        int i = j;
        if (this.mBaseChatPie.c != null)
        {
          GestureDetector localGestureDetector = ((TopGestureLayout)this.mBaseChatPie.c).getGestureDetector();
          i = j;
          if ((localGestureDetector instanceof StickerGestureDetector))
          {
            i = 1;
            this.gestureDetector = ((StickerGestureDetector)localGestureDetector);
          }
        }
        if (i == 0)
        {
          this.gestureDetector = new StickerGestureDetector(this.context, ((TopGestureLayout)this.mBaseChatPie.c).getGestureListener(), this.mBaseChatPie);
          ((TopGestureLayout)this.mBaseChatPie.c).setGestureDetector(this.gestureDetector);
        }
      }
      return;
    }
    this.gestureDetector.enteredAIO = false;
    this.gestureDetector.isFirstUpInvoked = false;
    this.gestureDetector.mBottom = this.mBaseChatPie.c.getBottom();
  }
  
  private void registerOtherProcessCallback()
  {
    if ((!QQEmoticonMainPanelApp.isMainProcess()) && (this.app != null)) {
      this.app.registerOtherProcessCallback();
    }
  }
  
  private void setViewPagerAdapter(long paramLong, int paramInt)
  {
    this.mSecondTabContainer.setVisibility(0);
    Object localObject = this.panelDataList;
    int i;
    if ((localObject != null) && (paramInt >= 0))
    {
      i = paramInt;
      if (paramInt < ((List)localObject).size()) {}
    }
    else
    {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "switchTabMode selectIndex = " + i);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0);
    if (localSharedPreferences.getBoolean("force_to_recommend_panel_sp", false)) {
      if ((localObject == null) || ((((List)localObject).size() > sRecommendEmoticonViewPoSition) && (((EmotionPanelInfo)((List)localObject).get(sRecommendEmoticonViewPoSition)).type == 8)))
      {
        sLastSelectedSecondTabIndex = sRecommendEmoticonViewPoSition;
        i = sRecommendEmoticonViewPoSition;
        localSharedPreferences.edit().putBoolean("force_to_recommend_panel_sp", false).apply();
        label170:
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "switchTabMode after recommend calculate, selectIndex = " + i);
        }
        if (!this.mMainPanel.mSecondTabInited) {
          initTabView(i);
        }
        if ((localObject != null) && (((List)localObject).size() != 0)) {
          break label318;
        }
        this.viewPager.setAdapter(null);
      }
    }
    for (;;)
    {
      StartupTracker.a("AIO_EmoticonPanel_EnterSecond", null);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] switchTabMode to , duration:" + (System.currentTimeMillis() - paramLong) + ",mSecondTabInited:" + this.mMainPanel.mSecondTabInited);
      }
      return;
      sLastSelectedSecondTabIndex = i;
      break;
      sLastSelectedSecondTabIndex = i;
      break label170;
      label318:
      paramInt = this.mEmoticonTabs.getSelectedItemPosition();
      if ((paramInt != i) || (paramInt == 0))
      {
        if (i == sRecommendEmoticonViewPoSition) {
          this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
        this.mEmoticonTabs.setSelection(i);
      }
      this.pageAdapter.setData((List)localObject);
      if (this.viewPager.getAdapter() != this.pageAdapter) {
        this.viewPager.setAdapter(this.pageAdapter);
      }
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] switchTabMode to , setAdapter duration: " + (System.currentTimeMillis() - l));
      }
      if (i < ((List)localObject).size()) {
        this.mPanelMallHelper.reportPageEvent((EmotionPanelInfo)((List)localObject).get(i), true);
      }
      showPanelByTabIndex(i);
      if ((this.mOpenFirstTimeInAIO) && (i == 0))
      {
        localObject = (EmotionPanelInfo)((List)localObject).get(i);
        this.pageAdapter.onPageSelected((EmotionPanelInfo)localObject);
      }
    }
  }
  
  private void updateLastSelectedSecondTabIndex()
  {
    if (sLastSelectedSecondTabIndex != findIndexByPanelType(12))
    {
      sLastSelectedSecondTabIndex -= this.mDeleteLeftPkgCount;
      if (sLastSelectedSecondTabIndex < 0) {
        sLastSelectedSecondTabIndex = this.mPanelTabSortHelper.getFrontDisSelectedTabSize();
      }
    }
  }
  
  public void deleteEmoticonClick()
  {
    if (this.callback != null) {
      this.callback.delete();
    }
    EmotionPanelInfo localEmotionPanelInfo;
    if ((this.panelDataList != null) && (sLastSelectedSecondTabIndex >= 0) && (sLastSelectedSecondTabIndex < this.panelDataList.size()))
    {
      localEmotionPanelInfo = (EmotionPanelInfo)this.panelDataList.get(sLastSelectedSecondTabIndex);
      if (localEmotionPanelInfo.type != 7) {
        break label109;
      }
      ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", "0X800A845", "0X800A845", 1, 0, "", "", "", "");
    }
    label109:
    while (localEmotionPanelInfo.type != 10) {
      return;
    }
    ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", "0X800A845", "0X800A845", 2, 0, "", "", "", "");
  }
  
  void dispatchDraw(Canvas paramCanvas)
  {
    if (EmoticonMainPanel.sOpenStartTime == -1L) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis() - EmoticonMainPanel.sOpenStartTime;
    } while (l <= 0L);
    paramCanvas = new HashMap(2);
    if (sOpenFirstTimeInProcess)
    {
      i = 1;
      paramCanvas.put("panelMode", "2");
      paramCanvas.put("duration", String.valueOf(l));
      ThreadManager.post(new EmoticonPanelController.5(this, i, l, paramCanvas), 5, null, true);
      StartupTracker.a("AIO_EmoticonPanel_OpenDuration", null);
      if (QLog.isColorLevel())
      {
        QLog.d("EmoticonPanelController", 2, "[Performance] dispatchDraw over, duration=" + l + ",openCondition=" + i + ",panelMode=" + "2");
        QLog.d("StressTesting.Emoticon.PanelCreate", 2, "open EmoticonPanel duration=" + l);
      }
      EmoticonMainPanel.sOpenStartTime = -1L;
      this.mOpenFirstTimeInAIO = false;
      sOpenFirstTimeInProcess = false;
      return;
    }
    if (this.mOpenFirstTimeInAIO) {}
    for (int i = 2;; i = 3) {
      break;
    }
  }
  
  public int findIndexByPanelType(int paramInt)
  {
    if ((this.panelDataList == null) || (this.panelDataList.isEmpty())) {}
    for (;;)
    {
      return 0;
      Iterator localIterator = this.panelDataList.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)localIterator.next();
        if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.type == paramInt)) {
          return i;
        }
        i += 1;
      }
    }
  }
  
  public BaseChatPie getAIOObj()
  {
    return this.mBaseChatPie;
  }
  
  public int getEmoticonTab(String paramString)
  {
    return this.mPanelMallHelper.getEmoticonTab(paramString, this.panelDataList, sIsRecommendExist);
  }
  
  protected int getFromType(boolean paramBoolean)
  {
    int j = 3;
    if (this.sessionType != -1)
    {
      int i = j;
      switch (Integer.valueOf(ChatActivityUtils.b(this.sessionType)).intValue())
      {
      case 2: 
      default: 
        i = j;
        if (paramBoolean) {
          i = 4;
        }
      case 1: 
        return i;
      case 0: 
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public <T extends AbstractEmoticonPanelHelper> T getHelper(int paramInt)
  {
    return this.mHelperProvider.getHelper(paramInt);
  }
  
  public EmotionPanelViewPagerAdapter getPageAdapter()
  {
    return this.pageAdapter;
  }
  
  public EmoticonMainPanel getPanel()
  {
    return this.mMainPanel;
  }
  
  public List<EmotionPanelInfo> getPanelDataList()
  {
    return this.panelDataList;
  }
  
  public void hideAllTabs()
  {
    if (this.mMainPanel == null) {}
    View localView;
    do
    {
      return;
      localView = this.mMainPanel.findViewById(2131378869);
    } while (localView == null);
    localView.setVisibility(8);
  }
  
  public void init()
  {
    this.mHelperProvider.dispatchLifeCycle(1);
    this.viewPager = ((EmoticonPanelViewPager)this.mMainPanel.findViewById(2131381588));
    this.viewPager.setOnPageChangeListener(this);
    this.pageAdapter = new EmotionPanelViewPagerAdapter(this.app, this.context, this.callback, this.mBaseChatPie, this.businessType, this.kanDianBiu);
    this.pageAdapter.isOnlySysEmotion = this.mParams.mIsOnlySysEmotion;
    this.pageAdapter.sysEmotionOrder = this.mSysEmotionOrder;
    this.pageAdapter.isFilterSysFaceBeyond255 = isFilterSysFaceBeyond255Enable();
    this.contentLayout = ((RelativeLayout)this.mMainPanel.findViewById(2131366299));
    this.mSecondTabContainer = this.mMainPanel.findViewById(2131365287);
    this.mEmoticonTabs = ((HorizontalListViewEx)this.mMainPanel.findViewById(2131378854));
    this.mMainPanel.mEmoticonTabs = this.mEmoticonTabs;
    this.mEmoticonTabs.setOnItemClickListener(this.mPanelMallHelper.tabItemClickListener);
    this.mEmoticonTabAdapter = new EmoticonTabAdapter(this.app, this.context, this.businessType);
    this.mEmoticonTabAdapter.setAIOShowStyleChange(isShowExtendPanel());
    this.mEmoticonTabAdapter.setGifEntranceIconUrl(this.mPanelTabSortHelper.getGifEntranceIconUrl());
    this.mEmoticonTabs.setTabAnimateEnable(isShowExtendPanel());
    this.mEmoticonTabs.setAdapter(this.mEmoticonTabAdapter);
    this.mNewFlag = ((ImageView)this.mMainPanel.findViewById(2131366265));
    this.contentLayout.setBackgroundColor(this.context.getResources().getColor(2131165639));
    this.mSecondTabContainer.setBackgroundColor(this.context.getResources().getColor(2131165638));
    this.mMainPanel.findViewById(2131378819).setBackgroundColor(this.context.getResources().getColor(2131165637));
    this.mOpenFirstTimeInAIO = true;
    if (this.mParams.defaultPanelType != -1) {
      initEmoticonView(this.mParams.defaultPanelType);
    }
    for (;;)
    {
      this.mHelperProvider.dispatchLifeCycle(2);
      registerOtherProcessCallback();
      return;
      initEmoticonView(this.mParams.defaultEpId);
    }
  }
  
  public void initEmoticonView(int paramInt)
  {
    this.mIsPositioningTab = true;
    sLastSelectedSecondTabIndex = findIndexByPanelType(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView panelType: " + paramInt + " selectIndex: " + sLastSelectedSecondTabIndex);
    }
    this.mPanelTabSortHelper.updateLastSelectedSecondTabIndex();
    initEmoticonView(sLastSelectedSecondTabIndex, null);
    this.isClickNoChangeTab = true;
    this.mPanelExtendHelper.initPanelExtendHeight();
    if (paramInt == 12) {
      this.mPanelHotPicSearchHelper.onSearchPullUp();
    }
  }
  
  void initEmoticonView(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 2, selectIndex = " + paramInt + ", defaultEpId = " + paramString);
    }
    int i = this.mPanelTabSortHelper.updateOriginalSelectIndex(paramInt);
    initGestureDetector();
    this.mMainPanel.isHiden = false;
    long l = System.currentTimeMillis();
    Object localObject = (CameraEmoRoamingManagerProxy)this.app.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER);
    int j;
    String str;
    if ((localObject != null) && (this.mEmoticonTabAdapter != null) && (((CameraEmoRoamingManagerProxy)localObject).isShowCameraEmoInApp()) && (i == findIndexByPanelType(11)))
    {
      j = 1;
      if (!EmoticonUtils.shouldDisplayBigEmoticon(this.sessionType))
      {
        this.mNewFlag.setVisibility(8);
        this.hasBigEmotion = false;
      }
      localObject = this.context.getSharedPreferences("mobileQQ", 0);
      str = ((SharedPreferences)localObject).getString("LAST_ADD_EMO_PACKAGE", "");
      if (TextUtils.isEmpty(str)) {
        break label335;
      }
      this.mMainPanel.mSecondTabInited = false;
      this.mMarketPgkDownloaded = false;
      ((SharedPreferences)localObject).edit().remove("LAST_ADD_EMO_PACKAGE").apply();
      ((SharedPreferences)localObject).edit().remove("LAST_ADD_EMO_PACKAGE_MAGIC").apply();
      paramInt = 0;
      label231:
      if (paramString == null) {
        break label377;
      }
      localObject = paramString;
      label238:
      if ((j == 0) || (paramString != null)) {
        break label395;
      }
      paramString = null;
    }
    for (;;)
    {
      new QueryTask(new EmoticonPanelController.6(this, i), new EmoticonPanelController.7(this, l)).a(paramString);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "ep_mall", "show_mine", "", 0, 0, 0, "", "", "");
      ABTestController.a("exp_qq_msg_marketface_recommendtab_2").a();
      ABTestController.a("exp_qq_msg_marketface_gif_icon").a();
      return;
      j = 0;
      break;
      label335:
      if ((this.hasBigEmotion) && (this.mMarketPgkDownloaded))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "new pkg downloaded in panel, refresh");
        }
        this.mMainPanel.mSecondTabInited = false;
      }
      paramInt = i;
      break label231;
      label377:
      localObject = str;
      if (!TextUtils.isEmpty(str)) {
        break label238;
      }
      localObject = null;
      break label238;
      label395:
      paramString = (String)localObject;
      i = paramInt;
    }
  }
  
  public void initEmoticonView(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "initEmoticonView 1");
    }
    this.mPanelTabSortHelper.updateLastSelectedSecondTabIndex();
    initEmoticonView(sLastSelectedSecondTabIndex, paramString);
    this.mPanelExtendHelper.initPanelExtendHeight();
  }
  
  void initTabView(int paramInt)
  {
    if (this.mMainPanel.mSecondTabInited) {}
    long l;
    List localList;
    do
    {
      return;
      l = System.currentTimeMillis();
      hideCmShowItemIfNeed(this.panelDataList);
      localList = this.panelDataList;
    } while ((localList == null) || (localList.size() == 0));
    if (paramInt == sRecommendEmoticonViewPoSition) {
      this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
    }
    Object localObject1 = "";
    int j = localList.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject2;
    EmoticonTabAdapter.EmoticonTabItem localEmoticonTabItem;
    if (i < j)
    {
      localObject2 = (EmotionPanelInfo)localList.get(i);
      localEmoticonTabItem = new EmoticonTabAdapter.EmoticonTabItem();
      localEmoticonTabItem.type = ((EmotionPanelInfo)localObject2).type;
      if (((EmotionPanelInfo)localObject2).type == 8) {
        localObject1 = HardCodeUtil.a(2131704077);
      }
    }
    for (;;)
    {
      localEmoticonTabItem.description = ((String)localObject1);
      localArrayList.add(localEmoticonTabItem);
      i += 1;
      break;
      if (((EmotionPanelInfo)localObject2).type == 9)
      {
        localObject1 = HardCodeUtil.a(2131704079);
      }
      else if (((EmotionPanelInfo)localObject2).type == 4)
      {
        localObject1 = HardCodeUtil.a(2131704101);
      }
      else if (((EmotionPanelInfo)localObject2).type == 7)
      {
        localObject1 = HardCodeUtil.a(2131704100);
      }
      else if ((((EmotionPanelInfo)localObject2).type == 6) || (((EmotionPanelInfo)localObject2).type == 10))
      {
        if (((EmotionPanelInfo)localObject2).emotionPkg != null)
        {
          EmoticonPackage localEmoticonPackage = ((EmotionPanelInfo)localObject2).emotionPkg;
          localObject2 = localEmoticonPackage.name + HardCodeUtil.a(2131704120);
          localObject1 = localObject2;
          if (localEmoticonPackage.status != 2) {
            localObject1 = (String)localObject2 + HardCodeUtil.a(2131704122);
          }
          localEmoticonTabItem.epId = localEmoticonPackage.epId;
          localEmoticonTabItem.subType = localEmoticonPackage.subType;
          if (localEmoticonPackage.status == 2) {}
          for (boolean bool = true;; bool = false)
          {
            localEmoticonTabItem.completed = bool;
            break;
          }
        }
      }
      else if (((EmotionPanelInfo)localObject2).type == 11)
      {
        localObject1 = HardCodeUtil.a(2131704065);
      }
      else if (((EmotionPanelInfo)localObject2).type == 13)
      {
        localObject1 = this.context.getResources().getString(2131692016);
      }
      else if (((EmotionPanelInfo)localObject2).type == 14)
      {
        localObject1 = this.context.getResources().getString(2131692024);
      }
      else if (((EmotionPanelInfo)localObject2).type == 12)
      {
        localObject1 = this.context.getResources().getString(2131689945);
      }
      else if (((EmotionPanelInfo)localObject2).type == 15)
      {
        localObject1 = this.context.getResources().getString(2131690590);
        continue;
        if (localArrayList.size() > 0)
        {
          if (this.isNeedResetX) {
            this.mEmoticonTabs.resetCurrentX(paramInt);
          }
          this.isNeedResetX = true;
          this.mEmoticonTabAdapter.updateData(localArrayList);
        }
        this.mMainPanel.mSecondTabInited = true;
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "[Performance] initSecondTabView duration:" + (System.currentTimeMillis() - l));
        }
        MobileReportManager.getInstance().reportAction("+", "4", "platform898", "6", "1", 101, 1, System.currentTimeMillis());
        return;
      }
    }
  }
  
  public boolean isEmoticonOnShow(int paramInt)
  {
    if ((this.panelDataList != null) && (sLastSelectedSecondTabIndex >= 0) && (sLastSelectedSecondTabIndex < this.panelDataList.size()))
    {
      EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)this.panelDataList.get(sLastSelectedSecondTabIndex);
      if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.type == paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isFilterSysFaceBeyond255Enable()
  {
    return this.isFilterSysFaceBeyond255Enable;
  }
  
  public boolean isPanelOpen()
  {
    return this.mPanelExtendHelper.isPanelOpen();
  }
  
  public boolean isShowExtendPanel()
  {
    return this.mPanelExtendHelper.isShowExtendPanel();
  }
  
  void onAttachedToWindow()
  {
    this.mHelperProvider.dispatchLifeCycle(9);
  }
  
  public void onDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "OnDestory");
    }
    this.mHelperProvider.dispatchLifeCycle(8);
    HorizontalListViewEx.destroyCacheView();
    EmotionPanelPayBackListenerManager.a().a();
    if (this.pageAdapter != null) {
      this.pageAdapter.onDestroy();
    }
    Object localObject = this.panelDataList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    this.mMainPanel.mSecondTabInited = false;
    if (this.app != null)
    {
      localObject = this.app.getApplication().getSharedPreferences("commonUsedSystemEmoji_sp", 0);
      long l = ((SharedPreferences)localObject).getLong("lastRequestTime", 0L);
      if ((System.currentTimeMillis() - l > 43200000L) || (System.currentTimeMillis() - l < 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "onDestroy commonused send");
        }
        ThreadManagerV2.excute(new EmoticonPanelController.3(this, (SharedPreferences)localObject), 64, null, true);
      }
      localObject = (EmoticonManagerProxy)this.app.getManager(QQManagerFactory.EMOTICON_MANAGER);
      if (localObject != null) {
        ((EmoticonManagerProxy)localObject).pushRecommendExposeInfoToSP();
      }
    }
    this.mWebPreloadHitSession.d();
    this.callback = null;
    if ((this.gestureDetector != null) && (this.mBaseChatPie != null) && (this.mBaseChatPie.c != null))
    {
      localObject = (TopGestureLayout)this.mBaseChatPie.c;
      GestureDetector localGestureDetector = ((TopGestureLayout)localObject).getGestureDetector();
      if ((localGestureDetector instanceof StickerGestureDetector))
      {
        ThreadManagerV2.getUIHandlerV2().post(new EmoticonPanelController.4(this, (TopGestureLayout)localObject, localGestureDetector));
        com.tencent.mobileqq.emoticon.EmojiStickerManager.a = false;
        this.mBaseChatPie.o(false);
        this.mBaseChatPie.o(false);
      }
      ((TopGestureLayout)localObject).restoreGestureDetector();
      this.gestureDetector = null;
    }
    if (ApolloCmEmojiReportUtil.a.a()) {
      ApolloCmEmojiReportUtil.a.a(this.mBaseChatPie);
    }
  }
  
  void onDetachedFromWindow()
  {
    this.detached = true;
    EmotionPanelListViewPool.getInstance().destory();
    EmotionPanelViewPool.getInstance().destory();
    this.mHelperProvider.dispatchLifeCycle(10);
  }
  
  public void onHide(boolean paramBoolean)
  {
    this.mHelperProvider.dispatchLifeCycle(4, -1, paramBoolean);
    if (ApolloCmEmojiReportUtil.a.a()) {
      ApolloCmEmojiReportUtil.a.a(this.mBaseChatPie);
    }
  }
  
  public void onMeasureMainPanel()
  {
    int i = this.mMainPanel.getMeasuredWidth();
    DisplayMetrics localDisplayMetrics = this.context.getResources().getDisplayMetrics();
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter;
    if (this.pageAdapter != null)
    {
      int j = this.pageAdapter.mainPanelWidth;
      if (i != j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "onMeasure: oldWidth=" + j + " newWidth=" + i);
        }
        EmotionPanelViewPool.getInstance().destory();
        EmotionPanelViewPool.widthPixels = i;
        localEmotionPanelViewPagerAdapter = this.pageAdapter;
        if (i / localDisplayMetrics.widthPixels >= 0.66F) {
          break label146;
        }
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      localEmotionPanelViewPagerAdapter.multiWindowMode = bool;
      this.pageAdapter.mainPanelWidth = i;
      ThreadManagerV2.getUIHandlerV2().post(new EmoticonPanelController.8(this));
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_PageScroll");
    Object localObject = this.panelDataList;
    if (localObject == null) {
      break label22;
    }
    label22:
    while (this.mPanelTabSortHelper.setSelection(paramInt)) {
      return;
    }
    localObject = (EmotionPanelInfo)((List)localObject).get(paramInt);
    int i;
    if ((localObject != null) && (this.pageAdapter != null))
    {
      this.pageAdapter.onPageSelected((EmotionPanelInfo)localObject);
      if (((EmotionPanelInfo)localObject).type != 7) {
        break label339;
      }
      i = 1;
    }
    for (;;)
    {
      label80:
      if (i > 0) {
        ReportController.b(this.app.getQQAppInterface(), "dc00898", "", "", "0x800a572", "0x800a572", 0, 0, i + "", i + "", i + "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "onPageSelected, position=" + paramInt + "panelInfo = " + localObject);
      }
      this.mPanelSettingHelper.switchMoreSettingStyle((EmotionPanelInfo)localObject);
      if (sLastSelectedSecondTabIndex != paramInt)
      {
        this.mEmoticonTabs.setSelection(paramInt);
        if (paramInt == sRecommendEmoticonViewPoSition) {
          this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
      }
      for (;;)
      {
        sLastSelectedSecondTabIndex = paramInt;
        this.mHelperProvider.dispatchLifeCycle(3, paramInt, false);
        StartupTracker.a("AIO_EmoticonPanel_PageScroll", null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmoticonPanelController", 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - l));
        return;
        label339:
        if ((((EmotionPanelInfo)localObject).type == 5) || (((EmotionPanelInfo)localObject).type == 4))
        {
          i = 2;
          break label80;
        }
        if (((EmotionPanelInfo)localObject).type == 11)
        {
          i = 3;
          break label80;
        }
        if (((EmotionPanelInfo)localObject).type == 8)
        {
          i = 4;
          break label80;
        }
        if (((EmotionPanelInfo)localObject).type == 9)
        {
          i = 5;
          break label80;
        }
        if ((((EmotionPanelInfo)localObject).emotionPkg == null) || (StringUtil.a(((EmotionPanelInfo)localObject).emotionPkg.epId))) {
          break label541;
        }
        i = 6;
        break label80;
        if ((localObject != null) && (((EmotionPanelInfo)localObject).type == 8))
        {
          ReportController.b(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, "", paramInt + "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelController", 2, "view times report. cur page:" + paramInt);
          }
        }
      }
      label541:
      i = -1;
    }
  }
  
  public void onPause()
  {
    if (this.app == null) {
      return;
    }
    this.isResumed = false;
    this.mHelperProvider.dispatchLifeCycle(7);
  }
  
  public void onPullDown()
  {
    this.mPanelExtendHelper.onPullDown();
    if (this.mEmoticonPanelCmshowHelper != null) {
      this.mEmoticonPanelCmshowHelper.onPullDown();
    }
  }
  
  public void onPullUp()
  {
    this.mPanelExtendHelper.onPullUp();
    if (this.mEmoticonPanelCmshowHelper != null) {
      this.mEmoticonPanelCmshowHelper.onPullUp();
    }
  }
  
  public void onResume()
  {
    StartupTracker.a(null, "AIO_EmoticonPanel_OnResume");
    this.isResumed = true;
    if ((this.mMainPanel.getVisibility() == 0) && (this.mNeedUpdate))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "onResume, Emoticon pkg moved、added or deleted, refresh");
      }
      this.mMainPanel.mSecondTabInited = false;
      updateLastSelectedSecondTabIndex();
      initEmoticonView(sLastSelectedSecondTabIndex, null);
      this.mDeleteLeftPkgCount = 0;
      this.mNeedUpdate = false;
    }
    for (;;)
    {
      this.mHelperProvider.dispatchLifeCycle(6);
      StartupTracker.a("AIO_EmoticonPanel_OnResume", null);
      return;
      if (this.mMainPanel.isShown())
      {
        if ((EmoticonUtils.shouldDisplayBigEmoticon(this.sessionType)) && (!TextUtils.isEmpty(this.context.getSharedPreferences("mobileQQ", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonPanelController", 2, "download in market, initEmoticonView");
          }
          initEmoticonView(sLastSelectedSecondTabIndex, null);
        }
        updateFavEmoticonPanel();
        this.mPanelCameraHelper.updateCameraEmoticonPanel();
      }
    }
  }
  
  public void onShow()
  {
    this.mHelperProvider.dispatchLifeCycle(5);
  }
  
  public void preloadWebProcess()
  {
    this.mPanelMallHelper.preloadWebProcess();
  }
  
  public void removePopupGuide()
  {
    this.mPanelSystemAndEmojiHelper.removePopupGuide();
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.callback = paramEmoticonCallback;
    this.mParams.callback = paramEmoticonCallback;
  }
  
  public void setCurType(int paramInt)
  {
    this.sessionType = paramInt;
    switch (paramInt)
    {
    case 100000: 
    default: 
      this.businessType = 0;
      return;
    case 99999: 
      this.businessType = 1;
      return;
    case 100001: 
      this.businessType = 2;
      return;
    case 100002: 
      this.businessType = 3;
      return;
    }
    this.businessType = 4;
  }
  
  @Deprecated
  public void setEmoSettingVisibility(int paramInt)
  {
    if (paramInt != 0) {
      this.mPanelTabSortHelper.hideEmoSetting();
    }
    this.mPanelSettingHelper.setEmoSettingVisibility(paramInt);
  }
  
  public void setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.isFilterSysFaceBeyond255Enable = paramBoolean;
    if (this.pageAdapter != null) {
      this.pageAdapter.isFilterSysFaceBeyond255 = paramBoolean;
    }
  }
  
  public void setHideAllSettingTabs(boolean paramBoolean)
  {
    this.mHideAllSettingTabs = paramBoolean;
  }
  
  public void setOnlySysEmotionEnable(boolean paramBoolean)
  {
    this.mIsOnlySysEmotion = paramBoolean;
    if (this.pageAdapter != null) {
      this.pageAdapter.isOnlySysEmotion = paramBoolean;
    }
  }
  
  public void setSysEmotionOrder(int[] paramArrayOfInt)
  {
    this.mSysEmotionOrder = paramArrayOfInt;
    if (this.pageAdapter != null) {
      this.pageAdapter.sysEmotionOrder = this.mSysEmotionOrder;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (paramInt != this.mMainPanel.getVisibility())
    {
      if (paramInt != 0) {
        break label209;
      }
      paramInt = this.context.getResources().getConfiguration().orientation;
      if (!this.mNeedUpdate) {
        break label176;
      }
      this.mMainPanel.mSecondTabInited = false;
      updateLastSelectedSecondTabIndex();
      initEmoticonView(null);
      this.mDeleteLeftPkgCount = 0;
      this.mNeedUpdate = false;
    }
    for (;;)
    {
      this.mOrientation = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "[Performance] reopen in aio, duration=" + (System.currentTimeMillis() - l));
      }
      this.mPanelSystemAndEmojiHelper.updateEmojiMallRedpoint();
      File localFile = new File(AppConstants.SDCARD_EMOTICON_SAVE);
      if (!localFile.exists())
      {
        boolean bool = localFile.mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelController", 2, "root dir not exist. try to make it. success:" + bool);
        }
      }
      return;
      label176:
      this.mMainPanel.mSecondTabInited = false;
      if (!this.mIsPositioningTab) {
        this.isNeedResetX = false;
      }
      this.mIsPositioningTab = false;
      initEmoticonView(null);
    }
    label209:
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelController.1(this), 1L);
  }
  
  public void showAllTabs()
  {
    if (this.mMainPanel == null) {}
    View localView;
    do
    {
      return;
      localView = this.mMainPanel.findViewById(2131378869);
    } while (localView == null);
    localView.setVisibility(0);
  }
  
  void showPanelByTabIndex(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "showPanelByTabIndex tabIndex = " + paramInt);
    }
    EmotionPanelInfo localEmotionPanelInfo = null;
    List localList = this.panelDataList;
    if (paramInt < localList.size()) {
      localEmotionPanelInfo = (EmotionPanelInfo)localList.get(paramInt);
    }
    if (localEmotionPanelInfo != null)
    {
      this.mPanelSettingHelper.switchSettingBtnStyle(localEmotionPanelInfo);
      this.viewPager.setCurrentItem(paramInt, false);
      this.mPanelCameraHelper.tryShowCameraEmoGuide(localEmotionPanelInfo);
    }
  }
  
  public void switchSystemEmojiTabLocationPos(int paramInt1, int paramInt2)
  {
    this.mPanelSystemAndEmojiHelper.switchSystemEmojiTabLocationPos(paramInt1, paramInt2);
  }
  
  public void switchTabMode(int paramInt)
  {
    paramInt = this.mPanelTabSortHelper.updateOriginalSelectIndex(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "switchTabMode selectIndex = " + paramInt);
    }
    if (this.app == null) {
      return;
    }
    long l = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_EnterSecond");
    if (!this.mMainPanel.mSecondTabInited)
    {
      this.mPanelMallHelper.asyncInitPanelDataList(this.hasBigEmotion, new EmoticonPanelController.2(this, paramInt, l));
      return;
    }
    setViewPagerAdapter(l, paramInt);
  }
  
  void syncInitPanelDataList(boolean paramBoolean)
  {
    if (this.mMainPanel.mSecondTabInited) {}
    while (this.mEmoticonListProvider == null) {
      return;
    }
    List localList = this.mEmoticonListProvider.getEmotionPanelInfo(paramBoolean, this.mParams.onlySysAndEmoji);
    this.panelDataList = this.mPanelTabSortHelper.getSortEmotionPanelInfoList(localList);
  }
  
  public void updateFavEmoticonPanel()
  {
    this.mPanelFavHelper.updateFavEmoticonPanel();
  }
  
  public void updateLastEmoticonPanel()
  {
    this.mPanelMallHelper.updateLastEmoticonPanel();
  }
  
  public void updateMagicPanel()
  {
    this.mPanelMallHelper.updateMagicPanel();
  }
  
  public void updateSystemAndEmojiPanel()
  {
    this.mPanelSystemAndEmojiHelper.updateSystemAndEmojiPanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController
 * JD-Core Version:    0.7.0.1
 */