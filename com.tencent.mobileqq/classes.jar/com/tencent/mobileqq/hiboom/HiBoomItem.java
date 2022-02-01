package com.tencent.mobileqq.hiboom;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class HiBoomItem
{
  public int a;
  public String b;
  public int c;
  public long d;
  public String e;
  public boolean f;
  public Bitmap g;
  public Bitmap h;
  public AtomicBoolean i = new AtomicBoolean(false);
  public int j;
  public boolean k;
  
  public int a()
  {
    boolean bool = TextUtils.isEmpty(this.e);
    int m = 1;
    Object localObject;
    if (!bool)
    {
      if (this.e.startsWith("act")) {
        break label143;
      }
      if (this.e.startsWith("free"))
      {
        localObject = this.e.split("-");
        if ((localObject.length >= 3) && (!TextUtils.isEmpty(localObject[1])) && (TextUtils.isDigitsOnly(localObject[1])) && (!TextUtils.isEmpty(localObject[2])) && (TextUtils.isDigitsOnly(localObject[2])))
        {
          long l1 = Long.parseLong(localObject[1]);
          long l2 = Long.parseLong(localObject[2]);
          long l3 = NetConnInfoCenter.getServerTime();
          if ((l3 > l1) && (l3 < l2))
          {
            m = 2;
            break label143;
          }
        }
      }
    }
    m = 0;
    label143:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTagType id = ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" type = ");
      ((StringBuilder)localObject).append(m);
      QLog.d("HiBoomFont.Item", 2, ((StringBuilder)localObject).toString());
    }
    return m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiBoomItem: id = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" name = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" engine = ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomItem
 * JD-Core Version:    0.7.0.1
 */