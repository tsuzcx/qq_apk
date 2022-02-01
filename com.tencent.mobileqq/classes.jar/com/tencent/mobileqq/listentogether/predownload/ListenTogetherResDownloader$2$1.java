package com.tencent.mobileqq.listentogether.predownload;

import avvw;
import avvy;
import bctj;
import bdwt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import java.util.HashMap;

public class ListenTogetherResDownloader$2$1
  implements Runnable
{
  public ListenTogetherResDownloader$2$1(avvy paramavvy, bdwt parambdwt, boolean paramBoolean, MusicInfo paramMusicInfo) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", String.valueOf(this.jdField_a_of_type_Bdwt.b));
    localHashMap.put("result", String.valueOf(this.jdField_a_of_type_Bdwt.a));
    bctj.a(BaseApplicationImpl.getContext()).a("", "listen_together_download_quality", this.jdField_a_of_type_Boolean, 0L, 0L, localHashMap, "", false);
    ((ListenTogetherManager)avvw.a(this.jdField_a_of_type_Avvy.a).getManager(331)).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataMusicInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1
 * JD-Core Version:    0.7.0.1
 */