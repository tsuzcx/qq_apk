package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.module.QQBaseLifecycleModule;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@HippyNativeModule(name="TKDBiuModule")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/hippy/module/TKDBiuModule;", "Lcom/tencent/hippy/qq/module/QQBaseLifecycleModule;", "context", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "hippyEventDispatcher", "Lcom/tencent/mobileqq/kandian/biz/hippy/interfaces/dispatcher/ITKDHippyEventDispatcher;", "getWholeContent", "", "content", "rptDataList", "", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentRptData;", "initialize", "", "openBiuEditor", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "activity", "Landroid/app/Activity;", "openCommentPublisher", "parseRptData", "dataString", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDBiuModule
  extends QQBaseLifecycleModule
{
  private static final String ARG_BIU_TIME = "biuTime";
  private static final String ARG_NICK_NAME = "nick";
  private static final String ARG_ROW_KEY = "rowKey";
  private static final String ARG_UIN = "uin";
  public static final TKDBiuModule.Companion Companion = new TKDBiuModule.Companion(null);
  private static final int REQ_CODE_BIU_EDITOR_NATIVE = 113;
  private static final String TAG = "TKDBiuModule";
  private ITKDHippyEventDispatcher hippyEventDispatcher;
  
  public TKDBiuModule(@Nullable HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private final String getWholeContent(String paramString, List<? extends BaseCommentData.CommentRptData> paramList)
  {
    if (paramString == null) {
      paramString = "";
    }
    paramString = new StringBuilder(paramString);
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        paramString.append(((BaseCommentData.CommentRptData)paramList.next()).b);
      }
    }
    paramString = paramString.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "sb.toString()");
    return paramString;
  }
  
  private final void openBiuEditor(HippyMap paramHippyMap, Activity paramActivity)
  {
    paramHippyMap.getString("rowKey");
    long l = paramHippyMap.getLong("uin");
    Object localObject = paramHippyMap.getString("comment");
    if (localObject == null) {
      localObject = "";
    }
    localObject = Base64Util.decode((String)localObject, 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Base64Util.decode(params…: \"\", Base64Util.DEFAULT)");
    String str = new String((byte[])localObject, Charsets.UTF_8);
    paramHippyMap.getInt("biuTime");
    localObject = paramHippyMap.getString("nick");
    if (localObject == null) {
      localObject = "";
    }
    localObject = Base64Util.decode((String)localObject, 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Base64Util.decode(params…: \"\", Base64Util.DEFAULT)");
    localObject = new String((byte[])localObject, Charsets.UTF_8);
    UIThreadUtils.runOnUiThread((Runnable)new TKDBiuModule.openBiuEditor.1(this, paramActivity, getWholeContent(str, parseRptData(paramHippyMap.getString("rptDataList"))), l, (String)localObject));
  }
  
  private final List<BaseCommentData.CommentRptData> parseRptData(String paramString)
  {
    Object localObject2 = (List)null;
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      localObject1 = localObject2;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        localObject1 = localObject2;
        int j = localJSONArray.length();
        int i = 0;
        for (paramString = (String)localObject2;; paramString = (String)localObject2)
        {
          localObject1 = paramString;
          if (i >= j) {
            break;
          }
          localObject1 = paramString;
          JSONObject localJSONObject = localJSONArray.optJSONObject(i);
          localObject1 = paramString;
          BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
          localObject2 = paramString;
          if (paramString == null)
          {
            localObject1 = paramString;
            localObject2 = (List)new ArrayList();
          }
          localObject1 = localObject2;
          ((List)localObject2).add(localCommentRptData);
          localObject1 = localObject2;
          int k = localJSONObject.optInt("data_type");
          localObject1 = localObject2;
          localCommentRptData.a = k;
          if (k != 0)
          {
            if (k != 1)
            {
              if (k != 2)
              {
                if (k == 3)
                {
                  localObject1 = localObject2;
                  paramString = localJSONObject.optJSONObject("herf_data");
                  localObject1 = localObject2;
                  localCommentRptData.b = paramString.optString("content");
                  localObject1 = localObject2;
                  localCommentRptData.e = paramString.optString("topic_id");
                  localObject1 = localObject2;
                  localCommentRptData.d = paramString.optString("url");
                }
              }
              else
              {
                localObject1 = localObject2;
                paramString = localJSONObject.optJSONObject("herf_data");
                localObject1 = localObject2;
                localCommentRptData.b = paramString.optString("content");
                localObject1 = localObject2;
                localCommentRptData.d = paramString.optString("url");
              }
            }
            else
            {
              localObject1 = localObject2;
              paramString = localJSONObject.optJSONObject("at_data");
              localObject1 = localObject2;
              localCommentRptData.b = paramString.optString("content");
              localObject1 = localObject2;
              localCommentRptData.c = paramString.optString("uid");
            }
          }
          else
          {
            localObject1 = localObject2;
            localCommentRptData.b = localJSONObject.optJSONObject("text_data").optString("content");
          }
          i += 1;
        }
        return localObject1;
      }
      catch (Exception paramString)
      {
        QLog.w("TKDBiuModule", 4, paramString.getMessage(), (Throwable)paramString);
      }
    }
  }
  
  public void initialize()
  {
    super.initialize();
    if ((getHippyQQEngine() instanceof ITKDHippyEventDispatcherOwner))
    {
      HippyQQEngine localHippyQQEngine = getHippyQQEngine();
      if (localHippyQQEngine != null)
      {
        this.hippyEventDispatcher = ((ITKDHippyEventDispatcherOwner)localHippyQQEngine).getTKDHippyEventDispatcher();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner");
    }
  }
  
  @HippyMethod(name="openBiuPublisher")
  public final void openCommentPublisher(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    UIThreadUtils.runOnUiThread((Runnable)new TKDBiuModule.openCommentPublisher.1(this, paramHippyMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDBiuModule
 * JD-Core Version:    0.7.0.1
 */