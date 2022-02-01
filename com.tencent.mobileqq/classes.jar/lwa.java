import android.text.TextUtils;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class lwa
{
  public static RedTouch a(VideoAppInterface paramVideoAppInterface, View paramView, int paramInt)
  {
    if ((paramVideoAppInterface == null) || (paramView == null)) {
      return null;
    }
    String str = a(paramInt);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramVideoAppInterface, paramInt);
    if (a(localAppInfo))
    {
      Object localObject = paramView.getParent();
      if ((localObject instanceof RedTouch)) {}
      for (localObject = (RedTouch)localObject;; localObject = new RedTouch(paramVideoAppInterface.getApplication(), paramView).a(53).a())
      {
        ((RedTouch)localObject).a(localAppInfo);
        paramVideoAppInterface.e(str);
        QLog.d("AVRedTouchUtil", 1, "tryGetRedTouchAndShowRedDot suc. appId[" + str + "], view[" + paramView + "], redTouch[" + localObject + "]");
        return localObject;
      }
    }
    QLog.d("AVRedTouchUtil", 1, "tryGetRedTouchAndShowRedDot fail. appId[" + str + "], view[" + paramView + "], appInfo[" + localAppInfo + "], hasRedDot[false]");
    return null;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramVideoAppInterface == null) {
      paramVideoAppInterface = null;
    }
    Object localObject;
    do
    {
      return paramVideoAppInterface;
      int j = 0;
      localObject = paramVideoAppInterface.a();
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (((VideoController)localObject).a() != null) {
          i = ((VideoController)localObject).a().d;
        }
      }
      localObject = a(paramInt);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.d("AVRedTouchUtil", 1, "tryGetRedTouch failed. appId[" + (String)localObject + "]");
        return null;
      }
      if (!a(paramVideoAppInterface, paramInt, i))
      {
        QLog.d("AVRedTouchUtil", 1, "tryGetRedTouch failed. can not show red touch. appId = " + (String)localObject);
        return null;
      }
      localObject = a(paramVideoAppInterface, (String)localObject);
      paramVideoAppInterface = (VideoAppInterface)localObject;
    } while (a((BusinessInfoCheckUpdate.AppInfo)localObject));
    return null;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = null;
    if (paramVideoAppInterface != null) {
      localAppInfo = paramVideoAppInterface.a(paramString);
    }
    return localAppInfo;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 9: 
      return "105000.105100.105140";
    case 6: 
      return "105000.105100.105120";
    case 1: 
      return "105000.105100";
    case 2: 
      return "105000.105100.105110";
    case 3: 
      return "105000.105100.105110.105111";
    case 4: 
      return "105000.105100.105110.105111.105116";
    case 5: 
      return "105000.105100.105110.105111.105117";
    case 7: 
      return "105000.105100.105130";
    }
    return "105000.105100.105130.105131";
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, RedTouch paramRedTouch, int paramInt)
  {
    if ((paramVideoAppInterface == null) || (paramRedTouch == null)) {
      return;
    }
    String str = a(paramInt);
    if (TextUtils.isEmpty(str))
    {
      QLog.d("AVRedTouchUtil", 1, "clearRedDot falied. appId[" + str + "], redTouch[" + paramRedTouch + "]");
      return;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramVideoAppInterface, str);
    if (a(localAppInfo))
    {
      paramVideoAppInterface.d(str);
      paramRedTouch.d();
      QLog.d("AVRedTouchUtil", 1, "clearRedDot successfully. appId[" + str + "], redTouch[" + paramRedTouch + "]");
      return;
    }
    QLog.d("AVRedTouchUtil", 1, "clearRedDot falied. appId[" + str + "], redTouch[" + paramRedTouch + "], appInfo[" + localAppInfo + "], hasRedDot[" + a(localAppInfo) + "]");
  }
  
  private static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    String str = a(paramInt);
    if (TextUtils.isEmpty(str))
    {
      QLog.d("AVRedTouchUtil", 1, "hasRedDot falied. appId = " + str);
      return false;
    }
    paramVideoAppInterface = a(paramVideoAppInterface, str);
    if (a(paramVideoAppInterface)) {
      return true;
    }
    QLog.d("AVRedTouchUtil", 1, "hasRedDot falied. appId = " + str + ", appInfo = " + paramVideoAppInterface + ", hasRedDot = false");
    return false;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool1 = false;
    boolean bool3 = true;
    if (paramVideoAppInterface == null)
    {
      bool2 = bool1;
      return bool2;
    }
    bool1 = bool2;
    switch (paramInt1)
    {
    default: 
      bool1 = bool2;
    case 4: 
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AVRedTouchUtil", 2, "canShowRedTouch, id[" + paramInt1 + "], show[" + bool1 + "]");
        return bool1;
        bool2 = a(paramVideoAppInterface, 1);
        bool1 = bool2;
        if (bool2)
        {
          bool2 = a(paramVideoAppInterface, 2, paramInt2);
          bool1 = bool2;
          if (!bool2) {
            bool1 = a(paramVideoAppInterface, 6, paramInt2);
          }
          bool2 = bool1;
          if (!bool1) {
            bool2 = a(paramVideoAppInterface, 7, paramInt2);
          }
          bool1 = bool2;
          if (!bool2)
          {
            bool1 = a(paramVideoAppInterface, 9, paramInt2);
            continue;
            if (paramInt2 != 2)
            {
              bool1 = bool4;
              if (paramInt2 != 4) {}
            }
            else
            {
              bool1 = true;
            }
            bool2 = bool1;
            if (bool1) {
              bool2 = a(paramVideoAppInterface, 2);
            }
            bool1 = bool2;
            if (bool2)
            {
              bool1 = a(paramVideoAppInterface, 3, paramInt2);
              continue;
              if (paramInt2 != 2)
              {
                bool1 = bool5;
                if (paramInt2 != 4) {}
              }
              else
              {
                bool1 = true;
              }
              bool2 = bool1;
              if (bool1) {
                bool2 = a(paramVideoAppInterface, 3);
              }
              bool1 = bool2;
              if (bool2)
              {
                bool2 = a(paramVideoAppInterface, 4, paramInt2);
                bool1 = bool2;
                if (!bool2) {
                  bool1 = a(paramVideoAppInterface, 5, paramInt2);
                }
              }
            }
          }
        }
      }
    case 5: 
      if (paramInt2 != 2) {
        break;
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (bool1) {
        bool2 = a(paramVideoAppInterface, 5);
      }
      if (bool2)
      {
        if ((lpm.b()) && (loy.b())) {}
        for (bool1 = bool3;; bool1 = false) {
          break;
        }
        bool1 = a(paramVideoAppInterface, 6);
        break;
        bool1 = a(paramVideoAppInterface, 9);
        break;
        if (paramInt2 != 2)
        {
          bool1 = bool6;
          if (paramInt2 != 4) {}
        }
        else
        {
          bool1 = lpm.b();
        }
        bool2 = bool1;
        if (bool1) {
          bool2 = a(paramVideoAppInterface, 7);
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        bool1 = a(paramVideoAppInterface, 8, paramInt2);
        break;
        if (paramInt2 != 2)
        {
          bool2 = bool7;
          if (paramInt2 != 4) {}
        }
        else
        {
          bool2 = true;
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        bool1 = lpm.b();
        break;
      }
      bool1 = bool2;
      break;
    }
  }
  
  public static boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while ((paramAppInfo.iNewFlag.get() == 0) || (paramAppInfo.exposure_max.get() < 0) || (paramAppInfo.red_display_info.get() == null) || (paramAppInfo.red_display_info.red_type_info.get() == null) || (paramAppInfo.red_display_info.red_type_info.get().size() == 0)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lwa
 * JD-Core Version:    0.7.0.1
 */