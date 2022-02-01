import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ohf
  implements srw
{
  private WeakReference<oha> a;
  
  ohf(oha paramoha)
  {
    this.a = new WeakReference(paramoha);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    oha localoha = (oha)this.a.get();
    if (((localoha == null) || (oha.a(localoha).a())) && (QLog.isColorLevel()))
    {
      QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
      return;
    }
    localoha.a(paramChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohf
 * JD-Core Version:    0.7.0.1
 */