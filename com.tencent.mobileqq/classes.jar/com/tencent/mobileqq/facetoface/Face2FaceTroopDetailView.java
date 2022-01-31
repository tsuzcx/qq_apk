package com.tencent.mobileqq.facetoface;

import actn;
import ajxn;
import ajyc;
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
import aonc;
import aonh;
import aonk;
import aonl;
import axqw;
import bbdr;
import bcpw;
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
  public aonk a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377771);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131376625);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377864));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377910));
    this.c = ((TextView)super.findViewById(2131377871));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362124));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131375211);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(actn.a(10.0F, this.e.getResources()), actn.a(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), actn.a(10.0F, this.e.getResources()), actn.a(15.0F, this.e.getResources()));
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
      if (this.jdField_a_of_type_Aonk != null)
      {
        str = this.jdField_a_of_type_Aonk.e;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Aonk instanceof aonh)) && (paramString2 != null) && (paramString2.equals(this.jdField_a_of_type_Aonk.e)))
    {
      if (paramInt != 0) {
        break label166;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692306);
      if (!paramBoolean) {
        bcpw.a(super.getContext(), 2, ajyc.a(2131704275), 1).a();
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
        this.jdField_a_of_type_Aonc.a((aonh)this.jdField_a_of_type_Aonk);
        super.c();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = ajyc.a(2131704292);
    }
    bcpw.a(super.getContext(), 1, paramString2, 1).a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      super.c();
    }
    while ((paramView != this.jdField_a_of_type_AndroidWidgetButton) || (this.jdField_a_of_type_Aonc == null) || (!(this.jdField_a_of_type_Aonk instanceof aonh))) {
      return;
    }
    paramView = (aonh)this.jdField_a_of_type_Aonk;
    this.jdField_a_of_type_Aonc.a(paramView, 1);
    axqw.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, paramView.e, this.jdField_a_of_type_Aonc.a().getCurrentAccountUin(), "", "");
  }
  
  public void setBindData(aonk paramaonk, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Aonk = paramaonk;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Aonc.a();
    if ((paramaonk instanceof aonh))
    {
      localObject2 = (aonh)paramaonk;
      localObject1 = this.jdField_a_of_type_Aonc.a().a(paramaonk.e, (byte)3, false, false);
      paramaonk = (aonk)localObject1;
      if (localObject1 == null) {
        paramaonk = bbdr.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramaonk));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((aonh)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((aonh)localObject2).e + ")");
      localObject1 = ((aonh)localObject2).c;
      paramaonk = (aonk)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramaonk = ((aonh)localObject2).b;
      }
      paramaonk = localQQAppInterface.getApplication().getString(2131692314, new Object[] { paramaonk });
      this.c.setText(paramaonk);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Aonc.a(((aonh)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692306);
      }
    }
    while (!(paramaonk instanceof aonl)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692305);
      }
    }
    Object localObject2 = localQQAppInterface.a(paramaonk.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = bbdr.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (aonl)paramaonk;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((aonl)localObject1).a);
    paramaonk = ((ajxn)localQQAppInterface.getManager(51)).e(paramaonk.e);
    if ((paramaonk != null) && (!TextUtils.isEmpty(paramaonk.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramaonk.remark + ")");
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