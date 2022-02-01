package com.tencent.mobileqq.emoticonview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.utils.VasVipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class EmoticonPanelSystemAndEmojiHelper
  extends AbstractEmoticonPanelHelper<EmoticonPanelController>
  implements View.OnClickListener
{
  private static final String LOG_TAG = "EmoticonPanelSystemAndEmojiHelper";
  private long mLastOpenTime = -1L;
  private int mLastPosition = -1;
  private ImageView mPopupGuideView;
  
  public EmoticonPanelSystemAndEmojiHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private SystemAndEmojiAdapter fetchSystemAndEmojiAdapter()
  {
    Object localObject = ((EmoticonPanelController)this.mPanelController).getPanelDataList();
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = ((EmoticonPanelController)this.mPanelController).getPageAdapter();
    if ((localObject != null) && (((List)localObject).size() > 0) && (localEmotionPanelViewPagerAdapter != null))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseEmotionAdapter localBaseEmotionAdapter = localEmotionPanelViewPagerAdapter.getAdapterFromCache((EmotionPanelInfo)((Iterator)localObject).next());
        if ((localBaseEmotionAdapter instanceof SystemAndEmojiAdapter)) {
          return (SystemAndEmojiAdapter)localBaseEmotionAdapter;
        }
      }
    }
    return null;
  }
  
  public String getTag()
  {
    return "EmoticonPanelSystemAndEmojiHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14, 8, 3, 7, 6 };
  }
  
  public void onClick(View paramView)
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = ((EmoticonPanelController)this.mPanelController).app;
    if (paramView.getId() == 2131362355)
    {
      SystemAndEmojiAdapter localSystemAndEmojiAdapter = fetchSystemAndEmojiAdapter();
      if (localSystemAndEmojiAdapter != null) {
        localSystemAndEmojiAdapter.setSelectionToApolloEmoticon();
      }
      VasVipUtils.a(localQQEmoticonMainPanelApp.getQQAppInterface(), "cmshow", "Apollo", "expresstab_bubble_click", 0, 0, new String[0]);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestory()
  {
    Object localObject = ((EmoticonPanelController)this.mPanelController).app;
    if (localObject != null)
    {
      localObject = (CommonUsedSystemEmojiManagerServiceProxy)((QQEmoticonMainPanelApp)localObject).getRuntimeService(ICommonUsedSystemEmojiManagerService.class);
      if (localObject != null) {
        ((CommonUsedSystemEmojiManagerServiceProxy)localObject).saveSystemEmojiInfoToFile();
      }
    }
    removePopupGuide();
    tryReportPanelShowTime();
  }
  
  public void onHide(boolean paramBoolean)
  {
    IPanelInteractionListener localIPanelInteractionListener = ((EmoticonPanelController)this.mPanelController).getInteractionListener();
    if (localIPanelInteractionListener != null) {
      localIPanelInteractionListener.removeEmoticonGuideBubble();
    }
    tryReportPanelShowTime();
  }
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt != 0) {
      removePopupGuide();
    }
    reportPanelOpenTimeEvent(paramInt);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "tryReportShowTime onPause ");
    }
    tryReportPanelShowTime();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume select: ");
      localStringBuilder.append(BasePanelModel.sLastSelectedSecondTabIndex);
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, localStringBuilder.toString());
    }
    reportPanelOpenTimeEvent(BasePanelModel.sLastSelectedSecondTabIndex);
  }
  
  public void onShowPageFinish()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowPageFinish select: ");
      localStringBuilder.append(BasePanelModel.sLastSelectedSecondTabIndex);
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, localStringBuilder.toString());
    }
    reportPanelOpenTimeEvent(BasePanelModel.sLastSelectedSecondTabIndex);
  }
  
  void removePopupGuide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "[removePopupGuide]");
    }
    ImageView localImageView = this.mPopupGuideView;
    if ((localImageView != null) && (localImageView.getParent() != null)) {
      ((ViewGroup)this.mPopupGuideView.getParent()).removeView(this.mPopupGuideView);
    }
  }
  
  protected void reportPanelOpenTimeEvent(int paramInt)
  {
    if (this.mLastPosition != paramInt)
    {
      if (paramInt < 0) {
        return;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPageSelected position: ");
        localStringBuilder.append(paramInt);
        QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, localStringBuilder.toString());
      }
      if (!((EmoticonPanelController)this.mPanelController).isInAIO())
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mBusinessType not AIO, it is ");
          localStringBuilder.append(((EmoticonPanelController)this.mPanelController).getBusinessType());
          QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, localStringBuilder.toString());
        }
        return;
      }
      if ((((EmoticonPanelController)this.mPanelController).getPanelDataList() != null) && (paramInt < ((EmoticonPanelController)this.mPanelController).getPanelDataList().size()))
      {
        if (((EmoticonPanelController)this.mPanelController).findIndexByPanelType(7) == paramInt) {
          this.mLastOpenTime = System.currentTimeMillis();
        } else {
          tryReportPanelShowTime();
        }
        this.mLastPosition = paramInt;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "mPanelController.panelDataList is null or position error ");
      }
    }
  }
  
  public void showEmoticonPopupGuide()
  {
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp = ((EmoticonPanelController)this.mPanelController).app;
    Context localContext = ((EmoticonPanelController)this.mPanelController).context;
    if (localQQEmoticonMainPanelApp == null) {
      return;
    }
    if (((IApolloUtil)QRoute.api(IApolloUtil.class)).shouldShowPopupGuide())
    {
      if (this.mPopupGuideView == null)
      {
        this.mPopupGuideView = new ImageView(localContext);
        this.mPopupGuideView.setId(2131362355);
        this.mPopupGuideView.setImageResource(2130837965);
      }
      this.mPopupGuideView.setClickable(true);
      this.mPopupGuideView.setOnClickListener(this);
      if (this.mPopupGuideView.getParent() != null) {
        ((ViewGroup)this.mPopupGuideView.getParent()).removeView(this.mPopupGuideView);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = EmotionUtils.a(52.0F, localContext.getResources());
      localLayoutParams.rightMargin = EmotionUtils.a(15.0F, localContext.getResources());
      ((EmoticonPanelController)this.mPanelController).getPanel().addView(this.mPopupGuideView, localLayoutParams);
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).onPopupGuideShown();
      VasVipUtils.a(localQQEmoticonMainPanelApp.getQQAppInterface(), "cmshow", "Apollo", "expresstab_bubble_view", 0, 0, new String[0]);
    }
  }
  
  public void switchSystemEmojiTabLocationPos(int paramInt1, int paramInt2)
  {
    if (BasePanelModel.sLastSelectedSecondTabIndex == ((EmoticonPanelController)this.mPanelController).findIndexByPanelType(7))
    {
      SystemAndEmojiAdapter localSystemAndEmojiAdapter = fetchSystemAndEmojiAdapter();
      if (localSystemAndEmojiAdapter != null) {
        localSystemAndEmojiAdapter.setSelectionToEmoticonByLocalId(paramInt1, paramInt2);
      }
    }
    else
    {
      ((EmoticonPanelController)this.mPanelController).getPanel().mLocalId = paramInt2;
      ((EmoticonPanelController)this.mPanelController).getPanel().mEmotionType = paramInt1;
      ((EmoticonPanelController)this.mPanelController).initEmoticonView(7);
    }
  }
  
  protected void tryReportPanelShowTime()
  {
    if (this.mLastOpenTime != -1L)
    {
      long l = (System.currentTimeMillis() - this.mLastOpenTime) / 1000L;
      StringBuilder localStringBuilder;
      if (l >= 0L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l);
        ReportController.b(null, "dc00898", "", "", "0X800B9F5", "0X800B9F5", 0, 0, localStringBuilder.toString(), "", "", "");
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tryReportShowTime report show time: ");
        localStringBuilder.append(l);
        QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, localStringBuilder.toString());
      }
      this.mLastOpenTime = -1L;
      this.mLastPosition = -1;
    }
  }
  
  @TargetApi(11)
  void updateEmojiMallRedpoint()
  {
    if (((RedTouchManagerProxy)((EmoticonPanelController)this.mPanelController).app.getRuntimeService(IRedTouchManager.class)).getAppInfoNewFlagByPath("100610.100611") != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "emoji mall has redpoint.");
      }
      ReportController.b(((EmoticonPanelController)this.mPanelController).app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B8", 0, 0, "", "", "", "");
      if (((EmoticonPanelController)this.mPanelController).context.getSharedPreferences("mobileQQ", 0).getBoolean("emo_panel_mall_new_played", false))
      {
        ((EmoticonPanelController)this.mPanelController).getNewFlag().setVisibility(0);
        return;
      }
      ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelSystemAndEmojiHelper.2(this), 200L);
    }
  }
  
  public void updateSystemAndEmojiPanel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelSystemAndEmojiHelper.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper
 * JD-Core Version:    0.7.0.1
 */