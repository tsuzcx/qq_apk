package com.tencent.mobileqq.teamwork;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TeamWorkForceShare$2
  implements Runnable
{
  TeamWorkForceShare$2(TeamWorkForceShare paramTeamWorkForceShare, boolean paramBoolean) {}
  
  public void run()
  {
    String str = AbsDownloader.getFilePath(TeamWorkForceShare.b(this.this$0));
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    localObject = ImageUtil.a(str, (BitmapFactory.Options)localObject);
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      ThreadManager.getUIHandler().post(new TeamWorkForceShare.2.1(this, str, (Bitmap)localObject));
      return;
    }
    str = TeamWorkForceShare.d();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("share to wx, image decode failed, url = ");
    ((StringBuilder)localObject).append(TeamWorkForceShare.b(this.this$0));
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.2
 * JD-Core Version:    0.7.0.1
 */