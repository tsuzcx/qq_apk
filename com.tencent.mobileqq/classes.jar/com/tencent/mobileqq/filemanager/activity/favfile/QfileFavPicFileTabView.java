package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import atjl;
import atjm;
import atli;
import atlm;
import atly;
import atmb;
import atmc;
import atmd;
import atme;
import atmf;
import atup;
import atyw;
import auoy;
import aups;
import bdll;
import bmkq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;

public class QfileFavPicFileTabView
  extends QfileBaseFavFileTabView
{
  static String c = "QfileFavPicFileTabView<FileAssistant>";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new atmd(this);
  atmb jdField_a_of_type_Atmb = new atmc(this);
  private aups jdField_a_of_type_Aups = new atmf(this);
  private View.OnClickListener b = new atme(this);
  
  public QfileFavPicFileTabView(Context paramContext, atlm paramatlm, atli paramatli)
  {
    super(paramContext, paramatlm, paramatli);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = (FavFileInfo)((atjl)paramView.getTag()).a;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (paramBoolean) {
      if (atyw.a(paramView))
      {
        atyw.b(paramView);
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
        atyw.a(paramView);
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
      bmkq.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView.a);
    }
  }
  
  private boolean a(FavFileInfo paramFavFileInfo, boolean paramBoolean)
  {
    if (paramFavFileInfo == null) {}
    do
    {
      return false;
      a(paramBoolean);
    } while ((g()) && (((atyw.a(paramFavFileInfo)) && (paramBoolean)) || ((!atyw.a(paramFavFileInfo)) && (!paramBoolean))));
    if (g())
    {
      if (!paramBoolean) {
        break label57;
      }
      atyw.a(paramFavFileInfo);
    }
    for (;;)
    {
      return true;
      label57:
      atyw.b(paramFavFileInfo);
    }
  }
  
  protected atjm a()
  {
    return new atly(this.jdField_a_of_type_Atmb, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, null, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.b, null, null);
  }
  
  protected String a(FavFileInfo paramFavFileInfo)
  {
    return auoy.a(paramFavFileInfo.c);
  }
  
  protected void a(boolean paramBoolean)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFAD", "0X800AFAD", 0, 0, "", "", "", "");
  }
  
  protected int b()
  {
    return 1;
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    atly localatly = (atly)this.jdField_a_of_type_Atjm;
    if ((b()) && (localatly.b())) {
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Aups);
  }
  
  protected void o()
  {
    super.o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((atly)this.jdField_a_of_type_Atjm).b());
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