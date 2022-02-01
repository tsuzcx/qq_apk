package com.tencent.mobileqq.vas.treasurecard;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/treasurecard/VasFtCard;", "Ljava/io/Serializable;", "orderUrl", "", "imageUrl", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "flowThreshold", "", "getFlowThreshold", "()I", "flowThresholdText", "getFlowThresholdText", "()Ljava/lang/String;", "getImageUrl", "getMessage", "getOrderUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class VasFtCard
  implements Serializable
{
  @Nullable
  private final String imageUrl;
  @Nullable
  private final String message;
  @Nullable
  private final String orderUrl;
  
  public VasFtCard(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    this.orderUrl = paramString1;
    this.imageUrl = paramString2;
    this.message = paramString3;
  }
  
  @Nullable
  public final String component1()
  {
    return this.orderUrl;
  }
  
  @Nullable
  public final String component2()
  {
    return this.imageUrl;
  }
  
  @Nullable
  public final String component3()
  {
    return this.message;
  }
  
  @NotNull
  public final VasFtCard copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    return new VasFtCard(paramString1, paramString2, paramString3);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VasFtCard))
      {
        paramObject = (VasFtCard)paramObject;
        if ((Intrinsics.areEqual(this.orderUrl, paramObject.orderUrl)) && (Intrinsics.areEqual(this.imageUrl, paramObject.imageUrl)) && (Intrinsics.areEqual(this.message, paramObject.message))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getFlowThreshold()
  {
    return MobileQQ.getContext().getSharedPreferences("TreasureCardFile_", 4).getInt("flowThreshold", -1);
  }
  
  @NotNull
  public final String getFlowThresholdText()
  {
    String str = MobileQQ.getContext().getSharedPreferences("TreasureCardFile_", 4).getString("flowThresholdText", "");
    Intrinsics.checkExpressionValueIsNotNull(str, "sp.getString(\"flowThresholdText\", \"\")");
    return str;
  }
  
  @Nullable
  public final String getImageUrl()
  {
    return this.imageUrl;
  }
  
  @Nullable
  public final String getMessage()
  {
    return this.message;
  }
  
  @Nullable
  public final String getOrderUrl()
  {
    return this.orderUrl;
  }
  
  public int hashCode()
  {
    String str = this.orderUrl;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.imageUrl;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.message;
    if (str != null) {
      k = str.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public final JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("TreasureCardFile_", 4);
    try
    {
      localJSONObject.put("orderUrl", this.orderUrl);
      localJSONObject.put("imageUrl", this.imageUrl);
      localJSONObject.put("message", this.message);
      localJSONObject.put("flowThreshold", localSharedPreferences.getInt("flowThreshold", -1));
      localJSONObject.put("flowThresholdText", localSharedPreferences.getString("flowThresholdText", ""));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toJson error");
      localStringBuilder.append(localException.getMessage());
      QLog.d("treasureCard", 2, localStringBuilder.toString());
    }
    return localJSONObject;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VasFtCard(orderUrl=");
    localStringBuilder.append(this.orderUrl);
    localStringBuilder.append(", imageUrl=");
    localStringBuilder.append(this.imageUrl);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.message);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.VasFtCard
 * JD-Core Version:    0.7.0.1
 */