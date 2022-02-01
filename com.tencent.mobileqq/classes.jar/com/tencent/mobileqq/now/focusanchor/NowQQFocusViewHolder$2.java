package com.tencent.mobileqq.now.focusanchor;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.now.focusanchor.commonwidget.RecyclerItemClickListener.OnItemClickListener;
import com.tencent.mobileqq.now.focusanchor.focusdata.FocusLiveStreamDataManager;
import com.tencent.mobileqq.now.focusanchor.focusdata.NowQQLiveAnchorInfo;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.now.utils.NowRoomUtil;
import java.util.List;

class NowQQFocusViewHolder$2
  implements RecyclerItemClickListener.OnItemClickListener
{
  NowQQFocusViewHolder$2(NowQQFocusViewHolder paramNowQQFocusViewHolder, Activity paramActivity) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = (NowQQLiveAnchorInfo)FocusLiveStreamDataManager.a().c().get(paramInt);
    NowRoomUtil.a(this.a, paramView.c(), paramView.b(), 60010);
    NowQQLiveDataReport.a(String.valueOf(paramView.a()), paramInt);
  }
  
  public void b(View paramView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.NowQQFocusViewHolder.2
 * JD-Core Version:    0.7.0.1
 */