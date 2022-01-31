import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

class tdp
  implements syt<tmc, toa>
{
  tdp(tdo paramtdo, tej paramtej, boolean paramBoolean, long paramLong) {}
  
  public void a(tmc arg1, toa paramtoa, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = paramtoa.a;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.jdField_a_of_type_Tdo.a(???);
        this.jdField_a_of_type_Tej.a = ???.qq;
        this.jdField_a_of_type_Tej.b = ???.uid;
        if (this.jdField_a_of_type_Boolean)
        {
          ??? = (tcv)tdc.a(10);
          ???.b("qqstory_my_uin", this.jdField_a_of_type_Tej.a);
          ???.b("qqstory_my_union_id", this.jdField_a_of_type_Tej.b);
        }
      }
      veg.d("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.jdField_a_of_type_Tej, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
    synchronized (this.jdField_a_of_type_Tej)
    {
      this.jdField_a_of_type_Tej.notifyAll();
      return;
      veg.d("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdp
 * JD-Core Version:    0.7.0.1
 */