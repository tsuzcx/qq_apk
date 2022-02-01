import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class nbz
  implements nbl
{
  nbm jdField_a_of_type_Nbm;
  nbn jdField_a_of_type_Nbn;
  
  public nbz(nbm paramnbm)
  {
    this.jdField_a_of_type_Nbm = paramnbm;
  }
  
  public String a(Context paramContext, myc parammyc)
  {
    parammyc = parammyc.a();
    paramContext = null;
    if (parammyc != null)
    {
      if (parammyc.a != 2) {
        break label54;
      }
      paramContext = BaseApplicationImpl.getContext().getResources().getString(2131690268);
    }
    for (;;)
    {
      parammyc = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        parammyc = BaseApplicationImpl.getContext().getResources().getString(2131690268);
      }
      return parammyc;
      label54:
      paramContext = parammyc.l;
      parammyc = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        parammyc = paramContext;
        if (paramContext.contains("\\n")) {
          parammyc = paramContext.replace("\\n", "\n");
        }
      }
      paramContext = parammyc;
      if (QLog.isColorLevel())
      {
        QLog.d("GuessPictureStagePresenter", 2, "getGamePrepareBottomTip result = " + parammyc);
        paramContext = parammyc;
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
    return paramContext.getResources().getString(2131690269);
  }
  
  public nbn a()
  {
    return this.jdField_a_of_type_Nbn;
  }
  
  public void a(mxq parammxq)
  {
    this.jdField_a_of_type_Nbm.a(parammxq);
  }
  
  public void a(myc parammyc)
  {
    a(mxl.a(parammyc), false);
    this.jdField_a_of_type_Nbn.a().d(false);
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
    this.jdField_a_of_type_Nbn.a().a(parammyc.a().a.c * 1000, parammyc.a().e());
    this.jdField_a_of_type_Nbn.a(this.jdField_a_of_type_Nbm.a(), parammyc.a().a.e * 1000, parammyc.a().d());
  }
  
  public void c(myc parammyc)
  {
    a(mxl.a(parammyc), true);
    a(parammyc.a());
    this.jdField_a_of_type_Nbn.a(this.jdField_a_of_type_Nbm.a(), parammyc.a().a.e * 1000, parammyc.a().d());
    this.jdField_a_of_type_Nbn.a().a(parammyc.a().a.c * 1000, parammyc.a().e());
  }
  
  public void d(myc parammyc) {}
  
  public void e(myc parammyc) {}
  
  public void f(myc parammyc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbz
 * JD-Core Version:    0.7.0.1
 */