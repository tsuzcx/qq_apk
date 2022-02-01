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
    this.jdField_a_of_type_JavaLangString = (paramLong + "");
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo = paramTroopFileStatusInfo;
  }
  
  private String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("file_color_note_peerType", 1);
      localJSONObject.put("file_color_note_peerUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("file_color_note_fileName", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g);
      localJSONObject.put("file_color_note_fileSize", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.c);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a != null) {
        localJSONObject.put("file_color_note_file_uuid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a.toString());
      }
      for (;;)
      {
        localJSONObject.put("file_color_note_file_url", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.e);
        localJSONObject.put("file_color_note_busId", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.h);
        return localJSONObject.toString();
        localJSONObject.put("file_color_note_file_uuid", "");
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public ColorNote getColorNote()
  {
    ColorNote.Builder localBuilder = new ColorNote.Builder();
    localBuilder.a(17039360);
    String str = QFileUtils.b(2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.e);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + str + "]");
    }
    localBuilder.a(str);
    localBuilder.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g);
    localBuilder.c(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.c));
    int i = FileManagerUtil.a(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g));
    localBuilder.d("resdrawable://" + i);
    str = a();
    if (!TextUtils.isEmpty(str)) {
      localBuilder.a(str.getBytes());
    }
    return localBuilder.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.colornote.TroopFileColorNoteServiceInfo
 * JD-Core Version:    0.7.0.1
 */