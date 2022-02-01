package com.tencent.mobileqq.kandian.biz.share;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;

public class ShareToComputerHelper
{
  private DataLineObserver a;
  private AppInterface b;
  private String c;
  
  public ShareToComputerHelper(AppInterface paramAppInterface)
  {
    this.b = paramAppInterface;
    this.a = new ShareToComputerHelper.1(this);
    paramAppInterface = this.b;
    if (paramAppInterface != null) {
      paramAppInterface.addObserver(this.a);
    }
  }
  
  public long a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l2 = 0L;
    if (bool) {
      return 0L;
    }
    Object localObject = this.b;
    long l1 = l2;
    if (localObject != null)
    {
      if (QFileAssistantUtils.a((QQAppInterface)localObject))
      {
        new QFileAssistantForwardManager((QQAppInterface)this.b).a(paramString);
        return 1L;
      }
      localObject = (DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      l1 = l2;
      if (localObject != null)
      {
        this.c = paramString;
        l1 = ((DataLineHandler)localObject).a(paramString, 0).longValue();
      }
    }
    return l1;
  }
  
  public void a()
  {
    AppInterface localAppInterface = this.b;
    if (localAppInterface != null) {
      localAppInterface.removeObserver(this.a);
    }
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ShareToComputerHelper
 * JD-Core Version:    0.7.0.1
 */