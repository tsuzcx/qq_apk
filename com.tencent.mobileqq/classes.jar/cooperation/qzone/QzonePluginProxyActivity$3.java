package cooperation.qzone;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class QzonePluginProxyActivity$3
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBool("qz_safe_mode_no_tip", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.3
 * JD-Core Version:    0.7.0.1
 */