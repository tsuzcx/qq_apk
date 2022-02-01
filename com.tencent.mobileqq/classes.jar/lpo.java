import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import java.util.List;

public class lpo
  implements lpc
{
  protected final AVRedPacketManager a;
  
  public lpo(VideoAppInterface paramVideoAppInterface)
  {
    this.a = ((AVRedPacketManager)paramVideoAppInterface.a(6));
  }
  
  public void a(lpa paramlpa, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramlpa == null) {}
    while ((paramlpa.jdField_a_of_type_Int <= 0) || (!this.a.c())) {
      return;
    }
    if ((paramlpa.jdField_a_of_type_JavaUtilList != null) && (paramlpa.jdField_a_of_type_JavaUtilList.size() > 0) && (paramlpa.jdField_a_of_type_ArrayOfFloat != null) && (paramlpa.jdField_a_of_type_ArrayOfFloat.length > 0)) {
      this.a.a(paramlpa.jdField_a_of_type_JavaUtilList, paramlpa.jdField_a_of_type_ArrayOfFloat);
    }
    this.a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean a()
  {
    return this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpo
 * JD-Core Version:    0.7.0.1
 */