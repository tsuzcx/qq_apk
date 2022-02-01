package com.tencent.mobileqq.emoticonview;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;

class EmotionPanelViewPagerAdapter$2
  implements Runnable
{
  EmotionPanelViewPagerAdapter$2(EmotionPanelViewPagerAdapter paramEmotionPanelViewPagerAdapter, int paramInt, EmotionPanelInfo paramEmotionPanelInfo, ListView paramListView, List paramList, BaseEmotionAdapter paramBaseEmotionAdapter) {}
  
  public void run()
  {
    int i = 1;
    QLog.d("EmotionPanelViewPagerAdapter", 1, "instantiateItem get data callback, panelType = " + this.val$panelType + ", panelInfo = " + this.val$panelInfo);
    this.val$listView.setOnScrollListener(new EmotionPanelViewPagerAdapter.2.1(this));
    if (this.val$panelType == 5) {}
    for (;;)
    {
      if ((this.val$data != null) && (this.val$data.size() > i)) {
        this.val$adapter.setData(this.val$data);
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.2
 * JD-Core Version:    0.7.0.1
 */