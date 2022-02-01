package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class CommonFileBrowserParams
  extends BaseFileBrowserParams
{
  private QQAppInterface f;
  private Context g;
  private FileManagerEntity h;
  private int i;
  private Bundle j;
  
  public CommonFileBrowserParams(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    super(paramQQAppInterface, paramContext);
    this.g = paramContext;
    FileManagerUtil.e(paramFileManagerEntity);
    this.h = paramFileManagerEntity;
    this.f = paramQQAppInterface;
    this.i = paramInt;
  }
  
  private ForwardFileInfo n()
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(this.h.nSessionId);
    localForwardFileInfo.d(this.h.fileName);
    localForwardFileInfo.d(this.h.fileSize);
    localForwardFileInfo.a(this.h.getFilePath());
    localForwardFileInfo.b(this.i);
    int k = this.i;
    if (k != 10000)
    {
      if (k != 10001)
      {
        if (k != 10004) {
          return localForwardFileInfo;
        }
        String str;
        if (this.h.bSend) {
          str = this.f.getAccount();
        } else {
          str = this.h.peerUin;
        }
        localForwardFileInfo.d(this.h.getCloudType());
        if (str != null) {
          localForwardFileInfo.a(Long.valueOf(str.replace("+", "")).longValue());
        }
        localForwardFileInfo.c(this.h.uniseq);
        localForwardFileInfo.b(this.h.Uuid);
        return localForwardFileInfo;
      }
      localForwardFileInfo.d(this.h.getCloudType());
      localForwardFileInfo.c(this.h.uniseq);
      localForwardFileInfo.b(this.h.Uuid);
      return localForwardFileInfo;
    }
    localForwardFileInfo.d(3);
    localForwardFileInfo.b(10000);
    return localForwardFileInfo;
  }
  
  private Intent o()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = this.j;
    if (localBundle != null) {
      localIntent.putExtras(localBundle);
    }
    return localIntent;
  }
  
  public void a(Bundle paramBundle)
  {
    this.j = paramBundle;
  }
  
  public void b(Bundle paramBundle)
  {
    Bundle localBundle = this.j;
    if ((localBundle != null) && (paramBundle != null))
    {
      if (localBundle.containsKey("file_color_note_subType")) {
        paramBundle.putInt("file_color_note_subType", this.j.getInt("file_color_note_subType", -1));
      }
      if (this.j.containsKey("FromChatHistoryTab")) {
        paramBundle.putInt("FromChatHistoryTab", this.j.getInt("FromChatHistoryTab", 0));
      }
      if (this.j.containsKey("file_location_pos_entrance_multiseq")) {
        paramBundle.putBoolean("file_location_pos_entrance_multiseq", this.j.getBoolean("file_location_pos_entrance_multiseq", false));
      }
    }
  }
  
  protected String e()
  {
    FileManagerEntity localFileManagerEntity = this.h;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileName;
    }
    return "";
  }
  
  protected long f()
  {
    FileManagerEntity localFileManagerEntity = this.h;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileSize;
    }
    return 0L;
  }
  
  protected int g()
  {
    FileManagerEntity localFileManagerEntity = this.h;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.status;
    }
    return 0;
  }
  
  protected String h()
  {
    FileManagerEntity localFileManagerEntity = this.h;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.getFilePath();
    }
    return "";
  }
  
  public Intent i()
  {
    ForwardFileInfo localForwardFileInfo = n();
    Intent localIntent = o();
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    return localIntent;
  }
  
  boolean j()
  {
    if ((this.h.status != 0) && (this.h.status != 3)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(this.h.nSessionId);
      localStringBuilder.append(" status:");
      localStringBuilder.append(this.h.status);
      localStringBuilder.append(" resume");
      QLog.i("FileVideo", 1, localStringBuilder.toString());
    }
    this.f.getFileManagerEngine().b(this.h.nSessionId);
    return true;
  }
  
  boolean k()
  {
    int k = FileManagerUtil.c(e());
    StringBuilder localStringBuilder;
    if (k != 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id:");
        localStringBuilder.append(this.h.nSessionId);
        localStringBuilder.append(" type is:");
        localStringBuilder.append(k);
        localStringBuilder.append(" use old filebrowser:");
        QLog.i("FileVideo", 1, localStringBuilder.toString());
      }
      return false;
    }
    boolean bool = FileManagerUtil.n(h());
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(this.h.nSessionId);
      localStringBuilder.append(" status:");
      localStringBuilder.append(this.h.status);
      localStringBuilder.append(" isLocal:");
      localStringBuilder.append(bool);
      QLog.i("FileVideo", 1, localStringBuilder.toString());
    }
    if ((!bool) && (QFileAssistantUtils.a(this.h.peerUin))) {
      return false;
    }
    return (!bool) || (this.h.status == 1) || (!this.h.isSend());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */