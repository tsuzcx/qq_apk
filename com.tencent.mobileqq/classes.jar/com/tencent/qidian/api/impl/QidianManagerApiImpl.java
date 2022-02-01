package com.tencent.qidian.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.api.IQidianManagerApi;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class QidianManagerApiImpl
  implements IQidianManagerApi
{
  private QQAppInterface app;
  
  public void addQidianShareAction(Context paramContext, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    QidianManager.a(paramContext, paramArrayList);
  }
  
  public void addShowUin(String paramString1, String paramString2)
  {
    QidianManager.a(this.app, paramString1, paramString2);
  }
  
  public boolean filterQidianMasterSearch(Friends paramFriends, int paramInt)
  {
    return QidianManager.a(this.app, paramFriends, paramInt);
  }
  
  public String getShowUin(String paramString)
  {
    return QidianManager.b(this.app, paramString);
  }
  
  public boolean isCrmMaster(int paramInt)
  {
    return QidianManager.c(paramInt);
  }
  
  public boolean isEmanMsg(MessageRecord paramMessageRecord)
  {
    return QidianManager.a(this.app, paramMessageRecord);
  }
  
  public boolean isNeedClickReply(String paramString1, String paramString2, String paramString3)
  {
    return QidianManager.a(paramString1, paramString2, paramString3);
  }
  
  public boolean isQidianAio(String paramString)
  {
    return QidianManager.b(this.app, paramString);
  }
  
  public boolean isQidianExt(int paramInt)
  {
    return QidianManager.a(paramInt);
  }
  
  public boolean isQidianMaster(int paramInt)
  {
    return QidianManager.b(paramInt);
  }
  
  public boolean isQidianMaster(String paramString)
  {
    return QidianManager.a(this.app, paramString);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((QQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void shareToQidianOrQiye(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, boolean paramBoolean)
  {
    QidianManager.a(paramActivity, paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt2, paramBoolean);
  }
  
  public void updateQidianAccountType(int paramInt, String paramString)
  {
    QidianManager.a(this.app, paramInt, paramString);
  }
  
  public void updateQidianAccountType(Friends paramFriends)
  {
    QidianManager.a(this.app, paramFriends);
  }
  
  public void updateQidianAccountType(Friends[] paramArrayOfFriends)
  {
    QidianManager.a(this.app, paramArrayOfFriends);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.api.impl.QidianManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */