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
  private static int jdField_a_of_type_Int = 9;
  private static String jdField_a_of_type_JavaLangString = "0";
  private static int b = 2147483647;
  private BaseTemplateFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory;
  private final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
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
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      int i = jdField_a_of_type_Int;
      if (i < b - 1)
      {
        this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i));
        jdField_a_of_type_Int += 1;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addViewType : ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" TYPE_DYNAMIC_END: ");
        localStringBuilder.append(jdField_a_of_type_Int);
        localStringBuilder.append("  TYPE_DYNAMIC_MAX_END : ");
        localStringBuilder.append(b);
        QLog.d("DynamicCommentProteusHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static boolean a(CommentViewItem paramCommentViewItem)
  {
    return (paramCommentViewItem != null) && (paramCommentViewItem.a != null) && (paramCommentViewItem.a.isDynamicComment());
  }
  
  public int a()
  {
    int i = b;
    if (i == 2147483647)
    {
      AIOUtils.a("DynamicCommentProteusHelper", "", new IllegalArgumentException(HardCodeUtil.a(2131703735)));
      return jdField_a_of_type_Int - 8;
    }
    return i - 8;
  }
  
  public int a(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.a == null) {
        return 8;
      }
      paramCommentViewItem = paramCommentViewItem.a.styleData;
      if (TextUtils.isEmpty(paramCommentViewItem)) {
        return 8;
      }
      try
      {
        paramCommentViewItem = new JSONObject(paramCommentViewItem).optString("style_ID");
        a(paramCommentViewItem);
        int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramCommentViewItem)).intValue();
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
  
  public TemplateBean a(CommentViewItem paramCommentViewItem)
  {
    TemplateBean localTemplateBean = null;
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.a == null) {
        return null;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory != null) {
          localTemplateBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory.getTemplateBean(new JSONObject(paramCommentViewItem.a.styleData));
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
      jdField_a_of_type_JavaLangString = ((AladdinConfig)localObject).getString("comment_feeds", "0");
      localObject = ((AladdinConfig)localObject).getString("comment_feeds_cdn_url", "");
      RIJProteusOfflineBidSp.a("comment_proteus_offline_bid", jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[init], offline comment pts bid = ");
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", cdnUrl = ");
      localStringBuilder.append((String)localObject);
      QLog.i("DynamicCommentProteusHelper", 1, localStringBuilder.toString());
      RIJProteusCDNSp.a(jdField_a_of_type_JavaLangString, (String)localObject);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory = paramVafContext.getTemplateFactory();
    int j = paramVafContext.getTemplateFactory().size();
    int i = jdField_a_of_type_Int;
    int k = j + 9;
    if ((i < k) && (j > 0) && (i < b))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      i = jdField_a_of_type_Int;
      paramVafContext = paramVafContext.iterator();
      while (paramVafContext.hasNext())
      {
        localObject = (String)paramVafContext.next();
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
        {
          this.jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(i));
          i += 1;
        }
      }
      jdField_a_of_type_Int = k;
      if (b == 2147483647) {
        b = jdField_a_of_type_Int + 30;
      }
      i = jdField_a_of_type_Int;
      k = b;
      if (i > k) {
        jdField_a_of_type_Int = k;
      }
      paramVafContext = new StringBuilder();
      paramVafContext.append("init: commentTemplateCount : ");
      paramVafContext.append(j);
      paramVafContext.append(" TYPE_DYNAMIC_END : ");
      paramVafContext.append(jdField_a_of_type_Int);
      paramVafContext.append(" max : ");
      paramVafContext.append(b);
      QLog.d("DynamicCommentProteusHelper", 1, paramVafContext.toString());
    }
    if (b == 2147483647) {
      b = 109;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.DynamicCommentProteusHelper
 * JD-Core Version:    0.7.0.1
 */