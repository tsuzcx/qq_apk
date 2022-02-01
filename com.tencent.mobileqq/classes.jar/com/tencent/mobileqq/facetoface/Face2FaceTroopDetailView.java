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
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131379873);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131378631);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379987));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380048));
    this.c = ((TextView)super.findViewById(2131380005));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362220));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131377022);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(AIOUtils.a(10.0F, this.e.getResources()), AIOUtils.a(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), AIOUtils.a(10.0F, this.e.getResources()), AIOUtils.a(15.0F, this.e.getResources()));
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
        break label166;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692245);
      if (!paramBoolean) {
        QQToast.a(super.getContext(), 2, HardCodeUtil.a(2131704303), 1).a();
      }
      super.c();
    }
    label166:
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
      paramString2 = HardCodeUtil.a(2131704320);
    }
    QQToast.a(super.getContext(), 1, paramString2, 1).a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      super.c();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.jdField_a_of_type_AndroidWidgetButton) && (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext != null) && ((this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData instanceof Face2FaceGroupProfile)))
      {
        Face2FaceGroupProfile localFace2FaceGroupProfile = (Face2FaceGroupProfile)this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData;
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a(localFace2FaceGroupProfile, 1);
        ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, localFace2FaceGroupProfile.e, this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a().getCurrentAccountUin(), "", "");
      }
    }
  }
  
  public void setBindData(Face2FaceUserData paramFace2FaceUserData, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceUserData = paramFace2FaceUserData;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a();
    if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile))
    {
      localObject2 = (Face2FaceGroupProfile)paramFace2FaceUserData;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a().getTroopFaceBitmap(paramFace2FaceUserData.e, (byte)3, false, false);
      paramFace2FaceUserData = (Face2FaceUserData)localObject1;
      if (localObject1 == null) {
        paramFace2FaceUserData = ImageUtil.a();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramFace2FaceUserData));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((Face2FaceGroupProfile)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((Face2FaceGroupProfile)localObject2).e + ")");
      localObject1 = ((Face2FaceGroupProfile)localObject2).c;
      paramFace2FaceUserData = (Face2FaceUserData)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramFace2FaceUserData = ((Face2FaceGroupProfile)localObject2).b;
      }
      paramFace2FaceUserData = localQQAppInterface.getApplication().getString(2131692253, new Object[] { paramFace2FaceUserData });
      this.c.setText(paramFace2FaceUserData);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$IFace2faceContext.a(((Face2FaceGroupProfile)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692245);
      }
    }
    while (!(paramFace2FaceUserData instanceof Face2FaceUserProfile)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692244);
      }
    }
    Object localObject2 = localQQAppInterface.getFaceBitmap(paramFace2FaceUserData.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ImageUtil.c();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (Face2FaceUserProfile)paramFace2FaceUserData;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((Face2FaceUserProfile)localObject1).a);
    paramFace2FaceUserData = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramFace2FaceUserData.e);
    if ((paramFace2FaceUserData != null) && (!TextUtils.isEmpty(paramFace2FaceUserData.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramFace2FaceUserData.remark + ")");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692246);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839424);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839440);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */