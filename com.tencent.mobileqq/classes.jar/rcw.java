import android.graphics.Bitmap.Config;
import java.net.URL;

public class rcw
{
  public int a;
  public Bitmap.Config a;
  public URL a;
  public volatile boolean a;
  public int b;
  public boolean b;
  public int c = 0;
  
  public rcw()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
  }
  
  public String a()
  {
    return "kandian_zimage_image_req_" + hashCode();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool3;
              } while (paramObject == null);
              bool1 = bool3;
            } while (getClass() != paramObject.getClass());
            paramObject = (rcw)paramObject;
            bool1 = bool3;
          } while (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int);
          bool1 = bool3;
        } while (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int);
        bool1 = bool3;
      } while (this.c != paramObject.c);
      if (this.jdField_a_of_type_JavaNetURL == null) {
        break;
      }
      bool1 = bool3;
    } while (!this.jdField_a_of_type_JavaNetURL.equals(paramObject.jdField_a_of_type_JavaNetURL));
    if (this.jdField_a_of_type_AndroidGraphicsBitmap$Config == paramObject.jdField_a_of_type_AndroidGraphicsBitmap$Config) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      if (paramObject.jdField_a_of_type_JavaNetURL == null) {
        break;
      }
      return false;
    }
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaNetURL != null) {}
    for (int i = this.jdField_a_of_type_JavaNetURL.hashCode();; i = 0) {
      return (((i * 31 + this.jdField_a_of_type_Int) * 31 + this.jdField_b_of_type_Int) * 31 + this.jdField_a_of_type_AndroidGraphicsBitmap$Config.hashCode()) * 31 + this.c;
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaNetURL + " " + this.jdField_a_of_type_Int + "x" + this.jdField_b_of_type_Int + " isPreload:" + this.jdField_b_of_type_Boolean + " isCancel:" + this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rcw
 * JD-Core Version:    0.7.0.1
 */