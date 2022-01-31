import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class oxg
  extends ampn
{
  oxg(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    oxf.a(false);
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "onLocationFinish errCode = ", Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      syb.a(100, new ArrayList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oxg
 * JD-Core Version:    0.7.0.1
 */