package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;

public class PGCPicInfo
{
  public int a;
  public long a;
  public PGCVideoInfo a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PGCPicInfo{picWidth=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", picHeight=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", picMd5='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", picUrl='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", thumbnailUrl='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isAnimation=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", picDesc='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", galleryIndex=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", pgcVideoInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityPGCVideoInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo
 * JD-Core Version:    0.7.0.1
 */