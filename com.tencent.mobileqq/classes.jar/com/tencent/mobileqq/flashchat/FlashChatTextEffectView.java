package com.tencent.mobileqq.flashchat;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView;
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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 10000, 12000, 7000, 8000, 8000 };
  int jdField_a_of_type_Int;
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  FlashChatObserver jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver = new FlashChatTextEffectView.1(this);
  FlashChatTextEffectView.FlashChatAdapter jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter;
  OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
  WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<FlashChatPanel.PluginData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<Integer, Long> a;
  public MqqHandler a;
  
  public FlashChatTextEffectView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_MqqOsMqqHandler = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public FlashChatTextEffectView(Context paramContext, BaseChatPie paramBaseChatPie, OnHolderItemClickListener paramOnHolderItemClickListener, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_MqqOsMqqHandler = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    this.jdField_a_of_type_Int = paramInt;
    setClipToPadding(false);
    a();
    b();
  }
  
  private static void b(FlashChatTextEffectView.MyViewHolder paramMyViewHolder)
  {
    if ((paramMyViewHolder != null) && (paramMyViewHolder.a != null))
    {
      String str = paramMyViewHolder.a.ark_app_message.appName;
      ArkAppCenter.a().post(str, new FlashChatTextEffectView.2(paramMyViewHolder));
    }
  }
  
  private static void c(FlashChatTextEffectView.MyViewHolder paramMyViewHolder)
  {
    if ((paramMyViewHolder != null) && (paramMyViewHolder.a != null))
    {
      String str = paramMyViewHolder.a.ark_app_message.appName;
      ArkAppCenter.a().post(str, new FlashChatTextEffectView.3(paramMyViewHolder));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.getItemCount();
  }
  
  public FlashChatItem a(int paramInt)
  {
    try
    {
      FlashChatItem localFlashChatItem = ((FlashChatPanel.PluginData)this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a.get(paramInt)).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem;
      return localFlashChatItem;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public FlashChatPanel.PluginData a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (FlashChatPanel.PluginData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  @TargetApi(9)
  public void a()
  {
    setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 3);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(this);
    OnHolderItemClickListener localOnHolderItemClickListener = this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (BaseChatPie localBaseChatPie = null;; localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter = new FlashChatTextEffectView.FlashChatAdapter(localOnHolderItemClickListener, localBaseChatPie, this.jdField_a_of_type_Int, this.jdField_a_of_type_MqqOsMqqHandler);
      setAdapter(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a.size())
      {
        FlashChatPanel.PluginData localPluginData = (FlashChatPanel.PluginData)this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a.get(i);
        if (i == paramInt) {}
        for (localPluginData.jdField_a_of_type_Boolean = true;; localPluginData.jdField_a_of_type_Boolean = false)
        {
          i += 1;
          break;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.notifyDataSetChanged();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      QLog.w("FlashChatTextEffectView", 1, "BaseChatPie released");
      return;
    }
    Object localObject = ((FlashChatManager)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FlashChatItem localFlashChatItem = (FlashChatItem)((Iterator)localObject).next();
      FlashChatPanel.PluginData localPluginData = new FlashChatPanel.PluginData();
      localPluginData.jdField_b_of_type_Int = localFlashChatItem.id;
      if (localFlashChatItem.id != -100000)
      {
        localPluginData.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131704641);
        localPluginData.jdField_a_of_type_JavaLangString = localFlashChatItem.name;
        localPluginData.jdField_a_of_type_Boolean = false;
        localPluginData.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = localFlashChatItem;
        this.jdField_a_of_type_JavaUtilArrayList.add(localPluginData);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.notifyDataSetChanged();
  }
  
  public void c()
  {
    int i = 0;
    while (i <= this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getChildAt(i);
      if (localObject != null)
      {
        localObject = getChildViewHolder((View)localObject);
        if ((localObject instanceof FlashChatTextEffectView.MyViewHolder)) {
          c((FlashChatTextEffectView.MyViewHolder)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a();
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.c();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.d();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter != null) {
      i();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof FlashChatTextEffectView.MyViewHolder)) {}
    for (Object localObject = (FlashChatTextEffectView.MyViewHolder)paramMessage.obj;; localObject = null)
    {
      switch (paramMessage.what)
      {
      }
      label265:
      for (;;)
      {
        return false;
        long l1;
        Long localLong;
        long l2;
        int i;
        if (paramMessage.what < jdField_a_of_type_ArrayOfInt.length)
        {
          l1 = jdField_a_of_type_ArrayOfInt[paramMessage.what];
          localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramMessage.what));
          l2 = SystemClock.uptimeMillis();
          if (localLong != null) {
            break label244;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramMessage.what), Long.valueOf(SystemClock.uptimeMillis()));
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label265;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramMessage.what), Long.valueOf(l2));
          if (QLog.isColorLevel()) {
            QLog.i("shinkencai", 2, "plays position:" + paramMessage.what);
          }
          if (localObject != null) {
            b((FlashChatTextEffectView.MyViewHolder)localObject);
          }
          localObject = Message.obtain();
          ((Message)localObject).what = paramMessage.what;
          ((Message)localObject).obj = paramMessage.obj;
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, l1);
          return false;
          l1 = 7000L;
          break;
          label244:
          if (l2 - localLong.longValue() >= l1) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  void i()
  {
    int i = 0;
    while (i <= this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getChildAt(i);
      if (localObject != null)
      {
        localObject = getChildViewHolder((View)localObject);
        if ((localObject instanceof FlashChatTextEffectView.MyViewHolder))
        {
          localObject = (FlashChatTextEffectView.MyViewHolder)localObject;
          this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a((FlashChatTextEffectView.MyViewHolder)localObject, ((FlashChatTextEffectView.MyViewHolder)localObject).getPosition());
        }
      }
      i += 1;
    }
  }
  
  public void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {}
    for (paramView = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a; paramInt == 0; paramView = BaseApplicationImpl.getApplication().getRuntime())
    {
      paramView.registObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
      return;
    }
    paramView.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView
 * JD-Core Version:    0.7.0.1
 */