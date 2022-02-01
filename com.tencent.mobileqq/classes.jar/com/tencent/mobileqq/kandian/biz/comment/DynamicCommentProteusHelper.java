package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusCDNSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicCommentProteusHelper
{
  private static int a = 9;
  private static int c = 2147483647;
  private static String e = "0";
  private final Map<String, Integer> b = new ConcurrentHashMap();
  private BaseTemplateFactory d;
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer != null) && (paramTemplateBean != null))
    {
      if (paramReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      try
      {
        ProteusSupportUtil.a(paramContainer, null, paramTemplateBean);
        if (paramTemplateBean.getViewBean() != null)
        {
          paramVafContext = CommentProteusUtil.a(paramReadinjoyCommentListBaseAdapter, paramVafContext, (CommentViewItem)paramReadinjoyCommentListBaseAdapter.getItem(paramInt1), paramInt2, paramBoolean);
          if (paramVafContext != null)
          {
            paramVafContext.put("ratio", CommentProteusUtil.a());
            paramTemplateBean.bindData(paramVafContext);
            CommentProteusUtil.a(paramContainer, paramReadinjoyCommentListBaseAdapter, (CommentViewItem)paramReadinjoyCommentListBaseAdapter.getItem(paramInt1));
          }
        }
        TraceUtils.traceEnd();
        return;
      }
      catch (JSONException paramVafContext)
      {
        paramContainer = new StringBuilder();
        paramContainer.append("bindData ");
        paramContainer.append(paramVafContext.getMessage());
        QLog.d("DynamicCommentProteusHelper", 2, paramContainer.toString());
      }
    }
  }
  
  private void a(String paramString)
  {
    if (!this.b.containsKey(paramString))
    {
      int i = a;
      if (i < c - 1)
      {
        this.b.put(paramString, Integer.valueOf(i));
        a += 1;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addViewType : ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" TYPE_DYNAMIC_END: ");
        localStringBuilder.append(a);
        localStringBuilder.append("  TYPE_DYNAMIC_MAX_END : ");
        localStringBuilder.append(c);
        QLog.d("DynamicCommentProteusHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static boolean b(CommentViewItem paramCommentViewItem)
  {
    return (paramCommentViewItem != null) && (paramCommentViewItem.c != null) && (paramCommentViewItem.c.isDynamicComment());
  }
  
  public int a()
  {
    int i = c;
    if (i == 2147483647)
    {
      AIOUtils.a("DynamicCommentProteusHelper", "", new IllegalArgumentException(HardCodeUtil.a(2131901681)));
      return a - 8;
    }
    return i - 8;
  }
  
  public TemplateBean a(CommentViewItem paramCommentViewItem)
  {
    TemplateBean localTemplateBean = null;
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.c == null) {
        return null;
      }
      try
      {
        if (this.d != null) {
          localTemplateBean = this.d.getTemplateBean(new JSONObject(paramCommentViewItem.c.styleData));
        }
        return localTemplateBean;
      }
      catch (JSONException paramCommentViewItem)
      {
        paramCommentViewItem.printStackTrace();
      }
    }
    return null;
  }
  
  public void a(VafContext paramVafContext)
  {
    if (paramVafContext == null) {
      return;
    }
    Object localObject = Aladdin.getConfig(228);
    if (localObject != null)
    {
      e = ((AladdinConfig)localObject).getString("comment_feeds", "0");
      localObject = ((AladdinConfig)localObject).getString("comment_feeds_cdn_url", "");
      RIJProteusOfflineBidSp.a("comment_proteus_offline_bid", e);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[init], offline comment pts bid = ");
      localStringBuilder.append(e);
      localStringBuilder.append(", cdnUrl = ");
      localStringBuilder.append((String)localObject);
      QLog.i("DynamicCommentProteusHelper", 1, localStringBuilder.toString());
      RIJProteusCDNSp.a(e, (String)localObject);
    }
    this.d = paramVafContext.getTemplateFactory();
    int j = paramVafContext.getTemplateFactory().size();
    int i = a;
    int k = j + 9;
    if ((i < k) && (j > 0) && (i < c))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      i = a;
      paramVafContext = paramVafContext.iterator();
      while (paramVafContext.hasNext())
      {
        localObject = (String)paramVafContext.next();
        if (!this.b.containsKey(localObject))
        {
          this.b.put(localObject, Integer.valueOf(i));
          i += 1;
        }
      }
      a = k;
      if (c == 2147483647) {
        c = a + 30;
      }
      i = a;
      k = c;
      if (i > k) {
        a = k;
      }
      paramVafContext = new StringBuilder();
      paramVafContext.append("init: commentTemplateCount : ");
      paramVafContext.append(j);
      paramVafContext.append(" TYPE_DYNAMIC_END : ");
      paramVafContext.append(a);
      paramVafContext.append(" max : ");
      paramVafContext.append(c);
      QLog.d("DynamicCommentProteusHelper", 1, paramVafContext.toString());
    }
    if (c == 2147483647) {
      c = 109;
    }
  }
  
  public int c(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.c == null) {
        return 8;
      }
      paramCommentViewItem = paramCommentViewItem.c.styleData;
      if (TextUtils.isEmpty(paramCommentViewItem)) {
        return 8;
      }
      try
      {
        paramCommentViewItem = new JSONObject(paramCommentViewItem).optString("style_ID");
        a(paramCommentViewItem);
        int i = ((Integer)this.b.get(paramCommentViewItem)).intValue();
        return i;
      }
      catch (JSONException paramCommentViewItem)
      {
        paramCommentViewItem.printStackTrace();
        return -1;
      }
    }
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.DynamicCommentProteusHelper
 * JD-Core Version:    0.7.0.1
 */