package com.tencent.qcircle.weseevideo.model.template.movie;

public class MovieStickerTextModel
{
  private int stickerTextColor = -1;
  private String stickerTextContent;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (MovieStickerTextModel)paramObject;
      return (this.stickerTextColor == paramObject.stickerTextColor) && (this.stickerTextContent.equals(paramObject.stickerTextContent));
    }
    return false;
  }
  
  public int getStickerTextColor()
  {
    return this.stickerTextColor;
  }
  
  public String getStickerTextContent()
  {
    return this.stickerTextContent;
  }
  
  public void setStickerTextColor(int paramInt)
  {
    this.stickerTextColor = paramInt;
  }
  
  public void setStickerTextContent(String paramString)
  {
    this.stickerTextContent = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MovieStickerTextModel{stickerTextContent='");
    localStringBuilder.append(this.stickerTextContent);
    localStringBuilder.append('\'');
    localStringBuilder.append(", stickerTextColor=");
    localStringBuilder.append(this.stickerTextColor);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.movie.MovieStickerTextModel
 * JD-Core Version:    0.7.0.1
 */