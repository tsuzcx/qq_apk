package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

public class QfileFavFileTabView
  extends QfileBaseFavFileTabView
{
  protected Drawable a;
  public View.OnClickListener a;
  protected TextView a;
  QfileFavFileBaseExpandableListAdapter.IAdapterCallBack a;
  protected ViewerMoreRelativeLayout a;
  public View.OnClickListener b = new QfileFavFileTabView.2(this);
  
  public QfileFavFileTabView(Context paramContext, QfileFavFileRecordProvider paramQfileFavFileRecordProvider, QfileBaseFavFileTabView.ITabBarViewProxy paramITabBarViewProxy)
  {
    super(paramContext, paramQfileFavFileRecordProvider, paramITabBarViewProxy);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QfileFavFileTabView.1(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileBaseExpandableListAdapter$IAdapterCallBack = new QfileFavFileTabView.3(this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getHeight();
  }
  
  protected QfileBaseExpandableListAdapter a()
  {
    return new QfileFavFileBaseExpandableListAdapter(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.b, null, null, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileBaseExpandableListAdapter$IAdapterCallBack);
  }
  
  protected String a(FavFileInfo paramFavFileInfo)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(paramFavFileInfo.c);
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839401);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void a(FavFileInfo paramFavFileInfo, boolean paramBoolean)
  {
    if ((g()) && (!paramBoolean))
    {
      if (FMDataCache.a(paramFavFileInfo))
      {
        FMDataCache.b(paramFavFileInfo);
      }
      else
      {
        FMDataCache.a(paramFavFileInfo);
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
          QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
        }
        return;
      }
      u();
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openFavorite(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin(), paramFavFileInfo.a);
    }
    a(g());
  }
  
  protected void a(boolean paramBoolean)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X800AFB3", "0X800AFB3", 0, 0, "", "", "", "");
  }
  
  protected int b()
  {
    return 5;
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
  }
  
  protected int c()
  {
    return 15;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null)
      {
        ((Animatable)localDrawable).stop();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  protected void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupExpandListener(new QfileFavFileTabView.4(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupCollapseListener(new QfileFavFileTabView.5(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(a());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131380895));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout);
  }
  
  protected void q()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    } else if ((this.jdField_a_of_type_JavaUtilLinkedHashMap != null) && (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
    super.q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView
 * JD-Core Version:    0.7.0.1
 */