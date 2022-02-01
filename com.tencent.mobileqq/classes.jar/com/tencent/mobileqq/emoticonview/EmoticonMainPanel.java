package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.EmotionInjectionInfo;
import com.tencent.mobileqq.EmotionPanelManager;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.core.EmotionPanelParamsBuilder;
import com.tencent.mobileqq.core.QQEmotionPanelManager;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
import com.tencent.mobileqq.core.SystemEmotionPanelManager.IEmoticonPanelInject;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager;
import com.tencent.mobileqq.emoticon.IEmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.adapter.IEmotionAdapterHelper;
import com.tencent.mobileqq.emoticonview.api.impl.AIOPanelInteractionListener;
import com.tencent.mobileqq.emoticonview.api.impl.ApolloDependListener;
import com.tencent.mobileqq.emoticonview.api.impl.EmotionPanelDependListener;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.sender.CameraEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.sender.FavoriteEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.sender.SystemAndEmojiEmoticonInfoSender;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;

public class EmoticonMainPanel
  extends RelativeLayout
  implements SystemEmotionPanelManager.IEmoticonPanelInject, IEmoticonPackageDownloadListener, EmotionPanelListView.PullAndFastScrollListener
{
  public static final int BTN_STATUS_DEL = 2;
  public static final int BTN_STATUS_MORE = 1;
  public static final String FORCE_TO_RECOMMEND_PANEL_SP = "force_to_recommend_panel_sp";
  protected static final String LOG_TAG = "EmoticonMainPanel";
  public static final int MAX_REPORT_COUNT = 10;
  public static final int OPEN_CONDITION_FIRST_IN_AIO = 2;
  public static final int OPEN_CONDITION_FIRST_IN_PROCESS = 1;
  public static final int OPEN_CONDITION_REOPEN_IN_AIO = 3;
  public static final String PERF_REPORT_OPEN_DURATION_TAG1 = "report_AIOEmoticonPanel_OpenFirstTimeInProcess";
  public static final String PERF_REPORT_OPEN_DURATION_TAG2 = "report_AIOEmoticonPanel_OpenFirstTimeInAIO";
  public static final String PERF_REPORT_OPEN_DURATION_TAG3 = "report_AIOEmoticonPanel_ReopenInAIO";
  public static final long REPORT_INTERVAL = 86400000L;
  public static final String REPORT_PARAM_PANEL_MODE = "panelMode";
  public static final String REPORT_PARAM_PANEL_OPEN_DURATION = "duration";
  public static final String SP_KEY_EMOTICON_PANEL_LAST_REPORT_TIME = "sp_key_emoticon_panel_last_report_time";
  public static final String SP_KEY_EMOTICON_PANEL_REPORT_COUNT = "sp_key_emoticon_panel_report_count";
  public static final String SP_KEY_MARKET_OPEN_TIME = "sp_key_market_open_time";
  public static final String SP_KEY_SEND_H5_MAGIC_FACE_TIME = "sp_key_send_h5_magic_face_time";
  public static final String SP_USER_FILE_NAME = "emoticon_panel_";
  public static long sOpenStartTime;
  @Deprecated
  public boolean disableAutoDownload = false;
  @Deprecated
  public boolean disableGuide = false;
  @Deprecated
  public boolean disableGuideOneTime = false;
  @Deprecated
  public boolean disableMoreEmotionButton = false;
  @Deprecated
  public boolean hasBigEmotion = true;
  public boolean isHiden = false;
  private EmoticonMainPanel.DispatchKeyEventListener mDispatchKeyEventListener;
  private EmoticonPanelController mEmoController = new EmoticonPanelController(paramContext, this);
  public HorizontalListViewEx mEmoticonTabs;
  public int mEmotionType = -1;
  public int mLocalId = -1;
  public boolean mSecondTabInited;
  @Deprecated
  public boolean onlySysAndEmoji = false;
  public boolean showStickerGuide = false;
  public View stickerMaskLayout;
  
  public EmoticonMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void addEmoticonPackageDownloadListener(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    EmojiListenerManager.a().a(paramEmoticonPackageDownloadListener);
  }
  
  public IEmoticonPanelLinearLayoutHelper createEmoticonPanelLayoutHelper(boolean paramBoolean)
  {
    Context localContext = getContext();
    if (paramBoolean) {}
    for (BaseChatPie localBaseChatPie = this.mEmoController.mBaseChatPie;; localBaseChatPie = null) {
      return new QQEmoticonPanelLinearLayoutHelper(localContext, localBaseChatPie);
    }
  }
  
  public IEmotionAdapterHelper createEmotionAdapterHelper(int paramInt)
  {
    if (paramInt == 11) {
      return new CameraEmotionAdapterHelper(this.mEmoController.app);
    }
    return null;
  }
  
  public IEmoticonInfoSender createEmotionInfoSender(int paramInt)
  {
    if (paramInt == 7) {
      return new SystemAndEmojiEmoticonInfoSender();
    }
    if (paramInt == 4) {
      return new FavoriteEmoticonInfoSender();
    }
    if (paramInt == 11) {
      return new CameraEmoticonInfoSender();
    }
    if (paramInt == 6) {
      return new PicEmoticonInfoSender();
    }
    return null;
  }
  
  public void deleteEmoticonClick()
  {
    this.mEmoController.deleteEmoticonClick();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      this.mEmoController.dispatchDraw(paramCanvas);
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      QLog.e("EmoticonMainPanel", 1, "dispatchDraw, StackOverflowError, stack:" + MsfSdkUtils.getStackTraceString(paramCanvas));
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.mDispatchKeyEventListener != null) && (this.mDispatchKeyEventListener.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void doAutoDownload(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload begins.");
    }
    EmotionPanelPayBackListenerManager.a().a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload ends.");
    }
  }
  
  public EmoticonPanelController getEmoController()
  {
    return this.mEmoController;
  }
  
  public EmoticonMainPanel getEmoPanel()
  {
    return this;
  }
  
  public int getEmoticonTab(String paramString)
  {
    return this.mEmoController.getEmoticonTab(paramString);
  }
  
  public void hideAllTabs()
  {
    this.mEmoController.hideAllTabs();
  }
  
  public void init(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, BaseChatPie paramBaseChatPie)
  {
    init(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, paramInt3, paramBaseChatPie, false, new EmoticonMainPanel.DefaultEmoticonListProvider(this, null));
  }
  
  public void init(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, BaseChatPie paramBaseChatPie, boolean paramBoolean, EmoticonListProvider paramEmoticonListProvider)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "init");
    }
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = new QQEmoticonMainPanelApp(paramQQAppInterface);
    QQEmotionPanelManager.a().a(BaseApplicationImpl.getApplication());
    QQEmotionPanelManager.a().a(this.mEmoController);
    QQEmotionPanelManager.a().a(this);
    if (paramBaseChatPie != null)
    {
      QQEmotionPanelManager.a().a(new AIOPanelInteractionListener(paramBaseChatPie));
      if (this.mEmoController == null) {
        break label304;
      }
    }
    label304:
    for (paramQQAppInterface = this.mEmoController.callback;; paramQQAppInterface = null)
    {
      paramQQAppInterface = new EmotionInjectionInfo(15, 4, 2130838111, new CmShowEmotionPanelBuilder(localQQEmoticonMainPanelApp, paramContext, 4, 15, 15, paramQQAppInterface, paramBaseChatPie));
      EmotionPanelManager.a().a("cmshow", paramQQAppInterface);
      SystemEmotionPanelManager.a().a(new EmotionPanelDependListener());
      SystemEmotionPanelManager.a().a(new ApolloDependListener());
      SystemEmotionPanelManager.a().a(this);
      if (paramBaseChatPie != null)
      {
        paramQQAppInterface = new EmotionPanelParamsBuilder().a(paramBaseChatPie.b()).a(paramBaseChatPie.b()).b(paramBaseChatPie.b()).c(paramBaseChatPie.d());
        QQEmotionPanelManager.a().a(paramQQAppInterface);
      }
      new EmoticonMainPanel.EmoticonPanelBuilder(this, localQQEmoticonMainPanelApp, paramBaseChatPie, paramInt1).setEmoticonListProvider(paramEmoticonListProvider).setKanDianBiu(paramBoolean).setDefaultEpId(paramString).setDefaultPanelType(paramInt3).setToastOffset(paramInt2).setDisableMoreEmotionButton(this.disableMoreEmotionButton).setHasBigEmotion(this.hasBigEmotion).setOnlySysAndEmoji(this.onlySysAndEmoji).setDisableGuide(this.disableGuide).setDisableGuideOneTime(this.disableGuideOneTime).setDisableAutoDownload(this.disableAutoDownload).setFilterSysFaceBeyond255Enable(isFilterSysFaceBeyond255Enable()).show();
      return;
    }
  }
  
  public void init(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie)
  {
    init(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, false, new EmoticonMainPanel.DefaultEmoticonListProvider(this, null));
  }
  
  public void init(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    init(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, paramBoolean, new EmoticonMainPanel.DefaultEmoticonListProvider(this, null));
  }
  
  public void init(QQAppInterface paramQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, BaseChatPie paramBaseChatPie, boolean paramBoolean, EmoticonListProvider paramEmoticonListProvider)
  {
    init(paramQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramBaseChatPie, paramBoolean, paramEmoticonListProvider);
  }
  
  public void initEmoticonView(int paramInt)
  {
    this.mEmoController.initEmoticonView(paramInt);
  }
  
  public void initEmoticonView(String paramString)
  {
    this.mEmoController.initEmoticonView(paramString);
  }
  
  public boolean isFilterSysFaceBeyond255Enable()
  {
    return this.mEmoController.isFilterSysFaceBeyond255Enable();
  }
  
  public boolean isPanelOpen()
  {
    return this.mEmoController.isPanelOpen();
  }
  
  public boolean isShowExtendPanel()
  {
    return this.mEmoController.isShowExtendPanel();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mEmoController.onAttachedToWindow();
  }
  
  public void onDestory()
  {
    this.mEmoController.onDestory();
    QQEmotionPanelManager.a().a();
    SystemEmotionPanelManager.a().a();
    EmotionPanelManager.a().a();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mEmoController.onDetachedFromWindow();
  }
  
  public void onHide(boolean paramBoolean)
  {
    this.mEmoController.onHide(paramBoolean);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewParent localViewParent = getParent();
    int i;
    if (localViewParent != null)
    {
      i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0) {
        break label35;
      }
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label35:
      if ((i == 1) || (i == 3)) {
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mEmoController.onMeasureMainPanel();
  }
  
  public void onPause()
  {
    this.mEmoController.onPause();
  }
  
  public void onPullDown()
  {
    this.mEmoController.onPullDown();
  }
  
  public void onPullUp()
  {
    this.mEmoController.onPullUp();
  }
  
  public void onResume()
  {
    this.mEmoController.onResume();
  }
  
  public void onShow()
  {
    this.mEmoController.onShow();
  }
  
  public void preloadWebProcess()
  {
    this.mEmoController.preloadWebProcess();
  }
  
  public void removeEmoticonPackageDownloadListener(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    EmojiListenerManager.a().b(paramEmoticonPackageDownloadListener);
  }
  
  public void removePopupGuide()
  {
    this.mEmoController.removePopupGuide();
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.mEmoController.setCallBack(paramEmoticonCallback);
  }
  
  public void setDispatchKeyEventListener(EmoticonMainPanel.DispatchKeyEventListener paramDispatchKeyEventListener)
  {
    this.mDispatchKeyEventListener = paramDispatchKeyEventListener;
  }
  
  @Deprecated
  public void setEmoSettingVisibility(int paramInt)
  {
    this.mEmoController.setEmoSettingVisibility(paramInt);
  }
  
  public void setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.mEmoController.setFilterSysFaceBeyond255Enable(paramBoolean);
  }
  
  public void setHideAllSettingTabs(boolean paramBoolean)
  {
    this.mEmoController.setHideAllSettingTabs(paramBoolean);
  }
  
  public void setOnlySysEmotionEnable(boolean paramBoolean)
  {
    this.mEmoController.setOnlySysEmotionEnable(paramBoolean);
  }
  
  public void setSysEmotionOrder(int[] paramArrayOfInt)
  {
    this.mEmoController.setSysEmotionOrder(paramArrayOfInt);
  }
  
  public void setVisibility(int paramInt)
  {
    this.mEmoController.setVisibility(paramInt);
    super.setVisibility(paramInt);
  }
  
  public void switchSystemEmojiTabLocationPos(int paramInt1, int paramInt2)
  {
    this.mEmoController.switchSystemEmojiTabLocationPos(paramInt1, paramInt2);
  }
  
  public void switchTabMode(int paramInt)
  {
    this.mEmoController.switchTabMode(paramInt);
  }
  
  public void switchToAnonymous(boolean paramBoolean) {}
  
  public void updateFavEmoticonPanel()
  {
    this.mEmoController.updateFavEmoticonPanel();
  }
  
  public void updateLastEmoticonPanel()
  {
    this.mEmoController.updateLastEmoticonPanel();
  }
  
  public void updateMagicPanel()
  {
    this.mEmoController.updateMagicPanel();
  }
  
  public void updateSystemAndEmojiPanel()
  {
    this.mEmoController.updateSystemAndEmojiPanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel
 * JD-Core Version:    0.7.0.1
 */