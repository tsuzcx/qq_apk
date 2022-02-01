package com.tencent.mobileqq.emoticonview;

import amrg;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import ares;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class EmoticonMainPanel
  extends RelativeLayout
  implements EmotionPanelListView.PullAndFastScrollListener
{
  public static final int BTN_STATUS_DEL = 2;
  public static final int BTN_STATUS_MORE = 1;
  public static final int CALL_BACK_TYPE_BIG_EMOTICON = 18;
  public static final int CALL_BACK_TYPE_RECOMMENT = 17;
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
  public boolean disableAutoDownload;
  @Deprecated
  public boolean disableGuide;
  @Deprecated
  public boolean disableGuideOneTime;
  @Deprecated
  public boolean disableMoreEmotionButton;
  @Deprecated
  public boolean hasBigEmotion = true;
  public boolean isHiden;
  private EmoticonMainPanel.DispatchKeyEventListener mDispatchKeyEventListener;
  private EmoticonPanelController mEmoController = new EmoticonPanelController(paramContext, this);
  public HorizontalListViewEx mEmoticonTabs;
  public int mEmotionType = -1;
  public int mLocalId = -1;
  public boolean mSecondTabInited;
  @Deprecated
  public boolean onlySysAndEmoji;
  public boolean showStickerGuide;
  public View stickerMaskLayout;
  
  public EmoticonMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void sendRecommendSSORequest(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    SharedPreferences localSharedPreferences;
    long l;
    do
    {
      return;
      if (paramInt == 1)
      {
        ThreadManagerV2.excute(new EmoticonMainPanel.1(paramQQAppInterface), 128, null, true);
        return;
      }
      localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      l = localSharedPreferences.getLong("last_get_recommendemotion_time_" + paramQQAppInterface.getCurrentUin(), 0L);
      paramInt = localSharedPreferences.getInt("recommendSeqinterval", 7200);
    } while (System.currentTimeMillis() - l < paramInt * 1000);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "sendRecommendSSORequest send req to recommend");
    }
    ((amrg)paramQQAppInterface.getBusinessHandler(12)).a();
    localSharedPreferences.edit().putLong("last_get_recommendemotion_time_" + paramQQAppInterface.getCurrentUin(), System.currentTimeMillis()).apply();
  }
  
  public void deleteEmoticonClick()
  {
    this.mEmoController.deleteEmoticonClick();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
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
    ares.a().a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func doAutoDownload ends.");
    }
  }
  
  public EmoticonPanelController getEmoController()
  {
    return this.mEmoController;
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
    new EmoticonMainPanel.EmoticonPanelBuilder(this, paramQQAppInterface, paramBaseChatPie, paramInt1).setEmoticonListProvider(paramEmoticonListProvider).setKanDianBiu(paramBoolean).setDefaultEpId(paramString).setDefaultPanelType(paramInt3).setToastOffset(paramInt2).setDisableMoreEmotionButton(this.disableMoreEmotionButton).setHasBigEmotion(this.hasBigEmotion).setOnlySysAndEmoji(this.onlySysAndEmoji).setDisableGuide(this.disableGuide).setDisableGuideOneTime(this.disableGuideOneTime).setDisableAutoDownload(this.disableAutoDownload).setFilterSysFaceBeyond255Enable(isFilterSysFaceBeyond255Enable()).show();
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mEmoController.onAttachedToWindow();
  }
  
  public void onDestory()
  {
    this.mEmoController.onDestory();
  }
  
  protected void onDetachedFromWindow()
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
  
  protected void onMeasure(int paramInt1, int paramInt2)
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