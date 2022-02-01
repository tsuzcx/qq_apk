package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil.NotifyDressReady;
import com.tencent.mobileqq.app.QQAppInterface;

class AbsApolloResManager$14
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  AbsApolloResManager$14(AbsApolloResManager paramAbsApolloResManager, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady, QQAppInterface paramQQAppInterface, int paramInt, int[] paramArrayOfInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramArrayOfInt = this.a;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.a(this.b, paramString, "", "", this.c, this.d, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.14
 * JD-Core Version:    0.7.0.1
 */