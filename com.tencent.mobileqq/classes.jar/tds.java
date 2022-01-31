import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;

public class tds
  extends QQUIEventReceiver<tdn, ybt>
{
  private int a;
  
  tds(@NonNull tdn paramtdn, int paramInt)
  {
    super(paramtdn);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@NonNull tdn paramtdn, @NonNull ybt paramybt)
  {
    tlo.d("comment", "onEvent,commentEvent.mEventAction:" + paramybt.jdField_a_of_type_Int + ",WSHomeFragment.mCurrentPageIndex:" + WSHomeFragment.jdField_a_of_type_Int + ",mCurrentPageIndex:" + paramtdn.jdField_a_of_type_Int);
    if (WSHomeFragment.jdField_a_of_type_Int != paramtdn.jdField_a_of_type_Int) {
      tlo.d("comment", "commentPresenter 's hashCode:" + paramtdn.hashCode() + ", 页面不对,不响应!");
    }
    do
    {
      return;
      tlo.c("comment", "commentPresenter 's hashCode:" + paramtdn.hashCode() + ", 页面正确,开始响应~");
      switch (paramybt.jdField_a_of_type_Int)
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
        if ((paramybt.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          paramybt = (Object[])paramybt.jdField_a_of_type_JavaLangObject;
          int i = ((Integer)paramybt[0]).intValue();
          paramtdn.a(i);
          paramybt = (stSimpleMetaFeed)((tmv)paramybt[1]).a();
          tlo.c("comment", "setCurrentFeed , feedId:" + paramybt.id + ", position:" + i + ",feed desc:" + paramybt.feed_desc);
          paramtdn.a(paramybt);
        }
        QZLog.w(this.TAG, "event page change, position:" + tdn.a(paramtdn) + " feedId:" + tdn.b(paramtdn));
        tdn.a(paramtdn, null);
        tdn.a(paramtdn, "");
        tdn.c(paramtdn, 0L);
        tdn.a(paramtdn, false);
      }
    } while (!tdn.e(paramtdn));
    tdn.a(paramtdn).a().removeMessages(11);
    paramybt = tdn.a(paramtdn).a().obtainMessage(11);
    tdn.a(paramtdn).a().sendMessageDelayed(paramybt, 20L);
    return;
    paramtdn.a((Object[])paramybt.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return ybt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tds
 * JD-Core Version:    0.7.0.1
 */