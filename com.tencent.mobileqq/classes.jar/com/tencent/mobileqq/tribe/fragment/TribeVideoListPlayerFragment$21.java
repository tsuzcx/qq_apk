package com.tencent.mobileqq.tribe.fragment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.playvideo.BaseTribeVideoItem;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoItem;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.ArrayList;

class TribeVideoListPlayerFragment$21
  extends Handler
{
  TribeVideoListPlayerFragment$21(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (TribeVideoListPlayerFragment.BaseVideoViewHolder)paramMessage.obj;
    long l1;
    long l2;
    TribeVideoItem localTribeVideoItem;
    if (this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying())
    {
      l1 = this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
      l2 = this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
      paramMessage.jdField_a_of_type_AndroidWidgetSeekBar.setMax((int)l1);
      paramMessage.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)l2);
      this.a.b(paramMessage);
      paramMessage = (BaseTribeVideoItem)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramMessage.jdField_a_of_type_Int);
      if ((paramMessage instanceof TribeVideoItem))
      {
        localTribeVideoItem = (TribeVideoItem)paramMessage;
        if ((!this.a.d) && (l2 >= l1 * 0.8D))
        {
          this.a.d = true;
          if (localTribeVideoItem.h == 0) {
            break label271;
          }
          paramMessage = "" + localTribeVideoItem.h;
          if (localTribeVideoItem.c != 31) {
            break label277;
          }
        }
      }
    }
    label271:
    label277:
    for (String str = "1";; str = "2")
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv_active", this.a.c, 0, localTribeVideoItem.d, "" + localTribeVideoItem.b, paramMessage, str);
      if (this.a.h < l1 - 100L) {
        this.a.h = ((int)l2);
      }
      return;
      paramMessage = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.21
 * JD-Core Version:    0.7.0.1
 */