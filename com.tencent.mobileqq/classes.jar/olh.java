import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

final class olh
  extends akup
{
  olh(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    olg.a(false);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (QLog.isColorLevel())) {
      QLog.d("GalleryReportedUtils", 2, "get Location: info = " + paramSosoLbsInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     olh
 * JD-Core Version:    0.7.0.1
 */