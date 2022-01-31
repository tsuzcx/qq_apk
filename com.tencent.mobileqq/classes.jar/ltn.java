import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import java.util.List;

public class ltn
{
  private int jdField_a_of_type_Int;
  public Frame a;
  private String jdField_a_of_type_JavaLangString = "RefFrame-" + Integer.toHexString(hashCode());
  public List<lto> a;
  
  private ltn(Frame paramFrame)
  {
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = paramFrame;
  }
  
  private ltn(Frame paramFrame, List<lto> paramList)
  {
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = paramFrame;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public static ltn a(Frame paramFrame)
  {
    return new ltn(paramFrame);
  }
  
  public static ltn a(Frame paramFrame, List<lto> paramList)
  {
    return new ltn(paramFrame, paramList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ltn
 * JD-Core Version:    0.7.0.1
 */