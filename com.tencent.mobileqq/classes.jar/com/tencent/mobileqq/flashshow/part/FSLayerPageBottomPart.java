package com.tencent.mobileqq.flashshow.part;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.bean.FSCommentInfo;
import com.tencent.mobileqq.flashshow.ioc.IFSTabFragmentIoc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FSLayerPageBottomPart
  extends FSBasePart
  implements View.OnClickListener
{
  private LinearLayout a;
  private FSFeedData b;
  private IFSTabFragmentIoc c;
  
  private void d()
  {
    if (this.b == null)
    {
      QLog.e("FSLayerPageBottomPart", 1, "[openCommentInput] mFeedData == null");
      return;
    }
    FSCommentInfo localFSCommentInfo = new FSCommentInfo();
    localFSCommentInfo.a = this.b.b();
    localFSCommentInfo.d = l();
    c("comment_input_window_show", localFSCommentInfo);
    IFSTabFragmentIoc localIFSTabFragmentIoc = this.c;
    if (localIFSTabFragmentIoc != null) {
      localIFSTabFragmentIoc.a("event_open_comment_input", new Object[] { localFSCommentInfo });
    }
  }
  
  public String a()
  {
    return "FSLayerPageBottomPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((LinearLayout)paramView.findViewById(2131433341));
    this.a.setVisibility(0);
    this.a.setOnClickListener(this);
  }
  
  public void a(IFSTabFragmentIoc paramIFSTabFragmentIoc)
  {
    this.c = paramIFSTabFragmentIoc;
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if ("layer_notify_part_update_feed".equals(paramString))
    {
      if (!(paramObject instanceof FSFeedData)) {
        return;
      }
      this.b = ((FSFeedData)paramObject);
      return;
    }
    if ("layer_notify_part_hide_bottom_input_view".equals(paramString))
    {
      paramString = this.a;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131433341) {
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSLayerPageBottomPart
 * JD-Core Version:    0.7.0.1
 */