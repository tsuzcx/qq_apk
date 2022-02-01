package cooperation.wadl.sso;

import abet;
import blec;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class WadlCmdUtil$1
  implements Runnable
{
  public WadlCmdUtil$1(blec paramblec, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    long l1 = abet.a("LAST_GET_CONF_VERSION");
    if (QLog.isColorLevel()) {
      QLog.d(blec.a, 2, "checkConfigUpdate isForce=" + this.jdField_a_of_type_Boolean + ",newVersion=" + this.jdField_a_of_type_Long + ",currVersion=" + l1);
    }
    if ((this.jdField_a_of_type_Long > -1L) && (this.jdField_a_of_type_Long == l1) && (blec.a().exists())) {}
    long l2;
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        blec.a(this.this$0, l1);
        return;
      }
      if (blec.a(this.this$0) >= 3)
      {
        blec.a(this.this$0, System.currentTimeMillis());
        blec.a(this.this$0, (short)0);
        return;
      }
      if (blec.a(this.this$0) == -1L) {
        blec.a(this.this$0, abet.a("LAST_GET_CONF_TIME"));
      }
      l2 = System.currentTimeMillis();
    } while ((blec.a(this.this$0) + 86400000L >= l2) && (blec.a(this.this$0) <= l2));
    blec.a(this.this$0, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.wadl.sso.WadlCmdUtil.1
 * JD-Core Version:    0.7.0.1
 */