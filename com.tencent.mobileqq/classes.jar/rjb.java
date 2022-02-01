import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyUgcVideoReportItem;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class rjb
{
  public float a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private VisibleSetParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam;
  public QQAppInterface a;
  private TroopBarPOI jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
  public String a;
  ArrayList<TagInfo> jdField_a_of_type_JavaUtilArrayList;
  private List<ReadInJoyUgcVideoReportItem> jdField_a_of_type_JavaUtilList;
  pmn jdField_a_of_type_Pmn = new rjc(this);
  private rjd jdField_a_of_type_Rjd;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  ArrayList<SocializeFeedsInfo.BiuCommentInfo> jdField_b_of_type_JavaUtilArrayList;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private String g = "";
  private String h;
  
  public rjb()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)pha.a());
    this.jdField_e_of_type_Boolean = paramBundle.getBoolean("arg_is_from_wang_zhe", false);
    this.g = paramBundle.getString("requestUUID");
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("is_from_dian_dian", false);
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("commentString");
    this.jdField_f_of_type_JavaLangString = paramBundle.getString("arg_ugc_edit_cookie");
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getParcelableArrayList("mSelectedTagList");
    this.jdField_a_of_type_JavaUtilList = paramBundle.getParcelableArrayList("key_read_in_joy_video_upload_report");
    this.jdField_b_of_type_JavaUtilArrayList = paramBundle.getParcelableArrayList("multiBiuStruct");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("arg_video_path");
    this.jdField_d_of_type_Int = paramBundle.getInt("arg_ad_tag", 0);
    this.jdField_d_of_type_Boolean = paramBundle.getBoolean("is_from_kan_dian", false);
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("arg_video_cover");
    this.h = paramBundle.getString("compressPath");
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramBundle.getParcelable("location"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam = ((VisibleSetParam)paramBundle.getParcelable("arg_visible_set_params"));
  }
  
  private void a(Bundle paramBundle, rtm paramrtm, int paramInt)
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put(((ReadInJoyUgcVideoReportItem)((Iterator)localObject).next()).a());
      }
    }
    Object localObject = new JSONObject();
    paramInt = paramBundle.getInt("arg_video_width", 0);
    int i = paramBundle.getInt("arg_video_height", 0);
    paramBundle = paramBundle.getString("captureMode");
    try
    {
      ((JSONObject)localObject).put("elements", localJSONArray);
      ((JSONObject)localObject).put("video_width_height", paramInt + "x" + i);
      ((JSONObject)localObject).put("video_bit_rate", Long.valueOf(paramrtm.b()).toString());
      ((JSONObject)localObject).put("video_capacity", Long.valueOf(paramrtm.a()).toString());
      ((JSONObject)localObject).put("camera_mode", paramBundle);
      ((JSONObject)localObject).put("@_counts", "0");
      ((JSONObject)localObject).put("tags", TextUtils.join("&", this.jdField_a_of_type_JavaUtilArrayList));
      oat.a(null, "", "0X80093D4", "0X80093D4", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("ReadInJoyDeliverVideo", 2, "doStatisticsReportForBigT: ", paramBundle);
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    bctj localbctj = bctj.a(this.jdField_a_of_type_AndroidContentContext);
    String str = pha.a().getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localbctj.a(str, "actReadInJoyDeliverVideoSendRequest", bool, this.jdField_f_of_type_Long - this.jdField_c_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    bctj localbctj = bctj.a(this.jdField_a_of_type_AndroidContentContext);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localbctj.a(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    bctj localbctj = bctj.a(this.jdField_a_of_type_AndroidContentContext);
    String str = pha.a().getAccount();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localbctj.a(str, "actReadInJoyDeliverUGCVideo", bool, this.jdField_e_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a(boolean paramBoolean, Context paramContext, Bundle paramBundle, rtm paramrtm, rjd paramrjd)
  {
    String str1 = paramrtm.a();
    String str2 = paramrtm.b();
    String str3 = paramrtm.c();
    String str4 = paramrtm.d();
    String str5 = paramrtm.e();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Rjd = paramrjd;
    if (paramBundle == null) {}
    for (this.jdField_a_of_type_AndroidOsBundle = new Bundle();; this.jdField_a_of_type_AndroidOsBundle = paramBundle)
    {
      a(this.jdField_a_of_type_AndroidOsBundle);
      pmk.a().a(this.jdField_a_of_type_Pmn);
      this.jdField_a_of_type_AndroidOsBundle.putString("arg_video_cover_url", str1);
      if (!paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("arg_video_cover_md5", str2);
        this.jdField_a_of_type_AndroidOsBundle.putString("arg_video_url", str3);
        this.jdField_a_of_type_AndroidOsBundle.putString("arg_video_md5", str4);
        this.jdField_a_of_type_AndroidOsBundle.putString("arg_video_uuid", str5);
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("arg_video_title", this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putParcelableArrayList("arg_ugc_tag_list", this.jdField_a_of_type_JavaUtilArrayList);
      this.g = (System.currentTimeMillis() + (Math.random() * 10000.0D) + "");
      paramContext = "coverURL:" + str1 + ",coverMd5:" + str2 + ", videoUrl:" + str3 + ",videoMd5:" + str4 + ", videoUUID:" + str5;
      QLog.d("ReadInJoyDeliverVideo", 1, this.jdField_a_of_type_JavaLangString + "send0x83eRequest,mRequestUUID:" + this.g + "detail info:" + paramContext);
      this.jdField_a_of_type_AndroidOsBundle.putString("up_master_deliver_uuid", this.g);
      this.jdField_a_of_type_AndroidOsBundle.putString("arg_ugc_edit_cookie", this.jdField_f_of_type_JavaLangString);
      this.jdField_c_of_type_Boolean = true;
      pmh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_JavaUtilArrayList, paramBoolean, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVisibleSetParam);
      this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      a(this.jdField_a_of_type_AndroidOsBundle, paramrtm, this.jdField_b_of_type_JavaUtilArrayList.size());
      return;
    }
  }
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjb
 * JD-Core Version:    0.7.0.1
 */