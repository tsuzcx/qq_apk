package com.tencent.mobileqq.filemanager.core;

import apab;
import apah;
import apll;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class FileVideoManager$1
  implements Runnable
{
  public FileVideoManager$1(apll paramapll) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Apll.a() + "]StartDownload");
      QLog.i("VideoPlayControllerForFile", 1, "[" + this.jdField_a_of_type_Apll.a() + "]StartDownload");
    }
    apah localapah = apab.a(this.jdField_a_of_type_Apll.a());
    localapah.jdField_a_of_type_Apll = this.jdField_a_of_type_Apll;
    this.jdField_a_of_type_Apll.a(-1L);
    Iterator localIterator = apab.a(apab.a).keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (apah)apab.a(apab.a).get(localObject);
      if (((apah)localObject).a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Apll.a() + "]is downloading continue");
        }
        return;
      }
      if (((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
        ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((apah)localObject).jdField_a_of_type_Apll.a() + "]Paused!");
        }
      }
      if (((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localObject.hashCode() + "]downMgr[" + ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + ((apah)localObject).jdField_a_of_type_Apll.a() + "]pause,start other download, stop this[" + ((apah)localObject).jdField_a_of_type_Int + "]");
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localObject.hashCode() + "]downMgr[" + ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + ((apah)localObject).jdField_a_of_type_Apll.a() + "]pause，start other download, stop this[" + ((apah)localObject).c + "]");
        }
        if (((apah)localObject).jdField_a_of_type_Int > 0) {
          ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apah)localObject).jdField_a_of_type_Int);
        }
        if (((apah)localObject).c > 0) {
          ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apah)localObject).c);
        }
        if (((apah)localObject).d > 0) {
          ((apah)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apah)localObject).d);
        }
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((apah)localObject).jdField_a_of_type_Apll.a() + "]##########Need pause########### bDownloading = false");
        }
        ((apah)localObject).b = false;
      }
    }
    localapah.b = true;
    localapah.a(this.jdField_a_of_type_Apll, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoManager.1
 * JD-Core Version:    0.7.0.1
 */