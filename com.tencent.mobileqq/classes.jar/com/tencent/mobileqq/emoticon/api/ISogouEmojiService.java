package com.tencent.mobileqq.emoticon.api;

import android.app.Activity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emoticon.ISogouEmoji;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISogouEmojiService
  extends QRouteApi
{
  public abstract ISogouEmoji createSogouEmoji(BaseAIOContext paramBaseAIOContext, Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.ISogouEmojiService
 * JD-Core Version:    0.7.0.1
 */