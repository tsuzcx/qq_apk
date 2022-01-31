import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class nxk
  implements rua
{
  private WeakReference<nxf> a;
  
  nxk(nxf paramnxf)
  {
    this.a = new WeakReference(paramnxf);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    nxf localnxf = (nxf)this.a.get();
    if (((localnxf == null) || (nxf.a(localnxf).a())) && (QLog.isColorLevel()))
    {
      QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
      return;
    }
    localnxf.a(paramChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nxk
 * JD-Core Version:    0.7.0.1
 */