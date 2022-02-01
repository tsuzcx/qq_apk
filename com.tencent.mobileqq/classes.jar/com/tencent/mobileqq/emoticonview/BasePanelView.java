package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.view.IBasePanelView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public class BasePanelView
  implements ViewPager.OnPageChangeListener, IBasePanelView
{
  private static final String LOG_TAG = "BasePanelView";
  static boolean sOpenFirstTimeInProcess = true;
  public static int sRecommendEmoticonViewPoSition = 3;
  private QQEmoticonMainPanelApp app;
  public RelativeLayout contentLayout;
  private Context context;
  float density;
  volatile boolean detached = false;
  private Object gestureDetector;
  public boolean hasBigEmotion = true;
  private boolean isFilterSysFaceBeyond255Enable = false;
  public boolean isNeedResetX = true;
  public boolean isResumed = false;
  public boolean kanDianBiu = false;
  int mDeleteLeftPkgCount = 0;
  public EmoticonTabAdapter mEmoticonTabAdapter;
  public HorizontalListViewEx mEmoticonTabs;
  boolean mHideAllSettingTabs;
  boolean mIsOnlySysEmotion;
  boolean mIsPositioningTab = false;
  private final EmoticonMainPanel mMainPanel;
  public boolean mMarketPgkDownloaded;
  boolean mNeedUpdate;
  public ImageView mNewFlag;
  boolean mOpenFirstTimeInAIO;
  int mOrientation;
  private final EmoticonPanelController mPanelController;
  public View mSecondTabContainer;
  private int[] mSysEmotionOrder = null;
  public EmotionPanelViewPagerAdapter pageAdapter;
  int toastOffset;
  public EmoticonPanelViewPager viewPager;
  
  public BasePanelView(IEmoticonMainPanel paramIEmoticonMainPanel)
  {
    this.mMainPanel = ((EmoticonMainPanel)paramIEmoticonMainPanel);
    this.mPanelController = this.mMainPanel.getEmoController();
    this.context = this.mMainPanel.getContext();
    this.mOrientation = this.context.getResources().getConfiguration().orientation;
    this.density = this.context.getResources().getDisplayMetrics().density;
    this.app = this.mPanelController.app;
  }
  
  private void setViewPagerAdapter(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.mSecondTabContainer.setVisibility(0);
    Object localObject1 = this.mPanelController.getPanelDataList();
    int i;
    if ((localObject1 != null) && (paramInt >= 0))
    {
      i = paramInt;
      if (paramInt < ((List)localObject1).size()) {}
    }
    else
    {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("switchTabMode selectIndex = ");
      ((StringBuilder)localObject2).append(i);
      QLog.d("BasePanelView", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = BaseApplication.getContext().getSharedPreferences("clubContentVersion", 0);
    if (((SharedPreferences)localObject2).getBoolean("force_to_recommend_panel_sp", false))
    {
      if (localObject1 != null)
      {
        paramInt = ((List)localObject1).size();
        int j = sRecommendEmoticonViewPoSition;
        if ((paramInt <= j) || (((EmotionPanelInfo)((List)localObject1).get(j)).type != 8))
        {
          BasePanelModel.sLastSelectedSecondTabIndex = i;
          break label175;
        }
      }
      BasePanelModel.sLastSelectedSecondTabIndex = sRecommendEmoticonViewPoSition;
      i = sRecommendEmoticonViewPoSition;
      label175:
      ((SharedPreferences)localObject2).edit().putBoolean("force_to_recommend_panel_sp", false).apply();
    }
    else
    {
      BasePanelModel.sLastSelectedSecondTabIndex = i;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("switchTabMode after recommend calculate, selectIndex = ");
      ((StringBuilder)localObject2).append(i);
      QLog.d("BasePanelView", 2, ((StringBuilder)localObject2).toString());
    }
    if (!this.mMainPanel.mSecondTabInited) {
      initTabView(i);
    }
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      paramInt = this.mEmoticonTabs.getSelectedItemPosition();
      if ((paramInt != i) || (paramInt == 0))
      {
        if (i == sRecommendEmoticonViewPoSition) {
          this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
        }
        this.mEmoticonTabs.setSelection(i);
      }
      this.pageAdapter.setData((List)localObject1);
      localObject2 = this.viewPager.getAdapter();
      EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = this.pageAdapter;
      if (localObject2 != localEmotionPanelViewPagerAdapter) {
        this.viewPager.setAdapter(localEmotionPanelViewPagerAdapter);
      }
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[Performance] switchTabMode to , setAdapter duration: ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        QLog.d("BasePanelView", 2, ((StringBuilder)localObject2).toString());
      }
      if (i < ((List)localObject1).size())
      {
        this.mPanelController.mPanelMallHelper.reportPageEvent((EmotionPanelInfo)((List)localObject1).get(i), true);
        if (!paramBoolean) {
          this.mPanelController.mDtReportHelper.updateAutoPaged(i, true);
        }
      }
      showPanelByTabIndex(i);
      if ((this.mOpenFirstTimeInAIO) && (i == 0))
      {
        localObject1 = (EmotionPanelInfo)((List)localObject1).get(i);
        this.pageAdapter.onPageSelected((EmotionPanelInfo)localObject1);
      }
    }
    else
    {
      this.viewPager.setAdapter(null);
    }
    StartupTracker.a("AIO_EmoticonPanel_EnterSecond", null);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[Performance] switchTabMode to , duration:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - paramLong);
      ((StringBuilder)localObject1).append(",mSecondTabInited:");
      ((StringBuilder)localObject1).append(this.mMainPanel.mSecondTabInited);
      QLog.d("BasePanelView", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected EmoticonTabAdapter.EmoticonTabItem convertEmoticonTabItem(EmotionPanelInfo paramEmotionPanelInfo)
  {
    EmoticonTabAdapter.EmoticonTabItem localEmoticonTabItem = new EmoticonTabAdapter.EmoticonTabItem();
    localEmoticonTabItem.type = paramEmotionPanelInfo.type;
    if (paramEmotionPanelInfo.type == 8)
    {
      paramEmotionPanelInfo = HardCodeUtil.a(2131704166);
    }
    else if (paramEmotionPanelInfo.type == 9)
    {
      paramEmotionPanelInfo = HardCodeUtil.a(2131704168);
    }
    else if (paramEmotionPanelInfo.type == 4)
    {
      paramEmotionPanelInfo = HardCodeUtil.a(2131704190);
    }
    else if (paramEmotionPanelInfo.type == 7)
    {
      paramEmotionPanelInfo = HardCodeUtil.a(2131704189);
    }
    else
    {
      if ((paramEmotionPanelInfo.type != 6) && (paramEmotionPanelInfo.type != 10))
      {
        if (paramEmotionPanelInfo.type == 11)
        {
          paramEmotionPanelInfo = HardCodeUtil.a(2131704154);
          break label374;
        }
        if (paramEmotionPanelInfo.type == 13)
        {
          paramEmotionPanelInfo = this.context.getResources().getString(2131691937);
          break label374;
        }
        if (paramEmotionPanelInfo.type == 14)
        {
          paramEmotionPanelInfo = this.context.getResources().getString(2131691943);
          break label374;
        }
        if (paramEmotionPanelInfo.type == 12)
        {
          paramEmotionPanelInfo = this.context.getResources().getString(2131689860);
          break label374;
        }
        if (paramEmotionPanelInfo.type == 15)
        {
          paramEmotionPanelInfo = this.context.getResources().getString(2131690518);
          break label374;
        }
      }
      else if (paramEmotionPanelInfo.emotionPkg != null)
      {
        EmoticonPackage localEmoticonPackage = paramEmotionPanelInfo.emotionPkg;
        paramEmotionPanelInfo = new StringBuilder();
        paramEmotionPanelInfo.append(localEmoticonPackage.name);
        paramEmotionPanelInfo.append(HardCodeUtil.a(2131704208));
        String str = paramEmotionPanelInfo.toString();
        paramEmotionPanelInfo = str;
        if (localEmoticonPackage.status != 2)
        {
          paramEmotionPanelInfo = new StringBuilder();
          paramEmotionPanelInfo.append(str);
          paramEmotionPanelInfo.append(HardCodeUtil.a(2131704210));
          paramEmotionPanelInfo = paramEmotionPanelInfo.toString();
        }
        localEmoticonTabItem.epId = localEmoticonPackage.epId;
        localEmoticonTabItem.subType = localEmoticonPackage.subType;
        boolean bool;
        if (localEmoticonPackage.status == 2) {
          bool = true;
        } else {
          bool = false;
        }
        localEmoticonTabItem.completed = bool;
        break label374;
      }
      paramEmotionPanelInfo = "";
    }
    label374:
    localEmoticonTabItem.description = paramEmotionPanelInfo;
    return localEmoticonTabItem;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (EmoticonMainPanel.sOpenStartTime == -1L) {
      return;
    }
    long l = System.currentTimeMillis() - EmoticonMainPanel.sOpenStartTime;
    if (l <= 0L) {
      return;
    }
    paramCanvas = new HashMap(2);
    int i;
    if (sOpenFirstTimeInProcess) {
      i = 1;
    } else if (this.mOpenFirstTimeInAIO) {
      i = 2;
    } else {
      i = 3;
    }
    paramCanvas.put("panelMode", "2");
    paramCanvas.put("duration", String.valueOf(l));
    ThreadManager.post(new BasePanelView.5(this, i, l, paramCanvas), 5, null, true);
    StartupTracker.a("AIO_EmoticonPanel_OpenDuration", null);
    if (QLog.isColorLevel())
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("[Performance] dispatchDraw over, duration=");
      paramCanvas.append(l);
      paramCanvas.append(",openCondition=");
      paramCanvas.append(i);
      paramCanvas.append(",panelMode=");
      paramCanvas.append("2");
      QLog.d("BasePanelView", 2, paramCanvas.toString());
      paramCanvas = new StringBuilder();
      paramCanvas.append("open EmoticonPanel duration=");
      paramCanvas.append(l);
      QLog.d("StressTesting.Emoticon.PanelCreate", 2, paramCanvas.toString());
    }
    EmoticonMainPanel.sOpenStartTime = -1L;
    this.mOpenFirstTimeInAIO = false;
    sOpenFirstTimeInProcess = false;
  }
  
  protected void execQueryTask(int paramInt, long paramLong, String paramString)
  {
    new QueryTask(new BasePanelView.1(this, paramInt), new BasePanelView.2(this, paramLong)).execute(paramString);
  }
  
  public Context getContext()
  {
    return this.mMainPanel.getContext();
  }
  
  public EmoticonPanelController getController()
  {
    return this.mPanelController;
  }
  
  public EmoticonMainPanel getMainPanel()
  {
    return this.mMainPanel;
  }
  
  public int[] getSysEmotionOrder()
  {
    return this.mSysEmotionOrder;
  }
  
  public void hideAllTabs()
  {
    Object localObject = this.mMainPanel;
    if (localObject == null) {
      return;
    }
    localObject = ((EmoticonMainPanel)localObject).findViewById(2131378258);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  public void initEmoticonView(int paramInt)
  {
    this.mIsPositioningTab = true;
    BasePanelModel.sLastSelectedSecondTabIndex = this.mPanelController.findIndexByPanelType(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initEmoticonView panelType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" selectIndex: ");
      localStringBuilder.append(BasePanelModel.sLastSelectedSecondTabIndex);
      QLog.d("BasePanelView", 2, localStringBuilder.toString());
    }
    this.mPanelController.mPanelTabSortHelper.updateLastSelectedSecondTabIndex();
    this.mPanelController.initEmoticonView(BasePanelModel.sLastSelectedSecondTabIndex, null);
    this.mPanelController.mPanelMallHelper.isClickNoChangeTab = true;
    this.mPanelController.mPanelExtendHelper.initPanelExtendHeight();
    if (paramInt == 12) {
      this.mPanelController.mPanelHotPicSearchHelper.onSearchPullUp();
    }
  }
  
  public void initEmoticonView(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initEmoticonView 2, selectIndex = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", defaultEpId = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("BasePanelView", 2, ((StringBuilder)localObject).toString());
    }
    int i = this.mPanelController.mPanelTabSortHelper.updateOriginalSelectIndex(paramInt);
    initGestureDetector();
    Object localObject = getMainPanel();
    paramInt = 0;
    ((EmoticonMainPanel)localObject).isHiden = false;
    long l = System.currentTimeMillis();
    localObject = (CameraEmoRoamingManagerServiceProxy)this.app.getRuntimeService(ICameraEmoRoamingManagerService.class);
    int j;
    if ((localObject != null) && (this.mEmoticonTabAdapter != null) && (((CameraEmoRoamingManagerServiceProxy)localObject).isShowCameraEmoInApp()) && (i == this.mPanelController.findIndexByPanelType(11))) {
      j = 1;
    } else {
      j = 0;
    }
    if (!EmoticonPanelUtils.c(this.mPanelController.getSessionType()))
    {
      this.mNewFlag.setVisibility(8);
      this.hasBigEmotion = false;
    }
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences("mobileQQ", 0);
    localObject = localSharedPreferences.getString("LAST_ADD_EMO_PACKAGE", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      getMainPanel().mSecondTabInited = false;
      this.mMarketPgkDownloaded = false;
      localSharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE").apply();
      localSharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE_MAGIC").apply();
    }
    else
    {
      if ((this.hasBigEmotion) && (this.mMarketPgkDownloaded))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BasePanelView", 2, "new pkg downloaded in panel, refresh");
        }
        getMainPanel().mSecondTabInited = false;
      }
      paramInt = i;
    }
    localSharedPreferences = null;
    if (paramString != null) {
      localObject = paramString;
    } else if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = null;
    }
    if ((j != 0) && (paramString == null))
    {
      localObject = localSharedPreferences;
      paramInt = i;
    }
    execQueryTask(paramInt, l, (String)localObject);
    VasWebviewUtil.a(this.app.getCurrentUin(), "ep_mall", "show_mine", "", 0, 0, 0, "", "", "");
    ABTestController.a().a("exp_qq_msg_marketface_gif_icon").a();
  }
  
  public void initEmoticonView(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BasePanelView", 2, "initEmoticonView 1");
    }
    this.mPanelController.updateTabSortLastSelectedSecondTabIndex();
    this.mPanelController.initEmoticonView(BasePanelModel.sLastSelectedSecondTabIndex, paramString);
    this.mPanelController.initPanelExtendHeight();
  }
  
  public void initGestureDetector()
  {
    this.gestureDetector = ((IEmosmService)QRoute.api(IEmosmService.class)).initGestureDetector(this.gestureDetector, this.context, this.mPanelController.getInteractionListener());
  }
  
  public void initQueryFinish(Integer paramInteger, long paramLong)
  {
    boolean bool = EmoticonStoreTabEntryUtils.checkTabListCanShowGuide(this.mPanelController.getPanelDataList());
    Integer localInteger = paramInteger;
    if (bool)
    {
      localInteger = paramInteger;
      if (EmoticonStoreTabEntryUtils.checkIsNeedShowGuide()) {
        localInteger = Integer.valueOf(0);
      }
    }
    initTabView(localInteger.intValue());
    switchTabMode(localInteger.intValue());
    if ((!this.mPanelController.getParams().disableGuide) && (!this.mPanelController.getParams().disableGuideOneTime)) {
      this.mPanelController.mPanelSystemAndEmojiHelper.showEmoticonPopupGuide();
    }
    this.mPanelController.getParams().disableGuideOneTime = false;
    if (QLog.isColorLevel())
    {
      paramInteger = new StringBuilder();
      paramInteger.append("selectIndex = ");
      paramInteger.append(localInteger);
      paramInteger.append("[Performance] initEmoticonView duration:");
      paramInteger.append(System.currentTimeMillis() - paramLong);
      QLog.d("BasePanelView", 2, paramInteger.toString());
    }
    if (!this.mPanelController.getParams().disableAutoDownload) {
      this.mPanelController.mPanelFavHelper.roamTenEmoticon();
    }
    paramInteger = this.mPanelController.getPanelDataList();
    int i = paramInteger.size();
    int j = sRecommendEmoticonViewPoSition;
    if (i > j)
    {
      if (((EmotionPanelInfo)paramInteger.get(j)).type != 8) {
        EmotionUtils.a(this.app, this.mPanelController.getBusinessType());
      }
    }
    else {
      EmotionUtils.a(this.app, this.mPanelController.getBusinessType());
    }
    this.mPanelController.mPanelCameraHelper.tryUpdateGuideImg();
    if ((bool) && (EmoticonStoreTabEntryUtils.checkIsNeedShowGuide()))
    {
      i = (int)this.mMainPanel.getResources().getDimension(2131296966);
      j = ViewUtils.b(8.0F);
      this.mPanelController.mPanelSettingHelper.showGuideView(this.mMainPanel, j, i);
    }
    this.mPanelController.onShowPageFinish();
  }
  
  void initTabView(int paramInt)
  {
    if (this.mMainPanel.mSecondTabInited) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject = this.mPanelController;
    ((EmoticonPanelController)localObject).hideCmShowItemIfNeed(((EmoticonPanelController)localObject).getPanelDataList());
    localObject = this.mPanelController.getPanelDataList();
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      int j = sRecommendEmoticonViewPoSition;
      int i = 0;
      if (paramInt == j) {
        this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
      }
      j = ((List)localObject).size();
      ArrayList localArrayList = new ArrayList();
      while (i < j)
      {
        localArrayList.add(convertEmoticonTabItem((EmotionPanelInfo)((List)localObject).get(i)));
        i += 1;
      }
      if (localArrayList.size() > 0)
      {
        if (this.isNeedResetX) {
          this.mEmoticonTabs.resetCurrentX(paramInt);
        }
        this.isNeedResetX = true;
        this.mEmoticonTabAdapter.updateData(localArrayList);
      }
      this.mMainPanel.mSecondTabInited = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Performance] initSecondTabView duration:");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        QLog.d("BasePanelView", 2, ((StringBuilder)localObject).toString());
      }
      ((IMobileReportManager)QRoute.api(IMobileReportManager.class)).reportAction("+", "4", "platform898", "6", "1", 101, 1, System.currentTimeMillis());
    }
  }
  
  public void initView()
  {
    this.mOpenFirstTimeInAIO = true;
    this.toastOffset = this.mPanelController.getParams().toastOffset;
    this.viewPager = ((EmoticonPanelViewPager)this.mMainPanel.findViewById(2131380822));
    this.viewPager.setOnPageChangeListener(this);
    this.pageAdapter = new EmotionPanelViewPagerAdapter(this.mPanelController.app, this.mPanelController.getInteractionListener(), this.mPanelController.context, this.mPanelController.callback, this.mPanelController.getBusinessType(), this.kanDianBiu);
    this.pageAdapter.setPanelInjectionInfoManager(this.mPanelController.getEmotionPanelManager());
    this.pageAdapter.setPanelController(this.mPanelController);
    this.pageAdapter.isOnlySysEmotion = this.mPanelController.getParams().mIsOnlySysEmotion;
    Object localObject = this.pageAdapter;
    ((EmotionPanelViewPagerAdapter)localObject).sysEmotionOrder = this.mSysEmotionOrder;
    ((EmotionPanelViewPagerAdapter)localObject).isFilterSysFaceBeyond255 = this.mPanelController.isFilterSysFaceBeyond255Enable();
    this.contentLayout = ((RelativeLayout)this.mMainPanel.findViewById(2131366187));
    this.mSecondTabContainer = this.mMainPanel.findViewById(2131365162);
    this.mEmoticonTabs = ((HorizontalListViewEx)this.mMainPanel.findViewById(2131378243));
    localObject = this.mMainPanel;
    HorizontalListViewEx localHorizontalListViewEx = this.mEmoticonTabs;
    ((EmoticonMainPanel)localObject).mEmoticonTabs = localHorizontalListViewEx;
    localHorizontalListViewEx.setOnItemClickListener(this.mPanelController.getTabItemClickListener());
    this.mEmoticonTabAdapter = new EmoticonTabAdapter(this.mPanelController.app, this.mPanelController.getEmotionPanelManager(), this.mPanelController.context, this.mPanelController.getBusinessType());
    this.mEmoticonTabAdapter.setAIOShowStyleChange(this.mPanelController.isShowExtendPanel());
    this.mEmoticonTabAdapter.setGifEntranceIconUrl(this.mPanelController.getGifEntranceIconUrl());
    this.mEmoticonTabs.setTabAnimateEnable(this.mPanelController.isShowExtendPanel());
    this.mEmoticonTabs.setAdapter(this.mEmoticonTabAdapter);
    this.mNewFlag = ((ImageView)this.mMainPanel.findViewById(2131366153));
    this.contentLayout.setBackgroundColor(this.context.getResources().getColor(2131165620));
    this.mSecondTabContainer.setBackgroundColor(this.context.getResources().getColor(2131165619));
    this.mMainPanel.findViewById(2131378207).setBackgroundColor(this.context.getResources().getColor(2131165618));
    if (this.mPanelController.getParams().defaultPanelType != -1)
    {
      initEmoticonView(this.mPanelController.getParams().defaultPanelType);
      return;
    }
    initEmoticonView(this.mPanelController.getParams().defaultEpId);
  }
  
  public boolean isFilterSysFaceBeyond255Enable()
  {
    return this.isFilterSysFaceBeyond255Enable;
  }
  
  public void onAttachedToWindow() {}
  
  public void onDestory()
  {
    HorizontalListViewEx.destroyCacheView();
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = this.pageAdapter;
    if (localEmotionPanelViewPagerAdapter != null) {
      localEmotionPanelViewPagerAdapter.onDestroy();
    }
    this.mMainPanel.mSecondTabInited = false;
    this.gestureDetector = ((IEmosmService)QRoute.api(IEmosmService.class)).gestureDetectorDestory(this.gestureDetector, this.mPanelController.getInteractionListener());
  }
  
  public void onDetachedFromWindow()
  {
    this.detached = true;
    EmotionPanelListViewPool.getInstance().destory();
    EmotionPanelViewPool.getInstance().destory();
  }
  
  public void onMeasureMainPanel()
  {
    int i = this.mMainPanel.getMeasuredWidth();
    DisplayMetrics localDisplayMetrics = this.context.getResources().getDisplayMetrics();
    Object localObject = this.pageAdapter;
    if (localObject != null)
    {
      int j = ((EmotionPanelViewPagerAdapter)localObject).mainPanelWidth;
      if (i != j)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onMeasure: oldWidth=");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(" newWidth=");
          ((StringBuilder)localObject).append(i);
          QLog.d("BasePanelView", 2, ((StringBuilder)localObject).toString());
        }
        EmotionPanelViewPool.getInstance().destory();
        EmotionPanelViewPool.widthPixels = i;
        localObject = this.pageAdapter;
        boolean bool;
        if (i / localDisplayMetrics.widthPixels < 0.66F) {
          bool = true;
        } else {
          bool = false;
        }
        ((EmotionPanelViewPagerAdapter)localObject).multiWindowMode = bool;
        this.pageAdapter.mainPanelWidth = i;
        ThreadManagerV2.getUIHandlerV2().post(new BasePanelView.6(this));
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    long l = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_PageScroll");
    Object localObject1 = this.mPanelController.getPanelDataList();
    if (localObject1 == null) {
      return;
    }
    if (this.mPanelController.mPanelTabSortHelper.setSelection(paramInt)) {
      return;
    }
    localObject1 = (EmotionPanelInfo)((List)localObject1).get(paramInt);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.pageAdapter;
      if (localObject2 != null)
      {
        ((EmotionPanelViewPagerAdapter)localObject2).onPageSelected((EmotionPanelInfo)localObject1);
        int j = ((EmotionPanelInfo)localObject1).type;
        int i = 5;
        if (j == 7) {
          i = 1;
        } else if ((((EmotionPanelInfo)localObject1).type != 5) && (((EmotionPanelInfo)localObject1).type != 4))
        {
          if (((EmotionPanelInfo)localObject1).type == 11) {
            i = 3;
          } else if (((EmotionPanelInfo)localObject1).type == 8) {
            i = 4;
          } else if (((EmotionPanelInfo)localObject1).type != 9) {
            if ((((EmotionPanelInfo)localObject1).emotionPkg != null) && (!StringUtil.a(((EmotionPanelInfo)localObject1).emotionPkg.epId))) {
              i = 6;
            } else {
              i = -1;
            }
          }
        }
        else {
          i = 2;
        }
        if (i > 0)
        {
          localObject2 = this.app.getQQAppInterface();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append("");
          localObject4 = ((StringBuilder)localObject4).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          localStringBuilder.append("");
          ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0x800a572", "0x800a572", 0, 0, (String)localObject3, (String)localObject4, localStringBuilder.toString(), "");
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPageSelected, position=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("panelInfo = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("BasePanelView", 2, ((StringBuilder)localObject2).toString());
    }
    this.mPanelController.mPanelSettingHelper.switchMoreSettingStyle((EmotionPanelInfo)localObject1);
    if (BasePanelModel.sLastSelectedSecondTabIndex != paramInt)
    {
      this.mEmoticonTabs.setSelection(paramInt);
      if (paramInt == sRecommendEmoticonViewPoSition) {
        this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
      }
    }
    else if ((localObject1 != null) && (((EmotionPanelInfo)localObject1).type == 8))
    {
      localObject1 = this.app.getQQAppInterface();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("");
      ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, "", ((StringBuilder)localObject2).toString(), "", "");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("view times report. cur page:");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("BasePanelView", 2, ((StringBuilder)localObject1).toString());
      }
    }
    BasePanelModel.sLastSelectedSecondTabIndex = paramInt;
    this.mPanelController.getHelperProvider().dispatchLifeCycle(3, paramInt, false);
    StartupTracker.a("AIO_EmoticonPanel_PageScroll", null);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[Performance] onPageSelected, handle duration=");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.d("BasePanelView", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void onPause()
  {
    this.isResumed = false;
  }
  
  public void onResume()
  {
    StartupTracker.a(null, "AIO_EmoticonPanel_OnResume");
    this.isResumed = true;
    if ((this.mMainPanel.getVisibility() == 0) && (this.mNeedUpdate))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BasePanelView", 2, "onResume, Emoticon pkg moved、added or deleted, refresh");
      }
      this.mMainPanel.mSecondTabInited = false;
      this.mPanelController.updateLastSelectedSecondTabIndex();
      this.mPanelController.initEmoticonView(BasePanelModel.sLastSelectedSecondTabIndex, null);
      this.mDeleteLeftPkgCount = 0;
      this.mNeedUpdate = false;
    }
    else if (this.mMainPanel.isShown())
    {
      if ((EmoticonPanelUtils.c(this.mPanelController.getSessionType())) && (!TextUtils.isEmpty(this.context.getSharedPreferences("mobileQQ", 0).getString("LAST_ADD_EMO_PACKAGE", ""))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BasePanelView", 2, "download in market, initEmoticonView");
        }
        this.mPanelController.initEmoticonView(BasePanelModel.sLastSelectedSecondTabIndex, null);
      }
      this.mPanelController.updateFavEmoticonPanel();
      this.mPanelController.mPanelCameraHelper.updateCameraEmoticonPanel();
    }
    this.mPanelController.getHelperProvider().dispatchLifeCycle(6);
    StartupTracker.a("AIO_EmoticonPanel_OnResume", null);
  }
  
  public void setEmoticonApp(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp)
  {
    this.app = paramQQEmoticonMainPanelApp;
  }
  
  public void setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.isFilterSysFaceBeyond255Enable = paramBoolean;
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = this.pageAdapter;
    if (localEmotionPanelViewPagerAdapter != null) {
      localEmotionPanelViewPagerAdapter.isFilterSysFaceBeyond255 = paramBoolean;
    }
  }
  
  public void setOnlySysEmotionEnable(boolean paramBoolean)
  {
    this.mIsOnlySysEmotion = paramBoolean;
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = this.pageAdapter;
    if (localEmotionPanelViewPagerAdapter != null) {
      localEmotionPanelViewPagerAdapter.isOnlySysEmotion = paramBoolean;
    }
  }
  
  public void setOverScrollMode(int paramInt)
  {
    HorizontalListViewEx localHorizontalListViewEx = this.mEmoticonTabs;
    if (localHorizontalListViewEx != null) {
      localHorizontalListViewEx.setOverScrollMode(paramInt);
    }
  }
  
  public void setSysEmotionOrder(int[] paramArrayOfInt)
  {
    this.mSysEmotionOrder = paramArrayOfInt;
    paramArrayOfInt = this.pageAdapter;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.sysEmotionOrder = this.mSysEmotionOrder;
    }
  }
  
  public void setViewData(EmoticonPanelParams paramEmoticonPanelParams)
  {
    this.mMainPanel.disableAutoDownload = paramEmoticonPanelParams.disableAutoDownload;
    this.mMainPanel.disableMoreEmotionButton = paramEmoticonPanelParams.disableMoreEmotionButton;
    this.mMainPanel.hasBigEmotion = paramEmoticonPanelParams.hasBigEmotion;
    this.mMainPanel.onlySysAndEmoji = paramEmoticonPanelParams.onlySysAndEmoji;
    this.mMainPanel.disableGuide = paramEmoticonPanelParams.disableGuide;
    this.mMainPanel.disableGuideOneTime = paramEmoticonPanelParams.disableGuideOneTime;
  }
  
  public void setVisibility(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (paramInt != this.mMainPanel.getVisibility()) {
      if (paramInt == 0)
      {
        paramInt = this.context.getResources().getConfiguration().orientation;
        if (this.mNeedUpdate)
        {
          this.mMainPanel.mSecondTabInited = false;
          this.mPanelController.updateLastSelectedSecondTabIndex();
          initEmoticonView(null);
          this.mDeleteLeftPkgCount = 0;
          this.mNeedUpdate = false;
        }
        else
        {
          this.mMainPanel.mSecondTabInited = false;
          if (!this.mIsPositioningTab) {
            this.isNeedResetX = false;
          }
          this.mIsPositioningTab = false;
          initEmoticonView(null);
        }
        this.mOrientation = paramInt;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[Performance] reopen in aio, duration=");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
          QLog.d("BasePanelView", 2, ((StringBuilder)localObject).toString());
        }
        this.mPanelController.updateEmojiMallRedpoint();
        Object localObject = new File(AppConstants.SDCARD_EMOTICON_SAVE);
        if (!((File)localObject).exists())
        {
          boolean bool = ((File)localObject).mkdirs();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("root dir not exist. try to make it. success:");
            ((StringBuilder)localObject).append(bool);
            QLog.d("BasePanelView", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      else
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new BasePanelView.3(this), 1L);
      }
    }
  }
  
  public void showAllTabs()
  {
    Object localObject = this.mMainPanel;
    if (localObject == null) {
      return;
    }
    localObject = ((EmoticonMainPanel)localObject).findViewById(2131378258);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
  }
  
  public void showPanelByTabIndex(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showPanelByTabIndex tabIndex = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("BasePanelView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    List localList = this.mPanelController.getPanelDataList();
    if (paramInt < localList.size()) {
      localObject = (EmotionPanelInfo)localList.get(paramInt);
    }
    if (localObject != null)
    {
      this.mPanelController.mPanelSettingHelper.switchSettingBtnStyle((EmotionPanelInfo)localObject);
      this.viewPager.setCurrentItem(paramInt, false);
      this.mPanelController.mPanelCameraHelper.tryShowCameraEmoGuide((EmotionPanelInfo)localObject);
    }
  }
  
  public void switchTabMode(int paramInt)
  {
    paramInt = this.mPanelController.mPanelTabSortHelper.updateOriginalSelectIndex(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchTabMode selectIndex = ");
      localStringBuilder.append(paramInt);
      QLog.d("BasePanelView", 2, localStringBuilder.toString());
    }
    if (this.app == null) {
      return;
    }
    long l = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_EnterSecond");
    if (!this.mMainPanel.mSecondTabInited)
    {
      this.mPanelController.mPanelMallHelper.asyncInitPanelDataList(this.hasBigEmotion, new BasePanelView.4(this, paramInt, l));
      return;
    }
    setViewPagerAdapter(l, paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BasePanelView
 * JD-Core Version:    0.7.0.1
 */