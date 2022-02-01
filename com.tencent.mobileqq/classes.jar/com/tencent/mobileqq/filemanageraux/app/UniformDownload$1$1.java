package com.tencent.mobileqq.filemanageraux.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;

class UniformDownload$1$1
  implements Runnable
{
  UniformDownload$1$1(UniformDownload.1 param1, String paramString, long paramLong) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.c.e.b, UniformDownloadActivity.class);
    Object localObject = this.c.a.getString("param_content_memo");
    String str1 = this.c.a.getString("param_icon_path");
    String str2 = this.c.a.getString("param_mime_type");
    if (localObject != null) {
      localIntent.putExtra(UniformDownloadActivity.h, (String)localObject);
    }
    if (str1 != null) {
      localIntent.putExtra(UniformDownloadActivity.g, str1);
    }
    boolean bool = this.c.a.getBoolean("param_isqbdownload", false);
    localIntent.putExtra(UniformDownloadActivity.i, bool);
    localIntent.putExtra(UniformDownloadActivity.b, this.c.b);
    localIntent.putExtra(UniformDownloadActivity.d, this.a);
    localIntent.setFlags(536870912);
    long l;
    if (this.c.c != 0L) {
      l = this.c.c;
    } else {
      l = this.b;
    }
    localIntent.putExtra(UniformDownloadActivity.e, l);
    localIntent.putExtra(UniformDownloadActivity.j, str2);
    if (this.c.d == 1L) {
      localIntent.putExtra(UniformDownloadActivity.c, this.c.d);
    }
    localIntent.putExtra("fromArkAppDownload", this.c.a.getBoolean("fromArkAppDownload", false));
    localIntent.putExtra(UniformDownloadActivity.k, this.c.a.getString("param_refer_url", ""));
    localObject = this.c.e.b.getIntent();
    if (localObject != null)
    {
      localIntent.putExtra("big_brother_source_key", ((Intent)localObject).getStringExtra("big_brother_source_key"));
      localIntent.putExtra("big_brother_ref_source_key", ((Intent)localObject).getStringExtra("big_brother_ref_source_key"));
    }
    this.c.e.b.startActivity(localIntent);
    this.c.e.b.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.app.UniformDownload.1.1
 * JD-Core Version:    0.7.0.1
 */