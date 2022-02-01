package cooperation.comic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class VipComicReportUtils$3
  implements IAsyncQimeiListener
{
  public void onQimeiDispatch(Qimei paramQimei)
  {
    if ((paramQimei != null) && (TextUtils.isEmpty(VipComicReportUtils.b()))) {
      VipComicReportUtils.a(paramQimei.getQimeiNew());
    }
    if (QLog.isColorLevel()) {
      QLog.i("VipComicReportUtils", 1, "getQimei onQimeiDispatch qimei:" + VipComicReportUtils.b());
    }
    BaseApplicationImpl.getContext().getSharedPreferences("fileSystemInfo_", 4).edit().putString("qimei_new", VipComicReportUtils.b()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicReportUtils.3
 * JD-Core Version:    0.7.0.1
 */