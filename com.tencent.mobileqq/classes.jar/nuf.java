import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class nuf
  implements ree
{
  private WeakReference<nua> a;
  
  nuf(nua paramnua)
  {
    this.a = new WeakReference(paramnua);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    nua localnua = (nua)this.a.get();
    if (((localnua == null) || (nua.a(localnua).a())) && (QLog.isColorLevel()))
    {
      QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
      return;
    }
    localnua.a(paramChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuf
 * JD-Core Version:    0.7.0.1
 */