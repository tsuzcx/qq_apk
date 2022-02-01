import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ndm
  implements ncy
{
  ncz jdField_a_of_type_Ncz;
  nda jdField_a_of_type_Nda;
  
  public ndm(ncz paramncz)
  {
    this.jdField_a_of_type_Ncz = paramncz;
  }
  
  public String a(Context paramContext, mze parammze)
  {
    parammze = parammze.a();
    paramContext = null;
    if (parammze != null)
    {
      if (parammze.a != 2) {
        break label54;
      }
      paramContext = BaseApplicationImpl.getContext().getResources().getString(2131690274);
    }
    for (;;)
    {
      parammze = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        parammze = BaseApplicationImpl.getContext().getResources().getString(2131690274);
      }
      return parammze;
      label54:
      paramContext = parammze.m;
      parammze = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        parammze = paramContext;
        if (paramContext.contains("\\n")) {
          parammze = paramContext.replace("\\n", "\n");
        }
      }
      paramContext = parammze;
      if (QLog.isColorLevel())
      {
        QLog.d("GuessPictureStagePresenter", 2, "getGamePrepareBottomTip result = " + parammze);
        paramContext = parammze;
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
    return paramContext.getResources().getString(2131690275);
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
    this.jdField_a_of_type_Nda.a().a(parammze.a().a.c * 1000, parammze.a().e());
    this.jdField_a_of_type_Nda.a(this.jdField_a_of_type_Ncz.a(), parammze.a().a.e * 1000, parammze.a().d());
  }
  
  public void c(mze parammze)
  {
    a(myk.a(parammze), true);
    a(parammze.a());
    this.jdField_a_of_type_Nda.a(this.jdField_a_of_type_Ncz.a(), parammze.a().a.e * 1000, parammze.a().d());
    this.jdField_a_of_type_Nda.a().a(parammze.a().a.c * 1000, parammze.a().e());
  }
  
  public void d(mze parammze) {}
  
  public void e(mze parammze) {}
  
  public void f(mze parammze) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndm
 * JD-Core Version:    0.7.0.1
 */