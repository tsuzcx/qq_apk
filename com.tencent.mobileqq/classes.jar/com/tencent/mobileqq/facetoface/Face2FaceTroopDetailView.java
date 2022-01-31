package com.tencent.mobileqq.facetoface;

import actj;
import ajxl;
import ajya;
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
import aonh;
import aonm;
import aonp;
import aonq;
import axqy;
import bbef;
import bcql;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
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
  public aonp a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377771);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131376627);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377869));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377915));
    this.c = ((TextView)super.findViewById(2131377876));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362123));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131375213);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(actj.a(10.0F, this.e.getResources()), actj.a(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), actj.a(10.0F, this.e.getResources()), actj.a(15.0F, this.e.getResources()));
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
      if (this.jdField_a_of_type_Aonp != null)
      {
        str = this.jdField_a_of_type_Aonp.e;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Aonp instanceof aonm)) && (paramString2 != null) && (paramString2.equals(this.jdField_a_of_type_Aonp.e)))
    {
      if (paramInt != 0) {
        break label166;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692306);
      if (!paramBoolean) {
        bcql.a(super.getContext(), 2, ajya.a(2131704286), 1).a();
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
        this.jdField_a_of_type_Aonh.a((aonm)this.jdField_a_of_type_Aonp);
        super.c();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = ajya.a(2131704303);
    }
    bcql.a(super.getContext(), 1, paramString2, 1).a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      super.c();
    }
    while ((paramView != this.jdField_a_of_type_AndroidWidgetButton) || (this.jdField_a_of_type_Aonh == null) || (!(this.jdField_a_of_type_Aonp instanceof aonm))) {
      return;
    }
    paramView = (aonm)this.jdField_a_of_type_Aonp;
    this.jdField_a_of_type_Aonh.a(paramView, 1);
    axqy.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, paramView.e, this.jdField_a_of_type_Aonh.a().getCurrentAccountUin(), "", "");
  }
  
  public void setBindData(aonp paramaonp, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Aonp = paramaonp;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Aonh.a();
    if ((paramaonp instanceof aonm))
    {
      localObject2 = (aonm)paramaonp;
      localObject1 = this.jdField_a_of_type_Aonh.a().a(paramaonp.e, (byte)3, false, false);
      paramaonp = (aonp)localObject1;
      if (localObject1 == null) {
        paramaonp = bbef.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramaonp));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((aonm)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((aonm)localObject2).e + ")");
      localObject1 = ((aonm)localObject2).c;
      paramaonp = (aonp)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramaonp = ((aonm)localObject2).b;
      }
      paramaonp = localQQAppInterface.getApplication().getString(2131692314, new Object[] { paramaonp });
      this.c.setText(paramaonp);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Aonh.a(((aonm)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692306);
      }
    }
    while (!(paramaonp instanceof aonq)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692305);
      }
    }
    Object localObject2 = localQQAppInterface.a(paramaonp.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = bbef.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (aonq)paramaonp;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((aonq)localObject1).a);
    paramaonp = ((ajxl)localQQAppInterface.getManager(51)).e(paramaonp.e);
    if ((paramaonp != null) && (!TextUtils.isEmpty(paramaonp.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramaonp.remark + ")");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692307);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839026);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839042);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */