package com.tencent.mobileqq.flashshow.personal.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalInfo;
import com.tencent.mobileqq.flashshow.personal.widget.FSPersonalInfoWidget;
import com.tencent.mobileqq.flashshow.widgets.FSBaseSingleViewBlock;
import feedcloud.FeedCloudMeta.StUser;

public class FSPersonalInfoBlock
  extends FSBaseSingleViewBlock
{
  private FSPersonalInfoWidget a;
  private final FeedCloudMeta.StUser b;
  
  public FSPersonalInfoBlock(Bundle paramBundle, FeedCloudMeta.StUser paramStUser)
  {
    super(paramBundle);
    this.b = paramStUser;
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, MultiViewBlock paramMultiViewBlock)
  {
    this.a = new FSPersonalInfoWidget(paramViewGroup.getContext(), this.b);
    return this.a;
  }
  
  public void a(FSPersonalInfo paramFSPersonalInfo)
  {
    FSPersonalInfoWidget localFSPersonalInfoWidget = this.a;
    if (localFSPersonalInfoWidget != null) {
      localFSPersonalInfoWidget.setData(paramFSPersonalInfo);
    }
  }
  
  public void loadData(LoadInfo paramLoadInfo) {}
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalInfoBlock
 * JD-Core Version:    0.7.0.1
 */