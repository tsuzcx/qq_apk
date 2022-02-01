package com.tencent.mobileqq.emoticonview.relateemo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RelatedEmoticonListAdapter$1
  implements View.OnClickListener
{
  RelatedEmoticonListAdapter$1(RelatedEmoticonListAdapter paramRelatedEmoticonListAdapter, EmoticonInfo paramEmoticonInfo) {}
  
  public void onClick(View paramView)
  {
    RelatedEmoticonListAdapter.access$000(this.this$0, this.val$emotionInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonListAdapter.1
 * JD-Core Version:    0.7.0.1
 */