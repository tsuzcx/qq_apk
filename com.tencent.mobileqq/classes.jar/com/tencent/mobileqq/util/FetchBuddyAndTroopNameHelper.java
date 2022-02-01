package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class FetchBuddyAndTroopNameHelper
{
  private QQAppInterface a;
  private FetchInfoListManager b = null;
  
  public FetchBuddyAndTroopNameHelper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private FetchInfoListManager b()
  {
    FetchInfoListManager localFetchInfoListManager = new FetchInfoListManager(new FetchBuddyAndTroopNameHelper.1(this));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createFetchInfoListManager fm: ");
      localStringBuilder.append(localFetchInfoListManager);
      QLog.i("FetchInfoListManager", 2, localStringBuilder.toString());
    }
    return localFetchInfoListManager;
  }
  
  public void a()
  {
    FetchInfoListManager localFetchInfoListManager = this.b;
    if (localFetchInfoListManager != null)
    {
      localFetchInfoListManager.a();
      this.b = null;
    }
  }
  
  public void a(String paramString)
  {
    if (this.b == null) {
      this.b = b();
    }
    this.b.a(2, paramString, null, null, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (this.b == null) {
      this.b = b();
    }
    this.b.a(3, paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void b(String paramString)
  {
    if (this.b == null) {
      this.b = b();
    }
    this.b.a(1, paramString, null, null, null);
  }
  
  public void c(String paramString)
  {
    if (this.b == null) {
      this.b = b();
    }
    this.b.a(4, paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper
 * JD-Core Version:    0.7.0.1
 */