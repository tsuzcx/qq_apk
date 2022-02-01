package cooperation.qzone.birthdaynotice;

import GIFT_MALL_PROTOCOL.DouFuInfo;
import GIFT_MALL_PROTOCOL.doufu_piece_rsp;
import android.os.Bundle;
import ayrb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class BirthDayNoticeManager$BirthDayNoticeObserver
  extends ayrb
{
  public WeakReference<QQAppInterface> mAppRef;
  
  public void onGetBirthDayNoticeData(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.mAppRef == null) {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneObserver", 2, "onGetBirthDayNoticeData appRef==null");
      }
    }
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.mAppRef.get();
      if (localQQAppInterface != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("UndealCount.QZoneObserver", 2, "onGetBirthDayNoticeData app == null ");
    return;
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof doufu_piece_rsp)))
    {
      paramBundle = ((doufu_piece_rsp)paramBundle).doufu.iterator();
      while (paramBundle.hasNext()) {
        BirthDayNoticeManager.access$000(localQQAppInterface, (DouFuInfo)paramBundle.next());
      }
    }
    localQQAppInterface.unRegistObserver(BirthDayNoticeManager.access$100());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.birthdaynotice.BirthDayNoticeManager.BirthDayNoticeObserver
 * JD-Core Version:    0.7.0.1
 */