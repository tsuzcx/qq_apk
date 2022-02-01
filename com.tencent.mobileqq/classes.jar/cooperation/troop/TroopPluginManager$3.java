package cooperation.troop;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;

class TroopPluginManager$3
  extends TroopObserver
{
  public void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        String str = (Long)paramObject[0] + "";
        if (this.jdField_a_of_type_JavaLangString.equals(str)) {
          break label59;
        }
      }
    }
    return;
    label59:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    this.jdField_a_of_type_CooperationTroopTroopPluginManager.a("com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", new TroopPluginManager.3.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.3
 * JD-Core Version:    0.7.0.1
 */