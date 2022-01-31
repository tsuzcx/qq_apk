import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.armap.ConversationARMap;
import com.tencent.mobileqq.armap.config.ARMapConfigManager.ARMapShower;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.qphone.base.util.QLog;

public class sfy
  extends ARMapConfigManager.ARMapShower
{
  private sfy(Conversation paramConversation) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "ARMap.showEntrance......");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao != null) && (this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.a())) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.b();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "ARMap.restoreNormal......reason=" + paramString);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.c();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "ARMap.pendant......switcher=" + paramBoolean);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.b(paramBoolean, paramInt);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "ARMap.breathe......switcher=" + paramBoolean1 + "  isPermanent:" + paramBoolean2);
    }
    ConversationARMap localConversationARMap;
    if (this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap != null)
    {
      localConversationARMap = this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap;
      if (!paramBoolean2) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      localConversationARMap.a(paramBoolean1, i);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap != null) {
      bool = this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.a(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "ARMap.isBreatheShowing " + bool);
    }
    return bool;
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap != null) {
      bool = this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.b(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "ARMap.isPendantShowing " + bool);
    }
    return bool;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "ARMap.isResume......");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap != null) {
      return this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.b();
    }
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfy
 * JD-Core Version:    0.7.0.1
 */