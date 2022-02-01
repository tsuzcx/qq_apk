package com.tencent.mobileqq.filemanager.data.search;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserParam;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class FileEntitySearchResultModel
  extends ISearchResultPositionModel
{
  public List<FileManagerEntity> a = new ArrayList();
  String b;
  CharSequence c;
  CharSequence d;
  int e = -1;
  String f;
  
  public FileEntitySearchResultModel()
  {
    f(16);
  }
  
  public CharSequence a()
  {
    if (this.c == null)
    {
      Object localObject1;
      Object localObject2;
      if (this.a.size() == 1)
      {
        Object localObject3 = (FileManagerEntity)this.a.get(0);
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append(f());
        if (((FileManagerEntity)localObject3).nFileType != 13)
        {
          ((SpannableStringBuilder)localObject1).append(" ").append(FileManagerUtil.l((FileManagerEntity)localObject3));
        }
        else
        {
          localObject2 = QfileTimeUtils.b(((FileManagerEntity)localObject3).srvTime);
          localObject3 = FileManagerUtil.k((FileManagerEntity)localObject3);
          ((SpannableStringBuilder)localObject1).clear();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(" ");
          localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131889286));
          ((SpannableStringBuilder)localObject1).append(localStringBuilder.toString());
        }
        this.c = ((CharSequence)localObject1);
      }
      else
      {
        long l = 0L;
        localObject1 = this.a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
          if (l < ((FileManagerEntity)localObject2).srvTime) {
            l = ((FileManagerEntity)localObject2).srvTime;
          }
        }
        this.c = f();
      }
    }
    return this.c;
  }
  
  public void a(View paramView)
  {
    Object localObject1;
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.b);
      SearchUtils.a("all_result", "clk_file", new String[] { ((StringBuilder)localObject1).toString() });
    }
    SearchUtils.a(this.b, 100, 0, paramView);
    if (this.a.size() == 1)
    {
      Object localObject2 = (FileManagerEntity)this.a.get(0);
      localObject1 = (QBaseActivity)paramView.getContext();
      Object localObject3 = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject3).b = "file_viewer_in";
      ((FileManagerReporter.FileAssistantReportData)localObject3).c = 73;
      ((FileManagerReporter.FileAssistantReportData)localObject3).d = FileUtil.a(((FileManagerEntity)localObject2).fileName);
      ((FileManagerReporter.FileAssistantReportData)localObject3).e = ((FileManagerEntity)localObject2).fileSize;
      FileManagerReporter.a(((QBaseActivity)localObject1).getAppRuntime().getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject3);
      FileManagerReporter.a("0X8004AE4");
      int i;
      if (((FileManagerEntity)localObject2).nFileType == 13)
      {
        ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).clickWebTDDocAndUpdateTitle(((FileManagerEntity)localObject2).Uuid, (Context)localObject1, this.e, (FileManagerEntity)localObject2, (AppInterface)((QBaseActivity)localObject1).getAppRuntime());
        i = this.e;
        if (i == 8) {
          ReportController.b(null, "dc00898", "", "", "0X800A084", "0X800A084", 0, 0, "", "", "", "");
        } else if (i == 1) {
          ReportController.b(null, "dc00898", "", "", "0X800A086", "0X800A086", 0, 0, "", "", "", "");
        }
      }
      else
      {
        CommonFileBrowserParams localCommonFileBrowserParams = new CommonFileBrowserParams((QQAppInterface)((QBaseActivity)localObject1).getAppRuntime(), (Context)localObject1, (FileManagerEntity)localObject2, 10001);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("from_qlink_enter_recent", false);
        ((Bundle)localObject3).putString("c2c_discussion_recentfile", ((FileManagerEntity)localObject2).peerUin);
        if (!TextUtils.isEmpty(this.f)) {
          ((Bundle)localObject3).putString("file_browser_extra_params_uin", this.f);
        }
        if ((((FileManagerEntity)localObject2).nFileType != 0) && (((FileManagerEntity)localObject2).nFileType != 2))
        {
          paramView = new FileModelAdapter((QQAppInterface)((QBaseActivity)localObject1).getAppRuntime(), (FileManagerEntity)localObject2);
          paramView.a((Bundle)localObject3);
          i = this.e;
          if (i == -1) {
            i = 7;
          }
          localObject2 = new FileBrowserParam().a(i);
          if (!TextUtils.isEmpty(this.f)) {
            ((FileBrowserParam)localObject2).a(this.f);
          }
          ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile((Context)localObject1, paramView, (IFileBrowserParam)localObject2);
        }
        else
        {
          localCommonFileBrowserParams.a((Bundle)localObject3);
          localObject1 = new FileBrowserCreator((Context)localObject1, localCommonFileBrowserParams);
          ((FileBrowserCreator)localObject1).a(7);
          i = this.e;
          if (i != -1) {
            ((FileBrowserCreator)localObject1).a(i);
          }
          ((FileBrowserCreator)localObject1).a(QFileUtils.a(paramView.findViewById(2131433103), ((FileManagerEntity)localObject2).fileName));
          ((FileBrowserCreator)localObject1).a();
        }
      }
      FileManagerReporter.a("0X8006062");
      UniteSearchReportController.a(null, 0, this.e, "0X8009D59", 0, 0, null, null);
      return;
    }
    FileManagerReporter.a("0X8006099");
    UniteSearchReportController.a(null, 0, this.e, "0X8009D5B", 0, 0, null, null);
    FileSearchDetailActivity.a(paramView.getContext(), g(), this);
  }
  
  public int b()
  {
    return 1;
  }
  
  public String c()
  {
    return ((FileManagerEntity)this.a.get(0)).peerUin;
  }
  
  public CharSequence d()
  {
    CharSequence localCharSequence = SearchUtils.a(((FileManagerEntity)this.a.get(0)).fileName.toLowerCase(), this.b);
    localCharSequence.toString();
    return localCharSequence;
  }
  
  public CharSequence e()
  {
    return null;
  }
  
  public CharSequence f()
  {
    Object localObject1 = this.d;
    if (localObject1 != null) {
      return localObject1;
    }
    int i = this.a.size();
    if (i > 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131902521));
      ((StringBuilder)localObject1).append("\"");
      localObject1 = new SpannableStringBuilder(((StringBuilder)localObject1).toString());
      str = this.b;
      ((SpannableStringBuilder)localObject1).append(SearchUtils.a(str, str));
      ((SpannableStringBuilder)localObject1).append("\"").append("相关的同名文件记录");
      this.d = ((CharSequence)localObject1);
      return this.d;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = FileManagerUtil.k((FileManagerEntity)this.a.get(0)).trim();
    int j = str.indexOf(HardCodeUtil.a(2131902520));
    i = 2;
    if (j == 0) {
      localSpannableStringBuilder.append("来自多人聊天: ");
    }
    for (;;)
    {
      i = 7;
      break label336;
      if (str.indexOf(HardCodeUtil.a(2131902518)) != 0) {
        break;
      }
      localSpannableStringBuilder.append("发给多人聊天: ");
    }
    if (str.indexOf(HardCodeUtil.a(2131902519)) == 0) {
      localSpannableStringBuilder.append("来自群: ");
    }
    for (;;)
    {
      i = 4;
      break label336;
      if (str.indexOf(HardCodeUtil.a(2131902515)) != 0) {
        break;
      }
      localSpannableStringBuilder.append("发给群: ");
    }
    if (str.indexOf(HardCodeUtil.a(2131902516)) == 0) {
      localSpannableStringBuilder.append("来自 ");
    } else if (str.indexOf(HardCodeUtil.a(2131902517)) == 0) {
      localSpannableStringBuilder.append("发给  ");
    } else if (str.indexOf(HardCodeUtil.a(2131902514)) == 0) {
      localSpannableStringBuilder.append("存到");
    } else {
      i = 0;
    }
    label336:
    localObject1 = str;
    if (i != 0) {}
    try
    {
      localObject1 = str.toLowerCase().substring(i);
      localSpannableStringBuilder.append(SearchUtils.a((String)localObject1, this.b));
      if (this.d == null) {
        this.d = localSpannableStringBuilder;
      }
      return this.d;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = str;
      }
    }
  }
  
  public String g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileEntitySearchResultModel
 * JD-Core Version:    0.7.0.1
 */