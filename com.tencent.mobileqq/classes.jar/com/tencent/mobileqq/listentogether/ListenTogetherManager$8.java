package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ListenTogetherManager$8
  extends FriendListObserver
{
  ListenTogetherManager$8(ListenTogetherManager paramListenTogetherManager) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateDelFriend isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" object: ");
    ((StringBuilder)localObject).append(paramObject);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      localObject = ListenTogetherUtils.a(2, String.valueOf(paramObject));
      if (ListenTogetherManager.a(this.a).equals(localObject))
      {
        ((ListenTogetherSession)ListenTogetherManager.b(this.a).get(ListenTogetherManager.a(this.a))).p = 3;
        ((ListenTogetherSession)ListenTogetherManager.b(this.a).get(ListenTogetherManager.a(this.a))).q = 3;
        ListenTogetherAIOStatusHelper.b(ListenTogetherManager.j(this.a), String.valueOf(paramObject), false);
        localObject = this.a;
        ((ListenTogetherManager)localObject).a(true, (ListenTogetherSession)ListenTogetherManager.b((ListenTogetherManager)localObject).get(ListenTogetherManager.a(this.a)), 1007);
        this.a.a(2, String.valueOf(paramObject), false);
      }
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    ListenTogetherSession localListenTogetherSession = this.a.e(2, paramString);
    if ((paramBoolean) && (localListenTogetherSession != null) && (localListenTogetherSession.n.equals(paramString)) && (ListenTogetherManager.a(this.a, localListenTogetherSession)))
    {
      QLog.d("ListenTogether.Manager", 1, String.format("onUpdateFriendInfo uin=%s mutual level changed", new Object[] { localListenTogetherSession.n }));
      ListenTogetherManager.b(this.a, localListenTogetherSession);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager.8
 * JD-Core Version:    0.7.0.1
 */