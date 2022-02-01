package dov.com.qq.im.ae.album.logic;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.exporter.MovieExporter;

class AEPhotoListLogicAECircle$4
  implements View.OnClickListener
{
  AEPhotoListLogicAECircle$4(AEPhotoListLogicAECircle paramAEPhotoListLogicAECircle) {}
  
  public void onClick(View paramView)
  {
    if (AEPhotoListLogicAECircle.a(this.a) != null)
    {
      if (AEPhotoListLogicAECircle.a(this.a) != null) {
        AEPhotoListLogicAECircle.a(this.a).cancelCompress();
      }
      AEPhotoListLogicAECircle.a(this.a).dismiss();
      AEPhotoListLogicAECircle.a(this.a, null);
      AEPhotoListLogicAECircle.a(this.a, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicAECircle.4
 * JD-Core Version:    0.7.0.1
 */