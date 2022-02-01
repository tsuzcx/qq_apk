package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;

class TVKVideoController$2
  implements Runnable
{
  TVKVideoController$2(TVKVideoController paramTVKVideoController) {}
  
  public void run()
  {
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController.2
 * JD-Core Version:    0.7.0.1
 */