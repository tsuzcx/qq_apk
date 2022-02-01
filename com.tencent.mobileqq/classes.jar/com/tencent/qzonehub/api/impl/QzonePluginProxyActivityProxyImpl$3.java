package com.tencent.qzonehub.api.impl;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cooperation.qzone.LocalMultiProcConfig;

final class QzonePluginProxyActivityProxyImpl$3
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBool("qz_safe_mode_no_tip", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzonePluginProxyActivityProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */