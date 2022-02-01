package cooperation.qzone.font;

import bmxj;
import bmyz;
import bmzc;
import java.io.File;

public class FontManager$3
  implements Runnable
{
  public FontManager$3(bmzc parambmzc, int paramInt1, int paramInt2, bmyz parambmyz, String paramString1, String paramString2) {}
  
  public void run()
  {
    File localFile = new File(bmzc.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    if (localFile.exists())
    {
      if (this.jdField_a_of_type_Bmyz == null) {
        break label152;
      }
      bmzc.a().a(localFile.getAbsolutePath(), true);
      this.jdField_a_of_type_Bmyz.a(this.jdField_a_of_type_Int, localFile.getAbsolutePath(), this.jdField_a_of_type_JavaLangString);
    }
    label152:
    while ((bmzc.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bmyz)) || (this.jdField_a_of_type_Bmyz == null))
    {
      return;
      if (this.jdField_b_of_type_Int == 1)
      {
        localFile = new File(bmzc.a(this.this$0, this.jdField_a_of_type_Int, 0));
        if (localFile.exists())
        {
          String str = bmzc.a(this.this$0, this.jdField_a_of_type_Int, 1);
          if (bmzc.a(this.this$0, localFile.getAbsolutePath(), str))
          {
            this.jdField_a_of_type_Bmyz.a(this.jdField_a_of_type_Int, str, this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
      }
    }
    this.jdField_a_of_type_Bmyz.a(this.jdField_a_of_type_Int, null, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.3
 * JD-Core Version:    0.7.0.1
 */