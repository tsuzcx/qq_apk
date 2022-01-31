import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;

public class pzp
  extends SecSvcObserver
{
  public pzp(DeviceMsgHandle paramDeviceMsgHandle) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (paramInt == 1)
      {
        EquipmentLockImpl.a().a(this.a.b, BaseApplicationImpl.getApplication(), this.a.b.getCurrentAccountUin(), true);
        return;
      }
      EquipmentLockImpl.a().a(this.a.b, BaseApplicationImpl.getApplication(), this.a.b.getCurrentAccountUin(), false);
      return;
    }
    EquipmentLockImpl.a().a(this.a.b, BaseApplicationImpl.getApplication(), this.a.b.getCurrentAccountUin(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pzp
 * JD-Core Version:    0.7.0.1
 */