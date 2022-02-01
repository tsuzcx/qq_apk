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
    if (this.a.p != null)
    {
      this.a.p.putString("cmd", "ipc_signature_setordelete");
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
      this.a.p.putBundle("response", paramRichStatus);
      paramRichStatus = this.a;
      paramRichStatus.a(paramRichStatus.p);
      this.a.p = null;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1)
    {
      if (this.a.r != null) {
        this.a.r.post(new MessengerService.9.1(this));
      }
    }
    else if (this.a.q != null)
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
      this.a.q.putBundle("response", (Bundle)localObject);
      localObject = this.a;
      ((MessengerService)localObject).a(((MessengerService)localObject).q);
      this.a.q = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.9
 * JD-Core Version:    0.7.0.1
 */