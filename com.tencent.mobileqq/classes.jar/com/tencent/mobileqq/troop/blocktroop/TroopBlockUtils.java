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
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
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
    boolean bool1;
    boolean bool2;
    label60:
    boolean bool4;
    label85:
    boolean bool3;
    label108:
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((TroopManager)localObject1).b(paramString);
      if (localObject1 != null) {
        if ((((TroopInfo)localObject1).dwAdditionalFlag & 1L) == 1L)
        {
          bool1 = true;
          if ((((TroopInfo)localObject1).dwCmdUinUinFlag & 1L) != 1L) {
            break label468;
          }
          bool2 = true;
          boolean bool5 = a(paramString);
          if (System.currentTimeMillis() >= ((TroopInfo)localObject1).appealDeadline * 1000L) {
            break label474;
          }
          bool4 = true;
          if (((!bool1) && (!bool2)) || (!bool4) || (!bool5)) {
            break label480;
          }
          bool3 = true;
          if (QLog.isColorLevel()) {
            QLog.d("TroopBlockUtils", 2, "showConstantBlockDialog. isOwner = " + bool1 + ", isAdmin = " + bool2 + ", appealDeadline = " + ((TroopInfo)localObject1).appealDeadline + ", isWithAppealPeriod = " + bool4 + ", isGrayTroop = " + bool5 + ", canAppeal = " + bool3);
          }
          if (!bool3) {
            break label632;
          }
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).setTimeInMillis(((TroopInfo)localObject1).appealDeadline * 1000L);
          localObject1 = paramActivity.getString(2131697277, new Object[] { Integer.valueOf(((Calendar)localObject2).get(1)), Integer.valueOf(((Calendar)localObject2).get(2) + 1), Integer.valueOf(((Calendar)localObject2).get(5)) });
          bool4 = bool3;
          bool3 = bool1;
          bool1 = bool4;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject2 = DialogUtil.a(paramActivity, 230).setTitle(paramActivity.getString(2131697278)).setMessage(2131697276);
        if ((bool1) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
        }
        if ((bool3) || (bool2))
        {
          ReportController.b(null, "dc00898", "", "", "0X800B222", "0X800B222", 0, 0, "", "", "", "");
          label357:
          if (!bool1) {
            break label513;
          }
          ((QQCustomDialog)localObject2).setPositiveButton(paramActivity.getString(2131697275), new TroopBlockUtils.1(paramQQAppInterface, paramString, paramActivity));
          ((QQCustomDialog)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131697275));
          label395:
          if ((!bool3) && (!bool2)) {
            break label588;
          }
          bool1 = true;
          ((QQCustomDialog)localObject2).setNegativeButton(paramActivity.getString(2131715130), new TroopBlockUtils.4(paramConstantBlockDialogCallback, bool1));
          ((QQCustomDialog)localObject2).setNegativeButtonContentDescription(paramActivity.getString(2131715130));
          ((QQCustomDialog)localObject2).setCancelable(false);
        }
        try
        {
          if (!paramActivity.isFinishing()) {
            ((QQCustomDialog)localObject2).show();
          }
          return localObject2;
          bool1 = false;
          break;
          label468:
          bool2 = false;
          break label60;
          label474:
          bool4 = false;
          break label85;
          label480:
          bool3 = false;
          break label108;
          ReportController.b(null, "dc00898", "", "", "0X800B225", "0X800B225", 0, 0, "", "", "", "");
          break label357;
          label513:
          if (bool3)
          {
            ((QQCustomDialog)localObject2).setPositiveButton(paramActivity.getString(2131697274), new TroopBlockUtils.2(paramQQAppInterface, paramString));
            ((QQCustomDialog)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131697274));
            break label395;
          }
          ((QQCustomDialog)localObject2).setPositiveButton(paramActivity.getString(2131697273), new TroopBlockUtils.3(paramQQAppInterface, paramString));
          ((QQCustomDialog)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131697273));
          break label395;
          label588:
          bool1 = false;
        }
        catch (Exception paramActivity)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("TroopBlockUtils", 2, "showConstantBlockDialog exception: " + paramActivity.getMessage());
          return localObject2;
        }
      }
      label632:
      bool4 = bool1;
      localObject1 = "";
      bool1 = bool3;
      bool3 = bool4;
      continue;
      localObject1 = "";
      bool1 = false;
      bool2 = false;
      bool3 = false;
    }
  }
  
  public static void a(View paramView, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockUtils", 2, "updateSearchResultItemViewStatus");
    }
    ImageView localImageView = (ImageView)paramView.findViewById(2131378434);
    paramView = (ImageView)paramView.findViewById(2131369718);
    if (localImageView != null)
    {
      if (paramInt1 != 1) {
        break label238;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
        break label220;
      }
      if (!b(localQQAppInterface, paramString)) {
        break label202;
      }
      localImageView.setImageResource(2130851175);
      localImageView.setVisibility(0);
      paramString = localImageView.getLayoutParams();
      if ((paramString != null) && ((paramString instanceof RelativeLayout.LayoutParams)))
      {
        if (paramInt2 != 2) {
          break label163;
        }
        ((RelativeLayout.LayoutParams)paramString).bottomMargin = (-ViewUtils.b(6.0F));
        ((RelativeLayout.LayoutParams)paramString).rightMargin = (-ViewUtils.b(3.0F));
      }
      if (paramView != null)
      {
        paramView.setVisibility(0);
        if (!SimpleUIUtil.a()) {
          break label194;
        }
        paramView.setBackgroundResource(2130842670);
      }
    }
    label163:
    label194:
    label202:
    label220:
    label238:
    do
    {
      do
      {
        do
        {
          return;
          ((RelativeLayout.LayoutParams)paramString).bottomMargin = (-ViewUtils.b(3.0F));
          ((RelativeLayout.LayoutParams)paramString).rightMargin = (-ViewUtils.b(3.0F));
          break;
          paramView.setBackgroundResource(2130842669);
          return;
          localImageView.setVisibility(8);
        } while (paramView == null);
        paramView.setVisibility(8);
        return;
        localImageView.setVisibility(8);
      } while (paramView == null);
      paramView.setVisibility(8);
      return;
      localImageView.setVisibility(8);
    } while (paramView == null);
    paramView.setVisibility(8);
  }
  
  public static void a(ContactsSearchResultAdapter.ViewTag paramViewTag, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockUtils", 2, "updateSearchResultItemViewStatus");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (!TextUtils.isEmpty(paramString))) {
      if (b(localQQAppInterface, paramString))
      {
        paramViewTag.b.setImageResource(2130851175);
        paramString = paramViewTag.b.getLayoutParams();
        if ((paramString != null) && ((paramString instanceof RelativeLayout.LayoutParams)))
        {
          ((RelativeLayout.LayoutParams)paramString).bottomMargin = (-ViewUtils.b(3.0F));
          ((RelativeLayout.LayoutParams)paramString).rightMargin = (-ViewUtils.b(3.0F));
        }
        if (paramViewTag.d != null)
        {
          paramViewTag.d.setVisibility(0);
          if (!SimpleUIUtil.a()) {
            break label131;
          }
          paramViewTag.d.setBackgroundResource(2130842670);
        }
      }
    }
    label131:
    while (paramViewTag.d == null)
    {
      do
      {
        return;
        paramViewTag.d.setBackgroundResource(2130842669);
        return;
      } while (paramViewTag.d == null);
      paramViewTag.d.setVisibility(8);
      return;
    }
    paramViewTag.d.setVisibility(8);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ((TroopListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).notifyUI(TroopNotificationConstants.aC, true, null);
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
    TroopBlockConfig localTroopBlockConfig = (TroopBlockConfig)QConfigManager.a().a(673);
    if ((localTroopBlockConfig != null) && (localTroopBlockConfig.a(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBlockUtils", 2, "isGrayTroop = " + bool);
      }
      return bool;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils
 * JD-Core Version:    0.7.0.1
 */