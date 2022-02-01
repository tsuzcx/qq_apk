package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.Context;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.qphone.base.util.QLog;

class HuayangDowanloadHelperImpl$GetLoginKeyDataListener$1
  implements Runnable
{
  HuayangDowanloadHelperImpl$GetLoginKeyDataListener$1(HuayangDowanloadHelperImpl.GetLoginKeyDataListener paramGetLoginKeyDataListener, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startLoadingActivity：");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("IHuayangPluginNewDownloader", 2, ((StringBuilder)localObject).toString());
    }
    if (!HuayangDowanloadHelperImpl.access$1100(this.c.a))
    {
      Context localContext = HuayangDowanloadHelperImpl.access$400(this.c.a);
      String str1 = HuayangDowanloadHelperImpl.GetLoginKeyDataListener.a(this.c);
      IVPluginInfo localIVPluginInfo = HuayangDowanloadHelperImpl.GetLoginKeyDataListener.b(this.c);
      InstalledPlugin localInstalledPlugin = HuayangDowanloadHelperImpl.GetLoginKeyDataListener.c(this.c);
      String str2 = HuayangDowanloadHelperImpl.access$1500(this.c.a);
      if (this.a) {
        localObject = HuayangDowanloadHelperImpl.access$1600(this.c.a);
      } else {
        localObject = null;
      }
      HuayangLoadbackgroudActivity.a(localContext, str1, localIVPluginInfo, localInstalledPlugin, str2, (String)localObject, this.b, this.a, HuayangDowanloadHelperImpl.access$800(this.c.a), HuayangDowanloadHelperImpl.GetLoginKeyDataListener.d(this.c));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IHuayangPluginNewDownloader", 2, "isNeedStop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangDowanloadHelperImpl.GetLoginKeyDataListener.1
 * JD-Core Version:    0.7.0.1
 */