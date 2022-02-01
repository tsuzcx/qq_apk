import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1;
import com.tencent.qphone.base.util.QLog;

public class nfa
  implements ned
{
  private Runnable jdField_a_of_type_JavaLangRunnable = new GuessStarStagePresenter.1(this);
  public nee a;
  public neg a;
  private boolean jdField_a_of_type_Boolean;
  
  public nfa(nee paramnee)
  {
    this.jdField_a_of_type_Nee = paramnee;
  }
  
  public String a(Context paramContext, naf paramnaf)
  {
    paramContext = paramnaf.a();
    if (paramContext == null)
    {
      QLog.d("GuessStarStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      paramnaf = "";
    }
    do
    {
      return paramnaf;
      paramnaf = paramContext.m;
      paramContext = paramnaf;
      if (!TextUtils.isEmpty(paramnaf))
      {
        paramContext = paramnaf;
        if (paramnaf.contains("\\n")) {
          paramContext = paramnaf.replace("\\n", "\n");
        }
      }
      paramnaf = paramContext;
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
    return paramContext.getResources().getString(2131690237);
  }
  
  public neg a()
  {
    return this.jdField_a_of_type_Neg;
  }
  
  public void a()
  {
    nht.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(int paramInt)
  {
    nht.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    nht.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
  }
  
  public void a(mzq parammzq)
  {
    this.jdField_a_of_type_Nee.a(parammzq);
  }
  
  public void a(naf paramnaf)
  {
    a(mzl.a(paramnaf), false);
    this.jdField_a_of_type_Neg.a().d(false);
    this.jdField_a_of_type_Neg.a().m(paramnaf);
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
  
  public void b(naf paramnaf)
  {
    a(mzl.a(paramnaf), true);
    a(paramnaf.a());
    this.jdField_a_of_type_Neg.a().d(true);
    String str = paramnaf.e() + 1 + "/" + paramnaf.f();
    this.jdField_a_of_type_Neg.a().b(str);
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_Nee.a(), paramnaf.a().f(), paramnaf.a().d());
    this.jdField_a_of_type_Boolean = true;
    int i = paramnaf.a().f() - paramnaf.a().d() - 5000;
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarStagePresenter", 2, "onRealStartGame delayMs = " + i + ",topicDuration = " + paramnaf.a().f() + ",statusPassedTime = " + paramnaf.a().d());
    }
    if (i > 0) {
      a(i);
    }
    this.jdField_a_of_type_Neg.a().k(paramnaf);
  }
  
  public void c(naf paramnaf)
  {
    a(mzl.a(paramnaf), true);
    a(paramnaf.a());
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_Nee.a(), paramnaf.a().f(), paramnaf.a().d());
    int i = paramnaf.a().f() - paramnaf.a().d() - 5000;
    if ((i > 0) && (this.jdField_a_of_type_Boolean)) {
      a(i);
    }
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarStagePresenter", 2, "onSwitchTopic delayMs = " + i + ",topicDuration = " + paramnaf.a().f() + ",statusPassedTime = " + paramnaf.a().d());
    }
    String str = paramnaf.e() + 1 + "/" + paramnaf.f();
    this.jdField_a_of_type_Neg.a().b(str);
    this.jdField_a_of_type_Neg.a().k(paramnaf);
  }
  
  public void d(naf paramnaf) {}
  
  public void e(naf paramnaf) {}
  
  public void f(naf paramnaf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfa
 * JD-Core Version:    0.7.0.1
 */