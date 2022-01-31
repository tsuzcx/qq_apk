package com.tencent.mobileqq.facetoface;

import aepi;
import alto;
import alud;
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
import aqko;
import aqkt;
import aqkw;
import aqkx;
import azqs;
import bdhj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
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
  public aqkw a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131378369);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131377188);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378468));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378515));
    this.c = ((TextView)super.findViewById(2131378475));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362130));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131375746);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(aepi.a(10.0F, this.e.getResources()), aepi.a(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), aepi.a(10.0F, this.e.getResources()), aepi.a(15.0F, this.e.getResources()));
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
      if (this.jdField_a_of_type_Aqkw != null)
      {
        str = this.jdField_a_of_type_Aqkw.e;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Aqkw instanceof aqkt)) && (paramString2 != null) && (paramString2.equals(this.jdField_a_of_type_Aqkw.e)))
    {
      if (paramInt != 0) {
        break label166;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692383);
      if (!paramBoolean) {
        QQToast.a(super.getContext(), 2, alud.a(2131704670), 1).a();
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
        this.jdField_a_of_type_Aqko.a((aqkt)this.jdField_a_of_type_Aqkw);
        super.c();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = alud.a(2131704687);
    }
    QQToast.a(super.getContext(), 1, paramString2, 1).a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      super.c();
    }
    while ((paramView != this.jdField_a_of_type_AndroidWidgetButton) || (this.jdField_a_of_type_Aqko == null) || (!(this.jdField_a_of_type_Aqkw instanceof aqkt))) {
      return;
    }
    paramView = (aqkt)this.jdField_a_of_type_Aqkw;
    this.jdField_a_of_type_Aqko.a(paramView, 1);
    azqs.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, paramView.e, this.jdField_a_of_type_Aqko.a().getCurrentAccountUin(), "", "");
  }
  
  public void setBindData(aqkw paramaqkw, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Aqkw = paramaqkw;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Aqko.a();
    if ((paramaqkw instanceof aqkt))
    {
      localObject2 = (aqkt)paramaqkw;
      localObject1 = this.jdField_a_of_type_Aqko.a().a(paramaqkw.e, (byte)3, false, false);
      paramaqkw = (aqkw)localObject1;
      if (localObject1 == null) {
        paramaqkw = bdhj.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramaqkw));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((aqkt)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((aqkt)localObject2).e + ")");
      localObject1 = ((aqkt)localObject2).c;
      paramaqkw = (aqkw)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramaqkw = ((aqkt)localObject2).b;
      }
      paramaqkw = localQQAppInterface.getApplication().getString(2131692391, new Object[] { paramaqkw });
      this.c.setText(paramaqkw);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Aqko.a(((aqkt)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692383);
      }
    }
    while (!(paramaqkw instanceof aqkx)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692382);
      }
    }
    Object localObject2 = localQQAppInterface.a(paramaqkw.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = bdhj.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (aqkx)paramaqkw;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((aqkx)localObject1).a);
    paramaqkw = ((alto)localQQAppInterface.getManager(51)).e(paramaqkw.e);
    if ((paramaqkw != null) && (!TextUtils.isEmpty(paramaqkw.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramaqkw.remark + ")");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692384);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839108);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839124);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */