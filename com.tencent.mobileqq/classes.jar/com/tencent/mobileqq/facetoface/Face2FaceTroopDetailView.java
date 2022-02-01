package com.tencent.mobileqq.facetoface;

import agej;
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
import anyw;
import anzj;
import atgs;
import atgx;
import atha;
import athb;
import bdll;
import bhmq;
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
  public atha a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131379385);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131378149);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379490));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379536));
    this.c = ((TextView)super.findViewById(2131379497));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362199));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131376605);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.e.setPadding(agej.a(10.0F, this.e.getResources()), agej.a(15.0F, this.e.getResources()) + ImmersiveUtils.getStatusBarHeight(this.e.getContext()), agej.a(10.0F, this.e.getResources()), agej.a(15.0F, this.e.getResources()));
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
      if (this.jdField_a_of_type_Atha != null)
      {
        str = this.jdField_a_of_type_Atha.e;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Atha instanceof atgx)) && (paramString2 != null) && (paramString2.equals(this.jdField_a_of_type_Atha.e)))
    {
      if (paramInt != 0) {
        break label166;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691977);
      if (!paramBoolean) {
        QQToast.a(super.getContext(), 2, anzj.a(2131703174), 1).a();
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
        this.jdField_a_of_type_Atgs.a((atgx)this.jdField_a_of_type_Atha);
        super.c();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = anzj.a(2131703191);
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
      if ((paramView == this.jdField_a_of_type_AndroidWidgetButton) && (this.jdField_a_of_type_Atgs != null) && ((this.jdField_a_of_type_Atha instanceof atgx)))
      {
        atgx localatgx = (atgx)this.jdField_a_of_type_Atha;
        this.jdField_a_of_type_Atgs.a(localatgx, 1);
        bdll.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, localatgx.e, this.jdField_a_of_type_Atgs.a().getCurrentAccountUin(), "", "");
      }
    }
  }
  
  public void setBindData(atha paramatha, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Atha = paramatha;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Atgs.a();
    if ((paramatha instanceof atgx))
    {
      localObject2 = (atgx)paramatha;
      localObject1 = this.jdField_a_of_type_Atgs.a().a(paramatha.e, (byte)3, false, false);
      paramatha = (atha)localObject1;
      if (localObject1 == null) {
        paramatha = bhmq.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramatha));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((atgx)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((atgx)localObject2).e + ")");
      localObject1 = ((atgx)localObject2).c;
      paramatha = (atha)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramatha = ((atgx)localObject2).b;
      }
      paramatha = localQQAppInterface.getApplication().getString(2131691985, new Object[] { paramatha });
      this.c.setText(paramatha);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Atgs.a(((atgx)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131691977);
      }
    }
    while (!(paramatha instanceof athb)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131691976);
      }
    }
    Object localObject2 = localQQAppInterface.a(paramatha.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = bhmq.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (athb)paramatha;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((athb)localObject1).a);
    paramatha = ((anyw)localQQAppInterface.getManager(51)).e(paramatha.e);
    if ((paramatha != null) && (!TextUtils.isEmpty(paramatha.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramatha.remark + ")");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131691978);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839291);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839307);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */