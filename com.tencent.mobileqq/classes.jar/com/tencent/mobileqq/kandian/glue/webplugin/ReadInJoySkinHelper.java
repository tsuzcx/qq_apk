package com.tencent.mobileqq.kandian.glue.webplugin;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoySkinHelper;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class ReadInJoySkinHelper
  implements IReadInJoySkinHelper
{
  private HashMap<String, ReadInJoySkinHelper.SkinDownloadListener> b = new HashMap();
  private AppRuntime c;
  private TroopMemberApiService d;
  
  public ReadInJoySkinHelper(AppRuntime paramAppRuntime, TroopMemberApiService paramTroopMemberApiService)
  {
    this.c = paramAppRuntime;
    this.d = paramTroopMemberApiService;
  }
  
  public void a()
  {
    QLog.d("ReadInJoySkinHelper", 1, "onDestroy");
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.c.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext()) {
      localReadInJoySkinManager.b((DownloadListener)((Map.Entry)localIterator.next()).getValue());
    }
    this.c = null;
    this.d = null;
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive load skin cmd");
    }
    Object localObject1 = this.c;
    if ((localObject1 != null) && (this.d != null))
    {
      Object localObject2 = (ReadInJoySkinManager)((AppRuntime)localObject1).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      localObject1 = paramBundle.getString("skinId");
      long l1 = paramBundle.getLong("skinSeq");
      String str1 = paramBundle.getString("skinName");
      String str2 = paramBundle.getString("skinUrl");
      long l2 = paramBundle.getLong("startTime");
      long l3 = paramBundle.getLong("endTime");
      ReadInJoySkinHelper.SkinDownloadListener localSkinDownloadListener = new ReadInJoySkinHelper.SkinDownloadListener(this.c, (String)localObject1, paramBundle, this.d);
      this.b.put(localObject1, localSkinDownloadListener);
      boolean bool = ((ReadInJoySkinManager)localObject2).a((String)localObject1, str1, str2, l1, l2, l3, localSkinDownloadListener);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadResult：");
        ((StringBuilder)localObject2).append(bool);
        QLog.d("readinjoy", 4, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("seq", paramBundle.getInt("seq"));
        ((Bundle)localObject2).putInt("retCode", 0);
        ((Bundle)localObject2).putInt("rate", 100);
        ((Bundle)localObject2).putString("skinId", (String)localObject1);
        this.d.a(107, (Bundle)localObject2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "mApp == null || mService == null");
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive cancel load skin cmd");
    }
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      if (this.d == null) {
        return;
      }
      Object localObject2 = (ReadInJoySkinManager)((AppRuntime)localObject1).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      localObject1 = paramBundle.getString("skinId");
      paramBundle.getString("skinUrl");
      boolean bool = ((ReadInJoySkinManager)localObject2).a((String)localObject1);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("seq", paramBundle.getInt("seq"));
      int i;
      if (bool) {
        i = 0;
      } else {
        i = -1;
      }
      ((Bundle)localObject2).putInt("retCode", i);
      ((Bundle)localObject2).putString("skinId", (String)localObject1);
      this.d.a(108, (Bundle)localObject2);
    }
  }
  
  public void c(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoySkinHelper
 * JD-Core Version:    0.7.0.1
 */