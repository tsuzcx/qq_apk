import com.tencent.image.NativeGifImage;
import java.io.File;

public class rrn
  extends NativeGifImage
{
  private int jdField_a_of_type_Int = 3;
  private rro jdField_a_of_type_Rro;
  
  public rrn(File paramFile, boolean paramBoolean, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, 0.0F);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rro = null;
  }
  
  public void a(rro paramrro)
  {
    this.jdField_a_of_type_Rro = paramrro;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.jdField_a_of_type_Int)
    {
      if (this.jdField_a_of_type_Rro != null) {
        this.jdField_a_of_type_Rro.a();
      }
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrn
 * JD-Core Version:    0.7.0.1
 */