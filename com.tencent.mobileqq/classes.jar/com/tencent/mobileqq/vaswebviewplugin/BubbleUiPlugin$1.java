package com.tencent.mobileqq.vaswebviewplugin;

import anad;
import anah;
import android.os.Bundle;
import anfc;

class BubbleUiPlugin$1
  implements Runnable
{
  BubbleUiPlugin$1(BubbleUiPlugin paramBubbleUiPlugin) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("optype", "Bubble");
    localBundle.putString("opname", "Clk_bubble_setting");
    localBundle = anah.a("reportActionCount", "", this.this$0.mOnRemoteResp.key, localBundle);
    anfc.a().a(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */