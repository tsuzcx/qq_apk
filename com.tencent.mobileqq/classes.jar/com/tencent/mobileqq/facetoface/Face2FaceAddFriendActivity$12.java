package com.tencent.mobileqq.facetoface;

import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearFieldTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.nearfield_group.nearfield_group.BusiRespHead;

class Face2FaceAddFriendActivity$12
  extends NearFieldTroopObserver
{
  Face2FaceAddFriendActivity$12(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void a(Face2FaceGroupProfile paramFace2FaceGroupProfile)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvTroopPush, from_type=");
      localStringBuilder.append(this.a.e);
      localStringBuilder.append(",groupProfile isNull=");
      boolean bool;
      if (paramFace2FaceGroupProfile == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(",show_type=");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((this.a.e == 0) && (paramFace2FaceGroupProfile != null) && (!this.a.n.contains(paramFace2FaceGroupProfile)))
    {
      this.a.n.add(paramFace2FaceGroupProfile);
      if (this.a.q.size() == this.a.p.size())
      {
        Face2FaceAddFriendActivity.a(this.a, paramFace2FaceGroupProfile);
      }
      else
      {
        localObject = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
        ((Message)localObject).what = 10;
        ((Message)localObject).obj = paramFace2FaceGroupProfile;
        Face2FaceAddFriendActivity.a(this.a).sendEmptyMessageDelayed(10, 5000L);
      }
      paramFace2FaceGroupProfile = this.a;
      paramFace2FaceGroupProfile.H += 1;
    }
  }
  
  public void a(Face2FaceUserProfile paramFace2FaceUserProfile)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvMemberPush, from_type=");
      localStringBuilder.append(this.a.e);
      localStringBuilder.append(",fromTroopUin=");
      localStringBuilder.append(this.a.f);
      localStringBuilder.append(",userProfile isNull=");
      boolean bool;
      if (paramFace2FaceUserProfile == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("total:");
      localStringBuilder.append(this.a.m.size() + 1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramFace2FaceUserProfile == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.a.aF;
    if ((this.a.aF != 0L) && (l2 < 1000L) && (paramFace2FaceUserProfile.g == 0L))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 16;
      ((Message)localObject).obj = paramFace2FaceUserProfile;
      long l3 = 1000L - l2;
      Face2FaceAddFriendActivity.a(this.a).sendMessageDelayed((Message)localObject, l3);
      paramFace2FaceUserProfile.g = l1;
      this.a.aF = (l1 + l3);
      if (QLog.isColorLevel())
      {
        paramFace2FaceUserProfile = Face2FaceAddFriendActivity.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRecvMemberPush, delay=");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(", delayed=");
        ((StringBuilder)localObject).append(l3);
        ((StringBuilder)localObject).append(",mLastToopMemberPushStamp=");
        ((StringBuilder)localObject).append(this.a.aF);
        QLog.d(paramFace2FaceUserProfile, 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (paramFace2FaceUserProfile.g == 0L) {
      this.a.aF = l1;
    }
    if ((this.a.e == 1) && (!this.a.m.contains(paramFace2FaceUserProfile)))
    {
      this.a.m.add(paramFace2FaceUserProfile);
      if ((this.a.am) && (this.a.N != null))
      {
        this.a.M.setText(String.valueOf(this.a.m.size()));
        this.a.N.a(paramFace2FaceUserProfile);
        return;
      }
      Face2FaceAddFriendActivity.a(this.a, paramFace2FaceUserProfile);
      this.a.e();
    }
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = Face2FaceAddFriendActivity.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCloseFace2faceTroop, respHead isNull=");
      boolean bool;
      if (paramBusiRespHead == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBusiRespHead == null) {
      return;
    }
    int i = paramBusiRespHead.int32_reply_code.get();
    int j = paramBusiRespHead.int32_seq.get();
    int k = paramBusiRespHead.int32_version.get();
    paramBusiRespHead = paramBusiRespHead.str_result.get();
    if (QLog.isColorLevel())
    {
      str = Face2FaceAddFriendActivity.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCloseFace2faceTroop, ret=");
      localStringBuilder.append(i);
      localStringBuilder.append(",seqNo=");
      localStringBuilder.append(j);
      localStringBuilder.append(",ver=");
      localStringBuilder.append(k);
      localStringBuilder.append(",errInfo=");
      localStringBuilder.append(paramBusiRespHead);
      localStringBuilder.append(",from_type=");
      localStringBuilder.append(this.a.e);
      localStringBuilder.append(",fromTroopUin=");
      localStringBuilder.append(this.a.f);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, String paramString)
  {
    if ((this.a.aG != null) && (this.a.aG.isShowing()))
    {
      this.a.aG.dismiss();
      this.a.aG = null;
    }
    if (paramBusiRespHead == null)
    {
      this.a.J.a(-1, "", paramString, this.a.isFinishing());
      if (QLog.isColorLevel())
      {
        paramBusiRespHead = Face2FaceAddFriendActivity.b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onJoinTroop, respHead isNull=true, troopCode=");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d(paramBusiRespHead, 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    int i = paramBusiRespHead.int32_reply_code.get();
    int j = paramBusiRespHead.int32_seq.get();
    int k = paramBusiRespHead.int32_version.get();
    Object localObject1 = paramBusiRespHead.str_result.get();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      paramBusiRespHead = Face2FaceAddFriendActivity.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onJoinTroop, ret=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", seqNo=");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",ver=");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(",errInfo=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",troopCode=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(",from_type=");
      ((StringBuilder)localObject2).append(this.a.e);
      ((StringBuilder)localObject2).append(",fromTroopUin=");
      ((StringBuilder)localObject2).append(this.a.f);
      QLog.d(paramBusiRespHead, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.a.e == 0)
    {
      if (i == 0)
      {
        localObject2 = this.a.Z.k.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramBusiRespHead = (Face2FaceFriendBubbleView)((Iterator)localObject2).next();
          if ((paramBusiRespHead != null) && (paramBusiRespHead.getUinType() == 2) && (paramString.equals(paramBusiRespHead.getUin())))
          {
            paramBusiRespHead.setStatusWithAnimation(2);
            paramBusiRespHead = paramBusiRespHead.getBindFriendInfo();
            if ((paramBusiRespHead instanceof Face2FaceGroupProfile))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramBusiRespHead.f);
              localStringBuilder.append("_");
              localStringBuilder.append(((Face2FaceGroupProfile)paramBusiRespHead).b);
              paramBusiRespHead = localStringBuilder.toString();
            }
            else
            {
              paramBusiRespHead = paramString;
            }
            this.a.Z.b(paramBusiRespHead);
            paramBusiRespHead = Face2FaceAddFriendActivity.a(this.a).obtainMessage();
            paramBusiRespHead.what = 11;
            paramBusiRespHead.arg1 = 2;
            Face2FaceAddFriendActivity.a(this.a).sendMessageDelayed(paramBusiRespHead, this.a.k());
          }
        }
        ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "suc_join", 0, 0, paramString, "8.8.17", "", this.a.app.getCurrentAccountUin());
      }
      this.a.J.a(i, (String)localObject1, paramString, this.a.isFinishing());
    }
  }
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, List<Face2FaceGroupProfile> paramList)
  {
    boolean bool2 = false;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = Face2FaceAddFriendActivity.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOpenFace2faceTroop, respHead isNull=");
      if (paramBusiRespHead == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      localStringBuilder.append(", troopList isNull=");
      boolean bool1 = bool2;
      if (paramList == null) {
        bool1 = true;
      }
      localStringBuilder.append(bool1);
      localStringBuilder.append(", troopList.size=");
      localStringBuilder.append(i);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBusiRespHead == null)
    {
      paramBusiRespHead = this.a;
      paramBusiRespHead.u = 2;
      Face2FaceAddFriendActivity.g(paramBusiRespHead);
      if (this.a.e == 1)
      {
        paramBusiRespHead = this.a;
        DialogUtil.a(paramBusiRespHead, 230, paramBusiRespHead.getString(2131917233), HardCodeUtil.a(2131902321), 2131887648, 2131889053, new Face2FaceAddFriendActivity.12.1(this), null).show();
      }
      return;
    }
    int i = paramBusiRespHead.int32_reply_code.get();
    int j = paramBusiRespHead.int32_seq.get();
    int k = paramBusiRespHead.int32_version.get();
    paramBusiRespHead = paramBusiRespHead.str_result.get();
    if (QLog.isColorLevel())
    {
      str = Face2FaceAddFriendActivity.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOpenFace2faceTroop, ret=");
      localStringBuilder.append(i);
      localStringBuilder.append(",seqNo=");
      localStringBuilder.append(j);
      localStringBuilder.append(",ver=");
      localStringBuilder.append(k);
      localStringBuilder.append(",errInfo=");
      localStringBuilder.append(paramBusiRespHead);
      localStringBuilder.append(",from_type=");
      localStringBuilder.append(this.a.e);
      localStringBuilder.append(",fromTroopUin=");
      localStringBuilder.append(this.a.f);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (i == 0)
    {
      paramBusiRespHead = this.a;
      paramBusiRespHead.u = 1;
      if (paramBusiRespHead.e == 0)
      {
        if ((paramList != null) && (paramList.size() > 0))
        {
          paramBusiRespHead = paramList.iterator();
          while (paramBusiRespHead.hasNext())
          {
            paramList = (Face2FaceUserData)paramBusiRespHead.next();
            if (this.a.n.contains(paramList)) {
              break;
            }
            this.a.n.add(paramList);
          }
        }
        paramBusiRespHead = this.a;
        paramBusiRespHead.s = true;
        Face2FaceAddFriendActivity.g(paramBusiRespHead);
      }
    }
    else
    {
      paramBusiRespHead = this.a;
      paramBusiRespHead.u = 2;
      Face2FaceAddFriendActivity.g(paramBusiRespHead);
      if (this.a.e == 1)
      {
        paramBusiRespHead = this.a;
        DialogUtil.a(paramBusiRespHead, 230, paramBusiRespHead.getString(2131917233), HardCodeUtil.a(2131902314), 2131887648, 2131889053, new Face2FaceAddFriendActivity.12.2(this), null).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.12
 * JD-Core Version:    0.7.0.1
 */