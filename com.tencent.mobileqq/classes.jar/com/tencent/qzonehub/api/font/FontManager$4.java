package com.tencent.qzonehub.api.font;

import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class FontManager$4
  implements Runnable
{
  FontManager$4(FontManager paramFontManager, String paramString, int paramInt) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FontManager", 4, "begin to download font file from network, url =" + this.jdField_a_of_type_JavaLangString);
    }
    if (HttpDownloadUtil.download(null, this.jdField_a_of_type_JavaLangString, new File(FontManager.a(this.this$0, this.jdField_a_of_type_Int)))) {
      FontManager.a(this.this$0, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      FontManager.a(this.this$0, this.jdField_a_of_type_Int);
      return;
      QLog.e("FontManager", 1, "Font Download Failed, font url = " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.font.FontManager.4
 * JD-Core Version:    0.7.0.1
 */