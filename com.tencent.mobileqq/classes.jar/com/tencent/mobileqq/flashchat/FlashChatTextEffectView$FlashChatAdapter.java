package com.tencent.mobileqq.flashchat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkAppView.OnVisibleChangeListener;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class FlashChatTextEffectView$FlashChatAdapter
  extends RecyclerView.Adapter<FlashChatTextEffectView.MyViewHolder>
{
  public static SparseArray<WeakReference<ArkFlashChatContainerWrapper>> c = new SparseArray();
  public static SparseArray<MessageForArkFlashChat> d = new SparseArray();
  public static int f = 1;
  List<FlashChatPanel.PluginData> a = new LinkedList();
  public OnHolderItemClickListener b;
  public int e;
  private String g = null;
  private WeakReference<BaseChatPie> h;
  private String i = "FlashChatAdapter";
  private MqqHandler j = null;
  private ArkAppView.OnVisibleChangeListener k = new FlashChatTextEffectView.FlashChatAdapter.1(this);
  
  public FlashChatTextEffectView$FlashChatAdapter(OnHolderItemClickListener paramOnHolderItemClickListener, BaseChatPie paramBaseChatPie, int paramInt, MqqHandler paramMqqHandler)
  {
    this.b = paramOnHolderItemClickListener;
    this.h = new WeakReference(paramBaseChatPie);
    this.e = paramInt;
    this.j = paramMqqHandler;
  }
  
  public FlashChatTextEffectView.MyViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new FlashChatTextEffectView.MyViewHolder(LayoutInflater.from(((BaseChatPie)this.h.get()).aX().getBaseContext()).inflate(2131627357, paramViewGroup, false), this.b, this.e);
  }
  
  public void a()
  {
    c.clear();
    d.clear();
  }
  
  public void a(FlashChatTextEffectView.MyViewHolder paramMyViewHolder, int paramInt)
  {
    Object localObject1 = (FlashChatPanel.PluginData)this.a.get(paramInt);
    Object localObject2 = (ViewGroup.MarginLayoutParams)paramMyViewHolder.itemView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).height = FlashChatPanel.n;
    ((ViewGroup.MarginLayoutParams)localObject2).width = FlashChatPanel.m;
    int m = paramInt % 3;
    if (m == 0)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = FlashChatPanel.o;
    }
    else if (m == 2)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = FlashChatPanel.o;
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
    }
    else
    {
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = FlashChatPanel.o;
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = FlashChatPanel.o;
    }
    m = paramInt / 3;
    if (m == 0)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = FlashChatPanel.o;
    }
    else if (m == getItemCount() / 3)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = FlashChatPanel.o;
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = 0;
    }
    else
    {
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = FlashChatPanel.o;
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = FlashChatPanel.o;
    }
    paramMyViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramMyViewHolder.itemView.setBackgroundDrawable(new ColorDrawable(0));
    localObject2 = paramMyViewHolder.itemView;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131902622));
    ((StringBuilder)localObject3).append(((FlashChatPanel.PluginData)localObject1).f.name);
    ((View)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
    paramMyViewHolder.b = ((FlashChatPanel.PluginData)localObject1).a;
    paramMyViewHolder.c = ((FlashChatPanel.PluginData)localObject1).e;
    paramMyViewHolder.d = ((FlashChatPanel.PluginData)localObject1).f;
    paramMyViewHolder.e = ((FlashChatPanel.PluginData)localObject1);
    paramMyViewHolder.h.setClipRadius(4.0F);
    localObject2 = paramMyViewHolder.itemView;
    localObject1 = null;
    ((View)localObject2).setLayerType(0, null);
    try
    {
      paramMyViewHolder.i.setVisibility(0);
      paramMyViewHolder.i.setBkgColorNormal(Color.parseColor(paramMyViewHolder.d.color));
      label331:
      if (c.get(paramMyViewHolder.d.id) != null) {
        localObject1 = (ArkFlashChatContainerWrapper)((WeakReference)c.get(paramMyViewHolder.d.id)).get();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new ArkFlashChatContainerWrapper();
        c.put(paramMyViewHolder.d.id, new WeakReference(localObject2));
      }
      localObject3 = (MessageForArkFlashChat)d.get(paramMyViewHolder.d.id);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new MessageForArkFlashChat();
        m = f;
        ((MessageForArkFlashChat)localObject1).uniseq = m;
        f = m + 1;
        ((MessageForArkFlashChat)localObject1).ark_app_message = new ArkFlashChatMessage();
        ((MessageForArkFlashChat)localObject1).ark_app_message.preview = true;
        d.put(paramMyViewHolder.d.id, localObject1);
      }
      if (this.h.get() != null)
      {
        this.g = FlashChatManager.b(((BaseChatPie)this.h.get()).Y.getText().toString());
        this.g = this.g.replaceAll("\\s", "");
      }
      else
      {
        this.g = "";
      }
      if (!HiBoomConstants.c.get()) {
        this.g = "";
      }
      ArkFlashChatMessage localArkFlashChatMessage = ((MessageForArkFlashChat)localObject1).ark_app_message;
      if (TextUtils.isEmpty(this.g)) {
        localObject3 = HardCodeUtil.a(2131902619);
      } else {
        localObject3 = this.g;
      }
      localArkFlashChatMessage.promptText = ((String)localObject3);
      ((MessageForArkFlashChat)localObject1).ark_app_message.appName = paramMyViewHolder.d.appName;
      ((MessageForArkFlashChat)localObject1).arkContainer = ((ArkFlashChatContainerWrapper)localObject2);
      ((ArkFlashChatContainerWrapper)localObject2).a();
      ((ArkFlashChatContainerWrapper)localObject2).a(((BaseChatPie)this.h.get()).d, BaseApplicationImpl.sApplication, paramMyViewHolder.d.appName, paramMyViewHolder.d.mainView, paramMyViewHolder.d.ver, paramMyViewHolder.d.id, ((MessageForArkFlashChat)localObject1).ark_app_message.getMeta(((MessageForArkFlashChat)localObject1).uniseq, false), paramMyViewHolder.itemView.getContext().getResources().getDisplayMetrics().scaledDensity, ((BaseChatPie)this.h.get()).aE(), FlashChatPanel.m - ScreenUtil.dip2px(7.0F), FlashChatPanel.n - ScreenUtil.dip2px(7.0F), FlashChatPanel.m, FlashChatPanel.n, (MessageForArkFlashChat)localObject1);
      paramMyViewHolder.g = ((MessageForArkFlashChat)localObject1);
      paramMyViewHolder.h.setOnVisibleChangeListener(this.k);
      paramMyViewHolder.h.setCallback(new FlashChatTextEffectView.FlashChatAdapter.2(this, paramMyViewHolder, paramInt));
      paramMyViewHolder.h.a((ArkAppContainer)localObject2, paramMyViewHolder.i);
      if ((paramMyViewHolder.h.getVisibility() == 0) && (HiBoomConstants.c.get()))
      {
        paramMyViewHolder.i.setVisibility(8);
        FlashChatTextEffectView.a(paramMyViewHolder);
        localObject1 = Message.obtain();
        ((Message)localObject1).obj = paramMyViewHolder;
        ((Message)localObject1).what = paramInt;
        if (paramInt < FlashChatTextEffectView.j().length) {
          this.j.sendMessageDelayed((Message)localObject1, FlashChatTextEffectView.j()[paramInt]);
        } else {
          this.j.sendMessageDelayed((Message)localObject1, 7000L);
        }
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramMyViewHolder, paramInt, getItemId(paramInt));
      return;
    }
    catch (Throwable localThrowable)
    {
      break label331;
    }
  }
  
  public void a(List<? extends FlashChatPanel.PluginData> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
  }
  
  public void b()
  {
    int m = 0;
    while (m < c.size())
    {
      Object localObject = (WeakReference)c.valueAt(m);
      if (localObject != null)
      {
        localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkFlashChatContainerWrapper)localObject).doOnEvent(0);
        }
      }
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    while (m < c.size())
    {
      Object localObject = (WeakReference)c.valueAt(m);
      if (localObject != null)
      {
        localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkFlashChatContainerWrapper)localObject).doOnEvent(1);
        }
      }
      m += 1;
    }
  }
  
  public void d()
  {
    int m = 0;
    while (m < c.size())
    {
      Object localObject = (WeakReference)c.valueAt(m);
      if (localObject != null)
      {
        localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkFlashChatContainerWrapper)localObject).doOnEvent(2);
        }
      }
      m += 1;
    }
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView.FlashChatAdapter
 * JD-Core Version:    0.7.0.1
 */