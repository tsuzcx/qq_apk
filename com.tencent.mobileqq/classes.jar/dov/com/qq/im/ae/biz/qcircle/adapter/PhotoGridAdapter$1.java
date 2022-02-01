package dov.com.qq.im.ae.biz.qcircle.adapter;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.util.ArrayUtils;

class PhotoGridAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  PhotoGridAdapter$1(PhotoGridAdapter paramPhotoGridAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    if (ArrayUtils.a(paramInt, this.a.a)) {
      return 3;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PhotoGridAdapter.1
 * JD-Core Version:    0.7.0.1
 */