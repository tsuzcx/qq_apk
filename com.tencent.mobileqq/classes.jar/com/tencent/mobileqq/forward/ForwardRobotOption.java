package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import com.tencent.mobileqq.app.face.FaceDrawable;

public class ForwardRobotOption
  extends ForwardRecommendFriendOption
{
  private String h;
  private String i;
  
  public ForwardRobotOption(Intent paramIntent)
  {
    super(paramIntent);
    this.h = paramIntent.getStringExtra("uin");
    this.i = paramIntent.getStringExtra("uinname");
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559042, null);
    TextView localTextView = (TextView)localView.findViewById(2131380369);
    ImageView localImageView = (ImageView)localView.findViewById(2131368764);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  public View a()
  {
    return a(String.format("[%s]%s", new Object[] { anvx.a(2131704257), this.i }), FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.h));
  }
  
  public boolean l()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardRobotOption
 * JD-Core Version:    0.7.0.1
 */