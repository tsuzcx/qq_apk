package dov.com.qq.im.ae.album.data;

import java.io.Serializable;

public class AEAlbumMediaBaseModel
  implements Serializable
{
  private String path;
  
  public AEAlbumMediaBaseModel(String paramString)
  {
    this.path = paramString;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.data.AEAlbumMediaBaseModel
 * JD-Core Version:    0.7.0.1
 */