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
import anvk;
import anvx;
import asxg;
import asxl;
import asxo;
import asxp;
import bdla;
import bheg;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
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
  public asxo a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131379450);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131378206);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379564));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379622));
    this.c = ((TextView)super.findViewById(2131379582));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362202));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131376626);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(AIOUtils.dp2px(10.0F, this.e.getResources()), AIOUtils.dp2px(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), AIOUtils.dp2px(10.0F, this.e.getResources()), AIOUtils.dp2px(15.0F, this.e.getResources()));
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
      if (this.jdField_a_of_type_Asxo != null)
      {
        str = this.jdField_a_of_type_Asxo.e;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Asxo instanceof asxl)) && (paramString2 != null) && (paramString2.equals(this.jdField_a_of_type_Asxo.e)))
    {
      if (paramInt != 0) {
        break label166;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692113);
      if (!paramBoolean) {
        QQToast.a(super.getContext(), 2, anvx.a(2131703755), 1).a();
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
        this.jdField_a_of_type_Asxg.a((asxl)this.jdField_a_of_type_Asxo);
        super.c();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = anvx.a(2131703772);
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
      if ((paramView == this.jdField_a_of_type_AndroidWidgetButton) && (this.jdField_a_of_type_Asxg != null) && ((this.jdField_a_of_type_Asxo instanceof asxl)))
      {
        asxl localasxl = (asxl)this.jdField_a_of_type_Asxo;
        this.jdField_a_of_type_Asxg.a(localasxl, 1);
        bdla.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, localasxl.e, this.jdField_a_of_type_Asxg.a().getCurrentAccountUin(), "", "");
      }
    }
  }
  
  public void setBindData(asxo paramasxo, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Asxo = paramasxo;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Asxg.a();
    if ((paramasxo instanceof asxl))
    {
      localObject2 = (asxl)paramasxo;
      localObject1 = this.jdField_a_of_type_Asxg.a().getTroopFaceBitmap(paramasxo.e, (byte)3, false, false);
      paramasxo = (asxo)localObject1;
      if (localObject1 == null) {
        paramasxo = bheg.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramasxo));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((asxl)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((asxl)localObject2).e + ")");
      localObject1 = ((asxl)localObject2).c;
      paramasxo = (asxo)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramasxo = ((asxl)localObject2).b;
      }
      paramasxo = localQQAppInterface.getApplication().getString(2131692121, new Object[] { paramasxo });
      this.c.setText(paramasxo);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Asxg.a(((asxl)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692113);
      }
    }
    while (!(paramasxo instanceof asxp)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692112);
      }
    }
    Object localObject2 = localQQAppInterface.getFaceBitmap(paramasxo.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = bheg.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (asxp)paramasxo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((asxp)localObject1).a);
    paramasxo = ((anvk)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramasxo.e);
    if ((paramasxo != null) && (!TextUtils.isEmpty(paramasxo.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramasxo.remark + ")");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692114);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839347);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839363);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */