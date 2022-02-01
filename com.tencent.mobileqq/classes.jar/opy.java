import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerController.refreshChannelBannerView.1;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerController;", "", "channelId", "", "context", "Landroid/content/Context;", "(ILandroid/content/Context;)V", "channelBannerInfo", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule$ChannelBannerInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule;", "<set-?>", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerView;", "channelBannerView", "getChannelBannerView", "()Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerView;", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "ptsUpdateDataListener", "Lcom/tencent/pts/core/PTSComposer$IPTSUpdateDataListener;", "ptsliteEventListener", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "rijChannelBannerReport", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerReport;", "clickBannerCard", "", "clickBannerItem", "uin", "", "avatarStatus", "exposeBannerCard", "exposeBannerItem", "exposeChannelBanner", "init", "loadChannelBannerView", "refreshChannelBannerView", "reportData", "requestChannelBannerData", "setChannelBannerVisible", "visible", "", "updateAvatarStatus", "identifier", "newAvatarStatus", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class opy
{
  public static final opz a;
  private final int jdField_a_of_type_Int;
  @Nullable
  private RIJChannelBannerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
  private final PTSComposer.IPTSUpdateDataListener jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener = (PTSComposer.IPTSUpdateDataListener)new oqb(this);
  private PTSComposer jdField_a_of_type_ComTencentPtsCorePTSComposer;
  private IPTSLiteEventListener jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  private oqd jdField_a_of_type_Oqd;
  private final oqf jdField_a_of_type_Oqf = new oqf();
  
  static
  {
    jdField_a_of_type_Opz = new opz(null);
  }
  
  public opy(int paramInt, @NotNull Context paramContext)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramInt, paramContext);
  }
  
  private final void a(int paramInt, Context paramContext)
  {
    if (!oqi.a.a(paramInt)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView = new RIJChannelBannerView(paramContext);
    this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener = ((IPTSLiteEventListener)new oqa(this, paramContext));
    paramContext = pay.a();
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    paramContext = (pks)((QQAppInterface)paramContext).getManager(163);
    if (paramContext != null)
    {
      paramContext = paramContext.a();
      if (paramContext != null)
      {
        paramContext = paramContext.a();
        if (paramContext != null)
        {
          paramContext = paramContext.a(paramInt);
          label99:
          if (paramContext == null) {
            break label139;
          }
          if (((Collection)paramContext).isEmpty()) {
            break label141;
          }
        }
      }
    }
    label139:
    label141:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        this.jdField_a_of_type_Oqd = ((oqd)paramContext.get(0));
      }
      return;
      paramContext = null;
      break label99;
      break;
    }
  }
  
  private final void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.i("RIJChannelBannerController", 1, "[updateAvatarStatus] identifier is empty.");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
    if (localObject != null) {
      localObject = ((PTSComposer)localObject).getJsonData();
    }
    for (;;)
    {
      int i;
      try
      {
        localJSONObject1 = new JSONObject((String)localObject);
        localJSONArray = localJSONObject1.optJSONArray("subscribers");
        if (localJSONArray == null) {
          break label206;
        }
        i = localJSONArray.length();
      }
      catch (JSONException paramString)
      {
        JSONObject localJSONObject1;
        JSONArray localJSONArray;
        JSONObject localJSONObject2;
        CharSequence localCharSequence;
        QLog.e("RIJChannelBannerController", 1, "[updateAvatarStatus] failed, e = " + paramString);
        return;
      }
      if (j < i)
      {
        localJSONObject2 = localJSONArray.optJSONObject(j);
        localCharSequence = (CharSequence)paramString;
        if (localJSONObject2 != null)
        {
          localObject = localJSONObject2.getString("uin");
          if (!TextUtils.equals(localCharSequence, (CharSequence)localObject)) {
            break label217;
          }
          localJSONObject2.put("avatar_status", paramInt);
          QLog.i("RIJChannelBannerController", 1, "[updateAvatarStatus] succeed, identifier = " + paramString);
        }
      }
      else
      {
        paramString = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
        if (paramString == null) {
          break;
        }
        paramString.setData(localJSONObject1.toString());
        return;
        localObject = null;
        continue;
        label206:
        i = 0;
        break label226;
      }
      localObject = null;
      continue;
      label217:
      j += 1;
      continue;
      label226:
      int j = 0;
    }
  }
  
  private final void a(String paramString1, String paramString2, oqd paramoqd)
  {
    oqh localoqh = this.jdField_a_of_type_Oqf.a(paramoqd);
    localoqh.a("puin", paramString1);
    if (TextUtils.equals((CharSequence)String.valueOf(1), (CharSequence)paramString2))
    {
      paramoqd = "1";
      localoqh.a("is_live", paramoqd);
      if (!TextUtils.equals((CharSequence)String.valueOf(2), (CharSequence)paramString2)) {
        break label109;
      }
    }
    label109:
    for (paramString2 = "1";; paramString2 = "0")
    {
      localoqh.a("is_update", paramString2);
      ((Map)this.jdField_a_of_type_Oqf.c()).put(paramString1, localoqh);
      return;
      paramoqd = "0";
      break;
    }
  }
  
  private final void b(String paramString1, String paramString2, oqd paramoqd)
  {
    QLog.i("RIJChannelBannerController", 1, "[clickBannerCard] uin = " + paramString1 + ", avatarStatus = " + paramString2);
    oqh localoqh = this.jdField_a_of_type_Oqf.a(paramoqd);
    localoqh.a("puin", paramString1);
    if (TextUtils.equals((CharSequence)String.valueOf(1), (CharSequence)paramString2))
    {
      paramoqd = "1";
      localoqh.a("is_live", paramoqd);
      if (!TextUtils.equals((CharSequence)String.valueOf(2), (CharSequence)paramString2)) {
        break label145;
      }
    }
    label145:
    for (paramString2 = "1";; paramString2 = "0")
    {
      localoqh.a("is_update", paramString2);
      ((Map)this.jdField_a_of_type_Oqf.d()).put(paramString1, localoqh);
      return;
      paramoqd = "0";
      break;
    }
  }
  
  private final void b(oqd paramoqd)
  {
    QLog.i("RIJChannelBannerController", 1, "[exposeBannerCard] channelBannerInfo = " + paramoqd);
    if (!TextUtils.isEmpty((CharSequence)paramoqd.a())) {
      ((Map)this.jdField_a_of_type_Oqf.a()).put(paramoqd.a(), this.jdField_a_of_type_Oqf.a(paramoqd));
    }
  }
  
  private final void c(oqd paramoqd)
  {
    QLog.i("RIJChannelBannerController", 1, "[clickBannerCard] channelBannerInfo = " + paramoqd);
    if (!TextUtils.isEmpty((CharSequence)paramoqd.a())) {
      ((Map)this.jdField_a_of_type_Oqf.b()).put(paramoqd.a(), this.jdField_a_of_type_Oqf.a(paramoqd));
    }
  }
  
  @Nullable
  public final RIJChannelBannerView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
  }
  
  public final void a()
  {
    Object localObject = pay.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (pks)((QQAppInterface)localObject).getManager(163);
    if (localObject != null)
    {
      localObject = ((pks)localObject).a();
      if (localObject != null)
      {
        localObject = ((pkm)localObject).a();
        if (localObject != null) {
          ((oqc)localObject).a(this.jdField_a_of_type_Int, 1);
        }
      }
    }
  }
  
  public final void a(@NotNull oqd paramoqd)
  {
    Intrinsics.checkParameterIsNotNull(paramoqd, "channelBannerInfo");
    if (!oqi.a.a(this.jdField_a_of_type_Int)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramoqd.b();
      String str = qoe.a().a("default_feeds", (String)localObject);
      QLog.i("RIJChannelBannerController", 1, "[refreshChannelBannerView] pageName = " + (String)localObject);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty((CharSequence)str)))
      {
        QLog.e("RIJChannelBannerController", 1, "[refreshChannelBannerView] pageName or frameTreeJson is empty.");
        return;
      }
      this.jdField_a_of_type_Oqd = paramoqd;
      b(paramoqd);
      paramoqd = PTSComposer.buildComposer((String)localObject, str, paramoqd.c(), this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener, this.jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
    } while (localObject == null);
    ((RIJChannelBannerView)localObject).post((Runnable)new RIJChannelBannerController.refreshChannelBannerView.1(this, paramoqd));
  }
  
  public final void a(boolean paramBoolean)
  {
    QLog.i("RIJChannelBannerController", 1, "[setChannelBannerViewVisibility], visible = " + paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
    if (localObject != null)
    {
      localObject = ((RIJChannelBannerView)localObject).a();
      if (localObject != null) {
        if (!paramBoolean) {
          break label68;
        }
      }
    }
    label68:
    for (int i = 0;; i = 8)
    {
      ((PTSItemView)localObject).setVisibility(i);
      if (!paramBoolean) {
        this.jdField_a_of_type_Oqd = ((oqd)null);
      }
      return;
    }
  }
  
  public final void b()
  {
    oqd localoqd = this.jdField_a_of_type_Oqd;
    if (localoqd != null) {
      a(localoqd);
    }
  }
  
  public final void c()
  {
    this.jdField_a_of_type_Oqf.a();
  }
  
  public final void d()
  {
    oqd localoqd = this.jdField_a_of_type_Oqd;
    if (localoqd != null) {
      b(localoqd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opy
 * JD-Core Version:    0.7.0.1
 */