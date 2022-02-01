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
  private AbsBaseArticleInfo b;
  private WeakReference<Activity> c;
  private FeedbackCallback d = new OnShareClickListener.ItemSheetClickProcessor.1(this);
  
  OnShareClickListener$ItemSheetClickProcessor(AbsBaseArticleInfo paramAbsBaseArticleInfo, WeakReference<Activity> paramWeakReference)
  {
    this.b = paramWeakReference;
    Object localObject;
    this.c = localObject;
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
    Object localObject = this.b;
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
  
  private void a(@NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!c()) {
      return;
    }
    if (paramActionSheetItem.action == 72) {
      OnShareClickListener.a(this.a, paramActionSheetItem.uin);
    }
    OnShareClickListener.a(this.a, paramActionSheetItem.uinType);
    OnShareClickListener.b(this.a, paramActionSheetItem.label);
    OnShareClickListener.b(this.a, paramActionSheetItem.action);
    ((ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().d().a(this.b, a(OnShareClickListener.e(this.a)), this.d);
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
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.b;
    if (localAbsBaseArticleInfo != null) {
      return localAbsBaseArticleInfo.mTitle;
    }
    return "";
  }
  
  private void b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
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
        localJSONObject.put("sourceName", HardCodeUtil.a(2131900862));
        localJSONObject.put("WXShareFromQQKandian", 1);
        localJSONObject.put("src_iconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
        localJSONObject.put("srcIconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
        localJSONObject.put("src_action", "plugin");
        localJSONObject.put("src_webActionUrl", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        localJSONObject.put("src_actionData", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        localJSONObject.put("desc", ((Activity)this.c.get()).getString(2131915519));
        localJSONObject.put("menu_title", HardCodeUtil.a(2131911054));
        boolean bool = RIJItemViewTypeUtils.E(this.b);
        if (bool)
        {
          localJSONObject.put("share_url", this.b.mOriginalUrl);
        }
        else
        {
          if (this.b == null) {
            break label558;
          }
          localObject = this.b.getShareUrl();
          localJSONObject.put("share_url", localObject);
        }
        localJSONObject.put("keepShareUrl", 1);
        localJSONObject.put("image_url", a());
        localJSONObject.put("weibo_title", HardCodeUtil.a(2131910530));
        localJSONObject.put("uin", "");
        localJSONObject.put("puin", 0);
        if (RIJFeedsType.a(this.b)) {
          localJSONObject.put("shareVideoMsgForArk", VideoStructMsgHelper.a.b(this.b));
        }
        if (OnShareClickListener.b(this.a) == null) {
          OnShareClickListener.a(this.a, new QShareUtils());
        }
        localObject = null;
        if (paramActionSheetItem.action == 72) {
          localObject = paramActionSheetItem.uin;
        }
        OnShareClickListener.b(this.a).a(localJSONObject, paramInt, (Activity)this.c.get(), (String)localObject, paramActionSheetItem.uinType, paramActionSheetItem.label);
        return;
      }
      catch (JSONException paramActionSheetItem)
      {
        QLog.d("OnShareClickListener", 2, paramActionSheetItem.getMessage());
        return;
      }
      label558:
      Object localObject = "";
    }
  }
  
  private boolean c()
  {
    if (!NetworkUtil.isNetworkAvailable(OnShareClickListener.d(this.a)))
    {
      QQToast.makeText(OnShareClickListener.d(this.a), 1, 2131915328, 0).show();
      return false;
    }
    return true;
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem.action == 13)
    {
      Activity localActivity = (Activity)this.c.get();
      if (localActivity != null)
      {
        Intent localIntent = OnBiuClickListener.a(localActivity, this.b);
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
    if ((!RIJItemViewTypeUtils.d(this.b)) && (!RIJItemViewTypeUtils.l(this.b))) {
      b(paramInt, paramActionSheetItem);
    } else {
      a(paramActionSheetItem);
    }
    return super.a(paramInt, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnShareClickListener.ItemSheetClickProcessor
 * JD-Core Version:    0.7.0.1
 */