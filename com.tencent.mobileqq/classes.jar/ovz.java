import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerController.refreshChannelBannerView.1;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.core.PTSComposer;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerController;", "", "channelId", "", "context", "Landroid/content/Context;", "(ILandroid/content/Context;)V", "channelBannerInfo", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule$ChannelBannerInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerModule;", "<set-?>", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerView;", "channelBannerView", "getChannelBannerView", "()Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerView;", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "ptsliteEventListener", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "rijChannelBannerReport", "Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerReport;", "clickBannerCard", "", "clickBannerItem", "uin", "", "avatarStatus", "exposeBannerCard", "exposeBannerItem", "exposeChannelBanner", "init", "loadChannelBannerView", "refreshChannelBannerView", "reportData", "requestChannelBannerData", "updateAvatarStatus", "identifier", "newAvatarStatus", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ovz
{
  public static final owa a;
  private final int jdField_a_of_type_Int;
  @Nullable
  private RIJChannelBannerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
  private PTSComposer jdField_a_of_type_ComTencentPtsCorePTSComposer;
  private IPTSLiteEventListener jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  private owd jdField_a_of_type_Owd;
  private final owf jdField_a_of_type_Owf = new owf();
  
  static
  {
    jdField_a_of_type_Owa = new owa(null);
  }
  
  public ovz(int paramInt, @NotNull Context paramContext)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramInt, paramContext);
  }
  
  private final void a(int paramInt, Context paramContext)
  {
    if (!owi.a.a(paramInt)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView = new RIJChannelBannerView(paramContext);
    this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener = ((IPTSLiteEventListener)new owb(this, paramContext));
    paramContext = pha.a();
    if (paramContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    paramContext = (pmm)((QQAppInterface)paramContext).getManager(163);
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
        this.jdField_a_of_type_Owd = ((owd)paramContext.get(0));
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
          break label205;
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
            break label216;
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
        label205:
        i = 0;
        break label225;
      }
      localObject = null;
      continue;
      label216:
      j += 1;
      continue;
      label225:
      int j = 0;
    }
  }
  
  private final void a(String paramString1, String paramString2, owd paramowd)
  {
    owh localowh = this.jdField_a_of_type_Owf.a(paramowd);
    localowh.a("puin", paramString1);
    if (TextUtils.equals((CharSequence)String.valueOf(1), (CharSequence)paramString2))
    {
      paramowd = "1";
      localowh.a("is_live", paramowd);
      if (!TextUtils.equals((CharSequence)String.valueOf(2), (CharSequence)paramString2)) {
        break label109;
      }
    }
    label109:
    for (paramString2 = "1";; paramString2 = "0")
    {
      localowh.a("is_update", paramString2);
      ((Map)this.jdField_a_of_type_Owf.c()).put(paramString1, localowh);
      return;
      paramowd = "0";
      break;
    }
  }
  
  private final void b(String paramString1, String paramString2, owd paramowd)
  {
    QLog.i("RIJChannelBannerController", 1, "[clickBannerCard] uin = " + paramString1 + ", avatarStatus = " + paramString2);
    owh localowh = this.jdField_a_of_type_Owf.a(paramowd);
    localowh.a("puin", paramString1);
    if (TextUtils.equals((CharSequence)String.valueOf(1), (CharSequence)paramString2))
    {
      paramowd = "1";
      localowh.a("is_live", paramowd);
      if (!TextUtils.equals((CharSequence)String.valueOf(2), (CharSequence)paramString2)) {
        break label145;
      }
    }
    label145:
    for (paramString2 = "1";; paramString2 = "0")
    {
      localowh.a("is_update", paramString2);
      ((Map)this.jdField_a_of_type_Owf.d()).put(paramString1, localowh);
      return;
      paramowd = "0";
      break;
    }
  }
  
  private final void b(owd paramowd)
  {
    QLog.i("RIJChannelBannerController", 1, "[exposeBannerCard] channelBannerInfo = " + paramowd);
    if (!TextUtils.isEmpty((CharSequence)paramowd.a())) {
      ((Map)this.jdField_a_of_type_Owf.a()).put(paramowd.a(), this.jdField_a_of_type_Owf.a(paramowd));
    }
  }
  
  private final void c(owd paramowd)
  {
    QLog.i("RIJChannelBannerController", 1, "[clickBannerCard] channelBannerInfo = " + paramowd);
    if (!TextUtils.isEmpty((CharSequence)paramowd.a())) {
      ((Map)this.jdField_a_of_type_Owf.b()).put(paramowd.a(), this.jdField_a_of_type_Owf.a(paramowd));
    }
  }
  
  @Nullable
  public final RIJChannelBannerView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
  }
  
  public final void a()
  {
    Object localObject = pha.a();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (pmm)((QQAppInterface)localObject).getManager(163);
    if (localObject != null)
    {
      localObject = ((pmm)localObject).a();
      if (localObject != null)
      {
        localObject = ((pmh)localObject).a();
        if (localObject != null) {
          ((owc)localObject).a(this.jdField_a_of_type_Int, 1);
        }
      }
    }
  }
  
  public final void a(@NotNull owd paramowd)
  {
    Intrinsics.checkParameterIsNotNull(paramowd, "channelBannerInfo");
    if (!owi.a.a(this.jdField_a_of_type_Int)) {}
    Object localObject;
    label160:
    do
    {
      return;
      String str1 = paramowd.b();
      String str2 = qpn.a().a("default_feeds", str1);
      QLog.i("RIJChannelBannerController", 1, "[refreshChannelBannerView] pageName = " + str1);
      if ((TextUtils.isEmpty((CharSequence)str1)) || (TextUtils.isEmpty((CharSequence)str2)))
      {
        QLog.e("RIJChannelBannerController", 1, "[refreshChannelBannerView] pageName or frameTreeJson is empty.");
        return;
      }
      this.jdField_a_of_type_Owd = paramowd;
      b(paramowd);
      CharSequence localCharSequence = (CharSequence)str1;
      localObject = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
      if (localObject != null) {}
      for (localObject = ((PTSComposer)localObject).getPageName();; localObject = null)
      {
        if (!TextUtils.equals(localCharSequence, (CharSequence)localObject)) {
          break label160;
        }
        localObject = this.jdField_a_of_type_ComTencentPtsCorePTSComposer;
        if (localObject == null) {
          break;
        }
        ((PTSComposer)localObject).setData(paramowd.c());
        return;
      }
      paramowd = PTSComposer.buildComposer(str1, str2, paramowd.c(), this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelbannerRIJChannelBannerView;
    } while (localObject == null);
    ((RIJChannelBannerView)localObject).post((Runnable)new RIJChannelBannerController.refreshChannelBannerView.1(this, paramowd));
  }
  
  public final void b()
  {
    owd localowd = this.jdField_a_of_type_Owd;
    if (localowd != null) {
      a(localowd);
    }
  }
  
  public final void c()
  {
    this.jdField_a_of_type_Owf.a();
  }
  
  public final void d()
  {
    owd localowd = this.jdField_a_of_type_Owd;
    if (localowd != null) {
      b(localowd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovz
 * JD-Core Version:    0.7.0.1
 */