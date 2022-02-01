package com.tencent.weseevideo.model.template.movie;

public class MovieStickerTextModel
{
  private int stickerTextColor = -1;
  private String stickerTextContent;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (MovieStickerTextModel)paramObject;
    } while ((this.stickerTextColor == paramObject.stickerTextColor) && (this.stickerTextContent.equals(paramObject.stickerTextContent)));
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
    return "MovieStickerTextModel{stickerTextContent='" + this.stickerTextContent + '\'' + ", stickerTextColor=" + this.stickerTextColor + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.movie.MovieStickerTextModel
 * JD-Core Version:    0.7.0.1
 */