import android.os.Handler;
import android.os.Looper;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.1;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.2;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.3;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.4;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.5;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class lkc
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  String jdField_a_of_type_JavaLangString;
  public WeakReference<lkd> a;
  public lkf a;
  public volatile boolean a;
  WeakReference<lke> b;
  
  public lkc()
  {
    this.jdField_a_of_type_Boolean = false;
    c();
  }
  
  public abstract int a();
  
  public void a()
  {
    d();
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Lkf.a();
    }
    try
    {
      new Thread(new MagicfaceBaseDecoder.1(this)).start();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MagicfaceBaseDecoder", 1, "startDecoder err:" + localOutOfMemoryError.getMessage());
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceBaseDecoder.3(this, paramString, paramInt));
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceBaseDecoder.4(this, paramString, paramBoolean));
    }
  }
  
  public void a(lkd paramlkd)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramlkd);
  }
  
  public void a(lke paramlke)
  {
    if (paramlke != null)
    {
      this.b = new WeakReference(paramlke);
      return;
    }
    this.b = null;
  }
  
  public void a(lkf paramlkf)
  {
    this.jdField_a_of_type_Lkf = paramlkf;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Lkf.b();
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceBaseDecoder.2(this, paramString));
    }
  }
  
  protected void c() {}
  
  protected void c(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceBaseDecoder.5(this, paramString));
    }
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lkc
 * JD-Core Version:    0.7.0.1
 */