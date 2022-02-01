package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/widget/AbsReadInJoyNickNameTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onLoadUserInfoFailed", "", "uin", "", "errMsg", "onLoadUserInfoSucceed", "userInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ReadInJoyUserInfo;", "setNickNameByUin", "", "isEllipsizeText", "", "uinStr", "setOnSetNickNameListener", "onSetNickNameListener", "Lcom/tencent/mobileqq/kandian/biz/common/widget/AbsReadInJoyNickNameTextView$OnSetNickNameListener;", "setPrefix", "prefix", "OnSetNickNameListener", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract class AbsReadInJoyNickNameTextView
  extends TextView
{
  public AbsReadInJoyNickNameTextView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void setNickNameByUin(long paramLong);
  
  public abstract void setNickNameByUin(long paramLong, boolean paramBoolean);
  
  public abstract void setNickNameByUin(@Nullable String paramString);
  
  public abstract void setNickNameByUin(@Nullable String paramString, boolean paramBoolean);
  
  public abstract void setOnSetNickNameListener(@NotNull AbsReadInJoyNickNameTextView.OnSetNickNameListener paramOnSetNickNameListener);
  
  public abstract void setPrefix(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView
 * JD-Core Version:    0.7.0.1
 */