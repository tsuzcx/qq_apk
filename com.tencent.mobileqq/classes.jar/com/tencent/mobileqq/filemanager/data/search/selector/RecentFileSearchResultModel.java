package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserParam;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentFileSearchResultModel
  extends FileSelectorSearchResultModel
{
  private String d;
  private CharSequence e;
  private CharSequence f;
  private List<FileManagerEntity> g = new ArrayList();
  
  public RecentFileSearchResultModel(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public CharSequence a()
  {
    if (this.e == null)
    {
      Object localObject1;
      Object localObject2;
      if (this.g.size() == 1)
      {
        Object localObject3 = (FileManagerEntity)this.g.get(0);
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
        this.e = ((CharSequence)localObject1);
      }
      else
      {
        long l = 0L;
        localObject1 = this.g.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
          if (l < ((FileManagerEntity)localObject2).srvTime) {
            l = ((FileManagerEntity)localObject2).srvTime;
          }
        }
        this.e = f();
      }
    }
    return this.e;
  }
  
  public List<ISearchResultModel> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new ArrayList();
    paramContext = this.g.iterator();
    while (paramContext.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramContext.next();
      RecentFileSearchResultModel localRecentFileSearchResultModel = new RecentFileSearchResultModel(this.b, this.a);
      localRecentFileSearchResultModel.a(this.c);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localFileManagerEntity);
      localRecentFileSearchResultModel.a(localArrayList);
      paramQQAppInterface.add(localRecentFileSearchResultModel);
    }
    return paramQQAppInterface;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.c != null) {
      this.d = this.c.getString("qfile_search_param_ex_params_target_uin", "");
    }
  }
  
  public void a(List<FileManagerEntity> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if ((!TextUtils.isEmpty(this.d)) && (this.d.equals(AppConstants.DATALINE_PC_UIN)))
      {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList.next();
          if (!QFileUtils.b(localFileManagerEntity)) {
            localArrayList.add(localFileManagerEntity);
          }
        }
        this.g.addAll(localArrayList);
        return;
      }
      this.g.addAll(paramList);
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  protected void b(View paramView)
  {
    Object localObject2 = (FileManagerEntity)this.g.get(0);
    paramView = (QBaseActivity)paramView.getContext();
    if (((FileManagerEntity)localObject2).nFileType == 13)
    {
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).clickWebTDDocAndUpdateTitle(((FileManagerEntity)localObject2).Uuid, paramView, this.a, (FileManagerEntity)localObject2, (AppInterface)paramView.getAppRuntime());
      return;
    }
    int i;
    if (this.a != 0) {
      i = this.a;
    } else {
      i = 7;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("from_qlink_enter_recent", false);
    ((Bundle)localObject1).putString("c2c_discussion_recentfile", ((FileManagerEntity)localObject2).peerUin);
    if (!TextUtils.isEmpty(this.d)) {
      ((Bundle)localObject1).putString("file_browser_extra_params_uin", this.d);
    }
    if ((((FileManagerEntity)localObject2).nFileType != 0) && (((FileManagerEntity)localObject2).nFileType != 2))
    {
      localObject2 = new FileModelAdapter((QQAppInterface)paramView.getAppRuntime(), (FileManagerEntity)localObject2);
      ((FileModelAdapter)localObject2).a((Bundle)localObject1);
      localObject1 = new FileBrowserParam().a(i);
      if (!TextUtils.isEmpty(this.d)) {
        ((FileBrowserParam)localObject1).a(this.d);
      }
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(paramView, (IFileBrowserModel)localObject2, (IFileBrowserParam)localObject1);
      return;
    }
    localObject2 = new CommonFileBrowserParams((QQAppInterface)paramView.getAppRuntime(), paramView, (FileManagerEntity)localObject2, 10001);
    ((CommonFileBrowserParams)localObject2).a((Bundle)localObject1);
    paramView = new FileBrowserCreator(paramView, (IFileBrowserParams)localObject2);
    paramView.a(7);
    if (this.a != 0) {
      paramView.a(this.a);
    }
    paramView.a();
  }
  
  public String c()
  {
    return null;
  }
  
  protected void c(View paramView)
  {
    paramView = (FileManagerEntity)this.g.get(0);
    if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).isSelected(paramView))
    {
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).removeSelected(paramView);
    }
    else
    {
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).addSelected(paramView);
      ReportController.b(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 1, 0, "0", "0", "", "");
    }
    if ((paramView.cloudType == 3) && (!FileUtil.b(paramView.getFilePath())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FileManagerUtil.j(paramView.fileName));
      localStringBuilder.append(HardCodeUtil.a(2131907326));
      FMToastUtil.a(localStringBuilder.toString());
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).removeSelected(paramView);
    }
  }
  
  public CharSequence d()
  {
    return SearchUtils.a(((FileManagerEntity)this.g.get(0)).fileName.toLowerCase(), this.b);
  }
  
  protected void d(View paramView)
  {
    paramView = (QBaseActivity)paramView.getContext();
    FileSelectorSearchGroupFragment.a(this);
    Intent localIntent = new Intent();
    localIntent.putExtra("qfile_search_param_ex_params", this.c);
    PublicFragmentActivity.a(paramView, localIntent, FileSelectorSearchGroupFragment.class, 9999);
  }
  
  public CharSequence e()
  {
    return null;
  }
  
  public CharSequence f()
  {
    Object localObject1 = this.f;
    if (localObject1 != null) {
      return localObject1;
    }
    int i = this.g.size();
    if (i > 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131902521));
      ((StringBuilder)localObject1).append("\"");
      localObject1 = new SpannableStringBuilder(((StringBuilder)localObject1).toString());
      ((SpannableStringBuilder)localObject1).append(SearchUtils.a(this.b, this.b));
      ((SpannableStringBuilder)localObject1).append("\"").append(HardCodeUtil.a(2131889316));
      this.f = ((CharSequence)localObject1);
      return this.f;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = FileManagerUtil.k((FileManagerEntity)this.g.get(0)).trim();
    int j = str.indexOf(HardCodeUtil.a(2131889307));
    i = 2;
    if (j == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131889307));
      ((StringBuilder)localObject1).append(" ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      i = 7;
      break label503;
      if (str.indexOf(HardCodeUtil.a(2131889311)) != 0) {
        break;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131889311));
      ((StringBuilder)localObject1).append(" ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    if (str.indexOf(HardCodeUtil.a(2131889308)) == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131889308));
      ((StringBuilder)localObject1).append(" ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      i = 4;
      break label503;
      if (str.indexOf(HardCodeUtil.a(2131889312)) != 0) {
        break;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131889312));
      ((StringBuilder)localObject1).append(" ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    if (str.indexOf(HardCodeUtil.a(2131889306)) == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131889306));
      ((StringBuilder)localObject1).append(" ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    else if (str.indexOf(HardCodeUtil.a(2131889310)) == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131889310));
      ((StringBuilder)localObject1).append("  ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    else if (str.indexOf(HardCodeUtil.a(2131889309)) == 0)
    {
      localSpannableStringBuilder.append(HardCodeUtil.a(2131889309));
    }
    else
    {
      i = 0;
    }
    label503:
    localObject1 = str;
    if (i != 0) {}
    try
    {
      localObject1 = str.toLowerCase().substring(i);
      localSpannableStringBuilder.append(SearchUtils.a((String)localObject1, this.b));
      if (this.f == null) {
        this.f = localSpannableStringBuilder;
      }
      return this.f;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = str;
      }
    }
  }
  
  public int i()
  {
    return this.g.size();
  }
  
  public String j()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.g.get(0);
    int i = FileManagerUtil.c(localFileManagerEntity.fileName);
    Object localObject1;
    if ((i != 0) && (i != 2))
    {
      if (i == 5) {
        localObject1 = localFileManagerEntity.getFilePath();
      } else {
        localObject1 = "";
      }
    }
    else
    {
      Object localObject2 = localFileManagerEntity.strMiddleThumPath;
      localObject1 = localObject2;
      if (!FileUtil.b((String)localObject2)) {
        localObject1 = localFileManagerEntity.strLargeThumPath;
      }
      localObject2 = localObject1;
      if (!FileUtil.b((String)localObject1)) {
        localObject2 = localFileManagerEntity.strThumbPath;
      }
      FileUtil.b((String)localObject2);
      localObject1 = localObject2;
    }
    if (localFileManagerEntity.nFileType == 13) {
      localObject1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTDDocFileThumbUrl(localFileManagerEntity.Uuid);
    }
    return localObject1;
  }
  
  public String k()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.g.get(0);
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileName;
    }
    return "";
  }
  
  public int l()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.g.get(0);
    if (localFileManagerEntity != null)
    {
      if (localFileManagerEntity.nFileType == 13) {
        return 13;
      }
      return FileManagerUtil.c(localFileManagerEntity.fileName);
    }
    return 11;
  }
  
  public boolean m()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.g.get(0);
    if (localFileManagerEntity != null) {
      return ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).isSelected(localFileManagerEntity);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.RecentFileSearchResultModel
 * JD-Core Version:    0.7.0.1
 */