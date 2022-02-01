package dov.com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.biz.qqstory.view.asyncImageLoader.ImageLoader;
import com.tencent.biz.qqstory.view.asyncImageLoader.Task;

public class FrameLoader
  extends ImageLoader<Integer>
{
  private int jdField_a_of_type_Int;
  private MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
  private LruCache<Integer, Drawable> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  public FrameLoader.GetFrameReport a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public LruCache<Integer, Drawable> a()
  {
    return this.jdField_a_of_type_AndroidSupportV4UtilLruCache;
  }
  
  public Task a(ImageView paramImageView, Integer paramInteger)
  {
    return new FrameLoader.FrameTask(paramImageView, this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever, paramInteger, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.d, this.c, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader$GetFrameReport, this.jdField_b_of_type_Boolean);
  }
  
  @TargetApi(10)
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    if (this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever != null) {
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.FrameLoader
 * JD-Core Version:    0.7.0.1
 */