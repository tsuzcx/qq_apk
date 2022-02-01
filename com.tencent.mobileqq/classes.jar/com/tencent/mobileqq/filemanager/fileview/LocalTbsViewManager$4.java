package com.tencent.mobileqq.filemanager.fileview;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;

class LocalTbsViewManager$4
  implements Runnable
{
  LocalTbsViewManager$4(LocalTbsViewManager paramLocalTbsViewManager, ITbsReaderCallback paramITbsReaderCallback) {}
  
  public void run()
  {
    ReaderEngine.getInstance().initReaderEntryAsync(BaseApplication.getContext(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.4
 * JD-Core Version:    0.7.0.1
 */