package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phone.PhoneNumberInfo;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class OpenSDKUtils
{
  public static Bitmap a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getOpenSDKUserFaceBitmap phoneNumber = ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("OpenSDKUtils", 2, ((StringBuilder)localObject1).toString());
    Object localObject2 = null;
    Bitmap localBitmap = null;
    localObject1 = localObject2;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (paramString != null)
      {
        if (!paramString.startsWith("+")) {
          return null;
        }
        if (a(paramQQAppInterface, paramString)) {
          localBitmap = paramQQAppInterface.getFaceBitmap(11, paramString, (byte)3, true, 0);
        }
        localObject1 = localBitmap;
        if (localBitmap == null) {
          localObject1 = ImageUtil.f();
        }
      }
    }
    return localObject1;
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getOpenSDKUserFaceBitmap phoneNumber = ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("OpenSDKUtils", 2, ((StringBuilder)localObject1).toString());
    Object localObject2 = null;
    FaceDrawable localFaceDrawable = null;
    localObject1 = localObject2;
    if (paramQQAppInterface != null)
    {
      localObject1 = localObject2;
      if (paramString != null)
      {
        if (!paramString.startsWith("+")) {
          return null;
        }
        if (a(paramQQAppInterface, paramString)) {
          localFaceDrawable = FaceDrawable.getMobileFaceDrawable(paramQQAppInterface, paramString, (byte)3);
        }
        localObject1 = localFaceDrawable;
        if (localFaceDrawable == null) {
          localObject1 = ImageUtil.e();
        }
      }
    }
    return localObject1;
  }
  
  public static PhoneContact a(QQAppInterface paramQQAppInterface, String paramString)
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (localIPhoneContactService != null)
    {
      PhoneContact localPhoneContact = localIPhoneContactService.queryContactByCodeNumber(paramString);
      PhoneNumberInfo localPhoneNumberInfo = PhoneNumberUtil.a(paramString);
      paramQQAppInterface = localPhoneContact;
      if (localPhoneContact == null) {
        paramQQAppInterface = localIPhoneContactService.queryPhoneContactByMobile(localPhoneNumberInfo.c);
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("+");
        paramQQAppInterface.append(localPhoneNumberInfo.a);
        paramQQAppInterface.append(localPhoneNumberInfo.c);
        paramString = localIPhoneContactService.queryPhoneContactByMobile(paramQQAppInterface.toString());
      }
      paramQQAppInterface = paramString;
      if (paramString == null)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(localPhoneNumberInfo.a);
        paramQQAppInterface.append(localPhoneNumberInfo.c);
        paramQQAppInterface = localIPhoneContactService.queryPhoneContactByMobile(paramQQAppInterface.toString());
      }
      paramString = paramQQAppInterface;
      if (paramQQAppInterface == null)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("00");
        paramQQAppInterface.append(localPhoneNumberInfo.a);
        paramQQAppInterface.append(localPhoneNumberInfo.c);
        paramString = localIPhoneContactService.queryPhoneContactByMobile(paramQQAppInterface.toString());
      }
      paramQQAppInterface = paramString;
      if (paramString == null)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(localPhoneNumberInfo.a);
        paramQQAppInterface.append("-");
        paramQQAppInterface.append(localPhoneNumberInfo.c);
        return localIPhoneContactService.queryPhoneContactByMobile(paramQQAppInterface.toString());
      }
    }
    else
    {
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getOpenSDKUserDisplayName phoneNumber = ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("OpenSDKUtils", 2, ((StringBuilder)localObject1).toString());
    if ((paramQQAppInterface != null) && (paramString != null) && (paramString.startsWith("+")))
    {
      Object localObject2 = a(paramQQAppInterface, paramString);
      Object localObject4 = null;
      Object localObject3 = null;
      String str;
      if (localObject2 != null)
      {
        localObject1 = ((PhoneContact)localObject2).name;
        str = ((PhoneContact)localObject2).uin;
      }
      else
      {
        str = null;
        localObject1 = str;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getOpenSDKUserDisplayName contactName = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("uin = ");
      ((StringBuilder)localObject2).append(str);
      QLog.d("OpenSDKUtils", 2, ((StringBuilder)localObject2).toString());
      localObject2 = localObject4;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = localObject4;
        if (!str.equals("0"))
        {
          paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str);
          localObject2 = localObject3;
          if (paramQQAppInterface != null)
          {
            if ((paramQQAppInterface.remark != null) && (paramQQAppInterface.remark.length() > 0)) {}
            for (paramQQAppInterface = paramQQAppInterface.remark;; paramQQAppInterface = paramQQAppInterface.name)
            {
              localObject2 = paramQQAppInterface;
              break;
              localObject2 = localObject3;
              if (paramQQAppInterface.name == null) {
                break;
              }
              localObject2 = localObject3;
              if (paramQQAppInterface.name.length() <= 0) {
                break;
              }
            }
          }
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("getOpenSDKUserDisplayName FriendDisplayName = ");
          paramQQAppInterface.append((String)localObject2);
          QLog.d("OpenSDKUtils", 2, paramQQAppInterface.toString());
        }
      }
      paramQQAppInterface = (QQAppInterface)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        paramQQAppInterface = (QQAppInterface)localObject1;
      }
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return a(paramString);
      }
      return paramQQAppInterface;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    PhoneNumberInfo localPhoneNumberInfo = PhoneNumberUtil.a(paramString);
    if (localPhoneNumberInfo.a.equals("86")) {
      paramString = localPhoneNumberInfo.c;
    }
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterActionSheet phoneNumber = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("OpenSDKUtils", 2, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localObject = new int[1];
    localObject[0] = 1;
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    localActionSheet.setMainTitle(2131689542);
    localObject[0] = 1;
    localActionSheet.addButton(2131690721);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnDismissListener(new OpenSDKUtils.1());
    localActionSheet.setOnButtonClickListener(new OpenSDKUtils.2(localActionSheet, (int[])localObject, paramString, paramContext, paramQQAppInterface));
    localActionSheet.show();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if (paramQQAppInterface != null) {
      paramQQAppInterface = paramQQAppInterface.queryContactByCodeNumber(paramString);
    } else {
      paramQQAppInterface = null;
    }
    return (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.uin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.OpenSDKUtils
 * JD-Core Version:    0.7.0.1
 */