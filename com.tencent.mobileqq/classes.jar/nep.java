import android.content.Context;
import android.content.res.Resources;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class nep
  implements ned
{
  nee jdField_a_of_type_Nee;
  neg jdField_a_of_type_Neg;
  
  public nep(nee paramnee)
  {
    this.jdField_a_of_type_Nee = paramnee;
  }
  
  public String a(Context paramContext, naf paramnaf)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessActionStagePresenter", 2, "getGamePrepareBottomTip null context");
      }
      return "";
    }
    boolean bool = mzl.a(paramnaf);
    paramnaf = paramnaf.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
    if (bool) {
      return paramContext.getResources().getString(2131690238);
    }
    return String.format(paramContext.getResources().getString(2131690239), new Object[] { ContactUtils.getFitString(paramnaf, 8.0F) });
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
      return paramContext.getResources().getString(2131690242);
    }
    return paramContext.getResources().getString(2131690237);
  }
  
  public neg a()
  {
    return this.jdField_a_of_type_Neg;
  }
  
  public void a(mzq parammzq)
  {
    this.jdField_a_of_type_Nee.a(parammzq);
  }
  
  public void a(naf paramnaf)
  {
    a(mzl.a(paramnaf), false);
    this.jdField_a_of_type_Neg.a().d(false);
  }
  
  public void a(neg paramneg)
  {
    this.jdField_a_of_type_Neg = paramneg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nee.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Nee.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void b(naf paramnaf)
  {
    a(mzl.a(paramnaf), true);
    a(paramnaf.a());
    this.jdField_a_of_type_Neg.a().d(true);
    this.jdField_a_of_type_Neg.a().a(paramnaf.a().jdField_a_of_type_Naj.c * 1000, paramnaf.a().e());
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_Nee.a(), paramnaf.a().jdField_a_of_type_Naj.e * 1000, paramnaf.a().d());
  }
  
  public void c(naf paramnaf)
  {
    a(mzl.a(paramnaf), true);
    a(paramnaf.a());
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_Nee.a(), paramnaf.a().jdField_a_of_type_Naj.e * 1000, paramnaf.a().d());
    this.jdField_a_of_type_Neg.a().a(paramnaf.a().jdField_a_of_type_Naj.c * 1000, paramnaf.a().e());
  }
  
  public void d(naf paramnaf) {}
  
  public void e(naf paramnaf) {}
  
  public void f(naf paramnaf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nep
 * JD-Core Version:    0.7.0.1
 */