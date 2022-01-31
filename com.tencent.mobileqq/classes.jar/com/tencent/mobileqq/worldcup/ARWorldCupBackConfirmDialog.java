package com.tencent.mobileqq.worldcup;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.utils.StringUtil;

public class ARWorldCupBackConfirmDialog
  extends Dialog
  implements View.OnClickListener
{
  ARWorldCupBackConfirmDialog.IBackConfirmDialogCallBack jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog$IBackConfirmDialogCallBack = null;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public ARWorldCupBackConfirmDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131624515);
    paramContext = getLayoutInflater().inflate(2130970196, null);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramContext);
  }
  
  public void a()
  {
    Object localObject1 = null;
    if (!StringUtil.a(this.d)) {}
    try
    {
      localObject1 = new BitmapDrawable(BitmapFactory.decodeFile(this.d));
      CornerImageView localCornerImageView;
      float f;
      if (localObject1 != null)
      {
        localCornerImageView = (CornerImageView)findViewById(2131369511);
        f = (int)getContext().getResources().getDimension(2131559448);
        localCornerImageView.setRadius(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
        localCornerImageView.setImageDrawable((Drawable)localObject1);
      }
      if (localObject1 == null)
      {
        localObject1 = URLDrawable.getDrawable("http://sqimg.qq.com/qq_product_operations/ar_test/worldcup/dialogImg.png");
        localCornerImageView = (CornerImageView)findViewById(2131369511);
        f = (int)getContext().getResources().getDimension(2131559448);
        localCornerImageView.setRadius(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
        localCornerImageView.setImageDrawable((Drawable)localObject1);
      }
      if (!StringUtil.a(this.c)) {
        ((TextView)findViewById(2131369512)).setText(this.c);
      }
      if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
      {
        ((TextView)findViewById(2131369515)).setText(this.jdField_a_of_type_JavaLangString);
        ((RelativeLayout)findViewById(2131369514)).setOnClickListener(this);
      }
      if (!StringUtil.a(this.b))
      {
        ((TextView)findViewById(2131369517)).setText(this.b);
        ((RelativeLayout)findViewById(2131369516)).setOnClickListener(this);
      }
      localObject1 = (ImageView)findViewById(2131363978);
      if (localObject1 != null) {
        ((ImageView)localObject1).setOnClickListener(this);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  public void a(ARWorldCupBackConfirmDialog.IBackConfirmDialogCallBack paramIBackConfirmDialogCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog$IBackConfirmDialogCallBack = paramIBackConfirmDialogCallBack;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog$IBackConfirmDialogCallBack == null) || (paramView == null)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363978: 
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog$IBackConfirmDialogCallBack.c();
      return;
    case 2131369514: 
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog$IBackConfirmDialogCallBack.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupBackConfirmDialog$IBackConfirmDialogCallBack.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.ARWorldCupBackConfirmDialog
 * JD-Core Version:    0.7.0.1
 */