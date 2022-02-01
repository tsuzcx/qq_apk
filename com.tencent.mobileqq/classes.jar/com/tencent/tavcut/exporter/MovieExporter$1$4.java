package com.tencent.tavcut.exporter;

class MovieExporter$1$4
  implements Runnable
{
  MovieExporter$1$4(MovieExporter.1 param1) {}
  
  public void run()
  {
    if ((this.this$1.val$compressListener != null) && (MovieExporter.access$200(this.this$1.this$0))) {
      this.this$1.val$compressListener.onCompressCanceled();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.exporter.MovieExporter.1.4
 * JD-Core Version:    0.7.0.1
 */