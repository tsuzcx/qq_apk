package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import bjme;
import com.tencent.mobileqq.widget.PinnedDividerListView;

class DeviceFriendListOpenFrame$2
  implements Runnable
{
  DeviceFriendListOpenFrame$2(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    int j = this.this$0.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        bjme localbjme = (bjme)this.this$0.a.getChildAt(i).getTag();
        if ((localbjme != null) && (this.jdField_a_of_type_JavaLangString.equals(localbjme.b))) {
          localbjme.a.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.DeviceFriendListOpenFrame.2
 * JD-Core Version:    0.7.0.1
 */