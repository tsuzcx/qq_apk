package com.tencent.mobileqq.filemanager.core;

import aojd;
import aojj;
import aotv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class FileVideoManager$1
  implements Runnable
{
  public FileVideoManager$1(aotv paramaotv) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aotv.a() + "]StartDownload");
      QLog.i("VideoPlayControllerForFile", 1, "[" + this.jdField_a_of_type_Aotv.a() + "]StartDownload");
    }
    aojj localaojj = aojd.a(this.jdField_a_of_type_Aotv.a());
    localaojj.jdField_a_of_type_Aotv = this.jdField_a_of_type_Aotv;
    this.jdField_a_of_type_Aotv.a(-1L);
    Iterator localIterator = aojd.a(aojd.a).keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aojj)aojd.a(aojd.a).get(localObject);
      if (((aojj)localObject).a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aotv.a() + "]is downloading continue");
        }
        return;
      }
      if (((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
        ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aojj)localObject).jdField_a_of_type_Aotv.a() + "]Paused!");
        }
      }
      if (((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localObject.hashCode() + "]downMgr[" + ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + ((aojj)localObject).jdField_a_of_type_Aotv.a() + "]pause,start other download, stop this[" + ((aojj)localObject).jdField_a_of_type_Int + "]");
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localObject.hashCode() + "]downMgr[" + ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + ((aojj)localObject).jdField_a_of_type_Aotv.a() + "]pause，start other download, stop this[" + ((aojj)localObject).c + "]");
        }
        if (((aojj)localObject).jdField_a_of_type_Int > 0) {
          ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aojj)localObject).jdField_a_of_type_Int);
        }
        if (((aojj)localObject).c > 0) {
          ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aojj)localObject).c);
        }
        if (((aojj)localObject).d > 0) {
          ((aojj)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aojj)localObject).d);
        }
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aojj)localObject).jdField_a_of_type_Aotv.a() + "]##########Need pause########### bDownloading = false");
        }
        ((aojj)localObject).b = false;
      }
    }
    localaojj.b = true;
    localaojj.a(this.jdField_a_of_type_Aotv, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoManager.1
 * JD-Core Version:    0.7.0.1
 */