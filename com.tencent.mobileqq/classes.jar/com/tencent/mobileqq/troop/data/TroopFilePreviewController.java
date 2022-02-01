package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class TroopFilePreviewController
  extends FilePreViewControllerBase
{
  QQAppInterface b;
  TroopFileStatusInfo c;
  long d;
  BizTroopObserver e = null;
  
  public TroopFilePreviewController(QQAppInterface paramQQAppInterface, long paramLong, TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    this.b = paramQQAppInterface;
    this.c = paramTroopFileStatusInfo;
    this.d = paramLong;
    d();
  }
  
  private void d()
  {
    this.e = new TroopFilePreviewController.1(this);
    this.b.addObserver(this.e);
  }
  
  public boolean a()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.b, this.d);
    if (localTroopFileTransferManager == null) {
      return false;
    }
    if (this.c.a != null) {
      localTroopFileTransferManager.f(this.c.a);
    } else {
      localTroopFileTransferManager.a(this.c.r, this.c.t, this.c.u);
    }
    return true;
  }
  
  public void b()
  {
    BizTroopObserver localBizTroopObserver = this.e;
    if (localBizTroopObserver != null) {
      this.b.removeObserver(localBizTroopObserver);
    }
  }
  
  public int c()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFilePreviewController
 * JD-Core Version:    0.7.0.1
 */