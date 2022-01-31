import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class tck
  implements Runnable
{
  public tck(Leba paramLeba) {}
  
  public void run()
  {
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.a.a.getManager(9);
    int j;
    ArrayList localArrayList;
    label40:
    int i;
    if (localQZoneManagerImp != null)
    {
      j = localQZoneManagerImp.a(1);
      if (localQZoneManagerImp == null) {
        break label132;
      }
      localArrayList = localQZoneManagerImp.a();
      if (j > 0) {
        break label207;
      }
      if (localQZoneManagerImp == null) {
        break label137;
      }
      i = localQZoneManagerImp.a(2);
      label56:
      if ((i <= 0) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break label142;
      }
      if ((!QLog.isColorLevel()) || (QLog.isColorLevel())) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
      }
      this.a.a(new tcl(this, localArrayList));
      i = 1;
    }
    for (;;)
    {
      this.a.a(new tco(this, i, j));
      return;
      j = 0;
      break;
      label132:
      localArrayList = null;
      break label40;
      label137:
      i = 0;
      break label56;
      label142:
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "updateQZoneFlag.noflag count=" + i);
      }
      this.a.a(new tcm(this));
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.ZebraAlbum.Q.lebatab.leba", 2, "freshEntryItemUI set style NOTETXT_STYLE_DEFAULT and mQzoneFeedSubIcon GONE");
      }
      i = 0;
      continue;
      label207:
      if (QLog.isColorLevel()) {
        QLog.d("UndealCount.Q.lebatab.leba", 2, "TYPE_PASSIVE_FEED freshEntryItemUI num=" + j);
      }
      i = 3;
      this.a.a(new tcn(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tck
 * JD-Core Version:    0.7.0.1
 */