package com.tencent.mobileqq.profilecard.bussiness.guide.bean;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "", "()V", "guideId", "", "getGuideId", "()I", "setGuideId", "(I)V", "guideMainMsg", "", "getGuideMainMsg", "()Ljava/lang/String;", "setGuideMainMsg", "(Ljava/lang/String;)V", "guideSecondaryMsg", "getGuideSecondaryMsg", "setGuideSecondaryMsg", "guideType", "getGuideType", "setGuideType", "isValid", "", "toString", "Companion", "profilecard-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileGuide
{
  public static final ProfileGuide.Companion Companion = new ProfileGuide.Companion(null);
  public static final int INVALID_ID = -1;
  public static final int TYPE_FILL = 1;
  public static final int TYPE_UPDATE = 2;
  @NotNull
  private static final Integer[] VALID_GUIDE_ID;
  @NotNull
  private static final Integer[] VALID_GUIDE_TYPE;
  private int guideId = -1;
  @Nullable
  private String guideMainMsg;
  @Nullable
  private String guideSecondaryMsg;
  private int guideType = -1;
  
  static
  {
    Integer localInteger1 = Integer.valueOf(2);
    Integer localInteger2 = Integer.valueOf(1);
    VALID_GUIDE_TYPE = new Integer[] { localInteger2, localInteger1 };
    VALID_GUIDE_ID = new Integer[] { localInteger2, localInteger1, Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) };
  }
  
  public final int getGuideId()
  {
    return this.guideId;
  }
  
  @Nullable
  public final String getGuideMainMsg()
  {
    return this.guideMainMsg;
  }
  
  @Nullable
  public final String getGuideSecondaryMsg()
  {
    return this.guideSecondaryMsg;
  }
  
  public final int getGuideType()
  {
    return this.guideType;
  }
  
  public final boolean isValid()
  {
    return (ArraysKt.contains(VALID_GUIDE_ID, Integer.valueOf(this.guideId))) && (ArraysKt.contains(VALID_GUIDE_TYPE, Integer.valueOf(this.guideType))) && (!TextUtils.isEmpty((CharSequence)this.guideMainMsg));
  }
  
  public final void setGuideId(int paramInt)
  {
    this.guideId = paramInt;
  }
  
  public final void setGuideMainMsg(@Nullable String paramString)
  {
    this.guideMainMsg = paramString;
  }
  
  public final void setGuideSecondaryMsg(@Nullable String paramString)
  {
    this.guideSecondaryMsg = paramString;
  }
  
  public final void setGuideType(int paramInt)
  {
    this.guideType = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ProfileGuide {guideId=");
    localStringBuilder.append(this.guideId);
    localStringBuilder.append(", guideType=");
    localStringBuilder.append(this.guideType);
    localStringBuilder.append(", guideMainMsg=");
    localStringBuilder.append(this.guideMainMsg);
    localStringBuilder.append(", guideSecondaryMsg=");
    localStringBuilder.append(this.guideSecondaryMsg);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide
 * JD-Core Version:    0.7.0.1
 */