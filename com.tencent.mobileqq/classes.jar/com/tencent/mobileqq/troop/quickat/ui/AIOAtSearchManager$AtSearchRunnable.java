package com.tencent.mobileqq.troop.quickat.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ATroopMember;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIOAtSearchManager$AtSearchRunnable
  implements Runnable
{
  public volatile boolean a = false;
  private final SessionInfo b;
  private String c;
  private boolean d;
  private Handler e;
  private List<TroopMemberInfo> f;
  private WeakReference<QQAppInterface> g;
  private boolean h = false;
  
  public AIOAtSearchManager$AtSearchRunnable(String paramString, List<TroopMemberInfo> paramList, Handler paramHandler, QQAppInterface paramQQAppInterface, boolean paramBoolean1, SessionInfo paramSessionInfo, boolean paramBoolean2)
  {
    this.c = paramString;
    this.f = paramList;
    this.e = paramHandler;
    this.h = paramBoolean1;
    this.g = new WeakReference(paramQQAppInterface);
    this.b = paramSessionInfo;
    this.d = paramBoolean2;
  }
  
  private ArrayList<ChatHistoryTroopMemberFragment.ATroopMember> a(List<TroopMemberInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
      localArrayList.add(AtUtil.a((QQAppInterface)this.g.get(), localTroopMemberInfo));
    }
    return localArrayList;
  }
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("taa AtSearchRunnable start: ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.e("AIOAtSearchManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a) {
      return;
    }
    if (this.g.get() == null) {
      return;
    }
    Object localObject = new SearchTask(a(this.f)).a((QQAppInterface)this.g.get(), this.c, this.h, this.b, this.d);
    if (this.a) {
      return;
    }
    Message localMessage = this.e.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = localObject;
    this.e.sendMessage(localMessage);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("taa AtSearchRunnable end: ");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.e("AIOAtSearchManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager.AtSearchRunnable
 * JD-Core Version:    0.7.0.1
 */