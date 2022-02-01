package com.tencent.mobileqq.pttlogic.api.impl;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.IPttAudioDataManager;
import com.tencent.mobileqq.ptt.IPttVoiceChangePreSender;
import com.tencent.mobileqq.ptt.PttAudioDataManager;
import com.tencent.mobileqq.ptt.PttVoiceChangePreSender;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import mqq.app.AppRuntime;

public class PttUtilsImpl
  implements IPttUtils
{
  public static final String TAG = "PttUtilsImpl";
  
  public IPttAudioDataManager creatPttAudioDataManager()
  {
    return new PttAudioDataManager();
  }
  
  public IPttVoiceChangePreSender createPttVoiceChangePreSender(AppRuntime paramAppRuntime)
  {
    return new PttVoiceChangePreSender(paramAppRuntime);
  }
  
  public int getReceivedPTTStatus(AppInterface paramAppInterface, MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt.url == null) {
      return 2005;
    }
    if ((paramMessageForPtt.url.startsWith(AppConstants.SDCARD_ROOT)) && (FileUtils.fileExists(paramMessageForPtt.getLocalFilePath()))) {
      return 2003;
    }
    int i = TransFileControllerBusHelper.findProcessorFileStatus(paramAppInterface, paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
    if ((i == -1) && (paramMessageForPtt.fileSize == -4L)) {
      return 2005;
    }
    return i;
  }
  
  public void showDialogAboutMeizuRecordPermission(Context paramContext)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131699174));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramContext.getResources().getColor(2131165601), paramContext.getResources().getColor(2131165606)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    DialogUtil.a(paramContext, paramContext.getString(2131699173), localSpannableString, 0, 2131694583, null, null, new PttUtilsImpl.1(this, paramContext)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.impl.PttUtilsImpl
 * JD-Core Version:    0.7.0.1
 */