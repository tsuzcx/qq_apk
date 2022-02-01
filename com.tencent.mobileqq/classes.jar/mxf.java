import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Random;

public class mxf
  extends bbjd
{
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private ngs jdField_a_of_type_Ngs;
  
  public mxf(AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    jdField_a_of_type_Int = Math.abs(new Random().nextInt());
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      this.jdField_a_of_type_Ngs = new ngs();
      super.a(this.jdField_a_of_type_Ngs);
      super.d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    super.b(paramToServiceMsg, null, mxg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxf
 * JD-Core Version:    0.7.0.1
 */