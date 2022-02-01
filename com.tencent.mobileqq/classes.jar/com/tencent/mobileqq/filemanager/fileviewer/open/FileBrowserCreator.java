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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private IFileBrowserParams jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams;
  private Class<?> jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  
  public FileBrowserCreator(Context paramContext, IFileBrowserParams paramIFileBrowserParams)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams = paramIFileBrowserParams;
    this.jdField_a_of_type_JavaLangClass = FileBrowserActivity.class;
    this.jdField_b_of_type_Int = -1;
  }
  
  private boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 5)
      {
        if (i == 3) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private void b()
  {
    d(-1);
  }
  
  private boolean b()
  {
    if (!a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processNewFileVideoBrowser isFromAIO return false, mEntranceType:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.w("FileBrowserCreator<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser getChatMessage return falase");
      }
      return false;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.a();
    if (localSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser getSessionInfo return falase");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.c())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser set video resume, return true");
      }
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.d())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserCreator<FileAssistant>", 1, "processNewFileVideoBrowser canUseNewVideoBrowser is false, don't start new video browser");
      }
      return false;
    }
    QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidGraphicsRect, (ChatMessage)localObject, localSessionInfo, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.e(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.f(), null);
    return true;
  }
  
  private void c()
  {
    FileBrowserCreator.2 local2 = new FileBrowserCreator.2(this);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692561);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692563);
    FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, str1, str2, local2);
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.d()) && (b())) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.a();
    if (localObject == null)
    {
      QLog.i("FileBrowserCreator<FileAssistant>", 1, "openFileBrowser error, intent params is null.");
      return;
    }
    int i = this.jdField_b_of_type_Int;
    if (i != -1) {
      ((Intent)localObject).setFlags(i);
    }
    ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangClass);
    ((Intent)localObject).putExtra("file_enter_file_browser_type", this.jdField_a_of_type_Int);
    Bundle localBundle = new Bundle();
    localBundle.putInt("file_enter_file_browser_type", this.jdField_a_of_type_Int);
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    if (localRect != null) {
      localBundle.putParcelable("file_browser_params_thumb_bound", localRect);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.b(localBundle);
    ((Intent)localObject).putExtra("file_browser_extra_params", localBundle);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ((Intent)localObject).putExtra("selfSet_leftViewText", this.jdField_a_of_type_JavaLangString);
    }
    if (paramInt != -1) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, paramInt);
    } else {
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    localObject = this.jdField_a_of_type_AndroidContentContext;
    if ((localObject instanceof Activity)) {
      ((Activity)localObject).overridePendingTransition(2130772065, 2130772067);
    }
  }
  
  public void a()
  {
    c(-1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
  
  public void a(Class<?> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerOpenIFileBrowserParams.b()))
    {
      if (QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, false, new FileBrowserCreator.1(this, paramInt))) {
        c();
      }
    }
    else {
      d(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator
 * JD-Core Version:    0.7.0.1
 */