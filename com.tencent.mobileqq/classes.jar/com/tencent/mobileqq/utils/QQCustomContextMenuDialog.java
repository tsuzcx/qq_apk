package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class QQCustomContextMenuDialog
  extends QQCustomDialog
{
  QQCustomMenu a;
  private int b = 2131624599;
  
  public QQCustomContextMenuDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramQQCustomMenu == null) {
      return;
    }
    this.a = paramQQCustomMenu;
    String[] arrayOfString = new String[paramQQCustomMenu.b()];
    int i = 0;
    while (i < paramQQCustomMenu.b())
    {
      arrayOfString[i] = paramQQCustomMenu.a(i).a();
      i += 1;
    }
    setItems(arrayOfString, paramOnClickListener);
    paramQQCustomMenu = paramQQCustomMenu.c();
    if (paramQQCustomMenu != null) {
      setTitle(paramQQCustomMenu);
    }
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    QQCustomMenuItem localQQCustomMenuItem = this.a.a(paramInt);
    if (localQQCustomMenuItem != null) {
      return localQQCustomMenuItem.b();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomContextMenuDialog
 * JD-Core Version:    0.7.0.1
 */