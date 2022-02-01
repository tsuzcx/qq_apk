package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.OnSelectListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class QfileFavPicFileTabView
  extends QfileBaseFavFileTabView
{
  static String c = "QfileFavPicFileTabView<FileAssistant>";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QfileFavPicFileTabView.2(this);
  QfileFavImageExpandableListAdapter.IAdapterCallBack jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavImageExpandableListAdapter$IAdapterCallBack = new QfileFavPicFileTabView.1(this);
  private QfilePinnedHeaderExpandableListView.OnSelectListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener = new QfileFavPicFileTabView.4(this);
  private View.OnClickListener b = new QfileFavPicFileTabView.3(this);
  
  public QfileFavPicFileTabView(Context paramContext, QfileFavFileRecordProvider paramQfileFavFileRecordProvider, QfileBaseFavFileTabView.ITabBarViewProxy paramITabBarViewProxy)
  {
    super(paramContext, paramQfileFavFileRecordProvider, paramITabBarViewProxy);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = (FavFileInfo)((ImageHolder)paramView.getTag()).a;
    if (paramBoolean)
    {
      if (FMDataCache.a(paramView))
      {
        FMDataCache.b(paramView);
      }
      else
      {
        FMDataCache.a(paramView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
      }
      w();
      q();
    }
    else
    {
      if (!c())
      {
        if (QLog.isColorLevel()) {
          QLog.i(c, 2, "click too fast , wait a minute.");
        }
        return;
      }
      u();
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openFavorite(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin(), paramView.a);
    }
    a(g());
  }
  
  private boolean a(FavFileInfo paramFavFileInfo, boolean paramBoolean)
  {
    if (paramFavFileInfo == null) {
      return false;
    }
    a(paramBoolean);
    if ((g()) && (((FMDataCache.a(paramFavFileInfo)) && (paramBoolean)) || ((!FMDataCache.a(paramFavFileInfo)) && (!paramBoolean)))) {
      return false;
    }
    if (g()) {
      if (paramBoolean) {
        FMDataCache.a(paramFavFileInfo);
      } else {
        FMDataCache.b(paramFavFileInfo);
      }
    }
    return true;
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileFavImageExpandableListAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavImageExpandableListAdapter$IAdapterCallBack, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.b, null);
  }
  
  protected String a(FavFileInfo paramFavFileInfo)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(paramFavFileInfo.c);
  }
  
  protected void a(boolean paramBoolean)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800AFAD", "0X800AFAD", 0, 0, "", "", "", "");
  }
  
  protected int b()
  {
    return 1;
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    QfileFavImageExpandableListAdapter localQfileFavImageExpandableListAdapter = (QfileFavImageExpandableListAdapter)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter;
    if ((b()) && (localQfileFavImageExpandableListAdapter.a())) {
      i();
    }
  }
  
  protected int c()
  {
    return 60;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.j();
    setEditbarButton(true, true, false, true, true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView$OnSelectListener);
  }
  
  protected void o()
  {
    super.o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((QfileFavImageExpandableListAdapter)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter).a());
  }
  
  public void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileFavPicFileTabView.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView
 * JD-Core Version:    0.7.0.1
 */