package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$10
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  FastWebActivity$10(FastWebActivity paramFastWebActivity) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadUserInfoFailed ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    QLog.e("FastWebActivity", 1, localStringBuilder.toString());
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    paramString = new StringBuilder();
    paramString.append("onLoadUserInfoSucceed ");
    paramString.append(paramReadInJoyUserInfo);
    QLog.d("FastWebActivity", 1, paramString.toString());
    if ((paramReadInJoyUserInfo != null) && (FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a) != null))
    {
      FastWebPTSDataConverter.a(this.a.a, FastWebActivity.a(this.a).c, paramReadInJoyUserInfo);
      FastWebRequestUtil.a(FastWebActivity.a(this.a), FastWebActivity.a(this.a));
      FastWebActivity.e(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.10
 * JD-Core Version:    0.7.0.1
 */