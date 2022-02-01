import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.List;

public class lqt
{
  private int jdField_a_of_type_Int;
  public Frame a;
  private String jdField_a_of_type_JavaLangString = "RefFrame-" + Integer.toHexString(hashCode());
  public List<lqu> a;
  
  private lqt(Frame paramFrame)
  {
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = paramFrame;
  }
  
  private lqt(Frame paramFrame, List<lqu> paramList)
  {
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = paramFrame;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public static lqt a(Frame paramFrame)
  {
    return new lqt(paramFrame);
  }
  
  public static lqt a(Frame paramFrame, List<lqu> paramList)
  {
    return new lqt(paramFrame, paramList);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.unlock();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      b();
      return;
    }
    b(1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int += paramInt;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  void b(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      Log.e(this.jdField_a_of_type_JavaLangString, "unlock: count=" + paramInt + ", ref=" + this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      this.jdField_a_of_type_Int -= paramInt;
    } while (this.jdField_a_of_type_Int != 0);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lqt
 * JD-Core Version:    0.7.0.1
 */