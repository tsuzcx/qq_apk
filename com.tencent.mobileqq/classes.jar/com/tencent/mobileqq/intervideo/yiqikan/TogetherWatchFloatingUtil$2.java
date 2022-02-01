package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class TogetherWatchFloatingUtil$2
  implements ActionSheet.OnButtonClickListener
{
  TogetherWatchFloatingUtil$2(Intent paramIntent, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("cur_uin");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_opener", 0, 0, paramView, localStringBuilder.toString(), "", "");
    paramView = WatchFloatingWindowController.a();
    if (paramInt == 0) {
      i = 2;
    }
    paramView.a(i);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil.2
 * JD-Core Version:    0.7.0.1
 */