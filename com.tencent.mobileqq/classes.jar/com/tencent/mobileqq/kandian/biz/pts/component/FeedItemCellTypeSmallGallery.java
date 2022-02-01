package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;

public class FeedItemCellTypeSmallGallery
  extends FeedItemCellTypeSmallImage
{
  public FeedItemCellTypeSmallGallery(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentSmallGallery(this.e);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeSmallGallery
 * JD-Core Version:    0.7.0.1
 */