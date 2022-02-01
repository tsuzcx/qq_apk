package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;

class VideoFeedsDebugDialog$4
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    boolean bool = ReadInJoyHelper.b();
    Aladdin.getConfig(260).update(VideoFeedsDebugDialog.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsDebugDialog, bool ^ true));
    Button localButton = (Button)paramView;
    String str;
    if (!bool) {
      str = "关Titkok(需退出一拖三)";
    } else {
      str = "开Tittok(需退出一拖三)";
    }
    localButton.setText(str);
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsDebugDialog.4
 * JD-Core Version:    0.7.0.1
 */