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
  private long jdField_a_of_type_Long;
  private AbsReadInJoyNickNameTextView.OnSetNickNameListener jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView$OnSetNickNameListener;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean;
  
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
    if (this.jdField_a_of_type_Boolean) {
      setText(RIJStringUtils.a(paramReadInJoyUserInfo.nick));
    } else {
      setText(paramReadInJoyUserInfo.nick);
    }
    AbsReadInJoyNickNameTextView.OnSetNickNameListener localOnSetNickNameListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView$OnSetNickNameListener;
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
    if (TextUtils.equals(paramString, String.valueOf(this.jdField_a_of_type_Long)))
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
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = ReadInJoyUserInfoModule.a(this.jdField_a_of_type_Long, this);
    String str = ReadInJoyUserInfoModule.a();
    if (localObject == null)
    {
      localObject = str;
      if (this.jdField_a_of_type_Boolean) {
        localObject = RIJStringUtils.a(str);
      }
      setText((CharSequence)localObject);
      return;
    }
    a((ReadInJoyUserInfo)localObject, this.jdField_a_of_type_Boolean);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView$OnSetNickNameListener = paramOnSetNickNameListener;
  }
  
  public void setPrefix(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject = paramCharSequence;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(paramCharSequence);
      localObject = ((StringBuilder)localObject).toString();
    }
    super.setText((CharSequence)localObject, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView
 * JD-Core Version:    0.7.0.1
 */