import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.utils.ContactUtils.OnGetTroopMemberNameCallback;

class scg
  implements ContactUtils.OnGetTroopMemberNameCallback
{
  scg(scf paramscf, TextView paramTextView) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Scf.a.runOnUiThread(new sch(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scg
 * JD-Core Version:    0.7.0.1
 */