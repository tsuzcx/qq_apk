package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import audj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;

public class LocalTbsViewManager$4
  implements Runnable
{
  public LocalTbsViewManager$4(audj paramaudj, ITbsReaderCallback paramITbsReaderCallback) {}
  
  public void run()
  {
    ReaderEngine.getInstance().initReaderEntryAsync(BaseApplicationImpl.getApplication(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.4
 * JD-Core Version:    0.7.0.1
 */