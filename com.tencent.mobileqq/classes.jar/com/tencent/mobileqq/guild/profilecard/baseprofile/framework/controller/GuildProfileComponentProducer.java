package com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller;

import android.util.SparseArray;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.collector.GuildProfileComponentCollector;
import com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

public class GuildProfileComponentProducer
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  private final SparseArray<Class<? extends AbsGuildProfileComponent>> b = new SparseArray();
  
  private void a()
  {
    this.b.clear();
    SparseArray localSparseArray = new GuildProfileComponentCollector().a();
    if ((localSparseArray != null) && (localSparseArray.size() > 0))
    {
      int j = localSparseArray.size();
      int i = 0;
      while (i < j)
      {
        int k = localSparseArray.keyAt(i);
        this.b.put(k, localSparseArray.get(k));
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildProfileComponentProducer", 2, String.format("initProfileComponentArray size=%s", new Object[] { Integer.valueOf(this.b.size()) }));
    }
  }
  
  private AbsGuildProfileComponent b(int paramInt, IGuildComponentController paramIGuildComponentController, GuildProfileData paramGuildProfileData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildProfileComponentProducer", 2, String.format("create componentType=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    try
    {
      paramIGuildComponentController = (AbsGuildProfileComponent)((Class)this.b.get(paramInt)).getConstructor(new Class[] { IGuildComponentController.class, GuildProfileData.class }).newInstance(new Object[] { paramIGuildComponentController, paramGuildProfileData });
    }
    catch (Exception paramIGuildComponentController)
    {
      QLog.e("GuildProfileComponentProducer", 1, "create component fail.", paramIGuildComponentController);
      paramIGuildComponentController = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildProfileComponentProducer", 2, String.format("create from base component factory. component=%s", new Object[] { paramIGuildComponentController }));
    }
    return paramIGuildComponentController;
  }
  
  public AbsGuildProfileComponent a(int paramInt, IGuildComponentController paramIGuildComponentController, GuildProfileData paramGuildProfileData)
  {
    if (!this.a.get())
    {
      this.a.set(true);
      a();
    }
    return b(paramInt, paramIGuildComponentController, paramGuildProfileData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.framework.controller.GuildProfileComponentProducer
 * JD-Core Version:    0.7.0.1
 */