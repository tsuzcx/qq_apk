package com.tencent.mobileqq.flashchat;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class FlashChatTextEffectView
  extends RichTextPanelRecyclerView
  implements Handler.Callback
{
  private static final int[] j = { 10000, 12000, 7000, 8000, 8000 };
  FlashChatTextEffectView.FlashChatAdapter a;
  GridLayoutManager b;
  WeakReference<BaseChatPie> c;
  OnHolderItemClickListener d;
  int e;
  FlashChatObserver f = new FlashChatTextEffectView.1(this);
  public MqqHandler g = null;
  ArrayList<FlashChatPanel.PluginData> h = new ArrayList();
  public HashMap<Integer, Long> i = new HashMap();
  
  public FlashChatTextEffectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FlashChatTextEffectView(Context paramContext, BaseChatPie paramBaseChatPie, OnHolderItemClickListener paramOnHolderItemClickListener, int paramInt)
  {
    super(paramContext);
    this.c = new WeakReference(paramBaseChatPie);
    this.d = paramOnHolderItemClickListener;
    this.e = paramInt;
    setClipToPadding(false);
    a();
    b();
  }
  
  private static void b(FlashChatTextEffectView.MyViewHolder paramMyViewHolder)
  {
    if ((paramMyViewHolder != null) && (paramMyViewHolder.g != null))
    {
      String str = paramMyViewHolder.g.ark_app_message.appName;
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(str, new FlashChatTextEffectView.2(paramMyViewHolder));
    }
  }
  
  private static void c(FlashChatTextEffectView.MyViewHolder paramMyViewHolder)
  {
    if ((paramMyViewHolder != null) && (paramMyViewHolder.g != null))
    {
      String str = paramMyViewHolder.g.ark_app_message.appName;
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(str, new FlashChatTextEffectView.3(paramMyViewHolder));
    }
  }
  
  public FlashChatPanel.PluginData a(int paramInt)
  {
    if (paramInt >= this.h.size()) {
      return null;
    }
    return (FlashChatPanel.PluginData)this.h.get(paramInt);
  }
  
  @TargetApi(9)
  public void a()
  {
    setOverScrollMode(2);
    this.b = new GridLayoutManager(getContext(), 3);
    setLayoutManager(this.b);
    this.g = new MqqWeakReferenceHandler(this);
    OnHolderItemClickListener localOnHolderItemClickListener = this.d;
    Object localObject = this.c;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (BaseChatPie)((WeakReference)localObject).get();
    }
    this.a = new FlashChatTextEffectView.FlashChatAdapter(localOnHolderItemClickListener, (BaseChatPie)localObject, this.e, this.g);
    setAdapter(this.a);
  }
  
  public void b()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = ((FlashChatManager)((BaseChatPie)this.c.get()).d.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).g();
      this.h.clear();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FlashChatItem localFlashChatItem = (FlashChatItem)((Iterator)localObject).next();
        FlashChatPanel.PluginData localPluginData = new FlashChatPanel.PluginData();
        localPluginData.e = localFlashChatItem.id;
        if (localFlashChatItem.id != -100000)
        {
          localPluginData.c = HardCodeUtil.a(2131902624);
          localPluginData.b = localFlashChatItem.name;
          localPluginData.d = false;
          localPluginData.f = localFlashChatItem;
          this.h.add(localPluginData);
        }
      }
      this.a.a(this.h);
      this.a.notifyDataSetChanged();
      return;
    }
    QLog.w("FlashChatTextEffectView", 1, "BaseChatPie released");
  }
  
  public void b(int paramInt)
  {
    if (this.a.a != null)
    {
      int k = 0;
      while (k < this.a.a.size())
      {
        FlashChatPanel.PluginData localPluginData = (FlashChatPanel.PluginData)this.a.a.get(k);
        if (k == paramInt) {
          localPluginData.d = true;
        } else {
          localPluginData.d = false;
        }
        k += 1;
      }
    }
    this.a.notifyDataSetChanged();
  }
  
  public FlashChatItem c(int paramInt)
  {
    try
    {
      FlashChatItem localFlashChatItem = ((FlashChatPanel.PluginData)this.a.a.get(paramInt)).f;
      return localFlashChatItem;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void c()
  {
    int k = 0;
    while (k <= this.b.getChildCount())
    {
      Object localObject = this.b.getChildAt(k);
      if (localObject != null)
      {
        localObject = getChildViewHolder((View)localObject);
        if ((localObject instanceof FlashChatTextEffectView.MyViewHolder)) {
          c((FlashChatTextEffectView.MyViewHolder)localObject);
        }
      }
      k += 1;
    }
  }
  
  public void d()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((FlashChatTextEffectView.FlashChatAdapter)localObject).a();
    }
    localObject = this.g;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public void e()
  {
    FlashChatTextEffectView.FlashChatAdapter localFlashChatAdapter = this.a;
    if (localFlashChatAdapter != null) {
      localFlashChatAdapter.b();
    }
  }
  
  public void f()
  {
    FlashChatTextEffectView.FlashChatAdapter localFlashChatAdapter = this.a;
    if (localFlashChatAdapter != null) {
      localFlashChatAdapter.c();
    }
  }
  
  public void g()
  {
    FlashChatTextEffectView.FlashChatAdapter localFlashChatAdapter = this.a;
    if (localFlashChatAdapter != null) {
      localFlashChatAdapter.d();
    }
  }
  
  public int getSize()
  {
    return this.a.getItemCount();
  }
  
  public void h()
  {
    if (this.a != null) {
      i();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    if ((paramMessage.obj instanceof FlashChatTextEffectView.MyViewHolder)) {
      localObject1 = (FlashChatTextEffectView.MyViewHolder)paramMessage.obj;
    } else {
      localObject1 = null;
    }
    int m = paramMessage.what;
    int k = 1;
    if ((m != 0) && (m != 1) && (m != 2) && (m != 3) && (m != 4)) {
      return false;
    }
    m = paramMessage.what;
    Object localObject2 = j;
    long l1;
    if (m < localObject2.length) {
      l1 = localObject2[paramMessage.what];
    } else {
      l1 = 7000L;
    }
    localObject2 = (Long)this.i.get(Integer.valueOf(paramMessage.what));
    long l2 = SystemClock.uptimeMillis();
    if (localObject2 == null) {
      this.i.put(Integer.valueOf(paramMessage.what), Long.valueOf(SystemClock.uptimeMillis()));
    } else if (l2 - ((Long)localObject2).longValue() < l1) {
      k = 0;
    }
    if (k != 0)
    {
      this.i.put(Integer.valueOf(paramMessage.what), Long.valueOf(l2));
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("plays position:");
        ((StringBuilder)localObject2).append(paramMessage.what);
        QLog.i("shinkencai", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 != null) {
        b((FlashChatTextEffectView.MyViewHolder)localObject1);
      }
      localObject1 = Message.obtain();
      ((Message)localObject1).what = paramMessage.what;
      ((Message)localObject1).obj = paramMessage.obj;
      this.g.sendMessageDelayed((Message)localObject1, l1);
    }
    return false;
  }
  
  void i()
  {
    int k = 0;
    while (k <= this.b.getChildCount())
    {
      Object localObject = this.b.getChildAt(k);
      if (localObject != null)
      {
        localObject = getChildViewHolder((View)localObject);
        if ((localObject instanceof FlashChatTextEffectView.MyViewHolder))
        {
          localObject = (FlashChatTextEffectView.MyViewHolder)localObject;
          this.a.a((FlashChatTextEffectView.MyViewHolder)localObject, ((FlashChatTextEffectView.MyViewHolder)localObject).getPosition());
        }
      }
      k += 1;
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    paramView = this.c;
    if ((paramView != null) && (paramView.get() != null)) {
      paramView = ((BaseChatPie)this.c.get()).d;
    } else {
      paramView = BaseApplicationImpl.getApplication().getRuntime();
    }
    if (paramInt == 0)
    {
      paramView.registObserver(this.f);
      return;
    }
    paramView.unRegistObserver(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView
 * JD-Core Version:    0.7.0.1
 */