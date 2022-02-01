package com.tencent.mobileqq.qwallet.hb.aio.elem;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class RedPacketInfo
  extends RedPacketInfoBase
{
  public int a;
  public long a;
  public Bitmap a;
  public MessageRecord a;
  public ICustomizeStrategyFactory.AnimConfig a;
  public String a;
  public boolean a;
  public Drawable[] a;
  public String b;
  public boolean b;
  public boolean c = false;
  
  public boolean a()
  {
    Object localObject1;
    if (this.b)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$AnimConfig;
        if ((localObject1 != null) && (((ICustomizeStrategyFactory.AnimConfig)localObject1).b > 0))
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
      localStringBuilder.append(this.b);
      localStringBuilder.append("|");
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(localObject1.length);
      } else {
        localObject1 = null;
      }
      localStringBuilder.append(localObject1);
      localStringBuilder.append("|");
      ICustomizeStrategyFactory.AnimConfig localAnimConfig = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemICustomizeStrategyFactory$AnimConfig;
      localObject1 = localObject2;
      if (localAnimConfig != null) {
        localObject1 = Integer.valueOf(localAnimConfig.b);
      }
      localStringBuilder.append(localObject1);
      QLog.d("RedPacketInfo", 2, localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo
 * JD-Core Version:    0.7.0.1
 */