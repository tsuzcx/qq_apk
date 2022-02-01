package com.tencent.mobileqq.onlinestatus.tempapi.impl;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.onlinestatus.tempapi.IEmojiPanelApi;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class EmojiPanelApiImpl
  implements IEmojiPanelApi
{
  public View findAndInitEmojiPanel(@NonNull AppRuntime paramAppRuntime, @NonNull @NotNull Activity paramActivity, @NonNull @NotNull View paramView, int paramInt, @NonNull @NotNull EditText paramEditText)
  {
    if (((paramActivity instanceof QBaseActivity)) && ((paramAppRuntime instanceof QQAppInterface)))
    {
      paramView = (IEmoticonMainPanel)paramView.findViewById(paramInt);
      paramView.setCallBack(new EmojiPanelApiImpl.1(this, paramEditText, paramAppRuntime, paramActivity));
      paramView.setDisableGuide(true);
      paramView.setDisableMoreEmotionButton(true);
      paramView.setHasBigEmotion(false);
      paramView.setOnlySysAndEmoji(true);
      paramView.setDisableAutoDownload(true);
      paramView.init((QQAppInterface)paramAppRuntime, 100002, paramActivity, ((QBaseActivity)paramActivity).getTitleBarHeight(), null, null, false, new EmojiPanelApiImpl.2(this));
      paramView.setTabListOverScrollMode(2);
      return paramView.getView();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.tempapi.impl.EmojiPanelApiImpl
 * JD-Core Version:    0.7.0.1
 */