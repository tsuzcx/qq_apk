package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LocalFileSearchResultModel
  extends FileSelectorSearchResultModel
{
  private List<FileInfo> d = new ArrayList();
  private CharSequence e;
  private CharSequence f;
  
  public LocalFileSearchResultModel(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  private String a(FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QfileTimeUtils.b(paramFileInfo.g()));
    localStringBuilder.append("  ");
    localStringBuilder.append(FileUtil.a(paramFileInfo.f()));
    return localStringBuilder.toString();
  }
  
  public CharSequence a()
  {
    if (this.e == null) {
      if (this.d.size() == 1)
      {
        Object localObject = (FileInfo)this.d.get(0);
        localObject = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject).append(f());
        this.e = ((CharSequence)localObject);
      }
      else
      {
        this.e = f();
      }
    }
    return this.e;
  }
  
  public List<ISearchResultModel> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new ArrayList();
    paramContext = this.d.iterator();
    while (paramContext.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramContext.next();
      LocalFileSearchResultModel localLocalFileSearchResultModel = new LocalFileSearchResultModel(this.b, this.a);
      localLocalFileSearchResultModel.a(this.c);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localFileInfo);
      localLocalFileSearchResultModel.a(localArrayList);
      paramQQAppInterface.add(localLocalFileSearchResultModel);
    }
    return paramQQAppInterface;
  }
  
  public void a(List<FileInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.d.addAll(paramList);
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  protected void b(View paramView)
  {
    Object localObject = (FileInfo)this.d.get(0);
    paramView = (QBaseActivity)paramView.getContext();
    localObject = FileManagerUtil.a((FileInfo)localObject);
    if ((((FileManagerEntity)localObject).nFileType != 0) && (((FileManagerEntity)localObject).nFileType != 2))
    {
      localObject = new FileModelAdapter((QQAppInterface)paramView.getAppRuntime(), (FileManagerEntity)localObject);
      FileBrowserParam localFileBrowserParam = new FileBrowserParam().a(8);
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(paramView, (IFileBrowserModel)localObject, localFileBrowserParam);
      return;
    }
    paramView = new FileBrowserCreator(paramView, new CommonFileBrowserParams((QQAppInterface)paramView.getAppRuntime(), paramView, (FileManagerEntity)localObject, 10000));
    paramView.a(8);
    paramView.a();
  }
  
  public String c()
  {
    return null;
  }
  
  protected void c(View paramView)
  {
    paramView = (FileInfo)this.d.get(0);
    if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).isSelected(paramView))
    {
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).removeSelected(paramView);
    }
    else
    {
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).addSelected(paramView);
      ReportController.b(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 2, 0, "0", "0", "", "");
    }
    if (!FileUtil.b(paramView.d()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FileManagerUtil.j(paramView.e()));
      localStringBuilder.append(HardCodeUtil.a(2131907332));
      FMToastUtil.a(localStringBuilder.toString());
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).removeSelected(paramView);
    }
  }
  
  public CharSequence d()
  {
    return SearchUtils.a(((FileInfo)this.d.get(0)).e().toLowerCase(), this.b);
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
    Object localObject = this.f;
    if (localObject != null) {
      return localObject;
    }
    int i = this.d.size();
    if (i > 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131902521));
      ((StringBuilder)localObject).append("\"");
      localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
      ((SpannableStringBuilder)localObject).append(SearchUtils.a(this.b, this.b));
      ((SpannableStringBuilder)localObject).append("\"").append(HardCodeUtil.a(2131889316));
      this.f = ((CharSequence)localObject);
      return this.f;
    }
    localObject = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject).append(SearchUtils.a(a((FileInfo)this.d.get(0)), this.b));
    if (this.f == null) {
      this.f = ((CharSequence)localObject);
    }
    return this.f;
  }
  
  public int i()
  {
    return this.d.size();
  }
  
  public String j()
  {
    FileInfo localFileInfo = (FileInfo)this.d.get(0);
    if (localFileInfo != null)
    {
      int i = FileManagerUtil.c(localFileInfo.d());
      if ((i == 0) || (i == 2) || (i == 5)) {
        return localFileInfo.d();
      }
    }
    return "";
  }
  
  public String k()
  {
    FileInfo localFileInfo = (FileInfo)this.d.get(0);
    if (localFileInfo != null) {
      return localFileInfo.e();
    }
    return "";
  }
  
  public int l()
  {
    FileInfo localFileInfo = (FileInfo)this.d.get(0);
    if (localFileInfo != null) {
      return FileManagerUtil.c(localFileInfo.d());
    }
    return 11;
  }
  
  public boolean m()
  {
    FileInfo localFileInfo = (FileInfo)this.d.get(0);
    if (localFileInfo != null) {
      return ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).isSelected(localFileInfo);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.LocalFileSearchResultModel
 * JD-Core Version:    0.7.0.1
 */