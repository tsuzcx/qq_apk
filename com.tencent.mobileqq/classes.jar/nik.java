import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import mqq.util.WeakReference;

@RequiresApi(api=16)
public abstract class nik
  implements mok, mxb, ndb
{
  public int a;
  public String a;
  protected moi a;
  public WeakReference<Context> a;
  private mwx a;
  protected volatile boolean a;
  
  public nik(Context paramContext)
  {
    if (paramContext != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    }
    this.jdField_a_of_type_Moi = moi.a();
    this.jdField_a_of_type_JavaLangString = (a() + "_Base");
  }
  
  protected abstract String a();
  
  public void a() {}
  
  public void a(View paramView) {}
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    for (boolean bool = true;; bool = false)
    {
      bkdp.d(this.jdField_a_of_type_JavaLangString, "isDeviceSupport, sdk:" + Build.VERSION.SDK_INT);
      return bool;
    }
  }
  
  public String b()
  {
    String str = BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "QQGameVideo" + File.separator + System.currentTimeMillis() + ".mp4";
    File localFile = new File(str).getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public void b() {}
  
  public void b(View paramView) {}
  
  public boolean b()
  {
    boolean bool = true;
    if ((!a()) || (!c())) {
      bool = false;
    }
    bkdp.d(this.jdField_a_of_type_JavaLangString, "isSupportRecord. isSupport = " + bool);
    return bool;
  }
  
  public String c()
  {
    String str = BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "QQGameVideo" + File.separator + System.currentTimeMillis() + ".jpg";
    File localFile = new File(str).getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  public void c() {}
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_Moi.r <= this.jdField_a_of_type_Moi.d) {
        break label92;
      }
      this.jdField_a_of_type_Int = 2;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Moi.jdField_a_of_type_Int != 1) {
        this.jdField_a_of_type_Int = 4;
      }
      bkdp.d(this.jdField_a_of_type_JavaLangString, "isPerformanceSupport=" + this.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 1)) {
        break;
      }
      return true;
      label92:
      if ((this.jdField_a_of_type_Moi.r == this.jdField_a_of_type_Moi.d) && (this.jdField_a_of_type_Moi.s >= this.jdField_a_of_type_Moi.e)) {
        this.jdField_a_of_type_Int = 2;
      } else if (this.jdField_a_of_type_Moi.r > this.jdField_a_of_type_Moi.b) {
        this.jdField_a_of_type_Int = 1;
      } else if ((this.jdField_a_of_type_Moi.r == this.jdField_a_of_type_Moi.b) && (this.jdField_a_of_type_Moi.s >= this.jdField_a_of_type_Moi.c)) {
        this.jdField_a_of_type_Int = 1;
      } else {
        this.jdField_a_of_type_Int = 3;
      }
    }
    return false;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void e() {}
  
  public boolean e()
  {
    if (!b()) {
      return false;
    }
    bkdp.d(this.jdField_a_of_type_JavaLangString, "startRecord");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Mwx = mwx.a();
    this.jdField_a_of_type_Mwx.a(7, this);
    return true;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    if (!b()) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Mwx != null)
    {
      this.jdField_a_of_type_Mwx.f();
      this.jdField_a_of_type_Mwx = null;
    }
    bkdp.d(this.jdField_a_of_type_JavaLangString, "endRecord");
  }
  
  public void l() {}
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nik
 * JD-Core Version:    0.7.0.1
 */