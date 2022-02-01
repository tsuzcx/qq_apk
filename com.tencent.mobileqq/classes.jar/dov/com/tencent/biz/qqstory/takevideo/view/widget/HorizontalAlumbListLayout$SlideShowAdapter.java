package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.takevideo.slideshow.ItemTouchHelperAction;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowUtils;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowViewController.SlideShowActionListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HorizontalAlumbListLayout$SlideShowAdapter
  extends RecyclerView.Adapter<HorizontalAlumbListLayout.SlideShowViewHolder>
  implements ItemTouchHelperAction
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private SlideShowViewController.SlideShowActionListener jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController$SlideShowActionListener;
  private List<SlideItemInfo> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  public HorizontalAlumbListLayout$SlideShowAdapter(HorizontalAlumbListLayout paramHorizontalAlumbListLayout, Context paramContext, View.OnClickListener paramOnClickListener, SlideShowViewController.SlideShowActionListener paramSlideShowActionListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController$SlideShowActionListener = paramSlideShowActionListener;
  }
  
  public HorizontalAlumbListLayout.SlideShowViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new HorizontalAlumbListLayout.SlideShowViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561882, paramViewGroup, false));
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(4);
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Collections.swap(this.jdField_a_of_type_JavaUtilList, paramInt1, paramInt2);
    notifyItemMoved(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_Int == paramInt1) || (this.jdField_a_of_type_Int == paramInt2)) {
      if (this.jdField_a_of_type_Int != paramInt1) {
        break label81;
      }
    }
    label81:
    for (this.jdField_a_of_type_Int = paramInt2;; this.jdField_a_of_type_Int = paramInt1)
    {
      notifyItemChanged(paramInt1, Integer.valueOf(0));
      notifyItemChanged(paramInt2, Integer.valueOf(0));
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController$SlideShowActionListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController$SlideShowActionListener.a(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  public void a(HorizontalAlumbListLayout.SlideShowViewHolder paramSlideShowViewHolder, int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localSlideItemInfo);
    if (localSlideItemInfo.jdField_a_of_type_JavaNetURL != null)
    {
      Object localObject = paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.jdField_a_of_type_JavaNetURL.equals(((URLDrawable)localObject).getURL())))
      {
        localObject = URLDrawableHelper.getDrawable(localSlideItemInfo.jdField_a_of_type_JavaNetURL, URLDrawableHelper.getLoadingDrawable(), URLDrawableHelper.getFailedDrawable());
        ((URLDrawable)localObject).setTag(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable((Drawable)localObject);
        paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setTag(localSlideItemInfo);
      }
    }
    switch (localSlideItemInfo.jdField_b_of_type_Int)
    {
    default: 
      if ((paramInt == this.jdField_a_of_type_Int) && (!paramSlideShowViewHolder.jdField_a_of_type_Boolean))
      {
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(0.94F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(0.94F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.post(new HorizontalAlumbListLayout.SlideShowAdapter.1(this, paramSlideShowViewHolder));
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramSlideShowViewHolder, paramInt, getItemId(paramInt));
      return;
      paramSlideShowViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramSlideShowViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(SlideShowUtils.a(localSlideItemInfo.jdField_a_of_type_Long));
      break;
      paramSlideShowViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (localSlideItemInfo.jdField_a_of_type_Long <= 0L) {
        break;
      }
      paramSlideShowViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(SlideShowUtils.a(localSlideItemInfo.c - localSlideItemInfo.jdField_b_of_type_Long));
      break;
      if (paramSlideShowViewHolder.jdField_a_of_type_Boolean)
      {
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.13F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.13F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(0.65F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
      else
      {
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
    }
  }
  
  public void a(List<SlideItemInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout.SlideShowAdapter
 * JD-Core Version:    0.7.0.1
 */