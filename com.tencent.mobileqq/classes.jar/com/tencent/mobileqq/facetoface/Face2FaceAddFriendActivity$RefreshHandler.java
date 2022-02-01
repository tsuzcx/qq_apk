package com.tencent.mobileqq.facetoface;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.NearFieldTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Face2FaceAddFriendActivity$RefreshHandler
  extends Handler
{
  Face2FaceAddFriendActivity$RefreshHandler(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void a(long paramLong)
  {
    removeMessages(0);
    sendMessageDelayed(obtainMessage(0), paramLong);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      int j = 2;
      Object localObject1;
      switch (i)
      {
      default: 
        return;
      case 18: 
        QQToast.makeText(this.a.app.getApplication(), 2131892104, 0).show(this.a.getTitleBarHeight());
        return;
      case 17: 
        long l = this.a.ay;
        paramMessage = new StringBuilder();
        paramMessage.append(l + 2396794490L);
        paramMessage.append("");
        paramMessage = paramMessage.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Member ");
        ((StringBuilder)localObject1).append(this.a.ay);
        paramMessage = new Face2FaceUserProfile(paramMessage, ((StringBuilder)localObject1).toString(), 1, 1, "");
        localObject1 = this.a;
        ((Face2FaceAddFriendActivity)localObject1).ay += 1;
        Face2FaceAddFriendActivity.e(this.a).a(paramMessage);
        Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(17, 300L);
        return;
      case 16: 
        if (!(paramMessage.obj instanceof Face2FaceUserProfile)) {
          break;
        }
        Face2FaceAddFriendActivity.e(this.a).a((Face2FaceUserProfile)paramMessage.obj);
        return;
      case 15: 
        if (!(paramMessage.obj instanceof Face2FaceUserProfile)) {
          break;
        }
        this.a.az.add((Face2FaceUserProfile)paramMessage.obj);
        return;
      case 14: 
        if (!(paramMessage.obj instanceof Face2FaceUserProfile)) {
          break;
        }
        paramMessage = (Face2FaceUserProfile)paramMessage.obj;
        this.a.a(paramMessage);
        return;
      case 13: 
        paramMessage = this.a.q.iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (Face2FaceUserData)paramMessage.next();
          if ((((Face2FaceUserData)localObject1).e == 1) && (Face2FaceAddFriendActivity.a(this.a, ((Face2FaceUserData)localObject1).f))) {
            Face2FaceAddFriendActivity.a(this.a, ((Face2FaceUserData)localObject1).e);
          } else if ((((Face2FaceUserData)localObject1).e == 2) && (this.a.a(((Face2FaceUserData)localObject1).f))) {
            Face2FaceAddFriendActivity.a(this.a, ((Face2FaceUserData)localObject1).e);
          }
        }
      case 12: 
        this.a.a((Face2FaceGroupProfile)paramMessage.obj);
        return;
      case 11: 
        Face2FaceAddFriendActivity.a(this.a, paramMessage.arg1);
        return;
      case 10: 
        Face2FaceAddFriendActivity.a(this.a, (Face2FaceUserData)paramMessage.obj);
        return;
      case 9: 
        this.a.f();
        return;
      case 8: 
        this.a.Z.b();
        return;
      case 7: 
        this.a.a();
        return;
      case 6: 
        if (Face2FaceAddFriendActivity.d(this.a)) {
          break;
        }
        paramMessage = this.a.getResources().getString(2131889123);
        QQToast.makeText(this.a, 0, paramMessage, 0).show(this.a.getTitleBarHeight());
        return;
      case 5: 
        if (this.a.ah == null) {
          break;
        }
        this.a.ah.a(this.a.app.getCurrentAccountUin(), true);
        sendMessageDelayed(obtainMessage(5), Face2FaceAddFriendActivity.x);
        if (!QLog.isColorLevel()) {
          break;
        }
        paramMessage = Face2FaceAddFriendActivity.a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("FTF_MSG_SEND_HEARTBEAT=");
        ((StringBuilder)localObject1).append(this.a.app.getCurrentAccountUin());
        QLog.d(paramMessage, 2, ((StringBuilder)localObject1).toString());
        return;
      case 4: 
        int m = paramMessage.arg1;
        int n = paramMessage.arg2;
        Object localObject2 = paramMessage.getData();
        localObject1 = Boolean.valueOf(((Bundle)localObject2).getBoolean("key_data _ispush"));
        boolean bool3 = ((Bundle)localObject2).getBoolean("key_data _hasfriend");
        int k = this.a.p.size();
        i = k;
        if (k >= 10) {
          i = 10;
        }
        if (this.a.q.contains(paramMessage.obj))
        {
          if (QLog.isColorLevel()) {
            QLog.d(Face2FaceAddFriendActivity.a, 2, "push的数据是显示列表中已有数据");
          }
          return;
        }
        if (m >= i) {
          break;
        }
        if (n == 1)
        {
          paramMessage = (NearbyUser)paramMessage.obj;
          if (paramMessage.a) {
            j = 2;
          } else {
            j = 1;
          }
          if (this.a.k == i - 1) {
            bool1 = true;
          }
          if (((Boolean)localObject1).booleanValue())
          {
            this.a.Z.c();
            bool1 = true;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = Face2FaceAddFriendActivity.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("show next isPush=");
            localStringBuilder.append(localObject1);
            localStringBuilder.append("isNeedShake=");
            localStringBuilder.append(bool1);
            localStringBuilder.append("currentFriendIndex=");
            localStringBuilder.append(this.a.k);
            localStringBuilder.append("count=");
            localStringBuilder.append(i);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          this.a.Z.a(paramMessage, ((Boolean)localObject1).booleanValue(), j, bool3, bool1);
          if (this.a.Y.containsKey(paramMessage.f))
          {
            this.a.Y.remove(paramMessage.f);
            this.a.Y.put(paramMessage.f, Integer.valueOf(j));
          }
          else
          {
            this.a.Y.put(paramMessage.f, Integer.valueOf(j));
          }
        }
        else if (n == 2)
        {
          paramMessage = (Face2FaceUserData)paramMessage.obj;
          if (this.a.e == 0 ? this.a.a(paramMessage.f) : (this.a.e != 1) || (((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.a.f, paramMessage.f) == null)) {
            j = 1;
          }
          bool1 = bool2;
          if (this.a.k == i - 1) {
            bool1 = true;
          }
          if (((Boolean)localObject1).booleanValue())
          {
            this.a.Z.c();
            bool1 = true;
          }
          this.a.Z.a(paramMessage, ((Boolean)localObject1).booleanValue(), j, bool3, bool1);
          if (this.a.Y.containsKey(paramMessage.f))
          {
            this.a.Y.remove(paramMessage.f);
            this.a.Y.put(paramMessage.f, Integer.valueOf(j));
          }
          else
          {
            this.a.Y.put(paramMessage.f, Integer.valueOf(j));
          }
        }
        Face2FaceAddFriendActivity.c(this.a);
        return;
      case 3: 
        this.a.Z.a(1, false);
        return;
      case 2: 
        Face2FaceAddFriendActivity.a(this.a, (String)paramMessage.obj, paramMessage.arg1);
        return;
      }
    }
    else
    {
      this.a.i.invalidate();
      a(20L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.RefreshHandler
 * JD-Core Version:    0.7.0.1
 */