package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.qphone.base.util.QLog;

class MessengerService$9
  implements IStatusListener
{
  MessengerService$9(MessengerService paramMessengerService) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject)
  {
    if (this.a.b != null)
    {
      this.a.b.putString("cmd", "ipc_signature_setordelete");
      paramRichStatus = new Bundle();
      paramRichStatus.putInt("result", paramInt);
      paramRichStatus.putBoolean("hasTipsInfo", false);
      if ((paramObject instanceof TipsInfo))
      {
        paramObject = (TipsInfo)paramObject;
        if (paramObject.type > 0)
        {
          paramRichStatus.putInt("result", paramObject.ret);
          paramRichStatus.putBoolean("hasTipsInfo", true);
          paramRichStatus.putInt("tips_type", paramObject.type);
          paramRichStatus.putString("tips_titleWording", paramObject.titleWording);
          paramRichStatus.putString("tips_wording", paramObject.wording);
          paramRichStatus.putString("tips_rightBtnWording", paramObject.rightBtnWording);
          paramRichStatus.putString("tips_leftBtnWording", paramObject.leftBtnWording);
          paramRichStatus.putString("tips_vipType", paramObject.vipType);
          paramRichStatus.putInt("tips_vipMonth", paramObject.vipMonth);
          paramRichStatus.putString("tips_url", paramObject.url);
        }
      }
      this.a.b.putBundle("response", paramRichStatus);
      paramRichStatus = this.a;
      paramRichStatus.a(paramRichStatus.b);
      this.a.b = null;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1)
    {
      if (this.a.a != null) {
        this.a.a.post(new MessengerService.9.1(this));
      }
    }
    else if (this.a.c != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isSync: ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("SigImg2Zone", 4, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("isSync", paramBoolean);
      this.a.c.putBundle("response", (Bundle)localObject);
      localObject = this.a;
      ((MessengerService)localObject).a(((MessengerService)localObject).c);
      this.a.c = null;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.9
 * JD-Core Version:    0.7.0.1
 */