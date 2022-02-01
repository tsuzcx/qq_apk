package com.tencent.weseevideo.model.template.movie;

import com.tencent.tavsticker.core.TAVStickerResourceExporter.IStickerResourceExportListener;
import com.tencent.tavsticker.model.TAVStickerResource;
import java.util.Iterator;
import java.util.List;

class MovieTemplate$1
  implements TAVStickerResourceExporter.IStickerResourceExportListener
{
  MovieTemplate$1(MovieTemplate paramMovieTemplate) {}
  
  public void exporting(TAVStickerResource paramTAVStickerResource, float paramFloat)
  {
    if (MovieTemplate.access$000(this.this$0) != null)
    {
      Iterator localIterator = MovieTemplate.access$000(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        TAVStickerResourceExporter.IStickerResourceExportListener localIStickerResourceExportListener = (TAVStickerResourceExporter.IStickerResourceExportListener)localIterator.next();
        if (localIStickerResourceExportListener != null) {
          localIStickerResourceExportListener.exporting(paramTAVStickerResource, paramFloat);
        }
      }
    }
  }
  
  public void failed(String paramString1, String paramString2)
  {
    MovieTemplate.access$102(this.this$0, null);
    if (MovieTemplate.access$000(this.this$0) != null)
    {
      Iterator localIterator = MovieTemplate.access$000(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        TAVStickerResourceExporter.IStickerResourceExportListener localIStickerResourceExportListener = (TAVStickerResourceExporter.IStickerResourceExportListener)localIterator.next();
        if (localIStickerResourceExportListener != null) {
          localIStickerResourceExportListener.failed(paramString1, paramString2);
        }
      }
    }
    MovieTemplate.access$202(this.this$0, false);
  }
  
  public void start(TAVStickerResource paramTAVStickerResource)
  {
    if (MovieTemplate.access$000(this.this$0) != null)
    {
      Iterator localIterator = MovieTemplate.access$000(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        TAVStickerResourceExporter.IStickerResourceExportListener localIStickerResourceExportListener = (TAVStickerResourceExporter.IStickerResourceExportListener)localIterator.next();
        if (localIStickerResourceExportListener != null) {
          localIStickerResourceExportListener.start(paramTAVStickerResource);
        }
      }
    }
  }
  
  public void succeed(TAVStickerResource paramTAVStickerResource)
  {
    if (paramTAVStickerResource != null)
    {
      MovieTemplate.access$102(this.this$0, paramTAVStickerResource.getFilePath());
      if (MovieTemplate.access$000(this.this$0) != null)
      {
        Iterator localIterator = MovieTemplate.access$000(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          TAVStickerResourceExporter.IStickerResourceExportListener localIStickerResourceExportListener = (TAVStickerResourceExporter.IStickerResourceExportListener)localIterator.next();
          if (localIStickerResourceExportListener != null) {
            localIStickerResourceExportListener.succeed(paramTAVStickerResource);
          }
        }
      }
    }
    MovieTemplate.access$202(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.movie.MovieTemplate.1
 * JD-Core Version:    0.7.0.1
 */