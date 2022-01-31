import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import java.util.List;

class tdm
  implements syq<tlz, tnx>
{
  tdm(tdl paramtdl, teg paramteg, boolean paramBoolean, long paramLong) {}
  
  public void a(tlz arg1, tnx paramtnx, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = paramtnx.a;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.jdField_a_of_type_Tdl.a(???);
        this.jdField_a_of_type_Teg.a = ???.qq;
        this.jdField_a_of_type_Teg.b = ???.uid;
        if (this.jdField_a_of_type_Boolean)
        {
          ??? = (tcs)tcz.a(10);
          ???.b("qqstory_my_uin", this.jdField_a_of_type_Teg.a);
          ???.b("qqstory_my_union_id", this.jdField_a_of_type_Teg.b);
        }
      }
      ved.d("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.jdField_a_of_type_Teg, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
    synchronized (this.jdField_a_of_type_Teg)
    {
      this.jdField_a_of_type_Teg.notifyAll();
      return;
      ved.d("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.jdField_a_of_type_Long) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdm
 * JD-Core Version:    0.7.0.1
 */