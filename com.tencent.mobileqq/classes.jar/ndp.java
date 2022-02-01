import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ndp
  implements ncy
{
  ncz jdField_a_of_type_Ncz;
  nda jdField_a_of_type_Nda;
  
  public ndp(ncz paramncz)
  {
    this.jdField_a_of_type_Ncz = paramncz;
  }
  
  public String a(Context paramContext, mze parammze)
  {
    paramContext = "";
    Object localObject = parammze.a();
    if (localObject == null)
    {
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131690277);
        QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
      }
      paramContext = parammze.c();
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
      paramContext = ((mzj)localObject).m;
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
    return paramContext.getResources().getString(2131690276);
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
    String str = parammze.e() + 1 + "/" + parammze.f();
    this.jdField_a_of_type_Nda.a().b(str);
    this.jdField_a_of_type_Nda.a(this.jdField_a_of_type_Ncz.a(), parammze.a().f(), parammze.a().d());
    this.jdField_a_of_type_Nda.a().k(parammze);
  }
  
  public void c(mze parammze)
  {
    a(myk.a(parammze), true);
    a(parammze.a());
    this.jdField_a_of_type_Nda.a(this.jdField_a_of_type_Ncz.a(), parammze.a().f(), parammze.a().d());
    String str = parammze.e() + 1 + "/" + parammze.f();
    this.jdField_a_of_type_Nda.a().b(str);
    this.jdField_a_of_type_Nda.a().k(parammze);
  }
  
  public void d(mze parammze) {}
  
  public void e(mze parammze) {}
  
  public void f(mze parammze) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndp
 * JD-Core Version:    0.7.0.1
 */