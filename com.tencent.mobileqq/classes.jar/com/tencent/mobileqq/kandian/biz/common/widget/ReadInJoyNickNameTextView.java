package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ReadInJoyNickNameTextView
  extends AbsReadInJoyNickNameTextView
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  private long a;
  private boolean b;
  private AbsReadInJoyNickNameTextView.OnSetNickNameListener c;
  private String d = null;
  
  public ReadInJoyNickNameTextView(Context paramContext)
  {
    super(paramContext, null, 0);
  }
  
  public ReadInJoyNickNameTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyNickNameTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo, boolean paramBoolean)
  {
    if (paramReadInJoyUserInfo == null) {
      return;
    }
    if (this.b) {
      setText(RIJStringUtils.a(paramReadInJoyUserInfo.nick));
    } else {
      setText(paramReadInJoyUserInfo.nick);
    }
    AbsReadInJoyNickNameTextView.OnSetNickNameListener localOnSetNickNameListener = this.c;
    if (localOnSetNickNameListener != null) {
      localOnSetNickNameListener.a(paramReadInJoyUserInfo.nick);
    }
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" onLoadUserInfoFailed:");
    localStringBuilder.append(paramString2);
    QLog.d("ReadInJoyNickNameTextView", 2, localStringBuilder.toString());
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (TextUtils.equals(paramString, String.valueOf(this.a)))
    {
      if (paramReadInJoyUserInfo == null) {
        return;
      }
      ThreadManager.getUIHandler().post(new ReadInJoyNickNameTextView.1(this, paramReadInJoyUserInfo));
    }
  }
  
  public void setNickNameByUin(long paramLong)
  {
    setNickNameByUin(paramLong, false);
  }
  
  public void setNickNameByUin(long paramLong, boolean paramBoolean)
  {
    if (paramLong <= 0L) {
      return;
    }
    this.a = paramLong;
    this.b = paramBoolean;
    Object localObject = ReadInJoyUserInfoModule.a(this.a, this);
    String str = ReadInJoyUserInfoModule.d();
    if (localObject == null)
    {
      localObject = str;
      if (this.b) {
        localObject = RIJStringUtils.a(str);
      }
      setText((CharSequence)localObject);
      return;
    }
    a((ReadInJoyUserInfo)localObject, this.b);
  }
  
  public void setNickNameByUin(String paramString)
  {
    setNickNameByUin(paramString, false);
  }
  
  public void setNickNameByUin(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyNickNameTextView", 2, "UinStr is illegal");
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("ReadInJoyNickNameTextView", 2, paramString.getMessage());
    }
    setNickNameByUin(l1, paramBoolean);
  }
  
  public void setOnSetNickNameListener(AbsReadInJoyNickNameTextView.OnSetNickNameListener paramOnSetNickNameListener)
  {
    this.c = paramOnSetNickNameListener;
  }
  
  public void setPrefix(String paramString)
  {
    this.d = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject = paramCharSequence;
    if (!TextUtils.isEmpty(this.d))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(paramCharSequence);
      localObject = ((StringBuilder)localObject).toString();
    }
    super.setText((CharSequence)localObject, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView
 * JD-Core Version:    0.7.0.1
 */