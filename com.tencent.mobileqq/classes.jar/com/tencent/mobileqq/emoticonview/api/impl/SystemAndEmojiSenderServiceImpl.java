package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ISystemAndEmojiSenderService;
import com.tencent.mobileqq.emoticonview.sender.SystemAndEmojiEmoticonInfoSender;
import mqq.app.AppRuntime;

public class SystemAndEmojiSenderServiceImpl
  implements ISystemAndEmojiSenderService
{
  public void send(SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    SystemAndEmojiEmoticonInfoSender.send(paramSystemAndEmojiEmoticonInfo, paramAppRuntime, paramContext, paramEditText, paramParcelable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.SystemAndEmojiSenderServiceImpl
 * JD-Core Version:    0.7.0.1
 */