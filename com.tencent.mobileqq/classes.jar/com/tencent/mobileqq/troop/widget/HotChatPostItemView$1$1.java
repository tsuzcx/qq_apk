package com.tencent.mobileqq.troop.widget;

import android.util.Pair;
import android.widget.ImageView;
import bffg;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.freshnews.feed.NearbyImgLoader;
import java.util.HashMap;
import java.util.Queue;
import mqq.os.MqqHandler;

public class HotChatPostItemView$1$1
  implements Runnable
{
  public HotChatPostItemView$1$1(bffg parambffg) {}
  
  public void run()
  {
    if (((this.this$0.jdField_a_of_type_AndroidWidgetImageView.getTag() instanceof String)) && (!((String)this.this$0.jdField_a_of_type_AndroidWidgetImageView.getTag()).endsWith(this.this$0.jdField_a_of_type_JavaLangString))) {
      return;
    }
    try
    {
      Pair localPair1 = NearbyImgLoader.a().a(null, HotChatPostItemView.a(this.this$0.jdField_a_of_type_ComTencentImageURLDrawable), 1);
      ThreadManager.getUIHandler().post(new HotChatPostItemView.1.1.1(this, localPair1));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        HotChatPostItemView.jdField_a_of_type_JavaUtilQueue.clear();
        HotChatPostItemView.jdField_a_of_type_JavaUtilHashMap.clear();
        Pair localPair2 = NearbyImgLoader.a().a(null, HotChatPostItemView.a(this.this$0.jdField_a_of_type_ComTencentImageURLDrawable), 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.HotChatPostItemView.1.1
 * JD-Core Version:    0.7.0.1
 */