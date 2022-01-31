package com.tencent.qidian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class QidianProfileAllTextActivity
  extends IphoneTitleBarActivity
{
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("title");
    String str = getIntent().getStringExtra("content");
    super.setContentView(2130970059);
    ((TextView)this.mContentView.findViewById(2131363378)).setText(paramBundle);
    ((TextView)this.mContentView.findViewById(2131363057)).setText(str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileAllTextActivity
 * JD-Core Version:    0.7.0.1
 */