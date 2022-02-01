import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class oka
  implements sng
{
  private WeakReference<ojv> a;
  
  oka(ojv paramojv)
  {
    this.a = new WeakReference(paramojv);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    ojv localojv = (ojv)this.a.get();
    if ((localojv == null) || (ojv.a(localojv).a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
      }
      return;
    }
    localojv.a(paramChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oka
 * JD-Core Version:    0.7.0.1
 */