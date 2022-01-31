import android.graphics.Bitmap;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.util.BitmapManager;
import java.io.File;

public final class m
  implements Runnable
{
  public m(String paramString, bt parambt) {}
  
  public void run()
  {
    if (ChatBackgroundManager.a(new File(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Bt.a(null, true);
    }
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = BitmapManager.a(this.jdField_a_of_type_JavaLangString);
    } while (this.jdField_a_of_type_Bt == null);
    this.jdField_a_of_type_Bt.a(localBitmap, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     m
 * JD-Core Version:    0.7.0.1
 */