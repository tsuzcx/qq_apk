package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import asth;
import asti;
import asve;
import asvi;
import asvu;
import asvx;
import asvy;
import asvz;
import aswa;
import aswb;
import atcv;
import athc;
import atxd;
import atxx;
import bcst;
import bljn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;

public class QfileFavPicFileTabView
  extends QfileBaseFavFileTabView
{
  static String c = "QfileFavPicFileTabView<FileAssistant>";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new asvz(this);
  asvx jdField_a_of_type_Asvx = new asvy(this);
  private atxx jdField_a_of_type_Atxx = new aswb(this);
  private View.OnClickListener b = new aswa(this);
  
  public QfileFavPicFileTabView(Context paramContext, asvi paramasvi, asve paramasve)
  {
    super(paramContext, paramasvi, paramasve);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = (FavFileInfo)((asth)paramView.getTag()).a;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if (paramBoolean) {
      if (athc.a(paramView))
      {
        athc.b(paramView);
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
        athc.a(paramView);
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
      bljn.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView.a);
    }
  }
  
  private boolean a(FavFileInfo paramFavFileInfo, boolean paramBoolean)
  {
    if (paramFavFileInfo == null) {}
    do
    {
      return false;
      a(paramBoolean);
    } while ((g()) && (((athc.a(paramFavFileInfo)) && (paramBoolean)) || ((!athc.a(paramFavFileInfo)) && (!paramBoolean))));
    if (g())
    {
      if (!paramBoolean) {
        break label57;
      }
      athc.a(paramFavFileInfo);
    }
    for (;;)
    {
      return true;
      label57:
      athc.b(paramFavFileInfo);
    }
  }
  
  protected asti a()
  {
    return new asvu(this.jdField_a_of_type_Asvx, a(), this.jdField_a_of_type_JavaUtilLinkedHashMap, null, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.b, null, null);
  }
  
  protected String a(FavFileInfo paramFavFileInfo)
  {
    return atxd.a(paramFavFileInfo.c);
  }
  
  protected void a(boolean paramBoolean)
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AFAD", "0X800AFAD", 0, 0, "", "", "", "");
  }
  
  protected int b()
  {
    return 1;
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    asvu localasvu = (asvu)this.jdField_a_of_type_Asti;
    if ((b()) && (localasvu.b())) {
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setOnIndexChangedListener(this.jdField_a_of_type_Atxx);
  }
  
  protected void o()
  {
    super.o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setWhetherImageTab(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGridSize(((asvu)this.jdField_a_of_type_Asti).b());
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