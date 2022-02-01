package com.tencent.mobileqq.tofumsg;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.manager.Manager;

public abstract interface ITofuManagerNew
  extends Manager
{
  public abstract void a();
  
  public abstract void a(Context paramContext, String paramString1, String paramString2);
  
  public abstract void a(BaseSessionInfo paramBaseSessionInfo);
  
  public abstract void a(String paramString);
  
  public abstract boolean a(BeancurdMsg paramBeancurdMsg);
  
  public abstract boolean a(MessageRecord paramMessageRecord);
  
  public abstract void b(BaseSessionInfo paramBaseSessionInfo);
  
  public abstract void b(@NonNull BeancurdMsg paramBeancurdMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.ITofuManagerNew
 * JD-Core Version:    0.7.0.1
 */