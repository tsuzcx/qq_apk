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
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private List<FileManagerEntity> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private String jdField_b_of_type_JavaLangString;
  
  public RecentFileSearchResultModel(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public int a()
  {
    return 0;
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null)
    {
      Object localObject1;
      Object localObject2;
      if (this.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        Object localObject3 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append(d());
        if (((FileManagerEntity)localObject3).nFileType != 13)
        {
          ((SpannableStringBuilder)localObject1).append(" ").append(FileManagerUtil.c((FileManagerEntity)localObject3));
        }
        else
        {
          localObject2 = QfileTimeUtils.b(((FileManagerEntity)localObject3).srvTime);
          localObject3 = FileManagerUtil.b((FileManagerEntity)localObject3);
          ((SpannableStringBuilder)localObject1).clear();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(" ");
          localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692298));
          ((SpannableStringBuilder)localObject1).append(localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      }
      else
      {
        long l = 0L;
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
          if (l < ((FileManagerEntity)localObject2).srvTime) {
            l = ((FileManagerEntity)localObject2).srvTime;
          }
        }
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
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramContext.next();
      RecentFileSearchResultModel localRecentFileSearchResultModel = new RecentFileSearchResultModel(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      localRecentFileSearchResultModel.a(this.jdField_a_of_type_AndroidOsBundle);
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
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_ex_params_target_uin", "");
    }
  }
  
  public void a(List<FileManagerEntity> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals(AppConstants.DATALINE_PC_UIN)))
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
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        return;
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public CharSequence b()
  {
    return SearchUtils.a(((FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0)).fileName.toLowerCase(), this.jdField_a_of_type_JavaLangString);
  }
  
  protected void b(View paramView)
  {
    Object localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    paramView = (QBaseActivity)paramView.getContext();
    if (((FileManagerEntity)localObject2).nFileType == 13)
    {
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).clickWebTDDocAndUpdateTitle(((FileManagerEntity)localObject2).Uuid, paramView, this.jdField_a_of_type_Int, (FileManagerEntity)localObject2, (AppInterface)paramView.getAppRuntime());
      return;
    }
    int i;
    if (this.jdField_a_of_type_Int != 0) {
      i = this.jdField_a_of_type_Int;
    } else {
      i = 7;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("from_qlink_enter_recent", false);
    ((Bundle)localObject1).putString("c2c_discussion_recentfile", ((FileManagerEntity)localObject2).peerUin);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      ((Bundle)localObject1).putString("file_browser_extra_params_uin", this.jdField_b_of_type_JavaLangString);
    }
    if ((((FileManagerEntity)localObject2).nFileType != 0) && (((FileManagerEntity)localObject2).nFileType != 2))
    {
      localObject2 = new FileModelAdapter((QQAppInterface)paramView.getAppRuntime(), (FileManagerEntity)localObject2);
      ((FileModelAdapter)localObject2).a((Bundle)localObject1);
      localObject1 = new FileBrowserParam().a(i);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        ((FileBrowserParam)localObject1).a(this.jdField_b_of_type_JavaLangString);
      }
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(paramView, (IFileBrowserModel)localObject2, (IFileBrowserParam)localObject1);
      return;
    }
    localObject2 = new CommonFileBrowserParams((QQAppInterface)paramView.getAppRuntime(), paramView, (FileManagerEntity)localObject2, 10001);
    ((CommonFileBrowserParams)localObject2).a((Bundle)localObject1);
    paramView = new FileBrowserCreator(paramView, (IFileBrowserParams)localObject2);
    paramView.a(7);
    if (this.jdField_a_of_type_Int != 0) {
      paramView.a(this.jdField_a_of_type_Int);
    }
    paramView.a();
  }
  
  public boolean b()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileManagerEntity != null) {
      return ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).isSelected(localFileManagerEntity);
    }
    return false;
  }
  
  public int c()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileManagerEntity != null)
    {
      if (localFileManagerEntity.nFileType == 13) {
        return 13;
      }
      return FileManagerUtil.a(localFileManagerEntity.fileName);
    }
    return 11;
  }
  
  public CharSequence c()
  {
    return null;
  }
  
  public String c()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    int i = FileManagerUtil.a(localFileManagerEntity.fileName);
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
      if (!FileUtil.a((String)localObject2)) {
        localObject1 = localFileManagerEntity.strLargeThumPath;
      }
      localObject2 = localObject1;
      if (!FileUtil.a((String)localObject1)) {
        localObject2 = localFileManagerEntity.strThumbPath;
      }
      FileUtil.a((String)localObject2);
      localObject1 = localObject2;
    }
    if (localFileManagerEntity.nFileType == 13) {
      localObject1 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTDDocFileThumbUrl(localFileManagerEntity.Uuid);
    }
    return localObject1;
  }
  
  protected void c(View paramView)
  {
    paramView = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).isSelected(paramView))
    {
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).removeSelected(paramView);
    }
    else
    {
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).addSelected(paramView);
      ReportController.b(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 1, 0, "0", "0", "", "");
    }
    if ((paramView.cloudType == 3) && (!FileUtil.a(paramView.getFilePath())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FileManagerUtil.c(paramView.fileName));
      localStringBuilder.append(HardCodeUtil.a(2131709597));
      FMToastUtil.a(localStringBuilder.toString());
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).removeSelected(paramView);
    }
  }
  
  public CharSequence d()
  {
    Object localObject1 = this.jdField_b_of_type_JavaLangCharSequence;
    if (localObject1 != null) {
      return localObject1;
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131704617));
      ((StringBuilder)localObject1).append("\"");
      localObject1 = new SpannableStringBuilder(((StringBuilder)localObject1).toString());
      ((SpannableStringBuilder)localObject1).append(SearchUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      ((SpannableStringBuilder)localObject1).append("\"").append(HardCodeUtil.a(2131692328));
      this.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = FileManagerUtil.b((FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0)).trim();
    int j = str.indexOf(HardCodeUtil.a(2131692319));
    i = 2;
    if (j == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131692319));
      ((StringBuilder)localObject1).append(" ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      i = 7;
      break label503;
      if (str.indexOf(HardCodeUtil.a(2131692323)) != 0) {
        break;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131692323));
      ((StringBuilder)localObject1).append(" ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    if (str.indexOf(HardCodeUtil.a(2131692320)) == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131692320));
      ((StringBuilder)localObject1).append(" ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      i = 4;
      break label503;
      if (str.indexOf(HardCodeUtil.a(2131692324)) != 0) {
        break;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131692324));
      ((StringBuilder)localObject1).append(" ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    if (str.indexOf(HardCodeUtil.a(2131692318)) == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131692318));
      ((StringBuilder)localObject1).append(" ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    else if (str.indexOf(HardCodeUtil.a(2131692322)) == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131692322));
      ((StringBuilder)localObject1).append("  ");
      localSpannableStringBuilder.append(((StringBuilder)localObject1).toString());
    }
    else if (str.indexOf(HardCodeUtil.a(2131692321)) == 0)
    {
      localSpannableStringBuilder.append(HardCodeUtil.a(2131692321));
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
      localSpannableStringBuilder.append(SearchUtils.a((String)localObject1, this.jdField_a_of_type_JavaLangString));
      if (this.jdField_b_of_type_JavaLangCharSequence == null) {
        this.jdField_b_of_type_JavaLangCharSequence = localSpannableStringBuilder;
      }
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = str;
      }
    }
  }
  
  public String d()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileName;
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.RecentFileSearchResultModel
 * JD-Core Version:    0.7.0.1
 */