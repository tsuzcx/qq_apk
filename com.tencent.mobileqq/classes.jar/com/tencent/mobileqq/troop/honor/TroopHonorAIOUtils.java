package com.tencent.mobileqq.troop.honor;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import java.util.Collections;
import java.util.List;

public class TroopHonorAIOUtils
{
  private static View.OnTouchListener a(QQAppInterface paramQQAppInterface, boolean paramBoolean, Activity paramActivity, String paramString)
  {
    return new TroopHonorAIOUtils.3(paramBoolean, paramQQAppInterface, paramActivity, paramString);
  }
  
  public static MutualMarkForDisplayInfo a(TroopHonor paramTroopHonor)
  {
    if (paramTroopHonor != null)
    {
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = new MutualMarkForDisplayInfo();
      localMutualMarkForDisplayInfo.s = paramTroopHonor.c;
      String str = paramTroopHonor.b;
      localMutualMarkForDisplayInfo.o = str;
      localMutualMarkForDisplayInfo.t = str;
      localMutualMarkForDisplayInfo.a = paramTroopHonor.a;
      localMutualMarkForDisplayInfo.p = true;
      return localMutualMarkForDisplayInfo;
    }
    return null;
  }
  
  public static MutualMarkForDisplayInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = new MutualMarkForDisplayInfo();
    localMutualMarkForDisplayInfo.s = paramString;
    localMutualMarkForDisplayInfo.o = HardCodeUtil.a(2131897530);
    localMutualMarkForDisplayInfo.t = HardCodeUtil.a(2131897530);
    localMutualMarkForDisplayInfo.p = true;
    return localMutualMarkForDisplayInfo;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, NavBarAIO paramNavBarAIO, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (paramActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramNavBarAIO != null) && (paramImageView1 != null))
    {
      if (paramImageView2 == null) {
        return;
      }
      ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString, new TroopHonorAIOUtils.1(paramImageView1, paramImageView2, paramQQAppInterface, paramActivity, paramBoolean, paramNavBarAIO));
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (AnonymousChatHelper.c(paramMessageRecord)) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForTroopConfess)) {
      return false;
    }
    if ("1000000".equals(paramMessageRecord.senderuin)) {
      return false;
    }
    return !((ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramMessageRecord.senderuin);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramString) != null;
  }
  
  private static boolean c(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ImageView> paramList, List<MutualMarkForDisplayInfo> paramList1, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() == 2) && (paramList1 != null) && (paramList1.size() < 2))
    {
      if (paramTroopInfo == null) {
        return false;
      }
      Object localObject = TroopLuckyCharacterUtil.b(paramQQAppInterface, paramTroopInfo);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return false;
      }
      localObject = a((String)localObject);
      if (localObject == null) {
        return false;
      }
      paramList = (ImageView)paramList.get(paramList1.size());
      if (paramList != null)
      {
        paramList1.add(localObject);
        paramList.setTag(localObject);
        paramList.setOnTouchListener(a(paramQQAppInterface, paramBoolean, paramActivity, paramTroopInfo.troopuin));
        return true;
      }
    }
    return false;
  }
  
  private static void d(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ImageView> paramList, List<MutualMarkForDisplayInfo> paramList1, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() == 2) && (paramList1 != null) && (paramList1.size() < 2))
    {
      if (paramTroopInfo == null) {
        return;
      }
      Object localObject = (ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "");
      if (!((ITroopHonorService)localObject).isSupportTroopHonor(paramTroopInfo.troopuin)) {
        return;
      }
      localObject = ((ITroopHonorService)localObject).convertToHonorList(paramTroopInfo.myHonorList, Byte.valueOf(paramTroopInfo.myHonorRichFlag));
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        if (((List)localObject).size() > 1) {
          Collections.sort((List)localObject, new TroopHonorAIOUtils.2());
        }
        MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = a((TroopHonor)((List)localObject).get(0));
        if (localMutualMarkForDisplayInfo != null)
        {
          ImageView localImageView = (ImageView)paramList.get(paramList1.size());
          if (localImageView != null)
          {
            localImageView.setTag(localMutualMarkForDisplayInfo);
            paramList1.add(localMutualMarkForDisplayInfo);
            localImageView.setOnTouchListener(a(paramQQAppInterface, paramBoolean, paramActivity, paramTroopInfo.troopuin));
          }
        }
        if (paramList1.size() < 2)
        {
          if (((List)localObject).size() > 1) {
            localObject = a((TroopHonor)((List)localObject).get(1));
          } else {
            localObject = null;
          }
          if (localObject != null)
          {
            paramList = (ImageView)paramList.get(paramList1.size());
            if (paramList != null)
            {
              paramList1.add(localObject);
              paramList.setTag(localObject);
              paramList.setOnTouchListener(a(paramQQAppInterface, paramBoolean, paramActivity, paramTroopInfo.troopuin));
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils
 * JD-Core Version:    0.7.0.1
 */