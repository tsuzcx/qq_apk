import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneLogTags;
import java.util.ArrayList;

public class sur
  implements Runnable
{
  public sur(Leba paramLeba) {}
  
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
        break label151;
      }
      localArrayList = localQZoneManagerImp.a();
      if (j > 0) {
        break label270;
      }
      if (localQZoneManagerImp == null) {
        break label156;
      }
      i = localQZoneManagerImp.a(2);
      label56:
      if ((i <= 0) || (localArrayList == null) || (localArrayList.size() <= 0)) {
        break label161;
      }
      if ((!QLog.isColorLevel()) || (QLog.isColorLevel())) {
        QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + "Q.lebatab.leba", 2, "TYPE_ACTIVE_FEED updateQZoneFlag.mQzoneFeedSubIcon setImageDrawable");
      }
      this.a.a(new sus(this, localArrayList));
      i = 1;
    }
    for (;;)
    {
      this.a.a(new suv(this, i, j));
      return;
      j = 0;
      break;
      label151:
      localArrayList = null;
      break label40;
      label156:
      i = 0;
      break label56;
      label161:
      if (QLog.isColorLevel()) {
        QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + "Q.lebatab.leba", 2, "updateQZoneFlag.noflag count=" + i);
      }
      this.a.a(new sut(this));
      if (QLog.isColorLevel()) {
        QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + QZoneLogTags.LOG_TAG_ZEBRAALBUM + "Q.lebatab.leba", 2, "freshEntryItemUI set style NOTETXT_STYLE_DEFAULT and mQzoneFeedSubIcon GONE");
      }
      i = 0;
      continue;
      label270:
      if (QLog.isColorLevel()) {
        QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + "Q.lebatab.leba", 2, "TYPE_PASSIVE_FEED freshEntryItemUI num=" + j);
      }
      i = 3;
      this.a.a(new suu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sur
 * JD-Core Version:    0.7.0.1
 */