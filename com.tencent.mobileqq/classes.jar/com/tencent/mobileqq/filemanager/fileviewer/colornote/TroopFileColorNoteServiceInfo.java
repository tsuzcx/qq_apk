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
  private TroopFileStatusInfo jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
  private String jdField_a_of_type_JavaLangString;
  
  public TroopFileColorNoteServiceInfo(long paramLong, TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo = paramTroopFileStatusInfo;
  }
  
  private String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("file_color_note_peerType", 1);
      ((JSONObject)localObject).put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("file_color_note_fileName", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g);
      ((JSONObject)localObject).put("file_color_note_fileSize", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.c);
      UUID localUUID = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a;
      if (localUUID != null) {
        ((JSONObject)localObject).put("file_color_note_file_uuid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a.toString());
      } else {
        ((JSONObject)localObject).put("file_color_note_file_uuid", "");
      }
      ((JSONObject)localObject).put("file_color_note_file_url", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.e);
      ((JSONObject)localObject).put("file_color_note_busId", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.h);
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
    Object localObject = QFileUtils.a(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.e);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColorNote: file colorNote key [");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      QLog.i("TroopFileColorNoteServiceInfo", 2, localStringBuilder.toString());
    }
    localBuilder.a((String)localObject);
    localBuilder.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g);
    localBuilder.c(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.c));
    int i = FileManagerUtil.a(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g));
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.colornote.TroopFileColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */