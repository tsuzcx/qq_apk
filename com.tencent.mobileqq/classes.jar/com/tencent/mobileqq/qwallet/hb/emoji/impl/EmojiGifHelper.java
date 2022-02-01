package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qwallet.temp.IQwTemp;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.emoji.ConvertParam;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class EmojiGifHelper
{
  private static volatile EmojiGifHelper a;
  private SparseArray<EmojiGifHelper.EmojiInfo> b = new SparseArray();
  
  public static EmojiGifHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new EmojiGifHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(EmojiGifHelper.EmojiInfo paramEmojiInfo)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity == null) {
      return;
    }
    if ((paramEmojiInfo != null) && (paramEmojiInfo.a != null))
    {
      if (TextUtils.isEmpty(paramEmojiInfo.d)) {
        return;
      }
      Intent localIntent = new Intent(localQBaseActivity, ((IQwTemp)QRoute.api(IQwTemp.class)).getSendPhotoActivity());
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramEmojiInfo.d);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      localIntent.putExtra("PhotoConst.PHOTO_COUNT", localArrayList.size());
      localIntent.putExtra("uin", paramEmojiInfo.a.b);
      localIntent.putExtra("uintype", paramEmojiInfo.a.a);
      localIntent.putExtra("troop_uin", paramEmojiInfo.a.c);
      localIntent.putExtra("key_confess_topicid", paramEmojiInfo.a.v);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("entrance", paramEmojiInfo.a.s);
      if (localArrayList.size() == 1) {
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
      }
      localQBaseActivity.startActivity(localIntent);
      this.b.remove(paramEmojiInfo.b);
    }
  }
  
  public void a(int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.b.get(paramInt);
    if (localEmojiInfo != null) {
      localEmojiInfo.a();
    }
    this.b.remove(paramInt);
  }
  
  public void a(BaseSessionInfo paramBaseSessionInfo, int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = new EmojiGifHelper.EmojiInfo();
    localEmojiInfo.a = paramBaseSessionInfo;
    localEmojiInfo.b = paramInt;
    this.b.put(paramInt, localEmojiInfo);
  }
  
  public void a(ConvertParam arg1, EmojiGifHelper.CompositeTask paramCompositeTask)
  {
    if (??? != null)
    {
      if (paramCompositeTask == null) {
        return;
      }
      EmojiGifHelper.EmojiInfo localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.b.get(???.tag);
      if (localEmojiInfo != null) {
        synchronized (localEmojiInfo.e)
        {
          if (localEmojiInfo.c != null) {
            localEmojiInfo.c.a();
          }
          localEmojiInfo.c = paramCompositeTask;
          paramCompositeTask.d = localEmojiInfo;
          return;
        }
      }
    }
  }
  
  public void a(ConvertParam paramConvertParam, EmojiGifHelper.OnConvertListener paramOnConvertListener)
  {
    if (paramConvertParam == null)
    {
      if (paramOnConvertListener != null) {
        paramOnConvertListener.a(false, null);
      }
      return;
    }
    paramOnConvertListener = new EmojiGifHelper.CompositeTask(this, paramConvertParam, paramOnConvertListener);
    a(paramConvertParam, paramOnConvertListener);
    paramOnConvertListener.run();
  }
  
  public void b(int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.b.get(paramInt);
    if (localEmojiInfo != null) {
      localEmojiInfo.b();
    }
  }
  
  public void c(int paramInt)
  {
    EmojiGifHelper.EmojiInfo localEmojiInfo = (EmojiGifHelper.EmojiInfo)this.b.get(paramInt);
    if (localEmojiInfo == null) {
      return;
    }
    byte[] arrayOfByte = localEmojiInfo.e;
    if (localEmojiInfo != null) {}
    try
    {
      if (TextUtils.isEmpty(localEmojiInfo.d))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmojiGifHelper", 2, "trySendPicToAIO waiting to send");
        }
        localEmojiInfo.f = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmojiGifHelper", 2, "trySendPicToAIO immediately send");
      }
      if ((localEmojiInfo != null) && (!TextUtils.isEmpty(localEmojiInfo.d))) {
        a(localEmojiInfo);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiGifHelper
 * JD-Core Version:    0.7.0.1
 */