package com.tencent.mobileqq.colornote.launcher;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.biz.subscribe.utils.ObjectTransformUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class SubscribeColorNoteLauncher
  implements ILauncher
{
  public int getType()
  {
    return 16908291;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    try
    {
      paramColorNote = paramColorNote.getReserve();
      if (paramColorNote == null) {
        return;
      }
      paramColorNote = (SubscribeColorNoteReserveBean)ObjectTransformUtil.a(paramColorNote);
      if (paramColorNote == null) {
        return;
      }
      CertifiedAccountMeta.StFeed localStFeed = new CertifiedAccountMeta.StFeed();
      localStFeed.mergeFrom(paramColorNote.feedData);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("articleInfo From ColorNote :\n");
      localStringBuilder.append(localStFeed.toString());
      QLog.d("SubscribeColorNoteLauncher", 2, localStringBuilder.toString());
      SubscribeLaucher.a(paramContext, "", localStFeed, new ExtraTypeInfo(paramColorNote.pageType, 9003), null);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void onCreate(Context paramContext, ColorNote paramColorNote, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.SubscribeColorNoteLauncher
 * JD-Core Version:    0.7.0.1
 */