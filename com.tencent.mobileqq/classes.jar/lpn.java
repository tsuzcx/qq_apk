import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import java.util.List;

public class lpn
  implements loz
{
  protected final AVRedPacketManager a;
  
  public lpn(VideoAppInterface paramVideoAppInterface)
  {
    this.a = ((AVRedPacketManager)paramVideoAppInterface.a(6));
  }
  
  public void a(lox paramlox, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramlox == null) {}
    while ((paramlox.jdField_a_of_type_Int <= 0) || (!this.a.c())) {
      return;
    }
    if ((paramlox.jdField_a_of_type_JavaUtilList != null) && (paramlox.jdField_a_of_type_JavaUtilList.size() > 0) && (paramlox.jdField_a_of_type_ArrayOfFloat != null) && (paramlox.jdField_a_of_type_ArrayOfFloat.length > 0)) {
      this.a.a(paramlox.jdField_a_of_type_JavaUtilList, paramlox.jdField_a_of_type_ArrayOfFloat);
    }
    this.a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean a()
  {
    return this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpn
 * JD-Core Version:    0.7.0.1
 */