package com.tencent.mobileqq.qwallet.hb.aio.elem;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RedPacketInfo
  extends RedPacketInfoBase
{
  public MessageRecord a;
  public long b;
  public boolean c;
  public String d;
  public Bitmap e;
  public int f;
  public boolean g;
  public ICustomizeStrategyFactory.AnimConfig h;
  public Drawable[] i;
  public boolean j = false;
  public String k;
  
  public boolean a()
  {
    Object localObject1;
    if (this.g)
    {
      localObject1 = this.i;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = this.h;
        if ((localObject1 != null) && (((ICustomizeStrategyFactory.AnimConfig)localObject1).c > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("RedPacketInfo", 2, "anim valid");
          }
          return true;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("anim invalid|");
      localStringBuilder.append(this.g);
      localStringBuilder.append("|");
      localObject1 = this.i;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(localObject1.length);
      } else {
        localObject1 = null;
      }
      localStringBuilder.append(localObject1);
      localStringBuilder.append("|");
      ICustomizeStrategyFactory.AnimConfig localAnimConfig = this.h;
      localObject1 = localObject2;
      if (localAnimConfig != null) {
        localObject1 = Integer.valueOf(localAnimConfig.c);
      }
      localStringBuilder.append(localObject1);
      QLog.d("RedPacketInfo", 2, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo
 * JD-Core Version:    0.7.0.1
 */