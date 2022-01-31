package cooperation.qzone.font;

import bfti;
import bfux;
import bfva;
import java.io.File;

public class FontManager$3
  implements Runnable
{
  public FontManager$3(bfva parambfva, int paramInt1, int paramInt2, bfux parambfux, String paramString1, String paramString2) {}
  
  public void run()
  {
    File localFile = new File(bfva.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    if (localFile.exists())
    {
      if (this.jdField_a_of_type_Bfux == null) {
        break label152;
      }
      bfva.a().a(localFile.getAbsolutePath(), true);
      this.jdField_a_of_type_Bfux.a(this.jdField_a_of_type_Int, localFile.getAbsolutePath(), this.jdField_a_of_type_JavaLangString);
    }
    label152:
    while ((bfva.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bfux)) || (this.jdField_a_of_type_Bfux == null))
    {
      return;
      if (this.jdField_b_of_type_Int == 1)
      {
        localFile = new File(bfva.a(this.this$0, this.jdField_a_of_type_Int, 0));
        if (localFile.exists())
        {
          String str = bfva.a(this.this$0, this.jdField_a_of_type_Int, 1);
          if (bfva.a(this.this$0, localFile.getAbsolutePath(), str))
          {
            this.jdField_a_of_type_Bfux.a(this.jdField_a_of_type_Int, str, this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
      }
    }
    this.jdField_a_of_type_Bfux.a(this.jdField_a_of_type_Int, null, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.3
 * JD-Core Version:    0.7.0.1
 */