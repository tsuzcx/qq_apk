package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;

public class SystemAndEmojiEmoticonPanelWithActionBar
  extends SystemAndEmojiEmoticonPanel
{
  protected EmoticonCallback mCallback;
  protected View mSendBtn;
  
  public SystemAndEmojiEmoticonPanelWithActionBar(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    super(paramContext, paramEmoticonCallback);
  }
  
  protected int getLayoutId()
  {
    return 2131562902;
  }
  
  protected void initUI(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    super.initUI(paramContext, paramEmoticonCallback);
    this.mCallback = paramEmoticonCallback;
    this.mSendBtn = findViewById(2131377197);
    this.mSendBtn.setOnClickListener(new SystemAndEmojiEmoticonPanelWithActionBar.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar
 * JD-Core Version:    0.7.0.1
 */