package com.tencent.mobileqq.kandian.biz.flutter.offline;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/flutter/offline/MxFlutterResourceLoader$realDownLoadResource$1$1", "Lcom/tencent/biz/common/offline/AsyncBack;", "loaded", "", "param", "", "code", "", "progress", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class MxFlutterResourceLoader$realDownLoadResource$1$1
  implements AsyncBack
{
  public void loaded(@Nullable String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downLoadResource  code ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("  param ");
    localStringBuilder.append(paramString);
    QLog.d("MxFlutterResourceLoader", 1, localStringBuilder.toString());
    if (paramInt == 0)
    {
      if (paramString == null)
      {
        MxFlutterResourceLoader.a(MxFlutterResourceLoader.a, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFlutterOfflineMxFlutterResourceLoadListener);
        return;
      }
      if (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"url", false, 2, null))
      {
        QLog.d("MxFlutterResourceLoader", 1, new Object[] { "load success and contains url. cost=", Long.valueOf(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) });
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.a.jdField_a_of_type_Long;
      MxFlutterResourceLoader.a(MxFlutterResourceLoader.a, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFlutterOfflineMxFlutterResourceLoadListener);
      QLog.d("MxFlutterResourceLoader", 1, new Object[] { "load success but no update. cost=", Long.valueOf(l1 - l2) });
      return;
    }
    paramString = this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFlutterOfflineMxFlutterResourceLoadListener;
    if (paramString != null) {
      paramString.a("load failed error code");
    }
  }
  
  public void progress(int paramInt)
  {
    MxFlutterResourceLoadListener localMxFlutterResourceLoadListener = this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFlutterOfflineMxFlutterResourceLoadListener;
    if (localMxFlutterResourceLoadListener != null) {
      localMxFlutterResourceLoadListener.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader.realDownLoadResource.1.1
 * JD-Core Version:    0.7.0.1
 */