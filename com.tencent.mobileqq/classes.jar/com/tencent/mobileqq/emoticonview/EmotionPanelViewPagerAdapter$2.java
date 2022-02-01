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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("instantiateItem get data callback, panelType = ");
    ((StringBuilder)localObject).append(this.val$panelType);
    ((StringBuilder)localObject).append(", panelInfo = ");
    ((StringBuilder)localObject).append(this.val$panelInfo);
    localObject = ((StringBuilder)localObject).toString();
    int i = 1;
    QLog.d("EmotionPanelViewPagerAdapter", 1, (String)localObject);
    this.val$listView.setOnScrollListener(new EmotionPanelViewPagerAdapter.2.1(this));
    if (this.val$panelType != 5) {
      i = 0;
    }
    localObject = this.val$data;
    if ((localObject != null) && (((List)localObject).size() > i)) {
      this.val$adapter.setData(this.val$data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.2
 * JD-Core Version:    0.7.0.1
 */