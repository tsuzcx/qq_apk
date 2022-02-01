package com.tencent.mobileqq.vip.lianghao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoUinData;

public class LiangHaoDialogView
  extends LinearLayout
{
  public LiangHaoUinData a;
  private LiangHaoView b;
  
  public LiangHaoDialogView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LiangHaoDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LiangHaoDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(1);
    LayoutInflater.from(getContext()).inflate(2131628351, this, true);
    this.b = ((LiangHaoView)findViewById(2131437155));
  }
  
  public void a(LiangHaoUinData paramLiangHaoUinData)
  {
    this.a = paramLiangHaoUinData;
    this.b.setUin(paramLiangHaoUinData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.LiangHaoDialogView
 * JD-Core Version:    0.7.0.1
 */