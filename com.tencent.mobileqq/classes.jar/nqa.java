import android.graphics.RectF;
import androidx.annotation.NonNull;

public class nqa
{
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  public nqa(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { paramFloat5, paramFloat5, paramFloat5, paramFloat5, paramFloat5, paramFloat5, paramFloat5, paramFloat5 };
  }
  
  @NonNull
  public String toString()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRectF != null) {
      return this.jdField_a_of_type_AndroidGraphicsRectF.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nqa
 * JD-Core Version:    0.7.0.1
 */