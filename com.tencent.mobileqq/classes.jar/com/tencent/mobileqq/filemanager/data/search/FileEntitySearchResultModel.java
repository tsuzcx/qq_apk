package com.tencent.mobileqq.filemanager.data.search;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileEntitySearchResultModel
  extends ISearchResultPositionModel
{
  int jdField_a_of_type_Int = -1;
  CharSequence jdField_a_of_type_JavaLangCharSequence;
  String jdField_a_of_type_JavaLangString;
  public List<FileManagerEntity> a;
  CharSequence jdField_b_of_type_JavaLangCharSequence;
  String jdField_b_of_type_JavaLangString;
  
  public FileEntitySearchResultModel()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public CharSequence a()
  {
    CharSequence localCharSequence = SearchUtils.a(((FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0)).fileName.toLowerCase(), this.jdField_a_of_type_JavaLangString);
    localCharSequence.toString();
    return localCharSequence;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      SearchUtils.a("all_result", "clk_file", new String[] { "" + this.jdField_a_of_type_JavaLangString });
    }
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 100, 0, paramView);
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
      Object localObject1 = (BaseActivity)paramView.getContext();
      Object localObject2 = new FileManagerReporter.FileAssistantReportData();
      ((FileManagerReporter.FileAssistantReportData)localObject2).jdField_b_of_type_JavaLangString = "file_viewer_in";
      ((FileManagerReporter.FileAssistantReportData)localObject2).jdField_a_of_type_Int = 73;
      ((FileManagerReporter.FileAssistantReportData)localObject2).c = FileUtil.a(localFileManagerEntity.fileName);
      ((FileManagerReporter.FileAssistantReportData)localObject2).jdField_a_of_type_Long = localFileManagerEntity.fileSize;
      FileManagerReporter.a(((BaseActivity)localObject1).app.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject2);
      FileManagerReporter.a("0X8004AE4");
      if (localFileManagerEntity.nFileType == 13)
      {
        TeamWorkUtils.a(localFileManagerEntity.Uuid, (Context)localObject1, this.jdField_a_of_type_Int, localFileManagerEntity, ((BaseActivity)localObject1).app);
        if (this.jdField_a_of_type_Int == 8) {
          ReportController.b(null, "dc00898", "", "", "0X800A084", "0X800A084", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        FileManagerReporter.a("0X8006062");
        UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0x8009D59", 0, 0, null, null);
        return;
        if (this.jdField_a_of_type_Int == 1)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A086", "0X800A086", 0, 0, "", "", "", "");
          continue;
          localObject2 = new CommonFileBrowserParams(((BaseActivity)localObject1).app, (Context)localObject1, localFileManagerEntity, 10001);
          Bundle localBundle = new Bundle();
          localBundle.putBoolean("from_qlink_enter_recent", false);
          localBundle.putString("c2c_discussion_recentfile", localFileManagerEntity.peerUin);
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            localBundle.putString("file_browser_extra_params_uin", this.jdField_b_of_type_JavaLangString);
          }
          ((CommonFileBrowserParams)localObject2).a(localBundle);
          localObject1 = new FileBrowserCreator((Context)localObject1, (IFileBrowserParams)localObject2);
          ((FileBrowserCreator)localObject1).a(7);
          if (this.jdField_a_of_type_Int != -1) {
            ((FileBrowserCreator)localObject1).a(this.jdField_a_of_type_Int);
          }
          ((FileBrowserCreator)localObject1).a(HardCodeUtil.a(2131704533));
          ((FileBrowserCreator)localObject1).a(QFileUtils.a(paramView.findViewById(2131366919), localFileManagerEntity.fileName));
          ((FileBrowserCreator)localObject1).a();
        }
      }
    }
    FileManagerReporter.a("0X8006099");
    UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0x8009D5B", 0, 0, null, null);
    FileSearchDetailActivity.a(paramView.getContext(), a(), this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    return null;
  }
  
  public String b()
  {
    return ((FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0)).peerUin;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    Object localObject3;
    if (this.jdField_a_of_type_JavaLangCharSequence == null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label158;
      }
      localObject3 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
      localObject1 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject1).append(d());
      if (((FileManagerEntity)localObject3).nFileType == 13) {
        break label87;
      }
      ((SpannableStringBuilder)localObject1).append(" ").append(FileManagerUtil.c((FileManagerEntity)localObject3));
    }
    label87:
    Object localObject2;
    for (;;)
    {
      this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      return this.jdField_a_of_type_JavaLangCharSequence;
      localObject2 = QfileTimeUtils.b(((FileManagerEntity)localObject3).srvTime);
      localObject3 = FileManagerUtil.b((FileManagerEntity)localObject3);
      ((SpannableStringBuilder)localObject1).clear();
      ((SpannableStringBuilder)localObject1).append((String)localObject2 + " " + (String)localObject3 + " " + BaseApplicationImpl.getContext().getString(2131692370));
    }
    label158:
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    long l = 0L;
    label170:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if (l >= ((FileManagerEntity)localObject2).srvTime) {
        break label220;
      }
      l = ((FileManagerEntity)localObject2).srvTime;
    }
    label220:
    for (;;)
    {
      break label170;
      this.jdField_a_of_type_JavaLangCharSequence = d();
      break;
    }
  }
  
  public CharSequence d()
  {
    int i = 7;
    if (this.jdField_b_of_type_JavaLangCharSequence != null) {
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    Object localObject1;
    if (j > 1)
    {
      localObject1 = new SpannableStringBuilder(j + HardCodeUtil.a(2131704537) + "\"");
      ((SpannableStringBuilder)localObject1).append(SearchUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      ((SpannableStringBuilder)localObject1).append("\"").append("相关的同名文件记录");
      this.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = FileManagerUtil.b((FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0)).trim();
    if (str.indexOf(HardCodeUtil.a(2131704536)) == 0) {
      localSpannableStringBuilder.append("来自多人聊天: ");
    }
    for (;;)
    {
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
        if (str.indexOf(HardCodeUtil.a(2131704534)) == 0)
        {
          localSpannableStringBuilder.append("发给多人聊天: ");
        }
        else if (str.indexOf(HardCodeUtil.a(2131704535)) == 0)
        {
          localSpannableStringBuilder.append("来自群: ");
          i = 4;
        }
        else if (str.indexOf(HardCodeUtil.a(2131704530)) == 0)
        {
          localSpannableStringBuilder.append("发给群: ");
          i = 4;
        }
        else if (str.indexOf(HardCodeUtil.a(2131704531)) == 0)
        {
          localSpannableStringBuilder.append("来自 ");
          i = 2;
        }
        else if (str.indexOf(HardCodeUtil.a(2131704532)) == 0)
        {
          localSpannableStringBuilder.append("发给  ");
          i = 2;
        }
        else if (str.indexOf(HardCodeUtil.a(2131704529)) == 0)
        {
          localSpannableStringBuilder.append("存到");
          i = 2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = str;
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileEntitySearchResultModel
 * JD-Core Version:    0.7.0.1
 */