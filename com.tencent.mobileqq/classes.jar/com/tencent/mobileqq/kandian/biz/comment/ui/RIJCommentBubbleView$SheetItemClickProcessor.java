package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.BaseSheetItemClickProcessor;
import com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/ui/RIJCommentBubbleView$SheetItemClickProcessor;", "Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;", "content", "", "shareUrl", "firstPagePicUrl", "mActivityReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ref/WeakReference;)V", "getContent", "()Ljava/lang/String;", "getFirstPagePicUrl", "getMActivityReference", "()Ljava/lang/ref/WeakReference;", "mShareUtils", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/QShareUtils;", "getShareUrl", "processClick", "", "action", "", "item", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentBubbleView$SheetItemClickProcessor
  extends ReadInJoyShareHelperV2.BaseSheetItemClickProcessor
{
  private final QShareUtils jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesQShareUtils;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  
  public RIJCommentBubbleView$SheetItemClickProcessor(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull WeakReference<Activity> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesQShareUtils = new QShareUtils();
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Intrinsics.checkParameterIsNotNull(paramActionSheetItem, "item");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("shareCallBack", "");
      localJSONObject.put("title", "腾讯看点热评");
      localJSONObject.put("back", true);
      localJSONObject.put("sourceName", HardCodeUtil.a(2131702884));
      localJSONObject.put("WXShareFromQQKandian", 1);
      localJSONObject.put("src_iconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
      localJSONObject.put("srcIconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
      localJSONObject.put("src_action", "plugin");
      localJSONObject.put("src_webActionUrl", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localJSONObject.put("src_actionData", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("精彩评论： ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("desc", ((StringBuilder)localObject).toString());
      localJSONObject.put("menu_title", HardCodeUtil.a(2131713504));
      localJSONObject.put("share_url", this.b);
      localJSONObject.put("image_url", this.c);
      localJSONObject.put("keepShareUrl", 1);
      localJSONObject.put("weibo_title", HardCodeUtil.a(2131712964));
      localJSONObject.put("uin", "");
      localJSONObject.put("puin", 0);
      localObject = (String)null;
      if (paramActionSheetItem.action == 72) {
        localObject = paramActionSheetItem.uin;
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesQShareUtils.a(localJSONObject, paramInt, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject, paramActionSheetItem.uinType, paramActionSheetItem.label);
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("RIJCommentBubbleView", 1, localNullPointerException.toString());
    }
    catch (JSONException localJSONException)
    {
      QLog.w("RIJCommentBubbleView", 1, localJSONException.toString());
    }
    return super.a(paramInt, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.RIJCommentBubbleView.SheetItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */