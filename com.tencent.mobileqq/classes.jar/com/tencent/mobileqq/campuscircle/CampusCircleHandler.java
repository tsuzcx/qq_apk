package com.tencent.mobileqq.campuscircle;

import abpf;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import tencent.im.oidb.cmd0x94c.cmd0x94c.ReqBody;
import tencent.im.oidb.cmd0x94c.cmd0x94c.RspBody;
import tencent.im.oidb.cmd0x94d.cmd0x94d.ReqBody;
import tencent.im.oidb.cmd0x94d.cmd0x94d.RspBody;
import tencent.im.oidb.cmd0x94d.cmd0x94d.TCollege;
import tencent.im.oidb.cmd0x94d.cmd0x94d.TSchool;
import tencent.im.oidb.cmd0x950.oidb_0x950.ReqBody;
import tencent.im.oidb.cmd0x950.oidb_0x950.RspBody;
import tencent.im.oidb.cmd0x954.cmd0x954.FeedInfo;
import tencent.im.oidb.cmd0x954.cmd0x954.ReqBody;
import tencent.im.oidb.cmd0x954.cmd0x954.ReqFeedsParam;
import tencent.im.oidb.cmd0x954.cmd0x954.RspBody;
import tencent.im.oidb.cmd0x955.oidb_0x955.ReqBody;
import tencent.im.oidb.cmd0x955.oidb_0x955.RspBody;

public class CampusCircleHandler
  extends BusinessHandler
{
  private CampusConfig a;
  
  public CampusCircleHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusConfig = new CampusConfig();
    ThreadManager.post(new abpf(this, paramQQAppInterface), 8, null, false);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    oidb_0x950.RspBody localRspBody = new oidb_0x950.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    Object localObject1 = null;
    List localList = null;
    Object localObject7 = null;
    Object localObject2 = null;
    paramBundle = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    paramFromServiceMsg = null;
    Object localObject5 = null;
    paramObject = null;
    Bundle localBundle = null;
    int j = paramToServiceMsg.extraData.getInt("nFromType");
    label108:
    boolean bool;
    if (i == 0) {
      switch (j)
      {
      default: 
        localObject1 = localObject3;
        paramObject = localObject2;
        paramBundle = null;
        paramFromServiceMsg = localBundle;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        bool = true;
      }
    }
    for (;;)
    {
      a(1, bool, new Object[] { paramBundle, paramObject, paramToServiceMsg, paramFromServiceMsg });
      if (bool)
      {
        localObject1 = (CampusCircleManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(215);
        switch (j)
        {
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircle", 2, String.format(Locale.getDefault(), "handleGetCampusTopics isSuc: %b from: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) }));
        }
        return;
        paramObject = localObject2;
        localObject1 = localObject3;
        if (!localRspBody.rpt_topics.has()) {
          break;
        }
        localObject1 = CampusTopic.convert2CampusTopicList(localRspBody.rpt_topics.get(), 0);
        paramObject = localList;
        paramToServiceMsg = paramBundle;
        paramBundle = (Bundle)localObject1;
        break label108;
        paramToServiceMsg = localObject7;
        if (localRspBody.rpt_recommended_recommend.has()) {
          paramToServiceMsg = CampusTopic.convert2CampusTopicList(localRspBody.rpt_recommended_recommend.get(), 1);
        }
        paramFromServiceMsg = localObject4;
        if (localRspBody.rpt_recommended_config.has()) {
          paramFromServiceMsg = CampusTopic.convert2CampusTopicList(localRspBody.rpt_recommended_config.get(), 2);
        }
        paramBundle = paramObject;
        if (localRspBody.rpt_recommended_recently_used.has()) {
          paramBundle = CampusTopic.convert2CampusTopicList(localRspBody.rpt_recommended_recently_used.get(), 0);
        }
        paramObject = paramToServiceMsg;
        localObject1 = paramFromServiceMsg;
        localBundle = paramBundle;
        if (!localRspBody.rpt_topics.has()) {
          break;
        }
        localList = CampusTopic.convert2CampusTopicList(localRspBody.rpt_topics.get(), 0);
        if (paramBundle == null)
        {
          paramBundle = localList;
          localObject1 = null;
          paramObject = paramToServiceMsg;
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = paramBundle;
          paramBundle = (Bundle)localObject1;
          break label108;
        }
        paramObject = paramToServiceMsg;
        localObject1 = paramFromServiceMsg;
        localBundle = paramBundle;
        if (localList == null) {
          break;
        }
        paramObject = paramToServiceMsg;
        localObject1 = paramFromServiceMsg;
        localBundle = paramBundle;
        if (localList.size() <= 0) {
          break;
        }
        paramBundle.addAll(localList);
        paramObject = paramToServiceMsg;
        localObject1 = paramFromServiceMsg;
        localBundle = paramBundle;
        break;
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          ((CampusCircleManager)localObject1).a(paramBundle, j, null);
          continue;
          if (paramObject != null) {
            ((CampusCircleManager)localObject1).a(paramObject, j, "tag_recommend_topic");
          }
          if (paramToServiceMsg != null) {
            ((CampusCircleManager)localObject1).a(paramToServiceMsg, j, "tag_hot_topic");
          }
          if (paramFromServiceMsg != null) {
            ((CampusCircleManager)localObject1).a(paramFromServiceMsg, j, "tag_more_topic");
          }
        }
      }
      bool = false;
      paramObject = null;
      paramToServiceMsg = localObject6;
      paramFromServiceMsg = localObject5;
      paramBundle = (Bundle)localObject1;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Bundle localBundle = paramToServiceMsg.extraData.getBundle("req_bundle");
    Object localObject = new cmd0x94c.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramToServiceMsg = null;
    int j;
    if (i == 0)
    {
      paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      paramFromServiceMsg = paramObject.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (((cmd0x94c.RspBody)localObject).str_school.has()) {
        paramFromServiceMsg.strSchool = ((cmd0x94c.RspBody)localObject).str_school.get();
      }
      if (((cmd0x94c.RspBody)localObject).str_campus_school.has()) {
        paramFromServiceMsg.strCampusSchool = ((cmd0x94c.RspBody)localObject).str_campus_school.get();
      }
      if (((cmd0x94c.RspBody)localObject).uint32_campus_enrol_time.has()) {
        paramFromServiceMsg.nCampusEnrolYear = ((cmd0x94c.RspBody)localObject).uint32_campus_enrol_time.get();
      }
      if (((cmd0x94c.RspBody)localObject).str_campus_college.has()) {
        paramFromServiceMsg.strCampusCollege = ((cmd0x94c.RspBody)localObject).str_campus_college.get();
      }
      if (((cmd0x94c.RspBody)localObject).str_campus_realname.has()) {
        paramFromServiceMsg.strCampusName = ((cmd0x94c.RspBody)localObject).str_campus_realname.get();
      }
      if (((cmd0x94c.RspBody)localObject).uint32_campus_college_id.has()) {
        paramFromServiceMsg.lCampusCollegeID = ((cmd0x94c.RspBody)localObject).uint32_campus_college_id.get();
      }
      if (((cmd0x94c.RspBody)localObject).uint32_campus_school_id.has()) {
        paramFromServiceMsg.lCampusSchoolID = ((cmd0x94c.RspBody)localObject).uint32_campus_school_id.get();
      }
      if (((cmd0x94c.RspBody)localObject).uint32_campus_last_modify_time.has()) {
        paramFromServiceMsg.lCampusLastModifySchoolTime = ((cmd0x94c.RspBody)localObject).uint32_campus_last_modify_time.get();
      }
      if (((cmd0x94c.RspBody)localObject).str_campus_class.has()) {
        paramFromServiceMsg.strCampusClass = ((cmd0x94c.RspBody)localObject).str_campus_class.get();
      }
      if (((cmd0x94c.RspBody)localObject).uint32_campus_cert_user.has()) {
        paramFromServiceMsg.iCampusIsSigned = ((cmd0x94c.RspBody)localObject).uint32_campus_cert_user.get();
      }
      if (((cmd0x94c.RspBody)localObject).uint32_campus_school_canbe_certified.has()) {
        paramFromServiceMsg.nCampusSchoolFlag = ((cmd0x94c.RspBody)localObject).uint32_campus_school_canbe_certified.get();
      }
      if (((cmd0x94c.RspBody)localObject).uint32_campus_school_certification_status.has()) {
        paramFromServiceMsg.nCampusStatus = ((cmd0x94c.RspBody)localObject).uint32_campus_school_certification_status.get();
      }
      if (paramFromServiceMsg.nCampusStatus == 4)
      {
        j = CampusCircleHelper.b(paramFromServiceMsg.lCampusSchoolID);
        if (j == 0)
        {
          paramFromServiceMsg.strCampusAcademy = "";
          paramObject.a(paramFromServiceMsg);
          a(3, true, new Object[] { localBundle, paramFromServiceMsg });
          paramToServiceMsg = paramFromServiceMsg;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder(200);
        paramFromServiceMsg.append("handleSetCampusInfo");
        paramFromServiceMsg.append(", result = ").append(i);
        if (paramToServiceMsg != null) {
          paramFromServiceMsg.append(", strSchool = ").append(paramToServiceMsg.strSchool).append(", strCampusAcademy = ").append(paramToServiceMsg.strCampusAcademy).append(", strCampusSchool = ").append(paramToServiceMsg.strCampusSchool).append(", lCampusSchoolID = ").append(paramToServiceMsg.lCampusSchoolID).append(", strCampusCollege = ").append(paramToServiceMsg.strCampusCollege).append(", strCampusClass = ").append(paramToServiceMsg.strCampusClass).append(", nCampusStatus = ").append(paramToServiceMsg.nCampusStatus).append(", nCampusSchoolFlag = ").append(paramToServiceMsg.nCampusSchoolFlag).append(", nCampusEnrolYear = ").append(paramToServiceMsg.nCampusEnrolYear);
        }
        QLog.i("CampusCircle", 2, paramFromServiceMsg.toString());
      }
      return;
      if (j == 4)
      {
        localObject = Locale.getDefault();
        if (TextUtils.isEmpty(paramFromServiceMsg.strCampusSchool)) {}
        for (paramToServiceMsg = paramFromServiceMsg.strSchool;; paramToServiceMsg = paramFromServiceMsg.strCampusSchool)
        {
          paramFromServiceMsg.strCampusAcademy = String.format((Locale)localObject, "%s %s %d级", new Object[] { paramToServiceMsg, paramFromServiceMsg.strCampusCollege, Integer.valueOf(paramFromServiceMsg.nCampusEnrolYear) });
          break;
        }
      }
      localObject = Locale.getDefault();
      if (TextUtils.isEmpty(paramFromServiceMsg.strCampusSchool)) {}
      for (paramToServiceMsg = paramFromServiceMsg.strSchool;; paramToServiceMsg = paramFromServiceMsg.strCampusSchool)
      {
        paramFromServiceMsg.strCampusAcademy = String.format((Locale)localObject, "%s %s %s", new Object[] { paramToServiceMsg, CampusCircleHelper.a(paramFromServiceMsg.lCampusSchoolID, paramFromServiceMsg.nCampusEnrolYear), paramFromServiceMsg.strCampusClass });
        break;
      }
      paramFromServiceMsg.strCampusAcademy = "";
      break;
      a(3, false, new Object[] { localBundle, null });
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramBundle = new oidb_0x955.RspBody();
    int j = a(paramFromServiceMsg, paramObject, paramBundle);
    long l2 = paramToServiceMsg.extraData.getLong("sesstionId");
    long l1;
    boolean bool;
    if (j == 0)
    {
      l1 = paramBundle.uint64_publisher_uin.get();
      paramToServiceMsg = paramBundle.bytes_feeds_id.get().toStringUtf8();
      bool = true;
    }
    for (;;)
    {
      paramBundle = (CampusCircleManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(215);
      CampusCircleManager.TopicPublishSession localTopicPublishSession = paramBundle.a(l2);
      paramFromServiceMsg = null;
      paramObject = null;
      if (localTopicPublishSession != null)
      {
        paramFromServiceMsg = localTopicPublishSession.a;
        paramBundle.a(l2, bool);
        paramObject = localTopicPublishSession.c;
      }
      a(2, bool, new Object[] { Integer.valueOf(j), String.valueOf(l1), paramToServiceMsg, paramObject });
      paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      int i;
      if (j == 0)
      {
        i = 0;
        CampusCircleHelper.a(paramToServiceMsg, "actPublishCampusFeed", i, paramBundle.a);
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder().append("handlePublishCampusFeed, isSuc=").append(bool).append(",ret=").append(j).append(",sesstionId=").append(l2).append(",reqkey=");
          if (paramFromServiceMsg == null) {
            break label264;
          }
        }
      }
      label264:
      for (l1 = paramFromServiceMsg.key;; l1 = -1L)
      {
        QLog.d("CampusCircle", 2, l1);
        return;
        i = 2;
        break;
      }
      bool = false;
      l1 = 0L;
      paramToServiceMsg = "";
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    String str1 = paramToServiceMsg.extraData.getString("uin");
    String str2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    boolean bool = Utils.a(str1, str2);
    paramToServiceMsg = new cmd0x954.RspBody();
    label88:
    int i;
    if (a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) {
      if (paramToServiceMsg.rpt_feed_info_list.has())
      {
        paramToServiceMsg = paramToServiceMsg.rpt_feed_info_list.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
          break label288;
        }
        paramObject = paramToServiceMsg.iterator();
        for (;;)
        {
          if (paramObject.hasNext())
          {
            paramToServiceMsg = (cmd0x954.FeedInfo)paramObject.next();
            if (paramToServiceMsg != null) {
              if (paramToServiceMsg.uint32_anonymity.has())
              {
                i = paramToServiceMsg.uint32_anonymity.get();
                label130:
                if (!paramToServiceMsg.bytes_content.has()) {
                  break label283;
                }
                paramToServiceMsg = paramToServiceMsg.bytes_content.get().toStringUtf8();
                label151:
                if (TextUtils.isEmpty(paramToServiceMsg)) {
                  break label286;
                }
                paramFromServiceMsg = paramToServiceMsg;
                if (!bool)
                {
                  if (i != 0) {
                    continue;
                  }
                  paramFromServiceMsg = paramToServiceMsg;
                }
                label172:
                paramToServiceMsg = paramFromServiceMsg;
              }
            }
          }
        }
      }
    }
    for (bool = true;; bool = false)
    {
      paramFromServiceMsg = localObject;
      if (bool)
      {
        paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramFromServiceMsg = paramObject.b(str1);
        paramFromServiceMsg.strLastCampusFeeds = paramToServiceMsg;
        paramObject.a(paramFromServiceMsg);
      }
      a(4, bool, paramFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.i("CampusCircle", 2, String.format(Locale.getDefault(), "handleGetCampusFeeds success: %b uin: %s selfUin: %s strFeedContent: %s", new Object[] { Boolean.valueOf(bool), str1, str2, paramToServiceMsg }));
      }
      return;
      paramToServiceMsg = null;
      break;
      i = 0;
      break label130;
      label283:
      paramToServiceMsg = null;
      break label151;
      label286:
      break label88;
      label288:
      paramFromServiceMsg = null;
      break label172;
      paramToServiceMsg = null;
    }
  }
  
  @TargetApi(11)
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("schoolId");
    String str = paramToServiceMsg.extraData.getString("schoolName");
    paramToServiceMsg = new cmd0x94d.RspBody();
    label203:
    label207:
    boolean bool;
    if (a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      paramToServiceMsg = paramToServiceMsg.rpt_schools.get();
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        paramToServiceMsg = paramToServiceMsg.iterator();
        for (;;)
        {
          if (paramToServiceMsg.hasNext())
          {
            paramFromServiceMsg = (cmd0x94d.TSchool)paramToServiceMsg.next();
            if ((paramFromServiceMsg != null) && (l == paramFromServiceMsg.uint64_id.get()))
            {
              paramToServiceMsg = paramFromServiceMsg.rpt_colleges.get();
              if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
              {
                paramFromServiceMsg = new ArrayList();
                paramObject = paramToServiceMsg.iterator();
                while (paramObject.hasNext())
                {
                  paramToServiceMsg = (cmd0x94d.TCollege)paramObject.next();
                  if ((paramToServiceMsg != null) && (paramToServiceMsg.str_name.has())) {}
                  for (paramToServiceMsg = paramToServiceMsg.str_name.get();; paramToServiceMsg = null)
                  {
                    if (TextUtils.isEmpty(paramToServiceMsg)) {
                      break label203;
                    }
                    paramFromServiceMsg.add(paramToServiceMsg);
                    break;
                  }
                }
                paramToServiceMsg = paramFromServiceMsg;
                bool = true;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        paramFromServiceMsg = CampusCircleHelper.a(l, str);
        paramObject = new HashSet();
        paramObject.addAll(paramToServiceMsg);
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getPreferences().edit().putStringSet(paramFromServiceMsg, paramObject).apply();
      }
      a(5, bool, new Object[] { Long.valueOf(l), str, paramToServiceMsg });
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = Locale.getDefault();
        if (paramToServiceMsg != null) {
          break label361;
        }
      }
      label361:
      for (int i = 0;; i = paramToServiceMsg.size())
      {
        QLog.i("CampusCircle", 2, String.format(paramFromServiceMsg, "handleGetCollegeList ret: %b schoolId: %d, schoolName: %s college_name_list_size: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), str, Integer.valueOf(i) }));
        return;
      }
      paramToServiceMsg = null;
      break label207;
      paramToServiceMsg = null;
      break;
      bool = false;
      paramToServiceMsg = null;
    }
  }
  
  public CampusConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusConfig;
  }
  
  protected Class a()
  {
    return CampusCircleObserver.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircle", 2, String.format(Locale.getDefault(), "getCampusTopics from: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    try
    {
      Object localObject = new oidb_0x950.ReqBody();
      ((oidb_0x950.ReqBody)localObject).uint32_req_type.set(1);
      if (paramInt == 2) {
        ((oidb_0x950.ReqBody)localObject).uint32_req_with_recommendation.set(1);
      }
      for (;;)
      {
        localObject = a("OidbSvc.0x950", 2384, 1, ((oidb_0x950.ReqBody)localObject).toByteArray());
        ((ToServiceMsg)localObject).extraData.putInt("nFromType", paramInt);
        b((ToServiceMsg)localObject);
        return;
        ((oidb_0x950.ReqBody)localObject).uint32_req_with_recommendation.set(0);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircle", 2, localException, new Object[0]);
      }
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {}
    int i;
    do
    {
      return;
      i = CampusCircleHelper.a(paramLong);
      Object localObject = new cmd0x94d.ReqBody();
      ((cmd0x94d.ReqBody)localObject).uint64_id.set(paramLong);
      ((cmd0x94d.ReqBody)localObject).str_name.set(paramString);
      ((cmd0x94d.ReqBody)localObject).uint32_type.set(i);
      ((cmd0x94d.ReqBody)localObject).uint32_req_class_list.set(1);
      localObject = a("OidbSvc.0x94d", 2381, 0, ((cmd0x94d.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putLong("schoolId", paramLong);
      ((ToServiceMsg)localObject).extraData.putString("schoolName", paramString);
      b((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("CampusCircle", 2, String.format(Locale.getDefault(), "getCollegeList [%d, %s, %d]", new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(i) }));
  }
  
  public void a(Bundle paramBundle)
  {
    int j = 1;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CampusCircle", 2, "setCampusInfo bundle is null");
      }
      return;
    }
    int i = 0;
    cmd0x94c.ReqBody localReqBody = new cmd0x94c.ReqBody();
    String str;
    Object localObject;
    if (paramBundle.containsKey("campus_school"))
    {
      str = paramBundle.getString("campus_school");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localReqBody.str_school.set((String)localObject);
      i = 1;
    }
    if (paramBundle.containsKey("campus_school_id"))
    {
      i = CampusCircleHelper.a(paramBundle.getLong("campus_school_id"));
      localReqBody.uint32_school_type.set(i);
      i = 1;
    }
    if (paramBundle.containsKey("campus_college"))
    {
      str = paramBundle.getString("campus_college");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localReqBody.str_college.set((String)localObject);
      i = 1;
    }
    if (paramBundle.containsKey("campus_class"))
    {
      localReqBody.str_class.set(paramBundle.getString("campus_class"));
      i = 1;
    }
    if (paramBundle.containsKey("campus_enroll_year"))
    {
      localReqBody.uint32_admission_year.set(paramBundle.getInt("campus_enroll_year"));
      i = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = a("OidbSvc.0x94c", 2380, 2, localReqBody.toByteArray());
        ((ToServiceMsg)localObject).extraData.putBundle("req_bundle", paramBundle);
        b((ToServiceMsg)localObject);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CampusCircle", 2, "setCampusInfo not change any data");
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("friendUin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramFromServiceMsg.getUin();
    }
    if (a(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("uin", (String)localObject1);
      localObject1 = paramFromServiceMsg.getServiceCmd();
      if ("OidbSvc.0x950".equals(localObject1))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
        return;
      }
      if ("OidbSvc.0x955".equals(localObject1))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
        return;
      }
      if ("OidbSvc.0x94c".equals(localObject1))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x954".equals(localObject1))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x94d".equals(localObject1));
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label94:
    do
    {
      return;
      long l1 = 0L;
      try
      {
        str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          long l2;
          Object localObject;
          cmd0x954.ReqFeedsParam localReqFeedsParam;
          String str = null;
          localException1.printStackTrace();
        }
      }
      try
      {
        l2 = Long.parseLong(paramString);
        l1 = l2;
        localObject = new cmd0x954.ReqBody();
        ((cmd0x954.ReqBody)localObject).uint64_uin.set(l1);
        ((cmd0x954.ReqBody)localObject).enum_refresh_type.set(0);
        localReqFeedsParam = new cmd0x954.ReqFeedsParam();
        localReqFeedsParam.uint32_req_myself_publish.set(1);
        ((cmd0x954.ReqBody)localObject).req_feeds_param.set(localReqFeedsParam);
        if (!paramString.equals(str)) {
          break label190;
        }
        i = 0;
      }
      catch (Exception localException2)
      {
        break;
        i = 1;
        break label94;
      }
      localObject = a("OidbSvc.0x954", 2388, i, ((cmd0x954.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
      b((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("CampusCircle", 2, String.format(Locale.getDefault(), "getCampusFeed uin: %s selfUin: %s nServiceType: %d", new Object[] { paramString, str, Integer.valueOf(i) }));
  }
  
  public boolean a(long paramLong, CampusCircleManager.CampusTopicReq paramCampusTopicReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircle", 2, "publishCampusTopic, sesstionId=" + paramLong + ",reqkey=" + paramCampusTopicReq.key);
    }
    oidb_0x955.ReqBody localReqBody;
    try
    {
      localReqBody = new oidb_0x955.ReqBody();
      long l = Long.parseLong(paramCampusTopicReq.uin);
      localReqBody.uint64_publisher_uin.set(l);
      localReqBody.uint32_retry_count.set(paramCampusTopicReq.retryCnt);
      if (!TextUtils.isEmpty(paramCampusTopicReq.content)) {
        localReqBody.bytes_content.set(ByteStringMicro.copyFromUtf8(paramCampusTopicReq.content));
      }
      if (paramCampusTopicReq.picInfos != null)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramCampusTopicReq.picInfos.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(ByteStringMicro.copyFromUtf8(((CampusCircleManager.PicInfo)localIterator.next()).url));
        }
        localReqBody.rpt_pic_url.set(localArrayList);
      }
    }
    catch (Exception paramCampusTopicReq)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircle", 2, paramCampusTopicReq, new Object[0]);
      }
      return false;
    }
    localReqBody.uint32_anonymity.set(paramCampusTopicReq.anonymousFlag);
    if (paramCampusTopicReq.feedType != 0) {
      localReqBody.rpt_uint32_type_id.add(Integer.valueOf(paramCampusTopicReq.feedType));
    }
    if (paramCampusTopicReq.publicityTopicId != 0) {
      localReqBody.rpt_uint32_type_id.add(Integer.valueOf(paramCampusTopicReq.publicityTopicId));
    }
    paramCampusTopicReq = a("OidbSvc.0x955", 2389, 0, localReqBody.toByteArray());
    paramCampusTopicReq.extraData.putLong("sesstionId", paramLong);
    b(paramCampusTopicReq);
    return true;
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x950");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x955");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x94c");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x954");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x94d");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleHandler
 * JD-Core Version:    0.7.0.1
 */