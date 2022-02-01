package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;

class BaseAuthorityAccountView$5$1
  implements Runnable
{
  BaseAuthorityAccountView$5$1(BaseAuthorityAccountView.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (this.a != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->updateAccountFace success uin = ");
      localStringBuilder.append(AuthorityUtil.a(this.b.a));
      SSOLog.a("BaseAuthorityAccountView", new Object[] { localStringBuilder.toString() });
      this.b.b.setImageBitmap(this.a);
      return;
    }
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->updateAccountFace use default uin = ");
      localStringBuilder.append(AuthorityUtil.a(this.b.a));
      SSOLog.a("BaseAuthorityAccountView", new Object[] { localStringBuilder.toString() });
      this.b.b.setImageBitmap(BitmapFactory.decodeResource(this.b.this$0.getResources(), 2130841444));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label140:
      break label140;
    }
    SSOLog.b("BaseAuthorityAccountView", new Object[] { "-->updateAccountFace oom uin = AuthorityUtil.getSimpleUin(uin)" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.5.1
 * JD-Core Version:    0.7.0.1
 */