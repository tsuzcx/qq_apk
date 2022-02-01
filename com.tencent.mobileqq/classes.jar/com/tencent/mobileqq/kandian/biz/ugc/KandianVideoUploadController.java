package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyUgcVideoReportItem;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoMetaInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.db.struct.VisibleSetParam;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
  private long A;
  private int B;
  private Context C;
  private KandianVideoUploadController.DeliverVideoTaskListener D;
  private TroopBarPOI E;
  private VisibleSetParam F;
  private String G = "";
  private String H;
  ArrayList<TagInfo> a;
  QQAppInterface b;
  boolean c;
  ArrayList<BiuCommentInfo> d;
  public boolean e = false;
  public boolean f = false;
  public String g;
  public float h;
  String i;
  String j;
  boolean k;
  public int l = 0;
  public long m;
  ReadInJoyObserver n = new KandianVideoUploadController.1(this);
  private long o = 0L;
  private long p;
  private List<ReadInJoyUgcVideoReportItem> q;
  private Bundle r;
  private String s = null;
  private boolean t;
  private String u;
  private String v;
  private int w = 0;
  private int x = 0;
  private long y = 0L;
  private long z;
  
  private void a(Bundle paramBundle)
  {
    this.b = ((QQAppInterface)ReadInJoyUtils.b());
    this.t = paramBundle.getBoolean("arg_is_from_wang_zhe", false);
    this.G = paramBundle.getString("requestUUID");
    this.c = paramBundle.getBoolean("is_from_dian_dian", false);
    this.u = paramBundle.getString("commentString");
    this.v = paramBundle.getString("arg_ugc_edit_cookie");
    this.a = paramBundle.getParcelableArrayList("mSelectedTagList");
    this.q = paramBundle.getParcelableArrayList("key_read_in_joy_video_upload_report");
    this.d = paramBundle.getParcelableArrayList("multiBiuStruct");
    this.i = paramBundle.getString("arg_video_path");
    this.B = paramBundle.getInt("arg_ad_tag", 0);
    this.k = paramBundle.getBoolean("is_from_kan_dian", false);
    this.j = paramBundle.getString("arg_video_cover");
    this.H = paramBundle.getString("compressPath");
    this.E = ((TroopBarPOI)paramBundle.getParcelable("location"));
    this.F = ((VisibleSetParam)paramBundle.getParcelable("arg_visible_set_params"));
  }
  
  private void a(Bundle paramBundle, VideoMetaInfo paramVideoMetaInfo, int paramInt)
  {
    Object localObject1 = new JSONArray();
    Object localObject2 = this.q;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((JSONArray)localObject1).put(((ReadInJoyUgcVideoReportItem)((Iterator)localObject2).next()).a());
      }
    }
    localObject2 = new JSONObject();
    paramInt = paramBundle.getInt("arg_video_width", 0);
    int i1 = paramBundle.getInt("arg_video_height", 0);
    paramBundle = paramBundle.getString("captureMode");
    try
    {
      ((JSONObject)localObject2).put("elements", localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("x");
      ((StringBuilder)localObject1).append(i1);
      ((JSONObject)localObject2).put("video_width_height", ((StringBuilder)localObject1).toString());
      ((JSONObject)localObject2).put("video_bit_rate", Long.valueOf(paramVideoMetaInfo.h()).toString());
      ((JSONObject)localObject2).put("video_capacity", Long.valueOf(paramVideoMetaInfo.f()).toString());
      ((JSONObject)localObject2).put("camera_mode", paramBundle);
      ((JSONObject)localObject2).put("@_counts", "0");
      ((JSONObject)localObject2).put("tags", TextUtils.join("&", this.a));
    }
    catch (Exception paramBundle)
    {
      QLog.e("ReadInJoyDeliverVideo", 2, "doStatisticsReportForBigT: ", paramBundle);
    }
    PublicAccountReportUtils.a(null, "", "0X80093D4", "0X80093D4", 0, 0, "", "", "", ((JSONObject)localObject2).toString(), false);
  }
  
  private void b(int paramInt)
  {
    this.A = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.C);
    String str = ReadInJoyUtils.b().getAccount();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoSendRequest", bool, this.A - this.p, 0L, localHashMap, "");
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.o;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.C);
    String str = this.b.getCurrentAccountUin();
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
    this.z = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.C);
    String str = ReadInJoyUtils.b().getAccount();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverUGCVideo", bool, this.z - this.m, 0L, localHashMap, "");
  }
  
  public void a(boolean paramBoolean, Context paramContext, Bundle paramBundle, VideoMetaInfo paramVideoMetaInfo, KandianVideoUploadController.DeliverVideoTaskListener paramDeliverVideoTaskListener)
  {
    String str1 = paramVideoMetaInfo.b();
    String str2 = paramVideoMetaInfo.c();
    String str3 = paramVideoMetaInfo.d();
    String str4 = paramVideoMetaInfo.e();
    String str5 = paramVideoMetaInfo.g();
    this.C = paramContext;
    this.D = paramDeliverVideoTaskListener;
    if (paramBundle == null) {
      this.r = new Bundle();
    } else {
      this.r = paramBundle;
    }
    a(this.r);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.n);
    this.r.putString("arg_video_cover_url", str1);
    if (!paramBoolean)
    {
      this.r.putString("arg_video_cover_md5", str2);
      this.r.putString("arg_video_url", str3);
      this.r.putString("arg_video_md5", str4);
      this.r.putString("arg_video_uuid", str5);
    }
    this.r.putString("arg_video_title", this.u);
    this.r.putParcelableArrayList("arg_ugc_tag_list", this.a);
    paramContext = new StringBuilder();
    paramContext.append(System.currentTimeMillis() + (Math.random() * 10000.0D));
    paramContext.append("");
    this.G = paramContext.toString();
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
    paramBundle.append(this.g);
    paramBundle.append("send0x83eRequest,mRequestUUID:");
    paramBundle.append(this.G);
    paramBundle.append("detail info:");
    paramBundle.append(paramContext);
    QLog.d("ReadInJoyDeliverVideo", 1, paramBundle.toString());
    this.r.putString("up_master_deliver_uuid", this.G);
    this.r.putString("arg_ugc_edit_cookie", this.v);
    this.f = true;
    ReadInJoyLogicEngine.a().a(this.b.getCurrentUin(), this.u, this.r, this.d, paramBoolean, this.c, this.E, this.F);
    this.o = NetConnInfoCenter.getServerTimeMillis();
    this.p = System.currentTimeMillis();
    a(this.r, paramVideoMetaInfo, this.d.size());
  }
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.KandianVideoUploadController
 * JD-Core Version:    0.7.0.1
 */