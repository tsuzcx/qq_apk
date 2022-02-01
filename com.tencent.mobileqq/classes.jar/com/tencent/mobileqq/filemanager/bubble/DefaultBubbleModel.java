package com.tencent.mobileqq.filemanager.bubble;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class DefaultBubbleModel
  extends QFileBubbleModel
{
  public DefaultBubbleModel(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    QLog.e("DefaultBubbleModel", 1, "error, this is a default bubble model.");
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, View paramView) {}
  
  protected void a(ChatMessage paramChatMessage) {}
  
  public boolean a()
  {
    return false;
  }
  
  public QFileBubblePauseHandler b()
  {
    return null;
  }
  
  public List<Integer> b(int paramInt)
  {
    return null;
  }
  
  public QFileBubbleDownloadHandler c()
  {
    return null;
  }
  
  public List<Integer> c(int paramInt)
  {
    return null;
  }
  
  public int d()
  {
    return 0;
  }
  
  public int e()
  {
    return 0;
  }
  
  public String f()
  {
    return null;
  }
  
  public long g()
  {
    return 0L;
  }
  
  public String h()
  {
    return null;
  }
  
  public int i()
  {
    return 0;
  }
  
  public int j()
  {
    return 0;
  }
  
  public int k()
  {
    return 0;
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.DefaultBubbleModel
 * JD-Core Version:    0.7.0.1
 */