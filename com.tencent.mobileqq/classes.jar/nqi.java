import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;

public class nqi
{
  public static String a = "AvGameEntranceUtil";
  
  public static long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e(a, 2, "transStringToLong parse err " + paramString.toString());
    }
    return 0L;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 104: 
      return paramContext.getResources().getString(2131690351);
    case 105: 
      return paramContext.getResources().getString(2131690352);
    }
    return paramContext.getResources().getString(2131690353);
  }
  
  public static String a(boolean paramBoolean, Context paramContext, int paramInt, long paramLong, String paramString)
  {
    if (paramBoolean) {
      switch (paramInt)
      {
      case 113: 
      case 114: 
      default: 
        if ((TextUtils.isEmpty(paramString)) || (a(paramInt))) {
          paramString = paramContext.getResources().getString(2131690467);
        }
        break;
      }
    }
    do
    {
      return paramString;
      return paramContext.getResources().getString(2131690319);
      return paramContext.getResources().getString(2131690320);
      return String.format(paramContext.getResources().getString(2131690315), new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(1000L * paramLong)) });
      return paramContext.getResources().getString(2131690321);
      return paramContext.getResources().getString(2131690316);
      return paramContext.getResources().getString(2131690322);
      switch (paramInt)
      {
      }
    } while ((!TextUtils.isEmpty(paramString)) && (!a(paramInt)));
    return paramContext.getResources().getString(2131690471);
    return paramContext.getResources().getString(2131690465);
    return paramContext.getResources().getString(2131690473);
    return paramContext.getResources().getString(2131690320);
    return String.format(paramContext.getResources().getString(2131690315), new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(1000L * paramLong)) });
    return paramContext.getResources().getString(2131690321);
    return paramContext.getResources().getString(2131690316);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null))
    {
      QLog.e(a, 2, "showErrorDialog CONTEXT NULL");
      return;
    }
    paramContext = bhdj.a(paramContext, 230);
    paramContext.setMessage(paramString).setPositiveButton(2131690469, new nqk());
    paramContext.show();
  }
  
  public static boolean a()
  {
    if (bdvn.a())
    {
      QLog.e(a, 2, "getStudyModeSwitch  ");
      return false;
    }
    if (!b())
    {
      QLog.e(a, 2, "is Surport Machine no!  ");
      return false;
    }
    nqg localnqg = (nqg)aqxe.a().a(642);
    if (localnqg != null) {}
    for (boolean bool = localnqg.a();; bool = false)
    {
      QLog.d(a, 2, "isShowInMsgPlusEntrance " + bool);
      return bool;
    }
  }
  
  private static boolean a(int paramInt)
  {
    if ((paramInt <= 120) && (paramInt >= 100)) {}
    while (paramInt == 1) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool1 = true;
    com.tencent.mobileqq.app.BaseActivity localBaseActivity;
    int i;
    mqq.app.BaseActivity localBaseActivity1;
    boolean bool3;
    if ((paramActivity instanceof com.tencent.mobileqq.app.BaseActivity))
    {
      localBaseActivity = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
      bool1 = localBaseActivity.isFinishing();
      i = 1;
      if (!(paramActivity instanceof mqq.app.BaseActivity)) {
        break label65;
      }
      localBaseActivity1 = (mqq.app.BaseActivity)paramActivity;
      bool3 = localBaseActivity1.isFinishing();
      i = 2;
    }
    for (;;)
    {
      if ((localBaseActivity != null) || (localBaseActivity1 != null)) {
        break label74;
      }
      return true;
      localBaseActivity = null;
      i = 0;
      break;
      label65:
      localBaseActivity1 = null;
      bool3 = bool1;
    }
    label74:
    boolean bool2 = true;
    bool1 = true;
    if (localBaseActivity != null) {
      if (localBaseActivity.checkSelfPermission("android.permission.CAMERA") == 0)
      {
        bool2 = true;
        if (localBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
          break label222;
        }
        bool1 = true;
      }
    }
    boolean bool4;
    for (;;)
    {
      bool4 = VideoController.a(paramActivity);
      if ((QLog.isDevelopLevel()) || (!bool2) || (!bool1) || (bool4)) {
        QLog.w(a, 1, "checkQAVPermission, Camera[" + bool2 + "], audio[" + bool1 + "], activityType[" + i + "], isScreenLocked[" + bool4 + "], isFinishing[" + bool3 + "]");
      }
      if ((!bool2) || (!bool1)) {
        break label271;
      }
      return true;
      bool2 = false;
      break;
      label222:
      bool1 = false;
      continue;
      if (localBaseActivity1 != null)
      {
        if (localBaseActivity1.checkSelfPermission("android.permission.CAMERA") == 0) {}
        for (bool2 = true;; bool2 = false)
        {
          if (localBaseActivity1.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label266;
          }
          bool1 = true;
          break;
        }
        label266:
        bool1 = false;
      }
    }
    label271:
    if (bool4)
    {
      paramOnClickListener.onClick(null, -1);
      return false;
    }
    paramActivity = new nql(paramOnClickListener);
    if ((!bool2) && (!bool1))
    {
      bdla.b(null, "dc00898", "", "", "0X800B03C", "0X800B03C", 0, 0, "", "", "", "");
      bdla.b(null, "dc00898", "", "", "0X800B03D", "0X800B03D", 0, 0, "", "", "", "");
      if (localBaseActivity != null) {
        localBaseActivity.requestPermissions(paramActivity, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      }
    }
    for (;;)
    {
      return false;
      if (localBaseActivity1 != null)
      {
        localBaseActivity1.requestPermissions(paramActivity, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
        continue;
        if (!bool2)
        {
          bdla.b(null, "dc00898", "", "", "0X800B03D", "0X800B03D", 0, 0, "", "", "", "");
          if (localBaseActivity != null) {
            localBaseActivity.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
          } else if (localBaseActivity1 != null) {
            localBaseActivity1.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
          }
        }
        else if (!bool1)
        {
          bdla.b(null, "dc00898", "", "", "0X800B03C", "0X800B03C", 0, 0, "", "", "", "");
          if (localBaseActivity != null) {
            localBaseActivity.requestPermissions(paramActivity, 3, new String[] { "android.permission.RECORD_AUDIO" });
          } else if (localBaseActivity1 != null) {
            localBaseActivity1.requestPermissions(paramActivity, 3, new String[] { "android.permission.RECORD_AUDIO" });
          }
        }
      }
    }
  }
  
  public static boolean a(com.tencent.mobileqq.app.BaseActivity paramBaseActivity, String paramString)
  {
    if ((paramBaseActivity == null) || (paramString == null)) {
      return false;
    }
    Object localObject = (TroopManager)paramBaseActivity.app.getManager(QQManagerFactory.TROOP_MANAGER);
    ncz localncz = (ncz)paramBaseActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if ((localObject == null) || (localncz == null)) {
      return false;
    }
    if (paramBaseActivity.app.getAVNotifyCenter().b(paramBaseActivity, paramString))
    {
      QQToast.a(paramBaseActivity, 2131690391, 1).b(paramBaseActivity.getResources().getDimensionPixelSize(2131299080));
      return true;
    }
    localObject = ((TroopManager)localObject).a(paramString);
    if ((localObject == null) || (((TroopInfo)localObject).isAdmin())) {
      return false;
    }
    if (localncz.c(paramString))
    {
      paramString = bhdj.a(paramBaseActivity, 230);
      paramString.setMessage(paramBaseActivity.getString(2131690319)).setPositiveButton(paramBaseActivity.getString(2131690469), new nqj());
      paramString.show();
      return true;
    }
    return false;
  }
  
  public static boolean b()
  {
    if (c()) {}
    while (nqm.a() != 0) {
      return true;
    }
    return false;
  }
  
  public static boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nqi
 * JD-Core Version:    0.7.0.1
 */