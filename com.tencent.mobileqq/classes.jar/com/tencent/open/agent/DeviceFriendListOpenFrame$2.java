package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import bdaf;
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
        bdaf localbdaf = (bdaf)this.this$0.a.getChildAt(i).getTag();
        if ((localbdaf != null) && (this.jdField_a_of_type_JavaLangString.equals(localbdaf.b))) {
          localbdaf.a.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.DeviceFriendListOpenFrame.2
 * JD-Core Version:    0.7.0.1
 */