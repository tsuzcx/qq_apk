package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ShareMsgImpl$1$1
  implements Runnable
{
  ShareMsgImpl$1$1(ShareMsgImpl.1 param1, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Activity localActivity = this.d.this$0.n;
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      try
      {
        if ("1".equals(this.d.e))
        {
          this.d.this$0.a(this.d.f, this.d.e, this.d.g, this.d.h, this.a, this.b, this.d.i, this.c);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1002, this.d.b, this.d.j, this.d.k, this.d.l);
          return;
        }
        boolean bool = "2".equals(this.d.e);
        if ((!bool) && (!"3".equals(this.d.e)))
        {
          if ("4".equals(this.d.e))
          {
            this.d.this$0.b(this.d.g, this.d.h, this.a, this.b);
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1005, this.d.b, this.d.j, this.d.k, this.d.l);
            return;
          }
          if ("5".equals(this.d.e))
          {
            this.d.this$0.a(this.d.g, this.d.h, this.a, this.b, 6);
            return;
          }
          if ("6".equals(this.d.e))
          {
            this.d.this$0.a(this.d.g, this.d.h, this.a, this.b, 7);
            return;
          }
          if ((!TextUtils.isEmpty(this.d.n)) && (this.d.f.has("is_tribe_short_video")) && (this.d.n.equals("true")))
          {
            this.d.this$0.b(this.d.f, this.d.e, this.d.g, this.d.h, this.d.b, this.d.c, this.d.i, this.d.d, this.d.o);
            return;
          }
          this.d.this$0.c(this.d.f, this.d.e, this.d.g, this.d.h, this.a, this.b, this.d.i, this.c, this.d.o);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, this.d.b, this.d.j, this.d.k, this.d.l);
          return;
        }
        this.d.this$0.a(this.d.f, this.d.e, this.d.g, this.d.h, this.a, this.b, this.d.i, this.c, this.d.m);
        if ("2".equals(this.d.e)) {
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, this.d.b, this.d.j, this.d.k, this.d.l);
        }
        if ("3".equals(this.d.e))
        {
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, this.d.b, this.d.j, this.d.k, this.d.l);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("shareMsg error: ");
          localStringBuilder.append(localJSONException.toString());
          QLog.d("ShareMsgImpl", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.1.1
 * JD-Core Version:    0.7.0.1
 */