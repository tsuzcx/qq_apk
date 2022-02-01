package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.repo.db.struct.KandianMsgBoxRedPntInfoUtils;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class KandianMergeManager$16
  extends NumRedGetMsgCallback
{
  KandianMergeManager$16(KandianMergeManager paramKandianMergeManager) {}
  
  public void a(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    if (!"kandian_num_red_pnt_buffer".equals(paramString)) {
      return;
    }
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramString = ((NumRedMsg.NumMsgBusi)paramList.get(paramList.size() - 1)).str_ext.get();
      if (!TextUtils.isEmpty(paramString))
      {
        paramList = KandianMsgBoxRedPntInfoUtils.a(paramString);
        if ((paramList != null) && (RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(paramList) > 0) && ((KandianMergeManager.f(this.a) == null) || (paramList.mSeq > KandianMergeManager.f(this.a).mSeq) || (paramList.mPrivateChatSeq > KandianMergeManager.f(this.a).mPrivateChatSeq)))
        {
          if (Aladdin.getConfig(215).getIntegerFromString("message_reddot_style", 1) != 2) {
            this.a.a(paramList);
          } else {
            ReadInJoyLogicEngine.a().p(1);
          }
        }
        else
        {
          QLog.d("KandianMergeManager", 2, new Object[] { "[redpnt_center]new msgbox red info has error, local : ", KandianMergeManager.f(this.a), "new : ", paramList });
          return;
        }
      }
      paramList = new StringBuilder();
      paramList.append("handlerRedPntCenterNotify | num red pnt buffer : ");
      paramList.append(paramString);
      QLog.d("KandianMergeManager", 1, paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.16
 * JD-Core Version:    0.7.0.1
 */