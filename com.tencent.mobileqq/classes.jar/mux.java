import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

class mux
{
  private Map<String, muy> jdField_a_of_type_JavaUtilMap = new HashMap();
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public mux(String[] paramArrayOfString)
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
          this.jdField_a_of_type_JavaUtilMap.put(str, new muy(this, 2130842244, anzj.a(2131713834), str));
        }
        for (;;)
        {
          i += 1;
          break;
          if ("DEVICE_EARPHONE".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new muy(this, 2130842246, anzj.a(2131713835), str));
          } else if ("DEVICE_SPEAKERPHONE".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new muy(this, 2130842249, anzj.a(2131713838), str));
          } else if ("DEVICE_WIREDHEADSET".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new muy(this, 2130842251, anzj.a(2131713836), str));
          }
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
  }
  
  public muy a(String paramString)
  {
    return (muy)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      muy localmuy = (muy)this.jdField_a_of_type_JavaUtilMap.get("DEVICE_BLUETOOTHHEADSET");
      if (localmuy != null) {
        localmuy.b = (anzj.a(2131713837) + paramString + "）");
      }
    }
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mux
 * JD-Core Version:    0.7.0.1
 */