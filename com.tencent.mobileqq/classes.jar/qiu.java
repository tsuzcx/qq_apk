import android.content.Context;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtHttpPost;
import com.tencent.gdtad.aditem.GdtHttpPost.Listener;
import com.tencent.gdtad.aditem.GdtHttpPost.Params;
import java.lang.ref.WeakReference;
import java.util.Set;
import tencent.gdt.qq_ad_get.QQAdGet;

public class qiu
{
  private GdtAdLoader.Session jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session;
  private GdtHttpPost.Listener jdField_a_of_type_ComTencentGdtadAditemGdtHttpPost$Listener = new qiv(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public qiu(GdtAdLoader.Session paramSession, WeakReference paramWeakReference)
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
      paramContext = new GdtHttpPost.Params();
      paramContext.a("https://mi.gdt.qq.com/rpc/gdt.display.QQAdService.GetAds");
      paramContext.jdField_a_of_type_JavaLangString = "application/x-protobuf";
      paramContext.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session.a.toByteArray();
    } while (!paramContext.a());
    GdtHttpPost.a(paramContext, new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtHttpPost$Listener));
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((GdtAdLoader.Listener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Session);
    }
    GdtAdLoader.a().remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qiu
 * JD-Core Version:    0.7.0.1
 */