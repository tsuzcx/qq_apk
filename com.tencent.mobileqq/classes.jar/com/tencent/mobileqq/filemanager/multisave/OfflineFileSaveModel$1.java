package com.tencent.mobileqq.filemanager.multisave;

import android.os.Bundle;

class OfflineFileSaveModel$1
  implements QFileControlCallback
{
  OfflineFileSaveModel$1(OfflineFileSaveModel paramOfflineFileSaveModel) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, Bundle paramBundle)
  {
    if (this.a.c != null) {
      this.a.c.a(paramInt3);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.a.c != null) {
      this.a.c.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.OfflineFileSaveModel.1
 * JD-Core Version:    0.7.0.1
 */