import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

class sqt
  implements slx<szg, tbe>
{
  sqt(sqs paramsqs, srn paramsrn, boolean paramBoolean, long paramLong) {}
  
  public void a(szg arg1, tbe paramtbe, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = paramtbe.a;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.jdField_a_of_type_Sqs.a(???);
        this.jdField_a_of_type_Srn.a = ???.qq;
        this.jdField_a_of_type_Srn.b = ???.uid;
        if (this.jdField_a_of_type_Boolean)
        {
          ??? = (spz)sqg.a(10);
          ???.b("qqstory_my_uin", this.jdField_a_of_type_Srn.a);
          ???.b("qqstory_my_union_id", this.jdField_a_of_type_Srn.b);
        }
      }
      urk.d("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.jdField_a_of_type_Srn, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
    synchronized (this.jdField_a_of_type_Srn)
    {
      this.jdField_a_of_type_Srn.notifyAll();
      return;
      urk.d("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqt
 * JD-Core Version:    0.7.0.1
 */