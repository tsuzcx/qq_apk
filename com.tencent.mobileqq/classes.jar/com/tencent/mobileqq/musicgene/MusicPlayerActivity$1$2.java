package com.tencent.mobileqq.musicgene;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.AppRuntime;

class MusicPlayerActivity$1$2
  implements ActionSheet.OnButtonClickListener
{
  MusicPlayerActivity$1$2(MusicPlayerActivity.1 param1, View paramView, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (!((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).isExistedDownloadOfUrl("https://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435")) {
        ThreadManager.post(new MusicPlayerActivity.1.2.1(this), 5, null, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.2
 * JD-Core Version:    0.7.0.1
 */