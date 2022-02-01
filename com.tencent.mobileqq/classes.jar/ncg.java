import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1;
import com.tencent.qphone.base.util.QLog;

public class ncg
  implements nbl
{
  private Runnable jdField_a_of_type_JavaLangRunnable = new GuessStarStagePresenter.1(this);
  public nbm a;
  public nbn a;
  private boolean jdField_a_of_type_Boolean;
  
  public ncg(nbm paramnbm)
  {
    this.jdField_a_of_type_Nbm = paramnbm;
  }
  
  public String a(Context paramContext, myc parammyc)
  {
    paramContext = parammyc.a();
    if (paramContext == null)
    {
      QLog.d("GuessStarStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      parammyc = "";
    }
    do
    {
      return parammyc;
      parammyc = paramContext.l;
      paramContext = parammyc;
      if (!TextUtils.isEmpty(parammyc))
      {
        paramContext = parammyc;
        if (parammyc.contains("\\n")) {
          paramContext = parammyc.replace("\\n", "\n");
        }
      }
      parammyc = paramContext;
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
    return paramContext.getResources().getString(2131690199);
  }
  
  public nbn a()
  {
    return this.jdField_a_of_type_Nbn;
  }
  
  public void a()
  {
    neq.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(int paramInt)
  {
    neq.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    neq.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
  }
  
  public void a(mxq parammxq)
  {
    this.jdField_a_of_type_Nbm.a(parammxq);
  }
  
  public void a(myc parammyc)
  {
    a(mxl.a(parammyc), false);
    this.jdField_a_of_type_Nbn.a().d(false);
    this.jdField_a_of_type_Nbn.a().m(parammyc);
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
  
  public void b(myc parammyc)
  {
    a(mxl.a(parammyc), true);
    a(parammyc.a());
    this.jdField_a_of_type_Nbn.a().d(true);
    String str = parammyc.e() + 1 + "/" + parammyc.f();
    this.jdField_a_of_type_Nbn.a().b(str);
    this.jdField_a_of_type_Nbn.a(this.jdField_a_of_type_Nbm.a(), parammyc.a().f(), parammyc.a().d());
    this.jdField_a_of_type_Boolean = true;
    int i = parammyc.a().f() - parammyc.a().d() - 5000;
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarStagePresenter", 2, "onRealStartGame delayMs = " + i + ",topicDuration = " + parammyc.a().f() + ",statusPassedTime = " + parammyc.a().d());
    }
    if (i > 0) {
      a(i);
    }
    this.jdField_a_of_type_Nbn.a().k(parammyc);
  }
  
  public void c(myc parammyc)
  {
    a(mxl.a(parammyc), true);
    a(parammyc.a());
    this.jdField_a_of_type_Nbn.a(this.jdField_a_of_type_Nbm.a(), parammyc.a().f(), parammyc.a().d());
    int i = parammyc.a().f() - parammyc.a().d() - 5000;
    if ((i > 0) && (this.jdField_a_of_type_Boolean)) {
      a(i);
    }
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarStagePresenter", 2, "onSwitchTopic delayMs = " + i + ",topicDuration = " + parammyc.a().f() + ",statusPassedTime = " + parammyc.a().d());
    }
    String str = parammyc.e() + 1 + "/" + parammyc.f();
    this.jdField_a_of_type_Nbn.a().b(str);
    this.jdField_a_of_type_Nbn.a().k(parammyc);
  }
  
  public void d(myc parammyc) {}
  
  public void e(myc parammyc) {}
  
  public void f(myc parammyc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncg
 * JD-Core Version:    0.7.0.1
 */