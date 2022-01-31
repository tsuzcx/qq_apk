import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;

public class tds
  extends QQUIEventReceiver<tdn, ygc>
{
  private int a;
  
  tds(@NonNull tdn paramtdn, int paramInt)
  {
    super(paramtdn);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@NonNull tdn paramtdn, @NonNull ygc paramygc)
  {
    tlo.d("comment", "onEvent,commentEvent.mEventAction:" + paramygc.jdField_a_of_type_Int + ",WSHomeFragment.mCurrentPageIndex:" + WSHomeFragment.jdField_a_of_type_Int + ",mCurrentPageIndex:" + paramtdn.jdField_a_of_type_Int);
    if (WSHomeFragment.jdField_a_of_type_Int != paramtdn.jdField_a_of_type_Int) {
      tlo.d("comment", "commentPresenter 's hashCode:" + paramtdn.hashCode() + ", 页面不对,不响应!");
    }
    do
    {
      return;
      tlo.c("comment", "commentPresenter 's hashCode:" + paramtdn.hashCode() + ", 页面正确,开始响应~");
      switch (paramygc.jdField_a_of_type_Int)
      {
      case 3: 
      case 5: 
      default: 
        return;
      case 1: 
        paramtdn.a();
        return;
      case 2: 
        tdn.a(paramtdn);
        return;
      case 4: 
        if ((paramygc.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramygc = (Object[])paramygc.jdField_a_of_type_JavaLangObject;
          int i = ((Integer)paramygc[0]).intValue();
          paramtdn.a(i);
          paramygc = (stSimpleMetaFeed)((tmv)paramygc[1]).a();
          tlo.c("comment", "setCurrentFeed , feedId:" + paramygc.id + ", position:" + i + ",feed desc:" + paramygc.feed_desc);
          paramtdn.a(paramygc);
        }
        QZLog.w(this.TAG, "event page change, position:" + tdn.a(paramtdn) + " feedId:" + tdn.b(paramtdn));
        tdn.a(paramtdn, null);
        tdn.a(paramtdn, "");
        tdn.c(paramtdn, 0L);
        tdn.a(paramtdn, false);
      }
    } while (!tdn.e(paramtdn));
    tdn.a(paramtdn).a().removeMessages(11);
    paramygc = tdn.a(paramtdn).a().obtainMessage(11);
    tdn.a(paramtdn).a().sendMessageDelayed(paramygc, 20L);
    return;
    paramtdn.a((Object[])paramygc.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return ygc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tds
 * JD-Core Version:    0.7.0.1
 */