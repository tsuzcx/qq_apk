package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x935.oidb_0x935.Color;
import tencent.im.oidb.cmd0x935.oidb_0x935.Label;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.AddFeedbackHateGroupCmd;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.ReqBody;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Color;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Label;
import tencent.im.oidb.oidb_0xc26.RgoupLabel;
import tencent.im.oidb.oidb_0xc26.RgroupColor;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class RecommendTroopUtils
{
  public static int a(AppInterface paramAppInterface)
  {
    paramAppInterface = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
    int k = 0;
    int i = 0;
    int j = k;
    if (paramAppInterface != null)
    {
      paramAppInterface = paramAppInterface.getMsgList(AppConstants.RECOMMEND_TROOP_UIN, 4001);
      j = k;
      if (paramAppInterface != null)
      {
        if (paramAppInterface.size() == 0) {
          return 0;
        }
        paramAppInterface = paramAppInterface.iterator();
        while (paramAppInterface.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramAppInterface.next();
          String str = localMessageRecord.msg;
          if ((str != null) && (str.length() > 0) && ((localMessageRecord.msgtype == -1039) || (localMessageRecord.msgtype == -1040)) && (localMessageRecord.extStr != null) && (localMessageRecord.extStr.length() > 0) && (!localMessageRecord.isread)) {
            i += 1;
          }
        }
        j = i;
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("getRecommendUnreadCount");
          paramAppInterface.append(i);
          QLog.d("RecommendTroopUtils", 2, paramAppInterface.toString());
          j = i;
        }
      }
    }
    return j;
  }
  
  public static List<oidb_0x9fb.Label> a(List<oidb_0xc26.RgoupLabel> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0xc26.RgoupLabel localRgoupLabel = (oidb_0xc26.RgoupLabel)paramList.next();
      oidb_0x9fb.Label localLabel = new oidb_0x9fb.Label();
      localLabel.bytes_name.set(localRgoupLabel.bytes_name.get());
      localLabel.edging_color.set(a((oidb_0xc26.RgroupColor)localRgoupLabel.edging_color.get()));
      localLabel.text_color.set(a((oidb_0xc26.RgroupColor)localRgoupLabel.text_color.get()));
      localLabel.enum_type.set(localRgoupLabel.enum_type.get());
      localLabel.uint32_label_attr.set(localRgoupLabel.uint32_label_attr.get());
      localLabel.uint32_label_type.set(localRgoupLabel.uint32_label_type.get());
      localArrayList.add(localLabel);
    }
    return localArrayList;
  }
  
  private static oidb_0x9fb.Color a(oidb_0x935.Color paramColor)
  {
    oidb_0x9fb.Color localColor = new oidb_0x9fb.Color();
    localColor.uint32_b.set(paramColor.uint32_b.get());
    localColor.uint32_g.set(paramColor.uint32_g.get());
    localColor.uint32_r.set(paramColor.uint32_r.get());
    return localColor;
  }
  
  private static oidb_0x9fb.Color a(oidb_0xc26.RgroupColor paramRgroupColor)
  {
    oidb_0x9fb.Color localColor = new oidb_0x9fb.Color();
    localColor.uint32_b.set(paramRgroupColor.uint32_b.get());
    localColor.uint32_g.set(paramRgroupColor.uint32_g.get());
    localColor.uint32_r.set(paramRgroupColor.uint32_r.get());
    return localColor;
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      ThreadManager.post(new RecommendTroopUtils.1(paramAppInterface, paramInt, paramString), 5, null, true);
    }
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        long l = Long.valueOf(paramString).longValue();
        Object localObject1 = new oidb_0x9fa.ReqBody();
        ((oidb_0x9fa.ReqBody)localObject1).uint32_appid.set(1);
        ((oidb_0x9fa.ReqBody)localObject1).int32_channel.set(paramInt);
        Object localObject2 = new oidb_0x9fa.AddFeedbackHateGroupCmd();
        ((oidb_0x9fa.AddFeedbackHateGroupCmd)localObject2).uint64_group_code.add(Long.valueOf(l));
        ((oidb_0x9fa.ReqBody)localObject1).msg_add_hate_group.set((MessageMicro)localObject2);
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2554);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9fa.ReqBody)localObject1).toByteArray()));
        localObject1 = new NewIntent(paramAppInterface.getApplication(), ProtoServlet.class);
        ((NewIntent)localObject1).setWithouLogin(true);
        ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x9fa_0");
        ((NewIntent)localObject1).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
        ((NewIntent)localObject1).setObserver(paramBusinessObserver);
        paramAppInterface.startServlet((NewIntent)localObject1);
        a(paramAppInterface, paramInt, paramString);
        return;
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
      }
    }
  }
  
  public static int b(AppInterface paramAppInterface)
  {
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recommend_troop_info");
    localStringBuilder.append(paramAppInterface.getAccount());
    paramAppInterface = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramAppInterface != null) {
      return paramAppInterface.getInt("unread_recommend_troop_count", 0);
    }
    return 0;
  }
  
  public static List<oidb_0x9fb.Label> b(List<oidb_0x935.Label> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0x935.Label localLabel = (oidb_0x935.Label)paramList.next();
      oidb_0x9fb.Label localLabel1 = new oidb_0x9fb.Label();
      localLabel1.bytes_name.set(localLabel.bytes_name.get());
      localLabel1.edging_color.set(a((oidb_0x935.Color)localLabel.edging_color.get()));
      localLabel1.text_color.set(a((oidb_0x935.Color)localLabel.text_color.get()));
      localLabel1.enum_type.set(localLabel.enum_type.get());
      localLabel1.uint32_label_attr.set(localLabel.uint32_label_attr.get());
      localLabel1.uint32_label_type.set(localLabel.uint32_label_type.get());
      localArrayList.add(localLabel1);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RecommendTroopUtils
 * JD-Core Version:    0.7.0.1
 */