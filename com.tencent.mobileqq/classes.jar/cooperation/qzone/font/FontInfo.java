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
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[id=");
    localStringBuffer.append(this.fontId);
    localStringBuffer.append(",fTypePath=");
    localStringBuffer.append(this.fTypePath);
    localStringBuffer.append(", tTYpePath=");
    localStringBuffer.append(this.tTypePath);
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.font.FontInfo
 * JD-Core Version:    0.7.0.1
 */