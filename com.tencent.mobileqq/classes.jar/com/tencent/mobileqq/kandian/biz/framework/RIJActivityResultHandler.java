package com.tencent.mobileqq.kandian.biz.framework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/RIJActivityResultHandler;", "", "adapter", "Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "currentActivity", "Landroid/app/Activity;", "channelID", "", "dataFetchManager", "Lcom/tencent/mobileqq/kandian/biz/accesslayer/data/RIJDataFetchManager;", "(Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;Landroid/app/Activity;ILcom/tencent/mobileqq/kandian/biz/accesslayer/data/RIJDataFetchManager;)V", "methodsMap", "", "Lkotlin/Function3;", "Landroid/content/Intent;", "", "addShareCount", "resultCode", "handleAdvertisementResultFunc", "what", "intent", "handleChatActivityResultFunc", "handleCommentResultFunc", "handleDeliverWenDaResultFunc", "handleFastWebActivityResultFunc", "handleShareReportFunc", "handleSocialTipMessageBoxFunc", "invokeMethod", "requestCode", "notifyAdapterRefreshFunc", "registerRequestCodeToFunctionMap", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJActivityResultHandler
{
  @JvmField
  @NotNull
  public ReadInJoyBaseAdapter a;
  @JvmField
  @NotNull
  public Activity b;
  @JvmField
  public int c;
  @JvmField
  @NotNull
  public RIJDataFetchManager d;
  private final Map<Integer, Function3<Integer, Integer, Intent, Unit>> e;
  
  public RIJActivityResultHandler(@NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @NotNull Activity paramActivity, int paramInt, @NotNull RIJDataFetchManager paramRIJDataFetchManager)
  {
    this.a = paramReadInJoyBaseAdapter;
    this.b = paramActivity;
    this.c = paramInt;
    this.d = paramRIJDataFetchManager;
    this.e = ((Map)new LinkedHashMap());
    a();
  }
  
  private final void a()
  {
    Map localMap = this.e;
    RIJActivityResultHandler localRIJActivityResultHandler = (RIJActivityResultHandler)this;
    localMap.put(Integer.valueOf(9991), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.1(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(9091), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.2(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(21), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.3(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(19202), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.4(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(125), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.5(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(2), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.6(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(1), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.7(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(10922), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.8(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(20001), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.9(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(1032), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.10(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(9999), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.11(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(102), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.12(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(55577), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.13(localRIJActivityResultHandler));
    this.e.put(Integer.valueOf(117), new RIJActivityResultHandler.registerRequestCodeToFunctionMap.14(localRIJActivityResultHandler));
  }
  
  private final void a(int paramInt)
  {
    if (-1 == paramInt) {
      ReadInJoyLogicEngine.a().O();
    }
  }
  
  private final void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.a(paramInt2, paramIntent);
  }
  
  private final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == -1) && (paramIntent != null))
    {
      Object localObject = ReadInJoyUtils.b();
      if (localObject != null)
      {
        localObject = (QQAppInterface)localObject;
        Activity localActivity = this.b;
        ForwardUtils.a((QQAppInterface)localObject, localActivity, localActivity.getApplicationContext(), paramIntent, null);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      }
    }
    paramIntent = ShareReport.a;
    boolean bool;
    if (-1 == paramInt1) {
      bool = true;
    } else {
      bool = false;
    }
    paramIntent.a(bool);
    a(paramInt1);
  }
  
  private final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = ShareReport.a;
    boolean bool;
    if (-1 == paramInt1) {
      bool = true;
    } else {
      bool = false;
    }
    paramIntent.a(bool);
    a(paramInt1);
  }
  
  private final void e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == -10069)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null)
        {
          paramIntent = paramIntent.get("fast_web_article_info");
          break label32;
        }
      }
      paramIntent = null;
      label32:
      paramIntent = (AbsBaseArticleInfo)paramIntent;
      if (paramIntent != null) {
        RIJJumpUtils.a(this.b, paramIntent, this.a, this.c);
      }
    }
  }
  
  private final void f(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = ReadInJoyUtils.b();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (paramIntent != null)
      {
        ((KandianMergeManager)paramIntent).T();
        QLog.d("ReadInJoyListViewGroup", 1, "back from msgbox page, setRead!");
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
    }
  }
  
  private final void g(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("arg_result_json");
    } else {
      paramIntent = null;
    }
    if (paramIntent != null)
    {
      Object localObject;
      try
      {
        paramIntent = new JSONObject(paramIntent);
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("channel_id", this.c);
          ((JSONObject)localObject).put("rowkey", paramIntent.optString("rowkey"));
          ((JSONObject)localObject).put("topicid", "");
        }
        catch (Exception localException) {}
        try
        {
          localException.printStackTrace();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramIntent.optString("feedsId"));
          localStringBuilder.append("");
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800982D", "0X800982D", 0, 0, localStringBuilder.toString(), "2", "", ((JSONObject)localObject).toString(), false);
          return;
        }
        catch (Exception paramIntent) {}
        localObject = new StringBuilder();
      }
      catch (Exception paramIntent) {}
      ((StringBuilder)localObject).append("REQ_CODE_DELIVER_WENDA wrong json : e = ");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.e("ReadInJoyListViewGroup", 1, ((StringBuilder)localObject).toString());
      return;
    }
  }
  
  private final void h(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == -1)
    {
      if (paramIntent != null) {
        paramIntent = paramIntent.getParcelableExtra("key_ad_info");
      } else {
        paramIntent = null;
      }
      paramIntent = (AdvertisementInfo)paramIntent;
      if (paramIntent != null) {
        this.a.a(paramIntent);
      }
    }
  }
  
  private final void i(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
      if (localBaseArticleInfo != null) {
        this.d.a(paramInt1, (AbsBaseArticleInfo)localBaseArticleInfo, paramIntent);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    Function3 localFunction3;
    if ((paramInt1 != 9991) && (paramInt1 != 2))
    {
      if (paramInt1 == 9091)
      {
        localFunction3 = (Function3)this.e.get(Integer.valueOf(paramInt1));
        if (localFunction3 != null) {
          paramIntent = (Unit)localFunction3.invoke(Integer.valueOf(paramInt2), Integer.valueOf(0), paramIntent);
        }
      }
      else if (paramInt1 == 1)
      {
        localFunction3 = (Function3)this.e.get(Integer.valueOf(paramInt1));
        if (localFunction3 != null) {
          paramIntent = (Unit)localFunction3.invoke(Integer.valueOf(paramInt2), Integer.valueOf(1), paramIntent);
        }
      }
      else
      {
        localFunction3 = (Function3)this.e.get(Integer.valueOf(paramInt1));
        if (localFunction3 != null) {
          paramIntent = (Unit)localFunction3.invoke(Integer.valueOf(paramInt2), Integer.valueOf(0), paramIntent);
        }
      }
    }
    else
    {
      localFunction3 = (Function3)this.e.get(Integer.valueOf(paramInt1));
      if (localFunction3 != null) {
        paramIntent = (Unit)localFunction3.invoke(Integer.valueOf(paramInt2), Integer.valueOf(2), paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJActivityResultHandler
 * JD-Core Version:    0.7.0.1
 */