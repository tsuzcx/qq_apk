package cooperation.qzone.util;

import android.content.Context;
import android.text.TextUtils;
import azqh;
import bjum;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.Properties;

public class PanoramaUtil$1
  implements Runnable
{
  public PanoramaUtil$1(bjum parambjum, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      Properties localProperties = new Properties();
      localProperties.put(this.b, this.jdField_a_of_type_JavaLangString);
      Context localContext = BaseApplication.getContext();
      if (localContext != null) {
        azqh.a(localContext).reportTimeKVEvent("qzone_panorama", localProperties, this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.util.PanoramaUtil.1
 * JD-Core Version:    0.7.0.1
 */