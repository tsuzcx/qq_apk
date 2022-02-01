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
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(str, new FlashChatTextEffectView.2(paramMyViewHolder));
    }
  }
  
  private static void c(FlashChatTextEffectView.MyViewHolder paramMyViewHolder)
  {
    if ((paramMyViewHolder != null) && (paramMyViewHolder.a != null))
    {
      String str = paramMyViewHolder.a.ark_app_message.appName;
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(str, new FlashChatTextEffectView.3(paramMyViewHolder));
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
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (BaseChatPie)((WeakReference)localObject).get();
    }
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter = new FlashChatTextEffectView.FlashChatAdapter(localOnHolderItemClickListener, (BaseChatPie)localObject, this.jdField_a_of_type_Int, this.jdField_a_of_type_MqqOsMqqHandler);
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a.size())
      {
        FlashChatPanel.PluginData localPluginData = (FlashChatPanel.PluginData)this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a.get(i);
        if (i == paramInt) {
          localPluginData.jdField_a_of_type_Boolean = true;
        } else {
          localPluginData.jdField_a_of_type_Boolean = false;
        }
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.notifyDataSetChanged();
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = ((FlashChatManager)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FlashChatItem localFlashChatItem = (FlashChatItem)((Iterator)localObject).next();
        FlashChatPanel.PluginData localPluginData = new FlashChatPanel.PluginData();
        localPluginData.jdField_b_of_type_Int = localFlashChatItem.id;
        if (localFlashChatItem.id != -100000)
        {
          localPluginData.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131704721);
          localPluginData.jdField_a_of_type_JavaLangString = localFlashChatItem.name;
          localPluginData.jdField_a_of_type_Boolean = false;
          localPluginData.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = localFlashChatItem;
          this.jdField_a_of_type_JavaUtilArrayList.add(localPluginData);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter.notifyDataSetChanged();
      return;
    }
    QLog.w("FlashChatTextEffectView", 1, "BaseChatPie released");
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter;
    if (localObject != null) {
      ((FlashChatTextEffectView.FlashChatAdapter)localObject).a();
    }
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public void e()
  {
    FlashChatTextEffectView.FlashChatAdapter localFlashChatAdapter = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter;
    if (localFlashChatAdapter != null) {
      localFlashChatAdapter.b();
    }
  }
  
  public void f()
  {
    FlashChatTextEffectView.FlashChatAdapter localFlashChatAdapter = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter;
    if (localFlashChatAdapter != null) {
      localFlashChatAdapter.c();
    }
  }
  
  public void g()
  {
    FlashChatTextEffectView.FlashChatAdapter localFlashChatAdapter = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatTextEffectView$FlashChatAdapter;
    if (localFlashChatAdapter != null) {
      localFlashChatAdapter.d();
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
    Object localObject1;
    if ((paramMessage.obj instanceof FlashChatTextEffectView.MyViewHolder)) {
      localObject1 = (FlashChatTextEffectView.MyViewHolder)paramMessage.obj;
    } else {
      localObject1 = null;
    }
    int j = paramMessage.what;
    int i = 1;
    if ((j != 0) && (j != 1) && (j != 2) && (j != 3) && (j != 4)) {
      return false;
    }
    j = paramMessage.what;
    Object localObject2 = jdField_a_of_type_ArrayOfInt;
    long l1;
    if (j < localObject2.length) {
      l1 = localObject2[paramMessage.what];
    } else {
      l1 = 7000L;
    }
    localObject2 = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramMessage.what));
    long l2 = SystemClock.uptimeMillis();
    if (localObject2 == null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramMessage.what), Long.valueOf(SystemClock.uptimeMillis()));
    } else if (l2 - ((Long)localObject2).longValue() < l1) {
      i = 0;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramMessage.what), Long.valueOf(l2));
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
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, l1);
    }
    return false;
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
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    paramView = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((paramView != null) && (paramView.get() != null)) {
      paramView = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a;
    } else {
      paramView = BaseApplicationImpl.getApplication().getRuntime();
    }
    if (paramInt == 0)
    {
      paramView.registObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
      return;
    }
    paramView.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView
 * JD-Core Version:    0.7.0.1
 */