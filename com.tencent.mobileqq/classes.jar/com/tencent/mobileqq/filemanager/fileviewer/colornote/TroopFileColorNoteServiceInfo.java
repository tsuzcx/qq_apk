package com.tencent.mobileqq.filemanager.fileviewer.colornote;

import android.text.TextUtils;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFileColorNoteServiceInfo
  implements IServiceInfo
{
  private String a;
  private TroopFileStatusInfo b;
  
  public TroopFileColorNoteServiceInfo(long paramLong, TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    this.a = localStringBuilder.toString();
    this.b = paramTroopFileStatusInfo;
  }
  
  private String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("file_color_note_peerType", 1);
      ((JSONObject)localObject).put("file_color_note_peerUin", this.a);
      ((JSONObject)localObject).put("file_color_note_fileName", this.b.t);
      ((JSONObject)localObject).put("file_color_note_fileSize", this.b.i);
      UUID localUUID = this.b.a;
      if (localUUID != null) {
        ((JSONObject)localObject).put("file_color_note_file_uuid", this.b.a.toString());
      } else {
        ((JSONObject)localObject).put("file_color_note_file_uuid", "");
      }
      ((JSONObject)localObject).put("file_color_note_file_url", this.b.r);
      ((JSONObject)localObject).put("file_color_note_busId", this.b.u);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public ColorNote getColorNote()
  {
    ColorNote.Builder localBuilder = new ColorNote.Builder();
    localBuilder.a(17039360);
    Object localObject = QFileUtils.a(2, this.b.r);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColorNote: file colorNote key [");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      QLog.i("TroopFileColorNoteServiceInfo", 2, localStringBuilder.toString());
    }
    localBuilder.a((String)localObject);
    localBuilder.b(this.b.t);
    localBuilder.c(FileUtil.a(this.b.i));
    int i = FileManagerUtil.c(FileManagerUtil.c(this.b.t));
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.colornote.TroopFileColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */