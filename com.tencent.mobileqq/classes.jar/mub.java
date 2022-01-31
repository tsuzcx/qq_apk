import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.BytePool;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.Releaser;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.Utils;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class mub
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  public BytePool a;
  public Releaser a;
  private QQLruCache jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
  public List a;
  int jdField_b_of_type_Int = 0;
  final List jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + mub.class.getSimpleName();
  }
  
  public mub(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBytePool = new BytePool(2097152);
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new muc(this, 2008, paramInt);
    paramInt = i;
    while (paramInt < 5)
    {
      this.jdField_a_of_type_JavaUtilList.add(new byte[16384]);
      paramInt += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReleaser = new mud(this);
  }
  
  public Bitmap a(BitmapFactory.Options paramOptions)
  {
    for (;;)
    {
      int i;
      try
      {
        this.jdField_b_of_type_Int += 1;
        ArrayList localArrayList = new ArrayList();
        List localList = this.jdField_b_of_type_JavaUtilList;
        i = 0;
        try
        {
          if (i < this.jdField_b_of_type_JavaUtilList.size())
          {
            localBitmap = (Bitmap)((SoftReference)this.jdField_b_of_type_JavaUtilList.get(i)).get();
            if (localBitmap != null)
            {
              if (Utils.a(localBitmap, paramOptions))
              {
                localArrayList.add(this.jdField_b_of_type_JavaUtilList.get(i));
                str = "cache";
                if (!localArrayList.isEmpty()) {
                  this.jdField_b_of_type_JavaUtilList.removeAll(localArrayList);
                }
                if (localBitmap != null) {
                  this.jdField_a_of_type_Int += 1;
                }
                if (QLog.isColorLevel()) {
                  Utils.a(jdField_a_of_type_JavaLangString, "getReuseableBitmap found:" + str + " picSize:" + paramOptions.outWidth + "x" + paramOptions.outHeight + " bitmap:" + localBitmap + " state:" + toString());
                }
                return localBitmap;
              }
            }
            else {
              localArrayList.add(this.jdField_b_of_type_JavaUtilList.get(i));
            }
          }
        }
        finally {}
        String str = "notFound";
      }
      finally {}
      Bitmap localBitmap = null;
      continue;
      i += 1;
    }
  }
  
  public CloseableBitmap a(ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null) {
      return null;
    }
    paramImageRequest = (CloseableBitmap)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramImageRequest);
    if (paramImageRequest != null) {
      return paramImageRequest.a();
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        Utils.a(jdField_a_of_type_JavaLangString, "clean  mBitmapCaches size = " + this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.size());
      }
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderBytePool.a();
      this.jdField_b_of_type_JavaUtilList.clear();
      return;
    }
    finally {}
  }
  
  public void a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap)
  {
    try
    {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramImageRequest, paramCloseableBitmap.a());
      return;
    }
    finally
    {
      paramImageRequest = finally;
      throw paramImageRequest;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("total:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" reuse:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" cacheMem:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.size() / 1024);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mub
 * JD-Core Version:    0.7.0.1
 */