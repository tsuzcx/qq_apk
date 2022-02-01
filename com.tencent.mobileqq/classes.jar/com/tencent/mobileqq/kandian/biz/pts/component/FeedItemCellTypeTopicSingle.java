package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeTopicSingle
  extends FeedItemCell
{
  public FeedItemCellTypeTopicSingle(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    return n().v().p();
  }
  
  public FeedItemCell e()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.e);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.B != null) {
      localLinearLayout.addView(this.B);
    }
    if (this.r != null) {
      localLinearLayout.addView(this.r);
    }
    if (this.t != null) {
      localLinearLayout.addView(this.t);
    }
    a(localLinearLayout);
    return this;
  }
  
  public FeedItemCell f()
  {
    return null;
  }
  
  public FeedItemCell q()
  {
    super.q();
    if (this.B != null) {
      this.B.a(this.b);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicSingle
 * JD-Core Version:    0.7.0.1
 */