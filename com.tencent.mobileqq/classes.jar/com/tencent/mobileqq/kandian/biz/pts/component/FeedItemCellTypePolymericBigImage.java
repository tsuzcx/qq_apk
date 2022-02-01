package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypePolymericBigImage
  extends FeedItemCell
{
  public FeedItemCellTypePolymericBigImage(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return i().j();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.e);
      localLinearLayout.setOrientation(1);
      if ((this.b != null) && ((this.b instanceof ReadInJoyModelImpl)) && (RIJFeedsType.l(((ReadInJoyModelImpl)this.b).k()))) {
        localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(AIOUtils.b(250.0F, this.e.getResources()), -2));
      } else {
        localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(AIOUtils.b(220.0F, this.e.getResources()), -2));
      }
      if ((this.l != null) && ((this.l instanceof ComponentContentBig))) {
        localLinearLayout.addView((ComponentContentBig)this.l);
      }
      if (this.m != null) {
        localLinearLayout.addView(this.m);
      }
      a(localLinearLayout);
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
    this.l = new ComponentContentBig(this.e);
    return this;
  }
  
  public FeedItemCell q()
  {
    super.q();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePolymericBigImage
 * JD-Core Version:    0.7.0.1
 */