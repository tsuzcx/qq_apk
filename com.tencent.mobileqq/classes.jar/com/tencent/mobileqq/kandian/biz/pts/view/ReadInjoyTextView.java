package com.tencent.mobileqq.kandian.biz.pts.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ReadInjoyTextView
  extends NativeText
{
  protected float a = 0.0F;
  
  public ReadInjoyTextView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative.setBackgroundColor(paramVafContext.getContext().getResources().getColor(2131168376));
  }
  
  private String a(String paramString1, String paramString2)
  {
    return String.format(paramString1, new Object[] { paramString2 });
  }
  
  public void a(long paramLong)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(paramLong, new ReadInjoyTextView.3(this, String.valueOf(paramLong)));
    if (localReadInJoyUserInfo != null)
    {
      setText(RIJStringUtils.a(localReadInJoyUserInfo.nick));
      return;
    }
    setText(((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getDefaultNickName());
  }
  
  public void a(long paramLong, String paramString)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(paramLong, new ReadInjoyTextView.2(this, String.valueOf(paramLong), paramString));
    if ((localReadInJoyUserInfo != null) && (!TextUtils.isEmpty(localReadInJoyUserInfo.decorationName)))
    {
      setText(RIJStringUtils.a(localReadInJoyUserInfo.decorationName));
      return;
    }
    setText(RIJStringUtils.a(paramString));
  }
  
  public void a(String paramString, long paramLong)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(paramLong, new ReadInjoyTextView.1(this, String.valueOf(paramLong), paramString));
    if (localReadInJoyUserInfo != null)
    {
      setText(a(paramString, RIJStringUtils.a(localReadInJoyUserInfo.nick)));
      return;
    }
    setText(a(paramString, ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getDefaultNickName()));
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    if (this.a > 0.0F) {
      this.mNative.setLineSpacing(this.a, 1.0F);
    }
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (paramInt == 1083) {
      try
      {
        this.a = Utils.dp2px(Double.valueOf(paramString).doubleValue());
        return true;
      }
      catch (Exception localException)
      {
        QLog.d("ReadInjoyTextView", 1, "", localException);
      }
    }
    return super.setAttribute(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView
 * JD-Core Version:    0.7.0.1
 */