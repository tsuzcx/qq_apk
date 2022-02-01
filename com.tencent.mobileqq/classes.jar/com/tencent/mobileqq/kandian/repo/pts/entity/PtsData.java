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
  public static final PtsData.Companion e = new PtsData.Companion(null);
  @JvmField
  @Nullable
  public PTSComposer a;
  @JvmField
  @NotNull
  public String b;
  @JvmField
  @NotNull
  public final PTSComposer.IPTSUpdateDataListener c;
  @JvmField
  @NotNull
  public String d;
  @Nullable
  private PTSItemData f;
  private boolean g;
  @NotNull
  private String h;
  
  public PtsData(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3)
  {
    super(27);
    this.d = paramString1;
    this.h = paramString2;
    this.g = true;
    this.b = "unknown";
    this.c = ((PTSComposer.IPTSUpdateDataListener)new PtsData.ptsUpdateDataListener.1(this));
    paramString1 = PTSStyleManager.a().a("native_article", this.d);
    if (TextUtils.isEmpty((CharSequence)paramString1))
    {
      this.g = false;
      return;
    }
    this.f = new PTSItemData.Builder().withJsonData(paramString3).withFrameTreeJson(paramString1).withItemID(this.h).withPageName(this.d).build();
  }
  
  @Nullable
  public final PTSItemData a()
  {
    return this.f;
  }
  
  public final void a(@Nullable PTSItemData paramPTSItemData)
  {
    this.f = paramPTSItemData;
  }
  
  @JvmOverloads
  public final void a(@Nullable IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    if (this.g)
    {
      Object localObject = this.f;
      if (localObject != null)
      {
        String str2 = this.d;
        String str1 = null;
        if (localObject != null) {
          localObject = ((PTSItemData)localObject).getFrameTreeJson();
        } else {
          localObject = null;
        }
        PTSItemData localPTSItemData = this.f;
        if (localPTSItemData != null) {
          str1 = localPTSItemData.getJSONData();
        }
        this.a = PTSComposer.buildComposer(str2, (String)localObject, str1, paramIPTSLiteEventListener, this.c);
      }
    }
  }
  
  @JvmOverloads
  public final void b()
  {
    a(this, null, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.entity.PtsData
 * JD-Core Version:    0.7.0.1
 */