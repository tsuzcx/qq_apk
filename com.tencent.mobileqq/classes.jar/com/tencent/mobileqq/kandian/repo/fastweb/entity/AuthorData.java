package com.tencent.mobileqq.kandian.repo.fastweb.entity;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyFromSelf;
import com.tencent.mobileqq.kandian.base.ktx.JSONObjectExtensionsKt;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@IgnoreDenyDependencyFromSelf
public class AuthorData
  extends ProteusItemData
{
  public String a;
  public String b;
  public String c;
  public String d;
  public long e;
  public String f;
  public AbsBaseArticleInfo g;
  public String h;
  public String i;
  public boolean j;
  
  public AuthorData(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    super(25);
    this.g = paramAbsBaseArticleInfo;
    this.aR = paramFastWebArticleInfo;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k;
    if ((this.aR != null) && (this.aR.a())) {
      k = 1;
    } else {
      k = 0;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (k != 0) {
          localJSONObject.put("style_ID", "ReadInjoy_article_relocated_header_cell");
        } else {
          localJSONObject.put("style_ID", "ReadInjoy_article_header_cell");
        }
        localJSONObject.put("avatar_url", this.a);
        localJSONObject.put("avatar_uin", this.c);
        localJSONObject.put("nickname_text", this.b);
        localJSONObject.put("timestamp_text", this.d);
        if (this.aR != null) {
          localJSONObject.put("dt_rowkey", this.aR.q);
        }
        localJSONObject.put("dt_puin", this.c);
        FastWebPTSDataConverter.a(this.g, localJSONObject);
        a(paramBoolean1, paramBoolean2, localJSONObject);
        JSONObjectExtensionsKt.a(localJSONObject, "ringUrl", this.h, "");
        JSONObjectExtensionsKt.a(localJSONObject, "liveStatusUrl", this.i, "");
        Object localObject1 = this.bc;
        if (localObject1 != null) {
          try
          {
            localObject1 = new JSONObject(this.bc);
            Iterator localIterator = ((JSONObject)localObject1).keys();
            if (localIterator != null) {
              if (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                localJSONObject.put(str, ((JSONObject)localObject1).opt(str));
                continue;
              }
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("merge result: ");
            ((StringBuilder)localObject1).append(localJSONObject.toString());
            QLog.d("AuthorData", 2, ((StringBuilder)localObject1).toString());
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
        Object localObject2 = TemplateFactory.a("native_article", true);
        if (localObject2 == null) {
          break label399;
        }
        localObject2 = ((TemplateFactory)localObject2).getTemplateBean(localJSONObject);
        if (localObject2 != null)
        {
          this.bd = ((TemplateBean)localObject2);
          this.bb = localJSONObject;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("bindAuthorData: ");
          ((StringBuilder)localObject2).append(this.bb);
          QLog.d("AuthorData", 1, ((StringBuilder)localObject2).toString());
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      return;
      label399:
      Object localObject3 = null;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, JSONObject paramJSONObject)
  {
    FastWebPTSDataConverter.a(this.g, paramJSONObject, paramBoolean1);
    this.j = paramBoolean1;
  }
  
  private long b()
  {
    try
    {
      long l = Long.parseLong(this.g.mSubscribeID);
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return 0L;
  }
  
  public void a()
  {
    a(FollowListInfoModule.a(this.g.getSubscribeUin(), null), false);
  }
  
  public void a(IFollowStatusObserver paramIFollowStatusObserver)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.g;
    if (localAbsBaseArticleInfo != null) {
      c(FollowListInfoModule.a(localAbsBaseArticleInfo.getSubscribeUin(), paramIFollowStatusObserver));
    }
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
    a();
  }
  
  public void a(Map<Long, FollowingMember> paramMap)
  {
    int k = FastWebPTSUtils.a(this.g.getSubscribeUin(), paramMap);
    if (k != -1)
    {
      boolean bool = true;
      if (k != 1) {
        bool = false;
      }
      c(bool);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }
  
  public void b(String paramString)
  {
    this.i = paramString;
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.j)
    {
      a(true);
      FastWebPTSUtils.a(this.g, this.aR, b(), this.a, paramBoolean);
      if (this.g != null) {
        RIJFeedsInsertUtil.a.a(this.g.mChannelID, this.g.innerUniqueID, this.g.mSubscribeID);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean != this.j) {
      a(paramBoolean, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData
 * JD-Core Version:    0.7.0.1
 */