package com.tencent.mobileqq.emoticonview;

import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.qphone.base.util.QLog;

public class EmoticonPanelSettingHelper
  extends AbstractEmoticonPanelHelper<EmoticonPanelController>
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
    if (paramEmotionPanelInfo == null)
    {
      QLog.e("EmoticonPanelSettingHelper", 1, "getMoreBtnStatusByEmotionInfo info = null");
      return -1;
    }
    if ((paramEmotionPanelInfo.type != 7) && (paramEmotionPanelInfo.type != 10)) {
      return 1;
    }
    return 2;
  }
  
  private static void updateIndividuationRedPoint(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp)
  {
    GameCenterManagerImpProxy localGameCenterManagerImpProxy = (GameCenterManagerImpProxy)paramQQEmoticonMainPanelApp.getManager(((IEmosmService)QRoute.api(IEmosmService.class)).getManagerID("GAMECENTER_MANAGER"));
    if (localGameCenterManagerImpProxy != null)
    {
      int i = localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100001");
      int i3 = 1;
      if (i != -1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100003") != -1) {
          i = 1;
        } else {
          i = 0;
        }
        int j;
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100002") != -1) {
          j = 1;
        } else {
          j = 0;
        }
        int k;
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100006") != -1) {
          k = 1;
        } else {
          k = 0;
        }
        int m;
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100018") != -1) {
          m = 1;
        } else {
          m = 0;
        }
        int n;
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100020") != -1) {
          n = 1;
        } else {
          n = 0;
        }
        int i1;
        if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100021") != -1) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        boolean bool = ((FontManagerProxy)paramQQEmoticonMainPanelApp.getRuntimeService(IFontManagerService.class)).isSupportFont();
        int i2;
        if ((bool) && (localGameCenterManagerImpProxy.checkNewFlagByPath("100005.100011") != -1)) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if (((bool) && (i == 0) && (j == 0) && (k == 0) && (i2 == 0) && (m == 0) && (n == 0) && (i1 == 0)) || ((!bool) && (i == 0) && (j == 0) && (k == 0) && (m == 0) && (n == 0) && (i1 == 0)))
        {
          if (localGameCenterManagerImpProxy.checkNewFlagByPath("100005") != -1) {
            i = i3;
          } else {
            i = 0;
          }
          if (i != 0) {
            ((RedTouchManagerProxy)paramQQEmoticonMainPanelApp.getRuntimeService(IRedTouchManager.class)).onRedTouchItemClick("100005");
          }
        }
      }
    }
  }
  
  public String getTag()
  {
    return "EmoticonPanelSettingHelper";
  }
  
  public void initBefore()
  {
    EmoticonMainPanel localEmoticonMainPanel = ((EmoticonPanelController)this.mPanelController).getPanel();
    this.mMoreEmoticonButton = ((ImageView)localEmoticonMainPanel.findViewById(2131363975));
    this.mEmoticonSettingBtn = ((ImageView)localEmoticonMainPanel.findViewById(2131364064));
    this.mMoreEmoticonButton.setOnClickListener(this);
    this.mEmoticonSettingBtn.setOnClickListener(this);
    if ((((EmoticonPanelController)this.mPanelController).getBusinessType() == 3) || (this.mHideSettingButton) || (((EmoticonPanelController)this.mPanelController).getBasePanelView().mHideAllSettingTabs)) {
      this.mEmoticonSettingBtn.setVisibility(8);
    }
    if ((!((EmoticonPanelController)this.mPanelController).getParams().disableMoreEmotionButton) && (!this.mHideMoreButton) && (!((EmoticonPanelController)this.mPanelController).getBasePanelView().mHideAllSettingTabs))
    {
      this.mMoreEmoticonButton.setVisibility(0);
      return;
    }
    this.mMoreEmoticonButton.setVisibility(8);
  }
  
  public void initGuideView(View paramView)
  {
    if (paramView != null)
    {
      if (this.mGuideView != null) {
        return;
      }
      this.mGuideView = new EmoticonStoreTabGuideView(paramView.getContext());
      this.mGuideView.initUI();
      this.mGuideView.setOnDismissListener(this);
      this.uiHandler = paramView.getHandler();
    }
  }
  
  public int[] interestedIn()
  {
    return new int[] { 1 };
  }
  
  public void onClick(View paramView)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onDestory()
  {
    Handler localHandler = this.uiHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.hiddenGuide);
      this.uiHandler = null;
    }
    super.onDestory();
  }
  
  public void onDismiss()
  {
    Handler localHandler = this.uiHandler;
    if (localHandler != null) {
      localHandler.removeCallbacks(this.hiddenGuide);
    }
    EmoticonStoreTabEntryUtils.doOnStoryGuideShowed();
  }
  
  public boolean performClick(int paramInt)
  {
    ImageView localImageView;
    if (paramInt == 13)
    {
      localImageView = this.mMoreEmoticonButton;
      if (localImageView != null)
      {
        localImageView.performClick();
        return true;
      }
    }
    if (paramInt == 14)
    {
      localImageView = this.mEmoticonSettingBtn;
      if (localImageView != null)
      {
        localImageView.performClick();
        return true;
      }
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
    ImageView localImageView = this.mEmoticonSettingBtn;
    if (localImageView != null) {
      localImageView.setVisibility(paramInt);
    }
  }
  
  public void setHideMoreAndSettingButton(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mHideMoreButton = paramBoolean1;
    this.mHideSettingButton = paramBoolean2;
  }
  
  protected void setMoreSettingVisibility(int paramInt)
  {
    ImageView localImageView = this.mMoreEmoticonButton;
    if (localImageView != null) {
      localImageView.setVisibility(paramInt);
    }
  }
  
  public void setmGuideView(EmoticonStoreTabGuideView paramEmoticonStoreTabGuideView)
  {
    this.mGuideView = paramEmoticonStoreTabGuideView;
  }
  
  public void showGuideView(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    if (this.mGuideView == null) {
      initGuideView(paramView);
    }
    if ((this.mMoreEmoticonButton != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.mGuideView.showAsDropDown(this.mMoreEmoticonButton, paramInt1, -paramInt2, 51);
    } else {
      this.mGuideView.showAtLocation(paramView, 83, paramInt1, paramInt2);
    }
    paramView = this.uiHandler;
    if (paramView != null)
    {
      paramView.removeCallbacks(this.hiddenGuide);
      this.uiHandler.postDelayed(this.hiddenGuide, 5000L);
    }
  }
  
  public void switchMoreSettingStyle(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {
      return;
    }
    boolean bool = ((EmoticonPanelController)this.mPanelController).getBasePanelView().hasBigEmotion;
    EmoticonPanelParams localEmoticonPanelParams = ((EmoticonPanelController)this.mPanelController).getParams();
    int i = getMoreBtnStatusByEmotionInfo(paramEmotionPanelInfo);
    if (this.mBtnStatus != i)
    {
      this.mBtnStatus = i;
      if ((bool) && (!localEmoticonPanelParams.disableMoreEmotionButton))
      {
        if (this.mHideMoreButton)
        {
          this.mMoreEmoticonButton.setVisibility(8);
        }
        else
        {
          this.mMoreEmoticonButton.setVisibility(0);
          this.mMoreEmoticonButton.setImageResource(2130847370);
        }
      }
      else if ((!((EmoticonPanelExtendHelper)((EmoticonPanelController)this.mPanelController).getHelper(1)).isShowExtendPanel()) && (this.mBtnStatus == 2) && (!localEmoticonPanelParams.disableMoreEmotionButton))
      {
        this.mMoreEmoticonButton.setVisibility(0);
        this.mMoreEmoticonButton.setImageResource(2130847359);
        this.mMoreEmoticonButton.setPadding((int)(((EmoticonPanelController)this.mPanelController).getBasePanelView().density * 10.0F), 0, 0, 0);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelSettingHelper", 2, "onPageSelected, show del pic");
        }
      }
      else
      {
        this.mMoreEmoticonButton.setVisibility(8);
      }
      if (((EmoticonPanelController)this.mPanelController).getBasePanelView().mHideAllSettingTabs) {
        this.mMoreEmoticonButton.setVisibility(8);
      }
    }
  }
  
  public void switchSettingBtnStyle(EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {
      return;
    }
    boolean bool = ((EmoticonPanelController)this.mPanelController).getBasePanelView().hasBigEmotion;
    EmoticonPanelParams localEmoticonPanelParams = ((EmoticonPanelController)this.mPanelController).getParams();
    int i = getMoreBtnStatusByEmotionInfo(paramEmotionPanelInfo);
    if (this.mBtnStatus != i)
    {
      this.mBtnStatus = i;
      if ((bool) && (!localEmoticonPanelParams.disableMoreEmotionButton))
      {
        if (this.mHideMoreButton)
        {
          this.mMoreEmoticonButton.setVisibility(8);
        }
        else
        {
          this.mMoreEmoticonButton.setVisibility(0);
          this.mMoreEmoticonButton.setImageResource(2130847370);
          this.mMoreEmoticonButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
      }
      else if ((!((EmoticonPanelExtendHelper)((EmoticonPanelController)this.mPanelController).getHelper(1)).isShowExtendPanel()) && (this.mBtnStatus == 2) && (!localEmoticonPanelParams.disableMoreEmotionButton))
      {
        this.mMoreEmoticonButton.setVisibility(0);
        this.mMoreEmoticonButton.setImageResource(2130847359);
        this.mMoreEmoticonButton.setScaleType(ImageView.ScaleType.CENTER);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelSettingHelper", 2, "onPageSelected, show del pic");
        }
      }
      else
      {
        this.mMoreEmoticonButton.setVisibility(8);
      }
      if (((EmoticonPanelController)this.mPanelController).getBasePanelView().mHideAllSettingTabs) {
        this.mMoreEmoticonButton.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSettingHelper
 * JD-Core Version:    0.7.0.1
 */