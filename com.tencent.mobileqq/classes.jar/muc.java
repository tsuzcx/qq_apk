import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.Utils;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.qphone.base.util.QLog;

class muc
  extends QQLruCache
{
  muc(mub parammub, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  protected int a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap)
  {
    return Utils.a(paramCloseableBitmap.a());
  }
  
  protected void a(boolean paramBoolean, ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap1, CloseableBitmap paramCloseableBitmap2)
  {
    super.entryRemoved(paramBoolean, paramImageRequest, paramCloseableBitmap1, paramCloseableBitmap2);
    if (QLog.isColorLevel()) {
      Utils.a(mub.a, "entryRemoved cache " + paramCloseableBitmap1 + " state:" + this.a.toString());
    }
    paramCloseableBitmap1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     muc
 * JD-Core Version:    0.7.0.1
 */