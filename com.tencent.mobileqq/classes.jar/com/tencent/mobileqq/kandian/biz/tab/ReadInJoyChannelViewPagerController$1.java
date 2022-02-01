package com.tencent.mobileqq.kandian.biz.tab;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class ReadInJoyChannelViewPagerController$1
  implements View.OnClickListener
{
  ReadInJoyChannelViewPagerController$1(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController) {}
  
  public void onClick(View paramView)
  {
    if (ChannelModeConfigHandler.a()) {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("currentIndex", ReadInJoyChannelViewPagerController.a(this.a).getCurrentItem());
    PublicTransFragmentActivity.b(ReadInJoyChannelViewPagerController.b(this.a), paramView, ReadInJoyChannelPanelFragment.class);
    try
    {
      RIJChannelReporter.a("0X8009497", new RIJTransMergeKanDianReport.ReportR5Builder().addFolderStatus().addRedDotStatus(this.a.b()).build());
    }
    catch (JSONException paramView)
    {
      QLog.e("ReadInJoyChannelViewPagerController", 1, QLog.getStackTraceString(paramView));
    }
    ReadInJoyChannelViewPagerController.a(this.a, false);
    ReadInJoyChannelViewPagerController.c(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController.1
 * JD-Core Version:    0.7.0.1
 */