import android.os.Handler;
import android.os.Looper;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.1;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.2;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.3;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.4;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.5;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class lhf
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  String jdField_a_of_type_JavaLangString;
  public WeakReference<lhg> a;
  public lhi a;
  public volatile boolean a;
  WeakReference<lhh> b;
  
  public lhf()
  {
    this.jdField_a_of_type_Boolean = false;
    c();
  }
  
  public abstract int a();
  
  public void a()
  {
    d();
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Lhi.a();
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
  
  public void a(lhg paramlhg)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramlhg);
  }
  
  public void a(lhh paramlhh)
  {
    if (paramlhh != null)
    {
      this.b = new WeakReference(paramlhh);
      return;
    }
    this.b = null;
  }
  
  public void a(lhi paramlhi)
  {
    this.jdField_a_of_type_Lhi = paramlhi;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Lhi.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhf
 * JD-Core Version:    0.7.0.1
 */