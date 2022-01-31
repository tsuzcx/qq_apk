import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

class mwq
{
  private Map<String, mwr> jdField_a_of_type_JavaUtilMap = new HashMap();
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public mwq(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if ("DEVICE_BLUETOOTHHEADSET".equals(str)) {
          this.jdField_a_of_type_JavaUtilMap.put(str, new mwr(this, 2130841911, alpo.a(2131715417), str));
        }
        for (;;)
        {
          i += 1;
          break;
          if ("DEVICE_EARPHONE".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new mwr(this, 2130841913, alpo.a(2131715418), str));
          } else if ("DEVICE_SPEAKERPHONE".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new mwr(this, 2130841916, alpo.a(2131715421), str));
          } else if ("DEVICE_WIREDHEADSET".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new mwr(this, 2130841918, alpo.a(2131715419), str));
          }
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
  }
  
  public mwr a(String paramString)
  {
    return (mwr)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      mwr localmwr = (mwr)this.jdField_a_of_type_JavaUtilMap.get("DEVICE_BLUETOOTHHEADSET");
      if (localmwr != null) {
        localmwr.b = (alpo.a(2131715420) + paramString + "）");
      }
    }
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mwq
 * JD-Core Version:    0.7.0.1
 */