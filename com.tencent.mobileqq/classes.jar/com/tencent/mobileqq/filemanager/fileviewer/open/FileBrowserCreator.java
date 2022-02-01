package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qphone.base.util.QLog;

public class FileBrowserCreator
{
  private Context a;
  private IFileBrowserParams b;
  private boolean c = false;
  private boolean d = false;
  private int e;
  private Rect f;
  private String g;
  private int h;
  private Class<?> i;
  
  public FileBrowserCreator(Context paramContext, IFileBrowserParams paramIFileBrowserParams)
  {
    this.a = paramContext;
    this.b = paramIFileBrowserParams;
    this.i = FileBrowserActivity.class;
    this.h = -1;
  }
  
  private boolean b()
  {
    int j = this.e;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (j != 1)
    {
      bool1 = bool2;
      if (j != 5)
      {
        if (j == 3) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private boolean c()
  {
    if (!b())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processNewFileVideoBrowser isFromAIO return false, mEntranceType:");
        ((StringBuilder)localObject).append(this.e);
        QLog.w("FileBrowserCreator<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = this.b.a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser getChatMessage return falase");
      }
      return false;
    }
    SessionInfo localSessionInfo = this.b.b();
    if (localSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser getSessionInfo return falase");
      }
      return false;
    }
    if (this.b.j())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser set video resume, return true");
      }
      return true;
    }
    if (!this.b.k())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser canUseNewVideoBrowser is false, don't start new video browser");
      }
      return false;
    }
    QFileUtils.a(this.a, this.f, (ChatMessage)localObject, localSessionInfo, this.b.c(), this.b.l(), this.b.m(), null);
    return true;
  }
  
  private void d()
  {
    d(-1);
  }
  
  private void d(int paramInt)
  {
    if ((this.b.k()) && (c())) {
      return;
    }
    Object localObject = this.b.i();
    if (localObject == null)
    {
      QLog.i("FileBrowserCreator<FileAssistant>", 1, "openFileBrowser error, intent params is null.");
      return;
    }
    int j = this.h;
    if (j != -1) {
      ((Intent)localObject).setFlags(j);
    }
    ((Intent)localObject).setClass(this.a, this.i);
    ((Intent)localObject).putExtra("file_enter_file_browser_type", this.e);
    Bundle localBundle = new Bundle();
    localBundle.putInt("file_enter_file_browser_type", this.e);
    Rect localRect = this.f;
    if (localRect != null) {
      localBundle.putParcelable("file_browser_params_thumb_bound", localRect);
    }
    this.b.b(localBundle);
    ((Intent)localObject).putExtra("file_browser_extra_params", localBundle);
    if (!TextUtils.isEmpty(this.g)) {
      ((Intent)localObject).putExtra("selfSet_leftViewText", this.g);
    }
    if (paramInt != -1) {
      ((Activity)this.a).startActivityForResult((Intent)localObject, paramInt);
    } else {
      this.a.startActivity((Intent)localObject);
    }
    localObject = this.a;
    if ((localObject instanceof Activity)) {
      ((Activity)localObject).overridePendingTransition(2130772090, 2130772092);
    }
  }
  
  private void e()
  {
    FileBrowserCreator.2 local2 = new FileBrowserCreator.2(this);
    String str1 = this.a.getString(2131889584);
    String str2 = this.a.getString(2131889586);
    FMDialogUtil.a(this.a, str1, str2, local2);
  }
  
  public void a()
  {
    c(-1);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(Rect paramRect)
  {
    this.f = paramRect;
  }
  
  public void a(Class<?> paramClass)
  {
    this.i = paramClass;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    if ((this.c) && (this.b.d()))
    {
      if (QFileUtils.a(this.a, false, new FileBrowserCreator.1(this, paramInt))) {
        e();
      }
    }
    else {
      d(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator
 * JD-Core Version:    0.7.0.1
 */