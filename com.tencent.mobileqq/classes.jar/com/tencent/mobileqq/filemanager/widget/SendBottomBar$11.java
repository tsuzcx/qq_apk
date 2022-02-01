package com.tencent.mobileqq.filemanager.widget;

import android.content.Intent;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import java.util.ArrayList;

class SendBottomBar$11
  implements FMDialogUtil.FMDialogInterface
{
  SendBottomBar$11(SendBottomBar paramSendBottomBar) {}
  
  public void a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(FMDataCache.g());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    SendBottomBar.c(this.a).setResult(-1, localIntent);
    SendBottomBar.c(this.a).finish();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.11
 * JD-Core Version:    0.7.0.1
 */