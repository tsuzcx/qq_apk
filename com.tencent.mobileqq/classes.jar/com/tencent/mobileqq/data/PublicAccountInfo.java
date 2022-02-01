package com.tencent.mobileqq.data;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.EqqAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.PublicAccountInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigGroupInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.PublicAccountInfo;

public class PublicAccountInfo
  extends Entity
{
  public static final int SHOW_FLAG_INVISIBLE_BIT = 2048;
  public static final int SHOW_FLAG_NO = 2;
  public static final int SHOW_FLAG_YES = 1;
  public static final int SHOW_MSG_FLAG_TYPE = 5;
  @notColumn
  public HashMap<String, Integer> Marks = null;
  public int accountFlag;
  public long accountFlag2;
  public long certifiedGrade;
  public int clickCount;
  public long dateTime;
  public String displayNumber;
  public long eqqAccountFlag;
  public int extendType;
  @notColumn
  public boolean isOffLine = false;
  public boolean isRecvMsg;
  public boolean isRecvPush;
  public boolean isShieldMsg;
  public boolean isSyncLbs;
  public long lastAIOReadTime = 0L;
  public String logo;
  public int mComparePartInt;
  public String mCompareSpell;
  public boolean mIsAgreeSyncLbs;
  public boolean mIsSyncLbsSelected;
  public int mShowMsgFlag;
  public int messageSettingFlag;
  public String name;
  @notColumn
  public int orderForMark = 0;
  public int showFlag;
  public String summary;
  @unique
  public long uin;
  @notColumn
  private String uinStr;
  
  private static void copyEqqLbsSwitch(mobileqq_mp.EqqAccountInfo paramEqqAccountInfo, PublicAccountInfo paramPublicAccountInfo)
  {
    int j;
    if ((paramEqqAccountInfo.config_group_info.has()) && (!paramEqqAccountInfo.config_group_info.isEmpty()))
    {
      paramEqqAccountInfo = paramEqqAccountInfo.config_group_info.get().iterator();
      int i = 0;
      do
      {
        j = i;
        if (!paramEqqAccountInfo.hasNext()) {
          break;
        }
        Object localObject1 = (mobileqq_mp.ConfigGroupInfo)paramEqqAccountInfo.next();
        j = i;
        if (((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.has())
        {
          j = i;
          if (!((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.isEmpty())
          {
            Object localObject2 = ((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.get().iterator();
            do
            {
              j = i;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (mobileqq_mp.ConfigInfo)((Iterator)localObject2).next();
            } while ((!((mobileqq_mp.ConfigInfo)localObject1).type.has()) || (((mobileqq_mp.ConfigInfo)localObject1).type.get() != 2) || (!((mobileqq_mp.ConfigInfo)localObject1).state_id.has()) || (((mobileqq_mp.ConfigInfo)localObject1).state_id.get() != 3));
            paramPublicAccountInfo.isSyncLbs = true;
            if (((mobileqq_mp.ConfigInfo)localObject1).state.has())
            {
              i = ((mobileqq_mp.ConfigInfo)localObject1).state.get();
              if (i != 0)
              {
                if (i != 1)
                {
                  if (i != 2)
                  {
                    if (QLog.isColorLevel())
                    {
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append("Error Eqq lbs state value: ");
                      ((StringBuilder)localObject2).append(((mobileqq_mp.ConfigInfo)localObject1).state.get());
                      QLog.e("PublicAccountInfo", 2, ((StringBuilder)localObject2).toString());
                    }
                  }
                  else
                  {
                    paramPublicAccountInfo.mIsSyncLbsSelected = true;
                    paramPublicAccountInfo.mIsAgreeSyncLbs = false;
                  }
                }
                else
                {
                  paramPublicAccountInfo.mIsSyncLbsSelected = true;
                  paramPublicAccountInfo.mIsAgreeSyncLbs = true;
                }
              }
              else
              {
                paramPublicAccountInfo.mIsSyncLbsSelected = false;
                paramPublicAccountInfo.mIsAgreeSyncLbs = false;
              }
            }
            j = 1;
          }
        }
        i = j;
      } while (j == 0);
    }
    else
    {
      j = 0;
    }
    if (j == 0) {
      paramPublicAccountInfo.isSyncLbs = false;
    }
  }
  
  public static PublicAccountInfo createLooker(Context paramContext)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    localPublicAccountInfo.uin = 0L;
    localPublicAccountInfo.name = paramContext.getString(2131886301);
    localPublicAccountInfo.displayNumber = paramContext.getString(2131886301);
    localPublicAccountInfo.summary = "";
    localPublicAccountInfo.extendType = 1;
    return localPublicAccountInfo;
  }
  
  public static PublicAccountInfo createPublicAccount(IPublicAccountDetail paramIPublicAccountDetail, long paramLong)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    localPublicAccountInfo.uinStr = paramIPublicAccountDetail.getUin();
    localPublicAccountInfo.uin = Long.parseLong(paramIPublicAccountDetail.getUin());
    localPublicAccountInfo.name = paramIPublicAccountDetail.getName();
    localPublicAccountInfo.displayNumber = paramIPublicAccountDetail.getDisplayNumber();
    localPublicAccountInfo.summary = paramIPublicAccountDetail.getSummary();
    localPublicAccountInfo.isRecvMsg = paramIPublicAccountDetail.isRecvMsg();
    localPublicAccountInfo.isRecvPush = paramIPublicAccountDetail.isRecvPush();
    localPublicAccountInfo.certifiedGrade = paramIPublicAccountDetail.getCertifiedGrade();
    localPublicAccountInfo.isSyncLbs = paramIPublicAccountDetail.isSyncLbs();
    localPublicAccountInfo.mIsAgreeSyncLbs = paramIPublicAccountDetail.isAgreeSyncLbs();
    localPublicAccountInfo.mShowMsgFlag = paramIPublicAccountDetail.getShowMsgFlag();
    localPublicAccountInfo.showFlag = paramIPublicAccountDetail.getShowFlag();
    localPublicAccountInfo.accountFlag = paramIPublicAccountDetail.getAccountFlag();
    localPublicAccountInfo.accountFlag2 = paramIPublicAccountDetail.getAccountFlag2();
    localPublicAccountInfo.isSyncLbs = paramIPublicAccountDetail.isSyncLbs();
    localPublicAccountInfo.mIsAgreeSyncLbs = paramIPublicAccountDetail.isAgreeSyncLbs();
    localPublicAccountInfo.mIsSyncLbsSelected = paramIPublicAccountDetail.isSyncLbsSelected();
    localPublicAccountInfo.dateTime = paramLong;
    ContactSorter.a(localPublicAccountInfo);
    return localPublicAccountInfo;
  }
  
  public static PublicAccountInfo createPublicAccount(EqqDetail paramEqqDetail, long paramLong)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    localPublicAccountInfo.uinStr = paramEqqDetail.uin;
    try
    {
      localPublicAccountInfo.uin = Long.parseLong(paramEqqDetail.uin);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label30:
      break label30;
    }
    localPublicAccountInfo.uin = 0L;
    localPublicAccountInfo.name = paramEqqDetail.name;
    localPublicAccountInfo.displayNumber = paramEqqDetail.displayNumber;
    localPublicAccountInfo.summary = paramEqqDetail.summary;
    localPublicAccountInfo.certifiedGrade = paramEqqDetail.certifiedGrade;
    localPublicAccountInfo.dateTime = paramLong;
    localPublicAccountInfo.showFlag = 1;
    localPublicAccountInfo.extendType = 2;
    localPublicAccountInfo.mShowMsgFlag = paramEqqDetail.mShowMsgFlag;
    localPublicAccountInfo.isSyncLbs = paramEqqDetail.mIsSyncLbs;
    localPublicAccountInfo.mIsAgreeSyncLbs = paramEqqDetail.mIsAgreeSyncLbs;
    localPublicAccountInfo.mIsSyncLbsSelected = paramEqqDetail.mIsSyncLbsSelected;
    localPublicAccountInfo.eqqAccountFlag = paramEqqDetail.eqqAccountFlag;
    return localPublicAccountInfo;
  }
  
  public static PublicAccountInfo createPublicAccountInfo(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, HashMap<String, Integer> paramHashMap, int paramInt2)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    localPublicAccountInfo.uin = paramLong;
    localPublicAccountInfo.uinStr = String.valueOf(paramLong);
    localPublicAccountInfo.displayNumber = paramString1;
    localPublicAccountInfo.name = paramString2;
    localPublicAccountInfo.summary = paramString3;
    localPublicAccountInfo.certifiedGrade = paramInt1;
    localPublicAccountInfo.Marks = paramHashMap;
    localPublicAccountInfo.isOffLine = true;
    localPublicAccountInfo.dateTime = SystemClock.uptimeMillis();
    localPublicAccountInfo.orderForMark = paramInt2;
    return localPublicAccountInfo;
  }
  
  public static PublicAccountInfo createPublicAccountInfo(mobileqq_mp.PublicAccountInfo paramPublicAccountInfo, long paramLong)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    if (paramPublicAccountInfo.uin.has()) {
      localPublicAccountInfo.uin = (paramPublicAccountInfo.uin.get() & 0xFFFFFFFF);
    }
    if (paramPublicAccountInfo.name.has()) {
      localPublicAccountInfo.name = paramPublicAccountInfo.name.get();
    }
    if (paramPublicAccountInfo.summary.has()) {
      localPublicAccountInfo.summary = paramPublicAccountInfo.summary.get();
    }
    if (paramPublicAccountInfo.is_recv_msg.has()) {
      localPublicAccountInfo.isRecvMsg = paramPublicAccountInfo.is_recv_msg.get();
    }
    if (paramPublicAccountInfo.display_number.has()) {
      localPublicAccountInfo.displayNumber = paramPublicAccountInfo.display_number.get();
    }
    if (paramPublicAccountInfo.is_recv_push.has()) {
      localPublicAccountInfo.isRecvPush = paramPublicAccountInfo.is_recv_push.get();
    }
    if (paramPublicAccountInfo.certified_grade.has()) {
      localPublicAccountInfo.certifiedGrade = paramPublicAccountInfo.certified_grade.get();
    }
    if (paramPublicAccountInfo.show_flag.has()) {
      localPublicAccountInfo.showFlag = paramPublicAccountInfo.show_flag.get();
    }
    if (paramPublicAccountInfo.account_flag.has()) {
      localPublicAccountInfo.accountFlag = paramPublicAccountInfo.account_flag.get();
    }
    if (paramPublicAccountInfo.account_flag2.has()) {
      localPublicAccountInfo.accountFlag2 = paramPublicAccountInfo.account_flag2.get();
    }
    localPublicAccountInfo.mShowMsgFlag = -1;
    Object localObject1;
    int i;
    Object localObject2;
    int j;
    mobileqq_mp.ConfigInfo localConfigInfo;
    if (paramPublicAccountInfo.config_group_info.has())
    {
      localObject1 = paramPublicAccountInfo.config_group_info.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (mobileqq_mp.ConfigGroupInfo)((Iterator)localObject1).next();
          j = i;
          if (((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.has())
          {
            localObject2 = ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.get().iterator();
            do
            {
              j = i;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject2).next();
            } while (localConfigInfo.state_id.get() != 5);
            if (localConfigInfo.state.get() == 1) {
              i = 1;
            } else {
              i = 0;
            }
            localPublicAccountInfo.mShowMsgFlag = i;
            j = 1;
          }
          i = j;
        } while (j == 0);
      }
    }
    localPublicAccountInfo.messageSettingFlag = -1;
    if (paramPublicAccountInfo.config_group_info_new.has())
    {
      localObject1 = paramPublicAccountInfo.config_group_info_new.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label586;
          }
          localObject2 = (mobileqq_mp.ConfigGroupInfo)((Iterator)localObject1).next();
          if (((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.has())
          {
            localObject2 = ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.get().iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject2).next();
              if (localConfigInfo.state_id.get() != 6) {
                break;
              }
              boolean bool;
              if (localConfigInfo.state.get() == 3) {
                bool = true;
              } else {
                bool = false;
              }
              localPublicAccountInfo.isShieldMsg = bool;
              localPublicAccountInfo.messageSettingFlag = localConfigInfo.state.get();
            }
          }
        }
      }
    }
    label586:
    if (paramPublicAccountInfo.is_sync_lbs.has()) {
      localPublicAccountInfo.mIsAgreeSyncLbs = paramPublicAccountInfo.is_sync_lbs.get();
    }
    localPublicAccountInfo.dateTime = paramLong;
    if ((paramPublicAccountInfo.config_group_info_new.has()) && (!paramPublicAccountInfo.config_group_info_new.isEmpty()))
    {
      paramPublicAccountInfo = paramPublicAccountInfo.config_group_info_new.get().iterator();
      i = 0;
      do
      {
        j = i;
        if (!paramPublicAccountInfo.hasNext()) {
          break;
        }
        localObject1 = (mobileqq_mp.ConfigGroupInfo)paramPublicAccountInfo.next();
        j = i;
        if (((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.has())
        {
          j = i;
          if (!((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.isEmpty())
          {
            localObject1 = ((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.get().iterator();
            do
            {
              j = i;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (mobileqq_mp.ConfigInfo)((Iterator)localObject1).next();
            } while ((!((mobileqq_mp.ConfigInfo)localObject2).type.has()) || (((mobileqq_mp.ConfigInfo)localObject2).type.get() != 2) || (!((mobileqq_mp.ConfigInfo)localObject2).state_id.has()) || (((mobileqq_mp.ConfigInfo)localObject2).state_id.get() != 3));
            localPublicAccountInfo.isSyncLbs = true;
            if (((mobileqq_mp.ConfigInfo)localObject2).state.has())
            {
              i = ((mobileqq_mp.ConfigInfo)localObject2).state.get();
              if (i != 0)
              {
                if (i != 1)
                {
                  if (i == 2)
                  {
                    localPublicAccountInfo.mIsSyncLbsSelected = true;
                    localPublicAccountInfo.mIsAgreeSyncLbs = false;
                  }
                }
                else
                {
                  localPublicAccountInfo.mIsSyncLbsSelected = true;
                  localPublicAccountInfo.mIsAgreeSyncLbs = true;
                }
              }
              else
              {
                localPublicAccountInfo.mIsSyncLbsSelected = false;
                localPublicAccountInfo.mIsAgreeSyncLbs = false;
              }
            }
            j = 1;
          }
        }
        i = j;
      } while (j == 0);
    }
    else
    {
      j = 0;
    }
    if (j == 0) {
      localPublicAccountInfo.isSyncLbs = false;
    }
    return localPublicAccountInfo;
  }
  
  public static PublicAccountInfo createPublicAccountInfoCf8(oidb_cmd0xcf8.PublicAccountInfo paramPublicAccountInfo, long paramLong)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    if (paramPublicAccountInfo.luin.has()) {
      localPublicAccountInfo.uin = (paramPublicAccountInfo.luin.get() & 0xFFFFFFFF);
    }
    if (paramPublicAccountInfo.name.has()) {
      localPublicAccountInfo.name = paramPublicAccountInfo.name.get();
    }
    if (paramPublicAccountInfo.summary.has()) {
      localPublicAccountInfo.summary = paramPublicAccountInfo.summary.get();
    }
    if (paramPublicAccountInfo.is_recv_msg.has()) {
      localPublicAccountInfo.isRecvMsg = paramPublicAccountInfo.is_recv_msg.get();
    }
    if (paramPublicAccountInfo.display_number.has()) {
      localPublicAccountInfo.displayNumber = paramPublicAccountInfo.display_number.get();
    }
    if (paramPublicAccountInfo.is_recv_push.has()) {
      localPublicAccountInfo.isRecvPush = paramPublicAccountInfo.is_recv_push.get();
    }
    if (paramPublicAccountInfo.certified_grade.has()) {
      localPublicAccountInfo.certifiedGrade = paramPublicAccountInfo.certified_grade.get();
    }
    if (paramPublicAccountInfo.show_flag.has()) {
      localPublicAccountInfo.showFlag = paramPublicAccountInfo.show_flag.get();
    }
    if (paramPublicAccountInfo.account_flag.has()) {
      localPublicAccountInfo.accountFlag = paramPublicAccountInfo.account_flag.get();
    }
    if (paramPublicAccountInfo.account_flag2.has()) {
      localPublicAccountInfo.accountFlag2 = paramPublicAccountInfo.account_flag2.get();
    }
    localPublicAccountInfo.mShowMsgFlag = -1;
    Object localObject1;
    int i;
    Object localObject2;
    int j;
    oidb_cmd0xcf8.ConfigInfo localConfigInfo;
    if (paramPublicAccountInfo.config_group_info.has())
    {
      localObject1 = paramPublicAccountInfo.config_group_info.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
          j = i;
          if (((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.has())
          {
            localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
            do
            {
              j = i;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
            } while (localConfigInfo.state_id.get() != 5);
            if (localConfigInfo.state.get() == 1) {
              i = 1;
            } else {
              i = 0;
            }
            localPublicAccountInfo.mShowMsgFlag = i;
            j = 1;
          }
          i = j;
        } while (j == 0);
      }
    }
    localPublicAccountInfo.messageSettingFlag = -1;
    if (paramPublicAccountInfo.config_group_info_new.has())
    {
      localObject1 = paramPublicAccountInfo.config_group_info_new.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label585;
          }
          localObject2 = (oidb_cmd0xcf8.ConfigGroupInfo)((Iterator)localObject1).next();
          if (((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.has())
          {
            localObject2 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject2).config_info.get().iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localConfigInfo = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject2).next();
              if (localConfigInfo.state_id.get() != 6) {
                break;
              }
              boolean bool;
              if (localConfigInfo.state.get() == 3) {
                bool = true;
              } else {
                bool = false;
              }
              localPublicAccountInfo.isShieldMsg = bool;
              localPublicAccountInfo.messageSettingFlag = localConfigInfo.state.get();
            }
          }
        }
      }
    }
    label585:
    if (paramPublicAccountInfo.is_sync_lbs.has()) {
      localPublicAccountInfo.mIsAgreeSyncLbs = paramPublicAccountInfo.is_sync_lbs.get();
    }
    localPublicAccountInfo.dateTime = paramLong;
    if ((paramPublicAccountInfo.config_group_info_new.has()) && (!paramPublicAccountInfo.config_group_info_new.isEmpty()))
    {
      paramPublicAccountInfo = paramPublicAccountInfo.config_group_info_new.get().iterator();
      i = 0;
      do
      {
        j = i;
        if (!paramPublicAccountInfo.hasNext()) {
          break;
        }
        localObject1 = (oidb_cmd0xcf8.ConfigGroupInfo)paramPublicAccountInfo.next();
        j = i;
        if (((oidb_cmd0xcf8.ConfigGroupInfo)localObject1).config_info.has())
        {
          j = i;
          if (!((oidb_cmd0xcf8.ConfigGroupInfo)localObject1).config_info.isEmpty())
          {
            localObject1 = ((oidb_cmd0xcf8.ConfigGroupInfo)localObject1).config_info.get().iterator();
            do
            {
              j = i;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (oidb_cmd0xcf8.ConfigInfo)((Iterator)localObject1).next();
            } while ((!((oidb_cmd0xcf8.ConfigInfo)localObject2).type.has()) || (((oidb_cmd0xcf8.ConfigInfo)localObject2).type.get() != 2) || (!((oidb_cmd0xcf8.ConfigInfo)localObject2).state_id.has()) || (((oidb_cmd0xcf8.ConfigInfo)localObject2).state_id.get() != 3));
            localPublicAccountInfo.isSyncLbs = true;
            if (((oidb_cmd0xcf8.ConfigInfo)localObject2).state.has())
            {
              i = ((oidb_cmd0xcf8.ConfigInfo)localObject2).state.get();
              if (i != 0)
              {
                if (i != 1)
                {
                  if (i == 2)
                  {
                    localPublicAccountInfo.mIsSyncLbsSelected = true;
                    localPublicAccountInfo.mIsAgreeSyncLbs = false;
                  }
                }
                else
                {
                  localPublicAccountInfo.mIsSyncLbsSelected = true;
                  localPublicAccountInfo.mIsAgreeSyncLbs = true;
                }
              }
              else
              {
                localPublicAccountInfo.mIsSyncLbsSelected = false;
                localPublicAccountInfo.mIsAgreeSyncLbs = false;
              }
            }
            j = 1;
          }
        }
        i = j;
      } while (j == 0);
    }
    else
    {
      j = 0;
    }
    if (j == 0) {
      localPublicAccountInfo.isSyncLbs = false;
    }
    return localPublicAccountInfo;
  }
  
  public static PublicAccountInfo createPublicAccountInfoFromEqq(mobileqq_mp.EqqAccountInfo paramEqqAccountInfo, long paramLong)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    if (paramEqqAccountInfo.uin.has()) {
      localPublicAccountInfo.uin = (paramEqqAccountInfo.uin.get() & 0xFFFFFFFF);
    }
    if (paramEqqAccountInfo.name.has()) {
      localPublicAccountInfo.name = paramEqqAccountInfo.name.get();
    }
    if (paramEqqAccountInfo.display_number.has()) {
      localPublicAccountInfo.displayNumber = paramEqqAccountInfo.display_number.get();
    }
    if (paramEqqAccountInfo.summary.has()) {
      localPublicAccountInfo.summary = paramEqqAccountInfo.summary.get();
    }
    if (paramEqqAccountInfo.certified_grade.has()) {
      localPublicAccountInfo.certifiedGrade = paramEqqAccountInfo.certified_grade.get();
    }
    if (paramEqqAccountInfo.logo.has()) {
      localPublicAccountInfo.logo = paramEqqAccountInfo.logo.get();
    }
    if (paramEqqAccountInfo.account_flag.has()) {
      localPublicAccountInfo.eqqAccountFlag = paramEqqAccountInfo.account_flag.get();
    }
    localPublicAccountInfo.mShowMsgFlag = -1;
    if (paramEqqAccountInfo.config_group_info.has())
    {
      Object localObject1 = paramEqqAccountInfo.config_group_info.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        int i = 0;
        int j;
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject2 = (mobileqq_mp.ConfigGroupInfo)((Iterator)localObject1).next();
          j = i;
          if (((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.has())
          {
            localObject2 = ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.get().iterator();
            mobileqq_mp.ConfigInfo localConfigInfo;
            do
            {
              j = i;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject2).next();
            } while (localConfigInfo.state_id.get() != 5);
            if (localConfigInfo.state.get() == 1) {
              i = 1;
            } else {
              i = 0;
            }
            localPublicAccountInfo.mShowMsgFlag = i;
            j = 1;
          }
          i = j;
        } while (j == 0);
      }
    }
    localPublicAccountInfo.dateTime = paramLong;
    localPublicAccountInfo.showFlag = 1;
    localPublicAccountInfo.extendType = 2;
    copyEqqLbsSwitch(paramEqqAccountInfo, localPublicAccountInfo);
    return localPublicAccountInfo;
  }
  
  public static List<PublicAccountInfo> createPublicAccountInfoList(List<mobileqq_mp.PublicAccountInfo> paramList, long paramLong)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(createPublicAccountInfo((mobileqq_mp.PublicAccountInfo)localIterator.next(), paramLong));
      }
    }
    paramList = null;
    return paramList;
  }
  
  public static List<PublicAccountInfo> createPublicAccountInfoListCf8(List<oidb_cmd0xcf8.PublicAccountInfo> paramList, long paramLong)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(createPublicAccountInfoCf8((oidb_cmd0xcf8.PublicAccountInfo)localIterator.next(), paramLong));
      }
    }
    paramList = null;
    return paramList;
  }
  
  public static List<PublicAccountInfo> createPublicAccountInfoListFromEqq(List<mobileqq_mp.EqqAccountInfo> paramList, long paramLong)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(createPublicAccountInfoFromEqq((mobileqq_mp.EqqAccountInfo)localIterator.next(), paramLong));
      }
    }
    paramList = null;
    return paramList;
  }
  
  private boolean isHideInContacts()
  {
    return (this.accountFlag & 0x800) != 0;
  }
  
  public static boolean isLooker(PublicAccountInfo paramPublicAccountInfo)
  {
    return paramPublicAccountInfo.extendType == 1;
  }
  
  public String getUin()
  {
    if (this.uinStr == null) {
      this.uinStr = String.valueOf(this.uin);
    }
    return this.uinStr;
  }
  
  public boolean hasIvrAbility()
  {
    int i = this.extendType;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (2 == i)
    {
      if (!CrmUtils.b)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountInfo", 4, "Don't support sharp");
        }
        return false;
      }
      bool1 = bool2;
      if ((this.eqqAccountFlag & 0x400000) == 4194304L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isNeedShow()
  {
    return 1 == this.showFlag;
  }
  
  public boolean isVisible()
  {
    return 1 == this.showFlag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublicAccountInfo
 * JD-Core Version:    0.7.0.1
 */