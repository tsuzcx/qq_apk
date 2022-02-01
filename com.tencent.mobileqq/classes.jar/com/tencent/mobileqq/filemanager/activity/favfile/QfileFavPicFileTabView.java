package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import arvu;
import arvv;
import arxr;
import arxv;
import aryh;
import aryk;
import aryl;
import arym;
import aryn;
import aryo;
import asgz;
import aslg;
import atbg;
import atca;
import bcef;
import bkox;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;

public class QfileFavPicFileTabView
  extends QfileBaseFavFileTabView
{
  static String c = "QfileFavPicFileTabView<FileAssistant>";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new arym(this);
  aryk jdField_a_of_type_Aryk = new aryl(this);
  private atca jdField_a_of_type_Atca = new aryo(this);
  private View.OnClickListener b = new aryn(this);
  
  public QfileFavPicFileTabView(Context paramContext, arxv paramarxv, arxr paramarxr)
  {
    super(paramContext, paramarxv, paramarxr);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = (FavFileInfo)((arvu)paramView.getTag()).a;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b();
    if (paramBoolean) {
      if (aslg.a(paramView))
      {
        aslg.b(paramView);
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
        aslg.a(paramView);
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
      bkox.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView.a);
    }
  }
  
  private boolean a(FavFileInfo paramFavFileInfo, boolean paramBoolean)
  {
    if (paramFavFileInfo == null) {}
    do
    {
      return false;
      a(paramBoolean);
    } while ((g()) && (((aslg.a(paramFavFileInfo)) && (paramBoolean)) || ((!aslg.a(paramFavFileInfo)) && (!paramBoolean))));
    if (g())
    {
      if (!paramBoolean) {
        break label57;
      }
      aslg.a(paramFavFileInfo);
    }
    for (;;)
    {
      return true;
      label57:
      aslg.b(paramFavFileInfo);
    }
  }
  
  protected arvv a()
  {
    return new aryh(this.jdField_a_of_type_Aryk, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, null, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.b, null, null);
  }
  
  protected String a(FavFileInfo paramFavFileInfo)
  {
    return atbg.a(paramFavFileInfo.c);
  }
  
  protected void a(boolean paramBoolean)
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFAD", "0X800AFAD", 0, 0, "", "", "", "");
  }
  
  protected int b()
  {
    return 1;
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    aryh localaryh = (aryh)this.jdField_a_of_type_Arvv;
    if ((b()) && (localaryh.b())) {
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Atca);
  }
  
  protected void o()
  {
    super.o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((aryh)this.jdField_a_of_type_Arvv).b());
  }
  
  public void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.runOnUiThread(new QfileFavPicFileTabView.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView
 * JD-Core Version:    0.7.0.1
 */