package com.tencent.mobileqq.filemanager.fileviewer.sendbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.QFileCustomBottomBarManager;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.qroute.QRoute;

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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131377187));
    this.b = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131371932));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692266));
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692531));
    ((StringBuilder)localObject1).append(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount());
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692532));
    Object localObject2 = ((StringBuilder)localObject1).toString();
    long l = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedFileSize();
    if (l > 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131692333));
      ((StringBuilder)localObject1).append(FileUtil.a(l));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    boolean bool;
    if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount() > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    ((TextView)localObject2).setEnabled(bool);
    this.b.setText((CharSequence)localObject1);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    boolean bool = this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.sendbar.PrinterSendBarManager
 * JD-Core Version:    0.7.0.1
 */