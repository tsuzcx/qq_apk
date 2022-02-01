package dov.com.qq.im.ae.album.data;

import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;

public class AEAlbumImageModel
  extends AEAlbumMediaBaseModel
{
  private EditorPicInfo editorPicInfo;
  
  public AEAlbumImageModel(String paramString, EditorPicInfo paramEditorPicInfo)
  {
    super(paramString);
    this.editorPicInfo = paramEditorPicInfo;
  }
  
  public EditorPicInfo getEditorPicInfo()
  {
    return this.editorPicInfo;
  }
  
  public void setEditorPicInfo(EditorPicInfo paramEditorPicInfo)
  {
    this.editorPicInfo = paramEditorPicInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.data.AEAlbumImageModel
 * JD-Core Version:    0.7.0.1
 */