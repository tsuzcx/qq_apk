package com.tencent.mobileqq.kandian.biz.share;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$Companion;", "", "()V", "FROM_BIU", "", "FROM_COLUMN_DETAIL", "FROM_COMMENT", "FROM_COMMENT_BUBBLE", "FROM_COMMENT_CARD", "FROM_MY_INFO_CARD", "FROM_NATIVE_ARTICLE", "FROM_NATIVE_ARTICLE_BAR_ICON", "FROM_OTHER", "FROM_SHORT_CONTENT_CARD", "FROM_SHORT_CONTENT_CARD_BIU_ICON", "FROM_SHORT_CONTENT_DETAIL", "FROM_SHORT_CONTENT_FLOAT", "FROM_TIKTOK_VIDEO_BOTTOM_SHARE_ICON", "FROM_TIKTOK_VIDEO_THREE_POINT", "FROM_TOPIC", "FROM_UGC", "FROM_UGC_SOCIAL", "FROM_VIDEO_CARD", "FROM_VIDEO_FEEDS_BOTTOM_SHARE_ICON", "FROM_VIDEO_FEEDS_THREE_POINT", "FROM_VIDEO_MULTI", "FROM_WEB_ARTICLE", "FROM_WECHAT_CARD", "MSG_SCREENSHOT_SAVED", "REQUEST_CODE_SHARE_TO_QZONE", "RIJ_FONT_SIZE_INDEX_SP", "", "RIJ_FONT_SIZE_RATIO_SP", "RIJ_FONT_SIZE_SP", "RIJ_SHARE_TITLE", "SHARE_UNIT_ADD_COLOR_NOTE", "SHARE_UNIT_ADD_FAVORITE", "SHARE_UNIT_ADD_FRIEND", "SHARE_UNIT_ADD_TO_COLUMN", "SHARE_UNIT_ADJUST_FONT_SIZE", "SHARE_UNIT_COPY_LINK", "SHARE_UNIT_DELETE_COLUMN", "SHARE_UNIT_DIS_LIKE", "SHARE_UNIT_EXPORT_DOCS", "SHARE_UNIT_MORE_INFO", "SHARE_UNIT_OPEN_AIO", "SHARE_UNIT_PERSONAL_C2C", "SHARE_UNIT_QR_CODE", "SHARE_UNIT_REMOVE_COLOR_NOTE", "SHARE_UNIT_REMOVE_FANS", "SHARE_UNIT_REMOVE_FROM_COLUMN", "SHARE_UNIT_REPORT", "SHARE_UNIT_SAVE_PIC", "SHARE_UNIT_SCREEN_SHOT", "SHARE_UNIT_SEND_TO_PC", "SHARE_UNIT_SEND_TO_QQ_BROWSER", "SHARE_UNIT_SEND_TO_QQ_FRIEND", "SHARE_UNIT_SEND_TO_QZONE", "SHARE_UNIT_SEND_TO_READINJOY", "SHARE_UNIT_SEND_TO_RECENT_FRIEND", "SHARE_UNIT_SEND_TO_SYS_BROWSER", "SHARE_UNIT_SEND_TO_WECHAT", "SHARE_UNIT_SEND_TO_WECHAT_CIRCLE", "SHARE_UNIT_SEND_TO_WEIBO", "SHARE_UNIT_SHIELD", "SHARE_UNIT_UNKNOWN", "TAG", "nameToAction", "", "actionToShareUnit", "action", "getDefaultActionItemLine1", "", "Lcom/tencent/mobileqq/kandian/biz/share/ActionItem;", "getDefaultActionItemLine2", "getWholeLineOneItems", "parseWebLineFromJson", "lineArr", "Lorg/json/JSONArray;", "jsonObject", "Lorg/json/JSONObject;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyShareHelperV2$Companion
{
  public final int a(int paramInt)
  {
    if (paramInt != 37)
    {
      if (paramInt != 38)
      {
        if (paramInt != 43)
        {
          if (paramInt != 44)
          {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    return 0;
                  case 138: 
                    return 27;
                  case 137: 
                    return 25;
                  }
                  return 22;
                case 134: 
                  return 21;
                case 82: 
                  return 19;
                case 72: 
                  return 1;
                case 70: 
                  return 10;
                case 68: 
                  return 12;
                case 40: 
                  return 20;
                case 35: 
                  return 23;
                case 31: 
                  return 26;
                case 26: 
                  return 13;
                case 23: 
                  return 17;
                }
                return 30;
              case 13: 
                return 2;
              case 12: 
                return 7;
              case 11: 
                return 15;
              case 10: 
                return 6;
              }
              return 5;
            case 7: 
              return 31;
            case 6: 
              return 11;
            case 5: 
              return 9;
            case 4: 
              return 8;
            case 3: 
              return 4;
            case 2: 
              return 3;
            }
            return 14;
          }
          return 29;
        }
        return 28;
      }
      return 16;
    }
    return 24;
  }
  
  @JvmStatic
  @NotNull
  public final List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList(9);
    localArrayList.add(Integer.valueOf(13));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    localArrayList.add(Integer.valueOf(12));
    localArrayList.add(Integer.valueOf(26));
    localArrayList.add(Integer.valueOf(4));
    return (List)localArrayList;
  }
  
  @JvmStatic
  @NotNull
  public final List<ActionItem> a(@NotNull JSONArray paramJSONArray, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONArray, "lineArr");
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int m;
      boolean bool;
      try
      {
        int k = paramJSONArray.length();
        int i = 0;
        if (i < k)
        {
          Object localObject2 = paramJSONArray.get(i);
          Object localObject1;
          if ((localObject2 instanceof String))
          {
            localObject1 = (Integer)ReadInJoyShareHelperV2.a().get(localObject2);
            if (localObject1 != null) {
              localArrayList.add(new ActionItem((String)localObject2, ((Integer)localObject1).intValue(), false));
            }
          }
          else if ((localObject2 instanceof JSONObject))
          {
            localObject1 = ((JSONObject)localObject2).optString("name");
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (ReadInJoyShareHelperV2.a().get(localObject1) != null))
            {
              m = ((JSONObject)localObject2).optInt("webHandle", 0);
              if ((Intrinsics.areEqual("save_picture", localObject1)) && (paramJSONObject != null))
              {
                localObject2 = (Integer)ReadInJoyShareHelperV2.a().get(localObject1);
                if (localObject2 == null) {
                  break label314;
                }
                j = ((Integer)localObject2).intValue();
                break label317;
                localObject2 = paramJSONObject.optString("saveImageUrl");
                Intrinsics.checkExpressionValueIsNotNull(localObject2, "jsonObject.optString(\"saveImageUrl\")");
                localArrayList.add(new ImageActionItem((String)localObject1, j, bool, (String)localObject2));
              }
              else
              {
                Intrinsics.checkExpressionValueIsNotNull(localObject1, "name");
                localObject2 = (Integer)ReadInJoyShareHelperV2.a().get(localObject1);
                if (localObject2 == null) {
                  break label335;
                }
                j = ((Integer)localObject2).intValue();
                break label338;
                localArrayList.add(new ActionItem((String)localObject1, j, bool));
              }
            }
          }
          i += 1;
        }
        else
        {
          return (List)localArrayList;
        }
      }
      catch (JSONException paramJSONArray)
      {
        QLog.e("ReadInJoyShareHelperV2", 1, QLog.getStackTraceString((Throwable)paramJSONArray));
      }
      label314:
      int j = 0;
      label317:
      if (m == 1)
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        label335:
        j = 0;
        label338:
        if (m == 1) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  @JvmStatic
  @NotNull
  public final List<ActionItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ActionItem("kandian", 13, false));
    localArrayList.add(new ActionItem("qq_friend", 2, false));
    localArrayList.add(new ActionItem("qzone", 3, false));
    localArrayList.add(new ActionItem("we_chat", 9, false));
    localArrayList.add(new ActionItem("we_chat_circle", 10, false));
    localArrayList.add(new ActionItem("we_bo", 12, false));
    localArrayList.add(new ActionItem("send_pc", 26, false));
    localArrayList.add(new ActionItem("sys_browser", 4, false));
    return (List)localArrayList;
  }
  
  @JvmStatic
  @NotNull
  public final List<ActionItem> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ActionItem("screen_shot", 21, false));
    localArrayList.add(new ActionItem("set_font", 7, false));
    localArrayList.add(new ActionItem("add_favourite", 6, false));
    localArrayList.add(new ActionItem("copy_link", 1, false));
    localArrayList.add(new ActionItem("report", 11, false));
    return (List)localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2.Companion
 * JD-Core Version:    0.7.0.1
 */