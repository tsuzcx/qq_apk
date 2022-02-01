package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;

public class MessageRecordCallback
  implements MessageRecord.Callback
{
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((AnonymousChatHelper.c(paramMessageRecord)) && (AnonymousChatHelper.f(paramMessageRecord))) {
      return true;
    }
    if ((TroopConfessUtil.a(paramMessageRecord)) && (TroopConfessUtil.b(paramMessageRecord))) {
      return true;
    }
    if (TextUtils.equals(AppConstants.FILE_ASSISTANT_UIN, paramMessageRecord.frienduin)) {
      return QFileAssistantUtils.b(paramMessageRecord);
    }
    return MessageRecordInfo.b(paramMessageRecord.issend);
  }
  
  public String b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isMultiMsg) {
      return "mr_multimessage";
    }
    return MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageRecordCallback
 * JD-Core Version:    0.7.0.1
 */