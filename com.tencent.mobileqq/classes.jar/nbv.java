import android.content.Context;
import android.content.res.Resources;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.qphone.base.util.QLog;

public class nbv
  implements nbl
{
  nbm jdField_a_of_type_Nbm;
  nbn jdField_a_of_type_Nbn;
  
  public nbv(nbm paramnbm)
  {
    this.jdField_a_of_type_Nbm = paramnbm;
  }
  
  public String a(Context paramContext, myc parammyc)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessActionStagePresenter", 2, "getGamePrepareBottomTip null context");
      }
      return "";
    }
    boolean bool = mxl.a(parammyc);
    parammyc = parammyc.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
    if (bool) {
      return paramContext.getResources().getString(2131690201);
    }
    return String.format(paramContext.getResources().getString(2131690202), new Object[] { bglf.a(parammyc, 8.0F) });
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
      return paramContext.getResources().getString(2131690206);
    }
    return paramContext.getResources().getString(2131690199);
  }
  
  public nbn a()
  {
    return this.jdField_a_of_type_Nbn;
  }
  
  public void a(mxq parammxq)
  {
    this.jdField_a_of_type_Nbm.a(parammxq);
  }
  
  public void a(myc parammyc)
  {
    a(mxl.a(parammyc), false);
    this.jdField_a_of_type_Nbn.a().d(false);
  }
  
  public void a(nbn paramnbn)
  {
    this.jdField_a_of_type_Nbn = paramnbn;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nbm.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Nbm.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void b(myc parammyc)
  {
    a(mxl.a(parammyc), true);
    a(parammyc.a());
    this.jdField_a_of_type_Nbn.a().d(true);
    this.jdField_a_of_type_Nbn.a().a(parammyc.a().jdField_a_of_type_Myf.c * 1000, parammyc.a().e());
    this.jdField_a_of_type_Nbn.a(this.jdField_a_of_type_Nbm.a(), parammyc.a().jdField_a_of_type_Myf.e * 1000, parammyc.a().d());
  }
  
  public void c(myc parammyc)
  {
    a(mxl.a(parammyc), true);
    a(parammyc.a());
    this.jdField_a_of_type_Nbn.a(this.jdField_a_of_type_Nbm.a(), parammyc.a().jdField_a_of_type_Myf.e * 1000, parammyc.a().d());
    this.jdField_a_of_type_Nbn.a().a(parammyc.a().jdField_a_of_type_Myf.c * 1000, parammyc.a().e());
  }
  
  public void d(myc parammyc) {}
  
  public void e(myc parammyc) {}
  
  public void f(myc parammyc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbv
 * JD-Core Version:    0.7.0.1
 */