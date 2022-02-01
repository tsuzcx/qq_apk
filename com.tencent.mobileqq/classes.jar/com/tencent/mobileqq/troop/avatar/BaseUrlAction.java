package com.tencent.mobileqq.troop.avatar;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import java.net.HttpURLConnection;
import java.util.List;

public abstract class BaseUrlAction
{
  protected Bundle a;
  protected HeaderSetting b;
  
  public abstract int a(HttpURLConnection paramHttpURLConnection, TroopUploadingThread.UploadState paramUploadState, UploadItem paramUploadItem);
  
  public HeaderSetting a()
  {
    return this.b;
  }
  
  public abstract List<String> a(AppInterface paramAppInterface);
  
  public void a(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public abstract void b(AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.BaseUrlAction
 * JD-Core Version:    0.7.0.1
 */