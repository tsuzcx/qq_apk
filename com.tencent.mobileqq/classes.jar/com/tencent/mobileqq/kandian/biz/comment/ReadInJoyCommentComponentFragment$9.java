package com.tencent.mobileqq.kandian.biz.comment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

class ReadInJoyCommentComponentFragment$9
  implements Runnable
{
  ReadInJoyCommentComponentFragment$9(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, ZhituPicData paramZhituPicData) {}
  
  public void run()
  {
    Object localObject = ReadInJoyCommentComponentFragment.a(this.this$0);
    if ((localObject != null) && (ReadInJoyCommentComponentFragment.a(this.this$0)))
    {
      ((ZhituManager)localObject).c();
      ReadInJoyCommentComponentFragment.b(this.this$0, false);
    }
    localObject = null;
    try
    {
      try
      {
        URL localURL = new File(this.a.b).toURI().toURL();
        if (localURL != null) {
          localObject = URLDrawable.getDrawable(localURL, true);
        }
      }
      finally {}
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label74:
      break label74;
    }
    if (localDrawable != null)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      this.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizBiuBiuEditText.setText("");
    ReadInJoyCommentComponentFragment.a(this.this$0);
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      ReadInJoyCommentComponentFragment.a(this.this$0, true);
      this.this$0.g.setImageResource(2130842947);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.9
 * JD-Core Version:    0.7.0.1
 */