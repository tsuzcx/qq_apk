package com.tencent.mobileqq.profilecard.bussiness.guide.bean;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "", "()V", "guideId", "", "getGuideId", "()I", "setGuideId", "(I)V", "guideMainMsg", "", "getGuideMainMsg", "()Ljava/lang/String;", "setGuideMainMsg", "(Ljava/lang/String;)V", "guideSecondaryMsg", "getGuideSecondaryMsg", "setGuideSecondaryMsg", "guideType", "getGuideType", "setGuideType", "isValid", "", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileGuide
{
  public static final ProfileGuide.Companion Companion = new ProfileGuide.Companion(null);
  public static final int INVALID_ID = -1;
  public static final int TYPE_FILL = 1;
  public static final int TYPE_UPDATE = 2;
  @NotNull
  private static final Integer[] VALID_GUIDE_ID = { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) };
  @NotNull
  private static final Integer[] VALID_GUIDE_TYPE = { Integer.valueOf(1), Integer.valueOf(2) };
  private int guideId = -1;
  @Nullable
  private String guideMainMsg;
  @Nullable
  private String guideSecondaryMsg;
  private int guideType = -1;
  
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
    return "ProfileGuide {guideId=" + this.guideId + ", guideType=" + this.guideType + ", guideMainMsg=" + this.guideMainMsg + ", guideSecondaryMsg=" + this.guideSecondaryMsg + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide
 * JD-Core Version:    0.7.0.1
 */