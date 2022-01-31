package com.tencent.mobileqq.filemanager.core;

import aqxi;
import aqxo;
import arit;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class FileVideoManager$1
  implements Runnable
{
  public FileVideoManager$1(arit paramarit) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arit.a() + "]StartDownload");
      QLog.i("VideoPlayControllerForFile", 1, "[" + this.jdField_a_of_type_Arit.a() + "]StartDownload");
    }
    aqxo localaqxo = aqxi.a(this.jdField_a_of_type_Arit.a());
    localaqxo.jdField_a_of_type_Arit = this.jdField_a_of_type_Arit;
    this.jdField_a_of_type_Arit.a(-1L);
    Iterator localIterator = aqxi.a(aqxi.a).keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aqxo)aqxi.a(aqxi.a).get(localObject);
      if (((aqxo)localObject).a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Arit.a() + "]is downloading continue");
        }
        return;
      }
      if (((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
        ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "]Paused!");
        }
      }
      if (((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localObject.hashCode() + "]downMgr[" + ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "]pause,start other download, stop this[" + ((aqxo)localObject).jdField_a_of_type_Int + "]");
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localObject.hashCode() + "]downMgr[" + ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "]pause，start other download, stop this[" + ((aqxo)localObject).c + "]");
        }
        if (((aqxo)localObject).jdField_a_of_type_Int > 0) {
          ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).jdField_a_of_type_Int);
        }
        if (((aqxo)localObject).c > 0) {
          ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).c);
        }
        if (((aqxo)localObject).d > 0) {
          ((aqxo)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((aqxo)localObject).d);
        }
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((aqxo)localObject).jdField_a_of_type_Arit.a() + "]##########Need pause########### bDownloading = false");
        }
        ((aqxo)localObject).b = false;
      }
    }
    localaqxo.b = true;
    localaqxo.a(this.jdField_a_of_type_Arit, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoManager.1
 * JD-Core Version:    0.7.0.1
 */