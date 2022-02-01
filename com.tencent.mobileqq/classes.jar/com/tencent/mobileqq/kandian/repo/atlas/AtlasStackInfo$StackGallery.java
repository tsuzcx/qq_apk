package com.tencent.mobileqq.kandian.repo.atlas;

public class AtlasStackInfo$StackGallery
{
  public AtlasModelImageList a;
  public int b;
  public boolean c;
  public boolean d;
  
  public AtlasStackInfo$StackGallery(AtlasStackInfo paramAtlasStackInfo, AtlasModelImageList paramAtlasModelImageList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramAtlasModelImageList;
    this.b = paramInt;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b == 0) {
      this.b = paramInt;
    }
    if (!this.c) {
      this.c = paramBoolean1;
    }
    if (!this.d) {
      this.d = paramBoolean2;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StackGallery{rowKey='");
    localStringBuilder.append(this.a.mParsedInfo.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", place=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isExposure=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isClicked=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.atlas.AtlasStackInfo.StackGallery
 * JD-Core Version:    0.7.0.1
 */