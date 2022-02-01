package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;

public class EmoticonPanelSettingHelper
  extends AbstractEmoticonPanelHelper
  implements View.OnClickListener, PopupWindow.OnDismissListener
{
  private static final String LOG_TAG = "EmoticonPanelSettingHelper";
  private Runnable hiddenGuide = new EmoticonPanelSettingHelper.1(this);
  private int mBtnStatus;
  private ImageView mEmoticonSettingBtn;
  private EmoticonStoreTabGuideView mGuideView;
  private boolean mHideMoreButton;
  private boolean mHideSettingButton;
  private ImageView mMoreEmoticonButton;
  private Handler uiHandler;
  
  public EmoticonPanelSettingHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private int getMoreBtnStatusByEmotionInfo(EmotionPanelInfo paramEmotionPanelInfo)
  {
    int i = 1;
    if (paramEmotionPanelInfo == null)
    {
      QLog.e("EmoticonPanelSettingHelper", 1, "getMoreBtnStatusByEmotionInfo info = null");
      i = -1;
    }
    while ((paramEmotionPanelInfo.type != 7) && (paramEmotionPanelInfo.type != 10)) {
      return i;
    }
    return 2;
  }
  
  private static void updateIndividuationRedPoint(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp)
  {
    int i3 = 1;
    GameCenterManagerImpProxy localGameCenterManagerImpProxy = (GameCenterManagerImpProxy)paramQQEmoticonMainPanelApp.getManager(QQManagerFactory.GAMECENTER_MANAGER);
    int i;
    int j;
    label50:
    int k;
    label63:
    int m;
    label77:
    int n;
    label91:
    int i1;
    label105:
    int i2;
    label119:
    boolean bool;
    if (localGameCenterManagerImpProxy != null)
    {
      if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100001") == -1) {
        break label256;
      }
      i = 1;
      if (i != 0)
      {
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100003") == -1) {
          break label261;
        }
        j = 1;
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100002") == -1) {
          break label266;
        }
        k = 1;
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100006") == -1) {
          break label271;
        }
        m = 1;
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100018") == -1) {
          break label277;
        }
        n = 1;
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100020") == -1) {
          break label283;
        }
        i1 = 1;
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100021") == -1) {
          break label289;
        }
        i2 = 1;
        bool = ((FontManagerProxy)paramQQEmoticonMainPanelApp.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).isSupportFont();
        if (!bool) {
          break label305;
        }
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100011") == -1) {
          break label295;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label152:
      if (((bool) && (j == 0) && (k == 0) && (m == 0) && (i == 0) && (n == 0) && (i1 == 0) && (i2 == 0)) || ((!bool) && (j == 0) && (k == 0) && (m == 0) && (n == 0) && (i1 == 0) && (i2 == 0))) {
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005") == -1) {
          break label300;
        }
      }
      label256:
      label261:
      label266:
      label271:
      label277:
      label283:
      label289:
      label295:
      label300:
      for (i = i3;; i = 0)
      {
        if (i != 0) {
          ((RedTouchManagerProxy)paramQQEmoticonMainPanelApp.getManager(QQManagerFactory.MGR_RED_TOUCH)).onRedTouchItemClick("100005");
        }
        return;
        i = 0;
        break;
        j = 0;
        break label50;
        k = 0;
        break label63;
        m = 0;
        break label77;
        n = 0;
        break label91;
        i1 = 0;
        break label105;
        i2 = 0;
        break label119;
        i = 0;
        break label152;
      }
      label305:
      i = 0;
    }
  }
  
  public String getTag()
  {
    return "EmoticonPanelSettingHelper";
  }
  
  public void initBefore()
  {
    EmoticonMainPanel localEmoticonMainPanel = this.mPanelController.getPanel();
    this.mMoreEmoticonButton = ((ImageView)localEmoticonMainPanel.findViewById(2131364050));
    this.mEmoticonSettingBtn = ((ImageView)localEmoticonMainPanel.findViewById(2131364143));
    this.mMoreEmoticonButton.setOnClickListener(this);
    this.mEmoticonSettingBtn.setOnClickListener(this);
    if ((this.mPanelController.businessType == 3) || (this.mHideSettingButton) || (this.mPanelController.mHideAllSettingTabs)) {
      this.mEmoticonSettingBtn.setVisibility(8);
    }
    if ((this.mPanelController.mParams.disableMoreEmotionButton) || (this.mHideMoreButton) || (this.mPanelController.mHideAllSettingTabs))
    {
      this.mMoreEmoticonButton.setVisibility(8);
      return;
    }
    this.mMoreEmoticonButton.setVisibility(0);
  }
  
  public void initGuideView(View paramView)
  {
    if ((paramView == null) || (this.mGuideView != null)) {
      return;
    }
    this.mGuideView = new EmoticonStoreTabGuideView(paramView.getContext());
    this.mGuideView.initUI();
    this.mGuideView.setOnDismissListener(this);
    this.uiHandler = paramView.getHandler();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 1 };
  }
  
  public void onClick(View paramView)
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.mPanelController.app;
    Object localObject = this.mPanelController.context;
    boolean bool = this.mPanelController.hasBigEmotion;
    EmoticonCallback localEmoticonCallback = this.mPanelController.callback;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VasWebviewUtil.reportCommercialDrainage(localQQEmoticonMainPanelApp.getCurrentUin(), "ep_mall", "click_mine", "", 0, 0, 0, "", "", "");
      EmojiHomeUiPlugin.openEmosmActivity((Context)localObject, localQQEmoticonMainPanelApp, localQQEmoticonMainPanelApp.getAccount(), 1, false, "");
      ReportController.b(localQQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", "0x800a56d", "0x800a56d", 0, 0, "", "", "", "");
      i = this.mPanelController.getFromType(false);
      if (i != 0)
      {
        ReportController.b(localQQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", "0X800AE0F", "0X800AE0F", i, 0, "", "", "", "");
        continue;
        if ((this.mBtnStatus != 2) || (bool)) {
          break;
        }
        if (localEmoticonCallback != null) {
          localEmoticonCallback.delete();
        }
      }
    }
    MobileReportManager.getInstance().reportAction("+", "4", "platform898", "6", "1", 102, 1, System.currentTimeMillis());
    ReportController.b(localQQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B7", 0, 0, "", "", "", "");
    bool = false;
    if (this.mPanelController.mNewFlag.getVisibility() == 0)
    {
      ReportController.b(localQQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B9", 0, 0, "", "", "", "");
      this.mPanelController.mNewFlag.setVisibility(8);
      ((RedTouchManagerProxy)localQQEmoticonMainPanelApp.getManager(QQManagerFactory.MGR_RED_TOUCH)).onRedTouchItemClick(String.valueOf("100610.100611"));
      ((Context)localObject).getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", false).apply();
      bool = true;
    }
    updateIndividuationRedPoint(localQQEmoticonMainPanelApp);
    this.mPanelController.mWebPreloadHitSession.b();
    EmojiHomeUiPlugin.openEmojiHomePage(this.mPanelController.context, localQQEmoticonMainPanelApp, localQQEmoticonMainPanelApp.getAccount(), 1, bool, "", true);
    ReportController.b(localQQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
    if (localObject != null)
    {
      localObject = ((Context)localObject).getSharedPreferences("emoticon_panel_" + localQQEmoticonMainPanelApp.getCurrentAccountUin(), 0);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).apply();
      }
    }
    if (((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) {}
    for (int i = 1;; i = 0)
    {
      VasWebviewUtil.reportVasStatus("personal_web_preload_hit_rit", "emoticon_main_panel_plus", "0", 0, 0, i, 0, "", "");
      ReportController.b(localQQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", "0x800a56c", "0x800a56c", 0, 0, "", "", "", "");
      i = this.mPanelController.getFromType(false);
      if (i == 0) {
        break;
      }
      ReportController.b(localQQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", "0X800AE0E", "0X800AE0E", i, 0, "", "", "", "");
      break;
    }
  }
  
  public void onDestory()
  {
    if (this.uiHandler != null)
    {
      this.uiHandler.removeCallbacks(this.hiddenGuide);
      this.uiHandler = null;
    }
    super.onDestory();
  }
  
  public void onDismiss()
  {
    if (this.uiHandler != null) {
      this.uiHandler.removeCallbacks(this.hiddenGuide);
    }
    EmoticonStoreTabEntryUtils.doOnStoryGuideShowed();
  }
  
  public boolean performClick(int paramInt)
  {
    if ((paramInt == 13) && (this.mMoreEmoticonButton != null))
    {
      this.mMoreEmoticonButton.performClick();
      return true;
    }
    if ((paramInt == 14) && (this.mEmoticonSettingBtn != null))
    {
      this.mEmoticonSettingBtn.performClick();
      return true;
    }
    return false;
  }
  
  public void prepareShowGuideView()
  {
    this.mMoreEmoticonButton = null;
    this.uiHandler = null;
  }
  
  protected void setEmoSettingVisibility(int paramInt)
  {
    if (this.mEmoticonSettingBtn != null) {
      this.mEmoticonSettingBtn.setVisibility(paramInt);
    }
  }
  
  public void setHideMoreAndSettingButton(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mHideMoreButton = paramBoolean1;
    this.mHideSettingButton = paramBoolean2;
  }
  
  protected void setMoreSettingVisibility(int paramInt)
  {
    if (this.mMoreEmoticonButton != null) {
      this.mMoreEmoticonButton.setVisibility(paramInt);
    }
  }
  
  public void setmGuideView(EmoticonStoreTabGuideView paramEmoticonStoreTabGuideView)
  {
    this.mGuideView = paramEmoticonStoreTabGuideView;
  }
  
  public void showGuideView(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (this.mGuideView == null) {
        initGuideView(paramView);
      }
      if ((this.mMoreEmoticonButton != null) && (Build.VERSION.SDK_INT >= 19)) {
        this.mGuideView.showAsDropDown(this.mMoreEmoticonButton, paramInt1, -paramInt2, 51);
      }
      while (this.uiHandler != null)
      {
        this.uiHandler.removeCallbacks(this.hiddenGuide);
        this.uiHandler.postDelayed(this.hiddenGuide, 5000L);
        return;
        this.mGuideView.showAtLocation(paramView, 83, paramInt1, paramInt2);
      }
    }
  }
  
  public void switchMoreSettingStyle(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {}
    for (;;)
    {
      return;
      boolean bool = this.mPanelController.hasBigEmotion;
      EmoticonPanelController.EmoticonPanelParams localEmoticonPanelParams = this.mPanelController.mParams;
      int i = getMoreBtnStatusByEmotionInfo(paramEmotionPanelInfo);
      if (this.mBtnStatus != i)
      {
        this.mBtnStatus = i;
        if ((bool) && (!localEmoticonPanelParams.disableMoreEmotionButton)) {
          if (this.mHideMoreButton) {
            this.mMoreEmoticonButton.setVisibility(8);
          }
        }
        while (this.mPanelController.mHideAllSettingTabs)
        {
          this.mMoreEmoticonButton.setVisibility(8);
          return;
          this.mMoreEmoticonButton.setVisibility(0);
          this.mMoreEmoticonButton.setImageResource(2130847500);
          continue;
          if ((!((EmoticonPanelExtendHelper)this.mPanelController.getHelper(1)).isShowExtendPanel()) && (this.mBtnStatus == 2) && (!localEmoticonPanelParams.disableMoreEmotionButton))
          {
            this.mMoreEmoticonButton.setVisibility(0);
            this.mMoreEmoticonButton.setImageResource(2130847489);
            this.mMoreEmoticonButton.setPadding((int)(10.0F * this.mPanelController.density), 0, 0, 0);
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelSettingHelper", 2, "onPageSelected, show del pic");
            }
          }
          else
          {
            this.mMoreEmoticonButton.setVisibility(8);
          }
        }
      }
    }
  }
  
  public void switchSettingBtnStyle(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {}
    for (;;)
    {
      return;
      boolean bool = this.mPanelController.hasBigEmotion;
      EmoticonPanelController.EmoticonPanelParams localEmoticonPanelParams = this.mPanelController.mParams;
      int i = getMoreBtnStatusByEmotionInfo(paramEmotionPanelInfo);
      if (this.mBtnStatus != i)
      {
        this.mBtnStatus = i;
        if ((bool) && (!localEmoticonPanelParams.disableMoreEmotionButton)) {
          if (this.mHideMoreButton) {
            this.mMoreEmoticonButton.setVisibility(8);
          }
        }
        while (this.mPanelController.mHideAllSettingTabs)
        {
          this.mMoreEmoticonButton.setVisibility(8);
          return;
          this.mMoreEmoticonButton.setVisibility(0);
          this.mMoreEmoticonButton.setImageResource(2130847500);
          this.mMoreEmoticonButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
          continue;
          if ((!((EmoticonPanelExtendHelper)this.mPanelController.getHelper(1)).isShowExtendPanel()) && (this.mBtnStatus == 2) && (!localEmoticonPanelParams.disableMoreEmotionButton))
          {
            this.mMoreEmoticonButton.setVisibility(0);
            this.mMoreEmoticonButton.setImageResource(2130847489);
            this.mMoreEmoticonButton.setScaleType(ImageView.ScaleType.CENTER);
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelSettingHelper", 2, "onPageSelected, show del pic");
            }
          }
          else
          {
            this.mMoreEmoticonButton.setVisibility(8);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSettingHelper
 * JD-Core Version:    0.7.0.1
 */