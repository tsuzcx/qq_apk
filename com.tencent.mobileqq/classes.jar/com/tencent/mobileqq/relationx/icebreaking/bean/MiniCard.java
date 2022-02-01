package com.tencent.mobileqq.relationx.icebreaking.bean;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiniCard
{
  public MiniCard.BaseProfile a;
  public List<String> b = new ArrayList();
  public MiniCard.QZoneInfo c;
  public List<MiniCard.NicePicInfo> d = new ArrayList();
  public MiniCard.Sign e;
  public AnonymousQuestion f;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("baseProfile");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|\n");
    localStringBuilder.append("personalLabels");
    localStringBuilder.append("=");
    localStringBuilder.append(Arrays.toString(this.b.toArray()));
    localStringBuilder.append("|\n");
    localStringBuilder.append("qZoneInfo");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|\n");
    localStringBuilder.append("nicePics");
    localStringBuilder.append("=");
    localStringBuilder.append(Arrays.toString(this.d.toArray()));
    localStringBuilder.append("|\n");
    localStringBuilder.append("sign");
    localStringBuilder.append("=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|\n");
    localStringBuilder.append("askAnonymously");
    localStringBuilder.append("=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard
 * JD-Core Version:    0.7.0.1
 */