import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ncc
  implements nbl
{
  nbm jdField_a_of_type_Nbm;
  nbn jdField_a_of_type_Nbn;
  
  public ncc(nbm paramnbm)
  {
    this.jdField_a_of_type_Nbm = paramnbm;
  }
  
  public String a(Context paramContext, myc parammyc)
  {
    paramContext = "";
    Object localObject = parammyc.a();
    if (localObject == null)
    {
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131690271);
        QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
      }
      paramContext = parammyc.c();
      if (TextUtils.isEmpty(paramContext)) {
        break label108;
      }
      paramContext = paramContext + "\n";
    }
    for (;;)
    {
      return paramContext + (String)localObject;
      paramContext = ((myg)localObject).l;
      break;
      label108:
      QLog.e("GuessPictureStagePresenter", 1, "songTypeString tips isEmpty");
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
    return paramContext.getResources().getString(2131690270);
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
    String str = parammyc.e() + 1 + "/" + parammyc.f();
    this.jdField_a_of_type_Nbn.a().b(str);
    this.jdField_a_of_type_Nbn.a(this.jdField_a_of_type_Nbm.a(), parammyc.a().f(), parammyc.a().d());
    this.jdField_a_of_type_Nbn.a().k(parammyc);
  }
  
  public void c(myc parammyc)
  {
    a(mxl.a(parammyc), true);
    a(parammyc.a());
    this.jdField_a_of_type_Nbn.a(this.jdField_a_of_type_Nbm.a(), parammyc.a().f(), parammyc.a().d());
    String str = parammyc.e() + 1 + "/" + parammyc.f();
    this.jdField_a_of_type_Nbn.a().b(str);
    this.jdField_a_of_type_Nbn.a().k(parammyc);
  }
  
  public void d(myc parammyc) {}
  
  public void e(myc parammyc) {}
  
  public void f(myc parammyc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncc
 * JD-Core Version:    0.7.0.1
 */