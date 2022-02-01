package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;
import tencent.im.oidb.articlesummary.articlesummary.WendaInfo;

public class WendaInfo
{
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public int g;
  public String h;
  public String i;
  public String j;
  public int k;
  public String l;
  public int m;
  public String n;
  public List<Integer> o = new ArrayList();
  public List<String> p = new ArrayList();
  public String q;
  public String r;
  public List<String> s = new ArrayList();
  public String t;
  public String u;
  public AnswerDetailInfo v = new AnswerDetailInfo();
  public String w;
  
  public static WendaInfo a(articlesummary.WendaInfo paramWendaInfo)
  {
    WendaInfo localWendaInfo = new WendaInfo();
    if (paramWendaInfo.uint32_is_super_wenda.has())
    {
      int i1 = paramWendaInfo.uint32_is_super_wenda.get();
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      localWendaInfo.a = bool;
    }
    if (paramWendaInfo.bytes_question_rowkey.has()) {
      localWendaInfo.b = paramWendaInfo.bytes_question_rowkey.get().toStringUtf8();
    }
    if (paramWendaInfo.bytes_question_desc.has()) {
      localWendaInfo.c = paramWendaInfo.bytes_question_desc.get().toStringUtf8();
    }
    if (paramWendaInfo.bytes_question_pic_url.has()) {
      localWendaInfo.d = paramWendaInfo.bytes_question_pic_url.get().toStringUtf8();
    }
    if (paramWendaInfo.bytes_wenda_url.has()) {
      localWendaInfo.e = paramWendaInfo.bytes_wenda_url.get().toStringUtf8();
    }
    if (paramWendaInfo.uint32_follow_count.has()) {
      localWendaInfo.f = paramWendaInfo.uint32_follow_count.get();
    }
    if (paramWendaInfo.uint32_answer_count.has()) {
      localWendaInfo.g = paramWendaInfo.uint32_answer_count.get();
    }
    if (paramWendaInfo.bytes_icon_url.has()) {
      localWendaInfo.h = paramWendaInfo.bytes_icon_url.get().toStringUtf8();
    }
    if (paramWendaInfo.bytes_answer_url.has()) {
      localWendaInfo.i = paramWendaInfo.bytes_answer_url.get().toStringUtf8();
    }
    if (paramWendaInfo.channel_id.has()) {
      localWendaInfo.k = paramWendaInfo.channel_id.get();
    }
    if (paramWendaInfo.channel_id_name.has()) {
      localWendaInfo.l = paramWendaInfo.channel_id_name.get();
    }
    if (paramWendaInfo.channel_second_id.has()) {
      localWendaInfo.m = paramWendaInfo.channel_second_id.get();
    }
    if (paramWendaInfo.channel_second_id_name.has()) {
      localWendaInfo.n = paramWendaInfo.channel_second_id_name.get();
    }
    if (paramWendaInfo.tag_id.has()) {
      localWendaInfo.o = paramWendaInfo.tag_id.get();
    }
    if (paramWendaInfo.tag_id_name.has()) {
      localWendaInfo.p = paramWendaInfo.tag_id_name.get();
    }
    if (paramWendaInfo.author_nick.has()) {
      localWendaInfo.q = paramWendaInfo.author_nick.get();
    }
    if (paramWendaInfo.jump_url.has()) {
      localWendaInfo.r = paramWendaInfo.jump_url.get();
    }
    if (paramWendaInfo.images_url.has()) {
      localWendaInfo.s = paramWendaInfo.images_url.get();
    }
    if (paramWendaInfo.icon_name.has()) {
      localWendaInfo.t = paramWendaInfo.icon_name.get();
    }
    if (paramWendaInfo.icon_color.has()) {
      localWendaInfo.u = paramWendaInfo.icon_color.get();
    }
    if (paramWendaInfo.super_wenda_button_title.has()) {
      localWendaInfo.w = paramWendaInfo.super_wenda_button_title.get();
    }
    if (paramWendaInfo.answer_detail.has()) {
      localWendaInfo.a((articlesummary.AnswerDetail)paramWendaInfo.answer_detail.get());
    }
    return localWendaInfo;
  }
  
  public articlesummary.WendaInfo a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(articlesummary.AnswerDetail paramAnswerDetail)
  {
    this.v = AnswerDetailInfo.a(paramAnswerDetail);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSuperWenda = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", questionRowkey = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", questionDes = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", questionPicUrl = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", wendaUrl = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", followCount = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", answerCount = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", questionIconUrl = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", answerUrl = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", questionPicUrlForSmartCrop = ");
    localStringBuilder.append(this.j);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo
 * JD-Core Version:    0.7.0.1
 */