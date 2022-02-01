import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class nlo
  implements nkv
{
  nkw jdField_a_of_type_Nkw;
  nky jdField_a_of_type_Nky;
  
  public nlo(nkw paramnkw)
  {
    this.jdField_a_of_type_Nkw = paramnkw;
  }
  
  public String a(Context paramContext, nfv paramnfv)
  {
    paramContext = "";
    Object localObject = paramnfv.a();
    if (localObject == null)
    {
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131690341);
        QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
      }
      paramContext = paramnfv.c();
      if (TextUtils.isEmpty(paramContext)) {
        break label98;
      }
      paramContext = paramContext + "\n";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext)) {
        break label109;
      }
      return localObject;
      paramContext = ((nga)localObject).m;
      break;
      label98:
      QLog.e("GuessPictureStagePresenter", 1, "songTypeString tips isEmpty");
    }
    label109:
    return paramContext + (String)localObject;
  }
  
  public String a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessPictureStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    return paramContext.getResources().getString(2131690340);
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
 * Qualified Name:     nlo
 * JD-Core Version:    0.7.0.1
 */