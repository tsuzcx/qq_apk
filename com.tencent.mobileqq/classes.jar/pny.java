import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/RIJActivityResultHandler;", "", "requestCode", "", "resultCode", "intent", "Landroid/content/Intent;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "currentActivity", "Landroid/app/Activity;", "channelID", "dataFetchManager", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataFetchManager;", "(IILandroid/content/Intent;Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;Landroid/app/Activity;ILcom/tencent/biz/pubaccount/readinjoy/decoupling/accesslayer/data/RIJDataFetchManager;)V", "requestCodeToFunctionMap", "", "", "handleAdvertisementResult", "handleChatActivityResult", "handleCommentResult", "handleDeliverWenDaResult", "handleFastWebActivityResult", "handleOnActivityResult", "handleShareReport", "handleSocialTipMessageBox", "notifyAdapterRefresh", "what", "data", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pny
{
  @JvmField
  public int a;
  @JvmField
  @NotNull
  public Activity a;
  @JvmField
  @Nullable
  public Intent a;
  private final Map<Object, Unit> a;
  @JvmField
  @NotNull
  public pmz a;
  @JvmField
  @NotNull
  public szd a;
  @JvmField
  public int b;
  @JvmField
  public int c;
  
  public pny(int paramInt1, int paramInt2, @Nullable Intent paramIntent, @NotNull szd paramszd, @NotNull Activity paramActivity, int paramInt3, @NotNull pmz parampmz)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Szd = paramszd;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.c = paramInt3;
    this.jdField_a_of_type_Pmz = parampmz;
    paramActivity = new Pair[14];
    paramIntent = this.jdField_a_of_type_AndroidContentIntent;
    if (paramIntent != null)
    {
      a(2, paramIntent);
      paramszd = Unit.INSTANCE;
      paramIntent = paramActivity;
      paramActivity[0] = TuplesKt.to(Integer.valueOf(9991), paramszd);
      paramszd = this.jdField_a_of_type_AndroidContentIntent;
      if (paramszd == null) {
        break label442;
      }
      a(0, paramszd);
      paramActivity = Unit.INSTANCE;
      label132:
      paramszd = paramIntent;
      paramIntent[1] = TuplesKt.to(Integer.valueOf(9091), paramActivity);
      a();
      paramszd[2] = TuplesKt.to(Integer.valueOf(21), Unit.INSTANCE);
      b();
      paramszd[3] = TuplesKt.to(Integer.valueOf(19202), Unit.INSTANCE);
      b();
      paramszd[4] = TuplesKt.to(Byte.valueOf(125), Unit.INSTANCE);
      paramIntent = this.jdField_a_of_type_AndroidContentIntent;
      if (paramIntent == null) {
        break label448;
      }
      a(2, paramIntent);
      paramActivity = Unit.INSTANCE;
      label227:
      paramIntent = paramszd;
      paramszd[5] = TuplesKt.to(Integer.valueOf(2), paramActivity);
      paramszd = this.jdField_a_of_type_AndroidContentIntent;
      if (paramszd == null) {
        break label454;
      }
      a(1, paramszd);
    }
    label442:
    label448:
    label454:
    for (paramszd = Unit.INSTANCE;; paramszd = null)
    {
      paramActivity = paramIntent;
      paramIntent[6] = TuplesKt.to(Integer.valueOf(1), paramszd);
      c();
      paramActivity[7] = TuplesKt.to(Integer.valueOf(10922), Unit.INSTANCE);
      d();
      paramActivity[8] = TuplesKt.to(Integer.valueOf(20001), Unit.INSTANCE);
      e();
      paramActivity[9] = TuplesKt.to(Integer.valueOf(1032), Unit.INSTANCE);
      f();
      paramActivity[10] = TuplesKt.to(Integer.valueOf(9999), Unit.INSTANCE);
      b();
      paramActivity[11] = TuplesKt.to(Integer.valueOf(102), Unit.INSTANCE);
      b();
      paramActivity[12] = TuplesKt.to(Integer.valueOf(55577), Unit.INSTANCE);
      g();
      paramActivity[13] = TuplesKt.to(Byte.valueOf(117), Unit.INSTANCE);
      this.jdField_a_of_type_JavaUtilMap = MapsKt.mapOf(paramActivity);
      return;
      paramszd = null;
      break;
      paramActivity = null;
      break label132;
      paramActivity = null;
      break label227;
    }
  }
  
  private final void a()
  {
    if ((this.b == -1) && (this.jdField_a_of_type_AndroidContentIntent != null))
    {
      localObject = pkh.a();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      }
      ForwardUtils.handleForwardData((QQAppInterface)localObject, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_AndroidContentIntent, null);
    }
    Object localObject = uva.a;
    if (-1 == this.b) {}
    for (boolean bool = true;; bool = false)
    {
      ((uva)localObject).a(bool);
      return;
    }
  }
  
  private final void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_Szd.a(paramInt, paramIntent);
  }
  
  private final void b()
  {
    uva localuva = uva.a;
    if (-1 == this.b) {}
    for (boolean bool = true;; bool = false)
    {
      localuva.a(bool);
      return;
    }
  }
  
  private final void c()
  {
    if (this.b == -10069)
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent;
      if (localObject == null) {
        break label61;
      }
      localObject = ((Intent)localObject).getExtras();
      if (localObject == null) {
        break label61;
      }
    }
    label61:
    for (Object localObject = ((Bundle)localObject).get("fast_web_article_info");; localObject = null)
    {
      localObject = (ArticleInfo)localObject;
      if (localObject != null) {
        pqx.a(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject, this.jdField_a_of_type_Szd, this.c);
      }
      return;
    }
  }
  
  private final void d()
  {
    Object localObject = pkh.a();
    if (localObject != null)
    {
      localObject = ((AppRuntime)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager");
      }
      ((KandianMergeManager)localObject).q();
      QLog.d("ReadInJoyListViewGroup", 1, "back from msgbox page, setRead!");
    }
  }
  
  private final void e()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_AndroidContentIntent;
    if (localObject2 != null) {
      localObject1 = ((Intent)localObject2).getStringExtra("arg_result_json");
    }
    if (localObject1 != null) {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("channel_id", this.c);
          ((JSONObject)localObject2).put("rowkey", ((JSONObject)localObject1).optString("rowkey"));
          ((JSONObject)localObject2).put("topicid", "");
          olh.a(null, "CliOper", "", "", "0X800982D", "0X800982D", 0, 0, ((JSONObject)localObject1).optString("feedsId") + "", "2", "", ((JSONObject)localObject2).toString(), false);
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("ReadInJoyListViewGroup", 1, "REQ_CODE_DELIVER_WENDA wrong json : e = " + localException1);
      }
    }
  }
  
  private final void f()
  {
    if (this.b == -1)
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent;
      if (localObject == null) {
        break label43;
      }
    }
    label43:
    for (Object localObject = ((Intent)localObject).getParcelableExtra("key_ad_info");; localObject = null)
    {
      localObject = (AdvertisementInfo)localObject;
      if (localObject != null) {
        this.jdField_a_of_type_Szd.a((AdvertisementInfo)localObject);
      }
      return;
    }
  }
  
  private final void g()
  {
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent;
      if (localObject == null) {
        break label48;
      }
    }
    label48:
    for (Object localObject = (ArticleInfo)((Intent)localObject).getParcelableExtra("comment_article_info");; localObject = null)
    {
      if (localObject != null) {
        this.jdField_a_of_type_Pmz.a(this.b, (ArticleInfo)localObject, this.jdField_a_of_type_AndroidContentIntent);
      }
      return;
    }
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pny
 * JD-Core Version:    0.7.0.1
 */