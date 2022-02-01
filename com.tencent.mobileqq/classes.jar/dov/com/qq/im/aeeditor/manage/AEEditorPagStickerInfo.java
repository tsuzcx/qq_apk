package dov.com.qq.im.aeeditor.manage;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.io.Serializable;

public class AEEditorPagStickerInfo
  implements Serializable
{
  @SerializedName("backgroundColorAdjustable")
  public int backgroundColorAdjustable;
  @SerializedName("fontID")
  public String fontId;
  @SerializedName("preDownload")
  public int preDownload;
  @SerializedName("resourceMD5")
  public String resourceMd5;
  @SerializedName("resourceURL")
  public String resourceUrl;
  @SerializedName("stickerID")
  public String stickerId;
  @SerializedName("stickerName")
  public String stickerName;
  @SerializedName("thumbURL")
  public String thumbUrl;
  
  @NonNull
  public static AEEditorDownloadResBean convert2DownloadBean(@NonNull AEEditorPagStickerInfo paramAEEditorPagStickerInfo)
  {
    AEEditorDownloadResBean localAEEditorDownloadResBean = new AEEditorDownloadResBean();
    localAEEditorDownloadResBean.setId(paramAEEditorPagStickerInfo.stickerId);
    localAEEditorDownloadResBean.setUrl(paramAEEditorPagStickerInfo.resourceUrl);
    localAEEditorDownloadResBean.setMd5(paramAEEditorPagStickerInfo.resourceMd5);
    localAEEditorDownloadResBean.setPreDownload(paramAEEditorPagStickerInfo.preDownload);
    return localAEEditorDownloadResBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo
 * JD-Core Version:    0.7.0.1
 */