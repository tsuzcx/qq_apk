package com.tencent.mobileqq.multiaio;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.ConversationDataFactory;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.multiaio.utils.GC;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiAIOHelper
{
  private static List<Integer> a = new ArrayList();
  private static boolean b = true;
  
  static
  {
    a.clear();
    a.add(Integer.valueOf(0));
    a.add(Integer.valueOf(1));
    a.add(Integer.valueOf(3000));
    a.add(Integer.valueOf(1004));
    a.add(Integer.valueOf(1000));
    a.add(Integer.valueOf(1022));
    a.add(Integer.valueOf(1001));
    a.add(Integer.valueOf(10002));
    a.add(Integer.valueOf(1006));
    a.add(Integer.valueOf(1005));
    a.add(Integer.valueOf(10008));
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cropAIOFromDecorView() called with: input = [");
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append("], contentHeight = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], activity = [");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append("]");
      QLog.d("MultiAIOHelper", 2, localStringBuilder.toString());
    }
    if (paramBitmap == null) {
      return null;
    }
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    a(paramActivity);
    if ((paramInt <= 0) || (paramInt >= i)) {
      paramInt = i;
    }
    i = ImmersiveUtils.getStatusBarHeight(paramActivity);
    paramInt -= i;
    try
    {
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("cropAIOFromDecorView() statusBarHeight = ");
        paramActivity.append(i);
        paramActivity.append(", width =");
        paramActivity.append(j);
        paramActivity.append(", finalHeight = ");
        paramActivity.append(paramInt);
        QLog.d("MultiAIOHelper", 2, paramActivity.toString());
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, i, j, paramInt);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      QLog.e("MultiAIOHelper", 1, "cropAIOFromDecorView: ", paramBitmap);
      GC.a();
    }
    return null;
  }
  
  public static List<RecentBaseData> a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    ProxyManager localProxyManager = paramQQAppInterface.getProxyManager();
    if (localProxyManager == null) {
      return localArrayList;
    }
    try
    {
      if (localProxyManager.g().a(false).size() > 0) {
        localArrayList.addAll(RecentDataListManager.a().c);
      }
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOHelper", 1, "getRecentUser error.", localException);
    }
    return a(paramBaseActivity, paramQQAppInterface, localArrayList, paramString1, paramInt, paramString2, paramString3);
  }
  
  private static List<RecentBaseData> a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, List<RecentBaseData> paramList, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (TextUtils.equals(paramString1, "conversation_tab_bottom")) {
      while (localIterator.hasNext())
      {
        paramBaseActivity = (RecentBaseData)localIterator.next();
        if ((a(paramBaseActivity)) && (!b(paramBaseActivity))) {
          localArrayList.add(paramBaseActivity);
        }
      }
    }
    int i = 0;
    int k;
    for (int j = -1; i < paramList.size(); j = k)
    {
      paramString1 = (RecentBaseData)paramList.get(i);
      k = j;
      if (a(paramString1)) {
        if ((paramString1.getRecentUserType() == paramInt) && (TextUtils.equals(paramString2, paramString1.getRecentUserUin())))
        {
          k = i;
        }
        else
        {
          k = j;
          if (!b(paramString1))
          {
            localArrayList.add(paramString1);
            k = j;
          }
        }
      }
      i += 1;
    }
    if (j == -1)
    {
      paramBaseActivity = ConversationDataFactory.a(new RecentUser(paramString2, paramInt), paramQQAppInterface, paramBaseActivity);
      if (paramBaseActivity != null)
      {
        if (paramString3 == null) {
          paramString3 = paramBaseActivity.getTitleName();
        }
        paramBaseActivity.mTitleName = paramString3;
        localArrayList.add(0, paramBaseActivity);
        return localArrayList;
      }
    }
    else
    {
      localArrayList.add(0, paramList.get(j));
    }
    return localArrayList;
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateMultiAIOSwitchStatusLocal() called switch is ");
        ((StringBuilder)localObject2).append(paramBoolean);
        QLog.d("MultiAIOHelper", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = (QQAppInterface)localObject1;
      Object localObject2 = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("multiaio_switch_sp");
      localStringBuilder.append(((QQAppInterface)localObject1).getCurrentAccountUin());
      localObject1 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).edit();
      ((SharedPreferences.Editor)localObject1).putBoolean("key_multiaio_switch", paramBoolean);
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  public static boolean a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOHelper", 2, "getMultiAioSwitchStatusLocal() called load from sp");
      }
      localObject = (QQAppInterface)localObject;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("multiaio_switch_sp");
      localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
      b = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("key_multiaio_switch", true);
    }
    return b;
  }
  
  public static boolean a(int paramInt)
  {
    return a.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint1 = new Point();
      Point localPoint2 = new Point();
      paramActivity.getSize(localPoint1);
      paramActivity.getRealSize(localPoint2);
      return localPoint2.y != localPoint1.y;
    }
    boolean bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
    boolean bool2 = KeyCharacterMap.deviceHasKey(4);
    if (!bool1) {
      return !bool2;
    }
    return false;
  }
  
  private static boolean a(RecentBaseData paramRecentBaseData)
  {
    return a(paramRecentBaseData.getRecentUserType());
  }
  
  public static void b() {}
  
  private static boolean b(RecentBaseData paramRecentBaseData)
  {
    return paramRecentBaseData.mUnreadFlag == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOHelper
 * JD-Core Version:    0.7.0.1
 */