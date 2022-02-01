import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class nes
  implements ned
{
  nee jdField_a_of_type_Nee;
  neg jdField_a_of_type_Neg;
  
  public nes(nee paramnee)
  {
    this.jdField_a_of_type_Nee = paramnee;
  }
  
  public String a(Context paramContext, naf paramnaf)
  {
    paramnaf = paramnaf.a();
    paramContext = null;
    if (paramnaf != null)
    {
      if (paramnaf.a != 2) {
        break label54;
      }
      paramContext = BaseApplicationImpl.getContext().getResources().getString(2131690299);
    }
    for (;;)
    {
      paramnaf = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        paramnaf = BaseApplicationImpl.getContext().getResources().getString(2131690299);
      }
      return paramnaf;
      label54:
      paramContext = paramnaf.m;
      paramnaf = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        paramnaf = paramContext;
        if (paramContext.contains("\\n")) {
          paramnaf = paramContext.replace("\\n", "\n");
        }
      }
      paramContext = paramnaf;
      if (QLog.isColorLevel())
      {
        QLog.d("GuessPictureStagePresenter", 2, "getGamePrepareBottomTip result = " + paramnaf);
        paramContext = paramnaf;
      }
    }
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
    return paramContext.getResources().getString(2131690300);
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
    a(mzl.a().a(), false);
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
    a(mzl.a().a(), true);
    a(paramnaf.a());
    this.jdField_a_of_type_Neg.a().d(true);
    this.jdField_a_of_type_Neg.a().a(paramnaf.a().a.c * 1000, paramnaf.a().e());
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_Nee.a(), paramnaf.a().a.e * 1000, paramnaf.a().d());
  }
  
  public void c(naf paramnaf)
  {
    a(mzl.a().a(), true);
    a(paramnaf.a());
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_Nee.a(), paramnaf.a().a.e * 1000, paramnaf.a().d());
    this.jdField_a_of_type_Neg.a().a(paramnaf.a().a.c * 1000, paramnaf.a().e());
  }
  
  public void d(naf paramnaf) {}
  
  public void e(naf paramnaf) {}
  
  public void f(naf paramnaf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nes
 * JD-Core Version:    0.7.0.1
 */