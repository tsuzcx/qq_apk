import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

class mtw
{
  private Map<String, mtx> jdField_a_of_type_JavaUtilMap = new HashMap();
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public mtw(String[] paramArrayOfString)
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
          this.jdField_a_of_type_JavaUtilMap.put(str, new mtx(this, 2130841760, ajya.a(2131715045), str));
        }
        for (;;)
        {
          i += 1;
          break;
          if ("DEVICE_EARPHONE".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new mtx(this, 2130841762, ajya.a(2131715046), str));
          } else if ("DEVICE_SPEAKERPHONE".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new mtx(this, 2130841765, ajya.a(2131715049), str));
          } else if ("DEVICE_WIREDHEADSET".equals(str)) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new mtx(this, 2130841767, ajya.a(2131715047), str));
          }
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilMap.size();
  }
  
  public mtx a(String paramString)
  {
    return (mtx)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      mtx localmtx = (mtx)this.jdField_a_of_type_JavaUtilMap.get("DEVICE_BLUETOOTHHEADSET");
      if (localmtx != null) {
        localmtx.b = (ajya.a(2131715048) + paramString + "）");
      }
    }
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mtw
 * JD-Core Version:    0.7.0.1
 */