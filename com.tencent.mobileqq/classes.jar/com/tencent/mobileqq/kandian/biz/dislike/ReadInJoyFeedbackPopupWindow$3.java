package com.tencent.mobileqq.kandian.biz.dislike;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ReadInJoyFeedbackPopupWindow$3
  implements Runnable
{
  ReadInJoyFeedbackPopupWindow$3(ReadInJoyFeedbackPopupWindow paramReadInJoyFeedbackPopupWindow) {}
  
  public void run()
  {
    if (!ReadInJoyFeedbackPopupWindow.a(this.this$0, "reportFeeds")) {
      return;
    }
    Object localObject1 = RIJJumpUtils.a(ReadInJoyFeedbackPopupWindow.c(this.this$0));
    String str1 = RIJQQAppInterfaceUtil.d();
    String str2 = String.valueOf(ReadInJoyFeedbackPopupWindow.c(this.this$0).publishUin);
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "reportFeeds, shareUrl = ", localObject1, ", uin = ", RIJLogUtil.a.a(str1), ", publicUin = ", str2 });
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    boolean bool = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher((CharSequence)localObject1).matches();
    Object localObject2 = null;
    try
    {
      localObject1 = URLEncoder.encode((String)localObject1, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label123:
      String str3;
      Object localObject3;
      break label123;
    }
    localObject1 = localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyBasePopupWindow", 2, "encode shareUrl failed, because UTF-8 is unknown");
      localObject1 = localObject2;
    }
    if (bool)
    {
      str3 = String.valueOf(NetConnInfoCenter.getServerTime());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(200);
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append("jubao@article@123");
      localObject3 = MD5Utils.encodeHexStr(((StringBuilder)localObject2).toString());
      localObject2 = localObject3;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (!((String)localObject3).isEmpty()) {
          localObject2 = ((String)localObject3).toLowerCase();
        }
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("https://web.kandian.qq.com/tpl/kdReport?pgyid=2021&qq=");
      ((StringBuilder)localObject3).append(str1);
      ((StringBuilder)localObject3).append("&mp_uin=");
      ((StringBuilder)localObject3).append(str2);
      ((StringBuilder)localObject3).append("&scene=200&sub_appname=article_webview&timestamp=");
      ((StringBuilder)localObject3).append(str3);
      ((StringBuilder)localObject3).append("&sign=");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("&article_url=");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("&_wv=3");
      localObject1 = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://web.kandian.qq.com/tpl/kdReport?pgyid=2021&shareUrl=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&qq=");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("&_wv=7");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "reportFeeds, reportUrl = ", RIJLogUtil.a.a((String)localObject1) });
    localObject2 = new Intent(ReadInJoyFeedbackPopupWindow.m(this.this$0), QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    ReadInJoyFeedbackPopupWindow.n(this.this$0).startActivity((Intent)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow.3
 * JD-Core Version:    0.7.0.1
 */