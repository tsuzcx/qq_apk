package com.tencent.mobileqq.qqexpand.manager;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExtendFriendSearchHistoryManager
  implements Handler.Callback
{
  private static final Object e = new Object();
  WeakReference<BaseQQAppInterface> a;
  WeakReference<ExtendFriendSearchHistoryManager.HistoryTagChangeListener> b;
  List<String> c = new ArrayList();
  private int d;
  private boolean f;
  private MqqWeakReferenceHandler g = new MqqWeakReferenceHandler(ThreadManager.getFileThreadLooper(), this);
  
  public ExtendFriendSearchHistoryManager(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    this.a = new WeakReference(paramBaseQQAppInterface);
    this.d = paramInt;
    ThreadManager.postImmediately(new ExtendFriendSearchHistoryManager.1(this), null, true);
  }
  
  private void c()
  {
    ??? = (BaseQQAppInterface)this.a.get();
    if (??? == null) {
      return;
    }
    int i = 0;
    Object localObject4 = FileUtils.readObject(String.format("%s_%s_%s", new Object[] { "extend_frd_search_history", Integer.valueOf(this.d), ((BaseQQAppInterface)???).getCurrentAccountUin() }));
    if (this.f) {
      return;
    }
    Object localObject2 = null;
    ??? = localObject2;
    if (localObject4 != null)
    {
      ??? = localObject2;
      if ((localObject4 instanceof List)) {
        ??? = (List)localObject4;
      }
    }
    localObject2 = ???;
    if (??? == null) {
      localObject2 = new ArrayList();
    }
    synchronized (e)
    {
      if (!this.f)
      {
        this.c.addAll((Collection)localObject2);
        while (this.c.size() > 10) {
          this.c.remove(this.c.size() - 1);
        }
        this.f = true;
        i = 1;
      }
      if (i != 0)
      {
        ??? = this.b;
        if ((??? != null) && (((WeakReference)???).get() != null)) {
          ((ExtendFriendSearchHistoryManager.HistoryTagChangeListener)this.b.get()).dh_();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private void d()
  {
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)this.a.get();
    if (localBaseQQAppInterface == null) {
      return;
    }
    FileUtils.writeObject(String.format("%s_%s_%s", new Object[] { "extend_frd_search_history", Integer.valueOf(this.d), localBaseQQAppInterface.getCurrentAccountUin() }), this.c);
  }
  
  public List<String> a()
  {
    return this.c;
  }
  
  public void a(ExtendFriendSearchHistoryManager.HistoryTagChangeListener paramHistoryTagChangeListener)
  {
    if (paramHistoryTagChangeListener != null)
    {
      this.b = new WeakReference(paramHistoryTagChangeListener);
      return;
    }
    this.b = null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!this.f) {
      c();
    }
    synchronized (e)
    {
      if (this.c.contains(paramString)) {
        this.c.remove(paramString);
      }
      this.c.add(0, paramString);
      if (this.c.size() > 10) {
        this.c.remove(this.c.size() - 1);
      }
      paramString = this.b;
      if ((paramString != null) && (paramString.get() != null)) {
        ((ExtendFriendSearchHistoryManager.HistoryTagChangeListener)this.b.get()).dh_();
      }
      if (!this.g.hasMessages(0)) {
        this.g.sendEmptyMessageDelayed(0, 300L);
      }
      return;
    }
  }
  
  public void b()
  {
    synchronized (e)
    {
      this.c.clear();
      this.f = true;
      ??? = this.b;
      if ((??? != null) && (((WeakReference)???).get() != null)) {
        ((ExtendFriendSearchHistoryManager.HistoryTagChangeListener)this.b.get()).dh_();
      }
      if (!this.g.hasMessages(0)) {
        this.g.sendEmptyMessageDelayed(0, 300L);
      }
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager
 * JD-Core Version:    0.7.0.1
 */