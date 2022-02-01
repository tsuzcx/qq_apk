package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class ColorNotePlugin$4
  implements Runnable
{
  ColorNotePlugin$4(ColorNotePlugin paramColorNotePlugin, IColorNoteController paramIColorNoteController, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.insertColorNote();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.4
 * JD-Core Version:    0.7.0.1
 */