import android.content.Context;
import android.content.res.Resources;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.qphone.base.util.QLog;

public class ndi
  implements ncy
{
  ncz jdField_a_of_type_Ncz;
  nda jdField_a_of_type_Nda;
  
  public ndi(ncz paramncz)
  {
    this.jdField_a_of_type_Ncz = paramncz;
  }
  
  public String a(Context paramContext, mze parammze)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessActionStagePresenter", 2, "getGamePrepareBottomTip null context");
      }
      return "";
    }
    boolean bool = myk.a(parammze);
    parammze = parammze.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
    if (bool) {
      return paramContext.getResources().getString(2131690213);
    }
    return String.format(paramContext.getResources().getString(2131690214), new Object[] { bhlg.a(parammze, 8.0F) });
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
      return paramContext.getResources().getString(2131690217);
    }
    return paramContext.getResources().getString(2131690212);
  }
  
  public nda a()
  {
    return this.jdField_a_of_type_Nda;
  }
  
  public void a(myp parammyp)
  {
    this.jdField_a_of_type_Ncz.a(parammyp);
  }
  
  public void a(mze parammze)
  {
    a(myk.a(parammze), false);
    this.jdField_a_of_type_Nda.a().d(false);
  }
  
  public void a(nda paramnda)
  {
    this.jdField_a_of_type_Nda = paramnda;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ncz.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Ncz.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void b(mze parammze)
  {
    a(myk.a(parammze), true);
    a(parammze.a());
    this.jdField_a_of_type_Nda.a().d(true);
    this.jdField_a_of_type_Nda.a().a(parammze.a().jdField_a_of_type_Mzi.c * 1000, parammze.a().e());
    this.jdField_a_of_type_Nda.a(this.jdField_a_of_type_Ncz.a(), parammze.a().jdField_a_of_type_Mzi.e * 1000, parammze.a().d());
  }
  
  public void c(mze parammze)
  {
    a(myk.a(parammze), true);
    a(parammze.a());
    this.jdField_a_of_type_Nda.a(this.jdField_a_of_type_Ncz.a(), parammze.a().jdField_a_of_type_Mzi.e * 1000, parammze.a().d());
    this.jdField_a_of_type_Nda.a().a(parammze.a().jdField_a_of_type_Mzi.c * 1000, parammze.a().e());
  }
  
  public void d(mze parammze) {}
  
  public void e(mze parammze) {}
  
  public void f(mze parammze) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndi
 * JD-Core Version:    0.7.0.1
 */