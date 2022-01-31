import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class niy
  implements qrv
{
  private WeakReference<nit> a;
  
  niy(nit paramnit)
  {
    this.a = new WeakReference(paramnit);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    nit localnit = (nit)this.a.get();
    if (((localnit == null) || (nit.a(localnit).a())) && (QLog.isColorLevel()))
    {
      QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
      return;
    }
    localnit.a(paramChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     niy
 * JD-Core Version:    0.7.0.1
 */