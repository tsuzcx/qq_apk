package com.tencent.mobileqq.facetoface;

import afur;
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
import anmw;
import anni;
import asqo;
import asqt;
import asqw;
import asqx;
import bcst;
import bgmo;
import com.tencent.mobileqq.app.QQAppInterface;
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
  public asqw a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131379219);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131377993);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379323));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379369));
    this.c = ((TextView)super.findViewById(2131379330));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362190));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131376473);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(afur.a(10.0F, this.e.getResources()), afur.a(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), afur.a(10.0F, this.e.getResources()), afur.a(15.0F, this.e.getResources()));
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
      if (this.jdField_a_of_type_Asqw != null)
      {
        str = this.jdField_a_of_type_Asqw.e;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Asqw instanceof asqt)) && (paramString2 != null) && (paramString2.equals(this.jdField_a_of_type_Asqw.e)))
    {
      if (paramInt != 0) {
        break label166;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691973);
      if (!paramBoolean) {
        QQToast.a(super.getContext(), 2, anni.a(2131703067), 1).a();
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
        this.jdField_a_of_type_Asqo.a((asqt)this.jdField_a_of_type_Asqw);
        super.c();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = anni.a(2131703084);
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
      if ((paramView == this.jdField_a_of_type_AndroidWidgetButton) && (this.jdField_a_of_type_Asqo != null) && ((this.jdField_a_of_type_Asqw instanceof asqt)))
      {
        asqt localasqt = (asqt)this.jdField_a_of_type_Asqw;
        this.jdField_a_of_type_Asqo.a(localasqt, 1);
        bcst.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, localasqt.e, this.jdField_a_of_type_Asqo.a().getCurrentAccountUin(), "", "");
      }
    }
  }
  
  public void setBindData(asqw paramasqw, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Asqw = paramasqw;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Asqo.a();
    if ((paramasqw instanceof asqt))
    {
      localObject2 = (asqt)paramasqw;
      localObject1 = this.jdField_a_of_type_Asqo.a().a(paramasqw.e, (byte)3, false, false);
      paramasqw = (asqw)localObject1;
      if (localObject1 == null) {
        paramasqw = bgmo.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramasqw));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((asqt)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((asqt)localObject2).e + ")");
      localObject1 = ((asqt)localObject2).c;
      paramasqw = (asqw)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramasqw = ((asqt)localObject2).b;
      }
      paramasqw = localQQAppInterface.getApplication().getString(2131691981, new Object[] { paramasqw });
      this.c.setText(paramasqw);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Asqo.a(((asqt)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131691973);
      }
    }
    while (!(paramasqw instanceof asqx)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131691972);
      }
    }
    Object localObject2 = localQQAppInterface.a(paramasqw.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = bgmo.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (asqx)paramasqw;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((asqx)localObject1).a);
    paramasqw = ((anmw)localQQAppInterface.getManager(51)).e(paramasqw.e);
    if ((paramasqw != null) && (!TextUtils.isEmpty(paramasqw.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramasqw.remark + ")");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691974);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839283);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839299);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */