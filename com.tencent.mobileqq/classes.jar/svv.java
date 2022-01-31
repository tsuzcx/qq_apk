import com.tencent.image.NativeGifImage;
import java.io.File;

public class svv
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private svw jdField_a_of_type_Svw;
  
  public svv(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Svw = null;
  }
  
  public void a(svw paramsvw)
  {
    this.jdField_a_of_type_Svw = paramsvw;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_Svw != null) {
        this.jdField_a_of_type_Svw.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svv
 * JD-Core Version:    0.7.0.1
 */