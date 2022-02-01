package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.BaseSheetItemClickProcessor;
import com.tencent.mobileqq.kandian.biz.video.VideoStructMsgHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.fastweb.FeedbackCallback;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OnShareClickListener$ItemSheetClickProcessor
  extends ReadInJoyShareHelperV2.BaseSheetItemClickProcessor
{
  private FeedbackCallback jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFeedbackCallback = new OnShareClickListener.ItemSheetClickProcessor.1(this);
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  
  OnShareClickListener$ItemSheetClickProcessor(AbsBaseArticleInfo paramAbsBaseArticleInfo, WeakReference<Activity> paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramWeakReference;
    Object localObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = localObject;
  }
  
  private int a(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 9)
        {
          if (paramInt != 10)
          {
            if (paramInt != 13) {
              return 0;
            }
            return 4;
          }
          return 3;
        }
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject != null) {
      localObject = ((AbsBaseArticleInfo)localObject).mFirstPagePicUrl;
    } else {
      localObject = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getImageUrl | shareImgUrl : ");
    localStringBuilder.append((String)localObject);
    QLog.d("OnShareClickListener", 2, localStringBuilder.toString());
    return localObject;
  }
  
  private void a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("name", "qq_friend");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "qzone");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "we_chat");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "we_chat_circle");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("upline", localObject);
        localJSONObject.put("belowline", new JSONArray());
        localJSONObject.put("shareCallBack", "");
        localJSONObject.put("title", b());
        localJSONObject.put("back", true);
        localJSONObject.put("sourceName", HardCodeUtil.a(2131702884));
        localJSONObject.put("WXShareFromQQKandian", 1);
        localJSONObject.put("src_iconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
        localJSONObject.put("srcIconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
        localJSONObject.put("src_action", "plugin");
        localJSONObject.put("src_webActionUrl", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        localJSONObject.put("src_actionData", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        localJSONObject.put("desc", ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131718042));
        localJSONObject.put("menu_title", HardCodeUtil.a(2131713504));
        boolean bool = RIJItemViewTypeUtils.B(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        if (bool)
        {
          localJSONObject.put("share_url", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mOriginalUrl);
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
            break label555;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getShareUrl();
          localJSONObject.put("share_url", localObject);
        }
        localJSONObject.put("keepShareUrl", 1);
        localJSONObject.put("image_url", a());
        localJSONObject.put("weibo_title", HardCodeUtil.a(2131712964));
        localJSONObject.put("uin", "");
        localJSONObject.put("puin", 0);
        if (RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
          localJSONObject.put("shareVideoMsgForArk", VideoStructMsgHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
        }
        if (OnShareClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnShareClickListener) == null) {
          OnShareClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnShareClickListener, new QShareUtils());
        }
        localObject = null;
        if (paramActionSheetItem.action == 72) {
          localObject = paramActionSheetItem.uin;
        }
        OnShareClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnShareClickListener).a(localJSONObject, paramInt, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject, paramActionSheetItem.uinType, paramActionSheetItem.label);
        return;
      }
      catch (JSONException paramActionSheetItem)
      {
        QLog.d("OnShareClickListener", 2, paramActionSheetItem.getMessage());
        return;
      }
      label555:
      Object localObject = "";
    }
  }
  
  private void a(@NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!a()) {
      return;
    }
    if (paramActionSheetItem.action == 72) {
      OnShareClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnShareClickListener, paramActionSheetItem.uin);
    }
    OnShareClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnShareClickListener, paramActionSheetItem.uinType);
    OnShareClickListener.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnShareClickListener, paramActionSheetItem.label);
    OnShareClickListener.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnShareClickListener, paramActionSheetItem.action);
    ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, a(OnShareClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnShareClickListener)), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFeedbackCallback);
  }
  
  private boolean a()
  {
    if (!NetworkUtil.isNetworkAvailable(OnShareClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnShareClickListener)))
    {
      QQToast.a(OnShareClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsListenersOnShareClickListener), 1, 2131717855, 0).a();
      return false;
    }
    return true;
  }
  
  private int b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return 2;
            }
            return 13;
          }
          return 10;
        }
        return 9;
      }
      return 3;
    }
    return 2;
  }
  
  private String b()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localAbsBaseArticleInfo != null) {
      return localAbsBaseArticleInfo.mTitle;
    }
    return "";
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem.action == 13)
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null)
      {
        Intent localIntent = OnBiuClickListener.a(localActivity, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        int i = BiuBehaviour.a();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        localIntent.putExtra("fast_biu_type", bool);
        localActivity.startActivity(localIntent);
        localActivity.overridePendingTransition(0, 0);
      }
      return super.a(paramInt, paramActionSheetItem);
    }
    if ((!RIJItemViewTypeUtils.d(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))) {
      a(paramInt, paramActionSheetItem);
    } else {
      a(paramActionSheetItem);
    }
    return super.a(paramInt, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnShareClickListener.ItemSheetClickProcessor
 * JD-Core Version:    0.7.0.1
 */