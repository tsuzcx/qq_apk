import com.tencent.image.NativeGifImage;
import java.io.File;

public class sef
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private seg jdField_a_of_type_Seg;
  
  public sef(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Seg = null;
  }
  
  public void a(seg paramseg)
  {
    this.jdField_a_of_type_Seg = paramseg;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_Seg != null) {
        this.jdField_a_of_type_Seg.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sef
 * JD-Core Version:    0.7.0.1
 */