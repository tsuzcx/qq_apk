package com.tencent.mobileqq.listentogether.predownload;

import atox;
import atoz;
import azri;
import bavf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import java.util.HashMap;

public class ListenTogetherResDownloader$2$1
  implements Runnable
{
  public ListenTogetherResDownloader$2$1(atoz paramatoz, bavf parambavf, boolean paramBoolean, MusicInfo paramMusicInfo) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", String.valueOf(this.jdField_a_of_type_Bavf.b));
    localHashMap.put("result", String.valueOf(this.jdField_a_of_type_Bavf.a));
    azri.a(BaseApplicationImpl.getContext()).a("", "listen_together_download_quality", this.jdField_a_of_type_Boolean, 0L, 0L, localHashMap, "", false);
    ((ListenTogetherManager)atox.a(this.jdField_a_of_type_Atoz.a).getManager(331)).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataMusicInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1
 * JD-Core Version:    0.7.0.1
 */