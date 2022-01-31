import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;

public class qf
  implements Runnable
{
  public qf(FontManager paramFontManager, FriendsManager paramFriendsManager, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> extensionInfo is null.");
      }
      AvatarPendantUtil.a(this.jdField_a_of_type_JavaLangString);
      AvatarPendantUtil.a(this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qf
 * JD-Core Version:    0.7.0.1
 */