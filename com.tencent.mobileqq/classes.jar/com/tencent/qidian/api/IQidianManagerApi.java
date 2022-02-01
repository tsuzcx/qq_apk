package com.tencent.qidian.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IQidianManagerApi
  extends IRuntimeService
{
  public abstract void addQidianShareAction(Context paramContext, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList);
  
  public abstract void addShowUin(String paramString1, String paramString2);
  
  public abstract boolean filterQidianMasterSearch(Friends paramFriends, int paramInt);
  
  public abstract String getShowUin(String paramString);
  
  public abstract boolean isCrmMaster(int paramInt);
  
  public abstract boolean isEmanMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isNeedClickReply(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean isQidianAio(String paramString);
  
  public abstract boolean isQidianExt(int paramInt);
  
  public abstract boolean isQidianMaster(int paramInt);
  
  public abstract boolean isQidianMaster(String paramString);
  
  public abstract void shareToQidianOrQiye(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, boolean paramBoolean);
  
  public abstract void updateQidianAccountType(int paramInt, String paramString);
  
  public abstract void updateQidianAccountType(Friends paramFriends);
  
  public abstract void updateQidianAccountType(Friends[] paramArrayOfFriends);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.api.IQidianManagerApi
 * JD-Core Version:    0.7.0.1
 */