package com.tencent.securemodule;

import android.content.Intent;
import com.tencent.securemodule.impl.AppInfo;
import com.tencent.securemodule.impl.SecureService;
import java.util.ArrayList;

public class ab
  extends y
{
  private int b = 0;
  
  public ab(SecureService paramSecureService) {}
  
  public void a()
  {
    SecureService.a(this.a, "1000020", null);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(ArrayList<AppInfo> paramArrayList)
  {
    Object localObject;
    if (paramArrayList.size() > 0)
    {
      SecureService.a(this.a, "1000022", paramArrayList);
      localObject = new Intent();
      ((Intent)localObject).setAction("1000030");
      ((Intent)localObject).putExtra("key_rise", paramArrayList);
      this.a.sendBroadcast((Intent)localObject);
      return;
    }
    if (this.b != 0)
    {
      localObject = this.a;
      paramArrayList = "1000023";
    }
    else
    {
      localObject = this.a;
      paramArrayList = "1000021";
    }
    SecureService.a((SecureService)localObject, paramArrayList, null);
    paramArrayList = new Intent();
    paramArrayList.setAction("1000031");
    paramArrayList.putExtra("key_errcode", this.b);
    this.a.sendBroadcast(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.ab
 * JD-Core Version:    0.7.0.1
 */