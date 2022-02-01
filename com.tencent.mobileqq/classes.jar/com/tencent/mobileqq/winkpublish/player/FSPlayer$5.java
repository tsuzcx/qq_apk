package com.tencent.mobileqq.winkpublish.player;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.util.FSTransUtils;

class FSPlayer$5
  implements Runnable
{
  FSPlayer$5(FSPlayer paramFSPlayer, String paramString) {}
  
  public void run()
  {
    Context localContext = FSTransUtils.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131913545));
    localStringBuilder.append(this.a);
    QQToast.makeText(localContext, 1, localStringBuilder.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.player.FSPlayer.5
 * JD-Core Version:    0.7.0.1
 */