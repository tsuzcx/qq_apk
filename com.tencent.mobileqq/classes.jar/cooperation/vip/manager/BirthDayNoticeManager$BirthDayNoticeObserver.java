package cooperation.vip.manager;

import GIFT_MALL_PROTOCOL.DouFuInfo;
import GIFT_MALL_PROTOCOL.doufu_piece_rsp;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class BirthDayNoticeManager$BirthDayNoticeObserver
  extends QZoneObserver
{
  public WeakReference<QQAppInterface> a;
  
  protected void j(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneObserver", 2, "onGetBirthDayNoticeData appRef==null");
      }
      return;
    }
    localObject = (QQAppInterface)((WeakReference)localObject).get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneObserver", 2, "onGetBirthDayNoticeData app == null ");
      }
      return;
    }
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof doufu_piece_rsp)))
    {
      paramBundle = ((doufu_piece_rsp)paramBundle).doufu.iterator();
      while (paramBundle.hasNext()) {
        BirthDayNoticeManager.a((QQAppInterface)localObject, (DouFuInfo)paramBundle.next());
      }
    }
    ((QQAppInterface)localObject).unRegistObserver(BirthDayNoticeManager.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.BirthDayNoticeManager.BirthDayNoticeObserver
 * JD-Core Version:    0.7.0.1
 */