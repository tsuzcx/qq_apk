package com.tencent.mobileqq.phonecontact.api;

import android.accounts.Account;
import android.net.Uri;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonecontact.data.SimplePhoneContact;
import com.tencent.mobileqq.qroute.annotation.Service;
import friendlist.GetOnlineInfoResp;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IContactSyncService
  extends IRuntimeService
{
  public abstract void deleteSyncContact(String paramString);
  
  public abstract String getMimeTypeByJumpUri(Uri paramUri);
  
  public abstract String getMobileNoByJumpUri(Uri paramUri);
  
  public abstract String getNetworkDescription(GetOnlineInfoResp paramGetOnlineInfoResp);
  
  public abstract SimplePhoneContact getSimplePhoneContactByJumpUri(Uri paramUri);
  
  public abstract String getStatusDescription(GetOnlineInfoResp paramGetOnlineInfoResp);
  
  public abstract String getSyncAccountUin();
  
  public abstract boolean isSyncContactAllowed();
  
  public abstract boolean isSyncSupportForTheDevice();
  
  public abstract void markAccountDeleteByUser(AppInterface paramAppInterface, Account paramAccount);
  
  public abstract void setSyncContactAllowed(boolean paramBoolean);
  
  public abstract boolean syncAllContacts(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.IContactSyncService
 * JD-Core Version:    0.7.0.1
 */