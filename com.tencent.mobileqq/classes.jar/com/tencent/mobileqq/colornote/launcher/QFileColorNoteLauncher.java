package com.tencent.mobileqq.colornote.launcher;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.DatalineFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.TroopFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.WeiYunFileBrowserParams;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileColorNoteLauncher
  implements ILauncher
{
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void a(Context paramContext, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = paramContext.getString(2131889391);
    } else {
      str = "";
    }
    QQToast.makeText(paramContext, 0, str, 0).show();
  }
  
  private void a(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    try
    {
      paramColorNote = new JSONObject(paramColorNote);
      long l1 = paramColorNote.getLong("file_color_note_uniSeq");
      long l2 = paramColorNote.getLong("file_color_note_sessionId");
      int i = paramColorNote.getInt("file_color_note_peerType");
      paramColorNote = paramColorNote.getString("file_color_note_peerUin");
      paramColorNote = ((QQAppInterface)localObject).getFileManagerDataCenter().a(l1, paramColorNote, i, l2);
      if (paramColorNote == null)
      {
        a(paramContext, 1);
        return;
      }
      paramColorNote = new CommonFileBrowserParams((QQAppInterface)localObject, paramContext, paramColorNote, 10001);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("from_qlink_enter_recent", false);
      paramColorNote.a((Bundle)localObject);
      paramContext = new FileBrowserCreator(paramContext, paramColorNote);
      paramContext.a(14);
      paramContext.b(268435456);
      paramContext.a();
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void b(Context paramContext, ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    try
    {
      paramColorNote = new JSONObject(paramColorNote);
      paramColorNote.getInt("file_color_note_peerType");
      long l = paramColorNote.getLong("file_color_note_peerUin");
      paramColorNote = TroopFileUtils.a(localQQAppInterface, l, paramColorNote.getString("file_color_note_file_uuid"), paramColorNote.getString("file_color_note_file_url"), paramColorNote.getString("file_color_note_fileName"), paramColorNote.getLong("file_color_note_fileSize"), paramColorNote.getInt("file_color_note_busId"));
      if (paramColorNote == null)
      {
        a(paramContext, 1);
        return;
      }
      if (paramColorNote.e == 12)
      {
        a(paramContext, 1);
        return;
      }
      paramContext = new FileBrowserCreator(paramContext, new TroopFileBrowserParams(localQQAppInterface, paramContext, l, paramColorNote, -1));
      paramContext.a(14);
      paramContext.a(TroopFileDetailBrowserActivity.class);
      paramContext.a(true);
      paramContext.b(268435456);
      paramContext.a();
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void c(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    String str = new String(paramColorNote.getReserve());
    try
    {
      str = new JSONObject(str).getString("file_color_note_local_path");
      if (!FileUtils.fileExistsAndNotEmpty(str))
      {
        a(paramContext, 1);
        return;
      }
      int i = QFileUtils.a(paramColorNote.getSubType());
      paramColorNote = new CommonFileBrowserParams((QQAppInterface)localObject, paramContext, FileManagerUtil.a(FileInfo.e(str)), 10000);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("file_color_note_subType", i);
      paramColorNote.a((Bundle)localObject);
      paramContext = new FileBrowserCreator(paramContext, paramColorNote);
      paramContext.a(14);
      paramContext.b(268435456);
      paramContext.a();
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void d(Context paramContext, ColorNote paramColorNote)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    try
    {
      long l = new JSONObject(paramColorNote).getLong("file_color_note_uniSeq");
      int i = DataLineMsgRecord.getDevTypeBySeId(l);
      paramColorNote = localQQAppInterface.getMessageFacade().d(i).a(l);
      if (paramColorNote != null)
      {
        paramContext = new FileBrowserCreator(paramContext, new DatalineFileBrowserParams(localQQAppInterface, paramContext, FileManagerUtil.a(paramColorNote)));
        paramContext.a(14);
        paramContext.b(268435456);
        paramContext.a();
        return;
      }
      a(paramContext, 1);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void e(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    paramColorNote = new String(paramColorNote.getReserve());
    try
    {
      JSONObject localJSONObject = new JSONObject(paramColorNote);
      long l = localJSONObject.getLong("file_color_note_sessionId");
      paramColorNote = ((QQAppInterface)localObject).getFileManagerDataCenter().a(l);
      WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
      localWeiYunFileInfo.e = localJSONObject.getLong("file_color_note_cloud_lastTime");
      localWeiYunFileInfo.d = localJSONObject.getLong("file_color_note_fileSize");
      localWeiYunFileInfo.f = localJSONObject.getInt("file_color_note_cloud_srcType");
      localWeiYunFileInfo.a = localJSONObject.getString("file_color_note_cloud_fileId");
      localWeiYunFileInfo.b = localJSONObject.getString("file_color_note_cloud_dirKey");
      localWeiYunFileInfo.c = localJSONObject.getString("file_color_note_fileName");
      if (localJSONObject.has("file_color_note_cloud_encodeUrl")) {
        localWeiYunFileInfo.i = localJSONObject.getString("file_color_note_cloud_encodeUrl");
      }
      if (localJSONObject.has("file_color_note_cloud_")) {
        localWeiYunFileInfo.m = localJSONObject.getString("file_color_note_cloud_");
      }
      if (localJSONObject.has("file_color_note_cloud_")) {
        localWeiYunFileInfo.n = localJSONObject.getString("file_color_note_cloud_");
      }
      localObject = new WeiYunFileBrowserParams((QQAppInterface)localObject, paramContext, localWeiYunFileInfo);
      ((WeiYunFileBrowserParams)localObject).a(paramColorNote);
      paramContext = new FileBrowserCreator(paramContext, (IFileBrowserParams)localObject);
      paramContext.a(14);
      paramContext.b(268435456);
      paramContext.a();
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public int getType()
  {
    return 17039360;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    if (paramColorNote.getServiceType() != 17039360) {
      return;
    }
    if (TextUtils.isEmpty(paramColorNote.getSubType()))
    {
      QLog.i("QFileColorNoteLauncher", 1, "launch: subType is null.");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launch: subKey[");
      localStringBuilder.append(paramColorNote.getSubType());
      localStringBuilder.append("]");
      QLog.i("QFileColorNoteLauncher", 2, localStringBuilder.toString());
    }
    int i = QFileUtils.a(paramColorNote.getSubType());
    if (i == -1)
    {
      QLog.i("QFileColorNoteLauncher", 1, "launch: subType is unknown.");
      return;
    }
    if (paramColorNote.getReserve() == null) {
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 6: 
      d(paramContext, paramColorNote);
      return;
    case 5: 
      c(paramContext, paramColorNote);
      return;
    case 4: 
      c(paramContext, paramColorNote);
      return;
    case 3: 
      e(paramContext, paramColorNote);
      return;
    case 2: 
      b(paramContext, paramColorNote);
      return;
    }
    a(paramContext, paramColorNote);
  }
  
  public void onCreate(Context paramContext, ColorNote paramColorNote, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.QFileColorNoteLauncher
 * JD-Core Version:    0.7.0.1
 */