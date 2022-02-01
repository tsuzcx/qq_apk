package com.tencent.mobileqq.troop.troopsetting.activity;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.util.List;

class TroopSettingActivity$22
  implements Runnable
{
  TroopSettingActivity$22(TroopSettingActivity paramTroopSettingActivity, long paramLong) {}
  
  public void run()
  {
    int j = this.this$0.w.size();
    int i = 0;
    while (i < j)
    {
      ImageView localImageView = (ImageView)this.this$0.w.get(i);
      Object localObject = (String)localImageView.getTag();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          long l = Long.valueOf((String)localObject).longValue();
          if (l == this.a)
          {
            localObject = BaseImageUtil.m();
            localObject = FaceDrawable.getFaceDrawableFrom(TroopSettingActivity.a(this.this$0), 1, Long.toString(this.a), 3, (Drawable)localObject, (Drawable)localObject, 4);
            this.this$0.runOnUiThread(new TroopSettingActivity.22.1(this, localImageView, (FaceDrawable)localObject));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.22
 * JD-Core Version:    0.7.0.1
 */