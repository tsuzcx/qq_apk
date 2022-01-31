package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class QQCustomContextMenuDialog
  extends QQCustomDialog
{
  private int jdField_a_of_type_Int = 2130968846;
  QQCustomMenu jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
  
  public QQCustomContextMenuDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramQQCustomMenu == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu = paramQQCustomMenu;
      String[] arrayOfString = new String[paramQQCustomMenu.a()];
      int i = 0;
      while (i < paramQQCustomMenu.a())
      {
        arrayOfString[i] = paramQQCustomMenu.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      paramQQCustomMenu = paramQQCustomMenu.a();
    } while (paramQQCustomMenu == null);
    setTitle(paramQQCustomMenu);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    QQCustomMenuItem localQQCustomMenuItem = this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu.a(paramInt);
    if (localQQCustomMenuItem != null) {
      return localQQCustomMenuItem.a();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomContextMenuDialog
 * JD-Core Version:    0.7.0.1
 */