import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneLogTags;

public class sug
  extends QZoneObserver
{
  public sug(Leba paramLeba) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + "Q.lebatab.leba", 2, "on Get QZone Count:" + paramBoolean1 + ",HasNew:" + paramBoolean2);
    }
    if (QLog.isColorLevel())
    {
      if ((paramLong >>> 17 & 1L) != 0L) {
        QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT + QZoneLogTags.LOG_TAG_ZEBRAALBUM, 2, "Leba onGetQZoneFeedCountFin Zebra album and then call Leba freshEntryItemUI");
      }
      QLog.d(QZoneLogTags.LOG_TAG_UNDEALCOUNT, 2, "Leba onGetQZoneFeedCountFin type: " + paramLong + " and then call Leba freshEntryItemUI");
    }
    if (paramBoolean1)
    {
      Leba.c(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "onGetQZoneFeedCountFin. notifyData.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sug
 * JD-Core Version:    0.7.0.1
 */