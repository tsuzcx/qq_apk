import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import java.util.List;

public class lqa
  implements lpm
{
  protected final AVRedPacketManager a;
  
  public lqa(VideoAppInterface paramVideoAppInterface)
  {
    this.a = ((AVRedPacketManager)paramVideoAppInterface.a(6));
  }
  
  public void a(lpk paramlpk, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramlpk == null) {}
    while ((paramlpk.jdField_a_of_type_Int <= 0) || (!this.a.c())) {
      return;
    }
    if ((paramlpk.jdField_a_of_type_JavaUtilList != null) && (paramlpk.jdField_a_of_type_JavaUtilList.size() > 0) && (paramlpk.jdField_a_of_type_ArrayOfFloat != null) && (paramlpk.jdField_a_of_type_ArrayOfFloat.length > 0)) {
      this.a.a(paramlpk.jdField_a_of_type_JavaUtilList, paramlpk.jdField_a_of_type_ArrayOfFloat);
    }
    this.a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean a()
  {
    return this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lqa
 * JD-Core Version:    0.7.0.1
 */