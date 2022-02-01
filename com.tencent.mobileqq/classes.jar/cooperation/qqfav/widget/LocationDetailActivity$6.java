package cooperation.qqfav.widget;

import android.os.Bundle;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class LocationDetailActivity$6
  extends OnColorNoteCurdListener
{
  LocationDetailActivity$6(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    QLog.e("PoiMapActivity", 1, "[ColorNote exit]");
    if (this.a.aw)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A991", "0X800A991", 4, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A990", "0X800A990", 4, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity.6
 * JD-Core Version:    0.7.0.1
 */