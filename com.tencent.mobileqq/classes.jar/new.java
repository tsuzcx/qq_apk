import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class new
  implements ned
{
  nee jdField_a_of_type_Nee;
  neg jdField_a_of_type_Neg;
  
  public new(nee paramnee)
  {
    this.jdField_a_of_type_Nee = paramnee;
  }
  
  public String a(Context paramContext, naf paramnaf)
  {
    paramContext = "";
    Object localObject = paramnaf.a();
    if (localObject == null)
    {
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131690302);
        QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
      }
      paramContext = paramnaf.c();
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
      paramContext = ((nak)localObject).m;
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
    return paramContext.getResources().getString(2131690301);
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
    this.jdField_a_of_type_Neg.a().k(paramnaf);
  }
  
  public void c(naf paramnaf)
  {
    a(mzl.a(paramnaf), true);
    a(paramnaf.a());
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_Nee.a(), paramnaf.a().f(), paramnaf.a().d());
    String str = paramnaf.e() + 1 + "/" + paramnaf.f();
    this.jdField_a_of_type_Neg.a().b(str);
    this.jdField_a_of_type_Neg.a().k(paramnaf);
  }
  
  public void d(naf paramnaf) {}
  
  public void e(naf paramnaf) {}
  
  public void f(naf paramnaf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     new
 * JD-Core Version:    0.7.0.1
 */