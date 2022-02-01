package com.tencent.tkd.topicsdk.imagecompress;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

class Luban$Builder$3
  extends InputStreamAdapter
{
  public String a()
  {
    return this.jdField_a_of_type_AndroidNetUri.getPath();
  }
  
  public InputStream b()
  {
    return Luban.Builder.a(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressLuban$Builder).getContentResolver().openInputStream(this.jdField_a_of_type_AndroidNetUri);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.Luban.Builder.3
 * JD-Core Version:    0.7.0.1
 */