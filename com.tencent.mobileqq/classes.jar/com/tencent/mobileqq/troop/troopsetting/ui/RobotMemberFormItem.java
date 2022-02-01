package com.tencent.mobileqq.troop.troopsetting.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.troop.robot.TroopRobotInfo;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;

public class RobotMemberFormItem
{
  public final int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public final String a;
  private int jdField_b_of_type_Int = 0;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c = 0;
  
  public RobotMemberFormItem(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaLangString = "RobotMemberFormItem";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
    a(paramString);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561527, null);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369980));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376597));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363158));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376320));
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298933);
    this.c = this.jdField_b_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a() {}
  
  public void a(AppInterface paramAppInterface, ArrayList<TroopRobotInfo> paramArrayList)
  {
    QLog.d("RobotMemberFormItem", 2, "setMemberUinList!");
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).removeAllViews();
      }
      int i = 0;
      while ((i < paramArrayList.size()) && (i < 3))
      {
        Object localObject2 = (TroopRobotInfo)paramArrayList.get(i);
        localObject1 = String.valueOf(((TroopRobotInfo)localObject2).a());
        Object localObject3 = BaseImageUtil.f();
        FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawableFrom(paramAppInterface, 1, (String)localObject1, 3, (Drawable)localObject3, (Drawable)localObject3, 4);
        localObject3 = new ThemeImageView(this.jdField_a_of_type_AndroidContentContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, this.c);
        localLayoutParams.leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298934);
        if (((TroopRobotInfo)localObject2).b()) {
          localFaceDrawable.setAlpha(50);
        }
        ((ThemeImageView)localObject3).setTag(localObject2);
        ((ThemeImageView)localObject3).setLayoutParams(localLayoutParams);
        ((ThemeImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ThemeImageView)localObject3).setBackgroundDrawable(localFaceDrawable);
        localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (localObject2 != null)
        {
          ((LinearLayout)localObject2).addView((View)localObject3);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("add AvatarViews task  ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("RobotMemberFormItem", 2, ((StringBuilder)localObject2).toString());
        }
        i += 1;
      }
      paramAppInterface = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramAppInterface != null) {
        paramAppInterface.setVisibility(0);
      }
      paramAppInterface = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramAppInterface != null) {
        paramAppInterface.setVisibility(8);
      }
    }
    else
    {
      paramAppInterface = this.jdField_b_of_type_AndroidWidgetTextView;
      if (paramAppInterface != null)
      {
        paramAppInterface.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694477));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramAppInterface = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        if (paramAppInterface != null) {
          paramAppInterface.setVisibility(8);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (paramString != null)
      {
        localTextView.setText(paramString);
        return;
      }
      localTextView.setText("");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      if (paramBoolean) {
        ((ImageView)localObject).setVisibility(0);
      } else {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setRobotRedDot");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("RobotMemberFormItem", 2, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.d("RobotMemberFormItem", 2, "mImgRobotRedDoterr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.ui.RobotMemberFormItem
 * JD-Core Version:    0.7.0.1
 */