import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class nui
  implements reh
{
  private WeakReference<nud> a;
  
  nui(nud paramnud)
  {
    this.a = new WeakReference(paramnud);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    nud localnud = (nud)this.a.get();
    if (((localnud == null) || (nud.a(localnud).a())) && (QLog.isColorLevel()))
    {
      QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
      return;
    }
    localnud.a(paramChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nui
 * JD-Core Version:    0.7.0.1
 */