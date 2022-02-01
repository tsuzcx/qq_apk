package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.EmotionPanelInjectionInfoManager;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloCmEmojiReportHelper;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelController
  implements EmotionPanelListView.PullAndFastScrollListener, IEmoticonPanelController
{
  private static final String LOG_TAG = "EmoticonPanelController";
  QQEmoticonMainPanelApp app;
  EmoticonCallback callback;
  final Context context;
  BaseAIOContext mAIOContext;
  BasePanelModel mBasePanelModel;
  BasePanelView mBasePanelView;
  final EmoticonReportDtHelper mDtReportHelper;
  private EmoticonHelperProvider mHelperProvider;
  IPanelInteractionListener mInteractionListener;
  final EmoticonPanelCameraHelper mPanelCameraHelper;
  final EmoticonPanelExtendHelper mPanelExtendHelper;
  final EmoticonPanelFavHelper mPanelFavHelper;
  final EmoticonPanelHotPicSearchHelper mPanelHotPicSearchHelper;
  final EmoticonPanelMallHelper mPanelMallHelper;
  final EmoticonPanelSettingHelper mPanelSettingHelper;
  final EmoticonPanelSystemAndEmojiHelper mPanelSystemAndEmojiHelper;
  final EmoticonPanelTabSortHelper mPanelTabSortHelper;
  
  protected EmoticonPanelController(Context paramContext)
  {
    this.context = paramContext;
    this.mHelperProvider = new EmoticonHelperProvider(this);
    this.mPanelExtendHelper = ((EmoticonPanelExtendHelper)getHelper(1));
    this.mPanelFavHelper = ((EmoticonPanelFavHelper)getHelper(2));
    this.mPanelCameraHelper = ((EmoticonPanelCameraHelper)getHelper(3));
    this.mPanelSystemAndEmojiHelper = ((EmoticonPanelSystemAndEmojiHelper)getHelper(4));
    this.mPanelMallHelper = ((EmoticonPanelMallHelper)getHelper(5));
    this.mPanelSettingHelper = ((EmoticonPanelSettingHelper)getHelper(6));
    this.mPanelTabSortHelper = ((EmoticonPanelTabSortHelper)getHelper(8));
    this.mPanelHotPicSearchHelper = ((EmoticonPanelHotPicSearchHelper)getHelper(7));
    this.mDtReportHelper = ((EmoticonReportDtHelper)getHelper(10));
  }
  
  private void registerOtherProcessCallback()
  {
    if (!QQEmoticonMainPanelApp.isMainProcess())
    {
      QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.app;
      if (localQQEmoticonMainPanelApp != null) {
        localQQEmoticonMainPanelApp.registerOtherProcessCallback();
      }
    }
  }
  
  public void deleteEmoticonClick()
  {
    EmoticonCallback localEmoticonCallback = this.callback;
    if (localEmoticonCallback != null) {
      localEmoticonCallback.delete();
    }
    this.mBasePanelModel.reportDeleteEmoticonClick();
  }
  
  void dispatchDraw(Canvas paramCanvas)
  {
    this.mBasePanelView.dispatchDraw(paramCanvas);
  }
  
  public int findIndexByPanelType(int paramInt)
  {
    return this.mBasePanelModel.findIndexByPanelType(paramInt);
  }
  
  public int findTabIndexByEpId(String paramString)
  {
    return this.mPanelMallHelper.findTabIndexByEpId(this.app, paramString, getPanelDataList());
  }
  
  public BaseAIOContext getAIOContext()
  {
    return this.mAIOContext;
  }
  
  public BasePanelModel getBasePanelModel()
  {
    return this.mBasePanelModel;
  }
  
  public BasePanelView getBasePanelView()
  {
    return this.mBasePanelView;
  }
  
  public int getBusinessType()
  {
    return this.mBasePanelModel.businessType;
  }
  
  public int getDeleteLeftPkgCount()
  {
    return this.mBasePanelView.mDeleteLeftPkgCount;
  }
  
  public EmoticonListProvider getEmoticonListProvider()
  {
    return this.mBasePanelModel.getEmoticonListProvider();
  }
  
  public int getEmoticonTab(String paramString)
  {
    return this.mPanelMallHelper.getEmoticonTab(paramString, getPanelDataList(), BasePanelModel.sIsRecommendExist);
  }
  
  public EmoticonTabAdapter getEmoticonTabAdapter()
  {
    return this.mBasePanelView.mEmoticonTabAdapter;
  }
  
  public EmotionInjectionInfo getEmotionInjectionInfo(int paramInt)
  {
    return this.mBasePanelModel.getEmotionInjectionInfo(paramInt);
  }
  
  public EmotionPanelInjectionInfoManager getEmotionPanelManager()
  {
    return this.mBasePanelModel.mEmotionPanelInjectionInfoManager;
  }
  
  protected int getFromType(boolean paramBoolean)
  {
    return this.mBasePanelModel.getFromType(paramBoolean);
  }
  
  public String getGifEntranceIconUrl()
  {
    return this.mPanelTabSortHelper.getGifEntranceIconUrl();
  }
  
  public <T extends AbstractEmoticonPanelHelper> T getHelper(int paramInt)
  {
    return this.mHelperProvider.getHelper(paramInt);
  }
  
  public EmoticonHelperProvider getHelperProvider()
  {
    return this.mHelperProvider;
  }
  
  public IPanelInteractionListener getInteractionListener()
  {
    return this.mInteractionListener;
  }
  
  public boolean getKanDianBiu()
  {
    return this.mBasePanelView.kanDianBiu;
  }
  
  public ImageView getNewFlag()
  {
    return this.mBasePanelView.mNewFlag;
  }
  
  public EmotionPanelViewPagerAdapter getPageAdapter()
  {
    return this.mBasePanelView.pageAdapter;
  }
  
  public EmoticonMainPanel getPanel()
  {
    return this.mBasePanelView.getMainPanel();
  }
  
  public List<EmotionPanelInfo> getPanelDataList()
  {
    return this.mBasePanelModel.panelDataList;
  }
  
  public EmoticonPanelParams getParams()
  {
    return this.mBasePanelModel.mParams;
  }
  
  public int getSessionType()
  {
    return this.mBasePanelModel.sessionType;
  }
  
  public int[] getSysEmotionOrder()
  {
    return this.mBasePanelView.getSysEmotionOrder();
  }
  
  public AdapterView.OnItemClickListener getTabItemClickListener()
  {
    return this.mPanelMallHelper.tabItemClickListener;
  }
  
  public int getToastOffset()
  {
    return this.mBasePanelView.toastOffset;
  }
  
  public EmoticonPanelViewPager getViewPager()
  {
    return this.mBasePanelView.viewPager;
  }
  
  public void hideAllTabs()
  {
    this.mBasePanelView.hideAllTabs();
  }
  
  public void hideCmShowItemIfNeed(List<EmotionPanelInfo> paramList)
  {
    this.mBasePanelModel.hideCmShowItemIfNeed(paramList);
  }
  
  public void init()
  {
    this.mBasePanelModel.init();
    if (this.mAIOContext == null)
    {
      IPanelInteractionListener localIPanelInteractionListener = this.mInteractionListener;
      if (localIPanelInteractionListener != null) {
        this.mAIOContext = localIPanelInteractionListener.getAIOContext();
      }
    }
    this.mHelperProvider.dispatchLifeCycle(1);
    this.mBasePanelView.initView();
    this.mHelperProvider.dispatchLifeCycle(2);
    registerOtherProcessCallback();
  }
  
  public void initEmoticonView(int paramInt)
  {
    this.mBasePanelView.initEmoticonView(paramInt);
  }
  
  public void initEmoticonView(int paramInt, String paramString)
  {
    this.mBasePanelView.initEmoticonView(paramInt, paramString);
  }
  
  public void initEmoticonView(String paramString)
  {
    this.mBasePanelView.initEmoticonView(paramString);
  }
  
  public void initPanelExtendHeight()
  {
    this.mPanelExtendHelper.initPanelExtendHeight();
  }
  
  public boolean isEmoticonOnShow(int paramInt)
  {
    return this.mBasePanelModel.isEmoticonOnShow(paramInt);
  }
  
  public boolean isFilterSysFaceBeyond255Enable()
  {
    return this.mBasePanelView.isFilterSysFaceBeyond255Enable();
  }
  
  public boolean isInAIO()
  {
    return (getAIOContext() != null) && (getBusinessType() == 0);
  }
  
  public boolean isOnlySysEmotion()
  {
    return this.mBasePanelView.mIsOnlySysEmotion;
  }
  
  public boolean isPanelOpen()
  {
    return this.mPanelExtendHelper.isPanelOpen();
  }
  
  public boolean isResumed()
  {
    return this.mBasePanelView.isResumed;
  }
  
  public boolean isSecondTabInited()
  {
    return this.mBasePanelView.getMainPanel().mSecondTabInited;
  }
  
  public boolean isShowExtendPanel()
  {
    return this.mPanelExtendHelper.isShowExtendPanel();
  }
  
  void onAttachedToWindow()
  {
    this.mBasePanelView.onAttachedToWindow();
    this.mHelperProvider.dispatchLifeCycle(9);
  }
  
  public void onDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "OnDestory");
    }
    this.mHelperProvider.dispatchLifeCycle(8);
    this.mBasePanelView.onDestory();
    this.mBasePanelModel.onDestory();
    this.callback = null;
  }
  
  void onDetachedFromWindow()
  {
    this.mBasePanelView.onDetachedFromWindow();
    this.mHelperProvider.dispatchLifeCycle(10);
  }
  
  public void onHide(boolean paramBoolean)
  {
    this.mHelperProvider.dispatchLifeCycle(4, -1, paramBoolean);
    IApolloCmEmojiReportHelper localIApolloCmEmojiReportHelper = (IApolloCmEmojiReportHelper)QRoute.api(IApolloCmEmojiReportHelper.class);
    if ((localIApolloCmEmojiReportHelper.needReport()) && (this.mInteractionListener != null)) {
      localIApolloCmEmojiReportHelper.report(this.app.getAppRuntime(), this.mInteractionListener.getCurType(), this.mInteractionListener.getCurFriendUin());
    }
  }
  
  public void onMeasureMainPanel()
  {
    this.mBasePanelView.onMeasureMainPanel();
  }
  
  public void onPause()
  {
    if (this.app == null) {
      return;
    }
    this.mBasePanelView.onPause();
    this.mHelperProvider.dispatchLifeCycle(7);
  }
  
  public void onPullDown()
  {
    this.mHelperProvider.dispatchLifeCycle(11);
  }
  
  public void onPullUp()
  {
    this.mHelperProvider.dispatchLifeCycle(12);
  }
  
  public void onResume()
  {
    this.mBasePanelView.onResume();
  }
  
  public void onShow()
  {
    this.mHelperProvider.dispatchLifeCycle(5);
  }
  
  public void onShowPageFinish()
  {
    this.mHelperProvider.dispatchLifeCycle(14);
  }
  
  public void preloadWebProcess()
  {
    this.mPanelMallHelper.preloadWebProcess();
  }
  
  public void removePopupGuide()
  {
    this.mPanelSystemAndEmojiHelper.removePopupGuide();
  }
  
  public void setBasePanelModel(BasePanelModel paramBasePanelModel)
  {
    this.mBasePanelModel = paramBasePanelModel;
  }
  
  public void setBasePanelView(BasePanelView paramBasePanelView)
  {
    this.mBasePanelView = paramBasePanelView;
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.callback = paramEmoticonCallback;
    getParams().callback = paramEmoticonCallback;
  }
  
  public void setCurType(int paramInt)
  {
    this.mBasePanelModel.setCurType(paramInt);
  }
  
  @Deprecated
  public void setEmoSettingVisibility(int paramInt)
  {
    if (paramInt != 0) {
      this.mPanelTabSortHelper.hideEmoSetting();
    }
    this.mPanelSettingHelper.setEmoSettingVisibility(paramInt);
  }
  
  public void setEmoticonApp(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp)
  {
    this.app = paramQQEmoticonMainPanelApp;
    this.mBasePanelView.setEmoticonApp(paramQQEmoticonMainPanelApp);
    this.mBasePanelModel.setEmoticonApp(paramQQEmoticonMainPanelApp);
  }
  
  public void setEmoticonListProvider(EmoticonListProvider paramEmoticonListProvider)
  {
    this.mBasePanelModel.setEmoticonListProvider(paramEmoticonListProvider);
  }
  
  public void setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.mBasePanelView.setFilterSysFaceBeyond255Enable(paramBoolean);
  }
  
  public void setHideAllSettingTabs(boolean paramBoolean)
  {
    this.mBasePanelView.mHideAllSettingTabs = paramBoolean;
  }
  
  public void setKanDianBiu(boolean paramBoolean)
  {
    this.mBasePanelView.kanDianBiu = paramBoolean;
  }
  
  public void setOnlySysEmotionEnable(boolean paramBoolean)
  {
    this.mBasePanelView.setOnlySysEmotionEnable(paramBoolean);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    this.mBasePanelView.setOverScrollMode(paramInt);
  }
  
  public void setSysEmotionOrder(int[] paramArrayOfInt)
  {
    this.mBasePanelView.setSysEmotionOrder(paramArrayOfInt);
  }
  
  public void setVisibility(int paramInt)
  {
    this.mBasePanelView.setVisibility(paramInt);
  }
  
  public void showAllTabs()
  {
    this.mBasePanelView.showAllTabs();
  }
  
  void showPanelByTabIndex(int paramInt)
  {
    this.mBasePanelView.showPanelByTabIndex(paramInt);
  }
  
  public void switchSystemEmojiTabLocationPos(int paramInt1, int paramInt2)
  {
    this.mPanelSystemAndEmojiHelper.switchSystemEmojiTabLocationPos(paramInt1, paramInt2);
  }
  
  public void switchTabMode(int paramInt)
  {
    this.mBasePanelView.switchTabMode(paramInt);
  }
  
  void syncInitPanelDataList(boolean paramBoolean)
  {
    this.mBasePanelModel.syncInitPanelDataList(paramBoolean);
  }
  
  public void updateEmojiMallRedpoint()
  {
    this.mPanelSystemAndEmojiHelper.updateEmojiMallRedpoint();
  }
  
  public void updateFavEmoticonPanel()
  {
    this.mPanelFavHelper.updateFavEmoticonPanel();
  }
  
  public void updateLastEmoticonPanel()
  {
    this.mPanelMallHelper.updateLastEmoticonPanel();
  }
  
  public void updateLastSelectedSecondTabIndex()
  {
    this.mBasePanelModel.updateLastSelectedSecondTabIndex();
  }
  
  public void updateMagicPanel()
  {
    this.mPanelMallHelper.updateMagicPanel();
  }
  
  public void updateSystemAndEmojiPanel()
  {
    this.mPanelSystemAndEmojiHelper.updateSystemAndEmojiPanel();
  }
  
  public void updateTabSortLastSelectedSecondTabIndex()
  {
    this.mPanelTabSortHelper.updateLastSelectedSecondTabIndex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController
 * JD-Core Version:    0.7.0.1
 */