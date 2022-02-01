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
    localStringBuilder.append("baseProfile").append("=").append(this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$BaseProfile).append("|\n");
    localStringBuilder.append("personalLabels").append("=").append(Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray())).append("|\n");
    localStringBuilder.append("qZoneInfo").append("=").append(this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$QZoneInfo).append("|\n");
    localStringBuilder.append("nicePics").append("=").append(Arrays.toString(this.b.toArray())).append("|\n");
    localStringBuilder.append("sign").append("=").append(this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingBeanMiniCard$Sign).append("|\n");
    localStringBuilder.append("askAnonymously").append("=").append(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousBeanAnonymousQuestion).append("|\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.bean.MiniCard
 * JD-Core Version:    0.7.0.1
 */