package dov.com.qq.im.aeeditor.manage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AEEditorPagStickerGroupWrapper
  implements Serializable
{
  @SerializedName("stickerGroups")
  public List<AEEditorPagStickerGroup> stickerGroupList;
  @SerializedName("version")
  public String version;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorPagStickerGroupWrapper
 * JD-Core Version:    0.7.0.1
 */