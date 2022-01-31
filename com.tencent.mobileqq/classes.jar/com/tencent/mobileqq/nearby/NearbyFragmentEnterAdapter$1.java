package com.tencent.mobileqq.nearby;

import android.os.Handler;
import auqn;
import auqr;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import java.util.List;

public class NearbyFragmentEnterAdapter$1
  implements Runnable
{
  public NearbyFragmentEnterAdapter$1(auqn paramauqn) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_JavaUtilList != null)
    {
      auqr localauqr = this.this$0.a();
      if (localauqr != null)
      {
        Object localObject = this.this$0;
        ((auqn)localObject).b += 1;
        if (this.this$0.b >= this.this$0.jdField_a_of_type_JavaUtilList.size()) {
          this.this$0.b = 0;
        }
        localObject = (ilive_feeds_near_anchor.NearAnchorInfo)this.this$0.jdField_a_of_type_JavaUtilList.get(this.this$0.b);
        this.this$0.a(localauqr, (ilive_feeds_near_anchor.NearAnchorInfo)localObject);
      }
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.1
 * JD-Core Version:    0.7.0.1
 */