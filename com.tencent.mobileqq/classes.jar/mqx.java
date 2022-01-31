import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.OfflineUtils;
import com.tencent.qphone.base.util.QLog;

public final class mqx
  implements AsyncBack
{
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      QLog.d("OfflineUtils", 2, "loaded:CODE_SUCCESS bid : " + OfflineUtils.a());
      OfflineUtils.a(true);
      OfflineUtils.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqx
 * JD-Core Version:    0.7.0.1
 */