package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.app.CameraEmoRoamingObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerServiceProxy;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.app.Foreground;

public class EmoticonPanelCameraHelper
  extends AbstractEmoticonPanelHelper<EmoticonPanelController>
{
  private static final String LOG_TAG = "EmoticonPanelCameraHelper";
  protected QQEmoticonMainPanelApp app;
  private volatile long lastJumpCameraTime = 0L;
  private ViewStub mCameraEmoGuideVS = null;
  private RelativeLayout mCameraEmoGuideView = null;
  private IPanelInteractionListener mInteractionListener;
  CameraEmoRoamingObserver sCameraEmoObserver = new EmoticonPanelCameraHelper.2(this);
  
  public EmoticonPanelCameraHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private void showDialogTipIfNeed(int paramInt)
  {
    if (CameraEmoAllSend.a) {
      return;
    }
    Context localContext = ((EmoticonPanelController)this.mPanelController).context;
    EmoticonTabAdapter localEmoticonTabAdapter = ((EmoticonPanelController)this.mPanelController).getEmoticonTabAdapter();
    EmoticonPanelViewPager localEmoticonPanelViewPager = ((EmoticonPanelController)this.mPanelController).getViewPager();
    EmoticonMainPanel localEmoticonMainPanel = ((EmoticonPanelController)this.mPanelController).getPanel();
    boolean bool;
    if (paramInt == 2) {
      bool = true;
    } else {
      bool = false;
    }
    CameraEmoAllSend.a = bool;
    if ((CameraEmoAllSend.a) && (localEmoticonTabAdapter != null) && (localEmoticonPanelViewPager != null))
    {
      paramInt = ((EmoticonPanelController)this.mPanelController).findIndexByPanelType(11);
      if ((Foreground.getTopActivity() != null) && (localEmoticonMainPanel.getVisibility() == 0) && (localEmoticonPanelViewPager.getCurrentItem() == paramInt)) {
        DialogUtil.a(Foreground.getTopActivity(), localContext.getString(2131691882), 2131691883, 2131691889, new EmoticonPanelCameraHelper.4(this, localContext), new EmoticonPanelCameraHelper.5(this)).show();
      }
    }
  }
  
  private void tryShowCameraEmoGuide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "timtest tryShowCameraEmoGuide start.");
    }
    if ((this.mCameraEmoGuideView == null) && (this.mCameraEmoGuideVS == null)) {
      return;
    }
    if (this.mCameraEmoGuideView == null)
    {
      this.mCameraEmoGuideView = ((RelativeLayout)this.mCameraEmoGuideVS.inflate());
      tryUpdateGuideImg();
      ImageView localImageView = (ImageView)this.mCameraEmoGuideView.findViewById(2131364245);
      if (localImageView != null) {
        localImageView.setOnClickListener(new EmoticonPanelCameraHelper.1(this));
      }
    }
    this.mCameraEmoGuideView.setClickable(true);
    this.mCameraEmoGuideView.setBackgroundColor(((EmoticonPanelController)this.mPanelController).context.getResources().getColor(2131165620));
    this.mCameraEmoGuideView.setVisibility(0);
  }
  
  void doSyncCameraEmotion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "doSyncCameraEmotion");
    }
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = ((EmoticonPanelController)this.mPanelController).app;
    Context localContext = ((EmoticonPanelController)this.mPanelController).context;
    if (localQQEmoticonMainPanelApp == null) {
      return;
    }
    ThreadManager.excute(new EmoticonPanelCameraHelper.6(this, localContext, localQQEmoticonMainPanelApp), 128, null, false);
  }
  
  protected int getDefaultExternalPanelHeight()
  {
    if (this.mInteractionListener == null)
    {
      QLog.e("EmoticonPanelCameraHelper", 2, "defaultExternalPanelHeight interactionListener is null.");
      return 0;
    }
    int j = ((Integer)BaseSharedPreUtil.a(BaseApplication.getContext(), "", "sp_key_input_height", Integer.valueOf(0))).intValue();
    int i = j;
    if (j == 0) {
      i = (int)(XPanelContainer.b() * ((EmoticonPanelController)this.mPanelController).context.getResources().getDisplayMetrics().density);
    }
    return i;
  }
  
  public String getTag()
  {
    return "EmoticonPanelCameraHelper";
  }
  
  public void initBefore()
  {
    this.app = ((EmoticonPanelController)this.mPanelController).app;
    this.mCameraEmoGuideVS = ((ViewStub)((EmoticonPanelController)this.mPanelController).getPanel().findViewById(2131381008));
    this.mInteractionListener = ((EmoticonPanelController)this.mPanelController).getInteractionListener();
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 9, 10, 1 };
  }
  
  public void onAttachedToWindow()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.app;
    if (localQQEmoticonMainPanelApp != null) {
      localQQEmoticonMainPanelApp.addObserver(this.sCameraEmoObserver);
    }
  }
  
  public void onDestory()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.app;
    if (localQQEmoticonMainPanelApp != null) {
      localQQEmoticonMainPanelApp.removeObserver(this.sCameraEmoObserver);
    }
  }
  
  public void onDetachedFromWindow()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = this.app;
    if (localQQEmoticonMainPanelApp != null) {
      localQQEmoticonMainPanelApp.removeObserver(this.sCameraEmoObserver);
    }
  }
  
  void tryHiddenCameraEmoGuide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "timtest tryHiddenCameraEmoGuide start.");
    }
    RelativeLayout localRelativeLayout = this.mCameraEmoGuideView;
    if (localRelativeLayout == null) {
      return;
    }
    localRelativeLayout.setVisibility(8);
  }
  
  public void tryShowCameraEmoGuide(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo.type == 11)
    {
      doSyncCameraEmotion();
      paramEmotionPanelInfo = (CameraEmoRoamingManagerServiceProxy)this.app.getRuntimeService(ICameraEmoRoamingManagerService.class);
      if (paramEmotionPanelInfo.getIsNeedShowGuide()) {
        paramEmotionPanelInfo.setIsNeedShowGuide(false);
      }
      if (((CameraEmotionRoamingDBManagerServiceProxy)this.app.getRuntimeService(ICameraEmotionRoamingDBManagerService.class)).getCatchDataCount() == 0) {
        tryShowCameraEmoGuide();
      }
    }
    else
    {
      tryHiddenCameraEmoGuide();
    }
  }
  
  public void tryUpdateGuideImg()
  {
    Object localObject = this.mCameraEmoGuideView;
    if (localObject != null)
    {
      if (((RelativeLayout)localObject).getVisibility() != 0) {
        return;
      }
      localObject = (ImageView)this.mCameraEmoGuideView.findViewById(2131364247);
      if ((localObject != null) && (((EmoticonPanelController)this.mPanelController).getViewPager() != null))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
        float f = getDefaultExternalPanelHeight();
        localLayoutParams.height = ((int)(0.5F * f));
        localLayoutParams.width = ((int)(localLayoutParams.height * 1.2F));
        localLayoutParams.topMargin = ((int)(f * 0.11F));
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void updateCameraEmoticonPanel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "refresh camera emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelCameraHelper.3(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper
 * JD-Core Version:    0.7.0.1
 */