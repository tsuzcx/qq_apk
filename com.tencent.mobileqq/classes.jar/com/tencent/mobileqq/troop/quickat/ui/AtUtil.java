package com.tencent.mobileqq.troop.quickat.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ATroopMember;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.Arrays;

public class AtUtil
{
  public static int a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (AtTroopMemberSpan[])localEditable.getSpans(0, paramEditText.getSelectionStart(), AtTroopMemberSpan.class);
    if ((paramEditText != null) && (paramEditText.length != 0))
    {
      Arrays.sort(paramEditText, new AtUtil.2(localEditable));
      return localEditable.getSpanEnd(paramEditText[(paramEditText.length - 1)]);
    }
    return -1;
  }
  
  public static ChatHistoryTroopMemberFragment.ATroopMember a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
    localATroopMember.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.memberuin.trim();
    if (localObject != null) {
      localObject = ((FriendsManager)localObject).b(paramTroopMemberInfo.memberuin);
    } else {
      localObject = null;
    }
    localATroopMember.jdField_b_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, paramTroopMemberInfo.troopuin, localATroopMember.jdField_a_of_type_JavaLangString, true);
    localATroopMember.jdField_a_of_type_Short = paramTroopMemberInfo.faceid;
    if ((paramTroopMemberInfo.friendnick != null) && (paramTroopMemberInfo.friendnick.length() > 0))
    {
      localATroopMember.b(paramTroopMemberInfo.friendnick);
      localATroopMember.d(paramTroopMemberInfo.pyAll_friendnick);
      localATroopMember.c(paramTroopMemberInfo.pyFirst_friendnick);
    }
    if ((localObject != null) && (((Friends)localObject).isFriend()) && (((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0) && (!((Friends)localObject).remark.equals(((Friends)localObject).name)))
    {
      localATroopMember.e(((Friends)localObject).remark);
      localATroopMember.h(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 1));
      localATroopMember.f(ChnToSpell.a(localATroopMember.jdField_j_of_type_JavaLangString, 2));
      localATroopMember.g(((Friends)localObject).remark);
    }
    else if ((paramTroopMemberInfo.autoremark != null) && (paramTroopMemberInfo.autoremark.length() > 0) && (QLog.isColorLevel()))
    {
      QLog.d("AtUtil", 2, new Object[] { "convertTroopMemberInfo: invoked. ", " tmi.autoremark: ", paramTroopMemberInfo.autoremark });
    }
    localATroopMember.i(paramTroopMemberInfo.troopnick);
    localATroopMember.a(paramTroopMemberInfo.troopColorNickId);
    localATroopMember.k(paramTroopMemberInfo.pyAll_troopnick);
    localATroopMember.j(paramTroopMemberInfo.pyFirst_troopnick);
    localATroopMember.jdField_b_of_type_Long = paramTroopMemberInfo.last_active_time;
    localATroopMember.jdField_a_of_type_Long = paramTroopMemberInfo.join_time;
    localATroopMember.jdField_b_of_type_Int = paramTroopMemberInfo.level;
    localATroopMember.jdField_d_of_type_Int = paramTroopMemberInfo.realLevel;
    localATroopMember.e = paramTroopMemberInfo.newRealLevel;
    localATroopMember.jdField_d_of_type_Long = paramTroopMemberInfo.credit_level;
    localATroopMember.jdField_a_of_type_Boolean = paramTroopMemberInfo.isTroopFollowed;
    localATroopMember.jdField_c_of_type_Long = paramTroopMemberInfo.active_point;
    localATroopMember.jdField_b_of_type_Boolean = paramTroopMemberInfo.mIsShielded;
    localATroopMember.f = paramTroopMemberInfo.globalTroopLevel;
    double d1 = ((IBizTroopMemberInfoService)paramQQAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberDiatanceToSelf(paramTroopMemberInfo.troopuin, localATroopMember.jdField_a_of_type_JavaLangString);
    if ((d1 != -1000.0D) && (d1 != -100.0D))
    {
      double d2 = d1 / 1000.0D;
      d1 = d2;
      if (d2 < 0.01D) {
        d1 = 0.01D;
      }
      if (d1 > 10.0D)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append((int)d1);
        paramQQAppInterface.append("km");
        localATroopMember.t = paramQQAppInterface.toString();
      }
      else
      {
        paramQQAppInterface = new DecimalFormat("#.##");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramQQAppInterface.format(d1));
        ((StringBuilder)localObject).append("km");
        localATroopMember.t = ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localATroopMember.t = "";
    }
    if ((paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() > 0L) || (paramTroopMemberInfo.mUniqueTitleExpire == -1))
    {
      localATroopMember.u = paramTroopMemberInfo.mUniqueTitle;
      localATroopMember.jdField_c_of_type_Int = paramTroopMemberInfo.mUniqueTitleExpire;
    }
    localATroopMember.jdField_g_of_type_Int = paramTroopMemberInfo.mVipType;
    localATroopMember.jdField_h_of_type_Int = paramTroopMemberInfo.mVipLevel;
    localATroopMember.jdField_i_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
    localATroopMember.jdField_j_of_type_Int = paramTroopMemberInfo.mBigClubVipType;
    localATroopMember.jdField_k_of_type_Int = paramTroopMemberInfo.mBigClubVipLevel;
    localATroopMember.jdField_l_of_type_Int = paramTroopMemberInfo.mBigClubTemplateId;
    localATroopMember.jdField_c_of_type_JavaLangString = ChnToSpell.a(c(localATroopMember), 2);
    localATroopMember.a(ChnToSpell.a(c(localATroopMember), 1));
    localATroopMember.v = c(localATroopMember);
    localATroopMember.x = localATroopMember.jdField_c_of_type_JavaLangString;
    localATroopMember.w = localATroopMember.jdField_d_of_type_JavaLangString;
    return localATroopMember;
  }
  
  public static AtTroopMemberSpan a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (AtTroopMemberSpan[])localEditable.getSpans(0, paramEditText.getSelectionStart(), AtTroopMemberSpan.class);
    if ((paramEditText != null) && (paramEditText.length != 0))
    {
      Arrays.sort(paramEditText, new AtUtil.1(localEditable));
      return paramEditText[(paramEditText.length - 1)];
    }
    return null;
  }
  
  public static String a(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (!TextUtils.isEmpty(paramATroopMember.m)) {
      return paramATroopMember.m;
    }
    if (!TextUtils.isEmpty(paramATroopMember.jdField_g_of_type_JavaLangString)) {
      return paramATroopMember.jdField_g_of_type_JavaLangString;
    }
    return paramATroopMember.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a(EditText paramEditText, QQAppInterface paramQQAppInterface)
  {
    paramEditText = (AtTroopMemberSpan[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), AtTroopMemberSpan.class);
    if (paramEditText != null)
    {
      if (paramEditText.length == 0) {
        return false;
      }
      paramQQAppInterface = (ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
      int i = 0;
      while (i < paramEditText.length)
      {
        if (paramQQAppInterface.isRobotUin(paramEditText[i].a())) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    String str = paramTroopInfo.Administrator;
    return (paramQQAppInterface.getCurrentAccountUin().equals(paramTroopInfo.troopowneruin)) || ((str != null) && (str.contains(paramQQAppInterface.getCurrentAccountUin())));
  }
  
  public static boolean a(String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (paramTroopInfo == null) {
        return false;
      }
      paramTroopInfo = paramTroopInfo.Administrator;
      bool1 = bool2;
      if (paramTroopInfo != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.contains(paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.toLowerCase().contains(paramString2.toLowerCase());
    }
    return false;
  }
  
  public static int b(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getEditableText();
    paramEditText = (AtTroopMemberSpan[])localEditable.getSpans(0, paramEditText.getSelectionStart(), AtTroopMemberSpan.class);
    if ((paramEditText != null) && (paramEditText.length != 0))
    {
      Arrays.sort(paramEditText, new AtUtil.3(localEditable));
      return localEditable.getSpanStart(paramEditText[(paramEditText.length - 1)]);
    }
    return -1;
  }
  
  public static String b(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (!TextUtils.isEmpty(paramATroopMember.jdField_j_of_type_JavaLangString)) {
      return paramATroopMember.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramATroopMember.jdField_b_of_type_JavaLangString)) {
      return paramATroopMember.jdField_b_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramATroopMember.m)) {
      return paramATroopMember.m;
    }
    if (!TextUtils.isEmpty(paramATroopMember.jdField_g_of_type_JavaLangString)) {
      return paramATroopMember.jdField_g_of_type_JavaLangString;
    }
    return paramATroopMember.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    return (paramTroopInfo.isNewTroop) && (paramTroopInfo.wMemberNum <= 20);
  }
  
  public static boolean b(String paramString, TroopInfo paramTroopInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramTroopInfo != null)) {
      return paramString.equals(paramTroopInfo.troopowneruin);
    }
    return false;
  }
  
  public static String c(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (!TextUtils.isEmpty(paramATroopMember.jdField_j_of_type_JavaLangString)) {
      return paramATroopMember.jdField_j_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramATroopMember.m)) {
      return paramATroopMember.m;
    }
    if (!TextUtils.isEmpty(paramATroopMember.jdField_g_of_type_JavaLangString)) {
      return paramATroopMember.jdField_g_of_type_JavaLangString;
    }
    return paramATroopMember.jdField_a_of_type_JavaLangString;
  }
  
  public static String d(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (!TextUtils.isEmpty(paramATroopMember.jdField_k_of_type_JavaLangString)) {
      return paramATroopMember.jdField_k_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramATroopMember.n)) {
      return paramATroopMember.n;
    }
    if (!TextUtils.isEmpty(paramATroopMember.jdField_h_of_type_JavaLangString)) {
      return paramATroopMember.jdField_h_of_type_JavaLangString;
    }
    return null;
  }
  
  public static String e(ChatHistoryTroopMemberFragment.ATroopMember paramATroopMember)
  {
    if (!TextUtils.isEmpty(paramATroopMember.jdField_l_of_type_JavaLangString)) {
      return paramATroopMember.jdField_l_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramATroopMember.o)) {
      return paramATroopMember.o;
    }
    if (!TextUtils.isEmpty(paramATroopMember.jdField_i_of_type_JavaLangString)) {
      return paramATroopMember.jdField_i_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtUtil
 * JD-Core Version:    0.7.0.1
 */