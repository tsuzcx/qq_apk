package com.tencent.mobileqq.data;

import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7cb.CommentConfig;
import tencent.im.oidb.cmd0x7cb.ConfigItem;
import tencent.im.oidb.cmd0x7cb.DateRequest;
import tencent.im.oidb.cmd0x7cb.RspBody;
import tencent.im.oidb.cmd0x7cb.TopicConfig;

public class DatingConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String aioApllyTips = null;
  public String aioFirstTips = null;
  public String aioTravelApplyTip = null;
  public String aioTravelProfileSendMsgTip = null;
  public String aioTravelSendMsgTip = null;
  public List<DatingConfigItem> cancelReasons = null;
  public int defaultSubject = 0;
  public List<byte[]> hotLocales = null;
  public HashMap<Integer, List<DatingConfigItem>> othersConfigs = null;
  public List<DatingSubjectItem> subjects = null;
  public int timeGap = 0;
  public DatingConfigItem timeRequestConfig = null;
  public int timeStamp = 0;
  
  public static DatingConfig createDatingConfig(cmd0x7cb.RspBody paramRspBody)
  {
    DatingConfig localDatingConfig = new DatingConfig();
    localDatingConfig.timeStamp = paramRspBody.uint32_time_stamp.get();
    localDatingConfig.timeGap = paramRspBody.uint32_time_gap.get();
    localDatingConfig.aioApllyTips = paramRspBody.str_attend_tips_to_A.get();
    localDatingConfig.aioFirstTips = paramRspBody.str_first_msg_tips.get();
    localDatingConfig.aioTravelSendMsgTip = paramRspBody.str_travel_msg_tips.get();
    localDatingConfig.aioTravelProfileSendMsgTip = paramRspBody.str_travel_profile_tips.get();
    localDatingConfig.aioTravelApplyTip = paramRspBody.str_travel_atten_tips.get();
    localDatingConfig.defaultSubject = paramRspBody.uint32_topic_default.get();
    Object localObject1 = new HashMap();
    Iterator localIterator = paramRspBody.rpt_comment_configs.get().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (cmd0x7cb.CommentConfig)localIterator.next();
      int i = ((cmd0x7cb.CommentConfig)localObject2).uint32_appoint_subject.get();
      Object localObject3 = ((cmd0x7cb.CommentConfig)localObject2).rpt_msg_configs.get();
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        cmd0x7cb.ConfigItem localConfigItem = (cmd0x7cb.ConfigItem)((Iterator)localObject3).next();
        ((List)localObject2).add(new DatingConfigItem(localConfigItem.uint32_id.get(), localConfigItem.str_config.get()));
      }
      ((HashMap)localObject1).put(Integer.valueOf(i), localObject2);
    }
    localDatingConfig.othersConfigs = ((HashMap)localObject1);
    localObject1 = new ArrayList();
    localIterator = paramRspBody.rpt_cancle_config.get().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (cmd0x7cb.ConfigItem)localIterator.next();
      ((List)localObject1).add(new DatingConfigItem(((cmd0x7cb.ConfigItem)localObject2).uint32_id.get(), ((cmd0x7cb.ConfigItem)localObject2).str_config.get()));
    }
    localDatingConfig.cancelReasons = ((List)localObject1);
    localObject1 = (cmd0x7cb.DateRequest)paramRspBody.msg_date_request.get();
    if (localObject1 != null) {
      localDatingConfig.timeRequestConfig = new DatingConfigItem(((cmd0x7cb.DateRequest)localObject1).uint32_time.get(), ((cmd0x7cb.DateRequest)localObject1).str_err_msg.get());
    }
    localObject1 = new ArrayList();
    localIterator = paramRspBody.rpt_msg_topic_list.get().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (cmd0x7cb.TopicConfig)localIterator.next();
      ((List)localObject1).add(new DatingSubjectItem(((cmd0x7cb.TopicConfig)localObject2).uint32_topic_id.get(), ((cmd0x7cb.TopicConfig)localObject2).str_topic_name.get(), ((cmd0x7cb.TopicConfig)localObject2).uint32_deadline.get(), ((cmd0x7cb.TopicConfig)localObject2).str_err_deadline.get()));
    }
    localDatingConfig.subjects = ((List)localObject1);
    localDatingConfig.hotLocales = new ArrayList();
    paramRspBody = paramRspBody.rpt_msg_hot_locale.get().iterator();
    while (paramRspBody.hasNext())
    {
      localObject1 = (appoint_define.LocaleInfo)paramRspBody.next();
      localDatingConfig.hotLocales.add(((appoint_define.LocaleInfo)localObject1).toByteArray());
    }
    return localDatingConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.DatingConfig
 * JD-Core Version:    0.7.0.1
 */