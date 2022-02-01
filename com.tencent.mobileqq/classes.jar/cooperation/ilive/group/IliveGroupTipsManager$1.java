package cooperation.ilive.group;

import blva;
import blvf;
import com.tencent.qphone.base.util.QLog;

public class IliveGroupTipsManager$1
  implements Runnable
{
  public IliveGroupTipsManager$1(blvf paramblvf, boolean paramBoolean, String paramString, long paramLong) {}
  
  public void run()
  {
    if (blvf.a(this.this$0) == null)
    {
      QLog.d("IliveGroupTipsManager", 1, "onGroupPushHandle isLive = " + this.jdField_a_of_type_Boolean + " exit page");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.a(this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Long), blvf.b);
      return;
    }
    blvf.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsManager.1
 * JD-Core Version:    0.7.0.1
 */