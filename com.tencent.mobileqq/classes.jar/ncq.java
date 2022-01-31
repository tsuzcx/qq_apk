import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;

public class ncq
  implements LbsManager.LbsUpdateListener
{
  public ncq(AddressDataProvider paramAddressDataProvider) {}
  
  public void a(boolean paramBoolean, BasicLocation paramBasicLocation)
  {
    SLog.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramBasicLocation != null))
    {
      SLog.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramBasicLocation.b), Integer.valueOf(paramBasicLocation.a));
      this.a.a(paramBasicLocation.b, paramBasicLocation.a);
      return;
    }
    SLog.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncq
 * JD-Core Version:    0.7.0.1
 */