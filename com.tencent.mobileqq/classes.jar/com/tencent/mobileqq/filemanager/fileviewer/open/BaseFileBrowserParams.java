package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.utils.FileUtils;

public abstract class BaseFileBrowserParams
  extends IFileBrowserParams
{
  private QQAppInterface f;
  private Context g;
  
  public BaseFileBrowserParams(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.g = paramContext;
    this.f = paramQQAppInterface;
  }
  
  public ChatMessage a()
  {
    return this.a;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.b = paramSessionInfo;
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    this.a = paramChatMessage;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public SessionInfo b()
  {
    return this.b;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    String str = e();
    long l = f();
    if (FileUtils.fileExistsAndNotEmpty(h())) {
      return false;
    }
    int i = g();
    if (i != 2)
    {
      if ((this.b != null) && (this.b.a == 1) && (i == 8)) {
        return false;
      }
      if (FileManagerUtil.c(str) != 2) {
        return false;
      }
      if (!FileManagerUtil.b()) {
        return false;
      }
      if ((!TextUtils.isEmpty(str)) && (l > 0L) && (l > ((IQFileConfigManager)this.f.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(str)).b)) {
        return true;
      }
      if (l > 1048576L) {
        return true;
      }
    }
    return false;
  }
  
  protected abstract String e();
  
  protected abstract long f();
  
  protected abstract int g();
  
  protected abstract String h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.BaseFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */