import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.MsgTabNodeEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabHaloEntity;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class tfi
  implements ssl
{
  public int a;
  public long a;
  public String a;
  public List<tga> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public List<tsr> b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public String g;
  public String h = "";
  public String i = "";
  public String j;
  public String k;
  
  public tfi()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_Boolean = true;
  }
  
  public tfi(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return 1;
    }
    if (this.jdField_d_of_type_Int > 0) {
      return 2;
    }
    return 0;
  }
  
  public long a(String paramString)
  {
    try
    {
      Object[] arrayOfObject = this.jdField_a_of_type_JavaUtilList.toArray();
      if (arrayOfObject != null)
      {
        int n = arrayOfObject.length;
        m = 0;
        if (m < n)
        {
          tga localtga = (tga)arrayOfObject[m];
          if (TextUtils.equals(paramString, localtga.jdField_a_of_type_JavaLangString)) {
            return localtga.jdField_b_of_type_Long;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int m;
        veg.c("Q.qqstory.msgTab.nodeList.MsgTabNodeInfo", "getRecommendIdByVid:%s", localException);
        Object localObject = null;
        continue;
        m += 1;
      }
    }
    return 0L;
  }
  
  public MsgTabNodeEntity a()
  {
    MsgTabNodeEntity localMsgTabNodeEntity = new MsgTabNodeEntity();
    localMsgTabNodeEntity.nodeType = this.jdField_a_of_type_Int;
    localMsgTabNodeEntity.uid = this.jdField_b_of_type_Long;
    localMsgTabNodeEntity.unionId = this.jdField_a_of_type_JavaLangString;
    localMsgTabNodeEntity.nodeVid = this.jdField_e_of_type_JavaLangString;
    localMsgTabNodeEntity.nodeFeedId = this.jdField_f_of_type_JavaLangString;
    localMsgTabNodeEntity.title = this.jdField_c_of_type_JavaLangString;
    localMsgTabNodeEntity.headUrl = this.jdField_b_of_type_JavaLangString;
    localMsgTabNodeEntity.recommendId = this.jdField_e_of_type_Long;
    localMsgTabNodeEntity.jumpUrl = this.jdField_d_of_type_JavaLangString;
    localMsgTabNodeEntity.nodePosition = this.jdField_c_of_type_Int;
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((tga)localIterator.next()).a());
    }
    localMsgTabNodeEntity.videoInfoList = localJSONArray.toString();
    localMsgTabNodeEntity.reqTimeStamp = this.jdField_c_of_type_Long;
    localMsgTabNodeEntity.nodeInfoTimeStamp = this.jdField_d_of_type_Long;
    localMsgTabNodeEntity.videoCover = this.jdField_g_of_type_JavaLangString;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localJSONArray = new JSONArray();
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((tsr)localIterator.next()).a());
      }
      localMsgTabNodeEntity.localSuccessVideoList = localJSONArray.toString();
    }
    localMsgTabNodeEntity.recommandNameIconUrl = this.j;
    localMsgTabNodeEntity.cacheSeq = this.jdField_f_of_type_Long;
    localMsgTabNodeEntity.passthrough = this.k;
    localMsgTabNodeEntity.redPoint = this.jdField_c_of_type_Boolean;
    return localMsgTabNodeEntity;
  }
  
  public MsgTabHaloEntity a()
  {
    MsgTabHaloEntity localMsgTabHaloEntity = new MsgTabHaloEntity();
    localMsgTabHaloEntity.nodeType = this.jdField_a_of_type_Int;
    localMsgTabHaloEntity.uid = this.jdField_b_of_type_Long;
    localMsgTabHaloEntity.unionId = this.jdField_a_of_type_JavaLangString;
    localMsgTabHaloEntity.nodeVid = this.jdField_e_of_type_JavaLangString;
    localMsgTabHaloEntity.title = this.jdField_c_of_type_JavaLangString;
    localMsgTabHaloEntity.headUrl = this.jdField_b_of_type_JavaLangString;
    localMsgTabHaloEntity.recommendId = this.jdField_e_of_type_Long;
    localMsgTabHaloEntity.jumpUrl = this.jdField_d_of_type_JavaLangString;
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((tga)localIterator.next()).a());
    }
    localMsgTabHaloEntity.videoInfoList = localJSONArray.toString();
    localMsgTabHaloEntity.reqTimeStamp = this.jdField_c_of_type_Long;
    localMsgTabHaloEntity.nodeInfoTimeStamp = this.jdField_d_of_type_Long;
    localMsgTabHaloEntity.videoCover = this.jdField_g_of_type_JavaLangString;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localJSONArray = new JSONArray();
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((tsr)localIterator.next()).a());
      }
      localMsgTabHaloEntity.localSuccessVideoList = localJSONArray.toString();
    }
    localMsgTabHaloEntity.noUpdate = this.jdField_e_of_type_Int;
    return localMsgTabHaloEntity;
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    int n = 0;
    this.jdField_a_of_type_Int = paramMsgTabNodeEntity.nodeType;
    this.jdField_b_of_type_Long = paramMsgTabNodeEntity.uid;
    this.jdField_a_of_type_JavaLangString = paramMsgTabNodeEntity.unionId;
    this.jdField_c_of_type_JavaLangString = paramMsgTabNodeEntity.title;
    this.jdField_b_of_type_JavaLangString = paramMsgTabNodeEntity.headUrl;
    this.jdField_e_of_type_Long = paramMsgTabNodeEntity.recommendId;
    this.jdField_d_of_type_JavaLangString = paramMsgTabNodeEntity.jumpUrl;
    this.jdField_e_of_type_JavaLangString = paramMsgTabNodeEntity.nodeVid;
    this.jdField_f_of_type_JavaLangString = paramMsgTabNodeEntity.nodeFeedId;
    this.jdField_g_of_type_JavaLangString = paramMsgTabNodeEntity.videoCover;
    this.jdField_c_of_type_Int = paramMsgTabNodeEntity.nodePosition;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramMsgTabNodeEntity.videoInfoList);
      int i1 = localJSONArray1.length();
      m = 0;
      JSONObject localJSONObject;
      Object localObject;
      while (m < i1)
      {
        localJSONObject = localJSONArray1.getJSONObject(m);
        localObject = new tga();
        ((tga)localObject).a(localJSONObject);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        if (!((tga)localObject).jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_Int += 1;
        }
        m += 1;
      }
      JSONArray localJSONArray2;
      if (this.jdField_a_of_type_Int == 11) {
        break label360;
      }
    }
    catch (JSONException localJSONException1)
    {
      veg.c("Q.qqstory.msgTab.nodeList.MsgTabNodeInfo", "convertFrom(entity) errors", localJSONException1);
      this.jdField_c_of_type_Long = paramMsgTabNodeEntity.reqTimeStamp;
      this.jdField_d_of_type_Long = paramMsgTabNodeEntity.nodeInfoTimeStamp;
      if ((!TextUtils.isEmpty(paramMsgTabNodeEntity.localSuccessVideoList)) && (!paramMsgTabNodeEntity.localSuccessVideoList.equals("null"))) {
        try
        {
          localJSONArray2 = new JSONArray(paramMsgTabNodeEntity.localSuccessVideoList);
          this.jdField_b_of_type_JavaUtilList = new ArrayList();
          i1 = localJSONArray2.length();
          m = 0;
          while (m < i1)
          {
            localJSONObject = localJSONArray2.getJSONObject(m);
            localObject = new tsr();
            ((tsr)localObject).a(localJSONObject);
            this.jdField_b_of_type_JavaUtilList.add(localObject);
            m += 1;
          }
          if (this.jdField_a_of_type_Int == 10) {
            break label360;
          }
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    if (this.jdField_a_of_type_Int == 3) {
      label360:
      if (!tgb.b(this)) {
        break label423;
      }
    }
    label423:
    for (int m = n;; m = 1)
    {
      this.jdField_b_of_type_Int = m;
      this.j = paramMsgTabNodeEntity.recommandNameIconUrl;
      this.jdField_f_of_type_Long = paramMsgTabNodeEntity.cacheSeq;
      this.k = paramMsgTabNodeEntity.passthrough;
      this.jdField_c_of_type_Boolean = paramMsgTabNodeEntity.redPoint;
      this.jdField_g_of_type_Int = paramMsgTabNodeEntity.videoCoverType;
      this.jdField_d_of_type_Boolean = paramMsgTabNodeEntity.firstExp;
      return;
    }
  }
  
  public void a(MsgTabHaloEntity paramMsgTabHaloEntity)
  {
    int n = 0;
    this.jdField_a_of_type_Int = paramMsgTabHaloEntity.nodeType;
    this.jdField_b_of_type_Long = paramMsgTabHaloEntity.uid;
    this.jdField_a_of_type_JavaLangString = paramMsgTabHaloEntity.unionId;
    this.jdField_c_of_type_JavaLangString = paramMsgTabHaloEntity.title;
    this.jdField_b_of_type_JavaLangString = paramMsgTabHaloEntity.headUrl;
    this.jdField_e_of_type_Long = paramMsgTabHaloEntity.recommendId;
    this.jdField_d_of_type_JavaLangString = paramMsgTabHaloEntity.jumpUrl;
    this.jdField_e_of_type_JavaLangString = paramMsgTabHaloEntity.nodeVid;
    this.jdField_g_of_type_JavaLangString = paramMsgTabHaloEntity.videoCover;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramMsgTabHaloEntity.videoInfoList);
      int i1 = localJSONArray1.length();
      m = 0;
      JSONObject localJSONObject;
      Object localObject;
      while (m < i1)
      {
        localJSONObject = localJSONArray1.getJSONObject(m);
        localObject = new tga();
        ((tga)localObject).a(localJSONObject);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        if (!((tga)localObject).jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_Int += 1;
        }
        m += 1;
      }
      JSONArray localJSONArray2;
      if (this.jdField_a_of_type_Int == 11) {
        break label340;
      }
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
      this.jdField_c_of_type_Long = paramMsgTabHaloEntity.reqTimeStamp;
      this.jdField_d_of_type_Long = paramMsgTabHaloEntity.nodeInfoTimeStamp;
      if ((!TextUtils.isEmpty(paramMsgTabHaloEntity.localSuccessVideoList)) && (!paramMsgTabHaloEntity.localSuccessVideoList.equals("null"))) {
        try
        {
          localJSONArray2 = new JSONArray(paramMsgTabHaloEntity.localSuccessVideoList);
          this.jdField_b_of_type_JavaUtilList = new ArrayList();
          i1 = localJSONArray2.length();
          m = 0;
          while (m < i1)
          {
            localJSONObject = localJSONArray2.getJSONObject(m);
            localObject = new tsr();
            ((tsr)localObject).a(localJSONObject);
            this.jdField_b_of_type_JavaUtilList.add(localObject);
            m += 1;
          }
          if (this.jdField_a_of_type_Int == 10) {
            break label340;
          }
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    if (this.jdField_a_of_type_Int == 3) {
      label340:
      if (!tgb.b(this)) {
        break label368;
      }
    }
    label368:
    for (int m = n;; m = 1)
    {
      this.jdField_b_of_type_Int = m;
      this.jdField_e_of_type_Int = paramMsgTabHaloEntity.noUpdate;
      this.jdField_f_of_type_Int = 1;
      return;
    }
  }
  
  public void a(qqstory_service.MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.jdField_a_of_type_Int = paramMsgTabNodeInfo.uint32_node_type.get();
    this.jdField_b_of_type_Long = paramMsgTabNodeInfo.uint64_uid.get();
    this.jdField_a_of_type_JavaLangString = paramMsgTabNodeInfo.bytes_union_id.get().toStringUtf8();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramMsgTabNodeInfo.rpt_msg_video_info_list.size());
    this.jdField_b_of_type_Int = 0;
    ArrayDeque localArrayDeque = new ArrayDeque(3);
    Iterator localIterator = paramMsgTabNodeInfo.rpt_msg_video_info_list.get().iterator();
    while (localIterator.hasNext())
    {
      qqstory_service.MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (qqstory_service.MsgTabNodeVideoInfo)localIterator.next();
      tga localtga = new tga();
      localtga.a(localMsgTabNodeVideoInfo, localArrayDeque);
      this.jdField_a_of_type_JavaUtilList.add(localtga);
      if (!localtga.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Int += 1;
      }
    }
    this.jdField_c_of_type_Long = paramMsgTabNodeInfo.uint64_req_time_stamp.get();
    this.jdField_d_of_type_Long = paramMsgTabNodeInfo.uint64_node_info_time_stamp.get();
    this.jdField_e_of_type_Long = paramMsgTabNodeInfo.recommend_id.get();
    if (paramMsgTabNodeInfo.bytes_title.has()) {
      this.jdField_c_of_type_JavaLangString = paramMsgTabNodeInfo.bytes_title.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.bytes_icon_url.has()) {
      this.jdField_b_of_type_JavaLangString = paramMsgTabNodeInfo.bytes_icon_url.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.link_url.has()) {
      this.jdField_d_of_type_JavaLangString = paramMsgTabNodeInfo.link_url.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.node_vid.has()) {
      this.jdField_e_of_type_JavaLangString = paramMsgTabNodeInfo.node_vid.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.video_cover.has()) {
      this.jdField_g_of_type_JavaLangString = paramMsgTabNodeInfo.video_cover.get().toStringUtf8();
    }
    if (paramMsgTabNodeInfo.node_position.has()) {
      this.jdField_c_of_type_Int = paramMsgTabNodeInfo.node_position.get();
    }
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_Int == 3)) {
      if (!tgb.b(this)) {
        break label603;
      }
    }
    label603:
    for (int m = 0;; m = 1)
    {
      this.jdField_b_of_type_Int = m;
      if ((this.jdField_a_of_type_Int == 12) && (paramMsgTabNodeInfo.rpt_msg_video_info_list.size() > 0))
      {
        this.jdField_e_of_type_JavaLangString = ((qqstory_service.MsgTabNodeVideoInfo)paramMsgTabNodeInfo.rpt_msg_video_info_list.get(0)).vid.get().toStringUtf8();
        this.jdField_f_of_type_JavaLangString = ((qqstory_service.MsgTabNodeVideoInfo)paramMsgTabNodeInfo.rpt_msg_video_info_list.get(0)).feed_id.get().toStringUtf8();
      }
      this.jdField_e_of_type_Int = paramMsgTabNodeInfo.no_update.get();
      if (paramMsgTabNodeInfo.recommend_name_icon.has()) {
        this.j = paramMsgTabNodeInfo.recommend_name_icon.get().toStringUtf8();
      }
      if (paramMsgTabNodeInfo.uint64_cache_seq.has()) {
        this.jdField_f_of_type_Long = paramMsgTabNodeInfo.uint64_cache_seq.get();
      }
      if (paramMsgTabNodeInfo.passthrough.has()) {
        this.k = paramMsgTabNodeInfo.passthrough.get().toStringUtf8();
      }
      if (paramMsgTabNodeInfo.redpoint.has())
      {
        this.jdField_c_of_type_Boolean = paramMsgTabNodeInfo.redpoint.get();
        veg.a("Q.qqstory.msgTab.nodeList.MsgTabNodeInfo", "MsgTabNodeInfo convertFrom, unionId:%s, uid:%s, redPoint:%s", this.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_b_of_type_Long), Boolean.valueOf(this.jdField_c_of_type_Boolean));
      }
      if (paramMsgTabNodeInfo.video_cover_type.has()) {
        this.jdField_g_of_type_Int = paramMsgTabNodeInfo.video_cover_type.get();
      }
      if (this.jdField_a_of_type_Int == 13) {
        tgb.a(QQStoryContext.a()).c(this);
      }
      return;
    }
  }
  
  public void a(tfi paramtfi)
  {
    this.jdField_d_of_type_Int = paramtfi.jdField_d_of_type_Int;
    this.jdField_b_of_type_Boolean = paramtfi.jdField_b_of_type_Boolean;
    this.h = paramtfi.h;
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      tga localtga = (tga)localIterator.next();
      if ((TextUtils.isEmpty(localtga.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localtga.jdField_b_of_type_JavaLangString))) {
        return false;
      }
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof tfi))
    {
      paramObject = (tfi)paramObject;
      this.jdField_a_of_type_Int = paramObject.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramObject.jdField_b_of_type_Long;
      this.jdField_a_of_type_JavaLangString = paramObject.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramObject.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Boolean = paramObject.jdField_a_of_type_Boolean;
      this.jdField_c_of_type_Long = paramObject.jdField_c_of_type_Long;
      this.jdField_d_of_type_Long = paramObject.jdField_d_of_type_Long;
      this.jdField_b_of_type_Int = paramObject.jdField_b_of_type_Int;
      this.jdField_e_of_type_Long = paramObject.jdField_e_of_type_Long;
      this.jdField_b_of_type_JavaLangString = paramObject.jdField_b_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramObject.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = paramObject.jdField_d_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = paramObject.jdField_e_of_type_JavaLangString;
      this.jdField_f_of_type_JavaLangString = paramObject.jdField_f_of_type_JavaLangString;
      this.jdField_d_of_type_Int = paramObject.jdField_d_of_type_Int;
      this.jdField_b_of_type_Boolean = paramObject.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_JavaUtilList = paramObject.jdField_b_of_type_JavaUtilList;
      this.h = paramObject.h;
      this.jdField_c_of_type_Int = paramObject.jdField_c_of_type_Int;
      this.jdField_e_of_type_Int = paramObject.jdField_e_of_type_Int;
      this.i = paramObject.i;
      this.j = paramObject.j;
      this.jdField_f_of_type_Long = paramObject.jdField_f_of_type_Long;
      this.k = paramObject.k;
      this.jdField_c_of_type_Boolean = paramObject.jdField_c_of_type_Boolean;
      this.jdField_g_of_type_Int = paramObject.jdField_g_of_type_Int;
      this.jdField_d_of_type_Boolean = paramObject.jdField_d_of_type_Boolean;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof tfi)) {
        return false;
      }
      paramObject = (tfi)paramObject;
      if (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) {
        return false;
      }
      if (this.jdField_a_of_type_JavaLangString != null) {
        return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
      }
    } while (paramObject.jdField_a_of_type_JavaLangString == null);
    return false;
  }
  
  public int hashCode()
  {
    int n = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (int m = this.jdField_a_of_type_JavaLangString.hashCode();; m = 0) {
      return m + (n + 629) * 37;
    }
  }
  
  public String toString()
  {
    return "MsgTabNodeInfo{nodeType=" + this.jdField_a_of_type_Int + ", title='" + this.jdField_c_of_type_JavaLangString + '\'' + ", uid=" + this.jdField_b_of_type_Long + ", unionId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", unreadCount=" + this.jdField_b_of_type_Int + ", nodePosition=" + this.jdField_c_of_type_Int + ", videoInfoList.size=" + this.jdField_a_of_type_JavaUtilList.size() + ", nodeVid='" + this.jdField_e_of_type_JavaLangString + '\'' + ", nodeFeedId='" + this.jdField_f_of_type_JavaLangString + '\'' + ", reqTimeStamp=" + this.jdField_c_of_type_Long + ", nodeInfoTimeStamp=" + this.jdField_d_of_type_Long + ", unUploadVideoCount=" + this.jdField_d_of_type_Int + ", id=" + this.jdField_a_of_type_Long + ", noUpdate=" + this.jdField_e_of_type_Int + '\'' + ", recommendId=" + this.jdField_e_of_type_Long + ", isUploading=" + this.jdField_b_of_type_Boolean + ", headerUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", jumpUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", videoCover='" + this.jdField_g_of_type_JavaLangString + '\'' + ", uploadingCover=" + this.h + ", recommandNameIconUrl=" + this.j + ", cacheSeq='" + this.jdField_f_of_type_Long + '\'' + ", passthrough=" + this.k + ", redPoint=" + this.jdField_c_of_type_Boolean + ", videoCoverType=" + this.jdField_g_of_type_Int + ", firstExp=" + this.jdField_d_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfi
 * JD-Core Version:    0.7.0.1
 */