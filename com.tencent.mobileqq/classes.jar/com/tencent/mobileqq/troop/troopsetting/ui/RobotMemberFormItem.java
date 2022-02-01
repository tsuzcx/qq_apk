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
  public final int a = 3;
  public final String b = "RobotMemberFormItem";
  private View c;
  private Context d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private LinearLayout h;
  private int i = 0;
  private int j = 0;
  
  public RobotMemberFormItem(Context paramContext, String paramString)
  {
    this.d = paramContext;
    c();
    a(paramString);
  }
  
  private void c()
  {
    this.c = View.inflate(this.d, 2131627888, null);
    View localView = this.c;
    if (localView != null)
    {
      this.e = ((TextView)localView.findViewById(2131437131));
      this.f = ((TextView)this.c.findViewById(2131444855));
      this.h = ((LinearLayout)this.c.findViewById(2131429023));
      this.g = ((ImageView)this.c.findViewById(2131444531));
    }
    this.i = this.d.getResources().getDimensionPixelSize(2131299655);
    this.j = this.i;
  }
  
  public View a()
  {
    return this.c;
  }
  
  public void a(AppInterface paramAppInterface, ArrayList<TroopRobotInfo> paramArrayList)
  {
    QLog.d("RobotMemberFormItem", 2, "setMemberUinList!");
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      Object localObject1 = this.h;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).removeAllViews();
      }
      int k = 0;
      while ((k < paramArrayList.size()) && (k < 3))
      {
        Object localObject2 = (TroopRobotInfo)paramArrayList.get(k);
        localObject1 = String.valueOf(((TroopRobotInfo)localObject2).a());
        Object localObject3 = BaseImageUtil.m();
        FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawableFrom(paramAppInterface, 1, (String)localObject1, 3, (Drawable)localObject3, (Drawable)localObject3, 4);
        localObject3 = new ThemeImageView(this.d);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.i, this.j);
        localLayoutParams.leftMargin = this.d.getResources().getDimensionPixelSize(2131299656);
        if (((TroopRobotInfo)localObject2).e()) {
          localFaceDrawable.setAlpha(50);
        }
        ((ThemeImageView)localObject3).setTag(localObject2);
        ((ThemeImageView)localObject3).setLayoutParams(localLayoutParams);
        ((ThemeImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ThemeImageView)localObject3).setBackgroundDrawable(localFaceDrawable);
        localObject2 = this.h;
        if (localObject2 != null)
        {
          ((LinearLayout)localObject2).addView((View)localObject3);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("add AvatarViews task  ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("RobotMemberFormItem", 2, ((StringBuilder)localObject2).toString());
        }
        k += 1;
      }
      paramAppInterface = this.h;
      if (paramAppInterface != null) {
        paramAppInterface.setVisibility(0);
      }
      paramAppInterface = this.f;
      if (paramAppInterface != null) {
        paramAppInterface.setVisibility(8);
      }
    }
    else
    {
      paramAppInterface = this.f;
      if (paramAppInterface != null)
      {
        paramAppInterface.setText(this.d.getResources().getString(2131892159));
        this.f.setVisibility(0);
        paramAppInterface = this.h;
        if (paramAppInterface != null) {
          paramAppInterface.setVisibility(8);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.e;
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
    Object localObject = this.g;
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
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.ui.RobotMemberFormItem
 * JD-Core Version:    0.7.0.1
 */