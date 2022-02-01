package com.tencent.mobileqq.listentogether.ui;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class BaseListenTogetherPanel$1
  extends AvatarObserver
{
  BaseListenTogetherPanel$1(BaseListenTogetherPanel paramBaseListenTogetherPanel) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equalsIgnoreCase(this.a.a.c))) {
      this.a.a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.1
 * JD-Core Version:    0.7.0.1
 */