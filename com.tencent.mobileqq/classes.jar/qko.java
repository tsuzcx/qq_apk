import android.content.Context;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.net.GdtHttp;
import com.tencent.gdtad.net.GdtHttp.Listener;
import com.tencent.gdtad.net.GdtHttp.Params;
import java.lang.ref.WeakReference;
import java.util.Set;
import tencent.gdt.qq_ad_get.QQAdGet;

public class qko
{
  private GdtAdLoader.Session jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session;
  private GdtHttp.Listener jdField_a_of_type_ComTencentGdtadNetGdtHttp$Listener = new qkp(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public qko(GdtAdLoader.Session paramSession, WeakReference paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session = paramSession;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private void a(Context paramContext)
  {
    GdtAdLoader.a().add(this);
    if ((paramContext == null) || (this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session == null) || (!this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session.a())) {}
    do
    {
      a();
      return;
      GdtAdLoader.a(paramContext, this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session.a.device_info);
      paramContext = new GdtHttp.Params();
      paramContext.a("https://mi.gdt.qq.com/rpc/gdt.display.QQAdService.GetAds");
      paramContext.jdField_a_of_type_JavaLangString = "POST";
      paramContext.b = "application/x-protobuf";
      paramContext.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session.a.toByteArray();
    } while (!paramContext.a());
    GdtHttp.a(paramContext, new WeakReference(this.jdField_a_of_type_ComTencentGdtadNetGdtHttp$Listener));
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((GdtAdLoader.Listener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session);
    }
    GdtAdLoader.a().remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qko
 * JD-Core Version:    0.7.0.1
 */