package com.tencent.mobileqq.troopgift;

import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;

class TroopGiftActionButton$2
  implements Runnable
{
  TroopGiftActionButton$2(TroopGiftActionButton paramTroopGiftActionButton, String paramString) {}
  
  public void run()
  {
    int i;
    if (this.this$0.d == null)
    {
      this.this$0.d = new AnimationDrawable();
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i < 7) {
        localObject = String.format("%sInteractGiftButton/image_0%d.png", new Object[] { TroopGiftUtil.a(this.a), Integer.valueOf(i) });
      }
      try
      {
        this.this$0.d.addFrame(new BitmapDrawable(BitmapFactory.decodeFile((String)localObject)), 50);
        label82:
        i += 1;
        continue;
        this.this$0.c.setImageDrawable(this.this$0.d);
        this.this$0.d.setOneShot(true);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        TroopGiftActionButton localTroopGiftActionButton = this.this$0;
        localTroopGiftActionButton.addView(localTroopGiftActionButton.c, (ViewGroup.LayoutParams)localObject);
        this.this$0.d.start();
        this.this$0.c.setVisibility(0);
        this.this$0.a.postDelayed(new TroopGiftActionButton.2.1(this), 350L);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label82;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftActionButton.2
 * JD-Core Version:    0.7.0.1
 */