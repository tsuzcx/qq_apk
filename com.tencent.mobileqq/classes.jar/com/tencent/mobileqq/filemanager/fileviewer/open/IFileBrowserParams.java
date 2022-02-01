package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;

public abstract class IFileBrowserParams
{
  ChatMessage a = null;
  SessionInfo b = null;
  boolean c = false;
  boolean d = false;
  boolean e = true;
  
  public ChatMessage a()
  {
    return null;
  }
  
  public void a(SessionInfo paramSessionInfo) {}
  
  public void a(ChatMessage paramChatMessage) {}
  
  public void a(boolean paramBoolean) {}
  
  public SessionInfo b()
  {
    return this.b;
  }
  
  public void b(Bundle paramBundle) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return true;
  }
  
  public abstract Intent i();
  
  boolean j()
  {
    return false;
  }
  
  boolean k()
  {
    return false;
  }
  
  public boolean l()
  {
    return this.d;
  }
  
  public boolean m()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */