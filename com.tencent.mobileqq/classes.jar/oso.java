import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class oso
  extends akui
{
  oso(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    osn.a(false);
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "onLocationFinish errCode = ", Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      sgg.a(100, new ArrayList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oso
 * JD-Core Version:    0.7.0.1
 */