package com.tencent.mobileqq.filemanager.fileviewer.colornote;

import android.text.TextUtils;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class FavFileColorNoteServiceInfo
  implements IServiceInfo
{
  private String a;
  
  public FavFileColorNoteServiceInfo(String paramString)
  {
    this.a = paramString;
    if (FileUtils.fileExistsAndNotEmpty(this.a)) {
      this.a = new File(this.a).getAbsolutePath();
    }
  }
  
  private String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("file_color_note_local_path", this.a);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      label26:
      break label26;
    }
    return "";
  }
  
  public ColorNote getColorNote()
  {
    if (!FileUtils.fileExistsAndNotEmpty(this.a))
    {
      QLog.i("FavFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
      return null;
    }
    ColorNote.Builder localBuilder = new ColorNote.Builder();
    localBuilder.a(17039360);
    Object localObject = QFileUtils.a(4, this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColorNote: file colorNote key [");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      QLog.i("FavFileColorNoteServiceInfo", 2, localStringBuilder.toString());
    }
    localBuilder.a((String)localObject);
    localObject = FileManagerUtil.a(this.a);
    localBuilder.b((String)localObject);
    localBuilder.c(FileUtil.a(FileManagerUtil.a(this.a)));
    int i = FileManagerUtil.a(FileManagerUtil.a((String)localObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.colornote.FavFileColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */