package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import anzj;
import aoot;

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
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559007, null);
    TextView localTextView = (TextView)localView.findViewById(2131380308);
    ImageView localImageView = (ImageView)localView.findViewById(2131368580);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  public View a()
  {
    return a(String.format("[%s]%s", new Object[] { anzj.a(2131703676), this.i }), aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.h));
  }
  
  public boolean j()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardRobotOption
 * JD-Core Version:    0.7.0.1
 */