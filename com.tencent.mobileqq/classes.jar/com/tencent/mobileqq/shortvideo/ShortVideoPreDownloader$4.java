package com.tencent.mobileqq.shortvideo;

import bcwx;
import bcxf;
import bcxn;

public class ShortVideoPreDownloader$4
  implements Runnable
{
  public ShortVideoPreDownloader$4(bcxf parambcxf, bcxn parambcxn) {}
  
  public void run()
  {
    bcxf.a("consumeShortVideo", "start pre download short video type=" + this.a.b + " uniseq=" + this.a.a.jdField_a_of_type_Long + ", uuid=" + this.a.a.jdField_a_of_type_JavaLangString);
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */