package com.tencent.mobileqq.profilecard.bussiness.stickynote;

import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

class QzoneStickyNoteManager$1$1
  implements QZoneApiProxy.QZoneLoadCallback
{
  QzoneStickyNoteManager$1$1(QzoneStickyNoteManager.1 param1) {}
  
  public void onLoadOver(boolean paramBoolean)
  {
    if (paramBoolean) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneStickyNoteManager.1.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.stickynote.QzoneStickyNoteManager.1.1
 * JD-Core Version:    0.7.0.1
 */