package com.tencent.mobileqq.nearpeople.mytab;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class NearbyMineHelper
{
  private static Object a;
  public static final HashMap a;
  public static boolean a = false;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    NearbyMyTabCard.NearbyMyTabConfigExtraVal localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100511";
    localNearbyMyTabConfigExtraVal.pathId = 100511;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10001), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100514";
    localNearbyMyTabConfigExtraVal.pathId = 100514;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10002), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100520";
    localNearbyMyTabConfigExtraVal.pathId = 100520;
    localNearbyMyTabConfigExtraVal.actionName = "0X80049F3";
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10003), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100521";
    localNearbyMyTabConfigExtraVal.pathId = 100521;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10004), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100517";
    localNearbyMyTabConfigExtraVal.pathId = 100517;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10005), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100513";
    localNearbyMyTabConfigExtraVal.pathId = 100513;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10006), localNearbyMyTabConfigExtraVal);
    localNearbyMyTabConfigExtraVal = new NearbyMyTabCard.NearbyMyTabConfigExtraVal();
    localNearbyMyTabConfigExtraVal.path = "100510.100524";
    localNearbyMyTabConfigExtraVal.pathId = 100524;
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10010), localNearbyMyTabConfigExtraVal);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "100510.100511", "100510.100513", "100510.100514", "100510.100519", "100510.100521", "100510.100520", "100510.100516", "100510.100517", "100510.100524", "100510.100523" };
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    int i;
    int j;
    if (paramInt != 100511)
    {
      if (paramInt != 100517)
      {
        if (paramInt != 100519)
        {
          i = 0;
        }
        else
        {
          j = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getUnreadCount(paramQQAppInterface.getAccount(), "unread_count_freshnews");
          i = j;
          if (QLog.isColorLevel())
          {
            NearbyUtils.a(2, "NearbyMineHelper", "getUnCountByPathIDMain", new Object[] { "freshnews", Integer.valueOf(j) });
            i = j;
          }
        }
      }
      else
      {
        if (((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getUnreadCount(paramQQAppInterface.getAccount(), "unread_count_rank") > 0) {
          j = 1;
        } else {
          j = 0;
        }
        i = j;
        if (QLog.isColorLevel())
        {
          NearbyUtils.a(2, "NearbyMineHelper", "getUnCountByPathIDMain", new Object[] { "ranking", Integer.valueOf(j) });
          i = j;
        }
      }
    }
    else
    {
      j = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getUnreadCount(paramQQAppInterface.getAccount(), "unread_count_date");
      i = j;
      if (QLog.isColorLevel())
      {
        NearbyUtils.a(2, "NearbyMineHelper", "getUnCountByPathIDMain", new Object[] { "dating", Integer.valueOf(j) });
        i = j;
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getUnCountByPathID|pathId=");
      paramQQAppInterface.append(paramInt);
      paramQQAppInterface.append(" unreadCount=");
      paramQQAppInterface.append(i);
      QLog.i("NewNearbyMyTab", 2, paramQQAppInterface.toString());
    }
    return i;
  }
  
  public static NearbyMyTabCard a(AppInterface paramAppInterface)
  {
    Object localObject1 = null;
    if (paramAppInterface == null) {
      return null;
    }
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Object.class;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject3).append("NewNearbyMyTab.nbr");
      localObject3 = FileUtils.readObjectList(((StringBuilder)localObject3).toString(), arrayOfClass);
      paramAppInterface = localObject1;
      if (localObject3 != null)
      {
        paramAppInterface = localObject1;
        if (localObject3.length == arrayOfClass.length) {
          paramAppInterface = (NearbyMyTabCard)localObject3[0];
        }
      }
      if ((paramAppInterface != null) && (paramAppInterface.configList != null))
      {
        int i = 0;
        while (i < paramAppInterface.configList.size())
        {
          if (((NearbyMyTabCard.NearbyMyTabConfig)paramAppInterface.configList.get(i)).configId == 10001)
          {
            paramAppInterface.configList.remove(i);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.nearby", 2, "handleGetNearbyMyTab|shield date entrance");
            break;
          }
          i += 1;
        }
      }
      NearbyUtils.a("Q.nearby", "readNearbyMyTabCardFromLocal", new Object[] { paramAppInterface });
      return paramAppInterface;
    }
    for (;;)
    {
      throw paramAppInterface;
    }
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    return a(paramInt1, paramInt2, paramString1, paramString2, -1);
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.path.set(paramString1);
    localAppInfo.num.set(0);
    localAppInfo.type.set(-1);
    localAppInfo.iNewFlag.set(0);
    localAppInfo.appset.set(-1);
    if (paramInt1 != -1)
    {
      localAppInfo.uiAppId.set(paramInt2);
      localAppInfo.type.set(paramInt1);
      localAppInfo.iNewFlag.set(1);
      localAppInfo.appset.set(paramInt3);
      localAppInfo.mission_level.set(0);
      paramString1 = new BusinessInfoCheckUpdate.RedDisplayInfo();
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(9);
      localRedTypeInfo.red_content.set("-1");
      localRedTypeInfo.red_desc.set("");
      paramString1.red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(paramInt1);
      if (!TextUtils.isEmpty(paramString2)) {
        localRedTypeInfo.red_content.set(paramString2);
      }
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      paramString1.tab_display_info.set(localRedTypeInfo);
      paramString1.red_type_info.add(localRedTypeInfo);
      localAppInfo.red_display_info.set(paramString1);
    }
    return localAppInfo;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramAppInterface == null) {
      return new BusinessInfoCheckUpdate.AppInfo();
    }
    paramString1 = a(paramInt1, paramInt2, paramString1, paramString2);
    if ((paramBoolean) && ((paramAppInterface instanceof QQAppInterface)))
    {
      paramAppInterface = (IRedTouchManager)paramAppInterface.getRuntimeService(IRedTouchManager.class, "");
      if (paramAppInterface != null) {
        paramAppInterface.updateAppInfo(paramString1, true);
      }
    }
    return paramString1;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "updateNearbyNumAppinfo main. start");
    }
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    if ((jdField_a_of_type_Boolean) && (localIRedTouchManager.isNumRedTouchEnable(100510)))
    {
      int i;
      if (((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getAccount(), "nearby_event_file", 4, "config_show_date", Boolean.valueOf(false))).booleanValue()) {
        i = a(paramQQAppInterface, 100511) + 0;
      } else {
        i = 0;
      }
      int j = i;
      if (((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getAccount(), "nearby_event_file", 4, "config_show_rank", Boolean.valueOf(false))).booleanValue()) {
        j = i + a(paramQQAppInterface, 100517);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("updateNearbyNumAppinfo main. count:");
        localStringBuilder1.append(j);
        QLog.i("NewNearbyMyTab", 2, localStringBuilder1.toString());
      }
      if (j > 0)
      {
        paramQQAppInterface = localIRedTouchManager.getAppInfoByPath(String.valueOf(100510));
        if ((paramQQAppInterface != null) && (paramQQAppInterface.red_display_info != null) && (paramQQAppInterface.red_display_info.red_type_info != null) && (paramQQAppInterface.red_display_info.red_type_info.size() == 2) && (paramQQAppInterface.red_display_info.red_type_info.get(1) != null)) {
          try
          {
            i = Integer.parseInt(((BusinessInfoCheckUpdate.RedTypeInfo)paramQQAppInterface.red_display_info.red_type_info.get(1)).red_content.get());
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("get cache redpoint failed, e = ");
              localStringBuilder2.append(localException);
              QLog.d("NewNearbyMyTab", 2, localStringBuilder2.toString());
            }
          }
        } else {
          i = 0;
        }
        if (i != j) {
          return localIRedTouchManager.createNumAppInfo(0, 100510, String.valueOf(100510), j);
        }
      }
      else
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100510");
        if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1) && (localAppInfo.type.get() == 5))
        {
          if (QLog.isColorLevel()) {
            QLog.i("NewNearbyMyTab", 2, "updateNearbyNumAppinfo Main, old is num, clear.");
          }
          localIRedTouchManager.onRedTouchItemClick(String.valueOf(100510));
          if (paramBoolean) {
            ((IRedTouchServer)paramQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(paramQQAppInterface);
          }
        }
        paramQQAppInterface = localAppInfo;
      }
      return paramQQAppInterface;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "updateNearbyNumAppinfo main. return");
    }
    return null;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, Object[] paramArrayOfObject)
  {
    if ((paramQQAppInterface != null) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
    {
      int i1 = ((Integer)paramArrayOfObject[0]).intValue();
      String str = (String)paramArrayOfObject[1];
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      Object localObject1 = "";
      int m = 0;
      int j = 0;
      int k = 0;
      for (;;)
      {
        paramArrayOfObject = jdField_a_of_type_ArrayOfJavaLangString;
        if (j >= paramArrayOfObject.length) {
          break;
        }
        int i2 = Integer.parseInt(paramArrayOfObject[j].substring(paramArrayOfObject[j].lastIndexOf(".") + 1));
        Object localObject2 = localIRedTouchManager.getAppInfoByPath(jdField_a_of_type_ArrayOfJavaLangString[j]);
        if ((((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info != null))
        {
          paramArrayOfObject = ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.get();
          if ((paramArrayOfObject != null) && (paramArrayOfObject.size() >= 2))
          {
            i = ((BusinessInfoCheckUpdate.RedTypeInfo)paramArrayOfObject.get(1)).red_type.get();
            break label177;
          }
        }
        int i = 0;
        label177:
        int n = i;
        if (i2 == 100524)
        {
          n = i;
          if (i == 4) {
            n = 0;
          }
        }
        if ((n == 4) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0))
        {
          try
          {
            localObject2 = ((BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.get(1)).red_content.get();
            localObject1 = localObject2;
            paramArrayOfObject = (Object[])localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = localObject2;
              paramArrayOfObject = new StringBuilder();
              localObject1 = localObject2;
              paramArrayOfObject.append("buildRedTouchAppInfo| pathId=");
              localObject1 = localObject2;
              paramArrayOfObject.append(i2);
              localObject1 = localObject2;
              paramArrayOfObject.append(" redTouchType=RED_TOUCH_TEXT text=");
              localObject1 = localObject2;
              paramArrayOfObject.append((String)localObject2);
              localObject1 = localObject2;
              QLog.d("NewNearbyMyTab", 2, paramArrayOfObject.toString());
              paramArrayOfObject = (Object[])localObject2;
            }
          }
          catch (Exception localException)
          {
            paramArrayOfObject = (Object[])localObject1;
            if (QLog.isColorLevel())
            {
              paramArrayOfObject = new StringBuilder();
              paramArrayOfObject.append("buildRedTouchAppInfo| exception=");
              paramArrayOfObject.append(localException.getMessage());
              QLog.d("NewNearbyMyTab", 2, paramArrayOfObject.toString());
              paramArrayOfObject = (Object[])localObject1;
            }
          }
          i = 1;
          n = k;
        }
        else
        {
          if ((n == 0) && (localException.iNewFlag.get() != 0)) {
            if (QLog.isColorLevel())
            {
              paramArrayOfObject = new StringBuilder();
              paramArrayOfObject.append("buildRedTouchAppInfo| pathId=");
              paramArrayOfObject.append(i2);
              paramArrayOfObject.append(" redTouchType=RED_TOUCH_RED_POINT text=");
              paramArrayOfObject.append((String)localObject1);
              QLog.d("NewNearbyMyTab", 2, paramArrayOfObject.toString());
            }
          }
          for (;;)
          {
            n = 1;
            i = m;
            paramArrayOfObject = (Object[])localObject1;
            break;
            i = m;
            n = k;
            paramArrayOfObject = (Object[])localObject1;
            if (i2 != 100523) {
              break;
            }
            i = m;
            n = k;
            paramArrayOfObject = (Object[])localObject1;
            if (localException.iNewFlag.get() == 0) {
              break;
            }
            if (QLog.isColorLevel())
            {
              paramArrayOfObject = new StringBuilder();
              paramArrayOfObject.append("buildRedTouchAppInfo| pathId=");
              paramArrayOfObject.append(i2);
              paramArrayOfObject.append(", UIAPPID_NEARBY_VISITOR RED_TOUCH");
              QLog.d("NewNearbyMyTab", 2, paramArrayOfObject.toString());
            }
          }
        }
        j += 1;
        m = i;
        k = n;
        localObject1 = paramArrayOfObject;
      }
      Object localObject3;
      if (m != 0)
      {
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append((String)localObject1);
        paramArrayOfObject.append("");
        paramArrayOfObject = a(paramQQAppInterface, 4, i1, str, paramArrayOfObject.toString(), true);
      }
      else if (k != 0)
      {
        paramArrayOfObject = a(paramQQAppInterface, 0, i1, str, "", true);
      }
      else
      {
        localObject3 = localIRedTouchManager.getAppInfoByPath(str);
        if (localObject3 != null)
        {
          paramArrayOfObject = (Object[])localObject3;
          if (((BusinessInfoCheckUpdate.AppInfo)localObject3).type.get() == -1) {}
        }
        else
        {
          paramArrayOfObject = a(paramQQAppInterface, -1, i1, str, "", true);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("buildRedTouchAppInfo| path=");
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(" redTouchType=");
        if (paramArrayOfObject != null)
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(paramArrayOfObject.type.get());
          paramQQAppInterface.append("");
          paramQQAppInterface = paramQQAppInterface.toString();
        }
        else
        {
          paramQQAppInterface = "-1";
        }
        ((StringBuilder)localObject3).append(paramQQAppInterface);
        ((StringBuilder)localObject3).append(" count=");
        ((StringBuilder)localObject3).append(0);
        ((StringBuilder)localObject3).append(" text=");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.d("NewNearbyMyTab", 2, ((StringBuilder)localObject3).toString());
      }
      return paramArrayOfObject;
    }
    return null;
  }
  
  public static void a(AppInterface paramAppInterface, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (paramAppInterface != null)
    {
      if (paramNearbyMyTabCard == null) {
        return;
      }
      NearbyUtils.a("Q.nearby", "storeNearbyMyTabCard", new Object[] { paramNearbyMyTabCard });
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
        localStringBuilder.append("NewNearbyMyTab.nbr");
        FileUtils.writeObjectList(localStringBuilder.toString(), new Object[] { paramNearbyMyTabCard });
        return;
      }
    }
  }
  
  public static void a(INearbyAppInterface paramINearbyAppInterface, int paramInt, boolean paramBoolean)
  {
    if (paramINearbyAppInterface == null) {
      return;
    }
    NearbyMyTabCard localNearbyMyTabCard = paramINearbyAppInterface.getMyTabCard();
    if (localNearbyMyTabCard != null)
    {
      localNearbyMyTabCard.newLikeNum = paramInt;
      a((AppInterface)paramINearbyAppInterface, localNearbyMyTabCard);
    }
    if (paramBoolean) {
      ((NearbyHandler)paramINearbyAppInterface.getBusinessHandler(NearbyConstants.a)).a(localNearbyMyTabCard);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper
 * JD-Core Version:    0.7.0.1
 */