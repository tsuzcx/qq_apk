package com.tencent.mobileqq.filemanager.activity.recentfile;

import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;

class QfileRecentPicFileTabView$4
  implements QfilePinnedHeaderExpandableListView.OnSelectListener
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  QfileRecentPicFileTabView$4(QfileRecentPicFileTabView paramQfileRecentPicFileTabView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.b = 2147483647;
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.a.getChild(paramInt1, paramInt2);
    if (localFileManagerEntity == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = (FMDataCache.a(localFileManagerEntity) ^ true);
    if (QfileRecentPicFileTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView, localFileManagerEntity, this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.k();
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
    QfileRecentPicFileTabView localQfileRecentPicFileTabView;
    while (paramInt2 <= j)
    {
      localQfileRecentPicFileTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView;
      QfileRecentPicFileTabView.a(localQfileRecentPicFileTabView, (FileManagerEntity)localQfileRecentPicFileTabView.a.getChild(paramInt1, paramInt2), this.jdField_a_of_type_Boolean);
      paramInt2 += 1;
    }
    paramInt2 = this.b;
    for (;;)
    {
      paramInt3 = j;
      if (paramInt2 >= i) {
        break;
      }
      localQfileRecentPicFileTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView;
      QfileRecentPicFileTabView.a(localQfileRecentPicFileTabView, (FileManagerEntity)localQfileRecentPicFileTabView.a.getChild(paramInt1, paramInt2), this.jdField_a_of_type_Boolean ^ true);
      paramInt2 += 1;
    }
    for (;;)
    {
      paramInt3 += 1;
      if (paramInt3 > this.jdField_a_of_type_Int) {
        break;
      }
      localQfileRecentPicFileTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView;
      QfileRecentPicFileTabView.a(localQfileRecentPicFileTabView, (FileManagerEntity)localQfileRecentPicFileTabView.a.getChild(paramInt1, paramInt3), this.jdField_a_of_type_Boolean ^ true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentPicFileTabView.k();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView.4
 * JD-Core Version:    0.7.0.1
 */