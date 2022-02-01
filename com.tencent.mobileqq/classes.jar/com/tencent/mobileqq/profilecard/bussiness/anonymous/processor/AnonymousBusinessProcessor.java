package com.tencent.mobileqq.profilecard.bussiness.anonymous.processor;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousAnswerInfo;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.Quest;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.ReqBody;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.RspBody;

@KeepClassConstructor
public class AnonymousBusinessProcessor
  extends AbsProfileBusinessProcessor
{
  private static final String TAG = "AnonymousBusinessProcessor";
  
  public AnonymousBusinessProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void handleGetAnonymousInfo(Card paramCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    paramSparseArray = (BusinessRespBuffer)paramSparseArray.get(19);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGetAnonymousInfo start vvResp = ");
      ((StringBuilder)localObject1).append(paramSparseArray);
      QLog.d("AnonymousBusinessProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramSparseArray != null) && (paramSparseArray.buffer != null)) {}
    for (;;)
    {
      boolean bool;
      try
      {
        localObject2 = new oidb_0xec4.RspBody();
        ((oidb_0xec4.RspBody)localObject2).mergeFrom(paramSparseArray.buffer);
        paramSparseArray = new ProfileAnonymousAnswerInfo();
        paramSparseArray.mTotalQuestionCount = ((oidb_0xec4.RspBody)localObject2).uint32_total_quest_num.get();
        paramSparseArray.mHasFetchOver = ((oidb_0xec4.RspBody)localObject2).bool_is_fetch_over.get();
        if (!((oidb_0xec4.RspBody)localObject2).uint32_ret.has()) {
          break label384;
        }
        i = ((oidb_0xec4.RspBody)localObject2).uint32_ret.get();
      }
      catch (Exception paramCard)
      {
        Object localObject2;
        long l;
        AnonymousQuestion localAnonymousQuestion;
        int j;
        int k;
        QLog.e("AnonymousBusinessProcessor", 1, "handleGetAnonymousInfo fail.", paramCard);
      }
      paramSparseArray.needForbidEntry = bool;
      paramSparseArray.mAnsweredQuestionCount = ((oidb_0xec4.RspBody)localObject2).uint32_answered_quest_num.get();
      if (((oidb_0xec4.RspBody)localObject2).msg_quest.has())
      {
        l = Long.parseLong(paramCard.uin);
        localObject1 = new ArrayList();
        localObject2 = ((oidb_0xec4.RspBody)localObject2).msg_quest.get().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localAnonymousQuestion = AnonymousQuestion.convertQuest((oidb_0xec4.Quest)((Iterator)localObject2).next(), l);
          if ((localAnonymousQuestion == null) || (TextUtils.isEmpty(localAnonymousQuestion.mQuest)) || (TextUtils.isEmpty(localAnonymousQuestion.mAnswer))) {
            continue;
          }
          ((List)localObject1).add(localAnonymousQuestion);
          continue;
        }
        paramSparseArray.mAnonymousQuestions.addAll((Collection)localObject1);
      }
      if (QLog.isColorLevel())
      {
        j = paramSparseArray.mTotalQuestionCount;
        k = paramSparseArray.mAnsweredQuestionCount;
        QLog.d("AnonymousBusinessProcessor", 2, String.format("handleGetAnonymousInfo total=%s fetchOver=%s questionSize=%s retCode=%s needForbidEntry=%b answeredCount=%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(paramSparseArray.mHasFetchOver), Integer.valueOf(paramSparseArray.mAnonymousQuestions.size()), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(k) }));
      }
      paramCard.putBusinessInfo(paramSparseArray);
      return;
      return;
      label384:
      int i = -1;
      if (i == 10001) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void onProcessProfileService(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    handleGetAnonymousInfo(paramCard, paramSparseArray);
  }
  
  public void onRequestProfileCard(Bundle paramBundle, ArrayList<BusinessReqBuffer> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    long l = paramBundle.getLong("targetUin", 0L);
    paramBundle = new oidb_0xec4.ReqBody();
    paramBundle.uint64_uin.set(l);
    paramBundle.uint64_quest_num.set(10L);
    paramBundle.uint32_fetch_type.set(1);
    paramArrayList.add(new BusinessReqBuffer(19, paramBundle.toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.processor.AnonymousBusinessProcessor
 * JD-Core Version:    0.7.0.1
 */