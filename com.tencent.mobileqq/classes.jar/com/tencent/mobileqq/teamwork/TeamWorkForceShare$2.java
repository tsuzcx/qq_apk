package com.tencent.mobileqq.teamwork;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import ayog;
import bbdr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TeamWorkForceShare$2
  implements Runnable
{
  TeamWorkForceShare$2(TeamWorkForceShare paramTeamWorkForceShare, boolean paramBoolean) {}
  
  public void run()
  {
    String str = ayog.d(TeamWorkForceShare.a(this.this$0));
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    localObject = bbdr.a(str, (BitmapFactory.Options)localObject);
    if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
    {
      QLog.d(TeamWorkForceShare.a(), 1, "share to wx, image decode failed, url = " + TeamWorkForceShare.a(this.this$0));
      return;
    }
    ThreadManager.getUIHandler().post(new TeamWorkForceShare.2.1(this, str, (Bitmap)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.2
 * JD-Core Version:    0.7.0.1
 */