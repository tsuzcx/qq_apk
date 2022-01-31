import android.os.Bundle;
import com.tencent.biz.huanjiplugin.HuanjiPluginStartListener;
import com.tencent.biz.troop.TroopMemberApiService;

class owr
  implements HuanjiPluginStartListener
{
  owr(owi paramowi, Bundle paramBundle, int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidOsBundle.putInt("state", paramInt2);
    this.jdField_a_of_type_AndroidOsBundle.putInt("percentage", paramInt3);
    this.jdField_a_of_type_AndroidOsBundle.putLong("errCode", 0L);
    if ((paramInt2 == 6) && (this.jdField_a_of_type_Int == 2)) {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("actionFinish", true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Owi.a.a(80, this.jdField_a_of_type_AndroidOsBundle);
      return;
      if ((paramInt2 == 4) && (this.jdField_a_of_type_Int == 1)) {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("actionFinish", true);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.putLong("errCode", paramInt);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("actionFinish", true);
    this.jdField_a_of_type_Owi.a.a(80, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owr
 * JD-Core Version:    0.7.0.1
 */