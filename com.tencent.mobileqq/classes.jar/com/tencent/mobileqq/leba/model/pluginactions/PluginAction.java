package com.tencent.mobileqq.leba.model.pluginactions;

import aebc;
import aebd;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.LebaGridHandler;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PluginAction
{
  Context a;
  
  public PluginAction(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private BusinessInfoCheckUpdate.AppInfo a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      localObject = null;
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = paramAppInfo;
        } while (paramAppInfo.red_display_info.get() == null);
        localObject = paramAppInfo;
      } while (paramAppInfo.red_display_info.red_type_info.get() == null);
      localObject = paramAppInfo;
    } while (paramAppInfo.red_display_info.red_type_info.get().size() <= 1);
    Object localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
    localAppInfo.red_display_info.red_type_info.add((MessageMicro)localObject);
    if (paramAppInfo.iNewFlag.has()) {
      localAppInfo.iNewFlag.set(paramAppInfo.iNewFlag.get());
    }
    return localAppInfo;
  }
  
  public Intent a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    QQAppInterface localQQAppInterface = a();
    Object localObject2 = paramLebaGridItemInfo.a.jumpInfo;
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    Object localObject1 = localObject2;
    if (((String)localObject2).indexOf("plg_uin=1") > -1) {
      localObject1 = (String)localObject2 + "&mqquin=" + localQQAppInterface.getCurrentAccountUin();
    }
    localObject2 = localObject1;
    if (((String)localObject1).indexOf("plg_vkey=1") > -1) {
      localObject2 = (String)localObject1 + "&mqqvkey=" + localQQAppInterface.b();
    }
    if (((String)localObject2).indexOf("plg_nld=1") > -1) {
      localIntent.putExtra("reportNld", true);
    }
    localObject1 = a(paramLebaGridItemInfo);
    boolean bool = a((BusinessInfoCheckUpdate.AppInfo)localObject1);
    localObject1 = a((BusinessInfoCheckUpdate.AppInfo)localObject1, paramLebaGridItemInfo.a.pluginId);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localIntent.putExtra("redTouch", (String)localObject1);
    }
    localIntent.putExtra("uin", localQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("plugin_start_time", System.nanoTime());
    localIntent.putExtra("click_start_time", System.currentTimeMillis());
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("is_from_leba", true);
    localIntent.putExtra("leba_resid", paramLebaGridItemInfo.a.pluginId);
    localIntent.putExtra("has_red_dot", bool);
    localIntent.putExtra("url", (String)localObject2);
    return localIntent;
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public JumpAction a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    Object localObject = a();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramLebaGridItemInfo);
    boolean bool1 = a(localAppInfo);
    String str1 = a(localAppInfo, paramLebaGridItemInfo.a.pluginId);
    boolean bool2 = a(paramLebaGridItemInfo.a.isNew, paramLebaGridItemInfo.a.pluginId);
    String str2 = paramLebaGridItemInfo.a.resName;
    String str3 = paramLebaGridItemInfo.a.jumpInfo;
    localObject = JumpParser.a((QQAppInterface)localObject, this.a, str3);
    ((JumpAction)localObject).a("from_leba", "fromleba");
    ((JumpAction)localObject).a("leba_resid", String.valueOf(paramLebaGridItemInfo.a.pluginId));
    ((JumpAction)localObject).a("config_res_plugin_item_name", str2);
    ((JumpAction)localObject).a("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
    ((JumpAction)localObject).a(bool2);
    ((JumpAction)localObject).b(paramLebaGridItemInfo.a.pkgName);
    ((JumpAction)localObject).d(str1);
    ((JumpAction)localObject).b(bool1);
    ((JumpAction)localObject).a(localAppInfo);
    return localObject;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    return ((RedTouchManager)a().getManager(35)).a(paramLebaGridItemInfo.a.pluginId + "");
  }
  
  public String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      new ArrayList();
      int i = 0;
      paramInt = i;
      if (paramAppInfo.red_display_info != null)
      {
        paramInt = i;
        if (paramAppInfo.red_display_info.red_type_info != null)
        {
          List localList = paramAppInfo.red_display_info.red_type_info.get();
          paramInt = i;
          if (localList != null)
          {
            paramInt = i;
            if (localList.size() >= 2) {
              paramInt = ((BusinessInfoCheckUpdate.RedTypeInfo)localList.get(1)).red_type.get();
            }
          }
        }
      }
      return "status=" + paramInt + "&number=" + paramAppInfo.num.get() + "&path=" + paramAppInfo.path.get();
    }
    return "status=" + -1 + "&number=0" + "&path=" + paramInt;
  }
  
  public void a(View paramView, LebaGridItemInfo paramLebaGridItemInfo)
  {
    if ((paramView != null) && ((paramView instanceof RedTouch))) {
      ((RedTouch)paramView).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginAction", 2, "clickAction.name=" + paramLebaGridItemInfo.a.resName + ",url=" + paramLebaGridItemInfo.a.jumpInfo);
    }
    d(paramLebaGridItemInfo);
    if (TextUtils.isEmpty(paramLebaGridItemInfo.a.jumpInfo)) {
      b(paramLebaGridItemInfo);
    }
  }
  
  public void a(ImageView paramImageView, int paramInt)
  {
    paramImageView.setImageResource(paramInt);
  }
  
  public void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramImageView.setImageBitmap(paramBitmap);
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo)
  {
    a(paramLebaGridItemInfo).b();
  }
  
  public void a(LebaGridItemInfo paramLebaGridItemInfo, View paramView)
  {
    if ((paramLebaGridItemInfo == null) || (paramLebaGridItemInfo.a == null)) {}
    QQAppInterface localQQAppInterface;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      paramView = (RedTouch)paramView;
      localQQAppInterface = a();
      localAppInfo = a(((RedTouchManager)localQQAppInterface.getManager(35)).a(paramLebaGridItemInfo.a.pluginId + ""));
      a(paramView, localAppInfo, paramLebaGridItemInfo, localQQAppInterface);
    } while (localAppInfo == null);
    paramView.a(localAppInfo);
    ThreadManager.post(new aebd(this, localQQAppInterface, localAppInfo), 2, null, true);
  }
  
  public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo, LebaGridItemInfo paramLebaGridItemInfo, QQAppInterface paramQQAppInterface)
  {
    if (paramRedTouch.a(paramAppInfo))
    {
      if ((paramLebaGridItemInfo.b == -1) && (!paramRedTouch.b(paramAppInfo))) {
        ((LebaGridHandler)paramQQAppInterface.a(106)).a(1, true, Integer.valueOf(paramLebaGridItemInfo.a.pluginId));
      }
      paramLebaGridItemInfo.b = 1;
      return;
    }
    paramLebaGridItemInfo.b = -1;
  }
  
  public void a(boolean paramBoolean, LebaGridItemInfo paramLebaGridItemInfo, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean)
    {
      if ((paramLebaGridItemInfo.b == -1) && (LebaShowListManager.a != 1)) {
        ((LebaGridHandler)paramQQAppInterface.a(106)).a(1, true, Integer.valueOf(paramLebaGridItemInfo.a.pluginId));
      }
      paramLebaGridItemInfo.b = 1;
      return;
    }
    paramLebaGridItemInfo.b = -1;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    Object localObject = a();
    if (paramInt2 == 10000)
    {
      localObject = (QZoneManagerImp)((QQAppInterface)localObject).getManager(9);
      if ((localObject == null) || ((((QZoneManagerImp)localObject).a(2) <= 0) && (((QZoneManagerImp)localObject).a(1) <= 0))) {
        break label103;
      }
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (paramInt2 > 0)
      {
        if (((GameCenterManagerImp)((QQAppInterface)localObject).getManager(11)).a(paramInt2 + "") == -1) {
          return false;
        }
      }
      else if (paramInt1 != 0)
      {
        return false;
        label103:
        bool = false;
      }
    }
  }
  
  protected boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppInfo != null)
    {
      bool1 = bool2;
      if (paramAppInfo.iNewFlag.get() != 0)
      {
        bool1 = bool2;
        if (paramAppInfo.type.get() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b(View paramView, LebaGridItemInfo paramLebaGridItemInfo) {}
  
  public void b(LebaGridItemInfo paramLebaGridItemInfo)
  {
    QQAppInterface localQQAppInterface = a();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramLebaGridItemInfo);
    if (paramLebaGridItemInfo.a.pluginId > 0)
    {
      WebProcessManager localWebProcessManager = (WebProcessManager)localQQAppInterface.getManager(12);
      paramLebaGridItemInfo = String.valueOf(paramLebaGridItemInfo.a.pluginId);
      if ((localAppInfo != null) && (localWebProcessManager != null) && (localWebProcessManager.a(paramLebaGridItemInfo))) {
        ThreadManager.getFileThreadHandler().post(new aebc(this, paramLebaGridItemInfo, localQQAppInterface, localAppInfo));
      }
    }
  }
  
  public void c(View paramView, LebaGridItemInfo paramLebaGridItemInfo) {}
  
  public void c(LebaGridItemInfo paramLebaGridItemInfo)
  {
    if ((paramLebaGridItemInfo == null) || (paramLebaGridItemInfo.a == null)) {
      return;
    }
    try
    {
      if (paramLebaGridItemInfo.a.uiJumpType == 0)
      {
        e(paramLebaGridItemInfo);
        return;
      }
    }
    catch (Exception paramLebaGridItemInfo)
    {
      QLog.e("raymondguo", 2, "jump error", paramLebaGridItemInfo);
      return;
    }
    a(paramLebaGridItemInfo);
  }
  
  public void d(LebaGridItemInfo paramLebaGridItemInfo)
  {
    if ((paramLebaGridItemInfo.a != null) && (paramLebaGridItemInfo.a.pluginId > 0)) {
      ((RedTouchManager)a().getManager(35)).b(paramLebaGridItemInfo.a.pluginId + "");
    }
  }
  
  public void e(LebaGridItemInfo paramLebaGridItemInfo)
  {
    paramLebaGridItemInfo = a(paramLebaGridItemInfo);
    this.a.startActivity(paramLebaGridItemInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.model.pluginactions.PluginAction
 * JD-Core Version:    0.7.0.1
 */