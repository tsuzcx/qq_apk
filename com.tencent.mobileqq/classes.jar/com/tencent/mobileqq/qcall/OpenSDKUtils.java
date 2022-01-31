package com.tencent.mobileqq.qcall;

import agtx;
import agty;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phone.PhoneNumberInfo;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class OpenSDKUtils
{
  public static Bitmap a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    QLog.d("OpenSDKUtils", 2, "getOpenSDKUserFaceBitmap phoneNumber = " + paramString);
    Object localObject2 = localObject1;
    if (paramQQAppInterface != null)
    {
      localObject2 = localObject1;
      if (paramString != null)
      {
        if (paramString.startsWith("+")) {
          break label55;
        }
        localObject2 = localObject1;
      }
    }
    label55:
    do
    {
      return localObject2;
      localObject1 = localObject3;
      if (a(paramQQAppInterface, paramString)) {
        localObject1 = paramQQAppInterface.a(11, paramString, (byte)3, true, 0);
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return ImageUtil.a();
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    QLog.d("OpenSDKUtils", 2, "getOpenSDKUserFaceBitmap phoneNumber = " + paramString);
    Object localObject2 = localObject1;
    if (paramQQAppInterface != null)
    {
      localObject2 = localObject1;
      if (paramString != null)
      {
        if (paramString.startsWith("+")) {
          break label55;
        }
        localObject2 = localObject1;
      }
    }
    label55:
    do
    {
      return localObject2;
      localObject1 = localObject3;
      if (a(paramQQAppInterface, paramString)) {
        localObject1 = FaceDrawable.b(paramQQAppInterface, paramString, (byte)3);
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return ImageUtil.b();
  }
  
  public static PhoneContact a(QQAppInterface paramQQAppInterface, String paramString)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (localPhoneContactManager != null)
    {
      PhoneContact localPhoneContact = localPhoneContactManager.c(paramString);
      PhoneNumberInfo localPhoneNumberInfo = PhoneNumberUtil.a(paramString);
      paramQQAppInterface = localPhoneContact;
      if (localPhoneContact == null) {
        paramQQAppInterface = localPhoneContactManager.b(localPhoneNumberInfo.c);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramString = localPhoneContactManager.b("+" + localPhoneNumberInfo.a + localPhoneNumberInfo.c);
      }
      paramQQAppInterface = paramString;
      if (paramString == null) {
        paramQQAppInterface = localPhoneContactManager.b(localPhoneNumberInfo.a + localPhoneNumberInfo.c);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramString = localPhoneContactManager.b("00" + localPhoneNumberInfo.a + localPhoneNumberInfo.c);
      }
      if (paramString == null) {
        return localPhoneContactManager.b(localPhoneNumberInfo.a + "-" + localPhoneNumberInfo.c);
      }
      return paramString;
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName phoneNumber = " + paramString);
    if ((paramQQAppInterface == null) || (paramString == null) || (!paramString.startsWith("+")))
    {
      paramQQAppInterface = "";
      return paramQQAppInterface;
    }
    Object localObject2 = a(paramQQAppInterface, paramString);
    Object localObject1;
    if (localObject2 != null) {
      localObject1 = ((PhoneContact)localObject2).name;
    }
    for (String str = ((PhoneContact)localObject2).uin;; str = null)
    {
      QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName contactName = " + (String)localObject1 + "uin = " + str);
      localObject2 = localObject4;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = localObject4;
        if (!str.equals("0"))
        {
          localObject2 = ((FriendsManager)paramQQAppInterface.getManager(50)).c(str);
          paramQQAppInterface = localObject3;
          if (localObject2 != null)
          {
            if ((((Friends)localObject2).remark == null) || (((Friends)localObject2).remark.length() <= 0)) {
              break label225;
            }
            paramQQAppInterface = ((Friends)localObject2).remark;
          }
          label177:
          QLog.d("OpenSDKUtils", 2, "getOpenSDKUserDisplayName FriendDisplayName = " + paramQQAppInterface);
          localObject2 = paramQQAppInterface;
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      for (;;)
      {
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        return a(paramString);
        label225:
        paramQQAppInterface = localObject3;
        if (((Friends)localObject2).name == null) {
          break label177;
        }
        paramQQAppInterface = localObject3;
        if (((Friends)localObject2).name.length() <= 0) {
          break label177;
        }
        paramQQAppInterface = ((Friends)localObject2).name;
        break label177;
        localObject1 = localObject2;
      }
      localObject1 = null;
    }
  }
  
  public static String a(String paramString)
  {
    PhoneNumberInfo localPhoneNumberInfo = PhoneNumberUtil.a(paramString);
    if (localPhoneNumberInfo.a.equals("86")) {
      paramString = localPhoneNumberInfo.c;
    }
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt1, PstnSessionInfo paramPstnSessionInfo, int paramInt2)
  {
    QLog.d("OpenSDKUtils", 2, "enterActionSheet phoneNumber = " + paramString + "pstnStatus = " + paramInt1);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int[] arrayOfInt = new int[2];
    int[] tmp49_47 = arrayOfInt;
    tmp49_47[0] = 0;
    int[] tmp53_49 = tmp49_47;
    tmp53_49[1] = 1;
    tmp53_49;
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    localActionSheet.a(2131438345);
    switch (paramInt1)
    {
    case 3: 
    case 4: 
    default: 
      arrayOfInt[0] = 1;
      localActionSheet.b(2131438043);
    }
    for (;;)
    {
      localActionSheet.c(2131433015);
      localActionSheet.a(new agtx());
      localActionSheet.a(new agty(localActionSheet, arrayOfInt, paramInt1, paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt2, paramString));
      localActionSheet.show();
      return;
      localActionSheet.a(paramContext.getResources().getString(2131438343), paramContext.getResources().getDrawable(2130840359), 0);
      continue;
      localActionSheet.a(paramContext.getResources().getString(2131438343), paramContext.getResources().getDrawable(2130840358), 0);
      continue;
      localActionSheet.a(paramContext.getResources().getString(2131438343), paramContext.getResources().getDrawable(2130840357), 0);
      localActionSheet.b(2131438043);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.c(paramString);; paramQQAppInterface = null) {
      return (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.uin));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.OpenSDKUtils
 * JD-Core Version:    0.7.0.1
 */