import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;

public class nhv
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
      return paramContext.getResources().getString(2131690287);
    case 105: 
      return paramContext.getResources().getString(2131690288);
    }
    return paramContext.getResources().getString(2131690289);
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
          paramString = paramContext.getResources().getString(2131690355);
        }
        break;
      }
    }
    do
    {
      return paramString;
      return paramContext.getResources().getString(2131690256);
      return paramContext.getResources().getString(2131690257);
      return String.format(paramContext.getResources().getString(2131690252), new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(1000L * paramLong)) });
      return paramContext.getResources().getString(2131690258);
      return paramContext.getResources().getString(2131690253);
      return paramContext.getResources().getString(2131690259);
      switch (paramInt)
      {
      }
    } while ((!TextUtils.isEmpty(paramString)) && (!a(paramInt)));
    return paramContext.getResources().getString(2131690359);
    return paramContext.getResources().getString(2131690353);
    return paramContext.getResources().getString(2131690361);
    return paramContext.getResources().getString(2131690257);
    return String.format(paramContext.getResources().getString(2131690252), new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(1000L * paramLong)) });
    return paramContext.getResources().getString(2131690258);
    return paramContext.getResources().getString(2131690253);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null))
    {
      QLog.e(a, 2, "showErrorDialog CONTEXT NULL");
      return;
    }
    paramContext = bhlq.a(paramContext, 230);
    paramContext.setMessage(paramString).setPositiveButton(2131690357, new nhx());
    paramContext.show();
  }
  
  public static boolean a()
  {
    if (bduy.a())
    {
      QLog.e(a, 2, "getStudyModeSwitch  ");
      return false;
    }
    if (!b())
    {
      QLog.e(a, 2, "is Surport Machine no!  ");
      return false;
    }
    nht localnht = (nht)aran.a().a(642);
    if (localnht != null) {}
    for (boolean bool = localnht.a();; bool = false)
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
    paramActivity = new nhy(paramOnClickListener);
    if ((!bool2) && (!bool1))
    {
      bdll.b(null, "dc00898", "", "", "0X800B03C", "0X800B03C", 0, 0, "", "", "", "");
      bdll.b(null, "dc00898", "", "", "0X800B03D", "0X800B03D", 0, 0, "", "", "", "");
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
          bdll.b(null, "dc00898", "", "", "0X800B03D", "0X800B03D", 0, 0, "", "", "", "");
          if (localBaseActivity != null) {
            localBaseActivity.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
          } else if (localBaseActivity1 != null) {
            localBaseActivity1.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
          }
        }
        else if (!bool1)
        {
          bdll.b(null, "dc00898", "", "", "0X800B03C", "0X800B03C", 0, 0, "", "", "", "");
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
    Object localObject = (TroopManager)paramBaseActivity.app.getManager(52);
    mxc localmxc = (mxc)paramBaseActivity.app.getManager(373);
    if ((localObject == null) || (localmxc == null)) {
      return false;
    }
    if (paramBaseActivity.app.a().b(paramBaseActivity, paramString))
    {
      QQToast.a(paramBaseActivity, 2131690313, 1).b(paramBaseActivity.getResources().getDimensionPixelSize(2131299011));
      return true;
    }
    localObject = ((TroopManager)localObject).a(paramString);
    if ((localObject == null) || (((TroopInfo)localObject).isAdmin())) {
      return false;
    }
    if (localmxc.c(paramString))
    {
      paramString = bhlq.a(paramBaseActivity, 230);
      paramString.setMessage(paramBaseActivity.getString(2131690256)).setPositiveButton(paramBaseActivity.getString(2131690357), new nhw());
      paramString.show();
      return true;
    }
    return false;
  }
  
  public static boolean b()
  {
    if (c()) {}
    while (nhz.a() != 0) {
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
 * Qualified Name:     nhv
 * JD-Core Version:    0.7.0.1
 */