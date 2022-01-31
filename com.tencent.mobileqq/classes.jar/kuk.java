import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class kuk
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  
  public kuk()
  {
    this.jdField_a_of_type_JavaLangString = Build.HARDWARE;
    this.jdField_b_of_type_JavaLangString = Build.MANUFACTURER;
    this.jdField_c_of_type_JavaLangString = Build.MODEL;
    this.jdField_d_of_type_JavaLangString = Build.PRODUCT;
    this.jdField_e_of_type_JavaLangString = Build.FINGERPRINT;
    this.jdField_f_of_type_JavaLangString = lbk.a();
    this.jdField_a_of_type_Int = Build.VERSION.SDK_INT;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append("|");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString).append("|");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString).append("|");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString).append("|");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString).append("|");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString).append("|");
    localStringBuilder.append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append(this.jdField_a_of_type_Long).append("|");
    localStringBuilder.append(this.jdField_b_of_type_Int).append("|");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString).append("|");
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString).append("|");
    localStringBuilder.append(this.jdField_c_of_type_Int).append("|");
    localStringBuilder.append(this.jdField_d_of_type_Int).append("|");
    localStringBuilder.append(this.jdField_e_of_type_Int).append("|");
    localStringBuilder.append(this.jdField_f_of_type_Int).append("|");
    localStringBuilder.append(this.jdField_g_of_type_Int).append("|");
    localStringBuilder.append(this.jdField_h_of_type_Int).append("|");
    localStringBuilder.append(this.jdField_i_of_type_Int).append("|");
    localStringBuilder.append(this.j).append("|");
    localStringBuilder.append(this.jdField_i_of_type_JavaLangString).append("|");
    QLog.w("DeviceCapabilityExamination", 1, "ReportData:" + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kuk
 * JD-Core Version:    0.7.0.1
 */