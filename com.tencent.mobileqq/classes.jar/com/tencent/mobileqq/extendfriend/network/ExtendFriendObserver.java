package com.tencent.mobileqq.extendfriend.network;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.bean.MatchFeedInfo;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.bean.TagInfo;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendObserver
  implements BusinessObserver
{
  protected void onCancleUnlimitMatch(boolean paramBoolean) {}
  
  protected void onEditExtendFriendInfo(boolean paramBoolean) {}
  
  protected void onGetColdPalaceData(boolean paramBoolean) {}
  
  protected void onGetExtendFriendInfo(boolean paramBoolean, Card paramCard) {}
  
  protected void onGetExtendFriendInfo(boolean paramBoolean, Card paramCard, int paramInt) {}
  
  protected void onGetExtendFriendOnlineState(boolean paramBoolean, List<Long> paramList1, int paramInt, List<Long> paramList2) {}
  
  protected void onGetSigBy0xb4cCode(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetSquareStrangerList(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<StrangerInfo> paramList, MatchFeedInfo paramMatchFeedInfo) {}
  
  protected void onGetStrangerInfo(boolean paramBoolean, StrangerInfo paramStrangerInfo, int paramInt) {}
  
  protected void onGetUnLimitBaseInfo(boolean paramBoolean1, ArrayList<TagInfo> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1, boolean paramBoolean3) {}
  
  protected void onGetUnLimitFriendInfo(boolean paramBoolean, int paramInt1, int paramInt2, MatchInfo paramMatchInfo, String paramString) {}
  
  protected void onLimitChatResourceStateUpdate(boolean paramBoolean) {}
  
  protected void onMatchPush(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo) {}
  
  protected void onMatchResponse(boolean paramBoolean, int paramInt1, int paramInt2, MatchInfo paramMatchInfo, int paramInt3) {}
  
  protected void onPreLoadDataForArkMiniProfileCard(boolean paramBoolean, Object paramObject) {}
  
  protected void onPreLoadDataForIcebreakerTopic(boolean paramBoolean, Object paramObject) {}
  
  protected void onReqThrowToColdPalace(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  protected void onResourceStateUpdate(boolean paramBoolean) {}
  
  protected void onSetUnLimitSwitch(boolean paramBoolean) {}
  
  protected void onUnLimitMatchPush(boolean paramBoolean, MatchInfo paramMatchInfo) {}
  
  protected void onUnLimitMatchResponse(boolean paramBoolean, int paramInt, MatchInfo paramMatchInfo, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = -1;
    switch (paramInt)
    {
    case 4: 
    case 10: 
    case 24: 
    case 25: 
    case 27: 
    case 29: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 9: 
    case 5: 
    case 8: 
    case 6: 
    case 7: 
    case 20: 
    case 22: 
    case 11: 
    case 16: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 17: 
    case 18: 
    case 19: 
    case 21: 
    case 23: 
    case 26: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    onEditExtendFriendInfo(paramBoolean);
                    return;
                  } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                  paramObject = (Object[])paramObject;
                  if ((paramBoolean) && (paramObject.length == 9))
                  {
                    onGetSquareStrangerList(true, ((Long)paramObject[0]).longValue(), (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), (byte[])paramObject[3], ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), ((Integer)paramObject[6]).intValue(), (List)paramObject[7], (MatchFeedInfo)paramObject[8]);
                    return;
                  }
                } while ((paramBoolean) || (paramObject.length != 2));
                onGetSquareStrangerList(false, ((Long)paramObject[0]).longValue(), (String)paramObject[1], false, null, false, false, 0, null, null);
                return;
                paramObject = (Object[])paramObject;
                onGetExtendFriendInfo(paramBoolean, (Card)paramObject[0]);
                onGetExtendFriendInfo(paramBoolean, (Card)paramObject[0], ((Integer)paramObject[1]).intValue());
                return;
                paramObject = (Object[])paramObject;
                onGetStrangerInfo(paramBoolean, (StrangerInfo)paramObject[0], ((Integer)paramObject[1]).intValue());
                return;
                onResourceStateUpdate(((Boolean)paramObject).booleanValue());
                return;
                onLimitChatResourceStateUpdate(((Boolean)paramObject).booleanValue());
                return;
                if ((paramObject instanceof Object[]))
                {
                  paramObject = (Object[])paramObject;
                  if (paramObject.length == 4)
                  {
                    onMatchResponse(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (MatchInfo)paramObject[2], ((Integer)paramObject[3]).intValue());
                    return;
                  }
                  onMatchResponse(paramBoolean, -1, -1, null, -1);
                  return;
                }
                onMatchResponse(paramBoolean, -1, -1, null, -1);
                return;
                if ((paramObject instanceof Object[]))
                {
                  paramObject = (Object[])paramObject;
                  if ((paramObject != null) && (paramObject.length == 2))
                  {
                    onMatchPush(paramBoolean, ((Integer)paramObject[0]).intValue(), (MatchInfo)paramObject[1]);
                    return;
                  }
                  onMatchPush(false, -1, null);
                  return;
                }
                onMatchPush(paramBoolean, -1, null);
                return;
                paramInt = i;
                if (paramObject != null)
                {
                  paramInt = i;
                  if ((paramObject instanceof Object[]))
                  {
                    paramObject = (Object[])paramObject;
                    paramInt = i;
                    if (paramObject != null)
                    {
                      paramInt = i;
                      if (paramObject.length > 0) {
                        paramInt = ((Integer)paramObject[0]).intValue();
                      }
                    }
                  }
                }
                onUpdateCampusCertificateStatus(paramBoolean, paramInt);
                return;
                onUpdateExtendFriendCampusSchoolInfo(paramBoolean, paramObject);
                return;
                if (paramBoolean)
                {
                  if ((paramObject != null) && ((paramObject instanceof Object[])))
                  {
                    paramObject = (Object[])paramObject;
                    if ((paramObject != null) && (paramObject.length == 4))
                    {
                      onUnLimitMatchResponse(paramBoolean, ((Integer)paramObject[0]).intValue(), (MatchInfo)paramObject[1], (String)paramObject[3]);
                      return;
                    }
                    onUnLimitMatchResponse(false, -1, null, null);
                    return;
                  }
                  onUnLimitMatchResponse(false, -1, null, null);
                  return;
                }
                onUnLimitMatchResponse(false, -1, null, null);
                return;
                if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
                {
                  paramObject = (Object[])paramObject;
                  if ((paramObject != null) && (paramObject.length == 1))
                  {
                    onUnLimitMatchPush(paramBoolean, (MatchInfo)paramObject[0]);
                    return;
                  }
                  onUnLimitMatchPush(false, null);
                  return;
                }
                onUnLimitMatchPush(false, null);
                return;
                onCancleUnlimitMatch(paramBoolean);
                return;
                if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
                {
                  paramObject = (Object[])paramObject;
                  if ((paramObject != null) && (paramObject.length == 5))
                  {
                    onGetUnLimitBaseInfo(true, (ArrayList)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue(), (ArrayList)paramObject[3], ((Boolean)paramObject[4]).booleanValue());
                    return;
                  }
                  onGetUnLimitBaseInfo(false, null, true, 0, null, false);
                  return;
                }
                onGetUnLimitBaseInfo(false, null, true, 0, null, false);
                return;
                onSetUnLimitSwitch(paramBoolean);
                return;
                if (paramBoolean)
                {
                  if ((paramObject != null) && ((paramObject instanceof Object[])))
                  {
                    paramObject = (Object[])paramObject;
                    if ((paramObject != null) && (paramObject.length == 4))
                    {
                      onGetUnLimitFriendInfo(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[2]).intValue(), (MatchInfo)paramObject[1], (String)paramObject[3]);
                      return;
                    }
                    onGetUnLimitFriendInfo(false, -1, -1, null, null);
                    return;
                  }
                  onGetUnLimitFriendInfo(false, -1, -1, null, null);
                  return;
                }
                onGetUnLimitFriendInfo(false, -1, -1, null, null);
                return;
                onUpdateRedPoint(((Integer)paramObject).intValue());
                return;
                onUpdateMatchChatConfig(paramBoolean);
                return;
              } while (!(paramObject instanceof Object[]));
              paramObject = (Object[])paramObject;
              ArrayList localArrayList = (ArrayList)paramObject[0];
              List localList = (List)paramObject[2];
              onGetExtendFriendOnlineState(paramBoolean, localArrayList, ((Integer)paramObject[1]).intValue(), localList);
              return;
              onGetSigBy0xb4cCode(paramBoolean, paramObject);
              return;
            } while (!(paramObject instanceof Object[]));
            paramObject = (Object[])paramObject;
          } while (paramObject.length <= 0);
          onUpdateSignalBombPush(paramBoolean, (String)paramObject[0]);
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
      } while (paramObject.length != 3);
      onReqThrowToColdPalace(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 28: 
      onGetColdPalaceData(paramBoolean);
      return;
    case 30: 
      onPreLoadDataForArkMiniProfileCard(paramBoolean, paramObject);
      return;
    }
    onPreLoadDataForIcebreakerTopic(paramBoolean, paramObject);
  }
  
  protected void onUpdateCampusCertificateStatus(boolean paramBoolean, int paramInt) {}
  
  protected void onUpdateExtendFriendCampusSchoolInfo(boolean paramBoolean, Object paramObject) {}
  
  protected void onUpdateMatchChatConfig(boolean paramBoolean) {}
  
  protected void onUpdateRedPoint(int paramInt) {}
  
  protected void onUpdateSignalBombPush(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver
 * JD-Core Version:    0.7.0.1
 */