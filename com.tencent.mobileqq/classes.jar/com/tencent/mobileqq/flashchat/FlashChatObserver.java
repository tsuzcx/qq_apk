package com.tencent.mobileqq.flashchat;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class FlashChatObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b() {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 970: 
      a();
      return;
    case 969: 
      b();
      return;
    case 968: 
      a(paramBoolean, paramBundle);
      return;
    }
    b(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatObserver
 * JD-Core Version:    0.7.0.1
 */