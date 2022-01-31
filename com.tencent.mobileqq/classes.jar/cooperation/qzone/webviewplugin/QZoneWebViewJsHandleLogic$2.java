package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.graphics.Bitmap;
import bcdp;
import bhmi;
import bhrp;
import java.util.Map;

public final class QZoneWebViewJsHandleLogic$2
  implements Runnable
{
  public QZoneWebViewJsHandleLogic$2(bcdp parambcdp, Map paramMap, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Bcdp.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    bhmi.a().a(bhrp.a);
    bhmi.a().a(this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, this.b, this.c, this.d, this.e, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.2
 * JD-Core Version:    0.7.0.1
 */