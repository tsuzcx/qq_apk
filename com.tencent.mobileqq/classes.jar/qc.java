import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

public class qc
  implements Runnable
{
  public qc(FontManager paramFontManager, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a.getManager(50)).a(this.jdField_a_of_type_JavaLangString);
    FontManager.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a, this.jdField_a_of_type_JavaLangString, localExtensionInfo, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qc
 * JD-Core Version:    0.7.0.1
 */