package com.tencent.mobileqq.profilecard.bussiness.achievement.processor;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.LifeAchivementData;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.ProfileLifeAchievementInfo;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b.LifeAchievementItem;
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b.ReqBody;
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b.RspBody;

@KeepClassConstructor
public class LifeAchievementBusinessProcessor
  extends AbsProfileBusinessProcessor
{
  public static final String SUMMARY_CARD_TAG = "Q.profilecard.SummaryCard";
  private static final String TAG = "LifeAchievementBusinessProcessor";
  
  public LifeAchievementBusinessProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void handleGetLifeAchievementInfo(Card paramCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetLifeAchievementInfo vvRespList=");
      ((StringBuilder)localObject).append(paramSparseArray);
      QLog.i("Q.profilecard.SummaryCard", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (BusinessRespBuffer)paramSparseArray.get(18);
    if ((localObject != null) && (((BusinessRespBuffer)localObject).buffer != null))
    {
      paramSparseArray = new oidb_0xe5b.RspBody();
      try
      {
        paramSparseArray.mergeFrom(((BusinessRespBuffer)localObject).buffer);
        localObject = new ProfileLifeAchievementInfo();
        ((ProfileLifeAchievementInfo)localObject).lifeAchievementTotalCount = paramSparseArray.uint32_achievement_totalcount.get();
        ((ProfileLifeAchievementInfo)localObject).lifeAchievementOpenId = paramSparseArray.str_achievement_openid.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, String.format(Locale.getDefault(), "handleGetLifeAchievementInfo totalCount=%s openId=%s", new Object[] { Integer.valueOf(((ProfileLifeAchievementInfo)localObject).lifeAchievementTotalCount), ((ProfileLifeAchievementInfo)localObject).lifeAchievementOpenId }));
        }
        ((ProfileLifeAchievementInfo)localObject).lifeAchievementList = new ArrayList();
        if (paramSparseArray.rpt_life_ach_item != null)
        {
          int i = 0;
          while (i < paramSparseArray.rpt_life_ach_item.size())
          {
            LifeAchivementData localLifeAchivementData = new LifeAchivementData();
            localLifeAchivementData.id = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).uint32_achievement_id.get();
            localLifeAchivementData.title = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).str_achievement_title.get();
            localLifeAchivementData.iconUrl = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).str_achievement_icon.get();
            localLifeAchivementData.hasPraised = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).bool_has_praised.get();
            localLifeAchivementData.praiseNum = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).uint32_praise_num.get();
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.SummaryCard", 2, String.format(Locale.getDefault(), "handleGetLifeAchievementInfo id=%s title=%s iconUrl=%s hasPraised=%s praiseNum=%s", new Object[] { Integer.valueOf(localLifeAchivementData.id), localLifeAchivementData.title, localLifeAchivementData.iconUrl, Boolean.valueOf(localLifeAchivementData.hasPraised), Integer.valueOf(localLifeAchivementData.praiseNum) }));
            }
            ((ProfileLifeAchievementInfo)localObject).lifeAchievementList.add(localLifeAchivementData);
            i += 1;
          }
        }
        paramCard.putBusinessInfo((IProfileBusinessInfo)localObject);
        return;
      }
      catch (Exception paramCard)
      {
        if (QLog.isColorLevel())
        {
          paramSparseArray = new StringBuilder();
          paramSparseArray.append("handleGetLifeAchievementInfo onResponse fail.");
          paramSparseArray.append(paramCard);
          QLog.d("LifeAchievementBusinessProcessor", 2, paramSparseArray.toString());
        }
      }
    }
  }
  
  public void onProcessProfileService(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    super.onProcessProfileService(paramBundle, paramCard, paramRespHead, paramRespSummaryCard, paramSparseArray);
    handleGetLifeAchievementInfo(paramCard, paramSparseArray);
  }
  
  public void onRequestProfileCard(Bundle paramBundle, ArrayList<BusinessReqBuffer> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    super.onRequestProfileCard(paramBundle, paramArrayList, paramArrayList1);
    long l = paramBundle.getLong("targetUin", 0L);
    paramBundle = new oidb_0xe5b.ReqBody();
    paramBundle.uint64_uin.set(l);
    paramBundle.uint32_max_count.set(10);
    paramBundle.bool_req_achievement_content.set(false);
    paramArrayList.add(new BusinessReqBuffer(18, paramBundle.toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.processor.LifeAchievementBusinessProcessor
 * JD-Core Version:    0.7.0.1
 */