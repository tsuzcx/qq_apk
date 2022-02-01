package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.graphics.Bitmap;
import bioy;
import bnhm;
import bnmv;
import java.util.Map;

public final class QZoneWebViewJsHandleLogic$2
  implements Runnable
{
  public QZoneWebViewJsHandleLogic$2(bioy parambioy, Map paramMap, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Bioy.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    bnhm.a().a(bnmv.a);
    bnhm.a().a(this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, this.b, this.c, this.d, this.e, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.2
 * JD-Core Version:    0.7.0.1
 */