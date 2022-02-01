package com.tencent.mobileqq.intervideo.audioroom.colornote;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.launcher.ILauncher;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;

public class QQVoiceLauncher
  implements ILauncher
{
  public int getType()
  {
    return 17301504;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    String str = paramColorNote.getSubType();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("QQVoiceLauncher", 1, "roomId is null!");
      return;
    }
    paramColorNote = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramColorNote instanceof QQAppInterface))
    {
      str = String.format("mqqapi://now/openroom?src_type=app&version=1&bid=88&roomid=%s&fromid=10026&first=2&startsrc=10026&source=37&roomtype=10001&odgameid=100&first_jump_mode=plugin&is_record=2&enter_record_if_finish=0&nowplugin_ext=%s", new Object[] { str, new String(Base64.encode("from_vr=102".getBytes(), 0)) });
      paramContext = JumpParser.a((QQAppInterface)paramColorNote, paramContext, str);
      if (paramContext != null)
      {
        paramContext.a();
        return;
      }
      QLog.e("QQVoiceLauncher", 1, "jumpAction is null!");
      return;
    }
    QLog.e("QQVoiceLauncher", 1, "QQAppInterface is null!");
  }
  
  public void onCreate(Context paramContext, ColorNote paramColorNote, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.colornote.QQVoiceLauncher
 * JD-Core Version:    0.7.0.1
 */