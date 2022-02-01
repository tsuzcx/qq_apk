package com.tencent.mobileqq.kandian.biz.video.column;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnBusinessObserver;", "Lmqq/observer/BusinessObserver;", "dataManager", "Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnDataManager;", "topicId", "", "rowKey", "(Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnDataManager;Ljava/lang/String;Ljava/lang/String;)V", "getRowKey", "()Ljava/lang/String;", "getTopicId", "weakRef", "Ljava/lang/ref/WeakReference;", "addToDataManager", "", "json", "Lorg/json/JSONObject;", "onReceive", "type", "", "isSuccess", "", "bundle", "Landroid/os/Bundle;", "parseToJson", "byteArray", "", "removeRequest", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnBusinessObserver
  implements BusinessObserver
{
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private WeakReference<VideoColumnDataManager> jdField_a_of_type_JavaLangRefWeakReference;
  @NotNull
  private final String b;
  
  public VideoColumnBusinessObserver(@NotNull VideoColumnDataManager paramVideoColumnDataManager, @NotNull String paramString1, @NotNull String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoColumnDataManager);
  }
  
  private final JSONObject a(byte[] paramArrayOfByte)
  {
    WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
    localWebSsoResponseBody.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = new JSONObject().put("data", new JSONObject(localWebSsoResponseBody.data.get())).put("retcode", localWebSsoResponseBody.ret.get()).put("cret", 0);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "JSONObject()\n           …          .put(\"cret\", 0)");
    return paramArrayOfByte;
  }
  
  private final void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (VideoColumnDataManager)((WeakReference)localObject).get();
      if (localObject != null) {
        ((VideoColumnDataManager)localObject).a(paramString);
      }
    }
  }
  
  private final void a(JSONObject paramJSONObject)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (VideoColumnDataManager)((WeakReference)localObject).get();
      if (localObject != null) {
        ((VideoColumnDataManager)localObject).a(this.jdField_a_of_type_JavaLangString, paramJSONObject);
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, @Nullable Bundle paramBundle)
  {
    if (paramBoolean)
    {
      if (paramBundle != null) {
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            break label123;
          }
          a(a(paramBundle));
        }
        catch (Exception paramBundle)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse video column json error: ");
          localStringBuilder.append(paramBundle.getMessage());
          QLog.e("VideoColumnDataManager", 1, localStringBuilder.toString());
        }
      }
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("request error, topicId: ");
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      paramBundle.append(", rowKey: ");
      paramBundle.append(this.b);
      QLog.e("VideoColumnDataManager", 1, paramBundle.toString());
    }
    label123:
    a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.column.VideoColumnBusinessObserver
 * JD-Core Version:    0.7.0.1
 */