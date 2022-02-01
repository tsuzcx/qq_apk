package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.AdReport;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;

public class TopBannerInfo$BaseItem
{
  public final int a;
  public long b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public boolean h;
  public List<TopBannerInfo.AdReport> i;
  public List<TopBannerInfo.AdReport> j;
  
  public TopBannerInfo$BaseItem(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected static void a(BaseItem paramBaseItem, oidb_cmd0xbc9.BannerItem paramBannerItem)
  {
    if (paramBaseItem != null)
    {
      int k = paramBannerItem.uint32_is_ad.get();
      boolean bool = true;
      if (k != 1) {
        bool = false;
      }
      paramBaseItem.h = bool;
      paramBaseItem.b = paramBannerItem.uint64_banner_id.get();
      Object localObject = paramBannerItem.msg_ad_click_report.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramBaseItem.i = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          oidb_cmd0xbc9.AdReport localAdReport = (oidb_cmd0xbc9.AdReport)((Iterator)localObject).next();
          paramBaseItem.i.add(TopBannerInfo.AdReport.a(localAdReport));
        }
      }
      paramBannerItem = paramBannerItem.msg_ad_exposure_report.get();
      if ((paramBannerItem != null) && (paramBannerItem.size() > 0))
      {
        paramBaseItem.j = new ArrayList();
        paramBannerItem = paramBannerItem.iterator();
        while (paramBannerItem.hasNext())
        {
          localObject = (oidb_cmd0xbc9.AdReport)paramBannerItem.next();
          paramBaseItem.j.add(TopBannerInfo.AdReport.a((oidb_cmd0xbc9.AdReport)localObject));
        }
      }
    }
  }
  
  public static void a(oidb_cmd0xbc9.BannerItem paramBannerItem, BaseItem paramBaseItem)
  {
    if (paramBannerItem.bytes_superscript_color.has()) {
      paramBaseItem.c = paramBannerItem.bytes_superscript_color.get().toStringUtf8();
    }
    if (paramBannerItem.bytes_superscript_text.has()) {
      paramBaseItem.d = paramBannerItem.bytes_superscript_text.get().toStringUtf8();
    }
    if (paramBannerItem.bytes_banner_title.has()) {
      paramBaseItem.f = paramBannerItem.bytes_banner_title.get().toStringUtf8();
    }
  }
  
  public static BaseItem b(oidb_cmd0xbc9.BannerItem paramBannerItem)
  {
    if (paramBannerItem.uint32_banner_type.has())
    {
      if (paramBannerItem.uint32_banner_type.get() == 2) {
        return TopBannerInfo.VideoItem.c(paramBannerItem);
      }
      return TopBannerInfo.ImgItem.c(paramBannerItem);
    }
    return null;
  }
  
  public List<String> a(List<TopBannerInfo.AdReport> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((TopBannerInfo.AdReport)paramList.next()).a);
      }
      return localArrayList;
    }
    return null;
  }
  
  public oidb_cmd0xbc9.BannerItem a()
  {
    oidb_cmd0xbc9.BannerItem localBannerItem = new oidb_cmd0xbc9.BannerItem();
    if (!TextUtils.isEmpty(this.d)) {
      localBannerItem.bytes_superscript_text.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    if (!TextUtils.isEmpty(this.c)) {
      localBannerItem.bytes_superscript_color.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.f)) {
      localBannerItem.bytes_banner_title.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    localBannerItem.uint32_banner_type.set(this.a);
    a(localBannerItem);
    return localBannerItem;
  }
  
  protected void a(oidb_cmd0xbc9.BannerItem paramBannerItem)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rowkey:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" title:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("tagText:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("tagColor:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.BaseItem
 * JD-Core Version:    0.7.0.1
 */