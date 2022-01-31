import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.OfflineUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public final class mps
  implements Runnable
{
  public void run()
  {
    if (!OfflineUtils.a())
    {
      QLog.d("OfflineUtils", 2, "fail to read from offline dir, fall back to assets styles");
      if (!OfflineUtils.a(BaseApplicationImpl.getContext())) {
        QLog.d("OfflineUtils", 2, "fail to load from asset folder, fall back to native styles");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mps
 * JD-Core Version:    0.7.0.1
 */