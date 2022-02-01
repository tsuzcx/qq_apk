package com.tencent.mobileqq.filemanager.fileviewer.colornote;

import android.text.TextUtils;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudFileColorNoteServiceInfo
  implements IServiceInfo
{
  private FileManagerEntity a;
  
  public CloudFileColorNoteServiceInfo(FileManagerEntity paramFileManagerEntity)
  {
    this.a = paramFileManagerEntity;
  }
  
  private String a()
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.a != null)
      {
        localJSONObject.put("file_color_note_sessionId", this.a.nSessionId);
        localJSONObject.put("file_color_note_cloud_lastTime", this.a.lastTime);
        localJSONObject.put("file_color_note_cloud_fileId", this.a.WeiYunFileId);
        localJSONObject.put("file_color_note_fileName", this.a.fileName);
        localJSONObject.put("file_color_note_fileSize", this.a.fileSize);
        localJSONObject.put("file_color_note_cloud_srcType", this.a.nWeiYunSrcType);
        localJSONObject.put("file_color_note_cloud_encodeUrl", this.a.strLargeThumPath);
        localJSONObject.put("file_color_note_cloud_dirKey", this.a.WeiYunDirKey);
        localJSONObject.put("file_color_note_cloud_", this.a.strFileMd5);
        localJSONObject.put("file_color_note_cloud_", this.a.strFileSHA);
        str = localJSONObject.toString();
      }
      return str;
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public ColorNote getColorNote()
  {
    if (this.a == null)
    {
      QLog.i("CloudFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
      return null;
    }
    ColorNote.Builder localBuilder = new ColorNote.Builder();
    localBuilder.a(17039360);
    String str = QFileUtils.b(3, this.a.nSessionId + this.a.WeiYunFileId);
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localBuilder.a(str);
    localBuilder.b(this.a.fileName);
    localBuilder.c(FileUtil.a(this.a.fileSize));
    int i = FileManagerUtil.a(FileManagerUtil.a(this.a.fileName));
    localBuilder.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localBuilder.a(str.getBytes());
    }
    return localBuilder.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.colornote.CloudFileColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */