package com.tencent.mobileqq.troop.blocktroop;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter.ViewTag;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.app.Foreground;

public class TroopBlockUtils
{
  protected static String a = "mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fsubmit%2Fstep2%2Fstep2&_vt=3&via=tencent_csd&_sig=1454231204&_nq=billid%3D200708selfqa204d82d5";
  
  public static QQCustomDialog a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, TroopBlockUtils.ConstantBlockDialogCallback paramConstantBlockDialogCallback)
  {
    Object localObject1 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    boolean bool5 = true;
    if (localObject1 != null)
    {
      localObject1 = ((TroopManager)localObject1).f(paramString);
      if (localObject1 != null)
      {
        if ((((TroopInfo)localObject1).dwAdditionalFlag & 1L) == 1L) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if ((((TroopInfo)localObject1).dwCmdUinUinFlag & 1L) == 1L) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        boolean bool6 = a(paramString);
        boolean bool4;
        if (System.currentTimeMillis() < ((TroopInfo)localObject1).appealDeadline * 1000L) {
          bool4 = true;
        } else {
          bool4 = false;
        }
        if (((bool1) || (bool2)) && (bool4) && (bool6)) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("showConstantBlockDialog. isOwner = ");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append(", isAdmin = ");
          ((StringBuilder)localObject2).append(bool2);
          ((StringBuilder)localObject2).append(", appealDeadline = ");
          ((StringBuilder)localObject2).append(((TroopInfo)localObject1).appealDeadline);
          ((StringBuilder)localObject2).append(", isWithAppealPeriod = ");
          ((StringBuilder)localObject2).append(bool4);
          ((StringBuilder)localObject2).append(", isGrayTroop = ");
          ((StringBuilder)localObject2).append(bool6);
          ((StringBuilder)localObject2).append(", canAppeal = ");
          ((StringBuilder)localObject2).append(bool3);
          QLog.d("TroopBlockUtils", 2, ((StringBuilder)localObject2).toString());
        }
        if (bool3)
        {
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).setTimeInMillis(((TroopInfo)localObject1).appealDeadline * 1000L);
          localObject1 = paramActivity.getString(2131895069, new Object[] { Integer.valueOf(((Calendar)localObject2).get(1)), Integer.valueOf(((Calendar)localObject2).get(2) + 1), Integer.valueOf(((Calendar)localObject2).get(5)) });
          break label360;
        }
        localObject1 = "";
        break label360;
      }
    }
    localObject1 = "";
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    label360:
    Object localObject2 = DialogUtil.a(paramActivity, 230).setTitle(paramActivity.getString(2131895070)).setMessage(2131895068);
    if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
    }
    if ((!bool1) && (!bool2)) {
      ReportController.b(null, "dc00898", "", "", "0X800B225", "0X800B225", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "dc00898", "", "", "0X800B222", "0X800B222", 0, 0, "", "", "", "");
    }
    if (bool3)
    {
      ((QQCustomDialog)localObject2).setPositiveButton(paramActivity.getString(2131895067), new TroopBlockUtils.1(paramQQAppInterface, paramString, paramActivity));
      ((QQCustomDialog)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131895067));
    }
    else if (bool1)
    {
      ((QQCustomDialog)localObject2).setPositiveButton(paramActivity.getString(2131895066), new TroopBlockUtils.2(paramQQAppInterface, paramString));
      ((QQCustomDialog)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131895066));
    }
    else
    {
      ((QQCustomDialog)localObject2).setPositiveButton(paramActivity.getString(2131895065), new TroopBlockUtils.3(paramQQAppInterface, paramString));
      ((QQCustomDialog)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131895065));
    }
    bool3 = bool5;
    if (!bool1) {
      if (bool2) {
        bool3 = bool5;
      } else {
        bool3 = false;
      }
    }
    ((QQCustomDialog)localObject2).setNegativeButton(paramActivity.getString(2131898212), new TroopBlockUtils.4(paramConstantBlockDialogCallback, bool3));
    ((QQCustomDialog)localObject2).setNegativeButtonContentDescription(paramActivity.getString(2131898212));
    ((QQCustomDialog)localObject2).setCancelable(false);
    try
    {
      if (!paramActivity.isFinishing())
      {
        ((QQCustomDialog)localObject2).show();
        return localObject2;
      }
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("showConstantBlockDialog exception: ");
        paramQQAppInterface.append(paramActivity.getMessage());
        QLog.e("TroopBlockUtils", 2, paramQQAppInterface.toString());
      }
    }
    return localObject2;
  }
  
  public static void a(View paramView, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockUtils", 2, "updateSearchResultItemViewStatus");
    }
    ImageView localImageView = (ImageView)paramView.findViewById(2131446321);
    paramView = (ImageView)paramView.findViewById(2131436452);
    if (localImageView != null) {
      if (paramInt1 == 1)
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if ((localQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
        {
          if (b(localQQAppInterface, paramString))
          {
            localImageView.setImageResource(2130853326);
            localImageView.setVisibility(0);
            paramString = localImageView.getLayoutParams();
            if ((paramString != null) && ((paramString instanceof RelativeLayout.LayoutParams))) {
              if (paramInt2 == 2)
              {
                paramString = (RelativeLayout.LayoutParams)paramString;
                paramString.bottomMargin = (-ViewUtils.dpToPx(6.0F));
                paramString.rightMargin = (-ViewUtils.dpToPx(3.0F));
              }
              else
              {
                paramString = (RelativeLayout.LayoutParams)paramString;
                paramString.bottomMargin = (-ViewUtils.dpToPx(3.0F));
                paramString.rightMargin = (-ViewUtils.dpToPx(3.0F));
              }
            }
            if (paramView != null)
            {
              paramView.setVisibility(0);
              if (SimpleUIUtil.e())
              {
                paramView.setBackgroundResource(2130843522);
                return;
              }
              paramView.setBackgroundResource(2130843521);
            }
          }
          else
          {
            localImageView.setVisibility(8);
            if (paramView != null) {
              paramView.setVisibility(8);
            }
          }
        }
        else
        {
          localImageView.setVisibility(8);
          if (paramView != null) {
            paramView.setVisibility(8);
          }
        }
      }
      else
      {
        localImageView.setVisibility(8);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
    }
  }
  
  public static void a(ContactsSearchResultAdapter.ViewTag paramViewTag, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockUtils", 2, "updateSearchResultItemViewStatus");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (b(localQQAppInterface, paramString))
      {
        paramViewTag.d.setImageResource(2130853326);
        paramString = paramViewTag.d.getLayoutParams();
        if ((paramString != null) && ((paramString instanceof RelativeLayout.LayoutParams)))
        {
          paramString = (RelativeLayout.LayoutParams)paramString;
          paramString.bottomMargin = (-ViewUtils.dpToPx(3.0F));
          paramString.rightMargin = (-ViewUtils.dpToPx(3.0F));
        }
        if (paramViewTag.f != null)
        {
          paramViewTag.f.setVisibility(0);
          if (SimpleUIUtil.e())
          {
            paramViewTag.f.setBackgroundResource(2130843522);
            return;
          }
          paramViewTag.f.setBackgroundResource(2130843521);
        }
      }
      else if (paramViewTag.f != null)
      {
        paramViewTag.f.setVisibility(8);
      }
    }
    else if (paramViewTag.f != null) {
      paramViewTag.f.setVisibility(8);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ((ITroopListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
  }
  
  public static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    if ((paramIntent.getIntExtra("uintype", -1) == 1) && (str != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBlockUtils", 2, "checkBlockTroopBeforeEnterAio");
      }
      if (b(paramQQAppInterface, str))
      {
        if ((paramActivity instanceof ChatActivity))
        {
          paramIntent = Foreground.getTopActivity();
          if ((paramIntent != null) && (paramIntent != paramActivity))
          {
            paramActivity.finish();
            a(paramIntent, paramQQAppInterface, str, null);
            return true;
          }
          a(paramActivity, paramQQAppInterface, str, null);
          return true;
        }
        a(paramActivity, paramQQAppInterface, str, null);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString, false, false);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.isTroopBlocked;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    TroopBlockConfig localTroopBlockConfig = (TroopBlockConfig)QConfigManager.b().b(673);
    boolean bool;
    if ((localTroopBlockConfig != null) && (localTroopBlockConfig.b(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isGrayTroop = ");
      paramString.append(bool);
      QLog.d("TroopBlockUtils", 2, paramString.toString());
    }
    return bool;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.f(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.isTroopBlocked;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockUtils", 2, "isConstantBlockTroop. TroopManager is null. isConstantBlockTroop = false");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils
 * JD-Core Version:    0.7.0.1
 */