package com.tencent.mobileqq.filemanager.multisave;

import android.os.Bundle;

class DatalineFileSaveModel$1
  implements QFileControlCallback
{
  DatalineFileSaveModel$1(DatalineFileSaveModel paramDatalineFileSaveModel) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, Bundle paramBundle)
  {
    if (this.a.a != null) {
      this.a.a.a(paramInt3);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.a.a != null) {
      this.a.a.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.DatalineFileSaveModel.1
 * JD-Core Version:    0.7.0.1
 */