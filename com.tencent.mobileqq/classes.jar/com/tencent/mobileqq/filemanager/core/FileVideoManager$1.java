package com.tencent.mobileqq.filemanager.core;

import aqsz;
import aqtf;
import arek;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class FileVideoManager$1
  implements Runnable
{
  public FileVideoManager$1(arek paramarek) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arek.a() + "]StartDownload");
      QLog.i("VideoPlayControllerForFile", 1, "[" + this.jdField_a_of_type_Arek.a() + "]StartDownload");
    }
    aqtf localaqtf = aqsz.a(this.jdField_a_of_type_Arek.a());
    localaqtf.jdField_a_of_type_Arek = this.jdField_a_of_type_Arek;
    this.jdField_a_of_type_Arek.a(-1L);
    Iterator localIterator = aqsz.a(aqsz.a).keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aqtf)aqsz.a(aqsz.a).get(localObject);
      if (((aqtf)localObject).a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arek.a() + "]is downloading continue");
        }
        return;
      }
      if (((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
        ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "]Paused!");
        }
      }
      if (((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localObject.hashCode() + "]downMgr[" + ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "]pause,start other download, stop this[" + ((aqtf)localObject).jdField_a_of_type_Int + "]");
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localObject.hashCode() + "]downMgr[" + ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "]pause，start other download, stop this[" + ((aqtf)localObject).c + "]");
        }
        if (((aqtf)localObject).jdField_a_of_type_Int > 0) {
          ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).jdField_a_of_type_Int);
        }
        if (((aqtf)localObject).c > 0) {
          ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).c);
        }
        if (((aqtf)localObject).d > 0) {
          ((aqtf)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqtf)localObject).d);
        }
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqtf)localObject).jdField_a_of_type_Arek.a() + "]##########Need pause########### bDownloading = false");
        }
        ((aqtf)localObject).b = false;
      }
    }
    localaqtf.b = true;
    localaqtf.a(this.jdField_a_of_type_Arek, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoManager.1
 * JD-Core Version:    0.7.0.1
 */