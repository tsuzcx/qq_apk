package com.tencent.mobileqq.kandian.repo.pts.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/pts/entity/PtsData;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "ptsLitePageName", "", "ptsLiteItemId", "dataJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isValid", "", "()Z", "setValid", "(Z)V", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "ptsItemData", "Lcom/tencent/pts/core/itemview/PTSItemData;", "getPtsItemData", "()Lcom/tencent/pts/core/itemview/PTSItemData;", "setPtsItemData", "(Lcom/tencent/pts/core/itemview/PTSItemData;)V", "getPtsLiteItemId", "()Ljava/lang/String;", "setPtsLiteItemId", "(Ljava/lang/String;)V", "ptsUpdateDataListener", "Lcom/tencent/pts/core/PTSComposer$IPTSUpdateDataListener;", "type", "buildComposer", "", "eventListener", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PtsData
  extends BaseData
{
  public static final PtsData.Companion a;
  @JvmField
  @NotNull
  public final PTSComposer.IPTSUpdateDataListener a;
  @JvmField
  @Nullable
  public PTSComposer a;
  @Nullable
  private PTSItemData jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemData;
  @JvmField
  @NotNull
  public String a;
  private boolean jdField_a_of_type_Boolean;
  @JvmField
  @NotNull
  public String b;
  @NotNull
  private String c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityPtsData$Companion = new PtsData.Companion(null);
  }
  
  public PtsData(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3)
  {
    super(27);
    this.b = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "unknown";
    this.jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener = ((PTSComposer.IPTSUpdateDataListener)new PtsData.ptsUpdateDataListener.1(this));
    paramString1 = PTSStyleManager.a().a("native_article", this.b);
    if (TextUtils.isEmpty((CharSequence)paramString1))
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemData = new PTSItemData.Builder().withJsonData(paramString3).withFrameTreeJson(paramString1).withItemID(this.c).withPageName(this.b).build();
  }
  
  @Nullable
  public final PTSItemData a()
  {
    return this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemData;
  }
  
  @JvmOverloads
  public final void a()
  {
    a(this, null, 1, null);
  }
  
  public final void a(@Nullable PTSItemData paramPTSItemData)
  {
    this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemData = paramPTSItemData;
  }
  
  @JvmOverloads
  public final void a(@Nullable IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemData;
      if (localObject != null)
      {
        String str2 = this.b;
        String str1 = null;
        if (localObject != null) {
          localObject = ((PTSItemData)localObject).getFrameTreeJson();
        } else {
          localObject = null;
        }
        PTSItemData localPTSItemData = this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemData;
        if (localPTSItemData != null) {
          str1 = localPTSItemData.getJSONData();
        }
        this.jdField_a_of_type_ComTencentPtsCorePTSComposer = PTSComposer.buildComposer(str2, (String)localObject, str1, paramIPTSLiteEventListener, this.jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.entity.PtsData
 * JD-Core Version:    0.7.0.1
 */