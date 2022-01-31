import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

class pbd
  implements Runnable
{
  pbd(paz parampaz, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Paz.a.getBaseContext().getSharedPreferences("sp_public_account_with_cuin_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("browser_font_size_index", this.jdField_a_of_type_Int);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbd
 * JD-Core Version:    0.7.0.1
 */