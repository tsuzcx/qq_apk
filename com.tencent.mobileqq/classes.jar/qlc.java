import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.2;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.4;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.5;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.8;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.9;
import com.tencent.biz.pubaccount.readinjoy.struct.MySelfNormalItemRedPointInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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

public class qlc
{
  public static int j = -1;
  public static int k = j + 1;
  public static int l = k + 1;
  public static int m = -1;
  public static int n = m + 1;
  public static int o = n + 1;
  public static int p = o + 1;
  public int a;
  public long a;
  public String a;
  public ArrayList<MySelfNormalItemRedPointInfo> a;
  private byte[] a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  
  public qlc()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    int i1 = j;
    for (;;)
    {
      try
      {
        submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has()))
        {
          i2 = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
          switch (i2)
          {
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int i2;
        paramArrayOfByte.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianOx210MsgInfo", 2, "get0x210MsgType = " + i1);
      }
      return i1;
      i2 = k;
      i1 = i2;
      continue;
      i2 = l;
      i1 = i2;
      continue;
      i2 = k;
      i1 = i2;
      continue;
      i2 = k;
      i1 = i2;
      continue;
      i2 = k;
      i1 = i2;
    }
  }
  
  public static qlc a()
  {
    SharedPreferences localSharedPreferences = bjxj.a(ors.a(), true, false);
    return a(a(localSharedPreferences.getString("kandian_push_ox210_msg", ""), localSharedPreferences.getInt("kandian_push_ox210_c5_msg_count", 1)));
  }
  
  private static qlc a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(bdlr.a(paramString), paramInt);
  }
  
  private static qlc a(qlc paramqlc)
  {
    SharedPreferences localSharedPreferences = bjxj.a(ors.a(), true, false);
    if ((localSharedPreferences == null) || (paramqlc == null)) {
      return paramqlc;
    }
    paramqlc.jdField_d_of_type_Long = localSharedPreferences.getLong("kandian_push_0x210_c5_msg_time", 0L);
    return paramqlc;
  }
  
  public static qlc a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 1);
  }
  
  public static qlc a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = 0;
    qlc localqlc = new qlc();
    for (;;)
    {
      try
      {
        submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        localqlc.jdField_a_of_type_Int = paramInt;
        localqlc.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        localqlc.jdField_b_of_type_Int = localMsgBody.uint32_source.get();
        if (QLog.isColorLevel()) {
          QLog.d("KandianOx210MsgInfo", 2, "receive push 0xc5, bid = " + localqlc.jdField_b_of_type_Int);
        }
        localqlc.jdField_c_of_type_Int = localMsgBody.uint32_bid.get();
        if (QLog.isColorLevel()) {
          QLog.d("KandianOx210MsgInfo", 2, "receive push 0xc5, realbid = " + localqlc.jdField_c_of_type_Int);
        }
        localqlc.jdField_a_of_type_Long = localMsgBody.uint64_article_id.get();
        localqlc.jdField_b_of_type_Long = localMsgBody.uint64_seq.get();
        if (localMsgBody.bytes_diandian_cookie.has()) {
          localqlc.jdField_c_of_type_JavaLangString = localMsgBody.bytes_diandian_cookie.get().toStringUtf8();
        }
        if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null))
        {
          Object localObject2;
          if ((((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.get() != null))
          {
            localqlc.jdField_a_of_type_JavaUtilArrayList.clear();
            paramArrayOfByte = ((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.get();
            paramInt = 0;
            if (paramInt < paramArrayOfByte.size())
            {
              localObject1 = (submsgtype0xc5.RedPointInfo)paramArrayOfByte.get(paramInt);
              localObject2 = new MySelfNormalItemRedPointInfo();
              if (((submsgtype0xc5.RedPointInfo)localObject1).uint32_item_id.has()) {
                ((MySelfNormalItemRedPointInfo)localObject2).itemId = ((submsgtype0xc5.RedPointInfo)localObject1).uint32_item_id.get();
              }
              if (((submsgtype0xc5.RedPointInfo)localObject1).red_point_item_type.has()) {
                ((MySelfNormalItemRedPointInfo)localObject2).redPointType = ((submsgtype0xc5.RedPointInfo)localObject1).red_point_item_type.get();
              }
              if (((submsgtype0xc5.RedPointInfo)localObject1).bytes_url.has()) {
                ((MySelfNormalItemRedPointInfo)localObject2).imgUrl = ((submsgtype0xc5.RedPointInfo)localObject1).bytes_url.get().toStringUtf8();
              }
              if (((submsgtype0xc5.RedPointInfo)localObject1).uint64_effect_time.has()) {
                ((MySelfNormalItemRedPointInfo)localObject2).effectTime = ((submsgtype0xc5.RedPointInfo)localObject1).uint64_effect_time.get();
              }
              if (((submsgtype0xc5.RedPointInfo)localObject1).uint64_failure_time.has()) {
                ((MySelfNormalItemRedPointInfo)localObject2).failureTime = ((submsgtype0xc5.RedPointInfo)localObject1).uint64_failure_time.get();
              }
              localqlc.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
              paramInt += 1;
              continue;
            }
          }
          Object localObject1 = (submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get();
          if (((submsgtype0xc5.StyleSheet)localObject1).uint32_show_folder.has())
          {
            paramInt = ((submsgtype0xc5.StyleSheet)localObject1).uint32_show_folder.get();
            localqlc.jdField_e_of_type_Int = paramInt;
            if (!((submsgtype0xc5.StyleSheet)localObject1).folder_red_type.has()) {
              break label1234;
            }
            paramInt = ((submsgtype0xc5.StyleSheet)localObject1).folder_red_type.get();
            localqlc.jdField_g_of_type_Int = paramInt;
            if (!((submsgtype0xc5.StyleSheet)localObject1).bytes_orange_word.has()) {
              break label1239;
            }
            paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).bytes_orange_word.get().toStringUtf8();
            localqlc.jdField_a_of_type_JavaLangString = paramArrayOfByte;
            if (!((submsgtype0xc5.StyleSheet)localObject1).bytes_summary.has()) {
              break label1244;
            }
            paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).bytes_summary.get().toStringUtf8();
            localqlc.jdField_b_of_type_JavaLangString = paramArrayOfByte;
            if (((!((submsgtype0xc5.StyleSheet)((submsgtype0xc5.StyleSheet)localObject1).get()).msg_tip_body.has()) || (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.StyleSheet)localObject1).get()).msg_tip_body.get() == null)) && (localqlc.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
              return null;
            }
            if (((!((submsgtype0xc5.StyleSheet)((submsgtype0xc5.StyleSheet)localObject1).get()).msg_tip_body.has()) || (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.StyleSheet)localObject1).get()).msg_tip_body.get() == null)) && (localqlc.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
              return localqlc;
            }
            localObject2 = (submsgtype0xc5.TipsBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.StyleSheet)localObject1).get()).msg_tip_body.get();
            if (((submsgtype0xc5.StyleSheet)localObject1).uint32_show_lock_screen.has())
            {
              paramInt = ((submsgtype0xc5.StyleSheet)localObject1).uint32_show_lock_screen.get();
              localqlc.jdField_f_of_type_Int = paramInt;
              paramInt = i1;
              if (((submsgtype0xc5.TipsBody)localObject2).tips_ui_type.has()) {
                paramInt = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.tips_ui_type.get();
              }
              localqlc.jdField_h_of_type_Int = paramInt;
              if (((submsgtype0xc5.TipsBody)localObject2).uint64_uin.has())
              {
                l1 = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.uint64_uin.get();
                localqlc.jdField_e_of_type_Long = l1;
                if (!((submsgtype0xc5.TipsBody)localObject2).bytes_icon_url.has()) {
                  continue;
                }
                paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.bytes_icon_url.get().toStringUtf8();
                localqlc.jdField_e_of_type_JavaLangString = paramArrayOfByte;
                if (!((submsgtype0xc5.TipsBody)localObject2).bytes_content.has()) {
                  continue;
                }
                paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.bytes_content.get().toStringUtf8();
                localqlc.jdField_d_of_type_JavaLangString = paramArrayOfByte;
                if (!((submsgtype0xc5.TipsBody)localObject2).bytes_schema.has()) {
                  continue;
                }
                paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.bytes_schema.get().toStringUtf8();
                localqlc.jdField_f_of_type_JavaLangString = paramArrayOfByte;
                if (!((submsgtype0xc5.TipsBody)localObject2).bytes_business_info.has()) {
                  continue;
                }
                paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.bytes_business_info.get().toStringUtf8();
                localqlc.jdField_g_of_type_JavaLangString = paramArrayOfByte;
                if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has())) {
                  localqlc.i = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
                }
                if ((((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_bb_info.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_bb_info.get() != null))
                {
                  paramArrayOfByte = (submsgtype0xc5.BBInfo)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_bb_info.get();
                  localqlc.jdField_c_of_type_Long = paramArrayOfByte.uint64_bb_uin.get();
                  localqlc.jdField_d_of_type_Int = paramArrayOfByte.uint32_src.get();
                }
                localqlc.jdField_h_of_type_JavaLangString = localMsgBody.str_msgid.get();
                return localqlc;
              }
            }
            else
            {
              paramInt = 0;
              continue;
            }
            long l1 = -1L;
            continue;
            paramArrayOfByte = null;
            continue;
            paramArrayOfByte = null;
            continue;
            paramArrayOfByte = null;
            continue;
            paramArrayOfByte = null;
            continue;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.w("KandianOx210MsgInfo", 2, "receive push 0xc5, parse msgBody err,", paramArrayOfByte);
        }
        return null;
      }
      paramInt = 0;
      continue;
      label1234:
      paramInt = 0;
      continue;
      label1239:
      paramArrayOfByte = null;
      continue;
      label1244:
      paramArrayOfByte = null;
    }
  }
  
  public static int b(byte[] paramArrayOfByte)
  {
    int i1 = m;
    for (;;)
    {
      try
      {
        submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has()))
        {
          i2 = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
          switch (i2)
          {
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int i2;
        paramArrayOfByte.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianOx210MsgInfo", 2, "get0x210MsgType = " + i1);
      }
      return i1;
      i2 = n;
      i1 = i2;
      continue;
      i2 = n;
      i1 = i2;
      continue;
      i2 = o;
      i1 = i2;
      continue;
      i2 = p;
      i1 = i2;
    }
  }
  
  public static qlc b()
  {
    return a(a(bjxj.a(ors.a(), true, false).getString("kandian_push_0x210_msg_for_follow", ""), 1));
  }
  
  public static int c(byte[] paramArrayOfByte)
  {
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (!localMsgBody.uint32_bid.has()) {
        break label85;
      }
      int i2 = localMsgBody.uint32_bid.get();
      if (i2 <= 2)
      {
        i1 = i2;
        if (i2 >= 1) {}
      }
      else
      {
        i1 = 0;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        label85:
        int i1 = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("KandianOx210MsgInfo", 2, "get0x210MsgBID = " + i1);
    }
    return i1;
  }
  
  public static qlc c()
  {
    return a(a(bjxj.a(ors.a(), true, false).getString("kandian_push_0x210_msg_for_follow_show_in_folder", ""), 1));
  }
  
  public static qlc d()
  {
    SharedPreferences localSharedPreferences = bjxj.a(ors.a(), true, false);
    return a(a(localSharedPreferences.getString("kandian_push_0x210_msg_sys", ""), localSharedPreferences.getInt("kandian_push_0x210_msg_sys_count", 1)));
  }
  
  public static qlc e()
  {
    SharedPreferences localSharedPreferences = bjxj.a(ors.a(), true, false);
    return a(a(localSharedPreferences.getString("kandian_0x210_c5_normal_item_body", ""), localSharedPreferences.getInt("kandian_0x210_c5_normal_item_msg_count", 1)));
  }
  
  public String a()
  {
    return bdlr.a(this.jdField_a_of_type_ArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qlc
 * JD-Core Version:    0.7.0.1
 */