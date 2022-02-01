package com.tencent.mobileqq.together;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class TogetherWatchingDelegate$1
  extends TogetherObserver
{
  TogetherWatchingDelegate$1(TogetherWatchingDelegate paramTogetherWatchingDelegate) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("KEY_SESSION_UIN");
    int i = paramBundle.getInt("KEY_SESSION_TYPE");
    int j = paramBundle.getInt("KEY_FROM", -1);
    String str2 = paramBundle.getString("jump_url", "");
    String str1 = paramBundle.getString("error_msg", "");
    int k = paramBundle.getInt("error_code", 0);
    if ((paramBoolean) && (!TextUtils.isEmpty(str2)))
    {
      TogetherWatchingDelegate.a(this.a, str2, i, (String)localObject, j);
      return;
    }
    if ((k == 10004) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
    {
      paramBundle = this.a;
      TogetherWatchingDelegate.a(paramBundle, paramBundle.a.getApplication(), str2, i, (String)localObject, j, str1);
      return;
    }
    localObject = this.a.a.getApplication();
    paramBundle = str1;
    if (TextUtils.isEmpty(str1)) {
      paramBundle = ((Context)localObject).getString(2131693100);
    }
    QQToast.a((Context)localObject, 1, paramBundle, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherWatchingDelegate.1
 * JD-Core Version:    0.7.0.1
 */