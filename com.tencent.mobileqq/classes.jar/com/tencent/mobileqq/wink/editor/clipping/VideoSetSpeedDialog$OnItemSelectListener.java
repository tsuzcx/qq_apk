package com.tencent.mobileqq.wink.editor.clipping;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class VideoSetSpeedDialog$OnItemSelectListener
  implements View.OnClickListener
{
  float a;
  
  public VideoSetSpeedDialog$OnItemSelectListener(VideoSetSpeedDialog paramVideoSetSpeedDialog, float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.b.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((TextView)localEntry.getValue()).setSelected(false);
      ((TextView)localEntry.getValue()).setTextColor(VideoSetSpeedDialog.a(this.b));
    }
    paramView.setSelected(true);
    ((TextView)paramView).setTextColor(VideoSetSpeedDialog.b(this.b));
    if (this.b.c != null)
    {
      this.b.c.onChangeSpeed(this.a, paramView);
      this.b.dismiss();
    }
    VideoReport.reportEvent("dt_clck", VideoSetSpeedDialog.c(this.b), WinkDTParamBuilder.buildElementParams());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.VideoSetSpeedDialog.OnItemSelectListener
 * JD-Core Version:    0.7.0.1
 */