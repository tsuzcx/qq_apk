package com.tencent.mobileqq.filemanager.core;

import aqxo;
import aqxq;
import arit;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

public class FileVideoManager$VideoControl$2$2
  implements Runnable
{
  public FileVideoManager$VideoControl$2$2(aqxq paramaqxq) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoManager<FileAssistant>.FVBlock", 1, "[" + this.a.a.jdField_a_of_type_Arit.a() + "] chang thread[" + this.a.a.d + "]");
    }
    if (this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
    {
      this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(this.a.a.d);
      this.a.a.d = -1;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoManager<FileAssistant>.FVBlock", 1, "[" + this.a.a.jdField_a_of_type_Arit.a() + "] block is full stop downloadId[" + this.a.a.d + "]");
      }
      this.a.a.d = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoManager.VideoControl.2.2
 * JD-Core Version:    0.7.0.1
 */