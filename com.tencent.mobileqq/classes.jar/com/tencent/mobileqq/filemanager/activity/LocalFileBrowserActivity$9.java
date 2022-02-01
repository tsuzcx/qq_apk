package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class LocalFileBrowserActivity$9
  extends AsyncTask<String, String, List<FileInfo>>
{
  LocalFileBrowserActivity$9(LocalFileBrowserActivity paramLocalFileBrowserActivity, boolean paramBoolean) {}
  
  protected List<FileInfo> a(String... paramVarArgs)
  {
    int j = this.b.Q;
    int i = 0;
    if (j == 6)
    {
      if (AppConstants.SDCARD_FILE_SAVE_PATH.equalsIgnoreCase(paramVarArgs[0])) {
        paramVarArgs = QQFileManagerUtil.a(false, 0);
      } else {
        paramVarArgs = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFiles(paramVarArgs[0], false, 0);
      }
    }
    else {
      paramVarArgs = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFiles(paramVarArgs[0], false, 1);
    }
    if (paramVarArgs == null)
    {
      paramVarArgs = LocalFileBrowserActivity.F;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tmp is null! mCategory:");
      ((StringBuilder)localObject1).append(this.b.Q);
      QLog.e(paramVarArgs, 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    Object localObject2;
    if (this.b.R)
    {
      localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append("/QQ/");
      localObject1 = new File(((StringBuilder)localObject2).toString());
      localObject1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFiles(((File)localObject1).getAbsolutePath(), false, 0);
      if (localObject1 != null) {
        paramVarArgs.addAll((Collection)localObject1);
      }
    }
    Object localObject1 = this.b.getIntent().getStringArrayExtra("STRING_Show_Within_Suffixs");
    if (localObject1 != null) {
      while (i < paramVarArgs.size())
      {
        localObject2 = (FileInfo)paramVarArgs.get(i);
        j = i;
        if (!((FileInfo)localObject2).k()) {
          if (((FileInfo)localObject2).f() != 0L)
          {
            j = i;
            if (((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).checkEnds(((FileInfo)localObject2).e().toLowerCase(), (String[])localObject1)) {}
          }
          else
          {
            paramVarArgs.remove(i);
            j = i - 1;
          }
        }
        i = j + 1;
      }
    }
    return paramVarArgs;
  }
  
  protected void a(List<FileInfo> paramList)
  {
    this.b.O.clear();
    if (paramList != null)
    {
      this.b.O.addAll(paramList);
      paramList.clear();
    }
    if (this.a)
    {
      if (this.b.M.getCount() != 0)
      {
        if (!this.b.K.isStackFromBottom()) {
          this.b.K.setStackFromBottom(true);
        }
        this.b.K.setStackFromBottom(false);
      }
      LocalFileBrowserActivity.a(this.b);
    }
    else if (this.b.V.containsKey(this.b.N))
    {
      int i = ((Integer)this.b.V.get(this.b.N)).intValue();
      if (this.b.M.getCount() > i) {
        LocalFileBrowserActivity.a(this.b, i);
      }
    }
    QQFileManagerUtil.a(this.b.centerView);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.b.J.setVisible(true);
    QQFileManagerUtil.a(this.b.T, this.b.centerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.9
 * JD-Core Version:    0.7.0.1
 */