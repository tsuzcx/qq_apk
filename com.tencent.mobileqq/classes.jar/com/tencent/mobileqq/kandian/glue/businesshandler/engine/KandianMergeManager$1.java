package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class KandianMergeManager$1
  implements Observer
{
  KandianMergeManager$1(KandianMergeManager paramKandianMergeManager) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((paramObservable.istroop == 10013) && (!TextUtils.isEmpty(paramObservable.senderuin)))
      {
        long l;
        try
        {
          l = Long.parseLong(paramObservable.senderuin);
        }
        catch (NumberFormatException paramObject)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("messageObserver [update] e = ");
          localStringBuilder.append(paramObject);
          QLog.e("KandianMergeManager", 1, localStringBuilder.toString());
          l = 0L;
        }
        if (((Long)RIJSPUtils.b("kandian_msg_box_private_chat_message_id_sp_key", Long.valueOf(0L))).longValue() == paramObservable.uniseq)
        {
          QLog.i("KandianMergeManager", 1, "messageObserver [update] red point has showed, do not request again.");
          return;
        }
        ReadInJoyLogicEngine.a().b(3, "", l);
        RIJSPUtils.a("kandian_msg_box_private_chat_message_id_sp_key", Long.valueOf(paramObservable.uniseq));
        paramObject = new StringBuilder();
        paramObject.append("messageObserver [update] request rij message box, uinLong = ");
        paramObject.append(l);
        paramObject.append(", uniseq = ");
        paramObject.append(paramObservable.uniseq);
        QLog.i("KandianMergeManager", 1, paramObject.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.1
 * JD-Core Version:    0.7.0.1
 */