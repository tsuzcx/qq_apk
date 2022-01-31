import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationAdapter.ChannelButtonListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lba
  implements ReadInJoyNavigationAdapter.ChannelButtonListener
{
  private WeakReference a;
  
  public lba(ReadInJoyNaviController paramReadInJoyNaviController)
  {
    this.a = new WeakReference(paramReadInJoyNaviController);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    ReadInJoyNaviController localReadInJoyNaviController = (ReadInJoyNaviController)this.a.get();
    if (((localReadInJoyNaviController == null) || (ReadInJoyNaviController.a(localReadInJoyNaviController).a())) && (QLog.isColorLevel()))
    {
      QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
      return;
    }
    localReadInJoyNaviController.a(paramChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lba
 * JD-Core Version:    0.7.0.1
 */