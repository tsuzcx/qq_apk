package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import android.widget.TextView;
import atjm;
import atli;
import atlj;
import atll;
import atlm;
import atlt;
import atlu;
import atlv;
import atlw;
import atlx;
import atup;
import atyw;
import auoy;
import bdll;
import bmkq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

public class QfileFavFileTabView
  extends QfileBaseFavFileTabView
{
  protected Drawable a;
  public View.OnClickListener a;
  protected TextView a;
  atll a;
  public ViewerMoreRelativeLayout a;
  public View.OnClickListener b = new atlu(this);
  
  public QfileFavFileTabView(Context paramContext, atlm paramatlm, atli paramatli)
  {
    super(paramContext, paramatlm, paramatli);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new atlt(this);
    this.jdField_a_of_type_Atll = new atlv(this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getHeight();
  }
  
  protected atjm a()
  {
    return new atlj(a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, a(), this.b, null, null, this.jdField_a_of_type_Atll);
  }
  
  protected String a(FavFileInfo paramFavFileInfo)
  {
    return auoy.a(paramFavFileInfo.c);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839410);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void a(FavFileInfo paramFavFileInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if ((g()) && (!paramBoolean)) {
      if (atyw.a(paramFavFileInfo))
      {
        atyw.b(paramFavFileInfo);
        w();
        q();
      }
    }
    for (;;)
    {
      a(g());
      do
      {
        return;
        atyw.a(paramFavFileInfo);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        break;
        if (c()) {
          break label87;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      return;
      label87:
      u();
      bmkq.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFavFileInfo.a);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFB3", "0X800AFB3", 0, 0, "", "", "", "");
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
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  protected void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupExpandListener(new atlw(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnGroupCollapseListener(new atlx(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(a());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.findViewById(2131381122));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout);
  }
  
  protected void q()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
    for (;;)
    {
      super.q();
      return;
      if ((this.jdField_a_of_type_JavaUtilLinkedHashMap == null) || (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView
 * JD-Core Version:    0.7.0.1
 */