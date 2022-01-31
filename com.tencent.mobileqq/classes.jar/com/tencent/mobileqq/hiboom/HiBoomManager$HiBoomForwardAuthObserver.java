package com.tencent.mobileqq.hiboom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class HiBoomManager$HiBoomForwardAuthObserver
  extends SVIPObserver
{
  private Context a;
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    int j = -1;
    Object localObject = HiBoomManager.a(this.a);
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      ((QQProgressDialog)localObject).dismiss();
    }
    if (!paramBoolean) {
      QQToast.a(this.a, 1, "转发失败", 0).a();
    }
    do
    {
      return;
      if (!(paramObject instanceof Object[])) {
        break;
      }
      localObject = (Object[])paramObject;
    } while (localObject.length < 4);
    int i;
    if ((localObject[0] instanceof Integer))
    {
      i = ((Integer)localObject[0]).intValue();
      if (!(localObject[1] instanceof byte[])) {
        break label178;
      }
      paramObject = (byte[])localObject[1];
      label115:
      if ((localObject[2] instanceof Integer)) {
        j = ((Integer)localObject[2]).intValue();
      }
      if (!(localObject[3] instanceof String)) {
        break label183;
      }
      localObject = (String)localObject[3];
    }
    for (;;)
    {
      if (i != 0)
      {
        if (paramObject != null)
        {
          HiBoomManager.a(this.a, paramObject);
          return;
          i = -1;
          break;
          label178:
          paramObject = null;
          break label115;
          label183:
          localObject = null;
          continue;
        }
        QQToast.a(this.a, 1, "转发失败", 0).a();
        return;
      }
    }
    paramObject = new Bundle();
    paramObject.putInt("forward_type", 37);
    paramObject.putInt("emoInputType", 5);
    paramObject.putString("forward_text", (String)localObject);
    paramObject.putInt("key_hiboom_id", j);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramObject);
    ForwardBaseOption.a((Activity)this.a, (Intent)localObject, 21);
    return;
    QQToast.a(this.a, 1, "转发失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomManager.HiBoomForwardAuthObserver
 * JD-Core Version:    0.7.0.1
 */