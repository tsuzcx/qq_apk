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
  public static SparseArray<WeakReference<ArkFlashChatContainerWrapper>> a;
  public static int b;
  public static SparseArray<MessageForArkFlashChat> b;
  public int a;
  private ArkAppView.OnVisibleChangeListener jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$OnVisibleChangeListener = new FlashChatTextEffectView.FlashChatAdapter.1(this);
  public OnHolderItemClickListener a;
  private String jdField_a_of_type_JavaLangString = null;
  private WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  List<FlashChatPanel.PluginData> jdField_a_of_type_JavaUtilList = new LinkedList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = null;
  private String b;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_Int = 1;
  }
  
  public FlashChatTextEffectView$FlashChatAdapter(OnHolderItemClickListener paramOnHolderItemClickListener, BaseChatPie paramBaseChatPie, int paramInt, MqqHandler paramMqqHandler)
  {
    this.jdField_b_of_type_JavaLangString = "FlashChatAdapter";
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public FlashChatTextEffectView.MyViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new FlashChatTextEffectView.MyViewHolder(LayoutInflater.from(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().getBaseContext()).inflate(2131561016, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener, this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    jdField_b_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void a(FlashChatTextEffectView.MyViewHolder paramMyViewHolder, int paramInt)
  {
    Object localObject1 = (FlashChatPanel.PluginData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2 = (ViewGroup.MarginLayoutParams)paramMyViewHolder.itemView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).height = FlashChatPanel.f;
    ((ViewGroup.MarginLayoutParams)localObject2).width = FlashChatPanel.e;
    int i = paramInt % 3;
    if (i == 0)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = FlashChatPanel.g;
    }
    else if (i == 2)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = FlashChatPanel.g;
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
    }
    else
    {
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = FlashChatPanel.g;
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = FlashChatPanel.g;
    }
    i = paramInt / 3;
    if (i == 0)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = FlashChatPanel.g;
    }
    else if (i == getItemCount() / 3)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = FlashChatPanel.g;
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = 0;
    }
    else
    {
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = FlashChatPanel.g;
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = FlashChatPanel.g;
    }
    paramMyViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramMyViewHolder.itemView.setBackgroundDrawable(new ColorDrawable(0));
    localObject2 = paramMyViewHolder.itemView;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(HardCodeUtil.a(2131704719));
    ((StringBuilder)localObject3).append(((FlashChatPanel.PluginData)localObject1).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.name);
    ((View)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
    paramMyViewHolder.jdField_a_of_type_Int = ((FlashChatPanel.PluginData)localObject1).jdField_a_of_type_Int;
    paramMyViewHolder.jdField_b_of_type_Int = ((FlashChatPanel.PluginData)localObject1).jdField_b_of_type_Int;
    paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = ((FlashChatPanel.PluginData)localObject1).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem;
    paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel$PluginData = ((FlashChatPanel.PluginData)localObject1);
    paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setClipRadius(4.0F);
    localObject2 = paramMyViewHolder.itemView;
    localObject1 = null;
    ((View)localObject2).setLayerType(0, null);
    try
    {
      paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setVisibility(0);
      paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setBkgColorNormal(Color.parseColor(paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.color));
      label331:
      if (jdField_a_of_type_AndroidUtilSparseArray.get(paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id) != null) {
        localObject1 = (ArkFlashChatContainerWrapper)((WeakReference)jdField_a_of_type_AndroidUtilSparseArray.get(paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id)).get();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new ArkFlashChatContainerWrapper();
        jdField_a_of_type_AndroidUtilSparseArray.put(paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id, new WeakReference(localObject2));
      }
      localObject3 = (MessageForArkFlashChat)jdField_b_of_type_AndroidUtilSparseArray.get(paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new MessageForArkFlashChat();
        i = jdField_b_of_type_Int;
        ((MessageForArkFlashChat)localObject1).uniseq = i;
        jdField_b_of_type_Int = i + 1;
        ((MessageForArkFlashChat)localObject1).ark_app_message = new ArkFlashChatMessage();
        ((MessageForArkFlashChat)localObject1).ark_app_message.preview = true;
        jdField_b_of_type_AndroidUtilSparseArray.put(paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id, localObject1);
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        this.jdField_a_of_type_JavaLangString = FlashChatManager.b(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replaceAll("\\s", "");
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = "";
      }
      if (!HiBoomConstants.b.get()) {
        this.jdField_a_of_type_JavaLangString = "";
      }
      ArkFlashChatMessage localArkFlashChatMessage = ((MessageForArkFlashChat)localObject1).ark_app_message;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localObject3 = HardCodeUtil.a(2131704716);
      } else {
        localObject3 = this.jdField_a_of_type_JavaLangString;
      }
      localArkFlashChatMessage.promptText = ((String)localObject3);
      ((MessageForArkFlashChat)localObject1).ark_app_message.appName = paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.appName;
      ((MessageForArkFlashChat)localObject1).arkContainer = ((ArkFlashChatContainerWrapper)localObject2);
      ((ArkFlashChatContainerWrapper)localObject2).a();
      ((ArkFlashChatContainerWrapper)localObject2).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.sApplication, paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.appName, paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.mainView, paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.ver, paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id, ((MessageForArkFlashChat)localObject1).ark_app_message.getMeta(((MessageForArkFlashChat)localObject1).uniseq, false), paramMyViewHolder.itemView.getContext().getResources().getDisplayMetrics().scaledDensity, ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), FlashChatPanel.e - ScreenUtil.dip2px(7.0F), FlashChatPanel.f - ScreenUtil.dip2px(7.0F), FlashChatPanel.e, FlashChatPanel.f, (MessageForArkFlashChat)localObject1);
      paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = ((MessageForArkFlashChat)localObject1);
      paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnVisibleChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$OnVisibleChangeListener);
      paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new FlashChatTextEffectView.FlashChatAdapter.2(this, paramMyViewHolder, paramInt));
      paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a((ArkAppContainer)localObject2, paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      if ((paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getVisibility() == 0) && (HiBoomConstants.b.get()))
      {
        paramMyViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setVisibility(8);
        FlashChatTextEffectView.a(paramMyViewHolder);
        localObject1 = Message.obtain();
        ((Message)localObject1).obj = paramMyViewHolder;
        ((Message)localObject1).what = paramInt;
        if (paramInt < FlashChatTextEffectView.a().length) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, FlashChatTextEffectView.a()[paramInt]);
        } else {
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, 7000L);
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
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void b()
  {
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      Object localObject = (WeakReference)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localObject != null)
      {
        localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkFlashChatContainerWrapper)localObject).doOnEvent(0);
        }
      }
      i += 1;
    }
  }
  
  public void c()
  {
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      Object localObject = (WeakReference)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localObject != null)
      {
        localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkFlashChatContainerWrapper)localObject).doOnEvent(1);
        }
      }
      i += 1;
    }
  }
  
  public void d()
  {
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      Object localObject = (WeakReference)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localObject != null)
      {
        localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkFlashChatContainerWrapper)localObject).doOnEvent(2);
        }
      }
      i += 1;
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView.FlashChatAdapter
 * JD-Core Version:    0.7.0.1
 */