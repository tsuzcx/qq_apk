package com.tencent.mobileqq.kandian.biz.pts.item;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.SubVideoInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.ReqBody;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnReq;

public class ColumnTwoVideoProteusItem
  implements ProteusItem
{
  private static final Set<Integer> a;
  private static final Set<Integer> b;
  private static final Set<Integer> c;
  private static final Set<Integer> d;
  private static final Set<Integer> e;
  private static final Set<Integer> f;
  private static final Set<Integer> g;
  private static final Set<Integer> h;
  
  static
  {
    Integer localInteger1 = Integer.valueOf(4);
    a = new HashSet(Collections.singletonList(localInteger1));
    Integer localInteger2 = Integer.valueOf(1);
    b = new HashSet(Collections.singletonList(localInteger2));
    Integer localInteger3 = Integer.valueOf(6);
    c = new HashSet(Collections.singletonList(localInteger3));
    Integer localInteger4 = Integer.valueOf(5);
    Integer localInteger5 = Integer.valueOf(2);
    Integer localInteger6 = Integer.valueOf(3);
    d = new HashSet(Arrays.asList(new Integer[] { localInteger2, localInteger5, localInteger6, localInteger1, localInteger4 }));
    Integer localInteger7 = Integer.valueOf(7);
    e = new HashSet(Arrays.asList(new Integer[] { localInteger2, localInteger5, localInteger6, localInteger1, localInteger4, localInteger7 }));
    f = new HashSet(Arrays.asList(new Integer[] { localInteger6, localInteger3, localInteger7 }));
    g = new HashSet(Arrays.asList(new Integer[] { localInteger2, localInteger5, localInteger6, localInteger1, localInteger4, localInteger3, localInteger7 }));
    h = new HashSet(Arrays.asList(new Integer[] { localInteger2, localInteger5 }));
  }
  
  @VisibleForTesting
  static String a(long paramLong1, long paramLong2)
  {
    long l = paramLong2 - paramLong1;
    if ((l > 0L) && (paramLong1 > 0L))
    {
      if (paramLong2 <= 0L) {
        return "";
      }
      String str = ReadInJoyUtils.b(2131915552);
      if ((l < 60000L) && (!str.isEmpty())) {
        return str;
      }
      str = ReadInJoyUtils.b(2131915553);
      if ((l < 3600000L) && (!str.isEmpty())) {
        return String.format(str, new Object[] { Long.valueOf(l / 1000L / 60L) });
      }
      str = ReadInJoyUtils.b(2131915551);
      if ((l < 86400000L) && (!str.isEmpty())) {
        return String.format(str, new Object[] { Long.valueOf(l / 1000L / 60L / 60L) });
      }
      str = ReadInJoyUtils.b(2131915550);
      if ((l >= 86400000L) && (!str.isEmpty())) {
        return String.format(str, new Object[] { Long.valueOf(l / 1000L / 60L / 60L / 24L) });
      }
    }
    return "";
  }
  
  private void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestSubscribeEvent, subscribeAction = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("ColumnTwoVideoProteusItem", 1, ((StringBuilder)localObject).toString());
    localObject = paramAbsBaseArticleInfo.multiVideoColumnInfo;
    oidb_0xd4b.ReqBody localReqBody = new oidb_0xd4b.ReqBody();
    localReqBody.msg_subscribe_video_column_req.uint32_video_column_id.set(((MultiVideoColumnInfo)localObject).a);
    localReqBody.msg_subscribe_video_column_req.uint32_oper_type.set(paramInt);
    localReqBody.msg_subscribe_video_column_req.setHasFlag(true);
    Bundle localBundle = new Bundle();
    localBundle.putInt("subscribeAction", paramInt);
    localBundle.putString("columnIconUrl", ((MultiVideoColumnInfo)localObject).c);
    localBundle.putInt("columnId", ((MultiVideoColumnInfo)localObject).a);
    ProtoUtils.a(RIJQQAppInterfaceUtil.a(), new ColumnTwoVideoProteusItem.ColumnSubscriptionCallback(paramAbsBaseArticleInfo, paramInt), localReqBody.toByteArray(), "OidbSvc.0xd4b", 3403, 1, localBundle);
  }
  
  private void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    MultiVideoColumnInfo localMultiVideoColumnInfo = paramAbsBaseArticleInfo.multiVideoColumnInfo;
    String str;
    if (paramBoolean) {
      str = "0x800A7FB";
    } else {
      str = "0x800A7D3";
    }
    HashMap localHashMap = new HashMap();
    int i;
    if (paramAbsBaseArticleInfo.mChannelID == 0L) {
      i = 1;
    } else {
      i = 2;
    }
    localHashMap.put("subscribe_page", Integer.valueOf(i));
    localHashMap.put("feeds_type", Integer.valueOf(1050));
    localHashMap.put("column_id", Integer.valueOf(localMultiVideoColumnInfo.a));
    localHashMap.put("column_card_bg_style", Integer.valueOf(localMultiVideoColumnInfo.o));
    RIJFrameworkReportManager.a(paramAbsBaseArticleInfo, str, str, (int)paramAbsBaseArticleInfo.mChannelID, localHashMap);
  }
  
  private void a(MultiVideoColumnInfo paramMultiVideoColumnInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("column_cover_image_url", paramMultiVideoColumnInfo.c);
    paramJSONObject.put("column_logo_image_url", paramMultiVideoColumnInfo.d);
    a(paramJSONObject, paramMultiVideoColumnInfo);
    b(paramJSONObject, paramMultiVideoColumnInfo);
    a(paramJSONObject, paramMultiVideoColumnInfo.j);
  }
  
  private void a(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    String str = paramMultiVideoColumnInfo.b;
    if (str.isEmpty()) {
      QLog.e("ColumnTwoVideoProteusItem", 1, "column Name is empty.");
    }
    if ((a.contains(Integer.valueOf(paramMultiVideoColumnInfo.o))) && (!paramMultiVideoColumnInfo.m.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMultiVideoColumnInfo.m);
      localStringBuilder.append("·");
      localStringBuilder.append(str);
      paramJSONObject.put("column_info_name_text", localStringBuilder.toString());
      return;
    }
    paramJSONObject.put("column_info_name_text", str);
  }
  
  private void a(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo, SubVideoInfo paramSubVideoInfo1, SubVideoInfo paramSubVideoInfo2)
  {
    if (c.contains(Integer.valueOf(paramMultiVideoColumnInfo.o)))
    {
      if (!paramSubVideoInfo1.c.isEmpty()) {
        paramJSONObject.put("column_show_video_left_title", paramSubVideoInfo1.c);
      } else {
        QLog.e("ColumnTwoVideoProteusItem", 1, "leftVideoInfo's title isEmpty.");
      }
      if (!paramSubVideoInfo2.c.isEmpty())
      {
        paramJSONObject.put("column_show_video_right_title", paramSubVideoInfo2.c);
        return;
      }
      QLog.e("ColumnTwoVideoProteusItem", 1, "rightVideoInfo's title isEmpty.");
    }
  }
  
  private void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramJSONObject.put("subscription_background_color", "#FFFFFF");
      paramJSONObject.put("subscribe_title", ReadInJoyUtils.b(2131893004));
      paramJSONObject.put("subscription_title_color", "#737373");
      paramJSONObject.put("subscription_border_color", "#E6E6E6");
      paramJSONObject.put("subscription_border_width", "0.5");
      return;
    }
    paramJSONObject.put("subscription_background_color", "#00CAFC");
    paramJSONObject.put("subscribe_title", ReadInJoyUtils.b(2131893005));
    paramJSONObject.put("subscription_title_color", "#FFFFFF");
    paramJSONObject.remove("subscription_border_color");
    paramJSONObject.remove("subscription_border_width");
  }
  
  private void b(MultiVideoColumnInfo paramMultiVideoColumnInfo, JSONObject paramJSONObject)
  {
    SubVideoInfo localSubVideoInfo1 = (SubVideoInfo)paramMultiVideoColumnInfo.p.get(0);
    SubVideoInfo localSubVideoInfo2 = (SubVideoInfo)paramMultiVideoColumnInfo.p.get(1);
    paramJSONObject.put("column_left_item_cover_url", localSubVideoInfo1.d);
    paramJSONObject.put("column_right_item_cover_url", localSubVideoInfo2.d);
    a(paramJSONObject, paramMultiVideoColumnInfo, localSubVideoInfo1, localSubVideoInfo2);
    c(paramJSONObject, paramMultiVideoColumnInfo);
    b(paramJSONObject, paramMultiVideoColumnInfo, localSubVideoInfo1, localSubVideoInfo2);
  }
  
  private void b(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    String str = ReadInJoyUtils.b(2131915256);
    if ((b.contains(Integer.valueOf(paramMultiVideoColumnInfo.o))) && (paramMultiVideoColumnInfo.i != 0) && (!str.isEmpty())) {
      paramJSONObject.put("column_info_subscription_text", String.format(str, new Object[] { ReadInJoyHelper.d(paramMultiVideoColumnInfo.i) }));
    }
  }
  
  private void b(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo, SubVideoInfo paramSubVideoInfo1, SubVideoInfo paramSubVideoInfo2)
  {
    if (e.contains(Integer.valueOf(paramMultiVideoColumnInfo.o)))
    {
      if (paramSubVideoInfo1.g != 0) {
        paramJSONObject.put("column_card_play_left_time_text", ReadInJoyHelper.f(paramSubVideoInfo1.g));
      } else {
        QLog.e("ColumnTwoVideoProteusItem", 1, "leftVideoInfo's duration == 0.");
      }
      if (paramSubVideoInfo2.g != 0)
      {
        paramJSONObject.put("column_card_play_right_time_text", ReadInJoyHelper.f(paramSubVideoInfo2.g));
        return;
      }
      QLog.e("ColumnTwoVideoProteusItem", 1, "rightVideoInfo's duration == 0.");
    }
  }
  
  private void c(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    if (d.contains(Integer.valueOf(paramMultiVideoColumnInfo.o)))
    {
      paramJSONObject.put("column_card_play_left_icon_url", "rij_multi_video_column_play");
      paramJSONObject.put("column_card_play_right_icon_url", "rij_multi_video_column_play");
    }
  }
  
  private void d(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    if (f.contains(Integer.valueOf(paramMultiVideoColumnInfo.o)))
    {
      if ((!paramMultiVideoColumnInfo.n.isEmpty()) && (!paramMultiVideoColumnInfo.m.isEmpty()))
      {
        paramJSONObject.put("column_bottom_icon_view_visibility", "1");
        paramJSONObject.put("column_bottom_icon_url", paramMultiVideoColumnInfo.n);
        paramJSONObject.put("column_bottom_name", paramMultiVideoColumnInfo.m);
        return;
      }
      QLog.e("ColumnTwoVideoProteusItem", 1, "dataInfo's appIconUrl or appName is Empty.");
    }
  }
  
  private void e(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    String str = ReadInJoyUtils.b(2131915260);
    if ((paramMultiVideoColumnInfo.h > 0) && (!str.isEmpty())) {
      str = String.format(str, new Object[] { Integer.valueOf(paramMultiVideoColumnInfo.h) });
    } else {
      str = "";
    }
    if ((g.contains(Integer.valueOf(paramMultiVideoColumnInfo.o))) && (!str.isEmpty())) {
      if ((paramMultiVideoColumnInfo.j) && (f.contains(Integer.valueOf(paramMultiVideoColumnInfo.o)))) {
        paramJSONObject.remove("column_bottom_video_count");
      } else {
        paramJSONObject.put("column_bottom_video_count", str);
      }
    }
    str = ReadInJoyUtils.b(2131915261);
    if ((paramMultiVideoColumnInfo.j) && (paramMultiVideoColumnInfo.f != 0) && (!str.isEmpty()))
    {
      paramJSONObject.put("column_bottom_video_update_count", String.format(str, new Object[] { Integer.valueOf(paramMultiVideoColumnInfo.f) }));
      return;
    }
    paramMultiVideoColumnInfo = a(paramMultiVideoColumnInfo.g, System.currentTimeMillis());
    if (!paramMultiVideoColumnInfo.isEmpty()) {
      paramJSONObject.put("column_bottom_video_update_time", paramMultiVideoColumnInfo);
    }
  }
  
  private void f(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void g(JSONObject paramJSONObject, @NotNull MultiVideoColumnInfo paramMultiVideoColumnInfo)
  {
    if (h.contains(Integer.valueOf(paramMultiVideoColumnInfo.o)))
    {
      paramJSONObject.put("column_top_view_visibility", "1");
      paramJSONObject.remove("column_middle_view_visibility");
    }
    else
    {
      paramJSONObject.put("column_middle_view_visibility", "1");
      paramJSONObject.remove("column_top_view_visibility");
    }
    if (c.contains(Integer.valueOf(paramMultiVideoColumnInfo.o)))
    {
      paramJSONObject.put("column_card_show_video_title_visibility", "1");
      paramJSONObject.remove("column_card_not_show_video_title_visibility");
      return;
    }
    paramJSONObject.put("column_card_not_show_video_title_visibility", "1");
    paramJSONObject.remove("column_card_show_video_title_visibility");
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.columnStyle == 1))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.multiVideoColumnInfo;
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.p != null) && (paramAbsBaseArticleInfo.p.size() >= 2))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("style_ID", "ReadInJoy_Column_card_cell");
        a(paramAbsBaseArticleInfo, localJSONObject);
        b(paramAbsBaseArticleInfo, localJSONObject);
        d(localJSONObject, paramAbsBaseArticleInfo);
        e(localJSONObject, paramAbsBaseArticleInfo);
        f(localJSONObject, paramAbsBaseArticleInfo);
        g(localJSONObject, paramAbsBaseArticleInfo);
        QLog.d("ColumnTwoVideoInfo", 1, localJSONObject.toString());
        return localJSONObject;
      }
      return new JSONObject();
    }
    return new JSONObject();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2) {}
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {
      return false;
    }
    String str = paramViewBase.getClickEvnet();
    paramIReadInJoyModel = paramIReadInJoyModel.k();
    MultiVideoColumnInfo localMultiVideoColumnInfo = paramIReadInJoyModel.multiVideoColumnInfo;
    paramContainer = paramContainer.getContext();
    if ("cmd_column_card_click".equals(str))
    {
      paramViewBase.setOnClickListener(new ColumnTwoVideoProteusItem.1(this, paramContainer, localMultiVideoColumnInfo, paramIReadInJoyModel));
      return true;
    }
    if ("cmd_column_left_item_click".equals(str))
    {
      paramViewBase.setOnClickListener(new ColumnTwoVideoProteusItem.2(this, paramContainer, localMultiVideoColumnInfo, paramIReadInJoyModel));
      return true;
    }
    if ("cmd_column_right_item_click".equals(str))
    {
      paramViewBase.setOnClickListener(new ColumnTwoVideoProteusItem.3(this, paramContainer, localMultiVideoColumnInfo, paramIReadInJoyModel));
      return true;
    }
    if ("cmd_subscription_click".equals(str))
    {
      paramViewBase.setOnClickListener(new ColumnTwoVideoProteusItem.4(this, localMultiVideoColumnInfo, paramIReadInJoyModel));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.ColumnTwoVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */