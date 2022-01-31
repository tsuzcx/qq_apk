import android.content.Intent;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.data.TroopMemberCard;

class sjc
  implements Runnable
{
  sjc(sja paramsja, TroopMemberCard paramTroopMemberCard) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("nick", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card);
      this.jdField_a_of_type_Sja.a.setResult(-1, localIntent);
      EditInfoActivity.e(this.jdField_a_of_type_Sja.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjc
 * JD-Core Version:    0.7.0.1
 */