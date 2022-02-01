package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import com.tencent.mobileqq.widget.QQVideoView;

class QWalletCommonJsPlugin$QWVideoJsPlugin$MyVideoView
  extends QQVideoView
{
  static final int FLAG_PAUSE_BY_USER = 4;
  static final int FLAG_PLAY = 3;
  static final int FLAG_READY = 2;
  static final int FLAG_RELEASE = 0;
  int mCurrTime = 0;
  int playState = 0;
  
  public QWalletCommonJsPlugin$QWVideoJsPlugin$MyVideoView(QWalletCommonJsPlugin.QWVideoJsPlugin paramQWVideoJsPlugin, Context paramContext)
  {
    super(paramContext);
  }
  
  public void release()
  {
    this.playState = 0;
    this.mCurrTime = 0;
    super.release();
  }
  
  void setFlag(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.playState = (1 << paramInt | this.playState);
      return;
    }
    this.playState = ((1 << paramInt ^ 0xFFFFFFFF) & this.playState);
  }
  
  boolean testFlag(int paramInt)
  {
    return (1 << paramInt & this.playState) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView
 * JD-Core Version:    0.7.0.1
 */