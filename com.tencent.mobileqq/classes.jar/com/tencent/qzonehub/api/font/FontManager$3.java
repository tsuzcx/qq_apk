package com.tencent.qzonehub.api.font;

import cooperation.qzone.cache.FileCacheService;
import java.io.File;

class FontManager$3
  implements Runnable
{
  FontManager$3(FontManager paramFontManager, int paramInt1, int paramInt2, FontInterface.FontResult paramFontResult, String paramString1, String paramString2) {}
  
  public void run()
  {
    File localFile = new File(FontManager.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
    if (localFile.exists())
    {
      if (this.jdField_a_of_type_ComTencentQzonehubApiFontFontInterface$FontResult == null) {
        break label152;
      }
      FontManager.a().updateLruFile(localFile.getAbsolutePath(), true);
      this.jdField_a_of_type_ComTencentQzonehubApiFontFontInterface$FontResult.a(this.jdField_a_of_type_Int, localFile.getAbsolutePath(), this.jdField_a_of_type_JavaLangString);
    }
    label152:
    while ((FontManager.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQzonehubApiFontFontInterface$FontResult)) || (this.jdField_a_of_type_ComTencentQzonehubApiFontFontInterface$FontResult == null))
    {
      return;
      if (this.jdField_b_of_type_Int == 1)
      {
        localFile = new File(FontManager.a(this.this$0, this.jdField_a_of_type_Int, 0));
        if (localFile.exists())
        {
          String str = FontManager.a(this.this$0, this.jdField_a_of_type_Int, 1);
          if (FontManager.a(this.this$0, localFile.getAbsolutePath(), str))
          {
            this.jdField_a_of_type_ComTencentQzonehubApiFontFontInterface$FontResult.a(this.jdField_a_of_type_Int, str, this.jdField_a_of_type_JavaLangString);
            return;
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentQzonehubApiFontFontInterface$FontResult.a(this.jdField_a_of_type_Int, null, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.font.FontManager.3
 * JD-Core Version:    0.7.0.1
 */