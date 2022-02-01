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
    if (FileUtils.b(this.a)) {
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
    catch (JSONException localJSONException) {}
    return "";
  }
  
  public ColorNote getColorNote()
  {
    if (!FileUtils.b(this.a))
    {
      QLog.i("FavFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
      return null;
    }
    ColorNote.Builder localBuilder = new ColorNote.Builder();
    localBuilder.a(17039360);
    String str = QFileUtils.b(4, this.a);
    if (QLog.isColorLevel()) {
      QLog.i("FavFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localBuilder.a(str);
    str = FileManagerUtil.a(this.a);
    localBuilder.b(str);
    localBuilder.c(FileUtil.a(FileManagerUtil.a(this.a)));
    int i = FileManagerUtil.a(FileManagerUtil.a(str));
    localBuilder.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localBuilder.a(str.getBytes());
    }
    return localBuilder.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.colornote.FavFileColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */