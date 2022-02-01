package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil.NotifyDressReady;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.app.QQAppInterface;

class AbsApolloResManager$13
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  AbsApolloResManager$13(AbsApolloResManager paramAbsApolloResManager, ApolloGameBasicEventUtil.NotifyDressReady paramNotifyDressReady, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ApolloDress paramApolloDress, int[] paramArrayOfInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramArrayOfInt = this.a;
    if (paramArrayOfInt != null) {
      paramArrayOfInt.a(this.b, paramString, this.c, this.d, this.e.roleId, this.f, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.13
 * JD-Core Version:    0.7.0.1
 */