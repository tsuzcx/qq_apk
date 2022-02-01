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

public class OfflineFileColorNoteServiceInfo
  implements IServiceInfo
{
  private FileManagerEntity a;
  
  public OfflineFileColorNoteServiceInfo(FileManagerEntity paramFileManagerEntity)
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
        localJSONObject.put("file_color_note_peerType", this.a.peerType);
        localJSONObject.put("file_color_note_peerUin", this.a.peerUin);
        localJSONObject.put("file_color_note_uniSeq", this.a.uniseq);
        localJSONObject.put("file_color_note_sessionId", this.a.nSessionId);
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
      QLog.i("OfflineFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
      return null;
    }
    ColorNote.Builder localBuilder = new ColorNote.Builder();
    localBuilder.a(17039360);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.nSessionId);
    ((StringBuilder)localObject).append("");
    localObject = QFileUtils.a(1, ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColorNote: file colorNote key [");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("] fileId[");
      localStringBuilder.append(this.a.Uuid);
      localStringBuilder.append("]");
      QLog.i("OfflineFileColorNoteServiceInfo", 2, localStringBuilder.toString());
    }
    localBuilder.a((String)localObject);
    localBuilder.b(this.a.fileName);
    localBuilder.c(FileUtil.a(this.a.fileSize));
    int i = FileManagerUtil.c(FileManagerUtil.c(this.a.fileName));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resdrawable://");
    ((StringBuilder)localObject).append(i);
    localBuilder.d(((StringBuilder)localObject).toString());
    localObject = a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localBuilder.a(((String)localObject).getBytes());
    }
    return localBuilder.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.colornote.OfflineFileColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */