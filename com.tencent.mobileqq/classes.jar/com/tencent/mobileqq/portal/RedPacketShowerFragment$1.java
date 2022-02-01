package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.springfestival.entry.IPreloadRes.OnDownloadCallback;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

class RedPacketShowerFragment$1
  implements IPreloadRes.OnDownloadCallback
{
  RedPacketShowerFragment$1(RedPacketShowerFragment paramRedPacketShowerFragment, String paramString, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a)) && (this.c.c != null))
    {
      if ((paramBoolean) && ((paramObject instanceof Bitmap)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initUI onDownload success,url = ");
          localStringBuilder.append(paramString);
          QLog.d("RedPacketShowerFragment", 2, localStringBuilder.toString());
        }
        paramObject = (Bitmap)paramObject;
        this.c.c.setImageBitmap(paramObject);
      }
      if (!paramBoolean)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("initUI onDownload failed,url = ");
          paramObject.append(paramString);
          QLog.d("RedPacketShowerFragment", 2, paramObject.toString());
        }
        paramString = null;
        paramObject = this.c.getResources().getDrawable(2130846860);
        if ((paramObject instanceof SkinnableBitmapDrawable)) {
          paramString = ((SkinnableBitmapDrawable)paramObject).getBitmap();
        } else if ((paramObject instanceof BitmapDrawable)) {
          paramString = ((BitmapDrawable)paramObject).getBitmap();
        }
        this.c.c.setImageBitmap(paramString);
      }
      this.b.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketShowerFragment.1
 * JD-Core Version:    0.7.0.1
 */