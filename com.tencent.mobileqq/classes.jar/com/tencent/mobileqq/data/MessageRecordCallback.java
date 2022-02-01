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
  public String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isMultiMsg) {
      return "mr_multimessage";
    }
    return MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((AnonymousChatHelper.a(paramMessageRecord)) && (AnonymousChatHelper.b(paramMessageRecord))) {}
    while ((TroopConfessUtil.a(paramMessageRecord)) && (TroopConfessUtil.b(paramMessageRecord))) {
      return true;
    }
    if (TextUtils.equals(AppConstants.FILE_ASSISTANT_UIN, paramMessageRecord.frienduin)) {
      return QFileAssistantUtils.b(paramMessageRecord);
    }
    return MessageRecordInfo.a(paramMessageRecord.issend);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageRecordCallback
 * JD-Core Version:    0.7.0.1
 */