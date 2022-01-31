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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

public class Face2FaceTroopDetailView
  extends Face2FaceDetailBaseView
  implements View.OnClickListener
{
  protected Button a;
  protected ImageView a;
  protected TextView a;
  public Face2FaceUserData a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363844);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131364606);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363667));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131364607));
    this.c = ((TextView)super.findViewById(2131364608));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364609));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131364604);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(AIOUtils.a(10.0F, this.e.getResources()), AIOUtils.a(15.0F, this.e.getResources()) + ImmersiveUtils.a(this.e.getContext()), AIOUtils.a(10.0F, this.e.getResources()), AIOUtils.a(15.0F, this.e.getResources()));
    }
    this.e.setOnClickListener(this);
    super.setOnClickListener(this);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onJoinTroopSucc, ret=").append(paramInt).append(",errInfo=").append(paramString1).append(",troopUin=").append(paramString2).append(",mUserData.nearbyUin=");
      if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData.e;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData instanceof Face2FaceGroupProfile)) && (paramString2 != null) && (paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData.e)))
    {
      if (paramInt != 0) {
        break label163;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131437906);
      if (!paramBoolean) {
        QQToast.a(super.getContext(), 2, "加群成功", 1).a();
      }
      super.c();
    }
    label163:
    do
    {
      return;
      str = null;
      break;
      if (paramInt == -5)
      {
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a((Face2FaceGroupProfile)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData);
        super.c();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = "加群失败";
    }
    QQToast.a(super.getContext(), 1, paramString2, 1).a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      super.c();
    }
    while ((paramView != this.jdField_a_of_type_AndroidWidgetButton) || (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext == null) || (!(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData instanceof Face2FaceGroupProfile))) {
      return;
    }
    paramView = (Face2FaceGroupProfile)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData;
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a(paramView, 1);
    ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, paramView.e, this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a().getCurrentAccountUin(), "", "");
  }
  
  public void setBindData(Face2FaceUserData paramFace2FaceUserData, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData = paramFace2FaceUserData;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a();
    if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile))
    {
      localObject2 = (Face2FaceGroupProfile)paramFace2FaceUserData;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a().a(paramFace2FaceUserData.e, (byte)3, false, false);
      paramFace2FaceUserData = (Face2FaceUserData)localObject1;
      if (localObject1 == null) {
        paramFace2FaceUserData = ImageUtil.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramFace2FaceUserData));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((Face2FaceGroupProfile)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((Face2FaceGroupProfile)localObject2).e + ")");
      localObject1 = ((Face2FaceGroupProfile)localObject2).c;
      paramFace2FaceUserData = (Face2FaceUserData)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramFace2FaceUserData = ((Face2FaceGroupProfile)localObject2).b;
      }
      paramFace2FaceUserData = localQQAppInterface.getApplication().getString(2131437909, new Object[] { paramFace2FaceUserData });
      this.c.setText(paramFace2FaceUserData);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a(((Face2FaceGroupProfile)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131437906);
      }
    }
    while (!(paramFace2FaceUserData instanceof Face2FaceUserProfile)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131437908);
      }
    }
    Object localObject2 = localQQAppInterface.a(paramFace2FaceUserData.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ImageUtil.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (Face2FaceUserProfile)paramFace2FaceUserData;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((Face2FaceUserProfile)localObject1).a);
    paramFace2FaceUserData = ((FriendsManager)localQQAppInterface.getManager(50)).c(paramFace2FaceUserData.e);
    if ((paramFace2FaceUserData != null) && (!TextUtils.isEmpty(paramFace2FaceUserData.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramFace2FaceUserData.remark + ")");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131437907);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838487);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838499);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */