package cooperation.qzone.util;

import android.content.Context;
import android.text.TextUtils;
import bdmc;
import bnjz;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import java.util.HashMap;

public class PanoramaUtil$1
  implements Runnable
{
  public PanoramaUtil$1(bnjz parambnjz, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(this.b, this.jdField_a_of_type_JavaLangString);
      Context localContext = BaseApplication.getContext();
      if (localContext != null) {
        bdmc.a(localContext).a(null, "qzone_panorama", true, this.jdField_a_of_type_Int, 0L, localHashMap, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.PanoramaUtil.1
 * JD-Core Version:    0.7.0.1
 */