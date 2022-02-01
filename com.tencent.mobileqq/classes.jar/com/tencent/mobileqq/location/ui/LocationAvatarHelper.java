package com.tencent.mobileqq.location.ui;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.model.FaceItem;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class LocationAvatarHelper
{
  private static volatile LocationAvatarHelper jdField_a_of_type_ComTencentMobileqqLocationUiLocationAvatarHelper;
  private final IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private final HashMap<String, FaceItem> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  
  private LocationAvatarHelper()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)localAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(localAppInterface);
  }
  
  public static LocationAvatarHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLocationUiLocationAvatarHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqLocationUiLocationAvatarHelper == null) {
          jdField_a_of_type_ComTencentMobileqqLocationUiLocationAvatarHelper = new LocationAvatarHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqLocationUiLocationAvatarHelper;
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (FaceItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((FaceItem)localObject2).jdField_a_of_type_Long < 4000L) && (((FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((FaceItem)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new FaceItem();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((FaceItem)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
    if (localObject2 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
      return localObject2;
    }
    ((FaceItem)localObject1).jdField_a_of_type_Long = l;
    ((FaceItem)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    return localObject2;
  }
  
  public FaceItem a(String paramString)
  {
    return (FaceItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    jdField_a_of_type_ComTencentMobileqqLocationUiLocationAvatarHelper = null;
  }
  
  public void a(DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(paramDecodeTaskCompletionListener);
  }
  
  public void a(String paramString, FaceItem paramFaceItem)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramFaceItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationAvatarHelper
 * JD-Core Version:    0.7.0.1
 */