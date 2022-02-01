package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyUgcVideoReportItem;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoMetaInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.db.struct.VisibleSetParam;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class KandianVideoUploadController
{
  public float a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private KandianVideoUploadController.DeliverVideoTaskListener jdField_a_of_type_ComTencentMobileqqKandianBizUgcKandianVideoUploadController$DeliverVideoTaskListener;
  private VisibleSetParam jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructVisibleSetParam;
  ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new KandianVideoUploadController.1(this);
  private TroopBarPOI jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI;
  public String a;
  ArrayList<TagInfo> jdField_a_of_type_JavaUtilArrayList;
  private List<ReadInJoyUgcVideoReportItem> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  ArrayList<BiuCommentInfo> jdField_b_of_type_JavaUtilArrayList;
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private String g = "";
  private String h;
  
  public KandianVideoUploadController()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
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
    this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI = ((TroopBarPOI)paramBundle.getParcelable("location"));
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructVisibleSetParam = ((VisibleSetParam)paramBundle.getParcelable("arg_visible_set_params"));
  }
  
  private void a(Bundle paramBundle, VideoMetaInfo paramVideoMetaInfo, int paramInt)
  {
    Object localObject1 = new JSONArray();
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((JSONArray)localObject1).put(((ReadInJoyUgcVideoReportItem)((Iterator)localObject2).next()).a());
      }
    }
    localObject2 = new JSONObject();
    paramInt = paramBundle.getInt("arg_video_width", 0);
    int i = paramBundle.getInt("arg_video_height", 0);
    paramBundle = paramBundle.getString("captureMode");
    try
    {
      ((JSONObject)localObject2).put("elements", localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("x");
      ((StringBuilder)localObject1).append(i);
      ((JSONObject)localObject2).put("video_width_height", ((StringBuilder)localObject1).toString());
      ((JSONObject)localObject2).put("video_bit_rate", Long.valueOf(paramVideoMetaInfo.b()).toString());
      ((JSONObject)localObject2).put("video_capacity", Long.valueOf(paramVideoMetaInfo.a()).toString());
      ((JSONObject)localObject2).put("camera_mode", paramBundle);
      ((JSONObject)localObject2).put("@_counts", "0");
      ((JSONObject)localObject2).put("tags", TextUtils.join("&", this.jdField_a_of_type_JavaUtilArrayList));
    }
    catch (Exception paramBundle)
    {
      QLog.e("ReadInJoyDeliverVideo", 2, "doStatisticsReportForBigT: ", paramBundle);
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80093D4", "0X80093D4", 0, 0, "", "", "", ((JSONObject)localObject2).toString(), false);
  }
  
  private void b(int paramInt)
  {
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = ReadInJoyUtils.a().getAccount();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoSendRequest", bool, this.jdField_f_of_type_Long - this.jdField_c_of_type_Long, 0L, localHashMap, "");
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = ReadInJoyUtils.a().getAccount();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverUGCVideo", bool, this.jdField_e_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
  
  public void a(boolean paramBoolean, Context paramContext, Bundle paramBundle, VideoMetaInfo paramVideoMetaInfo, KandianVideoUploadController.DeliverVideoTaskListener paramDeliverVideoTaskListener)
  {
    String str1 = paramVideoMetaInfo.a();
    String str2 = paramVideoMetaInfo.b();
    String str3 = paramVideoMetaInfo.c();
    String str4 = paramVideoMetaInfo.d();
    String str5 = paramVideoMetaInfo.e();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcKandianVideoUploadController$DeliverVideoTaskListener = paramDeliverVideoTaskListener;
    if (paramBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    } else {
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    }
    a(this.jdField_a_of_type_AndroidOsBundle);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
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
    paramContext = new StringBuilder();
    paramContext.append(System.currentTimeMillis() + (Math.random() * 10000.0D));
    paramContext.append("");
    this.g = paramContext.toString();
    paramContext = new StringBuilder();
    paramContext.append("coverURL:");
    paramContext.append(str1);
    paramContext.append(",coverMd5:");
    paramContext.append(str2);
    paramContext.append(", videoUrl:");
    paramContext.append(str3);
    paramContext.append(",videoMd5:");
    paramContext.append(str4);
    paramContext.append(", videoUUID:");
    paramContext.append(str5);
    paramContext = paramContext.toString();
    paramBundle = new StringBuilder();
    paramBundle.append(this.jdField_a_of_type_JavaLangString);
    paramBundle.append("send0x83eRequest,mRequestUUID:");
    paramBundle.append(this.g);
    paramBundle.append("detail info:");
    paramBundle.append(paramContext);
    QLog.d("ReadInJoyDeliverVideo", 1, paramBundle.toString());
    this.jdField_a_of_type_AndroidOsBundle.putString("up_master_deliver_uuid", this.g);
    this.jdField_a_of_type_AndroidOsBundle.putString("arg_ugc_edit_cookie", this.jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_Boolean = true;
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_JavaUtilArrayList, paramBoolean, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI, this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructVisibleSetParam);
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    a(this.jdField_a_of_type_AndroidOsBundle, paramVideoMetaInfo, this.jdField_b_of_type_JavaUtilArrayList.size());
  }
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadController
 * JD-Core Version:    0.7.0.1
 */