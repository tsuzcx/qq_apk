package com.tencent.mobileqq.filemanager.data.search;

import android.content.Intent;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileEntitySearchResultModel
  extends ISearchResultPositionModel
{
  CharSequence a;
  public String a;
  public List a;
  CharSequence b;
  
  public FileEntitySearchResultModel()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return 1;
  }
  
  public CharSequence a()
  {
    return SearchUtils.a(((FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0)).fileName.toLowerCase(), this.jdField_a_of_type_JavaLangString);
  }
  
  public String a()
  {
    return "##文件##";
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
      paramView = (BaseActivity)paramView.getContext();
      Object localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).b = "file_viewer_in";
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 73;
      ((FileManagerReporter.fileAssistantReportData)localObject).c = FileUtil.a(localFileManagerEntity.fileName);
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Long = localFileManagerEntity.fileSize;
      FileManagerReporter.a(paramView.app.getCurrentAccountUin(), (FileManagerReporter.fileAssistantReportData)localObject);
      FileManagerReporter.a("0X8004AE4");
      localObject = new ForwardFileInfo();
      ((ForwardFileInfo)localObject).d(localFileManagerEntity.getCloudType());
      ((ForwardFileInfo)localObject).b(10001);
      ((ForwardFileInfo)localObject).b(localFileManagerEntity.nSessionId);
      ((ForwardFileInfo)localObject).c(localFileManagerEntity.uniseq);
      ((ForwardFileInfo)localObject).d(localFileManagerEntity.fileName);
      ((ForwardFileInfo)localObject).d(localFileManagerEntity.fileSize);
      ((ForwardFileInfo)localObject).b(localFileManagerEntity.Uuid);
      ((ForwardFileInfo)localObject).a(localFileManagerEntity.getFilePath());
      Intent localIntent = new Intent(paramView, FileBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject);
      localIntent.putExtra("from_qlink_enter_recent", false);
      localIntent.putExtra("c2c_discussion_recentfile", localFileManagerEntity.peerUin);
      localIntent.putExtra("selfSet_leftViewText", "返回");
      FileManagerReporter.a("0X8006062");
      paramView.startActivityForResult(localIntent, 102);
      return;
    }
    FileManagerReporter.a("0X8006099");
    FileSearchDetailActivity.a(paramView.getContext(), b(), this);
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
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence c()
  {
    Object localObject2;
    if (this.jdField_a_of_type_JavaLangCharSequence == null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
        localObject1 = FileUtil.a(((FileManagerEntity)localObject2).fileSize);
        localObject2 = QfileTimeUtils.c(((FileManagerEntity)localObject2).srvTime);
        this.jdField_a_of_type_JavaLangCharSequence = ((String)localObject1 + " " + (String)localObject2);
      }
    }
    else {
      return this.jdField_a_of_type_JavaLangCharSequence;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    long l = 0L;
    label99:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if (l >= ((FileManagerEntity)localObject2).srvTime) {
        break label169;
      }
      l = ((FileManagerEntity)localObject2).srvTime;
    }
    label169:
    for (;;)
    {
      break label99;
      localObject1 = QfileTimeUtils.c(l);
      this.jdField_a_of_type_JavaLangCharSequence = ("最新:" + (String)localObject1);
      break;
    }
  }
  
  public CharSequence d()
  {
    int i = 7;
    if (this.b != null) {
      return this.b;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    Object localObject1;
    if (j > 1)
    {
      localObject1 = new SpannableStringBuilder(j + "条与\"");
      ((SpannableStringBuilder)localObject1).append(SearchUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      ((SpannableStringBuilder)localObject1).append("\"").append("相关的同名文件记录");
      this.b = ((CharSequence)localObject1);
      return this.b;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = FileManagerUtil.b((FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0)).trim();
    if (str.indexOf("来自多人聊天:") == 0) {
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
        if (this.b == null) {
          this.b = localSpannableStringBuilder;
        }
        return this.b;
        if (str.indexOf("发给多人聊天:") == 0)
        {
          localSpannableStringBuilder.append("发给多人聊天: ");
        }
        else if (str.indexOf("来自群:") == 0)
        {
          localSpannableStringBuilder.append("来自群: ");
          i = 4;
        }
        else if (str.indexOf("发给群:") == 0)
        {
          localSpannableStringBuilder.append("发给群: ");
          i = 4;
        }
        else if (str.indexOf("来自") == 0)
        {
          localSpannableStringBuilder.append("来自 ");
          i = 2;
        }
        else if (str.indexOf("发给") == 0)
        {
          localSpannableStringBuilder.append("发给  ");
          i = 2;
        }
        else if (str.indexOf("存到") == 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileEntitySearchResultModel
 * JD-Core Version:    0.7.0.1
 */