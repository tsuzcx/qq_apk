package cooperation.qzone.font;

import bjjs;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FontManager$4
  implements Runnable
{
  public FontManager$4(bjjs parambjjs, String paramString, int paramInt) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FontManager", 4, "begin to download font file from network, url =" + this.jdField_a_of_type_JavaLangString);
    }
    if (HttpDownloadUtil.a(null, this.jdField_a_of_type_JavaLangString, new File(bjjs.a(this.this$0, this.jdField_a_of_type_Int)))) {
      bjjs.a(this.this$0, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      bjjs.a(this.this$0, this.jdField_a_of_type_Int);
      return;
      QLog.e("FontManager", 1, "Font Download Failed, font url = " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.font.FontManager.4
 * JD-Core Version:    0.7.0.1
 */