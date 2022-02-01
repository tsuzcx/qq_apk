package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyLifeCycleLinearLayout;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeNoteCard
  extends FeedItemCell
{
  public FeedItemCellTypeNoteCard(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return i().n().p();
  }
  
  public FeedItemCell e()
  {
    ReadInJoyLifeCycleLinearLayout localReadInJoyLifeCycleLinearLayout = new ReadInJoyLifeCycleLinearLayout(this.e, null);
    localReadInJoyLifeCycleLinearLayout.setOrientation(1);
    localReadInJoyLifeCycleLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.l != null) && ((this.l instanceof ComponentContentNoteCard))) {
      localReadInJoyLifeCycleLinearLayout.addView((ComponentContentNoteCard)this.l);
    }
    if (this.t != null) {
      localReadInJoyLifeCycleLinearLayout.addView(this.t);
    }
    a(localReadInJoyLifeCycleLinearLayout);
    return this;
  }
  
  public FeedItemCell f()
  {
    return this;
  }
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentNoteCard(this.e, this.g);
    return this;
  }
  
  public FeedItemCell q()
  {
    super.q();
    return this;
  }
  
  public void y()
  {
    super.y();
    ((ComponentContentNoteCard)this.l).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNoteCard
 * JD-Core Version:    0.7.0.1
 */