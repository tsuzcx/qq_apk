package com.tencent.mobileqq.kandian.biz.flutter.offline;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/flutter/offline/MxFlutterResourceLoader$realDownLoadResource$1$downloadCallback$1", "Lcom/tencent/biz/common/offline/AsyncBack;", "loaded", "", "param", "", "code", "", "progress", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class MxFlutterResourceLoader$realDownLoadResource$1$downloadCallback$1
  implements AsyncBack
{
  public void loaded(@Nullable String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#realDownLoadResource: resource loaded, code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", param=");
    localStringBuilder.append(paramString);
    QLog.d("MxFlutterResourceLoader", 1, localStringBuilder.toString());
    if (paramInt == 0)
    {
      if (paramString == null)
      {
        QLog.d("MxFlutterResourceLoader", 1, "#realDownLoadResource: biz bundle downloaded");
        MxFlutterResourceLoader.a(MxFlutterResourceLoader.a, this.a.a, this.a.c, this.a.b);
        MxFlutterResourceLoader.a.b().remove(this);
        return;
      }
      if (StringsKt.contains$default((CharSequence)paramString, (CharSequence)"url", false, 2, null))
      {
        QLog.d("MxFlutterResourceLoader", 1, "#realDownLoadResource: wait for biz bundle");
        return;
      }
      QLog.d("MxFlutterResourceLoader", 1, "#realDownLoadResource: no update");
      MxFlutterResourceLoader.a(MxFlutterResourceLoader.a, this.a.a, this.a.b);
      MxFlutterResourceLoader.a.b().remove(this);
      return;
    }
    paramString = this.a.b;
    if (paramString != null) {
      paramString.a("load failed error code");
    }
    MxFlutterResourceLoader.a.b().remove(this);
  }
  
  public void progress(int paramInt)
  {
    MxFlutterResourceLoadListener localMxFlutterResourceLoadListener = this.a.b;
    if (localMxFlutterResourceLoadListener != null) {
      localMxFlutterResourceLoadListener.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader.realDownLoadResource.1.downloadCallback.1
 * JD-Core Version:    0.7.0.1
 */