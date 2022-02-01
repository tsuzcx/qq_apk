package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import ataa;
import atab;
import atbx;
import atcb;
import atcn;
import atcq;
import atcr;
import atcs;
import atct;
import atcu;
import atlf;
import atpm;
import aufn;
import augh;
import bdla;
import bmaf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;

public class QfileFavPicFileTabView
  extends QfileBaseFavFileTabView
{
  static String c = "QfileFavPicFileTabView<FileAssistant>";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new atcs(this);
  atcq jdField_a_of_type_Atcq = new atcr(this);
  private augh jdField_a_of_type_Augh = new atcu(this);
  private View.OnClickListener b = new atct(this);
  
  public QfileFavPicFileTabView(Context paramContext, atcb paramatcb, atbx paramatbx)
  {
    super(paramContext, paramatcb, paramatbx);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = (FavFileInfo)((ataa)paramView.getTag()).a;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
    if (paramBoolean) {
      if (atpm.a(paramView))
      {
        atpm.b(paramView);
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
        atpm.a(paramView);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h(true);
        break;
        if (c()) {
          break label94;
        }
      } while (!QLog.isColorLevel());
      QLog.i(c, 2, "click too fast , wait a minute.");
      return;
      label94:
      if (g()) {}
      u();
      bmaf.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView.a);
    }
  }
  
  private boolean a(FavFileInfo paramFavFileInfo, boolean paramBoolean)
  {
    if (paramFavFileInfo == null) {}
    do
    {
      return false;
      a(paramBoolean);
    } while ((g()) && (((atpm.a(paramFavFileInfo)) && (paramBoolean)) || ((!atpm.a(paramFavFileInfo)) && (!paramBoolean))));
    if (g())
    {
      if (!paramBoolean) {
        break label57;
      }
      atpm.a(paramFavFileInfo);
    }
    for (;;)
    {
      return true;
      label57:
      atpm.b(paramFavFileInfo);
    }
  }
  
  protected atab a()
  {
    return new atcn(this.jdField_a_of_type_Atcq, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, null, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.b, null, null);
  }
  
  protected String a(FavFileInfo paramFavFileInfo)
  {
    return aufn.a(paramFavFileInfo.c);
  }
  
  protected void a(boolean paramBoolean)
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFAD", "0X800AFAD", 0, 0, "", "", "", "");
  }
  
  protected int b()
  {
    return 1;
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    atcn localatcn = (atcn)this.jdField_a_of_type_Atab;
    if ((b()) && (localatcn.b())) {
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Augh);
  }
  
  protected void o()
  {
    super.o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((atcn)this.jdField_a_of_type_Atab).b());
  }
  
  public void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileFavPicFileTabView.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView
 * JD-Core Version:    0.7.0.1
 */