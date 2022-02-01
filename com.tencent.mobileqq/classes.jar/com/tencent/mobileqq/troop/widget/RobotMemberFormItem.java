package com.tencent.mobileqq.troop.widget;

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
import com.tencent.mobileqq.troop.utils.TroopRobotInfo;
import com.tencent.mobileqq.utils.ImageUtil;
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
    this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561685, null);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370312));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377120));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363219));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376828));
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298928);
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
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694512));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      }
      int i = 0;
      while ((i < paramArrayList.size()) && (i < 3))
      {
        TroopRobotInfo localTroopRobotInfo = (TroopRobotInfo)paramArrayList.get(i);
        String str = String.valueOf(localTroopRobotInfo.a());
        Object localObject = ImageUtil.d();
        localObject = FaceDrawable.getFaceDrawableFrom(paramAppInterface, 1, str, 3, (Drawable)localObject, (Drawable)localObject, 4);
        ThemeImageView localThemeImageView = new ThemeImageView(this.jdField_a_of_type_AndroidContentContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, this.c);
        localLayoutParams.leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298929);
        if (localTroopRobotInfo.b()) {
          ((FaceDrawable)localObject).setAlpha(50);
        }
        localThemeImageView.setTag(localTroopRobotInfo);
        localThemeImageView.setLayoutParams(localLayoutParams);
        localThemeImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        localThemeImageView.setBackgroundDrawable((Drawable)localObject);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localThemeImageView);
          QLog.d("RobotMemberFormItem", 2, "add AvatarViews task  " + str);
        }
        i += 1;
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (paramString != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        QLog.d("RobotMemberFormItem", 2, "setRobotRedDot" + paramBoolean);
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    QLog.d("RobotMemberFormItem", 2, "mImgRobotRedDoterr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RobotMemberFormItem
 * JD-Core Version:    0.7.0.1
 */