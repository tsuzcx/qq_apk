package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import java.util.ArrayList;
import java.util.List;

public class TroopFileViewerParamParser
{
  protected QQAppInterface a;
  protected FileManagerEntity b;
  protected List<IFileViewerAdapter> c;
  protected int d = 0;
  private int e = 0;
  
  TroopFileViewerParamParser(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public FileBrowserManager.IModelCreater a(BaseActivity paramBaseActivity)
  {
    return new TroopFileViewerParamParser.1(this, paramBaseActivity);
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity)
  {
    Object localObject = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (localObject == null) {
      return false;
    }
    if (paramIntent.getBooleanExtra("from_webview", false))
    {
      TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.a, ((ForwardFileInfo)localObject).b(), ((ForwardFileInfo)localObject).g(), ((ForwardFileInfo)localObject).k(), ((ForwardFileInfo)localObject).i(), ((ForwardFileInfo)localObject).j(), paramIntent.getIntExtra("bisId", 0));
      l1 = ((ForwardFileInfo)localObject).b();
      localObject = paramIntent.getStringExtra("sender_uin");
      long l2 = paramIntent.getLongExtra("last_time", 0L);
      QFileUtils.a(this.a, paramActivity, null, null, l1, localTroopFileStatusInfo, (String)localObject, l2, -1, 0, null, false, false);
      paramActivity.finish();
      return false;
    }
    long l1 = ((ForwardFileInfo)localObject).e();
    this.b = this.a.getFileManagerDataCenter().a(l1);
    if (this.b == null) {
      return false;
    }
    this.c = new ArrayList();
    this.b.lastTime = paramIntent.getLongExtra("last_time", 0L);
    this.c.add(FileViewerAdapterBase.b(this.a, this.b));
    if (this.b.nFileType == 0)
    {
      this.d = 1;
      return true;
    }
    this.d = 3;
    return true;
  }
  
  public List<IFileViewerAdapter> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileViewerParamParser
 * JD-Core Version:    0.7.0.1
 */