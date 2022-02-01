package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

class FaceItemAnimation$ChangeInfo
{
  public RecyclerView.ViewHolder a;
  public RecyclerView.ViewHolder b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  private FaceItemAnimation$ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    this.a = paramViewHolder1;
    this.b = paramViewHolder2;
  }
  
  private FaceItemAnimation$ChangeInfo(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramViewHolder1, paramViewHolder2);
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChangeInfo{oldHolder=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", newHolder=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", fromX=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", fromY=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", toX=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", toY=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceItemAnimation.ChangeInfo
 * JD-Core Version:    0.7.0.1
 */