package com.tencent.mobileqq.troop.api.troopcreate;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IRelationFriendsSearchHelper
  extends QRouteApi
{
  public abstract ArrayList<Entity> search(String paramString, AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.IRelationFriendsSearchHelper
 * JD-Core Version:    0.7.0.1
 */