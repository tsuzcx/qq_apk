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

public class rpl
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
  
  public rpl()
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
  
  public static rpl a()
  {
    SharedPreferences localSharedPreferences = bmhv.a(pkh.a(), true, false);
    return a(a(localSharedPreferences.getString("kandian_push_ox210_msg", ""), localSharedPreferences.getInt("kandian_push_ox210_c5_msg_count", 1)));
  }
  
  private static rpl a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(PkgTools.hexToBytes(paramString), paramInt);
  }
  
  private static rpl a(rpl paramrpl)
  {
    SharedPreferences localSharedPreferences = bmhv.a(pkh.a(), true, false);
    if ((localSharedPreferences == null) || (paramrpl == null)) {
      return paramrpl;
    }
    paramrpl.jdField_d_of_type_Long = localSharedPreferences.getLong("kandian_push_0x210_c5_msg_time", 0L);
    return paramrpl;
  }
  
  public static rpl a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 1);
  }
  
  public static rpl a(byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = 0;
    rpl localrpl = new rpl();
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      localrpl.jdField_a_of_type_Int = paramInt;
      localrpl.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      localrpl.jdField_b_of_type_Int = localMsgBody.uint32_source.get();
      localrpl.jdField_c_of_type_Int = localMsgBody.uint32_bid.get();
      if (QLog.isColorLevel()) {
        QLog.d("KandianOx210MsgInfo", 2, "receive push 0xc5, bid = " + localrpl.jdField_b_of_type_Int + " realBid = " + localrpl.jdField_c_of_type_Int);
      }
      localrpl.jdField_a_of_type_Long = localMsgBody.uint64_article_id.get();
      localrpl.jdField_b_of_type_Long = localMsgBody.uint64_seq.get();
      localrpl.jdField_c_of_type_JavaLangString = qxl.a(localMsgBody.bytes_diandian_cookie);
      if (b(localMsgBody)) {
        return null;
      }
      if ((((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.get() != null))
      {
        localrpl.jdField_a_of_type_JavaUtilArrayList.clear();
        paramArrayOfByte = ((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.get();
        paramInt = i1;
        while (paramInt < paramArrayOfByte.size())
        {
          submsgtype0xc5.RedPointInfo localRedPointInfo = (submsgtype0xc5.RedPointInfo)paramArrayOfByte.get(paramInt);
          MySelfNormalItemRedPointInfo localMySelfNormalItemRedPointInfo = new MySelfNormalItemRedPointInfo();
          localMySelfNormalItemRedPointInfo.itemId = qxl.a(localRedPointInfo.uint32_item_id);
          localMySelfNormalItemRedPointInfo.redPointType = qxl.a(localRedPointInfo.red_point_item_type);
          localMySelfNormalItemRedPointInfo.imgUrl = qxl.a(localRedPointInfo.bytes_url);
          localMySelfNormalItemRedPointInfo.effectTime = qxl.a(localRedPointInfo.uint64_effect_time);
          localMySelfNormalItemRedPointInfo.failureTime = qxl.a(localRedPointInfo.uint64_failure_time);
          localrpl.jdField_a_of_type_JavaUtilArrayList.add(localMySelfNormalItemRedPointInfo);
          paramInt += 1;
        }
      }
      paramArrayOfByte = (submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get();
      localrpl.jdField_e_of_type_Int = qxl.a(paramArrayOfByte.uint32_show_folder);
      localrpl.jdField_g_of_type_Int = qxl.b(paramArrayOfByte.folder_red_type, 0);
      localrpl.jdField_a_of_type_JavaLangString = qxl.a(paramArrayOfByte.bytes_orange_word);
      localrpl.jdField_b_of_type_JavaLangString = qxl.a(paramArrayOfByte.bytes_summary);
      if (a(paramArrayOfByte))
      {
        if (localrpl.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label635;
        }
        paramArrayOfByte = localrpl;
      }
      else
      {
        localrpl.jdField_f_of_type_Int = qxl.a(paramArrayOfByte.uint32_show_lock_screen);
        localrpl.jdField_h_of_type_Int = qxl.b(paramArrayOfByte.msg_tip_body.tips_ui_type, 0);
        localrpl.jdField_e_of_type_Long = qxl.a(paramArrayOfByte.msg_tip_body.uint64_uin, -1L);
        localrpl.jdField_e_of_type_JavaLangString = qxl.a(paramArrayOfByte.msg_tip_body.bytes_icon_url);
        localrpl.jdField_d_of_type_JavaLangString = qxl.a(paramArrayOfByte.msg_tip_body.bytes_content);
        localrpl.jdField_f_of_type_JavaLangString = qxl.a(paramArrayOfByte.msg_tip_body.bytes_schema);
        localrpl.jdField_g_of_type_JavaLangString = qxl.a(paramArrayOfByte.msg_tip_body.bytes_business_info);
        if (a(localMsgBody)) {
          localrpl.i = qxl.a(localMsgBody.msg_notify_infos.msg_style_sheet.msg_type);
        }
        if (qxl.a(localMsgBody.msg_notify_infos.msg_bb_info) != null)
        {
          paramArrayOfByte = (submsgtype0xc5.BBInfo)qxl.a(localMsgBody.msg_notify_infos.msg_bb_info);
          if (paramArrayOfByte != null)
          {
            localrpl.jdField_c_of_type_Long = paramArrayOfByte.uint64_bb_uin.get();
            localrpl.jdField_d_of_type_Int = paramArrayOfByte.uint32_src.get();
          }
        }
        localrpl.jdField_h_of_type_JavaLangString = localMsgBody.str_msgid.get();
        return localrpl;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.w("KandianOx210MsgInfo", 2, "receive push 0xc5, parse msgBody err,", paramArrayOfByte);
      }
      return null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      label635:
      paramArrayOfByte = null;
    }
  }
  
  private static boolean a(submsgtype0xc5.MsgBody paramMsgBody)
  {
    return (qxl.a(paramMsgBody.msg_notify_infos) != null) && (qxl.a(paramMsgBody.msg_notify_infos.msg_style_sheet) != null);
  }
  
  private static boolean a(submsgtype0xc5.StyleSheet paramStyleSheet)
  {
    return (!((submsgtype0xc5.StyleSheet)paramStyleSheet.get()).msg_tip_body.has()) || (((submsgtype0xc5.StyleSheet)paramStyleSheet.get()).msg_tip_body.get() == null);
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
  
  public static rpl b()
  {
    return a(a(bmhv.a(pkh.a(), true, false).getString("kandian_push_0x210_msg_for_follow", ""), 1));
  }
  
  private static boolean b(submsgtype0xc5.MsgBody paramMsgBody)
  {
    return (!paramMsgBody.msg_notify_infos.has()) || (paramMsgBody.msg_notify_infos.get() == null) || (!((submsgtype0xc5.NotifyBody)paramMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) || (((submsgtype0xc5.NotifyBody)paramMsgBody.msg_notify_infos.get()).msg_style_sheet.get() == null);
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
  
  public static rpl c()
  {
    return a(a(bmhv.a(pkh.a(), true, false).getString("kandian_push_0x210_msg_for_follow_show_in_folder", ""), 1));
  }
  
  public static rpl d()
  {
    SharedPreferences localSharedPreferences = bmhv.a(pkh.a(), true, false);
    return a(a(localSharedPreferences.getString("kandian_push_0x210_msg_sys", ""), localSharedPreferences.getInt("kandian_push_0x210_msg_sys_count", 1)));
  }
  
  public static rpl e()
  {
    SharedPreferences localSharedPreferences = bmhv.a(pkh.a(), true, false);
    return a(a(localSharedPreferences.getString("kandian_0x210_c5_normal_item_body", ""), localSharedPreferences.getInt("kandian_0x210_c5_normal_item_msg_count", 1)));
  }
  
  public String a()
  {
    return PkgTools.toHexStr(this.jdField_a_of_type_ArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpl
 * JD-Core Version:    0.7.0.1
 */