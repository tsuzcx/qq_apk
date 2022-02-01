package com.tencent.mobileqq.filemanager.activity.favfile;

import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;

class QfileFavPicFileTabView$4
  implements QfilePinnedHeaderExpandableListView.OnSelectListener
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  QfileFavPicFileTabView$4(QfileFavPicFileTabView paramQfileFavPicFileTabView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.b = 2147483647;
    FavFileInfo localFavFileInfo = (FavFileInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavPicFileTabView.a.getChild(paramInt1, paramInt2);
    if (localFavFileInfo == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = (FMDataCache.a(localFavFileInfo) ^ true);
    if (QfileFavPicFileTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavPicFileTabView, localFavFileInfo, this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavPicFileTabView.r();
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
    QfileFavPicFileTabView localQfileFavPicFileTabView;
    while (paramInt2 <= j)
    {
      localQfileFavPicFileTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavPicFileTabView;
      QfileFavPicFileTabView.a(localQfileFavPicFileTabView, (FavFileInfo)localQfileFavPicFileTabView.a.getChild(paramInt1, paramInt2), this.jdField_a_of_type_Boolean);
      paramInt2 += 1;
    }
    paramInt2 = this.b;
    for (;;)
    {
      paramInt3 = j;
      if (paramInt2 >= i) {
        break;
      }
      localQfileFavPicFileTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavPicFileTabView;
      QfileFavPicFileTabView.a(localQfileFavPicFileTabView, (FavFileInfo)localQfileFavPicFileTabView.a.getChild(paramInt1, paramInt2), this.jdField_a_of_type_Boolean ^ true);
      paramInt2 += 1;
    }
    for (;;)
    {
      paramInt3 += 1;
      if (paramInt3 > this.jdField_a_of_type_Int) {
        break;
      }
      localQfileFavPicFileTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavPicFileTabView;
      QfileFavPicFileTabView.a(localQfileFavPicFileTabView, (FavFileInfo)localQfileFavPicFileTabView.a.getChild(paramInt1, paramInt3), this.jdField_a_of_type_Boolean ^ true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavPicFileTabView.r();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView.4
 * JD-Core Version:    0.7.0.1
 */