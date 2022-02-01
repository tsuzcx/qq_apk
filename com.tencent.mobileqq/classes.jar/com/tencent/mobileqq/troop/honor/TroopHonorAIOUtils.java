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
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
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
      localMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString = paramTroopHonor.b;
      String str = paramTroopHonor.jdField_a_of_type_JavaLangString;
      localMutualMarkForDisplayInfo.jdField_a_of_type_JavaLangString = str;
      localMutualMarkForDisplayInfo.d = str;
      localMutualMarkForDisplayInfo.jdField_a_of_type_Long = paramTroopHonor.jdField_a_of_type_Int;
      localMutualMarkForDisplayInfo.jdField_c_of_type_Boolean = true;
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
    localMutualMarkForDisplayInfo.jdField_c_of_type_JavaLangString = paramString;
    localMutualMarkForDisplayInfo.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131699394);
    localMutualMarkForDisplayInfo.d = HardCodeUtil.a(2131699394);
    localMutualMarkForDisplayInfo.jdField_c_of_type_Boolean = true;
    return localMutualMarkForDisplayInfo;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, NavBarAIO paramNavBarAIO, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (TextUtils.isEmpty(paramString)) || (paramNavBarAIO == null) || (paramImageView1 == null) || (paramImageView2 == null)) {
      return;
    }
    ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString, new TroopHonorAIOUtils.1(paramImageView1, paramImageView2, paramQQAppInterface, paramActivity, paramBoolean, paramNavBarAIO));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (AnonymousChatHelper.a(paramMessageRecord)) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForTroopConfess)) {
      return false;
    }
    if ("1000000".equals(paramMessageRecord.senderuin)) {
      return false;
    }
    return !((TroopRobotManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).b(paramMessageRecord.senderuin);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString) != null;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ImageView> paramList, List<MutualMarkForDisplayInfo> paramList1, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() != 2) || (paramList1 == null) || (paramList1.size() >= 2) || (paramTroopInfo == null)) {}
    label296:
    for (;;)
    {
      return;
      Object localObject = (ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "");
      if (((ITroopHonorService)localObject).isSupportTroopHonor(paramTroopInfo.troopuin))
      {
        localObject = ((ITroopHonorService)localObject).convertToHonorList(paramTroopInfo.myHonorList, Byte.valueOf(paramTroopInfo.myHonorRichFlag));
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
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
            if (((List)localObject).size() > 1) {}
            for (localObject = a((TroopHonor)((List)localObject).get(1));; localObject = null)
            {
              if (localObject == null) {
                break label296;
              }
              paramList = (ImageView)paramList.get(paramList1.size());
              if (paramList == null) {
                break;
              }
              paramList1.add(localObject);
              paramList.setTag(localObject);
              paramList.setOnTouchListener(a(paramQQAppInterface, paramBoolean, paramActivity, paramTroopInfo.troopuin));
              return;
            }
          }
        }
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ImageView> paramList, List<MutualMarkForDisplayInfo> paramList1, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() != 2) || (paramList1 == null) || (paramList1.size() >= 2) || (paramTroopInfo == null)) {
      return false;
    }
    Object localObject = TroopLuckyCharacterUtil.a(paramQQAppInterface, paramTroopInfo);
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils
 * JD-Core Version:    0.7.0.1
 */