package com.tencent.mobileqq.qipc;

import android.content.Intent;

public class QIPCServiceEx
  extends QIPCService
{
  public void onConfigStartMode(Intent paramIntent)
  {
    paramIntent.putExtra("k_start_mode", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServiceEx
 * JD-Core Version:    0.7.0.1
 */