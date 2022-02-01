package com.tencent.mobileqq.equipmentlock;

import android.content.Context;
import android.text.format.Time;
import com.tencent.ims.devlock_mobile_phone.status;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class DevlockPhoneStatus
{
  public static int a = -1;
  private static DevlockPhoneStatus jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus;
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  private long jdField_a_of_type_Long = 0L;
  private int f = -1;
  
  public static DevlockPhoneStatus a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus == null) {
      jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus = new DevlockPhoneStatus();
    }
    return jdField_a_of_type_ComTencentMobileqqEquipmentlockDevlockPhoneStatus;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pre:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" now:");
      localStringBuilder.append(paramInt);
      QLog.d("DevlockPhoneStatus", 2, localStringBuilder.toString());
    }
    this.f = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext, String paramString)
  {
    DevlockPhoneStatus.1 local1 = new DevlockPhoneStatus.1(this);
    String str2 = paramContext.getString(2131692030);
    String str1 = paramContext.getString(2131692016);
    long l = this.jdField_a_of_type_Long * 1000L;
    Object localObject;
    if (l > 0L)
    {
      localObject = new Time();
      ((Time)localObject).set(l);
      localObject = String.format(paramContext.getString(2131692028), new Object[] { Integer.valueOf(((Time)localObject).year), Integer.valueOf(((Time)localObject).month + 1), Integer.valueOf(((Time)localObject).monthDay), Integer.valueOf(((Time)localObject).hour), Integer.valueOf(((Time)localObject).minute) });
    }
    else
    {
      localObject = paramContext.getString(2131692029);
    }
    paramContext = DialogUtil.a(paramContext, 230, str2, String.format(paramContext.getString(2131692027), new Object[] { paramString, localObject }), null, local1);
    if (paramContext != null)
    {
      paramContext.setNegativeButton(str1, local1);
      paramContext.show();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.f = jdField_a_of_type_Int;
    this.jdField_a_of_type_Long = 0L;
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockPhoneStatus", 2, "info is null");
      }
      return;
    }
    try
    {
      devlock_mobile_phone.status localstatus = new devlock_mobile_phone.status();
      localstatus.mergeFrom(paramArrayOfByte);
      if (localstatus.u32_mb_mobile_state.has()) {
        this.f = localstatus.u32_mb_mobile_state.get();
      }
      if (localstatus.u32_audit_time.has())
      {
        this.jdField_a_of_type_Long = localstatus.u32_audit_time.get();
        return;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockPhoneStatus", 2, "exception occurs");
      }
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus
 * JD-Core Version:    0.7.0.1
 */