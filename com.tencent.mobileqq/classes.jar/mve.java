import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

class mve
{
  private Map<String, mvf> jdField_a_of_type_JavaUtilMap = new HashMap();
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public mve(String[] paramArrayOfString)
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
          this.jdField_a_of_type_JavaUtilMap.put(str, new mvf(this, 2130842300, anvx.a(2131714413), str));
        }
        for (;;)
        {
          i += 1;
          break;
          if ("DEVICE_EARPHONE".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new mvf(this, 2130842302, anvx.a(2131714414), str));
          } else if ("DEVICE_SPEAKERPHONE".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new mvf(this, 2130842305, anvx.a(2131714417), str));
          } else if ("DEVICE_WIREDHEADSET".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new mvf(this, 2130842307, anvx.a(2131714415), str));
          }
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
  }
  
  public mvf a(String paramString)
  {
    return (mvf)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      mvf localmvf = (mvf)this.jdField_a_of_type_JavaUtilMap.get("DEVICE_BLUETOOTHHEADSET");
      if (localmvf != null) {
        localmvf.b = (anvx.a(2131714416) + paramString + "）");
      }
    }
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mve
 * JD-Core Version:    0.7.0.1
 */