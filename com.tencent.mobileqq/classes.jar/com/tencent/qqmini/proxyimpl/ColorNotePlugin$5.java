package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class ColorNotePlugin$5
  implements Runnable
{
  ColorNotePlugin$5(ColorNotePlugin paramColorNotePlugin, IColorNoteController paramIColorNoteController, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onCannotAdd();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin.5
 * JD-Core Version:    0.7.0.1
 */