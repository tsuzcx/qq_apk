package com.tencent.mobileqq.musicgene;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class MusicPlayerActivity$1$1
  implements AdapterView.OnItemClickListener
{
  MusicPlayerActivity$1$1(MusicPlayerActivity.1 param1, MusicPlayerActivity.ShareInfo paramShareInfo) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      MusicPlayerActivity.1.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1).dismiss();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1.a, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.a, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.b, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.d, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.c, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.e);
      continue;
      MusicPlayerActivity.b(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1.a, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.a, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.b, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.d, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.c, this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.e);
      continue;
      ThreadManager.post(new MusicPlayerActivity.1.1.1(this, paramInt), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.1
 * JD-Core Version:    0.7.0.1
 */