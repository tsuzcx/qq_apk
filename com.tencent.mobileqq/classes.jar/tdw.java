import android.graphics.Bitmap.Config;
import java.net.URL;

public class tdw
{
  public static int g;
  public int a;
  public long a;
  public Bitmap.Config a;
  public String a;
  public URL a;
  public volatile boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public int e;
  public long e;
  public int f;
  public long f;
  public long g;
  public long h;
  public long i;
  
  static
  {
    jdField_g_of_type_Int = 2;
  }
  
  public tdw()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = -2;
    this.jdField_c_of_type_JavaLangString = "";
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
            paramObject = (tdw)paramObject;
            bool1 = bool3;
          } while (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int);
          bool1 = bool3;
        } while (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int);
        bool1 = bool3;
      } while (this.jdField_c_of_type_Int != paramObject.jdField_c_of_type_Int);
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
    for (int j = this.jdField_a_of_type_JavaNetURL.hashCode();; j = 0) {
      return (((j * 31 + this.jdField_a_of_type_Int) * 31 + this.jdField_b_of_type_Int) * 31 + this.jdField_a_of_type_AndroidGraphicsBitmap$Config.hashCode()) * 31 + this.jdField_c_of_type_Int;
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaNetURL + " " + this.jdField_a_of_type_Int + "x" + this.jdField_b_of_type_Int + " isPreload:" + this.jdField_b_of_type_Boolean + " isCancel:" + this.jdField_a_of_type_Boolean + " startTime: " + this.jdField_a_of_type_Long + " enterSubThreadTime: " + this.jdField_b_of_type_Long + " enterThreadPoolTime: " + this.jdField_c_of_type_Long + " startThreadPoolTime: " + this.jdField_d_of_type_Long + " downloadAndWriteFileTime: " + this.jdField_e_of_type_Long + " decodeTime: " + this.f + " enterMainThreadTime: " + this.jdField_g_of_type_Long + " endTime: " + this.h + " failCode: " + this.jdField_e_of_type_Int + " errMsg: " + this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdw
 * JD-Core Version:    0.7.0.1
 */