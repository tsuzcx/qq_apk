package com.tencent.mobileqq.nearby.redtouch;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

public class RedTouchUtil
{
  public static final SparseIntArray a = new SparseIntArray(4);
  public static final SparseIntArray b = new SparseIntArray(4);
  
  static
  {
    a.put(1, 0);
    a.put(2, 5);
    a.put(3, 3);
    a.put(4, 4);
    b.put(0, 1);
    b.put(5, 2);
    b.put(3, 3);
    b.put(4, 4);
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 4)) {
      return a.get(paramInt);
    }
    return a.get(1);
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.path.set(paramString1);
    localAppInfo.num.set(0);
    localAppInfo.type.set(-1);
    localAppInfo.iNewFlag.set(0);
    localAppInfo.appset.set(paramInt3);
    localAppInfo.buffer.set(paramString3);
    localAppInfo.uiAppId.set(paramInt2);
    localAppInfo.type.set(paramInt1);
    localAppInfo.iNewFlag.set(1);
    localAppInfo.appset.set(paramInt3);
    localAppInfo.mission_level.set(0);
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      paramString1 = new BusinessInfoCheckUpdate.RedDisplayInfo();
      paramString3 = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramString3.red_type.set(9);
      paramString3.red_content.set("-1");
      paramString3.red_desc.set("");
      paramString1.red_type_info.add(paramString3);
      paramString3 = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramString3.red_type.set(paramInt1);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString3.red_content.set(paramString2);
        paramString3.red_desc.set("{'cn':'#FF0000'}");
      }
      paramString1.tab_display_info.set(paramString3);
      paramString1.red_type_info.add(paramString3);
      localAppInfo.red_display_info.set(paramString1);
    }
    while (paramInt1 != 0) {
      return localAppInfo;
    }
    paramString1 = new BusinessInfoCheckUpdate.RedDisplayInfo();
    paramString2 = new BusinessInfoCheckUpdate.RedTypeInfo();
    paramString2.red_type.set(0);
    paramString1.red_type_info.add(paramString2);
    localAppInfo.red_display_info.set(paramString1);
    return localAppInfo;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, int paramInt3, boolean paramBoolean2)
  {
    if ((paramAppInterface == null) || (!paramBoolean2)) {
      return new BusinessInfoCheckUpdate.AppInfo();
    }
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "buildRedTouchAppInfo, appset:" + paramInt3 + " path:" + paramString1);
    }
    paramString1 = a(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3);
    if ((paramBoolean1) && ((paramAppInterface instanceof QQAppInterface)))
    {
      paramAppInterface = (RedTouchManager)paramAppInterface.getManager(35);
      if (paramAppInterface != null) {
        paramAppInterface.a(paramString1, true);
      }
    }
    return paramString1;
  }
  
  public static void a(RedTouchItem paramRedTouchItem1, RedTouchItem paramRedTouchItem2)
  {
    paramRedTouchItem1.count = paramRedTouchItem2.count;
    paramRedTouchItem1.receiveTime = paramRedTouchItem2.receiveTime;
    paramRedTouchItem1.redtouchType = paramRedTouchItem2.redtouchType;
    paramRedTouchItem1.curSeq = paramRedTouchItem2.curSeq;
    paramRedTouchItem1.icon = paramRedTouchItem2.icon;
    paramRedTouchItem1.unReadFlag = paramRedTouchItem2.unReadFlag;
    paramRedTouchItem1.validTimeRemained = paramRedTouchItem2.validTimeRemained;
    paramRedTouchItem1.isClosed = paramRedTouchItem2.isClosed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedTouchUtil
 * JD-Core Version:    0.7.0.1
 */