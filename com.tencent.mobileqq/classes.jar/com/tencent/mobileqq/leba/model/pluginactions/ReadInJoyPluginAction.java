package com.tencent.mobileqq.leba.model.pluginactions;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;

public class ReadInJoyPluginAction
  extends PluginAction
{
  public ReadInJoyPluginAction(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo, View paramView)
  {
    Object localObject1 = a();
    paramLebaGridItemInfo = (RedTouch)paramView;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (ReadInJoyManager)((QQAppInterface)localObject1).getManager(95);
      if (localObject2 != null)
      {
        localObject1 = ((ReadInJoyManager)localObject2).a();
        paramView = ((ReadInJoyManager)localObject2).a();
        localObject2 = ((ReadInJoyManager)localObject2).a();
      }
    }
    int i;
    switch (((ReadInJoyNotifyRedTouchInfo)localObject2).a)
    {
    default: 
      return;
    case 1: 
      i = ((ReadInJoyNotifyRedTouchInfo)localObject2).b;
      if (i > 99) {
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set("99+");
      }
      for (;;)
      {
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(5);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'cn':'#FF0000'}");
        paramView.red_display_info.red_type_info.add((MessageMicro)localObject1);
        paramView.iNewFlag.set(1);
        paramLebaGridItemInfo.a(paramView);
        return;
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.set(i + "");
      }
    case 3: 
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(3);
      i = ((ReadInJoyNotifyRedTouchInfo)localObject2).c;
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_desc.set("{'drawable':" + i + "}");
      paramView.red_display_info.red_type_info.add((MessageMicro)localObject1);
      paramView.iNewFlag.set(1);
      paramLebaGridItemInfo.a(paramView);
      return;
    case 2: 
      localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
      paramView.red_display_info.red_type_info.add((MessageMicro)localObject1);
      paramView.iNewFlag.set(1);
      paramLebaGridItemInfo.a(paramView);
      return;
    case 4: 
      localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_type.set(0);
      paramView.red_display_info.red_type_info.add((MessageMicro)localObject1);
      paramView.iNewFlag.set(1);
      paramLebaGridItemInfo.a(paramView);
      return;
    }
    paramLebaGridItemInfo.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.pluginactions.ReadInJoyPluginAction
 * JD-Core Version:    0.7.0.1
 */