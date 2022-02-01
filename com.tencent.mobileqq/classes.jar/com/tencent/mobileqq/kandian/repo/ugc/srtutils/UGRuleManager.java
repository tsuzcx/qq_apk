package com.tencent.mobileqq.kandian.repo.ugc.srtutils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.ugc.RIJUGRuleSp;
import com.tencent.mobileqq.kandian.repo.ugc.api.IUGRuleManager;
import com.tencent.mobileqq.kandian.repo.ugc.srt.ArticleDiversionInfo;
import com.tencent.mobileqq.kandian.repo.ugc.srt.BackOffGroup;
import com.tencent.mobileqq.kandian.repo.ugc.srt.BackOffInfoWithArticleInfo;
import com.tencent.mobileqq.kandian.repo.ugc.srt.FreshInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BackOffGroupInfo;

public class UGRuleManager
  implements ReadInJoySrtHandler.IRuleManager
{
  private static int jdField_a_of_type_Int;
  private static int b;
  private Map<String, BackOffGroup> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = c(paramAbsBaseArticleInfo);
    int i = 1;
    if (!bool) {
      return 1;
    }
    if (paramAbsBaseArticleInfo.weishiUGInfo.msg_url_jump_info.uint32_jump_src.has()) {
      i = paramAbsBaseArticleInfo.weishiUGInfo.msg_url_jump_info.uint32_jump_src.get();
    }
    return i;
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if (!c(paramAbsBaseArticleInfo)) {
      return 0;
    }
    if (!paramBoolean) {
      return 2;
    }
    return jdField_a_of_type_Int;
  }
  
  private AbsBaseArticleInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    if (paramAbsBaseArticleInfo.viewRowkey != null)
    {
      localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
      if (!paramAbsBaseArticleInfo.viewRowkey.equals(paramAbsBaseArticleInfo.innerUniqueID))
      {
        localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
        if (paramAbsBaseArticleInfo.mSubArticleList != null)
        {
          localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
          if (paramAbsBaseArticleInfo.mSubArticleList.size() > 0)
          {
            localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
            if (paramAbsBaseArticleInfo.mSubArticleList.get(0) != null)
            {
              localAbsBaseArticleInfo = paramAbsBaseArticleInfo;
              if (paramAbsBaseArticleInfo.viewRowkey.equals(((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0)).innerUniqueID)) {
                localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0);
              }
            }
          }
        }
      }
    }
    return localAbsBaseArticleInfo;
  }
  
  private BackOffGroup a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    String str = b(paramAbsBaseArticleInfo);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return a(str, String.valueOf(paramAbsBaseArticleInfo.mChannelID));
  }
  
  private BackOffGroup a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString1);
      localObject = ((StringBuilder)localObject).toString();
      paramString2 = (BackOffGroup)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new BackOffGroup();
        this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString1);
      }
      return paramString1;
    }
    return null;
  }
  
  private BackOffGroup a(oidb_cmd0x68b.BackOffGroupInfo paramBackOffGroupInfo, String paramString1, String paramString2)
  {
    paramString1 = a(paramString2, paramString1);
    if (paramString1 == null) {
      return null;
    }
    paramString1.jdField_a_of_type_JavaLangString = paramBackOffGroupInfo.bytes_back_off_group.get().toStringUtf8();
    boolean bool = paramBackOffGroupInfo.uint32_max_evoke_count.has();
    int j = 0;
    if (bool) {
      i = paramBackOffGroupInfo.uint32_max_evoke_count.get();
    } else {
      i = 0;
    }
    paramString1.jdField_a_of_type_Int = i;
    int i = j;
    if (paramBackOffGroupInfo.uint32_max_fresh_evoke_count.has()) {
      i = paramBackOffGroupInfo.uint32_max_fresh_evoke_count.get();
    }
    paramString1.b = i;
    paramBackOffGroupInfo = new StringBuilder();
    paramBackOffGroupInfo.append("handleBackOffGroup id: ");
    paramBackOffGroupInfo.append(paramString1.jdField_a_of_type_JavaLangString);
    paramBackOffGroupInfo.append(", maxEvokeCnt : ");
    paramBackOffGroupInfo.append(paramString1.jdField_a_of_type_Int);
    paramBackOffGroupInfo.append(", maxFreshEvokeCnt : ");
    paramBackOffGroupInfo.append(paramString1.b);
    QLog.d("UGRuleManager", 1, paramBackOffGroupInfo.toString());
    return paramString1;
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = paramAbsBaseArticleInfo.innerUniqueID;
    if (paramAbsBaseArticleInfo.viewRowkey != null) {
      str = paramAbsBaseArticleInfo.viewRowkey;
    }
    return str;
  }
  
  public static List<String> a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!c(paramAbsBaseArticleInfo)) {
      return null;
    }
    if ((paramAbsBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.has()) && (paramAbsBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.get() != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.weishiUGInfo.rpt_bytes_report_base_url.get().iterator();
      while (paramAbsBaseArticleInfo.hasNext())
      {
        ByteStringMicro localByteStringMicro = (ByteStringMicro)paramAbsBaseArticleInfo.next();
        localArrayList.add(localByteStringMicro.toStringUtf8());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getReportUrl is ");
        localStringBuilder.append(localByteStringMicro.toStringUtf8());
        QLog.d("UGRuleManager", 1, localStringBuilder.toString());
      }
      return localArrayList;
    }
    QLog.d("UGRuleManager", 1, "getReportUrl is null");
    return null;
  }
  
  public static void a()
  {
    b(b);
  }
  
  public static void a(int paramInt)
  {
    Object localObject1;
    if (b != paramInt)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("wakeUpTimeCalculate change channel channel id is ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("UGRuleManager", 1, ((StringBuilder)localObject1).toString());
      b(b);
    }
    if ((paramInt == 0) || (DailyModeConfigHandler.b(paramInt)))
    {
      b = paramInt;
      Object localObject2 = TimeSliceHelper.a(String.valueOf(paramInt));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TimeSliceHelper();
        TimeSliceHelper.a(String.valueOf(paramInt), (TimeSliceHelper)localObject1);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("wakeUpTimeCalculate channel id is ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d("UGRuleManager", 1, ((StringBuilder)localObject2).toString());
      ((TimeSliceHelper)localObject1).a();
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    paramAbsBaseArticleInfo = ((IUGRuleManager)QRoute.api(IUGRuleManager.class)).getReportUrl(paramAbsBaseArticleInfo);
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.iterator();
    while (paramAbsBaseArticleInfo.hasNext())
    {
      String str = (String)paramAbsBaseArticleInfo.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("&acttype=");
      localStringBuilder.append(paramInt);
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("UG report url : ");
      localStringBuilder.append(str);
      QLog.d("UGRuleManager", 1, localStringBuilder.toString());
      ThreadManager.executeOnNetWorkThread(new UGRuleManager.1(str));
    }
  }
  
  private void a(BackOffInfoWithArticleInfo paramBackOffInfoWithArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBackOffInfoWithArticleInfo.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = paramBackOffInfoWithArticleInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (oidb_cmd0x68b.BackOffGroupInfo)localIterator.next();
        String str = RIJPBFieldUtils.a(((oidb_cmd0x68b.BackOffGroupInfo)localObject).bytes_back_off_group);
        if (!TextUtils.isEmpty(str))
        {
          localObject = a((oidb_cmd0x68b.BackOffGroupInfo)localObject, String.valueOf(paramBackOffInfoWithArticleInfo.jdField_a_of_type_Int), str);
          if ((localObject != null) && (paramBackOffInfoWithArticleInfo.b != null) && (!localArrayList.contains(str)))
          {
            FreshInfo localFreshInfo = new FreshInfo();
            a(paramBackOffInfoWithArticleInfo.b, (BackOffGroup)localObject, localFreshInfo);
            ((BackOffGroup)localObject).a(localFreshInfo);
            localArrayList.add(str);
          }
        }
      }
    }
  }
  
  private void a(List<AbsBaseArticleInfo> paramList, BackOffGroup paramBackOffGroup, FreshInfo paramFreshInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
      if (paramBackOffGroup.jdField_a_of_type_JavaLangString.equals(c(localAbsBaseArticleInfo))) {
        paramFreshInfo.jdField_a_of_type_JavaUtilHashMap.put(localAbsBaseArticleInfo.innerUniqueID, new ArticleDiversionInfo(localAbsBaseArticleInfo.innerUniqueID));
      }
      if ((localAbsBaseArticleInfo.mSubArticleList != null) && (localAbsBaseArticleInfo.mSubArticleList.size() > 0)) {
        a(localAbsBaseArticleInfo.mSubArticleList, paramBackOffGroup, paramFreshInfo);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = paramString.startsWith("http://clientui.3g.qq.com/mqqapi/");
    boolean bool1 = true;
    int i;
    if ((!bool2) && (!paramString.startsWith("http://clientui.3g.qq.com/mqq/")) && (!paramString.startsWith("http://qm.qq.com/cgi-bin/")) && (!paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      if (paramString.startsWith("http://")) {
        return bool1;
      }
      if (paramString.startsWith("https://")) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  private String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJPBFieldUtils.a(paramAbsBaseArticleInfo.weishiUGInfo.bytes_back_off_group, "");
  }
  
  public static void b(int paramInt)
  {
    if ((paramInt == 0) || (DailyModeConfigHandler.b(paramInt)))
    {
      Object localObject = TimeSliceHelper.a(String.valueOf(paramInt));
      if ((localObject != null) && (((TimeSliceHelper)localObject).a()))
      {
        RIJUGRuleSp.a(paramInt);
        ((TimeSliceHelper)localObject).b();
        ((TimeSliceHelper)localObject).c();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stopTimeCalculate channel id is ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("UGRuleManager", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private String c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = c(paramAbsBaseArticleInfo);
    String str = null;
    if (!bool) {
      return null;
    }
    if (paramAbsBaseArticleInfo.weishiUGInfo.bytes_back_off_group.has()) {
      str = paramAbsBaseArticleInfo.weishiUGInfo.bytes_back_off_group.get().toStringUtf8();
    }
    return str;
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (d(paramAbsBaseArticleInfo)) {
      return true;
    }
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.weishiUGInfo != null) && (paramAbsBaseArticleInfo.weishiUGInfo.uint32_use_ug.has()) && (paramAbsBaseArticleInfo.weishiUGInfo.uint32_use_ug.get() > 0) && (paramAbsBaseArticleInfo.weishiUGInfo.msg_url_jump_info.has()) && (paramAbsBaseArticleInfo.weishiUGInfo.msg_url_jump_info.get() != null);
  }
  
  public static boolean d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.weishiUGInfo != null) && (paramAbsBaseArticleInfo.weishiUGInfo.uint32_is_with_angle_sign.has()) && (paramAbsBaseArticleInfo.weishiUGInfo.uint32_is_with_angle_sign.get() > 0) && (paramAbsBaseArticleInfo.weishiUGInfo.msg_url_jump_info.has()) && (paramAbsBaseArticleInfo.weishiUGInfo.msg_url_jump_info.get() != null);
  }
  
  public static boolean e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool1 = c(paramAbsBaseArticleInfo);
    boolean bool2 = false;
    if (!bool1)
    {
      QLog.d("UGRuleManager", 1, "judgeIsAgreement is not isUgCard");
      return false;
    }
    int i = paramAbsBaseArticleInfo.weishiUGInfo.uint32_use_ug.get();
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.weishiUGInfo.msg_url_jump_info;
    if (paramAbsBaseArticleInfo.bytes_jump_bundle.has()) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.bytes_jump_bundle.get().toStringUtf8();
    } else {
      paramAbsBaseArticleInfo = "";
    }
    boolean bool3 = PackageUtil.a(BaseApplicationImpl.getApplication(), paramAbsBaseArticleInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("judgeIsAgreement isappInstall ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    localStringBuilder.append(" :");
    localStringBuilder.append(bool3);
    localStringBuilder.append(" useUg: ");
    localStringBuilder.append(i);
    QLog.d("UGRuleManager", 1, localStringBuilder.toString());
    if ((!bool3) || (i != 2))
    {
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (i != 1) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if (!c(paramAbsBaseArticleInfo)) {
      return null;
    }
    paramViewBase = a(paramAbsBaseArticleInfo);
    articlesummary.UrlJumpInfo localUrlJumpInfo = paramViewBase.weishiUGInfo.msg_url_jump_info;
    boolean bool = localUrlJumpInfo.bytes_jump_schema.has();
    paramTemplateBean = "";
    if (bool) {
      paramAbsBaseArticleInfo = localUrlJumpInfo.bytes_jump_schema.get().toStringUtf8();
    } else {
      paramAbsBaseArticleInfo = "";
    }
    if (localUrlJumpInfo.bytes_jump_url.has()) {
      paramTemplateBean = localUrlJumpInfo.bytes_jump_url.get().toStringUtf8();
    }
    int i;
    if (paramViewBase.weishiUGInfo.msg_url_jump_info.uint32_jump_type.has()) {
      i = paramViewBase.weishiUGInfo.msg_url_jump_info.uint32_jump_type.get();
    } else {
      i = 0;
    }
    int j = paramViewBase.weishiUGInfo.uint32_use_ug.get();
    if ((TextUtils.isEmpty(paramAbsBaseArticleInfo)) && (TextUtils.isEmpty(paramTemplateBean)))
    {
      QLog.d("UGRuleManager", 1, "getJumpUrl schema & h5 is null");
      jdField_a_of_type_Int = 3;
      return null;
    }
    if (!e(paramViewBase))
    {
      if ((j == 2) && (i == 2) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append("getJumpUrl return is h5:");
        paramAbsBaseArticleInfo.append(paramTemplateBean);
        QLog.d("UGRuleManager", 1, paramAbsBaseArticleInfo.toString());
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
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append("getJumpUrl return is h5:");
        paramAbsBaseArticleInfo.append(paramTemplateBean);
        QLog.d("UGRuleManager", 1, paramAbsBaseArticleInfo.toString());
        jdField_a_of_type_Int = 108;
        return paramTemplateBean;
      }
    }
    else if (j == 2)
    {
      if ((i == 2) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo)))
      {
        paramTemplateBean = new StringBuilder();
        paramTemplateBean.append("getJumpUrl return is schema:");
        paramTemplateBean.append(paramAbsBaseArticleInfo);
        QLog.d("UGRuleManager", 1, paramTemplateBean.toString());
        jdField_a_of_type_Int = 7;
        return paramAbsBaseArticleInfo;
      }
      if ((i == 1) && (!TextUtils.isEmpty(paramTemplateBean)))
      {
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append("getJumpUrl return is h5:");
        paramAbsBaseArticleInfo.append(paramTemplateBean);
        QLog.d("UGRuleManager", 1, paramAbsBaseArticleInfo.toString());
        jdField_a_of_type_Int = 108;
        return paramTemplateBean;
      }
    }
    jdField_a_of_type_Int = 3;
    QLog.d("UGRuleManager", 1, "getJumpUrl return is null");
    return null;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = a(paramAbsBaseArticleInfo, paramBoolean2);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UGRuleManager getUGSchema action is:");
      localStringBuilder.append(i);
      QLog.d("UGRuleManager", 1, localStringBuilder.toString());
      a(paramAbsBaseArticleInfo, i);
    }
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof BackOffInfoWithArticleInfo)) {
      return;
    }
    QLog.d("UGRuleManager", 1, "handleRules");
    a((BackOffInfoWithArticleInfo)paramObject);
  }
  
  public boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject1 = a(paramAbsBaseArticleInfo);
    if (localObject1 == null) {
      return false;
    }
    paramAbsBaseArticleInfo = a(paramAbsBaseArticleInfo);
    localObject1 = ((BackOffGroup)localObject1).jdField_a_of_type_JavaUtilDeque.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (FreshInfo)((Iterator)localObject1).next();
      if (((FreshInfo)localObject2).jdField_a_of_type_JavaUtilHashMap.containsKey(paramAbsBaseArticleInfo))
      {
        localObject2 = (ArticleDiversionInfo)((FreshInfo)localObject2).jdField_a_of_type_JavaUtilHashMap.get(paramAbsBaseArticleInfo);
        if ((localObject2 != null) && (((ArticleDiversionInfo)localObject2).jdField_a_of_type_Int != 0))
        {
          ((ArticleDiversionInfo)localObject2).jdField_a_of_type_Int -= 1;
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if (d(paramAbsBaseArticleInfo))
    {
      QLog.d("UGRuleManager", 1, "judgeHitRule isWithAngleSign");
      return true;
    }
    if (!c(paramAbsBaseArticleInfo))
    {
      QLog.d("UGRuleManager", 1, "judgeHitRule isNotUgCard");
      return false;
    }
    if (!paramBoolean) {
      return a(paramAbsBaseArticleInfo);
    }
    return b(paramAbsBaseArticleInfo);
  }
  
  public boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    BackOffGroup localBackOffGroup = a(paramAbsBaseArticleInfo);
    if (localBackOffGroup == null) {
      return false;
    }
    Object localObject1 = a(paramAbsBaseArticleInfo);
    String str = b(paramAbsBaseArticleInfo);
    if (RIJPBFieldUtils.a(paramAbsBaseArticleInfo.weishiUGInfo.uint32_residence_threshold, 0) > RIJUGRuleSp.a((int)paramAbsBaseArticleInfo.mChannelID))
    {
      QLog.d("UGRuleManager", 1, "judgeHitRule is not reach minTime");
      jdField_a_of_type_Int = 110;
      return false;
    }
    localBackOffGroup.c = RIJUGRuleSp.a(localBackOffGroup, str, String.valueOf(paramAbsBaseArticleInfo.mChannelID));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("judgeHitRule backOffGroup.clickTime is ");
    ((StringBuilder)localObject2).append(localBackOffGroup.c);
    ((StringBuilder)localObject2).append(" backOffGroup.maxEvokeCount is ");
    ((StringBuilder)localObject2).append(localBackOffGroup.jdField_a_of_type_Int);
    ((StringBuilder)localObject2).append(" groupid is ");
    ((StringBuilder)localObject2).append(localBackOffGroup.jdField_a_of_type_JavaLangString);
    QLog.d("UGRuleManager", 1, ((StringBuilder)localObject2).toString());
    if (localBackOffGroup.c >= localBackOffGroup.jdField_a_of_type_Int)
    {
      QLog.d("UGRuleManager", 1, "judgeHitRule over groupClick");
      return false;
    }
    Iterator localIterator = localBackOffGroup.jdField_a_of_type_JavaUtilDeque.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (FreshInfo)localIterator.next();
      if (((FreshInfo)localObject2).jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("judgeHitRule freshInfo.clickTime is ");
        localStringBuilder.append(((FreshInfo)localObject2).jdField_a_of_type_Int);
        localStringBuilder.append(" backOffGroup.maxFreshEvokeCount is ");
        localStringBuilder.append(localBackOffGroup.b);
        QLog.d("UGRuleManager", 1, localStringBuilder.toString());
        if (((FreshInfo)localObject2).jdField_a_of_type_Int < localBackOffGroup.b)
        {
          if (!TextUtils.isEmpty(a(paramAbsBaseArticleInfo, null, null)))
          {
            localObject1 = (ArticleDiversionInfo)((FreshInfo)localObject2).jdField_a_of_type_JavaUtilHashMap.get(paramAbsBaseArticleInfo.innerUniqueID);
            if (localObject1 != null) {
              ((ArticleDiversionInfo)localObject1).jdField_a_of_type_Int += 1;
            }
            ((FreshInfo)localObject2).jdField_a_of_type_Int += 1;
            RIJUGRuleSp.a(localBackOffGroup, str, String.valueOf(paramAbsBaseArticleInfo.mChannelID));
          }
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager
 * JD-Core Version:    0.7.0.1
 */