package com.tencent.mobileqq.kandian.repo.db.struct;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.BBInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.RedPointInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.TipsBody;

public class KandianOx210MsgInfo
{
  public static int A = -1;
  public static int B = A + 1;
  public static int C = B + 1;
  public static int D = C + 1;
  public static int x = -1;
  public static int y = x + 1;
  public static int z = y + 1;
  private byte[] E;
  public int a = 1;
  public int b;
  public int c;
  public long d;
  public long e;
  public long f;
  public int g = 0;
  public int h;
  public int i;
  public int j;
  public String k;
  public String l;
  public String m;
  public long n;
  public int o;
  public long p;
  public String q;
  public String r;
  public String s;
  public String t;
  public int u;
  public String v;
  public ArrayList<MySelfNormalItemRedPointInfo> w = new ArrayList();
  
  private static KandianOx210MsgInfo a(KandianOx210MsgInfo paramKandianOx210MsgInfo)
  {
    if (paramKandianOx210MsgInfo == null) {
      return null;
    }
    paramKandianOx210MsgInfo.n = ((Long)RIJSPUtils.b("kandian_push_0x210_c5_msg_time", Long.valueOf(0L))).longValue();
    return paramKandianOx210MsgInfo;
  }
  
  private static KandianOx210MsgInfo a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(PkgTools.hexToBytes(paramString), paramInt);
  }
  
  public static KandianOx210MsgInfo a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 1);
  }
  
  public static KandianOx210MsgInfo a(byte[] paramArrayOfByte, int paramInt)
  {
    KandianOx210MsgInfo localKandianOx210MsgInfo = new KandianOx210MsgInfo();
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      localKandianOx210MsgInfo.a = paramInt;
      localKandianOx210MsgInfo.E = paramArrayOfByte;
      localKandianOx210MsgInfo.b = localMsgBody.uint32_source.get();
      localKandianOx210MsgInfo.c = localMsgBody.uint32_bid.get();
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("receive push 0xc5, bid = ");
        paramArrayOfByte.append(localKandianOx210MsgInfo.b);
        paramArrayOfByte.append(" realBid = ");
        paramArrayOfByte.append(localKandianOx210MsgInfo.c);
        QLog.d("KandianOx210MsgInfo", 2, paramArrayOfByte.toString());
      }
      localKandianOx210MsgInfo.d = localMsgBody.uint64_article_id.get();
      localKandianOx210MsgInfo.e = localMsgBody.uint64_seq.get();
      localKandianOx210MsgInfo.m = RIJPBFieldUtils.a(localMsgBody.bytes_diandian_cookie);
      if (b(localMsgBody)) {
        return null;
      }
      if ((((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.get() != null))
      {
        localKandianOx210MsgInfo.w.clear();
        paramArrayOfByte = ((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.get();
        paramInt = 0;
        while (paramInt < paramArrayOfByte.size())
        {
          submsgtype0xc5.RedPointInfo localRedPointInfo = (submsgtype0xc5.RedPointInfo)paramArrayOfByte.get(paramInt);
          MySelfNormalItemRedPointInfo localMySelfNormalItemRedPointInfo = new MySelfNormalItemRedPointInfo();
          localMySelfNormalItemRedPointInfo.itemId = RIJPBFieldUtils.a(localRedPointInfo.uint32_item_id);
          localMySelfNormalItemRedPointInfo.redPointType = RIJPBFieldUtils.a(localRedPointInfo.red_point_item_type);
          localMySelfNormalItemRedPointInfo.imgUrl = RIJPBFieldUtils.a(localRedPointInfo.bytes_url);
          localMySelfNormalItemRedPointInfo.effectTime = RIJPBFieldUtils.a(localRedPointInfo.uint64_effect_time);
          localMySelfNormalItemRedPointInfo.failureTime = RIJPBFieldUtils.a(localRedPointInfo.uint64_failure_time);
          localKandianOx210MsgInfo.w.add(localMySelfNormalItemRedPointInfo);
          paramInt += 1;
        }
      }
      paramArrayOfByte = (submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get();
      localKandianOx210MsgInfo.h = RIJPBFieldUtils.a(paramArrayOfByte.uint32_show_folder);
      localKandianOx210MsgInfo.j = RIJPBFieldUtils.b(paramArrayOfByte.folder_red_type, 0);
      localKandianOx210MsgInfo.k = RIJPBFieldUtils.a(paramArrayOfByte.bytes_orange_word);
      localKandianOx210MsgInfo.l = RIJPBFieldUtils.a(paramArrayOfByte.bytes_summary);
      if (a(paramArrayOfByte))
      {
        if (localKandianOx210MsgInfo.w.size() > 0) {
          return localKandianOx210MsgInfo;
        }
      }
      else
      {
        localKandianOx210MsgInfo.i = RIJPBFieldUtils.a(paramArrayOfByte.uint32_show_lock_screen);
        localKandianOx210MsgInfo.o = RIJPBFieldUtils.b(paramArrayOfByte.msg_tip_body.tips_ui_type, 0);
        localKandianOx210MsgInfo.p = RIJPBFieldUtils.a(paramArrayOfByte.msg_tip_body.uint64_uin, -1L);
        localKandianOx210MsgInfo.r = RIJPBFieldUtils.a(paramArrayOfByte.msg_tip_body.bytes_icon_url);
        localKandianOx210MsgInfo.q = RIJPBFieldUtils.a(paramArrayOfByte.msg_tip_body.bytes_content);
        localKandianOx210MsgInfo.s = RIJPBFieldUtils.a(paramArrayOfByte.msg_tip_body.bytes_schema);
        localKandianOx210MsgInfo.t = RIJPBFieldUtils.a(paramArrayOfByte.msg_tip_body.bytes_business_info);
        if (a(localMsgBody)) {
          localKandianOx210MsgInfo.u = RIJPBFieldUtils.a(localMsgBody.msg_notify_infos.msg_style_sheet.msg_type);
        }
        if (RIJPBFieldUtils.a(localMsgBody.msg_notify_infos.msg_bb_info) != null)
        {
          paramArrayOfByte = (submsgtype0xc5.BBInfo)RIJPBFieldUtils.a(localMsgBody.msg_notify_infos.msg_bb_info);
          if (paramArrayOfByte != null)
          {
            localKandianOx210MsgInfo.f = paramArrayOfByte.uint64_bb_uin.get();
            localKandianOx210MsgInfo.g = paramArrayOfByte.uint32_src.get();
          }
        }
        localKandianOx210MsgInfo.v = localMsgBody.str_msgid.get();
        return localKandianOx210MsgInfo;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.w("KandianOx210MsgInfo", 2, "receive push 0xc5, parse msgBody err,", paramArrayOfByte);
      }
      return null;
    }
    return null;
  }
  
  private static boolean a(submsgtype0xc5.MsgBody paramMsgBody)
  {
    return (RIJPBFieldUtils.a(paramMsgBody.msg_notify_infos) != null) && (RIJPBFieldUtils.a(paramMsgBody.msg_notify_infos.msg_style_sheet) != null);
  }
  
  private static boolean a(submsgtype0xc5.StyleSheet paramStyleSheet)
  {
    return (!((submsgtype0xc5.StyleSheet)paramStyleSheet.get()).msg_tip_body.has()) || (((submsgtype0xc5.StyleSheet)paramStyleSheet.get()).msg_tip_body.get() == null);
  }
  
  public static int b(byte[] paramArrayOfByte)
  {
    int i2 = x;
    int i1;
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      i1 = i2;
      if (localMsgBody.msg_notify_infos.has())
      {
        i1 = i2;
        if (localMsgBody.msg_notify_infos.get() != null)
        {
          i1 = i2;
          if (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has())
          {
            i1 = i2;
            if (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null)
            {
              i1 = i2;
              if (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has())
              {
                i1 = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
                if (i1 != 0)
                {
                  if (i1 != 1)
                  {
                    if (i1 != 2)
                    {
                      if (i1 != 5)
                      {
                        if (i1 != 7) {
                          i1 = i2;
                        } else {
                          i1 = y;
                        }
                      }
                      else {
                        i1 = y;
                      }
                    }
                    else {
                      i1 = y;
                    }
                  }
                  else {
                    i1 = z;
                  }
                }
                else {
                  i1 = y;
                }
              }
            }
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      i1 = i2;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("get0x210MsgType = ");
      paramArrayOfByte.append(i1);
      QLog.d("KandianOx210MsgInfo", 2, paramArrayOfByte.toString());
    }
    return i1;
  }
  
  public static KandianOx210MsgInfo b()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(true, false);
    return a(a(localSharedPreferences.getString("kandian_push_ox210_msg", ""), localSharedPreferences.getInt("kandian_push_ox210_c5_msg_count", 1)));
  }
  
  private static boolean b(submsgtype0xc5.MsgBody paramMsgBody)
  {
    return (!paramMsgBody.msg_notify_infos.has()) || (paramMsgBody.msg_notify_infos.get() == null) || (!((submsgtype0xc5.NotifyBody)paramMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) || (((submsgtype0xc5.NotifyBody)paramMsgBody.msg_notify_infos.get()).msg_style_sheet.get() == null);
  }
  
  public static int c(byte[] paramArrayOfByte)
  {
    int i2 = A;
    int i1;
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      i1 = i2;
      if (localMsgBody.msg_notify_infos.has())
      {
        i1 = i2;
        if (localMsgBody.msg_notify_infos.get() != null)
        {
          i1 = i2;
          if (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has())
          {
            i1 = i2;
            if (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null)
            {
              i1 = i2;
              if (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has())
              {
                i1 = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
                if (i1 != 0)
                {
                  if (i1 != 2)
                  {
                    if (i1 != 5)
                    {
                      if (i1 != 7) {
                        i1 = i2;
                      } else {
                        i1 = D;
                      }
                    }
                    else {
                      i1 = C;
                    }
                  }
                  else {
                    i1 = B;
                  }
                }
                else {
                  i1 = B;
                }
              }
            }
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      i1 = i2;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("get0x210MsgType = ");
      paramArrayOfByte.append(i1);
      QLog.d("KandianOx210MsgInfo", 2, paramArrayOfByte.toString());
    }
    return i1;
  }
  
  public static KandianOx210MsgInfo c()
  {
    return a(a(RIJSPUtils.a(true, false).getString("kandian_push_0x210_msg_for_follow", ""), 1));
  }
  
  public static int d(byte[] paramArrayOfByte)
  {
    int i2 = 0;
    int i1;
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      i1 = i2;
      if (localMsgBody.uint32_bid.has())
      {
        int i3 = localMsgBody.uint32_bid.get();
        i1 = i2;
        if (i3 <= 2) {
          if (i3 < 1) {
            i1 = i2;
          } else {
            i1 = i3;
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      i1 = i2;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("get0x210MsgBID = ");
      paramArrayOfByte.append(i1);
      QLog.d("KandianOx210MsgInfo", 2, paramArrayOfByte.toString());
    }
    return i1;
  }
  
  public static KandianOx210MsgInfo d()
  {
    return a(a(RIJSPUtils.a(true, false).getString("kandian_push_0x210_msg_for_follow_show_in_folder", ""), 1));
  }
  
  public static KandianOx210MsgInfo e()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(true, false);
    return a(a(localSharedPreferences.getString("kandian_push_0x210_msg_sys", ""), localSharedPreferences.getInt("kandian_push_0x210_msg_sys_count", 1)));
  }
  
  public static KandianOx210MsgInfo f()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(true, false);
    return a(a(localSharedPreferences.getString("kandian_0x210_c5_normal_item_body", ""), localSharedPreferences.getInt("kandian_0x210_c5_normal_item_msg_count", 1)));
  }
  
  public String a()
  {
    return PkgTools.toHexStr(this.E);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new KandianOx210MsgInfo.2(this, paramQQAppInterface));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    ThreadManager.getSubThreadHandler().post(new KandianOx210MsgInfo.8(this, paramAppRuntime));
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new KandianOx210MsgInfo.4(this, paramQQAppInterface));
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new KandianOx210MsgInfo.5(this, paramQQAppInterface));
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new KandianOx210MsgInfo.9(this, paramQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.KandianOx210MsgInfo
 * JD-Core Version:    0.7.0.1
 */