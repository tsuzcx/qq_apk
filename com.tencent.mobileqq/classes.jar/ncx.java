import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Random;

public class ncx
  extends bcpv
{
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private nnk jdField_a_of_type_Nnk;
  
  public ncx(AVGameAppInterface paramAVGameAppInterface)
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
      this.jdField_a_of_type_Nnk = new nnk();
      super.a(this.jdField_a_of_type_Nnk);
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
    super.b(paramToServiceMsg, null, ncy.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncx
 * JD-Core Version:    0.7.0.1
 */