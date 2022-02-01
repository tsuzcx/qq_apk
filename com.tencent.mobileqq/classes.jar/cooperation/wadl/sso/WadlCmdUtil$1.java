package cooperation.wadl.sso;

import acik;
import bnyy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class WadlCmdUtil$1
  implements Runnable
{
  public WadlCmdUtil$1(bnyy parambnyy, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    long l1 = acik.a("LAST_GET_CONF_VERSION");
    if (QLog.isColorLevel()) {
      QLog.d(bnyy.a, 2, "checkConfigUpdate isForce=" + this.jdField_a_of_type_Boolean + ",newVersion=" + this.jdField_a_of_type_Long + ",currVersion=" + l1);
    }
    if ((this.jdField_a_of_type_Long > -1L) && (this.jdField_a_of_type_Long == l1) && (bnyy.a().exists())) {}
    long l2;
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        bnyy.a(this.this$0, l1);
        return;
      }
      if (bnyy.a(this.this$0) >= 3)
      {
        bnyy.a(this.this$0, System.currentTimeMillis());
        bnyy.a(this.this$0, (short)0);
        return;
      }
      if (bnyy.a(this.this$0) == -1L) {
        bnyy.a(this.this$0, acik.a("LAST_GET_CONF_TIME"));
      }
      l2 = System.currentTimeMillis();
    } while ((bnyy.a(this.this$0) + 86400000L >= l2) && (bnyy.a(this.this$0) <= l2));
    bnyy.a(this.this$0, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.wadl.sso.WadlCmdUtil.1
 * JD-Core Version:    0.7.0.1
 */