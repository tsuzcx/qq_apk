package com.tencent.mobileqq.utils.tab;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.ITabDataUtil;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.xtab.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.qcircle.api.data.QCircleExposeDataBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.Set;
import java.util.TimeZone;

public class TabDataUtil
  implements ITabDataUtil
{
  private final ThreadLocal<StringBuilder> a = new TabDataUtil.1(this);
  
  protected static String a(SosoLbsInfo paramSosoLbsInfo)
  {
    return String.valueOf(paramSosoLbsInfo.mLocation.mLat02);
  }
  
  protected static String b(SosoLbsInfo paramSosoLbsInfo)
  {
    return String.valueOf(paramSosoLbsInfo.mLocation.mLon02);
  }
  
  public static void b(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("toggleKandianTab isChecked:");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("TabDataUtil", 1, ((StringBuilder)localObject).toString());
        localObject = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
        if (paramBoolean)
        {
          i = 1;
          ((IReadInJoyHelper)localObject).updateLocalCacheSwitch(i);
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateKandianTabConfigSwitchSp(paramBoolean);
          ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateHasSetSwitch(true);
          return;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("toggleKandianTab error:");
        localStringBuilder.append(localException);
        QLog.i("TabDataUtil", 1, localStringBuilder.toString());
        return;
      }
      int i = 0;
    }
  }
  
  private String e()
  {
    Object localObject = PlatformInfor.g().getDeviceInfor();
    this.a.set(new StringBuilder());
    StringBuilder localStringBuilder = (StringBuilder)this.a.get();
    if ((localObject != null) && (((String)localObject).length() > 0) && (localStringBuilder != null))
    {
      localStringBuilder.setLength(0);
      localStringBuilder.trimToSize();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append('&');
      localStringBuilder.append("timezone=");
      localStringBuilder.append(TimeZone.getDefault().getID());
      localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle");
      if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
      {
        localStringBuilder.append('&');
        localStringBuilder.append("latitude=");
        localStringBuilder.append(a((SosoLbsInfo)localObject));
        localStringBuilder.append('&');
        localStringBuilder.append("longitude=");
        localStringBuilder.append(b((SosoLbsInfo)localObject));
      }
      localStringBuilder.append('&');
      localStringBuilder.append("vh265=");
      if ("".equals(QCircleExposeDataBean.sIsSupportHEVC)) {
        localObject = Integer.valueOf(0);
      } else {
        localObject = QCircleExposeDataBean.sIsSupportHEVC;
      }
      localStringBuilder.append(localObject);
      return localStringBuilder.toString();
    }
    this.a.set(null);
    this.a.remove();
    return localObject;
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(Conversation.class.getName(), Integer.valueOf(1));
    localHashMap.put(Contacts.class.getName(), Integer.valueOf(2));
    localHashMap.put(QzoneFrame.class.getName(), Integer.valueOf(3));
    localHashMap.put(((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass().getName(), Integer.valueOf(3));
    localHashMap.put(((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName(), Integer.valueOf(4));
    localHashMap.put(QCircleFrame.class.getName(), Integer.valueOf(5));
    localHashMap.put(((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getTabFrame().getName(), Integer.valueOf(6));
    if (!localHashMap.keySet().contains(paramString)) {
      return 1;
    }
    return ((Integer)localHashMap.get(paramString)).intValue();
  }
  
  public String a()
  {
    return QUA.getQUA3();
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  public String b()
  {
    return e();
  }
  
  public boolean c()
  {
    return ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTab();
  }
  
  public void d()
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.putExtra("KEY_ENTRANCE", "VALUE_QQ_SETTING_FRAGMENT");
    QPublicFragmentActivity.Launcher.a(BaseApplicationImpl.getContext(), localIntent, QPublicFragmentActivity.class, BottomTabSettingFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.tab.TabDataUtil
 * JD-Core Version:    0.7.0.1
 */