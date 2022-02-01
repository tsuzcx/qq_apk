package com.tencent.mobileqq.kandian.repo.common;

import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.SRTUniversalID;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTRule;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ReadInJoySrtUtils
{
  private static ReadInJoySrtUtils jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoySrtUtils;
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private List<oidb_cmd0x64e.SRTRule> jdField_a_of_type_JavaUtilList = new ArrayList();
  private oidb_cmd0x64e.SRTClickInfo jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo;
  private String jdField_b_of_type_JavaLangString;
  private List<ReadInJoySrtUtils.SRTInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private ReadInJoySrtUtils()
  {
    b();
  }
  
  private ReadInJoySrtUtils.SRTInfo a(oidb_cmd0x64e.SRTRule paramSRTRule)
  {
    if (paramSRTRule == null) {
      return null;
    }
    ReadInJoySrtUtils.SRTInfo localSRTInfo = new ReadInJoySrtUtils.SRTInfo(this);
    if (paramSRTRule.uint32_click_number.has()) {
      localSRTInfo.jdField_b_of_type_JavaUtilList = paramSRTRule.uint32_click_number.get();
    }
    if (paramSRTRule.uint32_feeds_type.has()) {
      localSRTInfo.jdField_a_of_type_JavaUtilList = paramSRTRule.uint32_feeds_type.get();
    }
    if (paramSRTRule.uint32_network_type.has()) {
      localSRTInfo.jdField_a_of_type_Int = paramSRTRule.uint32_network_type.get();
    }
    if (paramSRTRule.bytes_app_package_name.has()) {
      localSRTInfo.jdField_a_of_type_JavaLangString = paramSRTRule.bytes_app_package_name.get().toStringUtf8();
    }
    if (paramSRTRule.bytes_schema.has()) {
      localSRTInfo.c = paramSRTRule.bytes_schema.get().toStringUtf8();
    }
    if (paramSRTRule.bytes_h5.has()) {
      localSRTInfo.jdField_b_of_type_JavaLangString = paramSRTRule.bytes_h5.get().toStringUtf8();
    }
    paramSRTRule = new StringBuilder();
    paramSRTRule.append("convertSRTPbToSRTClassclickNumList = ");
    paramSRTRule.append(localSRTInfo.jdField_b_of_type_JavaUtilList);
    paramSRTRule.append(" feedsTypeList= ");
    paramSRTRule.append(localSRTInfo.jdField_a_of_type_JavaUtilList);
    paramSRTRule.append(" netWorkType= ");
    paramSRTRule.append(localSRTInfo.jdField_a_of_type_Int);
    paramSRTRule.append(" packageName = ");
    paramSRTRule.append(localSRTInfo.jdField_a_of_type_JavaLangString);
    paramSRTRule.append(" schemaUrl= ");
    paramSRTRule.append(localSRTInfo.c);
    paramSRTRule.append(" h5Url= ");
    paramSRTRule.append(localSRTInfo.jdField_b_of_type_JavaLangString);
    QLog.d("ReadInJoySrtUtils", 1, paramSRTRule.toString());
    return localSRTInfo;
  }
  
  public static ReadInJoySrtUtils a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoySrtUtils == null) {
        jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoySrtUtils = new ReadInJoySrtUtils();
      }
      ReadInJoySrtUtils localReadInJoySrtUtils = jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoySrtUtils;
      return localReadInJoySrtUtils;
    }
    finally {}
  }
  
  private String a(ReadInJoySrtUtils.SRTInfo paramSRTInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    if ((!TextUtils.isEmpty(paramSRTInfo.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramSRTInfo.c)))
    {
      if (TextUtils.isEmpty(paramSRTInfo.jdField_a_of_type_JavaLangString)) {
        return "";
      }
      String str2 = paramSRTInfo.jdField_a_of_type_JavaLangString;
      String str1 = paramSRTInfo.jdField_b_of_type_JavaLangString;
      paramSRTInfo = paramSRTInfo.c;
      paramTemplateBean = a(paramAbsBaseArticleInfo, str2, paramTemplateBean, paramViewBase);
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("appPackageName = ");
      paramAbsBaseArticleInfo.append(str2);
      paramAbsBaseArticleInfo.append("defaultURL = ");
      paramAbsBaseArticleInfo.append(str1);
      paramAbsBaseArticleInfo.append("appSchema = ");
      paramAbsBaseArticleInfo.append(paramSRTInfo);
      paramAbsBaseArticleInfo.append(" rowKey = ");
      paramAbsBaseArticleInfo.append(paramTemplateBean);
      QLog.d("ReadInJoySrtUtils", 1, paramAbsBaseArticleInfo.toString());
      if ((TextUtils.isEmpty(paramTemplateBean)) && ((str1.contains("${rowkey}")) || (paramSRTInfo.contains("${rowkey}")))) {
        return "";
      }
      if (!TextUtils.isEmpty(paramTemplateBean))
      {
        paramAbsBaseArticleInfo = str1.replace("${rowkey}", paramTemplateBean).replace("${uin}", RIJQQAppInterfaceUtil.a());
        paramSRTInfo = paramSRTInfo.replace("${rowkey}", paramTemplateBean).replace("${uin}", RIJQQAppInterfaceUtil.a());
      }
      else
      {
        paramAbsBaseArticleInfo = str1;
      }
      paramTemplateBean = new StringBuilder();
      try
      {
        paramTemplateBean.append("mqqapi://readinjoy/open?src_type=internal&target=4");
        paramTemplateBean.append("&defaultURL=");
        paramTemplateBean.append(URLEncoder.encode(paramAbsBaseArticleInfo, "utf-8"));
        paramTemplateBean.append("&appSchema=");
        paramTemplateBean.append(URLEncoder.encode(paramSRTInfo, "utf-8"));
        paramTemplateBean.append("&appPackageName=");
        paramTemplateBean.append(str2);
        paramTemplateBean.append("&readinjoyNotDecodeUrl=1");
        paramTemplateBean.append("&version=1");
        paramTemplateBean.append("&isCancelJump=0");
      }
      catch (UnsupportedEncodingException paramSRTInfo)
      {
        paramSRTInfo.printStackTrace();
      }
      QLog.d("ReadInJoySrtUtils", 1, paramTemplateBean.toString());
      return paramTemplateBean.toString();
    }
    return "";
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    String str = "";
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramAbsBaseArticleInfo.srtUniversalID != null))
    {
      paramAbsBaseArticleInfo = a(paramAbsBaseArticleInfo.srtUniversalID, paramTemplateBean, paramViewBase);
      if (paramAbsBaseArticleInfo == null)
      {
        QLog.d("ReadInJoySrtUtils", 1, "srtUniversalID is null ");
        return "";
      }
      if ((paramString.equals("com.tencent.reading")) && (paramAbsBaseArticleInfo.bytes_kb_id.has()))
      {
        if (paramAbsBaseArticleInfo.bytes_kb_id.get() != null) {
          str = paramAbsBaseArticleInfo.bytes_kb_id.get().toStringUtf8();
        }
        return str;
      }
      if ((paramString.equals("com.tencent.rijvideo")) && (paramAbsBaseArticleInfo.bytes_ks_id.has()))
      {
        if (paramAbsBaseArticleInfo.bytes_ks_id.get() != null) {
          str = paramAbsBaseArticleInfo.bytes_ks_id.get().toStringUtf8();
        }
        return str;
      }
      if ((paramString.equals("com.tencent.weishi")) && (paramAbsBaseArticleInfo.bytes_ws_id.has()))
      {
        if (paramAbsBaseArticleInfo.bytes_ws_id.get() != null) {
          str = paramAbsBaseArticleInfo.bytes_ws_id.get().toStringUtf8();
        }
        return str;
      }
      QLog.d("ReadInJoySrtUtils", 1, "getRowKey : no appPackageName hit ");
      return "";
    }
    QLog.d("ReadInJoySrtUtils", 1, "getRowKey error, some object is null");
    if (paramAbsBaseArticleInfo != null)
    {
      paramString = new StringBuilder();
      paramString.append("srtuniversalIdList is null = ");
      boolean bool;
      if (paramAbsBaseArticleInfo.srtUniversalID == null) {
        bool = true;
      } else {
        bool = false;
      }
      paramString.append(bool);
      QLog.d("ReadInJoySrtUtils", 1, paramString.toString());
    }
    return "";
  }
  
  private articlesummary.SRTUniversalID a(List<articlesummary.SRTUniversalID> paramList, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    int j;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      j = 0;
      if ((paramTemplateBean != null) && (paramViewBase != null))
      {
        paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId()).get("srt_universal_id_index");
        i = j;
        if (!(paramTemplateBean instanceof String)) {}
      }
    }
    try
    {
      i = Integer.parseInt((String)paramTemplateBean);
    }
    catch (Exception paramTemplateBean)
    {
      label69:
      break label69;
    }
    QLog.e("ReadInJoySrtUtils", 1, "handlePositionAndGetSRT parse int error");
    int i = j;
    if ((paramList.size() > i) && (i >= 0)) {
      return (articlesummary.SRTUniversalID)paramList.get(i);
    }
    return null;
    return (articlesummary.SRTUniversalID)paramList.get(0);
    return null;
  }
  
  private oidb_cmd0x64e.SRTRule a(ReadInJoySrtUtils.SRTInfo paramSRTInfo)
  {
    if (paramSRTInfo == null) {
      return null;
    }
    oidb_cmd0x64e.SRTRule localSRTRule = new oidb_cmd0x64e.SRTRule();
    if (paramSRTInfo.c != null) {
      localSRTRule.bytes_schema.set(ByteStringMicro.copyFromUtf8(paramSRTInfo.c));
    }
    if (paramSRTInfo.jdField_b_of_type_JavaLangString != null) {
      localSRTRule.bytes_h5.set(ByteStringMicro.copyFromUtf8(paramSRTInfo.jdField_b_of_type_JavaLangString));
    }
    if (paramSRTInfo.jdField_a_of_type_JavaLangString != null) {
      localSRTRule.bytes_app_package_name.set(ByteStringMicro.copyFromUtf8(paramSRTInfo.jdField_a_of_type_JavaLangString));
    }
    if (paramSRTInfo.jdField_b_of_type_JavaUtilList != null) {
      localSRTRule.uint32_click_number.set(paramSRTInfo.jdField_b_of_type_JavaUtilList);
    }
    if (paramSRTInfo.jdField_a_of_type_JavaUtilList != null) {
      localSRTRule.uint32_feeds_type.set(paramSRTInfo.jdField_a_of_type_JavaUtilList);
    }
    localSRTRule.uint32_network_type.set(paramSRTInfo.jdField_a_of_type_Int);
    return localSRTRule;
  }
  
  private void a(ReadInJoySrtUtils.SRTInfo paramSRTInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (paramInt3 >= ((List)localObject).size()) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("convertSRTClickInfo feedsType:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" clickTimes: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" position");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("ReadInJoySrtUtils", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo = new oidb_cmd0x64e.SRTClickInfo();
      paramSRTInfo = a(paramSRTInfo);
      if (paramSRTInfo != null)
      {
        localObject = new ArrayList();
        ((List)localObject).add(Integer.valueOf(paramInt2));
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(paramInt1));
        paramSRTInfo.uint32_click_number.set((List)localObject);
        paramSRTInfo.uint32_feeds_type.set(localArrayList);
      }
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.msg_srt_rule_list.set(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.uint32_hit_srt_rule_index.set(paramInt3);
      if (paramSRTInfo != null) {
        this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.msg_hit_srt_rule.set(paramSRTInfo);
      }
    }
  }
  
  private boolean a(ReadInJoySrtUtils.SRTInfo paramSRTInfo, int paramInt)
  {
    if (paramSRTInfo == null) {
      return false;
    }
    if (paramSRTInfo.jdField_b_of_type_JavaUtilList != null)
    {
      if (paramSRTInfo.jdField_a_of_type_JavaUtilList == null) {
        return false;
      }
      int i = paramSRTInfo.jdField_a_of_type_Int;
      int j = NetworkUtil.a(BaseActivity.sTopActivity);
      if (j == 0) {
        return false;
      }
      if (((i == 1) && (j != 1)) || ((i == 2) && (j == 1))) {
        return false;
      }
      if (!paramSRTInfo.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) {
        return false;
      }
      return paramSRTInfo.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(this.jdField_a_of_type_Int));
    }
    return false;
  }
  
  private void b() {}
  
  private void c()
  {
    try
    {
      Object localObject1 = (String)RIJSPUtils.a("readinjoy_srt_click_time_key", "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = new JSONObject();
      } else {
        localObject1 = new JSONObject((String)localObject1);
      }
      Object localObject2 = ((JSONObject)localObject1).optString("time", "");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("clickTimes");
      ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
      int j = ((JSONObject)localObject1).optInt(((StringBuilder)localObject3).toString(), 0);
      localObject3 = TimeSliceHelper.a();
      int i = j;
      if (j == 0) {
        i = this.jdField_a_of_type_Int;
      }
      if (!((String)localObject2).equals(localObject3))
      {
        localObject1 = new JSONObject();
        i = 0;
      }
      i += 1;
      this.jdField_a_of_type_Int = i;
      ((JSONObject)localObject1).put("time", localObject3);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("clickTimes");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject1).put(((StringBuilder)localObject2).toString(), i);
      RIJSPUtils.a("readinjoy_srt_click_time_key", ((JSONObject)localObject1).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      QLog.d("ReadInJoySrtUtils", 1, "getJumpSchema schemaCache is null");
    }
    String str = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = null;
    return str;
  }
  
  public oidb_cmd0x64e.SRTClickInfo a()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo == null)
    {
      QLog.d("ReadInJoySrtUtils", 1, "getNoDifferenceDiversionInfo cache is null");
      return null;
    }
    QLog.d("ReadInJoySrtUtils", 1, "getNoDifferenceDiversionInfo");
    oidb_cmd0x64e.SRTClickInfo localSRTClickInfo = this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo;
    this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo = null;
    return localSRTClickInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Int = 0;
    QLog.d("ReadInJoySrtUtils", 1, "clearData");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    ArrayList localArrayList = new ArrayList();
    Object localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("channel_id");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramString);
    localArrayList.add(localObject);
    ReadinjoyReportUtils.a(202, localArrayList);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start requestSRTRulesattris size = ");
    ((StringBuilder)localObject).append(localArrayList.size());
    ((StringBuilder)localObject).append("event_id = ");
    ((StringBuilder)localObject).append(202);
    ((StringBuilder)localObject).append("id: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ReadInJoySrtUtils", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(List<oidb_cmd0x64e.SRTRule> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      Object localObject = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ReadInJoySrtUtils.SRTInfo localSRTInfo = a((oidb_cmd0x64e.SRTRule)localIterator.next());
        if (localSRTInfo != null) {
          ((List)localObject).add(localSRTInfo);
        }
      }
      this.jdField_b_of_type_JavaUtilList = ((List)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle0x80aRespInfo  size = ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("ReadInJoySrtUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a()
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    return (localList != null) && (localList.size() != 0);
  }
  
  public boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0) && (paramAbsBaseArticleInfo != null) && ((paramAbsBaseArticleInfo.mChannelID == 0L) || (DailyModeConfigHandler.c((int)paramAbsBaseArticleInfo.mChannelID))))
    {
      c();
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject = (ReadInJoySrtUtils.SRTInfo)this.jdField_b_of_type_JavaUtilList.get(i);
        int j = RIJFeedsType.a(paramAbsBaseArticleInfo);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startJudge feedsType:");
        localStringBuilder.append(j);
        localStringBuilder.append(" clickTimes: ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(" position");
        localStringBuilder.append(i);
        QLog.d("ReadInJoySrtUtils", 1, localStringBuilder.toString());
        if (a((ReadInJoySrtUtils.SRTInfo)localObject, j))
        {
          paramAbsBaseArticleInfo = a((ReadInJoySrtUtils.SRTInfo)localObject, paramAbsBaseArticleInfo, paramTemplateBean, paramViewBase);
          if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
            return false;
          }
          this.jdField_a_of_type_JavaLangString = paramAbsBaseArticleInfo;
          a((ReadInJoySrtUtils.SRTInfo)localObject, j, this.jdField_a_of_type_Int, i);
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append("hitSrtRules feedsType:");
          paramAbsBaseArticleInfo.append(j);
          paramAbsBaseArticleInfo.append(" clickTimes: ");
          paramAbsBaseArticleInfo.append(this.jdField_a_of_type_Int);
          paramAbsBaseArticleInfo.append(" position");
          paramAbsBaseArticleInfo.append(i);
          QLog.d("ReadInJoySrtUtils", 1, paramAbsBaseArticleInfo.toString());
          return true;
        }
        i += 1;
      }
      return false;
    }
    QLog.d("ReadInJoySrtUtils", 1, "judgeIsNeedNoDifferenceDiversion srtInfos is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils
 * JD-Core Version:    0.7.0.1
 */