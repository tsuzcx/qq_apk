package com.tencent.mobileqq.qqexpand.utils.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.flutter.qqface.DecodeRequest;
import com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader;
import com.tencent.mobileqq.qqexpand.bean.flutter.ApiDecodeRequest;
import com.tencent.mobileqq.qqexpand.utils.IQFlutterFaceLoaderApi;
import com.tencent.mobileqq.qqexpand.utils.IQFlutterFaceLoaderApi.ApiFaceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class QFlutterFaceLoaderApiImpl
  implements IQFlutterFaceLoaderApi
{
  public static final String TAG = "QFlutterQFlutterFaceLoaderApiImpl";
  private QFlutterFaceLoader mLoader;
  private final Map<Integer, QFlutterFaceLoaderApiImpl.InnerFaceObserver> mObserverList = new HashMap();
  
  public void addFaceObserver(IQFlutterFaceLoaderApi.ApiFaceObserver paramApiFaceObserver)
  {
    if (paramApiFaceObserver == null)
    {
      QLog.e("QFlutterQFlutterFaceLoaderApiImpl", 1, "addFaceObserver null?");
      return;
    }
    QFlutterFaceLoaderApiImpl.InnerFaceObserver localInnerFaceObserver = new QFlutterFaceLoaderApiImpl.InnerFaceObserver(this, paramApiFaceObserver);
    this.mObserverList.put(Integer.valueOf(paramApiFaceObserver.hashCode()), localInnerFaceObserver);
    this.mLoader.a(localInnerFaceObserver);
  }
  
  public void clearCache()
  {
    this.mLoader.a();
  }
  
  public ApiDecodeRequest convert2Api(DecodeRequest paramDecodeRequest)
  {
    return new ApiDecodeRequest(paramDecodeRequest.jdField_a_of_type_Int, paramDecodeRequest.jdField_a_of_type_JavaLangString, paramDecodeRequest.b);
  }
  
  public DecodeRequest convert2Rep(ApiDecodeRequest paramApiDecodeRequest)
  {
    return new DecodeRequest(paramApiDecodeRequest.faceType, paramApiDecodeRequest.faceUin, paramApiDecodeRequest.faceShape);
  }
  
  public com.tencent.mobileqq.qqexpand.bean.common.Pair<Bitmap, Boolean> getBitmap(ApiDecodeRequest paramApiDecodeRequest)
  {
    paramApiDecodeRequest = this.mLoader.a(convert2Rep(paramApiDecodeRequest));
    return new com.tencent.mobileqq.qqexpand.bean.common.Pair(paramApiDecodeRequest.first, paramApiDecodeRequest.second);
  }
  
  public void onDestroy()
  {
    this.mObserverList.clear();
    this.mLoader.b();
  }
  
  public void removeFaceObserver(IQFlutterFaceLoaderApi.ApiFaceObserver paramApiFaceObserver)
  {
    if (paramApiFaceObserver != null)
    {
      paramApiFaceObserver = (QFlutterFaceLoaderApiImpl.InnerFaceObserver)this.mObserverList.get(Integer.valueOf(paramApiFaceObserver.hashCode()));
      this.mObserverList.remove(paramApiFaceObserver);
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.mLoader = new QFlutterFaceLoader(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.QFlutterFaceLoaderApiImpl
 * JD-Core Version:    0.7.0.1
 */