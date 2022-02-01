package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.util.QQTextToSpeechHelper;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class EmoticonPanelMallHelper$6
  implements AdapterView.OnItemClickListener
{
  EmoticonPanelMallHelper$6(EmoticonPanelMallHelper paramEmoticonPanelMallHelper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = ((EmoticonPanelController)this.this$0.mPanelController).app;
    long l = System.currentTimeMillis();
    StartupTracker.a(null, "AIO_EmoticonPanel_TabClick");
    Object localObject2 = ((EmoticonPanelController)this.this$0.mPanelController).getPanelDataList();
    if (localObject2 != null)
    {
      while ((paramInt >= ((List)localObject2).size()) || (((EmoticonPanelTabSortHelper)((EmoticonPanelController)this.this$0.mPanelController).getHelper(8)).setSelection(paramInt))) {}
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mOnItemClicked position: ");
        localStringBuilder.append(paramInt);
        QLog.d("EmoticonPanelMallHelper", 2, localStringBuilder.toString());
      }
      EmoticonPanelMallHelper.access$002(this.this$0, true);
      EmoticonPanelMallHelper.access$102(this.this$0, 1);
      ((EmoticonPanelController)this.this$0.mPanelController).getBasePanelView().mEmoticonTabs.setSelection(paramInt);
      boolean bool;
      if ((((List)localObject2).size() > BasePanelView.sRecommendEmoticonViewPoSition) && (((EmotionPanelInfo)((List)localObject2).get(BasePanelView.sRecommendEmoticonViewPoSition)).type == 8)) {
        bool = true;
      } else {
        bool = false;
      }
      BasePanelModel.sIsRecommendExist = bool;
      localObject2 = (EmotionPanelInfo)((List)localObject2).get(paramInt);
      localObject1 = this.this$0.getTalkBackWordingAndReportEvent(paramView, (QQEmoticonMainPanelApp)localObject1, (EmotionPanelInfo)localObject2);
      if (BasePanelModel.sLastSelectedSecondTabIndex != paramInt)
      {
        ((EmoticonPanelController)this.this$0.mPanelController).getHelperProvider().dispatchLifeCycle(13, paramInt, false);
        BasePanelModel.sLastSelectedSecondTabIndex = paramInt;
        ((EmoticonPanelController)this.this$0.mPanelController).showPanelByTabIndex(paramInt);
        if (AppSetting.e) {
          QQTextToSpeechHelper.a((String)localObject1);
        }
        StartupTracker.a("AIO_EmoticonPanel_TabClick", null);
        this.this$0.isClickNoChangeTab = true;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[Performance] TabsChanged duration:");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
          QLog.d("EmoticonPanelMallHelper", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.6
 * JD-Core Version:    0.7.0.1
 */