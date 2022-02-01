package com.tencent.tkd.topicsdk.imagecompress;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

class Luban$Builder$3
  extends InputStreamAdapter
{
  public InputStream b()
  {
    return Luban.Builder.g(this.b).getContentResolver().openInputStream(this.a);
  }
  
  public String e()
  {
    return this.a.getPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.Luban.Builder.3
 * JD-Core Version:    0.7.0.1
 */