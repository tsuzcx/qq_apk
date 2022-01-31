package com.tencent.mobileqq.flashchat;

import ajya;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import apyt;
import apyw;
import apyz;
import apza;
import apzd;
import apze;
import bfnk;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class FlashChatTextEffectView
  extends RecyclerView
  implements Handler.Callback
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 10000, 12000, 7000, 8000, 8000 };
  int jdField_a_of_type_Int;
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  apyt jdField_a_of_type_Apyt = new apyz(this);
  apza jdField_a_of_type_Apza;
  apze jdField_a_of_type_Apze;
  WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<apyw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<Integer, Long> a;
  public MqqHandler a;
  
  public FlashChatTextEffectView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public FlashChatTextEffectView(Context paramContext, BaseChatPie paramBaseChatPie, apze paramapze, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Apze = paramapze;
    this.jdField_a_of_type_Int = paramInt;
    setClipToPadding(false);
    a();
    b();
  }
  
  private static void b(apzd paramapzd)
  {
    if ((paramapzd != null) && (paramapzd.a != null))
    {
      String str = paramapzd.a.ark_app_message.appName;
      ArkAppCenter.a().post(str, new FlashChatTextEffectView.2(paramapzd));
    }
  }
  
  private static void c(apzd paramapzd)
  {
    if ((paramapzd != null) && (paramapzd.a != null))
    {
      String str = paramapzd.a.ark_app_message.appName;
      ArkAppCenter.a().post(str, new FlashChatTextEffectView.3(paramapzd));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Apza.getItemCount();
  }
  
  public apyw a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (apyw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public FlashChatItem a(int paramInt)
  {
    try
    {
      FlashChatItem localFlashChatItem = ((apyw)this.jdField_a_of_type_Apza.a.get(paramInt)).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem;
      return localFlashChatItem;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  @TargetApi(9)
  public void a()
  {
    setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(getContext(), 3);
    setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    this.jdField_a_of_type_MqqOsMqqHandler = new bfnk(this);
    apze localapze = this.jdField_a_of_type_Apze;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (BaseChatPie localBaseChatPie = null;; localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      this.jdField_a_of_type_Apza = new apza(localapze, localBaseChatPie, this.jdField_a_of_type_Int, this.jdField_a_of_type_MqqOsMqqHandler);
      setAdapter(this.jdField_a_of_type_Apza);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Apza.a != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_Apza.a.size())
      {
        apyw localapyw = (apyw)this.jdField_a_of_type_Apza.a.get(i);
        if (i == paramInt) {}
        for (localapyw.jdField_a_of_type_Boolean = true;; localapyw.jdField_a_of_type_Boolean = false)
        {
          i += 1;
          break;
        }
      }
    }
    this.jdField_a_of_type_Apza.notifyDataSetChanged();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      QLog.w("FlashChatTextEffectView", 1, "BaseChatPie released");
      return;
    }
    Object localObject = ((FlashChatManager)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.getManager(217)).a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FlashChatItem localFlashChatItem = (FlashChatItem)((Iterator)localObject).next();
      apyw localapyw = new apyw();
      localapyw.jdField_b_of_type_Int = localFlashChatItem.id;
      if (localFlashChatItem.id != -100000)
      {
        localapyw.jdField_b_of_type_JavaLangString = ajya.a(2131704625);
        localapyw.jdField_a_of_type_JavaLangString = localFlashChatItem.name;
        localapyw.jdField_a_of_type_Boolean = false;
        localapyw.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = localFlashChatItem;
        this.jdField_a_of_type_JavaUtilArrayList.add(localapyw);
      }
    }
    this.jdField_a_of_type_Apza.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Apza.notifyDataSetChanged();
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
        if ((localObject instanceof apzd)) {
          c((apzd)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Apza != null) {
      this.jdField_a_of_type_Apza.a();
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Apza != null) {
      this.jdField_a_of_type_Apza.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Apza != null) {
      this.jdField_a_of_type_Apza.c();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Apza != null) {
      this.jdField_a_of_type_Apza.d();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Apza != null) {
      i();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof apzd)) {}
    for (Object localObject = (apzd)paramMessage.obj;; localObject = null)
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
            b((apzd)localObject);
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
        if ((localObject instanceof apzd))
        {
          localObject = (apzd)localObject;
          this.jdField_a_of_type_Apza.a((apzd)localObject, ((apzd)localObject).getPosition());
        }
      }
      i += 1;
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {}
    for (paramView = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a; paramInt == 0; paramView = BaseApplicationImpl.getApplication().getRuntime())
    {
      paramView.registObserver(this.jdField_a_of_type_Apyt);
      return;
    }
    paramView.unRegistObserver(this.jdField_a_of_type_Apyt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView
 * JD-Core Version:    0.7.0.1
 */