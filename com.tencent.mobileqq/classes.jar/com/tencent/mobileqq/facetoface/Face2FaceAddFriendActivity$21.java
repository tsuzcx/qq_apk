package com.tencent.mobileqq.facetoface;

import android.content.Context;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Face2FaceAddFriendActivity$21
  implements Face2FaceDetailBaseView.IFace2faceContext
{
  Face2FaceAddFriendActivity$21(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a(Face2FaceGroupProfile paramFace2FaceGroupProfile)
  {
    if (this.a.q.size() == this.a.p.size())
    {
      this.a.a(paramFace2FaceGroupProfile);
      return;
    }
    Face2FaceAddFriendActivity.a(this.a).obtainMessage().obj = paramFace2FaceGroupProfile;
    Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(12, 5000L);
  }
  
  public boolean a(Face2FaceGroupProfile paramFace2FaceGroupProfile, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.b, 2, "joinTroop, NetworkUtil.isNetSupport==false");
      }
      QQToast.makeText(this.a.app.getApplication(), 2131892104, 0).show(this.a.getTitleBarHeight());
      return false;
    }
    Object localObject1 = (NearFieldTroopHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
    if (localObject1 != null)
    {
      Object localObject2 = this.a;
      ((Face2FaceAddFriendActivity)localObject2).aG = new QQProgressDialog((Context)localObject2);
      this.a.aG.a(HardCodeUtil.a(2131902318));
      this.a.aG.setCancelable(false);
      this.a.aG.show();
      try
      {
        long l1 = Long.valueOf(paramFace2FaceGroupProfile.f).longValue();
        long l2 = Long.valueOf(paramFace2FaceGroupProfile.b).longValue();
        if (QLog.isColorLevel())
        {
          localObject2 = Face2FaceAddFriendActivity.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("joinTroop, troopCode=");
          localStringBuilder.append(l1);
          localStringBuilder.append(", ownerUin=");
          localStringBuilder.append(l2);
          localStringBuilder.append(", distance=");
          localStringBuilder.append(paramFace2FaceGroupProfile.d);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        ((NearFieldTroopHandler)localObject1).a(l1, l2, paramFace2FaceGroupProfile.d, paramInt);
        return true;
      }
      catch (Exception paramFace2FaceGroupProfile)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = Face2FaceAddFriendActivity.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("joinTroop:");
          ((StringBuilder)localObject2).append(paramFace2FaceGroupProfile.toString());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public void b()
  {
    this.a.h();
  }
  
  public void c() {}
  
  public void d()
  {
    if (this.a.e == 1)
    {
      Face2FaceAddFriendActivity localFace2FaceAddFriendActivity = this.a;
      localFace2FaceAddFriendActivity.a(localFace2FaceAddFriendActivity.J.o);
    }
  }
  
  public void e()
  {
    this.a.g();
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.a, 2, "afterDetailViewHide 详情页返回");
    }
    Face2FaceAddFriendActivity localFace2FaceAddFriendActivity = this.a;
    localFace2FaceAddFriendActivity.ao = "";
    Face2FaceAddFriendActivity.a(localFace2FaceAddFriendActivity).sendEmptyMessageDelayed(13, this.a.k());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.21
 * JD-Core Version:    0.7.0.1
 */