package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.kwstudio.office.preview.TdsReaderView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;

public class LocalTdsViewManager
{
  private static LocalTdsViewManager jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewLocalTdsViewManager = null;
  private int jdField_a_of_type_Int = -1;
  private TdsReaderView jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView;
  
  public static LocalTdsViewManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewLocalTdsViewManager == null) {
      jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewLocalTdsViewManager = new LocalTdsViewManager();
    }
    return jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewLocalTdsViewManager;
  }
  
  private static boolean a(TdsReaderView paramTdsReaderView, String paramString)
  {
    String str = FileUtil.a(paramString);
    paramString = str;
    if (str.startsWith(".")) {
      paramString = str.replaceFirst(".", "");
    }
    return paramTdsReaderView.preOpen(paramString);
  }
  
  public TdsReaderView a(Activity paramActivity, String paramString, LocalTdsViewManager.LocalTdsViewManagerCallback paramLocalTdsViewManagerCallback)
  {
    TdsReaderView localTdsReaderView = null;
    if ((this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView != null) && (paramActivity.hashCode() == this.jdField_a_of_type_Int)) {
      localTdsReaderView = this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView;
    }
    do
    {
      return localTdsReaderView;
      if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView != null)
      {
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView.onStop();
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView = null;
      }
    } while (!FileUtil.b(paramString));
    if (!TdsReaderGlobal.a())
    {
      QLog.w("TdsReaderView_LocalTdsViewManager", 4, "openFile: tds disable for filePath=" + paramString);
      return null;
    }
    QLog.w("TdsReaderView_LocalTdsViewManager", 4, "initVarView: new TdsReaderView");
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView = TdsReaderView.newInstance(new LocalTdsViewManager.OpenCallbackImpl(paramActivity, false, paramLocalTdsViewManagerCallback, null));
    if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView != null)
    {
      QLog.w("TdsReaderView_LocalTdsViewManager", 4, "initVarView: TbsReaderView openFile");
      if (a(this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView, paramString))
      {
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView.openFile(paramString, ".pdf");
        this.jdField_a_of_type_Int = paramActivity.hashCode();
        return this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView;
      }
      this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView.onStop();
      this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView = null;
      return null;
    }
    QLog.w("TdsReaderView_LocalTdsViewManager", 4, "openFile: tds instance failed for filePath=" + paramString);
    return null;
  }
  
  public void a(Activity paramActivity)
  {
    int i = paramActivity.hashCode();
    if (QLog.isDevelopLevel()) {
      QLog.d("TdsReaderView_LocalTdsViewManager", 4, "destroy hashCode[" + this.jdField_a_of_type_Int + "],activity[" + i + "]");
    }
    if (this.jdField_a_of_type_Int != i) {}
    while (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView.onStop();
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewTdsReaderView = null;
  }
  
  public boolean a(Activity paramActivity, String paramString, LocalTdsViewManager.LocalTdsViewManagerCallback paramLocalTdsViewManagerCallback, boolean paramBoolean)
  {
    boolean bool = false;
    paramBoolean = bool;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!TdsReaderGlobal.a())
      {
        QLog.w("TdsReaderView_LocalTdsViewManager", 4, "canOpenFile: tds disable for filePath=" + paramString);
        paramBoolean = bool;
      }
    }
    else if (QLog.isColorLevel()) {
      if (!paramBoolean) {
        break label150;
      }
    }
    label150:
    for (paramActivity = "pre open file true! wait callback!";; paramActivity = "pre open file false! strPath=" + paramString)
    {
      QLog.i("TdsReaderView_LocalTdsViewManager", 1, paramActivity);
      if (paramLocalTdsViewManagerCallback != null) {
        paramLocalTdsViewManagerCallback.a(paramBoolean);
      }
      return paramBoolean;
      paramActivity = TdsReaderView.newInstance(new LocalTdsViewManager.OpenCallbackImpl(paramActivity, true, null, null));
      if (paramActivity != null)
      {
        paramBoolean = a(paramActivity, paramString);
        paramActivity.onStop();
        break;
      }
      QLog.w("TdsReaderView_LocalTdsViewManager", 4, "canOpenFile: tds instance failed for filePath=" + paramString);
      paramBoolean = bool;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.LocalTdsViewManager
 * JD-Core Version:    0.7.0.1
 */