package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.SubscriptInfo;

public class SubscriptInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, articlesummary.SubscriptInfo paramSubscriptInfo)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("SubscriptInfo", 2, "articleinfo == null");
      return;
    }
    paramAbsBaseArticleInfo.subscriptWording = RIJPBFieldUtils.a(paramSubscriptInfo.bytes_subscript_txt, "");
    paramAbsBaseArticleInfo.subscriptWordingColor = RIJPBFieldUtils.a(paramSubscriptInfo.bytes_subscript_color, "");
    paramAbsBaseArticleInfo.subscriptBgColor = RIJPBFieldUtils.a(paramSubscriptInfo.bytes_background_color, "");
    paramAbsBaseArticleInfo.subscriptLocation = RIJPBFieldUtils.a(paramSubscriptInfo.uint32_is_show_top, 0);
    paramAbsBaseArticleInfo.subscriptType = RIJPBFieldUtils.a(paramSubscriptInfo.uint32_subscript_type, 0);
    paramSubscriptInfo = new StringBuilder();
    paramSubscriptInfo.append("parseByPB | wording: ");
    paramSubscriptInfo.append(paramAbsBaseArticleInfo.subscriptWording);
    paramSubscriptInfo.append(" \ntxtColor : ");
    paramSubscriptInfo.append(paramAbsBaseArticleInfo.subscriptWordingColor);
    paramSubscriptInfo.append(" \nbgColor : ");
    paramSubscriptInfo.append(paramAbsBaseArticleInfo.subscriptBgColor);
    paramSubscriptInfo.append(" \nisShowTop : ");
    paramSubscriptInfo.append(paramAbsBaseArticleInfo.subscriptLocation);
    paramSubscriptInfo.append(" \ntype : ");
    paramSubscriptInfo.append(paramAbsBaseArticleInfo.subscriptType);
    paramSubscriptInfo.append(" \n");
    QLog.d("SubscriptInfo", 2, paramSubscriptInfo.toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubscriptInfo{wording='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wordingColor='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bgColor='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", location=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.SubscriptInfo
 * JD-Core Version:    0.7.0.1
 */