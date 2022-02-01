package com.tencent.mobileqq.emoticonview;

import amou;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqzw;
import arad;
import bfur;
import bfyz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class EmoticonPanelCameraHelper
  extends AbstractEmoticonPanelHelper
{
  private static final String LOG_TAG = "EmoticonPanelCameraHelper";
  protected QQAppInterface app;
  private volatile long lastJumpCameraTime;
  private ViewStub mCameraEmoGuideVS;
  private RelativeLayout mCameraEmoGuideView;
  amou sCameraEmoObserver = new EmoticonPanelCameraHelper.2(this);
  
  public EmoticonPanelCameraHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private void showDialogTipIfNeed(int paramInt)
  {
    if (CameraEmoAllSend.a) {
      return;
    }
    Context localContext = this.mPanelController.context;
    EmoticonTabAdapter localEmoticonTabAdapter = this.mPanelController.mEmoticonTabAdapter;
    EmoticonPanelViewPager localEmoticonPanelViewPager = this.mPanelController.viewPager;
    EmoticonMainPanel localEmoticonMainPanel = this.mPanelController.getPanel();
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      CameraEmoAllSend.a = bool;
      if ((!CameraEmoAllSend.a) || (localEmoticonTabAdapter == null) || (localEmoticonPanelViewPager == null)) {
        break;
      }
      paramInt = this.mPanelController.findIndexByPanelType(11);
      if ((BaseActivity.sTopActivity == null) || (localEmoticonMainPanel.getVisibility() != 0) || (localEmoticonPanelViewPager.getCurrentItem() != paramInt)) {
        break;
      }
      bfur.a(BaseActivity.sTopActivity, localContext.getString(2131691749), 2131691750, 2131691756, new EmoticonPanelCameraHelper.4(this, localContext), new EmoticonPanelCameraHelper.5(this)).show();
      return;
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
      ImageView localImageView = (ImageView)this.mCameraEmoGuideView.findViewById(2131364159);
      if (localImageView != null) {
        localImageView.setOnClickListener(new EmoticonPanelCameraHelper.1(this));
      }
    }
    this.mCameraEmoGuideView.setClickable(true);
    this.mCameraEmoGuideView.setBackgroundColor(this.mPanelController.context.getResources().getColor(2131165631));
    this.mCameraEmoGuideView.setVisibility(0);
  }
  
  void doSyncCameraEmotion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "doSyncCameraEmotion");
    }
    QQAppInterface localQQAppInterface = this.mPanelController.app;
    Context localContext = this.mPanelController.context;
    if (localQQAppInterface == null) {
      return;
    }
    ThreadManager.excute(new EmoticonPanelCameraHelper.6(this, localContext, localQQAppInterface), 128, null, false);
  }
  
  protected int getDefaultExternalPanelHeight()
  {
    int j = ((Integer)bfyz.a(BaseApplication.getContext(), "", "sp_key_input_height", Integer.valueOf(0))).intValue();
    int i = j;
    if (j == 0) {
      i = (int)(XPanelContainer.b() * this.mPanelController.context.getResources().getDisplayMetrics().density);
    }
    return i;
  }
  
  public String getTag()
  {
    return "EmoticonPanelCameraHelper";
  }
  
  public void initBefore()
  {
    this.app = this.mPanelController.app;
    this.mCameraEmoGuideVS = ((ViewStub)this.mPanelController.getPanel().findViewById(2131380971));
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 9, 10, 1 };
  }
  
  public void onAttachedToWindow()
  {
    if (this.app != null) {
      this.app.addObserver(this.sCameraEmoObserver);
    }
  }
  
  public void onDestory()
  {
    if (this.app != null) {
      this.app.removeObserver(this.sCameraEmoObserver);
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (this.app != null) {
      this.app.removeObserver(this.sCameraEmoObserver);
    }
  }
  
  void tryHiddenCameraEmoGuide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "timtest tryHiddenCameraEmoGuide start.");
    }
    if (this.mCameraEmoGuideView == null) {
      return;
    }
    this.mCameraEmoGuideView.setVisibility(8);
  }
  
  public void tryShowCameraEmoGuide(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo.type == 11)
    {
      doSyncCameraEmotion();
      paramEmotionPanelInfo = (aqzw)this.app.getManager(334);
      if (paramEmotionPanelInfo.b()) {
        paramEmotionPanelInfo.a(false);
      }
      if (((arad)this.app.getManager(333)).a() == 0) {
        tryShowCameraEmoGuide();
      }
      return;
    }
    tryHiddenCameraEmoGuide();
  }
  
  void tryUpdateGuideImg()
  {
    if ((this.mCameraEmoGuideView == null) || (this.mCameraEmoGuideView.getVisibility() != 0)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.mCameraEmoGuideView.findViewById(2131364161);
    } while ((localImageView == null) || (this.mPanelController.viewPager == null));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = getDefaultExternalPanelHeight();
    localLayoutParams.height = ((int)(i * 0.5F));
    localLayoutParams.width = ((int)(localLayoutParams.height * 1.2F));
    localLayoutParams.topMargin = ((int)(i * 0.11F));
    localImageView.setLayoutParams(localLayoutParams);
  }
  
  public void updateCameraEmoticonPanel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "refresh camera emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelCameraHelper.3(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper
 * JD-Core Version:    0.7.0.1
 */