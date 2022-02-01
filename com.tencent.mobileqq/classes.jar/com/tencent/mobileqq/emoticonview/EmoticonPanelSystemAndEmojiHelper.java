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
import azvi;
import bcef;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class EmoticonPanelSystemAndEmojiHelper
  extends AbstractEmoticonPanelHelper
  implements View.OnClickListener
{
  private static final String LOG_TAG = "EmoticonPanelSystemAndEmojiHelper";
  private ImageView mPopupGuideView;
  
  public EmoticonPanelSystemAndEmojiHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private SystemAndEmojiAdapter fetchSystemAndEmojiAdapter()
  {
    Object localObject = this.mPanelController.panelDataList;
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = this.mPanelController.pageAdapter;
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
    return new int[] { 4, 8, 3 };
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.mPanelController.app;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SystemAndEmojiAdapter localSystemAndEmojiAdapter = fetchSystemAndEmojiAdapter();
      if (localSystemAndEmojiAdapter != null) {
        localSystemAndEmojiAdapter.setSelectionToApolloEmoticon();
      }
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "expresstab_bubble_click", 0, 0, new String[0]);
    }
  }
  
  public void onDestory()
  {
    Object localObject = this.mPanelController.app;
    if (localObject != null)
    {
      localObject = (CommonUsedSystemEmojiManager)((QQAppInterface)localObject).getManager(172);
      if (localObject != null) {
        ((CommonUsedSystemEmojiManager)localObject).saveSystemEmojiInfoToFile();
      }
    }
    removePopupGuide();
  }
  
  public void onHide(boolean paramBoolean)
  {
    if (this.mPanelController.mBaseChatPie != null) {
      this.mPanelController.mBaseChatPie.removeEmoticonGuideBubble();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt != 0) {
      removePopupGuide();
    }
  }
  
  void removePopupGuide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "[removePopupGuide]");
    }
    if ((this.mPopupGuideView != null) && (this.mPopupGuideView.getParent() != null)) {
      ((ViewGroup)this.mPopupGuideView.getParent()).removeView(this.mPopupGuideView);
    }
  }
  
  void showEmoticonPopupGuide()
  {
    QQAppInterface localQQAppInterface = this.mPanelController.app;
    Context localContext = this.mPanelController.context;
    if (localQQAppInterface == null) {}
    while (!ApolloUtil.c()) {
      return;
    }
    if (this.mPopupGuideView == null)
    {
      this.mPopupGuideView = new ImageView(localContext);
      this.mPopupGuideView.setId(2131362364);
      this.mPopupGuideView.setImageResource(2130838030);
    }
    this.mPopupGuideView.setClickable(true);
    this.mPopupGuideView.setOnClickListener(this);
    if (this.mPopupGuideView.getParent() != null) {
      ((ViewGroup)this.mPopupGuideView.getParent()).removeView(this.mPopupGuideView);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = AIOUtils.dp2px(52.0F, localContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.dp2px(15.0F, localContext.getResources());
    this.mPanelController.getPanel().addView(this.mPopupGuideView, localLayoutParams);
    ApolloUtil.b();
    VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "expresstab_bubble_view", 0, 0, new String[0]);
  }
  
  public void switchSystemEmojiTabLocationPos(int paramInt1, int paramInt2)
  {
    if (EmoticonPanelController.sLastSelectedSecondTabIndex == this.mPanelController.findIndexByPanelType(7))
    {
      SystemAndEmojiAdapter localSystemAndEmojiAdapter = fetchSystemAndEmojiAdapter();
      if (localSystemAndEmojiAdapter != null) {
        localSystemAndEmojiAdapter.setSelectionToEmoticonByLocalId(paramInt1, paramInt2);
      }
      return;
    }
    this.mPanelController.getPanel().mLocalId = paramInt2;
    this.mPanelController.getPanel().mEmotionType = paramInt1;
    this.mPanelController.initEmoticonView(7);
  }
  
  @TargetApi(11)
  void updateEmojiMallRedpoint()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((azvi)this.mPanelController.app.getManager(36)).a(String.valueOf("100610.100611"));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "emoji mall has redpoint.");
      }
      bcef.b(this.mPanelController.app, "CliOper", "", "", "ep_mall", "0X80057B8", 0, 0, "", "", "", "");
      if (this.mPanelController.context.getSharedPreferences("mobileQQ", 0).getBoolean("emo_panel_mall_new_played", false)) {
        this.mPanelController.mNewFlag.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelSystemAndEmojiHelper.2(this), 200L);
  }
  
  public void updateSystemAndEmojiPanel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelSystemAndEmojiHelper.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper
 * JD-Core Version:    0.7.0.1
 */