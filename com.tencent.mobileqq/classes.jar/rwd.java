import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.3;
import com.tencent.qphone.base.util.QLog;

public class rwd
  implements mzb
{
  public rwd(ViolaAccessHelper.3 param3) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "downOffline  code " + paramInt + "  param " + paramString);
    }
    if (paramInt == 0) {
      if (paramString == null) {
        if (this.a.jdField_a_of_type_Rwh != null) {
          this.a.jdField_a_of_type_Rwh.a();
        }
      }
    }
    while (this.a.jdField_a_of_type_Rwh == null)
    {
      return;
      if (paramString.contains("url"))
      {
        QLog.d("ViolaAccessHelper", 2, new Object[] { "checkUpByBusinessId load success. contains url. cost=", Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) });
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.a.jdField_a_of_type_Long;
      if (this.a.jdField_a_of_type_Rwh != null) {
        this.a.jdField_a_of_type_Rwh.a();
      }
      QLog.d("ViolaAccessHelper", 2, new Object[] { "checkUpByBusinessId load success. no update. cost=", Long.valueOf(l1 - l2) });
      return;
    }
    this.a.jdField_a_of_type_Rwh.b();
  }
  
  public void progress(int paramInt)
  {
    if (this.a.jdField_a_of_type_Rwh != null) {
      this.a.jdField_a_of_type_Rwh.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rwd
 * JD-Core Version:    0.7.0.1
 */