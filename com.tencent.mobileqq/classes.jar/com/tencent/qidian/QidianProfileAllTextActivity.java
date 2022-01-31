package com.tencent.qidian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class QidianProfileAllTextActivity
  extends IphoneTitleBarActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("title");
    String str = getIntent().getStringExtra("content");
    super.setContentView(2131560516);
    ((TextView)this.mContentView.findViewById(2131377350)).setText(paramBundle);
    ((TextView)this.mContentView.findViewById(2131364691)).setText(str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileAllTextActivity
 * JD-Core Version:    0.7.0.1
 */