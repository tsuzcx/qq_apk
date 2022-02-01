package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

public class Face2FaceTroopDetailView
  extends Face2FaceDetailBaseView
  implements View.OnClickListener
{
  protected Face2FaceUserData o;
  protected ImageView p;
  protected TextView q;
  protected TextView r;
  protected TextView s;
  protected Button t;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.a = super.findViewById(2131447939);
    this.b = super.findViewById(2131446522);
    this.q = ((TextView)super.findViewById(2131448053));
    this.r = ((TextView)super.findViewById(2131448117));
    this.s = ((TextView)super.findViewById(2131448071));
    this.t = ((Button)super.findViewById(2131427824));
    this.p = ((ImageView)this.a);
    this.f = super.findViewById(2131444743);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.f.setPadding(AIOUtils.b(10.0F, this.f.getResources()), AIOUtils.b(15.0F, this.f.getResources()) + ImmersiveUtils.getStatusBarHeight(this.f.getContext()), AIOUtils.b(10.0F, this.f.getResources()), AIOUtils.b(15.0F, this.f.getResources()));
    }
    this.f.setOnClickListener(this);
    super.setOnClickListener(this);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onJoinTroopSucc, ret=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",errInfo=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",troopUin=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",mUserData.nearbyUin=");
      localObject = this.o;
      if (localObject != null) {
        localObject = ((Face2FaceUserData)localObject).f;
      } else {
        localObject = null;
      }
      localStringBuilder.append((String)localObject);
      QLog.d("Face2FaceTroopDetailView", 2, localStringBuilder.toString());
    }
    if (this.m)
    {
      localObject = this.o;
      if (((localObject instanceof Face2FaceGroupProfile)) && (paramString2 != null) && (paramString2.equals(((Face2FaceUserData)localObject).f)))
      {
        if (paramInt == 0)
        {
          setBtnEnabled(false);
          this.t.setText(2131889157);
          if (!paramBoolean) {
            QQToast.makeText(super.getContext(), 2, HardCodeUtil.a(2131902307), 1).show();
          }
          super.c();
          return;
        }
        if (paramInt == -5)
        {
          this.n.a((Face2FaceGroupProfile)this.o);
          super.c();
        }
        if (!paramBoolean)
        {
          paramString2 = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramString2 = HardCodeUtil.a(2131902324);
          }
          QQToast.makeText(super.getContext(), 1, paramString2, 1).show();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.f)
    {
      super.c();
    }
    else if ((paramView == this.t) && (this.n != null))
    {
      Object localObject = this.o;
      if ((localObject instanceof Face2FaceGroupProfile))
      {
        localObject = (Face2FaceGroupProfile)localObject;
        this.n.a((Face2FaceGroupProfile)localObject, 1);
        ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, ((Face2FaceGroupProfile)localObject).f, this.n.a().getCurrentAccountUin(), "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setBindData(Face2FaceUserData paramFace2FaceUserData, View.OnClickListener paramOnClickListener)
  {
    this.o = paramFace2FaceUserData;
    QQAppInterface localQQAppInterface = this.n.a();
    Object localObject2;
    Object localObject1;
    if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile))
    {
      localObject2 = (Face2FaceGroupProfile)paramFace2FaceUserData;
      localObject1 = this.n.a().getTroopFaceBitmap(paramFace2FaceUserData.f, (byte)3, false, false);
      paramFace2FaceUserData = (Face2FaceUserData)localObject1;
      if (localObject1 == null) {
        paramFace2FaceUserData = ImageUtil.g();
      }
      this.p.setBackgroundDrawable(new BitmapDrawable(paramFace2FaceUserData));
      this.q.setText(((Face2FaceGroupProfile)localObject2).a);
      paramFace2FaceUserData = this.r;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(((Face2FaceGroupProfile)localObject2).f);
      ((StringBuilder)localObject1).append(")");
      paramFace2FaceUserData.setText(((StringBuilder)localObject1).toString());
      localObject1 = ((Face2FaceGroupProfile)localObject2).c;
      paramFace2FaceUserData = (Face2FaceUserData)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramFace2FaceUserData = ((Face2FaceGroupProfile)localObject2).b;
      }
      paramFace2FaceUserData = localQQAppInterface.getApplication().getString(2131889165, new Object[] { paramFace2FaceUserData });
      this.s.setText(paramFace2FaceUserData);
      this.s.setVisibility(0);
      this.r.setVisibility(0);
      if (this.n.a(((Face2FaceGroupProfile)localObject2).f))
      {
        setBtnEnabled(false);
        this.t.setText(2131889157);
      }
      else
      {
        setBtnEnabled(true);
        this.t.setText(2131889156);
      }
    }
    else if ((paramFace2FaceUserData instanceof Face2FaceUserProfile))
    {
      localObject2 = localQQAppInterface.getFaceBitmap(paramFace2FaceUserData.f, (byte)3, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ImageUtil.k();
      }
      this.p.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
      localObject1 = (Face2FaceUserProfile)paramFace2FaceUserData;
      this.q.setText(((Face2FaceUserProfile)localObject1).a);
      paramFace2FaceUserData = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramFace2FaceUserData.f);
      if ((paramFace2FaceUserData != null) && (!TextUtils.isEmpty(paramFace2FaceUserData.remark)))
      {
        localObject1 = this.r;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(paramFace2FaceUserData.remark);
        ((StringBuilder)localObject2).append(")");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.r.setVisibility(0);
      }
      else
      {
        this.r.setVisibility(8);
      }
      this.s.setVisibility(8);
      setBtnEnabled(false);
      this.t.setText(2131889158);
    }
    this.p.setOnClickListener(paramOnClickListener);
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.t.setBackgroundResource(2130839460);
      this.t.setOnClickListener(this);
      return;
    }
    this.t.setBackgroundResource(2130839476);
    this.t.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */