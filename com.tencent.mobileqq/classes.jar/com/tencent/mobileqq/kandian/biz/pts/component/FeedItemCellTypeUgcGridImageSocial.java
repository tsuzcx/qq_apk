package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public class FeedItemCellTypeUgcGridImageSocial
  extends FeedItemCellTypeUgcPlainSocial
{
  public FeedItemCellTypeUgcGridImageSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentGridImage(this.e);
    return this;
  }
  
  public FeedItemCell q()
  {
    if (this.v != null)
    {
      this.v.a(this.b);
      if ((this.b instanceof IReadInJoyModel))
      {
        IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.b;
        this.v.setReadedStatus(this.g.b(localIReadInJoyModel.m(), localIReadInJoyModel.k().mArticleID));
      }
    }
    if (this.A != null) {
      this.A.a(this.b);
    }
    if (this.r != null) {
      this.r.a(this.b);
    }
    if (this.l != null)
    {
      if ((this.l instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.l).setMIReadInJoyModel(this.b);
      }
      this.l.a(ComponentContentGridImage.a(((IReadInJoyModel)this.b).k()));
    }
    if (this.t != null) {
      this.t.a(this.b);
    }
    if (this.x != null) {
      this.x.a(this.b);
    }
    if (this.o != null) {
      this.o.a(this.b);
    }
    if (this.m != null) {
      this.m.a(this.b);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeUgcGridImageSocial
 * JD-Core Version:    0.7.0.1
 */