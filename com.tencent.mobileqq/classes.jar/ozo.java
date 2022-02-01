import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.BaseActivity;
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

public class ozo
{
  private static ozo jdField_a_of_type_Ozo;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private List<oidb_cmd0x64e.SRTRule> jdField_a_of_type_JavaUtilList = new ArrayList();
  private oidb_cmd0x64e.SRTClickInfo jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo;
  private String jdField_b_of_type_JavaLangString;
  private List<ozp> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private ozo()
  {
    b();
  }
  
  private String a(BaseArticleInfo paramBaseArticleInfo, String paramString, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramBaseArticleInfo == null) || (TextUtils.isEmpty(paramString)) || (paramBaseArticleInfo.srtUniversalID == null))
    {
      QLog.d("ReadInJoySrtUtils", 1, "getRowKey error, some object is null");
      if (paramBaseArticleInfo != null)
      {
        paramString = new StringBuilder().append("srtuniversalIdList is null = ");
        if (paramBaseArticleInfo.srtUniversalID != null) {
          break label71;
        }
      }
      label71:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ReadInJoySrtUtils", 1, bool);
        return "";
      }
    }
    paramBaseArticleInfo = a(paramBaseArticleInfo.srtUniversalID, paramTemplateBean, paramViewBase);
    if (paramBaseArticleInfo == null)
    {
      QLog.d("ReadInJoySrtUtils", 1, "srtUniversalID is null ");
      return "";
    }
    if ((paramString.equals("com.tencent.reading")) && (paramBaseArticleInfo.bytes_kb_id.has()))
    {
      if (paramBaseArticleInfo.bytes_kb_id.get() != null) {
        return paramBaseArticleInfo.bytes_kb_id.get().toStringUtf8();
      }
      return "";
    }
    if ((paramString.equals("com.tencent.rijvideo")) && (paramBaseArticleInfo.bytes_ks_id.has()))
    {
      if (paramBaseArticleInfo.bytes_ks_id.get() != null) {
        return paramBaseArticleInfo.bytes_ks_id.get().toStringUtf8();
      }
      return "";
    }
    if ((paramString.equals("com.tencent.weishi")) && (paramBaseArticleInfo.bytes_ws_id.has()))
    {
      if (paramBaseArticleInfo.bytes_ws_id.get() != null) {
        return paramBaseArticleInfo.bytes_ws_id.get().toStringUtf8();
      }
      return "";
    }
    QLog.d("ReadInJoySrtUtils", 1, "getRowKey : no appPackageName hit ");
    return "";
  }
  
  private String a(ozp paramozp, BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    if ((TextUtils.isEmpty(paramozp.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramozp.c)) || (TextUtils.isEmpty(paramozp.jdField_a_of_type_JavaLangString))) {
      return "";
    }
    String str3 = paramozp.jdField_a_of_type_JavaLangString;
    String str1 = paramozp.jdField_b_of_type_JavaLangString;
    String str2 = paramozp.c;
    paramTemplateBean = a(paramBaseArticleInfo, str3, paramTemplateBean, paramViewBase);
    QLog.d("ReadInJoySrtUtils", 1, "appPackageName = " + str3 + "defaultURL = " + str1 + "appSchema = " + str2 + " rowKey = " + paramTemplateBean);
    if ((TextUtils.isEmpty(paramTemplateBean)) && ((str1.contains("${rowkey}")) || (str2.contains("${rowkey}")))) {
      return "";
    }
    paramBaseArticleInfo = str2;
    paramozp = str1;
    if (!TextUtils.isEmpty(paramTemplateBean))
    {
      paramozp = str1.replace("${rowkey}", paramTemplateBean).replace("${uin}", ozs.a());
      paramBaseArticleInfo = str2.replace("${rowkey}", paramTemplateBean).replace("${uin}", ozs.a());
    }
    paramTemplateBean = new StringBuilder();
    try
    {
      paramTemplateBean.append("mqqapi://readinjoy/open?src_type=internal&target=4").append("&defaultURL=").append(URLEncoder.encode(paramozp, "utf-8")).append("&appSchema=").append(URLEncoder.encode(paramBaseArticleInfo, "utf-8")).append("&appPackageName=").append(str3).append("&readinjoyNotDecodeUrl=1").append("&version=1").append("&isCancelJump=0");
      QLog.d("ReadInJoySrtUtils", 1, paramTemplateBean.toString());
      return paramTemplateBean.toString();
    }
    catch (UnsupportedEncodingException paramozp)
    {
      for (;;)
      {
        paramozp.printStackTrace();
      }
    }
  }
  
  public static ozo a()
  {
    try
    {
      if (jdField_a_of_type_Ozo == null) {
        jdField_a_of_type_Ozo = new ozo();
      }
      ozo localozo = jdField_a_of_type_Ozo;
      return localozo;
    }
    finally {}
  }
  
  private ozp a(oidb_cmd0x64e.SRTRule paramSRTRule)
  {
    if (paramSRTRule == null) {
      return null;
    }
    ozp localozp = new ozp(this);
    if (paramSRTRule.uint32_click_number.has()) {
      localozp.jdField_b_of_type_JavaUtilList = paramSRTRule.uint32_click_number.get();
    }
    if (paramSRTRule.uint32_feeds_type.has()) {
      localozp.jdField_a_of_type_JavaUtilList = paramSRTRule.uint32_feeds_type.get();
    }
    if (paramSRTRule.uint32_network_type.has()) {
      localozp.jdField_a_of_type_Int = paramSRTRule.uint32_network_type.get();
    }
    if (paramSRTRule.bytes_app_package_name.has()) {
      localozp.jdField_a_of_type_JavaLangString = paramSRTRule.bytes_app_package_name.get().toStringUtf8();
    }
    if (paramSRTRule.bytes_schema.has()) {
      localozp.c = paramSRTRule.bytes_schema.get().toStringUtf8();
    }
    if (paramSRTRule.bytes_h5.has()) {
      localozp.jdField_b_of_type_JavaLangString = paramSRTRule.bytes_h5.get().toStringUtf8();
    }
    QLog.d("ReadInJoySrtUtils", 1, "convertSRTPbToSRTClassclickNumList = " + localozp.jdField_b_of_type_JavaUtilList + " feedsTypeList= " + localozp.jdField_a_of_type_JavaUtilList + " netWorkType= " + localozp.jdField_a_of_type_Int + " packageName = " + localozp.jdField_a_of_type_JavaLangString + " schemaUrl= " + localozp.c + " h5Url= " + localozp.jdField_b_of_type_JavaLangString);
    return localozp;
  }
  
  private articlesummary.SRTUniversalID a(List<articlesummary.SRTUniversalID> paramList, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return (articlesummary.SRTUniversalID)paramList.get(0);
    }
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId()).get("srt_universal_id_index");
    if ((paramTemplateBean instanceof String)) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)paramTemplateBean);
        if ((paramList.size() <= i) || (i < 0)) {
          break;
        }
        return (articlesummary.SRTUniversalID)paramList.get(i);
      }
      catch (Exception paramTemplateBean)
      {
        QLog.e("ReadInJoySrtUtils", 1, "handlePositionAndGetSRT parse int error");
      }
      int i = 0;
    }
    return null;
  }
  
  private oidb_cmd0x64e.SRTRule a(ozp paramozp)
  {
    if (paramozp == null) {
      return null;
    }
    oidb_cmd0x64e.SRTRule localSRTRule = new oidb_cmd0x64e.SRTRule();
    if (paramozp.c != null) {
      localSRTRule.bytes_schema.set(ByteStringMicro.copyFromUtf8(paramozp.c));
    }
    if (paramozp.jdField_b_of_type_JavaLangString != null) {
      localSRTRule.bytes_h5.set(ByteStringMicro.copyFromUtf8(paramozp.jdField_b_of_type_JavaLangString));
    }
    if (paramozp.jdField_a_of_type_JavaLangString != null) {
      localSRTRule.bytes_app_package_name.set(ByteStringMicro.copyFromUtf8(paramozp.jdField_a_of_type_JavaLangString));
    }
    if (paramozp.jdField_b_of_type_JavaUtilList != null) {
      localSRTRule.uint32_click_number.set(paramozp.jdField_b_of_type_JavaUtilList);
    }
    if (paramozp.jdField_a_of_type_JavaUtilList != null) {
      localSRTRule.uint32_feeds_type.set(paramozp.jdField_a_of_type_JavaUtilList);
    }
    localSRTRule.uint32_network_type.set(paramozp.jdField_a_of_type_Int);
    return localSRTRule;
  }
  
  private void a(ozp paramozp, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt3 >= this.jdField_a_of_type_JavaUtilList.size())) {}
    do
    {
      return;
      QLog.d("ReadInJoySrtUtils", 1, "convertSRTClickInfo feedsType:" + paramInt1 + " clickTimes: " + paramInt2 + " position" + paramInt3);
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo = new oidb_cmd0x64e.SRTClickInfo();
      paramozp = a(paramozp);
      if (paramozp != null)
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(Integer.valueOf(paramInt2));
        ArrayList localArrayList2 = new ArrayList();
        localArrayList2.add(Integer.valueOf(paramInt1));
        paramozp.uint32_click_number.set(localArrayList1);
        paramozp.uint32_feeds_type.set(localArrayList2);
      }
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.msg_srt_rule_list.set(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.uint32_hit_srt_rule_index.set(paramInt3);
    } while (paramozp == null);
    this.jdField_a_of_type_TencentImOidbCmd0x64eOidb_cmd0x64e$SRTClickInfo.msg_hit_srt_rule.set(paramozp);
  }
  
  private boolean a(ozp paramozp, int paramInt)
  {
    if (paramozp == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((paramozp.jdField_b_of_type_JavaUtilList == null) || (paramozp.jdField_a_of_type_JavaUtilList == null));
      i = paramozp.jdField_a_of_type_Int;
      j = nny.a(BaseActivity.sTopActivity);
    } while ((j == 0) || ((i == 1) && (j != 1)) || ((i == 2) && (j == 1)) || (!paramozp.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))));
    return paramozp.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(this.jdField_a_of_type_Int));
  }
  
  private void b() {}
  
  private void c()
  {
    try
    {
      Object localObject = (String)bnrf.a("readinjoy_srt_click_time_key", "");
      String str1;
      int i;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        String str2 = ((JSONObject)localObject).optString("time", "");
        int j = ((JSONObject)localObject).optInt("clickTimes" + this.jdField_b_of_type_JavaLangString, 0);
        str1 = qur.a();
        i = j;
        if (j == 0) {
          i = this.jdField_a_of_type_Int;
        }
        if (str2.equals(str1)) {
          break label180;
        }
        localObject = new JSONObject();
        i = 0;
      }
      for (;;)
      {
        i += 1;
        this.jdField_a_of_type_Int = i;
        ((JSONObject)localObject).put("time", str1);
        ((JSONObject)localObject).put("clickTimes" + this.jdField_b_of_type_JavaLangString, i);
        bnrf.a("readinjoy_srt_click_time_key", ((JSONObject)localObject).toString());
        return;
        localObject = new JSONObject((String)localObject);
        break;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
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
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("channel_id");
    localAttributeList.att_value.set(paramString);
    localArrayList.add(localAttributeList);
    tzq.a(202, localArrayList);
    QLog.d("ReadInJoySrtUtils", 1, "start requestSRTRulesattris size = " + localArrayList.size() + "event_id = " + 202 + "id: " + paramString);
  }
  
  public void a(List<oidb_cmd0x64e.SRTRule> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ozp localozp = a((oidb_cmd0x64e.SRTRule)localIterator.next());
        if (localozp != null) {
          localArrayList.add(localozp);
        }
      }
      this.jdField_b_of_type_JavaUtilList = localArrayList;
      QLog.d("ReadInJoySrtUtils", 1, "handle0x80aRespInfo  size = " + paramList.size());
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() != 0);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0) || (paramBaseArticleInfo == null) || ((paramBaseArticleInfo.mChannelID != 0L) && (!pbd.c((int)paramBaseArticleInfo.mChannelID)))) {
      QLog.d("ReadInJoySrtUtils", 1, "judgeIsNeedNoDifferenceDiversion srtInfos is null");
    }
    label255:
    for (;;)
    {
      return false;
      c();
      int i = 0;
      for (;;)
      {
        if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
          break label255;
        }
        ozp localozp = (ozp)this.jdField_b_of_type_JavaUtilList.get(i);
        int j = ozs.a(paramBaseArticleInfo);
        QLog.d("ReadInJoySrtUtils", 1, "startJudge feedsType:" + j + " clickTimes: " + this.jdField_a_of_type_Int + " position" + i);
        if (a(localozp, j))
        {
          paramBaseArticleInfo = a(localozp, paramBaseArticleInfo, paramTemplateBean, paramViewBase);
          if (TextUtils.isEmpty(paramBaseArticleInfo)) {
            break;
          }
          this.jdField_a_of_type_JavaLangString = paramBaseArticleInfo;
          a(localozp, j, this.jdField_a_of_type_Int, i);
          QLog.d("ReadInJoySrtUtils", 1, "hitSrtRules feedsType:" + j + " clickTimes: " + this.jdField_a_of_type_Int + " position" + i);
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozo
 * JD-Core Version:    0.7.0.1
 */