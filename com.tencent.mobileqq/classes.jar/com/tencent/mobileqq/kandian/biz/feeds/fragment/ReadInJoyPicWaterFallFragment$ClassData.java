package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import com.tencent.mobileqq.kandian.biz.channel.ChannelClassificationListView.IClassData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;

public class ReadInJoyPicWaterFallFragment$ClassData
  implements ChannelClassificationListView.IClassData
{
  public ChannelCoverInfo a;
  public String a;
  private boolean a;
  public String b;
  
  public ReadInJoyPicWaterFallFragment$ClassData(ChannelCoverInfo paramChannelCoverInfo, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityChannelCoverInfo = paramChannelCoverInfo;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.ClassData
 * JD-Core Version:    0.7.0.1
 */