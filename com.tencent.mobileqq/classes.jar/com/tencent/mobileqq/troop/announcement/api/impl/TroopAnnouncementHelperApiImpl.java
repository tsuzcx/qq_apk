package com.tencent.mobileqq.troop.announcement.api.impl;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi.FeedItem;
import com.tencent.qphone.base.util.QLog;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MemoCtrlInfo;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MessageContent;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopAnnouncementHelperApiImpl
  implements ITroopAnnouncementHelperApi
{
  private static final String TAG = "TroopAnnouncementHelperApiImpl";
  static final String[] face_desc = { "微笑", "撇嘴", "色", "发呆", "得意", "流泪", "害羞", "闭嘴", "睡", "大哭", "尴尬", "发怒", "调皮", "呲牙", "惊讶", "难过", "酷", "冷汗", "抓狂", "吐", "偷笑", "可爱", "白眼", "傲慢", "饥饿", "困", "惊恐", "流汗", "憨笑", "大兵", "奋斗", "咒骂", "疑问", "嘘", "晕", "折磨", "衰", "骷髅", "敲打", "再见", "擦汗", "抠鼻", "鼓掌", "糗大了", "坏笑", "左哼哼", "右哼哼", "哈欠", "鄙视", "委屈", "快哭了", "阴险", "亲亲", "吓", "可怜", "菜刀", "西瓜", "啤酒", "篮球", "乒乓", "咖啡", "饭", "猪头", "玫瑰", "凋谢", "示爱", "爱心", "心碎", "蛋糕", "闪电", "炸弹", "刀", "足球", "瓢虫", "便便", "月亮", "太阳", "礼物", "拥抱", "强", "弱", "握手", "胜利", "抱拳", "勾引", "拳头", "差劲", "爱你", "NO", "OK", "爱情", "飞吻", "跳跳", "发抖", "怄火", "转圈", "磕头", "回头", "跳绳", "挥手", "激动", "街舞", "献吻", "左太极", "右太极", "潜水", "敬礼", "石化", "加油", "熬夜", "赢了", "输啦", "火炬", "金牌", "坑爹", "伤不起", "亲", "裁判", "跨栏" };
  static final int[] face_old2new = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 80, 81, 82, 83, 84, 45, 85, 44, 43, 40, 41, 86, 42, 87, 57, 88, 52, 89, 63, 64, 65, 66, 67, 53, 69, 90, 91, 74, 92, 93, 75, 76, 77, 94, 95, 15, 16, 17, 18, 19, 26, 27, 28, 29, 46, 47, 48, 49, 60, 61, 62, 68, 70, 71, 72, 73, 78, 59, 20, 21, 22, 23, 24, 25, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 50, 51, 54, 55, 56, 58, 79, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134 };
  
  private ITroopAnnouncementHelperApi.FeedItem decodeFeedItem_Stream(group_feeds.GroupFeedsMessage paramGroupFeedsMessage, String paramString)
  {
    Object localObject = paramGroupFeedsMessage.rpt_feeds_content.get().iterator();
    String str = null;
    byte[] arrayOfByte = null;
    while (((Iterator)localObject).hasNext())
    {
      group_feeds.GroupFeedsMessage.MessageContent localMessageContent = (group_feeds.GroupFeedsMessage.MessageContent)((Iterator)localObject).next();
      i = localMessageContent.enum_content_type.get();
      if (i == 0) {
        arrayOfByte = localMessageContent.bytes_content_value.get().toByteArray();
      } else if (i == 14) {
        str = localMessageContent.bytes_content_value.get().toStringUtf8();
      }
    }
    long l3 = 0L;
    boolean bool = true;
    long l2 = l3;
    long l1;
    if (str != null) {
      l1 = l3;
    }
    try
    {
      localObject = new JSONObject(str);
      l2 = l3;
      l1 = l3;
      if (!((JSONObject)localObject).has("controlType")) {
        break label229;
      }
      l2 = l3;
      l1 = l3;
      if (((JSONObject)localObject).getInt("controlType") != 1) {
        break label229;
      }
      l1 = l3;
      localObject = ((JSONObject)localObject).getJSONObject("controlInfo");
      l1 = l3;
      l2 = ((JSONObject)localObject).getLong("filterID");
      l1 = l2;
      i = ((JSONObject)localObject).getInt("src");
    }
    catch (JSONException localJSONException)
    {
      label206:
      break label206;
    }
    l2 = l1;
    if (QLog.isDevelopLevel())
    {
      QLog.d("TroopAnnouncementHelperApiImpl", 4, "decodeToFeedItem--JSONException");
      l2 = l1;
    }
    label229:
    int i = 0;
    localObject = new ITroopAnnouncementHelperApi.FeedItem();
    ((ITroopAnnouncementHelperApi.FeedItem)localObject).c = paramString;
    ((ITroopAnnouncementHelperApi.FeedItem)localObject).i = arrayOfByte;
    ((ITroopAnnouncementHelperApi.FeedItem)localObject).j = str;
    ((ITroopAnnouncementHelperApi.FeedItem)localObject).a = 2;
    ((ITroopAnnouncementHelperApi.FeedItem)localObject).l = l2;
    ((ITroopAnnouncementHelperApi.FeedItem)localObject).k = i;
    if (paramGroupFeedsMessage.opt_uint32_ctl_flag.has()) {
      i = paramGroupFeedsMessage.opt_uint32_ctl_flag.get();
    } else {
      i = 0;
    }
    ((ITroopAnnouncementHelperApi.FeedItem)localObject).m = i;
    if ((paramGroupFeedsMessage.memo_ctrl_info.has()) && (((group_feeds.GroupFeedsMessage.MemoCtrlInfo)paramGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.has()))
    {
      if (((group_feeds.GroupFeedsMessage.MemoCtrlInfo)paramGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.get() != 1) {
        bool = false;
      }
      ((ITroopAnnouncementHelperApi.FeedItem)localObject).n = bool;
    }
    return localObject;
  }
  
  private ITroopAnnouncementHelperApi.FeedItem decodeToFeedItem_Memo(group_feeds.GroupFeedsMessage paramGroupFeedsMessage, String paramString, boolean paramBoolean)
  {
    Object localObject2 = paramGroupFeedsMessage.rpt_feeds_content.get();
    String str2 = "";
    String str1;
    if (paramBoolean) {
      str1 = "";
    } else {
      str1 = "群公告";
    }
    Object localObject1 = new StringBuilder();
    localObject2 = ((List)localObject2).iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject2).hasNext();
      paramBoolean = false;
      Object localObject3;
      int i;
      if (bool)
      {
        localObject3 = (group_feeds.GroupFeedsMessage.MessageContent)((Iterator)localObject2).next();
        i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).enum_content_type.get();
        if (i == 3)
        {
          str2 = String.format("https://gdynamic.qpic.cn/gdynamic/%s/72", new Object[] { ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).bytes_pic_id.get().toStringUtf8() });
        }
        else if (i == 0)
        {
          ((StringBuilder)localObject1).append(((group_feeds.GroupFeedsMessage.MessageContent)localObject3).bytes_content_value.get().toStringUtf8());
        }
        else if (i == 10)
        {
          str1 = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).bytes_content_value.get().toStringUtf8();
        }
        else if (i == 2)
        {
          i = ((group_feeds.GroupFeedsMessage.MessageContent)localObject3).int32_face_idx.get();
          if (i < 0) {}
        }
      }
      else
      {
        try
        {
          if (i >= face_old2new.length) {
            continue;
          }
          localObject3 = face_desc[i];
          ((StringBuilder)localObject1).append('[');
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append(']');
        }
        catch (Exception localException) {}
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new ITroopAnnouncementHelperApi.FeedItem();
        ((ITroopAnnouncementHelperApi.FeedItem)localObject2).b = str1;
        ((ITroopAnnouncementHelperApi.FeedItem)localObject2).c = paramString;
        ((ITroopAnnouncementHelperApi.FeedItem)localObject2).d = ((String)localObject1);
        ((ITroopAnnouncementHelperApi.FeedItem)localObject2).e = str2;
        ((ITroopAnnouncementHelperApi.FeedItem)localObject2).a = 1;
        if (paramGroupFeedsMessage.opt_uint32_ctl_flag.has()) {
          i = paramGroupFeedsMessage.opt_uint32_ctl_flag.get();
        } else {
          i = 0;
        }
        ((ITroopAnnouncementHelperApi.FeedItem)localObject2).m = i;
        if ((paramGroupFeedsMessage.memo_ctrl_info.has()) && (((group_feeds.GroupFeedsMessage.MemoCtrlInfo)paramGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.has()))
        {
          if (((group_feeds.GroupFeedsMessage.MemoCtrlInfo)paramGroupFeedsMessage.memo_ctrl_info.get()).uint32_need_confirmation.get() == 1) {
            paramBoolean = true;
          }
          ((ITroopAnnouncementHelperApi.FeedItem)localObject2).n = paramBoolean;
        }
        return localObject2;
      }
    }
  }
  
  public ITroopAnnouncementHelperApi.FeedItem decodeToFeedItem(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      group_feeds.GroupFeedsMessage localGroupFeedsMessage = new group_feeds.GroupFeedsMessage();
      localGroupFeedsMessage.mergeFrom(paramArrayOfByte);
      int i = localGroupFeedsMessage.enum_feeds_type.get();
      if ((i != 5) && (i != 19))
      {
        if (i == 22) {
          return decodeFeedItem_Stream(localGroupFeedsMessage, paramString);
        }
      }
      else
      {
        paramString = decodeToFeedItem_Memo(localGroupFeedsMessage, paramString, paramBoolean);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAnnouncementHelperApiImpl", 2, paramString.getMessage());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.announcement.api.impl.TroopAnnouncementHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */