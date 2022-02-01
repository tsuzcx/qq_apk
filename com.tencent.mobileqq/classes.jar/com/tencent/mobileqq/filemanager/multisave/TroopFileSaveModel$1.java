package com.tencent.mobileqq.filemanager.multisave;

import android.os.Bundle;

class TroopFileSaveModel$1
  implements QFileControlCallback
{
  TroopFileSaveModel$1(TroopFileSaveModel paramTroopFileSaveModel) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.TroopFileSaveModel.1
 * JD-Core Version:    0.7.0.1
 */