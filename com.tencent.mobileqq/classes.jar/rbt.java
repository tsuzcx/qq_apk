import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BackOffGroupInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqChannelPara;

public class rbt
  implements rbq
{
  private static int jdField_a_of_type_Int;
  public static String a;
  private static int b;
  public static String b;
  public static String c = "readinjoy_sp_remain_times_one_day";
  private Map<String, rbv> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "readinjoy_sp_update_one_day";
    jdField_b_of_type_JavaLangString = "readinjoy_sp_clcik_times_one_day";
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!c(paramBaseArticleInfo)) {}
    while (!paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.uint32_jump_src.has()) {
      return 1;
    }
    return paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.uint32_jump_src.get();
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (!c(paramBaseArticleInfo)) {
      return 0;
    }
    if (!paramBoolean) {
      return 2;
    }
    return jdField_a_of_type_Int;
  }
  
  private int a(rbv paramrbv, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = (String)bkwm.a(jdField_b_of_type_JavaLangString, "");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return paramrbv.c;
      }
      localObject = new JSONObject((String)localObject);
      String str = ((JSONObject)localObject).optString("time", "");
      int j = ((JSONObject)localObject).optInt("clickTimes" + paramString2 + paramString1, 0);
      if (!str.equals(rbp.a())) {
        return paramrbv.c;
      }
      int i = j;
      if (j == 0) {
        i = paramrbv.c;
      }
      QLog.d("UGRuleManager", 1, "getChannelClickTimes :" + i);
      return i;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramrbv.c;
  }
  
  public static long a(int paramInt)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      try
      {
        if (pcl.b(paramInt))
        {
          Object localObject = pbm.a(String.valueOf(paramInt));
          if (localObject == null) {
            break label232;
          }
          l1 = ((pbm)localObject).a(false);
          localObject = (String)bkwm.a(c, "");
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            QLog.d("UGRuleManager", 1, "getNowRemainTime time is" + l1 / 1000L);
            return l1 / 1000L;
          }
          localObject = new JSONObject((String)localObject);
          String str = ((JSONObject)localObject).optString("time", "");
          long l2 = ((JSONObject)localObject).optLong("remainTime" + paramInt, 0L);
          if (!str.equals(rbp.a()))
          {
            QLog.d("UGRuleManager", 1, "getNowRemainTime time is" + l1 / 1000L);
            return l1 / 1000L;
          }
          QLog.d("UGRuleManager", 1, "getNowRemainTime time is" + (l1 + l2) / 1000L);
          l1 = (l1 + l2) / 1000L;
          return l1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return 0L;
      label232:
      long l1 = 0L;
    }
  }
  
  private BaseArticleInfo a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.viewRowkey != null) && (!paramBaseArticleInfo.viewRowkey.equals(paramBaseArticleInfo.innerUniqueID)) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mSubArtilceList.get(0) != null) && (paramBaseArticleInfo.viewRowkey.equals(((ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0)).innerUniqueID))) {
      return (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    }
    return paramBaseArticleInfo;
  }
  
  private String a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = paramBaseArticleInfo.innerUniqueID;
    if (paramBaseArticleInfo.viewRowkey != null) {
      str = paramBaseArticleInfo.viewRowkey;
    }
    return str;
  }
  
  public static List<String> a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!c(paramBaseArticleInfo)) {
      return null;
    }
    if ((!paramBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.has()) || (paramBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.get() == null))
    {
      QLog.d("UGRuleManager", 1, "getReportUrl is null");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramBaseArticleInfo = paramBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.get().iterator();
    while (paramBaseArticleInfo.hasNext())
    {
      ByteStringMicro localByteStringMicro = (ByteStringMicro)paramBaseArticleInfo.next();
      localArrayList.add(localByteStringMicro.toStringUtf8());
      QLog.d("UGRuleManager", 1, "getReportUrl is " + localByteStringMicro.toStringUtf8());
    }
    return localArrayList;
  }
  
  private rbv a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    String str;
    do
    {
      return null;
      str = b(paramBaseArticleInfo);
    } while (TextUtils.isEmpty(str));
    return a(str, String.valueOf(paramBaseArticleInfo.mChannelID));
  }
  
  private rbv a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      str = paramString2 + "_" + paramString1;
      paramString2 = (rbv)this.jdField_a_of_type_JavaUtilMap.get(str);
      paramString1 = paramString2;
    } while (paramString2 != null);
    paramString1 = new rbv(this);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramString1);
    return paramString1;
  }
  
  private rbv a(oidb_cmd0x68b.BackOffGroupInfo paramBackOffGroupInfo, String paramString1, String paramString2)
  {
    int j = 0;
    paramString1 = a(paramString2, paramString1);
    if (paramString1 == null) {
      return null;
    }
    paramString1.jdField_a_of_type_JavaLangString = paramBackOffGroupInfo.bytes_back_off_group.get().toStringUtf8();
    if (paramBackOffGroupInfo.uint32_max_evoke_count.has()) {}
    for (int i = paramBackOffGroupInfo.uint32_max_evoke_count.get();; i = 0)
    {
      paramString1.jdField_a_of_type_Int = i;
      i = j;
      if (paramBackOffGroupInfo.uint32_max_fresh_evoke_count.has()) {
        i = paramBackOffGroupInfo.uint32_max_fresh_evoke_count.get();
      }
      paramString1.jdField_b_of_type_Int = i;
      QLog.d("UGRuleManager", 1, "handleBackOffGroup id: " + paramString1.jdField_a_of_type_JavaLangString + ", maxEvokeCnt : " + paramString1.jdField_a_of_type_Int + ", maxFreshEvokeCnt : " + paramString1.jdField_b_of_type_Int);
      return paramString1;
    }
  }
  
  public static void a()
  {
    b(jdField_b_of_type_Int);
  }
  
  public static void a(int paramInt)
  {
    if (jdField_b_of_type_Int != paramInt)
    {
      QLog.d("UGRuleManager", 1, "wakeUpTimeCalculate change channel channel id is " + paramInt);
      b(jdField_b_of_type_Int);
    }
    if ((paramInt == 0) || (pcl.b(paramInt)))
    {
      jdField_b_of_type_Int = paramInt;
      pbm localpbm2 = pbm.a(String.valueOf(paramInt));
      pbm localpbm1 = localpbm2;
      if (localpbm2 == null)
      {
        localpbm1 = new pbm();
        pbm.a(String.valueOf(paramInt), localpbm1);
      }
      QLog.d("UGRuleManager", 1, "wakeUpTimeCalculate channel id is " + paramInt);
      localpbm1.a();
    }
  }
  
  private void a(List<ArticleInfo> paramList, rbv paramrbv, rbx paramrbx)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      if (paramrbv.jdField_a_of_type_JavaLangString.equals(c(localArticleInfo))) {
        paramrbx.jdField_a_of_type_JavaUtilHashMap.put(localArticleInfo.innerUniqueID, new rbu(this, localArticleInfo.innerUniqueID));
      }
      if ((localArticleInfo.mSubArtilceList != null) && (localArticleInfo.mSubArtilceList.size() > 0)) {
        a(localArticleInfo.mSubArtilceList, paramrbv, paramrbx);
      }
    }
  }
  
  private void a(rbv paramrbv, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = (String)bkwm.a(jdField_b_of_type_JavaLangString, "");
      QLog.d("UGRuleManager", 1, "start saveChannelClickToSP :" + (String)localObject);
      String str1;
      int i;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        String str2 = ((JSONObject)localObject).optString("time", "");
        int j = ((JSONObject)localObject).optInt("clickTimes" + paramString2 + paramString1, 0);
        str1 = rbp.a();
        i = j;
        if (j == 0) {
          i = paramrbv.c;
        }
        if (str2.equals(str1)) {
          break label256;
        }
        localObject = new JSONObject();
        i = 0;
      }
      for (;;)
      {
        i += 1;
        paramrbv.c = i;
        ((JSONObject)localObject).put("time", str1);
        ((JSONObject)localObject).put("clickTimes" + paramString2 + paramString1, i);
        QLog.d("UGRuleManager", 1, "end saveChannelClickToSP :" + ((JSONObject)localObject).toString());
        bkwm.a(jdField_b_of_type_JavaLangString, ((JSONObject)localObject).toString());
        return;
        localObject = new JSONObject((String)localObject);
        break;
      }
    }
    catch (JSONException paramrbv)
    {
      paramrbv.printStackTrace();
      return;
    }
  }
  
  private void a(rbw paramrbw)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramrbw.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = paramrbw.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (oidb_cmd0x68b.BackOffGroupInfo)localIterator.next();
        String str = qlg.a(((oidb_cmd0x68b.BackOffGroupInfo)localObject).bytes_back_off_group);
        if (!TextUtils.isEmpty(str))
        {
          localObject = a((oidb_cmd0x68b.BackOffGroupInfo)localObject, String.valueOf(paramrbw.jdField_a_of_type_Int), str);
          if ((localObject != null) && (paramrbw.b != null) && (!localArrayList.contains(str)))
          {
            rbx localrbx = new rbx(this);
            a(paramrbw.b, (rbv)localObject, localrbx);
            ((rbv)localObject).a(localrbx);
            localArrayList.add(str);
          }
        }
      }
    }
  }
  
  public static void a(oidb_cmd0x68b.ReqChannelPara paramReqChannelPara, String paramString)
  {
    try
    {
      Object localObject = (String)bkwm.a(jdField_a_of_type_JavaLangString, "");
      QLog.d("UGRuleManager", 1, "start addFreshTimesToUGAndSaveToSp : " + (String)localObject);
      int i;
      String str1;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        String str2 = ((JSONObject)localObject).optString("time", "");
        i = ((JSONObject)localObject).optInt("freshTimes" + paramString, 0);
        str1 = rbp.a();
        if (str2.equals(str1)) {
          break label219;
        }
        localObject = new JSONObject();
        i = 0;
      }
      for (;;)
      {
        i += 1;
        ((JSONObject)localObject).put("time", str1);
        ((JSONObject)localObject).put("freshTimes" + paramString, i);
        QLog.d("UGRuleManager", 1, "end addFreshTimesToUGAndSaveToSp : " + ((JSONObject)localObject).toString());
        bkwm.a(jdField_a_of_type_JavaLangString, ((JSONObject)localObject).toString());
        paramReqChannelPara.uint32_update_times_one_day.set(i);
        return;
        localObject = new JSONObject((String)localObject);
        break;
      }
    }
    catch (JSONException paramReqChannelPara)
    {
      paramReqChannelPara.printStackTrace();
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) || (paramString.startsWith("http://clientui.3g.qq.com/mqq/")) || (paramString.startsWith("http://qm.qq.com/cgi-bin/")) || (paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {}
    for (int i = 1;; i = 0) {
      return (i == 0) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://")));
    }
  }
  
  private String b(BaseArticleInfo paramBaseArticleInfo)
  {
    return qlg.a(paramBaseArticleInfo.weishiUGInfo.bytes_back_off_group, "");
  }
  
  public static void b(int paramInt)
  {
    if ((paramInt == 0) || (pcl.b(paramInt)))
    {
      pbm localpbm = pbm.a(String.valueOf(paramInt));
      if ((localpbm != null) && (localpbm.a()))
      {
        c(paramInt);
        localpbm.b();
        localpbm.c();
        QLog.d("UGRuleManager", 1, "stopTimeCalculate channel id is " + paramInt);
      }
    }
  }
  
  private String c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!c(paramBaseArticleInfo)) {}
    while (!paramBaseArticleInfo.weishiUGInfo.bytes_back_off_group.has()) {
      return null;
    }
    return paramBaseArticleInfo.weishiUGInfo.bytes_back_off_group.get().toStringUtf8();
  }
  
  private static void c(int paramInt)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      try
      {
        if (!pcl.b(paramInt)) {
          break;
        }
        Object localObject = pbm.a(String.valueOf(paramInt));
        if (localObject != null)
        {
          l1 = ((pbm)localObject).a(false);
          localObject = (String)bkwm.a(c, "");
          QLog.d("UGRuleManager", 1, "start saveRemainTimeToSP string is " + (String)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject();
            long l2 = ((JSONObject)localObject).optLong("remainTime" + paramInt, 0L);
            String str2 = ((JSONObject)localObject).optString("time", "");
            String str1 = rbp.a();
            if (!str2.equals(str1))
            {
              localObject = new JSONObject();
              l2 = 0L;
              ((JSONObject)localObject).put("time", str1);
              ((JSONObject)localObject).put("remainTime" + paramInt, l2 + l1);
              QLog.d("UGRuleManager", 1, "end saveRemainTimeToSP string is " + ((JSONObject)localObject).toString());
              bkwm.a(c, ((JSONObject)localObject).toString());
            }
          }
          else
          {
            localObject = new JSONObject((String)localObject);
            continue;
          }
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      long l1 = 0L;
    }
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (d(paramBaseArticleInfo)) {}
    while ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.weishiUGInfo != null) && (paramBaseArticleInfo.weishiUGInfo.uint32_use_ug.has()) && (paramBaseArticleInfo.weishiUGInfo.uint32_use_ug.get() > 0) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.has()) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.get() != null)) {
      return true;
    }
    return false;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.weishiUGInfo != null) && (paramBaseArticleInfo.weishiUGInfo.uint32_is_with_angle_sign.has()) && (paramBaseArticleInfo.weishiUGInfo.uint32_is_with_angle_sign.get() > 0) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.has()) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.get() != null);
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!c(paramBaseArticleInfo))
    {
      QLog.d("UGRuleManager", 1, "judgeIsAgreement is not isUgCard");
      return false;
    }
    int i = paramBaseArticleInfo.weishiUGInfo.uint32_use_ug.get();
    paramBaseArticleInfo = paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info;
    if (paramBaseArticleInfo.bytes_jump_bundle.has())
    {
      paramBaseArticleInfo = paramBaseArticleInfo.bytes_jump_bundle.get().toStringUtf8();
      bool = bfwv.a(BaseApplicationImpl.getApplication(), paramBaseArticleInfo);
      QLog.d("UGRuleManager", 1, "judgeIsAgreement isappInstall " + paramBaseArticleInfo + " :" + bool + " useUg: " + i);
      if (((!bool) || (i != 2)) && ((bool) || (i != 1))) {
        break label140;
      }
    }
    label140:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      paramBaseArticleInfo = "";
      break;
    }
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if (!c(paramBaseArticleInfo)) {
      return null;
    }
    paramViewBase = a(paramBaseArticleInfo);
    paramTemplateBean = paramViewBase.weishiUGInfo.msg_url_jump_info;
    if (paramTemplateBean.bytes_jump_schema.has())
    {
      paramBaseArticleInfo = paramTemplateBean.bytes_jump_schema.get().toStringUtf8();
      if (!paramTemplateBean.bytes_jump_url.has()) {
        break label143;
      }
      paramTemplateBean = paramTemplateBean.bytes_jump_url.get().toStringUtf8();
      label65:
      if (!paramViewBase.weishiUGInfo.msg_url_jump_info.uint32_jump_type.has()) {
        break label149;
      }
    }
    int j;
    label143:
    label149:
    for (int i = paramViewBase.weishiUGInfo.msg_url_jump_info.uint32_jump_type.get();; i = 0)
    {
      j = paramViewBase.weishiUGInfo.uint32_use_ug.get();
      if ((!TextUtils.isEmpty(paramBaseArticleInfo)) || (!TextUtils.isEmpty(paramTemplateBean))) {
        break label155;
      }
      QLog.d("UGRuleManager", 1, "getJumpUrl schema & h5 is null");
      jdField_a_of_type_Int = 3;
      return null;
      paramBaseArticleInfo = "";
      break;
      paramTemplateBean = "";
      break label65;
    }
    label155:
    if (!e(paramViewBase))
    {
      if ((j == 2) && (i == 2) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        QLog.d("UGRuleManager", 1, "getJumpUrl return is h5:" + paramTemplateBean);
        jdField_a_of_type_Int = 108;
        return paramTemplateBean;
      }
      QLog.d("UGRuleManager", 1, "getJumpUrl judgeIsAgreement is false");
      jdField_a_of_type_Int = 109;
      return null;
    }
    if (j == 1)
    {
      if ((i == 1) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        QLog.d("UGRuleManager", 1, "getJumpUrl return is h5:" + paramTemplateBean);
        jdField_a_of_type_Int = 108;
        return paramTemplateBean;
      }
    }
    else if (j == 2)
    {
      if ((i == 2) && (!TextUtils.isEmpty(paramBaseArticleInfo)))
      {
        QLog.d("UGRuleManager", 1, "getJumpUrl return is schema:" + paramBaseArticleInfo);
        jdField_a_of_type_Int = 7;
        return paramBaseArticleInfo;
      }
      if ((i == 1) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        QLog.d("UGRuleManager", 1, "getJumpUrl return is h5:" + paramTemplateBean);
        jdField_a_of_type_Int = 108;
        return paramTemplateBean;
      }
    }
    jdField_a_of_type_Int = 3;
    QLog.d("UGRuleManager", 1, "getJumpUrl return is null");
    return null;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = a(paramBaseArticleInfo, paramBoolean2);
    if (j != 0)
    {
      int i = j;
      if (!paramBoolean1)
      {
        i = j;
        if (j != 110) {
          i = 3;
        }
      }
      QLog.d("UGRuleManager", 1, "UGRuleManager getUGSchema action is:" + i);
      ues.a(paramBaseArticleInfo, i);
    }
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof rbw)) {
      return;
    }
    QLog.d("UGRuleManager", 1, "handleRules");
    a((rbw)paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject1 = a(paramBaseArticleInfo);
    if (localObject1 == null) {
      return false;
    }
    paramBaseArticleInfo = a(paramBaseArticleInfo);
    localObject1 = ((rbv)localObject1).jdField_a_of_type_JavaUtilDeque.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (rbx)((Iterator)localObject1).next();
      if (((rbx)localObject2).jdField_a_of_type_JavaUtilHashMap.containsKey(paramBaseArticleInfo))
      {
        localObject2 = (rbu)((rbx)localObject2).jdField_a_of_type_JavaUtilHashMap.get(paramBaseArticleInfo);
        if ((localObject2 != null) && (((rbu)localObject2).jdField_a_of_type_Int != 0))
        {
          ((rbu)localObject2).jdField_a_of_type_Int -= 1;
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (d(paramBaseArticleInfo))
    {
      QLog.d("UGRuleManager", 1, "judgeHitRule isWithAngleSign");
      return true;
    }
    if (!c(paramBaseArticleInfo))
    {
      QLog.d("UGRuleManager", 1, "judgeHitRule isNotUgCard");
      return false;
    }
    if (!paramBoolean) {
      return a(paramBaseArticleInfo);
    }
    return b(paramBaseArticleInfo);
  }
  
  public boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    rbv localrbv = a(paramBaseArticleInfo);
    if (localrbv == null) {
      return false;
    }
    Object localObject = a(paramBaseArticleInfo);
    String str = b(paramBaseArticleInfo);
    if (qlg.a(paramBaseArticleInfo.weishiUGInfo.uint32_residence_threshold, 0) > a((int)paramBaseArticleInfo.mChannelID))
    {
      QLog.d("UGRuleManager", 1, "judgeHitRule is not reach minTime");
      jdField_a_of_type_Int = 110;
      return false;
    }
    localrbv.c = a(localrbv, str, String.valueOf(paramBaseArticleInfo.mChannelID));
    QLog.d("UGRuleManager", 1, "judgeHitRule backOffGroup.clickTime is " + localrbv.c + " backOffGroup.maxEvokeCount is " + localrbv.jdField_a_of_type_Int + " groupid is " + localrbv.jdField_a_of_type_JavaLangString);
    if (localrbv.c >= localrbv.jdField_a_of_type_Int)
    {
      QLog.d("UGRuleManager", 1, "judgeHitRule over groupClick");
      return false;
    }
    Iterator localIterator = localrbv.jdField_a_of_type_JavaUtilDeque.iterator();
    while (localIterator.hasNext())
    {
      rbx localrbx = (rbx)localIterator.next();
      if (localrbx.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject))
      {
        QLog.d("UGRuleManager", 1, "judgeHitRule freshInfo.clickTime is " + localrbx.jdField_a_of_type_Int + " backOffGroup.maxFreshEvokeCount is " + localrbv.jdField_b_of_type_Int);
        if (localrbx.jdField_a_of_type_Int < localrbv.jdField_b_of_type_Int)
        {
          if (!TextUtils.isEmpty(a(paramBaseArticleInfo, null, null)))
          {
            localObject = (rbu)localrbx.jdField_a_of_type_JavaUtilHashMap.get(paramBaseArticleInfo.innerUniqueID);
            if (localObject != null) {
              ((rbu)localObject).jdField_a_of_type_Int += 1;
            }
            localrbx.jdField_a_of_type_Int += 1;
            a(localrbv, str, String.valueOf(paramBaseArticleInfo.mChannelID));
          }
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rbt
 * JD-Core Version:    0.7.0.1
 */