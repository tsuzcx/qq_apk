package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;

public class ForwardRobotOption
  extends ForwardRecommendFriendOption
{
  private String ae;
  private String af;
  
  public ForwardRobotOption(Intent paramIntent)
  {
    super(paramIntent);
    this.ae = paramIntent.getStringExtra("uin");
    this.af = paramIntent.getStringExtra("uinname");
  }
  
  private View a(String paramString, Drawable paramDrawable)
  {
    View localView = LayoutInflater.from(this.s).inflate(2131624610, null);
    TextView localTextView = (TextView)localView.findViewById(2131448988);
    ImageView localImageView = (ImageView)localView.findViewById(2131435631);
    localTextView.setText(paramString);
    localImageView.setImageDrawable(paramDrawable);
    return localView;
  }
  
  protected View a()
  {
    return a(String.format("[%s]%s", new Object[] { HardCodeUtil.a(2131902774), this.af }), FaceDrawable.getFaceDrawable(this.q, 1, this.ae));
  }
  
  protected boolean k()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardRobotOption
 * JD-Core Version:    0.7.0.1
 */