package com.tencent.mobileqq.facetoface;

import amsw;
import amtj;
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
import arta;
import artf;
import arti;
import artj;
import bcef;
import bfvo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
  public arti a;
  protected TextView b;
  protected TextView c;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131379155);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131377920);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379260));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379318));
    this.c = ((TextView)super.findViewById(2131379278));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131362199));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView);
    this.e = super.findViewById(2131376371);
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
      if (this.jdField_a_of_type_Arti != null)
      {
        str = this.jdField_a_of_type_Arti.e;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Arti instanceof artf)) && (paramString2 != null) && (paramString2.equals(this.jdField_a_of_type_Arti.e)))
    {
      if (paramInt != 0) {
        break label166;
      }
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692023);
      if (!paramBoolean) {
        QQToast.a(super.getContext(), 2, amtj.a(2131703404), 1).a();
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
        this.jdField_a_of_type_Arta.a((artf)this.jdField_a_of_type_Arti);
        super.c();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = amtj.a(2131703421);
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
      if ((paramView == this.jdField_a_of_type_AndroidWidgetButton) && (this.jdField_a_of_type_Arta != null) && ((this.jdField_a_of_type_Arti instanceof artf)))
      {
        artf localartf = (artf)this.jdField_a_of_type_Arti;
        this.jdField_a_of_type_Arta.a(localartf, 1);
        bcef.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, localartf.e, this.jdField_a_of_type_Arta.a().getCurrentAccountUin(), "", "");
      }
    }
  }
  
  public void setBindData(arti paramarti, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Arti = paramarti;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Arta.a();
    if ((paramarti instanceof artf))
    {
      localObject2 = (artf)paramarti;
      localObject1 = this.jdField_a_of_type_Arta.a().getTroopFaceBitmap(paramarti.e, (byte)3, false, false);
      paramarti = (arti)localObject1;
      if (localObject1 == null) {
        paramarti = bfvo.f();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramarti));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((artf)localObject2).a);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((artf)localObject2).e + ")");
      localObject1 = ((artf)localObject2).c;
      paramarti = (arti)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramarti = ((artf)localObject2).b;
      }
      paramarti = localQQAppInterface.getApplication().getString(2131692031, new Object[] { paramarti });
      this.c.setText(paramarti);
      this.c.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_Arta.a(((artf)localObject2).e))
      {
        setBtnEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692023);
      }
    }
    while (!(paramarti instanceof artj)) {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131692022);
      }
    }
    Object localObject2 = localQQAppInterface.getFaceBitmap(paramarti.e, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = bfvo.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (artj)paramarti;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((artj)localObject1).a);
    paramarti = ((amsw)localQQAppInterface.getManager(51)).e(paramarti.e);
    if ((paramarti != null) && (!TextUtils.isEmpty(paramarti.remark)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + paramarti.remark + ")");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.c.setVisibility(8);
      setBtnEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692024);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839326);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839342);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */