package com.tencent.mobileqq.facetoface;

import aciy;
import ajjj;
import ajjy;
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
import anwi;
import anwn;
import anwq;
import anwr;
import awqx;
import bacm;
import bbmy;
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
  public anwq a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131311950);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131310817);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131312041));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131312088));
    this.c = ((TextView)super.findViewById(2131312049));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131296583));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131309463);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(aciy.a(10.0F, this.e.getResources()), aciy.a(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), aciy.a(10.0F, this.e.getResources()), aciy.a(15.0F, this.e.getResources()));
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
      if (this.jdField_a_of_type_Anwq != null)
      {
        str = this.jdField_a_of_type_Anwq.e;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Anwq instanceof anwn)) && (paramString2 != null) && (paramString2.equals(this.jdField_a_of_type_Anwq.e)))
    {
      if (paramInt != 0) {
        break label166;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131626704);
      if (!paramBoolean) {
        bbmy.a(super.getContext(), 2, ajjy.a(2131638490), 1).a();
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
        this.jdField_a_of_type_Anwi.a((anwn)this.jdField_a_of_type_Anwq);
        super.c();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = ajjy.a(2131638507);
    }
    bbmy.a(super.getContext(), 1, paramString2, 1).a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      super.c();
    }
    while ((paramView != this.jdField_a_of_type_AndroidWidgetButton) || (this.jdField_a_of_type_Anwi == null) || (!(this.jdField_a_of_type_Anwq instanceof anwn))) {
      return;
    }
    paramView = (anwn)this.jdField_a_of_type_Anwq;
    this.jdField_a_of_type_Anwi.a(paramView, 1);
    awqx.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, paramView.e, this.jdField_a_of_type_Anwi.a().getCurrentAccountUin(), "", "");
  }
  
  public void setBindData(anwq paramanwq, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Anwq = paramanwq;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Anwi.a();
    if ((paramanwq instanceof anwn))
    {
      localObject2 = (anwn)paramanwq;
      localObject1 = this.jdField_a_of_type_Anwi.a().a(paramanwq.e, (byte)3, false, false);
      paramanwq = (anwq)localObject1;
      if (localObject1 == null) {
        paramanwq = bacm.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramanwq));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((anwn)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((anwn)localObject2).e + ")");
      localObject1 = ((anwn)localObject2).c;
      paramanwq = (anwq)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramanwq = ((anwn)localObject2).b;
      }
      paramanwq = localQQAppInterface.getApplication().getString(2131626712, new Object[] { paramanwq });
      this.c.setText(paramanwq);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Anwi.a(((anwn)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131626704);
      }
    }
    while (!(paramanwq instanceof anwr)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131626703);
      }
    }
    Object localObject2 = localQQAppInterface.a(paramanwq.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = bacm.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (anwr)paramanwq;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((anwr)localObject1).a);
    paramanwq = ((ajjj)localQQAppInterface.getManager(51)).e(paramanwq.e);
    if ((paramanwq != null) && (!TextUtils.isEmpty(paramanwq.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramanwq.remark + ")");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131626705);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838998);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839014);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */