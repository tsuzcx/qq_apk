package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.RelatedEmoticonSearchHandler;
import com.tencent.mobileqq.emosm.api.IEmoticonBusinessProxyApi;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;

public class EmoticonBusinessProxyApiImpl
  implements IEmoticonBusinessProxyApi
{
  public String getCameraEmoHandlerImplClassName()
  {
    return CameraEmoRoamingHandler.class.getName();
  }
  
  public String getEmoticonHandlerImplClassName()
  {
    return EmoticonHandler.class.getName();
  }
  
  public String getFavEmoHandlerImplClassName()
  {
    return FavEmoRoamingHandler.class.getName();
  }
  
  public String getRelatedEmoHandlerImplClassName()
  {
    return RelatedEmoticonSearchHandler.class.getName();
  }
  
  public String getVipComicMqqHandlerImplClassName()
  {
    return VipComicMqqHandler.class.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonBusinessProxyApiImpl
 * JD-Core Version:    0.7.0.1
 */