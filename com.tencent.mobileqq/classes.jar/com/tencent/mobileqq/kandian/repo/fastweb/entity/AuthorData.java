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
  public long a;
  public AbsBaseArticleInfo a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public AuthorData(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    super(25);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo = paramFastWebArticleInfo;
  }
  
  private long a()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID);
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a())) {
      i = 1;
    } else {
      i = 0;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (i != 0) {
          localJSONObject.put("style_ID", "ReadInjoy_article_relocated_header_cell");
        } else {
          localJSONObject.put("style_ID", "ReadInjoy_article_header_cell");
        }
        localJSONObject.put("avatar_url", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("avatar_uin", this.jdField_c_of_type_JavaLangString);
        localJSONObject.put("nickname_text", this.b);
        localJSONObject.put("timestamp_text", this.d);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo != null) {
          localJSONObject.put("dt_rowkey", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.j);
        }
        localJSONObject.put("dt_puin", this.jdField_c_of_type_JavaLangString);
        FastWebPTSDataConverter.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, localJSONObject);
        a(paramBoolean1, paramBoolean2, localJSONObject);
        JSONObjectExtensionsKt.a(localJSONObject, "ringUrl", this.f, "");
        JSONObjectExtensionsKt.a(localJSONObject, "liveStatusUrl", this.g, "");
        Object localObject1 = this.ad;
        if (localObject1 != null) {
          try
          {
            localObject1 = new JSONObject(this.ad);
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
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject2);
          this.jdField_c_of_type_OrgJsonJSONObject = localJSONObject;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("bindAuthorData: ");
          ((StringBuilder)localObject2).append(this.jdField_c_of_type_OrgJsonJSONObject);
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
    FastWebPTSDataConverter.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramJSONObject, paramBoolean1);
    this.jdField_a_of_type_Boolean = paramBoolean1;
  }
  
  public void a()
  {
    a(FollowListInfoModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getSubscribeUin(), null), false);
  }
  
  public void a(IFollowStatusObserver paramIFollowStatusObserver)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localAbsBaseArticleInfo != null) {
      c(FollowListInfoModule.a(localAbsBaseArticleInfo.getSubscribeUin(), paramIFollowStatusObserver));
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
    a();
  }
  
  public void a(Map<Long, FollowingMember> paramMap)
  {
    int i = FastWebPTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getSubscribeUin(), paramMap);
    if (i != -1)
    {
      boolean bool = true;
      if (i != 1) {
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
    this.g = paramString;
    a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(true);
      FastWebPTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, a(), this.jdField_a_of_type_JavaLangString, paramBoolean);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) {
        RIJFeedsInsertUtil.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean) {
      a(paramBoolean, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData
 * JD-Core Version:    0.7.0.1
 */