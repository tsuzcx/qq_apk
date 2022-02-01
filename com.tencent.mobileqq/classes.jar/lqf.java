import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import java.util.List;

public class lqf
  implements lpr
{
  protected final AVRedPacketManager a;
  
  public lqf(VideoAppInterface paramVideoAppInterface)
  {
    this.a = ((AVRedPacketManager)paramVideoAppInterface.a(6));
  }
  
  public void a(lpp paramlpp, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramlpp == null) {}
    while ((paramlpp.jdField_a_of_type_Int <= 0) || (!this.a.c())) {
      return;
    }
    if ((paramlpp.jdField_a_of_type_JavaUtilList != null) && (paramlpp.jdField_a_of_type_JavaUtilList.size() > 0) && (paramlpp.jdField_a_of_type_ArrayOfFloat != null) && (paramlpp.jdField_a_of_type_ArrayOfFloat.length > 0)) {
      this.a.a(paramlpp.jdField_a_of_type_JavaUtilList, paramlpp.jdField_a_of_type_ArrayOfFloat);
    }
    this.a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean a()
  {
    return this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lqf
 * JD-Core Version:    0.7.0.1
 */