package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class TroopAuditObserver
  implements BusinessObserver
{
  public static final int a;
  public static final int b;
  private static int c;
  
  static
  {
    int i = c;
    c = i + 1;
    a = i;
    i = c;
    c = i + 1;
    b = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != a) {
      return;
    }
    try
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (oidb_0x88d.GroupInfo)paramObject[4]);
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("oidb_0x91a_1", 2, paramObject.toString());
      }
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject != null) && (paramObject.length > 1))
    {
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    }
    a(paramBoolean, -1, "");
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, oidb_0x88d.GroupInfo paramGroupInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.observer.TroopAuditObserver
 * JD-Core Version:    0.7.0.1
 */