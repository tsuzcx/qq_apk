package com.tencent.mobileqq.leba.model.pluginactions;

import aejk;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.campuscircle.CampusCircleHelper;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

public class CampusCirclePluginAction
  extends PluginAction
{
  public CampusCirclePluginAction(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(RedTouch paramRedTouch)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localRedTypeInfo.red_type.set(0);
    localRedTypeInfo.red_desc.set("");
    localRedTypeInfo.red_content.set("");
    localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
    localAppInfo.iNewFlag.set(1);
    paramRedTouch.a(localAppInfo);
  }
  
  public void a(View paramView, LebaGridItemInfo paramLebaGridItemInfo)
  {
    super.a(paramView, paramLebaGridItemInfo);
    ReportController.b(a(), "dc00898", "", "", "0X8008732", "0X8008732", 0, 0, "", "", "", "");
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo, View paramView)
  {
    boolean bool3 = true;
    QQAppInterface localQQAppInterface = a();
    paramView = (RedTouch)paramView;
    CampusCircleHelper.a(localQQAppInterface, paramView);
    Object localObject1;
    Object localObject2;
    RedTouchItem localRedTouchItem;
    int j;
    boolean bool2;
    int i;
    boolean bool1;
    if (localQQAppInterface != null)
    {
      localObject1 = (LocalRedTouchManager)localQQAppInterface.getManager(159);
      localObject2 = ((LocalRedTouchManager)localObject1).a(10017);
      localRedTouchItem = ((LocalRedTouchManager)localObject1).a(103421);
      if (!((LocalRedTouchManager)localObject1).a((RedTouchItem)localObject2, false)) {
        break label496;
      }
      if (((RedTouchItem)localObject2).redtouchType != 2) {
        break label248;
      }
      j = ((RedTouchItem)localObject2).count;
      bool2 = false;
      i = 0;
      j += 0;
      bool1 = true;
    }
    for (;;)
    {
      int k = i;
      int m = j;
      if (((LocalRedTouchManager)localObject1).a(localRedTouchItem, false))
      {
        k = i;
        m = j;
        if (localRedTouchItem.passThroughLevel >= 1)
        {
          if (localRedTouchItem.redtouchType != 2) {
            break label318;
          }
          m = j + localRedTouchItem.count;
          k = i;
        }
      }
      label154:
      if (QLog.isColorLevel()) {
        QLog.i("CampusCirclePluginActio", 2, "updateEntryRedTouch redNum:" + m + " redPoint:" + k + " hasUnnormal:" + bool2 + " isText:" + bool1);
      }
      if ((m <= 0) && (k <= 0) && (!bool2))
      {
        paramView.b();
        bool1 = false;
      }
      for (;;)
      {
        a(bool1, paramLebaGridItemInfo, localQQAppInterface);
        return;
        label248:
        if (((RedTouchItem)localObject2).redtouchType == 1)
        {
          bool1 = true;
          bool2 = false;
          i = 1;
          j = 0;
          break;
        }
        if ((((RedTouchItem)localObject2).redtouchType != 3) && (((RedTouchItem)localObject2).redtouchType != 4)) {
          break label496;
        }
        if (((RedTouchItem)localObject2).redtouchType == 4) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = true;
          i = 0;
          j = 0;
          break;
        }
        label318:
        k = i + 1;
        m = j;
        break label154;
        if (m > 0)
        {
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          localObject2 = new BusinessInfoCheckUpdate.AppInfo();
          if (m > 99) {
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set("99+");
          }
          for (;;)
          {
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(5);
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000'}");
            ((BusinessInfoCheckUpdate.AppInfo)localObject2).red_display_info.red_type_info.add((MessageMicro)localObject1);
            ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(1);
            paramView.a((BusinessInfoCheckUpdate.AppInfo)localObject2);
            bool1 = bool3;
            break;
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(String.valueOf(m));
          }
        }
        if ((bool2) && (bool1))
        {
          a(paramView);
          bool1 = bool3;
        }
        else if ((bool2) && (!bool1))
        {
          a(paramView);
          bool1 = bool3;
        }
        else
        {
          a(paramView);
          bool1 = bool3;
        }
      }
      label496:
      bool1 = true;
      bool2 = false;
      i = 0;
      j = 0;
    }
  }
  
  public void b(LebaGridItemInfo paramLebaGridItemInfo)
  {
    QQAppInterface localQQAppInterface = a();
    super.b(paramLebaGridItemInfo);
    ThreadManager.post(new aejk(this, localQQAppInterface), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.pluginactions.CampusCirclePluginAction
 * JD-Core Version:    0.7.0.1
 */