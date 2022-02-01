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
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g();
  }
  
  public FeedItemCell d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ComponentContentVerticalSmallVideo localComponentContentVerticalSmallVideo = (ComponentContentVerticalSmallVideo)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView;
      if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof ReadInJoyModelImpl)))
      {
        Pair localPair = RIJComponentConfigImage.a(((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).f(), ((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).c());
        if (RIJFeedsType.h(((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).a())) {
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
  
  public FeedItemCell e()
  {
    return null;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView = new ComponentContentVerticalSmallVideo(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePolymericSmallVideo
 * JD-Core Version:    0.7.0.1
 */