package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.FormResHelper;

public class TroopAppFormItem
  extends RelativeLayout
{
  TextView a;
  TextView b;
  ImageView c;
  View d;
  RoundCornerImageView e;
  ImageView f;
  String g = "";
  String h = "";
  int i = 0;
  
  public TroopAppFormItem(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  protected Drawable a(Resources paramResources, int paramInt)
  {
    return FormResHelper.a(paramResources, paramInt, false);
  }
  
  public void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131626664, this);
    this.a = ((TextView)localView.findViewById(2131439121));
    this.b = ((TextView)localView.findViewById(2131446537));
    this.c = ((ImageView)localView.findViewById(2131437126));
    this.d = localView.findViewById(2131444847);
    this.e = ((RoundCornerImageView)localView.findViewById(2131435357));
    this.e.setCorner(DisplayUtil.a(getContext(), 4.0F));
    this.f = ((ImageView)localView.findViewById(2131435469));
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    setBackgroundDrawable(a(getResources(), paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAppFormItem
 * JD-Core Version:    0.7.0.1
 */