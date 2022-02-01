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
public final class oom
{
  public static final oon a;
  private final int jdField_a_of_type_Int;
  @Nullable
  private RIJChannelBannerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
  private final PTSComposer.IPTSUpdateDataListener jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener = (PTSComposer.IPTSUpdateDataListener)new oop(this);
  private PTSComposer jdField_a_of_type_ComTencentPtsCorePTSComposer;
  private IPTSLiteEventListener jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  private oor jdField_a_of_type_Oor;
  private final oot jdField_a_of_type_Oot = new oot();
  
  static
  {
    jdField_a_of_type_Oon = new oon(null);
  }
  
  public oom(int paramInt, @NotNull Context paramContext)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramInt, paramContext);
  }
  
  private final void a(int paramInt, Context paramContext)
  {
    if (!oow.a.a(paramInt)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView = new RIJChannelBannerView(paramContext);
    this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener = ((IPTSLiteEventListener)new ooo(this, paramContext));
    paramContext = ozs.a();
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    paramContext = (pfg)((QQAppInterface)paramContext).getManager(163);
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
        this.jdField_a_of_type_Oor = ((oor)paramContext.get(0));
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
  
  private final void a(String paramString1, String paramString2, oor paramoor)
  {
    oov localoov = this.jdField_a_of_type_Oot.a(paramoor);
    localoov.a("puin", paramString1);
    if (TextUtils.equals((CharSequence)String.valueOf(1), (CharSequence)paramString2))
    {
      paramoor = "1";
      localoov.a("is_live", paramoor);
      if (!TextUtils.equals((CharSequence)String.valueOf(2), (CharSequence)paramString2)) {
        break label109;
      }
    }
    label109:
    for (paramString2 = "1";; paramString2 = "0")
    {
      localoov.a("is_update", paramString2);
      ((Map)this.jdField_a_of_type_Oot.c()).put(paramString1, localoov);
      return;
      paramoor = "0";
      break;
    }
  }
  
  private final void b(String paramString1, String paramString2, oor paramoor)
  {
    QLog.i("RIJChannelBannerController", 1, "[clickBannerCard] uin = " + paramString1 + ", avatarStatus = " + paramString2);
    oov localoov = this.jdField_a_of_type_Oot.a(paramoor);
    localoov.a("puin", paramString1);
    if (TextUtils.equals((CharSequence)String.valueOf(1), (CharSequence)paramString2))
    {
      paramoor = "1";
      localoov.a("is_live", paramoor);
      if (!TextUtils.equals((CharSequence)String.valueOf(2), (CharSequence)paramString2)) {
        break label145;
      }
    }
    label145:
    for (paramString2 = "1";; paramString2 = "0")
    {
      localoov.a("is_update", paramString2);
      ((Map)this.jdField_a_of_type_Oot.d()).put(paramString1, localoov);
      return;
      paramoor = "0";
      break;
    }
  }
  
  private final void b(oor paramoor)
  {
    QLog.i("RIJChannelBannerController", 1, "[exposeBannerCard] channelBannerInfo = " + paramoor);
    if (!TextUtils.isEmpty((CharSequence)paramoor.a())) {
      ((Map)this.jdField_a_of_type_Oot.a()).put(paramoor.a(), this.jdField_a_of_type_Oot.a(paramoor));
    }
  }
  
  private final void c(oor paramoor)
  {
    QLog.i("RIJChannelBannerController", 1, "[clickBannerCard] channelBannerInfo = " + paramoor);
    if (!TextUtils.isEmpty((CharSequence)paramoor.a())) {
      ((Map)this.jdField_a_of_type_Oot.b()).put(paramoor.a(), this.jdField_a_of_type_Oot.a(paramoor));
    }
  }
  
  @Nullable
  public final RIJChannelBannerView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
  }
  
  public final void a()
  {
    Object localObject = ozs.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (pfg)((QQAppInterface)localObject).getManager(163);
    if (localObject != null)
    {
      localObject = ((pfg)localObject).a();
      if (localObject != null)
      {
        localObject = ((pfa)localObject).a();
        if (localObject != null) {
          ((ooq)localObject).a(this.jdField_a_of_type_Int, 1);
        }
      }
    }
  }
  
  public final void a(@NotNull oor paramoor)
  {
    Intrinsics.checkParameterIsNotNull(paramoor, "channelBannerInfo");
    if (!oow.a.a(this.jdField_a_of_type_Int)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramoor.b();
      String str = qib.a().a("default_feeds", (String)localObject);
      QLog.i("RIJChannelBannerController", 1, "[refreshChannelBannerView] pageName = " + (String)localObject);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty((CharSequence)str)))
      {
        QLog.e("RIJChannelBannerController", 1, "[refreshChannelBannerView] pageName or frameTreeJson is empty.");
        return;
      }
      this.jdField_a_of_type_Oor = paramoor;
      b(paramoor);
      paramoor = PTSComposer.buildComposer((String)localObject, str, paramoor.c(), this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener, this.jdField_a_of_type_ComTencentPtsCorePTSComposer$IPTSUpdateDataListener);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
    } while (localObject == null);
    ((RIJChannelBannerView)localObject).post((Runnable)new RIJChannelBannerController.refreshChannelBannerView.1(this, paramoor));
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
        this.jdField_a_of_type_Oor = ((oor)null);
      }
      return;
    }
  }
  
  public final void b()
  {
    oor localoor = this.jdField_a_of_type_Oor;
    if (localoor != null) {
      a(localoor);
    }
  }
  
  public final void c()
  {
    this.jdField_a_of_type_Oot.a();
  }
  
  public final void d()
  {
    oor localoor = this.jdField_a_of_type_Oor;
    if (localoor != null) {
      b(localoor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oom
 * JD-Core Version:    0.7.0.1
 */