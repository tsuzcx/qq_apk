package dov.com.qq.im.aeeditor.manage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AEEditorPagStickerGroup
  implements Serializable
{
  @SerializedName("stickerGroupID")
  public String stickerGroupId;
  @SerializedName("stickerGroupName")
  public String stickerGroupName;
  @SerializedName("stickers")
  public List<AEEditorPagStickerInfo> stickerInfoList = new ArrayList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorPagStickerGroup
 * JD-Core Version:    0.7.0.1
 */