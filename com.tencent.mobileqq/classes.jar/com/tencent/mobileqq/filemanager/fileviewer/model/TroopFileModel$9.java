package com.tencent.mobileqq.filemanager.fileviewer.model;

import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;

class TroopFileModel$9
  implements Runnable
{
  TroopFileModel$9(TroopFileModel paramTroopFileModel, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if ((this.a != null) && ((this.a instanceof MessageForTroopFile))) {
      this.this$0.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.9
 * JD-Core Version:    0.7.0.1
 */