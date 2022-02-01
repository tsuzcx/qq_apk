package com.tencent.mobileqq.phonecontact.data;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonecontact.constant.ContactSyncConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class ContactOperation
{
  private static String d = ContactSyncConstants.a;
  private List<ContentProviderOperation> a;
  private AppInterface b;
  private ContentValues c;
  private long e;
  private boolean f;
  private int g;
  
  private ContactOperation(AppInterface paramAppInterface, List<ContentProviderOperation> paramList)
  {
    this.a = paramList;
    this.b = paramAppInterface;
    this.c = new ContentValues();
  }
  
  private ContactOperation(AppInterface paramAppInterface, List<ContentProviderOperation> paramList, long paramLong)
  {
    this(paramAppInterface, paramList);
    this.e = paramLong;
    this.f = false;
  }
  
  private ContactOperation(AppInterface paramAppInterface, List<ContentProviderOperation> paramList, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this(paramAppInterface, paramList);
    this.f = true;
    this.g = paramList.size();
    paramAppInterface = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build()).withValue("aggregation_mode", Integer.valueOf(0)).withValue("account_type", "com.tencent.mobileqq.account").withValue("account_name", paramString1).withValue("sourceid", paramString2).withValue("sync1", paramString3).withValue("sync2", paramString4).withValue("sync3", Integer.valueOf(paramInt1));
    this.a.add(paramAppInterface.build());
  }
  
  public static ContactOperation a(AppInterface paramAppInterface, List<ContentProviderOperation> paramList, long paramLong)
  {
    return new ContactOperation(paramAppInterface, paramList, paramLong);
  }
  
  public static ContactOperation a(AppInterface paramAppInterface, List<ContentProviderOperation> paramList, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    return new ContactOperation(paramAppInterface, paramList, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2);
  }
  
  private void a()
  {
    if (!this.f) {
      this.c.put("raw_contact_id", Long.valueOf(this.e));
    }
    ContentProviderOperation.Builder localBuilder = b();
    localBuilder.withValues(this.c);
    if (this.f) {
      localBuilder.withValueBackReference("raw_contact_id", this.g);
    }
    this.a.add(localBuilder.build());
  }
  
  private void a(Uri paramUri)
  {
    paramUri = b(paramUri);
    paramUri.withValues(this.c);
    this.a.add(paramUri.build());
  }
  
  private static ContentProviderOperation.Builder b()
  {
    return ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", d).build()).withYieldAllowed(true);
  }
  
  private static ContentProviderOperation.Builder b(Uri paramUri)
  {
    return ContentProviderOperation.newUpdate(paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", d).build()).withYieldAllowed(true);
  }
  
  public ContactOperation a(String paramString)
  {
    this.c.clear();
    this.c.put("mimetype", "vnd.android.cursor.item/name");
    this.c.put("data1", paramString);
    a();
    return this;
  }
  
  public ContactOperation a(String paramString, Uri paramUri)
  {
    this.c.clear();
    this.c.put("data1", paramString);
    a(paramUri);
    return this;
  }
  
  public ContactOperation b(String paramString)
  {
    this.c.clear();
    this.c.put("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile");
    this.c.put("data1", paramString);
    this.c.put("data2", "QQ");
    this.c.put("data3", this.b.getApp().getString(2131896675));
    a();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.data.ContactOperation
 * JD-Core Version:    0.7.0.1
 */