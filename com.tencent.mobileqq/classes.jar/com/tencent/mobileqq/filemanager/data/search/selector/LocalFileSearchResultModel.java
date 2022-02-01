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
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private List<FileInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CharSequence b;
  
  public LocalFileSearchResultModel(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  private String a(FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QfileTimeUtils.b(paramFileInfo.b()));
    localStringBuilder.append("  ");
    localStringBuilder.append(FileUtil.a(paramFileInfo.a()));
    return localStringBuilder.toString();
  }
  
  public int a()
  {
    return 0;
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      if (this.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        Object localObject = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
        localObject = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject).append(d());
        this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject);
      }
      else
      {
        this.jdField_a_of_type_JavaLangCharSequence = d();
      }
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return null;
  }
  
  public List<ISearchResultModel> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new ArrayList();
    paramContext = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramContext.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramContext.next();
      LocalFileSearchResultModel localLocalFileSearchResultModel = new LocalFileSearchResultModel(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      localLocalFileSearchResultModel.a(this.jdField_a_of_type_AndroidOsBundle);
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
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public CharSequence b()
  {
    return SearchUtils.a(((FileInfo)this.jdField_a_of_type_JavaUtilList.get(0)).d().toLowerCase(), this.jdField_a_of_type_JavaLangString);
  }
  
  protected void b(View paramView)
  {
    Object localObject = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
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
  
  public boolean b()
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileInfo != null) {
      return ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).isSelected(localFileInfo);
    }
    return false;
  }
  
  public int c()
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileInfo != null) {
      return FileManagerUtil.a(localFileInfo.c());
    }
    return 11;
  }
  
  public CharSequence c()
  {
    return null;
  }
  
  public String c()
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileInfo != null)
    {
      int i = FileManagerUtil.a(localFileInfo.c());
      if ((i == 0) || (i == 2) || (i == 5)) {
        return localFileInfo.c();
      }
    }
    return "";
  }
  
  protected void c(View paramView)
  {
    paramView = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).isSelected(paramView))
    {
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).removeSelected(paramView);
    }
    else
    {
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).addSelected(paramView);
      ReportController.b(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 2, 0, "0", "0", "", "");
    }
    if (!FileUtil.a(paramView.c()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FileManagerUtil.c(paramView.d()));
      localStringBuilder.append(HardCodeUtil.a(2131709605));
      FMToastUtil.a(localStringBuilder.toString());
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).removeSelected(paramView);
    }
  }
  
  public CharSequence d()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return localObject;
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131704617));
      ((StringBuilder)localObject).append("\"");
      localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
      ((SpannableStringBuilder)localObject).append(SearchUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      ((SpannableStringBuilder)localObject).append("\"").append(HardCodeUtil.a(2131692328));
      this.b = ((CharSequence)localObject);
      return this.b;
    }
    localObject = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject).append(SearchUtils.a(a((FileInfo)this.jdField_a_of_type_JavaUtilList.get(0)), this.jdField_a_of_type_JavaLangString));
    if (this.b == null) {
      this.b = ((CharSequence)localObject);
    }
    return this.b;
  }
  
  public String d()
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileInfo != null) {
      return localFileInfo.d();
    }
    return "";
  }
  
  protected void d(View paramView)
  {
    paramView = (QBaseActivity)paramView.getContext();
    FileSelectorSearchGroupFragment.a(this);
    Intent localIntent = new Intent();
    localIntent.putExtra("qfile_search_param_ex_params", this.jdField_a_of_type_AndroidOsBundle);
    PublicFragmentActivity.a(paramView, localIntent, FileSelectorSearchGroupFragment.class, 9999);
  }
  
  public int e_()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.LocalFileSearchResultModel
 * JD-Core Version:    0.7.0.1
 */