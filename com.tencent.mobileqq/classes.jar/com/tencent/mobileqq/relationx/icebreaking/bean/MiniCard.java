package com.tencent.mobileqq.relationx.icebreaking.bean;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiniCard
{
  public AnonymousQuestion a;
  public MiniCard.BaseProfile a;
  public MiniCard.QZoneInfo a;
  public MiniCard.Sign a;
  public List<String> a;
  public List<MiniCard.NicePicInfo> b = new ArrayList();
  
  public MiniCard()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("baseProfile");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$BaseProfile);
    localStringBuilder.append("|\n");
    localStringBuilder.append("personalLabels");
    localStringBuilder.append("=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray()));
    localStringBuilder.append("|\n");
    localStringBuilder.append("qZoneInfo");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$QZoneInfo);
    localStringBuilder.append("|\n");
    localStringBuilder.append("nicePics");
    localStringBuilder.append("=");
    localStringBuilder.append(Arrays.toString(this.b.toArray()));
    localStringBuilder.append("|\n");
    localStringBuilder.append("sign");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$Sign);
    localStringBuilder.append("|\n");
    localStringBuilder.append("askAnonymously");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion);
    localStringBuilder.append("|\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard
 * JD-Core Version:    0.7.0.1
 */