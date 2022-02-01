package com.tencent.mobileqq.colornote.launcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;

public class MusicLauncher
  implements ILauncher
{
  private void a(Intent paramIntent, ColorNote paramColorNote)
  {
    String str = paramIntent.getStringExtra("url");
    if ((!TextUtils.isEmpty(str)) && (str.matches("^https?://fm\\.qzone\\.qq\\.com/.*")))
    {
      paramColorNote = paramColorNote.getReserve();
      if ((paramColorNote != null) && (paramColorNote.length > 0)) {
        paramIntent.putExtra("url", new String(paramColorNote));
      }
    }
  }
  
  public int getType()
  {
    return 16973824;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return;
    }
    if (paramColorNote.getServiceType() != 16973824) {
      return;
    }
    Intent localIntent = QQPlayerService.a();
    if (localIntent != null)
    {
      a(localIntent, paramColorNote);
      localIntent.addFlags(268435456);
      localIntent.addFlags(536870912);
      localIntent.addFlags(67108864);
      paramContext.startActivity(localIntent);
    }
  }
  
  public void onCreate(Context paramContext, ColorNote paramColorNote, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.MusicLauncher
 * JD-Core Version:    0.7.0.1
 */