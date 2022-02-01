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
  private TextView g;
  private TextView h;
  private View.OnClickListener i = new PrinterSendBarManager.1(this);
  
  public PrinterSendBarManager(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    c();
  }
  
  private void c()
  {
    this.g = ((TextView)this.c.a(2131445568));
    this.h = ((TextView)this.c.a(2131439377));
    this.g.setOnClickListener(this.i);
  }
  
  public void a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.a.getString(2131889253));
    ((StringBuilder)localObject1).append(this.a.getString(2131889554));
    ((StringBuilder)localObject1).append(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount());
    ((StringBuilder)localObject1).append(this.a.getString(2131889555));
    Object localObject2 = ((StringBuilder)localObject1).toString();
    long l = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedFileSize();
    if (l > 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.a.getString(2131889321));
      ((StringBuilder)localObject1).append(FileUtil.a(l));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    this.g.setText((CharSequence)localObject2);
    localObject2 = this.g;
    boolean bool;
    if (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedCount() > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    ((TextView)localObject2).setEnabled(bool);
    this.h.setText((CharSequence)localObject1);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    boolean bool = this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.sendbar.PrinterSendBarManager
 * JD-Core Version:    0.7.0.1
 */