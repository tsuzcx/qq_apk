package com.tencent.open.downloadnew;

import android.os.Bundle;
import bhzm;
import bicg;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.util.Map;

public class DownloaderGetCodeClient$1
  implements Runnable
{
  public DownloaderGetCodeClient$1(bicg parambicg, String paramString, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    if (((Boolean)bicg.a(this.this$0).get(bicg.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))).booleanValue())
    {
      bhzm.c("DownloaderGetCodeClient", "last request not back,retry ......");
      QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", this.jdField_a_of_type_AndroidOsBundle, bicg.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloaderGetCodeClient.1
 * JD-Core Version:    0.7.0.1
 */