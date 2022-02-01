package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.Pair;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypePolymericSmallVideo
  extends FeedItemCell
{
  public FeedItemCellTypePolymericSmallVideo(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return i();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      ComponentContentVerticalSmallVideo localComponentContentVerticalSmallVideo = (ComponentContentVerticalSmallVideo)this.l;
      if ((this.b != null) && ((this.b instanceof ReadInJoyModelImpl)))
      {
        Pair localPair = RIJComponentConfigImage.a(((ReadInJoyModelImpl)this.b).q(), ((ReadInJoyModelImpl)this.b).m());
        if (RIJFeedsType.l(((ReadInJoyModelImpl)this.b).k())) {
          localComponentContentVerticalSmallVideo.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        } else {
          localComponentContentVerticalSmallVideo.setLayoutParams(new AbsListView.LayoutParams(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue()));
        }
      }
      a(localComponentContentVerticalSmallVideo);
      return this;
    }
    throw new Exception("buildComponent() must after buildComponent()!");
  }
  
  public FeedItemCell f()
  {
    return null;
  }
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentVerticalSmallVideo(this.e);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePolymericSmallVideo
 * JD-Core Version:    0.7.0.1
 */