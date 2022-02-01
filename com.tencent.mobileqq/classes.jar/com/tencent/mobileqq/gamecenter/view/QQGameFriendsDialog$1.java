package com.tencent.mobileqq.gamecenter.view;

import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import java.util.ArrayList;

class QQGameFriendsDialog$1
  implements IApolloExtensionObserver
{
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    QQGameFriendsDialog.a(this.a, (ArrayList)paramObject);
    QQGameFriendsDialog.a(this.a).a(QQGameFriendsDialog.a(this.a));
    QQGameFriendsDialog.a(this.a).notifyDataSetChanged();
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 31) {
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGameFriendsDialog.1
 * JD-Core Version:    0.7.0.1
 */