package com.tencent.mobileqq.nearby;

import android.os.Handler;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import java.util.List;

class NearbyFragmentEnterAdapter$1
  implements Runnable
{
  NearbyFragmentEnterAdapter$1(NearbyFragmentEnterAdapter paramNearbyFragmentEnterAdapter) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_JavaUtilList != null)
    {
      NearbyFragmentEnterAdapter.ViewHolder localViewHolder = this.this$0.a();
      if (localViewHolder != null)
      {
        Object localObject = this.this$0;
        ((NearbyFragmentEnterAdapter)localObject).b += 1;
        if (this.this$0.b >= this.this$0.jdField_a_of_type_JavaUtilList.size()) {
          this.this$0.b = 0;
        }
        localObject = (ilive_feeds_near_anchor.NearAnchorInfo)this.this$0.jdField_a_of_type_JavaUtilList.get(this.this$0.b);
        this.this$0.a(localViewHolder, (ilive_feeds_near_anchor.NearAnchorInfo)localObject);
      }
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.1
 * JD-Core Version:    0.7.0.1
 */