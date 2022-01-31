import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

final class opo
  extends ampt
{
  opo(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    opn.a(false);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (QLog.isColorLevel())) {
      QLog.d("GalleryReportedUtils", 2, "get Location: info = " + paramSosoLbsInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     opo
 * JD-Core Version:    0.7.0.1
 */