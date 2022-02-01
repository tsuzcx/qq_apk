package com.tencent.mobileqq.filemanager.fileviewer.sendbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.QFileCustomBottomBarManager;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;

public class PrinterSendBarManager
  extends QFileCustomBottomBarManager
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new PrinterSendBarManager.1(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public PrinterSendBarManager(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131377759));
    this.b = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131372347));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131692338) + this.jdField_a_of_type_AndroidContentContext.getString(2131692579) + FMDataCache.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692580);
    long l = FMDataCache.d();
    String str = "";
    if (l > 0L) {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692405) + FileUtil.a(l);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (FMDataCache.b() > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject).setEnabled(bool);
      this.b.setText(str);
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Boolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.sendbar.PrinterSendBarManager
 * JD-Core Version:    0.7.0.1
 */