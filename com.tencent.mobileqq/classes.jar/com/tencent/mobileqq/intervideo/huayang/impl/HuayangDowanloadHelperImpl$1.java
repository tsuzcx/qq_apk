package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.qroute.QRoute;

class HuayangDowanloadHelperImpl$1
  implements IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener
{
  HuayangDowanloadHelperImpl$1(HuayangDowanloadHelperImpl paramHuayangDowanloadHelperImpl) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Intent localIntent = new Intent(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(HuayangDowanloadHelperImpl.access$000(this.a)));
    localIntent.putExtra("key_state", paramInt);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                if (paramInt == 10) {
                  HuayangDowanloadHelperImpl.access$300(this.a);
                }
              }
              else
              {
                localIntent.putExtra("key_error_msg", (String)paramVarArgs[0]);
                if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangDowanloadHelperImpl.access$000(this.a))) {
                  Monitor.a("2691704");
                } else if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isHyPkg(HuayangDowanloadHelperImpl.access$000(this.a))) {
                  Monitor.a("2597721");
                }
              }
            }
            else
            {
              if ("download".equals(HuayangDowanloadHelperImpl.access$100(this.a)))
              {
                InstalledPlugin localInstalledPlugin = (InstalledPlugin)paramVarArgs[0];
                boolean bool = ((Boolean)paramVarArgs[1]).booleanValue();
                long l = ((Long)paramVarArgs[2]).longValue();
                HuayangDowanloadHelperImpl.access$200(this.a, localInstalledPlugin, bool, l);
              }
              if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangDowanloadHelperImpl.access$000(this.a))) {
                Monitor.a("2691703");
              } else if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isHyPkg(HuayangDowanloadHelperImpl.access$000(this.a))) {
                Monitor.a("2597720");
              }
            }
          }
          else
          {
            localIntent.putExtra("key_error_msg", (String)paramVarArgs[0]);
            if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangDowanloadHelperImpl.access$000(this.a))) {
              Monitor.a("2691710");
            } else if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isHyPkg(HuayangDowanloadHelperImpl.access$000(this.a))) {
              Monitor.a("2597858");
            }
          }
        }
        else
        {
          localIntent.putExtra("key_installedplugin", (InstalledPlugin)paramVarArgs[0]);
          if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangDowanloadHelperImpl.access$000(this.a))) {
            Monitor.a("2691709");
          } else if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).isHyPkg(HuayangDowanloadHelperImpl.access$000(this.a))) {
            Monitor.a("2597857");
          }
        }
      }
      else
      {
        paramInt = ((Integer)paramVarArgs[0]).intValue();
        localIntent.putExtra("key_totalSize", ((Long)paramVarArgs[1]).longValue());
        localIntent.putExtra("key_progress", paramInt);
      }
    }
    else {
      localIntent.putExtra("key_totalSize", ((Long)paramVarArgs[0]).longValue());
    }
    HuayangDowanloadHelperImpl.access$400(this.a).sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangDowanloadHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */