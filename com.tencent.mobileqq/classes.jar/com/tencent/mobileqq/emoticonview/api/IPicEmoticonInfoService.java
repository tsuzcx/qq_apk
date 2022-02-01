package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.Serializable;

@QAPI(process={""})
public abstract interface IPicEmoticonInfoService
  extends QRouteApi
{
  public abstract void send(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, Serializable paramSerializable);
  
  public abstract void startSoundDrawablePlay(URLDrawable paramURLDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IPicEmoticonInfoService
 * JD-Core Version:    0.7.0.1
 */