package com.tencent.mobileqq.listentogether.predownload;

import artr;
import artt;
import axrl;
import aysx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import java.util.HashMap;

public class ListenTogetherResDownloader$2$1
  implements Runnable
{
  public ListenTogetherResDownloader$2$1(artt paramartt, aysx paramaysx, boolean paramBoolean, MusicInfo paramMusicInfo) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", String.valueOf(this.jdField_a_of_type_Aysx.b));
    localHashMap.put("result", String.valueOf(this.jdField_a_of_type_Aysx.a));
    axrl.a(BaseApplicationImpl.getContext()).a("", "listen_together_download_quality", this.jdField_a_of_type_Boolean, 0L, 0L, localHashMap, "", false);
    ((ListenTogetherManager)artr.a(this.jdField_a_of_type_Artt.a).getManager(331)).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataMusicInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1
 * JD-Core Version:    0.7.0.1
 */