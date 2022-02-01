package com.tencent.mobileqq.richmedia.conn;

import com.tencent.mobileqq.richmedia.server.ChannelStateManager;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;

class ConnManager$1
  implements Runnable
{
  ConnManager$1(ConnManager paramConnManager, PeakAudioTransHandler paramPeakAudioTransHandler, long paramLong, HostInfo paramHostInfo) {}
  
  public void run()
  {
    ConnManager.a(this.this$0).b(12);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakAudioTransHandler.notifyUI(1, true, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.e), Integer.valueOf(2000), this.jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo });
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakAudioTransHandler.a(this.jdField_a_of_type_Long, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.conn.ConnManager.1
 * JD-Core Version:    0.7.0.1
 */