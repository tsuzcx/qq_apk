package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.winkpublish.event.PublishMediaDeleteEvent;
import java.util.List;

class QCircleVideoPreviewPart$2
  implements DialogInterface.OnClickListener
{
  QCircleVideoPreviewPart$2(QCircleVideoPreviewPart paramQCircleVideoPreviewPart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SimpleEventBus.getInstance().dispatchEvent(new PublishMediaDeleteEvent(0));
    if (QCircleVideoPreviewPart.a(this.a).size() > 0) {
      QCircleVideoPreviewPart.a(this.a).remove(0);
    }
    if (QCircleVideoPreviewPart.a(this.a).size() == 0) {
      this.a.c().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.QCircleVideoPreviewPart.2
 * JD-Core Version:    0.7.0.1
 */