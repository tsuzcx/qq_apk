package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;

class QfileLocalFilePicTabView$4
  implements QfilePinnedHeaderExpandableListView.OnSelectListener
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  QfileLocalFilePicTabView$4(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.b = 2147483647;
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getChild(paramInt1, paramInt2);
    if (localFileInfo == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = (FMDataCache.a(localFileInfo) ^ true);
    if (QfileLocalFilePicTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView, localFileInfo, this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.p();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      return;
    }
    int i = Math.min(paramInt2, paramInt4);
    int j = Math.max(paramInt2, paramInt4);
    if (paramInt4 < paramInt2) {
      this.b = Math.min(paramInt4, this.b);
    } else {
      this.jdField_a_of_type_Int = Math.max(paramInt4, this.jdField_a_of_type_Int);
    }
    paramInt2 = i;
    QfileLocalFilePicTabView localQfileLocalFilePicTabView;
    while (paramInt2 <= j)
    {
      localQfileLocalFilePicTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView;
      QfileLocalFilePicTabView.a(localQfileLocalFilePicTabView, (FileInfo)localQfileLocalFilePicTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getChild(paramInt1, paramInt2), this.jdField_a_of_type_Boolean);
      paramInt2 += 1;
    }
    paramInt2 = this.b;
    for (;;)
    {
      paramInt3 = j;
      if (paramInt2 >= i) {
        break;
      }
      localQfileLocalFilePicTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView;
      QfileLocalFilePicTabView.a(localQfileLocalFilePicTabView, (FileInfo)localQfileLocalFilePicTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getChild(paramInt1, paramInt2), this.jdField_a_of_type_Boolean ^ true);
      paramInt2 += 1;
    }
    for (;;)
    {
      paramInt3 += 1;
      if (paramInt3 > this.jdField_a_of_type_Int) {
        break;
      }
      localQfileLocalFilePicTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView;
      QfileLocalFilePicTabView.a(localQfileLocalFilePicTabView, (FileInfo)localQfileLocalFilePicTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter.getChild(paramInt1, paramInt3), this.jdField_a_of_type_Boolean ^ true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.p();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      URLDrawable.pause();
      return;
    }
    URLDrawable.resume();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()))
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0).edit();
      localEditor.putInt("GROUP", paramInt1);
      localEditor.putInt("CHILD", (paramInt2 + 1) / 4);
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.4
 * JD-Core Version:    0.7.0.1
 */