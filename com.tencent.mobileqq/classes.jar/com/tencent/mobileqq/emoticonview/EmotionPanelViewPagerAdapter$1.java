package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.widget.ListView;
import java.util.List;

class EmotionPanelViewPagerAdapter$1
  implements Runnable
{
  EmotionPanelViewPagerAdapter$1(EmotionPanelViewPagerAdapter paramEmotionPanelViewPagerAdapter, int paramInt, BaseEmotionAdapter paramBaseEmotionAdapter, EmotionPanelInfo paramEmotionPanelInfo, ListView paramListView) {}
  
  public void run()
  {
    if (this.val$panelType == 1) {
      if (this.this$0.isOnlySysEmotion) {
        localObject = SystemAndEmojiEmoticonInfo.getOnlySysEmoticonListFromConfig(this.this$0.app, this.val$adapter.columnNum, this.this$0.sysEmotionOrder);
      }
    }
    QQEmoticonMainPanelApp localQQEmoticonMainPanelApp;
    int j;
    EmoticonPackage localEmoticonPackage;
    int i;
    for (Object localObject = SystemAndEmojiEmoticonInfo.getEmoticonListFromConfig(this.this$0.app, this.this$0.isFilterSysFaceBeyond255, this.val$adapter.columnNum, this.this$0.businessType);; localObject = ((EmotionPanelDataBuilder)localObject).syncGetEmotionPanelData(localQQEmoticonMainPanelApp, j, localEmoticonPackage, i, this.this$0.businessType, this.this$0.kanDianBiu))
    {
      break;
      localObject = EmotionPanelDataBuilder.getInstance();
      localQQEmoticonMainPanelApp = this.this$0.app;
      j = this.val$panelType;
      localEmoticonPackage = this.val$panelInfo.emotionPkg;
      if (this.this$0.interactionListener != null) {
        i = this.this$0.interactionListener.getCurType();
      } else {
        i = -1;
      }
    }
    EmotionPanelViewPagerAdapter.access$000(this.this$0, this.val$panelInfo.emotionPkg, this.val$adapter, (List)localObject);
    this.this$0.onGetPanelDataResult(this.val$panelType, this.val$panelInfo, this.val$adapter, this.val$listView, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */