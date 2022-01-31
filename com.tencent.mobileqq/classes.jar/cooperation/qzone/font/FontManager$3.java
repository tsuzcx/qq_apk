package cooperation.qzone.font;

import bjds;
import bjfi;
import bjfl;
import java.io.File;

public class FontManager$3
  implements Runnable
{
  public FontManager$3(bjfl parambjfl, int paramInt1, int paramInt2, bjfi parambjfi, String paramString1, String paramString2) {}
  
  public void run()
  {
    File localFile = new File(bjfl.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    if (localFile.exists())
    {
      if (this.jdField_a_of_type_Bjfi == null) {
        break label152;
      }
      bjfl.a().a(localFile.getAbsolutePath(), true);
      this.jdField_a_of_type_Bjfi.a(this.jdField_a_of_type_Int, localFile.getAbsolutePath(), this.jdField_a_of_type_JavaLangString);
    }
    label152:
    while ((bjfl.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bjfi)) || (this.jdField_a_of_type_Bjfi == null))
    {
      return;
      if (this.jdField_b_of_type_Int == 1)
      {
        localFile = new File(bjfl.a(this.this$0, this.jdField_a_of_type_Int, 0));
        if (localFile.exists())
        {
          String str = bjfl.a(this.this$0, this.jdField_a_of_type_Int, 1);
          if (bjfl.a(this.this$0, localFile.getAbsolutePath(), str))
          {
            this.jdField_a_of_type_Bjfi.a(this.jdField_a_of_type_Int, str, this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
      }
    }
    this.jdField_a_of_type_Bjfi.a(this.jdField_a_of_type_Int, null, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.3
 * JD-Core Version:    0.7.0.1
 */