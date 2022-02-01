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
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected Face2FaceUserData a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131379202);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131378024);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379316));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379377));
    this.c = ((TextView)super.findViewById(2131379334));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362243));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131376502);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(AIOUtils.b(10.0F, this.e.getResources()), AIOUtils.b(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), AIOUtils.b(10.0F, this.e.getResources()), AIOUtils.b(15.0F, this.e.getResources()));
    }
    this.e.setOnClickListener(this);
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData;
      if (localObject != null) {
        localObject = ((Face2FaceUserData)localObject).e;
      } else {
        localObject = null;
      }
      localStringBuilder.append((String)localObject);
      QLog.d("Face2FaceTroopDetailView", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData;
      if (((localObject instanceof Face2FaceGroupProfile)) && (paramString2 != null) && (paramString2.equals(((Face2FaceUserData)localObject).e)))
      {
        if (paramInt == 0)
        {
          setBtnEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131692171);
          if (!paramBoolean) {
            QQToast.a(super.getContext(), 2, HardCodeUtil.a(2131704394), 1).a();
          }
          super.c();
          return;
        }
        if (paramInt == -5)
        {
          this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a((Face2FaceGroupProfile)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData);
          super.c();
        }
        if (!paramBoolean)
        {
          paramString2 = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramString2 = HardCodeUtil.a(2131704411);
          }
          QQToast.a(super.getContext(), 1, paramString2, 1).a();
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e)
    {
      super.c();
    }
    else if ((paramView == this.jdField_a_of_type_AndroidWidgetButton) && (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData;
      if ((localObject instanceof Face2FaceGroupProfile))
      {
        localObject = (Face2FaceGroupProfile)localObject;
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a((Face2FaceGroupProfile)localObject, 1);
        ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, ((Face2FaceGroupProfile)localObject).e, this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a().getCurrentAccountUin(), "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setBindData(Face2FaceUserData paramFace2FaceUserData, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData = paramFace2FaceUserData;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a();
    Object localObject2;
    Object localObject1;
    if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile))
    {
      localObject2 = (Face2FaceGroupProfile)paramFace2FaceUserData;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a().getTroopFaceBitmap(paramFace2FaceUserData.e, (byte)3, false, false);
      paramFace2FaceUserData = (Face2FaceUserData)localObject1;
      if (localObject1 == null) {
        paramFace2FaceUserData = ImageUtil.d();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramFace2FaceUserData));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((Face2FaceGroupProfile)localObject2).a);
      paramFace2FaceUserData = this.jdField_b_of_type_AndroidWidgetTextView;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(((Face2FaceGroupProfile)localObject2).e);
      ((StringBuilder)localObject1).append(")");
      paramFace2FaceUserData.setText(((StringBuilder)localObject1).toString());
      localObject1 = ((Face2FaceGroupProfile)localObject2).c;
      paramFace2FaceUserData = (Face2FaceUserData)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramFace2FaceUserData = ((Face2FaceGroupProfile)localObject2).b;
      }
      paramFace2FaceUserData = localQQAppInterface.getApplication().getString(2131692179, new Object[] { paramFace2FaceUserData });
      this.c.setText(paramFace2FaceUserData);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a(((Face2FaceGroupProfile)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692171);
      }
      else
      {
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692170);
      }
    }
    else if ((paramFace2FaceUserData instanceof Face2FaceUserProfile))
    {
      localObject2 = localQQAppInterface.getFaceBitmap(paramFace2FaceUserData.e, (byte)3, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ImageUtil.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
      localObject1 = (Face2FaceUserProfile)paramFace2FaceUserData;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((Face2FaceUserProfile)localObject1).a);
      paramFace2FaceUserData = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramFace2FaceUserData.e);
      if ((paramFace2FaceUserData != null) && (!TextUtils.isEmpty(paramFace2FaceUserData.remark)))
      {
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(paramFace2FaceUserData.remark);
        ((StringBuilder)localObject2).append(")");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692172);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839280);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839296);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */