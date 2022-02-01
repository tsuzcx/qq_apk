import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarStagePresenter.1;
import com.tencent.qphone.base.util.QLog;

public class nls
  implements nkv
{
  private Runnable jdField_a_of_type_JavaLangRunnable = new GuessStarStagePresenter.1(this);
  public nkw a;
  public nky a;
  private boolean jdField_a_of_type_Boolean;
  
  public nls(nkw paramnkw)
  {
    this.jdField_a_of_type_Nkw = paramnkw;
  }
  
  public String a(Context paramContext, nfv paramnfv)
  {
    paramContext = paramnfv.a();
    if (paramContext == null)
    {
      QLog.d("GuessStarStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      paramnfv = "";
    }
    do
    {
      return paramnfv;
      paramnfv = paramContext.m;
      paramContext = paramnfv;
      if (!TextUtils.isEmpty(paramnfv))
      {
        paramContext = paramnfv;
        if (paramnfv.contains("\\n")) {
          paramContext = paramnfv.replace("\\n", "\n");
        }
      }
      paramnfv = paramContext;
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
    return paramContext.getResources().getString(2131690275);
  }
  
  public nky a()
  {
    return this.jdField_a_of_type_Nky;
  }
  
  public void a()
  {
    nom.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(int paramInt)
  {
    nom.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    nom.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
  }
  
  public void a(nfh paramnfh)
  {
    this.jdField_a_of_type_Nkw.a(paramnfh);
  }
  
  public void a(nfv paramnfv)
  {
    a(nfc.a(paramnfv), false);
    this.jdField_a_of_type_Nky.a().e(false);
    this.jdField_a_of_type_Nky.a().m(paramnfv);
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
  
  public void b(nfv paramnfv)
  {
    a(nfc.a(paramnfv), true);
    a(paramnfv.a());
    this.jdField_a_of_type_Nky.a().e(true);
    if (paramnfv.a().a.a()) {
      this.jdField_a_of_type_Nky.a().a(paramnfv.a().a.c * 1000, paramnfv.a().e());
    }
    for (;;)
    {
      this.jdField_a_of_type_Nky.a(this.jdField_a_of_type_Nkw.a(), paramnfv.a().f(), paramnfv.a().d());
      this.jdField_a_of_type_Boolean = true;
      int i = paramnfv.a().f() - paramnfv.a().d() - 5000;
      if (QLog.isColorLevel()) {
        QLog.i("GuessStarStagePresenter", 2, "onRealStartGame delayMs = " + i + ",topicDuration = " + paramnfv.a().f() + ",statusPassedTime = " + paramnfv.a().d());
      }
      if (i > 0) {
        a(i);
      }
      this.jdField_a_of_type_Nky.a().k(paramnfv);
      return;
      String str = paramnfv.e() + 1 + "/" + paramnfv.f();
      this.jdField_a_of_type_Nky.a().b(str);
    }
  }
  
  public void c(nfv paramnfv)
  {
    a(nfc.a(paramnfv), true);
    a(paramnfv.a());
    this.jdField_a_of_type_Nky.a(this.jdField_a_of_type_Nkw.a(), paramnfv.a().f(), paramnfv.a().d());
    int i = paramnfv.a().f() - paramnfv.a().d() - 5000;
    if ((i > 0) && (this.jdField_a_of_type_Boolean)) {
      a(i);
    }
    if (QLog.isColorLevel()) {
      QLog.i("GuessStarStagePresenter", 2, "onSwitchTopic delayMs = " + i + ",topicDuration = " + paramnfv.a().f() + ",statusPassedTime = " + paramnfv.a().d());
    }
    if (paramnfv.a().a.a()) {
      this.jdField_a_of_type_Nky.a().a(paramnfv.a().a.c * 1000, paramnfv.a().e());
    }
    for (;;)
    {
      this.jdField_a_of_type_Nky.a().k(paramnfv);
      return;
      String str = paramnfv.e() + 1 + "/" + paramnfv.f();
      this.jdField_a_of_type_Nky.a().b(str);
    }
  }
  
  public void d(nfv paramnfv) {}
  
  public void e(nfv paramnfv) {}
  
  public void f(nfv paramnfv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nls
 * JD-Core Version:    0.7.0.1
 */