import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class pz
  implements Runnable
{
  public pz(FontManager paramFontManager, String paramString, int paramInt) {}
  
  public void run()
  {
    if (FontManager.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager).containsKey(this.jdField_a_of_type_JavaLangString))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)FontManager.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager).get(this.jdField_a_of_type_JavaLangString);
      if (localConcurrentHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_Int)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "updateDiyConfig uin = " + this.jdField_a_of_type_JavaLangString + " fontId = " + this.jdField_a_of_type_Int);
        }
        localConcurrentHashMap.remove(Integer.valueOf(this.jdField_a_of_type_Int));
        VasUtils.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pz
 * JD-Core Version:    0.7.0.1
 */