package com.tencent.mobileqq.kandian.biz.detail;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyArticleDetailActivity$4
  implements ITroopMemberApiClientApi.Callback
{
  ReadInJoyArticleDetailActivity$4(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public void callback(Bundle paramBundle)
  {
    synchronized (this.a.j)
    {
      ReadInJoyArticleDetailActivity.a(this.a, paramBundle.getByteArray("decryptResult"));
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("请求返回时间");
        paramBundle.append(System.currentTimeMillis());
        QLog.d("ReadInJoyArticleDetail", 2, paramBundle.toString());
      }
      if (ReadInJoyArticleDetailActivity.a(this.a) == null) {
        this.a.a = null;
      }
      this.a.j.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.4
 * JD-Core Version:    0.7.0.1
 */