package com.tencent.mobileqq.filemanager.core;

import aozx;
import apad;
import aplh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class FileVideoManager$1
  implements Runnable
{
  public FileVideoManager$1(aplh paramaplh) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aplh.a() + "]StartDownload");
      QLog.i("VideoPlayControllerForFile", 1, "[" + this.jdField_a_of_type_Aplh.a() + "]StartDownload");
    }
    apad localapad = aozx.a(this.jdField_a_of_type_Aplh.a());
    localapad.jdField_a_of_type_Aplh = this.jdField_a_of_type_Aplh;
    this.jdField_a_of_type_Aplh.a(-1L);
    Iterator localIterator = aozx.a(aozx.a).keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (apad)aozx.a(aozx.a).get(localObject);
      if (((apad)localObject).a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + this.jdField_a_of_type_Aplh.a() + "]is downloading continue");
        }
        return;
      }
      if (((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
        ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((apad)localObject).jdField_a_of_type_Aplh.a() + "]Paused!");
        }
      }
      if (((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localObject.hashCode() + "]downMgr[" + ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + ((apad)localObject).jdField_a_of_type_Aplh.a() + "]pause,start other download, stop this[" + ((apad)localObject).jdField_a_of_type_Int + "]");
          QLog.i("FileVideoManager<FileAssistant>", 4, "[" + localObject.hashCode() + "]downMgr[" + ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.hashCode() + "][" + ((apad)localObject).jdField_a_of_type_Aplh.a() + "]pause，start other download, stop this[" + ((apad)localObject).c + "]");
        }
        if (((apad)localObject).jdField_a_of_type_Int > 0) {
          ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apad)localObject).jdField_a_of_type_Int);
        }
        if (((apad)localObject).c > 0) {
          ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apad)localObject).c);
        }
        if (((apad)localObject).d > 0) {
          ((apad)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((apad)localObject).d);
        }
        if (QLog.isColorLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((apad)localObject).jdField_a_of_type_Aplh.a() + "]##########Need pause########### bDownloading = false");
        }
        ((apad)localObject).b = false;
      }
    }
    localapad.b = true;
    localapad.a(this.jdField_a_of_type_Aplh, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoManager.1
 * JD-Core Version:    0.7.0.1
 */