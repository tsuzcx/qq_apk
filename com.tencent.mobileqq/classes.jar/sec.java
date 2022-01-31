import com.tencent.image.NativeGifImage;
import java.io.File;

public class sec
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private sed jdField_a_of_type_Sed;
  
  public sec(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Sed = null;
  }
  
  public void a(sed paramsed)
  {
    this.jdField_a_of_type_Sed = paramsed;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_Sed != null) {
        this.jdField_a_of_type_Sed.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sec
 * JD-Core Version:    0.7.0.1
 */