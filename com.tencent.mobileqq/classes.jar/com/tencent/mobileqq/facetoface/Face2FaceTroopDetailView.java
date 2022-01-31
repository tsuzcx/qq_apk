package com.tencent.mobileqq.facetoface;

import aekt;
import aloz;
import alpo;
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
import aqgf;
import aqgk;
import aqgn;
import aqgo;
import azmj;
import bdda;
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
  public aqgn a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131378315);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131377134);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378414));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378461));
    this.c = ((TextView)super.findViewById(2131378421));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362130));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131375695);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(aekt.a(10.0F, this.e.getResources()), aekt.a(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), aekt.a(10.0F, this.e.getResources()), aekt.a(15.0F, this.e.getResources()));
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
      if (this.jdField_a_of_type_Aqgn != null)
      {
        str = this.jdField_a_of_type_Aqgn.e;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Aqgn instanceof aqgk)) && (paramString2 != null) && (paramString2.equals(this.jdField_a_of_type_Aqgn.e)))
    {
      if (paramInt != 0) {
        break label166;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692382);
      if (!paramBoolean) {
        QQToast.a(super.getContext(), 2, alpo.a(2131704658), 1).a();
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
        this.jdField_a_of_type_Aqgf.a((aqgk)this.jdField_a_of_type_Aqgn);
        super.c();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = alpo.a(2131704675);
    }
    QQToast.a(super.getContext(), 1, paramString2, 1).a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      super.c();
    }
    while ((paramView != this.jdField_a_of_type_AndroidWidgetButton) || (this.jdField_a_of_type_Aqgf == null) || (!(this.jdField_a_of_type_Aqgn instanceof aqgk))) {
      return;
    }
    paramView = (aqgk)this.jdField_a_of_type_Aqgn;
    this.jdField_a_of_type_Aqgf.a(paramView, 1);
    azmj.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, paramView.e, this.jdField_a_of_type_Aqgf.a().getCurrentAccountUin(), "", "");
  }
  
  public void setBindData(aqgn paramaqgn, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Aqgn = paramaqgn;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Aqgf.a();
    if ((paramaqgn instanceof aqgk))
    {
      localObject2 = (aqgk)paramaqgn;
      localObject1 = this.jdField_a_of_type_Aqgf.a().a(paramaqgn.e, (byte)3, false, false);
      paramaqgn = (aqgn)localObject1;
      if (localObject1 == null) {
        paramaqgn = bdda.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramaqgn));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((aqgk)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((aqgk)localObject2).e + ")");
      localObject1 = ((aqgk)localObject2).c;
      paramaqgn = (aqgn)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramaqgn = ((aqgk)localObject2).b;
      }
      paramaqgn = localQQAppInterface.getApplication().getString(2131692390, new Object[] { paramaqgn });
      this.c.setText(paramaqgn);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Aqgf.a(((aqgk)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692382);
      }
    }
    while (!(paramaqgn instanceof aqgo)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692381);
      }
    }
    Object localObject2 = localQQAppInterface.a(paramaqgn.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = bdda.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (aqgo)paramaqgn;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((aqgo)localObject1).a);
    paramaqgn = ((aloz)localQQAppInterface.getManager(51)).e(paramaqgn.e);
    if ((paramaqgn != null) && (!TextUtils.isEmpty(paramaqgn.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramaqgn.remark + ")");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692383);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839107);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839123);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */