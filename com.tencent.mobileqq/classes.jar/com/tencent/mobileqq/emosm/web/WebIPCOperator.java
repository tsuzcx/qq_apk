package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class WebIPCOperator
{
  private static WebIPCOperator b;
  EmojiIPCAlarmer a = null;
  private CopyOnWriteArrayList<OnRemoteRespObserver> c = new CopyOnWriteArrayList();
  private Client d = new Client();
  private Handler e = new Handler(Looper.getMainLooper());
  private int f = 0;
  private Vector<WebIPCOperator.RequestItem> g = new Vector();
  private EmojiIPCAlarmer.TimeoutObserver h = new WebIPCOperator.5(this);
  
  public static WebIPCOperator a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new WebIPCOperator();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchBindToClient suc");
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((OnRemoteRespObserver)localIterator.next()).onBindedToClient();
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchBindToClient suc");
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((OnRemoteRespObserver)localIterator.next()).onDisconnectWithService();
    }
  }
  
  private void g(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "dispatchPushMsg suc");
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((OnRemoteRespObserver)localIterator.next()).onPushMsg(paramBundle);
    }
  }
  
  private void h()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "alarm init");
      }
      this.a = new EmojiIPCAlarmer(this.h);
      this.a.a();
    }
  }
  
  public WebIPCOperator.RequestItem a(int paramInt)
  {
    synchronized (this.g)
    {
      Object localObject2 = this.g.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        WebIPCOperator.RequestItem localRequestItem = (WebIPCOperator.RequestItem)((Iterator)localObject2).next();
        if (localRequestItem.a == paramInt)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("remove req queue seq:");
            ((StringBuilder)localObject2).append(paramInt);
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, ((StringBuilder)localObject2).toString());
          }
          this.a.a(localRequestItem.c);
          this.g.remove(localRequestItem);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("after remove req queue size:");
            ((StringBuilder)localObject2).append(this.g.size());
            QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, ((StringBuilder)localObject2).toString());
          }
          return localRequestItem;
        }
      }
      return null;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("Q.emoji.web.EmoWebIPCOperator", 1, "error:reqbundle is null.");
      return;
    }
    Object localObject = f(paramBundle);
    if (localObject != null)
    {
      Client localClient = this.d;
      if ((localClient == null) || (!localClient.onReqToServer(((WebIPCOperator.RequestItem)localObject).b)))
      {
        paramBundle = a(paramBundle.getInt("seq"));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sendServiceIpcReq unbind fail seq:");
          ((StringBuilder)localObject).append(this.f);
          QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, ((StringBuilder)localObject).toString());
        }
        if (paramBundle != null)
        {
          localObject = new Bundle();
          a((Bundle)localObject, 1002);
          paramBundle.b.putBundle("response", (Bundle)localObject);
          a(new WebIPCOperator.1(this, paramBundle));
        }
      }
    }
  }
  
  void a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle != null) {
      paramBundle.putInt("failcode", paramInt);
    }
  }
  
  public void a(OnRemoteRespObserver paramOnRemoteRespObserver)
  {
    if (paramOnRemoteRespObserver == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RegisterObserver key:");
      localStringBuilder.append(paramOnRemoteRespObserver.key);
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, localStringBuilder.toString());
    }
    if (!this.c.contains(paramOnRemoteRespObserver)) {
      this.c.add(paramOnRemoteRespObserver);
    }
  }
  
  void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.e.post(paramRunnable);
    }
  }
  
  public void b()
  {
    f();
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = this.d;
      if ((localObject == null) || (!((Client)localObject).onReqToServer(paramBundle)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sendServiceIpcReq unbind fail seq:");
          ((StringBuilder)localObject).append(this.f);
          QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new Bundle();
        a((Bundle)localObject, 1002);
        paramBundle.putBundle("response", (Bundle)localObject);
        a(new WebIPCOperator.2(this, paramBundle));
      }
    }
  }
  
  public void b(OnRemoteRespObserver paramOnRemoteRespObserver)
  {
    if (paramOnRemoteRespObserver != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unRegisterObserver key:");
        localStringBuilder.append(paramOnRemoteRespObserver.key);
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, localStringBuilder.toString());
      }
      if (this.c.contains(paramOnRemoteRespObserver)) {
        this.c.remove(paramOnRemoteRespObserver);
      }
    }
  }
  
  public Client c()
  {
    return this.d;
  }
  
  public void c(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("seq");
      Object localObject = a(i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dispatchResp seq:");
        localStringBuilder.append(i);
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, localStringBuilder.toString());
      }
      if (localObject != null)
      {
        a(paramBundle, 1000);
        a(new WebIPCOperator.3(this, paramBundle));
        return;
      }
      localObject = paramBundle.getString("cmd");
      if ((localObject != null) && ((((String)localObject).equals("startDownloadEmoji")) || (((String)localObject).equals("stopdownload")) || (((String)localObject).equals("openEquipmentLock")) || (((String)localObject).equals("card_setSummaryCard")) || (((String)localObject).equals("card_getVipInfo")) || (((String)localObject).equals("closeWeb")) || (((String)localObject).equals("setMobileResult")) || (((String)localObject).equals("setWaitingResponse")) || (((String)localObject).equals("openEmojiMall")) || (((String)localObject).equals("openProfileCard")) || (((String)localObject).equals("close_version")) || (((String)localObject).equals("openEmojiDetail")) || (((String)localObject).equals("openFontSetting")) || (((String)localObject).equals("startDownloadColorRing")) || (((String)localObject).equals("stopDownloadColorRing")) || (((String)localObject).equals("funcall_download")) || (((String)localObject).equals("funcall_set")) || (((String)localObject).equals("getA2")) || (((String)localObject).equals("openDevLock")) || (((String)localObject).equals("queryDevLockStatus")) || (((String)localObject).equals("ipc_funnypic_add")) || (((String)localObject).equals("ipc_video_isinstalled")) || (((String)localObject).equals("ipc_video_install_plugin")) || (((String)localObject).equals("gamecenter_delaydownload")) || (((String)localObject).equals("emojiStickerRecall")) || (((String)localObject).equals("ipc_cmd_get_team_work_url"))))
      {
        a(paramBundle, 1000);
        a(new WebIPCOperator.4(this, paramBundle));
      }
    }
  }
  
  public void d()
  {
    g();
  }
  
  public void d(Bundle paramBundle)
  {
    g(paramBundle);
  }
  
  void e(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("cmd");
    int i = paramBundle.getInt("failcode");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchResp suc: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", retCode: ");
      localStringBuilder.append(i);
      QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, localStringBuilder.toString());
    }
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OnRemoteRespObserver)((Iterator)localObject).next()).onResponse(paramBundle);
    }
  }
  
  public boolean e()
  {
    Client localClient = this.d;
    if (localClient != null) {
      return localClient.isClientBinded();
    }
    return false;
  }
  
  public WebIPCOperator.RequestItem f(Bundle paramBundle)
  {
    synchronized (this.g)
    {
      int i = this.f;
      this.f = (i + 1);
      paramBundle = new WebIPCOperator.RequestItem(i, paramBundle);
      h();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("add to req queue seq: ");
        localStringBuilder.append(paramBundle.a);
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, localStringBuilder.toString());
      }
      paramBundle.c = this.a.a(paramBundle.a, 30000L);
      this.g.add(paramBundle);
      return paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.WebIPCOperator
 * JD-Core Version:    0.7.0.1
 */