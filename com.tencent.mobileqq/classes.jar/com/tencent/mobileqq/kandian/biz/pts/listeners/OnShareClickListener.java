package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OnShareClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a = null;
  private Context b;
  private ReadInJoyShareHelperV2 c;
  private QShareUtils d;
  private FastWebShareUtils e;
  private String f;
  private int g;
  private String h;
  private int i = -1;
  
  public OnShareClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      RIJTransMergeKanDianReport.a(localJSONObject, paramAbsBaseArticleInfo);
      localJSONObject.put("feed_type", 1043);
      localJSONObject.put("version", VideoReporter.a);
      localJSONObject.put("os", "1");
      if (paramAbsBaseArticleInfo != null)
      {
        localJSONObject.put("comment_id", paramAbsBaseArticleInfo.commentId);
        localJSONObject.put("entry", paramAbsBaseArticleInfo.commentSrc);
      }
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mChannelID == 0L)) {
        localJSONObject.put("place", 1);
      } else if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mChannelID == 70L)) {
        localJSONObject.put("place", 2);
      }
      paramAbsBaseArticleInfo = localJSONObject.toString();
      return paramAbsBaseArticleInfo;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      QLog.d("OnShareClickListener", 2, paramAbsBaseArticleInfo.getMessage());
    }
    return "";
  }
  
  private List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(13));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    return localArrayList;
  }
  
  private void a(ViewBase paramViewBase)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.c = new ReadInJoyShareHelperV2((Activity)paramViewBase.getNativeView().getContext(), (AppInterface)localObject1, new OnShareClickListener.ItemSheetClickProcessor(this, this.a, new WeakReference((Activity)paramViewBase.getNativeView().getContext())));
    paramViewBase.getNativeView().addOnAttachStateChangeListener(new OnShareClickListener.1(this));
    paramViewBase = this.c.f().getIntent();
    if ((paramViewBase != null) && (TextUtils.isEmpty(paramViewBase.getStringExtra("big_brother_source_key")))) {
      paramViewBase.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    this.c.a().setActionSheetTitle(HardCodeUtil.a(2131911054));
    paramViewBase = this.a.mArticleContentUrl;
    boolean bool = RIJItemViewTypeUtils.l(this.a);
    localObject1 = "";
    int j;
    if (bool)
    {
      j = 15;
    }
    else if (RIJItemViewTypeUtils.d(this.a))
    {
      j = 16;
    }
    else if (RIJItemViewTypeUtils.h(this.a))
    {
      j = 12;
    }
    else if (RIJItemViewTypeUtils.E(this.a))
    {
      paramViewBase = this.a;
      if (paramViewBase != null) {
        paramViewBase = paramViewBase.mOriginalUrl;
      } else {
        paramViewBase = "";
      }
      j = 28;
    }
    else
    {
      j = 0;
    }
    if (paramViewBase != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramViewBase);
      ((StringBuilder)localObject2).append("&rowkey=");
      ((StringBuilder)localObject2).append(this.a.innerUniqueID);
      ((StringBuilder)localObject2).toString();
    }
    ShareReport.a.a(this.a);
    Object localObject2 = this.c;
    List localList = a();
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    paramViewBase = (ViewBase)localObject1;
    if (localAbsBaseArticleInfo != null) {
      paramViewBase = localAbsBaseArticleInfo.innerUniqueID;
    }
    ((ReadInJoyShareHelperV2)localObject2).a(new List[] { localList }, j, paramViewBase);
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str1 = a(paramAbsBaseArticleInfo);
    Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
    String str2 = paramAbsBaseArticleInfo.mSubscribeID;
    long l1 = ((SocializeFeedsInfo)localObject).a;
    long l2 = paramAbsBaseArticleInfo.mArticleID;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
    PublicAccountReportUtils.a(null, str2, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject).toString(), str1, false);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a(paramViewBase);
    paramViewBase = this.a;
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = paramViewBase;
    b(paramViewBase);
    RIJFeedsDynamicInsertController.INSTANCE.requestDynamicInsertInTL(this.a, new RIJFeedsInsertAction(ActionType.ACTION_SHARE, 0, 0, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnShareClickListener
 * JD-Core Version:    0.7.0.1
 */