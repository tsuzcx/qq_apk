import android.graphics.Bitmap;
import android.text.TextUtils;

class mss
{
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  String d;
  
  private mss(msp parammsp)
  {
    a(null);
  }
  
  mss(msp parammsp, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramString4;
  }
  
  private void a(mss parammss)
  {
    if (parammss != null)
    {
      this.jdField_a_of_type_JavaLangString = parammss.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Int = parammss.jdField_a_of_type_Int;
      this.jdField_c_of_type_JavaLangString = parammss.jdField_c_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = parammss.jdField_b_of_type_JavaLangString;
      this.d = parammss.d;
      this.jdField_b_of_type_Int = parammss.jdField_b_of_type_Int;
      this.jdField_c_of_type_Int = parammss.jdField_c_of_type_Int;
      this.jdField_a_of_type_Boolean = parammss.jdField_a_of_type_Boolean;
      return;
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.d = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Int == 47) || (this.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_Int == 48) || (this.jdField_a_of_type_Int == 44);
  }
  
  private boolean a(mss parammss)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parammss != null) {
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, parammss.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Int != parammss.jdField_a_of_type_Int)
        {
          bool1 = bool2;
          if (!parammss.a()) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("NotifyData{sessionId[").append(this.jdField_a_of_type_JavaLangString).append("], id[").append(this.jdField_c_of_type_JavaLangString).append("], type[").append(this.jdField_a_of_type_Int).append("], uinType[").append(this.jdField_b_of_type_Int).append("], name[").append(this.jdField_b_of_type_JavaLangString).append("], extraName[").append(this.d).append("], head[");
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {}
    for (boolean bool = true;; bool = false) {
      return bool + "], isHide[" + this.jdField_a_of_type_Boolean + "]}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mss
 * JD-Core Version:    0.7.0.1
 */