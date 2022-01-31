package com.tencent.mobileqq.musicgene;

import android.os.Message;
import android.view.View;
import aswm;
import aswo;
import aswy;
import axqy;

public class MusicPlayerActivity$1$2$1
  implements Runnable
{
  public MusicPlayerActivity$1$2$1(aswo paramaswo) {}
  
  public void run()
  {
    axqy.b(this.a.jdField_a_of_type_Aswm.a.app, "CliOper", "", "", "0X800682D", "0X800682D", 0, 0, "", "", "", "");
    aswy.a(this.a.jdField_a_of_type_Aswm.a, "http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435");
    Object localObject = this.a.jdField_a_of_type_AndroidViewView.getTag();
    if ((localObject instanceof Integer)) {}
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      Message.obtain(MusicPlayerActivity.a(this.a.jdField_a_of_type_Aswm.a), 54, 2131694479, i, this.a.jdField_a_of_type_AndroidViewView).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.2.1
 * JD-Core Version:    0.7.0.1
 */