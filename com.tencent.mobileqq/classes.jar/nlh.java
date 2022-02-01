import android.content.Context;
import android.content.res.Resources;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class nlh
  implements nkv
{
  nkw jdField_a_of_type_Nkw;
  nky jdField_a_of_type_Nky;
  
  public nlh(nkw paramnkw)
  {
    this.jdField_a_of_type_Nkw = paramnkw;
  }
  
  public String a(Context paramContext, nfv paramnfv)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessActionStagePresenter", 2, "getGamePrepareBottomTip null context");
      }
      return "";
    }
    boolean bool = nfc.a(paramnfv);
    paramnfv = paramnfv.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
    if (bool) {
      return paramContext.getResources().getString(2131690276);
    }
    return String.format(paramContext.getResources().getString(2131690277), new Object[] { ContactUtils.getFitString(paramnfv, 8.0F) });
  }
  
  public String a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessActionStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    if (paramBoolean) {
      return paramContext.getResources().getString(2131690280);
    }
    return paramContext.getResources().getString(2131690275);
  }
  
  public nky a()
  {
    return this.jdField_a_of_type_Nky;
  }
  
  public void a(nfh paramnfh)
  {
    this.jdField_a_of_type_Nkw.a(paramnfh);
  }
  
  public void a(nfv paramnfv)
  {
    a(nfc.a(paramnfv), false);
    this.jdField_a_of_type_Nky.a().e(false);
  }
  
  public void a(nky paramnky)
  {
    this.jdField_a_of_type_Nky = paramnky;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nkw.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Nkw.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void b(nfv paramnfv)
  {
    a(nfc.a(paramnfv), true);
    a(paramnfv.a());
    this.jdField_a_of_type_Nky.a().e(true);
    this.jdField_a_of_type_Nky.a().a(paramnfv.a().jdField_a_of_type_Nfz.c * 1000, paramnfv.a().e());
    this.jdField_a_of_type_Nky.a(this.jdField_a_of_type_Nkw.a(), paramnfv.a().jdField_a_of_type_Nfz.e * 1000, paramnfv.a().d());
  }
  
  public void c(nfv paramnfv)
  {
    a(nfc.a(paramnfv), true);
    a(paramnfv.a());
    this.jdField_a_of_type_Nky.a(this.jdField_a_of_type_Nkw.a(), paramnfv.a().jdField_a_of_type_Nfz.e * 1000, paramnfv.a().d());
    this.jdField_a_of_type_Nky.a().a(paramnfv.a().jdField_a_of_type_Nfz.c * 1000, paramnfv.a().e());
  }
  
  public void d(nfv paramnfv) {}
  
  public void e(nfv paramnfv) {}
  
  public void f(nfv paramnfv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlh
 * JD-Core Version:    0.7.0.1
 */