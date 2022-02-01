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
    String str3 = this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.b;
    this.a.b(i, str3);
    ListenTogetherManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(i, str3, paramBoolean);
    if ((i == 2) && (!TextUtils.isEmpty(str3))) {
      ReportController.b(null, "dc00899", "c2c_AIO", "", "music_tab", "close_tab", 0, 0, str3, "", "", "");
    }
    while ((i != 1) || (TextUtils.isEmpty(str3))) {
      return;
    }
    String str2 = "2";
    TroopInfo localTroopInfo = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(str3);
    String str1 = str2;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
        break label181;
      }
      str1 = "0";
    }
    for (;;)
    {
      ReportController.b(null, "dc00899", "Grp_AIO", "", "music_tab", "close_tab", 0, 0, str3, "", str1, "");
      return;
      label181:
      str1 = str2;
      if (localTroopInfo.isAdmin()) {
        str1 = "1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.11
 * JD-Core Version:    0.7.0.1
 */