package com.tencent.mobileqq.flashchat;

import alpo;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import arrv;
import arry;
import arsb;
import arsc;
import arsf;
import arsg;
import bhoe;
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
  arrv jdField_a_of_type_Arrv = new arsb(this);
  arsc jdField_a_of_type_Arsc;
  arsg jdField_a_of_type_Arsg;
  WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<arry> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<Integer, Long> a;
  public MqqHandler a;
  
  public FlashChatTextEffectView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public FlashChatTextEffectView(Context paramContext, BaseChatPie paramBaseChatPie, arsg paramarsg, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Arsg = paramarsg;
    this.jdField_a_of_type_Int = paramInt;
    setClipToPadding(false);
    a();
    b();
  }
  
  private static void b(arsf paramarsf)
  {
    if ((paramarsf != null) && (paramarsf.a != null))
    {
      String str = paramarsf.a.ark_app_message.appName;
      ArkAppCenter.a().post(str, new FlashChatTextEffectView.2(paramarsf));
    }
  }
  
  private static void c(arsf paramarsf)
  {
    if ((paramarsf != null) && (paramarsf.a != null))
    {
      String str = paramarsf.a.ark_app_message.appName;
      ArkAppCenter.a().post(str, new FlashChatTextEffectView.3(paramarsf));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Arsc.getItemCount();
  }
  
  public arry a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (arry)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public FlashChatItem a(int paramInt)
  {
    try
    {
      FlashChatItem localFlashChatItem = ((arry)this.jdField_a_of_type_Arsc.a.get(paramInt)).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem;
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
    this.jdField_a_of_type_MqqOsMqqHandler = new bhoe(this);
    arsg localarsg = this.jdField_a_of_type_Arsg;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (BaseChatPie localBaseChatPie = null;; localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      this.jdField_a_of_type_Arsc = new arsc(localarsg, localBaseChatPie, this.jdField_a_of_type_Int, this.jdField_a_of_type_MqqOsMqqHandler);
      setAdapter(this.jdField_a_of_type_Arsc);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Arsc.a != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_Arsc.a.size())
      {
        arry localarry = (arry)this.jdField_a_of_type_Arsc.a.get(i);
        if (i == paramInt) {}
        for (localarry.jdField_a_of_type_Boolean = true;; localarry.jdField_a_of_type_Boolean = false)
        {
          i += 1;
          break;
        }
      }
    }
    this.jdField_a_of_type_Arsc.notifyDataSetChanged();
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
      arry localarry = new arry();
      localarry.jdField_b_of_type_Int = localFlashChatItem.id;
      if (localFlashChatItem.id != -100000)
      {
        localarry.jdField_b_of_type_JavaLangString = alpo.a(2131704997);
        localarry.jdField_a_of_type_JavaLangString = localFlashChatItem.name;
        localarry.jdField_a_of_type_Boolean = false;
        localarry.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = localFlashChatItem;
        this.jdField_a_of_type_JavaUtilArrayList.add(localarry);
      }
    }
    this.jdField_a_of_type_Arsc.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Arsc.notifyDataSetChanged();
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
        if ((localObject instanceof arsf)) {
          c((arsf)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Arsc != null) {
      this.jdField_a_of_type_Arsc.a();
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    setAdapter(null);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Arsc != null) {
      this.jdField_a_of_type_Arsc.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Arsc != null) {
      this.jdField_a_of_type_Arsc.c();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Arsc != null) {
      this.jdField_a_of_type_Arsc.d();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Arsc != null) {
      i();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof arsf)) {}
    for (Object localObject = (arsf)paramMessage.obj;; localObject = null)
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
            b((arsf)localObject);
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
        if ((localObject instanceof arsf))
        {
          localObject = (arsf)localObject;
          this.jdField_a_of_type_Arsc.a((arsf)localObject, ((arsf)localObject).getPosition());
        }
      }
      i += 1;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {}
    for (paramView = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a; paramInt == 0; paramView = BaseApplicationImpl.getApplication().getRuntime())
    {
      paramView.registObserver(this.jdField_a_of_type_Arrv);
      return;
    }
    paramView.unRegistObserver(this.jdField_a_of_type_Arrv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView
 * JD-Core Version:    0.7.0.1
 */