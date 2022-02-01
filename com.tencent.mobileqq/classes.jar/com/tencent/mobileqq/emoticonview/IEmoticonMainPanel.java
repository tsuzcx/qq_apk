package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;

public abstract interface IEmoticonMainPanel
{
  public static final int BTN_STATUS_DEL = 2;
  public static final int BTN_STATUS_MORE = 1;
  public static final String FORCE_TO_RECOMMEND_PANEL_SP = "force_to_recommend_panel_sp";
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
  
  public abstract void deleteEmoticonClick();
  
  public abstract void doAutoDownload(int paramInt);
  
  public abstract IEmoticonPanelController getEmoController();
  
  public abstract int getEmoticonTab(String paramString);
  
  public abstract boolean getGlobalVisibleRect(Rect paramRect);
  
  public abstract IPanelInteractionListener getPanelInteractionListener();
  
  public abstract View getStickerMaskLayout();
  
  @NonNull
  public abstract RelativeLayout getView();
  
  public abstract int getVisibility();
  
  public abstract void hideAllTabs();
  
  public abstract void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3);
  
  public abstract void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, IPanelInteractionListener paramIPanelInteractionListener);
  
  public abstract void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, IPanelInteractionListener paramIPanelInteractionListener, boolean paramBoolean, EmoticonListProvider paramEmoticonListProvider);
  
  public abstract void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, IPanelInteractionListener paramIPanelInteractionListener);
  
  public abstract void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, IPanelInteractionListener paramIPanelInteractionListener, boolean paramBoolean);
  
  public abstract void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, IPanelInteractionListener paramIPanelInteractionListener, boolean paramBoolean, EmoticonListProvider paramEmoticonListProvider);
  
  public abstract void initEmoticonView(int paramInt);
  
  public abstract void initEmoticonView(String paramString);
  
  public abstract boolean isHiden();
  
  public abstract boolean isOnlySysAndEmoji();
  
  public abstract void onDestory();
  
  public abstract void onHide(boolean paramBoolean);
  
  public abstract void onPause();
  
  public abstract void onPullDown();
  
  public abstract void onResume();
  
  public abstract void onShow();
  
  public abstract void preloadWebProcess();
  
  public abstract void setCallBack(EmoticonCallback paramEmoticonCallback);
  
  public abstract void setDisableAutoDownload(boolean paramBoolean);
  
  public abstract void setDisableGuide(boolean paramBoolean);
  
  public abstract void setDisableGuideOneTime(boolean paramBoolean);
  
  public abstract void setDisableMoreEmotionButton(boolean paramBoolean);
  
  public abstract void setDispatchKeyEventListener(IEmoticonMainPanel.DispatchKeyEventListener paramDispatchKeyEventListener);
  
  public abstract void setEmoSettingVisibility(int paramInt);
  
  public abstract void setHasBigEmotion(boolean paramBoolean);
  
  public abstract void setIsHiden(boolean paramBoolean);
  
  public abstract void setOnlySysAndEmoji(boolean paramBoolean);
  
  public abstract void setOnlySysEmotionEnable(boolean paramBoolean);
  
  public abstract void setSecondTabInited(boolean paramBoolean);
  
  public abstract void setTabListOverScrollMode(int paramInt);
  
  public abstract boolean showStickerGuide();
  
  public abstract void switchSystemEmojiTabLocationPos(int paramInt1, int paramInt2);
  
  public abstract void switchTabMode(int paramInt);
  
  public abstract void switchToAnonymous(boolean paramBoolean);
  
  public abstract void updateFavEmoticonPanel();
  
  public abstract void updateLastEmoticonPanel();
  
  public abstract void updateMagicPanel();
  
  public abstract void updateSystemAndEmojiPanel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IEmoticonMainPanel
 * JD-Core Version:    0.7.0.1
 */