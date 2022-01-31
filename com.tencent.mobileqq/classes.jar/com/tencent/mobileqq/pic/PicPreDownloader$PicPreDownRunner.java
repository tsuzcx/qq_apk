package com.tencent.mobileqq.pic;

class PicPreDownloader$PicPreDownRunner
  implements Runnable
{
  Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  
  PicPreDownloader$PicPreDownRunner(PicPreDownloader paramPicPreDownloader, Runnable paramRunnable, String paramString)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void run()
  {
    this.jdField_a_of_type_JavaLangRunnable.run();
    PicPreDownloader localPicPreDownloader = this.this$0;
    localPicPreDownloader.a -= 1;
    PicPreDownloader.a(this.this$0);
  }
  
  public String toString()
  {
    return "PicPreDownloader ," + this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.PicPreDownRunner
 * JD-Core Version:    0.7.0.1
 */