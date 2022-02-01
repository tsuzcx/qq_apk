package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager;
import com.tencent.mobileqq.emoticon.IEmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;

public class EmoticonMainPanel
  extends RelativeLayout
  implements IEmoticonPackageDownloadListener, EmotionPanelListView.PullAndFastScrollListener, IEmoticonMainPanel
{
  protected static final String LOG_TAG = "EmoticonMainPanel";
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
  private IEmoticonMainPanel.DispatchKeyEventListener mDispatchKeyEventListener;
  private EmoticonPanelController mEmoController;
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
    this.mEmoController = new EmoticonPanelController(paramContext);
    this.mEmoController.setBasePanelView(new BasePanelView(this));
    paramContext = this.mEmoController;
    paramContext.setBasePanelModel(new BasePanelModel(paramContext));
    this.mEmoController.getBasePanelModel().initParams();
  }
  
  public void addEmoticonPackageDownloadListener(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    EmojiListenerManager.a().addEmoticonPackageDownloadListener(paramEmoticonPackageDownloadListener);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchDraw, StackOverflowError, stack:");
      localStringBuilder.append(MsfSdkUtils.getStackTraceString(paramCanvas));
      QLog.e("EmoticonMainPanel", 1, localStringBuilder.toString());
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    IEmoticonMainPanel.DispatchKeyEventListener localDispatchKeyEventListener = this.mDispatchKeyEventListener;
    if ((localDispatchKeyEventListener != null) && (localDispatchKeyEventListener.dispatchKeyEvent(paramKeyEvent))) {
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
  
  public IPanelInteractionListener getPanelInteractionListener()
  {
    return this.mEmoController.getInteractionListener();
  }
  
  public View getStickerMaskLayout()
  {
    return this.stickerMaskLayout;
  }
  
  @NonNull
  public RelativeLayout getView()
  {
    return this;
  }
  
  public void hideAllTabs()
  {
    this.mEmoController.hideAllTabs();
  }
  
  public void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3)
  {
    init(paramBaseQQAppInterface, paramInt1, paramContext, paramInt2, paramString, paramInt3, this.mEmoController.getInteractionListener());
  }
  
  @Deprecated
  public void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, IPanelInteractionListener paramIPanelInteractionListener)
  {
    init(paramBaseQQAppInterface, paramInt1, paramContext, paramInt2, paramString, paramInt3, paramIPanelInteractionListener, false, new DefaultEmoticonListProvider(this.mEmoController));
  }
  
  @Deprecated
  public void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, int paramInt3, IPanelInteractionListener paramIPanelInteractionListener, boolean paramBoolean, EmoticonListProvider paramEmoticonListProvider)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "init");
    }
    new EmoticonMainPanel.EmoticonPanelBuilder(new BasePanelView(this), new QQEmoticonMainPanelApp(paramBaseQQAppInterface), paramInt1).setEmoticonListProvider(paramEmoticonListProvider).setKanDianBiu(paramBoolean).setDefaultEpId(paramString).setDefaultPanelType(paramInt3).setToastOffset(paramInt2).setPanelInteractionListener(paramIPanelInteractionListener).setDisableMoreEmotionButton(this.disableMoreEmotionButton).setHasBigEmotion(this.hasBigEmotion).setOnlySysAndEmoji(this.onlySysAndEmoji).setDisableGuide(this.disableGuide).setDisableGuideOneTime(this.disableGuideOneTime).setDisableAutoDownload(this.disableAutoDownload).setFilterSysFaceBeyond255Enable(isFilterSysFaceBeyond255Enable()).show();
  }
  
  @Deprecated
  public void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, IPanelInteractionListener paramIPanelInteractionListener)
  {
    init(paramBaseQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramIPanelInteractionListener, false, new DefaultEmoticonListProvider(this.mEmoController));
  }
  
  @Deprecated
  public void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, IPanelInteractionListener paramIPanelInteractionListener, boolean paramBoolean)
  {
    init(paramBaseQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramIPanelInteractionListener, paramBoolean, new DefaultEmoticonListProvider(this.mEmoController));
  }
  
  @Deprecated
  public void init(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, Context paramContext, int paramInt2, String paramString, IPanelInteractionListener paramIPanelInteractionListener, boolean paramBoolean, EmoticonListProvider paramEmoticonListProvider)
  {
    init(paramBaseQQAppInterface, paramInt1, paramContext, paramInt2, paramString, -1, paramIPanelInteractionListener, paramBoolean, paramEmoticonListProvider);
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
  
  public boolean isHiden()
  {
    return this.isHiden;
  }
  
  public boolean isOnlySysAndEmoji()
  {
    return this.onlySysAndEmoji;
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
    if (localViewParent != null)
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i == 0) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      } else if ((i == 1) || (i == 3)) {
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
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
  
  public void removeEmoticonPackageDownloadListener(EmoticonPackageDownloadListener paramEmoticonPackageDownloadListener)
  {
    EmojiListenerManager.a().removeEmoticonPackageDownloadListener(paramEmoticonPackageDownloadListener);
  }
  
  public void removePopupGuide()
  {
    this.mEmoController.removePopupGuide();
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.mEmoController.setCallBack(paramEmoticonCallback);
  }
  
  public void setDisableAutoDownload(boolean paramBoolean)
  {
    this.disableAutoDownload = paramBoolean;
  }
  
  public void setDisableGuide(boolean paramBoolean)
  {
    this.disableGuide = paramBoolean;
  }
  
  public void setDisableGuideOneTime(boolean paramBoolean)
  {
    this.disableGuideOneTime = paramBoolean;
  }
  
  public void setDisableMoreEmotionButton(boolean paramBoolean)
  {
    this.disableMoreEmotionButton = paramBoolean;
  }
  
  public void setDispatchKeyEventListener(IEmoticonMainPanel.DispatchKeyEventListener paramDispatchKeyEventListener)
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
  
  public void setHasBigEmotion(boolean paramBoolean)
  {
    this.hasBigEmotion = paramBoolean;
  }
  
  public void setHideAllSettingTabs(boolean paramBoolean)
  {
    this.mEmoController.setHideAllSettingTabs(paramBoolean);
  }
  
  public void setIsHiden(boolean paramBoolean)
  {
    this.isHiden = paramBoolean;
  }
  
  public void setOnlySysAndEmoji(boolean paramBoolean)
  {
    this.onlySysAndEmoji = paramBoolean;
  }
  
  public void setOnlySysEmotionEnable(boolean paramBoolean)
  {
    this.mEmoController.setOnlySysEmotionEnable(paramBoolean);
  }
  
  public void setSecondTabInited(boolean paramBoolean)
  {
    this.mSecondTabInited = paramBoolean;
  }
  
  public void setSysEmotionOrder(int[] paramArrayOfInt)
  {
    this.mEmoController.setSysEmotionOrder(paramArrayOfInt);
  }
  
  public void setTabListOverScrollMode(int paramInt)
  {
    this.mEmoController.setOverScrollMode(paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    this.mEmoController.setVisibility(paramInt);
    super.setVisibility(paramInt);
  }
  
  public boolean showStickerGuide()
  {
    return this.showStickerGuide;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel
 * JD-Core Version:    0.7.0.1
 */