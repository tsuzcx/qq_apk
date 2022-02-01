package com.tencent.mobileqq.kandian.repo.atlas;

public class AtlasStackInfo$StackGallery
{
  public int a;
  public AtlasModelImageList a;
  public boolean a;
  public boolean b;
  
  public AtlasStackInfo$StackGallery(AtlasStackInfo paramAtlasStackInfo, AtlasModelImageList paramAtlasModelImageList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoAtlasAtlasModelImageList = paramAtlasModelImageList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = paramBoolean1;
    }
    if (!this.b) {
      this.b = paramBoolean2;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StackGallery{rowKey='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoAtlasAtlasModelImageList.mParsedInfo.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", place=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isExposure=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isClicked=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.atlas.AtlasStackInfo.StackGallery
 * JD-Core Version:    0.7.0.1
 */