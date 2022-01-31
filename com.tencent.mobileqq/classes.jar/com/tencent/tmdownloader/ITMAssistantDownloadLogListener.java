package com.tencent.tmdownloader;

import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import java.util.ArrayList;

public abstract interface ITMAssistantDownloadLogListener
{
  public abstract void onLog(ArrayList<TMAssistantDownloadLogInfo> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.ITMAssistantDownloadLogListener
 * JD-Core Version:    0.7.0.1
 */