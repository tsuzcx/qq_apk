import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1;
import com.tencent.qphone.base.util.QLog;

public class ndt
  implements ncy
{
  private Runnable jdField_a_of_type_JavaLangRunnable = new GuessStarStagePresenter.1(this);
  public ncz a;
  public nda a;
  private boolean jdField_a_of_type_Boolean;
  
  public ndt(ncz paramncz)
  {
    this.jdField_a_of_type_Ncz = paramncz;
  }
  
  public String a(Context paramContext, mze parammze)
  {
    paramContext = parammze.a();
    if (paramContext == null)
    {
      QLog.d("GuessStarStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      parammze = "";
    }
    do
    {
      return parammze;
      parammze = paramContext.m;
      paramContext = parammze;
      if (!TextUtils.isEmpty(parammze))
      {
        paramContext = parammze;
        if (parammze.contains("\\n")) {
          paramContext = parammze.replace("\\n", "\n");
        }
      }
      parammze = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d("GuessStarStagePresenter", 2, "getGamePrepareBottomTip result = " + paramContext);
    return paramContext;
  }
  
  public String a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessStarStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    return paramContext.getResources().getString(2131690212);
  }
  
  public nda a()
  {
    return this.jdField_a_of_type_Nda;
  }
  
  public void a()
  {
    ngk.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(int paramInt)
  {
    ngk.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    ngk.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
  }
  
  public void a(myp parammyp)
  {
    this.jdField_a_of_type_Ncz.a(parammyp);
  }
  
  public void a(mze parammze)
  {
    a(myk.a(parammze), false);
    this.jdField_a_of_type_Nda.a().d(false);
    this.jdField_a_of_type_Nda.a().m(parammze);
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
    if (!paramBoolean2) {
      a();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(mze parammze)
  {
    a(myk.a(parammze), true);
    a(parammze.a());
    this.jdField_a_of_type_Nda.a().d(true);
    String str = parammze.e() + 1 + "/" + parammze.f();
    this.jdField_a_of_type_Nda.a().b(str);
    this.jdField_a_of_type_Nda.a(this.jdField_a_of_type_Ncz.a(), parammze.a().f(), parammze.a().d());
    this.jdField_a_of_type_Boolean = true;
    int i = parammze.a().f() - parammze.a().d() - 5000;
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarStagePresenter", 2, "onRealStartGame delayMs = " + i + ",topicDuration = " + parammze.a().f() + ",statusPassedTime = " + parammze.a().d());
    }
    if (i > 0) {
      a(i);
    }
    this.jdField_a_of_type_Nda.a().k(parammze);
  }
  
  public void c(mze parammze)
  {
    a(myk.a(parammze), true);
    a(parammze.a());
    this.jdField_a_of_type_Nda.a(this.jdField_a_of_type_Ncz.a(), parammze.a().f(), parammze.a().d());
    int i = parammze.a().f() - parammze.a().d() - 5000;
    if ((i > 0) && (this.jdField_a_of_type_Boolean)) {
      a(i);
    }
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarStagePresenter", 2, "onSwitchTopic delayMs = " + i + ",topicDuration = " + parammze.a().f() + ",statusPassedTime = " + parammze.a().d());
    }
    String str = parammze.e() + 1 + "/" + parammze.f();
    this.jdField_a_of_type_Nda.a().b(str);
    this.jdField_a_of_type_Nda.a().k(parammze);
  }
  
  public void d(mze parammze) {}
  
  public void e(mze parammze) {}
  
  public void f(mze parammze) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndt
 * JD-Core Version:    0.7.0.1
 */