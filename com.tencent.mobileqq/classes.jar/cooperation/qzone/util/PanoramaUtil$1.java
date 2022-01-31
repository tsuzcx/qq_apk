package cooperation.qzone.util;

import android.text.TextUtils;
import axql;
import bhod;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.Properties;

public class PanoramaUtil$1
  implements Runnable
{
  public PanoramaUtil$1(bhod parambhod, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      Properties localProperties = new Properties();
      localProperties.put(this.b, this.jdField_a_of_type_JavaLangString);
      axql.a(BaseApplication.getContext()).reportTimeKVEvent("qzone_panorama", localProperties, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.PanoramaUtil.1
 * JD-Core Version:    0.7.0.1
 */