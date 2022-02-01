import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class orx
  implements tar
{
  private WeakReference<ors> a;
  
  orx(ors paramors)
  {
    this.a = new WeakReference(paramors);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    ors localors = (ors)this.a.get();
    if ((localors == null) || (ors.a(localors).a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
      }
      return;
    }
    localors.a(paramChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orx
 * JD-Core Version:    0.7.0.1
 */