package com.tencent.mobileqq.listentogether.lyrics;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.OnExistListenTogetherCallback;
import com.tencent.mobileqq.statistics.ReportController;

class LyricsController$11
  implements OnExistListenTogetherCallback
{
  LyricsController$11(LyricsController paramLyricsController) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.e;
    String str = this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.b;
    this.a.b(i, str);
    ListenTogetherManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(i, str, paramBoolean);
    if ((i == 2) && (!TextUtils.isEmpty(str)))
    {
      ReportController.b(null, "dc00899", "c2c_AIO", "", "music_tab", "close_tab", 0, 0, str, "", "", "");
      return;
    }
    if ((i == 1) && (!TextUtils.isEmpty(str)))
    {
      Object localObject = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(str);
      if (localObject != null)
      {
        if (((TroopInfo)localObject).isTroopOwner(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
        {
          localObject = "0";
          break label166;
        }
        if (((TroopInfo)localObject).isAdmin())
        {
          localObject = "1";
          break label166;
        }
      }
      localObject = "2";
      label166:
      ReportController.b(null, "dc00899", "Grp_AIO", "", "music_tab", "close_tab", 0, 0, str, "", (String)localObject, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.11
 * JD-Core Version:    0.7.0.1
 */