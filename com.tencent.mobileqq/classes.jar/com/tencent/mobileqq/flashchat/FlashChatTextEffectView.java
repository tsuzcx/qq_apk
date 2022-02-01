package com.tencent.mobileqq.flashchat;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import anvx;
import auly;
import aumb;
import aume;
import aumf;
import aumi;
import aumj;
import bkyc;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.hiboom.RichTextPanelRecyclerView;
import com.tencent.qphone.base.util.QLog;
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
  auly jdField_a_of_type_Auly = new aume(this);
  aumf jdField_a_of_type_Aumf;
  aumj jdField_a_of_type_Aumj;
  WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<aumb> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<Integer, Long> a;
  public MqqHandler a;
  
  public FlashChatTextEffectView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public FlashChatTextEffectView(Context paramContext, BaseChatPie paramBaseChatPie, aumj paramaumj, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Aumj = paramaumj;
    this.jdField_a_of_type_Int = paramInt;
    setClipToPadding(false);
    a();
    b();
  }
  
  private static void b(aumi paramaumi)
  {
    if ((paramaumi != null) && (paramaumi.a != null))
    {
      String str = paramaumi.a.ark_app_message.appName;
      ArkAppCenter.a().post(str, new FlashChatTextEffectView.2(paramaumi));
    }
  }
  
  private static void c(aumi paramaumi)
  {
    if ((paramaumi != null) && (paramaumi.a != null))
    {
      String str = paramaumi.a.ark_app_message.appName;
      ArkAppCenter.a().post(str, new FlashChatTextEffectView.3(paramaumi));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Aumf.getItemCount();
  }
  
  public aumb a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (aumb)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public FlashChatItem a(int paramInt)
  {
    try
    {
      FlashChatItem localFlashChatItem = ((aumb)this.jdField_a_of_type_Aumf.a.get(paramInt)).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem;
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
    this.jdField_a_of_type_MqqOsMqqHandler = new bkyc(this);
    aumj localaumj = this.jdField_a_of_type_Aumj;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (BaseChatPie localBaseChatPie = null;; localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      this.jdField_a_of_type_Aumf = new aumf(localaumj, localBaseChatPie, this.jdField_a_of_type_Int, this.jdField_a_of_type_MqqOsMqqHandler);
      setAdapter(this.jdField_a_of_type_Aumf);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aumf.a != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_Aumf.a.size())
      {
        aumb localaumb = (aumb)this.jdField_a_of_type_Aumf.a.get(i);
        if (i == paramInt) {}
        for (localaumb.jdField_a_of_type_Boolean = true;; localaumb.jdField_a_of_type_Boolean = false)
        {
          i += 1;
          break;
        }
      }
    }
    this.jdField_a_of_type_Aumf.notifyDataSetChanged();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      QLog.w("FlashChatTextEffectView", 1, "BaseChatPie released");
      return;
    }
    Object localObject = ((FlashChatManager)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FlashChatItem localFlashChatItem = (FlashChatItem)((Iterator)localObject).next();
      aumb localaumb = new aumb();
      localaumb.jdField_b_of_type_Int = localFlashChatItem.id;
      if (localFlashChatItem.id != -100000)
      {
        localaumb.jdField_b_of_type_JavaLangString = anvx.a(2131704093);
        localaumb.jdField_a_of_type_JavaLangString = localFlashChatItem.name;
        localaumb.jdField_a_of_type_Boolean = false;
        localaumb.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = localFlashChatItem;
        this.jdField_a_of_type_JavaUtilArrayList.add(localaumb);
      }
    }
    this.jdField_a_of_type_Aumf.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Aumf.notifyDataSetChanged();
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
        if ((localObject instanceof aumi)) {
          c((aumi)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aumf != null) {
      this.jdField_a_of_type_Aumf.a();
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aumf != null) {
      this.jdField_a_of_type_Aumf.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Aumf != null) {
      this.jdField_a_of_type_Aumf.c();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Aumf != null) {
      this.jdField_a_of_type_Aumf.d();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Aumf != null) {
      i();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof aumi)) {}
    for (Object localObject = (aumi)paramMessage.obj;; localObject = null)
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
            b((aumi)localObject);
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
        if ((localObject instanceof aumi))
        {
          localObject = (aumi)localObject;
          this.jdField_a_of_type_Aumf.a((aumi)localObject, ((aumi)localObject).getPosition());
        }
      }
      i += 1;
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {}
    for (paramView = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app; paramInt == 0; paramView = BaseApplicationImpl.getApplication().getRuntime())
    {
      paramView.registObserver(this.jdField_a_of_type_Auly);
      return;
    }
    paramView.unRegistObserver(this.jdField_a_of_type_Auly);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView
 * JD-Core Version:    0.7.0.1
 */