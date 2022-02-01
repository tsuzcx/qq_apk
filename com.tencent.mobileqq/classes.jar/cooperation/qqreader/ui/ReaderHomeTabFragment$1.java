package cooperation.qqreader.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qqreader.utils.Config.UserConfig;
import cooperation.qqreader.view.ReaderTabBarView;

class ReaderHomeTabFragment$1
  extends BroadcastReceiver
{
  ReaderHomeTabFragment$1(ReaderHomeTabFragment paramReaderHomeTabFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Config.UserConfig.c(this.a.getActivity());
    ReaderHomeTabFragment.a(this.a).setUnReadMsg(1, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderHomeTabFragment.1
 * JD-Core Version:    0.7.0.1
 */