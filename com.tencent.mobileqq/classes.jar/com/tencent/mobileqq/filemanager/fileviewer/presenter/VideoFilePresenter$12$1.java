package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import arnb;
import arnf;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.util.HashMap;
import java.util.Map;

public class VideoFilePresenter$12$1
  implements Runnable
{
  public VideoFilePresenter$12$1(arnf paramarnf, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Arnf.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    this.jdField_a_of_type_Arnf.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    arnb.a(this.jdField_a_of_type_Arnf.a, this.jdField_a_of_type_JavaLangString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_video_file");
    this.jdField_a_of_type_Arnf.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    this.jdField_a_of_type_Arnf.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_Arnf.a.jdField_a_of_type_AndroidAppActivity, arnb.a(this.jdField_a_of_type_Arnf.a), 0L, 0L, this.jdField_a_of_type_Arnf.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.12.1
 * JD-Core Version:    0.7.0.1
 */