import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class oin
  implements sja
{
  private WeakReference<oii> a;
  
  oin(oii paramoii)
  {
    this.a = new WeakReference(paramoii);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    oii localoii = (oii)this.a.get();
    if (((localoii == null) || (oii.a(localoii).a())) && (QLog.isColorLevel()))
    {
      QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
      return;
    }
    localoii.a(paramChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oin
 * JD-Core Version:    0.7.0.1
 */