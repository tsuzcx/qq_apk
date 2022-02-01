package com.tencent.mobileqq.musicgene;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;

class MusicPlayerActivity$1$2$1
  implements Runnable
{
  MusicPlayerActivity$1$2$1(MusicPlayerActivity.1.2 param2) {}
  
  public void run()
  {
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1.a.app, "CliOper", "", "", "0X800682D", "0X800682D", 0, 0, "", "", "", "");
    QQMusicConst.a(this.a.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1.a, "https://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435");
    Object localObject = this.a.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof Integer)) {}
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      Message.obtain(MusicPlayerActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1.a), 54, 2131694401, i, this.a.jdField_a_of_type_AndroidViewView).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.2.1
 * JD-Core Version:    0.7.0.1
 */