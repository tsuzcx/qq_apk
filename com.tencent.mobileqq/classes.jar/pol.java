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

public class pol
  implements poj
{
  public static String a;
  public static String b;
  public static String c;
  private static String jdField_d_of_type_JavaLangString = "UGRuleManager";
  private static int f;
  private static int g;
  private final int jdField_a_of_type_Int = 3;
  private Map<String, pom> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final int b;
  private final int c;
  private final int jdField_d_of_type_Int = 109;
  private final int e = 110;
  
  static
  {
    jdField_a_of_type_JavaLangString = "readinjoy_sp_update_one_day";
    jdField_b_of_type_JavaLangString = "readinjoy_sp_clcik_times_one_day";
    jdField_c_of_type_JavaLangString = "readinjoy_sp_remain_times_one_day";
  }
  
  public pol()
  {
    this.jdField_b_of_type_Int = 108;
    this.jdField_c_of_type_Int = 7;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!a(paramBaseArticleInfo)) {}
    while (!paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.uint32_jump_src.has()) {
      return 1;
    }
    return paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.uint32_jump_src.get();
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (!a(paramBaseArticleInfo)) {
      return 0;
    }
    if (!paramBoolean) {
      return 2;
    }
    return f;
  }
  
  private int a(pom parampom, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = (String)bgmq.a(jdField_b_of_type_JavaLangString, "");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return parampom.jdField_c_of_type_Int;
      }
      localObject = new JSONObject((String)localObject);
      String str = ((JSONObject)localObject).optString("time", "");
      int j = ((JSONObject)localObject).optInt("clickTimes" + paramString2 + paramString1, 0);
      if (!str.equals(poi.a())) {
        return parampom.jdField_c_of_type_Int;
      }
      int i = j;
      if (j == 0) {
        i = parampom.jdField_c_of_type_Int;
      }
      QLog.d(jdField_d_of_type_JavaLangString, 1, "getChannelClickTimes :" + i);
      return i;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return parampom.jdField_c_of_type_Int;
  }
  
  public static long a(int paramInt)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      try
      {
        if (odm.b(paramInt))
        {
          Object localObject = ocr.a(String.valueOf(paramInt));
          if (localObject == null) {
            break label235;
          }
          l1 = ((ocr)localObject).a(false);
          localObject = (String)bgmq.a(jdField_c_of_type_JavaLangString, "");
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            QLog.d(jdField_d_of_type_JavaLangString, 1, "getNowRemainTime time is" + l1 / 1000L);
            return l1 / 1000L;
          }
          localObject = new JSONObject((String)localObject);
          String str = ((JSONObject)localObject).optString("time", "");
          long l2 = ((JSONObject)localObject).optLong("remainTime" + paramInt, 0L);
          if (!str.equals(poi.a()))
          {
            QLog.d(jdField_d_of_type_JavaLangString, 1, "getNowRemainTime time is" + l1 / 1000L);
            return l1 / 1000L;
          }
          QLog.d(jdField_d_of_type_JavaLangString, 1, "getNowRemainTime time is" + (l1 + l2) / 1000L);
          l1 = (l1 + l2) / 1000L;
          return l1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return 0L;
      label235:
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
    if (!a(paramBaseArticleInfo)) {}
    while (!paramBaseArticleInfo.weishiUGInfo.bytes_back_off_group.has()) {
      return null;
    }
    return paramBaseArticleInfo.weishiUGInfo.bytes_back_off_group.get().toStringUtf8();
  }
  
  public static List<String> a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!a(paramBaseArticleInfo)) {
      return null;
    }
    if ((!paramBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.has()) || (paramBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.get() == null))
    {
      QLog.d(jdField_d_of_type_JavaLangString, 1, "getReportUrl is null");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramBaseArticleInfo = paramBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.get().iterator();
    while (paramBaseArticleInfo.hasNext())
    {
      ByteStringMicro localByteStringMicro = (ByteStringMicro)paramBaseArticleInfo.next();
      localArrayList.add(localByteStringMicro.toStringUtf8());
      QLog.d(jdField_d_of_type_JavaLangString, 1, "getReportUrl is " + localByteStringMicro.toStringUtf8());
    }
    return localArrayList;
  }
  
  private pom a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      str = paramString2 + paramString1;
      paramString2 = (pom)this.jdField_a_of_type_JavaUtilMap.get(str);
      paramString1 = paramString2;
    } while (paramString2 != null);
    paramString1 = new pom(this);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramString1);
    return paramString1;
  }
  
  public static void a()
  {
    b(g);
  }
  
  public static void a(int paramInt)
  {
    if (g != paramInt)
    {
      QLog.d(jdField_d_of_type_JavaLangString, 1, "wakeUpTimeCalculate change channel channel id is " + paramInt);
      b(g);
    }
    if ((paramInt == 0) || (odm.b(paramInt)))
    {
      g = paramInt;
      ocr localocr2 = ocr.a(String.valueOf(paramInt));
      ocr localocr1 = localocr2;
      if (localocr2 == null)
      {
        localocr1 = new ocr();
        ocr.a(String.valueOf(paramInt), localocr1);
      }
      QLog.d(jdField_d_of_type_JavaLangString, 1, "wakeUpTimeCalculate channel id is " + paramInt);
      localocr1.a();
    }
  }
  
  private void a(List<ArticleInfo> paramList, pom parampom, poo parampoo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      if (parampom.jdField_a_of_type_JavaLangString.equals(a(localArticleInfo))) {
        parampoo.jdField_a_of_type_JavaUtilList.add(localArticleInfo.innerUniqueID);
      }
      if ((localArticleInfo.mSubArtilceList != null) && (localArticleInfo.mSubArtilceList.size() > 0)) {
        a(localArticleInfo.mSubArtilceList, parampom, parampoo);
      }
    }
  }
  
  private void a(pom parampom, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = (String)bgmq.a(jdField_b_of_type_JavaLangString, "");
      QLog.d(jdField_d_of_type_JavaLangString, 1, "start saveChannelClickToSP :" + (String)localObject);
      String str1;
      int i;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        String str2 = ((JSONObject)localObject).optString("time", "");
        int j = ((JSONObject)localObject).optInt("clickTimes" + paramString2 + paramString1, 0);
        str1 = poi.a();
        i = j;
        if (j == 0) {
          i = parampom.jdField_c_of_type_Int;
        }
        if (str2.equals(str1)) {
          break label258;
        }
        localObject = new JSONObject();
        i = 0;
      }
      for (;;)
      {
        i += 1;
        parampom.jdField_c_of_type_Int = i;
        ((JSONObject)localObject).put("time", str1);
        ((JSONObject)localObject).put("clickTimes" + paramString2 + paramString1, i);
        QLog.d(jdField_d_of_type_JavaLangString, 1, "end saveChannelClickToSP :" + ((JSONObject)localObject).toString());
        bgmq.a(jdField_b_of_type_JavaLangString, ((JSONObject)localObject).toString());
        return;
        localObject = new JSONObject((String)localObject);
        break;
      }
    }
    catch (JSONException parampom)
    {
      parampom.printStackTrace();
      return;
    }
  }
  
  private void a(pon parampon)
  {
    if ((parampon != null) && (parampon.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = parampon.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        oidb_cmd0x68b.BackOffGroupInfo localBackOffGroupInfo = (oidb_cmd0x68b.BackOffGroupInfo)localIterator.next();
        if ((localBackOffGroupInfo.bytes_back_off_group.has()) || (localBackOffGroupInfo.bytes_back_off_group.get() == null)) {
          a(localBackOffGroupInfo, parampon.b);
        }
      }
    }
  }
  
  private void a(oidb_cmd0x68b.BackOffGroupInfo paramBackOffGroupInfo, List<ArticleInfo> paramList)
  {
    int j = 0;
    if ((paramList == null) || (paramList.size() == 0)) {}
    pom localpom;
    do
    {
      return;
      long l = ((ArticleInfo)paramList.get(0)).mChannelID;
      localpom = a(paramBackOffGroupInfo.bytes_back_off_group.get().toStringUtf8(), String.valueOf(l));
    } while (localpom == null);
    localpom.jdField_a_of_type_JavaLangString = paramBackOffGroupInfo.bytes_back_off_group.get().toStringUtf8();
    if (paramBackOffGroupInfo.uint32_max_evoke_count.has()) {}
    for (int i = paramBackOffGroupInfo.uint32_max_evoke_count.get();; i = 0)
    {
      localpom.jdField_a_of_type_Int = i;
      i = j;
      if (paramBackOffGroupInfo.uint32_max_fresh_evoke_count.has()) {
        i = paramBackOffGroupInfo.uint32_max_fresh_evoke_count.get();
      }
      localpom.jdField_b_of_type_Int = i;
      paramBackOffGroupInfo = new poo(this);
      a(paramList, localpom, paramBackOffGroupInfo);
      localpom.a(paramBackOffGroupInfo);
      return;
    }
  }
  
  public static void a(oidb_cmd0x68b.ReqChannelPara paramReqChannelPara, String paramString)
  {
    try
    {
      Object localObject = (String)bgmq.a(jdField_a_of_type_JavaLangString, "");
      QLog.d(jdField_d_of_type_JavaLangString, 1, "start addFreshTimesToUGAndSaveToSp : " + (String)localObject);
      int i;
      String str1;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        String str2 = ((JSONObject)localObject).optString("time", "");
        i = ((JSONObject)localObject).optInt("freshTimes" + paramString, 0);
        str1 = poi.a();
        if (str2.equals(str1)) {
          break label221;
        }
        localObject = new JSONObject();
        i = 0;
      }
      for (;;)
      {
        i += 1;
        ((JSONObject)localObject).put("time", str1);
        ((JSONObject)localObject).put("freshTimes" + paramString, i);
        QLog.d(jdField_d_of_type_JavaLangString, 1, "end addFreshTimesToUGAndSaveToSp : " + ((JSONObject)localObject).toString());
        bgmq.a(jdField_a_of_type_JavaLangString, ((JSONObject)localObject).toString());
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
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (b(paramBaseArticleInfo)) {}
    while ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.weishiUGInfo != null) && (paramBaseArticleInfo.weishiUGInfo.uint32_use_ug.has()) && (paramBaseArticleInfo.weishiUGInfo.uint32_use_ug.get() > 0) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.has()) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.get() != null)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) || (paramString.startsWith("http://clientui.3g.qq.com/mqq/")) || (paramString.startsWith("http://qm.qq.com/cgi-bin/")) || (paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {}
    for (int i = 1;; i = 0) {
      return (i == 0) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://")));
    }
  }
  
  public static void b(int paramInt)
  {
    if ((paramInt == 0) || (odm.b(paramInt)))
    {
      ocr localocr = ocr.a(String.valueOf(paramInt));
      if ((localocr != null) && (localocr.a()))
      {
        c(paramInt);
        localocr.b();
        localocr.c();
        QLog.d(jdField_d_of_type_JavaLangString, 1, "stopTimeCalculate channel id is " + paramInt);
      }
    }
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.weishiUGInfo != null) && (paramBaseArticleInfo.weishiUGInfo.uint32_is_with_angle_sign.has()) && (paramBaseArticleInfo.weishiUGInfo.uint32_is_with_angle_sign.get() > 0) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.has()) && (paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info.get() != null);
  }
  
  private static void c(int paramInt)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      try
      {
        if (!odm.b(paramInt)) {
          break;
        }
        Object localObject = ocr.a(String.valueOf(paramInt));
        if (localObject != null)
        {
          l1 = ((ocr)localObject).a(false);
          localObject = (String)bgmq.a(jdField_c_of_type_JavaLangString, "");
          QLog.d(jdField_d_of_type_JavaLangString, 1, "start saveRemainTimeToSP string is " + (String)localObject);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject();
            long l2 = ((JSONObject)localObject).optLong("remainTime" + paramInt, 0L);
            String str2 = ((JSONObject)localObject).optString("time", "");
            String str1 = poi.a();
            if (!str2.equals(str1))
            {
              localObject = new JSONObject();
              l2 = 0L;
              ((JSONObject)localObject).put("time", str1);
              ((JSONObject)localObject).put("remainTime" + paramInt, l2 + l1);
              QLog.d(jdField_d_of_type_JavaLangString, 1, "end saveRemainTimeToSP string is " + ((JSONObject)localObject).toString());
              bgmq.a(jdField_c_of_type_JavaLangString, ((JSONObject)localObject).toString());
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
    if (!a(paramBaseArticleInfo))
    {
      QLog.d(jdField_d_of_type_JavaLangString, 1, "judgeIsAgreement is not isUgCard");
      return false;
    }
    int i = paramBaseArticleInfo.weishiUGInfo.uint32_use_ug.get();
    paramBaseArticleInfo = paramBaseArticleInfo.weishiUGInfo.msg_url_jump_info;
    if (paramBaseArticleInfo.bytes_jump_bundle.has())
    {
      paramBaseArticleInfo = paramBaseArticleInfo.bytes_jump_bundle.get().toStringUtf8();
      bool = bady.a(BaseApplicationImpl.getApplication(), paramBaseArticleInfo);
      QLog.d(jdField_d_of_type_JavaLangString, 1, "judgeIsAgreement isappInstall " + paramBaseArticleInfo + " :" + bool + " useUg: " + i);
      if (((!bool) || (i != 2)) && ((bool) || (i != 1))) {
        break label142;
      }
    }
    label142:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      paramBaseArticleInfo = "";
      break;
    }
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if (!a(paramBaseArticleInfo)) {
      return null;
    }
    paramViewBase = a(paramBaseArticleInfo);
    paramTemplateBean = paramViewBase.weishiUGInfo.msg_url_jump_info;
    if (paramTemplateBean.bytes_jump_schema.has())
    {
      paramBaseArticleInfo = paramTemplateBean.bytes_jump_schema.get().toStringUtf8();
      if (!paramTemplateBean.bytes_jump_url.has()) {
        break label144;
      }
      paramTemplateBean = paramTemplateBean.bytes_jump_url.get().toStringUtf8();
      label65:
      if (!paramViewBase.weishiUGInfo.msg_url_jump_info.uint32_jump_type.has()) {
        break label150;
      }
    }
    int j;
    label144:
    label150:
    for (int i = paramViewBase.weishiUGInfo.msg_url_jump_info.uint32_jump_type.get();; i = 0)
    {
      j = paramViewBase.weishiUGInfo.uint32_use_ug.get();
      if ((!TextUtils.isEmpty(paramBaseArticleInfo)) || (!TextUtils.isEmpty(paramTemplateBean))) {
        break label156;
      }
      QLog.d(jdField_d_of_type_JavaLangString, 1, "getJumpUrl schema & h5 is null");
      f = 3;
      return null;
      paramBaseArticleInfo = "";
      break;
      paramTemplateBean = "";
      break label65;
    }
    label156:
    if (!c(paramViewBase))
    {
      if ((j == 2) && (i == 2) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        QLog.d(jdField_d_of_type_JavaLangString, 1, "getJumpUrl return is h5:" + paramTemplateBean);
        f = 108;
        return paramTemplateBean;
      }
      QLog.d(jdField_d_of_type_JavaLangString, 1, "getJumpUrl judgeIsAgreement is false");
      f = 109;
      return null;
    }
    if (j == 1)
    {
      if ((i == 1) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        QLog.d(jdField_d_of_type_JavaLangString, 1, "getJumpUrl return is h5:" + paramTemplateBean);
        f = 108;
        return paramTemplateBean;
      }
    }
    else if (j == 2)
    {
      if ((i == 2) && (!TextUtils.isEmpty(paramBaseArticleInfo)))
      {
        QLog.d(jdField_d_of_type_JavaLangString, 1, "getJumpUrl return is schema:" + paramBaseArticleInfo);
        f = 7;
        return paramBaseArticleInfo;
      }
      if ((i == 1) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        QLog.d(jdField_d_of_type_JavaLangString, 1, "getJumpUrl return is h5:" + paramTemplateBean);
        f = 108;
        return paramTemplateBean;
      }
    }
    f = 3;
    QLog.d(jdField_d_of_type_JavaLangString, 1, "getJumpUrl return is null");
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
      QLog.d(jdField_d_of_type_JavaLangString, 1, "UGRuleManager getUGSchema action is:" + i);
      rsk.a(paramBaseArticleInfo, i);
    }
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof pon)) {
      return;
    }
    QLog.d(jdField_d_of_type_JavaLangString, 1, "handleRules");
    a((pon)paramObject);
  }
  
  public boolean a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (b(paramBaseArticleInfo))
    {
      QLog.d(jdField_d_of_type_JavaLangString, 1, "judgeHitRule isWithAngleSign");
      bool1 = true;
      return bool1;
    }
    if (!a(paramBaseArticleInfo))
    {
      QLog.d(jdField_d_of_type_JavaLangString, 1, "judgeHitRule isNotUgCard");
      return false;
    }
    String str2 = paramBaseArticleInfo.weishiUGInfo.bytes_back_off_group.get().toStringUtf8();
    String str1 = paramBaseArticleInfo.innerUniqueID;
    if (paramBaseArticleInfo.viewRowkey != null) {
      str1 = paramBaseArticleInfo.viewRowkey;
    }
    for (;;)
    {
      pom localpom = a(str2, String.valueOf(paramBaseArticleInfo.mChannelID));
      if (localpom == null)
      {
        QLog.d(jdField_d_of_type_JavaLangString, 1, "judgeHitRule backOffGroup is null");
        return false;
      }
      if (paramBaseArticleInfo.weishiUGInfo.uint32_residence_threshold.has()) {}
      for (int i = paramBaseArticleInfo.weishiUGInfo.uint32_residence_threshold.get(); i > a((int)paramBaseArticleInfo.mChannelID); i = 0)
      {
        QLog.d(jdField_d_of_type_JavaLangString, 1, "judgeHitRule is not reach minTime");
        f = 110;
        return false;
      }
      localpom.jdField_c_of_type_Int = a(localpom, str2, String.valueOf(paramBaseArticleInfo.mChannelID));
      QLog.d(jdField_d_of_type_JavaLangString, 1, "judgeHitRule backOffGroup.clickTime is " + localpom.jdField_c_of_type_Int + " backOffGroup.maxEvokeCount is " + localpom.jdField_a_of_type_Int + " groupid is " + localpom.jdField_a_of_type_JavaLangString);
      if (localpom.jdField_c_of_type_Int >= localpom.jdField_a_of_type_Int)
      {
        QLog.d(jdField_d_of_type_JavaLangString, 1, "judgeHitRule over groupClick");
        return false;
      }
      Iterator localIterator = localpom.jdField_a_of_type_JavaUtilDeque.iterator();
      poo localpoo;
      do
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        localpoo = (poo)localIterator.next();
      } while (!localpoo.jdField_a_of_type_JavaUtilList.contains(str1));
      QLog.d(jdField_d_of_type_JavaLangString, 1, "judgeHitRule freshInfo.clickTime is " + localpoo.jdField_a_of_type_Int + " backOffGroup.maxFreshEvokeCount is " + localpom.jdField_b_of_type_Int);
      bool1 = bool2;
      if (localpoo.jdField_a_of_type_Int >= localpom.jdField_b_of_type_Int) {
        break;
      }
      if ((paramBoolean) && (!TextUtils.isEmpty(a(paramBaseArticleInfo, null, null))))
      {
        localpoo.jdField_a_of_type_Int += 1;
        a(localpom, str2, String.valueOf(paramBaseArticleInfo.mChannelID));
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pol
 * JD-Core Version:    0.7.0.1
 */