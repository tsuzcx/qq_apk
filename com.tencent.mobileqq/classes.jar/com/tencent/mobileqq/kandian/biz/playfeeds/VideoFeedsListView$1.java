package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.database.DataSetObserver;

class VideoFeedsListView$1
  extends DataSetObserver
{
  VideoFeedsListView$1(VideoFeedsListView paramVideoFeedsListView) {}
  
  public void onChanged()
  {
    VideoFeedsListView localVideoFeedsListView = this.a;
    boolean bool;
    if (VideoFeedsListView.a(localVideoFeedsListView) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    VideoFeedsListView.a(localVideoFeedsListView, bool);
  }
  
  public void onInvalidated()
  {
    VideoFeedsListView localVideoFeedsListView = this.a;
    boolean bool;
    if (VideoFeedsListView.a(localVideoFeedsListView) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    VideoFeedsListView.a(localVideoFeedsListView, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsListView.1
 * JD-Core Version:    0.7.0.1
 */