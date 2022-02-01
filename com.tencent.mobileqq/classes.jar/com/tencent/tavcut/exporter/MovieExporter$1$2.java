package com.tencent.tavcut.exporter;

class MovieExporter$1$2
  implements Runnable
{
  MovieExporter$1$2(MovieExporter.1 param1) {}
  
  public void run()
  {
    if (this.this$1.val$compressListener != null) {
      this.this$1.val$compressListener.onCompressFinish(this.this$1.val$outputPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.exporter.MovieExporter.1.2
 * JD-Core Version:    0.7.0.1
 */