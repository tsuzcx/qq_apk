import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BackOffGroupInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/AritcleInfoModuleUtils$CommonChannelDataHandle;", "", "()V", "handleNearbyCookie", "", "cookie", "Lcom/tencent/mobileqq/pb/PBBytesField;", "handleUGBackoffGroupInfos", "articleList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "rulesData", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$BackOffGroupInfo;", "channelID", "", "parseArticleList", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "refreshType", "recommendFlag", "pbData", "Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pol
{
  public static final pol a = new pol();
  
  @Nullable
  public final List<ArticleInfo> a(@NotNull ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, int paramInt3, @NotNull PBRepeatMessageField<articlesummary.ArticleSummary> paramPBRepeatMessageField)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "pbData");
    if ((!paramPBRepeatMessageField.has()) || (paramPBRepeatMessageField.get() == null)) {
      return null;
    }
    List localList = qfn.a(paramPBRepeatMessageField.get(), paramInt1, paramInt2, paramInt3);
    if (ozf.a()) {
      ozf.a().a(paramPBRepeatMessageField.get(), localList, paramInt1);
    }
    paramToServiceMsg = paramToServiceMsg.getAttributes().get("SubscriptionArticles");
    paa localpaa;
    if (((paramToServiceMsg instanceof List)) && (((List)paramToServiceMsg).size() > 0))
    {
      if (localList == null) {
        break label326;
      }
      paramInt1 = localList.size();
      if (paramInt1 > 0)
      {
        paramPBRepeatMessageField = StringCompanionObject.INSTANCE;
        paramPBRepeatMessageField = new Object[2];
        paramPBRepeatMessageField[0] = ((List)paramToServiceMsg).get(0);
        paramPBRepeatMessageField[1] = Long.valueOf(((ArticleInfo)localList.get(0)).mArticleID);
        paramPBRepeatMessageField = String.format("red point article (%d)  server's first article(%d)", Arrays.copyOf(paramPBRepeatMessageField, paramPBRepeatMessageField.length));
        Intrinsics.checkExpressionValueIsNotNull(paramPBRepeatMessageField, "java.lang.String.format(format, *args)");
        QLog.d("ArticleInfoModule", 1, paramPBRepeatMessageField);
        if ((Intrinsics.areEqual(((List)paramToServiceMsg).get(0), Long.valueOf(((ArticleInfo)localList.get(0)).mArticleID)) ^ true))
        {
          localpaa = ozs.a();
          paramPBRepeatMessageField = ((List)paramToServiceMsg).get(0);
          paramToServiceMsg = paramPBRepeatMessageField;
          if (!(paramPBRepeatMessageField instanceof Long)) {
            paramToServiceMsg = null;
          }
          paramToServiceMsg = (Long)paramToServiceMsg;
          if (paramToServiceMsg == null) {
            break label331;
          }
        }
      }
    }
    label326:
    label331:
    for (long l = paramToServiceMsg.longValue();; l = -1L)
    {
      localpaa.a("red_article", l);
      localpaa.a("feed_first_article", ((ArticleInfo)localList.get(0)).mArticleID);
      ocd.a(null, "0X8009650", "0X8009650", "", 0, 0, "", "", "", localpaa.toString(), false);
      return localList;
      paramInt1 = 0;
      break;
    }
  }
  
  public final void a(@NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "cookie");
    paramPBBytesField = qfm.a(paramPBBytesField);
    QLog.d("ArticleInfoModule", 1, "nearby cookie = " + paramPBBytesField);
    if (!TextUtils.isEmpty((CharSequence)paramPBBytesField))
    {
      bnrf.a("sp_key_daily_dynamic_header_data", paramPBBytesField);
      pfa.a().i(paramPBBytesField);
      bnrf.a("readinjoy_nearby_people_last_refresh_cookie_sp_key", paramPBBytesField);
      pbd.a(paramPBBytesField);
    }
  }
  
  public final void a(@Nullable List<? extends ArticleInfo> paramList, @NotNull PBRepeatMessageField<oidb_cmd0x68b.BackOffGroupInfo> paramPBRepeatMessageField, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "rulesData");
    if ((paramPBRepeatMessageField.has()) && (paramPBRepeatMessageField.get() != null))
    {
      quy localquy = new quy();
      localquy.b = paramList;
      localquy.jdField_a_of_type_JavaUtilList = paramPBRepeatMessageField.get();
      localquy.jdField_a_of_type_Int = paramInt;
      qur.a().a(localquy, qur.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pol
 * JD-Core Version:    0.7.0.1
 */