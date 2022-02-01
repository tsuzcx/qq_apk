package com.tencent.mobileqq.kandian.biz.pts.item;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnBiuClickListener;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.BaseSheetItemClickProcessor;
import com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class PgcShortContentProteusItem$PgcShortContentProteusItemSheetClickProcessor
  extends ReadInJoyShareHelperV2.BaseSheetItemClickProcessor
{
  private AbsBaseArticleInfo b;
  private WeakReference<Activity> c;
  
  PgcShortContentProteusItem$PgcShortContentProteusItemSheetClickProcessor(AbsBaseArticleInfo paramAbsBaseArticleInfo, WeakReference<Activity> paramWeakReference)
  {
    this.b = paramWeakReference;
    Object localObject;
    this.c = localObject;
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject3 = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
    boolean bool = true;
    Object localObject1 = localObject3;
    Object localObject2;
    try
    {
      if (this.b.mSocialFeedInfo.t.f)
      {
        localObject1 = localObject3;
        if (this.b.mSocialFeedInfo.t.a.size() > 0) {
          localObject1 = ((PGCPicInfo)this.b.mSocialFeedInfo.t.a.get(0)).e;
        }
      }
    }
    catch (NullPointerException localNullPointerException1)
    {
      QLog.e("PgcShortContentProteusItem", 1, localNullPointerException1.toString());
      localObject2 = localObject3;
    }
    if (paramActionSheetItem.action == 13)
    {
      localObject2 = (Activity)this.c.get();
      if (localObject2 != null)
      {
        localObject3 = OnBiuClickListener.a((Activity)localObject2, this.b);
        if (BiuBehaviour.a() != 1) {
          bool = false;
        }
        ((Intent)localObject3).putExtra("fast_biu_type", bool);
        ((Activity)localObject2).startActivityForResult((Intent)localObject3, 55577);
        ((Activity)localObject2).overridePendingTransition(0, 0);
      }
      return super.a(paramInt, paramActionSheetItem);
    }
    try
    {
      localObject3 = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", "qq_friend");
      localJSONObject.put("webHandle", 0);
      ((JSONArray)localObject3).put(localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("name", "qzone");
      localJSONObject.put("webHandle", 0);
      ((JSONArray)localObject3).put(localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("name", "we_chat");
      localJSONObject.put("webHandle", 0);
      ((JSONArray)localObject3).put(localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("name", "we_chat_circle");
      localJSONObject.put("webHandle", 0);
      ((JSONArray)localObject3).put(localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("upline", localObject3);
      localJSONObject.put("belowline", new JSONArray());
      localJSONObject.put("shareCallBack", "");
      localJSONObject.put("title", this.b.mSocialFeedInfo.t.c);
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
      localJSONObject.put("share_url", this.b.getShareUrl());
      localJSONObject.put("keepShareUrl", 1);
      localJSONObject.put("image_url", localObject2);
      localJSONObject.put("weibo_title", HardCodeUtil.a(2131910530));
      localJSONObject.put("uin", "");
      localJSONObject.put("puin", 0);
      if (PgcShortContentProteusItem.b(this.a) == null) {
        PgcShortContentProteusItem.a(this.a, new QShareUtils());
      }
      localObject2 = null;
      if (paramActionSheetItem.action == 72) {
        localObject2 = paramActionSheetItem.uin;
      }
      PgcShortContentProteusItem.b(this.a).a(localJSONObject, paramInt, (Activity)this.c.get(), (String)localObject2, paramActionSheetItem.uinType, paramActionSheetItem.label);
    }
    catch (NullPointerException localNullPointerException2)
    {
      QLog.e("PgcShortContentProteusItem", 1, localNullPointerException2.toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return super.a(paramInt, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.PgcShortContentProteusItemSheetClickProcessor
 * JD-Core Version:    0.7.0.1
 */