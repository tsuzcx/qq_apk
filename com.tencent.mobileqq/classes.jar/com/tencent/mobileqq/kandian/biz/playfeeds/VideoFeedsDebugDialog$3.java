package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;

class VideoFeedsDebugDialog$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    boolean bool = ReadInJoyHelper.j(ReadInJoyUtils.a());
    ReadInJoyHelper.i(ReadInJoyUtils.a(), bool ^ true);
    Button localButton = (Button)paramView;
    String str;
    if (!bool) {
      str = "关闭debug信息";
    } else {
      str = "开启debug信息";
    }
    localButton.setText(str);
    this.a.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsDebugDialog.3
 * JD-Core Version:    0.7.0.1
 */