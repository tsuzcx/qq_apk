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
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  private static DevlockPhoneStatus h;
  private int f = -1;
  private long g = 0L;
  
  public static DevlockPhoneStatus a()
  {
    if (h == null) {
      h = new DevlockPhoneStatus();
    }
    return h;
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
    this.g = paramLong;
  }
  
  public void a(Context paramContext, String paramString)
  {
    DevlockPhoneStatus.1 local1 = new DevlockPhoneStatus.1(this);
    String str2 = paramContext.getString(2131888997);
    String str1 = paramContext.getString(2131888983);
    long l = this.g * 1000L;
    Object localObject;
    if (l > 0L)
    {
      localObject = new Time();
      ((Time)localObject).set(l);
      localObject = String.format(paramContext.getString(2131888995), new Object[] { Integer.valueOf(((Time)localObject).year), Integer.valueOf(((Time)localObject).month + 1), Integer.valueOf(((Time)localObject).monthDay), Integer.valueOf(((Time)localObject).hour), Integer.valueOf(((Time)localObject).minute) });
    }
    else
    {
      localObject = paramContext.getString(2131888996);
    }
    paramContext = DialogUtil.a(paramContext, 230, str2, String.format(paramContext.getString(2131888994), new Object[] { paramString, localObject }), null, local1);
    if (paramContext != null)
    {
      paramContext.setNegativeButton(str1, local1);
      paramContext.show();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.f = a;
    this.g = 0L;
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
        this.g = localstatus.u32_audit_time.get();
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
  
  public int b()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus
 * JD-Core Version:    0.7.0.1
 */