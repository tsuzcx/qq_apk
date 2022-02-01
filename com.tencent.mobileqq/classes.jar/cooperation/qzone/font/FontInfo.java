package cooperation.qzone.font;

public class FontInfo
{
  public String fTypePath;
  public int fontId;
  public String fontUrl;
  public String tTypePath;
  
  public FontInfo() {}
  
  public FontInfo(int paramInt)
  {
    this.fontId = paramInt;
    this.fTypePath = "";
    this.tTypePath = "";
  }
  
  public String getFullTypeFont()
  {
    return this.fTypePath;
  }
  
  public String getTrueTypeFont()
  {
    return this.tTypePath;
  }
  
  public String toString()
  {
    return "[id=" + this.fontId + ",fTypePath=" + this.fTypePath + ", tTYpePath=" + this.tTypePath + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.font.FontInfo
 * JD-Core Version:    0.7.0.1
 */